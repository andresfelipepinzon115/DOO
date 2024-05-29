package com.doo.ubico.data.dao.factory;

import com.doo.ubico.data.dao.AulaDAO;
import com.doo.ubico.data.dao.BloqueDAO;
import com.doo.ubico.data.dao.TipoAulaDAO;

import com.doo.ubico.data.dao.factory.sql.azuresql.AzureSqlDAOFactory;
import com.doo.ubico.data.dao.sql.azuresql.AulaAzureSqlDAO;
import com.doo.ubico.data.dao.sql.azuresql.BloqueAzureSqlDAO;
import com.doo.ubico.data.dao.sql.azuresql.TipoAulaAzureSqlDAO;

import java.sql.Connection;




public interface DAOFactory {

    static DAOFactory getFactory() {
        return new AzureSqlDAOFactory();
    }

    void cerrarConexion();

    void iniciarTransaccion();

    void confirmarTransaccion();

    void cancelarTransaccion();

     AulaDAO getAulaDAO();

     BloqueDAO getBloqueDAO();

     TipoAulaDAO getTipoAulaDAO();
}