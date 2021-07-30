package dev.beale.services;

import java.util.List;

import dev.beale.models.Request;
import dev.beale.repositories.RequestRepo;

public class RequestServiceImpl implements RequestService {

	public RequestRepo cd;

	public RequestServiceImpl(RequestRepo cd) {
		this.cd = cd;
	}

	@Override
	public Request createRequest(Request c) {
		return cd.createRequest(c);
	}

	@Override
	public Request getRequest(int id) {
		return cd.getRequest(id);
	}

	@Override
	public List<Request> getAllRequests(int id, int name) {
		return cd.getAllRequests(id, name);
	}

	@Override
	public Request updateRequest(Request change) {
		return cd.updateRequest(change);
	}

	@Override
	public Request deleteRequest(int id) {
		return cd.deleteRequest(id);
	}

	@Override
	public Request getRequest(String name) {
		return cd.getRequest(name);
	}
}
