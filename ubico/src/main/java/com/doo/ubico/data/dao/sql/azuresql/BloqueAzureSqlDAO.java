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
import com.doo.ubico.data.dao.BloqueDAO;
import com.doo.ubico.data.dao.sql.SqlConnection;
import com.doo.ubico.entity.BloqueEntity;


public final class BloqueAzureSqlDAO extends SqlConnection implements BloqueDAO {

    public BloqueAzureSqlDAO(final Connection connection) {
        super(connection);
    }

    @Override
    public List<BloqueEntity> consultar(final BloqueEntity entity) {
        final var listaBloques = new ArrayList<BloqueEntity>();
        final var sql = "SELECT * FROM bloques";

        try (final PreparedStatement preparedStatement = getConnection().prepareStatement(sql);
             final ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                var bloque = new BloqueEntity(resultSet.getInt("id"), resultSet.getString("nombre"));
                listaBloques.add(bloque);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error al consultar los bloques", e);
        }

        return listaBloques;
    }

    @Override
    public void actualizar(BloqueEntity entidad) {

    }

    @Override
    public void crear(BloqueEntity entidad) {

    }

    @Override
    public void eliminar(int id) {

    }
}
