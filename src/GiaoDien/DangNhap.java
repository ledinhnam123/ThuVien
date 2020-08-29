package GiaoDien;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Data.Connect;
import Data.DocGiaData;
import Data.ThuThuData;
import Object.DocGia;
import Object.ThuThu;

import javax.swing.JComboBox;
import java.awt.Panel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

public class DangNhap extends JFrame {

	private JPanel contentPane;
	private JTextField usenameField;
	private JPasswordField passwordField;
	private ButtonGroup buttongroup = new ButtonGroup();
	private JRadioButton rdbtnThTh;
	private JRadioButton rdbtncGi;

	/**
	 * Launch the application.
	 */
	ThuThuData tt = new ThuThuData();
	DocGiaData dgdt = new DocGiaData();
	public DangNhap() {
		setResizable(false);
		setTitle("Đăng Nhập\r\n");
        initComponents();
        this.setLocation(300, 200);
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DangNhap frame = new DangNhap();
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
	private void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 561, 338);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbusername = new JLabel("T\u00E0i Kho\u1EA3n");
		lbusername.setFont(new Font("Arial", Font.PLAIN, 16));
		lbusername.setBounds(87, 96, 91, 19);
		contentPane.add(lbusername);
		
		JLabel lbpassword = new JLabel("M\u1EADt Kh\u1EA9u");
		lbpassword.setFont(new Font("Arial", Font.PLAIN, 16));
		lbpassword.setBounds(87, 145, 91, 25);
		contentPane.add(lbpassword);
		
		usenameField = new JTextField();
		usenameField.setBounds(208, 92, 175, 25);
		contentPane.add(usenameField);
		usenameField.setColumns(10);
		usenameField.setEnabled(false);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(208, 148, 175, 24);
		contentPane.add(passwordField);
		passwordField.setEnabled(false);
		
		JButton btnLogin = new JButton("\u0110\u0103ng Nh\u1EADp");
		btnLogin.setToolTipText("Đăng Nhập Vào Hệ Thống");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GiaoDienTuongTac(e);
			}
		});
		btnLogin.setFont(new Font("Arial", Font.PLAIN, 13));
		btnLogin.setBounds(87, 229, 100, 32);
		contentPane.add(btnLogin);
		
		JButton btnReset = new JButton("Nh\u1EADp L\u1EA1i");
		btnReset.setToolTipText("Nhập Lại Từ Đầu");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nhapLai(e);
			}
		});
		btnReset.setFont(new Font("Arial", Font.PLAIN, 13));
		btnReset.setBounds(232, 229, 100, 32);
		contentPane.add(btnReset);
		
		JButton btnExit = new JButton("Tho\u00E1t");
		btnExit.setToolTipText("Thoát Khoải Hệ Thống");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Thoat(e);
			}
		});
		btnExit.setFont(new Font("Arial", Font.PLAIN, 13));
		btnExit.setBounds(374, 229, 100, 32);
		contentPane.add(btnExit);
		
		rdbtnThTh = new JRadioButton("Thủ Thư");
		rdbtnThTh.setActionCommand("ThuThu");
		buttongroup.add(rdbtnThTh);
		rdbtnThTh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bamTruocKhiNhapTK_MK(e);
			}
		});
		rdbtnThTh.setFont(new Font("Arial", Font.PLAIN, 12));
		rdbtnThTh.setBounds(92, 189, 105, 21);
		contentPane.add(rdbtnThTh);
		
		rdbtncGi = new JRadioButton("Độc Giả");
		rdbtncGi.setActionCommand("DocGia");
		buttongroup.add(rdbtncGi);
		rdbtncGi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bamTruocKhiNhapTK_MK1(e);
			}
		});
		rdbtncGi.setFont(new Font("Arial", Font.PLAIN, 12));
		rdbtncGi.setBounds(330, 189, 105, 21);
		contentPane.add(rdbtncGi);
	}
	
	private void GiaoDienTuongTac(ActionEvent e) {
		String taiKhoan = this.usenameField.getText();
		String matKhau = this.passwordField.getText();
		if(taiKhoan.isEmpty() || matKhau.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Chưa Nhập Tài Khoản Hoặc Mật Khẩu","Thông Báo",1);
		}
		else {
			ThuThu thuthu = tt.dangNhap(taiKhoan, matKhau);
			DocGia docgia = dgdt.DangNhap(taiKhoan, matKhau);
			try {
				if(thuthu != null && buttongroup.getSelection().getActionCommand() == "ThuThu") {
					tuongTac ttac = new tuongTac();
					ttac.setVisible(true);
					dispose();
				}
				else if(docgia != null && buttongroup.getSelection().getActionCommand() == "DocGia") {
					DocGiaTimKiem d = new DocGiaTimKiem();
					d.setVisible(true);
					dispose();
				}
				else JOptionPane.showMessageDialog(null, "Không tồn tại tài khoản", "Thông báo", 1);
			}
			catch(Exception e1) {
                JOptionPane.showMessageDialog(null, e1);
            }
		}
	}
	private void nhapLai(ActionEvent e) {
		this.usenameField.setText("");
		this.passwordField.setText("");
	}
	private void Thoat(ActionEvent e) {
		System.exit(0);
	}
	private void bamTruocKhiNhapTK_MK(ActionEvent e) {
		this.usenameField.setEnabled(true);
		this.passwordField.setEnabled(true);
	}
	private void bamTruocKhiNhapTK_MK1(ActionEvent e) {
		this.usenameField.setEnabled(true);
		this.passwordField.setEnabled(true);
	}
}

