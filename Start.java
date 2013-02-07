import java.util.Date;

public class Start {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Lokomotive lok = new Lokomotive(8000);
		
		Gueterwaggon g = new Gueterwaggon(2000, 2000); //insg. 4t
		g.fuegeHinzuGut(1000);
		g.fuegeHinzuGut(1000);
		g.fuegeHinzuGut(1000); //Fehler!
		
		Personenwaggon p = new Personenwaggon(2000, 3); //insg. 5t
		p.fuegeHinzuPerson("Bert");
		p.fuegeHinzuPerson("Ernie");
		p.fuegeHinzuPerson("Bernie");
		p.fuegeHinzuPerson("Peter"); //Fehler
		
		Viehwaggon v = new Viehwaggon(3000, 2000, 2); //insg. 5t
		v.fuegeHinzuVieh(1000);
		v.fuegeHinzuVieh(1000);
		v.fuegeHinzuVieh(1000); //Fehler;

		Kippwaggon k = new Kippwaggon(3000, 1000); //insg. 4t
		k.fuegeHinzuGut(2000);
		k.fuegeHinzuGut(2000); //Fehler
		k.kippen();
		k.fuegeHinzuGut(1000); //Fehler
		k.aufrichten();
		k.fuegeHinzuGut(500);
		
		lok.koppeln(g,true);
		lok.koppeln(p,true);
		lok.koppeln(v,true);
		lok.koppeln(k,true);
		lok.losfahren(); //Fehler: Fuehrer fehlt 
		lok.lokfuehrerSteigtEin("Hans-Peter", "458uDD3434", new Date());
		lok.losfahren(); //Fehler: Last zu hoch
		lok.koppeln(v,false);
		lok.losfahren();
		lok.koppeln(v,true); //Fehler: Lok faehrt grad
		lok.losfahren(); // (Lok faehrt bereits)
		lok.anhalten();
		
	}

}
