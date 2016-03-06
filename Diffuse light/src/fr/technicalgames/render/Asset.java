package fr.technicalgames.render;
import java.nio.*;
import java.util.*;

import org.lwjgl.*;
import org.lwjgl.opengl.*;

import fr.technicalgames.light.*;
import fr.technicalgames.material.*;
import fr.technicalgames.math.*;

public class Asset {

	public int vbo,vao;
	public Texture texture;
	public Matrix4f transform;
	public Material material;
	private int size;
	
	public Asset(){
		texture = Texture.WOOD;
		transform = new Matrix4f();
		material = new DefaultMaterial();
		vao = GL30.glGenVertexArrays();
		vbo = GL15.glGenBuffers();
		float[] a = new float[]{
				//  X     Y     Z       U     V          Normal
		        // bottom
		        -1.0f,-1.0f,-1.0f,   0.0f, 0.0f,   0.0f, -1.0f, 0.0f,
		         1.0f,-1.0f,-1.0f,   1.0f, 0.0f,   0.0f, -1.0f, 0.0f,
		        -1.0f,-1.0f, 1.0f,   0.0f, 1.0f,   0.0f, -1.0f, 0.0f,
		         1.0f,-1.0f,-1.0f,   1.0f, 0.0f,   0.0f, -1.0f, 0.0f,
		         1.0f,-1.0f, 1.0f,   1.0f, 1.0f,   0.0f, -1.0f, 0.0f,
		        -1.0f,-1.0f, 1.0f,   0.0f, 1.0f,   0.0f, -1.0f, 0.0f,

		        // top
		        -1.0f, 1.0f,-1.0f,   0.0f, 0.0f,   0.0f, 1.0f, 0.0f,
		        -1.0f, 1.0f, 1.0f,   0.0f, 1.0f,   0.0f, 1.0f, 0.0f,
		         1.0f, 1.0f,-1.0f,   1.0f, 0.0f,   0.0f, 1.0f, 0.0f,
		         1.0f, 1.0f,-1.0f,   1.0f, 0.0f,   0.0f, 1.0f, 0.0f,
		        -1.0f, 1.0f, 1.0f,   0.0f, 1.0f,   0.0f, 1.0f, 0.0f,
		         1.0f, 1.0f, 1.0f,   1.0f, 1.0f,   0.0f, 1.0f, 0.0f,

		        // front
		        -1.0f,-1.0f, 1.0f,   1.0f, 0.0f,   0.0f, 0.0f, 1.0f,
		         1.0f,-1.0f, 1.0f,   0.0f, 0.0f,   0.0f, 0.0f, 1.0f,
		        -1.0f, 1.0f, 1.0f,   1.0f, 1.0f,   0.0f, 0.0f, 1.0f,
		         1.0f,-1.0f, 1.0f,   0.0f, 0.0f,   0.0f, 0.0f, 1.0f,
		         1.0f, 1.0f, 1.0f,   0.0f, 1.0f,   0.0f, 0.0f, 1.0f,
		        -1.0f, 1.0f, 1.0f,   1.0f, 1.0f,   0.0f, 0.0f, 1.0f,

		        // back
		        -1.0f,-1.0f,-1.0f,   0.0f, 0.0f,   0.0f, 0.0f, -1.0f,
		        -1.0f, 1.0f,-1.0f,   0.0f, 1.0f,   0.0f, 0.0f, -1.0f,
		         1.0f,-1.0f,-1.0f,   1.0f, 0.0f,   0.0f, 0.0f, -1.0f,
		         1.0f,-1.0f,-1.0f,   1.0f, 0.0f,   0.0f, 0.0f, -1.0f,
		        -1.0f, 1.0f,-1.0f,   0.0f, 1.0f,   0.0f, 0.0f, -1.0f,
		         1.0f, 1.0f,-1.0f,   1.0f, 1.0f,   0.0f, 0.0f, -1.0f,

		        // left
		        -1.0f,-1.0f, 1.0f,   0.0f, 1.0f,   -1.0f, 0.0f, 0.0f,
		        -1.0f, 1.0f,-1.0f,   1.0f, 0.0f,   -1.0f, 0.0f, 0.0f,
		        -1.0f,-1.0f,-1.0f,   0.0f, 0.0f,   -1.0f, 0.0f, 0.0f,
		        -1.0f,-1.0f, 1.0f,   0.0f, 1.0f,   -1.0f, 0.0f, 0.0f,
		        -1.0f, 1.0f, 1.0f,   1.0f, 1.0f,   -1.0f, 0.0f, 0.0f,
		        -1.0f, 1.0f,-1.0f,   1.0f, 0.0f,   -1.0f, 0.0f, 0.0f,

		        // right
		         1.0f,-1.0f, 1.0f,   1.0f, 1.0f,   1.0f, 0.0f, 0.0f,
		         1.0f,-1.0f,-1.0f,   1.0f, 0.0f,   1.0f, 0.0f, 0.0f,
		         1.0f, 1.0f,-1.0f,   0.0f, 0.0f,   1.0f, 0.0f, 0.0f,
		         1.0f,-1.0f, 1.0f,   1.0f, 1.0f,   1.0f, 0.0f, 0.0f,
		         1.0f, 1.0f,-1.0f,   0.0f, 0.0f,   1.0f, 0.0f, 0.0f,
		         1.0f, 1.0f, 1.0f,   0.0f, 1.0f,   1.0f, 0.0f, 0.0f
		};
		FloatBuffer buffer = BufferUtils.createFloatBuffer(a.length);
		buffer.put(a).flip();
		size = a.length/(3+2+3);
		GL30.glBindVertexArray(vao);
		GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, vbo);
		GL15.glBufferData(GL15.GL_ARRAY_BUFFER, buffer, GL15.GL_STATIC_DRAW);
		
		GL20.glEnableVertexAttribArray(Shaders.MAIN_LIGHT.getAttribLocation("vert"));
		GL20.glVertexAttribPointer(Shaders.MAIN_LIGHT.getAttribLocation("vert"), 3, GL11.GL_FLOAT, false, 8*4, 0);
		
		GL20.glEnableVertexAttribArray(Shaders.MAIN_LIGHT.getAttribLocation("vertTexCoord"));
		GL20.glVertexAttribPointer(Shaders.MAIN_LIGHT.getAttribLocation("vertTexCoord"), 2, GL11.GL_FLOAT, true, 8*4, 3*4);
		
		GL20.glEnableVertexAttribArray(Shaders.MAIN_LIGHT.getAttribLocation("vertNormal"));
		GL20.glVertexAttribPointer(Shaders.MAIN_LIGHT.getAttribLocation("vertNormal"), 3, GL11.GL_FLOAT, true, 8*4, 5*4);
		
		GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, 0);	
		GL30.glBindVertexArray(0);
	}
	
	public void render(ArrayList<Light> lights){
		Shaders.MAIN_LIGHT.bind();
		Shaders.MAIN_LIGHT.uniform("camera", Camera.matrix);
		Shaders.MAIN_LIGHT.uniform("transform", transform);
		Shaders.MAIN_LIGHT.uniform("projection", DisplayManager.projection);
		Shaders.MAIN_LIGHT.uniform("materialTex", 0); //set to 0 because the texture will be bound to GL_TEXTURE0
		Shaders.MAIN_LIGHT.uniform("materialShininess", material.shininess);
		Shaders.MAIN_LIGHT.uniform("materialSpecularColor", material.specularColor);
		Shaders.MAIN_LIGHT.uniform("numLights", lights.size());
		Shaders.MAIN_LIGHT.uniform("cameraPosition", Camera.pos);
		
		for(int i = 0;i < lights.size();i++){
			Shaders.MAIN_LIGHT.uniform("allLights["+i+"].position", lights.get(i).position);
			Shaders.MAIN_LIGHT.uniform("allLights["+i+"].intensities", lights.get(i).intensities);
			Shaders.MAIN_LIGHT.uniform("allLights["+i+"].attenuation", lights.get(i).attenuation);
			Shaders.MAIN_LIGHT.uniform("allLights["+i+"].ambientCoefficient", lights.get(i).ambientCoefficient);
			Shaders.MAIN_LIGHT.uniform("allLights["+i+"].coneAngle", lights.get(i).coneAngle);
			Shaders.MAIN_LIGHT.uniform("allLights["+i+"].coneDirection", lights.get(i).coneDirection);
		}
		
		GL13.glActiveTexture(GL13.GL_TEXTURE0);
		texture.bind();
		
		GL30.glBindVertexArray(vao);
		GL11.glDrawArrays(GL11.GL_TRIANGLES, 0, size);
		GL30.glBindVertexArray(0);
		texture.unbind();
		Shaders.MAIN_LIGHT.unbind();
	}
	
	public void destroy(){
		GL15.glDeleteBuffers(vbo);
		GL30.glBindVertexArray(vao);
		texture.destroy();
		transform = null;
	}
	
}
