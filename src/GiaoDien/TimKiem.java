package GiaoDien;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
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

public class TimKiem extends JFrame {

	private JPanel contentPane;
	private JTextField txtTimKiemDocGia;
	private JTextField txtTaiKhoan;
	private JTextField txtMatKhau;
	private JTextField txtTenDocGia;
	private JTextField txtDiaChi;
	private JTextField txtSoDienThoai;
	private JTextField txtEmail;
	private JTable tableDocGia;
	private JTextField txtTimKiemSach;
	private JTextField txtTimKiemPhieuMuon;
	private JTextField txtMaSach;
	private JTextField txtTenSach;
	private JTextField txtLoaiSach;
	private JTextField txtTacGia;
	private JTextField txtNhaXuatBan;
	private JTextField txtGiaTien;
	private JTextField txtSoLuong;
	private JTable tableSach;
	private JTextField txtMaPhieuMuon;
	private JTextField txtMaDocGia;
	private JTextField txtMaSach1;
	private JTextField txtNgayMuon;
	private JTextField txtHanTraSach;
	private JTextField txtTienCoc;
	private JTable tablePhieuMuon;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TimKiem frame = new TimKiem();
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
	public TimKiem() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 787, 461);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 10, 753, 404);
		contentPane.add(tabbedPane);
		
			
		//Sách
		JPanel panel = new JPanel();
		tabbedPane.addTab("Tìm Kiếm Sách", null, panel, null);
		panel.setLayout(null);
		
		JButton btnNhapMoiSach = new JButton("Nhập Mới");
		btnNhapMoiSach.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NhapMoiSach(e);
			}
		});
		btnNhapMoiSach.setFont(new Font("Arial", Font.PLAIN, 14));
		btnNhapMoiSach.setBounds(118, 46, 106, 23);
		panel.add(btnNhapMoiSach);
		
		txtTimKiemSach = new JTextField();
		txtTimKiemSach.setColumns(10);
		txtTimKiemSach.setBounds(255, 46, 188, 25);
		panel.add(txtTimKiemSach);
		
		JButton btnTimKiemSach = new JButton("Tìm Kiếm");
		btnTimKiemSach.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TimKiemSach(e);
			}
		});
		btnTimKiemSach.setFont(new Font("Arial", Font.PLAIN, 14));
		btnTimKiemSach.setBounds(474, 46, 106, 23);
		panel.add(btnTimKiemSach);
		
		JButton button_2 = new JButton("Quai Lại");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				QuayLai(e);
			}
		});
		button_2.setFont(new Font("Arial", Font.PLAIN, 14));
		button_2.setBounds(642, 0, 106, 23);
		panel.add(button_2);
		
		JLabel lblMSch = new JLabel("Mã Sách");
		lblMSch.setFont(new Font("Arial", Font.PLAIN, 14));
		lblMSch.setBounds(30, 93, 69, 16);
		panel.add(lblMSch);
		
		JLabel lbTenSach = new JLabel("Tên Sách");
		lbTenSach.setFont(new Font("Arial", Font.PLAIN, 14));
		lbTenSach.setBounds(30, 136, 69, 16);
		panel.add(lbTenSach);
		
		JLabel lbLoaiSach = new JLabel("Loại Sách");
		lbLoaiSach.setFont(new Font("Arial", Font.PLAIN, 14));
		lbLoaiSach.setBounds(30, 173, 69, 16);
		panel.add(lbLoaiSach);
		
		JLabel lblTcGi = new JLabel("Tác Giả");
		lblTcGi.setFont(new Font("Arial", Font.PLAIN, 14));
		lblTcGi.setBounds(30, 211, 69, 16);
		panel.add(lblTcGi);
		
		JLabel lblNhXutBn = new JLabel("Nhà Xuất Bản");
		lblNhXutBn.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNhXutBn.setBounds(434, 93, 90, 16);
		panel.add(lblNhXutBn);
		
		JLabel lblGiTin = new JLabel("Giá Tiền");
		lblGiTin.setFont(new Font("Arial", Font.PLAIN, 14));
		lblGiTin.setBounds(434, 136, 69, 16);
		panel.add(lblGiTin);
		
		JLabel lblSLng = new JLabel("Số Lượng");
		lblSLng.setFont(new Font("Arial", Font.PLAIN, 14));
		lblSLng.setBounds(434, 173, 69, 16);
		panel.add(lblSLng);
		
		txtMaSach = new JTextField();
		txtMaSach.setColumns(10);
		txtMaSach.setBounds(118, 90, 179, 25);
		panel.add(txtMaSach);
		
		txtTenSach = new JTextField();
		txtTenSach.setColumns(10);
		txtTenSach.setBounds(118, 133, 179, 25);
		panel.add(txtTenSach);
		
		txtLoaiSach = new JTextField();
		txtLoaiSach.setColumns(10);
		txtLoaiSach.setBounds(118, 170, 179, 25);
		panel.add(txtLoaiSach);
		
		txtTacGia = new JTextField();
		txtTacGia.setColumns(10);
		txtTacGia.setBounds(118, 208, 179, 25);
		panel.add(txtTacGia);
		
		txtNhaXuatBan = new JTextField();
		txtNhaXuatBan.setColumns(10);
		txtNhaXuatBan.setBounds(528, 90, 179, 25);
		panel.add(txtNhaXuatBan);
		
		txtGiaTien = new JTextField();
		txtGiaTien.setColumns(10);
		txtGiaTien.setBounds(528, 133, 179, 25);
		panel.add(txtGiaTien);
		
		txtSoLuong = new JTextField();
		txtSoLuong.setColumns(10);
		txtSoLuong.setBounds(528, 170, 179, 25);
		panel.add(txtSoLuong);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 244, 728, 129);
		panel.add(scrollPane_1);
		
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
		scrollPane_1.setViewportView(tableSach);
		duLieuJTable.layDuLieuJtable("SELECT * FROM Sach", tableSach);
		
		JButton btnRefreshSach = new JButton("Refresh");
		btnRefreshSach.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				duLieuJTable.layDuLieuJtable("SELECT * FROM Sach", tableSach);
			}
		});
		btnRefreshSach.setFont(new Font("Arial", Font.PLAIN, 14));
		btnRefreshSach.setBounds(642, 24, 106, 23);
		panel.add(btnRefreshSach);
		
		
		//Đọc Giả
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Tìm Kiếm Đọc Giả", null, panel_1, null);
		panel_1.setLayout(null);
		
		txtTimKiemDocGia = new JTextField();
		txtTimKiemDocGia.setBounds(234, 44, 188, 25);
		panel_1.add(txtTimKiemDocGia);
		txtTimKiemDocGia.setColumns(10);
		
		JButton btnNhapMoi = new JButton("Nhập Mới");
		btnNhapMoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NhapMoiDocGia(e);
			}
		});
		btnNhapMoi.setFont(new Font("Arial", Font.PLAIN, 14));
		btnNhapMoi.setBounds(106, 44, 106, 23);
		panel_1.add(btnNhapMoi);
		
		JButton btnTimKiem = new JButton("Tìm Kiếm");
		btnTimKiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TimKiemDocGia(e);
			}
		});
		btnTimKiem.setFont(new Font("Arial", Font.PLAIN, 14));
		btnTimKiem.setBounds(443, 46, 106, 23);
		panel_1.add(btnTimKiem);
		
		JLabel lblNewLabel = new JLabel("Tài Khoản");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel.setBounds(36, 117, 69, 16);
		panel_1.add(lblNewLabel);
		
		JLabel lblMtKhu = new JLabel("Mật Khẩu");
		lblMtKhu.setFont(new Font("Arial", Font.PLAIN, 14));
		lblMtKhu.setBounds(36, 152, 69, 16);
		panel_1.add(lblMtKhu);
		
		JLabel lblTncGi = new JLabel("Tên Đọc Giả");
		lblTncGi.setFont(new Font("Arial", Font.PLAIN, 14));
		lblTncGi.setBounds(36, 191, 81, 16);
		panel_1.add(lblTncGi);
		
		JLabel lblaCh = new JLabel("Địa Chỉ");
		lblaCh.setFont(new Font("Arial", Font.PLAIN, 14));
		lblaCh.setBounds(451, 117, 59, 16);
		panel_1.add(lblaCh);
		
		JLabel lblSinThoi = new JLabel("Số Điện Thoại");
		lblSinThoi.setFont(new Font("Arial", Font.PLAIN, 14));
		lblSinThoi.setBounds(451, 155, 98, 16);
		panel_1.add(lblSinThoi);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Arial", Font.PLAIN, 14));
		lblEmail.setBounds(451, 191, 49, 16);
		panel_1.add(lblEmail);
		
		txtTaiKhoan = new JTextField();
		txtTaiKhoan.setBounds(142, 111, 179, 25);
		panel_1.add(txtTaiKhoan);
		txtTaiKhoan.setColumns(10);
		
		txtMatKhau = new JTextField();
		txtMatKhau.setColumns(10);
		txtMatKhau.setBounds(142, 152, 179, 25);
		panel_1.add(txtMatKhau);
		
		txtTenDocGia = new JTextField();
		txtTenDocGia.setColumns(10);
		txtTenDocGia.setBounds(142, 187, 179, 25);
		panel_1.add(txtTenDocGia);
		
		txtDiaChi = new JTextField();
		txtDiaChi.setColumns(10);
		txtDiaChi.setBounds(548, 108, 179, 25);
		panel_1.add(txtDiaChi);
		
		txtSoDienThoai = new JTextField();
		txtSoDienThoai.setColumns(10);
		txtSoDienThoai.setBounds(548, 152, 179, 25);
		panel_1.add(txtSoDienThoai);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(548, 188, 179, 25);
		panel_1.add(txtEmail);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 231, 728, 136);
		panel_1.add(scrollPane);
		
		tableDocGia = new JTable();
		tableDocGia.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				bamVaoJTableDocGia(e);
			}
		});
		tableDocGia.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column", "New column"
			}
		));
		scrollPane.setViewportView(tableDocGia);
		duLieuJTable.layDuLieuJtable("SELECT * FROM DocGia", tableDocGia);
		
		JButton btnQuayLai = new JButton("Quai Lại");
		btnQuayLai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				QuayLai(e);
			}
		});
		btnQuayLai.setFont(new Font("Arial", Font.PLAIN, 14));
		btnQuayLai.setBounds(642, 0, 106, 23);
		panel_1.add(btnQuayLai);
		
		JButton btnRefreshDocGia = new JButton("Refresh");
		btnRefreshDocGia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				duLieuJTable.layDuLieuJtable("SELECT * FROM DocGia", tableDocGia);
			}
		});
		btnRefreshDocGia.setFont(new Font("Arial", Font.PLAIN, 14));
		btnRefreshDocGia.setBounds(642, 25, 106, 23);
		panel_1.add(btnRefreshDocGia);
		
		//Phiếu Mượn
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Tìm Kiếm Phiếu Mượn", null, panel_2, null);
		panel_2.setLayout(null);
		
		JButton button_3 = new JButton("Quai Lại");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				QuayLai(e);
			}
		});
		button_3.setFont(new Font("Arial", Font.PLAIN, 14));
		button_3.setBounds(642, 0, 106, 23);
		panel_2.add(button_3);
		
		JButton button_4 = new JButton("Nhập Mới");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NhapMoiPhieuMuon(e);
			}
		});
		button_4.setFont(new Font("Arial", Font.PLAIN, 14));
		button_4.setBounds(121, 53, 106, 23);
		panel_2.add(button_4);
		
		txtTimKiemPhieuMuon = new JTextField();
		txtTimKiemPhieuMuon.setColumns(10);
		txtTimKiemPhieuMuon.setBounds(257, 53, 188, 25);
		panel_2.add(txtTimKiemPhieuMuon);
		
		JButton button_5 = new JButton("Tìm Kiếm");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TimKiemPhieuMuon(e);
			}
		});
		button_5.setFont(new Font("Arial", Font.PLAIN, 14));
		button_5.setBounds(484, 55, 106, 23);
		panel_2.add(button_5);
		
		JLabel label = new JLabel("Mã Phiếu Mượn");
		label.setFont(new Font("Arial", Font.PLAIN, 14));
		label.setBounds(20, 109, 116, 24);
		panel_2.add(label);
		
		JLabel label_1 = new JLabel("Mã Đọc Giả");
		label_1.setFont(new Font("Arial", Font.PLAIN, 14));
		label_1.setBounds(20, 145, 116, 24);
		panel_2.add(label_1);
		
		JLabel label_2 = new JLabel("Mã Sách");
		label_2.setFont(new Font("Arial", Font.PLAIN, 14));
		label_2.setBounds(20, 179, 116, 24);
		panel_2.add(label_2);
		
		JLabel label_3 = new JLabel("Ngày Mượn");
		label_3.setFont(new Font("Arial", Font.PLAIN, 14));
		label_3.setBounds(397, 109, 95, 24);
		panel_2.add(label_3);
		
		JLabel label_4 = new JLabel("Hạn Trả Sách");
		label_4.setFont(new Font("Arial", Font.PLAIN, 14));
		label_4.setBounds(397, 145, 95, 24);
		panel_2.add(label_4);
		
		JLabel label_5 = new JLabel("Tiền Cọc");
		label_5.setFont(new Font("Arial", Font.PLAIN, 14));
		label_5.setBounds(397, 179, 91, 24);
		panel_2.add(label_5);
		
		txtMaPhieuMuon = new JTextField();
		txtMaPhieuMuon.setColumns(10);
		txtMaPhieuMuon.setBounds(146, 111, 198, 23);
		panel_2.add(txtMaPhieuMuon);
		
		txtMaDocGia = new JTextField();
		txtMaDocGia.setColumns(10);
		txtMaDocGia.setBounds(146, 145, 198, 23);
		panel_2.add(txtMaDocGia);
		
		txtMaSach1 = new JTextField();
		txtMaSach1.setColumns(10);
		txtMaSach1.setBounds(146, 180, 198, 23);
		panel_2.add(txtMaSach1);
		
		txtNgayMuon = new JTextField();
		txtNgayMuon.setColumns(10);
		txtNgayMuon.setBounds(502, 109, 198, 23);
		panel_2.add(txtNgayMuon);
		
		txtHanTraSach = new JTextField();
		txtHanTraSach.setColumns(10);
		txtHanTraSach.setBounds(502, 145, 198, 23);
		panel_2.add(txtHanTraSach);
		
		txtTienCoc = new JTextField();
		txtTienCoc.setColumns(10);
		txtTienCoc.setBounds(502, 180, 198, 23);
		panel_2.add(txtTienCoc);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 229, 728, 138);
		panel_2.add(scrollPane_2);
		
		tablePhieuMuon = new JTable();
		tablePhieuMuon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				BamVaoJTableMuonSach(e);
			}
		});
		tablePhieuMuon.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column", "New column"
			}
		));
		scrollPane_2.setViewportView(tablePhieuMuon);
		duLieuJTable.layDuLieuJtable("SELECT * FROM MuonSach", tablePhieuMuon);
		
		JButton btnRefreshPhieuMuon = new JButton("Refresh");
		btnRefreshPhieuMuon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				duLieuJTable.layDuLieuJtable("SELECT * FROM MuonSach", tablePhieuMuon);
			}
		});
		btnRefreshPhieuMuon.setFont(new Font("Arial", Font.PLAIN, 14));
		btnRefreshPhieuMuon.setBounds(642, 25, 106, 23);
		panel_2.add(btnRefreshPhieuMuon);
	}
	
	
	//Nút Quay Lại
	private void QuayLai(ActionEvent e) {
		tuongTac t = new tuongTac();
		t.setVisible(true);
		dispose();
	}
	
	
	//Nút Nhập Mới Đọc Giả 
	private void NhapMoiDocGia(ActionEvent e) {
		this.txtTimKiemDocGia.setText("");
		this.txtTaiKhoan.setText("");
		this.txtMatKhau.setText("");
		this.txtTenDocGia.setText("");
		this.txtDiaChi.setText("");
		this.txtSoDienThoai.setText("");
		this.txtEmail.setText("");	
	}
	
	
	//Nút Nhập Mới Sách
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
	
	
	//Nút Nhập Mới Phiếu Mượn
	private void NhapMoiPhieuMuon(ActionEvent e) {
		this.txtMaPhieuMuon.setText("");
		this.txtMaSach1.setText("");
		this.txtMaDocGia.setText("");
		this.txtNgayMuon.setText("");
		this.txtHanTraSach.setText("");
		this.txtTienCoc.setText("");
	}
	
	//Bấm vào JTable Sách
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
	
	//Bấm Vào JTable Đọc Giả
	private void bamVaoJTableDocGia(MouseEvent e) {
		khongThayDoiTextDocGia(false);
		try {
			int row = this.tableDocGia.getSelectedRow();
			String layTaiKhoanDocGia = (this.tableDocGia.getModel().getValueAt(row,0)).toString();
			String sql1 = "SELECT * FROM DocGia where TaiKhoan = '" + layTaiKhoanDocGia + "'";
			ResultSet rs = duLieuJTable.kiemTraKetNoi(sql1);
			if(rs.next()) {
				this.txtTaiKhoan.setText(rs.getString("TaiKhoan"));
				this.txtMatKhau.setText(rs.getString("MatKhau"));
				this.txtTenDocGia.setText(rs.getString("TenDocGia"));
				this.txtSoDienThoai.setText(rs.getString("SoDienThoai"));
				this.txtDiaChi.setText(rs.getString("DiaChi"));
				this.txtEmail.setText(rs.getString("Email"));
			}
		}catch(Exception e1) {
			
		}
	}
	
	//Bấm Vào JTable Mượn Sách
	private void BamVaoJTableMuonSach(MouseEvent e) {
		khongThayDoiTextCuaPhieuMuon(false);
		try {
			int row = this.tablePhieuMuon.getSelectedRow();
			String layMaPhieuMuon = (this.tablePhieuMuon.getModel().getValueAt(row,0)).toString();
			String sql1 = "SELECT * FROM MuonSach WHERE MaPhieuMuon = '" + layMaPhieuMuon + "'";
			ResultSet rs = duLieuJTable.kiemTraKetNoi(sql1);
			if(rs.next()) {
				this.txtMaPhieuMuon.setText(rs.getString("MaPhieuMuon"));
				this.txtMaDocGia.setText(rs.getString("MaDocGia"));
				this.txtMaSach1.setText(rs.getString("MaSach"));
				this.txtNgayMuon.setText(rs.getString("NgayMuon"));
				this.txtHanTraSach.setText(rs.getString("HanTra"));
				this.txtTienCoc.setText(rs.getString("TienCoc"));
			}
		}catch(Exception e1) {
			
		}
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
	
	
	//Nút Tìm Kiếm Đọc Giả
	private void TimKiemDocGia(ActionEvent e) {
		try {
			if(this.txtTimKiemDocGia.getText().length() == 0) {
				JOptionPane.showMessageDialog(null,"Nhập Nội Dung Tìm Kiếm","Thông Báo",1);
			}
			else
			{
				String sql = "SELECT * from DocGia WHERE TaiKhoan like N'%"+this.txtTimKiemDocGia.getText()+"%' "
	                    + "or TenDocGia like N'%"+this.txtTimKiemDocGia.getText()+"%'" + "or SoDienThoai like '%"+this.txtTimKiemDocGia.getText()+"%'"
	                    +"or Email like N'%"+this.txtTimKiemDocGia.getText()+"%'";
	            duLieuJTable.layDuLieuJtable(sql, tableDocGia);
			}
			
		}catch(Exception e1) {
			
		}
	}
	
	
	//Nút Tìm kiếm Phiếu Mượn
	private void TimKiemPhieuMuon(ActionEvent e) {
		try {
			if(this.txtTimKiemPhieuMuon.getText().length() == 0) {
				JOptionPane.showMessageDialog(null,"Nhập Nội Dung Tìm Kiếm","Thông Báo",1);
			}
			else
			{
				String sql = "SELECT * from MuonSach WHERE MaPhieuMuon like N'%"+this.txtTimKiemPhieuMuon.getText()+"%' "
	                   + "or MaDocGia like N'%"+this.txtTimKiemPhieuMuon.getText()+"%'" + "or MaSach like '%"+this.txtTimKiemPhieuMuon.getText()+"%'";
	            duLieuJTable.layDuLieuJtable(sql, tablePhieuMuon);
			}
			
		}catch(Exception e1) {
			
		}
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
	
	private void khongThayDoiTextDocGia(boolean b) {
		this.txtDiaChi.setEnabled(b);
		this.txtEmail.setEnabled(b);
		this.txtMatKhau.setEnabled(b);
		this.txtSoDienThoai.setEnabled(b);
		this.txtTaiKhoan.setEnabled(b);
		this.txtTenDocGia.setEnabled(b);
	}
	
	private void khongThayDoiTextCuaPhieuMuon(boolean b) {
		this.txtMaPhieuMuon.setEnabled(b);
		this.txtMaDocGia.setEnabled(b);
		this.txtMaSach1.setEnabled(b);
		this.txtNgayMuon.setEnabled(b);
		this.txtHanTraSach.setEnabled(b);
		this.txtTienCoc.setEnabled(b);
	}
}
