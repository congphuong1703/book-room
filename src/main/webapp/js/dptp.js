function showThaoTac(maPhong) {
	// phần nhấn vô hiện menu chọn cách đặt phòng
	if ($("#thaotac-" + maPhong).css("display") == "block") {
		$("#thaotac-" + maPhong).hide();
		$("#thongtin-" + maPhong).show();
	} else {
		$(".thongtin").show();
		$(".thaotac").hide();
		$("#thongtin-" + maPhong).hide();
		$("#thaotac-" + maPhong).show();
	}
}

function dsdattruoc() {
	window.location = "/dsdattruoc";
}

function dptppck() {
	window.location = "/dptppck";
}

function dptppdt() {
	window.location = "/dptppdt";
}

function dptptong() {
	window.location = "/dptptong";
}

function dptppt() {
	window.location = "/dptppt";
}