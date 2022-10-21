package it.prova.televisoredaowithservices.DAO.televisore;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Televisore get(Long idInput) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(Televisore input) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(Televisore input) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Televisore input) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Televisore> findByExample(Televisore input) throws Exception {
		// TODO Auto-generated method stub
		return null;
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

	private Televisore estraiDaDB(ResultSet rs) throws SQLException {
		Televisore result = new Televisore();
		result.setId(rs.getLong("id"));
		result.setMarca(rs.getString("marca"));
		result.setModello(rs.getString("modello"));
		result.setPollici(rs.getInt("pollici"));
		result.setDataProduzione(DateConverter.fromSqlToUtil(rs.getDate("dataproduzione")));
		return result;
	}
}
