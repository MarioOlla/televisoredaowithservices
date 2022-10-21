package it.prova.televisoredaowithservices.test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import it.prova.televisoredaowithservices.model.Televisore;
import it.prova.televisoredaowithservices.services.MyServiceFactory;
import it.prova.televisoredaowithservices.services.televisore.TelevisoreService;
import it.prova.televisoredaowithservices.utility.DateConverter;

public class testTelevisore {

	public static void main(String[] args) {
		TelevisoreService televisoreService = MyServiceFactory.getTelevisoreServiceImpl();

		try {
			System.out.println("=====Inizio Test Televisore===============================================================");

			testInserisciNuovo(televisoreService);
			System.out.println("In tabella ci sono " + televisoreService.listAll().size() + " elementi.");

			testFindById(televisoreService);
			System.out.println("In tabella ci sono " + televisoreService.listAll().size() + " elementi.");

			testFindByExample(televisoreService);
			System.out.println("In tabella ci sono " + televisoreService.listAll().size() + " elementi.");

			testAggiorna(televisoreService);
			System.out.println("In tabella ci sono " + televisoreService.listAll().size() + " elementi.");
			
			testAllTelevisoriProdottiTraDate(televisoreService);
			System.out.println("In tabella ci sono " + televisoreService.listAll().size() + " elementi.");
			
			testFindTelevisorePiuGrande(televisoreService);
			System.out.println("In tabella ci sono " + televisoreService.listAll().size() + " elementi.");
			
			testListaMarcheTelevisoriProdottiUltimiSeiMesi(televisoreService);
			System.out.println("In tabella ci sono " + televisoreService.listAll().size() + " elementi.");
			
			testRimuovi(televisoreService);
			System.out.println("In tabella ci sono " + televisoreService.listAll().size() + " elementi.");
			
			System.out.println("=====Fine Test Televisore=================================================================");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void testInserisciNuovo(TelevisoreService televisoreService) throws Exception {
		System.out.println("\n___inizio testInserisciNuovo...");
		Televisore daInserire = new Televisore(null, "Sony", "KD43X72K", 43,
				new SimpleDateFormat("dd-MM-yyyy").parse("06-02-2021"));
		int result = televisoreService.inserisciNuovo(daInserire);
		if (result != 1)
			throw new RuntimeException("testInserisciNuovo : FAILED, non e' stato aggiunto alcun record.");
		System.out.println("___fine testInserisciNuovo : PASSED");
	}

	private static void testFindById(TelevisoreService televisoreService) throws Exception {
		System.out.println("\n___inizio testFindById...");
		if (televisoreService.listAll().isEmpty())
			throw new RuntimeException("testFindById : FAILED, il DB e' vuoto.");
		Long idCercato = televisoreService.listAll().get(0).getId();
		Televisore result = televisoreService.findById(idCercato);
		if (!result.getId().equals(televisoreService.listAll().get(0).getId()))
			throw new RuntimeException("testFindById : FAILED, gli id non coincidono.");
		System.out.println("___fine testFindById : PASSED");
	}

	private static void testFindByExample(TelevisoreService televisoreService) throws Exception {
		System.out.println("\n___inizio testFindByExample...");
		if (televisoreService.listAll().isEmpty())
			throw new RuntimeException("testFindByExample : FAILED, il DB e' vuoto.");
		Televisore esempio = new Televisore(null, "So", "KD", 30,
				new SimpleDateFormat("dd-MM-yyyy").parse("01-01-2018"));
		List<Televisore> result = televisoreService.findByExample(esempio);
		if (result.isEmpty())
			throw new RuntimeException("testFindByExample : FAILED, la ricerca non ha dato i risultati attesi");
		System.out.println("___fine testFindByExample : PASSED");
	}

	private static void testAggiorna(TelevisoreService televisoreService) throws Exception {
		System.out.println("\n___inizio testAggiorna...");
		if (televisoreService.listAll().isEmpty())
			throw new RuntimeException("testAggiorna : FAILED, il DB e' vuoto.");
		Long idDaAggiornare = televisoreService.listAll().get(0).getId();
		Televisore daAggiornare = new Televisore(idDaAggiornare, "Phillips", "BNXIWKRE", 40,
				DateConverter.fromUtilToSql( new SimpleDateFormat("dd-MM-yyyy").parse("05-03-2020")));
		int result = televisoreService.aggiorna(daAggiornare);
		if (result < 1)
			throw new RuntimeException("testAggiorna : FAILED, non e' stato modificato alcun record.");
		System.out.println("___fine testAggiorna : PASSED");
	}
	
	private static void testAllTelevisoriProdottiTraDate(TelevisoreService televisoreService)throws Exception{
		System.out.println("\n___inizio testAllTelevisoriProdottiTraDate...");
		if (televisoreService.listAll().isEmpty())
			throw new RuntimeException("testAllTelevisoriProdottiTraDate : FAILED, il DB e' vuoto.");
		List<Televisore> result = televisoreService.allTelevisoriProdottiTraDate(new SimpleDateFormat("dd-MM-yyyy").parse("01-01-2020"), new SimpleDateFormat("dd-MM-yyyy").parse("01-01-2021"));
		if (result.isEmpty())
			throw new RuntimeException("testAllTelevisoriProdottiTraDate : FAILED, la ricerca non ha prodotto i risultati desiderati.");
		System.out.println("___fine testAllTelevisoriProdottiTraDate : PASSED");
	}
	
	private static void testFindTelevisorePiuGrande(TelevisoreService televisoreService)throws Exception{
		System.out.println("\n___inizio testFindTelevisorePiuGrande...");
		if (televisoreService.listAll().isEmpty())
			throw new RuntimeException("testFindTelevisorePiuGrande : FAILED, il DB e' vuoto.");
		Televisore result = televisoreService.findTelevisorePiuGrande();
		if (!result.getId().equals(televisoreService.listAll().get(0).getId()))
			throw new RuntimeException("testFindTelevisorePiuGrande : FAILED, la ricerca non ha prodotto i risultati desiderati.");
		System.out.println("___fine testFindTelevisorePiuGrande : PASSED");
	}
	
	private static void testListaMarcheTelevisoriProdottiUltimiSeiMesi(TelevisoreService televisoreService)throws Exception{
		System.out.println("\n___inizio testListaMarcheTelevisoriProdottiUltimiSeiMesi...");
		Date negliUltimiSeiMesi = new SimpleDateFormat("dd-MM-yyyy").parse("01-09-2022");
		Televisore prodottoNegliUltimiSeiMesi = new Televisore(null, "Sony", "KD43X72K", 43,
				negliUltimiSeiMesi);
		if (televisoreService.inserisciNuovo(prodottoNegliUltimiSeiMesi) < 1)
			throw new RuntimeException("testListaMarcheTelevisoriProdottiUltimiSeiMesi : FAILED, inserimento preliminare non avvenuto.");
		List<String> result = televisoreService.listMarcheTelevisoriProdottiUltimiSeiMesi();
		if (result.isEmpty())
			throw new RuntimeException("testListaMarcheTelevisoriProdottiUltimiSeiMesi : FAILED, la ricerca non ha prodotto i risultati desiderati.");
		televisoreService.rimuovi(televisoreService.listAll().get(0));
		System.out.println("___fine testListaMarcheTelevisoriProdottiUltimiSeiMesi : PASSED");
	}

	private static void testRimuovi(TelevisoreService televisoreService) throws Exception {
		System.out.println("\n___inizio testRimuovi...");
		if (televisoreService.listAll().isEmpty())
			throw new RuntimeException("testRimuovi : FAILED, il DB e' gia' vuoto.");
		Televisore daEliminare = televisoreService.listAll().get(0);
		int result = televisoreService.rimuovi(daEliminare);
		if (result < 1)
			throw new RuntimeException("testRimuovi : FAILED, elemento non cancellato.");
		System.out.println("___fine testRimuovi : PASSED");
	}
	
}
