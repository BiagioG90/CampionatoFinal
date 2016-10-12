package serieA;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class ServizioCampionato {
	
	public Giocatore registraGiocatore(Campionato c, String nome, String cognome, String codiceFiscale, String ruolo){
		
		Giocatore g = null;
		
		if(!c.getElencoCalciatori().containsKey(codiceFiscale)){
			g = new Giocatore(nome, cognome, codiceFiscale, ruolo);
			c.getElencoCalciatori().put(codiceFiscale, g);
		}
		return g;
	}	
	
	public Squadra registraSquadra(Campionato c, String nome){
		
		Squadra s = null;
		
		if(!c.getElencoSquadre().containsKey(nome)){
			s = new Squadra(nome);
			c.getElencoSquadre().put(nome, s);
		}
		return s;
	}
	
	public boolean assegnaGiocatoreASquadra(Campionato c, Giocatore g, Squadra s){
		if(c.getElencoCalciatori().containsKey(g.getCodiceFiscale()) && c.getElencoSquadre().containsKey(s.getNome())){
			if(!s.getRosa().containsKey(g.getCodiceFiscale())){
				
				s.getRosa().put(g.getCodiceFiscale(), g);
				return true;
			}
		}
		return false;
	}
	
	public Partita registraPartita(Campionato c, Date d, Squadra sCasa, Squadra sOspite, int retiCasa, int retiOspite, List<Giocatore> reti, List<Giocatore> amm, List<Giocatore> esp){
		if(c.getElencoSquadre().containsKey(sCasa.getNome()) && c.getElencoSquadre().containsKey(sOspite.getNome())){
			
			sCasa = c.getElencoSquadre().get(sCasa.getNome());
			sOspite = c.getElencoSquadre().get(sOspite.getNome());
			
			for(Giocatore g : reti){
				if(c.getElencoCalciatori().containsKey(g.getCodiceFiscale())){
					Giocatore giocatoreCheHaSegnato = c.getElencoCalciatori().get(g.getCodiceFiscale());
					giocatoreCheHaSegnato.setReti(giocatoreCheHaSegnato.getReti() + 1 );				
				}			
			}
			
			for(Giocatore g : amm){
				if(c.getElencoCalciatori().containsKey(g.getCodiceFiscale())){
					Giocatore giocatoreAmmonito = c.getElencoCalciatori().get(g.getCodiceFiscale());
					giocatoreAmmonito.setAmmonizioni(giocatoreAmmonito.getAmmonizioni() + 1);
				}
			}

			for(Giocatore g : esp){
				if(c.getElencoCalciatori().containsKey(g.getCodiceFiscale())){
					Giocatore giocatoreEspulso = c.getElencoCalciatori().get(g.getCodiceFiscale());
					giocatoreEspulso.setEspulsioni(giocatoreEspulso.getAmmonizioni() + 1);
				}
			}
			
			Partita p = new Partita(d,sCasa, sOspite, retiCasa, retiOspite);
			p.setElencoRetiFatte(reti);
			p.setElencoAmmonizioni(amm);
			p.setElencoEspulsioni(esp);
			c.getElencoPartite().put(d + " " + sCasa.getNome() + " " + sOspite.getNome(), p);
			sCasa.getGiornate().put(d + " " + sCasa.getNome() + " " + sOspite.getNome(), p);
			sOspite.getGiornate().put(d + " " + sCasa.getNome() + " " + sOspite.getNome(), p);
			sCasa.setRetiFatte(sCasa.getRetiFatte()+ retiCasa);
			sCasa.setRetiSubite(sCasa.getRetiSubite()+ retiOspite);
			sOspite.setRetiFatte(sOspite.getRetiFatte()+ retiOspite);
			sOspite.setRetiSubite(sOspite.getRetiSubite() + retiCasa);		
			
			return p;
		}
		return null;
	}

	public Giocatore getCapoCannoniere(Campionato c){
		GiocatoreComparator comparator = new GiocatoreComparator();
		List<Giocatore> lista = new ArrayList<Giocatore>(c.getElencoCalciatori().values());
		Collections.sort(lista, comparator);
		return lista.get(0);
	}
	
	public Squadra getCampione (Campionato c){
		SquadraComparator comparator = new SquadraComparator();
		List<Squadra> lista = new ArrayList<Squadra>(c.getElencoSquadre().values());
		Collections.sort(lista, comparator);
		return lista.get(0);
	}
}
