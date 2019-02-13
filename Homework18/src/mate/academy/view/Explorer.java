package mate.academy.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.text.JTextComponent;
import javax.swing.JScrollPane;
import java.awt.Color;
import javax.swing.JSplitPane;
import javax.swing.JTextPane;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingUtilities;
import javax.swing.JList;
import java.awt.Dimension;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JTextField;
import javax.security.auth.DestroyFailedException;
import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.SystemColor;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Explorer extends JFrame {

	private JPanel contentPane;
	private JScrollPane scrollPane = new JScrollPane();
	private JTextField address = new JTextField("D:\\");
	private File file = new File("D:\\");
	private DefaultListModel<String> model;
	private JList<String> list = new JList<String>();
	private JPopupMenu popupMenu;
	private JButton upButton = new JButton("Up");
	private Path pathCopy;
	private String temp;
	private String selectItem;
	private JMenuItem itemCopy = new JMenuItem("Copy");
	private JMenuItem itemDelete = new JMenuItem("Delete");
	private JMenuItem itemPaste = new JMenuItem("Paste");
	private JMenuItem itemCut = new JMenuItem("Cut");
	private JMenu itemCreate = new JMenu("Create");
	private JMenuItem folder = new JMenuItem("Directory");
	private JMenuItem txt = new JMenuItem("Text file");
	private JTextComponent directory;
	private JTextField textField;
	private JPanel panel = new JPanel();
	int count = 1;
	int countFile = 1;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public Explorer() {
		setTitle("Total Commander");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 400);
		contentPane = addContentPanel();
		contentPane.setBackground(Color.CYAN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}

	JPanel addContentPanel() {
		contentPane = new JPanel();

		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(0, 24, 434, 338);
		contentPane.add(scrollPane);

		popupMenu = addPopupMenu();
		addPopup(list, popupMenu);
		popupMenu.setBounds(0, 0, 200, 50);

		model = getContent(file);
		list.setModel(model);
		list.setBackground(SystemColor.control);
		list.setCellRenderer(new SelectedListCellRenderer());
	 
		scrollPane.setViewportView(list);
	

		upButton.setBounds(0, 0, 89, 23);
		contentPane.add(upButton);

		address.setBackground(Color.white);
		address.setBounds(89, 0, 361, 25);
		contentPane.add(address);
		address.setColumns(10);

		initListener();
		initListListener();
		return contentPane;
	}

	private JPopupMenu addPopupMenu() {
		popupMenu = new JPopupMenu();

		popupMenu.add(itemCreate);
		popupMenu.add(itemCopy);
		popupMenu.add(itemCut);
		popupMenu.add(itemPaste);
		popupMenu.add(itemDelete);

		itemCreate.add(folder);
		itemCreate.addSeparator();
		itemCreate.add(txt);

		initMenuListener();

		return popupMenu;

	}

	private void initMenuListener() {
		itemCopy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String currentPath = file.getAbsolutePath() + "\\" + list.getSelectedValue();
				temp = list.getSelectedValue();
				selectItem = itemCopy.getText();
				pathCopy = Paths.get(currentPath);
			}
		});

		itemCut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String currentPath = file.getAbsolutePath() + "\\" + list.getSelectedValue();
				temp = list.getSelectedValue();
				selectItem = itemCut.getText();
				pathCopy = Paths.get(currentPath);
			}
		});

		itemPaste.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nextPath = file.getAbsolutePath() + "\\" + temp;
				Path pathPaste = Paths.get(nextPath);
				switch (selectItem) {
				case "Copy":
					try {
						Files.copy(pathCopy, pathPaste);
						showFiles();
						break;
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				case "Cut":
					try {
						Files.move(pathCopy, pathPaste, StandardCopyOption.REPLACE_EXISTING);
						showFiles();
						break;
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				default:
					break;
				}
			}
		});

		itemDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String currentPath = file.getAbsolutePath() + "\\" + list.getSelectedValue();
				Path path = Paths.get(currentPath);
				try {
					Files.delete(path);
					showFiles();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});

		folder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String folderPath = file.getAbsolutePath() + "\\" + "New Folder";
				Path p = Paths.get(folderPath);
				if (Files.exists(p)) {
					folderPath = file.getAbsolutePath() + "\\" + "New Folder" + "_" + count;
					p = Paths.get(folderPath);
					count++;
					try {
						Files.createDirectory(p);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				} else {
					try {
						Files.createDirectory(p);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
				showFiles();
			}
		});

		txt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String filePath = file.getAbsolutePath() + "\\" + "New File" + ".txt";
				Path p = Paths.get(filePath);
				if (Files.exists(p)) {
					filePath = file.getAbsolutePath() + "\\" + "New File" + "_" + countFile + ".txt";
					p = Paths.get(filePath);
					count++;
					try {
						Files.createFile(p);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				} else {
					try {
						Files.createFile(p);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				showFiles();
			}
		});
	}

	private void initListListener() {
		list.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {

			}

			@Override
			public void mousePressed(MouseEvent e) {

				if (e.getClickCount() == 2) {
					file = new File(file.getAbsolutePath() + "\\" + list.getSelectedValue());
					if (file.isDirectory()) {
						list.setModel(getContent(file));
					}
					address.setText(file.getAbsolutePath());
				}
			}

			@Override
			public void mouseExited(MouseEvent e) {
			}

			@Override
			public void mouseEntered(MouseEvent e) {

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				if (SwingUtilities.isRightMouseButton(e)) {
					popupMenu.setVisible(true);
				}
				if (SwingUtilities.isLeftMouseButton(e)) {
				//	list.ren
				}
			}
		});
	}

	private void initListener() {
		upButton.addActionListener((e) -> {
			String path = file.getParent();
			address.setText(path);
			file = new File(path);
			model = getContent(file);
			list.setModel(model);
		});

		address.addActionListener((e) -> {
			file = new File(address.getText());
			list.setModel(getContent(file));
		});

	}

	private void showFiles() {
		file = new File(file.getAbsolutePath());
		list.setModel(getContent(file));
	}

	private DefaultListModel<String> getContent(File file) {
		DefaultListModel<String> alm = new DefaultListModel<>();
		for (File f : file.listFiles()) {
			if (f.isDirectory()) {
				alm.addElement(f.getName());
			}
		}
		for (File f : file.listFiles()) {
			if (f.isFile()) {
				alm.addElement(f.getName());
			}
		}
		return alm;
	}

	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
