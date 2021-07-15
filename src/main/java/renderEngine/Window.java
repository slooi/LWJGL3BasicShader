package renderEngine;

import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWVidMode;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GLUtil;
import org.lwjgl.opengl.KHRDebug;
import org.lwjgl.system.Callback;

public class Window {
    long windowHandle;
    Callback debugCallback;

    public Window(){
        // Init
        if(!GLFW.glfwInit()){
            throw new IllegalStateException("ERROR: GLFW.glfwInit()");
        }

        // 6 Hint
        // Hint context
        GLFW.glfwWindowHint(GLFW.GLFW_CONTEXT_VERSION_MAJOR,3);
        GLFW.glfwWindowHint(GLFW.GLFW_CONTEXT_VERSION_MINOR,2);
        // Hint profile & forward compat
        GLFW.glfwWindowHint(GLFW.GLFW_OPENGL_PROFILE,GLFW.GLFW_OPENGL_CORE_PROFILE);
        GLFW.glfwWindowHint(GLFW.GLFW_OPENGL_FORWARD_COMPAT,GLFW.GLFW_TRUE);    // Find out what happens when T/F $%^$%^
        // Hint display & debug
        GLFW.glfwWindowHint(GLFW.GLFW_VISIBLE,GLFW.GLFW_FALSE);
        GLFW.glfwWindowHint(GLFW.GLFW_OPENGL_DEBUG_CONTEXT,GLFW.GLFW_TRUE);

        // Create Window
        windowHandle = GLFW.glfwCreateWindow(500,500,"ApprasialShader",0,0); //!@#!@#!@# could be wrong
        if(windowHandle == 0){
            throw new IllegalStateException("ERROR: GLFW.glfwCreateWindow()");
        }

        // Context and Capabilities
        GLFW.glfwMakeContextCurrent(windowHandle); // !@#!@#!@# might be wrong
        GL.createCapabilities();

        // Debuger
        GL11.glEnable(KHRDebug.GL_DEBUG_OUTPUT_SYNCHRONOUS);
        debugCallback = GLUtil.setupDebugMessageCallback();

        // Window position
        GLFWVidMode vidMode = GLFW.glfwGetVideoMode(GLFW.glfwGetPrimaryMonitor());
        GLFW.glfwSetWindowPos(windowHandle,vidMode.width()/2,vidMode.height()/2);

        // Show
        GLFW.glfwShowWindow(windowHandle);
    }

    public void terminate(){
        GLFW.glfwTerminate();
    }


//  GETTERS
    public long getWindowHandle() {
        return windowHandle;
    }


}
