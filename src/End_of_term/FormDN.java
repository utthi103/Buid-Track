package End_of_term;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.Choice;
import javax.swing.JRadioButton;

public class FormDN extends JFrame {

	private JPanel contentPane;
	private JTextField txtngKTi;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JTextField texthovaten;
	private JTextField textsdt;
	private JTextField textdc;
	private JTextField texttendn;
	private JPasswordField passwordmk;
	private JPasswordField passwordxnmk;
	private JRadioButton rdbtnNewRadioButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormDN frame = new FormDN();
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
	public FormDN() {
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 342, 660);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtngKTi = new JTextField();
		txtngKTi.setEditable(false);
		txtngKTi.setHorizontalAlignment(SwingConstants.CENTER);
		txtngKTi.setBackground(new Color(95, 158, 160));
		txtngKTi.setFont(new Font("Tahoma", Font.BOLD, 20));
		txtngKTi.setText("\u0110\u0103ng k\u00ED t\u00E0i kho\u1EA3n\r\n");
		txtngKTi.setBounds(0, 0, 324, 77);
		contentPane.add(txtngKTi);
		txtngKTi.setColumns(10);
		
		lblNewLabel = new JLabel("H\u1ECD v\u00E0 t\u00EAn");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(23, 96, 96, 19);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("S\u1ED1 \u0111i\u1EC7n tho\u1EA1i");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(23, 159, 96, 19);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("\u0110\u1ECBa ch\u1EC9");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(23, 224, 68, 19);
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("T\u00EAn \u0111\u0103ng nh\u1EADp");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(23, 287, 125, 31);
		contentPane.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("M\u1EADt kh\u1EA9u");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(23, 356, 111, 32);
		contentPane.add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("X\u00E1c nh\u1EADn m\u1EADt kh\u1EA9u");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_5.setBounds(23, 431, 155, 31);
		contentPane.add(lblNewLabel_5);
		
		texthovaten = new JTextField();
		texthovaten.setFont(new Font("Tahoma", Font.PLAIN, 13));
		texthovaten.setBounds(23, 121, 272, 27);
		contentPane.add(texthovaten);
		texthovaten.setColumns(10);
		
		textsdt = new JTextField();
		textsdt.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textsdt.setBounds(23, 184, 272, 27);
		contentPane.add(textsdt);
		textsdt.setColumns(10);
		
		textdc = new JTextField();
		textdc.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textdc.setBounds(23, 249, 272, 27);
		contentPane.add(textdc);
		textdc.setColumns(10);
		
		texttendn = new JTextField();
		texttendn.setFont(new Font("Tahoma", Font.PLAIN, 13));
		texttendn.setBounds(23, 318, 272, 27);
		contentPane.add(texttendn);
		texttendn.setColumns(10);
		
		Choice choice = new Choice();
		choice.setFont(new Font("Times New Roman", Font.ITALIC, 19));
		choice.setBounds(23, 528, 272, 31);
		choice.add("");
		choice.add("Admin");
		choice.add("User");
		contentPane.add(choice);
		
		JButton btnNewButton = new JButton("T\u1EA1o t\u00E0i kho\u1EA3n");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String line = null;
				
				String pass = new String(passwordmk.getPassword());
				if(texthovaten.equals("") || textsdt.equals("") || textdc.equals("") || texttendn.equals("") 
						|| passwordmk.equals("") || passwordxnmk.equals("") || choice.getSelectedItem().equals("")  ) {
					JOptionPane.showMessageDialog(rootPane, "Vui lòng điền đầy đủ thông tin");
				}else {
					if(!(textsdt.getText().length()==10) ) {
						JOptionPane.showMessageDialog(rootPane, "Số điện thoại có 10 chữ số");
					}else if(pass.length() <5) {
						JOptionPane.showMessageDialog(rootPane, "Mật khẩu phải nhiều hơn 5 kí tự");
					}
					else if(!passwordmk.getText().equals(passwordxnmk.getText()) ) {
						JOptionPane.showMessageDialog(rootPane, "Vui lòng kiểm tra lại mật khẩu");
					}else {
						try {
							connect c = new connect();
							Connection conn1 = c.newConnection();
							PreparedStatement pst = conn1.prepareStatement("insert into DANGNHAP values(?,?,?,?,?,?) ");
							pst.setString(1, texthovaten.getText());
							pst.setString(2, textsdt.getText());
							pst.setString(3, textdc.getText());
							pst.setString(4, texttendn.getText());
							pst.setString(5, passwordmk.getText());
							pst.setString(6, choice.getSelectedItem());
						   int rs = pst.executeUpdate();
						   if(rs>0) {// có hàng được cập nhật
							   JOptionPane.showMessageDialog(rootPane, "Tạo thành công");
						   }
							}
						
						 catch (Exception e1) {
							 JOptionPane.showMessageDialog(rootPane, "Vui lòng kiểm tra lại! " + e1.getMessage());
						}
						
						 texthovaten.setText("");
						textsdt.setText("");
					   textdc.setText("");
						 texttendn.setText("");
						 passwordmk.setText("");
						 choice.getSelectedItem();
						 passwordxnmk.setText("");
						 JOptionPane.showMessageDialog(rootPane, "Về trang chủ để đăng nhâp");
					}
				}
			}
		});
		btnNewButton.setBackground(new Color(95, 158, 160));
		btnNewButton.setBounds(23, 580, 111, 32);
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
		btnNewButton_1.setBounds(184, 580, 111, 32);
		contentPane.add(btnNewButton_1);
		
		passwordmk = new JPasswordField();
		passwordmk.setFont(new Font("Tahoma", Font.PLAIN, 15));
		passwordmk.setBounds(23, 393, 272, 27);
	    passwordmk.setEchoChar('.');
		contentPane.add(passwordmk);
		
		passwordxnmk = new JPasswordField();
		passwordxnmk.setFont(new Font("Tahoma", Font.PLAIN, 15));
		passwordxnmk.setBounds(23, 465, 272, 27);
		passwordxnmk.setEchoChar('.');
		contentPane.add(passwordxnmk);
		
		JLabel lblNewLabel_6 = new JLabel("Lo\u1EA1i ng\u01B0\u1EDDi d\u00F9ng");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_6.setBounds(23, 503, 125, 19);
		contentPane.add(lblNewLabel_6);
		
		rdbtnNewRadioButton = new JRadioButton("Hiện mật khẩu");
		rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rdbtnNewRadioButton.setBackground(Color.WHITE);
		rdbtnNewRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnNewRadioButton.isSelected()) {
					passwordmk.setEchoChar((char)0);	
					passwordmk.setFont(new Font("Tahoma", Font.PLAIN, 15));
				}else {
					passwordmk.setEchoChar('.');
				}
			  
			}
		});
		rdbtnNewRadioButton.setBounds(172, 361, 134, 23);
		contentPane.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Hiện mật khẩu");
		rdbtnNewRadioButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnNewRadioButton_1.isSelected()) {
					passwordxnmk.setEchoChar((char)0);	
					passwordxnmk.setFont(new Font("Tahoma", Font.PLAIN, 15));
				}else {
					passwordxnmk.setEchoChar('.');
				}
			}
		});
		rdbtnNewRadioButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rdbtnNewRadioButton_1.setBackground(Color.WHITE);
		rdbtnNewRadioButton_1.setBounds(172, 435, 134, 23);
		contentPane.add(rdbtnNewRadioButton_1);

	}
}
