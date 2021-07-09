package dev.beale.services;

import java.util.List;

import dev.beale.models.Client;

public interface ClientService {

	public Client createClient(Client c);

	public Client getClient(int id);

	public List<Client> getAllClients();

	public Client updateClient(Client change);

	public Client deleteClient(int id);

	public List<Client> getClientsWithCheckingAccounts(boolean checkingAccounts);

	public Client forgotPassword();

}
