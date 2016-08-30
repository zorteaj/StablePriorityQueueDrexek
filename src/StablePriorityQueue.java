import java.util.ArrayList;
import java.time.*;

/**
 * Created by JZ_W541 on 8/22/2016.
 */
public class StablePriorityQueue<T extends Comparable<? super T>> {

    public StablePriorityQueue() {
    }

    private class QueueElement{

        private T myData;
        private Instant myTime;

        public QueueElement(T data) {
            myData = data;
            myTime = Instant.now();
        }

        public T getData() {
            return myData;
        }

        public Instant getTime() {
            return myTime;
        }

        // Returns negative value if this data is less, positive if this data is greater
        // If data is equal, returns negative value if this time is less, positive if this time greater
        public int compareTo(QueueElement e) {
            if(this.myData.compareTo(e.getData()) < 0) {
                return -1;
            } else if(this.myData.compareTo(e.getData()) > 0) {
                return 1;
            } else {
                return -1 * this.myTime.compareTo(e.getTime());
            }
        }
    }

    private ArrayList<QueueElement> myList = new ArrayList<>();

    public boolean isEmpty() {
        if(myList.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    public T maximum() throws IndexOutOfBoundsException {
        return myList.get(0).getData();
    }

    public T extractMax() throws IndexOutOfBoundsException {
        T max = maximum();
        QueueElement last = myList.remove(myList.size() - 1);
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
            greatestChildIndex = myList.get(leftIndex).compareTo(myList.get(rightIndex)) > 0 ? leftIndex : rightIndex;
        }

        // If greatest child is greater than parent, promote greatest child
        // and recursively extract sort
        if(myList.get(greatestChildIndex).compareTo(myList.get(index)) > 0 ) {
            promote(greatestChildIndex);
            extractSort(greatestChildIndex);
        } else {
            return;
        }
    }

    // Synchronized so that even if different threads try to
    // insert at the same time (which could cause elements with
    // the same timestamp, invalidating our "stability" framework), they
    // will not be able to (assuming I understand synchronization
    // and the Thread.sleep function)
    public synchronized void insert(T data) {
        QueueElement elem = new QueueElement(data);
        // Pause thread for one nanosecond so that no two
        // elements may be created with the same time
        // (This is probably not the most elegant solution)
        try {
            Thread.sleep(0, 1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        myList.add(elem);
        insertSort(myList.size() - 1);
    }

    private void insertSort(int index) {
        if (myList.size() <= 1) {
            return;
        } else if (myList.get(index).compareTo(myList.get(parentIndex(index))) > 0) {
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
        QueueElement temp = myList.get(index);
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
