package org.example.appication.repository;

import org.example.domain.Provider;

import java.util.ArrayList;

public interface ProvidersRepository {

    ArrayList<Provider> getProviders(int clientId, String localhost, int port, String user, String password);
}
