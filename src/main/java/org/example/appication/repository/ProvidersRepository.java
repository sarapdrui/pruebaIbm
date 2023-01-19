package org.example.appication.repository;

import org.example.domain.Provider;

import java.util.ArrayList;

public interface ProvidersRepository {

    ArrayList<Provider> getProviders(int providerId);
}
