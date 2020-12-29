package DuAn2.Services;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import DuAn2.Model.LoaiPhong;



public interface ILoaiphongSercives extends CrudRepository<LoaiPhong, String> {
	@Query("select lp from LoaiPhong lp where lp.maLoaiPhong = ?1 or lp.tenLoaiPhong = ?2")
	public List<LoaiPhong> ListFindtdnOrName(Integer maLoaiPhong, String tenLoaiPhong);
}
