package fr.technicalgames.light;
import fr.technicalgames.math.*;

public abstract class Light {

	public Vector4f position;//w == 0 si c une directional light
	public Vector3f intensities;
	public float attenuation;
    public float ambientCoefficient;
    public float coneAngle;
    public Vector3f  coneDirection;
    
    public Light(Vector4f position,Vector3f intensities,float attenuation,float ambientCoefficient,float coneAngle,Vector3f coneDirection){
    	this.position = position;
    	this.intensities = intensities;
    	this.attenuation = attenuation;
    	this.ambientCoefficient = ambientCoefficient;
    	this.coneAngle = coneAngle;
    	this.coneDirection = coneDirection;
    }
    
    public abstract void update();

	public Vector4f getPosition() {
		return position;
	}

	public void setPosition(Vector4f position) {
		this.position = position;
	}

	public Vector3f getIntensities() {
		return intensities;
	}

	public void setIntensities(Vector3f intensities) {
		this.intensities = intensities;
	}

	public float getAttenuation() {
		return attenuation;
	}

	public void setAttenuation(float attenuation) {
		this.attenuation = attenuation;
	}

	public float getAmbientCoefficient() {
		return ambientCoefficient;
	}

	public void setAmbientCoefficient(float ambientCoefficient) {
		this.ambientCoefficient = ambientCoefficient;
	}

	public float getConeAngle() {
		return coneAngle;
	}

	public void setConeAngle(float coneAngle) {
		this.coneAngle = coneAngle;
	}

	public Vector3f getConeDirection() {
		return coneDirection;
	}

	public void setConeDirection(Vector3f coneDirection) {
		this.coneDirection = coneDirection;
	}
    
    
	
}
