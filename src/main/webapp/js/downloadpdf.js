function downloadPdf() {
		$("#pdf").show();
		$("#loading").show();
		setTimeout(() => {
			html2canvas(document.querySelector("#pdf")).then(canvas => {
				var rate = 0.75;
				var height = parseInt(canvas.getAttribute("height"));
				var width = parseInt(canvas.getAttribute("width"));
				var doc = new jsPDF('p','mm',[width * rate,height * rate]);
				doc.addImage(canvas, 'JPEG', 0,0);
				doc.save('HoaDon.pdf');
				$("#pdf").hide();
				$("#loading").hide();
			});
		}, 300);
}