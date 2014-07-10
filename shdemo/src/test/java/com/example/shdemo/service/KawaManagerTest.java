package com.example.shdemo.service;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.example.shdemo.domain.Kawa;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/beans.xml" })
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = true)
@Transactional
public class KawaManagerTest {

	@Autowired
	KawaManager kawagManager;

	private final String NAZWA_1 = "Nescafee";
	private final String TYP_1 = "rozpuszczalna";

	private final String NAZWA_2 = "Woseba";
	private final String TYP_2 = "Sypana";

	private final String NAZWA_3 = "Saga";
	private final String TYP_3 = "inna";
	
	private final String NAZWA_4 = "Rodzinna";
	private final String TYP_4 = "inna";

	@Before
	public void start() {

		Kawa kawa = new Kawa();
		kawa.setNazwa(NAZWA_1);
		kawa.setRodzaj(TYP_1);

		Kawa kawa2 = new Kawa();
		kawa2.setNazwa(NAZWA_2);
		kawa2.setRodzaj(TYP_2);
		
		Kawa kawa3 = new Kawa();
		kawa3.setNazwa(NAZWA_4);
		kawa3.setRodzaj(TYP_4);

		int kawaId = kawagManager.addNewKawa(kawa);
		int kawaId2 = kawagManager.addNewKawa(kawa2);
		int kawaId3 = kawagManager.addNewKawa(kawa3);
	}

	@Test
	// create
	public void addKawaCheck() {

		Kawa kawa3 = new Kawa();
		kawa3.setNazwa(NAZWA_3);
		kawa3.setRodzaj(TYP_3);

		int kawaId3 = kawagManager.addNewKawa(kawa3);

		Kawa retrievedKawa = kawagManager.findKawaById(kawaId3);
		assertEquals(NAZWA_3, retrievedKawa.getNazwa());
		assertEquals(TYP_3, retrievedKawa.getRodzaj());
		System.out.println("1");
	}

	@Test
	// read All
	public void readAllKawa() {
		List<Kawa> allKawa = kawagManager.getAllKawa();

		assert(allKawa.size() > 0);
		System.out.println("2");
	}

	@Test
	// read by id
	public void readKawaById() {
		Kawa kawa = new Kawa();
		kawa.setNazwa(NAZWA_2);
		kawa.setRodzaj(TYP_2);
		
		int id = kawagManager.addNewKawa(kawa);

		Kawa retrievedKawa = kawagManager.findKawaById(id);
		assertEquals(NAZWA_2, retrievedKawa.getNazwa());
		assertEquals(TYP_2, retrievedKawa.getRodzaj());
		System.out.println("3");
	}

	@Test
	// delete
	public void deleteKawa() {
		Kawa kawa = new Kawa();
		kawa.setNazwa("do usuniecia");
		kawa.setRodzaj("du usuniecia");
		
		int ilosc = kawagManager.getAllKawa().size();
		
		int id = kawagManager.addNewKawa(kawa);
		int ilosc2 = kawagManager.getAllKawa().size();
		
		Kawa retrievedKawa = kawagManager.findKawaById(id);
		kawagManager.deleteKawa(retrievedKawa);
		int ilosc3 = kawagManager.getAllKawa().size();
		
		assertEquals(ilosc, ilosc3);
		assertEquals(ilosc + 1, ilosc2);
		assertEquals(null, kawagManager.findKawaById(id));
		System.out.println("4");
	}
	
	@Test
	// update
	public void updateKawa() {
		Kawa kawa = new Kawa();
		kawa.setNazwa("do update");
		kawa.setRodzaj("du update");
		
		int id = kawagManager.addNewKawa(kawa);
		Kawa retrievedKawa = kawagManager.findKawaById(id);
		retrievedKawa.setNazwa(NAZWA_2);
		retrievedKawa.setRodzaj(TYP_2);
		kawagManager.updateKawa(retrievedKawa);
		retrievedKawa = kawagManager.findKawaById(id);

		assertEquals(NAZWA_2, retrievedKawa.getNazwa());
		assertEquals(TYP_2, retrievedKawa.getRodzaj());
		System.out.println("5");
	}
}