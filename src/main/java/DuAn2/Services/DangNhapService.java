package DuAn2.Services;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import DuAn2.Model.TaiKhoan;


public interface DangNhapService extends CrudRepository<TaiKhoan, String> {

	@Query("SELECT tk FROM TaiKhoan tk WHERE tk.tenDangNhap = ?1 and tk.matKhau = ?2")
	public List<TaiKhoan> TimTenDangNhap(String tendangnhap, String matkhau);
}
