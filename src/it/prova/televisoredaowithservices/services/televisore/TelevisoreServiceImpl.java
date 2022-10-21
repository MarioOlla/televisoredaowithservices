package it.prova.televisoredaowithservices.services.televisore;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import it.prova.televisoredaowithservices.DAO.Constants;
import it.prova.televisoredaowithservices.DAO.televisore.TelevisoreDAO;
import it.prova.televisoredaowithservices.connection.MyConnection;
import it.prova.televisoredaowithservices.model.Televisore;

public class TelevisoreServiceImpl implements TelevisoreService {

	private TelevisoreDAO televisoreDAO;

	@Override
	public void setTelevisoreDAO(TelevisoreDAO televisoreDAO) {
		this.televisoreDAO = televisoreDAO;

	}

	@Override
	public List<Televisore> listAll() throws Exception {
		List<Televisore> result = new ArrayList<>();
		try (Connection connection = MyConnection.getConnection(Constants.DRIVER_NAME, Constants.CONNECTION_URL)) {

			televisoreDAO.setConnection(connection);

			result = televisoreDAO.list();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return result;
	}

	@Override
	public Televisore findById(Long idInput) throws Exception {
		Televisore result = null;
		try (Connection connection = MyConnection.getConnection(Constants.DRIVER_NAME, Constants.CONNECTION_URL)) {

			televisoreDAO.setConnection(connection);

			result = televisoreDAO.get(idInput);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return result;
	}

	@Override
	public int aggiorna(Televisore input) throws Exception {
		int result = 0;
		try (Connection connection = MyConnection.getConnection(Constants.DRIVER_NAME, Constants.CONNECTION_URL)) {

			televisoreDAO.setConnection(connection);

			result = televisoreDAO.update(input);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return result;
	}

	@Override
	public int inserisciNuovo(Televisore input) throws Exception {
		int result = 0;
		try (Connection connection = MyConnection.getConnection(Constants.DRIVER_NAME, Constants.CONNECTION_URL)) {

			televisoreDAO.setConnection(connection);

			result = televisoreDAO.insert(input);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return result;
	}

	@Override
	public int rimuovi(Televisore input) throws Exception {
		int result = 0;
		try (Connection connection = MyConnection.getConnection(Constants.DRIVER_NAME, Constants.CONNECTION_URL)) {

			televisoreDAO.setConnection(connection);

			result = televisoreDAO.delete(input);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return result;
	}

	@Override
	public List<Televisore> findByExample(Televisore input) throws Exception {
		List<Televisore> result = new ArrayList<>();
		try (Connection connection = MyConnection.getConnection(Constants.DRIVER_NAME, Constants.CONNECTION_URL)) {

			televisoreDAO.setConnection(connection);

			result = televisoreDAO.findByExample(input);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return result;
	}

	@Override
	public List<Televisore> allTelevisoriProdottiTraDate(Date dataDa, Date dataA) throws Exception {
		List<Televisore> result = new ArrayList<>();
		try (Connection connection = MyConnection.getConnection(Constants.DRIVER_NAME, Constants.CONNECTION_URL)) {

			televisoreDAO.setConnection(connection);

			result = televisoreDAO.tuttiITelevisoriProdottiTraDate(dataDa, dataA);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return result;
	}

	@Override
	public Televisore findTelevisorePiuGrande() throws Exception {
		Televisore result = null;
		try (Connection connection = MyConnection.getConnection(Constants.DRIVER_NAME, Constants.CONNECTION_URL)) {

			televisoreDAO.setConnection(connection);

			result = televisoreDAO.ilTelevisorePiuGrande();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return result;
	}

	@Override
	public List<String> listMarcheTelevisoriProdottiUltimiSeiMesi() throws Exception {
		List<String> result = new ArrayList<>();
		try (Connection connection = MyConnection.getConnection(Constants.DRIVER_NAME, Constants.CONNECTION_URL)) {

			televisoreDAO.setConnection(connection);

			result = televisoreDAO.listaMarcheTelevisoriProdottiUltimiSeiMesi();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return result;
	}

}
