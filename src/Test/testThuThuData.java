package Test;

import static org.junit.Assert.assertNotEquals;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.junit.Test;
import org.junit.jupiter.params.shadow.com.univocity.parsers.common.ParsingContextSnapshot;

import Data.Connect;
import Data.ThuThuData;
import Object.ThuThu;


	


public class testThuThuData {
	public static PreparedStatement ps;
	public static ResultSet rs;

	public ArrayList<ThuThu> getAllThuThu(){
		ArrayList<ThuThu> arr = new ArrayList<ThuThu>(); 
		try {
			
			ps = Connect.getConnect().prepareStatement("SELECT * from DangNhap");
			rs=ps.executeQuery();
			while(rs.next()) {
				ThuThu tt = new ThuThu(rs.getString("TaiKhoan"), rs.getString("MatKhau"));
				arr.add(tt);
			}
			
			
		}
			
		 catch (Exception e) {
			
		}
		return arr;
	}
	@Test
	public void testCase() {
		testThuThuData teData =new testThuThuData();
		ThuThuData data = new ThuThuData();
		for(int i=0; i < teData.getAllThuThu().size() ; i++) {
			System.out.println(teData.getAllThuThu().get(i).getMaThuThu());
			assertNotEquals("Error Dang Nhap", null ,data.dangNhap(teData.getAllThuThu().get(i).getMaThuThu(), teData.getAllThuThu().get(i).getMKThuThu()));
		}
	}
	@Test
	public void testCase2Fail() {
		
		testThuThuData teData= new  testThuThuData();
		ThuThuData data= new ThuThuData();
		ArrayList<ThuThu> arr=teData.getAllThuThu();
		arr.add(new ThuThu("Nam","12345"));
		for (int i = 0; i < arr.size(); i++) {
			System.out.println(arr.get(i).getMaThuThu());
			assertNotEquals("Error Dang Nhap "+ "Vị Trí Sai"+ i,null,data.dangNhap(arr.get(i).getMaThuThu(),arr.get(i).getMKThuThu())) ;
			// null, Nam = null => false tai vi tri Nam
		}
		
		
			
		}
	
}
 

	
	


