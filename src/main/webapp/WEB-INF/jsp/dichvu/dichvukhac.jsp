<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="frm" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

	
<table style="width: 100%;">
	<tr>
		<td>Service name:</td>
		<td><input id="tenDichVu" class="form-control" placeholder="Import service name" maxlength="50" /></td>
	</tr>
	<tr>
		<td>More information:</td>
		<td><input id="thongTinThem" class="form-control" placeholder="Optional" maxlength="254" /></td>
	</tr>
	<tr>
		<td>Service prices:</td>
		<td><input id="giaDichVu" type="number" class="form-control" placeholder="Import service prices" oninput="checkMaxLenghtNumber(this,12)"/></td>
	</tr>
	<tr>
		<td></td>
		<td><button class="btn btn-success btn-xs" onclick="actiondichvukhac(${madatphong})">Add</button></td>
	</tr>
</table>
<script>
function actiondichvukhac(maDatPhong) {
	var tenDichVu = $("#tenDichVu").val();
	var thongTinThem = $("#thongTinThem").val();
	var giaDichVu = $("#giaDichVu").val();
	
	if (tenDichVu.trim() == "" || giaDichVu == "") {
		$("#messageCustom").show();
	} else {
		window.location.href = "actiondichvukhac?maDatPhong=" + maDatPhong + "&tenDichVu=" + tenDichVu + "&thongTinThem=" + thongTinThem + "&giaDichVu=" + giaDichVu;
	}
}
</script>