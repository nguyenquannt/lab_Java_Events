package employees;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class EmployeesGUI extends JFrame implements ActionListener {

	private JTextField jTF_ID, jTF_FirstName, jTF_LastName, jTF_Age, jTF_Salary, jTF_SearchID;
	private Button bT_Search, bT_Add, bT_Del_All, bT_Del, bT_Save;
	private JRadioButton jRB_male, jRb_Female;
	private ButtonGroup bG_Sex;
	private JTable jT_TableCenter;
	private DefaultTableModel dTB_Model;

	private void initUI() {

		this.setTitle("Quản lý nhân viên");
		this.setSize(900, 500);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);

		// North
		JPanel jP_North = new JPanel();
		jP_North.setLayout(new FlowLayout(FlowLayout.CENTER));
		JLabel jL_Title = new JLabel("THÔNG TIN NHÂN VIÊN");
		Font font_Title = new Font("Arial", Font.BOLD, 22);
		jL_Title.setFont(font_Title);
		jL_Title.setForeground(Color.BLUE);
		jP_North.add(jL_Title);

		// Center
		JPanel jP_Center = new JPanel();
		jP_Center.setLayout(new BoxLayout(jP_Center, BoxLayout.Y_AXIS));

		JLabel jL_IDNV = new JLabel("Mã nhân viên: ");
		JLabel jL_FirstName = new JLabel("Họ: ");
		JLabel jL_LastName = new JLabel("Tên nhân viên: ");
		JLabel jL_Age = new JLabel("Tuổi: ");
		JLabel jL_Sex = new JLabel("Phái: ");
		JLabel jL_Salary = new JLabel("Tiền lương: ");

		jTF_ID = new JTextField();
		jTF_FirstName = new JTextField();
		jTF_LastName = new JTextField();
		jTF_Age = new JTextField();
		jTF_Salary = new JTextField();

		jRB_male = new JRadioButton("Nam", true); // mặc định chọn nam
		jRb_Female = new JRadioButton("Nữ");
		bG_Sex = new ButtonGroup();
		bG_Sex.add(jRB_male);
		bG_Sex.add(jRb_Female);

		Box b_Center, b1, b2, b3, b4;
		b_Center = Box.createVerticalBox();
		b1 = Box.createHorizontalBox();
		b2 = Box.createHorizontalBox();
		b3 = Box.createHorizontalBox();
		b4 = Box.createHorizontalBox();

		b_Center.add(b1);
		b_Center.add(Box.createVerticalStrut(10)); // khoản cách giữa các box
		b_Center.add(b2);
		b_Center.add(Box.createVerticalStrut(10));
		b_Center.add(b3);
		b_Center.add(Box.createVerticalStrut(10));
		b_Center.add(b4);
		b_Center.add(Box.createVerticalStrut(10));

		b1.add(jL_IDNV);
		b1.add(jTF_ID);

		b2.add(jL_FirstName);
		b2.add(jTF_FirstName);
		b2.add(jL_LastName);
		b2.add(jTF_LastName);
		jL_FirstName.setPreferredSize(jL_IDNV.getPreferredSize()); // canh chữ jlabel họ bằng với jlabel idnv

		b3.add(jL_Age);
		b3.add(jTF_Age);
		b3.add(jL_Sex);
		b3.add(jRB_male);
		b3.add(jRb_Female);
		jL_Age.setPreferredSize(jL_IDNV.getPreferredSize());

		b4.add(jL_Salary);
		b4.add(jTF_Salary);
		jL_Salary.setPreferredSize(jL_IDNV.getPreferredSize());
		jP_Center.add(b_Center);
		
		// JPanel jP_Table = new JPanel();
		dTB_Model = new DefaultTableModel();
		dTB_Model.addColumn("Mã NV");
		dTB_Model.addColumn("Họ");
		dTB_Model.addColumn("Tên");
		dTB_Model.addColumn("Phái");
		dTB_Model.addColumn("Tuổi");
		dTB_Model.addColumn("Tiền lương");
		jT_TableCenter = new JTable(dTB_Model);

		// tạo list option phái
		TableColumn sex_Columns = jT_TableCenter.getColumnModel().getColumn(3);
		JComboBox comboBox = new JComboBox();
		comboBox.addItem("Nam");
		comboBox.addItem("Nữ");
		sex_Columns.setCellEditor(new DefaultCellEditor(comboBox));
		JScrollPane jSP_Center = new JScrollPane(jT_TableCenter, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		jSP_Center.setPreferredSize(new Dimension(650, 500));
		jP_Center.add(jSP_Center);

		// South
		JSplitPane jsplitPane_South = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		jsplitPane_South.setResizeWeight(0.5);

		JPanel jP_Search = new JPanel(); // phần tìm kiếm bên trái
		JLabel jL_search = new JLabel("Nhập mã số cần tìm");
		jTF_SearchID = new JTextField(15);
		jP_Search.add(jL_search);
		jP_Search.add(jTF_SearchID);
		bT_Search = new Button("Tìm kiếm");
		jP_Search.add(bT_Search);
		jsplitPane_South.add(jP_Search);

		JPanel jP_Function = new JPanel();
		bT_Add = new Button("Thêm");
		bT_Del_All = new Button("Xóa trắng");
		bT_Del = new Button("Xóa");
		bT_Save = new Button("Lưu");
		jP_Function.add(bT_Add);
		jP_Function.add(bT_Del_All);
		jP_Function.add(bT_Del);
		jP_Function.add(bT_Save);
		jsplitPane_South.add(jP_Function);

		Border bdSouth = BorderFactory.createLineBorder(Color.DARK_GRAY, 1); 
		TitledBorder titleBoder = new TitledBorder(bdSouth, " Nguyễn Quân ");
		jsplitPane_South.setBorder(titleBoder);
		
		// Main
		Container c_Main = getContentPane();
		c_Main.setLayout(new BorderLayout());
		c_Main.add(jP_North, BorderLayout.NORTH);
		c_Main.add(jP_Center, BorderLayout.CENTER);
		c_Main.add(jsplitPane_South, BorderLayout.SOUTH);
	}

	public EmployeesGUI() {
		initUI();
		addEvents();
	}

	public static void main(String[] args) {
		EmployeesGUI nv = new EmployeesGUI();
		nv.setVisible(true);

	}

	private void addEvents() {

		bT_Search.addActionListener(this);
		bT_Add.addActionListener(this);
		bT_Del_All.addActionListener(this);
		bT_Del.addActionListener(this);
		bT_Save.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(bT_Add)) {
			if (jTF_ID.getText().equals("") || jTF_FirstName.getText().equals("") || jTF_LastName.getText().equals("")
					|| jTF_Age.getText().equals("") || jTF_Salary.getText().equals("")) {
				JOptionPane.showMessageDialog(this, "Bạn đã nhập thiếu dữ liệu");
			} else {
				/*
				 * Employees employees = new Employees(); employees.setIdNV(jTF_ID.getText());
				 * employees.setFirstName(jTF_FirstName.getText());
				 * employees.setLastNamel(jTF_LastName.getText()); int age =
				 * Integer.parseInt(jTF_Age.getText()); employees.setAge(age); double salary =
				 * Double.parseDouble(jTF_Salary.getText()); employees.setSalary(salary);
				 */
				Object[] obj = new Object[6];
				obj[0] = jTF_ID.getText();
				obj[1] = jTF_FirstName.getText();
				obj[2] = jTF_LastName.getText();
				// obj[3] = bG_Sex.getSelection();
				obj[4] = jTF_Age.getText();
				obj[5] = jTF_Salary.getText();

				dTB_Model.addRow(obj);
				this.jTF_Age.setText("");
				this.jTF_FirstName.setText("");
				this.jTF_ID.setText("");
				this.jTF_LastName.setText("");
				this.jTF_Salary.setText("");

			}
		} else if (o.equals(bT_Del_All)) {
			jTF_Age.setText("");
			jTF_FirstName.setText("");
			jTF_ID.setText("");
			jTF_LastName.setText("");
			jTF_Salary.setText("");
			jTF_SearchID.setText("");
		} else if (o.equals(bT_Del)) {
			if (jT_TableCenter.getSelectedRow() == -1) {
				JOptionPane.showMessageDialog(this, "Hãy chọn dòng muốn xóa");
			} else {
				if (JOptionPane.showConfirmDialog(this, "Bạn sẽ xóa xòng này nêu nhấn Yes", "Cảnh báo",
						JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
					dTB_Model.removeRow(jT_TableCenter.getSelectedRow());

			}

		} else if (o.equals(bT_Save)) {

		} else if (o.equals(bT_Search)) {

		}
	}

}
/*
 * Lỗi nhận text Age, salary
 * Lỗi option giới tính
 * Chưa có lọc thêm trùng ID
 */
