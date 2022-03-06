import java.util.*;
import java.util.regex.*;

public class EmailID {
    public static void main(String[] args){
        ArrayList<String> emailList = new ArrayList<String>();
        Scanner sc = new Scanner(System.in);
        String s= new String(); int i= 0;

        //Adding Email IDs to the array emailList
        emailList.add("johnlennon@infymax.com");
        emailList.add("jose_butler@infymax.com");
        emailList.add("jonathan_greese@infymax.com");
        emailList.add("annie.parisse@infymax.com");
        emailList.add("sarah.shahi@infymax.com");
        emailList.add("haroldfinch@infymax.com");
        emailList.add("tomhanks@infymax.com");
        emailList.add("will.smith@infymax.com");
        emailList.add("leonard.corisson@infymax.com");
        emailList.add("juliaann@infymax.com");

        //Getting and validating Email IDs from the user to search it
        System.out.println("\nThere are 10 Email IDs registered in the system with '@infymax.com' as email domain name");
        System.out.println("Enter the Email ID to be searched\n");

        while(true){
            s= sc.next();

            if(s.equalsIgnoreCase("exit")){
                sc.close();
                System.exit(0);
            }

            boolean b= EmailID.validateEmail(s);
            if(b==true){
                if(emailList.contains(s)){
                    i = emailList.indexOf(s);
                    System.out.println("\nThe given Email ID "+s+" is present in "+(i+1)+"th position in the system");
                }

                else{
                    System.out.println("\nThe given Email ID "+s+" is not present in the system");
                }

                System.out.println("\nEnter 'Yes' if you want to see all the Email IDs present in the system or 'Exit' to exit");
                String op= sc.next();

                if(op.equalsIgnoreCase("Yes")){
                    ListIterator<String> itr= emailList.listIterator();
                    while(itr.hasNext()){
                        System.out.println(itr.next());
                    }
                    sc.close();
                    System.exit(0);
                }

                else{
                    System.exit(0);
                }
            }

            else{
                System.out.println("\nEnter a valid Email ID to continue the search or enter 'exit' to exit the program\n");
                continue;
            }
        }
    }

    public static boolean validateEmail(String email){
        String regex = "^[A-Za-z0-9+_.-]+@+\\binfymax.com\\b$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}