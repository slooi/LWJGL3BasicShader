package renderEngine;

public class Model {
    private int vao;
    private int vertexCount;

    public Model(int vao, int vertexCount){
        this.vao = vao;
        this.vertexCount = vertexCount;
    }


    // GETTERS
    public int getVao() {
        return vao;
    }

    public int getVertexCount() {
        return vertexCount;
    }
}
