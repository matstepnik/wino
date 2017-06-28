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
		super.sugarMass = calcSugarMass();
	}
	
	double calcFruitMass(){
		return wineVolume / (1 - fruit.getLoss());
	}
	
	double calcSugarMass(){
		return wineVolume*(alcoholContent*0.016 - fruit.getSugarContent());
	}
	
	double calcCitricAcidMass(){
		return (8 - fruit.getAcidContent() / 2) * wineVolume;
	}
	
	double calcWaterVolume(){
		return wineVolume / 2 - sugarMass * Wine.SUGAR_DENSITY;
	}
	
	private double getFruitMass() {
		return fruitMass;
	}

	private Fruit getFruit() {
		return fruit;
	}

	private double getWaterVolume() {
		return waterVolume;
	}

	private double getCitricAcidMass() {
		return citricAcidMass;
	}


}
