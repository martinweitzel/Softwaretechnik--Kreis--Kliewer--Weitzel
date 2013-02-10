import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/**
 * Diese Klasse initialisiert eine Lokomotive
 */
public class Diesellok {

	private static final int STATUS_HAELT = 0;
	private static final int STATUS_FAEHRT = 1;

	private final float zugkraftKg; 
	private int lokStatus; 
	private String lokfuehrerName;
	private String lokfuehrerId;
	private Date lokfuehrerSeit;
	private final List<Object> waggons; 

	/**
	 * @param zugkraft : float
	 * <br><br>
	 * Der Konstruktor der Klasse <tt>Lokomotive</tt>
	 */
	public Lokomotive(float zugkraft) {
		this.zugkraftKg = zugkraft;
		this.waggons = new ArrayList<Object>();
		this.lokStatus = STATUS_HAELT;
	}

	/**
	 * Diese Methode initialisiert das Losfahren des Zuges. <br>
	 * ueberprueft wird, ob der Zug ueberhaupt losfahren kann. Muegliche Fehler:<br>
	 * - Der Zug ist zu schwer<br>
	 * - Kein Lokfuehrer vorhanden<br>
	 * - Die Lok faehrt bereits<br><br>
	 * Zu allen Aktionen wird eine Meldung in der Console ausgegeben
	 */
	public void losfahren() {
		if (this.lokStatus == STATUS_HAELT) {
			if (lokfuehrerName != null) {
				float gewichtKg = 0;
				for (Object waggonObject : waggons) {
					if((waggonObject instanceof Gueterwaggon)||(waggonObject instanceof Kippwaggon)||(waggonObject instanceof Personenwaggon)||(waggonObject instanceof Viehwaggon)){
						gewichtKg += ((Waggon_Interface) waggonObject).liefereGewichtKg();
					}
				}

				if (gewichtKg <= zugkraftKg) {
					this.lokStatus = STATUS_FAEHRT;
					System.out.println("Die Lok faehrt los! Die Last betraegt " + gewichtKg + "kg");
				} else {
					System.out.println("Fehler: Lokomotive kann nicht losfahren, da die Waggons zu schwer sind. Es muessen Waggons abgekoppelt werden!");
				}

			} else {
				System.out.println("Fehler: Kein Lokfuehrer vorhanden!");
			}
		} else {
			System.out.println("Die Lok faehrt bereits!");
		}

	}

	/**
	 * In dieser Methode wird der Zug angehalten. Falls der Zug bereits steht, wird nichts unternommen.
	 */
	public void anhalten() {
		if (this.lokStatus == STATUS_FAEHRT) {
			this.lokStatus = STATUS_HAELT;
			System.out.println("Die Lok haelt an");
		} else {
			System.out.println("Die Lok steht bereits!");
		}
	}

	/**
	 * @param waggonTyp : Object
	 * @param ankoppeln : boolean
	 * <br><br>
	 * Fuehrt die Wagen-Kopplung durch und gibt bei Fehler eine Meldung in der Console aus
	 */
	public void koppeln(Object waggonTyp, boolean ankoppeln){
		if((waggonTyp instanceof Gueterwaggon)||(waggonTyp instanceof Kippwaggon)||(waggonTyp instanceof Personenwaggon)||(waggonTyp instanceof Viehwaggon)){
			if (this.lokStatus == STATUS_HAELT) {
				if(ankoppeln==true){
					if (!this.waggons.contains(waggonTyp))
						this.waggons.add(waggonTyp);
				}else{
					this.waggons.remove(waggonTyp);
				}
			} else {
				System.out.println("Fehler: Waggons koennen nur gekoppelt werden, wenn die Lok steht!");
			}
		}		
	}

	/**
	 * @param name : String
	 * @param lokfuehrerId : String
	 * @param lokfuehrerSeit : Date
	 * <br><br>
	 * Diese Methode luesst einen Lokfuehrer in einen Zug einsteigen
	 */
	public void lokfuehrerSteigtEin(String name, String lokfuehrerId, Date lokfuehrerSeit) {
		this.lokfuehrerName = name;
		this.lokfuehrerId = lokfuehrerId;
		this.lokfuehrerSeit = lokfuehrerSeit;
	}

	/**
	 * Diese Methode luesst einen Lokfuehrer aus dem Zug aussteigen
	 */
	public void lokfuehrerSteigtAus() {
		this.lokfuehrerName = null;
		this.lokfuehrerId = null;
		this.lokfuehrerSeit = null;
	}
	
	/**
	 * @return <b>zugkraftKg</b> : float
	 * <br><br>
	 * Gibt die Zugkraft des Zuges zurueck
	 */
	public float getZugkraftKg() {
		return this.zugkraftKg;
	}

	/**
	 * @return <b>lokfuehrerName</b> : String
	 * <br><br>
	 * Gibt den Namen des Lokfuehrers zurueck
	 */
	public String getLokfuehrerName() {
		return this.lokfuehrerName;
	}

}
