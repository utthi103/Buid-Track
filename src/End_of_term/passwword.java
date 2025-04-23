package End_of_term;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class passwword extends JFrame {

	private JPanel contentPane;
	private JTextField textdangnhap;
	private JPasswordField passmkc;
	private JPasswordField passmkm;
	private JPasswordField passxnmk;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					passwword frame = new passwword();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	


	/**
	 * Create the frame.
	 */
	public passwword() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 313, 422);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("T\u00EAn \u0111\u0103ng nh\u1EADp");
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(10, 69, 117, 22);
		contentPane.add(lblNewLabel);
		
		textdangnhap = new JTextField();
		textdangnhap.setBounds(10, 95, 272, 27);
		contentPane.add(textdangnhap);
		textdangnhap.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("M\u1EADt kh\u1EA9u c\u0169");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(10, 132, 106, 22);
		contentPane.add(lblNewLabel_1);
		
		passmkc = new JPasswordField();
		passmkc.setFont(new Font("Tahoma", Font.PLAIN, 15));
		passmkc.setBounds(10, 162, 272, 27);
		passmkc.setEchoChar('.');
		contentPane.add(passmkc);
		
		JLabel lblNewLabel_2 = new JLabel("M\u1EADt kh\u1EA9u m\u1EDBi");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(10, 200, 95, 22);
		contentPane.add(lblNewLabel_2);
		
		passmkm = new JPasswordField();
		passmkm.setFont(new Font("Tahoma", Font.PLAIN, 15));
		passmkm.setBounds(10, 226, 272, 27);
		passmkm.setEchoChar('.');
		contentPane.add(passmkm);
		
		JLabel lblNewLabel_3 = new JLabel("Xác nhận lại mật khẩu");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(10, 264, 159, 22);
		contentPane.add(lblNewLabel_3);
		
		passxnmk = new JPasswordField();
		passxnmk.setFont(new Font("Tahoma", Font.PLAIN, 15));
		passxnmk.setBounds(10, 297, 272, 27);
		passxnmk.setEchoChar('.');
		contentPane.add(passxnmk);
		
		JButton btnNewButton = new JButton("L\u01B0u");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pass = new String(passmkm.getPassword());
				String pass1 = new String(passxnmk.getPassword());
						try {
							connect c = new connect();
							Connection conn1 = c.newConnection();
							
							PreparedStatement pst1 = conn1.prepareStatement("select *from DANGNHAP where [Tên đăng nhập] = ? ");
							pst1.setString(1,textdangnhap.getText());
							ResultSet rs1 = pst1.executeQuery();
							
							PreparedStatement pst2 = conn1.prepareStatement("select * from DANGNHAP where [Tên đăng nhập] = ? and [Mật khẩu] = ?  ");
							pst2.setString(1,textdangnhap.getText());
							pst2.setString(2,passmkc.getText());
							ResultSet rs2 = pst2.executeQuery();
							if(!rs1.next()) {
								JOptionPane.showMessageDialog(rootPane, "Không tồn tại tên đăng nhập");
							}
						       else  if(!rs2.next()){
								JOptionPane.showMessageDialog(rootPane, "Sai mật khẩu");
							}
						       else {
								if(textdangnhap.getText().equals("") || passmkc.getText().equals("") 
										|| passmkm.getText().equals("") || passxnmk.getText().equals("")) {
									JOptionPane.showMessageDialog(rootPane, "Vui lòng điền đầy đủ thông tin");
								}else {
									if(pass.length()<5) {
										JOptionPane.showMessageDialog(rootPane, "Mật khẩu phải nhiều hơn 5 kí tự");
									}else if(!passmkm.getText().equals(passxnmk.getText())) {
										JOptionPane.showMessageDialog(rootPane, "Vui lòng kiểm tra lại mật khẩu");
									}else {
								PreparedStatement pst = conn1.prepareStatement("update DANGNHAP set [Mật khẩu] = ? where [Tên đăng nhập] = ? and [Mật khẩu] =?");
								pst.setString(1,passmkm.getText());
								pst.setString(2,textdangnhap.getText());
								pst.setString(3,passmkc.getText());
								int rs = pst.executeUpdate();
								if(rs>0) {
								JOptionPane.showMessageDialog(rootPane, "Đổi thành công!!");
								textdangnhap.setText("");
								passmkc.setText("");
								passmkm.setText("");
								passxnmk.setText("");
							}
									}
							}
							
							}
						}
							
						catch (Exception e1) {
							e1.printStackTrace();
							JOptionPane.showMessageDialog(rootPane, "Vui lòng kiểm tra lại! " + e1.getMessage());
						}
					}
			
				

			
		});
		btnNewButton.setBackground(new Color(95, 158, 160));
		btnNewButton.setIcon(null);
		btnNewButton.setBounds(10, 345, 111, 30);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Trang ch\u1EE7");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Loign frame = new Loign();
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
				setVisible(false);
			}
		});
		btnNewButton_1.setBackground(new Color(95, 158, 160));
		btnNewButton_1.setBounds(171, 345, 111, 30);
		contentPane.add(btnNewButton_1);
		
		JRadioButton password2 = new JRadioButton("Hi\u1EC7n m\u1EADt kh\u1EA9u");
		password2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(password2.isSelected()) {
					passmkm .setEchoChar((char)0);	
					passmkm .setFont(new Font("Tahoma", Font.PLAIN, 15));
				}else {
					passmkm.setEchoChar('.');
				}
			}
		});
		password2.setBackground(new Color(255, 255, 255));
		password2.setBounds(171, 202, 111, 23);
		contentPane.add(password2);
		
		JRadioButton password3 = new JRadioButton("Hi\u1EC7n m\u1EADt kh\u1EA9u");
		password3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(password3.isSelected()) {
					passxnmk .setEchoChar((char)0);	
					passxnmk .setFont(new Font("Tahoma", Font.PLAIN, 15));
				}else {
					passxnmk .setEchoChar('.');
				}
			}
		});
		password3.setBackground(new Color(255, 255, 255));
		password3.setBounds(171, 266, 111, 23);
		contentPane.add(password3);
		
		JRadioButton password1 = new JRadioButton("Hi\u1EC7n m\u1EADt kh\u1EA9u");
		password1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(password1.isSelected()) {
					passmkc .setEchoChar((char)0);	
					passmkc .setFont(new Font("Tahoma", Font.PLAIN, 15));
				}else {
					passmkc .setEchoChar('.');
				}
			}
		});
		password1.setBackground(new Color(255, 255, 255));
		password1.setBounds(171, 131, 111, 23);
		contentPane.add(password1);
		
		JLabel lblNewLabel_4 = new JLabel("Đổi Mật Khẩu");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_4.setBounds(87, 21, 152, 36);
		contentPane.add(lblNewLabel_4);
	}
}
