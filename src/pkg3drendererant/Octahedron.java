package pkg3drendererant;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class Octahedron {
    protected List<Triangle> triangles;
    
    public Octahedron() {
        this.triangles = new ArrayList<>();
    }
    
    public List<Triangle> getShape() {
        // Top vertex of the Octahedron
        Vertex top = new Vertex(0, 100, 0);
        // Bottom vertex of the Octahedron
        Vertex bottom = new Vertex(0, -100, 0);
        // 4 middle vertices of the Octahedron
        Vertex v1 = new Vertex(100, 0, 0);
        Vertex v2 = new Vertex(0, 0, 100);
        Vertex v3 = new Vertex(-100, 0, 0);
        Vertex v4 = new Vertex(0, 0, -100);

        // 8 triangles of the octahedron
        triangles.add(new Triangle(top, v1, v2, Color.WHITE));
        triangles.add(new Triangle(top, v2, v3, Color.RED));
        triangles.add(new Triangle(top, v3, v4, Color.GREEN));
        triangles.add(new Triangle(top, v4, v1, Color.BLUE));

        triangles.add(new Triangle(bottom, v1, v2, Color.YELLOW));
        triangles.add(new Triangle(bottom, v2, v3, Color.CYAN));
        triangles.add(new Triangle(bottom, v3, v4, Color.MAGENTA));
        triangles.add(new Triangle(bottom, v4, v1, Color.ORANGE));

        return triangles;
    }
}
