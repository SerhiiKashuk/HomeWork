package academy.mate;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class ShapeFrame extends JFrame {

	private JPanel contentPane;
	private JPanel selectShape;
	private JPanel creatingShape;
	private JPanel resultShape;
	private Shape shape;
	private DBWorker worker;
	private JButton square = new JButton("Square");
	private JButton circle = new JButton("Circle");
	private JButton triangle = new JButton("Triangle");
	private JButton result = new JButton("RESULT");
	private JButton createButton = new JButton("CREATE");
	private JButton deleteButton = new JButton("Delete");
	private JButton returnButton = new JButton("New Shape");
	private JTable tableResult;
	private DefaultTableModel model;
	private List<String[]> list;
	private JLabel ok = new JLabel("");
	private JLabel side = new JLabel("Side");
	private JComboBox<String> colors = new JComboBox<String>();
	private JTextField sideCteate;
	private final JScrollPane scrollResult = new JScrollPane();
	private JTextField delId;

	/**
	 * Create the frame.
	 */
	public ShapeFrame() {
		setTitle("SHAPE");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setVisible(true);
		contentPane.setLayout(null);
		selectShape = addSelectPanel();
		contentPane.add(selectShape);
		creatingShape = addCreatingPanel();
		creatingShape.setVisible(false);
		contentPane.add(creatingShape);
		resultShape = addResultPanel();
		contentPane.add(resultShape);
	}

	private JPanel addSelectPanel() {
		selectShape = new JPanel();
		selectShape.setVisible(true);
		selectShape.setBounds(0, 0, 434, 262);
		selectShape.setBackground(Color.GREEN);
		selectShape.setLayout(null);

		result.setFont(new Font("Times New Roman", Font.BOLD, 12));
		result.setBounds(161, 199, 106, 23);
		selectShape.add(result);

		square.setFont(new Font("Times New Roman", Font.BOLD, 12));
		square.setBounds(10, 143, 106, 23);
		selectShape.add(square);

		circle.setFont(new Font("Times New Roman", Font.BOLD, 12));
		circle.setBounds(161, 143, 106, 23);
		selectShape.add(circle);

		triangle.setFont(new Font("Times New Roman", Font.BOLD, 12));
		triangle.setBounds(308, 143, 106, 23);
		selectShape.add(triangle);

		JLabel select = new JLabel("Select shape");
		select.setForeground(Color.BLUE);
		select.setHorizontalAlignment(SwingConstants.CENTER);
		select.setFont(new Font("Times New Roman", Font.BOLD, 18));
		select.setBounds(93, 35, 230, 23);
		selectShape.add(select);

		ok.setFont(new Font("Times New Roman", Font.BOLD, 17));
		ok.setHorizontalAlignment(SwingConstants.CENTER);

		ok.setBounds(10, 90, 404, 14);
		selectShape.add(ok);
		initListener();
		return selectShape;
	}

	private JPanel addCreatingPanel() {
		creatingShape = new JPanel();
		creatingShape.setBackground(Color.GREEN);
		creatingShape.setBounds(0, 0, 434, 262);
		creatingShape.setLayout(null);

		JLabel color = new JLabel("Color");
		color.setFont(new Font("Times New Roman", Font.BOLD, 14));
		color.setBounds(62, 101, 46, 14);
		creatingShape.add(color);

		JLabel title = new JLabel("Enter your data");
		title.setFont(new Font("Times New Roman", Font.BOLD, 24));
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setBounds(111, 11, 229, 29);
		creatingShape.add(title);

		side.setFont(new Font("Times New Roman", Font.BOLD, 14));
		side.setBounds(47, 54, 61, 14);
		side.setHorizontalAlignment(SwingConstants.LEFT);
		creatingShape.add(side);

		sideCteate = new JTextField();
		sideCteate.setHorizontalAlignment(SwingConstants.CENTER);
		sideCteate.setBounds(183, 51, 201, 20);
		creatingShape.add(sideCteate);
		sideCteate.setColumns(10);

		colors.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 13));
		colors.setModel(new DefaultComboBoxModel<String>(
		    new String[] { "Red", "Blue", "Green", "Yellow", "Orange", "Pink", "Cyan", "Black", "White" }));
		colors.setBounds(183, 98, 201, 20);
		creatingShape.add(colors);

		createButton.setFont(new Font("Times New Roman", Font.BOLD, 14));
		createButton.setBounds(171, 208, 97, 23);
		creatingShape.add(createButton);
		initListenerCreate();

		return creatingShape;
	}

	private JPanel addResultPanel() {
		resultShape = new JPanel();
		resultShape.setBounds(0, 0, 434, 262);
		contentPane.add(resultShape);
		resultShape.setLayout(null);
		scrollResult.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollResult.setBounds(0, 0, 434, 208);
		resultShape.add(scrollResult);

		String[][] obj = {};
		String[] header = { "id", "name", "color", "area", "perimeter", "user" };
		model = new DefaultTableModel(obj, header);
		tableResult = new JTable(model);
		scrollResult.setViewportView(tableResult);

		JLabel deleteLabel = new JLabel("Delete ID:");
		deleteLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		deleteLabel.setBounds(10, 229, 76, 14);
		resultShape.add(deleteLabel);

		delId = new JTextField();
		delId.setBounds(99, 226, 76, 23);
		resultShape.add(delId);
		delId.setColumns(10);

		deleteButton.setFont(new Font("Times New Roman", Font.BOLD, 13));
		deleteButton.setBounds(198, 226, 89, 23);
		resultShape.add(deleteButton);

		returnButton.setFont(new Font("Times New Roman", Font.BOLD, 13));
		returnButton.setBounds(325, 226, 99, 23);
		resultShape.add(returnButton);
		resultShape.setVisible(false);
		initListenerResult();
		return resultShape;
	}

	private void initListener() {
		square.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectShape.setVisible(false);
				shape = new Square(square.getText());
				creatingShape.setVisible(true);
			}
		});

		circle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectShape.setVisible(false);
				side.setText("Radius");
				shape = new Circle(circle.getText());
				creatingShape.setVisible(true);
			}
		});

		triangle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectShape.setVisible(false);
				shape = new Triangle(triangle.getText());
				creatingShape.setVisible(true);
			}
		});

		result.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				selectShape.setVisible(false);
				worker = new DBWorker();
				if (model.getRowCount() == 0) {
					list = worker.getAllRecord();
					for (String[] obj : list) {
						model.addRow(obj);
					}
				} else {
					Integer temp = Integer.parseInt((String) model.getValueAt(model.getRowCount() - 1, 0));
					int ids = worker.getIdLastRecord() - temp;
					System.out.println(ids);
					list = worker.getLastRecordsById(ids);
					for (String[] obj : list) {
						model.addRow(obj);
					}
				}
				worker.close();
				resultShape.setVisible(true);
			}
		});
	}

	private void initListenerCreate() {
		createButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				worker = new DBWorker();
				shape.setColor(colors.getSelectedItem().toString());
				shape.setArea(Integer.parseInt(sideCteate.getText()));
				shape.setPerimeter(Integer.parseInt(sideCteate.getText()));
				shape.setUser("Serhii Kashuk");
				worker.createShape(shape);
				worker.close();
				creatingShape.setVisible(false);
				ok.setText("Shape was created");
				selectShape.setVisible(true);

			}
		});

	}

	private void initListenerResult() {
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id = Integer.parseInt(delId.getText());
				worker = new DBWorker();
				worker.deleteById(id);
				int count = 0;
				while (count < id) {
					int temp = Integer.parseInt((String) model.getValueAt(count, 0));
					if (temp == id) {
						model.removeRow(count);
						break;
					}
					count++;
				}
				worker.close();
			}
		});

		returnButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resultShape.setVisible(false);
				selectShape.setVisible(true);
			}
		});
	}
}
