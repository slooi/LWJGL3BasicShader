package renderEngine;

public class StaticProgram extends ShaderProgram {
    private static final String vsFile = "staticVS.txt";
    private static final String fsFile = "staticFS.txt";


    public StaticProgram() {
        super(vsFile, fsFile);
    }

    @Override
    void bindAttributeLocations() {
        super.bindAttributeLocation(0,"position");
    }
}
