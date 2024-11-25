
package pkg3drendererant;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class Isocahedron {
    private List<Triangle> triangles;
    
    public Isocahedron() {
        this.triangles = new ArrayList<>();
    }
    
    public List<Triangle> getShape() {

        double t = 100 * (1.0 + Math.sqrt(5.0)) / 2.0;  // Golden ratio scaled by 100

        // Inner vertices (core structure, similar to icosahedron)
        Vertex v1 = new Vertex(-100,  t, 0);
        Vertex v2 = new Vertex( 100,  t, 0);
        Vertex v3 = new Vertex(-100, -t, 0);
        Vertex v4 = new Vertex( 100, -t, 0);
        Vertex v5 = new Vertex(0, -100,  t);
        Vertex v6 = new Vertex(0,  100,  t);
        Vertex v7 = new Vertex(0, -100, -t);
        Vertex v8 = new Vertex(0,  100, -t);
        Vertex v9 = new Vertex( t, 0, -100);
        Vertex v10 = new Vertex( t, 0,  100);
        Vertex v11 = new Vertex(-t, 0, -100);
        Vertex v12 = new Vertex(-t, 0,  100);

        // Outer "spike" vertices
        Vertex s1 = new Vertex(-200, 2 * t, 0);
        Vertex s2 = new Vertex(200, 2 * t, 0);
        Vertex s3 = new Vertex(-200, -2 * t, 0);
        Vertex s4 = new Vertex(200, -2 * t, 0);
        Vertex s5 = new Vertex(0, -200, 2 * t);
        Vertex s6 = new Vertex(0, 200, 2 * t);
        Vertex s7 = new Vertex(0, -200, -2 * t);
        Vertex s8 = new Vertex(0, 200, -2 * t);
        Vertex s9 = new Vertex(2 * t, 0, -200);
        Vertex s10 = new Vertex(2 * t, 0, 200);
        Vertex s11 = new Vertex(-2 * t, 0, -200);
        Vertex s12 = new Vertex(-2 * t, 0, 200);

        // Define triangles for the star-like polyhedron
        triangles.add(new Triangle(v1, v6, s1, Color.WHITE));
        triangles.add(new Triangle(v1, s1, v2, Color.RED));
        triangles.add(new Triangle(v1, v11, s1, Color.GREEN));
        triangles.add(new Triangle(v6, s1, v12, Color.YELLOW));

        triangles.add(new Triangle(v2, s2, v6, Color.BLUE));
        triangles.add(new Triangle(v2, v10, s2, Color.MAGENTA));
        triangles.add(new Triangle(v2, s2, v9, Color.ORANGE));
        triangles.add(new Triangle(v10, s2, v5, Color.CYAN));

        triangles.add(new Triangle(v3, v5, s3, Color.BLACK));
        triangles.add(new Triangle(v3, s3, v12, Color.RED));
        triangles.add(new Triangle(v3, v7, s3, Color.GREEN));
        triangles.add(new Triangle(v5, s3, v10, Color.YELLOW));

        triangles.add(new Triangle(v4, s4, v5, Color.BLUE));
        triangles.add(new Triangle(v4, v9, s4, Color.ORANGE));
        triangles.add(new Triangle(v4, s4, v7, Color.CYAN));
        triangles.add(new Triangle(v9, s4, v8, Color.PINK));

        triangles.add(new Triangle(v6, v12, s6, Color.RED));
        triangles.add(new Triangle(v6, s6, v10, Color.GREEN));
        triangles.add(new Triangle(v12, s6, v1, Color.BLUE));
        triangles.add(new Triangle(v10, s6, v5, Color.MAGENTA));

        triangles.add(new Triangle(v8, v11, s8, Color.YELLOW));
        triangles.add(new Triangle(v8, s8, v9, Color.CYAN));
        triangles.add(new Triangle(v11, s8, v7, Color.BLACK));
        triangles.add(new Triangle(v9, s8, v4, Color.RED));

        triangles.add(new Triangle(v7, v11, s7, Color.ORANGE));
        triangles.add(new Triangle(v7, s7, v3, Color.PINK));
        triangles.add(new Triangle(v11, s7, v8, Color.MAGENTA));
        triangles.add(new Triangle(v3, s7, v4, Color.GREEN));

        triangles.add(new Triangle(v12, v1, s12, Color.CYAN));
        triangles.add(new Triangle(v12, s12, v5, Color.BLACK));
        triangles.add(new Triangle(v1, s12, v6, Color.RED));
        triangles.add(new Triangle(v5, s12, v2, Color.YELLOW));

            
        return triangles;
    }
}
