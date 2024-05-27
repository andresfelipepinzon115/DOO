<<<<<<< Updated upstream
package co.edu.uco.tiendachepito.data.DAO.sql.azuresql;

import co.edu.uco.tiendachepito.crosscutting.crosscutting.exception.custom.DataTiendaChepitoException;
import co.edu.uco.tiendachepito.crosscutting.crosscutting.exception.messagecatalog.MessageCatalogStrategy;
import co.edu.uco.tiendachepito.crosscutting.crosscutting.exception.messagecatalog.data.CodigoMensaje;
import co.edu.uco.tiendachepito.data.DAO.PaisDAO;
import co.edu.uco.tiendachepito.data.DAO.sql.SqlConnection;
import co.edu.uco.tiendachepito.entity.PaisEntity;
=======
package com.doo.ubico.data.dao.sql.azuresql;
>>>>>>> Stashed changes

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

<<<<<<< Updated upstream
public final class PaisAzureSqlDAO extends SqlConnection implements PaisDAO {

    public PaisAzureSqlDAO(final Connection connection) {
=======
import com.doo.ubico.crosscutting.exception.custom.DataUbicoException;
import com.doo.ubico.crosscutting.exception.messagecatalog.MessageCatalogStrategy;
import com.doo.ubico.crosscutting.exception.messagecatalog.data.CodigoMensaje;
import com.doo.ubico.data.dao.TipoAulaDAO;
import com.doo.ubico.data.dao.sql.SqlConnection;
import com.doo.ubico.entity.TipoAulaEntity;

public final class TipoAulaAzureSqlDAO extends SqlConnection implements TipoAulaDAO {

    public TipoAulaAzureSqlDAO(final Connection connection) {
>>>>>>> Stashed changes
        super(connection);
    }

    @Override
<<<<<<< Updated upstream
    public final void actualizar(final PaisEntity entidad) {
        final var sentenciaSql = new StringBuilder();
        sentenciaSql.append("UPDATE Pais ");
=======
    public final void actualizar(final TipoAulaEntity entidad) {
        final var sentenciaSql = new StringBuilder();
        sentenciaSql.append("UPDATE TipoAula ");
>>>>>>> Stashed changes
        sentenciaSql.append("SET Nombre = ? ");
        sentenciaSql.append("WHERE Id = ?");

        try (final PreparedStatement sentenciaPreparada = getConnection().prepareStatement(sentenciaSql.toString())) {
            sentenciaPreparada.setString(1, entidad.getNombre());
            sentenciaPreparada.setInt(2, entidad.getId());
            sentenciaPreparada.executeUpdate();
        } catch (final SQLException exception) {
<<<<<<< Updated upstream
            var mensajeUsuario = "No ha sido posible llevar a cabo la actualización de la información del país. Por favor intente de nuevo y en caso de persistir el problema comuníquese con el administrador de la app tiendaChepito";
            var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M000023, entidad.getNombre());
            throw new DataTiendaChepitoException(mensajeTecnico, mensajeUsuario, exception);
        } catch (final Exception exception) {
            var mensajeUsuario = "No ha sido posible llevar a cabo la actualización de la información del país. Por favor intente de nuevo y en caso de persistir el problema comuníquese con el administrador de la app tiendaChepito";
            var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M000024, entidad.getNombre());
            throw new DataTiendaChepitoException(mensajeTecnico, mensajeUsuario, exception);
=======
            var mensajeUsuario = "No ha sido posible llevar a cabo la actualización de la información del TipoAula. Por favor intente de nuevo y en caso de persistir el problema comuníquese con el administrador de la app Ubico";
            var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M000023, entidad.getNombre());
            throw new DataUbicoException(mensajeTecnico, mensajeUsuario, exception);
        } catch (final Exception exception) {
            var mensajeUsuario = "No ha sido posible llevar a cabo la actualización de la información del TipoAula. Por favor intente de nuevo y en caso de persistir el problema comuníquese con el administrador de la app Ubico";
            var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M000024, entidad.getNombre());
            throw new DataUbicoException(mensajeTecnico, mensajeUsuario, exception);
>>>>>>> Stashed changes
        }
    }

    @Override
<<<<<<< Updated upstream
    public final List<PaisEntity> consultar(final PaisEntity entidad) {
        final var listaPaises = new ArrayList<PaisEntity>();
        final var sentenciaSql = new StringBuilder();
        sentenciaSql.append("SELECT Id, Nombre ");
        sentenciaSql.append("FROM Pais ");
=======
    public final List<TipoAulaEntity> consultar(final TipoAulaEntity entidad) {
        final var listaTipoAula= new ArrayList<TipoAulaEntity>();
        final var sentenciaSql = new StringBuilder();
        sentenciaSql.append("SELECT Id, Nombre ");
        sentenciaSql.append("FROM TipoAula ");
>>>>>>> Stashed changes
        sentenciaSql.append("ORDER BY Nombre ASC");

        try (final PreparedStatement sentenciaPreparada = getConnection().prepareStatement(sentenciaSql.toString())) {
            try (final ResultSet resultado = sentenciaPreparada.executeQuery()) {
<<<<<<< Updated upstream
                List<PaisEntity> paises = new ArrayList<>();
                while (resultado.next()) {
                    PaisEntity paisTmp = PaisEntity.build(resultado.getInt("Id"), resultado.getString("Nombre"));
                    listaPaises.add(paisTmp);
                }
            }
        } catch (final SQLException exception) {
            var mensajeUsuario = "No ha sido posible llevar a cabo la consulta de los países. Por favor intente de nuevo y en caso de persistir el problema comuníquese con el administrador de la app tiendaChepito";
            var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M000023);
            throw new DataTiendaChepitoException(mensajeTecnico, mensajeUsuario, exception);
        } catch (final DataTiendaChepitoException exception){
            throw exception;
        } catch (final Exception exception) {
            var mensajeUsuario = "No ha sido posible llevar a cabo la consulta de los países. Por favor intente de nuevo y en caso de persistir el problema comuníquese con el administrador de la app tiendaChepito";
            var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M000024);
            throw new DataTiendaChepitoException(mensajeTecnico, mensajeUsuario, exception);
        }
        return listaPaises;
    }

    @Override
    public final void crear(final PaisEntity entidad) {
        final var sentenciaSql = new StringBuilder();
        sentenciaSql.append("INSERT INTO Pais(Nombre) ");
        sentenciaSql.append("VALUES(?)");
=======
                List<TipoAulaEntity> TipoAula = new ArrayList<>();
                while (resultado.next()) {
                	TipoAulaEntity TipoAulaTmp = TipoAulaEntity.build(resultado.getInt("Id"), resultado.getString("Nombre"));
                    listaTipoAula.add(TipoAulaTmp);
                }
            }
        } catch (final SQLException exception) {
            var mensajeUsuario = "No ha sido posible llevar a cabo la consulta de los Tipos de aulas. Por favor intente de nuevo y en caso de persistir el problema comuníquese con el administrador de la app Ubico";
            var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M000023);
            throw new DataUbicoException(mensajeTecnico, mensajeUsuario, exception);
        } catch (final DataUbicoException exception){
            throw exception;
        } catch (final Exception exception) {
            var mensajeUsuario = "No ha sido posible llevar a cabo la consulta de los Tipos de Aulas. Por favor intente de nuevo y en caso de persistir el problema comuníquese con el administrador de la app Ubico";
            var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M000024);
            throw new DataUbicoException(mensajeTecnico, mensajeUsuario, exception);
        }
        return listaTipoAula;
    }

    @Override
    public final void crear(final TipoAulaEntity entidad) {
        final var sentenciaSql = new StringBuilder();
        sentenciaSql.append("INSERT INTO TipoAula(Nombre) ");
        sentenciaSql.append("VALUES ('Aula Común'), ('Salon de Informatica'), ('Laboratorio')");
>>>>>>> Stashed changes

        try (final PreparedStatement sentenciaPreparada = getConnection().prepareStatement(sentenciaSql.toString())) {
            sentenciaPreparada.setString(1, entidad.getNombre());
            sentenciaPreparada.executeUpdate();
        } catch (final SQLException exception) {
<<<<<<< Updated upstream
            var mensajeUsuario = "No ha sido posible llevar a cabo el registro de la información del nuevo país. Por favor intente de nuevo y en caso de persistir el problema comuníquese con el administrador de la app tiendaChepito";
            var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M000023, entidad.getNombre());
            throw new DataTiendaChepitoException(mensajeTecnico, mensajeUsuario, exception);
        } catch (final Exception exception) {
            var mensajeUsuario = "No ha sido posible llevar a cabo el registro de la información del nuevo país. Por favor intente de nuevo y en caso de persistir el problema comuníquese con el administrador de la app tiendaChepito";
            var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M000024, entidad.getNombre());
            throw new DataTiendaChepitoException(mensajeTecnico, mensajeUsuario, exception);
=======
            var mensajeUsuario = "No ha sido posible llevar a cabo el registro de la información del nuevo TipoAula. Por favor intente de nuevo y en caso de persistir el problema comuníquese con el administrador de la app Ubico";
            var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M000023, entidad.getNombre());
            throw new DataUbicoException(mensajeTecnico, mensajeUsuario, exception);
        } catch (final Exception exception) {
            var mensajeUsuario = "No ha sido posible llevar a cabo el registro de la información del nuevo TipoAula. Por favor intente de nuevo y en caso de persistir el problema comuníquese con el administrador de la app Ubico";
            var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M000024, entidad.getNombre());
            throw new DataUbicoException(mensajeTecnico, mensajeUsuario, exception);
>>>>>>> Stashed changes
        }
    }

    @Override
    public final void eliminar(final int id) {
        final var sentenciaSql = new StringBuilder();
<<<<<<< Updated upstream
        sentenciaSql.append("DELETE FROM Pais ");
=======
        sentenciaSql.append("DELETE FROM TipoAula ");
>>>>>>> Stashed changes
        sentenciaSql.append("WHERE Id = ?");

        try (final PreparedStatement sentenciaPreparada = getConnection().prepareStatement(sentenciaSql.toString())) {
            sentenciaPreparada.setInt(1, id);
            sentenciaPreparada.executeUpdate();
        } catch (final SQLException exception) {
<<<<<<< Updated upstream
            var mensajeUsuario = "No ha sido posible llevar a cabo la eliminación del país. Por favor intente de nuevo y en caso de persistir el problema comuníquese con el administrador de la app tiendaChepito";
            var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M000023, String.valueOf(id));
            throw new DataTiendaChepitoException(mensajeTecnico, mensajeUsuario, exception);
        } catch (final Exception exception) {
            var mensajeUsuario = "No ha sido posible llevar a cabo la eliminación del país. Por favor intente de nuevo y en caso de persistir el problema comuníquese con el administrador de la app tiendaChepito";
            var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M000024, String.valueOf(id));
            throw new DataTiendaChepitoException(mensajeTecnico, mensajeUsuario, exception);
=======
            var mensajeUsuario = "No ha sido posible llevar a cabo la eliminación del TipoAula. Por favor intente de nuevo y en caso de persistir el problema comuníquese con el administrador de la app Ubico";
            var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M000023, String.valueOf(id));
            throw new DataUbicoException(mensajeTecnico, mensajeUsuario, exception);
        } catch (final Exception exception) {
            var mensajeUsuario = "No ha sido posible llevar a cabo la eliminación del TipoAula. Por favor intente de nuevo y en caso de persistir el problema comuníquese con el administrador de la app Ubico";
            var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M000024, String.valueOf(id));
            throw new DataUbicoException(mensajeTecnico, mensajeUsuario, exception);
>>>>>>> Stashed changes
        }
    }
}
