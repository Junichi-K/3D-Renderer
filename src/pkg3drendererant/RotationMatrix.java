
package pkg3drendererant;

public class RotationMatrix {
    private double[][] values;
    
    RotationMatrix(double values[][]) {
        this.values = values;
    }
    
    RotationMatrix multiplication(RotationMatrix otherMatrix) {
        double result[][] = new double[3][3];
        
        for(int row = 0; row < 3; row++) {
            for(int col = 0; col < 3; col++) {
                for(int i = 0; i < 3; i++) {
                    result[row][col] += this.values[row][i] * otherMatrix.values[i][col];
                }
            }
        }
        
        return new RotationMatrix(result);
    }
    
    Vertex VectorTransformation(Vertex initial) {
        double newX = initial.x * values[0][0] + initial.y * values[1][0] + initial.z * values[2][0];
        double newY = initial.x * values[0][1] + initial.y * values[1][1] + initial.z * values[2][1];
        double newZ = initial.x * values[0][2] + initial.y * values[1][2] + initial.z * values[2][2];
        
        return new Vertex(newX, newY, newZ);
    }
}
