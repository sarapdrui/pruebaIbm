package org.example.infrastructure.service;

import org.example.appication.repository.ProvidersRepository;
import org.example.appication.service.ProvidersService;
import org.example.domain.Provider;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ProvidersServiceImpl implements ProvidersService {

    ProvidersRepository providersRepository;

    public ProvidersServiceImpl (ProvidersRepository providersRepository){
        this.providersRepository = providersRepository;
    }

    @Override
    public void exportProviders(int id) throws IOException {
        List<Provider> providersList = providersRepository.getProviders(id);


        if (providersList.size() > 0) {
            FileWriter fw = new FileWriter("proveedores.txt");
            for (Provider proveedor : providersList) {
                fw.write(proveedor.getId() + ", "
                        + proveedor.getName() + ", "
                        + proveedor.getDischargeDate()
                        + "\n");
            }
            fw.close();
            System.out.println("Fichero generado con éxito.");
        } else {
            System.out.println("El cliente no tiene proveedores asignados.");
        }
    }
}
