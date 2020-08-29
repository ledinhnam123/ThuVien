package Test;



import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.Assert.*;
import org.junit.rules.ExpectedException;
import org.junit.validator.PublicClassValidator;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.microsoft.sqlserver.jdbc.SQLServerException;


import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import Data.Connect;
import Data.DocGiaData;
import Data.ThuThuData;
import Object.DocGia;
import junit.framework.Assert;

public class testConnect {
	public static PreparedStatement ps;
	public static ResultSet rs;
	
	
	public ArrayList<String> getAllDocGia() {
		ArrayList<String> arr = new ArrayList<String>(); 
		try {
			String tempString;
			ps = Connect.getConnect().prepareStatement("SELECT * from DocGia");
			rs = ps.executeQuery();
			while(rs.next()) {
				tempString = rs.getString("TaiKhoan") + "_"+ rs.getString("MatKhau");
				arr.add(tempString);
			}
			
		}
		catch(Exception e) {
			
		}
		return arr;
	}	

	
	@Test
	public void TestConnect() {
		Connect connect = new Connect();
		
		assertNotEquals("Connect Database Fail",null, connect.getConnect());
	}
	
	@Test
	public void TestDangNhap() {
		DocGiaData data = new DocGiaData();
		testConnect te = new testConnect();
		for (int i = 0; i < te.getAllDocGia().size(); i++) {
			String[] tam = te.getAllDocGia().get(i).split("_");
			for (int j = 0; j < tam.length; j++) {
				assertNotEquals("sai user orr Password",null, data.DangNhap(tam[0], tam[1]));
			}
			
		}
	}
		
		
		/*
		 * String user = "docgia1"; String pass = "123456";
		 * assertNotEquals("sai user orr Password",null, data.DangNhap(user, pass));
		 * assertNotEquals("sai user orr Password",null, data.DangNhap("ad", "ads"));
		 */
	
    
	@Test
	public void testCaseDangNhap2() {
		
		DocGiaData data = new DocGiaData();
		testConnect te = new testConnect();
		ArrayList<String> arr = te.getAllDocGia();
		// truong hop TK mat Khau khong phu hop
		arr.add("fdagysvshagchjgashjgasjhajajhj_hdakjshdakjhdakjhdajkhdajkh");
		for (int i = 0; i < arr.size(); i++) {
			System.out.println(arr.get(i));
			String[] tam = arr.get(i).split("_");
			for (int j = 0; j < tam.length; j++) {
				assertNotEquals("sai user orr Password tai vi tri "+i,null, data.DangNhap(tam[0], tam[1]));
			}
			
		}
	}
	/*
	 * // @Test // public void TestDangNhapTT() { // ThuThuData data1= new
	 * ThuThuData(); // String user="quangtinh"; // String pass="123456"; //
	 * assertNotEquals("Sai user or Pass ",null,data1.dangNhap(user, pass)); // // }
	 * //
	 */
	
	
	
	
	
	@Test
	public void TestThemDocGia() throws Exception {
		
			DocGiaData data = new DocGiaData();
			DocGia dg = new DocGia();
			dg.setTaiKhoan("yau2555s3");
			dg.setMatKhau("yqquo1212");
			dg.setDiaChi("dasd");
			dg.setSoDienThoai("54w44w");
			dg.setTen("sdfdsf");
			dg.setEmail("faesjkfjds");
			data.ThemDocGia(dg);
			assertNotEquals("Faill!",true, data.them);
			
		// data.them= true;
			// assertNotEqual , exepected và actual khác nhau, giống nhau thì test case fail
			//them 1 bien tham static them = false; 
			// Throw Exception la true
			
	}
	/*
	 * @Test(expected = ArithmeticException.class) public void
	 * testDivisionWithException() { int i = 1 / 0; }
	 */
	
	@Test
	public void testCapNhatTTDocGia() {
		
		// Phải có tk hoặc mk mới update được
		
		//Pass
		DocGiaData data = new DocGiaData();
		DocGia dg= new DocGia();
		dg.setDiaChi("Địa Chỉ");
		dg.setTaiKhoan("docgia1");
		dg.setMatKhau("123456");
		
		assertEquals("CAp Nhat khong thanh cong!!!",true,data.CapNhapThongTinDocGia(dg));
		//Faile
		data = new DocGiaData();
		dg= new DocGia();
		dg.setTaiKhoan("Nam");
		dg.setDiaChi("Địa chỉ");
		dg.setMatKhau("123456");
		assertEquals("Cập nhật không thành công,  Tài Khoản Fail",true,data.CapNhapThongTinDocGia(dg));
		
	}
	@Test
	public void testXoaDocGia() {
		DocGiaData data = new DocGiaData();
		//NULL
		String tk="B";
		assertEquals("Xóa Thất Bại!,(Tk fail hoặc Null)",true ,data.XoaDocGia(tk));
		// xóa được khi đúng tài khoản
		// Pass
		String tk2="EE";
		assertEquals("Xóa Thất Bại", true,data.XoaDocGia(tk2));
		// MÃ null
		//assertEquals("Xóa Thất Bại,TK không phù hợp!",true,data.XoaDocGia(null));
		
		
	}
	@Test
	public void testTimKiemDocGia() {
		DocGiaData data= new DocGiaData();
		
		String Tk= "docgia1";
		assertEquals("Tìm Kiếm Thất Bại,(TK không hơp lệ)",true ,data.timKiemMaDocGia(Tk));
		//assertEquals("Tìm Kiếm Thất Bại",true ,data.timKiemMaDocGia("B"));
		// tìm được khi đúng tài khoản
		String Tk2="Nam";
		assertEquals("Tìm kiếm Thất Bại,(TK fail Hoặc Null)",true, data.timKiemMaDocGia(Tk2));
		// Mã Độc Giả = null
		//assertEquals("Tìm kiếm THất Bai,(TK không hợp lệ)",true,data.timKiemMaDocGia(null));
		
		
	}
	
	
	@Test
	public void testTimkiemToanBoDGTrongDB() {
		
		DocGiaData data= new DocGiaData();
		testConnect teData= new testConnect();
		String[] tam ;
		for(int i= 0; i < teData.getAllDocGia().size();i++) {
			tam = teData.getAllDocGia().get(i).split("_");
			for (int j = 0; j < tam.length; j++) {
				assertEquals("Eroor!",  true , data.timKiemMaDocGia(tam[0]) );
			}
		}
	}
	 
		

	/*
	 * @Test(expected = Exception.class) public void tata() { DocGiaData data = new
	 * DocGiaData(); data.toan(); }
	 */
	
	
	
}
