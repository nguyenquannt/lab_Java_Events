package nhanVien;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class NhanVien extends JFrame{

	private JTextField jTF_ID, jTF_FirstName, jTF_LastName, jTF_Age, jTF_Salary;
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
		
		//North
		JPanel jP_North = new JPanel();
		jP_North.setLayout(new FlowLayout(FlowLayout.CENTER));
		JLabel jL_Title = new JLabel("THÔNG TIN NHÂN VIÊN");
		Font font_Title =new Font("Arial", Font.BOLD, 22);
		jL_Title.setFont(font_Title);
		jL_Title.setForeground(Color.BLUE);
		jP_North.add(jL_Title);
		
		//Center
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
		b_Center.add(Box.createVerticalStrut(5)); // khoảng cách giữa các box
		b_Center.add(b2);
		b_Center.add(Box.createVerticalStrut(5));
		b_Center.add(b3);
		b_Center.add(Box.createVerticalStrut(5));
		b_Center.add(b4);
		b_Center.add(Box.createVerticalStrut(5));
		
		b1.add(jL_IDNV);
		b1.add(jTF_ID);
		
		b2.add(jL_FirstName);
		b2.add(jTF_FirstName);
		b2.add(jL_LastName);
		b2.add(jTF_LastName);
		jL_FirstName.setPreferredSize(jL_IDNV.getPreferredSize()); // canh chữ jl họ bằng với jl idnv 
		
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
		//JPanel jP_Table = new JPanel();
		dTB_Model = new DefaultTableModel();
		dTB_Model.addColumn("Mã NV");
		dTB_Model.addColumn("Họ");
		dTB_Model.addColumn("Tên");
		dTB_Model.addColumn("Phái");
		dTB_Model.addColumn("Tuổi");
		dTB_Model.addColumn("Tiền lương");
		jT_TableCenter = new JTable(dTB_Model);
		
		//tạo list option phái
		TableColumn sex_Columns = jT_TableCenter.getColumnModel().getColumn(3);
		JComboBox comboBox = new JComboBox();
		comboBox.addItem("Nam");
		comboBox.addItem("Nữ");
		sex_Columns.setCellEditor(new DefaultCellEditor(comboBox));
		JScrollPane jSP_Center = new JScrollPane(jT_TableCenter, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		jSP_Center.setPreferredSize(new Dimension(650,300));
		jP_Center.add(jSP_Center);
		
		//South
		// Main
		Container c_Main = getContentPane();
		c_Main.setLayout(new BorderLayout());
		c_Main.add(jP_North, BorderLayout.NORTH);
		c_Main.add(jP_Center, BorderLayout.CENTER);
	}
	
	private void addEvents() {
		
	}
	public NhanVien() {
		initUI();
		addEvents();
	}
	
	public static void main(String[] args) {
		NhanVien nv = new NhanVien();
		nv.setVisible(true);

	}

}
