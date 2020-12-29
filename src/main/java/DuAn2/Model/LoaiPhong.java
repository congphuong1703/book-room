package DuAn2.Model;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "loaiphong")
public class LoaiPhong {
	@Id
	private int maLoaiPhong;
	@NotBlank(message = "- Loại phòng không được để trống")
	private String tenLoaiPhong;
	@NotBlank(message = "- Mô tả không được để trống")
	private String moTa;

	@OneToMany(mappedBy = "loaiPhong", fetch = FetchType.LAZY)

	private Collection<Phong> phongs;

	public int getMaLoaiPhong() {
		return maLoaiPhong;
	}

	public void setMaLoaiPhong(int maLoaiPhong) {
		this.maLoaiPhong = maLoaiPhong;
	}

	public String getTenLoaiPhong() {
		return tenLoaiPhong;
	}

	public void setTenLoaiPhong(String tenLoaiPhong) {
		this.tenLoaiPhong = tenLoaiPhong;
	}

	public String getMoTa() {
		return moTa;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}

	public Collection<Phong> getPhongs() {
		return phongs;
	}

	public void setPhongs(Collection<Phong> phongs) {
		this.phongs = phongs;
	}
}
