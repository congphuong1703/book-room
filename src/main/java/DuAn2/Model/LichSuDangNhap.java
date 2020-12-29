package DuAn2.Model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="lichsudangnhap")
public class LichSuDangNhap {

	@Id
	private int maLichSuDangNhap;
	@Column(name="ngayDangNhap")
	private Date ngayDangNhap;
	@Column(name="gioDangNhap")
	@DateTimeFormat(pattern="HH:mm")
	private java.util.Date gioDangNhap;
	@Column(name="taiKhoanDangNhap")
	private String taiKhoanDangNhap;
	public int getMaLichSuDangNhap() {
		return maLichSuDangNhap;
	}
	public void setMaLichSuDangNhap(int maLichSuDangNhap) {
		this.maLichSuDangNhap = maLichSuDangNhap;
	}
	public Date getNgayDangNhap() {
		return ngayDangNhap;
	}
	public void setNgayDangNhap(Date ngayDangNhap) {
		this.ngayDangNhap = ngayDangNhap;
	}
	public java.util.Date getGioDangNhap() {
		return gioDangNhap;
	}
	public void setGioDangNhap(java.util.Date gioDangNhap) {
		this.gioDangNhap = gioDangNhap;
	}
	public String getTaiKhoanDangNhap() {
		return taiKhoanDangNhap;
	}
	public void setTaiKhoanDangNhap(String taiKhoanDangNhap) {
		this.taiKhoanDangNhap = taiKhoanDangNhap;
	}
	
	
}
