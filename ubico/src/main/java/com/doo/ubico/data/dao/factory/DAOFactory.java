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

    public static final DAOFactory getFactory(final Factory factory){
        switch (factory) {
            case AZURE_SQL: 
                return new AzureSqlDAOFactory();
        
            case POSTGRES_SQL: {
                var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00002);
                var mensajeTecnico = "No existe una factoria de base de datos configurada para POSTGRES_SQL";

                throw new DataUbicoException(mensajeTecnico, mensajeUsuario);
            }
            case SQL_SERVER: {
                var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00002);
                var mensajeTecnico = "No existe una factoria de base de datos configurada para SQL_SERVER";

                throw new DataUbicoException(mensajeTecnico, mensajeUsuario);
            }
            case MYSQL: {
                var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00002);
                var mensajeTecnico = "No existe una factoria de base de datos configurada para MYSQL";

                throw new DataUbicoException(mensajeTecnico, mensajeUsuario);
            }
            case ORACLE: {
                var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00002);
                var mensajeTecnico = "No existe una factoria de base de datos configurada para ORACLE";

                throw new DataUbicoException(mensajeTecnico, mensajeUsuario);}
            default:
                return new AzureSqlDAOFactory();
            }
        }
            
  
    protected abstract void obtenerConexion();

    public abstract void iniciarTransaccion();

    public abstract void confirmarTransaccion();

    public abstract void cancelarTransaccion();

    public abstract void cerrarConexion();

    public abstract AulaDAO getAulaDAO();
    public  abstract TipoAulaDAO getTipoAulaDAO();
    public abstract BloqueDAO getBloqueDAO();

    public static void main(String[] args) {
        DAOFactory.getFactory(Factory.AZURE_SQL).getAulaDAO().crear(null);
        DAOFactory.getFactory(Factory.AZURE_SQL).getAulaDAO().actualizar(null);
        DAOFactory.getFactory(Factory.AZURE_SQL).getAulaDAO().eliminar(0);
        List<AulaAzureSqlDAO> AulaAzureSql = new ArrayList<AulaAzureSqlDAO>();
    }

}
