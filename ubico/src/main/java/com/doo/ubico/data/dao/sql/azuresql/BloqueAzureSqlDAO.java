package com.doo.ubico.data.dao.sql.azuresql;

<<<<<<< Updated upstream

import com.doo.ubico.crosscutting.exception.custom.DataUbicoException;
import com.doo.ubico.crosscutting.exception.messagecatalog.MessageCatalogStrategy;
import com.doo.ubico.crosscutting.exception.messagecatalog.data.CodigoMensaje;
import com.doo.ubico.data.dao.BloqueDAO;
import com.doo.ubico.data.dao.sql.SqlConnection;
import com.doo.ubico.entity.BloqueEntity;

=======
>>>>>>> Stashed changes
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

<<<<<<< Updated upstream
public final class BloqueAzureSqlDAO extends SqlConnection implements BloqueDAO {

    public BloqueAzureSqlDAO(final Connection connection){
=======
import com.doo.ubico.crosscutting.exception.custom.DataUbicoException;
import com.doo.ubico.crosscutting.exception.messagecatalog.MessageCatalogStrategy;
import com.doo.ubico.crosscutting.exception.messagecatalog.data.CodigoMensaje;
import com.doo.ubico.data.dao.BloqueDAO;
import com.doo.ubico.data.dao.sql.SqlConnection;
import com.doo.ubico.entity.BloqueEntity;


public final class BloqueAzureSqlDAO extends SqlConnection implements BloqueDAO {

    public BloqueAzureSqlDAO(final Connection connection) {
>>>>>>> Stashed changes
        super(connection);
    }

    @Override
    public final void actualizar(final BloqueEntity entidad) {
        final var sentenciaSql = new StringBuilder();
<<<<<<< Updated upstream
        sentenciaSql.append("UPDATE Pais ");
        sentenciaSql.append("SET Nombre = ? ");
        sentenciaSql.append("WHERE Id = ?");
=======
        sentenciaSql.append("UPDATE Bloque ");
        sentenciaSql.append("SET Nombre = ? ");
        sentenciaSql.append("WHERE Id = ? ");
>>>>>>> Stashed changes

        try (final PreparedStatement sentenciaPreparada = getConnection().prepareStatement(sentenciaSql.toString())) {
            sentenciaPreparada.setString(1, entidad.getNombre());
            sentenciaPreparada.setInt(2, entidad.getId());
            sentenciaPreparada.executeUpdate();
        } catch (final SQLException exception) {
<<<<<<< Updated upstream
            var mensajeUsuario = "No ha sido posible llevar a cabo la actualización de la información del bloque. Por favor intente de nuevo y en caso de persistir el problema comuníquese con el administrador de la app tiendaChepito";
            var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M000023, entidad.getNombre());
            throw new DataUbicoException(mensajeTecnico, mensajeUsuario, exception);
        } catch (final Exception exception) {
            var mensajeUsuario = "No ha sido posible llevar a cabo la actualización de la información del bloque. Por favor intente de nuevo y en caso de persistir el problema comuníquese con el administrador de la app tiendaChepito";
=======
            var mensajeUsuario = "No ha sido posible llevar a cabo la actualización de la información del Bloque. Por favor intente de nuevo y en caso de persistir el problema comuníquese con el administrador de la app Ubico";
            var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M000023, entidad.getNombre());
            throw new DataUbicoException(mensajeTecnico, mensajeUsuario, exception);
        } catch (final Exception exception) {
            var mensajeUsuario = "No ha sido posible llevar a cabo la actualización de la información del Bloque. Por favor intente de nuevo y en caso de persistir el problema comuníquese con el administrador de la app Ubico";
>>>>>>> Stashed changes
            var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M000024, entidad.getNombre());
            throw new DataUbicoException(mensajeTecnico, mensajeUsuario, exception);
        }
    }

    @Override
    public final List<BloqueEntity> consultar(final BloqueEntity entidad) {
<<<<<<< Updated upstream
        final var listaPaises = new ArrayList<BloqueEntity>();
        final var sentenciaSql = new StringBuilder();
        sentenciaSql.append("SELECT Id, Nombre ");
        sentenciaSql.append("FROM Pais ");
=======
        final var listaBloque= new ArrayList<BloqueEntity>();
        final var sentenciaSql = new StringBuilder();
        sentenciaSql.append("SELECT Id, Nombre ");
        sentenciaSql.append("FROM Bloque ");
>>>>>>> Stashed changes
        sentenciaSql.append("ORDER BY Nombre ASC");

        try (final PreparedStatement sentenciaPreparada = getConnection().prepareStatement(sentenciaSql.toString())) {
            try (final ResultSet resultado = sentenciaPreparada.executeQuery()) {
<<<<<<< Updated upstream
                List<BloqueEntity> bloques = new ArrayList<>();
                while (resultado.next()) {
                    BloqueEntity paisTmp = BloqueEntity.build(resultado.getInt("Id"), resultado.getString("Nombre"));
                    listaPaises.add(paisTmp);
                }
            }
        } catch (final SQLException exception) {
            var mensajeUsuario = "No ha sido posible llevar a cabo la consulta del tipo AULA. Por favor intente de nuevo y en caso de persistir el problema comuníquese con el administrador de la app tiendaChepito";
=======
                List<BloqueEntity> Bloque = new ArrayList<>();
                while (resultado.next()) {
                	BloqueEntity BloqueTmp = BloqueEntity.build(resultado.getInt("Id"), resultado.getString("Nombre"));
                    listaBloque.add(BloqueTmp);
                }
            }
        } catch (final SQLException exception) {
            var mensajeUsuario = "No ha sido posible llevar a cabo la consulta de los Bloques. Por favor intente de nuevo y en caso de persistir el problema comuníquese con el administrador de la app Ubico";
>>>>>>> Stashed changes
            var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M000023);
            throw new DataUbicoException(mensajeTecnico, mensajeUsuario, exception);
        } catch (final DataUbicoException exception){
            throw exception;
        } catch (final Exception exception) {
<<<<<<< Updated upstream
            var mensajeUsuario = "No ha sido posible llevar a cabo la consulta del tipo AULA. Por favor intente de nuevo y en caso de persistir el problema comuníquese con el administrador de la app tiendaChepito";
            var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M000024);
            throw new DataUbicoException(mensajeTecnico, mensajeUsuario, exception);
        }
        return listaPaises;
=======
            var mensajeUsuario = "No ha sido posible llevar a cabo la consulta de los Bloques. Por favor intente de nuevo y en caso de persistir el problema comuníquese con el administrador de la app Ubico";
            var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M000024);
            throw new DataUbicoException(mensajeTecnico, mensajeUsuario, exception);
        }
        return listaBloque;
>>>>>>> Stashed changes
    }

    @Override
    public final void crear(final BloqueEntity entidad) {
        final var sentenciaSql = new StringBuilder();
<<<<<<< Updated upstream
        sentenciaSql.append("INSERT INTO Pais(Nombre) ");
        sentenciaSql.append("VALUES(?)");
=======
        sentenciaSql.append("INSERT INTO Bloque(Nombre) ");
        sentenciaSql.append("VALUES ('M'), ('EDC'), ('J'), ('CO'), ('E'), ('D')");
>>>>>>> Stashed changes

        try (final PreparedStatement sentenciaPreparada = getConnection().prepareStatement(sentenciaSql.toString())) {
            sentenciaPreparada.setString(1, entidad.getNombre());
            sentenciaPreparada.executeUpdate();
        } catch (final SQLException exception) {
<<<<<<< Updated upstream
            var mensajeUsuario = "No ha sido posible llevar a cabo el registro de la información del nuevo TipoAula. Por favor intente de nuevo y en caso de persistir el problema comuníquese con el administrador de la app tiendaChepito";
            var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M000023, entidad.getNombre());
            throw new DataUbicoException(mensajeTecnico, mensajeUsuario, exception);
        } catch (final Exception exception) {
            var mensajeUsuario = "No ha sido posible llevar a cabo el registro de la información del nuevo TipoAula. Por favor intente de nuevo y en caso de persistir el problema comuníquese con el administrador de la app tiendaChepito";
=======
            var mensajeUsuario = "No ha sido posible llevar a cabo el registro de la información del nuevo Bloque. Por favor intente de nuevo y en caso de persistir el problema comuníquese con el administrador de la app Ubico";
            var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M000023, entidad.getNombre());
            throw new DataUbicoException(mensajeTecnico, mensajeUsuario, exception);
        } catch (final Exception exception) {
            var mensajeUsuario = "No ha sido posible llevar a cabo el registro de la información del nuevo Bloque. Por favor intente de nuevo y en caso de persistir el problema comuníquese con el administrador de la app Ubico";
>>>>>>> Stashed changes
            var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M000024, entidad.getNombre());
            throw new DataUbicoException(mensajeTecnico, mensajeUsuario, exception);
        }
    }

    @Override
    public final void eliminar(final int id) {
        final var sentenciaSql = new StringBuilder();
<<<<<<< Updated upstream
        sentenciaSql.append("DELETE FROM Pais ");
=======
        sentenciaSql.append("DELETE FROM Bloque ");
>>>>>>> Stashed changes
        sentenciaSql.append("WHERE Id = ?");

        try (final PreparedStatement sentenciaPreparada = getConnection().prepareStatement(sentenciaSql.toString())) {
            sentenciaPreparada.setInt(1, id);
            sentenciaPreparada.executeUpdate();
        } catch (final SQLException exception) {
<<<<<<< Updated upstream
            var mensajeUsuario = "No ha sido posible llevar a cabo la eliminación del TipoAula. Por favor intente de nuevo y en caso de persistir el problema comuníquese con el administrador de la app tiendaChepito";
            var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M000023, String.valueOf(id));
            throw new DataUbicoException(mensajeTecnico, mensajeUsuario, exception);
        } catch (final Exception exception) {
            var mensajeUsuario = "No ha sido posible llevar a cabo la eliminación del TipoAula. Por favor intente de nuevo y en caso de persistir el problema comuníquese con el administrador de la app tiendaChepito";
=======
            var mensajeUsuario = "No ha sido posible llevar a cabo la eliminación del Bloque. Por favor intente de nuevo y en caso de persistir el problema comuníquese con el administrador de la app Ubico";
            var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M000023, String.valueOf(id));
            throw new DataUbicoException(mensajeTecnico, mensajeUsuario, exception);
        } catch (final Exception exception) {
            var mensajeUsuario = "No ha sido posible llevar a cabo la eliminación del Bloque. Por favor intente de nuevo y en caso de persistir el problema comuníquese con el administrador de la app Ubico";
>>>>>>> Stashed changes
            var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M000024, String.valueOf(id));
            throw new DataUbicoException(mensajeTecnico, mensajeUsuario, exception);
        }
    }
}
