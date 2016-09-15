package fr.technicalgames.game;

import java.util.*;

import fr.technicalgames.light.*;
import fr.technicalgames.render.*;

public abstract class Game {

	public static ArrayList<Asset> assets = new ArrayList<Asset>();
	public static ArrayList<Light> lights = new ArrayList<Light>();
	
	public Game(){
		init();
		System.out.println(this.getClass().getSimpleName() + " loaded with " + assets.size() + " assets and with " + lights.size() + " lights !");
	}
	
	public abstract void init();
	public abstract void update();
	public abstract void render2D();
	public abstract void render3D();
	public abstract void renderGUI();
	public abstract void destroy();
	
	
}
