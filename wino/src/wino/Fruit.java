package wino;

import processing.core.PApplet;
import processing.data.*;

public class Fruit {

	private String type;
	private double loss;
	private double sugarContent;
	private double acidContent;
	
	Fruit(JSONArray fruits, String type){
		this.type = type;
		for (int i=0; i<fruits.size(); i++){
			JSONObject fruit = fruits.getJSONObject(i);
			if (fruit.getString("type").equals(type)){
				loss = fruit.getDouble("loss");
				sugarContent = fruit.getDouble("sugar");
				acidContent = fruit.getDouble("acid");
			}
		}
	}
	
	
	
	public String getType(){
		return type;
	}
	
	public double getLoss(){
		return loss;
	}
	
	public double getSugarContent(){
		return sugarContent;
	}
	
	public double getAcidContent(){
		return acidContent;
	}
}
