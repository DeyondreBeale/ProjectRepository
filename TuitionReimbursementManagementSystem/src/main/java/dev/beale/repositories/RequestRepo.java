package dev.beale.repositories;

import java.util.List;

import dev.beale.models.Request;

public interface RequestRepo {
	public Request createRequest(Request r);

	public List<Request> getAllRequests(int id, int name);

	public Request getRequest(int id);

	public Request getRequest(String name);

	public Request updateRequest(Request change);

	public Request deleteRequest(int id);
}
