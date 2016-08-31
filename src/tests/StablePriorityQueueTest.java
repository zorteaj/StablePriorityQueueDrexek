import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by JZ_W541 on 8/31/2016.
 */
// Used to test StablePriorityQueue
// Only tests extractMax() method; if this is method is proven correct, the class must be correct
// regardless of the other methods in the class
public class StablePriorityQueueTest {

    // Dynamic in the sense that arrayElems can be changed (in the source below) by the test developer.
    // Uses Integers without any duplicates.
    // ArrayElems are inserted into the StablePriorityQueue and an ArrayList that is then sorted
    // PASSES if the order of values returned by extractMax() calls equals the order of the sorted ArrayList
    @Test
    public void dynamicTestExtractMaxIntNoDups() throws Exception {
        StablePriorityQueue<Integer> q = new StablePriorityQueue<>();

        int[] arrayElems = {1, 2, 3, 4, 5};

        ArrayList<Integer> elems = new ArrayList();
        for(int i = 0; i < arrayElems.length; i++) {
            elems.add(arrayElems[i]);
            q.insert(arrayElems[i]);
        }

        elems.sort((right, left) -> left - right);

        ArrayList<Integer> queueMaxes = new ArrayList<>();
        while(!q.isEmpty()) {
            queueMaxes.add(q.extractMax());
        }

        assertEquals(elems, queueMaxes);
    }

    // Static in the sense that the sorted result is hard-coded (as an alternative
    // to the dynamic test above).  An ascending, descending, and mixed array are each
    // inserted into corresponding StablePriorityQueues.
    // Uses integers without any duplicates
    // PASSES if the order of values returned by extractMax() calls equals the order of the sorted array
    @Test
    public void staticTestExtractMaxIntNoDups() throws Exception {
        StablePriorityQueue<Integer> q1 = new StablePriorityQueue<>();
        StablePriorityQueue<Integer> q2 = new StablePriorityQueue<>();
        StablePriorityQueue<Integer> q3 = new StablePriorityQueue<>();

        int[] sorted = {5, 4, 3, 2, 1};

        int[] orig1 = {1, 2, 3, 4, 5};
        int[] queueMaxes1 = new int[5];

        int[] orig2 = {5, 4, 3, 2, 1};
        int[] queueMaxes2 = new int[5];

        int[] orig3 = {2, 4, 1, 3, 5};
        int[] queueMaxes3 = new int[5];

        for(int i = 0; i < 5; i++) {
            q1.insert(orig1[i]);
            q2.insert(orig2[i]);
            q3.insert(orig3[i]);
        }

        int i = 0;
        while(!q1.isEmpty()) {
            queueMaxes1[i] = q1.extractMax();
        }

        i = 0;
        while(!q1.isEmpty()) {
            queueMaxes2[i] = q2.extractMax();
        }

        i = 0;
        while(!q1.isEmpty()) {
            queueMaxes2[i] = q3.extractMax();
        }

        assertEquals(sorted, queueMaxes1);
        assertEquals(sorted, queueMaxes2);
        assertEquals(sorted, queueMaxes3);
    }

    // Static in the sense that the sorted result is hard-coded (as an alternative
    // to the dynamic test above).  An ascending, descending, and mixed array are each
    // inserted into corresponding StablePriorityQueues.
    // Uses Structs (an implementations of Comparable - see comments in Struct source for more info) with duplicates
    // PASSES if the order of values returned by extractMax() calls equals the order of the sorted array
    @Test
    public void staticTestExtractMaxStructDups() throws Exception {
        StablePriorityQueue<Struct> q1 = new StablePriorityQueue<>();
        StablePriorityQueue<Struct> q2 = new StablePriorityQueue<>();
        StablePriorityQueue<Struct> q3 = new StablePriorityQueue<>();

        Struct[] sorted = {
                new Struct(5, 1),
                new Struct(5, 2),
                new Struct(3, 1),
                new Struct(2, 1),
                new Struct(2, 2),
                new Struct(1, 1),
                new Struct(1, 2),
        };

        Struct[] orig1 = {
                new Struct(5, 1),
                new Struct(5, 2),
                new Struct(3, 1),
                new Struct(2, 1),
                new Struct(2, 2),
                new Struct(1, 1),
                new Struct(1, 2),
        };
        Struct[] queueMaxes1 = new Struct[7];

        Struct[] orig2 = {
                new Struct(1, 1),
                new Struct(1, 2),
                new Struct(2, 1),
                new Struct(2, 2),
                new Struct(3, 1),
                new Struct(5, 1),
                new Struct(5, 2)
        };
        Struct[] queueMaxes2 = new Struct[7];

        Struct[] orig3 = {
                new Struct(5, 1),
                new Struct(1, 1),
                new Struct(2, 1),
                new Struct(5, 2),
                new Struct(1, 2),
                new Struct(3, 1),
                new Struct(2, 2)
        };
        Struct[] queueMaxes3 = new Struct[7];

        for(int i = 0; i < 7; i++) {
            q1.insert(orig1[i]);
            q2.insert(orig2[i]);
            q3.insert(orig3[i]);
        }

        int i = 0;
        while(!q1.isEmpty()) {
            queueMaxes1[i] = q1.extractMax();
            queueMaxes2[i] = q2.extractMax();
            queueMaxes3[i] = q3.extractMax();
            i++;
        }

        for(i = 0; i < 7; i++) {
            assertEquals(true, queueMaxes1[i].equals(sorted[i]));
            assertEquals(true, queueMaxes2[i].equals(sorted[i]));
            assertEquals(true, queueMaxes3[i].equals(sorted[i]));
        }
    }
}