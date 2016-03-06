package fr.technicalgames.material;

import fr.technicalgames.math.*;

public abstract class Material {

	public float shininess;
	public Vector3f specularColor;
	
	public Material(float shininess,Vector3f specularColor){
		this.shininess = shininess;
		this.specularColor = specularColor;
	}

	public float getShininess() {
		return shininess;
	}

	public void setShininess(float shininess) {
		this.shininess = shininess;
	}

	public Vector3f getSpecularColor() {
		return specularColor;
	}

	public void setSpecularColor(Vector3f specularColor) {
		this.specularColor = specularColor;
	}
	
}
