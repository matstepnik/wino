package wino;

import java.util.ArrayList;

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
		parseFruit();
		getFruitsItems();
		
		
		addTextfield();
		addDropdownList();
	}
	
	public void draw(){
		surface.setTitle(mouseX + ", " + mouseY);
		background(100);
		//fill(255);
		 // text(cp5.get(Textfield.class, "textInput_1").getText(), 360, 130);
		//  text(textValue, 360, 180);
		//  System.out.println(cp5.get(Textfield.class, "textInput_1").getText());
	}
	
	private void addTextfield(){
		Textfield tf_carboyVolume = cp5.addTextfield("objetosc balonu")
				.setPosition(20, 100);
		customizeTextfield(tf_carboyVolume);
		Textfield tf_alcoholContent = cp5.addTextfield("moc wina")
				.setPosition(20, 170);
		customizeTextfield(tf_alcoholContent);
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
	
	private void addDropdownList(){
		DropdownList ddl_fruitType = cp5.addDropdownList("rodzaj owocow")
				.setPosition(20, 240);
		customizeDropdownList(ddl_fruitType);
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
