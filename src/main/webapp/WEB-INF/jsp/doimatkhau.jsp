
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@taglib prefix="frm" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

              	
<div class="container">
<!-- thông báo lỗi ngoại lệ form -->
<frm:form modelAttribute="taikhoan">
           <c:if test="${not empty errors }">
           <div class="alert alert-danger">
    <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
    <strong>Lỗi!</strong>
    <p><frm:errors path="*" ></frm:errors></p>
  </div>
  </c:if>
  </frm:form>
  <!-- thông báo khi sửa hoặc xóa thành công -->
  
  <c:if test="${not empty messageloi }">
           <div class="alert alert-danger">
    <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
    
    <strong>${messageloi }</strong>
  </div>
  </c:if>
  
  <c:if test="${not empty message }">
           <div class="alert alert-success">
    <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
    
    <strong>${message }</strong>
  </div>
  </c:if>
  </div>
           
                  
           
          <div class="container">
          
          <div class="breadcrumb" style="box-shadow: 1px 1px 5px #888888;">
<div>
	  
	  
	   <frm:form action="actiondoimatkhau" modelAttribute="taikhoan">
	   
	   <div class="form-group">
		<label for="matkhaucu" style="font-weight: bold;">Old password:</label>
		<div class="col-sm-10">
			<input type="password" name="matkhaucu" id="matkhaucu" class="form-control" placeholder="Enter your old password" maxlength="100" required="required">
		</div>
	</div>
	<frm:hidden path="tenDangNhap" value="${gettaikhoan.tenDangNhap }"/>
	<frm:hidden path="hoTen" value="${gettaikhoan.hoTen }"/>
	<frm:hidden path="gioiTinh" value="${gettaikhoan.gioiTinh }"/>
	<frm:hidden path="ngaySinh" value="${gettaikhoan.ngaySinh }"/>
	<frm:hidden path="cmnd" value="${gettaikhoan.cmnd }"/>
	<frm:hidden path="soDT" value="${gettaikhoan.soDT }"/>
	<frm:hidden path="email" value="${gettaikhoan.email }"/>
	<frm:hidden path="chucVu.maChucVu" value="${gettaikhoan.chucVu.maChucVu }"/>
	<div class="form-group">
		<label for="matkhaumoi" style="font-weight: bold;">A new password:</label>
		<div class="col-sm-10">
			<input type="password" name="matkhaumoi" id="matkhaumoi" class="form-control" placeholder="Enter your new password" maxlength="100" required="required" >
		</div>
	</div>
	  
             <div class="form-group">
		<label for="xacnhanmatkhaumoi" style="font-weight: bold;">Confirm new password:</label>
		<div class="col-sm-10">
			<frm:input path="matKhau" type="password"  class="form-control" placeholder="Confirm new password" maxlength="100" required="required" ></frm:input>
		</div>
	</div>
           
         <div class="container">
			<button type="submit" class="btn btn-success btn-xs">Agree</button>
		</div>
           
             </frm:form>
             
             
             
       </div></div></div>
           
          