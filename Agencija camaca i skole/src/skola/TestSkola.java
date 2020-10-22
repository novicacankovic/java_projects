package skola;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class TestSkola {

	public static Scanner scanner = new Scanner(System.in);
	public static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy.");

	public static boolean isIDValid(String id) {

		try {
			if (id.equals("")) {
				return false;
			}

			boolean containsDigitsOnly = true;
			for (int i = 0; i < id.length(); i++) {
				if (!Character.isDigit(id.charAt(i))) {
					containsDigitsOnly = false;

				}
			}

			return id.length() == 13 && containsDigitsOnly;

		} catch (Exception e) {
			return false;
		}
	}

	public static boolean proveraIspravnostiKaraktera(String odeljenje) {
		try {

			if (odeljenje.length() == 2) {
				return true;
			}

			return false;

		} catch (Exception e) {
			return false;
		}
	}

	public static boolean proveriVrednostBroja(String razredS) {

		try {

			int brojrazreda = Integer.parseInt(razredS);
			if (brojrazreda >= 1 && brojrazreda <= 8) {
				return true;
			}

			return false;
		} catch (Exception e) {
			return false;
		}

	}

	public static boolean isDecimalNumber(String ukupnaCenaRacunaS) {
		try {
			double iznos = Double.parseDouble(ukupnaCenaRacunaS);
			if (iznos > 0) {
				return true;
			}
			return false;
		} catch (Exception e) {
			return false;
		}

	}

	public static boolean proveriDatum(LocalDate sadasnnjiDatum, String datumUnos) {

		sadasnnjiDatum = LocalDate.now();

		try {
			LocalDate datum = LocalDate.parse(datumUnos, dtf);
			if (sadasnnjiDatum.compareTo(datum) >= 0) {
				return true;

			} else {
				return false;
			}
		} catch (Exception e) {
			return false;
		}

	}

	public static void unosSkole(Skola mojaSkola) {

		String nazivSkole;
		String adresaSkole;

		System.out.println("Unesite naziv skole: ");
		nazivSkole = scanner.nextLine();
		mojaSkola.setNazivSkole(nazivSkole);

		System.out.println("Unesite adresu skole: ");
		adresaSkole = scanner.nextLine();
		mojaSkola.setAdresaSkole(adresaSkole);

		System.out.println("Agencija je uspesno dodata. ");
	}

	public static void unosUcenika(Skola mojaSkola) {
		String id = null;

		String ime = null;

		String prezime = null;

		String odeljenje = null;

		int razred = 0;
		String razredS = null;

		double prosek = 0.00;
		String prosekS = null;

		String imeRoditelja = null;

		String prezimeRoditelja = null;

		LocalDate datumRodjenja = null;
		String datumUnos = null;
		LocalDate sadasnnjiDatum = LocalDate.now();

		do {
			System.out.println("Unesite JMBG ucenika: ");
			id = scanner.nextLine();
		} while (!isIDValid(id));

		System.out.println("Unesite ime ucenika: ");
		ime = scanner.nextLine();

		System.out.println("Unesite prezime ucenika: ");
		prezime = scanner.nextLine();

		do {
			System.out.println("Unesite odeljenje ucenika: ");
			odeljenje = scanner.nextLine();
		} while (!proveraIspravnostiKaraktera(odeljenje));

		do {
			System.out.println("Unesite razred ucenika: ");
			razredS = scanner.nextLine();
		} while (!proveriVrednostBroja(razredS));
		razred = Integer.parseInt(razredS);

		do {
			System.out.println("Unesite prosek ucenika: ");
			prosekS = scanner.nextLine();
		} while (!isDecimalNumber(prosekS));
		prosek = Double.parseDouble(prosekS);

		System.out.println("Unesite ime roditelja ucenika: ");
		imeRoditelja = scanner.nextLine();

		System.out.println("Unesite prezime roditelja ucenika: ");
		prezimeRoditelja = scanner.nextLine();

		do {
			System.out.print("Datum datum rodjenja: ");
			datumUnos = scanner.nextLine();
		} while (!proveriDatum(sadasnnjiDatum, datumUnos));
		try {
			datumRodjenja = LocalDate.parse(datumUnos, dtf);
		} catch (Exception e) {
			e.printStackTrace();
		}

		Ucenik mojUcenik = new Ucenik(id, ime, prezime, odeljenje, razred, prosek, imeRoditelja, prezimeRoditelja,
				datumRodjenja);
		mojaSkola.dodajUcenika(mojUcenik);

	}

	public static void ispisUcenika(Skola mojaSkola) {

		mojaSkola.ispispodataka();

	}

	public static void izmeniUcenika(Skola mojaSkola) {

		String id = null;

		String ime = null;

		String prezime = null;

		String odeljenje = null;

		int razred = 0;
		String razredS = null;

		double prosek = 0.00;
		String prosekS = null;

		String imeRoditelja = null;

		String prezimeRoditelja = null;

		LocalDate datumRodjenja = null;
		String datumUnos = null;
		LocalDate sadasnnjiDatum = LocalDate.now();

		do {
			System.out.println("Unesite JMBG ucenika: ");
			id = scanner.nextLine();
		} while (!isIDValid(id));

		System.out.println("Unesite ime ucenika: ");
		ime = scanner.nextLine();

		System.out.println("Unesite prezime ucenika: ");
		prezime = scanner.nextLine();

		do {
			System.out.println("Unesite odeljenje ucenika: ");
			odeljenje = scanner.nextLine();
		} while (!proveraIspravnostiKaraktera(odeljenje));

		do {
			System.out.println("Unesite razred ucenika: ");
			razredS = scanner.nextLine();
		} while (!proveriVrednostBroja(razredS));
		razred = Integer.parseInt(razredS);

		do {
			System.out.println("Unesite prosek ucenika: ");
			prosekS = scanner.nextLine();
		} while (!isDecimalNumber(prosekS));
		prosek = Double.parseDouble(prosekS);

		System.out.println("Unesite ime roditelja ucenika: ");
		imeRoditelja = scanner.nextLine();

		System.out.println("Unesite prezime roditelja ucenika: ");
		prezimeRoditelja = scanner.nextLine();

		do {
			System.out.print("Datum datum rodjenja: ");
			datumUnos = scanner.nextLine();
		} while (!proveriDatum(sadasnnjiDatum, datumUnos));
		try {
			datumRodjenja = LocalDate.parse(datumUnos, dtf);
		} catch (Exception e) {
			e.printStackTrace();
		}

		Ucenik mojUcenik = new Ucenik(id, ime, prezime, odeljenje, razred, prosek, imeRoditelja, prezimeRoditelja,
				datumRodjenja);
		mojaSkola.izmeniUcenika(mojUcenik);

	}

	public static void obrisiUcenika(Skola mojaSkola) {

		String id = null;
		do {
			System.out.println("Unesite JMBG ucenika: ");
			id = scanner.nextLine();
		} while (!isIDValid(id));
		mojaSkola.obrisiUcenika(id);

	}

	public static void pretragaUcenikapremaOdeljenju(Skola mojaSkola) {

		String odeljenje = null;
		do {
			System.out.println("Unesite odeljenje ucenika: ");
			odeljenje = scanner.nextLine();
		} while (!proveraIspravnostiKaraktera(odeljenje));

		mojaSkola.pretragaUcenikapremaOdeljenju(odeljenje);

	}

	public static void pretragaUcenikaPremaProseku(Skola mojaSkola) {

		double prosek = 0.00;
		String prosekS = null;

		do {
			System.out.println("Unesite prosek ucenika: ");
			prosekS = scanner.nextLine();
		} while (!isDecimalNumber(prosekS));
		prosek = Double.parseDouble(prosekS);
		mojaSkola.pretragaUcenikaPremaProseku(prosek);

	}

	public static void pretragaPremaProseku(Skola mojaSkola) {

		int razred = 0;
		String razredS = null;

		do {
			System.out.println("Unesite razred ucenika: ");
			razredS = scanner.nextLine();
		} while (!proveriVrednostBroja(razredS));
		razred = Integer.parseInt(razredS);
		mojaSkola.pretragaPremaProseku(razred);

	}

	public static void pronalazenjeUcenikasaNajcevomProsekom(Skola mojaSkola) {
		int razred = 0;
		String razredS = null;

		do {
			System.out.println("Unesite razred ucenika: ");
			razredS = scanner.nextLine();
		} while (!proveriVrednostBroja(razredS));
		razred = Integer.parseInt(razredS);

		mojaSkola.pronalazenjeUcenikasaNajcevomProsekom(razred);

	}

	public static void IspisPodatakaoSkoli(Skola mojaSkola) {

		System.out.println(mojaSkola);

	}

	public static void main(String[] args) {

		Skola mojaSkola = new Skola();
		mojaSkola.ucitaj("listaUcenika.txt");

		String odgovor = null;

		do {

			System.out.println("Meni:");
			System.out.println("1. Unos podataka o novoj skoli");
			System.out.println("2. Unos novog ucenika");
			System.out.println("3. Ispis podataka o svim ucenicima u evidenciji");
			System.out.println("4. Izmena podataka o uceniku");
			System.out.println("5. Brisanje podataka o uceniku");
			System.out.println("6. Pretraga svih ucenika prema odeljenju");
			System.out.println("7. Pretraga svih ucenika prema proseku");
			System.out.println("8. Izracunavanje prosecnog proseka ucenika");
			System.out.println("9. Pronalazenje ucenika sa najvecim prosekom");
			System.out.println("10. Ispis podataka o skoli");
			System.out.println("x. Izlaz");

			odgovor = scanner.nextLine();

			switch (odgovor) {

			case "1":
				unosSkole(mojaSkola);
				mojaSkola.sacuvaj("listaUcenika.txt");
				break;
			case "2":
				unosUcenika(mojaSkola);
				mojaSkola.sacuvaj("listaUcenika.txt");
				break;
			case "3":
				ispisUcenika(mojaSkola);
				break;
			case "4":
				izmeniUcenika(mojaSkola);
				mojaSkola.sacuvaj("listaUcenika.txt");
				break;
			case "5":
				obrisiUcenika(mojaSkola);
				mojaSkola.sacuvaj("listaUcenika.txt");
				break;
			case "6":
				pretragaUcenikapremaOdeljenju(mojaSkola);
				break;
			case "7":
				pretragaUcenikaPremaProseku(mojaSkola);
				break;
			case "8":
				pretragaPremaProseku(mojaSkola);
				break;
			case "9":
				pronalazenjeUcenikasaNajcevomProsekom(mojaSkola);
				break;
			case "10":
				IspisPodatakaoSkoli(mojaSkola);
				break;

			case "x":
				break;
			default:
				System.out.println("Pogresan izbor opcije. Pokusajte ponovo.");
			}

		} while (!odgovor.equals("x"));

		mojaSkola.sacuvaj("listaUcenika.txt");
		scanner.close();

	}

}
