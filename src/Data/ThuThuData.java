package Data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import Object.ThuThu;

public class ThuThuData {
	public static PreparedStatement ps;
	public static ResultSet rs;
	
	public ThuThu dangNhap(String taiKhoan, String matKhau) {
		ThuThu ad = null;
		try {
			ps = Connect.getConnect().prepareStatement("SELECT * from DangNhap where TaiKhoan = ? AND MatKhau = ?");
			ps.setString(1, taiKhoan);
			ps.setString(2, matKhau);
			rs = ps.executeQuery();
			while(rs.next()) {
				ad = new ThuThu();
			}
		}catch(Exception E) {
			return ad = null;
		}
		return ad;
	}
}
