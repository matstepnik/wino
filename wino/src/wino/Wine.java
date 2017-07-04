package wino;

public class Wine {

	protected double wineVolume; //[l]
	protected double carboyVolume; //[l]
	protected double sugarMass; //[kg]
	protected double alcoholContent; //[%]
	protected double yeastMass; //[g]
	protected double e224Mass; //[g]
	
	public static final double SUGAR_DENSITY = 0.625; //[kg/l]
	
	Wine(Input input, Options options){
		alcoholContent = input.getAlcoholContent();
		if (options.isCarboyChecked == true){
			carboyVolume = input.getCarboyVolume();
			wineVolume = 4.0 / 5.0 * carboyVolume;
		}
		if (options.isFruitsChecked == true){
						
		}
	}
	
	protected double calcCarboyVolume(){
		return 5.0 / 4.0 * wineVolume;
	}
	
	/*
	protected double calcWineVolume(){
		return 4.0 / 5.0 * carboyVolume;
	}
	*/
	
	public double getWineVolume(){
		return wineVolume;
	}
	
	public double getCarboyVolume(){
		return carboyVolume;
	}

	public double getSugarMass() {
		return sugarMass;
	}

	public double getAlcoholContent() {
		return alcoholContent;
	}

	public double getYeastMass() {
		return yeastMass;
	}

	public double getE224Mass() {
		return e224Mass;
	}
	
	public String toString(){
		return "balon: "+carboyVolume+" l, "
				+"moc wina: "+alcoholContent+" %, "
				+"objêtoœæ wina: "+wineVolume+" l";	
	}
}
