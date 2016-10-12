package test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import serieA.Campionato;
import serieA.Giocatore;
import serieA.Partita;
import serieA.ServizioCampionato;
import serieA.Squadra;

public class TestCampionato {

	public static void main(String[] args) throws Exception {
		
		ServizioCampionato sc1 = new ServizioCampionato();
		Campionato c1 = new Campionato("Serie A TIM");
		
		Giocatore g1 = sc1.registraGiocatore(c1, "Paulo", "Dybala", "DYBPLO", "Attaccante");
		Giocatore g2 = sc1.registraGiocatore(c1, "Gonzalo", "Higuain", "HGNGNZ", "Attaccante");
		Giocatore g3 = sc1.registraGiocatore(c1, "Gianluigi", "Buffon", "BFFGNL", "Portiere");
		Giocatore g4 = sc1.registraGiocatore(c1, "Alex", "Sandro", "SNDALX", "Difensore");
		Giocatore g5 = sc1.registraGiocatore(c1, "Gonzalo", "Higuain", "HGNGNZ", "Attaccante");
		Giocatore g6 = sc1.registraGiocatore(c1, "Sami", "Khedira", "KHDSAM", "Centrocampista");
		Giocatore g7 = sc1.registraGiocatore(c1, "Marek", "Hamsik", "HMSMRK", "Centrocampista");
		
		for(Giocatore g : c1.getElencoCalciatori().values()){
			System.out.println(g.getCognome() + " " + g.getNome() + " " + g.getCodiceFiscale() + " " + g.getRuolo());
			
		}
		
		System.out.println("\n");
		
		Squadra s1 = sc1.registraSquadra(c1, "Juventus");
		Squadra s2 = sc1.registraSquadra(c1, "Napoli");
		Squadra s3 = sc1.registraSquadra(c1, "Sassuolo");
		Squadra s4 = sc1.registraSquadra(c1, "Milan");
		Squadra s5 = sc1.registraSquadra(c1, "Inter");
		Squadra s6 = sc1.registraSquadra(c1, "Roma");
		
		for(Squadra s : c1.getElencoSquadre().values()){
			System.out.println(s.getNome());
		}
		
		System.out.println("\n");
		
		sc1.assegnaGiocatoreASquadra(c1, g1, s1);
		sc1.assegnaGiocatoreASquadra(c1, g2, s1);
		sc1.assegnaGiocatoreASquadra(c1, g3, s1);
		sc1.assegnaGiocatoreASquadra(c1, g4, s1);
		sc1.assegnaGiocatoreASquadra(c1, g6, s1);
		sc1.assegnaGiocatoreASquadra(c1, g7, s2);
		
		for(Squadra s : c1.getElencoSquadre().values()){
			for(Giocatore g : s.getRosa().values()){
				
				System.out.println(g.getCognome() + " " + g.getNome() + " è stato acquistato da " + s.getNome());
			}
		}
				System.out.println();
			
			List <Giocatore> marcatori = new ArrayList<Giocatore>();
			List <Giocatore> ammoniti = new ArrayList<Giocatore>();
			List <Giocatore> espulsi = new ArrayList<Giocatore>();
			List <Giocatore> marcatori1 = new ArrayList<Giocatore>();
			List <Giocatore> ammoniti1 = new ArrayList<Giocatore>();
			List <Giocatore> espulsi1 = new ArrayList<Giocatore>();
			
			marcatori.add(g1);
			marcatori.add(g1);
		    marcatori.add(g2);
			ammoniti.add(g2);
			ammoniti.add(g6);
			espulsi.add(g4);
			marcatori1.add(g7);
			marcatori1.add(g7);
			ammoniti1.add(g7);
		
			SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
			String date = "27-09-2016";
			Date dataPartita = df.parse(date);
			String date1 = "27-05-2017";
			Date dataPartita1 = df.parse(date1);
			
			Partita p = sc1.registraPartita(c1, dataPartita, s1, s2, 2, 0, marcatori, ammoniti, espulsi);
			Partita p2 = sc1.registraPartita(c1, dataPartita1, s2, s1, 2, 1, marcatori1, ammoniti1, espulsi1);
			
			System.out.println("\t\t\treti \tamm \tesp");
			
			for(Map.Entry<String, Giocatore> m : c1.getElencoCalciatori().entrySet()){
			
			     System.out.println(m.getValue().getCognome()+"\t"+m.getValue().getNome()
						+"\t\t"+m.getValue().getReti()+"\t"+m.getValue().getAmmonizioni()
						+"\t"+m.getValue().getEspulsioni());
			} 
			System.out.println();
			for(Map.Entry<String, Squadra> S : c1.getElencoSquadre().entrySet()){
			System.out.println(S.getValue().getNome()+"\t"+S.getValue().getPunti()
			+"\t"+S.getValue().getRetiFatte()+"\t"+S.getValue().getRetiSubite()
			+"\t"+S.getValue().getDifferenzaReti());
			}
			System.out.println();
			Squadra S = sc1.getCampione(c1);
			Giocatore G = sc1.getCapoCannoniere(c1);
			System.out.println(G.getNome()+" "+G.getCognome() + "\n");
			System.out.println("Campione D'Italia: " + S.getNome());
			}
	}