package com.doo.ubico.data.dao.sql;



import java.sql.Connection;

import com.doo.ubico.crosscutting.exception.messagecatalog.MessageCatalogStrategy;
import com.doo.ubico.crosscutting.exception.messagecatalog.data.CodigoMensaje;
import com.doo.ubico.crosscutting.helpers.SQLHelper;
import com.doo.ubico.crosscutting.exception.custom.DataUbicoException;



public abstract class SqlConnection {

    private Connection connection;

    protected SqlConnection(final Connection connection) {
        setConnection(connection);
    }

    private void setConnection(final Connection connection) {
        if (!SQLHelper.isOpen(connection)) {  // Verificamos si la conexión está cerrada
            var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00002);
            var mensajeTecnico = "No es posible crear el DAO deseado, dado que la conexion SQL esta cerrada";
            throw new DataUbicoException(mensajeTecnico, mensajeUsuario);
        }
        this.connection = connection;
    }

    protected final Connection getConnection() {
        return connection;
    }

    protected final void closeConnection() {
        if (this.connection != null) {
            SQLHelper.close(this.connection);
        }
    }
}