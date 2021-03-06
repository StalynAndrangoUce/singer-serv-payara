package com.distribuida.rest;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.distribuida.dto.Singer;
import com.distribuida.service.SingerService;

@ApplicationScoped
@Path("/singers")
public class SingerRest {
	@Inject
	private SingerService singerService;

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Singer listar(@PathParam(value = "id") Integer id) {
		Singer singer = singerService.buscarPorId(id);
		return singer;
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Singer> listarTodos() {
		List<Singer> singers = singerService.listar();
		return singers;
	}
}
