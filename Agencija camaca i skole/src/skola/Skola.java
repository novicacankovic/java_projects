package skola;

import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;



public class Skola {

	private String nazivSkole;
	private String adresaSkole;
	private ArrayList<Ucenik> listaUcenika;

	public Skola() {
		super();
		this.listaUcenika = new ArrayList<>();
	}

	public Skola(String nazivSkole) {
		super();
		this.nazivSkole = nazivSkole;
		this.listaUcenika = new ArrayList<>();
	}

	public Skola(String nazivSkole, String adresaSkole, ArrayList<Ucenik> listaUcenika) {
		super();
		this.nazivSkole = nazivSkole;
		this.adresaSkole = adresaSkole;
		this.listaUcenika = listaUcenika;
	}

	public String getNazivSkole() {
		return nazivSkole;
	}

	public void setNazivSkole(String nazivSkole) {
		this.nazivSkole = nazivSkole;
	}

	public String getAdresaSkole() {
		return adresaSkole;
	}

	public void setAdresaSkole(String adresaSkole) {
		this.adresaSkole = adresaSkole;
	}

	public ArrayList<Ucenik> getListaUcenika() {
		return listaUcenika;
	}

	public void setListaUcenika(ArrayList<Ucenik> listaUcenika) {
		this.listaUcenika = listaUcenika;
	}

	public boolean dodajUcenika(Ucenik mojUcenik) {

		for (int i = 0; i < this.listaUcenika.size(); i++) {
			if (this.listaUcenika.get(i).getid().equals(mojUcenik.getid())) {

				System.out.println("NIje moguce uneti ucenika pod navedenim ID-om");
				return false;
			}
		}

		this.listaUcenika.add(mojUcenik);
		System.out.println("Ucenik je uspeno dodat. ");
		return true;
	}

	public void ispispodataka() {
		System.out.printf("%15s %15s %15s %15s %15s %15s %15s %15s  %15s\n", "id", "ime", "prezime", "odeljenje",
				"razred", "prosek", "imeRoditelja", "prezimeRoditelja", "datumRodjenja");
		System.out.println(
				"------------------------------------------------------------------------------------------------------------------------------------------------------------");
		for (int i = 0; i < this.listaUcenika.size(); i++) {
			System.out.println(this.listaUcenika.get(i));
		}

	}

	public boolean izmeniUcenika(Ucenik mojUcenik) {

		for (int i = 0; i < this.listaUcenika.size(); i++) {
			if (this.listaUcenika.get(i).getid().equals(mojUcenik.getid())) {

				this.listaUcenika.set(i, mojUcenik);
				System.out.println("Ucenik je uspesno izmenjen. ");
				return true;
			}
		}

		System.out.println("Nije moguce izmeniti ucenika pod navedenim ID-om");
		return false;
	}

	public Ucenik obrisiUcenika(String id) {

		int index = -1;
		for (int i = 0; i < this.listaUcenika.size(); i++) {
			if (this.listaUcenika.get(i).getid().equals(id)) {
				index = i;

				System.out.println("Ucenik je uspesno obrisan. ");
				return this.listaUcenika.remove(index);
			}
		}

		System.out.println("Ucenik ne postoji u evidenciji Skole. ");
		return null;

	}

	public ArrayList<Ucenik> pretragaUcenikapremaOdeljenju(String odeljenje) {
		System.out.printf("%15s %15s %15s %15s %15s %15s %15s %15s  %15s\n", "id", "ime", "prezime", "odeljenje",
				"razred", "prosek", "imeRoditelja", "prezimeRoditelja", "datumRodjenja");
		System.out.println(
				"------------------------------------------------------------------------------------------------------------------------------------------------------------");

		ArrayList<Ucenik> listaRezultata = new ArrayList<>();
		for (int i = 0; i < this.listaUcenika.size(); i++) {
			if (this.listaUcenika.get(i).getOdeljenje().equalsIgnoreCase(odeljenje)) {

				listaRezultata.add(this.listaUcenika.get(i));
				System.out.println(this.listaUcenika.get(i));

			}
		}

		return listaRezultata;
	}

	public ArrayList<Ucenik> pretragaUcenikaPremaProseku(double prosek) {
		System.out.printf("%15s %15s %15s %15s %15s %15s %15s %15s  %15s\n", "id", "ime", "prezime", "odeljenje",
				"razred", "prosek", "imeRoditelja", "prezimeRoditelja", "datumRodjenja");
		System.out.println(
				"------------------------------------------------------------------------------------------------------------------------------------------------------------");

		ArrayList<Ucenik> listaRezultata = new ArrayList<>();
		for (int i = 0; i < this.listaUcenika.size(); i++) {
			if (this.listaUcenika.get(i).getRazred() >= 5 && this.listaUcenika.get(i).getRazred() <= 8
					&& this.listaUcenika.get(i).getProsek() > prosek) {

				listaRezultata.add(this.listaUcenika.get(i));
				System.out.println(this.listaUcenika.get(i));

			}
		}

		return listaRezultata;
	}

	public double pretragaPremaProseku(int razred) {

		ArrayList<Ucenik> listaRezultata = new ArrayList<>();

		for (int i = 0; i < this.listaUcenika.size(); i++) {
			if (this.listaUcenika.get(i).getRazred() == razred) {

				listaRezultata.add(this.listaUcenika.get(i));

			}
		}

		double prosek = 0.00;
		double suma = 0;
		for (int i = 0; i < listaRezultata.size(); i++) {
			suma += listaRezultata.get(i).getProsek();

			prosek = (double) suma / listaRezultata.size();
		}

		System.out.println("Prosek ucenika za razred: " + razred + " iznosi: " + prosek);
		return prosek;

	}

	public int razred(int broj) {

		ArrayList<Ucenik> listaRezultata = new ArrayList<>();

		for (int i = 0; i < this.listaUcenika.size(); i++) {
			if (this.listaUcenika.get(i).getRazred() == broj) {

				listaRezultata.add(this.listaUcenika.get(i));
			}
		}
		return listaRezultata.size();

	}

	public ArrayList<Ucenik> pronalazenjeUcenikasaNajcevomProsekom(int razred) {

		ArrayList<Ucenik> listaRezultata = new ArrayList<>();

		for (int i = 0; i < this.listaUcenika.size(); i++) {

			if (this.listaUcenika.get(i).getRazred() == razred) {
				listaRezultata.add(this.listaUcenika.get(i));
			}
		}

		Ucenik najveca = pronadjiJednogUcenika(listaRezultata);

		if (najveca == null) {
			System.out.println("Ne postoji informacija za zadate uslove.");
			return null;
		} else {
			ArrayList<Ucenik> sveNajveceProseke = pronadjisveNajveceProseke(listaRezultata, najveca);
			for (int i = 0; i < sveNajveceProseke.size(); i++) {
				System.out.println("Najveci prosek ucenika " + i + " je: " + sveNajveceProseke.get(i));
			}
			return sveNajveceProseke;
		}
	}

	public Ucenik pronadjiJednogUcenika(ArrayList<Ucenik> listaUcenika) {

		Ucenik najveca = null;
		if (listaUcenika.size() > 0) {
			najveca = listaUcenika.get(0);
			for (int i = 1; i < listaUcenika.size(); i++) {
				if (najveca.getProsek() < listaUcenika.get(i).getProsek()) {
					najveca = listaUcenika.get(i);
				}
			}
		}
		return najveca;
	}

	public ArrayList<Ucenik> pronadjisveNajveceProseke(ArrayList<Ucenik> listaFilter, Ucenik najveca) {

		ArrayList<Ucenik> listaRezultata = new ArrayList<>();
		for (int i = 0; i < listaFilter.size(); i++) {
			if (listaFilter.get(i).getProsek() == najveca.getProsek()) {
				listaRezultata.add(listaFilter.get(i));
			}
		}
		return listaRezultata;
	}

	public void sacuvaj(String putanja) {

		ArrayList<String> linije = new ArrayList<String>();

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy.");

		linije.add(this.nazivSkole);
		linije.add(this.adresaSkole);

		for (int i = 0; i < this.listaUcenika.size(); i++) {
			Ucenik mojUcenik = this.listaUcenika.get(i);

			String id = mojUcenik.getid();
			String ime = mojUcenik.getIme();
			String prezime = mojUcenik.getPrezime();
			String odeljenje = mojUcenik.getOdeljenje();
			int razred = mojUcenik.getRazred();
			double prosek = mojUcenik.getProsek();
			String imeRoditelja = mojUcenik.getImeRoditelja();
			String prezimeRoditelja = mojUcenik.getPrezimeRoditelja();
			String formatiraniDatumRodjenja = dtf.format(mojUcenik.getDatumRodjenja());

			String linija = id + ";" + ime + ";" + prezime + ";" + odeljenje + ";" + razred + ";" + prosek + ";"
					+ imeRoditelja + ";" + prezimeRoditelja + ";" + formatiraniDatumRodjenja + ";";
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

		this.listaUcenika = new ArrayList<>();

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy.");
		List<String> linije;
		try {
			linije = Files.readAllLines(Paths.get(putanja), Charset.defaultCharset());

			this.nazivSkole = linije.get(0);
			this.adresaSkole = linije.get(1);

			for (int i = 2; i < linije.size(); i++) {
				String[] attributes = linije.get(i).split(";");

				String id = attributes[0];
				String ime = attributes[1];
				String prezime = attributes[2];
				String odeljenje = attributes[3];
				int razred = Integer.parseInt(attributes[4]);
				double prosek = Double.parseDouble(attributes[5]);
				String imeRoditelja = attributes[6];
				String prezimeRoditelja = attributes[7];
				LocalDate datumRodjenja = LocalDate.parse(attributes[8], dtf);

				Ucenik mojUcenik = new Ucenik(id, ime, prezime, odeljenje, razred, prosek, imeRoditelja,
						prezimeRoditelja, datumRodjenja);
				this.listaUcenika.add(mojUcenik);

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

		StringBuilder sb = new StringBuilder();
		sb.append("Naziv skole je : " + this.nazivSkole + "\n");
		sb.append("Adresa skole: " + this.adresaSkole + "\n");
		sb.append("Broj ucenika za prvi razred je: " + this.razred(1) + "\n");
		sb.append("Broj ucenika za drugi razred je: " + this.razred(2) + "\n");
		sb.append("Broj ucenika za treci razred je: " + this.razred(3) + "\n");
		sb.append("Broj ucenika za cetvrti razred je: " + this.razred(4) + "\n");
		sb.append("Broj ucenika za peti razred je: " + this.razred(5) + "\n");
		sb.append("Broj ucenika za sesti razred je: " + this.razred(6) + "\n");
		sb.append("Broj ucenika za sedmi razred je: " + this.razred(7) + "\n");
		sb.append("Broj ucenika za osmi razred je: " + this.razred(8) + "\n");

		return sb.toString();

	}

}
	
	
	
	
	
	
	