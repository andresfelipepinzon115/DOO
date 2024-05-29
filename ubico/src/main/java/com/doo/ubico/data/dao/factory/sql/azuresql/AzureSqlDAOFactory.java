package com.doo.ubico.data.dao.factory.sql.azuresql;

import com.doo.ubico.crosscutting.exception.custom.DataUbicoException;
import com.doo.ubico.crosscutting.exception.messagecatalog.MessageCatalogStrategy;
import com.doo.ubico.crosscutting.exception.messagecatalog.data.CodigoMensaje;
import com.doo.ubico.crosscutting.helpers.SQLHelper;
import com.doo.ubico.data.dao.factory.DAOFactory;
import com.doo.ubico.data.dao.sql.azuresql.AulaAzureSqlDAO;
import com.doo.ubico.data.dao.sql.azuresql.BloqueAzureSqlDAO;
import com.doo.ubico.data.dao.sql.azuresql.TipoAulaAzureSqlDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class AzureSqlDAOFactory implements DAOFactory {

    private Connection connection;

    public AzureSqlDAOFactory() {
        obtenerConexion();

    }


    protected void obtenerConexion() {
        final String connectionUrl = "jdbc:mysql://127.0.0.1:3306/ubico?user=root&password=0000";

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
    public AulaAzureSqlDAO getAulaDAO() {
        return new AulaAzureSqlDAO(connection);
    }

    @Override
    public BloqueAzureSqlDAO getBloqueDAO() {
        return new BloqueAzureSqlDAO(connection);
    }

    @Override
    public TipoAulaAzureSqlDAO getTipoAulaDAO() {
        return new TipoAulaAzureSqlDAO(connection);
    }



}