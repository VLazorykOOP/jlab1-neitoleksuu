
public class Matrix {
    private double[][] matrix;

    public Matrix(double a, double b, double c, double d) {
        matrix = new double[][]{{a, b}, {c, d}};
    }

    public double determinant() {
        return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
    }

    public Matrix inverse() {
        double det = determinant();
        if (det == 0) {
            throw new ArithmeticException("Matrix is singular, cannot find inverse");
        }

        double[][] result = new double[2][2];
        result[0][0] = matrix[1][1] / det;
        result[0][1] = -matrix[0][1] / det;
        result[1][0] = -matrix[1][0] / det;
        result[1][1] = matrix[0][0] / det;

        return new Matrix(result[0][0], result[0][1], result[1][0], result[1][1]);
    }

    public Matrix multiply(Matrix other) {
        double a = matrix[0][0] * other.matrix[0][0] + matrix[0][1] * other.matrix[1][0];
        double b = matrix[0][0] * other.matrix[0][1] + matrix[0][1] * other.matrix[1][1];
        double c = matrix[1][0] * other.matrix[0][0] + matrix[1][1] * other.matrix[1][0];
        double d = matrix[1][0] * other.matrix[0][1] + matrix[1][1] * other.matrix[1][1];

        return new Matrix(a, b, c, d);
    }

    public Matrix add(Matrix other) {
        double a = matrix[0][0] + other.matrix[0][0];
        double b = matrix[0][1] + other.matrix[0][1];
        double c = matrix[1][0] + other.matrix[1][0];
        double d = matrix[1][1] + other.matrix[1][1];

        return new Matrix(a, b, c, d);
    }

    public Matrix multiply(double scalar) {
        double a = matrix[0][0] * scalar;
        double b = matrix[0][1] * scalar;
        double c = matrix[1][0] * scalar;
        double d = matrix[1][1] * scalar;

        return new Matrix(a, b, c, d);
    }

    @Override
    public String toString() {
        return String.format("| %.2f %.2f |\n| %.2f %.2f |", matrix[0][0], matrix[0][1], matrix[1][0], matrix[1][1]);
    }

    public static void main(String[] args) {
        Matrix A = new Matrix(1, 2, 3, 4);
        Matrix B = new Matrix(5, 6, 7, 8);

        System.out.println("Matrix A:");
        System.out.println(A);

        System.out.println("\nMatrix B:");
        System.out.println(B);

        System.out.println("\nDeterminant of A: " + A.determinant());
        System.out.println("\nInverse of A:");
        System.out.println(A.inverse());

        System.out.println("\nA + B:");
        System.out.println(A.add(B));

        System.out.println("\nA * B:");
        System.out.println(A.multiply(B));

        System.out.println("\nA * 2:");
        System.out.println(A.multiply(2));
    }
}


