package wino;

import java.text.DecimalFormat;

public class FruitWine extends Wine {

	private double fruitMass; //[kg]
	private Fruit fruit;
	private double waterVolume; //[l]
	private double citricAcidMass; //[g]

	FruitWine(Input input, Options options){
		super(input, options);
		fruit = input.getFruit();
		if (options.isCarboyChecked == true){
			fruitMass = calcFruitMass();
			
		}
		if (options.isFruitsChecked == true){
			fruitMass = input.getFruitMass();
			wineVolume = fruitMass * (1 - fruit.getLoss()/100.0);
			carboyVolume = calcCarboyVolume();
		}
		sugarMass = calcSugarMass();
		waterVolume = calcWaterVolume();
		citricAcidMass = calcCitricAcidMass();
		
	}

	/*
	protected double calcWineVolume(){
		return fruitMass * (1 - fruit.getLoss()/100.0);
	}
	 */

	private double calcFruitMass(){
		return wineVolume / (1.0 - fruit.getLoss()/100.0);
	}

	private double calcSugarMass(){
		double sugarMass = 0.0;
		double sugarMassPerLitre = alcoholContent*16.0 - fruit.getSugarContent();
		if (sugarMassPerLitre > 0.0){
			sugarMass = wineVolume * sugarMassPerLitre / 1000;
		}
		return sugarMass;
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
		DecimalFormat df = new DecimalFormat("####0.00");
		return this.fruit.getType() +", "
				+"balon: "+df.format(carboyVolume)+" l, "
				+"moc wina: "+df.format(alcoholContent)+" %, "
				+"objêtoœæ wina: "+df.format(wineVolume)+" l, "
				+"masa owoców: "+df.format(fruitMass)+" kg, "
				+"masa cukru: "+df.format(sugarMass)+" kg, "
				+"objêtoœæ wody: "+df.format(waterVolume)+" l, "
				+"masa kwasku cytrynowego: "+df.format(citricAcidMass)+" g";	
	}


}
