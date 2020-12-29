package DuAn2.Model;


import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "lichdatphong")
public class LichDatPhong {

	@Id
	private int maLich;
	private String tenNguoiDat;
	private String soDienThoai;
	private Date ngayDat;
	@DateTimeFormat(pattern="HH:mm")
	private java.util.Date gioDat;
	private String thongTinThem;
	private String tenDangNhap;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "maPhong")
	private Phong phong;

	
	public Date getNgayDat() {
		return ngayDat;
	}

	public void setNgayDat(Date ngayDat) {
		this.ngayDat = ngayDat;
	}

	public java.util.Date getGioDat() {
		return gioDat;
	}

	public void setGioDat(java.util.Date gioDat) {
		this.gioDat = gioDat;
	}

	public Integer getMaLich() {
		return maLich;
	}

	public void setMaLich(Integer maLich) {
		this.maLich = maLich;
	}

	public String getTenNguoiDat() {
		return tenNguoiDat;
	}

	public void setTenNguoiDat(String tenNguoiDat) {
		this.tenNguoiDat = tenNguoiDat;
	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	public String getThongTinThem() {
		return thongTinThem;
	}

	public void setThongTinThem(String thongTinThem) {
		this.thongTinThem = thongTinThem;
	}

	public String getTenDangNhap() {
		return tenDangNhap;
	}

	public void setTenDangNhap(String tenDangNhap) {
		this.tenDangNhap = tenDangNhap;
	}

	public Phong getPhong() {
		return phong;
	}

	public void setPhong(Phong phong) {
		this.phong = phong;
	}
	
	
}
