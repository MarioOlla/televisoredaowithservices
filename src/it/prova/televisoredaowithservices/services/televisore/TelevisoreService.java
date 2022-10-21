package it.prova.televisoredaowithservices.services.televisore;

import java.util.Date;
import java.util.List;

import it.prova.televisoredaowithservices.DAO.televisore.TelevisoreDAO;
import it.prova.televisoredaowithservices.model.Televisore;

public interface TelevisoreService {

	void setTelevisoreDAO(TelevisoreDAO televisoreDAO);
	
	public List<Televisore> listAll() throws Exception;
	
	public Televisore findById(Long idInput) throws Exception;

	public int aggiorna(Televisore input) throws Exception;

	public int inserisciNuovo(Televisore input) throws Exception;

	public int rimuovi(Televisore input) throws Exception;

	public List<Televisore> findByExample(Televisore input) throws Exception;
	
	public List<Televisore> allTelevisoriProdottiTraDate(Date dataDa, Date dataA)throws Exception;
	
	public Televisore findTelevisorePiuGrande() throws Exception;
	
	public List<String> listMarcheTelevisoriProdottiUltimiSeiMesi() throws Exception;

}
