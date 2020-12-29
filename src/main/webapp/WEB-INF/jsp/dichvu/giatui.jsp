<%@page import="DuAn2.Controller.DvController"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="frm" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<frm:form action="actiongiatui" modelAttribute="donDichVu">
	<table style="width: 100%;">
		<frm:hidden path="datPhong.maDatPhong" value="${madatphong }" />
		<tr>
			<td>Choose an item:</td>
			<td><frm:select class="form-control input-sm"
					path="dichVu.maDichVu">
					<c:forEach var="u" items="${ltendichvugiatui }">
						<frm:option value="${u.maDichVu }" label="${u.tenDichVu }" />
					</c:forEach>
				</frm:select></td>
		</tr>
		<tr>
			<td>Quantity:</td>
			<td><frm:input class="form-control input-sm" type="number"
					path="soLuong" min="1" max="999999" required="required"
					oninput="checkMaxLenghtNumber(this,6)" /></td>
		</tr>
		<tr>
			<td></td>
			<td><frm:button type="submit" class="btn btn-success btn-xs">Add</frm:button></td>
		</tr>
	</table>
</frm:form>
