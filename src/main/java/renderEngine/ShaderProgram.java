package renderEngine;

import org.lwjgl.opengl.GL30;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public abstract class ShaderProgram {
    int programId;

    ShaderProgram(String vsFile, String fsFile){
        // Create Program
        programId = GL30.glCreateProgram();
        GL30.glAttachShader(programId,buildShader(vsFile,GL30.GL_VERTEX_SHADER));
        System.out.println("Vertex shader compiled successfully");
        GL30.glAttachShader(programId,buildShader(fsFile,GL30.GL_FRAGMENT_SHADER));
        System.out.println("Fragment shader compiled successfully");
        GL30.glLinkProgram(programId);
        GL30.glValidateProgram(programId);

        // Check
        if(GL30.glGetProgrami(programId,GL30.GL_LINK_STATUS) == 0){
            System.err.println("ERROR: linking program. Info: "+GL30.glGetProgramInfoLog(programId));
            System.exit(-1);
        }
        if(GL30.glGetProgrami(programId,GL30.GL_VALIDATE_STATUS) == 0){
            System.err.println("ERROR: validating program. Info:" +GL30.glGetProgramInfoLog(programId));
            System.exit(-1);
        }
    }

    //
    void bindAttributeLocation(int location,String attributeName){
        GL30.glBindAttribLocation(programId,location,attributeName);
    }


    // abstract
    abstract void bindAttributeLocations();



//    START & STOP
    public void startProgram(){
        GL30.glUseProgram(programId);
    }
    public void stopProgram(){
        GL30.glUseProgram(0);
    }



//    HELPER FUNCTIONS

    // Creating shaders
    private int buildShader(String shaderFile, int shaderType){
        // Create shader
        int shader = GL30.glCreateShader(shaderType);
        GL30.glShaderSource(shader,getShaderSource(shaderFile));
        GL30.glCompileShader(shader);

        // Check
        if(GL30.glGetShaderi(shader,GL30.GL_COMPILE_STATUS) == 0){
            System.err.println("ERROR: compiling shader. Info: "+GL30.glGetShaderInfoLog(shader));
            System.exit(-1);
        }

        return shader;
    }

    // Reading shader files
    private String getShaderSource(String shaderFile){
        StringBuilder stringBuilder = new StringBuilder();
        String line;
        try(BufferedReader reader= new BufferedReader(new FileReader(shaderFile))){
            while((line = reader.readLine())!=null){
                stringBuilder.append(line+"\n");
            }
        }catch(IOException e){
            e.printStackTrace();
            System.exit(-1);
        }

        return stringBuilder.toString();
    }

}
