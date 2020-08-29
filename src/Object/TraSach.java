package Object;

import java.sql.Date;

public class TraSach {
	
	
	private String maPhieuMuon;
    private String maDocGia;
    private String maSach;
    private Date ngayMuon;
    private Date hanTra;
    private Date ngayTra;
    private int tienTra;
    private int tienCoc;
    
    public TraSach() {
        
    }
    
    public TraSach(String maPhieuMuon, String maDocGia, String maSach, Date ngayMuon, Date hanTra,int tienCoc,Date ngayTra,int tienTra) {
        this.maPhieuMuon = maPhieuMuon;
        this.maDocGia = maDocGia;
        this.maSach = maSach;
        this.ngayMuon = ngayMuon;
        this.hanTra = hanTra;
        this.tienCoc = tienCoc;
        this.ngayTra = ngayTra;
        this.tienTra = tienTra;
    }
	public Date getNgayTra() {
		return ngayTra;
	}

	public void setNgayTra(Date ngayTra) {
		this.ngayTra = ngayTra;
	}

	public int getTienTra() {
		return tienTra;
	}

	public void setTienTra(int tienTra) {
		this.tienTra = tienTra;
	}

	public int getTienCoc() {
		return tienCoc;
	}

	public void setTienCoc(int tienCoc) {
		this.tienCoc = tienCoc;
	}

	public String getMaPhieuMuon() {
		return maPhieuMuon;
	}

	public void setMaPhieuMuon(String maPhieuMuon) {
		this.maPhieuMuon = maPhieuMuon;
	}

	public String getMaDocGia() {
		return maDocGia;
	}

	public void setMaDocGia(String maDocGia) {
		this.maDocGia = maDocGia;
	}

	public String getMaSach() {
		return maSach;
	}

	public void setMaSach(String maSach) {
		this.maSach = maSach;
	}

	public Date getNgayMuon() {
		return ngayMuon;
	}

	public void setNgayMuon(Date ngayMuon) {
		this.ngayMuon = ngayMuon;
	}

	public Date getHanTra() {
		return hanTra;
	}

	public void setHanTra(Date hanTra) {
		this.hanTra = hanTra;
	}
}
