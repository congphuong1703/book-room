package DuAn2.Services;

import java.sql.Date;
import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import DuAn2.Model.ThuChi;

public interface ThuChiService extends CrudRepository<ThuChi, Integer>{

	@Query("SELECT tc FROM ThuChi tc order by tc.ngayChi desc, tc.gioChi desc")
	public List<ThuChi> getThuChi(PageRequest pageRequest);
	
	@Query("SELECT tc FROM ThuChi tc order by tc.ngayChi desc, tc.gioChi desc")
	public List<ThuChi> getThuChi();
	
	@Query("SELECT sum(tc.soTien) FROM ThuChi tc where tc.loaiThuChi = 1")
	public Double getTongChi();
	
	@Query("SELECT sum(tc.soTien) FROM ThuChi tc where tc.loaiThuChi = 0")
	public Double getTongThu();
	
	@Query("SELECT count(0) FROM ThuChi tc")
	public Double countThuChi();
	
	@Query("SELECT tc FROM ThuChi tc where tc.loaiThuChi = 0 order by tc.ngayChi desc, tc.gioChi desc")
	public List<ThuChi> getThu();
	
	@Query("SELECT tc FROM ThuChi tc where tc.loaiThuChi = 1 order by tc.ngayChi desc, tc.gioChi desc")
	public List<ThuChi> getChi();
	
	@Query("SELECT tc FROM ThuChi tc where tc.ngayChi between ?1 and ?2 order by tc.ngayChi desc, tc.gioChi desc")
	public List<ThuChi> getTimThuChi(Date tuNgay, Date denNgay, PageRequest pageRequest);
	
	@Query("SELECT tc FROM ThuChi tc where tc.ngayChi between ?1 and ?2 order by tc.ngayChi desc, tc.gioChi desc")
	public List<ThuChi> getTimThuChi(Date tuNgay, Date denNgay);
	
	@Query("SELECT sum(tc.soTien) FROM ThuChi tc where tc.loaiThuChi = 1 and tc.ngayChi between ?1 and ?2 order by tc.ngayChi desc, tc.gioChi desc")
	public Double getTongChiTim(Date tuNgay, Date denNgay);
	
	@Query("SELECT sum(tc.soTien) FROM ThuChi tc where tc.loaiThuChi = 0 and tc.ngayChi between ?1 and ?2 order by tc.ngayChi desc, tc.gioChi desc")
	public Double getTongThuTim(Date tuNgay, Date denNgay);
	
	@Query("SELECT count(0) FROM ThuChi tc where tc.ngayChi between ?1 and ?2")
	public Double countThuChiTim(Date tuNgay, Date denNgay);
}
