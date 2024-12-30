import java.util.*;

class question1 {
    public static void main(String[] args) {
        // Don't touch
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        // Generate random array without duplicates
        int[] array = new int[random.nextInt(5, 16)];
        populateRandomSortedArray(array, random);

        // Print the array
        System.out.println("Generated array: " + Arrays.toString(array));
        
        // Ask for min and max values
        System.out.print("Enter the min value: ");
        int min = scanner.nextInt();
        
        System.out.print("Enter the max value: ");
        int max = scanner.nextInt();
        
        scanner.close();


        // Your function
        boolean result = hasNumberRange(array, min, max);
        System.out.print("\nFound all the numbers between " + min + " and " + max + ": ");
        System.out.println(result);
    }

    public static boolean hasNumberRange(int[] arr, int min, int max) {
        // ! * Your code here:* !
        return false;
    }




    //#region Array generation code
    // Don't touch
    public static void populateRandomSortedArray(int[] array, Random random) {
        int minArr = -10;
        int maxArr = 5;
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(minArr, maxArr + 1); // Random numbers
            minArr = array[i] + 1;
            if (minArr > maxArr) {
                maxArr += 2;
            }
        }
    }
    //#endregion

}


/* Possible Solution:
public static boolean hasNumberRange(int[] arr, int min, int max) {
    int lastNum = min;
    boolean found_min = false;
    for (int i = 0; i < arr.length; i++) {
        if (found_min && lastNum + 1 != arr[i]) {
            return false;
        }
        if (arr[i] == min) {
            found_min = true;
        }
        if (arr[i] == max && found_min) {
            return true;
        }
        lastNum = arr[i];
    }

    return false;
}*/