/**
 * Diese Klasse initialisiert einen Gueterwaggon
 */
public class Gueterwaggon extends Waggon implements Waggon_Interface{

	private final float maximalGewichtKg;
	private final float leergewichtKg;
	private float gewichtKg;
	
	/**
	 * @param leergewichtKg : float
	 * @param maximalGewichtKg : float
	 * <br><br>
	 * Der Konstuktor der Klasse <tt>Gueterwaggon</tt>
	 */
	public Gueterwaggon(float leergewichtKg, float maximalGewichtKg) {
		this.leergewichtKg = leergewichtKg;
		this.maximalGewichtKg = maximalGewichtKg;
		this.gewichtKg = 0;
	}

	/**
	 * @param gewichtVomGutKg : float
	 * @return <tt>true</tt> bei erfolgreicher Hinzufuegung von <tt>gewichtVomGutKg</tt>, ansonsten <tt>false</tt><br><br>
	 * Die Methode fuegt Gut in ein Gueterwaggon-Objekt. Sobald der Wagen voll ist, wird <tt>false</tt> als Parameter zurueckgegeben
	 */
	public boolean fuegeHinzuGut(float gewichtVomGutKg){
		this.gewichtKg = fuegeHinzu(this.gewichtKg, gewichtVomGutKg, this.maximalGewichtKg, "Gut");
		if(this.gewichtKg==-1){
			return false;
		}else{
			return true;
		}
	}

	/**
	 * @return maximalGewichtKg : float
	 * <br><br>
	 * Gibt das Maximalgewicht des Waggons zurueck
	 */
	public float getMaximalGewicht() {
		return maximalGewichtKg;
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
		return leergewichtKg+gewichtKg;
	}

}
