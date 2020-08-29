package Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.sql.Date;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.junit.validator.PublicClassValidator;

import Data.DocGiaData;
import Data.PhieuMuonData;
import Object.PhieuMuon;

public class testPhieuMuonDaTa {
//	public static void showCelender(Calendar c) {
//		int year= c.get(Calendar.YEAR);
//		int month=c.get(Calendar.MONTH);
//		int day=c.get(Calendar.DAY_OF_MONTH);
//	}
//	boolean expected;
//	String maPM="";
//	public  testPhieuMuonDaTa(String maPM,boolean expected) {
//		
//		this.maPM=maPM;
//		this.expected=expected;
//	}
//	@Parameters
//	public static Collection testData() {
//		return Arrays.asList(new Object[][] {
//			{"ABC",false},{ "AAA",true}
//		});
//	}
//	

	@Test
	public void testThemPhieuMuon() {
		// bat exception để test
		PhieuMuonData data = new PhieuMuonData();

		PhieuMuon pMuon = new PhieuMuon();
		pMuon.setMaPhieuMuon("AAAcc");
		pMuon.setMaDocGia("A111");
		pMuon.setMaSach("A1111");

		pMuon.setTienCoc(120);
		data.ThemPhieuMuon(pMuon);// fail
		/// xét trường hợp thêm 6 keys
		// .....
		assertNotEquals("Sai! Thiếu thông tin Phiếu Mượn Hoặc Phiếu Mượn Bị trùng", true, data.themPhieuMuon);
		

	}

	@Test

	public void testCapNhatTTPhieuMuon() {
		// cập nhật dựa trên MÃ Phiếu Mượn
		PhieuMuonData data = new PhieuMuonData();
		PhieuMuon pm = new PhieuMuon();
		//failues:
		/*
		 * // pm.setMaPhieuMuon("blalala"); pm.setMaDocGia("A234");
		 * pm.setMaSach("b234"); // pm.setTienCoc(200); // //
		 * assertEquals("Cập Nhật Không thành công (Mã Độc Giả, MÃ Sách Fail)",
		 * true,data.CapNhapThongTinPhieuMuon(pm)); //
		 */		
		// runs:
		data = new PhieuMuonData();
		pm = new PhieuMuon();
		pm.setMaPhieuMuon("AAA");
		pm.setMaDocGia("A222");
		pm.setMaSach("B553");
		pm.setTienCoc(2022);

		assertEquals("Cập nhật Không thành công (MÃ Phiếu Mượn  fail)", true, data.CapNhapThongTinPhieuMuon(pm));

	}

	@Test
	public void testXoaPhieuMuon() {
		PhieuMuonData data = new PhieuMuonData();
		// thiếu rang buoc ve do dai cua cac MAPHieuMuon
		String maT = "AAAKKK";

		assertEquals("Xóa Thất Bại Mã Phiếu Mượn Không Đúng", true, data.XoaPhieuMuon(maT));

	}
}
