package org.example.infrastructure.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.appication.repository.ProvidersRepository;
import org.example.appication.service.ProvidersService;
import org.springframework.stereotype.Service;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

@Service
@Slf4j
public class ProvidersServiceImpl implements ProvidersService {

    ProvidersRepository providersRepository;

    @Override
    public void getProviders(int id) throws IOException {
        List<String> providersList = providersRepository.getProviders(id);

        if (providersList.size() > 0) {
            FileWriter fw = new FileWriter("proveedores.txt");
            for (String proveedor : providersList) {
                fw.write(proveedor + "\n");
            }
            fw.close();
            System.out.println("Fichero generado con éxito.");
        } else {
            System.out.println("El cliente no tiene proveedores asignados.");
        }
    }
}
