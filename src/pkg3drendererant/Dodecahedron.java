package pkg3drendererant;

//DOESN'T WORK DOESN'T WORK DOESN'T WORK DOESN'T WORK DOESN'T WORK DOESN'T WORK DOESN'T WORK DOESNT' WORK
//DOESN'T WORK DOESN'T WORK DOESN'T WORK DOESN'T WORK DOESN'T WORK DOESN'T WORK DOESN'T WORK DOESNT' WORK
//DOESN'T WORK DOESN'T WORK DOESN'T WORK DOESN'T WORK DOESN'T WORK DOESN'T WORK DOESN'T WORK DOESNT' WORK
//DOESN'T WORK DOESN'T WORK DOESN'T WORK DOESN'T WORK DOESN'T WORK DOESN'T WORK DOESN'T WORK DOESNT' WORK
//DOESN'T WORK DOESN'T WORK DOESN'T WORK DOESN'T WORK DOESN'T WORK DOESN'T WORK DOESN'T WORK DOESNT' WORK
//DOESN'T WORK DOESN'T WORK DOESN'T WORK DOESN'T WORK DOESN'T WORK DOESN'T WORK DOESN'T WORK DOESNT' WORK
//DOESN'T WORK DOESN'T WORK DOESN'T WORK DOESN'T WORK DOESN'T WORK DOESN'T WORK DOESN'T WORK DOESNT' WORK
//DOESN'T WORK DOESN'T WORK DOESN'T WORK DOESN'T WORK DOESN'T WORK DOESN'T WORK DOESN'T WORK DOESNT' WORK
//DOESN'T WORK DOESN'T WORK DOESN'T WORK DOESN'T WORK DOESN'T WORK DOESN'T WORK DOESN'T WORK DOESNT' WORK
//DOESN'T WORK DOESN'T WORK DOESN'T WORK DOESN'T WORK DOESN'T WORK DOESN'T WORK DOESN'T WORK DOESNT' WORK
//DOESN'T WORK DOESN'T WORK DOESN'T WORK DOESN'T WORK DOESN'T WORK DOESN'T WORK DOESN'T WORK DOESNT' WORK
//DOESN'T WORK DOESN'T WORK DOESN'T WORK DOESN'T WORK DOESN'T WORK DOESN'T WORK DOESN'T WORK DOESNT' WORK
//DOESN'T WORK DOESN'T WORK DOESN'T WORK DOESN'T WORK DOESN'T WORK DOESN'T WORK DOESN'T WORK DOESNT' WORK


import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class Dodecahedron {
    protected List<Triangle> triangles;
    
    public Dodecahedron() {
        this.triangles = new ArrayList<>();
    }
    
    public List<Triangle> getShape() {
        // Here we can define vertices of the Dodecahedron.
        // This is a simplified version with more faces for visualizing. The actual dodecahedron would have pentagonal faces made up of 5 triangles each.
        
        // Central vertices
        Vertex v1 = new Vertex(100, 100, 100);
        Vertex v2 = new Vertex(-100, 100, 100);
        Vertex v3 = new Vertex(100, -100, 100);
        Vertex v4 = new Vertex(-100, -100, 100);
        Vertex v5 = new Vertex(100, 100, -100);
        Vertex v6 = new Vertex(-100, 100, -100);
        Vertex v7 = new Vertex(100, -100, -100);
        Vertex v8 = new Vertex(-100, -100, -100);
        
        // Define faces (for simplicity, assuming quadrilaterals divided into two triangles)
        triangles.add(new Triangle(v1, v2, v3, Color.WHITE));
        triangles.add(new Triangle(v3, v4, v1, Color.RED));
        triangles.add(new Triangle(v5, v6, v7, Color.GREEN));
        triangles.add(new Triangle(v7, v8, v5, Color.BLUE));

        return triangles;
    }
}
