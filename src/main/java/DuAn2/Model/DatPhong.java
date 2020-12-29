package DuAn2.Model;

import java.sql.Date;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="datphong")

public class DatPhong {
	
	@Id
	private int maDatPhong;
	private String hoTen;
	@Column(name="sodt")
	private String soDT;
	@Column(name="socmnd")
	private String soCMND;
	private Double tienCoc;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="maPhong")
	private Phong phong;
	@DateTimeFormat(pattern="yyyy-mm-dd")
	private Date ngayDat;
	@DateTimeFormat(pattern="HH:mm:ss")
	private java.util.Date gioDat;
	private String loaiDat;
	private String tenDangNhap;
	
	@OneToMany(mappedBy="datPhong", fetch = FetchType.LAZY)
	private Collection<DonDichVu> donDichVus;
	
	@OneToMany(mappedBy="datPhong", fetch = FetchType.LAZY)
	private Collection<TraPhong> traPhongs;

	public DatPhong(int maDatPhong, String hoTen, String soDT, Phong phong, Date ngayDat) {
		this.maDatPhong = maDatPhong;
		this.hoTen = hoTen;
		this.soDT = soDT;
		this.phong = phong;
		this.ngayDat = ngayDat;
	}

	public DatPhong() {
	}

	public int getMaDatPhong() {
		return maDatPhong;
	}
	public void setMaDatPhong(int maDatPhong) {
		this.maDatPhong = maDatPhong;
	}
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public String getSoDT() {
		return soDT;
	}
	
	public String getLoaiDat() {
		return loaiDat;
	}
	public void setLoaiDat(String loaiDat) {
		this.loaiDat = loaiDat;
	}
	public void setSoDT(String soDT) {
		this.soDT = soDT;
	}
	public String getSoCMND() {
		return soCMND;
	}
	public void setSoCMND(String soCMND) {
		this.soCMND = soCMND;
	}
	public Double getTienCoc() {
		return tienCoc;
	}
	public void setTienCoc(Double tienCoc) {
		this.tienCoc = tienCoc;
	}
	public Phong getPhong() {
		return phong;
	}
	public void setPhong(Phong phong) {
		this.phong = phong;
	}
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
	
	public String getTenDangNhap() {
		return tenDangNhap;
	}
	public void setTenDangNhap(String tenDangNhap) {
		this.tenDangNhap = tenDangNhap;
	}
	public Collection<DonDichVu> getDonDichVus() {
		return donDichVus;
	}
	public void setDonDichVus(Collection<DonDichVu> donDichVus) {
		this.donDichVus = donDichVus;
	}
	public Collection<TraPhong> getTraPhongs() {
		return traPhongs;
	}
	public void setTraPhongs(Collection<TraPhong> traPhongs) {
		this.traPhongs = traPhongs;
	}


	
}
