import java.util.ArrayList;
import java.util.Collections;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        /*System.out.println("Hello World!");*/
        System.out.println("\n**************************************\n");
        System.out.println("\tWelcome to The Desk \n");
        System.out.println("**************************************");
        optionsSelection();

    }


    private static void optionsSelection() {
        String[] arr = {"1. I wish to review my expenditure",
                "2. I wish to add my expenditure",
                "3. I wish to delete my expenditure",
                "4. I wish to sort the expenditures",
                "5. I wish to search for a particular expenditure",
                "6. Close the application"};
        int[] arr1 = {1,2,3,4,5,6};
        int  slen = arr1.length;
        for(int i=0; i<slen; i++){
            System.out.println(arr[i]);
            // display the all the Strings mentioned in the String array
        }
        ArrayList<Integer> arrlist = new ArrayList<Integer>();
        ArrayList<Integer> expenses = new ArrayList<Integer>();
        //Default expenses that were added when the system starts
        expenses.add(1000);
        expenses.add(2300);
        expenses.add(45000);
        expenses.add(32000);
        expenses.add(110);
        expenses.addAll(arrlist);
        System.out.println("\nEnter your choice:");
        Scanner sc = new Scanner(System.in);
        int  options =  sc.nextInt();
        while(true){
            switch (options){
                case 1:
                    System.out.println("\nYour saved expenses are listed below:");
                    System.out.println(expenses+"\n");
                    for(int i=0; i<slen; i++){
                        System.out.println(arr[i]);
                        // display the all the Strings mentioned in the String array
                    }
                    System.out.println("\nEnter your choice:");
                    options= sc.nextInt();
                    break;
                case 2:
                    System.out.println("\nEnter the value to add your Expense:");
                    int value = sc.nextInt();
                    expenses.add(value);
                    System.out.println("\nYour value is updated");
                    expenses.addAll(arrlist);
                    System.out.println(expenses+"\n");
                    for(int i=0; i<slen; i++){
                        System.out.println(arr[i]);
                        // display the all the Strings mentioned in the String array
                    }
                    System.out.println("\nEnter your choice:");
                    options= sc.nextInt();
                    break;
                case 3:
                    System.out.println("\nYou are about to delete all your expenses! \nConfirm again by selecting the same option...");
                    int con_choice = sc.nextInt();
                    if(con_choice==3){
                        expenses.clear();
                        System.out.println(expenses+"\n");
                        System.out.println("All your expenses are erased!\n");
                    } else {
                        System.out.println("\nOops... try again!");
                    }
                    for(int i=0; i<slen; i++){
                        System.out.println(arr[i]);
                        // display the all the Strings mentioned in the String array
                    }
                    System.out.println("\nEnter your choice:");
                    options= sc.nextInt();
                    break;
                case 4:
                    ArrayList<Integer> sortexp= new ArrayList<Integer>();
                    sortexp.addAll(sortExpenses(expenses, 0, (expenses.size()-1)));
                    expenses.clear();
                    expenses.addAll(sortexp);
                    System.out.println(expenses+"\n");
                    for(int i=0; i<slen; i++){
                        System.out.println(arr[i]);
                        // display the all the Strings mentioned in the String array
                    }
                    System.out.println("\nEnter your choice:");
                    options= sc.nextInt();
                    break;
                case 5:
                    searchExpenses(expenses);
                    for(int i=0; i<slen; i++){
                        System.out.println(arr[i]);
                        // display the all the Strings mentioned in the String array
                    }
                    System.out.println("\nEnter your choice:");
                    options= sc.nextInt();
                    break;
                case 6:
                    closeApp();
                    System.exit(0);
                default:
                    System.out.println("You have made an invalid choice!");
                    for(int i=0; i<slen; i++){
                        System.out.println(arr[i]);
                        // display the all the Strings mentioned in the String array
                    }
                    System.out.println("\nEnter your choice:");
                    options= sc.nextInt();
                    break;
            }
        }
    }


    static void closeApp() {
        System.out.println("Closing your application... \nThank you!");
    }

    static void searchExpenses(ArrayList<Integer> arrayList) {
        //Complete the method
        System.out.println("Enter the expense you need to search:\t");
        Scanner sc= new Scanner(System.in);
        int exp= sc.nextInt(); int f=0;
        //Checking if the element is present
        ListIterator<Integer> itr= arrayList.listIterator();

        if(arrayList.isEmpty()){
            System.out.println("The given amount "+exp+" is not present in the expenses list\n");
            return;
        }

        else{
            while(itr.hasNext()==true){
                if(exp==itr.next()){
                    f=1;
                    System.out.println("The given amount "+exp+" is present in the expenses list\n");
                    return;
                }
            }
        }

        if(f==0){
            System.out.println("The given amount "+exp+" is not present in the expenses list\n");
            return;
        }
    }

    static ArrayList<Integer> sortExpenses(ArrayList<Integer> list, int a, int b){
        //Complete the method
        if (a >= b) 
            return list;

        int pivot = list.get(b);

        int left = a;
        int right = b;

        while (left < right)
        {
            while(list.get(left).compareTo(pivot) < 0)
                left++;

            while(list.get(right).compareTo(pivot) > 0)
                right--;

            if (right > left);
            {
                Collections.swap(list, left, right);
            }
        }

        sortExpenses(list, a, right-1);
        sortExpenses(list, right+1, b);

        return list;
    }
}