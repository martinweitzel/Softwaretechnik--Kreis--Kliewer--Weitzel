public class Waggon {
	public int val;
	protected float fuegeHinzu(float gewichtKg, float gewichtVomGutKg, float maximalGewichtKg, String bezeichnungVomGut){
		if (gewichtKg + gewichtVomGutKg <= maximalGewichtKg) {
			gewichtKg += gewichtVomGutKg;
			if(bezeichnungVomGut!="Vieh")System.out.println(bezeichnungVomGut+" mit "+gewichtVomGutKg+"kg hinzugefuegt");
			return gewichtKg;
		} else {
			if(bezeichnungVomGut!="Vieh")System.out.println("Fehler: "+bezeichnungVomGut+" mit "+gewichtVomGutKg+"kg kann nicht hinzugefuegt werden, da das max. Gewicht ueberschritten werden wuerde!");
			return -1;
		}
	}
}