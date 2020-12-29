package DuAn2.Services;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import DuAn2.Model.Phong;

public interface Ittp extends CrudRepository<Phong, Integer> {

	@Query("SELECT p FROM Phong p WHERE p.soPhong = ?1 or p.loaiPhong.tenLoaiPhong = ?2")
	public List<Phong> TimPhong(Integer soPhong,String loaiPhong);
	
	@Query("SELECT p FROM Phong p ORDER BY tang,soPhong ASC")
	public List<Phong> findAllOrderByASC();
	
	@Query("SELECT p FROM Phong p ORDER BY p.maPhong DESC")
	public List<Phong> findAllOrderByMaDesc(PageRequest pageRequest);
	
	@Query("SELECT count(0) FROM Phong p")
	public Integer countFindAll();
	
	@Query("SELECT p FROM Phong p where p.trangThai = 1 or p.trangThai = 2 ORDER BY p.tang, p.soPhong ASC")
	public List<Phong> findFilterPCKOrderByASC();
	
	@Query("SELECT p FROM Phong p where p.trangThai = 0 ORDER BY p.tang, p.soPhong ASC")
	public List<Phong> findFilterPTOrderByASC();
	
	@Query("SELECT p FROM Phong p where p.countDatLich > 0 and p.countDatLich is not null")
	public List<Phong> findFilterPDTOrderByASC();
	
	@Query(value = "SELECT count(0) FROM phong where trang_thai = 1 or trang_thai = 2", nativeQuery = true)
	public Integer countPhongCoKhach();
	
	@Query(value = "SELECT count(0) FROM phong where trang_thai = 0", nativeQuery = true)
	public Integer countPhongTrong();
	
	@Query(value = "SELECT count(0) FROM phong where trang_thai = 2", nativeQuery = true)
	public Integer countPhongDatTruoc();
	
	@Query(value = "select count(0) from datphong dp where dp.ma_phong = ?1 and dp.loai_dat = 'homestay' AND dp.ma_dat_phong not in (select ma_dat_phong from traphong)", nativeQuery = true)
	public Integer countHomestayByMaPhong(Integer maPhong);
}
