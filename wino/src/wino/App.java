package wino;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import controlP5.Button;
import controlP5.ControlP5;
import controlP5.Label;

import processing.core.PApplet;
import processing.core.PFont;
import processing.core.PImage;


public class App extends PApplet{

	private Options options;
	private Input input;
	private Output output;
	
	private PFont vesper;
	private PImage logo;
	private PImage info;
	private boolean overInfo;
	ControlP5 cp5;
	
	Wine wine;
	private boolean isCalculated;
	
	public static void main(String[] args) {
		PApplet.main("wino.App");
	}

	public void settings(){
		size(800,600);
	}

	public void setup(){
		
		vesper = createFont("font/VesperLibre-Regular.ttf", 32);
		Label.setUpperCaseDefault(false);
		cp5 = new ControlP5(this);
		cp5.setFont(vesper, 20);
		logo = loadImage("logo_lemag.png");
		info = loadImage("info.png");
		
		options = new Options(this);
		input = new Input(this);
		output = new Output(this);
		
		options.setup();
		input.setup();
		output.setup();
		
		addButton();
	}

	public void draw(){
		surface.setTitle(mouseX + ", " + mouseY);
		background(Settings.COLOR_BACKGROUND);
		addTitle();
		image(logo, Settings.MARGIN, 0);
		image(info, width-30-info.width, 30);
		
		options.draw();
		input.draw();
		
		if (isCalculated){
			output.draw();
		}
		
		if (overInfo){
			addInfo();
		}
	}

	private void addTitle(){
		pushStyle();
		fill(0);
		textFont(vesper);
		text("Kalkulator winiarski dla ka¿dego", logo.width+2*Settings.MARGIN, 50);
		popStyle();
	}
	
	private void addInfo(){
		pushStyle();
		fill(255);
		stroke(0);
		rect(width/2-200, 400, 400, 180);
		fill(0);
		textSize(15);
		textAlign(CENTER);
		textLeading(20);
		text("Twórcy:\nMateusz Stêpnik - kod\nTomasz i Kinga Wojtkowscy - wino"
				+ "\n\nIcon made by Freepik from www.flaticon.com is licensed by Creative Commons BY 3.0"
				+ "\n\nwww.centrumfermentacji.pl", width/2-200, 400, 400, 180);
		popStyle();
	}

	private void addButton(){
		Button b_calculate = cp5.addButton("calculate")
				.setPosition(360, 360);
		customizeButton(b_calculate);
	}
	
	private void customizeButton(Button b){
		b.setSize(100, Settings.SIZE_CONTROLER)
		.setLabel("Oblicz")
		.getCaptionLabel().align(ControlP5.CENTER, ControlP5.CENTER)
		;
	}

	public void calculate(){
		input.addInput();
		calcWine();
		isCalculated = true;
	}

	private void calcWine(){
		wine = new FruitWine(input.getCarboyVolume(), 
				input.getAlcoholContent(), 
				input.getFruit());
	}

	private boolean overRect(int x, int y, int width, int height)  {
		if (mouseX >= x && mouseX <= x+width && 
				mouseY >= y && mouseY <= y+height) {
			return true;
		} else {
			return false;
		}
	}

	public void mousePressed() {
		if (overRect(Settings.MARGIN, 0, logo.width, logo.height)) {
			openBrowser("http://www.centrumfermentacji.pl");
		}
	}
	
	public void mouseMoved(){
		if (overRect(width-30-info.width, 30, info.width, info.height)){
			overInfo = true;
		} else {
			overInfo = false;
		}
	}
	
	private void openBrowser(String url){
		if(Desktop.isDesktopSupported()){
			Desktop desktop = Desktop.getDesktop();
			try {
				desktop.browse(new URI(url));
			} catch (IOException | URISyntaxException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public Options getOptions() {
		return options;
	}
}