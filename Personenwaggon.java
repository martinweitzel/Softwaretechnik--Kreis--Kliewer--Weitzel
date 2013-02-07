import java.util.ArrayList;
import java.util.List;

/**
 * Diese Klasse initialisiert einen Personenwaggon
 */
public class Personenwaggon extends Waggon implements Waggon_Interface {

	private final int maximaleAnzahlPersonen;
	private final float leergewicht;
	private static final int NORMGEWICHT_PERSON = 80;

	private List<String> personen;

	/**
	 * @param leergewicht : float
	 * @param maxPersonen : int
	 * <br><br>
	 * Der Konstruktor fuer die Klasse <tt>Personenwaggon</tt>
	 */
	public Personenwaggon(float leergewicht, int maxPersonen) {
		this.leergewicht = leergewicht;
		this.maximaleAnzahlPersonen = maxPersonen;
		this.personen = new ArrayList<String>();
	}

	/**
	 * 
	 * @param name : String
	 * @return <tt>true</tt> bei erfolgreicher Hinzufuegung von <tt>name</tt>, ansonsten <tt>false</tt><br><br>
	 * Die Methode fuegt eine Person in ein Personenwaggon-Objekt. Sobald der Wagen voll ist, wird <tt>false</tt> als Parameter zurueckgegeben
	 */
	public boolean fuegeHinzuPerson(String name) {
		if (personen.size() < maximaleAnzahlPersonen) {
			personen.add(name);
			System.out.println("Person \"" + name + "\" hinzugefuegt");
			return true;
		} else {
			System.out.println("Fehler: Person \"" + name + "\" kann nicht hinzugefuegt werden, da die max. Personenzahl ueberschritten werden wuerde!");
			return false;
		}
	}
	
	/**
	 * @return maximaleAnzahlPersonen : int
	 * <br><br>
	 * Gibt die maximale Anzahl der Personen des Waggons zurueck
	 */
	public int getMaxPersonen() {
		return maximaleAnzahlPersonen;
	}

	/**
	 * @return leergewicht : float
	 * <br><br>
	 * Gibt das Leergewicht des Waggons zurueck
	 */
	public float getLeergewichtKg() {
		return leergewicht;
	}

	/**
	 * @return wagengewicht : float
	 * <br><br>
	 * Gibt das Gewicht des Waggons zurueck
	 */
	public float liefereGewichtKg() {
		return leergewicht + personen.size() * NORMGEWICHT_PERSON;
	}
}
