/**
 * Created by JZ_W541 on 8/22/2016.
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("Hello");
        StablePriorityQueue q = new StablePriorityQueue();

        int[] nums = {4, 6, 2, 1, 8, 2, 3, 8, 5, 7};

        for(int i = 0 ; i < nums.length ; i++) {
            q.insert(nums[i]);
        }

       while(!q.isEmpty()) {
           //System.out.println(q.maximum());
           System.out.println(q.extractMax());
       }
    }

}
