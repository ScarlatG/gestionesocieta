package it.prova.gestionesocieta.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.prova.gestionesocieta.model.Societa;

@Service
public class BatteriaDiTestService {

	@Autowired
	private SocietaService societaService;
	@Autowired
	private DipendenteService dipendenteService;

	public void testInserisciSocieta() {
		Date dataFondazione = new Date();
		try {
			dataFondazione = new SimpleDateFormat("yyyy-MM-dd").parse("1985-03-22");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		societaService.inserisciNuova(new Societa("Scarlat Costruzioni", "via Aldo 10", dataFondazione));

		if (societaService.listAllSocieta().isEmpty())
			throw new RuntimeException("testInserisciSocieta.....failed, inserimento non avvenuto.");
		System.out.println("testInserisciSocieta.....OK");
	}

	public void testFindByExampleSocieta() {
		Date dataFondazione = new Date();
		try {
			dataFondazione = new SimpleDateFormat("yyyy-MM-dd").parse("1980-01-01");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<Societa> result;
		result = societaService.findByExample(new Societa("rlat", null, dataFondazione));
		if (result.isEmpty())
			throw new RuntimeException(
					"testFindByExampleSocieta.....failed, la ricerca non ha prodotto i risultati attesi");
		System.out.println("testFindByExampleSocieta.....OK");
	}
}
