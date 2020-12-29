package DuAn2.Model;

public class DoanhThuDichVu {
private String tenDichVu;
private double soLuong;
private double gia;


public DoanhThuDichVu(String tenDichVu, double soLuong, double gia) {
	super();
	this.tenDichVu = tenDichVu;
	this.soLuong = soLuong;
	this.gia = gia;
}
public String getTenDichVu() {
	return tenDichVu;
}
public void setTenDichVu(String tenDichVu) {
	this.tenDichVu = tenDichVu;
}
public double getSoLuong() {
	return soLuong;
}
public void setSoLuong(double soLuong) {
	this.soLuong = soLuong;
}
public double getGia() {
	return gia;
}
public void setGia(double gia) {
	this.gia = gia;
}


}
