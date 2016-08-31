/**
 * Created by JZ_W541 on 8/28/2016.
 */


// Used for testing a StablePriorityQueue of Comparable Objects
public class Struct implements Comparable<Struct> {

    // The data
    int data;
    // A lower priority means that the Struct
    // was inserted earlier in the queue
    // Assuming the test developer correctly assigns priorities
    // in the order of insertion, s/he can print the priorities on
    // extractMax() and maximum() to test those methods.
    // (however, this is not being used in StablePriorityQueueTest;
    // I just used it for some less formal testing)
    int priority;

    public Struct(int data, int priority) {
        this.data = data;
        this.priority = priority;
    }

    public int compareTo(Struct s) {
        if (this.data < s.data) {
            return -1;
        } else if (this.data > s.data) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public boolean equals(Object o) {
        if(!(o instanceof Struct)) {
            return false;
        } else {
            Struct struct = (Struct) o;
            if(this.compareTo(struct) == 0) {
                return true;
            }
            return false;
        }
    }

    @Override
    public String toString() {
        return String.valueOf(data) + " : " + String.valueOf(priority);
    }

}
