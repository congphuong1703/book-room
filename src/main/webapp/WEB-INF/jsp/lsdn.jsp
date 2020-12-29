<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@taglib prefix="frm" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

            	  <div class="container">
             <div class="container">
           <form action="timlsdn" >
           
           <div class="row" style="float: right">
           <div class="form-group">
           <div class="input-group">
            <input class="form-control" type="text" name="data" placeholder="Enter the account to look for" maxlength="50" value="${data }" required/>
            <span class="input-group-btn">
             <button class="btn btn-success" type="submit"><span class="glyphicon glyphicon-search" aria-hidden="true"></span><span style="margin-left:2px;"><i class="fa fa-search"></i> Search</span></button>
             </span>
             </div>
            </div>
            </div>
            
            </form>
            </div>
            
            
           <div style="overflow: auto;height: auto;width: 100%;box-shadow: 1px 1px 5px #888888;">
           
           <table class="table table-striped css-serial" style="font-size: 15px;white-space: nowrap;">
           <thead>
           <tr>
           <th style="width: 50px;"></th>
           <th>Account</th><th>Login date</th><th>Login time</th>
           </tr>
           </thead>
           <c:forEach var="u" items="${l }">
           <tr>
           <td></td>
          <td>${u.taiKhoanDangNhap }</td> 
          <td><fmt:formatDate value="${u.ngayDangNhap }" pattern="d/M/yyyy"/></td>
          <td><fmt:formatDate value="${u.gioDangNhap }" pattern="HH:mm"/></td>
         
          </tr>
           </c:forEach>
           </table>
           
           
               </div>
 <c:if test="${danhsach!=0}">
<br>
<ul class="pagination" id="pagination" style="float: right;box-shadow: 1px 1px 5px #888888;">
	<li class="page-item first"><a href="lsdnpage?data=${data }&page=${trangdau }" class="page-link">First page</a></li>
	<li class="page-item prev"><a href="lsdnpage?data=${data }&page=<c:if test="${vitrihientai==1 }">${vitrihientai }</c:if><c:if test="${vitrihientai>1 }">${vitrihientai-1 }</c:if>" class="page-link"><</a></li>
	
	<c:forEach items="${listSoLuongTrang }" var="u">
	<li class="page-item"><a <c:if test="${u == vitrihientai}">style="background-color: rgba(0,0,0,.15);"</c:if> href="lsdnpage?data=${data }&page=${u }" class="page-link">${u }</a></li>
	</c:forEach>
	
	<li class="page-item next"><a href="lsdnpage?data=${data }&page=<c:if test="${vitrihientai==trangcuoi }">${vitrihientai }</c:if><c:if test="${vitrihientai<trangcuoi }">${vitrihientai+1 }</c:if>" class="page-link">></a></li>
	<li class="page-item last"><a href="lsdnpage?data=${data }&page=${trangcuoi }" class="page-link">Last page</a></li>
</ul>
<br><br>
</c:if>



 <c:if test="${ not empty danhsachtim}">
 <br>
<ul class="pagination" id="pagination" style="float: right;box-shadow: 1px 1px 5px #888888;">
	<li class="page-item first"><a href="lsdnpagetim?data=${data }&page=${trangdau }" class="page-link">First page</a></li>
	<li class="page-item prev"><a href="lsdnpagetim?data=${data }&page=<c:if test="${vitrihientai==1 }">${vitrihientai }</c:if><c:if test="${vitrihientai>1 }">${vitrihientai-1 }</c:if>" class="page-link"><</a></li>
	
	<c:forEach items="${listSoLuongTrang }" var="u">
	<li class="page-item"><a <c:if test="${u == vitrihientai}">style="background-color: rgba(0,0,0,.15);"</c:if> href="lsdnpagetim?data=${data }&page=${u }" class="page-link">${u }</a></li>
	</c:forEach>
	
	<li class="page-item next"><a href="lsdnpagetim?data=${data }&page=<c:if test="${vitrihientai==trangcuoi }">${vitrihientai }</c:if><c:if test="${vitrihientai<trangcuoi }">${vitrihientai+1 }</c:if>" class="page-link">></a></li>
	<li class="page-item last"><a href="lsdnpagetim?data=${data }&page=${trangcuoi }" class="page-link">Last page</a></li>
</ul>
<br><br>
</c:if>
            </div>

          
            
         

       