package pkg3drendererant;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Path2D;
import java.awt.image.BufferedImage;
import java.util.List;
import java.util.ArrayList;


public class DemoViewer {
    
    private Octahedron shape;
    
    public DemoViewer() {
        this.shape = new Octahedron();
        
        /*for(int i = 0; i < 4; i++) {
            shape.triangles = inflate(shape.getShape());
        }*/
    }
    
    public static Color getShade(Color color, double shade) {
        double redLinear = Math.pow(color.getRed(), 2.4) * shade;
        double greenLinear = Math.pow(color.getGreen(), 2.4) * shade;
        double blueLinear = Math.pow(color.getBlue(), 2.4) * shade;

        int red = (int) Math.pow(redLinear, 1/2.4);
        int green = (int) Math.pow(greenLinear, 1/2.4);
        int blue = (int) Math.pow(blueLinear, 1/2.4);

        return new Color(red, green, blue);
    }
    
        public static List<Triangle> inflate(List<Triangle> tris) {
            List<Triangle> result = new ArrayList<>();
            for (Triangle t : tris) {
                Vertex m1 = new Vertex((t.v1.x + t.v2.x)/2, (t.v1.y + t.v2.y)/2, (t.v1.z + t.v2.z)/2);
                Vertex m2 = new Vertex((t.v2.x + t.v3.x)/2, (t.v2.y + t.v3.y)/2, (t.v2.z + t.v3.z)/2);
                Vertex m3 = new Vertex((t.v1.x + t.v3.x)/2, (t.v1.y + t.v3.y)/2, (t.v1.z + t.v3.z)/2);
                result.add(new Triangle(t.v1, m1, m3, t.color));
                result.add(new Triangle(t.v2, m1, m2, t.color));
                result.add(new Triangle(t.v3, m2, m3, t.color));
                result.add(new Triangle(m1, m2, m3, t.color));
            }
            for (Triangle t : result) {
                for (Vertex v : new Vertex[] { t.v1, t.v2, t.v3 }) {
                    double l = Math.sqrt(v.x * v.x + v.y * v.y + v.z * v.z) / Math.sqrt(30000);
                    v.x /= l;
                    v.y /= l;
                    v.z /= l;
                }
            }
            return result;
    }
    
    public static void main(String[] args) {
        JFrame frame = new JFrame();    //JFrame is the ENTIRE window that gets displayed(even including the title bar)
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container pane = frame.getContentPane();    //includes everything excluding the titlebar(the window area)
        pane.setLayout(new BorderLayout()); //A JFrame got 5 main areas, called NORTH, SOUTH, EAST, WEST, CENTER. This layout is set using this line of code

        // slider to control horizontal rotation
        JSlider headingSlider = new JSlider(0, 360, 180);   //This adds a horizontal slider to the JFrame with start value at 180degrees(maybe we'll use it's values later to control the render angle)
        pane.add(headingSlider, BorderLayout.SOUTH);

        // slider to control vertical rotation
        JSlider pitchSlider = new JSlider(SwingConstants.VERTICAL, -90, 90, 0); //this creates a VERTICAL slider, with max and min values as shown, and then we place it along the EAST border
        pane.add(pitchSlider, BorderLayout.EAST);
        
        DemoViewer demoViewer = new DemoViewer();
        //demoViewer.shape = new Tetrahedron();
        
        double xz_theta = Math.toRadians(headingSlider.getValue());
        
        /*RotationMatrix XZTransform = new RotationMatrix(new double[][] {{Math.cos(xz_theta), 0, -Math.sin(xz_theta)},         //cosO, 0, -sinO
                                                                        {0, 1, 0},                                      //0     1    0
                                                                        {Math.sin(xz_theta), 0, Math.cos(xz_theta)}});        //sinO 0 cosO
        
        RotationMatrix YZTransform = new RotationMatrix(new double[][] {{1, 0, 0},                                       //1,   0,  0
                                                                        {0, Math.cos(xz_theta), Math.sin(xz_theta)},           //0  cosO  sinO
                                                                        {0, -Math.sin(xz_theta), Math.cos(xz_theta)}});        //0  -sinO cosO*/
        
        // panel to display render results
        JPanel renderPanel;
        renderPanel = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D) g;
                g.setColor(Color.BLACK);
                g.fillRect(0, 0, getWidth(), getHeight());

                g.translate(getWidth()/2, getHeight()/2);   //origin is initially at TOP LEFT CORNER, this shifts it to center of window
                g.setColor(Color.WHITE);
                

                double xz_theta = Math.toRadians(headingSlider.getValue());
        
                RotationMatrix XZTransform = new RotationMatrix(new double[][] {{Math.cos(xz_theta), 0, -Math.sin(xz_theta)},         //cosO, 0, -sinO
                                                                                {0, 1, 0},                                            //0     1    0
                                                                                {Math.sin(xz_theta), 0, Math.cos(xz_theta)}});        //sinO 0 cosO     
                
                double yz_theta = Math.toRadians(pitchSlider.getValue()); 
                
                RotationMatrix YZTransform = new RotationMatrix(new double[][] {{1, 0, 0},                                              //1,   0,  0
                                                                                {0, Math.cos(yz_theta), Math.sin(yz_theta)},           //0  cosO  sinO
                                                                                {0, -Math.sin(yz_theta), Math.cos(yz_theta)}});        //0  -sinO cosO   
                
                RotationMatrix Transform = XZTransform.multiplication(YZTransform);
                
                BufferedImage img = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);
                
                double[] zBuffer = new double[img.getWidth() * img.getHeight()];
                // initialize array with extremely far away depths
                for (int q = 0; q < zBuffer.length; q++) {
                    zBuffer[q] = Double.NEGATIVE_INFINITY;
                }

                for(Triangle t : demoViewer.shape.getShape()) {
                    Vertex v1 = Transform.VectorTransformation(t.v1);
                    Vertex v2 = Transform.VectorTransformation(t.v2);
                    Vertex v3 = Transform.VectorTransformation(t.v3);
                    
                    v1.x += getWidth()/2;
                    v1.y += getHeight()/2;
                    v2.x += getWidth()/2;
                    v2.y += getHeight()/2;
                    v3.x += getWidth()/2;
                    v3.y += getHeight()/2;
                    
                    Vertex ab = new Vertex(v2.x - v1.x, v2.y - v1.y, v2.z - v1.z);
                    Vertex ac = new Vertex(v3.x - v1.x, v3.y - v1.y, v3.z - v1.z);
                    Vertex norm = new Vertex(
                         ab.y * ac.z - ab.z * ac.y,
                         ab.z * ac.x - ab.x * ac.z,
                         ab.x * ac.y - ab.y * ac.x
                    );
                    double normalLength = Math.sqrt(norm.x * norm.x + norm.y * norm.y + norm.z * norm.z);
                    norm.x /= normalLength;
                    norm.y /= normalLength;
                    norm.z /= normalLength;

                    double angleCos = Math.abs(norm.z);
                    
                    //we essentially find the "rectnalge" that CONTAINS our current triangle t
                    int minX = (int) Math.max(0, Math.ceil(Math.min(v1.x, Math.min(v2.x, v3.x))));  
                    int maxX = (int) Math.min(img.getWidth() - 1, Math.floor(Math.max(v1.x, Math.max(v2.x, v3.x))));
                    int minY = (int) Math.max(0, Math.ceil(Math.min(v1.y, Math.min(v2.y, v3.y))));
                    int maxY = (int) Math.min(img.getHeight() - 1, Math.floor(Math.max(v1.y, Math.max(v2.y, v3.y))));

                    double triangleArea = (v1.y - v3.y) * (v2.x - v3.x) + (v2.y - v3.y) * (v3.x - v1.x);

                    for (int y = minY; y <= maxY; y++) {
                        for (int x = minX; x <= maxX; x++) {
                            
                            double b1 = ((y - v3.y) * (v2.x - v3.x) + (v2.y - v3.y) * (v3.x - x))/triangleArea;
                            double b2 = ((y - v1.y) * (v3.x - v1.x) + (v3.y - v1.y) * (v1.x - x))/triangleArea;
                            double b3 = ((y - v2.y) * (v1.x - v2.x) + (v1.y - v2.y) * (v2.x - x))/triangleArea;
                            
                            if (b1 >= 0 && b1 <= 1 && b2 >= 0 && b2 <= 1 && b3 >= 0 && b3 <= 1) {
                                    double depth = b1 * v1.z + b2 * v2.z + b3 * v3.z;
                                    int zIndex = y * img.getWidth() + x;
                                    if (zBuffer[zIndex] < depth) {
                                        img.setRGB(x, y, getShade(t.color, angleCos).getRGB());
                                        zBuffer[zIndex] = depth;
                                    }
                            }
                        }
                    }
                    
                }
                
                g2.drawImage(img, -400, -400, null);
            }
        };
        
        pane.add(renderPanel, BorderLayout.CENTER);
        
        headingSlider.addChangeListener(e -> renderPanel.repaint());
        pitchSlider.addChangeListener(e -> renderPanel.repaint());

        frame.setSize(800, 800);
        frame.setVisible(true);
        
        //All the application window work ends here
    }   
}

