
package pkg3drendererant;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class Tetrahedron {
    protected List<Triangle> triangles;
    
    public Tetrahedron() {
        this.triangles = new ArrayList<>();
    }
    
    public List<Triangle> getShape() {
        
                    triangles.add(new Triangle(new Vertex(100, 100, 100),
                                          new Vertex(-100, -100, 100),
                                          new Vertex(-100, 100, -100),
                                          Color.WHITE));
                    triangles.add(new Triangle(new Vertex(100, 100, 100),
                                          new Vertex(-100, -100, 100),
                                          new Vertex(100, -100, -100),
                                          Color.RED));
                    triangles.add(new Triangle(new Vertex(-100, 100, -100),
                                          new Vertex(100, -100, -100),
                                          new Vertex(100, 100, 100),
                                          Color.GREEN));
                    triangles.add(new Triangle(new Vertex(-100, 100, -100),
                                          new Vertex(100, -100, -100),
                                          new Vertex(-100, -100, 100),
                                          Color.BLUE));
                    
        return triangles;
    }
}
