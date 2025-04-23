package End_of_term;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Choice;

public class Khachhang extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField texttimkiem;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Khachhang frame = new Khachhang();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
 public void xoa() {	
		try {
				 connect c = new connect();
		Connection conn1 = c.newConnection();
		PreparedStatement pst;
		pst = conn1.prepareStatement("Delete  from KHACHHANG");
		int rs = pst.executeUpdate();
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
 }
 public void ht() {
	 try {
			connect c = new connect();
			Connection conn1 = c.newConnection();
			PreparedStatement pst = conn1.prepareStatement("select * from KHACHHANG ");
			ResultSet rs = pst.executeQuery();
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			model.setRowCount(0);
			while( rs.next() ){
				Object oblist[] = {rs.getString("Mã hàng"),rs.getString("Tên hàng"),rs.getString("Đơn vị tính"),
				           rs.getInt("Số lượng"), 
				           rs.getFloat("Giá"), rs.getString("Ghi chú")};
					model.addRow(oblist);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

 
	public void hienthi() {
		try {
			connect c = new connect();
			Connection conn1 = c.newConnection();
			xoa();
		
			PreparedStatement pst = conn1.prepareStatement("INSERT INTO KHACHHANG([Mã hàng], [Tên hàng],[Đơn vị tính], [Số lượng], Giá, [Ghi chú])"
					+ "SELECT [Mã hàng], [Tên hàng],[Đơn vị tính], [Tồn kho], [Giá bán ra], [Ghi chú]"
					+ "FROM VATLIEU");
			int rs = pst.executeUpdate();
				//DefaultTableModel model = (DefaultTableModel) table.getModel();
			//model.setRowCount(0);
			ht();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public Khachhang() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1036, 494);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 84, 1002, 23);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 324, 1002, 23);
		contentPane.add(separator_1);
			
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 99, 980, 201);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setBackground(new Color(255, 255, 255));
		table.setFont(new Font("Tahoma", Font.ITALIC, 15));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				" M\u00E3 h\u00E0ng", "T\u00EAn h\u00E0ng", "\u0110\u01A1n v\u1ECB t\u00EDnh", "S\u1ED1 l\u01B0\u1EE3ng", "Gi\u00E1 ", "Ghi ch\u00FA"
			}
		));
	hienthi();
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("Từ khóa:");
		lblNewLabel.setBounds(20, 358, 182, 28);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		contentPane.add(lblNewLabel);
		
		texttimkiem = new JTextField();
		texttimkiem.setBounds(118, 358, 310, 28);
		texttimkiem.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(texttimkiem);
		texttimkiem.setColumns(10);
			
		Choice choice = new Choice();
		choice.setFont(new Font("Dialog", Font.PLAIN, 18));
		choice.setBounds(118, 417, 310, 18);
		choice.add(" ");
		choice.add("Mã hàng");
		choice.add("Tên hàng");
		choice.add("Nhà cung cấp");
		contentPane.add(choice);
		
		JButton btnNewButton = new JButton("Tìm kiếm");
		btnNewButton.setBounds(479, 379, 134, 33);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int dem =0;
				String ch = choice.getSelectedItem();	
				
				 if(texttimkiem.getText().equals("")) {
					   JOptionPane.showMessageDialog(rootPane, "Vui lòng nhập từ khóa cần tìm!");
				   }
				 else {
				try {
					connect c = new connect();
					Connection conn1 = c.newConnection();	
					DefaultTableModel model = (DefaultTableModel) table.getModel();
					if(ch.equals("Mã hàng")) {
						PreparedStatement pst = conn1.prepareStatement("select * from KHACHHANG where [Mã hàng] LIKE N'%' + ? + '%' ");
					pst.setString(1,texttimkiem.getText());
					ResultSet rs = pst.executeQuery();
					model.setRowCount(0);
					while( rs.next() ){
						dem++;
						Object oblist[] = {rs.getString("Mã hàng"),rs.getString("Tên hàng"),rs.getString("Đơn vị tính"),
						           rs.getInt("Số lượng"), 
						           rs.getFloat("Giá"), rs.getString("Ghi chú")};
								          
									model.addRow(oblist);
										texttimkiem.setText("");
					}if(dem==0) {
						JOptionPane.showMessageDialog(rootPane, "Không tìm thấy!");
						hienthi();
					}
					}else if(ch.equals("Tên hàng")) {
						PreparedStatement pst = conn1.prepareStatement("select * from KHACHHANG where [Tên hàng] LIKE N'%' + ? + '%' ");
						pst.setString(1,texttimkiem.getText());
						ResultSet rs = pst.executeQuery();
							model.setRowCount(0);
						while( rs.next() ){
							dem++;
							Object oblist[] = {rs.getString("Mã hàng"),rs.getString("Tên hàng"),rs.getString("Đơn vị tính"),
									           rs.getInt("Số lượng"),
									           rs.getFloat("Giá"), rs.getString("Ghi chú")};
										model.addRow(oblist);
											texttimkiem.setText("");
						}if(dem==0) {
							JOptionPane.showMessageDialog(rootPane, "Không tìm thấy!");
							hienthi();
							
						}
					}else if (ch.equals("Nhà cung cấp")){
						PreparedStatement pst = conn1.prepareStatement("select * from VATLIEU where [Nhà cung cấp] = ? ");
						pst.setString(1,texttimkiem.getText());
					ResultSet rs = pst.executeQuery();
					model.setRowCount(0);

					while( rs.next() ){	
						dem++;
						Object oblist[] = {rs.getString("Mã hàng"),rs.getString("Tên hàng"),rs.getString("Đơn vị tính"),
						           rs.getInt("Đã bán"),rs.getInt("Tồn kho"),rs.getString("Nhà cung cấp") , rs.getString("Ngày nhập"),
						           rs.getFloat("Giá nhập vào"), rs.getFloat("Giá bán ra"), rs.getString("Ghi chú")};
							model.addRow(oblist);
							texttimkiem.setText("");
					}
					if(dem==0) {
						JOptionPane.showMessageDialog(rootPane, "Không tìm thấy!");
						hienthi();
					}
					}
					
				
				}
				catch (Exception e1) {
					e1.printStackTrace();
				}
			}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.setForeground(Color.LIGHT_GRAY);
		btnNewButton.setBackground(Color.DARK_GRAY);
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\FPTSHOP\\OneDrive\\Pictures\\Icon\\tìm kiếm.png"));
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("Danh sách vật tư");
		lblNewLabel_1.setBounds(397, 11, 231, 34);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_1.setForeground(SystemColor.textHighlight);
		lblNewLabel_1.setIcon(null);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton_1 = new JButton("Xem");
		btnNewButton_1.setBounds(866, 379, 134, 33);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ht();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_1.setForeground(Color.LIGHT_GRAY);
		btnNewButton_1.setBackground(Color.DARK_GRAY);
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\FPTSHOP\\OneDrive\\Pictures\\Icon\\reload (3) (1).png"));
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Sắp xếp");
		btnNewButton_2.setBounds(670, 379, 134, 33);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					connect c = new connect();
					Connection conn1 = c.newConnection();
					PreparedStatement pst = conn1.prepareStatement("select *from KHACHHANG order by Giá ");
					ResultSet rs = pst.executeQuery();
					DefaultTableModel model = (DefaultTableModel) table.getModel();
					model.setRowCount(0);
					while( rs.next() ){
						Object oblist[] = {rs.getString("Mã hàng"),rs.getString("Tên hàng"),rs.getString("Đơn vị tính"),
								           rs.getInt("Số lượng"), 
								        rs.getFloat("Giá"), rs.getString("Ghi chú")};
									model.addRow(oblist);
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_2.setForeground(Color.LIGHT_GRAY);
		btnNewButton_2.setBackground(Color.DARK_GRAY);
		btnNewButton_2.setIcon(new ImageIcon("C:\\Users\\FPTSHOP\\OneDrive\\Pictures\\Icon\\sort.png"));
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel_2 = new JLabel("Tìm theo:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2.setBounds(20, 417, 74, 29);
		contentPane.add(lblNewLabel_2);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 331, 1033, 126);
		contentPane.add(panel);

		

	}
}
