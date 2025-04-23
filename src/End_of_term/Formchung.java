package End_of_term;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;

import javax.print.attribute.Size2DSyntax;
import javax.print.attribute.standard.Finishings;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.security.interfaces.RSAKey;
import javax.swing.JTextField;
import java.awt.Choice;

public class Formchung extends JFrame {
	private JPanel contentPane;
	private JTable table_1;
	DefaultTableModel model;
	private JTextField texttimkiem;
	Object oblist1[];
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Formchung frame = new Formchung();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void hienthi() {
		try {
			connect c = new connect();
			Connection conn1 = c.newConnection();
			PreparedStatement pst = conn1.prepareStatement("select * from VATLIEU");
			ResultSet rs = pst.executeQuery(); 
			// Lưu kết quả của câu lệnh sql
			// tạo ra mối liên kết giữa Model và model đưa dl vào model cũng giống như đưa vào Model
			DefaultTableModel model = (DefaultTableModel) table_1.getModel();// lưu lại kq sau khi thực thi câu lệnh
			model.setRowCount(0);
			while( rs.next() ){
				Object oblist[] = {rs.getString("Mã hàng"),rs.getString("Tên hàng"),rs.getString("Đơn vị tính"),
						           rs.getInt("Đã bán"),rs.getInt("Tồn kho"),rs.getString("Nhà cung cấp") , rs.getString("Ngày nhập"),
						           rs.getFloat("Giá nhập vào"), rs.getFloat("Giá bán ra"), rs.getString("Ghi chú")};
							model.addRow(oblist);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}



	public Formchung() {
		setBackground(Color.WHITE);
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1069, 544);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 65, 1041, 23);
		separator.setBackground(SystemColor.desktop);
		contentPane.add(separator);
		
		JLabel lblNewLabel = new JLabel(" Qu\u1EA3n L\u00ED V\u1EADt T\u01B0");
		lblNewLabel.setBounds(388, 0, 243, 65);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\FPTSHOP\\OneDrive\\Pictures\\Icon\\home_badge (1).png"));
		lblNewLabel.setForeground(SystemColor.textHighlight);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 23));
		contentPane.add(lblNewLabel);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 371, 1041, 12);
		separator_1.setBackground(SystemColor.desktop);
		contentPane.add(separator_1);
		
		
		JButton btthem = new JButton("Th\u00EAm");
		btthem.setFont(new Font("Tahoma", Font.BOLD, 11));
		btthem.setIcon(new ImageIcon("C:\\Users\\FPTSHOP\\OneDrive\\Pictures\\Icon\\Th\u00EAm.png"));
		btthem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				formAdd frame = new formAdd();
				frame.setVisible(true);
	           hienthi();
	           
			}
		});
		btthem.setBackground(Color.DARK_GRAY);
		btthem.setForeground(Color.LIGHT_GRAY);
		btthem.setBounds(706, 394, 115, 37);
		contentPane.add(btthem);
		
		JButton btsua = new JButton("S\u1EEDa");
		btsua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Formedit frame = new Formedit();
				frame.setVisible(true);
			}
		});
		btsua.setFont(new Font("Tahoma", Font.BOLD, 11));
		btsua.setBackground(Color.DARK_GRAY);
		btsua.setForeground(Color.LIGHT_GRAY);
		btsua.setIcon(new ImageIcon("C:\\Users\\FPTSHOP\\OneDrive\\Pictures\\Icon\\S\u1EEDa.png"));
		btsua.setBounds(879, 394, 115, 37);
		contentPane.add(btsua);
		
		
		JButton btxoa = new JButton("X\u00F3a");
		btxoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = table_1.getSelectedRow();
				int col = table_1.getSelectedColumn();
				
				if(row == -1) {
					JOptionPane.showMessageDialog(rootPane, "Vui lòng chọn mã hàng cần xóa!");
				}else {
					
					try {
						connect c = new connect();
						Connection conn1 = c.newConnection();
						String xoa =  (String) table_1.getValueAt(row, col);
						if(JOptionPane.showConfirmDialog(rootPane, "Bạn có chắc muốn xóa không",  "Xác nhận",
								JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
							PreparedStatement pst = conn1.prepareStatement(" delete from VATLIEU where [Mã hàng] = ? ");
						pst.setString(1,xoa);
						if( pst.executeUpdate()>0 ){// có hàng được cập nhật
								hienthi();
							JOptionPane.showMessageDialog(rootPane, "Đã xóa thành công!");				
						}

							}
						
						}
					 catch (Exception e1) {
						e1.printStackTrace();
						JOptionPane.showMessageDialog(rootPane, "Vui lòng kiểm tra lại! " + e1.getMessage());
					}

				}
	
			}
		});
		btxoa.setFont(new Font("Tahoma", Font.BOLD, 11));
		btxoa.setIcon(new ImageIcon("C:\\Users\\FPTSHOP\\OneDrive\\Pictures\\Icon\\x\u00F3a.png"));
		btxoa.setBackground(Color.DARK_GRAY);
		btxoa.setForeground(Color.LIGHT_GRAY);
		btxoa.setBounds(535, 451, 115, 37);
		contentPane.add(btxoa);
		Choice choice = new Choice();
		choice.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		choice.setBounds(126, 461, 310, 18);
		choice.add("");
		choice.add("Mã hàng");
		choice.add("Tên hàng");
		choice.add("Nhà cung cấp");
		contentPane.add(choice);
		
		JButton bttimkiem = new JButton("T\u00ECm ki\u1EBFm");
		bttimkiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ch = choice.getSelectedItem();	
				int dem =0;
				   if(texttimkiem.getText().equals("")) {
					   JOptionPane.showMessageDialog(rootPane, "Vui lòng nhập từ khóa cần tìm!");
				   }else if(ch.equals("")) {
					   JOptionPane.showMessageDialog(rootPane, "Vui lòng nhập loại cần tìm!");
				   }
				   else {
				try {
					connect c = new connect();
					Connection conn1 = c.newConnection();
					DefaultTableModel model = (DefaultTableModel) table_1.getModel();

					if(ch.equals("Tên hàng")) {
						PreparedStatement pst = conn1.prepareStatement("select * from VATLIEU where [Tên hàng] LIKE N'%' + ? + '%'");
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
					}else if(ch.equals("Mã hàng")) {
						PreparedStatement pst = conn1.prepareStatement("select * from VATLIEU where [Mã hàng] LIKE N'%' + ? + '%'");
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
					}if(dem==0) {
						JOptionPane.showMessageDialog(rootPane, "Không tìm thấy!");
						hienthi();
					}
					
					
					}else if(ch.equals("Nhà cung cấp")) {
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
		bttimkiem.setFont(new Font("Tahoma", Font.BOLD, 11));
		bttimkiem.setIcon(new ImageIcon("C:\\Users\\FPTSHOP\\OneDrive\\Pictures\\Icon\\t\u00ECm ki\u1EBFm.png"));
		bttimkiem.setBackground(Color.DARK_GRAY);
		bttimkiem.setForeground(Color.LIGHT_GRAY);
		bttimkiem.setBounds(535, 394, 115, 37);
		contentPane.add(bttimkiem);
		
		
		JButton btnNewButton_4 = new JButton("S\u1EAFp x\u1EBFp");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					connect c = new connect();
					Connection conn1 = c.newConnection();
					PreparedStatement pst = conn1.prepareStatement("select *from VATLIEU order by [Giá nhập vào],[Giá bán ra] ");
					ResultSet rs = pst.executeQuery();
					DefaultTableModel model = (DefaultTableModel) table_1.getModel();
					model.setRowCount(0);
					while( rs.next() ){
						Object oblist[] = {rs.getString("Mã hàng"),rs.getString("Tên hàng"),rs.getString("Đơn vị tính"),
						           rs.getInt("Đã bán"),rs.getInt("Tồn kho"),rs.getString("Nhà cung cấp") , rs.getString("Ngày nhập"),
						           rs.getFloat("Giá nhập vào"), rs.getFloat("Giá bán ra"), rs.getString("Ghi chú")};
							model.addRow(oblist);
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
				
			}
		});
		btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_4.setIcon(new ImageIcon("C:\\Users\\FPTSHOP\\OneDrive\\Pictures\\Icon\\sort.png"));
		btnNewButton_4.setBackground(Color.DARK_GRAY);
		btnNewButton_4.setForeground(Color.LIGHT_GRAY);
		btnNewButton_4.setBounds(706, 451, 115, 37);
		contentPane.add(btnNewButton_4);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 99, 1009, 244);
		contentPane.add(scrollPane);
		
		table_1 = new JTable();
		table_1.setBackground(Color.WHITE);
		table_1.setFont(new Font("Tahoma", Font.ITALIC, 15));
		scrollPane.setViewportView(table_1);
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"M\u00E3 h\u00E0ng ", "T\u00EAn h\u00E0ng", "\u0110\u01A1n v\u1ECB t\u00EDnh", "\u0110\u00E3 b\u00E1n", "T\u1ED3n kho", "Nh\u00E0 cung c\u1EA5p", "Ng\u00E0y nh\u1EADp", "Gi\u00E1 nh\u1EADp", "Gi\u00E1 b\u00E1n ra", "Ghi ch\u00FA"
			}
		));
		hienthi();
		JButton btnNewButton = new JButton("Xem");
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\FPTSHOP\\OneDrive\\Pictures\\Icon\\reload (3) (1).png"));
		btnNewButton.setBackground(Color.DARK_GRAY);
		btnNewButton.setForeground(Color.LIGHT_GRAY);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hienthi();
			}
		});
		btnNewButton.setBounds(879, 451, 115, 37);
		contentPane.add(btnNewButton);
		
		texttimkiem = new JTextField();
		texttimkiem.setFont(new Font("Tahoma", Font.PLAIN, 15));
		texttimkiem.setBounds(126, 394, 310, 35);
		contentPane.add(texttimkiem);
		texttimkiem.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Từ khóa:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(20, 398, 122, 25);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("  Tìm theo:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2.setBounds(10, 465, 115, 23);
		contentPane.add(lblNewLabel_2);
		
	
		
	}
}

