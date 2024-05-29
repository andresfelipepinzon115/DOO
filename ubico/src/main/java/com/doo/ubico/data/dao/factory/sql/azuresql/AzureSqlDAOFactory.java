package com.doo.ubico.data.dao.factory.sql.azuresql;

import com.doo.ubico.crosscutting.exception.custom.DataUbicoException;
import com.doo.ubico.crosscutting.exception.messagecatalog.MessageCatalogStrategy;
import com.doo.ubico.crosscutting.exception.messagecatalog.data.CodigoMensaje;
import com.doo.ubico.crosscutting.helpers.SQLHelper;
import com.doo.ubico.data.dao.AulaDAO;
import com.doo.ubico.data.dao.BloqueDAO;
import com.doo.ubico.data.dao.TipoAulaDAO;
import com.doo.ubico.data.dao.factory.DAOFactory;
import com.doo.ubico.data.dao.sql.azuresql.AulaAzureSqlDAO;
import com.doo.ubico.data.dao.sql.azuresql.BloqueAzureSqlDAO;
import com.doo.ubico.data.dao.sql.azuresql.TipoAulaAzureSqlDAO;
import com.doo.ubico.dto.AulaDTO;
import com.doo.ubico.entity.AulaEntity;
import com.doo.ubico.data.dao.factory.enums.Factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.UUID;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public final class AzureSqlDAOFactory extends DAOFactory {

    private Connection connection;

    public AzureSqlDAOFactory() {
        obtenerConexion();
        cargarDatosPorDefecto();
    }

    @Override
    protected void obtenerConexion() {
        final String connectionUrl = "jdbc:sqlserver://wednesday.database.windows.net:1433;databaseName=wednesday;user=wednesdayDmlUser;password=w3dn3sd4y!";

        try {
            connection = DriverManager.getConnection(connectionUrl);
        } catch (final SQLException excepcion) {
            var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00002);
            var mensajeTecnico = "Se ha presentado un problema tratando de obtener la conexión con la base de datos wednesday en el servidor de bases de datos wednesday.database.windows.net. Por favor revise la traza de errores para identificar y solucionar el problema...";

            throw new DataUbicoException(mensajeTecnico, mensajeUsuario, excepcion);
        } catch (final Exception excepcion) {
            var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00002);
            var mensajeTecnico = "Se ha presentado un problema INESPERADO tratando de obtener la conexión con la base de datos wednesday en el servidor de bases de datos wednesday.database.windows.net. Por favor revise la traza de errores para identificar y solucionar el problema...";

            throw new DataUbicoException(mensajeTecnico, mensajeUsuario, excepcion);
        }
    }

    private void cargarDatosPorDefecto() {
        String sqlBloques = "INSERT INTO bloques (nombre) VALUES " +
                "('M'), ('EDC'), ('J'), ('CO'),('E'),('D');";
        String sqlTiposAula = "INSERT INTO tipos_aula (nombre) VALUES " +
                "('Aula Común'), ('Salón de Informática'), ('Laboratorio');";

        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(sqlBloques);
            statement.executeUpdate(sqlTiposAula);
            System.out.println("Datos por defecto cargados exitosamente.");
        } catch (SQLException e) {
            System.out.println("Error al cargar datos por defecto: " + e.getMessage());
        }
    }

    @Override
    public void iniciarTransaccion() {
        SQLHelper.initTransaction(connection);
    }

    @Override
    public void confirmarTransaccion() {
        SQLHelper.commit(connection);
    }

    @Override
    public void cancelarTransaccion() {
        SQLHelper.rollback(connection);
    }

    @Override
    public void cerrarConexion() {
        SQLHelper.close(connection);
    }

    @Override
    public AulaDAO getAulaDAO() {
        return new AulaAzureSqlDAO(connection);
    }

    @Override
    public BloqueDAO getBloqueDAO() {
        return new BloqueAzureSqlDAO(connection);
    }

    @Override
    public TipoAulaDAO getTipoAulaDAO() {
        return new TipoAulaAzureSqlDAO(connection);
    }



}
