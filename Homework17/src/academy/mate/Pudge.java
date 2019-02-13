package academy.mate;

import java.awt.Image;
import java.io.Serializable;

public class Pudge implements Serializable{

	private String strHello;
	private String strNation;
	private String strDrink;


	public Pudge() {

	}

	public String getStrHello() {
		return strHello;
	}

	public void setStrHello(String strHello) {
		this.strHello = strHello;
	}

	public String getStrNation() {
		return strNation;
	}

	public void setStrNation(String strNation) {
		this.strNation = strNation;
	}

	public String getStrDrink() {
		return strDrink;
	}

	public void setStrDrink(String strDrink) {
		this.strDrink = strDrink;
	}


}
