package DuAn2.Services;

import java.util.List;

import DuAn2.Model.Phong;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import DuAn2.Model.DatPhong;

public interface IttkhService extends CrudRepository<DatPhong, Integer>{

	@Query("SELECT dp from DatPhong dp WHERE dp.hoTen = ?1 or dp.soDT = ?1 or dp.soCMND = ?1 order by dp.maDatPhong desc")
	public List<DatPhong> timttkh(String id, PageRequest pageRequest);
	
	@Query("SELECT count(0) from DatPhong dp WHERE dp.hoTen = ?1 or dp.soDT = ?1 or dp.soCMND = ?1")
	public Double countTimttkh(String id);
	
	@Query("SELECT dp from DatPhong dp order by dp.maDatPhong desc")
	public List<DatPhong> findAllOrderBy(PageRequest pageRequest);
	
	@Query("SELECT count(0) from DatPhong dp")
	public Double countfindAll();

	public List<DatPhong> findAllByPhongMaPhongOrderByNgayDatDesc(int maPhong);

}
