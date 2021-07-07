package heap;

import java.util.Arrays;

// https://www.youtube.com/watch?v=t0Cq6tVNRBA
// https://en.wikipedia.org/wiki/Heap_(data_structure)

/**
 * Element at index k. (If root is stored at index 0, Array[(k-1)/2])
 *  - Left Child = 2k + 1
 *  - Right Child = 2k + 2
 */

public class MinHeap {

    private int capacity = 10;
    private int size = 0;

    int data[] = new int[capacity];

    public int getLeftChildIndex(int index) {
        if (size > 0) {
            return (2 * index) + 1;
        }
        return -1;
    }

    public int getRightChildIndex(int index) {
        if (size > 0) {
            return (2 * index) + 2;
        }
        return -1;
    }

    public int getParentIndex(int index) {
        if (size > 0) {
            return (index - 1) / 2;
        }
        return -1;
    }

    public boolean hasLeftChild(int index) {
        return getLeftChildIndex(index) < size;
    }

    public boolean hasRightChild(int index) {
        return getRightChildIndex(index) < size;
    }

    public boolean hasParent(int index) {
        return getParentIndex(index) >= 0;
    }

    public int getLeftChild(int index) {
        if (hasLeftChild(index)) {
            return data[getLeftChildIndex(index)];
        }
        return -1;
    }

    public int getRightChild(int index) {
        if (hasRightChild(index)) {
            return data[getRightChildIndex(index)];
        }
        return -1;
    }

    public int getParent(int index) {
        if (hasParent(index)) {
            return data[getParentIndex(index)];
        }
        return -1;
    }

    public void swap(int firstIndex, int secondIndex) {
        int temp = data[firstIndex];
        data[firstIndex] = data[secondIndex];
        data[secondIndex] = temp;
    }

    public void ensureCapacity() {
        if (size == capacity) {
            data = Arrays.copyOf(data, capacity * 2);
            capacity *= 2;
        }
    }

    public int peek() {
        return (size == 0) ? -1 : data[0];
    }

    public int poll() {
        if (size == 0) return -1;
        int dataAtRoot = data[0];
        data[0] = data[size - 1]; // Replace it with the last element before we fix the heap (heapify)
        size--;
        heapifyDown();
        return dataAtRoot;
    }

    public void add(int value) {
        ensureCapacity();
        data[size] = value;
        size++;
        heapifyUp();
    }

    public void heapifyUp() {
        int index = size - 1;
        while (hasParent(index) && getParent(index) > data[index]) {
            swap(getParentIndex(index), index);
            index = getParentIndex(index);
        }
    }

    public void heapifyDown() {
        int index = 0;

        while (hasLeftChild(index)) {
            int smallerChildIndex = getLeftChildIndex(index);
            if (
                hasRightChild(index) &&
                getRightChild(index) < getLeftChild(index)
            ) {
                smallerChildIndex = getRightChildIndex(index);
            }

            if (data[index] < data[smallerChildIndex]) {
                break;
            } else {
                swap(index, smallerChildIndex);
            }

            index = smallerChildIndex;
        }
    }

    public static void main(String[] args) {
        MinHeap heap = new MinHeap();
        for (int i = 11; i < 20; i++) {
            heap.add(i);
        }

        System.out.println("Removing 3-5");
        for (int i = 3; i <= 5; i++) {
            System.out.print(heap.poll() + ", ");
        }
        System.out.println();

        for (int i : heap.data) {
            System.out.print(i + " | ");
        }
    }
}
