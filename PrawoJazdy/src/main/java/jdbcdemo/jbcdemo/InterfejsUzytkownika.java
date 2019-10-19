package jdbcdemo.jbcdemo;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import jdbcdemo.system.PrawoJazdySystem;
import jdbcdemo.domain.Egzamin;
import jdbcdemo.domain.Kursant;

public class InterfejsUzytkownika {

	private static final int REJESTRUJ_NOWY_EGZAMIN = 0;
	private static final int ZMIEN_STATUSY_EGZAMINOW = 1;
	private static final int POKAZ_KURSANTOW = 2;
	private static final int DODAJ_KURSANTA = 3;
	private static final int KONIEC = -1;

	int aktualnePolecenie;
	String data;

	static PrawoJazdySystem system = new PrawoJazdySystem();

	Scanner sc = new Scanner(System.in);

	
	public void wyświetlajInterfejs() {
		System.out.println("<< Witaj w bazie danych egzaminów prawa jazdy Szkoły Jazdy Autko >>\n");

		while (true) {

			wybórPolecenia();
			aktualnePolecenie = sc.nextInt();
			działanieAplikacji();
			if (aktualnePolecenie == KONIEC) {
				break;
			}
		}
	}

	private void wybórPolecenia() {
		System.out.println("ZAREJESTRUJ NOWY EGZAMIN " + REJESTRUJ_NOWY_EGZAMIN);
		System.out.println("ZMIEŃ STATUSY EGZAMINÓW " + ZMIEN_STATUSY_EGZAMINOW);
//		System.out.println("POKAŻ KURSANTÓW " + POKAZ_KURSANTOW);
//		System.out.println("DODAJ KURSANTÓW " + DODAJ_KURSANTA);
		System.out.println("KONIEC " + KONIEC);

	}

	private void działanieAplikacji() {
		if (aktualnePolecenie == REJESTRUJ_NOWY_EGZAMIN) {
			// tworzenie nowego obiektu
			Egzamin egzamin = new Egzamin();

			Date data2 = null;
			// wypełnianie pól nowego obiektu
			while (data2 == null) {

				System.out.println("Podaj datę w formacie dd-MM-yyyy");
				data = sc.next();
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
				try {
					// Parsing the String
					data2 = dateFormat.parse(data);
				} catch (ParseException e) {

					// e.printStackTrace();
					System.out.println("Podano zły format daty. Proszę spóbować ponownie. ");
				}

			}
			egzamin.setDataGodzina(data2);
			
			try {
				system.addEgzamin(egzamin);
				System.out.println("Zapisano egzamin.");
			} catch (Exception e) {
				System.out.println("Błąd zapisu egzaminu");
				e.printStackTrace();
			}

		} else if (aktualnePolecenie == ZMIEN_STATUSY_EGZAMINOW) {
			try {
				// 1. pobranie z bazy listy egzaminów
				List<Egzamin> spisEgzaminow = system.getAllEgzamin();
				String wynik;
				Boolean nowyStatus = null;
				List<Long> idEgzaminow = new ArrayList<Long>();

				// 2.wyświetlenie listy egzaminów z bazy
				System.out.println(spisEgzaminow);
				// 3.zmiana statusu egzaminu - określenie co i gdzie:

				// a) wskazanie elementow do zmiany poprzez podanie id egzaminu
				System.out.println("Podaj id egzaminów. które chcesz zmienić:");
				String inputId;
				inputId = sc.next();
				String[] tablicaIdEgzaminow = inputId.split("[^0-9]+");
				for (String s : tablicaIdEgzaminow) {
					idEgzaminow.add(Long.parseLong(s));
				}
				Map<Long, Egzamin> mapaEgzaminow = new HashMap<Long, Egzamin>();
				for (Egzamin e : spisEgzaminow) {
					mapaEgzaminow.put(e.getId(), e);
				}

				List<Egzamin> egzaminyDoZmiany = new ArrayList<Egzamin>();
				for (Long id : idEgzaminow) {
					egzaminyDoZmiany.add(mapaEgzaminow.get(id));

				}

				// b) określenie nowego statusu - true/false
				while (nowyStatus == null) {
					System.out.println("Podaj nowy status egzaminu");
					System.out.println("Z-zdany, N-niezdany");
					wynik = sc.next();

					if ("Z".equalsIgnoreCase(wynik)) {
						nowyStatus = true;

					} else if ("N".equalsIgnoreCase(wynik)) {
						nowyStatus = false;
					} else {
						System.out.println("Podano złą literę: ");

					}

				}
				// c) zmiana kolekcji spisEgzaminow
				for (Egzamin e : egzaminyDoZmiany) {
					e.setZdany(nowyStatus);
				}
				// 4. zgłoszenie do zmiany

				
				for (Egzamin e : egzaminyDoZmiany) {
					system.updateEgzamin(e); // oflagowuje e jako zmieniony w
												// UOW
				}
				// 5.zapis do bazy całego UOW
				
				system.zapiszUOW(); // commituje wszystkie zmiany w UOW za
									// pomocą 1 transakcji

			} catch (SQLException e) {
				System.out.println("Nie udało się pobrać spisu egzaminów.");
				e.printStackTrace();
			}

		} 
		else if (aktualnePolecenie == POKAZ_KURSANTOW) {
			try {
				List<Kursant> spisKursantow = system.getAllKursantWithForeginEntities();
				System.out.println(spisKursantow);
			} catch (SQLException e) {
				System.out.println("Nie udało się pobrać spisu kursantów.");
				e.printStackTrace();
			}
		} 
		
		else if (aktualnePolecenie == DODAJ_KURSANTA) {
			
			Kursant kursant= new Kursant();

			String nazwisko = null;
			String imie = null;
			
			while (nazwisko == null) {

				System.out.println("Podaj nazwisko kursanta");
				nazwisko = sc.next();
				System.out.println("Podaj imię kursanta");
				imie = sc.next();
				

			}
			kursant.setNazwisko(nazwisko);
			kursant.setImie(imie);
			// zgłoszenie nowego obiektu do zapisu TODO
			try {
				system.addKursant(kursant);
				System.out.println("Zapisano kursanta.");
			} catch (Exception e) {
				System.out.println("Błąd zapisu kursanta");
				e.printStackTrace();}}
			else {
			System.out.println("Koniec");
		}

	}

}
