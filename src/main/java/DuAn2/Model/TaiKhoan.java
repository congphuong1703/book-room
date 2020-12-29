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
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name = "taikhoan")
public class TaiKhoan {
	@Id
	private int Id;
	@NotBlank(message = "- Tên đăng nhập không được trống")
	private String tenDangNhap;
	@NotBlank(message = "- Mật khẩu không được trống")
	@Length(min = 8, message = "- Mật khẩu phải từ 8 kí tự trở lên")
	private String matKhau;
	@NotBlank(message = "- Họ và tên không được trống")
	private String hoTen;
	@NotBlank(message = "- Giới tính không được trống")
	private String gioiTinh;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull(message = "- Ngày sinh không được trống")
	@Past(message = "- Ngày sinh phải trong quá khứ")
	private Date ngaySinh;
	@NotBlank(message = "- Số chứng minh không được trống")
	private String cmnd;
	@Length(min = 9, max = 15, message = "- Số điện thoại không hợp lệ")
	@NotBlank(message = "- Số điện thoại không được trống")
	private String soDT;
	@NotBlank(message = "- Email không được trống")
	private String email;
	@Temporal(TemporalType.DATE)
	private Date ngayTao;
	@DateTimeFormat(pattern = "HH:mm")
	private java.util.Date gioTao;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "maChucVu")
	private ChucVu chucVu;

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public Date getNgayTao() {
		return ngayTao;
	}

	public void setNgayTao(Date ngayTao) {
		this.ngayTao = ngayTao;
	}

	public java.util.Date getGioTao() {
		return gioTao;
	}

	public void setGioTao(java.util.Date gioTao) {
		this.gioTao = gioTao;
	}

	public String getTenDangNhap() {
		return tenDangNhap;
	}

	public void setTenDangNhap(String tenDangNhap) {
		this.tenDangNhap = tenDangNhap;
	}

	public String getMatKhau() {
		return matKhau;
	}

	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public String getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public Date getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public String getCmnd() {
		return cmnd;
	}

	public void setCmnd(String cmnd) {
		this.cmnd = cmnd;
	}

	public String getSoDT() {
		return soDT;
	}

	public void setSoDT(String soDT) {
		this.soDT = soDT;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public ChucVu getChucVu() {
		return chucVu;
	}

	public void setChucVu(ChucVu chucVu) {
		this.chucVu = chucVu;
	}

}
