/**
 * Diese Klasse initialisiert einen Kippwaggon
 */
public class Kippwaggon extends Waggon implements Waggon_Interface{

	private final float maximalesGewichtKg;
	private final float leergewichtKg;
	private float gewichtKg;
	private boolean gekippt;

	/**
	 * @param maximalesGewichtKg : float
	 * @param leergewichtKg : float
	 * <br><br>
	 * Der Konstuktor der Klasse <tt>Kippwaggon</tt>
	 */
	public Kippwaggon(float maximalesGewichtKg, float leergewichtKg) {
		super();
		this.maximalesGewichtKg = maximalesGewichtKg;
		this.leergewichtKg = leergewichtKg;
		this.gewichtKg = 0;
		this.gekippt = false;
	}
	
	/**
	 * @param gewichtVomGutKg : float
	 * @return <tt>true</tt> bei erfolgreicher Hinzufuegung von <tt>gewichtVomGutKg</tt>, ansonsten <tt>false</tt><br><br>
	 * Die Methode fuegt Gut in ein Kippwaggon-Objekt. Sobald der Wagen voll ist, wird <tt>false</tt> als Parameter zurueckgegeben
	 */
	public boolean fuegeHinzuGut(float gewichtVomGutKg) {
		if (this.isGekippt()) {
			System.out.println("Fehler: Beladung nicht moeglich, da der Waggon noch gekippt ist!");
			return false;
		} else {
			this.gewichtKg = fuegeHinzu(this.gewichtKg, gewichtVomGutKg, this.maximalesGewichtKg, "Gut");
			if(this.gewichtKg==-1){
				return false;
			}else{
				return true;
			}
		}
	}

	/**
	 * Diese Methode "kippt" den Waggon aus. Der Waggon hat nun keinen Inhalt mehr.
	 */
	public void kippen() {
		this.gewichtKg = 0;
		this.gekippt = true;
	}

	/**
	 * Aufrichten der Beladeflaeche. Damit ist der Kippwaggon bereit, neu beladen
	 * zu werden.
	 */
	public void aufrichten() {
		this.gekippt = false;
	}

	/**
	 * @return Gibt <tt>true</tt> zurueck, falls der Waggon gekippt ist, andernfalls wird <tt>false</tt> zurueckgegeben
	 */
	public boolean isGekippt() {
		return this.gekippt;
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
	 * @return wagengewicht : float
	 * <br><br>
	 * Gibt das Gewicht des Waggons zurueck
	 */
	public float liefereGewichtKg() {
		return leergewichtKg+gewichtKg;
	}
}