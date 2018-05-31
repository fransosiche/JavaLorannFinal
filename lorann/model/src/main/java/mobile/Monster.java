package mobile;

import java.io.IOException;

import element.Element;
import model.Permeability;
import model.Sprite;

public class Monster extends Element {

	public Monster(Sprite sprite, Permeability permeability) throws IOException {
		super(sprite, Permeability.MONSTER);
		sprite = new Sprite(' ', "ground.png");
	}

}
