package serieA;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Partita {
	
	private Date d;
	private Squadra sCasa;
	private Squadra sTrasferta;
	private int golCasa;
	private int golTrasferta;
	private char risultato;
	private List<Giocatore> elencoRetiFatte = new ArrayList<Giocatore> ();
	private List<Giocatore> elencoAmmonizioni = new ArrayList<Giocatore> ();
	private List<Giocatore> elencoEspulsioni = new ArrayList<Giocatore> ();
	
	public Partita(Date d, Squadra sCasa, Squadra sTrasferta, int golCasa, int golTrasferta) {
		super();
		this.d = d;
		this.sCasa = sCasa;
		this.sTrasferta = sTrasferta;
		this.golCasa = golCasa;
		this.golTrasferta = golTrasferta;
		
		if(golCasa>golTrasferta){
			this.risultato = '1';
			sCasa.setPunti(sCasa.getPunti()+3);
		}else if(golCasa==golTrasferta){
			this.risultato = 'X';
			sCasa.setPunti(sCasa.getPunti()+1);
			sTrasferta.setPunti(sTrasferta.getPunti()+1);
		}else{this.risultato = '2';
		sTrasferta.setPunti(sTrasferta.getPunti()+3);
		}
		
	}
	public Date getD() {
		return d;
	}
	public void setD(Date d) {
		this.d = d;
	}
	public Squadra getsCasa() {
		return sCasa;
	}
	public void setsCasa(Squadra sCasa) {
		this.sCasa = sCasa;
	}
	public Squadra getsTrasferta() {
		return sTrasferta;
	}
	public void setsTrasferta(Squadra sTrasferta) {
		this.sTrasferta = sTrasferta;
	}
	public int getGolCasa() {
		return golCasa;
	}
	public void setGolCasa(int golCasa) {
		this.golCasa = golCasa;
	}
	public int getGolTrasferta() {
		return golTrasferta;
	}
	public void setGolTrasferta(int golTrasferta) {
		this.golTrasferta = golTrasferta;
	}
	public char getRisultato() {
		return risultato;
	}
	public void setRisultato(char risultato) {
		this.risultato = risultato;
	}
	public List<Giocatore> getElencoRetiFatte() {
		return elencoRetiFatte;
	}
	public void setElencoRetiFatte(List<Giocatore> elencoRetiFatte) {
		this.elencoRetiFatte = elencoRetiFatte;
	}
	public List<Giocatore> getElencoEspulsioni() {
		return elencoEspulsioni;
	}
	public void setElencoEspulsioni(List<Giocatore> elencoEspulsioni) {
		this.elencoEspulsioni = elencoEspulsioni;
	}
	public List<Giocatore> getElencoAmmonizioni() {
		return elencoAmmonizioni;
	}
	public void setElencoAmmonizioni(List<Giocatore> elencoAmmonizioni) {
		this.elencoAmmonizioni = elencoAmmonizioni;
	}
}
