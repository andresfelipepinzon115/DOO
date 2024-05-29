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
import com.doo.ubico.entity.TipoAulaEntity;

public final class AulaAzureSqlDAO extends SqlConnection implements AulaDAO {

    public AulaAzureSqlDAO(final Connection connection) {
        super(connection);
    }

    @Override
    public final void actualizar(final AulaEntity entidad) {
        final var sentenciaSql = new StringBuilder();
        sentenciaSql.append("UPDATE Aula ");
        sentenciaSql.append("SET Nombre = ?, Capacidad = ?, Bloque = ?, TipoAula = ? ");
        sentenciaSql.append("WHERE Id = ?");

        try (final PreparedStatement sentenciaPreparada = getConnection().prepareStatement(sentenciaSql.toString())) {
            sentenciaPreparada.setString(1, entidad.getNombre());
            sentenciaPreparada.setInt(2, entidad.getCapacidad());
            sentenciaPreparada.setInt(3, entidad.getBloque().getId());
            sentenciaPreparada.setInt(4, entidad.getTipoAula().getId());
            sentenciaPreparada.setInt(5, entidad.getId());
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
        final var listaAula = new ArrayList<AulaEntity>();
        final var sentenciaSql = new StringBuilder();
        sentenciaSql.append("SELECT Id, Nombre, Capacidad, Bloque, TipoAula ");
        sentenciaSql.append("FROM Aula ");
        sentenciaSql.append("ORDER BY Nombre ASC");

        try (final PreparedStatement sentenciaPreparada = getConnection().prepareStatement(sentenciaSql.toString())) {
            try (final ResultSet resultado = sentenciaPreparada.executeQuery()) {
                while (resultado.next()) {
                    BloqueEntity bloque = BloqueEntity.build(resultado.getInt("Bloque")); // Método estático para instanciar BloqueEntity
                    TipoAulaEntity tipoAula = TipoAulaEntity.build(resultado.getInt("TipoAula")); // Método estático para instanciar TipoAulaEntity

                    AulaEntity aulaTmp = AulaEntity.build(
                            resultado.getInt("Id"),
                            resultado.getString("Nombre"),
                            resultado.getInt("Capacidad"),
                            tipoAula,
                            bloque
                    );
                    listaAula.add(aulaTmp);
                }
            }
        } catch (final SQLException exception) {
            var mensajeUsuario = "No ha sido posible llevar a cabo la consulta de los Aula. Por favor intente de nuevo y en caso de persistir el problema comuníquese con el administrador de la app Ubico";
            var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M000023);
            throw new DataUbicoException(mensajeTecnico, mensajeUsuario, exception);
        } catch (final DataUbicoException exception) {
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
        sentenciaSql.append("INSERT INTO Aula(Nombre, Capacidad, Bloque, TipoAula) ");
        sentenciaSql.append("VALUES(?, ?, ?, ?)");

        try (final PreparedStatement sentenciaPreparada = getConnection().prepareStatement(sentenciaSql.toString())) {
            sentenciaPreparada.setString(1, entidad.getNombre());
            sentenciaPreparada.setInt(2, entidad.getCapacidad());
            sentenciaPreparada.setInt(3, entidad.getBloque().getId());
            sentenciaPreparada.setInt(4, entidad.getTipoAula().getId());
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
    }

    @Override
    public final void eliminar(final int id) {
        final var sentenciaSql = new StringBuilder();
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
    }
}
