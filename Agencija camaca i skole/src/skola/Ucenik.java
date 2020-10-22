package skola;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Ucenik {

	private String id;
	private String ime;
	private String prezime;
	private String odeljenje;
	private int razred;
	private double prosek;
	private String imeRoditelja;
	private String prezimeRoditelja;
	private LocalDate datumRodjenja;
	private static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy.");

	public Ucenik() {
		super();

	}

	public Ucenik(String id, String ime, String prezime, String prezimeRoditelja, LocalDate datumRodjenja) {
		super();
		this.id = id;
		this.ime = ime;
		this.prezime = prezime;
		this.prezimeRoditelja = prezimeRoditelja;
		this.datumRodjenja = datumRodjenja;
	}

	public Ucenik(String id, String ime, String prezime, String odeljenje, int razred, double prosek,
			String imeRoditelja, String prezimeRoditelja, LocalDate datumRodjenja) {
		super();
		this.id = id;
		this.ime = ime;
		this.prezime = prezime;
		this.odeljenje = odeljenje;
		this.razred = razred;
		this.prosek = prosek;
		this.imeRoditelja = imeRoditelja;
		this.prezimeRoditelja = prezimeRoditelja;
		this.datumRodjenja = datumRodjenja;
	}

	public String getid() {
		return id;
	}

	public void setid(String id) {
		this.id = id;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public String getOdeljenje() {
		return odeljenje;
	}

	public void setOdeljenje(String odeljenje) {
		this.odeljenje = odeljenje;
	}

	public int getRazred() {
		return razred;
	}

	public void setRazred(int razred) {
		this.razred = razred;
	}

	public double getProsek() {
		return prosek;
	}

	public void setProsek(double prosek) {
		this.prosek = prosek;
	}

	public String getImeRoditelja() {
		return imeRoditelja;
	}

	public void setImeRoditelja(String imeRoditelja) {
		this.imeRoditelja = imeRoditelja;
	}

	public String getPrezimeRoditelja() {
		return prezimeRoditelja;
	}

	public void setPrezimeRoditelja(String prezimeRoditelja) {
		this.prezimeRoditelja = prezimeRoditelja;
	}

	public LocalDate getDatumRodjenja() {
		return datumRodjenja;
	}

	public void setDatumRodjenja(LocalDate datumRodjenja) {
		this.datumRodjenja = datumRodjenja;
	}

	public String toString() {
		return String.format("%15s %15s %15s %15s %15s %15s %15s %15s  %15s\n", this.id, this.ime, this.prezime,
				this.odeljenje, this.razred, this.prosek, this.imeRoditelja, this.prezimeRoditelja,
				dtf.format(this.datumRodjenja));
	}

}
