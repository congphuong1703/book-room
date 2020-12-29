function checkMaxLenghtNumber(element,length) {
	if (element.value.length > length) {
		element.value = element.value.slice(0,length); 
	}
};

function setHeightMenu() {
	if(!($(window).width() >= 666 && $(window).width() <= 991)) {
		$("#menuUl").height($("#page-top").height()-105);
	}
}

function showLoading(element){
	$("form").submit(function() {
		$("#loading").show();
	})
};

function setLoadWhenSubmit() {
	$('button[type="submit"]').attr("onclick","showLoading(this)");
}

function notShowHistoryInput() {
	$('input').attr("autocomplete","off");
}

function changeNgaySinhEdit(tenDangNhap) {
	$("#inputngaySinh-"+ tenDangNhap + " input").val($("#ngaySinh-" + tenDangNhap).html());
}

function addRowCount(tableAttr) {
	  $(tableAttr).each(function(){
	    $('th:first-child, thead td:first-child', this).each(function(){
	      var tag = $(this).prop('tagName');
	      $(this).before('<'+tag+'>#</'+tag+'>');
	    });
	    $('td:first-child', this).each(function(i){
	      $(this).before('<td>'+(i+1)+'</td>');
	    });
	  });
	}

setTimeout(() => {
	setHeightMenu();
	setLoadWhenSubmit();
	notShowHistoryInput();
	
	addRowCount('.js-serial');
}, 50);