
package GiaoDien;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import Data.Connect;
import Data.DocGiaData;
import Data.PhieuMuonData;
import Data.SachData;
import Object.DocGia;
import Object.PhieuMuon;
import Object.Sach;
import net.proteanit.sql.DbUtils;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.ParseException;
import java.util.Date;

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

public class ThuThuCapNhap extends JFrame {

	private JPanel contentPane;
	private JTextField txtMatKhau;
	private JTextField txtTenDocGia;
	private JTextField txtTaiKhoan;
	private JTextField txtDiaChi;
	private JTextField txtSoDienThoai;
	private JTextField txtEmail;
	private JTable tableDocGia;
	private JButton btnThem,btnSua,btnXoa,btnThemDocGia;
	private JButton btnRefresh;
	private JButton btnSuaDocGia;
	private JTabbedPane tabbedPane;
	private JPanel panel;
	private JLabel lbMaDocGia;
	private JLabel lbDiaChi;
	private JLabel lbMatKhau;
	private JLabel lbSoDienThoai;
	private JLabel lbTenDocGia;
	private JLabel lbEmail;
	private JScrollPane scrollPane;
	private JPanel panel_1;
	private JButton btnThemSach;
	private JButton btnThem1;
	private JButton btnSuaSach;
	private JButton btnSua1;
	private JButton btnXoaSach;
	private JButton btnRefresh1;
	private JButton btnQuayLaiS;
	private JTextField txtMaSach;
	private JTextField txtTenSach;
	private JTextField txtLoaiSach;
	private JTextField txtTacGia;
	private JTextField txtNhaXuatBan;
	private JTextField txtGiaTien;
	private JTextField txtSoLuong;
	private JScrollPane scrollPane_1;
	private JTable tableSach;
	private JButton btnQuayLaiPM;
	private JTextField txtMaPhieuMuon;
	private JTextField txtMaDocGia1;
	private JTextField txtMaSach1;
	private JTextField txtNgayMuon;
	private JTextField txtHanTra;
	private JTable tablePhieuMuon;
	private JPanel panel_2;
	private JButton btnThemPhieuMuon;
	private JButton btnThem2;
	private JButton btnSuaPhieuMuon;
	private JButton btnSua2;
	private JButton btnRefresh2;
	private JButton btnXoaPhieuMuon;
	private JLabel lbMaPhieuMuon;
	private JLabel lbMaDocGia1;
	private JLabel lbMaSach1;
	private JLabel lbNgayMuon;
	private JLabel lbHanTra;
	private JScrollPane scrollPane_2 ;
	private JTextField txtTienCoc;
	private JLabel labelTienCoc;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ThuThuCapNhap frame = new ThuThuCapNhap();
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
	public ThuThuCapNhap() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		initComponents();
		DocGiaOP(false);
		SachOP(false);
		PhieuMuonOP(false);
		this.btnRefresh.setEnabled(true);
		this.btnRefresh1.setEnabled(true);
		this.btnRefresh2.setEnabled(true);
		
	}
	
	
	private void initComponents() {
		setBounds(100, 100, 875, 587);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		
		// Tạo Jtab(Có Tác dụng là tạo nhiều tab trong 1 cái giao diẹn)
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 5, 839, 513);
		contentPane.add(tabbedPane);
		
		
		//Tạo Jtable Cập Nhập Độc Giả
		panel = new JPanel();
		tabbedPane.addTab("Cập Nhập Độc Giả", null, panel, null);
		panel.setLayout(null);
		
		
		//Các button tương tác trong Jpanel Cập Nhập Độc Giả
		btnThem = new JButton("Thêm");
		btnThem.setBounds(43, 74, 85, 27);
		panel.add(btnThem);
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ThemDocGia(e);
			}
		});
		btnThem.setFont(new Font("Arial", Font.PLAIN, 16));
		
		
		btnThemDocGia = new JButton("Thêm Độc Giả");
		btnThemDocGia.setBounds(10, 29, 150, 27);
		panel.add(btnThemDocGia);
		btnThemDocGia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ThemMoi(e);
			}
		});
		btnThemDocGia.setFont(new Font("Arial", Font.PLAIN, 14));
		
		
		btnSuaDocGia = new JButton("Sửa Độc Giả");
		btnSuaDocGia.setBounds(319, 29, 150, 27);
		panel.add(btnSuaDocGia);
		btnSuaDocGia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SuaThongTinDocGia(e);
			}
		});
		btnSuaDocGia.setFont(new Font("Arial", Font.PLAIN, 14));
		
		
		btnSua = new JButton("Sửa");
		btnSua.setBounds(355, 74, 73, 27);
		panel.add(btnSua);
		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnSua(e);
			}
		});
		btnSua.setFont(new Font("Arial", Font.PLAIN, 16));
		
		
		btnXoa = new JButton("Xóa");
		btnXoa.setBounds(655, 74, 73, 27);
		panel.add(btnXoa);
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				XoaDocGia(e);
			}
		});
		btnXoa.setFont(new Font("Arial", Font.PLAIN, 16));
		

		JButton btnNewButton = new JButton("Quay Lại");
		btnNewButton.setBounds(749, 0, 85, 23);
		panel.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				QuayLai(e);
			}
		});
		
		
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 12));
		btnRefresh = new JButton("Refresh");
		btnRefresh.setBounds(629, 28, 114, 27);
		panel.add(btnRefresh);
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				duLieuJTable.layDuLieuJtable("SELECT * FROM DocGia", tableDocGia);				
			}
		});
		btnRefresh.setFont(new Font("Arial", Font.PLAIN, 16));
		btnRefresh.setEnabled(false);
		
		
		//Nơi Tương Tác Thông Tin Đọc Giả
		lbMaDocGia = new JLabel("Tài Khoản");
		lbMaDocGia.setBounds(10, 121, 66, 26);
		panel.add(lbMaDocGia);
		lbMaDocGia.setFont(new Font("Arial", Font.PLAIN, 14));
		
		
		txtTaiKhoan = new JTextField();
		txtTaiKhoan.setBounds(148, 123, 195, 25);
		panel.add(txtTaiKhoan);
		txtTaiKhoan.setColumns(10);
		
		
		lbDiaChi = new JLabel("Địa Chỉ");
		lbDiaChi.setBounds(473, 122, 76, 25);
		panel.add(lbDiaChi);
		lbDiaChi.setFont(new Font("Arial", Font.PLAIN, 14));
		
		
		txtDiaChi = new JTextField();
		txtDiaChi.setBounds(598, 123, 195, 25);
		panel.add(txtDiaChi);
		txtDiaChi.setColumns(10);
		
		
		lbMatKhau = new JLabel("Mật Khẩu");
		lbMatKhau.setBounds(10, 168, 66, 25);
		panel.add(lbMatKhau);
		lbMatKhau.setFont(new Font("Arial", Font.PLAIN, 14));
		
		
		txtMatKhau = new JTextField();
		txtMatKhau.setBounds(148, 169, 195, 25);
		panel.add(txtMatKhau);
		txtMatKhau.setColumns(10);
		
		
		lbSoDienThoai = new JLabel("Số Điện Thoại");
		lbSoDienThoai.setBounds(473, 168, 91, 25);
		panel.add(lbSoDienThoai);
		lbSoDienThoai.setFont(new Font("Arial", Font.PLAIN, 14));
		
		
		txtSoDienThoai = new JTextField();
		txtSoDienThoai.setBounds(598, 169, 195, 25);
		panel.add(txtSoDienThoai);
		txtSoDienThoai.setColumns(10);
		
		
		lbTenDocGia = new JLabel("Tên Độc Giả");
		lbTenDocGia.setBounds(10, 221, 103, 25);
		panel.add(lbTenDocGia);
		lbTenDocGia.setFont(new Font("Arial", Font.PLAIN, 14));
		
		
		txtTenDocGia = new JTextField();
		txtTenDocGia.setBounds(148, 222, 195, 25);
		panel.add(txtTenDocGia);
		txtTenDocGia.setColumns(10);
		
		
		lbEmail = new JLabel("Email");
		lbEmail.setBounds(473, 221, 76, 25);
		panel.add(lbEmail);
		lbEmail.setFont(new Font("Arial", Font.PLAIN, 14));

		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 280, 815, 196);
		panel.add(scrollPane);
		
		
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
				"Tài Khoản", "Mật Khẩu", "Tên Độc Giả", "Địa Chỉ", "Số Điện Thoại", "Email"
			}
		));
		
		
		scrollPane.setViewportView(tableDocGia);
		duLieuJTable.layDuLieuJtable("SELECT * FROM DocGia", tableDocGia);
		
		
		txtEmail = new JTextField();
		txtEmail.setBounds(598, 222, 195, 25);
		panel.add(txtEmail);
		txtEmail.setColumns(10);
		
		
		//JPanel Cập Nhập Sách
		panel_1 = new JPanel();
		tabbedPane.addTab("Cập Nhập Sách", null, panel_1, null);
		
		
		btnThemSach = new JButton("Thêm Sách");
		btnThemSach.setBounds(32, 27, 126, 25);
		btnThemSach.setFont(new Font("Arial", Font.PLAIN, 14));
		btnThemSach.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ThemMoiSach(e);
			}
		});
		panel_1.setLayout(null);
		panel_1.add(btnThemSach);
		
		
		btnThem1 = new JButton("Thêm");
		btnThem1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ThemSach(e);
			}
		});
		btnThem1.setBounds(46, 80, 76, 25);
		btnThem1.setFont(new Font("Arial", Font.PLAIN, 14));
		panel_1.add(btnThem1);
		
		
		btnSuaSach = new JButton("Sửa Thông Tin Sách");
		btnSuaSach.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SuaThongTinSach(e);
			}
		});
		btnSuaSach.setBounds(296, 27, 186, 25);
		btnSuaSach.setFont(new Font("Arial", Font.PLAIN, 14));
		panel_1.add(btnSuaSach);
		
		
		btnSua1 = new JButton("Sửa");
		btnSua1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SuaSach(e);
			}
		});
		btnSua1.setBounds(323, 80, 107, 25);
		btnSua1.setEnabled(false);
		btnSua1.setFont(new Font("Arial", Font.PLAIN, 14));
		panel_1.add(btnSua1);
		
		btnXoaSach = new JButton("Xóa Sách");
		btnXoaSach.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				XoaSach(e);
			}
		});
		btnXoaSach.setBounds(665, 80, 107, 25);
		btnXoaSach.setFont(new Font("Arial", Font.PLAIN, 14));
		panel_1.add(btnXoaSach);
		
		
		btnRefresh1 = new JButton("Refresh");
		btnRefresh1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				duLieuJTable.layDuLieuJtable("SELECT * FROM Sach", tableSach);	
			}
		});
		btnRefresh1.setBounds(665, 30, 107, 25);
		btnRefresh1.setFont(new Font("Arial", Font.PLAIN, 14));
		panel_1.add(btnRefresh1);
		
		
		btnQuayLaiS = new JButton("Quay Lại");
		btnQuayLaiS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				QuayLai(e);
			}
		});
		btnQuayLaiS.setBounds(732, 0, 102, 25);
		btnQuayLaiS.setFont(new Font("Arial", Font.PLAIN, 12));
		panel_1.add(btnQuayLaiS);
		
		JLabel lbMaSach = new JLabel("Mã Sách");
		lbMaSach.setBounds(32, 159, 76, 25);
		lbMaSach.setFont(new Font("Arial", Font.PLAIN, 14));
		panel_1.add(lbMaSach);
		
		JLabel lbTenSach = new JLabel("Tên Sách");
		lbTenSach.setBounds(32, 194, 76, 25);
		lbTenSach.setFont(new Font("Arial", Font.PLAIN, 14));
		panel_1.add(lbTenSach);
		
		JLabel lbLoaiSach = new JLabel("Loại Sách");
		lbLoaiSach.setBounds(32, 229, 76, 25);
		lbLoaiSach.setFont(new Font("Arial", Font.PLAIN, 14));
		panel_1.add(lbLoaiSach);
		
		JLabel lbNhaXuatBan = new JLabel("Nhà Xuất Bản");
		lbNhaXuatBan.setBounds(441, 159, 102, 25);
		lbNhaXuatBan.setFont(new Font("Arial", Font.PLAIN, 14));
		panel_1.add(lbNhaXuatBan);
		
		JLabel lbGiaTien = new JLabel("Giá Tiền");
		lbGiaTien.setBounds(441, 194, 76, 25);
		lbGiaTien.setFont(new Font("Arial", Font.PLAIN, 14));
		panel_1.add(lbGiaTien);
		
		JLabel lbSoLuong = new JLabel("Số Lượng");
		lbSoLuong.setBounds(441, 229, 76, 25);
		lbSoLuong.setFont(new Font("Arial", Font.PLAIN, 14));
		panel_1.add(lbSoLuong);
		
		JLabel lbTacGia = new JLabel("Tác Giả");
		lbTacGia.setBounds(32, 264, 76, 25);
		lbTacGia.setFont(new Font("Arial", Font.PLAIN, 14));
		panel_1.add(lbTacGia);
		
		txtMaSach = new JTextField();
		txtMaSach.setBounds(130, 159, 222, 25);
		panel_1.add(txtMaSach);
		txtMaSach.setColumns(10);
		
		txtTenSach = new JTextField();
		txtTenSach.setBounds(130, 194, 222, 25);
		txtTenSach.setColumns(10);
		panel_1.add(txtTenSach);
		
		txtLoaiSach = new JTextField();
		txtLoaiSach.setBounds(130, 230, 222, 25);
		txtLoaiSach.setColumns(10);
		panel_1.add(txtLoaiSach);
		
		txtTacGia = new JTextField();
		txtTacGia.setBounds(130, 264, 222, 25);
		txtTacGia.setColumns(10);
		panel_1.add(txtTacGia);
		
		txtNhaXuatBan = new JTextField();
		txtNhaXuatBan.setBounds(564, 159, 222, 25);
		txtNhaXuatBan.setColumns(10);
		panel_1.add(txtNhaXuatBan);
		
		txtGiaTien = new JTextField();
		txtGiaTien.setBounds(564, 195, 222, 25);
		txtGiaTien.setColumns(10);
		panel_1.add(txtGiaTien);
		
		txtSoLuong = new JTextField();
		txtSoLuong.setBounds(564, 233, 222, 25);
		txtSoLuong.setColumns(10);
		panel_1.add(txtSoLuong);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 299, 814, 177);
		panel_1.add(scrollPane_1);
		
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
				"Mã Sách", "Tên Sách", "Loại Sách", "Tác Giả", "Nhà Xuất Bản", "Giá Tiền", "Số Lượng"
			}
		));
		
		scrollPane_1.setViewportView(tableSach);
		duLieuJTable.layDuLieuJtable("SELECT * FROM Sach", tableSach);
		
		
		//Cập Nhập Phiếu Mượn
		panel_2 = new JPanel();
		tabbedPane.addTab("Cập Nhập Phiếu Mượn", null, panel_2, null);
		panel_2.setLayout(null);
		
		btnThemPhieuMuon = new JButton("Thêm Phiếu Mượn");
		btnThemPhieuMuon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ThemMoiPhieuMuon(e);
			}
		});
		btnThemPhieuMuon.setFont(new Font("Arial", Font.PLAIN, 14));
		btnThemPhieuMuon.setBounds(31, 52, 163, 31);
		panel_2.add(btnThemPhieuMuon);
		
		btnThem2 = new JButton("Thêm");
		btnThem2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnThemJTablePhieuMuon(e);
			}
		});
		btnThem2.setFont(new Font("Arial", Font.PLAIN, 14));
		btnThem2.setBounds(58, 108, 83, 31);
		panel_2.add(btnThem2);
		
		btnSuaPhieuMuon = new JButton("Sửa Phiếu Mượn");
		btnSuaPhieuMuon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SuaPhieuMuon(e);
			}
		});
		btnSuaPhieuMuon.setFont(new Font("Arial", Font.PLAIN, 14));
		btnSuaPhieuMuon.setBounds(323, 52, 153, 31);
		panel_2.add(btnSuaPhieuMuon);
		
		btnSua2 = new JButton("Sửa");
		btnSua2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnSuaPhieuMuon(e);
			}
		});
		btnSua2.setFont(new Font("Arial", Font.PLAIN, 14));
		btnSua2.setBounds(364, 108, 83, 31);
		panel_2.add(btnSua2);
		
		btnRefresh2 = new JButton("Refresh");
		btnRefresh2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				duLieuJTable.layDuLieuJtable("SELECT * FROM MuonSach", tablePhieuMuon);
			}
		});
		btnRefresh2.setFont(new Font("Arial", Font.PLAIN, 14));
		btnRefresh2.setBounds(648, 108, 95, 31);
		panel_2.add(btnRefresh2);
		
		btnXoaPhieuMuon = new JButton("Xóa Phiếu");
		btnXoaPhieuMuon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				xoaPhieuMuon(e);
			}
		});
		btnXoaPhieuMuon.setFont(new Font("Arial", Font.PLAIN, 14));
		btnXoaPhieuMuon.setBounds(629, 52, 123, 31);
		panel_2.add(btnXoaPhieuMuon);
		
		btnQuayLaiPM = new JButton("Quay Lại");
		btnQuayLaiPM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				QuayLai(e);
			}
		});
		btnQuayLaiPM.setFont(new Font("Arial", Font.PLAIN, 12));
		btnQuayLaiPM.setBounds(739, 0, 95, 31);
		panel_2.add(btnQuayLaiPM);
		
		lbMaPhieuMuon = new JLabel("Mã Phiếu Mượn");
		lbMaPhieuMuon.setFont(new Font("Arial", Font.PLAIN, 14));
		lbMaPhieuMuon.setBounds(31, 191, 116, 24);
		panel_2.add(lbMaPhieuMuon);
		
		lbMaDocGia1 = new JLabel("Mã Đọc Giả");
		lbMaDocGia1.setFont(new Font("Arial", Font.PLAIN, 14));
		lbMaDocGia1.setBounds(31, 225, 116, 24);
		panel_2.add(lbMaDocGia1);
		
		lbMaSach1 = new JLabel("Mã Sách");
		lbMaSach1.setFont(new Font("Arial", Font.PLAIN, 14));
		lbMaSach1.setBounds(31, 259, 116, 24);
		panel_2.add(lbMaSach1);
		
		lbNgayMuon = new JLabel("Ngày Mượn");
		lbNgayMuon.setFont(new Font("Arial", Font.PLAIN, 14));
		lbNgayMuon.setBounds(469, 191, 95, 24);
		panel_2.add(lbNgayMuon);
		
		lbHanTra = new JLabel("Hạn Trả Sách");
		lbHanTra.setFont(new Font("Arial", Font.PLAIN, 14));
		lbHanTra.setBounds(469, 225, 95, 24);
		panel_2.add(lbHanTra);
		
		labelTienCoc = new JLabel("Tiền Cọc");
		labelTienCoc.setFont(new Font("Arial", Font.PLAIN, 14));
		labelTienCoc.setBounds(469, 266, 91, 24);
		panel_2.add(labelTienCoc);
		
		txtMaPhieuMuon = new JTextField();
		txtMaPhieuMuon.setBounds(172, 193, 198, 23);
		panel_2.add(txtMaPhieuMuon);
		txtMaPhieuMuon.setColumns(10);
		
		txtMaDocGia1 = new JTextField();
		txtMaDocGia1.setColumns(10);
		txtMaDocGia1.setBounds(172, 227, 198, 23);
		panel_2.add(txtMaDocGia1);
		
		txtMaSach1 = new JTextField();
		txtMaSach1.setColumns(10);
		txtMaSach1.setBounds(172, 260, 198, 23);
		panel_2.add(txtMaSach1);
		
		txtNgayMuon = new JTextField();
		txtNgayMuon.setColumns(10);
		txtNgayMuon.setBounds(570, 195, 198, 23);
		panel_2.add(txtNgayMuon);
		
		txtHanTra = new JTextField();
		txtHanTra.setColumns(10);
		txtHanTra.setBounds(570, 229, 198, 23);
		panel_2.add(txtHanTra);
		
		txtTienCoc = new JTextField();
		txtTienCoc.setColumns(10);
		txtTienCoc.setBounds(570, 263, 198, 23);
		panel_2.add(txtTienCoc);
		
		scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 302, 814, 174);
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
				"M\u00E3 Phi\u1EBFu M\u01B0\u1EE3n", "M\u00E3 Kh\u00E1ch H\u00E0ng", "M\u00E3 S\u00E1ch", "Ng\u00E0y M\u01B0\u1EE3n", "H\u1EA1n Tr\u1EA3", "Tiền Trả"
			}
		));
		duLieuJTable.layDuLieuJtable("SELECT * FROM MuonSach", tablePhieuMuon);
		scrollPane_2.setViewportView(tablePhieuMuon);

		contentPane.setLayout(null);
				
	}
	
	//Nút Quay Lại
	private void QuayLai(ActionEvent e) {
		tuongTac t = new tuongTac();
		t.setVisible(true);
		dispose();
	}

	
	//Bấm nào Jtable của Đọc Giả
	private void bamVaoJTableDocGia(MouseEvent e) {
		DocGiaOP(true);
		this.btnThem.setEnabled(false);
		this.btnSua.setEnabled(false);
		khongThayDoiText(false);
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
	
	//Bấm Vào Jtable Sách
	private void bamVaoJTableSach(MouseEvent e) {
		SachOP(true);
		this.btnThem1.setEnabled(false);
		this.btnSua1.setEnabled(false);
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
	
	//Bấm Vào JTable Mượn Sách
	private void BamVaoJTableMuonSach(MouseEvent e) {
		PhieuMuonOP(true);
		this.btnThem2.setEnabled(false);
		this.btnSua2.setEnabled(false);
		khongThayDoiTextCuaPhieuMuon(false);
		try {
			int row = this.tablePhieuMuon.getSelectedRow();
			String layMaPhieuMuon = (this.tablePhieuMuon.getModel().getValueAt(row,0)).toString();
			String sql1 = "SELECT * FROM MuonSach WHERE MaPhieuMuon = '" + layMaPhieuMuon + "'";
			ResultSet rs = duLieuJTable.kiemTraKetNoi(sql1);
			if(rs.next()) {
				this.txtMaPhieuMuon.setText(rs.getString("MaPhieuMuon"));
				this.txtMaDocGia1.setText(rs.getString("MaDocGia"));
				this.txtMaSach1.setText(rs.getString("MaSach"));
				this.txtNgayMuon.setText(rs.getString("NgayMuon"));
				this.txtHanTra.setText(rs.getString("HanTra"));
				this.txtTienCoc.setText(rs.getString("TienCoc"));
			}
		}catch(Exception e1) {
			
		}
	}
	//Xóa Đọc Giả
	private void XoaDocGia(ActionEvent e) {
		try {
			if(DocGiaData.XoaDocGia(this.txtTaiKhoan.getText())) {
				JOptionPane.showMessageDialog(null, "Xóa Thành Công", "Thông Báo", 1);
				duLieuJTable.layDuLieuJtable("SELECT * FROM DocGia", tableDocGia);
			}
			else
				JOptionPane.showMessageDialog(null, "Xóa Không Thành công", "Thông Báo", 1);
		}catch(Exception e1) {
			JOptionPane.showMessageDialog(null, "Eroor", "Thông Báo", 1);
		}
	}
	
	//Xoá Sách
	private void XoaSach(ActionEvent e) {
		try {
			if(SachData.XoaSach(this.txtMaSach.getText())) {
				JOptionPane.showMessageDialog(null, "Xóa Thành Công", "Thông Báo", 1);
				duLieuJTable.layDuLieuJtable("SELECT * FROM Sach", tableSach);
			}
			else
				JOptionPane.showMessageDialog(null, "Xóa Không Thành công", "Thông Báo", 1);
		}catch(Exception e1) {
			JOptionPane.showMessageDialog(null, "Eroor", "Thông Báo", 1);
		}
	}
	
	//Xóa Phiếu Mượn
	private void xoaPhieuMuon(ActionEvent e) {
		try {
			if(PhieuMuonData.XoaPhieuMuon(this.txtMaPhieuMuon.getText())) {
				JOptionPane.showMessageDialog(null, "Xóa Thành Công", "Thông Báo", 1);
				duLieuJTable.layDuLieuJtable("SELECT * FROM MuonSach", tablePhieuMuon);
			}
			else
				JOptionPane.showMessageDialog(null, "Xóa Không Thành công", "Thông Báo", 1);
		}catch(Exception e1) {
			JOptionPane.showMessageDialog(null, "Eroor", "Thông Báo", 1);
		}
	}
	
	
	//Nút Thêm Đọc Giả cuả JTable DocGia
	private void ThemMoi(ActionEvent e) {
		DocGiaOP(true);
		khongThayDoiText(true);
		this.btnSua.setEnabled(false);
		this.btnXoa.setEnabled(false);
		resetTextboxDocGia();
	}
	
	//Nút Thêm Sách của JTable Sach
	private void ThemMoiSach(ActionEvent e) {
		SachOP(true);
		khongThayDoiTextCuaSach(true);
		this.btnSua1.setEnabled(false);
		this.btnXoaSach.setEnabled(false);
		resetTextBoxSach();
		
	}
	
	//Nút Thêm Phiếu Mượn của JTable Phiếu mượn
	private void ThemMoiPhieuMuon(ActionEvent e) {
		PhieuMuonOP(true);
		khongThayDoiTextCuaPhieuMuon(true);
		this.btnSua2.setEnabled(false);
		this.btnXoaPhieuMuon.setEnabled(false);
		resetTextBoxPhieuMuon();
	}
	
	//Nút Thêm JTable Đọc Giả
	private void ThemDocGia(ActionEvent e) {
		try {
			if(this.txtTaiKhoan.getText().length() == 0 || this.txtMatKhau.getText().length() == 0){
				JOptionPane.showMessageDialog(null, "Tài Khoản Hoặc Mật Khẩu Không Được Bỏ Trống", "Thông Báo", 1);
				return;
			}
			else if(this.txtTaiKhoan.getText().length() > 10 || this.txtMatKhau.getText().length() > 10) {
				JOptionPane.showMessageDialog(null, "Tài Khoản Hoặc Mật Khẩu Không Được Quá 10 Ký Tự", "Thông Báo", 1);
				return;
			}
			else
			{
				DocGia dg = new DocGia(this.txtTaiKhoan.getText(),this.txtMatKhau.getText(),this.txtTenDocGia.getText(),
						this.txtDiaChi.getText(),this.txtSoDienThoai.getText(),this.txtEmail.getText());
				DocGiaData.ThemDocGia(dg);
				ThemMoi(e);
				duLieuJTable.layDuLieuJtable("SELECT * FROM DocGia", tableDocGia);
			}
		}catch(Exception e1) {
			JOptionPane.showMessageDialog(null, "Thêm Không Thành Công", "Thông Báo", 1);
		}
	}
	
	//Nút Thêm JTable Sách
		private void ThemSach(ActionEvent e) {
			try {
				if(this.txtMaSach.getText().length() == 0){
					JOptionPane.showMessageDialog(null, "Mã Sách Không Được Bỏ Trống", "Thông Báo", 1);
					return;
				}
				else if(this.txtMaSach.getText().length() > 10) {
					JOptionPane.showMessageDialog(null, "Mã Sách Không Được Quá 10 Ký Tự", "Thông Báo", 1);
					return;
					
				}
				
				
				else
				{
					Sach s = new Sach(this.txtMaSach.getText(), this.txtTenSach.getText(), this.txtLoaiSach.getText(),this.txtTacGia.getText(),
							this.txtNhaXuatBan.getText(), Integer.parseInt(this.txtGiaTien.getText()),Integer.parseInt(this.txtSoLuong.getText()));
					SachData.ThemSach(s);
					ThemMoiSach(e);
					duLieuJTable.layDuLieuJtable("SELECT * FROM Sach", tableSach);
				}
			}catch(Exception e1) {
				JOptionPane.showMessageDialog(null, "Thêm Không Thành Công", "Thông Báo", 1);
			}
		}
	
	//Nút Thêm JTable Phiếu Mượn
	private void btnThemJTablePhieuMuon(ActionEvent e) {
		try {
			if(this.txtMaPhieuMuon.getText().length() == 0 || this.txtMaDocGia1.getText().length() == 0 || this.txtMaSach1.getText().length() == 0){
				JOptionPane.showMessageDialog(null, "Mã Phiếu Mượn, Mã Sách, Mã Đọc Giả Không Được Bỏ Trống", "Thông Báo", 1);
				return;
			}
			else if(this.txtMaPhieuMuon.getText().length() > 10 || this.txtMaDocGia1.getText().length() > 10 || this.txtMaSach1.getText().length() > 10) {
				JOptionPane.showMessageDialog(null, "Mã Phiếu Mượn, Mã Sách, Mã Đọc Giả Không Được Quá 10 Ký Tự", "Thông Báo", 1);
				return;
			}
			else
			{
				if(DocGiaData.timKiemMaDocGia(this.txtMaDocGia1.getText()) == false) {
					JOptionPane.showMessageDialog(null, "Không có mã đọc giả này", "Thông Báo", 1);
				}
				else if(SachData.TimMaSach(this.txtMaSach1.getText()) == false) {
					JOptionPane.showMessageDialog(null, "Không có mã sách", "Thông Báo", 1);
				}
				else {

					PhieuMuon p = new PhieuMuon(this.txtMaPhieuMuon.getText(),this.txtMaDocGia1.getText(),this.txtMaSach1.getText(),
							java.sql.Date.valueOf(this.txtNgayMuon.getText()),java.sql.Date.valueOf(this.txtHanTra.getText()),
							Integer.parseInt(this.txtTienCoc.getText()));
					PhieuMuonData.ThemPhieuMuon(p);
					ThemMoiPhieuMuon(e);
					duLieuJTable.layDuLieuJtable("SELECT * FROM MuonSach", tablePhieuMuon);
				}
			
			}
		}catch(Exception e1) {
			JOptionPane.showMessageDialog(null, "Thêm Không Thành Công", "Thông Báo", 1);
		}
	}
	
	
	
	//Nút Sửa Đọc Giả Của JTable Đọc Giả
	private void SuaThongTinDocGia(ActionEvent e) {
		khongThayDoiText(true);
		DocGiaOP(false);
		this.txtTaiKhoan.setEnabled(false);
		this.btnSua.setEnabled(true);
		this.btnThem.setEnabled(false);
		this.btnXoa.setEnabled(false);
	}
	
	//Nút Sửa Thông Tin Sách Của JTable Sách
	private void SuaThongTinSach(ActionEvent e) {
		khongThayDoiTextCuaSach(true);
		SachOP(false);
		this.txtMaSach.setEnabled(false);
		this.btnSua1.setEnabled(true);
		this.btnThem1.setEnabled(false);
		this.btnXoaSach.setEnabled(false);
	}
	
	//Nút Sửa Thông Tin Phiếu Mượn Của JTable Phiếu Mượn
	private void SuaPhieuMuon(ActionEvent e) {
		khongThayDoiTextCuaPhieuMuon(true);
		PhieuMuonOP(false);
		this.txtMaPhieuMuon.setEnabled(false);
		this.btnSua2.setEnabled(true);
		this.btnThem2.setEnabled(false);
		this.btnXoaPhieuMuon.setEnabled(false);
	}
	
	
	//Nút Sửa của JTable đọc giả
	private void btnSua(ActionEvent e) {
		try {
			if(this.txtMatKhau.getText().length() == 0){
				JOptionPane.showMessageDialog(null, "Tài Khoản Hoặc Mật Khẩu Không Được Bỏ Trống", "Thông Báo", 1);
				return;
			}
			else if(this.txtMatKhau.getText().length() > 10) {
				JOptionPane.showMessageDialog(null, "Tài Khoản Hoặc Mật Khẩu Không Được Quá 10 Ký Tự", "Thông Báo", 1);
				return;
			}else {
				DocGia dg = new DocGia(this.txtTaiKhoan.getText(),this.txtMatKhau.getText(),this.txtTenDocGia.getText(), 
							this.txtDiaChi.getText(),this.txtSoDienThoai.getText(),this.txtEmail.getText());
				if(DocGiaData.CapNhapThongTinDocGia(dg)) {
					JOptionPane.showMessageDialog(null, "Sửa Thông Tin Thành Công", "Thông Báo", 1);
					duLieuJTable.layDuLieuJtable("SELECT * FROM DocGia", tableDocGia);
				}
				else {
					JOptionPane.showMessageDialog(null, "Sửa Thông Tin Không Thành Công", "Thông Báo", 1);
				}
			}
		}
		catch(Exception e1) {
			JOptionPane.showMessageDialog(null, "Sửa Không Thành Công", "Thông Báo", 1);
		}
		
	}
	
	//Nút Sửa Của JTable Sách
	private void SuaSach(ActionEvent e) {
		try {
				Sach s = new Sach(this.txtMaSach.getText(),this.txtTenSach.getText(),this.txtLoaiSach.getText(), this.txtTacGia.getText(),
							this.txtNhaXuatBan.getText(),Integer.parseInt(this.txtGiaTien.getText()),Integer.parseInt(this.txtSoLuong.getText()));
				if(SachData.CapNhapThongTinSach(s)) {
					JOptionPane.showMessageDialog(null, "Sửa Thông Tin Thành Công", "Thông Báo", 1);
					duLieuJTable.layDuLieuJtable("SELECT * FROM Sach", tableSach);
				}
				else {
					JOptionPane.showMessageDialog(null, "Sửa Thông Tin Không Thành Công", "Thông Báo", 1);
				}
		}
		catch(Exception e1) {
			JOptionPane.showMessageDialog(null, "Sửa Không Thành Công", "Thông Báo", 1);
		}
		
	}
	//Nút Sửa Của JTable Phiếu Mượn
	private void btnSuaPhieuMuon(ActionEvent e) {
		try {
			if(DocGiaData.timKiemMaDocGia(this.txtMaDocGia1.getText()) == false) {
				JOptionPane.showMessageDialog(null, "Không có mã đọc giả này", "Thông Báo", 1);
			}
			else if(SachData.TimMaSach(this.txtMaSach1.getText()) == false) {
				JOptionPane.showMessageDialog(null, "Không có mã sách", "Thông Báo", 1);
			}
			else {
				PhieuMuon p = new PhieuMuon(this.txtMaPhieuMuon.getText(),this.txtMaDocGia1.getText(),this.txtMaSach1.getText(),
						java.sql.Date.valueOf((this.txtNgayMuon.getText())),java.sql.Date.valueOf(this.txtHanTra.getText()),
						Integer.parseInt(this.txtTienCoc.getText()));
				if(PhieuMuonData.CapNhapThongTinPhieuMuon(p)) {
					JOptionPane.showMessageDialog(null, "Sửa Thành Công", "Thông Báo", 1);
					duLieuJTable.layDuLieuJtable("SELECT * FROM MuonSach", tablePhieuMuon);
				}
				else
					JOptionPane.showMessageDialog(null, "Sửa Không Thành Công", "Thông Báo", 1);
			}
		}catch(Exception e1) {
			JOptionPane.showMessageDialog(null, "Sửa Không Thành Công", "Thông Báo", 1);
		}
	}
	
	//Thiệt lập có cho phép nhập vào các textbox hay không
	private void khongThayDoiText(boolean b) {
		this.txtDiaChi.setEnabled(b);
		this.txtEmail.setEnabled(b);
		this.txtMatKhau.setEnabled(b);
		this.txtSoDienThoai.setEnabled(b);
		this.txtTaiKhoan.setEnabled(b);
		this.txtTenDocGia.setEnabled(b);
	}
	
	private void khongThayDoiTextCuaSach(boolean b) {
		this.txtTenSach.setEnabled(b);
		this.txtMaSach.setEnabled(b);
		this.txtLoaiSach.setEnabled(b);
		this.txtTacGia.setEnabled(b);
		this.txtNhaXuatBan.setEnabled(b);
		this.txtGiaTien.setEnabled(b);
		this.txtSoLuong.setEnabled(b);
	}
	private void khongThayDoiTextCuaPhieuMuon(boolean b) {
		this.txtMaPhieuMuon.setEnabled(b);
		this.txtMaDocGia1.setEnabled(b);
		this.txtMaSach1.setEnabled(b);
		this.txtNgayMuon.setEnabled(b);
		this.txtHanTra.setEnabled(b);
		this.txtTienCoc.setEnabled(b);
	}
	
	//Thiết lập sự tương tác của các nút thêm sửa xóa(Nếu true, thì khả dụng ngược lại thì không khả dụng(Không bấm được))
	private void DocGiaOP(boolean a) {
		this.btnThem.setEnabled(a);
		this.btnSua.setEnabled(a);
		this.btnXoa.setEnabled(a);
	}
	
	private void SachOP(boolean a) {
		this.btnThem1.setEnabled(a);
		this.btnSua1.setEnabled(a);
		this.btnXoaSach.setEnabled(a);
	}
	
	private void PhieuMuonOP(boolean a) {
		this.btnThem2.setEnabled(a);
		this.btnSua2.setEnabled(a);
		this.btnXoaPhieuMuon.setEnabled(a);
	}
	
	
	//Đưa nội dung text box về rỗng
	private void resetTextboxDocGia() {
		this.txtDiaChi.setText("");
		this.txtEmail.setText("");
		this.txtMatKhau.setText("");
		this.txtSoDienThoai.setText("");
		this.txtTaiKhoan.setText("");
		this.txtTenDocGia.setText("");
	}
	
	private void resetTextBoxSach() {
		this.txtMaSach.setText("");
		this.txtTenSach.setText("");
		this.txtLoaiSach.setText("");
		this.txtTacGia.setText("");
		this.txtNhaXuatBan.setText("");
		this.txtGiaTien.setText("");
		this.txtSoLuong.setText("");
	}
	
	private void resetTextBoxPhieuMuon(){
		this.txtMaPhieuMuon.setText("");
		this.txtMaDocGia1.setText("");
		this.txtMaSach1.setText("");
		this.txtNgayMuon.setText("");
		this.txtHanTra.setText("");
		this.txtTienCoc.setText("");
	}
}
