package GiaoDien;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Data.PhieuMuonData;
import Data.TraSachData;

import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import Object.TraSach;

public class TraSachGiaoDien extends JFrame {

	private JPanel contentPane;
	private JTextField txtTimKiem;
	private JTextField txtMaPhieuMuon;
	private JTextField txtMaSach;
	private JTextField txtMaDocGia;
	private JTextField txtTienCoc;
	private JTextField txtNgayMuon;
	private JTextField txtTienTra;
	private JTextField txtHanTraSach;
	private JTextField txtNgayTra;
	private JTable table;
	private JTable table_1;
	private int tienPhat;
	private int ngayPhat;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TraSachGiaoDien frame = new TraSachGiaoDien();
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
	public TraSachGiaoDien() {
		setTitle("Trả Sách");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 868, 546);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 10, 844, 489);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Trả Sách", null, panel, null);
		panel.setLayout(null);
		
		JButton btnNhapMoi = new JButton("Nhập Mới");
		btnNhapMoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NhapMoi(e);
			}
		});
		btnNhapMoi.setFont(new Font("Arial", Font.PLAIN, 14));
		btnNhapMoi.setBounds(10, 21, 106, 23);
		panel.add(btnNhapMoi);
		
		txtTimKiem = new JTextField();
		txtTimKiem.setColumns(10);
		txtTimKiem.setBounds(140, 21, 188, 25);
		panel.add(txtTimKiem);
		
		JButton btnTimKiem = new JButton("Tìm Kiếm");
		btnTimKiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TimKiem(e);
			}
		});
		btnTimKiem.setFont(new Font("Arial", Font.PLAIN, 14));
		btnTimKiem.setBounds(363, 23, 106, 23);
		panel.add(btnTimKiem);
		
		JButton btnQuayLai = new JButton("Quai Lại");
		btnQuayLai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				QuayLai(e);
			}
		});
		btnQuayLai.setFont(new Font("Arial", Font.PLAIN, 14));
		btnQuayLai.setBounds(723, 0, 106, 23);
		panel.add(btnQuayLai);
		
		JButton btnRefresh = new JButton("Refresh");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				duLieuJTable.layDuLieuJtable("SELECT * FROM MuonSach", table);
			}
		});
		btnRefresh.setFont(new Font("Arial", Font.PLAIN, 14));
		btnRefresh.setBounds(723, 23, 106, 23);
		panel.add(btnRefresh);
		
		JLabel label = new JLabel("Mã Phiếu Mượn");
		label.setFont(new Font("Arial", Font.PLAIN, 14));
		label.setBounds(25, 108, 116, 24);
		panel.add(label);
		
		JLabel label_1 = new JLabel("Mã Sách");
		label_1.setFont(new Font("Arial", Font.PLAIN, 14));
		label_1.setBounds(25, 176, 116, 24);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("Mã Đọc Giả");
		label_2.setFont(new Font("Arial", Font.PLAIN, 14));
		label_2.setBounds(25, 142, 116, 24);
		panel.add(label_2);
		
		JLabel label_3 = new JLabel("Tiền Cọc");
		label_3.setFont(new Font("Arial", Font.PLAIN, 14));
		label_3.setBounds(25, 210, 91, 24);
		panel.add(label_3);
		
		JLabel label_4 = new JLabel("Ngày Mượn");
		label_4.setFont(new Font("Arial", Font.PLAIN, 14));
		label_4.setBounds(456, 108, 95, 24);
		panel.add(label_4);
		
		JLabel label_5 = new JLabel("Hạn Trả Sách");
		label_5.setFont(new Font("Arial", Font.PLAIN, 14));
		label_5.setBounds(456, 142, 95, 24);
		panel.add(label_5);
		
		JLabel lblNgyTr = new JLabel("Ngày Trả");
		lblNgyTr.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNgyTr.setBounds(456, 176, 95, 24);
		panel.add(lblNgyTr);
		
		JLabel lblTinPhiTr = new JLabel("Tiền Phải Trả");
		lblTinPhiTr.setFont(new Font("Arial", Font.PLAIN, 14));
		lblTinPhiTr.setBounds(456, 210, 95, 24);
		panel.add(lblTinPhiTr);
		
		txtMaPhieuMuon = new JTextField();
		txtMaPhieuMuon.setColumns(10);
		txtMaPhieuMuon.setBounds(149, 110, 198, 23);
		panel.add(txtMaPhieuMuon);
		
		txtMaSach = new JTextField();
		txtMaSach.setColumns(10);
		txtMaSach.setBounds(149, 177, 198, 23);
		panel.add(txtMaSach);
		
		txtMaDocGia = new JTextField();
		txtMaDocGia.setColumns(10);
		txtMaDocGia.setBounds(149, 144, 198, 23);
		panel.add(txtMaDocGia);
		
		txtTienCoc = new JTextField();
		txtTienCoc.setColumns(10);
		txtTienCoc.setBounds(149, 210, 198, 23);
		panel.add(txtTienCoc);
		
		txtNgayMuon = new JTextField();
		txtNgayMuon.setColumns(10);
		txtNgayMuon.setBounds(582, 111, 198, 23);
		panel.add(txtNgayMuon);
		
		txtTienTra = new JTextField();
		txtTienTra.setColumns(10);
		txtTienTra.setBounds(582, 211, 198, 23);
		panel.add(txtTienTra);
		
		txtHanTraSach = new JTextField();
		txtHanTraSach.setColumns(10);
		txtHanTraSach.setBounds(582, 145, 198, 23);
		panel.add(txtHanTraSach);
		
		txtNgayTra = new JTextField();
		txtNgayTra.setColumns(10);
		txtNgayTra.setBounds(582, 178, 198, 23);
		panel.add(txtNgayTra);
		
		JButton btnTraSach = new JButton("Trả Sách");
		btnTraSach.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TraSach(e);
			}
		});
		btnTraSach.setFont(new Font("Arial", Font.PLAIN, 14));
		btnTraSach.setBounds(326, 265, 106, 23);
		panel.add(btnTraSach);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 296, 819, 156);
		panel.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				BamVaoJTableMuonSach(e);
			}
		});
		table.setModel(new DefaultTableModel(
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
		scrollPane.setViewportView(table);
		duLieuJTable.layDuLieuJtable("SELECT * FROM MuonSach", table);
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Thống Kê Sách Trả", null, panel_1, null);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 10, 819, 442);
		panel_1.add(scrollPane_1);
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column"
			}
		));
		duLieuJTable.layDuLieuJtable("SELECT * FROM TraSach", table_1);
		scrollPane_1.setViewportView(table_1);
	}
	
	
	//Nút Nhập Mới
	private void NhapMoi(ActionEvent e) {
		this.txtTimKiem.setText("");
		this.txtHanTraSach.setText("");
		this.txtMaDocGia.setText("");
		this.txtMaPhieuMuon.setText("");
		this.txtMaSach.setText("");
		this.txtNgayMuon.setText("");
		this.txtNgayTra.setText("");
		this.txtTienCoc.setText("");
		this.txtTienTra.setText("");
		khongThayDoiText(true);
	}
	
	
	//Nút Quay Lại
	private void QuayLai(ActionEvent e) {
		tuongTac t = new tuongTac();
		t.setVisible(true);
		dispose();
	}
	
	
	//Nút Tìm kiếm
	private void TimKiem(ActionEvent e) {
		try {
			if(this.txtTimKiem.getText().length() == 0) {
				JOptionPane.showMessageDialog(null,"Nhập Nội Dung Tìm Kiếm","Thông Báo",1);
			}
			else
			{
				String sql = "SELECT * from MuonSach WHERE MaPhieuMuon like N'%"+this.txtTimKiem.getText()+"%' "
		                + "or MaDocGia like N'%"+this.txtTimKiem.getText()+"%'" + "or MaSach like '%"+this.txtTimKiem.getText()+"%'";
		        duLieuJTable.layDuLieuJtable(sql, table);
			}
			
		}catch(Exception e1) {
			
		}
	}
	
	//Bấm Vào JTable
	private void BamVaoJTableMuonSach(MouseEvent e) {
		khongThayDoiText(false);
		try {
			int row = this.table.getSelectedRow();
			String layMaPhieuMuon = (this.table.getModel().getValueAt(row,0)).toString();
			String sql1 = "SELECT * FROM MuonSach WHERE MaPhieuMuon = '" + layMaPhieuMuon + "'";
			ResultSet rs = duLieuJTable.kiemTraKetNoi(sql1);
			if(rs.next()) {
				this.txtMaPhieuMuon.setText(rs.getString("MaPhieuMuon"));
				this.txtMaDocGia.setText(rs.getString("MaDocGia"));
				this.txtMaSach.setText(rs.getString("MaSach"));
				this.txtNgayMuon.setText(rs.getString("NgayMuon"));
				this.txtHanTraSach.setText(rs.getString("HanTra"));
				this.txtTienCoc.setText(rs.getString("TienCoc"));
			}
		}catch(Exception e1) {
			
		}
	}
	
	
	//Trả Sách
	@SuppressWarnings("deprecation")
	private void TraSach(ActionEvent e) {
		try {
			if(this.txtNgayTra.getText().length() == 0 || this.txtTienTra.getText().length() == 0) {
				JOptionPane.showMessageDialog(null,"Chưa Điền thông tin Ngày Trả Hoặc Tiền Trả","Thông Báo",1);
			}
			else {
				if(java.sql.Date.valueOf(this.txtNgayTra.getText()).getYear() - java.sql.Date.valueOf(this.txtNgayMuon.getText())
						.getYear()>= 0) {
					if(java.sql.Date.valueOf(this.txtNgayTra.getText()).getMonth() - java.sql.Date.valueOf(this.txtNgayMuon.getText())
							.getMonth() >=0) {
						if(java.sql.Date.valueOf(this.txtNgayTra.getText()).getDay() - java.sql.Date.valueOf(this.txtNgayMuon.getText())
								.getDay() >=0) {
							ngayPhat = (java.sql.Date.valueOf(this.txtNgayTra.getText()).getYear() -java.sql.Date.valueOf(this.
									txtHanTraSach.getText()).getYear())*365 + (java.sql.Date.valueOf(this.txtNgayTra.getText()).getMonth()
									- java.sql.Date.valueOf(this.txtHanTraSach.getText()).getMonth())*30 + (java.sql.Date.valueOf(
									this.txtNgayTra.getText()).getDay() - java.sql.Date.valueOf(this.txtHanTraSach.getText()).getDay()) ;
							tienPhat = ngayPhat* 3;
							if(tienPhat > 0) {
								JOptionPane.showMessageDialog(null, "Tiền Phạt là: " + String.valueOf(tienPhat) + ". Tổng tiền Phải Trả là: "
										+ String.valueOf(tienPhat + Integer.parseInt(this.txtTienTra.getText())),"Thông Báo",1);
							}
							else {
								JOptionPane.showMessageDialog(null,"Không Có Tiền Phạt. Tổng Tiền Phải Trả Là : " + String.valueOf(
										Integer.parseInt(this.txtTienTra.getText())),"Thông Báo",1);
							}
							TraSach ts = new TraSach(this.txtMaPhieuMuon.getText(),this.txtMaDocGia.getText(),this.txtMaSach.getText(),
									java.sql.Date.valueOf(this.txtNgayMuon.getText()),java.sql.Date.valueOf(this.txtHanTraSach.getText()),
									Integer.parseInt(this.txtTienCoc.getText()),java.sql.Date.valueOf(this.txtNgayTra.getText()),tienPhat +
									Integer.parseInt(this.txtTienTra.getText()));
							TraSachData.CapThongThongTinTraSach(ts);
							PhieuMuonData.XoaPhieuMuon(this.txtMaPhieuMuon.getText());
							duLieuJTable.layDuLieuJtable("SELECT * FROM MuonSach", table);
							duLieuJTable.layDuLieuJtable("SELECT * FROM TraSach", table_1);
							cleartextbox();
						}else {
							JOptionPane.showMessageDialog(null, "Ngày Trả Không Hợp Lệ","Thông Báo",1);
						}
					}
					else {
						JOptionPane.showMessageDialog(null, "Ngày Trả Không Hợp Lệ","Thông Báo",1);
					}
					
				}
				else {
					JOptionPane.showMessageDialog(null, "Ngày Trả Không Hợp Lệ","Thông Báo",1);
				}

			}
		}catch(Exception e1) {
			JOptionPane.showMessageDialog(null, "Không Hợp Lệ", "Thông Báo",1);
		}
	}
	
	private void khongThayDoiText(boolean b) {
		this.txtMaPhieuMuon.setEnabled(b);
		this.txtMaDocGia.setEnabled(b);
		this.txtMaSach.setEnabled(b);
		this.txtNgayMuon.setEnabled(b);
		this.txtHanTraSach.setEnabled(b);
		this.txtTienCoc.setEnabled(b);
	}
	
	private void cleartextbox() {
		this.txtHanTraSach.setText("");
		this.txtMaDocGia.setText("");
		this.txtMaPhieuMuon.setText("");
		this.txtMaSach.setText("");
		this.txtNgayMuon.setText("");
		this.txtNgayTra.setText("");
		this.txtTienCoc.setText("");
		this.txtTienTra.setText("");
		this.txtTimKiem.setText("");
	}
	

}
