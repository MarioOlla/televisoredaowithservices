package it.prova.televisoredaowithservices.DAO.televisore;

import java.util.Date;
import java.util.List;

import it.prova.televisoredaowithservices.DAO.IBaseDAO;
import it.prova.televisoredaowithservices.model.Televisore;

public interface TelevisoreDAO extends IBaseDAO<Televisore> {
	
	public List<Televisore> tuttiITelevisoriProdottiTraDate(Date dataDa, Date dataA)throws Exception;
	public Televisore ilTelevisorePiuGrande() throws Exception;
	public List<String> listaMarcheTelevisoriProdottiUltimiSeiMesi() throws Exception;
}
