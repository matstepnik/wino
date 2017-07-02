package wino;

import controlP5.ControlP5;
import controlP5.DropdownList;
import controlP5.Slider;
import controlP5.Textfield;
import processing.data.JSONArray;

public class Input {

	private double carboyVolume;
	private double alcoholContent;
	private Fruit fruit;
	
	JSONArray fruits;
	String[] fruitsTypes;
	
	private Textfield tf_carboyVolume, tf_alcoholContent;
	private Slider s_alcoholContent;
	private DropdownList ddl_fruitType;
	private App p;
	private int x, y;
	private int width, height;
	
	Input(App p){
		this.p = p;
		parseFruit();
		getFruitsItems();
	}
	
	public void setup(){
		x = Settings.MARGIN;
		y = 250;
		width = p.width-2*Settings.MARGIN;
		height = 100;
		
		addTextfield();
		addDropdownList();
		addSlider();
	}
	
	public void draw(){
		p.pushStyle();
		p.stroke(0);
		p.fill(Settings.FILL_BOX);
		p.rect(x, y, width, height);
		
		p.textSize(20);
		p.fill(Settings.FILL_TEXT);
		p.text("Jakie wino planujesz?", x, y-10);
		p.popStyle();
	}
	
	private void addTextfield(){
		tf_carboyVolume = p.cp5.addTextfield("carboyVolume")
				.setPosition(p.getOptions().getX()+80, p.getOptions().getY()+45); //TODO uzale¿niæ od wspó³rzêdnych Options
		customizeTextfield(tf_carboyVolume);
		/*
		tf_alcoholContent = p.cp5.addTextfield("alcoholContent")
				.setPosition(x+width/3, y+20);
		customizeTextfield(tf_alcoholContent);
		*/
	}
	
	private void addSlider(){
		s_alcoholContent = p.cp5.addSlider("alcoholContent")
				.setPosition(x+width/3, y+20);
		customizeSlider(s_alcoholContent);
	}
	
		private void customizeSlider(Slider s){
		s.setSize(150, Settings.SIZE_CONTROLER)
		.setRange(8, 18)
		.setNumberOfTickMarks(21)
		.setDecimalPrecision(1)
	    .setSliderMode(Slider.FLEXIBLE) 
		.shuffle()
		.setLabel("%")
		;
	}

	private void addDropdownList(){
		ddl_fruitType = p.cp5.addDropdownList("fruits")
				.setPosition(x, y+20);
		customizeDropdownList(ddl_fruitType);
	}
	
	private void customizeTextfield(Textfield tf){
		tf.setSize(60, Settings.SIZE_CONTROLER)
		//.setFocus(true)
		.setColor(p.color(255, 0, 0))
		.setAutoClear(false)
		.setLabel("litrów")
		//.setLabelVisible(false)
		.getCaptionLabel().align(ControlP5.RIGHT_OUTSIDE, ControlP5.CENTER)
		;
	}

	private void customizeDropdownList(DropdownList ddl){
		ddl
		.setSize(200, 5*Settings.SIZE_CONTROLER)
		.setItemHeight(Settings.SIZE_CONTROLER)
		.setBarHeight(Settings.SIZE_CONTROLER)
		.close()
		.setLabel("Rodzaj owoców")
		//.getCaptionLabel().getStyle().marginTop = 3
		//.getCaptionLabel().getStyle().marginLeft = 3
		//.getValueLabel().getStyle().marginTop = 3
		//.addItem("Image One", 0)
		//.addItem("Image Two", 1)
		.addItems(fruitsTypes)
		//.setColorBackground(color(60))
		//.setColorActive(color(255,128))
		//.setBackgroundColor(color(190))
		;
	}
	
	public void addInput(){
		//TODO handle exceptions
		String carboyVolume_str = p.cp5.get(Textfield.class, "carboyVolume").getText();
		carboyVolume = Double.parseDouble(carboyVolume_str.replaceAll(",", "."));
		
		alcoholContent = p.cp5.get(Slider.class, "alcoholContent").getValue();
		
		int fruitTypeIndex = (int) p.cp5.get(DropdownList.class, "fruits").getValue();
		fruit = new Fruit(fruits, fruitsTypes[fruitTypeIndex]);
		
	}
	
	private void parseFruit(){
		String fileName = "fruits.json";
		fruits = p.loadJSONArray(fileName);
	}

	private void getFruitsItems(){
		fruitsTypes = new String[fruits.size()];
		for (int i=0; i<fruits.size(); i++){
			String fruitType = fruits.getJSONObject(i).getString("type");
			fruitsTypes[i] = fruitType;
		}
	}
	
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
