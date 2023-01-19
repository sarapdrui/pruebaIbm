package org.example.infrastructure.repository;

import org.example.appication.repository.ProvidersRepository;
import org.example.domain.Provider;

import java.sql.*;
import java.util.ArrayList;


public class ProvidersRepositoryImpl implements ProvidersRepository {
    @Override
    public ArrayList<Provider> getProviders(int clientId) {
        Connection con = null;
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/providers", "root", "admin");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM provider WHERE idClient = " + clientId);
            ArrayList<Provider> providers = new ArrayList<>();
            while (rs.next()) {
                Provider provider = new Provider();
                provider.setId(rs.getInt("idProvider"));
                provider.setName(rs.getString("name"));
                provider.setDischargeDate(rs.getDate("dischargeDate"));
                provider.setClientId(rs.getInt("idClient"));
                providers.add(provider);
            }
            return providers;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    System.out.println("Error al cerrar la conexión a la base de datos: " + e.getMessage());
                }
            }
        }
    }

}
