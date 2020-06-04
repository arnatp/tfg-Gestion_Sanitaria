$(document).ready(function () {
	
	 $("#cancelVisit").click(function (event){
		 event.preventDefault();
		 confirm("Seguro que quieres cancelar la visita?");
	 });
	 
}