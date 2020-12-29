package DuAn2.Services;

import java.sql.Date;
import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import DuAn2.Model.DatPhong;


public interface Ilsdtp extends CrudRepository<DatPhong, Integer>{
	
	@Query(value = "SELECT dp FROM DatPhong dp ORDER BY dp.maDatPhong DESC")
	public List<DatPhong> findAllOrderByMaDesc(PageRequest pageRequest);
	
	@Query(value = "SELECT count(0) FROM DatPhong dp")
	public Double countFindAll();

	@Query("SELECT dp FROM DatPhong dp WHERE dp.ngayDat BETWEEN ?1 and ?2")
	public List<DatPhong> timlsdtp(Date tungay,Date denngay);
	
	@Query("SELECT dp FROM DatPhong dp where (dp.phong.trangThai=1 or dp.phong.trangThai=2) and dp.maDatPhong not in (select tp.datPhong.maDatPhong from TraPhong tp) ORDER BY dp.phong.tang,dp.phong.soPhong ASC")
	public List<DatPhong> timtrangthai();
	
	@Query("SELECT p FROM DatPhong p WHERE p.phong.maPhong = ?1")
	public List<DatPhong> timphongchuatra(int maPhong);
	
	@Query("SELECT p FROM DatPhong p WHERE p.maDatPhong = ?1 or p.hoTen=?2 or p.soDT=?2 or p.soCMND = ?2 or p.phong.soPhong = ?2 or p.ngayDat=?3 or p.tenDangNhap=?2")
	public List<DatPhong> timlsdtp(int maPhong,String data,java.util.Date date,PageRequest pageRequest);
	
	@Query("SELECT count(0) FROM DatPhong p WHERE p.maDatPhong = ?1 or p.hoTen=?2 or p.soDT=?2 or p.soCMND = ?2 or p.phong.soPhong = ?2 or p.ngayDat=?3 or p.tenDangNhap=?2")
	public Double countTimlsdtp(int maPhong,String data,java.util.Date date);
	
	@Query("SELECT p.phong FROM DatPhong p WHERE p.phong.trangThai = 1")
	public List<DatPhong> timtang();
	
	@Query(value = "select dp.* from datphong dp where dp.ma_phong = ?1 and dp.loai_dat = 'homestay' AND dp.ma_dat_phong not in (select ma_dat_phong from traphong)", nativeQuery = true)
	public List<DatPhong> listHomestayByMaPhong(Integer maPhong);
	
}
