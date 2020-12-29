package DuAn2.Services;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


import DuAn2.Model.DonDichVu;

public interface Ilsdv extends CrudRepository<DonDichVu, Integer> {
	
	@Query("SELECT ddv FROM DonDichVu ddv ORDER BY ddv.maDonDichVu DESC")
	public List<DonDichVu> findAllOrderByMaDesc(PageRequest pageRequest);
	
	@Query("SELECT count(0) FROM DonDichVu ddv")
	public Double countFindAll();

	@Query("SELECT ddv FROM DonDichVu ddv WHERE ddv.maDonDichVu = ?1 OR ddv.datPhong.maDatPhong = ?2 OR ddv.dichVu.tenDichVu = ?3 or ddv.dichVu.loaiDichVu = ?3 or ddv.ngayDat = ?4 ORDER BY ddv.maDonDichVu DESC")
	public List<DonDichVu> timlsdv(Integer maddv,Integer madp, String tendv,java.util.Date ngaydat, PageRequest pageRequest);
	
	@Query("SELECT count(0) FROM DonDichVu ddv WHERE ddv.maDonDichVu = ?1 OR ddv.datPhong.maDatPhong = ?2 OR ddv.dichVu.tenDichVu = ?3 or ddv.dichVu.loaiDichVu = ?3 or ddv.ngayDat = ?4")
	public Double countTimlsdv(Integer maddv,Integer madp, String tendv,java.util.Date ngaydat);
	
	@Query("SELECT ddv FROM DonDichVu ddv WHERE ddv.ngayDat BETWEEN ?1 and ?2")
	public List<DonDichVu> timdsvtungaydenngay(java.util.Date tungay,java.util.Date denngay);
}
