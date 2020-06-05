function inici() {
	document.getElementById('cancelVisit').onclick = function(e){
	    if( !confirm('Seguro que quieres borrar la visita?') ) {
	    	e.preventDefault();
	    }
	}
}
window.onload = inici;
