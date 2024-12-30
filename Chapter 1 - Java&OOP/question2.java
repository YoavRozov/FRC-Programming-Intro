import java.util.*;

class question2 {
    public static void main(String[] args) {
        // Don't touch
        Random random = new Random();
        
        int[][] ocean = new int[random.nextInt(5, 10)][random.nextInt(5, 10)];
        populateSubmarines(ocean, random);
        printArr(ocean);

        // Your function
        int result = countSubmarines(ocean);
        System.out.print("\nCounted submarines: ");
        System.out.println(result);
    }

    public static int countSubmarines(int[][] arr) {
        // ! * Your code here:* !
        return 0;
    }

    // Helper function you can use
    // Checks if a specific index is inside a given array
    public static boolean inRange(int[][] arr, int y, int x) {
        if (x < 0 || x >= arr[0].length || y < 0 || y >= arr.length) {
            return false;
        }
        return true;
    }
    



    //#region Submarine generator code
    // Don't Use:

    // Don't touch and don't use
    public static void populateSubmarines(int[][] arr, Random random) {
        for (int y = 0; y < arr.length; y++) {
            for (int x = 0; x < arr[y].length; x++) {
                boolean hasSub = random.nextBoolean();
                if (hasSub && isLegal(arr, y, x)) {
                    arr[y][x] = 1;
                }
            }
        }
    }

    // Don't touch and don't use
    // Checks if it is possible to place a part of a submarine in a specific area
    public static boolean isLegal(int[][] arr, int y, int x) {
        // Horizontal submarine possibility
        if (inRange(arr, y, x-1) && arr[y][x-1] == 1) {
            //System.out.println(x + ","+ y);
            if ((inRange(arr, y-1, x-1) && arr[y-1][x-1] == 1) || 
                (inRange(arr, y-1, x) && arr[y-1][x] == 1)){
                    return false;
            }
        }

        // Vertical submarine possibility
        if (inRange(arr, y-1, x) && arr[y-1][x] == 1) {
            //System.out.println(x + ","+ y +" -> 2");
            if ((inRange(arr, y-1, x-1) && arr[y-1][x-1] == 1) || 
                (inRange(arr, y, x-1) && arr[y][x-1] == 1) || 
                (inRange(arr, y-1, x+1) && arr[y-1][x+1] == 1)){
                    return false;
            }
        }

        return true;
    }

    // Prints the 2d array to the screen
    public static void printArr(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] == 1 ? "[1]" : "[ ]");
            }
            System.out.println(); // Move to the next line after each row
        }
    }

    //#endregion
}


/* Possible Solution:
public static int countSubmarines(int[][] arr) {
        int counter = 0;

        for (int y = 0; y < arr.length; y++) {
            for (int x = 0; x < arr[y].length; x++) {
                if (arr[y][x] == 1) {
                    if (!(inRange(arr, y, x - 1) && arr[y][x - 1] == 1) && 
                        !(inRange(arr, y - 1, x) && arr[y - 1][x] == 1)) {
                            counter++;
                    }
                }
            }
        }

        return counter;
    }
}*/