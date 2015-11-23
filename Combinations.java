import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Combinations {

    public static void main(String[] args) {
        List<String> l1 = Arrays.asList("abc", "def" , "xyz");
        List<String> l2 = Arrays.asList("123");
        List<String> l3 = Arrays.asList("()", "<>");
        List<List<String>> lists = Arrays.asList(l1, l2,l3);
        List<List<String>> allSubsets = allSubsets(lists);
     //   for (List<String> subset : allSubsets) {
    //        System.out.println(subset);
    //    }
        Queue<String> pr = new LinkedList<String>();
        
        pr.add("hi");
        pr.add("hey");
        System.out.println(pr);
        System.out.println(pr.poll());
        System.out.println(pr);
        
    }

    static List<List<String>> allSubsets(List<List<String>> lists) {
        if (lists.isEmpty()) {
            List<String> empty = new ArrayList<String>();
            return Arrays.asList(empty);
        }

        List<List<String>> reduced = new ArrayList<List<String>>();
        reduced.addAll(lists);
        List<String> list = reduced.remove(0);
        List<List<String>> subsets = allSubsets(reduced);
        List<List<String>> newSubsets = new ArrayList<List<String>>(subsets);
        for (List<String> subset : subsets) {
            for (String s : list) {
                List<String> newSubset = new ArrayList<String>(subset);
                newSubset.add(s);
                newSubsets.add(newSubset);
            }
        }
        return newSubsets;
    }
}