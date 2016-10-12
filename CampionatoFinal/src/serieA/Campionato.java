package serieA;

import java.util.Map;
import java.util.TreeMap;

public class Campionato {
	
	private String nome;
	private Map<String, Giocatore> elencoCalciatori = new TreeMap<String, Giocatore>();
	private Map<String, Squadra> elencoSquadre = new TreeMap<String, Squadra>();
	private Map<String, Partita> elencoPartite = new TreeMap<String, Partita> ();
	
	public Map<String, Squadra> getElencoSquadre() {
		return elencoSquadre;
	}

	public void setElencoSquadre(TreeMap<String, Squadra> elencoSquadre) {
		this.elencoSquadre = elencoSquadre;
	}

	public Campionato(String nome) {
		super();
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Map<String, Giocatore> getElencoCalciatori() {
		return elencoCalciatori;
	}

	public void setElencoCalciatori(TreeMap<String, Giocatore> elencoCalciatori) {
		this.elencoCalciatori = elencoCalciatori;
	}

	public Map<String, Partita> getElencoPartite() {
		return elencoPartite;
	}

	public void setElencoPartite(Map<String, Partita> elencoPartite) {
		this.elencoPartite = elencoPartite;
	}
}
