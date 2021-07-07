public class RotateArray {

    public static void rotateLeft(int array[], int rotateSteps) {
        int tempArray[] = new int[rotateSteps];
        int index = 0;

        // O(n) = {n : n = rotateSteps }
        for (int i = 0; i < rotateSteps; i++) {
            tempArray[i] = array[i];
        }

        // O(n - rotateSteps) = ~O(n)
        for (int i = rotateSteps; i < array.length; i++) {
            array[index++] = array[i];
        }

        index = 0;
        // ~O(n)
        for (int i = array.length - rotateSteps; i < array.length; i++) {
            array[i] = tempArray[index++];
        }
    }

    public static void printArray(int array[]) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + (i == array.length - 1 ? "" : ", "));
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int steps = 7;
        int array[] = { 1, 2, 3, 4, 5, 6, 7 };

        // printArray(array);
        // rotateLeft(array, 1);
        // printArray(array);
        // rotateLeft(array, 1);
        // printArray(array);
        rotateLeft(array, steps);
        printArray(array);
    }
}
