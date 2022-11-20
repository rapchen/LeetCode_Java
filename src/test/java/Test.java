import java.util.ArrayList;
import java.util.List;

/**
 * @author Chen Runwen
 * @time 2:03
 */
public class Test {
    public static void main(String[] args) {
//        System.out.println((int)(163222581212825552L % (int)(Math.pow(10, 9) + 7)));
        List<String> ll = new ArrayList<>();
        ll.add("test");
        ll.add("test");
        ll.add("test");

//        for (int i = 0; i < ll.size(); i++) {
//            if (ll.remove("test")) i--;
//        }
        while (ll.remove("test")) ;
//        for (int i = 0; i < ll.size(); i++) {
//            if (ll.remove("test")) i--;
//        }
//        ll.remove("test");

        System.out.println(ll.getClass());
//        ISinger stu = new Student(); Person p = (Person)stu;
        System.currentTimeMillis();
//        System.arraycopy();
    }
}

