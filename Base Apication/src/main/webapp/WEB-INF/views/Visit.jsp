<html>

<head>
    <jsp:include page="sections/head.jsp" />
</head>

<body>
    <jsp:include page="sections/navMenu.jsp" />
    <div class="container col-4" style="border: 1px solid black; box-shadow: 4px 4px 8px grey; margin-top: 3%;">
        <h3><i class="fa fa-calendar-plus-o"></i> Solicitar nueva visita</h3>
        <hr style="background-color: hsl(120, 60%, 50%)">
        <form action="spring" method="post" style="margin-top: 3%;">
            <div class="row">
                <div class="col">
                    <div class="form-group row">
                        <div class="form-group col-6">
                            <label for="doctor"><b>Doctor</b></label>
                            <select id="doctor" class="form-control" path="doctor">
                                <option value="M">Arny Officel</option>
                                <option value="F">Alberto Truchas</option>
                                <option value="N">Beer Master</option>
                            </select>
                        </div>
                        <label for="visitDate" class="col-6 col-form-label">
                            <b>Fecha de visita</b>
                            <input class="form-control" type="date" value="2011-08-19" id="visitDate">
                        </label>
                    </div>
                    <div class="form-group">
                        <label for="description col-12"><b>Motivo de visita</b></label>
                        <textarea class="form-control col-12" id="description" rows="3"></textarea>
                    </div>
                    <div class="d-flex justify-content-center"><button type="submit"
                            class="btn btn-outline-success">Solicitar</button>
                    </div>
                </div>
            </div>
        </form>
    </div>

    <body>

</html>