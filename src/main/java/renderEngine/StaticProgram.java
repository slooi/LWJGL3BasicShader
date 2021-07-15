package renderEngine;

public class StaticProgram extends ShaderProgram {

    public StaticProgram() {
        super("src/main/java/shaders/staticVS.txt", "src/main/java/shaders/staticFS.txt");
    }

    @Override
    void bindAttributeLocations() {
        super.bindAttributeLocation(0,"position");
    }
}
