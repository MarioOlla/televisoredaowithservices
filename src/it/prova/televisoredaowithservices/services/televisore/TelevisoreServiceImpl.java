package it.prova.televisoredaowithservices.services.televisore;

import java.util.Date;
import java.util.List;

import it.prova.televisoredaowithservices.DAO.televisore.TelevisoreDAO;
import it.prova.televisoredaowithservices.model.Televisore;

public class TelevisoreServiceImpl implements TelevisoreService {

	private TelevisoreDAO televisoreDAO;

	@Override
	public void setTelevisoreDAO(TelevisoreDAO televisoreDAO) {
		this.televisoreDAO = televisoreDAO;

	}

	@Override
	public List<Televisore> listAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Televisore findById(Long idInput) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int aggiorna(Televisore input) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int inserisciNuovo(Televisore input) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int rimuovi(Televisore input) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Televisore> findByExample(Televisore input) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Televisore> allTelevisoriProdottiTraDate(Date dataDa, Date dataA) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Televisore findTelevisorePiuGrande() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String listMarcheTelevisoriProdottiUltimiSeiMesi() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
