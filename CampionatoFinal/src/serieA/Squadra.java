package serieA;

import java.util.Map;
import java.util.TreeMap;

public class Squadra {
	
	private String nome;
	private int punti;
	private int retiFatte;
	private int retiSubite;
	private int differenzaReti;
	private Map<String, Giocatore> rosa = new TreeMap<String, Giocatore>();
	private Map<String, Partita> giornate = new TreeMap<String, Partita>();
	
	public Squadra(String nome) {
		super();
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getPunti() {
		return punti;
	}

	public void setPunti(int punti) {
		this.punti = punti;
	}

	public int getRetiFatte() {
		return retiFatte;
	}

	public void setRetiFatte(int retiFatte) {
		this.retiFatte = retiFatte;
	}

	public int getRetiSubite() {
		return retiSubite;
	}

	public void setRetiSubite(int retiSubite) {
		this.retiSubite = retiSubite;
	}

	public int getDifferenzaReti() {
		differenzaReti = retiFatte-retiSubite;
		return differenzaReti;
	}

	public Map<String, Giocatore> getRosa() {
		return rosa;
	}

	public void setRosa(TreeMap<String, Giocatore> rosa) {
		this.rosa = rosa;
	}

	public Map<String, Partita> getGiornate() {
		return giornate;
	}

	public void setGiornate(Map<String, Partita> giornate) {
		this.giornate = giornate;
	}

	public int puntiOttenutiDaSquadra(Squadra s){
		int risultato=0;
		for(String codicePartita : giornate.keySet()){
			if(codicePartita.contains(s.getNome())){
				Partita partita = giornate.get(codicePartita);
				if(partita.getRisultato()=='X'){
					risultato += 1;
				}
				if (partita.getsCasa().getNome().equals(s.getNome()) && partita.getRisultato()=='2'){
					risultato += 3;
				}
				if (partita.getsTrasferta().getNome().equals(s.getNome()) && partita.getRisultato()=='1'){
					risultato += 3;
				}
			}
		}
		return risultato;
	}
	
}
