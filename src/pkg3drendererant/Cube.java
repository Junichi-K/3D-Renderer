
package pkg3drendererant;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class Cube {
    protected List<Triangle> triangles;
    
    public Cube() {
        this.triangles = new ArrayList<>();
    }
    
    public List<Triangle> getShape() {
        // Front face
        triangles.add(new Triangle(new Vertex(100, 100, 100),
                                   new Vertex(-100, 100, 100),
                                   new Vertex(-100, -100, 100),
                                   Color.WHITE));
        triangles.add(new Triangle(new Vertex(100, 100, 100),
                                   new Vertex(-100, -100, 100),
                                   new Vertex(100, -100, 100),
                                   Color.WHITE));

        // Back face
        triangles.add(new Triangle(new Vertex(100, 100, -100),
                                   new Vertex(100, -100, -100),
                                   new Vertex(-100, -100, -100),
                                   Color.RED));
        triangles.add(new Triangle(new Vertex(100, 100, -100),
                                   new Vertex(-100, -100, -100),
                                   new Vertex(-100, 100, -100),
                                   Color.RED));

        // Left face
        triangles.add(new Triangle(new Vertex(-100, 100, 100),
                                   new Vertex(-100, 100, -100),
                                   new Vertex(-100, -100, -100),
                                   Color.GREEN));
        triangles.add(new Triangle(new Vertex(-100, 100, 100),
                                   new Vertex(-100, -100, -100),
                                   new Vertex(-100, -100, 100),
                                   Color.GREEN));

        // Right face
        triangles.add(new Triangle(new Vertex(100, 100, 100),
                                   new Vertex(100, -100, 100),
                                   new Vertex(100, -100, -100),
                                   Color.BLUE));
        triangles.add(new Triangle(new Vertex(100, 100, 100),
                                   new Vertex(100, -100, -100),
                                   new Vertex(100, 100, -100),
                                   Color.BLUE));

        // Top face
        triangles.add(new Triangle(new Vertex(100, 100, 100),
                                   new Vertex(100, 100, -100),
                                   new Vertex(-100, 100, -100),
                                   Color.YELLOW));
        triangles.add(new Triangle(new Vertex(100, 100, 100),
                                   new Vertex(-100, 100, -100),
                                   new Vertex(-100, 100, 100),
                                   Color.YELLOW));

        // Bottom face
        triangles.add(new Triangle(new Vertex(100, -100, 100),
                                   new Vertex(-100, -100, 100),
                                   new Vertex(-100, -100, -100),
                                   Color.CYAN));
        triangles.add(new Triangle(new Vertex(100, -100, 100),
                                   new Vertex(-100, -100, -100),
                                   new Vertex(100, -100, -100),
                                   Color.CYAN));

        return triangles;
    }
}
