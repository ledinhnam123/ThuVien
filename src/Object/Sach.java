package Object;

public class Sach {
	private String nhaXuatBan;
	private String tenSach;
	private String loaiSach;
	private String tacGia;
	private int giaTien;
	private int soLuong;
	private String maSach;
	
	public Sach() {}

	public Sach(String maSach,String tenSach,String loaiSach, String tacGia,String nhaXuatBan, int giaTien,int soLuong) {
		this.maSach = maSach;
		this.tenSach = tenSach;
		this.loaiSach = loaiSach;
		this.tacGia = tacGia;
		this.nhaXuatBan = nhaXuatBan;
		this.giaTien = giaTien;
		this.soLuong = soLuong;
	}

	public String getNhaXuatBan() {
		return nhaXuatBan;
	}

	public void setNhaXuatBan(String nhaXuatBan) {
		this.nhaXuatBan = nhaXuatBan;
	}

	public String getTenSach() {
		return tenSach;
	}

	public void setTenSach(String tenSach) {
		this.tenSach = tenSach;
	}

	public String getLoaiSach() {
		return loaiSach;
	}

	public void setLoaiSach(String loaiSach) {
		this.loaiSach = loaiSach;
	}

	public String getTacGia() {
		return tacGia;
	}

	public void setTacGia(String tacGia) {
		this.tacGia = tacGia;
	}

	public int getGiaTien() {
		return giaTien;
	}

	public void setGiaTien(int giaTien) {
		this.giaTien = giaTien;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public String getMaSach() {
		return maSach;
	}

	public void setMaSach(String maSach) {
		this.maSach = maSach;
	}	
	
	
}
