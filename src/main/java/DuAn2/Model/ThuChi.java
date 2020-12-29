package DuAn2.Model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "thuchi")
public class ThuChi {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer maThuChi;
	private String noiDungChi;
	private Integer loaiThuChi;
	private Date ngayChi;
	@DateTimeFormat(pattern = "HH:mm")
	private java.util.Date gioChi;
	private Double soTien;
	private String tenDangNhap;

	
	public Integer getLoaiThuChi() {
		return loaiThuChi;
	}

	public void setLoaiThuChi(Integer loaiThuChi) {
		this.loaiThuChi = loaiThuChi;
	}

	public Double getSoTien() {
		return soTien;
	}

	public void setSoTien(Double soTien) {
		this.soTien = soTien;
	}

	public Integer getMaThuChi() {
		return maThuChi;
	}

	public void setMaThuChi(Integer maThuChi) {
		this.maThuChi = maThuChi;
	}

	public String getNoiDungChi() {
		return noiDungChi;
	}

	public void setNoiDungChi(String noiDungChi) {
		this.noiDungChi = noiDungChi;
	}

	public Date getNgayChi() {
		return ngayChi;
	}

	public void setNgayChi(Date ngayChi) {
		this.ngayChi = ngayChi;
	}

	public java.util.Date getGioChi() {
		return gioChi;
	}

	public void setGioChi(java.util.Date gioChi) {
		this.gioChi = gioChi;
	}

	public String getTenDangNhap() {
		return tenDangNhap;
	}

	public void setTenDangNhap(String tenDangNhap) {
		this.tenDangNhap = tenDangNhap;
	}
}
