package dev.beale.services;

import java.util.List;

import dev.beale.models.Request;

public interface RequestService {

	public Request getRequest(String name);

	public Request getRequest(int id);

	public List<Request> getAllRequests(int id, int name);

	public Request createRequest(Request r);

	public Request updateRequest(Request change);

	public Request deleteRequest(int id);

}
