package DuAn2.Services;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import DuAn2.Model.LichDatPhong;

public interface LichDatPhongService extends CrudRepository<LichDatPhong, Integer> {

	@Query("select l from LichDatPhong l where l.phong.maPhong = ?1")
	List<LichDatPhong> listDatPhongByMaPhong(Integer maPhong);
	
	@Query("select l from LichDatPhong l order by l.ngayDat asc, l.gioDat asc")
	List<LichDatPhong> tongdsdatlich();
	
	@Query("select count(0) from LichDatPhong l where l.phong.maPhong = ?1")
	Integer countDatLich(Integer maPhong);
	
	@Query(value = "select l.ma_phong from lichdatphong l group by l.ma_phong", nativeQuery = true)
	List<Integer> listLichDatPhongCount();
}
