function hideLink() {
	var length = $("a").length;
	var href;
	for (var i = 0; i < length; i++) {
		href = $("a")[i].href;
		if (href.indexOf("?") > -1) {
			$("a").eq(i).attr("onclick", "clickHideParamURL('" + href + "')");
			$("a").eq(i).attr("href", "javascript:void(0)");
		}
	}
}

function clickHideParamURL(href) {
	window.location.replace(href);
	history.pushState(null, "", document.getElementById("changeURL").value);
}

function setMinHeightContent() {
	$(".content-custom").css('min-height', ($("#getFullSize").height() - 60) + "px");
}
hideLink();
setMinHeightContent();
