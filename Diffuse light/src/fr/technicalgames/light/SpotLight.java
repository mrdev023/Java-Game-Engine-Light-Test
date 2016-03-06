package fr.technicalgames.light;

import fr.technicalgames.math.*;

public class SpotLight extends Light{

	public SpotLight(Vector3f position, Vector3f intensities, float attenuation, float ambientCoefficient,
			float coneAngle, Vector3f coneDirection) {
		super(new Vector4f(position,1), intensities, attenuation, ambientCoefficient, coneAngle, coneDirection);
	}

	@Override
	public void update() {
		
	}

}
