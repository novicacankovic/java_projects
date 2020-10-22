package Camci;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;



public class TestAgencijaCamaca {

	public static Scanner scanner = new Scanner(System.in);
	public static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy.");

	public static boolean proveraZaBroj(String idS) {

		try {

			int brojId = Integer.parseInt(idS);
			if (brojId < 1) {
				return false;
			}

			return true;
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

	public static boolean proveriDatum(String datumUnos) {

		try {
			LocalDate.parse(datumUnos, dtf);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public static boolean daLiJeVeciDatum(LocalDate datumPocetaRen, String datumUnosaKraj) {

		LocalDate datumKrajRen = null;
		try {
			datumKrajRen = LocalDate.parse(datumUnosaKraj, dtf);
			if (datumKrajRen.compareTo(datumPocetaRen) >= 0) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
	}

	public static void unosPodatakaAgencije(Agencija mojaAgencija) {

		String naziv;
		String adresa;
		String telefon;

		System.out.println("Unesite naziv agencije: ");
		naziv = scanner.nextLine();
		mojaAgencija.setNaziv(naziv);

		System.out.println("Unesite adresu agencije: ");
		adresa = scanner.nextLine();
		mojaAgencija.setAdresa(adresa);

		System.out.println("Unesite telefon agencije: ");
		telefon = scanner.nextLine();
		mojaAgencija.setTelefon(telefon);

		System.out.println("Agencija je uspesno dodata. ");

	}

	public static void unosNovogCamca(Agencija mojaAgencija) {
		int id = 0;
		String idS = null;

		int nosivost = 0;
		String nosivostS = null;

		double potrosnja = 0.00;
		String potrosnjaS = null;

		double cena = 0.00;
		String cenaS = null;

		LocalDate datumPocetaRen = null;
		String datumUnosaPoc = null;

		LocalDate datumKrajRen = null;
		String datumUnosaKraj = null;

		do {
			System.out.print("Unesite identifikacioni broj: ");
			idS = scanner.nextLine();
		} while (!proveraZaBroj(idS));
		id = Integer.parseInt(idS);

		do {
			System.out.print("Unesite nosivost camca: ");
			nosivostS = scanner.nextLine();
		} while (!proveraZaBroj(nosivostS));
		nosivost = Integer.parseInt(nosivostS);

		do {
			System.out.print("Unesite potrosnju camca: ");
			potrosnjaS = scanner.nextLine();
		} while (!isDecimalNumber(potrosnjaS));
		potrosnja = Double.parseDouble(potrosnjaS);

		do {
			System.out.print("Unesite cenu camca: ");
			cenaS = scanner.nextLine();
		} while (!isDecimalNumber(cenaS));
		cena = Double.parseDouble(cenaS);

		do {
			System.out.print("Datum pocetka rentiranja: ");
			datumUnosaPoc = scanner.nextLine();
		} while (!proveriDatum(datumUnosaPoc));
		try {
			datumPocetaRen = LocalDate.parse(datumUnosaPoc, dtf);
		} catch (Exception e) {
			e.printStackTrace();
		}

		do {
			System.out.print("Datum kraja rentiranja: ");
			datumUnosaKraj = scanner.nextLine();
		} while (!daLiJeVeciDatum(datumPocetaRen, datumUnosaKraj));
		try {
			datumKrajRen = LocalDate.parse(datumUnosaKraj, dtf);
		} catch (Exception e) {
			e.printStackTrace();
		}

		Camac mojCamac = new Camac(id, nosivost, potrosnja, cena, datumPocetaRen, datumKrajRen);
		mojaAgencija.dodajCamac(mojCamac);

	}

	public static void izmenaPodataka(Agencija mojaAgencija) {
		int id = 0;
		String idS = null;

		int nosivost = 0;
		String nosivostS = null;

		double potrosnja = 0.00;
		String potrosnjaS = null;

		double cena = 0.00;
		String cenaS = null;

		LocalDate datumPocetaRen = null;
		String datumUnosaPoc = null;

		LocalDate datumKrajRen = null;
		String datumUnosaKraj = null;

		do {
			System.out.print("Unesite identifikacioni broj: ");
			idS = scanner.nextLine();
		} while (!proveraZaBroj(idS));
		id = Integer.parseInt(idS);

		do {
			System.out.print("Unesite nosivost camca: ");
			nosivostS = scanner.nextLine();
		} while (!proveraZaBroj(nosivostS));
		nosivost = Integer.parseInt(nosivostS);

		do {
			System.out.print("Unesite potrosnju camca: ");
			potrosnjaS = scanner.nextLine();
		} while (!isDecimalNumber(potrosnjaS));
		potrosnja = Double.parseDouble(potrosnjaS);

		do {
			System.out.print("Unesite cenu camca: ");
			cenaS = scanner.nextLine();
		} while (!isDecimalNumber(cenaS));
		cena = Double.parseDouble(cenaS);

		do {
			System.out.print("Datum pocetka rentiranja: ");
			datumUnosaPoc = scanner.nextLine();
		} while (!proveriDatum(datumUnosaPoc));
		try {
			datumPocetaRen = LocalDate.parse(datumUnosaPoc, dtf);
		} catch (Exception e) {
			e.printStackTrace();
		}

		do {
			System.out.print("Datum kraja rentiranja: ");
			datumUnosaKraj = scanner.nextLine();
		} while (!daLiJeVeciDatum(datumPocetaRen, datumUnosaKraj));
		try {
			datumKrajRen = LocalDate.parse(datumUnosaKraj, dtf);
		} catch (Exception e) {
			e.printStackTrace();
		}

		Camac mojCamac = new Camac(id, nosivost, potrosnja, cena, datumPocetaRen, datumKrajRen);
		mojaAgencija.izmeniCamac(mojCamac);

	}

	public static void ispispodataka(Agencija mojaAgencija) {

		mojaAgencija.ispispodataka();

	}

	public static void obrisiCamac(Agencija mojaAgencija) {

		int id = 0;
		String idS = null;
		do {
			System.out.print("Unesite identifikacioni broj: ");
			idS = scanner.nextLine();
		} while (!proveraZaBroj(idS));
		id = Integer.parseInt(idS);

		mojaAgencija.obrisiCamac(id);

	}

	public static void pretragaPoNosivosti(Agencija mojaAgencija) {

		int nosivost = 0;
		String nosivostS = null;

		do {
			System.out.print("Unesite nosivost camca: ");
			nosivostS = scanner.nextLine();
		} while (!proveraZaBroj(nosivostS));
		nosivost = Integer.parseInt(nosivostS);

		mojaAgencija.pretragaPoNosivosti(nosivost);

	}

	public static void pretragaPremaPotrosnji(Agencija mojaAgencija) {

		double potrosnja = 0.00;
		String potrosnjaS = null;
		double cenaMin = 0.00;
		String cenaMinS = null;
		double cenaMax = 0.00;
		String cenaMaxS = null;

		do {
			System.out.print("Unesite potrosnju camca: ");
			potrosnjaS = scanner.nextLine();
		} while (!isDecimalNumber(potrosnjaS));
		potrosnja = Double.parseDouble(potrosnjaS);

		do {
			System.out.print("Unesite minimalnu cenu camca: ");
			cenaMinS = scanner.nextLine();
		} while (!isDecimalNumber(cenaMinS));
		cenaMin = Double.parseDouble(cenaMinS);

		do {
			System.out.print("Unesite maksimalnu cenu camca: ");
			cenaMaxS = scanner.nextLine();
		} while (!isDecimalNumber(cenaMaxS));
		cenaMax = Double.parseDouble(cenaMaxS);

		mojaAgencija.pretragaPremaPotrosnji(potrosnja, cenaMin, cenaMax);

	}

	public static void pretragaiProsek(Agencija mojaAgencija) {
		int nosivost = 0;
		String nosivostS = null;
		do {
			System.out.print("Unesite nosivost camca: ");
			nosivostS = scanner.nextLine();
		} while (!proveraZaBroj(nosivostS));
		nosivost = Integer.parseInt(nosivostS);
		mojaAgencija.pretragaiProsek(nosivost);

	}

	public static void ispisPodatakaOAgenciji(Agencija mojaAgencija) {
		System.out.println(mojaAgencija);

	}

	public static void pretraga9(Agencija mojaAgencija) {

		LocalDate datumMin = null;
		String datumMinS = null;
		LocalDate datumMax = null;
		String datumMaxS = null;
		do {
			System.out.print("Unesite minimalni datum za pretragu: ");
			datumMinS = scanner.nextLine();
		} while (!proveriDatum(datumMinS));
		datumMin = LocalDate.parse(datumMinS, dtf);
		do {
			System.out.print("Unesite maksimalni datum za pretragu: ");
			datumMaxS = scanner.nextLine();
		} while (!daLiJeVeciDatum(datumMin, datumMaxS));
		datumMax = LocalDate.parse(datumMaxS, dtf);

		mojaAgencija.pretraga9(datumMin, datumMax);

	}

	public static void main(String[] args) {

		Agencija mojaAgencija = new Agencija();
		mojaAgencija.ucitaj("listaCamaca.txt");

		String odgovor = null;

		do {

			System.out.println("Meni:");
			System.out.println("1. Unos podataka o novoj agenciji");
			System.out.println("2. Unos novog camca");
			System.out.println("3. Ispis podataka o camcima u ponudi");
			System.out.println("4. Izmena podataka o camcima");
			System.out.println("5. Brisanje podataka o camcu");
			System.out.println("6. Pretraga svih camaca prema nosivosti");
			System.out.println("7. Pretraga svih camaca prema potrosnji");
			System.out.println("8. Izracunavanje prosecne cene camaca u zavisnosti od nosivosti");
			System.out.println("9. Pronalazenje najpovoljnijeg camca");
			System.out.println("10. Ispis podataka o turistickoj agenciji");
			System.out.println("x. Izlaz");

			odgovor = scanner.nextLine();

			switch (odgovor) {
			case "1":
				unosPodatakaAgencije(mojaAgencija);
				mojaAgencija.sacuvaj("listaCamaca.txt");

				break;
			case "2":
				unosNovogCamca(mojaAgencija);
				mojaAgencija.sacuvaj("listaCamaca.txt");
				break;
			case "3":
				ispispodataka(mojaAgencija);
				break;
			case "4":
				izmenaPodataka(mojaAgencija);
				mojaAgencija.sacuvaj("listaCamaca.txt");
				break;
			case "5":
				obrisiCamac(mojaAgencija);
				mojaAgencija.sacuvaj("listaCamaca.txt");
				break;
			case "6":
				pretragaPoNosivosti(mojaAgencija);
				break;
			case "7":
				pretragaPremaPotrosnji(mojaAgencija);
				break;
			case "8":
				pretragaiProsek(mojaAgencija);
				break;
			case "9":
				pretraga9(mojaAgencija);
				break;
			case "10":
				ispisPodatakaOAgenciji(mojaAgencija);
				break;

			case "x":
				break;
			default:
				System.out.println("Pogresan izbor opcije. Pokusajte ponovo.");
			}

		} while (!odgovor.equals("x"));

		mojaAgencija.sacuvaj("listaCamaca.txt");
		scanner.close();

	}

}
