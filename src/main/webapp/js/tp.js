function formatNumber(val ,n, x, s, c) {
    var re = '\\d(?=(\\d{' + (x || 3) + '})+' + (n > 0 ? '\\D' : '$') + ')',
        num = val.toFixed(Math.max(0, ~~n));

    return (c ? num.replace('.', c) : num).replace(new RegExp(re, 'g'), '$&' + (s || ','));
};

function changeTime() {
	$("#loading").show();
	var maPhong = $("#maPhong").val();
	var soPhong = $("#soPhong").val();
	var trangThai = $("#trangThai").val();
	var ngayTra = $("#ngayTra").val();
	var gioTra = $("#gioTra").val();
	$.ajax({
		type : "GET",
		contentType : "application/json",
		url : "changeTimeTraPhong",
		data : {
			maPhong : maPhong,
			soPhong : soPhong,
			trangThai : trangThai,
			ngayTra : ngayTra,
			gioTra : gioTra
		},
		dataType : 'json',
		timeout : 100000,
		success : function(data) {
			$("#loading").hide();
			$(".ThoiGianThueLable").html(data.soGioThue!=null?"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Số giờ đã thuê":"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Số ngày đã thuê");
			$(".ThoiGianThueValue").html(data.soGioThue!=null?data.soGioThue + "&nbsp;giờ":data.soNgayThue + "&nbsp;ngày");
			$("#tongTien").val(data.tongTien);
			$(".tongTienTrai").html(formatNumber(data.tongTien, 0, 3, ',') + "&nbsp;VND");
			$("#tongTienPhai").html("Tổng tiền cần thanh toán:&nbsp;&nbsp;&nbsp;" + formatNumber(data.tongTien, 0, 3, ',') + "&nbsp;VNĐ");
			$(".tienphong").html(formatNumber(data.tienPhong, 0, 3, ',') + "&nbsp;VND");
		}
	});
}