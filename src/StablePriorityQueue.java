import java.util.ArrayList;
import java.util.Queue;

/**
 * Created by JZ_W541 on 8/22/2016.
 */
public class StablePriorityQueue {

    //private Node root;
    private ArrayList<Integer> myList = new ArrayList<>(); //TODO: Make Generic Type

    public StablePriorityQueue() {

    }

    public boolean isEmpty() {
        if(myList.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }


    public int maximum() throws IndexOutOfBoundsException { // TODO: Exception
        return myList.get(0);
    }

    public int extractMax() throws IndexOutOfBoundsException { // TODO: Exception
        int max = maximum();
        int last = myList.remove(myList.size() - 1);
        if(myList.size() > 0) {
            myList.set(0, last);
            extractSort(0);
        }
        return max;
    }

    private void extractSort(int index) {
        int leftIndex = leftIndex(index);
        int rightIndex = rightIndex(index);
        int greatestChildIndex;

        // If left child is empty, right child must be empty as well;
        // so we've reached the depth of the tree, and we're sorted
        if(leftIndex == -1) {
            return;
        // If right child is empty, but left is not, left is greatest child
        } else if (rightIndex == -1) {
            greatestChildIndex = leftIndex;
        // If neither child is empty, compare for greatest
        } else {
            greatestChildIndex = myList.get(leftIndex) > myList.get(rightIndex) ? leftIndex : rightIndex;
        }

        // If greatest child is greater than parent, promote greatest child
        // and recursively extract sort
        if(myList.get(greatestChildIndex) > myList.get(index)) {
            promote(greatestChildIndex);
            extractSort(greatestChildIndex);
        } else {
            return;
        }
    }

    public void insert(Integer data) {
        myList.add(data);
        insertSort(myList.size() - 1);
    }

    private void insertSort(int index) {
        if (myList.size() <= 1) {
            return;
        } else if (myList.get(index) > myList.get(parentIndex(index))) {
            promote(index);
            insertSort(parentIndex(index));
        } else {
            return;
        }
    }

    // Swap element at current index with parent
    private void promote(int index)
    {
        int parentIndex = parentIndex(index);
        int temp = myList.get(index);
        myList.set(index, myList.get(parentIndex));
        myList.set(parentIndex, temp);
    }

    // Get index of parent
    private int parentIndex(int index) {
        // TODO: Throw divide my 0 exception
        return (index - 1) / 2;
    }

    // Get index of left child
    // Returns -1 if no left child
    private int leftIndex(int index) {
        int leftIndex = 2 * index + 1;
        if(leftIndex > myList.size() - 1) {
            return -1;
        }
        return leftIndex;
    }

    // Get index of right child
    // Returns -1 if not right child
    private int rightIndex(int index) {
        int rightIndex = 2 * index + 2;
        if(rightIndex > myList.size() - 1) {
            return -1;
        }
        return rightIndex;
    }

}
