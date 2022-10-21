package it.prova.televisoredaowithservices.DAO.televisore;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import it.prova.televisoredaowithservices.DAO.AbstractMySQLDAO;
import it.prova.televisoredaowithservices.model.Televisore;
import it.prova.televisoredaowithservices.utility.DateConverter;

public class TelevisoreDAOImpl extends AbstractMySQLDAO implements TelevisoreDAO {

	@Override
	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	@Override
	public List<Televisore> list() throws Exception {
		if (isNotActive())
			throw new Exception("Impossibile effettuare operazioni sul DB. La connessione non e' attiva.");
		List<Televisore> result = new ArrayList<>();
		try (Statement ps = connection.createStatement(); ResultSet rs = ps.executeQuery("select * from televisore;")) {
			if (rs.next())

				// estraiDaDB si occupa di "riempire" con i valori giusti le variabili di
				// istanza
				result.add(this.estraiDaDB(rs));

		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public Televisore get(Long idInput) throws Exception {
		if (isNotActive())
			throw new Exception("Impossibile effettuare operazioni sul DB. La connessione non e' attiva.");
		if (idInput == null || idInput < 1)
			throw new Exception("Impossibile effettuare operazioni su DB. Input non valido.");
		Televisore result = null;
		try (PreparedStatement ps = connection.prepareStatement("select * from televisore where id=?;")) {
			ps.setLong(1, idInput);
			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next())
					result = this.estraiDaDB(rs);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return result;
	}

	@Override
	public int update(Televisore input) throws Exception {
		if (isNotActive())
			throw new Exception("Impossibile effettuare operazioni sul DB. La connessione non e' attiva.");
		if (input == null || input.getId() == null || input.getId() < 1)
			throw new Exception("Impossibile effettuare operazioni su DB. Input non valido.");
		int result = 0;
		try (PreparedStatement ps = connection.prepareStatement(
				"update televisore set marca=?, modello=?, pollici=?, dataproduzione=? where id=?;")) {
			this.preparaDatiPerDB(ps, input);
			ps.setLong(5, input.getId());
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return result;
	}

	@Override
	public int insert(Televisore input) throws Exception {
		if (isNotActive())
			throw new Exception("Impossibile effettuare operazioni sul DB. La connessione non e' attiva.");
		if (input == null)
			throw new Exception("Impossibile effettuare operazioni su DB. Input non valido.");
		int result = 0;
		try (PreparedStatement ps = connection.prepareStatement(
				"insert into televisore (marca, modello, pollici, dataproduzione) values (?,?,?,?);")) {
			this.preparaDatiPerDB(ps, input);
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return result;
	}

	@Override
	public int delete(Televisore input) throws Exception {
		if (isNotActive())
			throw new Exception("Impossibile effettuare operazioni sul DB. La connessione non e' attiva.");
		if (input == null || input.getId() == null || input.getId() < 1)
			throw new Exception("Impossibile effettuare operazioni su DB. Input non valido.");
		int result = 0;
		try (PreparedStatement ps = connection.prepareStatement("delete from televisore where id=?;")) {
			ps.setLong(1, input.getId());
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return result;
	}

	@Override
	public List<Televisore> findByExample(Televisore input) throws Exception {
		if (isNotActive())
			throw new Exception("Impossibile effettuare operazioni sul DB. La connessione non e' attiva.");
		if (input == null)
			throw new Exception("Impossibile effettuare operazioni su DB. Input non valido.");
		String query = "select * from televisore where 1=1 ";

		if (input.getMarca() != null || input.getMarca().isBlank())
			query += "and marca like '" + input.getMarca() + "%' ";
		if (input.getModello() != null || input.getModello().isBlank())
			query += "and modello like '" + input.getModello() + "%' ";
		if (input.getPollici() > 0)
			query += "and pollici > " + input.getPollici() + " ";
		if (input.getDataProduzione() != null)
			query += "and dataproduzione > '" + DateConverter.fromUtilToSql(input.getDataProduzione()) + "' ";
		query += ";";

		List<Televisore> result = new ArrayList<>();
		try (PreparedStatement ps = connection.prepareStatement(query)) {

			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					result.add(this.estraiDaDB(rs));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return result;
	}

	@Override
	public List<Televisore> tuttiITelevisoriProdottiTraDate(Date dataDa, Date dataA) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Televisore ilTelevisorePiuGrande() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String listaMarcheTelevisoriProdottiUltimiSeiMesi() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	// metodi di utilita'

	private Televisore estraiDaDB(ResultSet rs) throws SQLException {
		Televisore result = new Televisore();
		result.setId(rs.getLong("id"));
		result.setMarca(rs.getString("marca"));
		result.setModello(rs.getString("modello"));
		result.setPollici(rs.getInt("pollici"));
		result.setDataProduzione(DateConverter.fromSqlToUtil(rs.getDate("dataproduzione")));
		return result;
	}

	private void preparaDatiPerDB(PreparedStatement ps, Televisore input) throws Exception {
		ps.setString(1, input.getMarca());
		ps.setString(2, input.getModello());
		ps.setInt(3, input.getPollici());
		ps.setDate(4, DateConverter.fromUtilToSql(input.getDataProduzione()));
	}

}
