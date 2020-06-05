function inici() {

	function tractaError(objecte, text) {
		objecte.classList.add("is-invalid");
		objecte.classList.remove("is-valid");
		objecte.parentElement.lastElementChild.classList
				.add("invalid-feedback");
		objecte.parentElement.lastElementChild.classList
				.remove("valid-feedback");
		objecte.parentElement.lastElementChild.innerHTML = text;
		objecte.setCustomValidity(text);
	}

	function tractaCorrecte(objecte) {
		objecte.classList.remove("is-invalid");
		objecte.classList.add("is-valid");
		objecte.parentElement.lastElementChild.classList.add("valid-feedback");
		objecte.parentElement.lastElementChild.classList
				.remove("invalid-feedback");
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

	document.visit.visitDate.addEventListener("blur", verificarData);
	document.visit.description.addEventListener("input", funcionCaracteres);
	document.visit.description.addEventListener("blur", verificarObservations);
	// document.visit.resolution.addEventListener("input",
	// funcionCaracteresResolution);
	// document.visit.resolution.addEventListener("blur",
	// verificarObservationsResolution);

	function verificarData() {
		var data = this.value.split("-");
		var today = new Date();
		today.setHours(0, 0, 0, 0);

		if (data != "") {
			var date = new Date(data[0], data[1] - 1, data[2]);

			console.log(date.getTime());
			console.log(today.getTime());

			if (date.getTime() < today.getTime()) {
				tractaError(this,
						"No puedes hacer una visita con fecha anterior a la actual");
				return 0;
			}
			tractaCorrecte(this);
		}
	}

	var textoObservaciones = document.getElementById("caracteres");
	// var textoResoluciones = document.getElementById("caracteresResoulucion");

	function funcionCaracteres() {
		observaciones = this.value;
		textoObservaciones.classList.remove("d-none");
		textoObservaciones.innerHTML = observaciones.length + " caracteres";
		if (observaciones.length > 0) {
			if (observaciones.length > 255) {
				textoObservaciones.classList.add("text-danger");
				textoObservaciones.classList.remove("text-dark");
			} else {
				textoObservaciones.classList.remove("text-danger");
				textoObservaciones.classList.add("text-dark");
			}
		}
	}

	function verificarObservations() {
		textoObservaciones.classList.add("d-none");
		if (this.value.length > 0) {
			if (this.value.length > 255) {
				tractaError(this, "Longitud máxima de 255 carácteres");
			} else {
				tractaCorrecte(this);
			}
		}

	}

}
window.onload = inici;
