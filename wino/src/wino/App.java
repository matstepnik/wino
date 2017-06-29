package wino;

import java.util.ArrayList;

import controlP5.Button;
import controlP5.ControlEvent;
import controlP5.ControlP5;
import controlP5.DropdownList;
import controlP5.Textfield;
import processing.core.PApplet;
import processing.data.JSONArray;

public class App extends PApplet{

	ControlP5 cp5;
	JSONArray fruits;
	String[] fruitsTypes;
	Input input;
	Wine wine;
	boolean isCalculated;
	/*
	Textfield tf_carboyVolume;
	Textfield tf_alcoholContent;
	DropdownList ddl_fruitType;
	*/
	public static void main(String[] args) {
		PApplet.main("wino.App");
	}

	public void settings(){
		size(500,500);
	}
	
	public void setup(){
		cp5 = new ControlP5(this);
		input = new Input();
		parseFruit();
		getFruitsItems();
		
		
		addTextfield();
		addDropdownList();
		addButton();
	}
	
	public void draw(){
		surface.setTitle(mouseX + ", " + mouseY);
		background(100);
		
		if (isCalculated){
			fill(0);
			ellipse(100,100,100,100);
			stroke(0);
			text(String.valueOf(wine.getSugarMass()), 20, 400);
		}
	}
	
	
	
	
	private void addTextfield(){
		Textfield tf_carboyVolume = cp5.addTextfield("objetosc balonu")
				.setPosition(20, 100);
		customizeTextfield(tf_carboyVolume);
		Textfield tf_alcoholContent = cp5.addTextfield("moc wina")
				.setPosition(20, 170);
		customizeTextfield(tf_alcoholContent);
	}
	
	private void addDropdownList(){
		DropdownList ddl_fruitType = cp5.addDropdownList("fruits")
				.setPosition(20, 240);
		customizeDropdownList(ddl_fruitType);
	}
	
	private void addButton(){
		Button b_calculate = cp5.addButton("licz")
				.setPosition(300, 300);
	}
	
	private void customizeTextfield(Textfield tf){
		tf.setSize(200, 40)
		.setFont(createFont("arial", 20))
		.setFocus(true)
		.setColor(color(255, 0, 0))
		.setAutoClear(false)
		.getCaptionLabel().align(ControlP5.LEFT, ControlP5.TOP_OUTSIDE)
		;
	}
	
	private void customizeDropdownList(DropdownList ddl){
		//ddl.setBackgroundColor(color(190));
		ddl.setItemHeight(30);
		ddl.setBarHeight(30);
		ddl.close();
		ddl.getCaptionLabel().set("Rodzaj owocow");
		//ddl.getCaptionLabel().getStyle().marginTop = 3;
		//ddl.getCaptionLabel().getStyle().marginLeft = 3;
		//ddl.getValueLabel().getStyle().marginTop = 3;
		//ddl.addItem("Image One", 0);
		//ddl.addItem("Image Two", 1);
		ddl.addItems(fruitsTypes);
		//ddl.setColorBackground(color(60));
		//ddl.setColorActive(color(255,128));
	}
	
	
	public void licz(){
		addInput();
		calcWine();
		System.out.println(input.getFruit().getType()+" "
				+input.getAlcoholContent()+"% "
				+input.getCarboyVolume()+"l baniak");
		isCalculated = true;
	}
	
	private void addInput(){
		String carboyVolume_str = cp5.get(Textfield.class, "objetosc balonu").getText();
		double carboyVolume = Double.parseDouble(carboyVolume_str.replaceAll(",", "."));
		input.setCarboyVolume(carboyVolume);
		String alcoholContent_str = cp5.get(Textfield.class, "moc wina").getText();
		double alcoholContent = Double.parseDouble(alcoholContent_str.replaceAll(",", "."));
		input.setAlcoholContent(alcoholContent);
	}
	
	private void calcWine(){
		wine = new FruitWine(input.getCarboyVolume(), 
				input.getAlcoholContent(), 
				input.getFruit());
	}
	
	
	
	
	public void controlEvent(ControlEvent theEvent) {
		if (theEvent.isGroup()) {
			// not used in this sketch but has to be included
		} 
		else if(theEvent.isController()) {
			if (theEvent.getController().getName().equals("fruits")){
					int index = (int) theEvent.getController().getValue();
					Fruit fruit = new Fruit(fruits, fruitsTypes[index]);
					input.setFruit(fruit);
				}
			
		}
	}
	
	private void parseFruit(){
		String fileName = "fruits.json";
		fruits = this.loadJSONArray(fileName);
	}
	
	private void getFruitsItems(){
		fruitsTypes = new String[fruits.size()];
		for (int i=0; i<fruits.size(); i++){
			String fruitType = fruits.getJSONObject(i).getString("type");
			fruitsTypes[i] = fruitType;
		}
	}
	
}
