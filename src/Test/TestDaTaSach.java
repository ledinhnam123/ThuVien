package Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertNotEquals;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import Data.Connect;
import Data.DocGiaData;
import Data.SachData;
import Object.Sach;


public class TestDaTaSach {

	public static PreparedStatement ps;
	public static ResultSet rs;
	public  ArrayList<String> getAllSach() {
		ArrayList<String> arr= new ArrayList<String>();
		try {
			
			ps = Connect.getConnect().prepareStatement("SELECT * FROM Sach WHERE MaSach = ?");
			
			rs = ps.executeQuery();
			while(rs.next()) {
				String temString = rs.getString("maSach") + "_" + rs.getString("tenSach");
				arr.add(temString);
		}
		}
			catch (Exception e) {
			
		}
		return arr;
	}
	
	
	
	
	@Test
	public void testThemSach() {
		// test dựa vào exception , bởi vì đã ràng buộc điều kiện trong code----> -> 
		// >>> thêm không đủ dữ liệu->xuất ra message "thêm không thành công"
		// thêm đủ giữ liệu xuất ra --" thêm thành công"
		SachData sachDT=new SachData();
		Sach s= new Sach();
		s.setTenSach("Rừng xà Nốp xà Nu");
		s.setMaSach("ABCDaa");
		s.setLoaiSach("Ngôn Tình ");
		s.setSoLuong(35);
		s.setGiaTien(21);
		s.setNhaXuatBan("Kim Thân");
		s.setTacGia("Nam Nam Nam");
		sachDT.ThemSach(s);
		assertNotEquals("Fail-->Do Thiếu Thông tin Sách Or Tên Sách, Mã Sách Bị Trùng",true,sachDT.them);
		// giống nhau fail , khác true
		// chức năng thêm sách bị sai thêm không thành công phải trả về test case đúng, 
		
		
		
	}
	@Test
	public void testCapNhat() {
		
		SachData sData= new SachData();
		Sach s=new Sach();
		s.setMaSach("ABC");
		s.setGiaTien(2222);
		assertEquals("Cập nhật Không thành công (Sai MÃ Sách)",true, sData.CapNhapThongTinSach(s));
		//them truong hop sai ma sach
		sData = new SachData();
		s= new Sach();
		s.setMaSach("QQQQ");
		s.setGiaTien(22222);
		assertEquals("Cập nhật không thành(Sai Mã Sách) ",true,sData.CapNhapThongTinSach(s));
		
		
	}
	
	@Test
	public void testXoaSach(){
		SachData sData = new SachData();
		String maSach="A531";
		assertEquals("Xóa không thành công!",true, sData.XoaSach(maSach));
		// xóa Đc
		String maSach2="ABCDaa";
		assertEquals("Xóa Không thành Công(Sai MÃ Sách!)",true, sData.XoaSach(maSach2));
		
		
		
	}
	@Test
	public void testTimKiemSach() {
		SachData sData = new SachData();
		String maSach="K34";
		assertEquals("Tìm Không thấy!(MÃ Sách SAi!)",true,sData.TimMaSach(maSach) );
	
		// Null
		String maSach2="ABC";
				assertEquals("Tìm không thấy !(MÃ Sách Sai)",true, sData.TimMaSach(maSach2));

	}
	//Tìm kiếm toàn bộ mã sách có trong data
	@Test
	public void testTimKiemSachToanBoSach() {
		TestDaTaSach te= new TestDaTaSach();
		SachData data= new SachData();
		String [] tam;
		for(int i = 0 ; i < te.getAllSach().size(); i++) {
			tam= te.getAllSach().get(i).split("_");
			for (int j = 0; j < tam.length; j++) {
				
				assertEquals("Fail-->Mã sách không phù hợp ",true,data.TimMaSach(tam[0]));
			}
		}
	}

}
