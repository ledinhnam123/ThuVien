package Data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import Object.TraSach;

public class TraSachData {
	
	
	public static PreparedStatement ps;
	public static ResultSet rs;
	public static boolean themCapnhatthongtintraSach =false;
	public static void CapThongThongTinTraSach(TraSach ts) {
		String sql = "INSERT INTO TraSach values(?,?,?,?,?,?,?,?)";
		try {
			ps = Connect.getConnect().prepareStatement(sql);
			ps.setString(1, ts.getMaPhieuMuon());
			ps.setString(2, ts.getMaDocGia());
			ps.setString(3, ts.getMaSach());
			ps.setDate(4, ts.getNgayMuon());
			ps.setDate(5,ts.getHanTra());
			ps.setInt(6, ts.getTienCoc());
			ps.setDate(7,ts.getNgayMuon());
			ps.setInt(8, ts.getTienTra());
			ps.execute();
			JOptionPane.showMessageDialog(null, "Thêm Thành Công" , "Thông báo", 1);
		}catch(Exception e) {
		 themCapnhatthongtintraSach= true;
		 
		JOptionPane.showMessageDialog(null, "Thêm Không Thành Công" , "Thông báo", 1);
		}
	}
}
