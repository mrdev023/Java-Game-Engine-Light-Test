package fr.technicalgames.render;

import static org.lwjgl.opengl.GL11.*;

import fr.technicalgames.*;
import fr.technicalgames.math.*;

public class DisplayManager {

	public static Matrix4f projection = new Matrix4f();
	
	public static void clear(){
	    glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
	}
	
	public static void preRender2D(){
		projection.loadIdentity();
		projection.Ortho2D(0, Main.WIDTH, 0, Main.HEIGHT, -1, 1);
		glEnable(GL_DEPTH_TEST);
	    glDepthFunc(GL_LESS);
	    glEnable(GL_BLEND);
	    glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
	}
	
	public static void preRender3D(){
		projection.loadIdentity();
		projection.perspective(50.0f, (float)Main.WIDTH/(float)Main.HEIGHT, 0.1f,100.0f);
		glEnable(GL_DEPTH_TEST);
	    glDepthFunc(GL_LESS);
	    glEnable(GL_BLEND);
	    glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
	}
	
	public static void preRenderGUI(){
		projection.loadIdentity();
		projection.Ortho2D(0, Main.WIDTH, 0, Main.HEIGHT, -1, 1);
		glEnable(GL_DEPTH_TEST);
	    glDepthFunc(GL_LESS);
	    glEnable(GL_BLEND);
	    glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
	}
	
	public static void render2D(){
		Main.game.render2D();
	}
	
	public static void render3D(){
		Main.game.render3D();
	}
	
	public static void renderGUI(){
		Main.game.renderGUI();
	}
	
}
