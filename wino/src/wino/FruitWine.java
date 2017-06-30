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
		waterVolume = 30; //calcWaterVolume();
		citricAcidMass = 4; //calcCitricAcidMass();
		sugarMass = calcSugarMass();
	}
	
	private double calcFruitMass(){
		return wineVolume / (1 - fruit.getLoss()/100);
	}
	
	private double calcSugarMass(){
		return wineVolume*(alcoholContent*0.016 - fruit.getSugarContent());
	}
	
	private double calcCitricAcidMass(){
		return (8 - fruit.getAcidContent() / 2) * wineVolume;
	}
	
	private double calcWaterVolume(){
		return wineVolume / 2 - sugarMass * Wine.SUGAR_DENSITY;
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
