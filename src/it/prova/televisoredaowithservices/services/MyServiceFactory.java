package it.prova.televisoredaowithservices.services;

import it.prova.televisoredaowithservices.DAO.televisore.TelevisoreDAOImpl;
import it.prova.televisoredaowithservices.services.televisore.TelevisoreService;
import it.prova.televisoredaowithservices.services.televisore.TelevisoreServiceImpl;

public class MyServiceFactory {
	
	public static TelevisoreService getTelevisoreServiceImpl() {
		TelevisoreService televisoreService = new TelevisoreServiceImpl();
		televisoreService.setTelevisoreDAO(new TelevisoreDAOImpl());
		return televisoreService;
	}
}
