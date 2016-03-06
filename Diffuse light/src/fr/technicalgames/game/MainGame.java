package fr.technicalgames.game;

import fr.technicalgames.*;
import fr.technicalgames.light.*;
import fr.technicalgames.math.*;
import fr.technicalgames.render.*;

public class MainGame extends Game{
	
    private float value = 0;

	@Override
	public void init() {
		
	    lights.add(new SpotLight(new Vector3f(-4,0,10),new Vector3f(2,2,2),0.1f,0.0f,15.0f,new Vector3f(0,0,-1)));
	    lights.add(new DirectionalLight(new Vector3f(4,0,-10), new Vector3f(0.4f,0.3f,0.1f), 0.06f));
	    
	    
	    Asset as = new Asset();
	    as.transform = (new Matrix4f());
	    assets.add(as);
	    as = new Asset();
	    as.transform = (new Matrix4f()).tranlate(0, -4, 0).scale(1, 2, 1);
	    assets.add(as);
	    as = new Asset();
	    as.transform = (new Matrix4f()).tranlate(-8,0,0).scale(1, 6, 1);
	    assets.add(as);
	    as = new Asset();
	    as.transform = (new Matrix4f()).tranlate(-4,0,0).scale(1, 6, 1);
	    assets.add(as);
	    as = new Asset();
	    as.transform = (new Matrix4f()).tranlate(-6,0,0).scale(2,1,0.8f);
	    assets.add(as);
	    as = null;
	}

	@Override
	public void update() {
	    Camera.update();
	    Camera.transform();
		
	    lights.get(0).position.y = Mathf.cos(value) * 6f;
	    lights.get(0).position.x = Mathf.sin(value) * 3f - 4f;
	    value += Main.delta * 1.0f;
	}

	@Override
	public void render2D() {
		
	}

	@Override
	public void render3D() {
	    for(Asset a : assets){
	    	a.render(lights);
	    }
	}

	@Override
	public void renderGUI() {
		
	}

	@Override
	public void destroy() {
		for(Asset a : assets){
	    	a.destroy();
	    }
	}

}
