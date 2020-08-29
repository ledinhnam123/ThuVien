package GiaoDien;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class tuongTac extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					tuongTac frame = new tuongTac();
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
	public tuongTac() {
		setResizable(false);
		setTitle("Tương Tác");
		initComponents();
	}
	private void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 398, 418);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnCapNhap = new JButton("Cập Nhập");
		btnCapNhap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CapNhapHeThong(e);
			}
		});
		btnCapNhap.setFont(new Font("Arial", Font.PLAIN, 20));
		btnCapNhap.setBounds(104, 104, 186, 33);
		btnCapNhap.setToolTipText("Thêm Mới Một Sinh Viên");
		contentPane.add(btnCapNhap);
		
		JButton btnTimKiemSach = new JButton("Tìm Kiếm");
		btnTimKiemSach.setToolTipText("Tìm Kiếm Sinh Viên Trong Thư Viện");
		btnTimKiemSach.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ThuThuTimKiem(e);
			}
		});
		btnTimKiemSach.setFont(new Font("Arial", Font.PLAIN, 20));
		btnTimKiemSach.setBounds(104, 173, 186, 33);
		contentPane.add(btnTimKiemSach);
		
		JButton btnTraSach = new JButton("Trả Sách");
		btnTraSach.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TraSach(e);
			}
		});
		btnTraSach.setFont(new Font("Arial", Font.PLAIN, 20));
		btnTraSach.setBounds(104, 239, 186, 33);
		btnTraSach.setToolTipText("Báo Cáo");
		contentPane.add(btnTraSach);
		
		JButton binThoat = new JButton("Thoát");
		binThoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ThoatChuongTrinh(e);
			}
		});
		binThoat.setFont(new Font("Arial", Font.PLAIN, 20));
		binThoat.setBounds(104, 303, 186, 33);
		contentPane.add(binThoat);
		
		JButton btnQuayLai = new JButton("Quay Lại");
		btnQuayLai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				QuayLai(e);
			}
		});
		btnQuayLai.setFont(new Font("Arial", Font.PLAIN, 12));
		btnQuayLai.setBounds(299, 359, 85, 21);
		contentPane.add(btnQuayLai);
	}
	private void QuayLai(ActionEvent e) {
		DangNhap t = new DangNhap();
		t.setVisible(true);
		dispose();
	}
	private void ThoatChuongTrinh(ActionEvent e) {
		System.exit(0);
	}
	private void CapNhapHeThong(ActionEvent e) {
		ThuThuCapNhap ttcn = new ThuThuCapNhap();
		ttcn.setVisible(true);
		dispose();
	}
	private void ThuThuTimKiem(ActionEvent e) {
		TimKiem tttk = new TimKiem();
		tttk.setVisible(true);
		dispose();
	}
	private void TraSach(ActionEvent e) {
		TraSachGiaoDien ts = new TraSachGiaoDien();
		ts.setVisible(true);
		dispose();
	}
}
