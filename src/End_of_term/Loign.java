package End_of_term;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.Choice;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.Window.Type;
import javax.swing.JSeparator;
import javax.swing.JFormattedTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Loign extends JFrame {

	private JPanel contentPane;
	private JTextField textdangnhap;
	private JPasswordField passwordmk;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Loign frame = new Loign();
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
	public Loign() {
		setBackground(Color.WHITE);
		setTitle("\u0110\u0103ng nh\u1EADp");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 841, 544);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Mật khẩu");
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(262, 200, 160, 44);
		contentPane.add(lblNewLabel_1);
		
		textdangnhap = new JTextField();
		textdangnhap.setBackground(new Color(255, 255, 255));
		textdangnhap.setFont(new Font("Tahoma", Font.ITALIC, 20));
		textdangnhap.setBounds(262, 154, 295, 35);
		contentPane.add(textdangnhap);
		textdangnhap.setColumns(10);
		
		passwordmk = new JPasswordField();
		passwordmk.setBackground(new Color(255, 255, 255));
		passwordmk.setFont(new Font("Tahoma", Font.ITALIC, 20));
		passwordmk.setEchoChar('.');
		passwordmk.setBounds(262, 241, 295, 35);
		contentPane.add(passwordmk);
		
		Choice choice = new Choice();
		choice.setBackground(new Color(255, 255, 255));
		choice.setFont(new Font("Times New Roman", Font.ITALIC, 22));
		choice.setBounds(262, 319, 295, 30);
		choice.add("");
		choice.add("Admin");
		choice.add("User");
		contentPane.add(choice);
		
		JLabel lblNewLabel_2 = new JLabel("Loại người dùng");
		lblNewLabel_2.setForeground(Color.BLACK);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(262, 280, 274, 44);
		contentPane.add(lblNewLabel_2);
		
		JButton btndangnhap = new JButton("\u0110\u0103ng nh\u1EADp");
		btndangnhap.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btndangnhap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pass = new String(passwordmk.getPassword());

			String sl = choice.getSelectedItem();	
			
				try {
					connect c = new connect();
					Connection conn1 = c.newConnection();
					
					PreparedStatement pst = conn1.prepareStatement("select * from DANGNHAP where [Tên đăng nhập] = ? and [Mật khẩu] = ? and [Loại người dùng] = ? ");
					pst.setString(1,textdangnhap.getText());
					pst.setString(2,passwordmk.getText());
					pst.setString(3,choice.getSelectedItem());
					
					ResultSet rs = pst.executeQuery();
					if( rs.next() ){
						if(sl.equals("Admin")) {
							Formchung fc = new Formchung();
							fc.setVisible(true);
						setVisible(false);
						}else if(sl.equals("User")){
							Khachhang frame = new Khachhang();
							frame.setVisible(true);
							setVisible(false);
						}else {
							JOptionPane.showMessageDialog(rootPane, "Vui lòng chọn loại người dùng");
						}
					}else {
						JOptionPane.showMessageDialog(rootPane, "Vui lòng kiểm tra lại thông tin");
					}
					
				}
				catch (Exception e1) {
					e1.printStackTrace();
				}
				
			}
		});
		btndangnhap.setBackground(new Color(175, 238, 238));
		btndangnhap.setForeground(new Color(0, 0, 0));
		btndangnhap.setBounds(262, 380, 148, 44);
		contentPane.add(btndangnhap);
		
			
		JButton btnNewButton = new JButton("Đăng kí");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FormDN frame = new FormDN();
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
					setVisible(false);
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBackground(new Color(255, 127, 80));
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBounds(409, 380, 148, 44);
		contentPane.add(btnNewButton);
			JLabel lblNewLabel = new JLabel("Tên đăng nhập");
		lblNewLabel.setBounds(262, 125, 135, 25);
		contentPane.add(lblNewLabel);
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
			JLabel lblNewLabel_4 = new JLabel("Đăng nhập vào hệ thống");
			lblNewLabel_4.setForeground(new Color(0, 0, 0));
			lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 25));
			lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(248, 43, 326, 44);
		contentPane.add(lblNewLabel_4);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Hiện mật khẩu");
		rdbtnNewRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnNewRadioButton.isSelected()) {
					passwordmk .setEchoChar((char)0);	
					passwordmk .setFont(new Font("Tahoma", Font.PLAIN, 20));
				}else {
					passwordmk.setEchoChar('.');
				}
			}
		});
		rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rdbtnNewRadioButton.setBackground(Color.WHITE);
		rdbtnNewRadioButton.setBounds(432, 211, 125, 30);
		contentPane.add(rdbtnNewRadioButton);

		JLabel lblNewLabel_5 = new JLabel("Đổi mật khẩu?");
		lblNewLabel_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				passwword frame = new passwword();
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
				setVisible(false);

			}
		});
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_5.setForeground(new Color(255, 0, 0));
		lblNewLabel_5.setBounds(366, 446, 119, 19);
		contentPane.add(lblNewLabel_5);
			JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(211, 34, 381, 446);
		contentPane.add(panel);
	
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\FPTSHOP\\OneDrive\\Pictures\\xaydung.PNG"));
		lblNewLabel_3.setBounds(0, -25, 875, 545);
		contentPane.add(lblNewLabel_3);
		

		
	
		

		
	
	}
}
