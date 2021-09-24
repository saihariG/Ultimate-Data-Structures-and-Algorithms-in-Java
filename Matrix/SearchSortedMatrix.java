package Matrix;

public class SearchSortedMatrix {

    private static void searchMatrix(int[][] matrix , int n , int key) {
        int i = 0;
        int j = n-1;

        while (i < n && j >= 0) {
            if(matrix[i][j] == key) {
                System.out.println("Key Found at : "+i+","+j);
                return;
            }
            else if(matrix[i][j] > key) {
                j--;
            }
            else {
                i++;
            }
        }
        System.out.println("Key not Found");
    }


    public static void main(String[] args) {

        int[][] matrix = {
                {10,20,30,40},
                {15,25,35,45},
                {27,29,37,48},
                {32,33,39,51}
        };

        searchMatrix(matrix, matrix.length, 32);

    }
}
