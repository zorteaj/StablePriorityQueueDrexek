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
                new Struct(4, 2)
        };

        for(int i = 0 ; i < nums.length ; i++) {
            q.insert(nums[i]);
            try {
                Thread.sleep(1000);
            } catch (Exception e) {

            }
        }

       while(!q.isEmpty()) {
           //System.out.println(q.maximum());
           Struct max = q.extractMax();
           System.out.println(max.data + " : " + max.priority);
       }
    }

}
