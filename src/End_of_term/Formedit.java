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
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Formedit extends JFrame {

	private JPanel contentPane;
	private JTextField textmahang;
	private JTextField texttenhang;
	private JTextField textdonvitinh;
	private JTextField textDaban;
	private JTextField textnhacungcap;
	private JTextField textngaynhap;
	private JTextField textgianhapvao;
	private JTextField textgiabanra;
	private JTextField textghichu;
	private JTextField texttonkho;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Formedit frame = new Formedit();
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
	public Formedit() {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 607, 506);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(SystemColor.desktop);
		separator.setBackground(SystemColor.desktop);
		separator.setBounds(10, 68, 573, 18);
		contentPane.add(separator);
		
		JLabel lblNewLabel = new JLabel("S\u1EEDa V\u1EADt li\u1EC7u");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\FPTSHOP\\OneDrive\\Pictures\\Icon\\S\u1EEDa (1).png"));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setForeground(SystemColor.textHighlight);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(183, 11, 208, 46);
		contentPane.add(lblNewLabel);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBackground(SystemColor.desktop);
		separator_1.setForeground(SystemColor.desktop);
		separator_1.setBounds(10, 385, 573, 11);
		contentPane.add(separator_1);
		
		JLabel lblNewLabel_1 = new JLabel("Mã hàng cần sửa");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(30, 79, 134, 17);
		contentPane.add(lblNewLabel_1);
		
		textmahang = new JTextField();
		textmahang.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					try {
						connect c = new connect();
						Connection conn1 = c.newConnection();
						
						PreparedStatement pst = conn1.prepareStatement("select * from VATLIEU where [Mã hàng] = ? ");
						pst.setString(1,textmahang.getText());
						ResultSet rs = pst.executeQuery();
						if( rs.next() ){
						texttenhang.setText(rs.getString("Tên hàng"));
						textdonvitinh.setText(rs.getString("Đơn vị tính")); 
						textDaban.setText(String.valueOf(rs.getInt("Đã bán")));
						texttonkho.setText(String.valueOf(rs.getInt("Tồn kho")));
						textnhacungcap.setText(rs.getString("Nhà cung cấp") );
						textngaynhap.setText(rs.getString("Ngày nhập"));
						textgianhapvao.setText(String.valueOf(rs.getFloat("Giá nhập vào")));
						textgiabanra.setText(String.valueOf(rs.getFloat("Giá bán ra")));
						textghichu.setText(rs.getString("Ghi chú"));

										
						}else {
							JOptionPane.showMessageDialog(rootPane, "Không tồn tại mã hàng cần sửa!");
						}
					
					}
					catch (Exception e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		textmahang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 
			}
		});
		textmahang.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textmahang.setBounds(30, 99, 215, 27);
		contentPane.add(textmahang);
		textmahang.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Tên hàng");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(29, 137, 104, 18);
		contentPane.add(lblNewLabel_2);
		
		texttenhang = new JTextField();
		texttenhang.setFont(new Font("Tahoma", Font.PLAIN, 15));
		texttenhang.setBounds(29, 158, 215, 27);
		contentPane.add(texttenhang);
		texttenhang.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Đơn vị tính");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(29, 196, 86, 14);
		contentPane.add(lblNewLabel_3);
		
		textdonvitinh = new JTextField();
		textdonvitinh.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textdonvitinh.setBounds(29, 214, 215, 27);
		contentPane.add(textdonvitinh);
		textdonvitinh.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Đã bán");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(29, 252, 65, 18);
		contentPane.add(lblNewLabel_4);
		
		textDaban = new JTextField();
		textDaban.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textDaban.setBounds(29, 275, 216, 27);
		contentPane.add(textDaban);
		textDaban.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Nhà cung cấp");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_5.setBounds(349, 80, 124, 14);
		contentPane.add(lblNewLabel_5);
		
		textnhacungcap = new JTextField();
		textnhacungcap.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textnhacungcap.setBounds(349, 97, 215, 27);
		contentPane.add(textnhacungcap);
		textnhacungcap.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Ngày nhập");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_6.setBounds(349, 138, 86, 17);
		contentPane.add(lblNewLabel_6);
		
		textngaynhap = new JTextField();
		textngaynhap.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textngaynhap.setBounds(349, 158, 215, 27);
		contentPane.add(textngaynhap);
		textngaynhap.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Giá nhập vào");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_7.setBounds(349, 194, 104, 18);
		contentPane.add(lblNewLabel_7);
		
		textgianhapvao = new JTextField();
		textgianhapvao.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textgianhapvao.setBounds(349, 214, 215, 27);
		contentPane.add(textgianhapvao);
		textgianhapvao.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Giá bán ra");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_8.setBounds(349, 252, 83, 18);
		contentPane.add(lblNewLabel_8);
		
		textgiabanra = new JTextField();
		textgiabanra.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textgiabanra.setBounds(349, 275, 215, 27);
		contentPane.add(textgiabanra);
		textgiabanra.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("Ghi chú");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_9.setBounds(349, 313, 83, 14);
		contentPane.add(lblNewLabel_9);
		
		textghichu = new JTextField();
		textghichu.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textghichu.setBounds(349, 332, 215, 27);
		contentPane.add(textghichu);
		textghichu.setColumns(10);
		
		JButton btnluu = new JButton("L\u01B0u");
		btnluu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textmahang.getText().equals("")) {
						JOptionPane.showMessageDialog(rootPane, "Vui lòng nhập mã hàng cần sửa!");
					}else{
				try {
					connect c = new connect();
					Connection conn1 = c.newConnection();
					
					PreparedStatement pst = conn1.prepareStatement("update VATLIEU set [Tên hàng] = ?, [Đơn vị tính] = ? ,"
							+ " [Đã bán] = ?, [Tồn kho] = ?, [Nhà cung cấp] = ? , [Ngày nhập] = ? , [Giá nhập vào] = ?, [Giá bán ra] = ?, [Ghi chú] = ?"
							+ " where [Mã hàng] = ? ");
					pst.setString(10,textmahang.getText());
					pst.setString(1,texttenhang.getText());
					pst.setString(2,textdonvitinh.getText());
					pst.setInt(3,Integer.parseInt(textDaban.getText()));
					pst.setInt(4,Integer.parseInt(texttonkho.getText()));
					pst.setString(5,textnhacungcap.getText());
			        pst.setString(6,textngaynhap.getText());
					pst.setFloat(7,Float.parseFloat(textgianhapvao.getText()));
					pst.setFloat(8,Float.parseFloat(textgiabanra.getText()));
					pst.setString(9,textghichu.getText());
				  if( pst.executeUpdate()>0) {
					  Formchung fc   = new Formchung();
					  fc.hienthi();
					  JOptionPane.showMessageDialog(rootPane, "Sửa thành công!");
				  }
					else {
						JOptionPane.showMessageDialog(rootPane, "Vui lòng kiểm tra lại!");
					}
						
				}
				 catch (Exception e2) {
					e2.printStackTrace();
					JOptionPane.showMessageDialog(rootPane, "Vui lòng kiểm tra lại! " + e2.getMessage());
					
				}
					}
				
			}

		});
		btnluu.setIcon(new ImageIcon("C:\\Users\\FPTSHOP\\OneDrive\\Pictures\\Icon\\L\u01B0u.png"));
		btnluu.setBackground(Color.DARK_GRAY);
		btnluu.setForeground(Color.LIGHT_GRAY);
		btnluu.setBounds(80, 419, 112, 33);
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
		btnNewButton.setBounds(415, 419, 110, 33);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_10 = new JLabel("Tồn kho");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_10.setBounds(30, 313, 65, 14);
		contentPane.add(lblNewLabel_10);
		
		texttonkho = new JTextField();
		texttonkho.setBounds(29, 332, 216, 27);
		contentPane.add(texttonkho);
		texttonkho.setColumns(10);
	}
}
