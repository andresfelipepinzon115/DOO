package com.doo.ubico.data.dao.factory;

import com.doo.ubico.crosscutting.exception.custom.DataUbicoException;
import com.doo.ubico.crosscutting.exception.messagecatalog.MessageCatalogStrategy;
import com.doo.ubico.crosscutting.exception.messagecatalog.data.CodigoMensaje;
import com.doo.ubico.data.dao.AulaDAO;
import com.doo.ubico.data.dao.BloqueDAO;
import com.doo.ubico.data.dao.TipoAulaDAO;
import com.doo.ubico.data.dao.factory.enums.Factory;

import com.doo.ubico.data.dao.factory.sql.azuresql.AzureSqlDAOFactory;
import com.doo.ubico.data.dao.sql.*;
import com.doo.ubico.data.dao.sql.azuresql.AulaAzureSqlDAO;

import java.util.ArrayList;
import java.util.List;

public abstract class DAOFactory {

    public static DAOFactory getFactory() {
        return new AzureSqlDAOFactory();
    }


    protected abstract void obtenerConexion();

    public abstract void iniciarTransaccion();

    public abstract void confirmarTransaccion();

    public abstract void cancelarTransaccion();

    public abstract void cerrarConexion();

    public abstract AulaDAO getAulaDAO();
    public  abstract TipoAulaDAO getTipoAulaDAO();
    public abstract BloqueDAO getBloqueDAO();



}
