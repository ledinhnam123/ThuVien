package Data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;


import Object.Sach;

/**
 *
 * @author Gaara
 */
public class SachData {
	public static PreparedStatement ps;
	public static ResultSet rs;
	
	public static boolean them=false;
	public static void ThemSach(Sach s) {
		String sql = "INSERT into Sach values(?,?,?,?,?,?,?)";
		try {
			ps = Connect.getConnect().prepareStatement(sql);
			ps.setString(1, s.getMaSach());
			ps.setString(2, s.getTenSach());
			ps.setString(3, s.getLoaiSach());
			ps.setString(4, s.getTacGia());
			ps.setString(5, s.getNhaXuatBan());
			ps.setInt(6, s.getGiaTien());
			ps.setInt(7, s.getSoLuong());
			ps.execute();
			JOptionPane.showMessageDialog(null, "Thêm Thành Công" , "Thông báo", 1);
		}
		catch(Exception e) {
			them= true;
			JOptionPane.showMessageDialog(null, "Thêm Không Thành Công" , "Thông báo", 1);
		}
	}
	
	public static boolean CapNhapThongTinSach(Sach s) {
		try {
			ps = Connect.getConnect().prepareStatement("UPDATE Sach SET TenSach = ?, LoaiSach = ?,"+
							"TacGia = ?, NhaXuatBan = ?, GiaTien =  ?, SoLuong = ? WHERE MaSach = ?");
			ps.setString(7, s.getMaSach());
			ps.setString(1, s.getTenSach());
			ps.setString(2, s.getLoaiSach());
			ps.setString(3, s.getTacGia());
			ps.setString(4, s.getNhaXuatBan());
			ps.setInt(5, s.getGiaTien());
			ps.setInt(6, s.getSoLuong());
			return ps.executeUpdate() > 0;
		}catch(Exception e) {
			return false;
		}
	}
	public static boolean XoaSach(String maSach) {
		try {
			ps = Connect.getConnect().prepareStatement("DELETE FROM Sach WHERE MaSach = ?");
			ps.setString(1, maSach);
			return ps.executeUpdate() > 0;
		}catch(Exception e) {
			return false;
		}
	}
	
	public static boolean TimMaSach(String masach) {
		try {
			ps = Connect.getConnect().prepareStatement("SELECT * FROM Sach WHERE MaSach = ?");
			ps.setString(1, masach);
			rs = ps.executeQuery();
			if(rs.next()) {
				return true;
			}
			else
				return false;
		}catch(Exception e) {
			return false;
		}
	}
}
