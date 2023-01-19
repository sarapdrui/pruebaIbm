package org.example.appication.service;

import java.io.IOException;

public interface ProvidersService {
     void exportProviders(int id, String localhost, int port, String user, String password) throws IOException;
}
