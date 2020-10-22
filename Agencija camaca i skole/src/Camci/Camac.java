package Camci;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Camac {

	int id;
	int nosivost;
	double potrosnja;
	double cena;
	LocalDate datumPocetaRen;
	LocalDate datumKrajRen;
	private static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy.");

	public Camac() {
		super();
		this.datumPocetaRen = LocalDate.now();
		this.datumKrajRen = LocalDate.now();

	}

	public Camac(int id, int nosivost, double potrosnja) {
		super();
		this.id = id;
		this.nosivost = nosivost;
		this.potrosnja = potrosnja;
		this.datumPocetaRen = LocalDate.now();
		this.datumKrajRen = LocalDate.now();

	}

	public Camac(int id, int nosivost, double potrosnja, double cena, LocalDate datumPocetaRen,
			LocalDate datumKrajRen) {
		super();
		this.id = id;
		this.nosivost = nosivost;
		this.potrosnja = potrosnja;
		this.cena = cena;
		this.datumPocetaRen = datumPocetaRen;
		this.datumKrajRen = datumKrajRen;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNosivost() {
		return nosivost;
	}

	public void setNosivost(int nosivost) {
		this.nosivost = nosivost;
	}

	public double getPotrosnja() {
		return potrosnja;
	}

	public void setPotrosnja(double potrosnja) {
		this.potrosnja = potrosnja;
	}

	public double getCena() {
		return cena;
	}

	public void setCena(double cena) {
		this.cena = cena;
	}

	public LocalDate getDatumPocetaRen() {
		return datumPocetaRen;
	}

	public void setDatumPocetaRen(LocalDate datumPocetaRen) {
		this.datumPocetaRen = datumPocetaRen;
	}

	public LocalDate getDatumKrajRen() {
		return datumKrajRen;
	}

	public void setDatumKrajRen(LocalDate datumKrajRen) {
		this.datumKrajRen = datumKrajRen;
	}

	public String toString() {
		return String.format("%15s %15s %15s %15s %15s %15s", this.id, this.nosivost, this.potrosnja, this.cena,
				dtf.format(this.datumPocetaRen), dtf.format(this.datumKrajRen));
	}

}
