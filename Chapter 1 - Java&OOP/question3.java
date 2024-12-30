import java.util.*;

public class question3 {
    public static void main(String[] args) {
        Random random = new Random();
        
        // Generate random array without duplicates
        int[] array = new int[random.nextInt(10, 25)];
        populateRandomSortedArray(array, random);
        int sum = getRandomSum(array, random);

        // Print the array
        System.out.println("Generated array: " + Arrays.toString(array));
        System.out.println("Target sum: " + sum);

        // Your function
        printIdsForGivenSum(array, sum);
    }

    public static void printIdsForGivenSum(int[] arr, int targetSum) {
        // ! * Your code here:* !
    }




    // #region Array generation code
    public static void populateRandomSortedArray(int[] array, Random random) {
        int minArr = -10;
        int maxArr = 5;
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(minArr, maxArr + 1); // Random numbers
            minArr = array[i] + 1;
            if (minArr > maxArr) {
                maxArr += 5;
            }
        }
    }

    public static int getRandomSum(int[] array, Random random) {
        int firstIndex = random.nextInt(0, array.length);
        int secondIndex = random.nextInt(0, array.length);

        while (firstIndex == secondIndex) {
            secondIndex = random.nextInt(0, array.length);
        }

        return array[firstIndex] + array[secondIndex];
    }
    //#endregion
}


/* Possible Solution:
public static void printIdsForGivenSum(int[] arr, int targetSum) {
        int top = arr.length - 1;
        int bottom = 0;
        while (bottom < top) {
            int currentSum = arr[bottom] + arr[top];

            if (currentSum > targetSum) {
                top--;
            } else if (currentSum < targetSum) {
                bottom++;
            } else {
                System.out.println("Found the result in the indexes: " + bottom + ", " + top);
                return;
            }
        }

        System.out.println("Couldn't find the correct indices, something went wrong");
    }
}*/