package DuAn2.Services;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import DuAn2.Model.LichSuDangNhap;

public interface LichSuDangNhapService extends CrudRepository<LichSuDangNhap, Integer> {

	@Query("select d from LichSuDangNhap d where d.taiKhoanDangNhap = ?1 ORDER BY ngayDangNhap desc, gioDangNhap desc")
	public List<LichSuDangNhap> timlsdn(String data, PageRequest pageRequest);
	
	@Query("select count(0) from LichSuDangNhap d where d.taiKhoanDangNhap = ?1")
	public Double countTimlsdn(String data);
	
	@Query("select d from LichSuDangNhap d ORDER BY ngayDangNhap desc, gioDangNhap desc")
	public List<LichSuDangNhap> findAllOrderBy(PageRequest pageRequest);
	
	@Query("select count(0) from LichSuDangNhap d")
	public Double countFindAll();
}
