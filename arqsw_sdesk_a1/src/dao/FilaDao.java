package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entity.Fila;

public class FilaDao {

	public ArrayList<Fila> listarFilas() throws IOException {
		String query = "SELECT id_fila, nm_fila FROM fila";
		ArrayList<Fila> lista = new ArrayList<>();

		try (Connection conn = ConnectionFactory.getConnection();
				PreparedStatement pst = conn.prepareStatement(query);
				ResultSet rs = pst.executeQuery();) {

			while (rs.next()) {
				Fila fila = new Fila();

				fila.setId(rs.getInt("id_fila"));
				fila.setNome(rs.getString("nm_fila"));

				lista.add(fila);
			}

		} catch (SQLException e) {
			throw new IOException(e);
		}
		return lista;
	}

}
