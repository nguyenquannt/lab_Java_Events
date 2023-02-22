package myCalculator;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.concurrent.Flow;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

public class MyCalculator extends JFrame {
	private JButton buttonG, buttonT, buttonXR;
	private JTextField jTF_KQ, jTF_A, jTF_B;
	private JRadioButton jRB_C, jRB_T, jRB_N, jRB_Ch;
	
	private void initUI() {
		this.setTitle("Cộng - Trừ - Nhân - Chia");
		this.setSize(550, 400);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);

		// North
		JPanel jPNorth = new JPanel();
		JLabel jL_Title = new JLabel("Cộng Trừ Nhân Chia");
		Font f_Title = new Font("Tahoma", Font.BOLD, 24);
		jL_Title.setFont(f_Title);
		jL_Title.setForeground(Color.BLUE);
		jPNorth.add(jL_Title);
		jPNorth.setLayout(new FlowLayout(FlowLayout.CENTER));

		// South
		JPanel jPSouth = new JPanel();
		jPSouth.setPreferredSize(new Dimension(0, 50)); //
		JPanel jP_Blue = new JPanel();
		jP_Blue.setBackground(Color.BLUE);
		JPanel jP_Red = new JPanel();
		jP_Red.setBackground(Color.RED);
		JPanel jP_Yellow = new JPanel();
		jP_Yellow.setBackground(Color.YELLOW);
		
		Border bDSouth = BorderFactory.createLineBorder(Color.RED); // boder xung quanh
		TitledBorder titleBDSouth = new TitledBorder(bDSouth, " Nguyễn Quân ");
		jPSouth.setBorder(titleBDSouth);

		jPSouth.add(jP_Blue); // 3 ô màu xanh đỏ vàng
		jPSouth.add(jP_Red);
		jPSouth.add(jP_Yellow);
		jPSouth.setBackground(Color.PINK); // màu background

		// West
		JPanel jPWest = new JPanel();
		jPWest.setBackground(Color.LIGHT_GRAY);
		jPWest.setPreferredSize(new Dimension(100,0));
		jPWest.setLayout(new BoxLayout(jPWest, BoxLayout.Y_AXIS)); // tạo một boxlayout trục y
		
		buttonG = new JButton("Giải    ");
		buttonG.setLayout(new FlowLayout(FlowLayout.CENTER));
		buttonXR = new JButton("Xóa    ");
		buttonXR.setLayout(new FlowLayout(FlowLayout.CENTER));
		buttonT = new JButton("Thoát ");
		buttonT.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		jPWest.add(Box.createVerticalStrut(15));
		jPWest.add(buttonG);
		jPWest.add(Box.createVerticalStrut(15));
		jPWest.add(buttonXR);
		jPWest.add(Box.createVerticalStrut(15)); // khoảng cách giữa các phím là 
		jPWest.add(buttonT);
		
		Border bDWest = BorderFactory.createLineBorder(Color.RED, 1); // Tạo border bao xung quanh, màu ..., độ dày là 1
		TitledBorder tittleBorderWest = new TitledBorder(bDWest, "Chọn tác vụ"); // tạo một tittel boder "chọn tác vụ"
		jPWest.setBorder(tittleBorderWest); // Add titleBoder vào panel West

		// Center
		JPanel jPCenter = new JPanel();
		jPCenter.setLayout(new BoxLayout(jPCenter, BoxLayout.Y_AXIS));		
		
		JPanel jP_nhapa = new JPanel(); // tạo ra 1 panel để chứa jtf và jlb nhập a
		jP_nhapa.setLayout(new FlowLayout(FlowLayout.CENTER)); // set flowlayout, canh giữa		
		JLabel jL_nhapa = new JLabel("Nhập a: ");
		jTF_A = new JTextField(20);
		jP_nhapa.add(jL_nhapa);
		jP_nhapa.add(jTF_A);
		jPCenter.add(jP_nhapa);
		
		JPanel jP_nhapb = new JPanel();
		jP_nhapb.setLayout(new FlowLayout(FlowLayout.CENTER));
		JLabel jL_nhapb = new JLabel("Nhập b: ");	
		jTF_B = new JTextField(20);
		jP_nhapb.add(jL_nhapb);
		jP_nhapb.add(jTF_B);
		jPCenter.add(jP_nhapb);
		
		// Phần select cộng trừ nhân chia	
		ButtonGroup bG_select =new ButtonGroup(); // quản lý phần chọn or không chọn của 1 nhóm nút
		JPanel jP_select = new JPanel(); // tạo một panel khu vực lựa chọn cộng trừ nhân chia
		jP_select.setLayout(new BoxLayout(jP_select, BoxLayout.Y_AXIS)); // setlayout
		jP_select.setSize(new Dimension(100, 300)); // set kích thước jp_select = 100, 300
		
		jRB_C = new JRadioButton("Cộng");
		jRB_T = new JRadioButton("Trừ");
		jRB_N = new JRadioButton("Nhân");
		jRB_Ch = new JRadioButton("Chia");
		
		bG_select.add(jRB_C); // add jrb vào butonGroup bG_select
		bG_select.add(jRB_T);
		bG_select.add(jRB_N);
		bG_select.add(jRB_Ch);
		
		JPanel jP_Hang1 = new JPanel();
		jP_Hang1.setLayout(new FlowLayout(FlowLayout.CENTER));
		jP_Hang1.add(jRB_C);
		jP_Hang1.add(jRB_T);
		jP_select.add(jP_Hang1);
		
		JPanel jP_Hang2 = new JPanel();
		jP_Hang2.setLayout(new FlowLayout(FlowLayout.CENTER));
		jP_Hang2.add(jRB_N);
		jP_Hang2.add(jRB_Ch);		
		jP_select.add(jP_Hang2);
		
		TitledBorder tittle_BD = new TitledBorder(BorderFactory.createLineBorder(Color.RED), "Chọn phép toán");
		jP_select.setBorder(tittle_BD);
		jPCenter.add(jP_select);
		
		JPanel jP_KQ = new JPanel();
		jP_KQ.setLayout(new FlowLayout(FlowLayout.CENTER));
		jTF_KQ = new JTextField(20);
		jTF_KQ.setEditable(false);
		JLabel jL_KQ = new JLabel("Kết quả");
		jP_KQ.add(jL_KQ);
		jP_KQ.add(jTF_KQ);
		jPCenter.add(jP_KQ);
		
		// Main
		Container c_Main = getContentPane();
		c_Main.setLayout(new BorderLayout(5, 5));
		c_Main.add(jPNorth, BorderLayout.NORTH);
		c_Main.add(jPSouth, BorderLayout.SOUTH);
		c_Main.add(jPWest, BorderLayout.WEST);
		c_Main.add(jPCenter, BorderLayout.CENTER);

	}

	private void addEvents() {

	}

	public MyCalculator() {
		initUI();
		addEvents();
	}

	public static void main(String[] args) {
		new MyCalculator().setVisible(true);
	}

}
/*
 * MSSV: 21006171
 * Họ và tên: Nguyễn Tống Anh Quân
 */
