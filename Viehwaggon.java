/**
 * Diese Klasse initialisiert einen Viehwaggon
 */
public class Viehwaggon extends Waggon implements Waggon_Interface{

	private final float maxGewichtKg;
	private final int maxViehAnzahl;
	private final float leergewichtKg;
	private float gewichtVonEinemViehKg;
	private int viehAnzahl;

	/**
	 * @param leergewicht : float
	 * @param maxGewichtKg : float
	 * @param maxViehAnzahl : int
	 * <br><br>
	 * Der Konstruktor fuer die Klasse <tt>Viehwaggon</tt>
	 */
	public Viehwaggon(float leergewicht, float maxGewichtKg, int maxViehAnzahl) {
		this.leergewichtKg = leergewicht;
		this.maxGewichtKg = maxGewichtKg;
		this.maxViehAnzahl = maxViehAnzahl;
		this.gewichtVonEinemViehKg = 0;
		this.viehAnzahl = 0;
	}

	/**
	 * 
	 * @param gewichtVonEinemViehKg : float
	 * @return <tt>true</tt> bei erfolgreicher Hinzufuegung von <tt>gewichtVonEinemViehKg</tt>, ansonsten <tt>false</tt><br><br>
	 * Die Methode fuegt Gut in ein Viehwaggon-Objekt. Sobald der Wagen voll ist, wird <tt>false</tt> als Parameter zurueckgegeben
	 */
	public boolean fuegeHinzuVieh(float gewichtVonEinemViehKg) {
		if (this.viehAnzahl + 1 <= this.maxViehAnzahl) {
			this.viehAnzahl++;
			this.gewichtVonEinemViehKg = fuegeHinzu(this.gewichtVonEinemViehKg, gewichtVonEinemViehKg, this.maxGewichtKg, "Vieh");
			System.out.println(this.viehAnzahl +". Vieh mit "+gewichtVonEinemViehKg+"kg hinzugefuegt");
			return true;
		} else {
			System.out.println("Fehler: Vieh mit "+gewichtVonEinemViehKg+"kg kann nicht hinzugefuegt werden, da entweder das max. Gewicht oder die max. Viehanzahl ueberschritten werden wuerde!");
			return false;
		}
	}

	/**
	 * @return maxGewichtKg : float
	 * <br><br>
	 * Gibt das Maximalgewicht des Waggons zurueck
	 */
	public float getMaxKg() {
		return maxGewichtKg;
	}

	/**
	 * @return maxViehAnzahl : int
	 * <br><br>
	 * Gibt die maximale Viehanzahl des Waggons zurueck
	 */
	public int getMaxVieh() {
		return maxViehAnzahl;
	}

	/**
	 * @return leergewichtKg : float
	 * <br><br>
	 * Gibt das Leergewicht des Waggons zurueck
	 */
	public float getLeergewichtKg() {
		return leergewichtKg;
	}

	/**
	 * @return liefereGewichtKg : float
	 * <br><br>
	 * Gibt das Gewicht des Waggons zurueck
	 */
	public float liefereGewichtKg() {
		return leergewichtKg+gewichtVonEinemViehKg;
	}

}
