package main;

import org.lwjgl.glfw.GLFW;
import renderEngine.*;

public class Main {
    public static void main(String[] args){
        // Print
        System.out.println("Hello World!");

        // Window
        Window window = new Window();
        long windowHandle = window.getWindowHandle();

        // Renderer
        Renderer renderer = new Renderer();

        // Shader Program
        ShaderProgram staticShader = new StaticProgram();

        // Model
        float[] positions = {
                0.5f,0.5f,0.0f,
                -0.5f,0.5f,0.0f,
                -0.5f,-0.5f,0.0f,
                0.5f,-0.5f,0.0f
        };
        int[] indices = {
                0,1,2,
        };
        Model triangle = Loader.dataToModel(positions,indices);

        // Loop
        while(!GLFW.glfwWindowShouldClose(windowHandle)){
            // Poll
            GLFW.glfwPollEvents();

            // Render
            staticShader.startProgram();
            renderer.clear();
            renderer.render(triangle);
            staticShader.stopProgram();

            // Swap buffers
            GLFW.glfwSwapBuffers(windowHandle);
        }

        // Terminate
        window.terminate();
    }
}
