package academy.mate;

import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.io.UnsupportedEncodingException;
import java.util.Enumeration;
import java.util.Locale;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;
import java.awt.event.ActionEvent;

public class PudgeView extends JFrame {

	private JPanel contentPane;
	private JRadioButton ru = new JRadioButton("RU");
	private JRadioButton de = new JRadioButton("DE");
	private JRadioButton fr = new JRadioButton("FR");
	private JLabel image = new JLabel();
	private ImageIcon ic;
	private JButton loadButton = new JButton("Load");
	private JButton saveButton = new JButton("Save");
	private JLabel strHello = new JLabel();
	private JLabel strNation = new JLabel();
	private JLabel strDrink = new JLabel();
	private ResourceBundle messages;

	/**
	 * Create the frame.510=382
	 */
	public PudgeView() {
		setTitle("Language");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = addPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

	}

	public JPanel addPanel() {
		contentPane = new JPanel();
		ru.setHorizontalAlignment(SwingConstants.CENTER);
		ru.setBounds(22, 36, 80, 23);
		contentPane.add(ru);

		de.setBounds(204, 36, 66, 23);
		contentPane.add(de);
		
		fr.setHorizontalAlignment(SwingConstants.CENTER);
		fr.setBounds(325, 36, 80, 23);
		contentPane.add(fr);
	
		image.setHorizontalAlignment(SwingConstants.CENTER);
		image.setBounds(25, 66, 145, 148);
		contentPane.add(image);
		
		saveButton.setBounds(269, 225, 155, 23);
		contentPane.add(saveButton);
		
		loadButton.setBounds(15, 225, 155, 23);
		contentPane.add(loadButton);

		strHello.setBounds(204, 84, 220, 14);
		contentPane.add(strHello);

		strNation.setBounds(204, 132, 220, 14);
		contentPane.add(strNation);

		strDrink.setBounds(204, 177, 220, 14);
		contentPane.add(strDrink);

		JLabel ruFlag = new JLabel(new ImageIcon("Images/rf.png"));
		ruFlag.setHorizontalAlignment(SwingConstants.CENTER);
		ruFlag.setBounds(34, 0, 46, 38);
		contentPane.add(ruFlag);

		JLabel deFlag = new JLabel(new ImageIcon("Images/gf.png"));
		deFlag.setHorizontalAlignment(SwingConstants.CENTER);
		deFlag.setBounds(193, 0, 46, 38);
		contentPane.add(deFlag);

		JLabel frFlag = new JLabel(new ImageIcon("Images/ff.png"));
		frFlag.setHorizontalAlignment(SwingConstants.CENTER);
		frFlag.setBounds(335, 0, 57, 38);
		contentPane.add(frFlag);

		initListener();
		return contentPane;

	}

	private ImageIcon getImageIcon(String path) {
		ic = new ImageIcon(path);
		Image images = ic.getImage();
		Image newimg = images.getScaledInstance(120, 130, java.awt.Image.SCALE_SMOOTH);
		ic = new ImageIcon(newimg);
		return ic;

	}

	private void initListener() {
		ru.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				de.setSelected(false);
				fr.setSelected(false);
				translateData("ru", "RU");
				image.setIcon(getImageIcon("Images\\rasha.png"));

			}
		});

		de.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fr.setSelected(false);
				ru.setSelected(false);
				translateData("de", "DE");
				image.setIcon(getImageIcon("Images\\germany.png"));
			}
		});

		fr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				de.setSelected(false);
				ru.setSelected(false);
				translateData("fr", "FR");
				image.setIcon(getImageIcon("Images\\france.png"));
			}
		});
		

		saveButton.addActionListener((e) -> {
			WorkerFiles.write(setPudge());
			deleteData();
		});
		
		loadButton.addActionListener((e)-> {
			Pudge pudge = WorkerFiles.read();
			System.out.println(pudge.getStrHello());
			strDrink.setText(pudge.getStrDrink());
System.out.println("2 " +pudge.getStrNation());
			strNation.setText(pudge.getStrNation());
			strHello.setText(pudge.getStrHello());
	
			
			
		}	);
	}

	private void translateData(String lang, String country) {
		Locale locale = new Locale(lang, country);
		messages = ResourceBundle.getBundle("messageBundle", locale);
	
		strHello.setText(messages.getString("hello"));
		strNation.setText(messages.getString("nation"));
		strDrink.setText(messages.getString("drink"));
		saveButton.setText(messages.getString("Save"));
		loadButton.setText(messages.getString("Load"));
	}
/*
	private String changeEncoding(String key) {
		String temp = messages.getString(key);
		try {
			return new String(temp.getBytes("ISO-8859-1"), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return "Encoding cann't be changed";
		}
	}*/
	private Pudge setPudge() {
		Pudge pudge = new Pudge();
		pudge.setStrHello(strHello.getText());
		//System.out.println("pudge1 "+pudge.getStrHello());
		pudge.setStrNation(strNation.getText());
	//	System.out.println("pudge2 "+pudge.getStrNation());
		pudge.setStrDrink(strDrink.getText());
		//System.out.println("pudge3 "+pudge.getStrDrink());
		return pudge;
	}
	
	private void deleteData() {
		strHello.setText("");
		strNation.setText("");
		strDrink.setText("");
		image.setIcon(null);
	}
}
