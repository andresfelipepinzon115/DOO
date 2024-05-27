<<<<<<< Updated upstream
package co.edu.uco.tiendachepito.data.DAO.sql.azuresql;

import co.edu.uco.tiendachepito.data.DAO.CiudadDAO;
import co.edu.uco.tiendachepito.data.DAO.sql.SqlConnection;
import co.edu.uco.tiendachepito.entity.CiudadEntity;

import java.sql.Connection;
import java.util.List;

public final class CiudadAzureSqlDAO extends SqlConnection implements CiudadDAO {

    public CiudadAzureSqlDAO(final Connection connection){
=======
package com.doo.ubico.data.dao.sql.azuresql;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.doo.ubico.crosscutting.exception.custom.DataUbicoException;
import com.doo.ubico.crosscutting.exception.messagecatalog.MessageCatalogStrategy;
import com.doo.ubico.crosscutting.exception.messagecatalog.data.CodigoMensaje;
import com.doo.ubico.data.dao.AulaDAO;
import com.doo.ubico.data.dao.sql.SqlConnection;
import com.doo.ubico.entity.AulaEntity;
import com.doo.ubico.entity.BloqueEntity;

public final class AulaAzureSqlDAO extends SqlConnection implements AulaDAO {

    public AulaAzureSqlDAO(final Connection connection){
>>>>>>> Stashed changes
        super(connection);
    }

    @Override
<<<<<<< Updated upstream
    public final void actualizar(final CiudadEntity entidad) {
        final var sentenciaSql = new StringBuilder();
        sentenciaSql.append("UPDATE Ciudad");
        sentenciaSql.append("SET Nombre = 'Barranquilla' ");
        sentenciaSql.append("WHERE Id = '1'");
    }

    @Override
    public final List<CiudadEntity> consultar(final CiudadEntity entidad) {
        final var sentenciaSql = new StringBuilder();
        sentenciaSql.append("SELECT  Id, Nombre");
        sentenciaSql.append("FROM Departamento");
        sentenciaSql.append("ORDER BY Nombre ASC");
        return null;
    }

    @Override
    public final void crear(final CiudadEntity entidad) {
        final var sentenciaSql = new StringBuilder();
        sentenciaSql.append("INSERT INTO Ciudad(Nombre)");
        sentenciaSql.append("VALUES('Rionegro')");
=======
    public final void actualizar(final AulaEntity entidad) {
        final var sentenciaSql = new StringBuilder();
        sentenciaSql.append("UPDATE Aula");
        sentenciaSql.append("SET Nombre =? ");
        sentenciaSql.append("SET Capacidad =? ");
        sentenciaSql.append("WHERE Id = ? ");
        try (final PreparedStatement sentenciaPreparada = getConnection().prepareStatement(sentenciaSql.toString())) {
            sentenciaPreparada.setString(1, entidad.getNombre());
            sentenciaPreparada.setInt(2, entidad.getId());
            sentenciaPreparada.setInt(3, entidad.getCapacidad());
            sentenciaPreparada.executeUpdate();
        } catch (final SQLException exception) {
            var mensajeUsuario = "No ha sido posible llevar a cabo la actualización de la información del Aula. Por favor intente de nuevo y en caso de persistir el problema comuníquese con el administrador de la app Ubico";
            var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M000023, entidad.getNombre());
            throw new DataUbicoException(mensajeTecnico, mensajeUsuario, exception);
        } catch (final Exception exception) {
            var mensajeUsuario = "No ha sido posible llevar a cabo la actualización de la información del Aula. Por favor intente de nuevo y en caso de persistir el problema comuníquese con el administrador de la app Ubico";
            var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M000024, entidad.getNombre());
            throw new DataUbicoException(mensajeTecnico, mensajeUsuario, exception);
        }
    }

    @Override
    public final List<AulaEntity> consultar(final AulaEntity entidad) {
        final var listaAula= new ArrayList<AulaEntity>();
        final var sentenciaSql = new StringBuilder();
        sentenciaSql.append("SELECT Id, Nombre, Capacidad");
        sentenciaSql.append("FROM Aula ");
        sentenciaSql.append("ORDER BY Nombre ASC");

        try (final PreparedStatement sentenciaPreparada = getConnection().prepareStatement(sentenciaSql.toString())) {
            try (final ResultSet resultado = sentenciaPreparada.executeQuery()) {
                List<AulaEntity> Aula = new ArrayList<>();
                while (resultado.next()) {
                	AulaEntity AulaTmp = AulaEntity.build(resultado.getInt("Id"), resultado.getString("Nombre"), resultado.getString("Bloque"), resultado.getString("TipoAula"), resultado.getInt("Capacidad"));
                    listaAula.add(AulaTmp);
                }
            }
        } catch (final SQLException exception) {
            var mensajeUsuario = "No ha sido posible llevar a cabo la consulta de los Aula. Por favor intente de nuevo y en caso de persistir el problema comuníquese con el administrador de la app Ubico";
            var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M000023);
            throw new DataUbicoException(mensajeTecnico, mensajeUsuario, exception);
        } catch (final DataUbicoException exception){
            throw exception;
        } catch (final Exception exception) {
            var mensajeUsuario = "No ha sido posible llevar a cabo la consulta de los Aula. Por favor intente de nuevo y en caso de persistir el problema comuníquese con el administrador de la app Ubico";
            var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M000024);
            throw new DataUbicoException(mensajeTecnico, mensajeUsuario, exception);
        }
        return listaAula;
    }

    @Override
    public final void crear(final AulaEntity entidad) {
        final var sentenciaSql = new StringBuilder();
        sentenciaSql.append("INSERT INTO Aula(Nombre) ");
        sentenciaSql.append("VALUES(?)");

        try (final PreparedStatement sentenciaPreparada = getConnection().prepareStatement(sentenciaSql.toString())) {
            sentenciaPreparada.setString(1, entidad.getNombre());
            sentenciaPreparada.executeUpdate();
        } catch (final SQLException exception) {
            var mensajeUsuario = "No ha sido posible llevar a cabo el registro de la información del nuevo Aula. Por favor intente de nuevo y en caso de persistir el problema comuníquese con el administrador de la app Ubico";
            var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M000023, entidad.getNombre());
            throw new DataUbicoException(mensajeTecnico, mensajeUsuario, exception);
        } catch (final Exception exception) {
            var mensajeUsuario = "No ha sido posible llevar a cabo el registro de la información del nuevo Aula. Por favor intente de nuevo y en caso de persistir el problema comuníquese con el administrador de la app Ubico";
            var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M000024, entidad.getNombre());
            throw new DataUbicoException(mensajeTecnico, mensajeUsuario, exception);
        }
>>>>>>> Stashed changes
    }

    @Override
    public final void eliminar(final int id) {
        final var sentenciaSql = new StringBuilder();
<<<<<<< Updated upstream
        sentenciaSql.append("DELETE FROM Ciudad");
        sentenciaSql.append("WHERE Id = '1'");
=======
        sentenciaSql.append("DELETE FROM Aula ");
        sentenciaSql.append("WHERE Id = ?");

        try (final PreparedStatement sentenciaPreparada = getConnection().prepareStatement(sentenciaSql.toString())) {
            sentenciaPreparada.setInt(1, id);
            sentenciaPreparada.executeUpdate();
        } catch (final SQLException exception) {
            var mensajeUsuario = "No ha sido posible llevar a cabo la eliminación del Aula. Por favor intente de nuevo y en caso de persistir el problema comuníquese con el administrador de la app Ubico";
            var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M000023, String.valueOf(id));
            throw new DataUbicoException(mensajeTecnico, mensajeUsuario, exception);
        } catch (final Exception exception) {
            var mensajeUsuario = "No ha sido posible llevar a cabo la eliminación del Aula. Por favor intente de nuevo y en caso de persistir el problema comuníquese con el administrador de la app Ubico";
            var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M000024, String.valueOf(id));
            throw new DataUbicoException(mensajeTecnico, mensajeUsuario, exception);
        }
>>>>>>> Stashed changes
    }
}
