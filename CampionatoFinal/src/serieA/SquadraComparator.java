package serieA;

import java.util.Comparator;

public class SquadraComparator implements Comparator<Squadra> { 

	@Override
	public int compare(Squadra s1, Squadra s2) {
		if(s1.getPunti() > s2.getPunti()){
			return -1;
		}
		if(s1.getPunti() < s2.getPunti()){
			return +1;
		}
		if(s1.getPunti() == s2.getPunti()){
			int puntiS1 = s1.puntiOttenutiDaSquadra(s2);
			int puntiS2 = s2.puntiOttenutiDaSquadra(s1);
			if(puntiS1 > puntiS2){
				return -1;
			}
			if(puntiS1 < puntiS2){
				return +1;
			}
			if(puntiS1 == puntiS2){
				if(s1.getDifferenzaReti() > s2.getDifferenzaReti()){
					return -1;
				}
				if(s1.getDifferenzaReti() < s2.getDifferenzaReti()){
					return +1;
				}
				if(s1.getDifferenzaReti() == s2.getDifferenzaReti()){
					if(s1.getRetiFatte() > s2.getRetiFatte()){
						return -1;
					}
					if(s1.getRetiFatte() < s2.getRetiFatte()){
						return +1;
					}
				}
			}
		}
		return 0;
	}
}
