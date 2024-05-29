package com.doo.ubico.config;


/*
import com.doo.ubico.data.dao.factory.DAOFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;


@Component
public class CargaInicial implements CommandLineRunner {

    @Autowired
    private DAOFactory daoFactory;

    @Override
    public void run(String... args) throws Exception {
        cargarDatosPorDefecto();
    }

    private void cargarDatosPorDefecto() {
        Connection connection = daoFactory.obtenerConexion();
        if (connection == null) {
            System.out.println("No se pudo obtener la conexión a la base de datos.");
            return;
        }

        try (Statement statement = connection.createStatement()) {
            // Crear tablas si no existen
            String createBloquesTable = "IF NOT EXISTS (SELECT * FROM sysobjects WHERE name='bloques' AND xtype='U') " +
                    "CREATE TABLE bloques (" +
                    "id INT IDENTITY(1,1) PRIMARY KEY, " +
                    "nombre NVARCHAR(50) NOT NULL);";
            statement.executeUpdate(createBloquesTable);

            String createTiposAulaTable = "IF NOT EXISTS (SELECT * FROM sysobjects WHERE name='tipos_aula' AND xtype='U') " +
                    "CREATE TABLE tipos_aula (" +
                    "id INT IDENTITY(1,1) PRIMARY KEY, " +
                    "nombre NVARCHAR(50) NOT NULL);";
            statement.executeUpdate(createTiposAulaTable);

            // Insertar datos
            String sqlBloques = "INSERT INTO bloques (nombre) VALUES " +
                    "('M'), ('EDC'), ('J'), ('CO'),('E'),('D');";
            statement.executeUpdate(sqlBloques);

            String sqlTiposAula = "INSERT INTO tipos_aula (nombre) VALUES " +
                    "('Aula Común'), ('Salón de Informática'), ('Laboratorio');";
            statement.executeUpdate(sqlTiposAula);

            System.out.println("Datos por defecto cargados exitosamente.");
        } catch (SQLException e) {
            System.out.println("Error al cargar datos por defecto: " + e.getMessage());
        } finally {
            daoFactory.cerrarConexion();
        }
    }
}
*/