package wino;



public class Output {

	private App p;
	private int x, y;
	private int width, height;
	
	Output(App p){
		this.p = p;
	}
	
	public void setup(){
		x = Settings.MARGIN;
		y = 400;
		width = p.width-2*Settings.MARGIN;
		height = 180;
	}
	
	public void draw(){
		p.pushStyle();
		p.stroke(0);
		p.fill(Settings.FILL_BOX);
		p.rect(x, y, width, height);
		
		p.textSize(20);
		p.fill(Settings.FILL_TEXT);
		p.text(p.wine.toString(), x, y, width, height);
		p.popStyle();
	}
}
