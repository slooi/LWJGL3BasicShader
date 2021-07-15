package renderEngine;

import org.lwjgl.opengl.GL30;

import java.util.ArrayList;
import java.util.List;

public class Loader {
    private static List<Integer> vaos = new ArrayList<Integer>();
    private static List<Integer> vbos = new ArrayList<Integer>();

    public static Model dataToModel(float[] data,int[] indices){
        // VAO
        int vao = GL30.glGenVertexArrays();
        GL30.glBindVertexArray(vao); // !@#!@#!@#
        vaos.add(vao);

        // vbo Indices
        int vboIndices = GL30.glGenBuffers();
        GL30.glBindBuffer(GL30.GL_ELEMENT_ARRAY_BUFFER,vboIndices);
        GL30.glBufferData(GL30.GL_ELEMENT_ARRAY_BUFFER,indices,GL30.GL_STATIC_DRAW);
        vbos.add(vboIndices);

        // vbo
        int vbo = GL30.glGenBuffers();
        GL30.glBindBuffer(GL30.GL_ARRAY_BUFFER,vbo);
        GL30.glBufferData(GL30.GL_ARRAY_BUFFER,data,GL30.GL_STATIC_DRAW);
        GL30.glVertexAttribPointer(0,3,GL30.GL_FLOAT,false,0,0);//!@#!@#!@# GL_FLOAT could be wrong
        GL30.glBindBuffer(GL30.GL_ARRAY_BUFFER,0);
        vbos.add(vbo);

        // Clean up
        GL30.glBindVertexArray(0);

        // Model
        int count = data.length;
        return new Model(vao,count);
    }
}
