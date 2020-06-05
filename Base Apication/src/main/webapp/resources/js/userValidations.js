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

    function tractaPassword(objecte, text) {
        objecte.classList.remove("is-invalid");
        objecte.classList.add("is-valid");
        objecte.parentElement.lastElementChild.classList.remove("invalid-feedback");
        objecte.parentElement.lastElementChild.classList.add("valid-feedback");
        objecte.parentElement.lastElementChild.innerHTML = text;
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
	
	var meter = document.getElementById("password-strength-meter");
    meter.style.display = "none";
    
    document.user.name.addEventListener("blur", verificarNom);
    document.user.bornDate.addEventListener("blur", verificarData);
    document.user.dni.addEventListener("blur", verificarDNI);
    document.user.mediCard.addEventListener("blur", verificarMediCard);
    document.user.email.addEventListener("blur", verificarEmail);
    document.user.password1.addEventListener("input", funcionMeter);
    document.user.password1.addEventListener("blur", verificarPassword1);
    document.user.password2.addEventListener("blur", verificarPassword2);
    document.getElementById("clean").addEventListener("click", limpiarFormulari);
    
    function verificarNom() {
    	if (this.value.length > 0) {
            var name = this.value.split("");
            for (var i = 0; i < name.length; i++) {
                if (!isNaN(name[i]) && name[i] != " ") {
                    tractaError(this, "No puede contener numeros");
                    return 0;
                }
            }
            if(this.value.length > 25){
            	tractaError(this, "No puede superar los 25 carácteres");
                return 0;
            }
            else{
            	tractaCorrecte(this);
            }
        }
    }
    
    function verificarData() {
        var data = this.value.split("-");
        var today = new Date();

        if (data != "") {
            var date = new Date(data[0], data[1] - 1, data[2]);
            if (date >= today) {
                tractaError(this, "No puedes haber nacido mas tarde a la fecha de hoy");
                return 0;
            }
            tractaCorrecte(this);
        }
    }
    
    function verificarDNI() {
        var DNI = this.value;
        var expresionRegular = /^\d{8}[A-Z]$/
        /*var lletres = ['T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E',
            'T'];*/
        if (DNI.length > 0) {
            if (expresionRegular.test(DNI)) {
                var lletraDNI = DNI.substring(DNI.length - 1);
                var numDNI = DNI.substring(0, DNI.length - 1);
                var index = numDNI % 23;
                //if (lletraDNI.toUpperCase() == lletres[index]) {
                    tractaCorrecte(this);
                /*}
                else {
                    tractaError(this, "Formato del DNI no válido (Letra DNI incorrecta)");
                }*/
            }
            else {
                tractaError(this, "Formato del DNI no válido (DNI incorrecto)");
            }
        }
    }
    
    function verificarMediCard(){
    	if (this.value.length > 0) {
	    	if(this.value.length != 9){
	    		tractaError(this, "La tarjeta sanitaria debe contener 9 carátcteres");
	    	}
	    	else{
	    		tractaCorrecte(this);
	    	}
    	}
    }
    
    function verificarEmail() {
        var email = this.value;
        var expresionRegular = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,4})+$/;
        if (email.length > 0) {
        	if(email.length <= 30){
	            if (expresionRegular.test(email)) {
	                tractaCorrecte(this);
	            }
	            else {
	                tractaError(this, "Formato del email no válido (Mail Inválido)");
	            }
        	}
        	else{
        		tractaError(this, "No puede superar los 30 caracteres");
        	}
        }
    }
    
    function funcionMeter() {
        meter.style.display = "block";

        var strength = {
            0: "Worst",
            1: "Bad",
            2: "Weak",
            3: "Good",
            4: "Strong"
        }

        var password = this.value;
        var result = zxcvbn(password);
        meter.value = result.score;
    }
    
    function verificarPassword1() {
        var password2 = document.getElementById("password2");
        console.log(meter.length);
        if (this.value.length > 0) {
            switch (meter.value) {
                case 0: tractaError(this, "Eso no es ni una contraseña");
                    password2.setAttribute("disabled", "0");
                    return 0;
                case 1: tractaError(this, "Esa contraseña todavía no vale ni para empezar");
                    password2.setAttribute("disabled", "0");
                    return 0;
                case 2: tractaError(this, "Por lo menos lo estás intentando");
                    password2.setAttribute("disabled", "0");
                    return 0;
                case 3: tractaPassword(this, "Que contraseña mas bacana me brindaste amigo");
                    password2.removeAttribute("disabled");
                    return 0;
                case 4: tractaPassword(this, "Esa contraseña es mas mejor que un buen vino");
                    password2.removeAttribute("disabled");
                    return 0;
            }
        }
    }
    
    function verificarPassword2() {
        var password1 = document.user.password1.value;
        var password2 = this.value;

        if (password1 == password2) {
            tractaCorrecte(this);
        }
        else {
            tractaError(this, "Las contraseñas no coinciden");
        }
    }
    
    
    function limpiarFormulari() {
        for (var x = 0; x < inputs.length; x++) {
            inputs.item(x).classList.remove("is-invalid");
            inputs.item(x).classList.remove("is-valid");
            inputs.item(x).setCustomValidity("");
        }
    }
    
    
}
window.onload = inici;
