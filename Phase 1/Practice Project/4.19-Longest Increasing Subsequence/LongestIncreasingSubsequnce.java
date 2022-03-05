import java.util.*;
import java.util.ArrayList;
import java.util.Iterator;
 
class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        
        Scanner sc= new Scanner(System.in);
        ArrayList<Integer> in= new ArrayList<Integer>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        ArrayList<Integer> longestList = new ArrayList<Integer>();
        int currentMax;
        int highestCount = 0; int num;
        System.out.print("Enter the number of elements to be entered in the sequence: ");
        int n= sc.nextInt();

        //Getting elements for the list
        System.out.println("Enter the elements");
        for (int i=0; i<n; i++) {
            num=sc.nextInt();
            in.add(num);
        }
        sc.close();

        for(int i = 0; i< in.size(); i++)
        {
            currentMax = in.get(i);
            list.add(in.get(i));
            for(int j = i; j< in.size(); j++)
            {
                if(in.get(j) > currentMax)
                {
                    list.add(in.get(j));
                    currentMax = in.get(j);
                }
            }
             
            //Compare previous highest subsequence
            if(highestCount < list.size())
            {
                highestCount = list.size();
                longestList.clear();
                longestList.addAll(list);
            }  
            list.clear();
        }
        System.out.println();
         
        //Print list
        Iterator<Integer> itr = longestList.iterator();
        System.out.println("The Longest subsequence");
        while(itr.hasNext())
        {
            System.out.print(itr.next() + " ");
        }
        System.out.println();
        System.out.println("Length of LIS: " + highestCount);
    }     
}