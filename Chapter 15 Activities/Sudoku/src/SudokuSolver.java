import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class SudokuSolver {
    private final int M = 3;
    private final int N = M * M;
    private int[][] grid;
    private final ArrayList<Set<Integer>> rows;
    private ArrayList<Set<Integer>> cols;
    private ArrayList<Set<Integer>> squares;
    private Set<Integer> nums;

    public SudokuSolver(String fileName) {
        // read the puzzle file
        try (Scanner in = new Scanner(new File(fileName), StandardCharsets.UTF_8)) {

            this.grid = new int[N][N];

            for (int row = 0; row < N; row++) {
                String line = in.next();

                for (int col = 0; col < N; col++) {
                    String strVal = line.substring(col, col + 1);
                    int number;
                    if (strVal.equals("x")) {
                        number = 0;
                    } else {
                        number = Integer.parseInt(strVal);
                    }
                    System.out.println(number);
                    this.grid[row][col] = number;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Cannot open: " + fileName);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // create the list of sets for each row (this.rows)
        // ...
        this.rows = new ArrayList<>();
        if (grid != null) {
            for (int[] ints : grid) {
                Set<Integer> row = new HashSet<>();
                for (int c = 0; c < N; c++) {
                    row.add(ints[c]);
                    //System.out.print(ints[c]);
                }
                //System.out.println();
                this.rows.add(row);
            }
            // create the list of sets for each col (this.cols)
            // ...
            this.cols = new ArrayList<>();
            for (int col = 0; col < N; col++) {
                Set<Integer> colSet = new HashSet<>();

                for (int row = 0; row < N; row++) {
                    colSet.add(this.grid[row][col]);
                }

                this.cols.add(colSet);
            }
            // create the list of sets for each square (this.squares)
        /* the squares are added to the list row-by-row:
            0 1 2
            3 4 5
            6 7 8
         */
            // ...
            this.squares = new ArrayList<>();
            for (int square = 0; square < N; square++) {
                Set<Integer> squareSet = new HashSet<>();

                int startRow = (square / M) * M;
                int startCol = (square % M) * M;

                // Iterate through the cells in the current square
                for (int row = startRow; row < startRow + M; row++) {
                    for (int col = startCol; col < startCol + M; col++) {
                        squareSet.add(this.grid[row][col]);
                    }
                }

                // Add the squareSet to this.squares
                this.squares.add(squareSet);
            }
            // create a hash set for [1..9] (this.nums)
            // ...
            this.nums = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
            // visually inspect that all the sets are correct
            for (int row = 0; row < N; row++) {
                System.out.println("row " + row + ": " + this.rows.get(row));
            }
            for (int col = 0; col < N; col++) {
                System.out.println("col " + col + ": " + this.cols.get(col));
            }
            for (int square = 0; square < N; square++) {
                System.out.println("square " + square + ": " + this.squares.get(square));
            }
            System.out.println(this.nums);
        }
    }

    public boolean solve() {
        // find an empty location, if any
        boolean finished = true;
        int nextRow = -1;
        int nextCol = -1;
        for (int row = 0; row < N && finished; row++) {
            for (int col = 0; col < N && finished; col++) {
                if (this.grid[row][col] == 0) {
                    finished = false;
                    nextRow = row;
                    nextCol = col;
                }
            }
        }

        // the board is complete; we solved it
        if (finished) {
            return true;
        }

        // get all possible numbers for the row and column we are trying to populate
        /*
            Create a new set based on the this.nums and remove all elements in the sets
            corresponding to nextRow, nextCol, and the corresponding square (use the
            removeAll method).

            Properly indexing the squares list of sets is tricky. Verify that your
            algorithm is correct.
         */
        Set<Integer> possibleNums = new HashSet<>(this.nums);
        Set<Integer> rowSet = this.rows.get(nextRow);
        Set<Integer> colSet = this.cols.get(nextCol);
        Set<Integer> squareSet = this.squares.get((nextRow / M) * M + (nextCol / M));

        possibleNums.removeAll(rowSet);
        possibleNums.removeAll(colSet);
        possibleNums.removeAll(squareSet);
        // ...

        // if there are no possible numbers, we cannot solve the board in its current state
        if (possibleNums.isEmpty()) {
            return false;
        }

        // try each possible number
        for (Integer possibleNum : possibleNums) {
            // update the grid and all three corresponding sets with possibleNum
            // ...
            this.grid[nextRow][nextCol] = possibleNum;
            rowSet.add(possibleNum);
            colSet.add(possibleNum);
            squareSet.add(possibleNum);
            // recursively solve the board
            if (this.solve()) {
                // the board is solved!
                return true;
            } else {
                /*
                 Undo the move before trying another possible number by setting the corresponding
                 element in the grid back to 0 and removing possibleNum from all three corresponding
                 sets.
                 */
                // ...
                this.grid[nextRow][nextCol] = 0;
                rowSet.remove(possibleNum);
                colSet.remove(possibleNum);
                squareSet.remove(possibleNum);
            }
        }

        return false;
    }

    public String toString() {
        StringBuilder str = new StringBuilder();

        for (int[] row : grid) {
            for (int val : row) {
                str.append(val).append("\t");
            }

            str.append("\n");
        }

        return str.toString();
    }

    public static void main(String[] args) {
        String fileName = "Chapter 15 Activities/Sudoku/src/puzzle1.txt";

        SudokuSolver solver = new SudokuSolver(fileName);
        System.out.println(solver);
        if (solver.solve()) {
            System.out.println("Solved!");
            System.out.println(solver);
        } else {
            System.out.println("Unsolvable...");
        }
    }
}