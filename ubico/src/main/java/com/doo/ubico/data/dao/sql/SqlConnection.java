<<<<<<< Updated upstream
package co.edu.uco.tiendachepito.data.DAO.sql;

import co.edu.uco.tiendachepito.crosscutting.crosscutting.exception.custom.DataTiendaChepitoException;
import co.edu.uco.tiendachepito.crosscutting.crosscutting.exception.messagecatalog.MessageCatalogStrategy;
import co.edu.uco.tiendachepito.crosscutting.crosscutting.exception.messagecatalog.data.CodigoMensaje;
import co.edu.uco.tiendachepito.crosscutting.crosscutting.helpers.SQLHelper;

import java.sql.Connection;

=======
package com.doo.ubico.data.dao.sql;



import java.sql.Connection;

import com.doo.ubico.crosscutting.exception.messagecatalog.MessageCatalogStrategy;
import com.doo.ubico.crosscutting.exception.messagecatalog.data.CodigoMensaje;
import com.doo.ubico.crosscutting.helpers.SQLHelper;
import com.doo.ubico.crosscutting.exception.custom.DataUbicoException;

>>>>>>> Stashed changes
public class SqlConnection {

    private Connection connection;

    protected SqlConnection(final Connection connection) {
        setConnection(connection);
    }

    private void setConnection(final Connection connection) {
        if (SQLHelper.isOpen(connection)) {
            var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00002);
            var mensajeTecnico = "No es posible crear el DAO deseado, dado que la conexion SQL esta cerrada";
<<<<<<< Updated upstream
            throw new DataTiendaChepitoException(mensajeTecnico, mensajeUsuario);
=======
            throw new DataUbicoException(mensajeTecnico, mensajeUsuario);
>>>>>>> Stashed changes
        }
        this.connection = connection;
    }

    protected final Connection getConnection() {
        return connection;

    }

//        protected SqlConnection(final Connection connection) {
//            if (connection == null) {
//                throw new NullPointerException("The connection is null");
//            }
//            this.connection = connection;
//        }
//
//        protected Connection getConnection() {
//            return connection;
//        }

}
