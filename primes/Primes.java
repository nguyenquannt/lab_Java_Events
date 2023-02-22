package primes;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Primes extends JFrame {

	private JTextField jTF_Scan;
	private JButton jB_Generate;
	private JTextArea jTA_DP;
	private void initUI() {
		this.setTitle("Primes");
		this.setSize(400, 300);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		
		this.jTF_Scan = new JTextField(20);
		this.jB_Generate = new JButton("Generate");
		this.jTA_DP = new JTextArea();
		
		// Top
		JPanel jP_Top = new JPanel();
		jP_Top.add(jTF_Scan);
		jP_Top.add(jB_Generate);
		
		// Center
		JScrollPane jSP_roll = new JScrollPane(jTA_DP); // để cuộn JtextArea
		
		// Main
		Container cTN_Main = this.getContentPane();
		cTN_Main.add(jP_Top, BorderLayout.NORTH);
		cTN_Main.add(jSP_roll, BorderLayout.CENTER);

	}
	public void addEvents() {
		jB_Generate.addMouseListener(new MouseListener() {
			
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
				try {
					int number = Integer.parseInt(jTF_Scan.getText());
					if(number > 0) {
					    int dem = 0;
					    int i = 2;
					    while (dem < number) {
					        if (isPrimeNumber(i)) {
					            jTA_DP.append(i+"\n");
					            dem++;
					        }
					        i++;
					    }
					}else {
						JOptionPane.showMessageDialog(null,"Kieu du lieu nhap vao khong dung !");
						jTF_Scan.setText(""); // set rỗng
						jTF_Scan.requestFocus();// con trỏ trỏ vào jtextfield 
					}
					
					
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null,"Kieu du lieu nhap vao khong dung !");
					jTF_Scan.setText(""); // set rỗng
					jTF_Scan.requestFocus();// con trỏ trỏ vào jtextfield 
					
				}
				
			}
		});
	}
	private boolean isPrimeNumber(int n) {
	    if (n < 2) {
	        return false;
	    }
	    int i;
	    int squareRoot = (int) Math.sqrt(n);
	    for (i = 2; i <= squareRoot; i++) {
	        if (n % i == 0) {
	            return false;
	        }
	    }
	    return true;
	}
	
	public Primes() {
		initUI();
		addEvents();
	}
	
	public static void main(String[] args) {
		new Primes().setVisible(true);

	}

}
/*
 * MSSV: 21006171
 * Họ và tên: Nguyễn Tống Anh Quân
 */
