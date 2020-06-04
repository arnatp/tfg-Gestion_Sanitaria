function inici() {
		
	function tractaError(objecte, text) {
        objecte.classList.add("is-invalid");
        objecte.classList.remove("is-valid");
        objecte.parentElement.lastElementChild.classList.add("invalid-feedback");
        objecte.parentElement.lastElementChild.classList.remove("valid-feedback");
        objecte.parentElement.lastElementChild.innerHTML = text;
        objecte.setCustomValidity(text);
    }
	
	function tractaCorrecte(objecte) {
        objecte.classList.remove("is-invalid");
        objecte.classList.add("is-valid");
        objecte.parentElement.lastElementChild.classList.add("valid-feedback");
        objecte.parentElement.lastElementChild.classList.remove("invalid-feedback");
        objecte.parentElement.lastElementChild.innerHTML = "Parece Correcto";
        objecte.setCustomValidity("");
    }

    var inputs = document.getElementsByTagName("input");
    for (var x = 0; x < inputs.length; x++) {
        inputs.item(x).addEventListener("focus", quitarClases);
    }
	
	function quitarClases() {
        this.classList.remove("is-invalid");
        this.classList.remove("is-valid");
        this.setCustomValidity("");
    }
    
    document.visit.resolution.addEventListener("input", funcionCaracteresResolution);
    document.visit.resolution.addEventListener("blur", verificarObservationsResolution);
    
    
    var textoResoluciones = document.getElementById("caracteresResoulucion");
    
    function funcionCaracteresResolution() {
        observaciones = this.value;
        textoResoluciones.classList.remove("d-none");
        textoResoluciones.innerHTML = observaciones.length + " caracteres";
        if (observaciones.length > 0) {
            if (observaciones.length > 255) {
                textoResoluciones.classList.add("text-danger");
                textoResoluciones.classList.remove("text-dark");
            }
            else {
                textoResoluciones.classList.remove("text-danger");
                textoResoluciones.classList.add("text-dark");
            }
        }
    }

    function verificarObservationsResolution() {
        textoResoluciones.classList.add("d-none");
        if (this.value.length > 255) {
            tractaError(this, "Longitud máxima de 255 carácteres");
        }
        else {
            tractaCorrecte(this);
        }
    }
    
}
window.onload = inici;
