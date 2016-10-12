package serieA;

import java.util.Comparator;

public class GiocatoreComparator implements Comparator<Giocatore> {

	@Override
	public int compare(Giocatore g1, Giocatore g2) {
		if(g1.getReti() > g2.getReti()){
			return -1;
			
		}if(g1.getReti() < g2.getReti()) {
			return +1;
		}
		if(g1.getReti() == g2.getReti()){
			if(g1.getEspulsioni() > g2.getEspulsioni()){
				return +1;
			}
			if(g1.getEspulsioni() < g2.getEspulsioni()){
				return -1;
			}
			if(g1.getEspulsioni() == g2.getEspulsioni()){
				if(g1.getAmmonizioni() > g2.getAmmonizioni()){
					return +1;
				}
				if(g1.getAmmonizioni() < g2.getAmmonizioni()){
					return -1;
				}
			}
		}
		return 0;
	}

}
