package DuAn2.Services;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import DuAn2.Model.TaiKhoan;

public interface ITaikhoanServices extends CrudRepository<TaiKhoan, String> {
	
	@Query("select tk from TaiKhoan tk")
	public List<TaiKhoan> findAllTk(PageRequest pageRequest);
	
	@Query("select count(0) from TaiKhoan tk")
	public Double countFindAllTk();

	@Query("select tk from TaiKhoan tk where tk.tenDangNhap = ?1 or tk.hoTen = ?1 or tk.cmnd = ?1 or tk.soDT = ?1 or tk.email = ?1")
	public List<TaiKhoan> ListFindtdnOrName(String data, PageRequest pageRequest);
	
	@Query("select count(0) from TaiKhoan tk where tk.tenDangNhap = ?1 or tk.hoTen = ?1 or tk.cmnd = ?1 or tk.soDT = ?1 or tk.email = ?1")
	public Double countListFindtdnOrName(String data);
	
	@Query("select tk from TaiKhoan tk where tk.tenDangNhap = ?1 and tk.matKhau = ?2")
	public List<TaiKhoan> findUser(String tendangnhap,String matkhau);
}
