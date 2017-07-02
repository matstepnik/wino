package wino;

import controlP5.RadioButton;

public class Options {

	private App p;
	private RadioButton rb_carboyOrFruits;
	private int x, y;
	private int width, height;
	
	Options(App p){
		this.p = p;
	}
	
	public void setup(){
		x = Settings.MARGIN;
		y = 100;
		width = p.width-2*Settings.MARGIN;
		height = 100;
		
		addRadioButton();
	}
	
	public void draw(){
		p.pushStyle();
		p.stroke(0);
		p.fill(Settings.FILL_BOX);
		p.rect(x, y, width, height);
		
		p.textSize(20);
		p.fill(Settings.FILL_TEXT);
		p.text("Wybierz drogê obliczeñ", x, y-10);
		p.popStyle();
	}
	
	private void addRadioButton(){
		rb_carboyOrFruits = p.cp5.addRadioButton("radio")
			.setPosition(x, y)
			.setSize(Settings.SIZE_CONTROLER, Settings.SIZE_CONTROLER)
			.setItemsPerRow(2)
			.setSpacingColumn(width/2)
			.addItem("Mam balon", 1)
			.addItem("Mam owoce/sok", 2);
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
}
