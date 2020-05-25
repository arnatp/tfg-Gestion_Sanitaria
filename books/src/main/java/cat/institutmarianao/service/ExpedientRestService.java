package cat.institutmarianao.service;

import java.net.URI;
import java.util.List;

import javax.ejb.Singleton;
import javax.inject.Inject;
import javax.ws.rs.BadRequestException;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import cat.institutmarianao.domain.Expedient;
import cat.institutmarianao.domain.repository.ExpedientRepository;

@Path("/expedients")
@Singleton
public class ExpedientRestService {
	@Context
	private UriInfo uriInfo;

	@Inject
	private ExpedientRepository expedientRepository;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Expedient> getAll() {
		return expedientRepository.getAll();
	}

	@GET
	@Path("findByExpedientId/{expedientId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Expedient findByExpedientId(@PathParam("expedientId") int expedientId) {
		return expedientRepository.getExpedientByExpedientId(expedientId);
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response create(Expedient expedient) {
		if (expedient == null) {
			throw new BadRequestException();
		}
		expedientRepository.add(expedient);

		URI doctorUri = uriInfo.getAbsolutePathBuilder().path(String.valueOf(expedient.getExpedientId())).build();
		return Response.ok(doctorUri).build();
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public void edit(Expedient expedient) {
		expedientRepository.update(expedient);
	}

	@DELETE
	@Path("deleteExpedientId/{expedientId}")
	public void remove(@PathParam("expedientId") int expedientId) {
		expedientRepository.delete(expedientRepository.getExpedientByExpedientId(expedientId));
	}
}
