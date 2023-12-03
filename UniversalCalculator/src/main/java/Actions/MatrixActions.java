package Actions;

import domain.Matrix;

public class MatrixActions
{
    public Matrix addMatrices(Matrix m1, Matrix m2){
        if(!m1.getDimension().contains(m2.getDimension())){
            throw new IllegalArgumentException("Matrices dim should be equal: %s != %s".formatted(m1.getDimension(), m2.getDimension()));
        }
        Matrix newMatrix = new Matrix(m1);
        for (int i = 0; i < m1.getMatrix().length; i++) {
            for (int j = 0; j < m1.getMatrix()[0].length; j++) {
                newMatrix.getMatrix()[i][j] = m1.getMatrix()[i][j] + m2.getMatrix()[i][j];
            }
        }
        return newMatrix;
    }

    public Matrix subtractMatrices(Matrix m1, Matrix m2) {
        if (m1.getMatrix().length != m2.getMatrix().length || m1.getMatrix()[0].length != m2.getMatrix()[0].length) {
            throw new IllegalArgumentException("Matrices must have the same dimensions for subtraction.");
        }

        Matrix newMatrix = new Matrix(m1);
        for (int i = 0; i < m1.getMatrix().length; i++) {
            for (int j = 0; j < m1.getMatrix()[0].length; j++) {
                newMatrix.getMatrix()[i][j] = m1.getMatrix()[i][j] - m2.getMatrix()[i][j];
            }
        }
        return newMatrix;
    }

    public Matrix multiplicationByScalar(Matrix a, double scalar) {
        Matrix result = new Matrix(a.getRows(), a.getColumns());
        for (int i = 0; i < a.getRows(); i++) {
            for (int j = 0; j < a.getColumns(); j++) {
                result.setElement(i + 1, j + 1, a.getElement(i + 1, j + 1) * scalar);
            }
        }
        return result;
    }
    public Matrix multiplicationMatrices(Matrix a, Matrix b) {
        if (a.getMatrix().length == 0 || b.getMatrix().length == 0) {
            throw new IllegalArgumentException("No matrices provided for addition.");
        }

        if (a.getColumns() != b.getRows()) {
            throw new IllegalArgumentException("Such matrices cannot be multiplied, since the number of columns of matrix 'a' is not equal to the number of rows of matrix 'b'.");
        }

        Matrix result = new Matrix(a.getRows(), b.getColumns());

        for (int i = 0; i < a.getRows(); i++) {
            for (int j = 0; j < b.getColumns(); j++) {
                double sum = 0;
                for (int k = 0, l = 0; k < a.getColumns() && l < b.getRows(); k++, l++) {
                    double number1 = a.getMatrix()[i][k];
                    double number2 = b.getMatrix()[l][j];
                    double mult = number1 * number2;
                    sum = sum + mult;
                }
                result.setElement(i + 1, j + 1, sum);
            }
        }
        return result;

    }

    public Matrix triangularShapeUpper(Matrix matrix){
        int LowestLength;
        if (matrix.getColumns() < matrix.getRows()) {
            LowestLength = matrix.getColumns();
        } else {
            LowestLength = matrix.getRows();
        }

        Matrix newMatrix = new Matrix(matrix);
        for (int i = 0; i < LowestLength; i++) {
            boolean matrix_swaped = false;
            for (int j = i; j < matrix.getRows(); j++) {
                if (matrix_swaped) {

                } else {
                    if (newMatrix.getMatrix()[j][i] != 0) {
                        double[] temp = newMatrix.getMatrix()[i];
                        newMatrix.getMatrix()[i] = newMatrix.getMatrix()[j];
                        newMatrix.getMatrix()[j] = temp;
                        matrix_swaped = true;
                    }
                }
            }
            double first_d = newMatrix.getMatrix()[i][i];
            for (int j = 1 + i; j < newMatrix.getRows(); j++) {
                double other_d = newMatrix.getMatrix()[j][i];
                if (first_d != 0) {
                    double alpha = other_d / first_d;
                    for (int k = 0; k < newMatrix.getColumns(); k++) {
                        newMatrix.getMatrix()[j][k] = newMatrix.getMatrix()[j][k] - alpha*newMatrix.getMatrix()[i][k];
                    }
                }
            }
        }

        return newMatrix;
    }

    public Matrix triangularShapeLower(Matrix matrix){

        int LastDigitOfTriangul;
        if (matrix.getColumns() < matrix.getRows()) {
            LastDigitOfTriangul = 0;
        } else {
            LastDigitOfTriangul = matrix.getColumns() - matrix.getRows();
        }
        Matrix newMatrix = new Matrix(matrix);
        int count_backing = 0;
        for (int i = newMatrix.getColumns() - 1; i > LastDigitOfTriangul - 1; i--) {
            count_backing++;
            int row_pivot = newMatrix.getRows() - count_backing;

            Boolean matrix_swaped = false;
            for (int j = row_pivot; j > -1; j--) {
                if(matrix_swaped){

                } else {
                    if (newMatrix.getMatrix()[j][i] != 0) {
                        double[] temp = newMatrix.getMatrix()[row_pivot];
                        newMatrix.getMatrix()[row_pivot] = newMatrix.getMatrix()[j];
                        newMatrix.getMatrix()[j] = temp;
                        matrix_swaped = true;
                    }
                }

            }

            double first_d = newMatrix.getMatrix()[row_pivot][i];

            for (int j = row_pivot - 1; j > -1 ; j--) {
                double other_d = newMatrix.getMatrix()[j][i];
                if(first_d != 0) {
                    double alpha = other_d / first_d;
                    for (int k = 0; k < newMatrix.getColumns(); k++) {
                        newMatrix.getMatrix()[j][k] = newMatrix.getMatrix()[j][k] - alpha*newMatrix.getMatrix()[row_pivot][k];
                    }
                }
            }
        }

        return newMatrix;
    }

}
