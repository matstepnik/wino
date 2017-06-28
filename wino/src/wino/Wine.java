package wino;

public class Wine {

	protected double wineVolume; //[l]
	protected double carboyVolume; //[l]
	protected double sugarMass; //[kg]
	protected double alcoholContent; //[%]
	protected double yeastMass; //[g]
	protected double e224Mass; //[g]
	
	public static final double SUGAR_DENSITY = 0.625; //[kg/l]
	
	Wine(double carboyVolume, double alcoholContent){
		this.carboyVolume = carboyVolume;
		this.alcoholContent = alcoholContent;
		wineVolume = calcWineVolume(carboyVolume);
	}
	
	private double calcWineVolume(double carboyVolume){
		return 4 / 5 * carboyVolume;
	}
	
	protected double getWineVolume(){
		return wineVolume;
	}
	
	protected double getCarboyVolume(){
		return carboyVolume;
	}

	protected double getSugarMass() {
		return sugarMass;
	}

	protected double getAlcoholContent() {
		return alcoholContent;
	}

	protected double getYeastMass() {
		return yeastMass;
	}

	protected double getE224Mass() {
		return e224Mass;
	}
}
