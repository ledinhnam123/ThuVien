package Data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Object.DocGia;

public class DocGiaData {
	public static PreparedStatement ps;
	public static ResultSet rs;
	public DocGia DangNhap(String taiKhoan, String matKhau) {
		DocGia dg = null;
		try {
			ps = Connect.getConnect().prepareStatement("SELECT * from DocGia where TaiKhoan = ? AND MatKhau = ?");
			ps.setString(1, taiKhoan);
			ps.setString(2, matKhau);
			rs = ps.executeQuery();
			if(rs.next()) {
				dg = new DocGia();
				dg.setTen(rs.getString("TenDocGia"));
				dg.setDiaChi(rs.getString("DiaChi"));
				dg.setEmail(rs.getString("Email"));
				dg.setSoDienThoai(rs.getString("SoDienThoai"));
				dg.setTaiKhoan(rs.getString("TaiKhoan"));
				dg.setMatKhau(rs.getString("MatKhau"));
			}
			
		}
		catch(Exception e) {
			dg = null;
		}
		
		return dg;
	}
	
	public static boolean them = false;
	public static void ThemDocGia(DocGia dg) {
		
		try {
			String sql = "INSERT into DocGia values(?,?,?,?,?,?)";
			ps = Connect.getConnect().prepareStatement(sql);
			ps.setString(1, dg.getTaiKhoan());
			ps.setString(2, dg.getMatKhau());
			ps.setString(3, dg.getTen());
			ps.setString(4, dg.getDiaChi());
			ps.setString(5, dg.getSoDienThoai());
			ps.setString(6, dg.getEmail());
			ps.execute();
			JOptionPane.showMessageDialog(null, "Thêm Thành Công" , "Thông báo", 1);
		}
		catch(Exception e) {
			
			//e.printStackTrace();
			them = true;
			JOptionPane.showMessageDialog(null, "Thêm Không Thành Công" , "Thông báo", 1);
		}
	}
	public static boolean CapNhapThongTinDocGia(DocGia dg) {
		try {
			ps = Connect.getConnect().prepareStatement("UPDATE DocGia SET MatKhau = ?, TenDocGia = ?,"+
							"DiaChi = ?, SoDienThoai = ?, Email =  ? WHERE TaiKhoan = ?");
			ps.setString(6,dg.getTaiKhoan());
			ps.setString(1, dg.getMatKhau());
			ps.setString(2,dg.getTen());
			ps.setString(3, dg.getDiaChi());
			ps.setString(4,dg.getSoDienThoai());
			ps.setString(5,dg.getEmail());
			return ps.executeUpdate() > 0;
		}catch(Exception e) {
			return false;
		}
	}
	public static boolean XoaDocGia(String TaiKhoan) {
		try {
			ps = Connect.getConnect().prepareStatement("DELETE FROM DocGia WHERE TaiKhoan = ?");
			ps.setString(1, TaiKhoan);
			return ps.executeUpdate() > 0;
		}catch(Exception e) {
			return false;
		}
	}
	
	
	public static boolean timKiemMaDocGia(String taikhoan) {
		boolean xacNhan = false;
		try {
			ps = Connect.getConnect().prepareStatement("SELECT * FROM DocGia WHERE TaiKhoan = ?");
			ps.setString(1, taikhoan);
			rs = ps.executeQuery();
			if(rs.next()) 
				xacNhan = true;
		}catch(Exception e){
			xacNhan = false;
		}
		return xacNhan;
	}
	
}
