package DuAn2.Services;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import DuAn2.Model.Phong;




public interface QuanLyPhongService extends CrudRepository<Phong, Integer> {
	@Query("SELECT p FROM Phong p WHERE p.soPhong = ?1 or p.tang = ?1")
	public List<Phong> TimMaPhong(int id, PageRequest pageRequest);
	
	@Query("SELECT p FROM Phong p WHERE p.soPhong = ?1 or p.tang = ?1")
	public List<Phong> TimMaPhong(int id);
	
	@Query("SELECT count(0) FROM Phong p WHERE p.soPhong = ?1 or p.tang = ?1")
	public Double countTimMaPhong(int id);
	
	@Query("SELECT p FROM Phong p ORDER BY p.maPhong DESC")
	public List<Phong> findAllOrderByMaDesc();

	public List<Phong> findAll();

	public List<Phong> findAllByGiaPhongLessThanAndLoaiPhongTenLoaiPhong(double maxPrice,String typeRoom);

	@Query("select p from Phong p where p.trangThai = 1")
	public List<Phong> findAllByTrangThai();

	public List<Phong> findAllByLoaiPhongTenLoaiPhong(String roomType);

	@Query("select p from Phong p where p.trangThai = 1 and p.maPhong = ?1")
	public List<Phong> findAllByTrangThaiAndMaPhong(int maPhong);

	public Phong getByMaPhong(int maPhong);

}
