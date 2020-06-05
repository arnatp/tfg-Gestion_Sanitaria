function inici() {
	var buttons = document.getElementsByClassName("cancelVisit");
    for (var x = 0; x < buttons.length; x++) {
    	buttons.item(x).addEventListener("click", function(event){
    		if(!confirm('Seguro que quieres borrar la visita?') ) {
    	    	event.preventDefault();
    	    }
    	});
    }
}
window.onload = inici;
