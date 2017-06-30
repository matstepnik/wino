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
}
