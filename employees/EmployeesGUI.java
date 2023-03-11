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
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Iterator;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
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
	private JButton jBT_Search, jBT_Add, jBT_Del_All, jBT_Del, jBT_Save, jBT_Edit;
	private JRadioButton jRB_Male, jRb_Female;
	private ButtonGroup bG_Sex;
	private JTable jT_TableCenter;
	private DefaultTableModel dTM_Model;
	protected ListEmployees listEmployees;

	public EmployeesGUI() {
		listEmployees = new ListEmployees(); // phải khởi tạo listEmployee trước
		initUI();
		addEvents();
	}

	private void initUI() {

		this.setTitle("Quản lý nhân viên");
		this.setSize(900, 590);
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

		jRB_Male = new JRadioButton("Nam", true); // mặc định chọn nam
		jRb_Female = new JRadioButton("Nữ");
		bG_Sex = new ButtonGroup();
		bG_Sex.add(jRB_Male);
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
		b3.add(jRB_Male);
		b3.add(jRb_Female);
		jL_Age.setPreferredSize(jL_IDNV.getPreferredSize());

		b4.add(jL_Salary);
		b4.add(jTF_Salary);
		jL_Salary.setPreferredSize(jL_IDNV.getPreferredSize());
		jP_Center.add(b_Center);

		// JPanel jP_Table = new JPanel();
		dTM_Model = new DefaultTableModel();
		dTM_Model.addColumn("Mã NV");
		dTM_Model.addColumn("Họ");
		dTM_Model.addColumn("Tên");
		dTM_Model.addColumn("Phái");
		dTM_Model.addColumn("Tuổi");
		dTM_Model.addColumn("Tiền lương");
		jT_TableCenter = new JTable(dTM_Model);

		// tạo list option phái
		TableColumn sex_Columns = jT_TableCenter.getColumnModel().getColumn(3);
		JComboBox comboBox = new JComboBox();
		comboBox.addItem("Nam");
		comboBox.addItem("Nữ");
		sex_Columns.setCellEditor(new DefaultCellEditor(comboBox));
		JScrollPane jSP_Center = new JScrollPane(jT_TableCenter, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		jSP_Center.setPreferredSize(new Dimension(650, 320));
		jP_Center.add(jSP_Center);

		// South
		JSplitPane jsplitPane_South = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		jsplitPane_South.setResizeWeight(0.2); // 20%/80% mỗi bên

		JPanel jP_Search = new JPanel(); // phần tìm kiếm bên trái
		JLabel jL_search = new JLabel("Nhập mã số cần tìm");
		jTF_SearchID = new JTextField(15);
		jP_Search.add(jL_search);
		jP_Search.add(jTF_SearchID);
		jBT_Search = new JButton("Tìm kiếm");
		jP_Search.add(jBT_Search);
		jsplitPane_South.add(jP_Search);

		JPanel jP_Function = new JPanel();
		jBT_Add = new JButton("Thêm");
		jBT_Del_All = new JButton("Xóa trắng");
		jBT_Del = new JButton("Xóa");
		jBT_Save = new JButton("Lưu");
		jBT_Edit = new JButton("Sữa");
		jP_Function.add(jBT_Add);
		jP_Function.add(jBT_Del_All);
		jP_Function.add(jBT_Del);
		jP_Function.add(jBT_Save);
		jP_Function.add(jBT_Edit);
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

	private void addEvents() {

		offJtextField(); // tắt các JTF
		jBT_Search.addActionListener(this);
		jBT_Add.addActionListener(this);
		jBT_Del.addActionListener(this);
		jBT_Del_All.addActionListener(this);
		jBT_Save.addActionListener(this);
		jBT_Edit.addActionListener(this);
		jRB_Male.addActionListener(this);
		jRb_Female.addActionListener(this);

		jT_TableCenter.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				
				int row = jT_TableCenter.getSelectedRow();
				jTF_ID.setText(dTM_Model.getValueAt(row, 0).toString());
				jTF_FirstName.setText(dTM_Model.getValueAt(row, 1).toString());
				jTF_LastName.setText(dTM_Model.getValueAt(row, 2).toString());
				if (dTM_Model.getValueAt(row, 3).toString().equalsIgnoreCase("Nam")) {
					jRB_Male.setSelected(true);
					jRb_Female.setSelected(false);
				} else {
					jRB_Male.setSelected(false);
					jRb_Female.setSelected(true);
				}
				jTF_Age.setText(dTM_Model.getValueAt(row, 4) + "");
				jTF_Salary.setText(dTM_Model.getValueAt(row, 5) + "");
			}
		});
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj.equals(jBT_Add)) {
			if (jBT_Add.getText().equals("Thêm")) {
				onJtextField();
				jBT_Del.setEnabled(false);
				jBT_Add.setText("Hủy");
			} else {
				jBT_Del.setEnabled(true);
				jBT_Add.setText("Thêm");
			}
		} else if (obj.equals(jBT_Save)) {

			if (jTF_ID.getText().equals("") || jTF_FirstName.getText().equals("") || jTF_LastName.getText().equals("")
					|| jTF_Salary.getText().equals("") || jTF_Age.getText().equals("")) {
				JOptionPane.showMessageDialog(this, "Bạn chưa nhập đầy đủ thông tin !");
			} else {
				try {
					saveEmployees();
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(this, "Bạn đã nhập sai dữ liệu, vui lòng kiểm tra lại ^^");
				}
				jTF_FirstName.setText("");
				jTF_LastName.setText("");
				jTF_ID.setText("");
				jTF_Age.setText("");
				jTF_Salary.setText("");
				jBT_Add.setText("Thêm");
				jTF_ID.requestFocus(); // requestFocus()
				jRB_Male.setSelected(false);
				jRb_Female.setSelected(false);

				jBT_Del.setEnabled(true);
				offJtextField();
			}
		} else if (obj.equals(jBT_Del)) {
			try {
				delEmployees();
				clearJTF();
			} catch (Exception e1) {
				 e1.printStackTrace();
			}

		} else if (obj.equals(jBT_Del_All)) {
			clear();
		} else if (obj.equals(jBT_Edit)) {
			// System.exit(0);
		} else if (obj.equals(jBT_Search)) {
			searchID();
		}
	}
	
	// funtion
	public void offJtextField() {
		// tắt các JTF
		jTF_ID.setEnabled(false);
		jTF_FirstName.setEnabled(false);
		jTF_LastName.setEnabled(false);
		jTF_Age.setEnabled(false);
		jTF_Salary.setEnabled(false);
		jRB_Male.setEnabled(false);
		jRb_Female.setEnabled(false);
	}

	public void onJtextField() {
		// bật các JTF
		jTF_ID.setEnabled(true);
		jTF_FirstName.setEnabled(true);
		jTF_LastName.setEnabled(true);
		jTF_Age.setEnabled(true);
		jTF_Salary.setEnabled(true);
		jRB_Male.setEnabled(true);
		jRb_Female.setEnabled(true);
		jTF_ID.requestFocus();
	}

	public void saveEmployees() throws Exception {

		String id = jTF_ID.getText();
		String fName = jTF_FirstName.getText();
		String lName = jTF_LastName.getText();
		String sex = "";
		if (jRB_Male.isSelected()) {
			sex = jRB_Male.getText();
		} else if (jRb_Female.isSelected()) {
			sex = jRb_Female.getText();
		}
		int Age = Integer.parseInt(jTF_Age.getText());
		double salary = Double.parseDouble(jTF_Salary.getText());

		Employees employees = new Employees(id, fName, lName, sex, Age, salary);
		if (listEmployees.addEmployees(employees) == true) {
			Object[] obj = new Object[6];
			obj[0] = id;
			obj[1] = fName;
			obj[2] = lName;
			obj[3] = sex;
			obj[4] = Integer.toString(Age);
			obj[5] = Double.toString(salary);
			dTM_Model.addRow(obj);
			JOptionPane.showMessageDialog(this, "Thêm thành công !");
		} else {
			JOptionPane.showMessageDialog(this, "Mã nhân viên đã tồn tại");
			jTF_ID.setText("");
		}
	}
	
	public void clear() {
		if (JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa tất cả hay không ?", "cảnh báo",
				JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
			dTM_Model.setRowCount(0); // set các hàng table thành 0 => sẽ xóa dữ liệu của table
			clearJTF();
		}
	}
	
	public void clearJTF() {
		jTF_ID.setText("");
		jTF_FirstName.setText("");
		jTF_LastName.setText("");
		jTF_Age.setText("");
		jTF_Salary.setText("");
		jTF_SearchID.setText("");
		jRB_Male.setText("Nam");
	}
	
	public void delEmployees() {
		int row = jT_TableCenter.getSelectedRow();
		if (row == -1) {
			JOptionPane.showMessageDialog(this, "Hãy chọn dòng cần xóa !");
		} else {
			if (JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa dòng này hay không", "Cảnh báo",
					JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
				listEmployees.delEmployees(row);
				dTM_Model.removeRow(row);
				clearJTF();
			}
		}
	}
	
	public void searchID() {
		int indexEmployees =  listEmployees.searchID(jTF_SearchID.getText());
		jT_TableCenter.setRowSelectionInterval(indexEmployees, indexEmployees); // setRowSelectionInterval tô đậm dữ liệu từ dòng nào -> dòng nào
		if(indexEmployees != 0) {
			JOptionPane.showMessageDialog(this, "Không tìm thấy !");
		}
	}

	public void editEployees() {
		// listEmployees.editEmployees(getName(), getTitle(), getWarningString(),
		// getName(), ALLBITS, ABORT)
	}

	public static void main(String[] args) {
		EmployeesGUI nv = new EmployeesGUI();
		nv.setVisible(true);
	}

}