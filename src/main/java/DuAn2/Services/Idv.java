package DuAn2.Services;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import DuAn2.Model.DonDichVu;

public interface Idv extends CrudRepository<DonDichVu, Integer>{

	@Query("SELECT ddv FROM DonDichVu ddv WHERE ddv.datPhong.maDatPhong = ?1")
	public List<DonDichVu> datdichvu(int madatphong);
}
