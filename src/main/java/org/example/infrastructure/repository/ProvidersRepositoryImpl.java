package org.example.infrastructure.repository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.appication.repository.ProvidersRepository;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;

@Repository
@Slf4j
@RequiredArgsConstructor
public class ProvidersRepositoryImpl implements ProvidersRepository {
    @Override
    public ArrayList<String> getProviders(int clientId) {
        Connection con = null;
        try {
            con = DriverManager.getConnection("jdbc:mysql://host:port/dbname", "username", "password");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT idProvider, name, dischargeDate FROM provider WHERE idClient = " + clientId);
            ArrayList<String> providers = new ArrayList<>();
            while (rs.next()) {
                providers.add(rs.getInt("idProvider") + "," + rs.getString("name") + "," + rs.getDate("fecha_alta"));
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
