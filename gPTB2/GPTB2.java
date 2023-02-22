package gPTB2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

public class GPTB2 extends JFrame {
	private JButton buttonG, buttonT, buttonXR;
	private JTextField txtKQ, txtA, txtB, txtC;

	private void initUI() {
		this.setSize(550, 400);
		this.setTitle("Phần mềm giải phương trình");
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);

		JPanel jPanel_Main_BoderLayout = new JPanel(new BorderLayout(5, 5)); // Panel tổng quát bên ngoài

		// North
		JPanel jPanel_title = new JPanel(); // Tạo ra một Panel để chứa title
		jPanel_title.setBackground(Color.CYAN); // màu backgroup
		JLabel jLabel_title = new JLabel("GIẢI PHƯƠNG TRÌNH BẬC HAI"); // Title
		Font ftitle = new Font("Tahoma", Font.BOLD, 22); // Tạo font và cỡ chữ
		jLabel_title.setFont(ftitle); // Set font
		jPanel_title.add(jLabel_title); // Add label title vào panel title

		// South
		JPanel jPanel_below = new JPanel(); // Layout mặc định Flowlayout
		buttonG = new JButton("Giải");
		buttonXR = new JButton("Xóa Rỗng");
		buttonT = new JButton("Thoát");
		jPanel_below.add(buttonG);
		jPanel_below.add(buttonXR);
		jPanel_below.add(buttonT);

		Border bdSouth = BorderFactory.createLineBorder(Color.GREEN, 1); // Tạo border bao xung quanh, màu đỏ, độ dày là
																			// 1
		TitledBorder titleBoder = new TitledBorder(bdSouth, " Nguyễn Quân "); // Title cho border, Gắn titele này vào
																			// border South
		jPanel_below.setBorder(titleBoder); // Add titleBoder vào panel South

		// Center
		JPanel jPanel_Center = new JPanel();
		jPanel_Center.setLayout(new BoxLayout(jPanel_Center, BoxLayout.Y_AXIS)); // Tạo một BoxLayout theo trục Y
		Border bdCenter = BorderFactory.createLineBorder(Color.YELLOW, 2); // Tạo border bao xung quanh, màu vàng, độ
																			// dày là 1
		TitledBorder titleCenter = new TitledBorder(bdCenter, "Nhập a, b và c"); // Title cho border, Gắn titele này vào
																					// border center
		jPanel_Center.setBorder(titleCenter); // Add titleBoder vào panel Center

		JPanel jPanel_nhapa = new JPanel(); // Tạo ra một panel để nhập a
		jPanel_nhapa.add(new JLabel("Nhập a: ")); // Add ra một label chứa chứ "Nhập a" và add vào panel
		txtA = new JTextField(25); // 1 TextField độ dài 25
		jPanel_nhapa.add(txtA);

		JPanel jPanel_nhapb = new JPanel();
		jPanel_nhapb.add(new JLabel("Nhập b: "));
		txtB = new JTextField(25);
		jPanel_nhapb.add(txtB);

		JPanel jPanel_nhapc = new JPanel();
		jPanel_nhapc.add(new JLabel("Nhập c: "));
		txtC = new JTextField(25);
		jPanel_nhapc.add(txtC);

		JPanel jPanel_KetQua = new JPanel();
		jPanel_KetQua.add(new JLabel("Kết quả: "));
		txtKQ = new JTextField(25);
		txtKQ.setEditable(false); // không cho nhập dữ liệu
		jPanel_KetQua.add(txtKQ);

		jPanel_Center.add(jPanel_nhapa);
		jPanel_Center.add(jPanel_nhapb);
		jPanel_Center.add(jPanel_nhapc);
		jPanel_Center.add(jPanel_KetQua);

		// ráp các phần lại
		jPanel_Main_BoderLayout.add(jPanel_title, BorderLayout.NORTH); // Thêm phần title vào North panel chính
		jPanel_Main_BoderLayout.add(jPanel_below, BorderLayout.SOUTH); // Thêm phần below vào South panel chính
		jPanel_Main_BoderLayout.add(jPanel_Center, BorderLayout.CENTER); // Thêm Phần Center vào panel chính
		this.add(jPanel_Main_BoderLayout);// thêm panel main vào JFrame
	}

	private void addEvents() {
		buttonT.addMouseListener(new MouseListener() {

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
				// TODO Auto-generated method stub
				System.exit(1);

			}
		});

		buttonXR.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
			}

			@Override
			public void mousePressed(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {
			}

			@Override
			public void mouseEntered(MouseEvent e) {
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				txtC.setText("");
				txtA.setText("");
				txtB.setText("");
				txtKQ.setText("");

			}
		});

		buttonG.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
			}

			@Override
			public void mousePressed(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {
			}

			@Override
			public void mouseEntered(MouseEvent e) {
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					double a = Double.parseDouble(txtA.getText());
					double b = Double.parseDouble(txtB.getText());
					double c = Double.parseDouble(txtC.getText());
					double delta = b * b - 4 * a * c;
					double x1, x2;

					if (delta > 0) {
						x1 = (double) ((-b + Math.sqrt(delta)) / (2 * a));
						x2 = (double) ((-b - Math.sqrt(delta)) / (2 * a));
						txtKQ.setText("X1= " + x1 + ", X2= " + x2);
					} else if (delta == 0) {
						x1 = (-b / (2 * a));
						txtKQ.setText("Phuong trinh co nghiem kep X= " + txtKQ);
					} else {
						txtKQ.setText("Vo nghiem !");
					}
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Kieu du lieu dau vao khong dung !");
				}

			}
		});

	}

	public GPTB2() {
		super();
		initUI();
		addEvents();
	}

	public static void main(String[] args) {
		GPTB2 gpt = new GPTB2();
		gpt.setVisible(true);

	}

}
/*
 * MSSV: 21006171 
 * Ho va ten: Nguyen Tong Anh Quan
 *
 */
