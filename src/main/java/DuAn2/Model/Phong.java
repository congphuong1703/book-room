package DuAn2.Model;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
@Entity
@Table(name="phong")
public class Phong {
	@Id
	private int maPhong;
	@NotNull(message="- Số phòng không được trống")
	private Integer soPhong;
	@NotNull(message="- Số tầng không được trống")
	private Integer tang;
	private String tienNghi;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="maLoaiPhong")
	private LoaiPhong loaiPhong;
	
	private String hinhAnh;
	@NotNull(message="- Giá không được trống")
	private Double giaPhong;
	@NotNull(message="- Giá giờ đầu không được trống")
	private Double giaPhongGioDau;
	@NotNull(message="- Giá giờ tiếp theo không được trống")
	private Double giaPhongGioSau;
	@NotNull(message="- Giá homestay không được trống")
	private Double giaHomestay;
	@NotNull(message="- Khuyến mãi không được trống")
	private String khuyenMai;
	private Integer trangThai;
	private Integer countHomestay;
	private Integer countDatLich;
	@OneToMany(mappedBy="phong", fetch = FetchType.LAZY)
	
	private Collection<DatPhong> datPhongs;
	
	@OneToMany(mappedBy="phong", fetch = FetchType.LAZY)
	private Collection<LichDatPhong> lichDatPhongs;

	
	public Collection<LichDatPhong> getLichDatPhongs() {
		return lichDatPhongs;
	}

	public void setLichDatPhongs(Collection<LichDatPhong> lichDatPhongs) {
		this.lichDatPhongs = lichDatPhongs;
	}

	public int getMaPhong() {
		return maPhong;
	}

	public void setMaPhong(int maPhong) {
		this.maPhong = maPhong;
	}

	public Integer getSoPhong() {
		return soPhong;
	}

	public void setSoPhong(Integer soPhong) {
		this.soPhong = soPhong;
	}
	

	public Double getGiaPhongGioDau() {
		return giaPhongGioDau;
	}

	public void setGiaPhongGioDau(Double giaPhongGioDau) {
		this.giaPhongGioDau = giaPhongGioDau;
	}

	public Double getGiaPhongGioSau() {
		return giaPhongGioSau;
	}

	public void setGiaPhongGioSau(Double giaPhongGioSau) {
		this.giaPhongGioSau = giaPhongGioSau;
	}

	public Integer getTang() {
		return tang;
	}

	public void setTang(Integer tang) {
		this.tang = tang;
	}

	public String getTienNghi() {
		return tienNghi;
	}

	public void setTienNghi(String tienNghi) {
		this.tienNghi = tienNghi;
	}

	public LoaiPhong getLoaiPhong() {
		return loaiPhong;
	}

	public void setLoaiPhong(LoaiPhong loaiPhong) {
		this.loaiPhong = loaiPhong;
	}

	public String getHinhAnh() {
		return hinhAnh;
	}

	public void setHinhAnh(String hinhAnh) {
		this.hinhAnh = hinhAnh;
	}

	public Double getGiaPhong() {
		return giaPhong;
	}

	public void setGiaPhong(Double giaPhong) {
		this.giaPhong = giaPhong;
	}

	public String getKhuyenMai() {
		return khuyenMai;
	}

	public void setKhuyenMai(String khuyenMai) {
		this.khuyenMai = khuyenMai;
	}

	public Integer getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(Integer trangThai) {
		this.trangThai = trangThai;
	}

	public Collection<DatPhong> getDatPhongs() {
		return datPhongs;
	}

	public void setDatPhongs(Collection<DatPhong> datPhongs) {
		this.datPhongs = datPhongs;
	}

	public Integer getCountHomestay() {
		return countHomestay;
	}

	public void setCountHomestay(Integer countHomestay) {
		this.countHomestay = countHomestay;
	}

	public Double getGiaHomestay() {
		return giaHomestay;
	}

	public void setGiaHomestay(Double giaHomestay) {
		this.giaHomestay = giaHomestay;
	}

	
	public Integer getCountDatLich() {
		return countDatLich;
	}

	public void setCountDatLich(Integer countDatLich) {
		this.countDatLich = countDatLich;
	}
	
	
}
