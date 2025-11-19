import java.util.*;

public class set {
    public static void main(String[] args) {
        Set<String> s = new HashSet<String>();
        s.add("First");
        s.add("Second");
        s.add("Third");
        s.add("Third");
        s.remove("Second");
        System.out.println(s.contains("Second"));
        System.out.println(s.size());
        System.out.println(s);

        System.out.println("print by loop");
        for (String str : s) {
            System.out.println(str);
        }
    }
}
