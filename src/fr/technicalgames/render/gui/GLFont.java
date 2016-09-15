package fr.technicalgames.render.gui;

import java.awt.*;
import java.awt.image.*;
import java.nio.*;

public class GLFont {

	private Font font;
	private int textureFont;
	
	public GLFont(String name,int style,int size){
		this.font = new Font(name, style, size);
		
		
        
	}
	
	public GLFont(){
		this("Verdana",Font.BOLD,24);
	}
	
	
}
