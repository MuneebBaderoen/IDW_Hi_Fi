package cs.honours.idw;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class Main {
	public static void main(String[] args) {
		LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
		cfg.title = "Hi-fi_Prototype";
		cfg.useGL20 = true;
		cfg.width = 240;
		cfg.height = 400;
		
		new LwjglApplication(new PrototypeMain(), cfg);
	}
}
