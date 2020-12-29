package DuAn2.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "thongsotheogio")
public class ThongSoTheoGio {
	@Id
	private Integer maThongSo;
	private Integer baoNhieuGioDau;
	private Integer soGioChuyenThanhNgay;

	public Integer getMaThongSo() {
		return maThongSo;
	}

	public void setMaThongSo(Integer maThongSo) {
		this.maThongSo = maThongSo;
	}

	public Integer getBaoNhieuGioDau() {
		return baoNhieuGioDau;
	}

	public void setBaoNhieuGioDau(Integer baoNhieuGioDau) {
		this.baoNhieuGioDau = baoNhieuGioDau;
	}

	public Integer getSoGioChuyenThanhNgay() {
		return soGioChuyenThanhNgay;
	}

	public void setSoGioChuyenThanhNgay(Integer soGioChuyenThanhNgay) {
		this.soGioChuyenThanhNgay = soGioChuyenThanhNgay;
	}

}
