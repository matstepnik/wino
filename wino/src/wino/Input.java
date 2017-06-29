package wino;

public class Input {

	private double carboyVolume;
	private double alcoholContent;
	private Fruit fruit;
	
	/*
	Input(double carboyVolume, double alcoholContent, String fruitType){
		this.carboyVolume = carboyVolume;
		this.alcoholContent = alcoholContent;
		this.fruitType = fruitType;
	}*/
	
	public double getCarboyVolume() {
		return carboyVolume;
	}
	public void setCarboyVolume(double carboyVolume) {
		this.carboyVolume = carboyVolume;
	}
	public double getAlcoholContent() {
		return alcoholContent;
	}
	public void setAlcoholContent(double alcoholContent) {
		this.alcoholContent = alcoholContent;
	}
	
	public Fruit getFruit() {
		return fruit;
	}
	public void setFruit(Fruit fruit) {
		this.fruit = fruit;
	}
}
