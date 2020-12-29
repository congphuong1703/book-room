package DuAn2.Services;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import DuAn2.Model.TraPhong;

public interface ITraPhong extends CrudRepository<TraPhong, Integer> {

	@Query("SELECT tp FROM TraPhong tp WHERE tp.ngayTra BETWEEN ?1 and ?2")
	public List<TraPhong> timtkdt(Date tungay, Date denngay);

	public List<TraPhong> findAll();

	public TraPhong getByDatPhongMaDatPhong(int maDatPhong);
}
