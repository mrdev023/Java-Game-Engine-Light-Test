package fr.technicalgames.shadow;

import org.lwjgl.opengl.*;

public class Shadow {
	
	public static final int SIZE_OF_SHADOW_MAPPING = 1024;
	
	private int frameBuffer;
	private int depthTexture;
	private boolean success = false;

	public Shadow(){
		//Creer et selectionne le buffer
//		this.frameBuffer = GL30.glGenFramebuffers();
//		GL30.glBindFramebuffer(GL30.GL_FRAMEBUFFER, this.frameBuffer);
//		
//		//Creer la texture pour les ombres 
//		this.depthTexture = GL11.glGenTextures();
//		GL11.glBindTexture(GL11.GL_TEXTURE_2D, this.depthTexture);
//		GL11.glTexImage2D(GL11.GL_TEXTURE_2D, 0, GL14.GL_DEPTH_COMPONENT16,SIZE_OF_SHADOW_MAPPING,SIZE_OF_SHADOW_MAPPING,0,GL11.GL_DEPTH_COMPONENT,GL11.GL_FLOAT,0);
//		GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_NEAREST);
//		GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MIN_FILTER, GL11.GL_NEAREST);
//		GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_WRAP_S, GL12.GL_CLAMP_TO_EDGE);
//		GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_WRAP_T, GL12.GL_CLAMP_TO_EDGE);
//		
//		GL32.glFramebufferTexture(GL30.GL_FRAMEBUFFER, GL30.GL_DEPTH_ATTACHMENT, depthTexture, 0);
//		GL11.glDrawBuffer(GL11.GL_NONE);
//		GL11.glReadBuffer(GL11.GL_NONE);
//		if(GL30.glCheckFramebufferStatus(GL30.GL_FRAMEBUFFER) == GL30.GL_FRAMEBUFFER_COMPLETE){
//			success = true;
//		}else{
//			success = false;
//			System.err.println("Shadow not adding to light");
//		}
	}
	
	public void render(){
		
	}
	
	public void destroy(){
		if(this.frameBuffer != 0)GL30.glDeleteFramebuffers(this.frameBuffer);
		if(this.depthTexture != 0)GL11.glDeleteTextures(this.depthTexture);
	}

	public int getFrameBuffer() {
		return frameBuffer;
	}

	public void setFrameBuffer(int frameBuffer) {
		this.frameBuffer = frameBuffer;
	}

	public int getDepthTexture() {
		return depthTexture;
	}

	public void setDepthTexture(int depthTexture) {
		this.depthTexture = depthTexture;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}
	
	
	
}
