package com.doo.ubico.data.dao.factory.sql.azuresql;

import com.doo.ubico.crosscutting.exception.UbicoException;
import com.doo.ubico.crosscutting.exception.custom.DataUbicoException;
import com.doo.ubico.crosscutting.exception.messagecatalog.MessageCatalogStrategy;
import com.doo.ubico.crosscutting.exception.messagecatalog.data.CodigoMensaje;
import com.doo.ubico.crosscutting.helpers.SQLHelper;
import com.doo.ubico.data.dao.AulaDAO;
import com.doo.ubico.data.dao.BloqueDAO;
import com.doo.ubico.data.dao.TipoAulaDAO;
import com.doo.ubico.data.dao.factory.DAOFactory;
import com.doo.ubico.data.dao.sql.SqlConnection;
import com.doo.ubico.data.dao.sql.azuresql.AulaAzureSqlDAO;
import com.doo.ubico.data.dao.sql.azuresql.BloqueAzureSqlDAO;
import com.doo.ubico.data.dao.sql.azuresql.TipoAulaAzureSqlDAO;

import java.sql.DriverManager;
import java.sql.SQLException;

public final class AzureSQLDAOFactory extends SqlConnection implements DAOFactory {
    public AzureSQLDAOFactory() {
        super();
        obtenerConexion();
    }


    protected void obtenerConexion() {
        final String connectionUrl = "jdbc:sqlserver://wednesday.database.windows.net:1433;databaseName=wednesday;user=wednesdayDmlUser;password=w3dn3sd4y!";
        try {
            setConexion(DriverManager.getConnection(connectionUrl));
        } catch (final UbicoException excepcion) {
            var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00002);
            var mensajeTecnico = "Se ha presentado un problema tratando de obtener la conexión con la base de datos wednesday en el servidor de bases de datos wednesday.database.windows.net. Por favor revise la traza de errores para identificar y solucionar el problema...";

            throw new DataUbicoException(mensajeTecnico, mensajeUsuario, excepcion);
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
    public void cerrarConexion() {
        SQLHelper.close(getConexion());
    }

    @Override
    public void iniciarTransaccion() {
        SQLHelper.initTransaction(getConexion());
    }

    @Override
    public void confirmarTransaccion() {
        SQLHelper.commit(getConexion());
    }

    @Override
    public void cancelarTransaccion() {
        SQLHelper.rollback(getConexion());
    }

    @Override
    public AulaDAO getAulaDAO() {
        return new AulaAzureSqlDAO(getConexion());
    }

    @Override
    public BloqueDAO getBloqueDAO() {
        return new BloqueAzureSqlDAO(getConexion());
    }

    @Override
    public TipoAulaDAO getTipoAulaDAO() {
        return new TipoAulaAzureSqlDAO(getConexion());
    }

}