<<<<<<< Updated upstream
package co.edu.uco.tiendachepito.data.DAO.factory;

import co.edu.uco.tiendachepito.crosscutting.crosscutting.exception.custom.DataTiendaChepitoException;
import co.edu.uco.tiendachepito.crosscutting.crosscutting.exception.messagecatalog.MessageCatalogStrategy;
import co.edu.uco.tiendachepito.crosscutting.crosscutting.exception.messagecatalog.data.CodigoMensaje;
import co.edu.uco.tiendachepito.data.DAO.CiudadDAO;
import co.edu.uco.tiendachepito.data.DAO.DepartamentoDAO;
import co.edu.uco.tiendachepito.data.DAO.PaisDAO;
import co.edu.uco.tiendachepito.data.DAO.factory.enums.Factory;
import co.edu.uco.tiendachepito.data.DAO.factory.sql.azuresql.AzureSqlDAOFactory;
import co.edu.uco.tiendachepito.data.DAO.sql.azuresql.PaisAzureSqlDAO;
=======
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
>>>>>>> Stashed changes

import java.util.ArrayList;
import java.util.List;

public abstract class DAOFactory {

    public static final DAOFactory getFactory(final Factory factory){
        switch (factory) {
<<<<<<< Updated upstream
            case AZURE_SQL: {
                return new AzureSqlDAOFactory();
            }
=======
            case AZURE_SQL: 
                return new AzureSqlDAOFactory();
        
>>>>>>> Stashed changes
            case POSTGRES_SQL: {
                var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00002);
                var mensajeTecnico = "No existe una factoria de base de datos configurada para POSTGRES_SQL";

<<<<<<< Updated upstream
                throw new DataTiendaChepitoException(mensajeTecnico, mensajeUsuario);
=======
                throw new DataUbicoException(mensajeTecnico, mensajeUsuario);
>>>>>>> Stashed changes
            }
            case SQL_SERVER: {
                var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00002);
                var mensajeTecnico = "No existe una factoria de base de datos configurada para SQL_SERVER";

<<<<<<< Updated upstream
                throw new DataTiendaChepitoException(mensajeTecnico, mensajeUsuario);
=======
                throw new DataUbicoException(mensajeTecnico, mensajeUsuario);
>>>>>>> Stashed changes
            }
            case MYSQL: {
                var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00002);
                var mensajeTecnico = "No existe una factoria de base de datos configurada para MYSQL";

<<<<<<< Updated upstream
                throw new DataTiendaChepitoException(mensajeTecnico, mensajeUsuario);
=======
                throw new DataUbicoException(mensajeTecnico, mensajeUsuario);
>>>>>>> Stashed changes
            }
            case ORACLE: {
                var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00002);
                var mensajeTecnico = "No existe una factoria de base de datos configurada para ORACLE";

<<<<<<< Updated upstream
                throw new DataTiendaChepitoException(mensajeTecnico, mensajeUsuario);
            }
            default:
                return new AzureSqlDAOFactory();
        }
    }
=======
                throw new DataUbicoException(mensajeTecnico, mensajeUsuario);}
            default:
                return new AzureSqlDAOFactory();
            }
        }
            
  
>>>>>>> Stashed changes
    protected abstract void obtenerConexion();

    public abstract void iniciarTransaccion();

    public abstract void confirmarTransaccion();

    public abstract void cancelarTransaccion();

    public abstract void cerrarConexion();

<<<<<<< Updated upstream
    public abstract PaisDAO getPaisDAO();

    public abstract DepartamentoDAO getDepartamentoDAO();

    public abstract CiudadDAO getCiudadDAO();

    public static void main(String[] args) {
        DAOFactory.getFactory(Factory.AZURE_SQL).getPaisDAO().crear(null);
        DAOFactory.getFactory(Factory.AZURE_SQL).getPaisDAO().actualizar(null);
        DAOFactory.getFactory(Factory.AZURE_SQL).getPaisDAO().eliminar(0);
=======
    public abstract AulaDAO getAulaDAO();
    public  abstract TipoAulaDAO getTipoAulaDAO();
    public abstract BloqueDAO getBloqueDAO();

    public static void main(String[] args) {
        DAOFactory.getFactory(Factory.AZURE_SQL).getAulaDAO().crear(null);
        DAOFactory.getFactory(Factory.AZURE_SQL).getAulaDAO().actualizar(null);
        DAOFactory.getFactory(Factory.AZURE_SQL).getAulaDAO().eliminar(0);
>>>>>>> Stashed changes
//        List<PaisAzureSqlDAO> paisAzureSql = new ArrayList<PaisAzureSqlDAO>();
    }

}
