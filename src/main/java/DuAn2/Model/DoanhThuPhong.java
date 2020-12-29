package DuAn2.Model;

public class DoanhThuPhong {
	private Integer soPhong;
	private Integer soLanDat;
	private double tongGia;

	public DoanhThuPhong(Integer soPhong, Integer soLanDat, double tongGia) {
		super();
		this.soPhong = soPhong;
		this.soLanDat = soLanDat;
		this.tongGia = tongGia;
	}

	public Integer getSoPhong() {
		return soPhong;
	}

	public void setSoPhong(Integer soPhong) {
		this.soPhong = soPhong;
	}

	public Integer getSoLanDat() {
		return soLanDat;
	}

	public void setSoLanDat(Integer soLanDat) {
		this.soLanDat = soLanDat;
	}

	public double getTongGia() {
		return tongGia;
	}

	public void setTongGia(double tongGia) {
		this.tongGia = tongGia;
	}

}
