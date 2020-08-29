package Test;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.sql.Date;
import java.util.ArrayList;

import org.junit.Test;

import Data.TraSachData;
import Object.Sach;
import Object.TraSach;

public class testTraSach {

	@Test
	public void testCaseTraSach() {
		
		TraSachData tData = new TraSachData();
		TraSach traSach = new TraSach();
		 traSach.setMaDocGia("A222");
		 traSach.setMaPhieuMuon("AAA");
		 traSach.setMaSach("B553");
		 traSach.setTienCoc(2020);
		 traSach.setHanTra(null);
		 traSach.setNgayTra(null);
		 traSach.setNgayMuon(null);
		 traSach.setTienTra(0);
		 tData.CapThongThongTinTraSach(traSach);
		 assertNotEquals("Không đủ thông tin !",true,tData.themCapnhatthongtintraSach);
		 
		// them khong thanh cong-> test Case Fail
	}
 
}
