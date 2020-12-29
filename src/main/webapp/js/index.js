 $("#login-button").click(function(event){
	 event.preventDefault();
	 $('#error').hide();
	 $('form').fadeOut(500);
	 $('.wrapper').addClass('form-success');
	 setTimeout(() => {
		 $('form').submit();
	}, 500);
});
 
 function autoFontSize() {
		var divWidth = $("html").width() - 20;
		var text = $("#text");
		var fontSize = 40;
		while (text.width() > divWidth) {
			text.css("font-size", fontSize -= 1);
		}
	}
	 autoFontSize();
	