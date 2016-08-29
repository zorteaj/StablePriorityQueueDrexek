/**
 * Created by JZ_W541 on 8/28/2016.
 */
public class Struct implements Comparable<Struct> {

    int data;
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

}
