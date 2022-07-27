package Matrix;

import java.util.ArrayList;
import java.util.List;

public class Shift2DGrid {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int row = grid.length;
        int col = grid[0].length;

        // Create temporary array of the same size in which we will add element in new position after k shifting.
        int[][] temp = new int[row][col];

        // Solution Approach:
        // Assume if we convert given array into 1D Array then shift element to k positions and after shifting all the elements we will again convert 1D Array to our original dimension array.

        // Logic for Finding current elements index in 1D Array after shifting K times :
        // For current element We will just find that what will be its index in 1D Array
        // After for New position in 1D Array we will shift it k times means we will add K in current index
        // And if new position in 1D Array gets increased by its total size, we will modulo it by 1D Array Size

        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {

                // (i * col) + j : will Give Index in 1D Array
                // (i * col) + j + k : Adding K means we will shift it k times
                // ((i * col) + j + k ) % (row * col) : modulo it by array size (row * col), if it exceeds the size
                int indexIn1DArray = ((i * col) + j + k ) % (row * col);

                // Now Based on the 1D Array Index we will find its index in our temporary result array
                int tempRowIndex = indexIn1DArray / col; // Find the particular row
                int tempColIndex = indexIn1DArray % col; // Find the particular column
                temp[tempRowIndex][tempColIndex] = grid[i][j]; // Add Element at that new index in our temporary result array
            }
        }

        // Prepare Result in List
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        for(int i = 0; i < row; i++) {
            List<Integer> list = new ArrayList<Integer>();
            for(int j = 0; j < col; j++) {
                list.add(temp[i][j]);
            }
            result.add(list);
        }

        return result;
    }
}
