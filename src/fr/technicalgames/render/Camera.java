package fr.technicalgames.render;
import static org.lwjgl.glfw.GLFW.*;

import org.lwjgl.glfw.*;
import org.lwjgl.opengl.*;

import fr.technicalgames.*;
import fr.technicalgames.input.*;
import fr.technicalgames.math.*;



public class Camera {

	public static Matrix4f matrix = new Matrix4f();
	public static final float SPEED = 1.0f;
	public static final float sens = 0.5f;
	public static float speed = 1.0f;


	
	public static Vector3f rot = new Vector3f();
	public static Vector3f pos = new Vector3f();
	
	public static void update(){
		speed = SPEED * Main.delta;
		if(Input.isKey(GLFW_KEY_LEFT_CONTROL))speed *= 2.0f;
		rot.x += -Input.getDMouse().getY() * sens;
		rot.y += -Input.getDMouse().getX() * sens;
		if(rot.x > 90)rot.x = 90;
		if(rot.x < -90)rot.x = -90;
		if(Input.isKey(GLFW.GLFW_KEY_W)){
			pos.x += Mathf.cos(Mathf.toRadians(rot.y + 90)) * speed;
			pos.z += Mathf.sin(Mathf.toRadians(rot.y + 90)) * speed;
		}
		if(Input.isKey(GLFW.GLFW_KEY_S)){
			pos.x += -Mathf.cos(Mathf.toRadians(rot.y + 90)) * speed;
			pos.z += -Mathf.sin(Mathf.toRadians(rot.y + 90)) * speed;
		}
		if(Input.isKey(GLFW.GLFW_KEY_A)){
			pos.x += -Mathf.cos(Mathf.toRadians(rot.y)) * speed;
			pos.z += -Mathf.sin(Mathf.toRadians(rot.y)) * speed;
		}
		if(Input.isKey(GLFW.GLFW_KEY_D)){
			pos.x += Mathf.cos(Mathf.toRadians(rot.y)) * speed;
			pos.z += Mathf.sin(Mathf.toRadians(rot.y)) * speed;
		}
		if(Input.isKey(GLFW.GLFW_KEY_LEFT_SHIFT)){
			pos.y -= speed;
		}
		if(Input.isKey(GLFW.GLFW_KEY_SPACE)){
			pos.y += speed;
		}
		if(Input.isKeyDown(GLFW_KEY_ESCAPE))glfwSetWindowShouldClose(Main.windowID, GL11.GL_TRUE);
		if(Input.isButtonDown(0))glfwSetInputMode(Main.windowID, GLFW_CURSOR, GLFW_CURSOR_DISABLED);
		if(Input.isButtonDown(1))glfwSetInputMode(Main.windowID, GLFW_CURSOR, GLFW_CURSOR_NORMAL);
	}
	
	public static void transform(){
		matrix.loadIdentity();
		matrix.rotate(new Quaternion(new Vector3f(1,0,0),rot.x));
		matrix.rotate(new Quaternion(new Vector3f(0,1,0),rot.y));
		matrix.rotate(new Quaternion(new Vector3f(0,0,1),rot.z));
		matrix.tranlate(-pos.x, -pos.y, -pos.z);
	}
	
}
