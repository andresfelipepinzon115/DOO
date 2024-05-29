package com.doo.ubico.data.dao.factory;


import com.doo.ubico.data.dao.AulaDAO;
import com.doo.ubico.data.dao.BloqueDAO;
import com.doo.ubico.data.dao.TipoAulaDAO;
import com.doo.ubico.data.dao.factory.sql.azuresql.AzureSQLDAOFactory;


public interface DAOFactory {

    static DAOFactory getFactory() {
        return new AzureSQLDAOFactory();
    }

    void cerrarConexion();

    void iniciarTransaccion();

    void confirmarTransaccion();

    void cancelarTransaccion();
    public abstract AulaDAO getAulaDAO();
    public  abstract TipoAulaDAO getTipoAulaDAO();
    public abstract BloqueDAO getBloqueDAO();


}
