package Data;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import Object.PhieuMuon;
import Object.Sach;

public class PhieuMuonData {
	public static PreparedStatement ps;
	public static ResultSet rs;
	
	public static boolean themPhieuMuon=false;
	public static void ThemPhieuMuon(PhieuMuon pm) {
		String sql = "INSERT into MuonSach values(?,?,?,?,?,?)";
		try {
			ps = Connect.getConnect().prepareStatement(sql);
			ps.setString(1, pm.getMaPhieuMuon());
			ps.setString(2, pm.getMaDocGia());
			ps.setString(3, pm.getMaSach());
			ps.setDate(4, pm.getNgayMuon());
			ps.setDate(5, pm.getHanTra());
			ps.setInt(6, pm.getTienCoc());
			ps.execute();
			JOptionPane.showMessageDialog(null, "Thêm Thành Công" , "Thông báo", 1);
		}
		catch(Exception e) {
			themPhieuMuon = true;
			JOptionPane.showMessageDialog(null, "Thêm Không Thành Công" , "Thông báo", 1);
		}
	}
	
	public static boolean CapNhapThongTinPhieuMuon(PhieuMuon pm) {
		try {
			ps = Connect.getConnect().prepareStatement("UPDATE MuonSach SET MaDocGia = ?,"+
							"MaSach = ?, NgayMuon = ?, HanTra =  ?, TienCoc = ? WHERE MaPhieuMuon = ?");
			ps.setString(6, pm.getMaPhieuMuon());
			ps.setString(1, pm.getMaDocGia());
			ps.setString(2, pm.getMaSach());
			ps.setDate(3, pm.getNgayMuon());
			ps.setDate(4, pm.getHanTra());
			ps.setInt(5, pm.getTienCoc());
			return ps.executeUpdate() > 0;
		}catch(Exception e) {
			return false;
		}
	}
	public static boolean XoaPhieuMuon(String maPhieuMuon) {
		try {
			ps = Connect.getConnect().prepareStatement("DELETE FROM MuonSach WHERE MaPhieuMuon = ?");
			ps.setString(1, maPhieuMuon);
			return ps.executeUpdate() > 0;
		}catch(Exception e) {
			return false;
		}
	}
}
