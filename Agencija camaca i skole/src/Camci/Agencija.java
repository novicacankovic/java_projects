package Camci;

import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;



public class Agencija {

	String naziv;
	String adresa;
	String telefon;
	ArrayList<Camac> listaCamaca;

	public Agencija() {
		super();
		listaCamaca = new ArrayList<>();

	}

	public Agencija(String naziv, String adresa) {
		super();
		this.naziv = naziv;
		this.adresa = adresa;
		listaCamaca = new ArrayList<>();
	}

	public Agencija(String naziv, String adresa, String telefon, ArrayList<Camac> listaCamaca) {
		super();
		this.naziv = naziv;
		this.adresa = adresa;
		this.telefon = telefon;
		this.listaCamaca = listaCamaca;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public String getTelefon() {
		return telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	public ArrayList<Camac> getListaCamaca() {
		return listaCamaca;
	}

	public void setListaCamaca(ArrayList<Camac> listaCamaca) {
		this.listaCamaca = listaCamaca;
	}

	public boolean dodajCamac(Camac mojCamac) {

		for (int i = 0; i < this.listaCamaca.size(); i++) {
			if (this.listaCamaca.get(i).getId() == mojCamac.getId()) {

				System.out.println("NIje moguce uneti camac pod navedenim ID-om");
				return false;
			}
		}

		this.listaCamaca.add(mojCamac);
		System.out.println("Camac je uspeno dodat. ");
		return true;
	}

	public void ispispodataka() {

		System.out.printf("%15s %15s %15s %15s %15s %15s\n", "id", "nosivost", "Potrosnja", "cena", "datumPocetaRen",
				"datumKrajRen");

		for (int i = 0; i < this.listaCamaca.size(); i++) {
			System.out.println(this.listaCamaca.get(i));
		}
	}

	public boolean izmeniCamac(Camac mojCamac) {

		for (int i = 0; i < this.listaCamaca.size(); i++) {
			if (this.listaCamaca.get(i).getId() == mojCamac.getId()) {

				this.listaCamaca.set(i, mojCamac);
				System.out.println("Camac je uspeno izmenjen. ");
				return true;
			}
		}

		System.out.println("Nije moguce uneti camac pod navedenim ID-om");
		return false;
	}

	public Camac obrisiCamac(int id) {

		int index = -1;
		for (int i = 0; i < this.listaCamaca.size(); i++) {
			if (this.listaCamaca.get(i).getId() == id) {
				index = i;

				System.out.println("Camac je uspesno obrisan. ");
				return this.listaCamaca.remove(index);
			}
		}

		System.out.println("Caamc ne postoji u Agenciji. ");
		return null;

	}

	public ArrayList<Camac> pretragaPoNosivosti(double nosivost) {
		System.out.printf("%15s %15s %15s %15s %15s %15s\n", "id", "nosivost", "Potrosnja", "cena", "datumPocetaRen",
				"datumKrajRen");

		ArrayList<Camac> listaRezultata = new ArrayList<>();
		for (int i = 0; i < this.listaCamaca.size(); i++) {
			if (this.listaCamaca.get(i).getNosivost() > nosivost) {

				listaRezultata.add(this.listaCamaca.get(i));
				System.out.println(this.listaCamaca.get(i));

			}
		}

		return listaRezultata;
	}

	public ArrayList<Camac> pretragaPremaPotrosnji(double potrosnja, double cenaMin, double cenaMax) {
		System.out.printf("%15s %15s %15s %15s %15s %15s\n", "id", "nosivost", "Potrosnja", "cena", "datumPocetaRen",
				"datumKrajRen");

		ArrayList<Camac> listaRezultata = new ArrayList<>();
		for (int i = 0; i < this.listaCamaca.size(); i++) {
			if (this.listaCamaca.get(i).getPotrosnja() < potrosnja && this.listaCamaca.get(i).getCena() >= cenaMin
					&& this.listaCamaca.get(i).getCena() <= cenaMax) {

				listaRezultata.add(this.listaCamaca.get(i));
				System.out.println(this.listaCamaca.get(i));
			}
		}
		return listaRezultata;

	}

	public double pretragaiProsek(int nosivost) {

		ArrayList<Camac> listaRezultata = new ArrayList<>();

		for (int i = 0; i < this.listaCamaca.size(); i++) {
			if (this.listaCamaca.get(i).getNosivost() > nosivost) {

				listaRezultata.add(this.listaCamaca.get(i));

			}
		}

		double prosek = 0.00;
		int suma = 0;
		for (int i = 0; i < listaRezultata.size(); i++) {
			suma += listaRezultata.get(i).getCena();

			prosek = (double) suma / listaRezultata.size();
		}

		System.out.println("Prosecna cena rentiranja camca,cija je nosivost: " + nosivost + " iznosi: " + prosek);
		return prosek;

	}

	public ArrayList<Camac> pretraga9(LocalDate min, LocalDate max) {

		ArrayList<Camac> listaRezultata = new ArrayList<>();
		for (int i = 0; i < this.listaCamaca.size(); i++) {

			if (this.listaCamaca.get(i).getDatumPocetaRen().compareTo(min) >= 0
					&& this.listaCamaca.get(i).getDatumKrajRen().compareTo(max) <= 0) {
				listaRezultata.add(this.listaCamaca.get(i));
			}
		}

		Camac najmanja = pronadjiJednuNajmanjuUplatu(listaRezultata);

		if (najmanja == null) {
			System.out.println("Ne postoji informacija za zadate uslove.");
			return null;
		} else {
			ArrayList<Camac> sveNajmanjeTransakcije = pronadjiSveNajmanjeUplate(listaRezultata, najmanja);
			for (int i = 0; i < sveNajmanjeTransakcije.size(); i++) {
				System.out.println("Najpovoljniji camac " + " je: " + sveNajmanjeTransakcije.get(i));
			}
			return sveNajmanjeTransakcije;
		}
	}

	public Camac pronadjiJednuNajmanjuUplatu(ArrayList<Camac> listaUplata) {

		Camac najmanja = null;
		if (listaUplata.size() > 0) {
			najmanja = listaUplata.get(0);
			for (int i = 1; i < listaUplata.size(); i++) {
				if (najmanja.getCena() > listaUplata.get(i).getCena()) {
					najmanja = listaUplata.get(i);
				}
			}
		}
		return najmanja;
	}

	public ArrayList<Camac> pronadjiSveNajmanjeUplate(ArrayList<Camac> listaFilterUplata, Camac najmanja) {

		ArrayList<Camac> listaRezultata = new ArrayList<>();
		for (int i = 0; i < listaFilterUplata.size(); i++) {
			if (listaFilterUplata.get(i).getCena() == najmanja.getCena()) {
				listaRezultata.add(listaFilterUplata.get(i));
			}
		}
		return listaRezultata;
	}

	public void sacuvaj(String putanja) {

		ArrayList<String> linije = new ArrayList<String>();

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy.");

		linije.add(this.naziv);
		linije.add(this.adresa);
		linije.add(this.telefon);

		for (int i = 0; i < this.listaCamaca.size(); i++) {
			Camac mojCamac = this.listaCamaca.get(i);

			int id = mojCamac.getId();
			int nosivost = mojCamac.getNosivost();
			double potrosnja = mojCamac.getPotrosnja();
			double cena = mojCamac.getCena();
			String formatiraniDatumPocetak = dtf.format(mojCamac.getDatumPocetaRen());
			String formatiraniDatumKraj = dtf.format(mojCamac.getDatumKrajRen());

			String linija = id + ";" + nosivost + ";" + potrosnja + ";" + cena + ";" + formatiraniDatumPocetak + ";"
					+ formatiraniDatumKraj + ";";
			linije.add(linija);
		}

		try {
			Files.write(Paths.get(putanja), linije, Charset.defaultCharset(), StandardOpenOption.CREATE,
					StandardOpenOption.TRUNCATE_EXISTING, StandardOpenOption.WRITE);
		} catch (java.io.IOException e) {
			System.out.println("Desila se greska prilikom cuvanja podataka.");
		}
	}

	public void ucitaj(String putanja) {

		this.listaCamaca = new ArrayList<>();

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy.");
		List<String> linije;
		try {
			linije = Files.readAllLines(Paths.get(putanja), Charset.defaultCharset());

			this.naziv = linije.get(0);
			this.adresa = linije.get(1);
			this.telefon = linije.get(2);

			for (int i = 3; i < linije.size(); i++) {
				String[] attributes = linije.get(i).split(";");

				int id = Integer.parseInt(attributes[0]);
				int nosivost = Integer.parseInt(attributes[1]);
				double potrosnja = Double.parseDouble(attributes[2]);
				double cena = Double.parseDouble(attributes[3]);
				LocalDate datumPocetaRen = LocalDate.parse(attributes[4], dtf);
				LocalDate datumKrajRen = LocalDate.parse(attributes[5], dtf);

				Camac mojCamac = new Camac(id, nosivost, potrosnja, cena, datumPocetaRen, datumKrajRen);
				this.listaCamaca.add(mojCamac);

			}
		} catch (java.io.IOException e) {
			System.out.println("Desila se greska prilikom citanja fajla.");
		} catch (NumberFormatException e) {
			System.out.println("Desila se greska prilikom konverzije brojeva.");
		} catch (DateTimeParseException e) {
			System.out.println("Desila se greska prilikom konverzije datuma.");
		} catch (Exception e) {
			System.out.println("Desila se nepredvidjena greska.");
		}

	}

	public String toString() {
		String temp = " ";

		temp += "Naziv agencije je: " + this.naziv + "\n";
		temp += "Adresa agencije je: " + this.adresa + "\n";
		temp += "Telefon agencije je: " + this.telefon + "\n";
		temp += "Ukupan broj aranzmana je: " + this.listaCamaca.size() + "\n";

		return temp.trim();
	}
}
