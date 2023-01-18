package org.example.infrastructure.main;

import org.example.appication.service.ProvidersService;
import org.example.infrastructure.service.ProvidersServiceImpl;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        ProvidersService providersService = new ProvidersServiceImpl();

        // Recibir el parámetro
        int idCliente = Integer.parseInt(args[0]);

        try {
            providersService.getProviders(idCliente);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
