package wino;

public class FruitWine extends Wine {

	private double fruitMass; //[kg]
	private Fruit fruit;
	private double waterVolume; //[l]
	private double citricAcidMass; //[g]
	
	FruitWine(double carboyVolume, double alcoholContent, Fruit fruit){
		super(carboyVolume, alcoholContent);
		this.fruit = fruit;
		fruitMass = calcFruitMass();
		waterVolume = calcWaterVolume();
		citricAcidMass = calcCitricAcidMass();
		sugarMass = calcSugarMass();
	}
	
	private double calcFruitMass(){
		return wineVolume / (1.0 - fruit.getLoss()/100.0);
	}
	
	private double calcSugarMass(){
		return wineVolume*(alcoholContent*16.0 - fruit.getSugarContent());
	}
	
	private double calcCitricAcidMass(){
		return (8.0 - fruit.getAcidContent() / 2.0) * wineVolume;
	}
	
	private double calcWaterVolume(){
		return wineVolume / 2.0 - sugarMass * Wine.SUGAR_DENSITY;
	}
	
	public double getFruitMass() {
		return fruitMass;
	}

	public Fruit getFruit() {
		return fruit;
	}

	public double getWaterVolume() {
		return waterVolume;
	}

	public double getCitricAcidMass() {
		return citricAcidMass;
	}
	
	public String toString(){
		return this.fruit.getType() +", "
				+"balon: "+carboyVolume+" l, "
				+"moc wina: "+alcoholContent+" %, "
				+"objêtoœæ wina: "+wineVolume+" l, "
				+"masa owoców: "+fruitMass+" kg, "
				+"masa cukru: "+sugarMass+" kg, "
				+"objêtoœæ wody: "+waterVolume+" l, "
				+"masa kwasku cytrynowego: "+citricAcidMass+" g";	
	}


}
