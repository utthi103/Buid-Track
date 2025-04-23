package End_of_term;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import java.awt.Font;


import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.sql.Date;


import java.awt.event.ActionEvent;

public class formAdd extends JFrame{

	private JPanel contentPane;
	private JTextField textmahang;
	private JTextField texttenhang;
	private JTextField textdvt;
	private JTextField textDaban;
	private JTextField textnhacungcap;
	private JTextField textngaynhap;
	private JTextField textgianhapvao;
	private JTextField textgiabanra;
	private JTextField textghichu;
	private JTextField texttonkhoa;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					formAdd frame = new formAdd();
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
	public formAdd() {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 645, 555);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(SystemColor.desktop);
		separator.setBackground(SystemColor.desktop);
		separator.setBounds(10, 68, 611, 18);
		contentPane.add(separator);
		
		JLabel lblNewLabel = new JLabel("Th\u00EAm V\u1EADt li\u1EC7u");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\FPTSHOP\\OneDrive\\Pictures\\Icon\\Th\u00EAm1.png"));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setForeground(SystemColor.textHighlight);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(207, 11, 208, 46);
		contentPane.add(lblNewLabel);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBackground(SystemColor.desktop);
		separator_1.setForeground(SystemColor.desktop);
		separator_1.setBounds(10, 435, 611, 11);
		contentPane.add(separator_1);
		
		JLabel lblNewLabel_1 = new JLabel("Mã hàng");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBackground(new Color(0, 0, 0));
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setBounds(45, 97, 75, 17);
		contentPane.add(lblNewLabel_1);
		
		textmahang = new JTextField();
		textmahang.setBounds(45, 120, 215, 27);
		contentPane.add(textmahang);
		textmahang.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Tên hàng");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(45, 158, 75, 18);
		contentPane.add(lblNewLabel_2);
		
		texttenhang = new JTextField();
		texttenhang.setBounds(45, 183, 215, 27);
		contentPane.add(texttenhang);
		texttenhang.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Đơn vị tính");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(45, 221, 96, 14);
		contentPane.add(lblNewLabel_3);
		
		textdvt = new JTextField();
		textdvt.setBounds(45, 246, 215, 27);
		contentPane.add(textdvt);
		textdvt.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Đã bán");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(45, 284, 65, 18);
		contentPane.add(lblNewLabel_4);
		
		textDaban = new JTextField();
		textDaban.setBounds(45, 313, 215, 27);
		contentPane.add(textDaban);
		textDaban.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Nhà cung cấp");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_5.setBounds(369, 92, 132, 27);
		contentPane.add(lblNewLabel_5);
		
		textnhacungcap = new JTextField();
		textnhacungcap.setBounds(369, 120, 215, 27);
		contentPane.add(textnhacungcap);
		textnhacungcap.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Ngày nhập");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_6.setBounds(369, 159, 86, 17);
		contentPane.add(lblNewLabel_6);
		
		textngaynhap = new JTextField();
		textngaynhap.setBounds(369, 183, 215, 27);
		contentPane.add(textngaynhap);
		textngaynhap.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Giá nhập vào");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_7.setBounds(369, 221, 112, 18);
		contentPane.add(lblNewLabel_7);
		
		textgianhapvao = new JTextField();
		textgianhapvao.setBounds(369, 246, 217, 27);
		contentPane.add(textgianhapvao);
		textgianhapvao.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Giá bán ra");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_8.setBounds(369, 284, 83, 18);
		contentPane.add(lblNewLabel_8);
		
		textgiabanra = new JTextField();
		textgiabanra.setBounds(369, 313, 217, 27);
		contentPane.add(textgiabanra);
		textgiabanra.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("Ghi chú");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_9.setBounds(369, 351, 83, 14);
		contentPane.add(lblNewLabel_9);
		
		textghichu = new JTextField();
		textghichu.setBounds(369, 369, 217, 27);
		contentPane.add(textghichu);
		textghichu.setColumns(10);
		
		JButton btnluu = new JButton("L\u01B0u");
		btnluu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textmahang.getText().equals("")) {
				    JOptionPane.showMessageDialog(rootPane, "Vui lòng nhập mã hàng!");
				}else {

				try {
					connect c = new connect();
					Connection conn1 = c.newConnection();
					
					PreparedStatement pst = conn1.prepareStatement("insert into VATLIEU values(?,?,?,?,?,?,?,?,?,?)");
					pst.setString(1,textmahang.getText());
					pst.setString(2,texttenhang.getText());
					pst.setString(3,textdvt.getText());
					pst.setInt(4,Integer.parseInt(textDaban.getText()));
					pst.setInt(5,Integer.parseInt(texttonkhoa.getText()));
					pst.setString(6,textnhacungcap.getText());
					pst.setString(7, textngaynhap.getText());
					pst.setFloat(8,Float.parseFloat(textgianhapvao.getText()));
					pst.setFloat(9,Float.parseFloat(textgiabanra.getText()));
					pst.setString(10,textghichu.getText());
					
					if( pst.executeUpdate()>0 ){
						Formchung fc = new Formchung();
						fc.hienthi();
						JOptionPane.showMessageDialog(rootPane, "Đã thêm thành công!");
						textmahang.setText("");
						texttenhang.setText("");
						textdvt.setText("");
						textDaban.setText("");
						texttonkhoa.setText("");
						textnhacungcap.setText("");
						textngaynhap.setText("");
						textgianhapvao.setText("");
						textgiabanra.setText("");
						textghichu.setText("");


					}
				} catch (Exception e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(rootPane, "Vui lòng kiểm tra lại! " + e1.getMessage());
				}
				}
			}	
		});
		btnluu.setIcon(new ImageIcon("C:\\Users\\FPTSHOP\\OneDrive\\Pictures\\Icon\\L\u01B0u.png"));
		btnluu.setBackground(Color.DARK_GRAY);
		btnluu.setForeground(Color.LIGHT_GRAY);
		btnluu.setBounds(93, 457, 112, 33);
		contentPane.add(btnluu);
		
		JButton btnNewButton = new JButton("Tho\u00E1t");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int xn = JOptionPane.showConfirmDialog(rootPane, "Bạn có chắc muốn thoát không",  "Xác nhận",
						JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
				if(xn == JOptionPane.YES_OPTION) {
					setVisible(false);
				}
			}
		});
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\FPTSHOP\\OneDrive\\Pictures\\Icon\\exit (1).png"));
		btnNewButton.setForeground(Color.LIGHT_GRAY);
		btnNewButton.setBackground(Color.DARK_GRAY);
		btnNewButton.setBounds(413, 457, 110, 33);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_10 = new JLabel("Tồn kho");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_10.setBounds(45, 351, 62, 14);
		contentPane.add(lblNewLabel_10);
		
		texttonkhoa = new JTextField();
		texttonkhoa.setBounds(45, 369, 215, 27);
		contentPane.add(texttonkhoa);
		texttonkhoa.setColumns(10);
		
	}
}
