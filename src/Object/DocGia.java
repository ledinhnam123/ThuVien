package Object;

public class DocGia {
	private String TaiKhoan;
	private String MatKhau;
	private String Ten;
	private String DiaChi;
	private String SoDienThoai;
	private String Email;
	public DocGia() {}
	public DocGia(String TK, String MK, String ten,  String DC, String SDT, String Email) {
		this.TaiKhoan = TK;
		this.MatKhau = MK;
		this.Ten = ten;
		this.DiaChi = DC;
		this.SoDienThoai = SDT;
		this.Email = Email;
	}
	public String getTaiKhoan() {
		return TaiKhoan;
	}
	public void setTaiKhoan(String taiKhoan) {
		TaiKhoan = taiKhoan;
	}
	public String getMatKhau() {
		return MatKhau;
	}
	public void setMatKhau(String matKhau) {
		MatKhau = matKhau;
	}
	public String getTen() {
		return Ten;
	}
	public void setTen(String ten) {
		Ten = ten;
	}
	public String getDiaChi() {
		return DiaChi;
	}
	public void setDiaChi(String diaChi) {
		DiaChi = diaChi;
	}
	public String getSoDienThoai() {
		return SoDienThoai;
	}
	public void setSoDienThoai(String soDienThoai) {
		SoDienThoai = soDienThoai;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
}
