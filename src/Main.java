/**
 * Created by JZ_W541 on 8/22/2016.
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("Hello");
        StablePriorityQueue<Struct> q = new StablePriorityQueue();

        /*
        Struct[] nums = {
                new Struct(4, 1),
                new Struct(6, 1),
                new Struct(8, 1),
                new Struct(2, 1),
                new Struct(1, 1),
                new Struct(9, 1),
                new Struct(4, 2)
        };
*/

        Struct[] nums = {
                new Struct(4, 1),
                new Struct(6, 1),
                new Struct(8, 1),
                new Struct(12, 1),
                new Struct(1, 1),
                new Struct(4, 2),
                new Struct(4, 3),
                new Struct(99, 1),
                new Struct(55, 1),
                new Struct(55, 2),
                new Struct(1, 2),
                new Struct(100, 1),
                new Struct(4, 4),
                new Struct(4, 5),
                new Struct(4, 6)
        };


        for(int i = 0 ; i < nums.length ; i++) {
            q.insert(nums[i]);
        }

       while(!q.isEmpty()) {
           //System.out.println(q.maximum());
           Struct max = q.extractMax();
           System.out.println(max.data + " : " + max.priority);
       }
    }

}
