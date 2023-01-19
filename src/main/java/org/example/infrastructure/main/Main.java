package org.example.infrastructure.main;

import org.example.appication.repository.ProvidersRepository;
import org.example.appication.service.ProvidersService;
import org.example.infrastructure.repository.ProvidersRepositoryImpl;
import org.example.infrastructure.service.ProvidersServiceImpl;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        if (!validateArgument(args)) {
            System.exit(1);
        }
        ProvidersRepository providersRepository = new ProvidersRepositoryImpl();

        ProvidersService providersService = new ProvidersServiceImpl(providersRepository);

        // Recibir el parámetro


        int idCliente = Integer.parseInt(args[0]);

        try {
            providersService.exportProviders(idCliente);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static boolean validateArgument(String[] args) {
        if(args.length == 0) {
            System.out.println("No se han encontrado argumentos");
            return false;
        }

        if(args[0].isBlank()) {
            System.out.println("No se han encontrado argumentos");
            return false;
        }

        if(!isNumeric(args[0])) {
            System.out.println("El valor debe ser un numero entero");
            return false;
        }
        return true;
    }


    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            int d = Integer.parseInt(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }


}
