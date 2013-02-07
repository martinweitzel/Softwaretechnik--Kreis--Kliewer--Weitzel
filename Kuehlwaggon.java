/**
 * Diese Klasse initialisiert einen Kuehlwaggon
 */
public class Kuehlwaggon extends Waggon implements Waggon_Interface{
	private final float maximalGewichtKg;
	private final float leergewichtKg;
	private float gewichtKg;
	private boolean kaeltemaschine_an;
	
	/**
	 * @param leergewichtKg : float
	 * @param maximalGewichtKg : float
	 * <br><br>
	 * Der Konstuktor der Klasse <tt>Gueterwaggon</tt>
	 */
	public Kuehlwaggon(float leergewichtKg, float maximalGewichtKg) {
		this.leergewichtKg = leergewichtKg;
		this.maximalGewichtKg = maximalGewichtKg;
		this.gewichtKg = 0;
		this.kaeltemaschine_an = false;
	}

	/**
	 * @param gewichtVomGutKg : float
	 * @return <tt>true</tt> bei erfolgreicher Hinzufuegung von <tt>gewichtVomGutKg</tt>, ansonsten <tt>false</tt><br><br>
	 * Die Methode fuegt Gut in ein Kuehlwaggon-Objekt. Sobald der Wagen voll ist, wird <tt>false</tt> als Parameter zurueckgegeben
	 */
	public boolean fuegeHinzuGut(float gewichtVomGutKg){
		if(this.kaeltemaschine_an==false){
			this.gewichtKg = fuegeHinzu(this.gewichtKg, gewichtVomGutKg, this.maximalGewichtKg, "Gut");
			if(this.gewichtKg==-1){
				return false;
			}else{
				return true;
			}
		}else{
			System.out.println("Fehler: Beladung nicht moeglich, da die Kaeltemaschine noch an ist!");
			return false;
		}
	}

	/**
	 * @param schalter : boolean
	 * <br><br>
	 * Schaltet die Kältemaschine an und aus
	 */
	public void kaeltemaschine_betaetigen(boolean schalter){
		if(schalter==true){
			this.kaeltemaschine_an = true;
		}else{
			if(this.gewichtKg==this.leergewichtKg){
				this.kaeltemaschine_an = false;
			}else{
				System.out.println("Fehler: Da noch Gut im Waggon ist, kann die Kaeltemaschine nicht ausgeschaltet werden!");
			}
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
