package GiaoDien;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;

public class DocGiaTimKiem extends JFrame {

	private JPanel contentPane;
	private JTextField txtTimKiemSach;
	private JTextField txtMaSach;
	private JTextField txtTenSach;
	private JTextField txtLoaiSach;
	private JTextField txtTacGia;
	private JTextField txtNhaXuatBan;
	private JTextField txtGiaTien;
	private JTextField txtSoLuong;
	private JTable tableSach;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DocGiaTimKiem frame = new DocGiaTimKiem();
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
	public DocGiaTimKiem() {
		setTitle("Đọc Giả Tìm Kiếm");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 763, 455);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNhapMoi = new JButton("Nhập Mới");
		btnNhapMoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NhapMoiSach(e);
			}
		});
		btnNhapMoi.setFont(new Font("Arial", Font.PLAIN, 14));
		btnNhapMoi.setBounds(98, 59, 106, 23);
		contentPane.add(btnNhapMoi);
		
		txtTimKiemSach = new JTextField();
		txtTimKiemSach.setColumns(10);
		txtTimKiemSach.setBounds(248, 59, 188, 25);
		contentPane.add(txtTimKiemSach);
		
		JButton btnTimKiem = new JButton("Tìm Kiếm");
		btnTimKiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TimKiemSach(e);
			}
		});
		btnTimKiem.setFont(new Font("Arial", Font.PLAIN, 14));
		btnTimKiem.setBounds(478, 61, 106, 23);
		contentPane.add(btnTimKiem);
		
		JButton button_2 = new JButton("Quai Lại");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				QuayLai(e);
			}
		});
		button_2.setFont(new Font("Arial", Font.PLAIN, 14));
		button_2.setBounds(633, 10, 106, 23);
		contentPane.add(button_2);
		
		JButton button_3 = new JButton("Refresh");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				duLieuJTable.layDuLieuJtable("SELECT * FROM Sach", tableSach);
			}
		});
		button_3.setFont(new Font("Arial", Font.PLAIN, 14));
		button_3.setBounds(633, 37, 106, 23);
		contentPane.add(button_3);
		
		JLabel label = new JLabel("Mã Sách");
		label.setFont(new Font("Arial", Font.PLAIN, 14));
		label.setBounds(34, 115, 69, 16);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("Tên Sách");
		label_1.setFont(new Font("Arial", Font.PLAIN, 14));
		label_1.setBounds(34, 145, 69, 16);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("Loại Sách");
		label_2.setFont(new Font("Arial", Font.PLAIN, 14));
		label_2.setBounds(34, 180, 69, 16);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("Tác Giả");
		label_3.setFont(new Font("Arial", Font.PLAIN, 14));
		label_3.setBounds(34, 218, 69, 16);
		contentPane.add(label_3);
		
		txtMaSach = new JTextField();
		txtMaSach.setColumns(10);
		txtMaSach.setBounds(113, 106, 179, 25);
		contentPane.add(txtMaSach);
		
		txtTenSach = new JTextField();
		txtTenSach.setColumns(10);
		txtTenSach.setBounds(113, 145, 179, 25);
		contentPane.add(txtTenSach);
		
		txtLoaiSach = new JTextField();
		txtLoaiSach.setColumns(10);
		txtLoaiSach.setBounds(113, 180, 179, 25);
		contentPane.add(txtLoaiSach);
		
		txtTacGia = new JTextField();
		txtTacGia.setColumns(10);
		txtTacGia.setBounds(113, 218, 179, 25);
		contentPane.add(txtTacGia);
		
		JLabel label_4 = new JLabel("Nhà Xuất Bản");
		label_4.setFont(new Font("Arial", Font.PLAIN, 14));
		label_4.setBounds(416, 115, 90, 16);
		contentPane.add(label_4);
		
		JLabel label_5 = new JLabel("Giá Tiền");
		label_5.setFont(new Font("Arial", Font.PLAIN, 14));
		label_5.setBounds(416, 145, 69, 16);
		contentPane.add(label_5);
		
		JLabel label_6 = new JLabel("Số Lượng");
		label_6.setFont(new Font("Arial", Font.PLAIN, 14));
		label_6.setBounds(416, 180, 69, 16);
		contentPane.add(label_6);
		
		txtNhaXuatBan = new JTextField();
		txtNhaXuatBan.setColumns(10);
		txtNhaXuatBan.setBounds(516, 106, 179, 25);
		contentPane.add(txtNhaXuatBan);
		
		txtGiaTien = new JTextField();
		txtGiaTien.setColumns(10);
		txtGiaTien.setBounds(516, 141, 179, 25);
		contentPane.add(txtGiaTien);
		
		txtSoLuong = new JTextField();
		txtSoLuong.setColumns(10);
		txtSoLuong.setBounds(516, 176, 179, 25);
		contentPane.add(txtSoLuong);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 257, 729, 151);
		contentPane.add(scrollPane);
		
		tableSach = new JTable();
		tableSach.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				bamVaoJTableSach(e);
			}
		});
		tableSach.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column", "New column", "New column"
			}
		));
		duLieuJTable.layDuLieuJtable("SELECT * FROM Sach", tableSach);
		scrollPane.setViewportView(tableSach);
	}
	//Nút Quay Lại
	private void QuayLai(ActionEvent e) {
		tuongTac t = new tuongTac();
		t.setVisible(true);
		dispose();
	}
	
	//Nút Tìm Kiếm Sách
	private void TimKiemSach(ActionEvent e) {
		try {
			if(this.txtTimKiemSach.getText().length() == 0) {
				JOptionPane.showMessageDialog(null,"Nhập Nội Dung Tìm Kiếm","Thông Báo",1);
			}
			else
			{
				String sql = "SELECT * from Sach WHERE MaSach like N'%"+this.txtTimKiemSach.getText()+"%' "
	                    + "or TenSach like N'%"+this.txtTimKiemSach.getText()+"%'" +"or LoaiSach like '%"+this.txtTimKiemSach.getText()+"%'"
	                    +"or TacGia like N'%"+this.txtTimKiemSach.getText()+"%'" + "or NhaXuatBan like '%"+this.txtTimKiemSach.getText()+"%'";
	            duLieuJTable.layDuLieuJtable(sql, tableSach);
			}
			
		}catch(Exception e1) {
			
		}
	}
	
	//Bấm Vào JTable Sách
	private void bamVaoJTableSach(MouseEvent e) {
		khongThayDoiTextCuaSach(false);
		try {
			int row = this.tableSach.getSelectedRow();
			String layMaSach = (this.tableSach.getModel().getValueAt(row,0)).toString();
			String sql1 = "SELECT * FROM Sach where MaSach = '" + layMaSach + "'";
			ResultSet rs = duLieuJTable.kiemTraKetNoi(sql1);
			if(rs.next()) {
				this.txtMaSach.setText(rs.getString("MaSach"));
				this.txtTenSach.setText(rs.getString("TenSach"));
				this.txtLoaiSach.setText(rs.getString("LoaiSach"));
				this.txtTacGia.setText(rs.getString("TacGia"));
				this.txtNhaXuatBan.setText(rs.getString("NhaXuatBan"));
				this.txtGiaTien.setText(rs.getString("GiaTien"));
				this.txtSoLuong.setText(rs.getString("SoLuong"));
			}
		}catch(Exception e1) {
			
		}
	}
	
	
	//Nhập Mới Sách
	private void NhapMoiSach(ActionEvent e) {
		this.txtTimKiemSach.setText("");
		this.txtMaSach.setText("");
		this.txtLoaiSach.setText("");
		this.txtTenSach.setText("");
		this.txtTacGia.setText("");
		this.txtNhaXuatBan.setText("");
		this.txtSoLuong.setText("");
		this.txtGiaTien.setText("");
	}
	
	
	//Thiết Lập Xem Có Cho Phép Nhập vào JTable hay không
		private void khongThayDoiTextCuaSach(boolean b) {
			this.txtTenSach.setEnabled(b);
			this.txtMaSach.setEnabled(b);
			this.txtLoaiSach.setEnabled(b);
			this.txtTacGia.setEnabled(b);
			this.txtNhaXuatBan.setEnabled(b);
			this.txtGiaTien.setEnabled(b);
			this.txtSoLuong.setEnabled(b);
		}
}
