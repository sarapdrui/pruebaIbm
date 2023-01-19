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

        String localhost = args[1];
        int port = Integer.parseInt(args[2]);
        String user = args[3];
        String password= args[4];

        try {
            providersService.exportProviders(idCliente, localhost, port, user, password);

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

        if(args[1].isBlank()) {
            System.out.println("El host es un valor obligatorio");
            return false;
        }

        if(isNumeric(args[1])) {
            System.out.println("El host debe ser una cadena de texto");
            return false;
        }

        if(args[2].isBlank()) {
            System.out.println("El puerto es un valor obligatorio");
            return false;
        }

        if(!isNumeric(args[2])) {
            System.out.println("El puerto debe ser un numero entero");
            return false;
        }


        if(args[3].isBlank()) {
            System.out.println("El usuario es un valor obligatorio");
            return false;
        }

        if(isNumeric(args[3])) {
            System.out.println("El usuario debe ser una cadena de texto");
            return false;
        }

        if(args[4].isBlank()) {
            System.out.println("La contraseña es un valor obligatorio");
            return false;
        }

        if(isNumeric(args[4])) {
            System.out.println("La contraseña debe ser una cadena de texto");
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
