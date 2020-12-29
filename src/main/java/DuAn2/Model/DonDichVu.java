package DuAn2.Model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "dondichvu")
public class DonDichVu {
	@Id
	private int maDonDichVu;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "maDatPhong")
	private DatPhong datPhong;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "maDichVu")
	private DichVu dichVu;
	private Integer soLuong;
	@Temporal(TemporalType.DATE)
	private Date ngayDat;
	@DateTimeFormat(pattern="HH:mm")
	private java.util.Date gioDat;
	private String thongTinThem;
	private String tenDangNhap;

	
	public java.util.Date getGioDat() {
		return gioDat;
	}

	public void setGioDat(java.util.Date gioDat) {
		this.gioDat = gioDat;
	}

	public String getThongTinThem() {
		return thongTinThem;
	}

	public void setThongTinThem(String thongTinThem) {
		this.thongTinThem = thongTinThem;
	}

	public int getMaDonDichVu() {
		return maDonDichVu;
	}

	public String getTenDangNhap() {
		return tenDangNhap;
	}

	public void setTenDangNhap(String tenDangNhap) {
		this.tenDangNhap = tenDangNhap;
	}

	public Date getNgayDat() {
		return ngayDat;
	}

	public void setNgayDat(Date ngayDat) {
		this.ngayDat = ngayDat;
	}

	public void setMaDonDichVu(int maDonDichVu) {
		this.maDonDichVu = maDonDichVu;
	}

	public DatPhong getDatPhong() {
		return datPhong;
	}

	public void setDatPhong(DatPhong datPhong) {
		this.datPhong = datPhong;
	}

	public DichVu getDichVu() {
		return dichVu;
	}

	public void setDichVu(DichVu dichVu) {
		this.dichVu = dichVu;
	}

	public Integer getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(Integer soLuong) {
		this.soLuong = soLuong;
	}

}
