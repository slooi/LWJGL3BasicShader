package renderEngine;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL30;

import java.util.ArrayList;
import java.util.List;

public class Renderer {
    public void render(Model model){
        // Enable
        GL30.glBindVertexArray(model.getVao());
        GL30.glEnableVertexAttribArray(0); // !@#!@#!@

        // Render
//        GL11.glDrawArrays(GL11.GL_TRIANGLES,0,model.getVertexCount());
        GL11.glDrawElements(GL11.GL_TRIANGLES,model.getVertexCount(),GL11.GL_UNSIGNED_INT,0);

        // Clean up
        GL30.glDisableVertexAttribArray(0);
        GL30.glBindVertexArray(0);
    }
    public void clear(){
        GL11.glClearColor(0.3f,0.9f,0.7f,1.0f);
        GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);
    }


}
