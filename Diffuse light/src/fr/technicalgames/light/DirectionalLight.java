package fr.technicalgames.light;

import fr.technicalgames.math.*;

public class DirectionalLight extends Light{

	public DirectionalLight(Vector3f position, Vector3f intensities,float ambientCoefficient) {
		super(new Vector4f(position,0), intensities, 1.0f, ambientCoefficient, 0.0f, new Vector3f());
	}

	@Override
	public void update() {
		
	}
	
	

}
