import java.util.Scanner;

public class ArithmeticCalculator{
    public static void main(String args[]){
        System.out.println("//Welcome to the Arithmetic Calculator program//");
        Scanner sc= new Scanner(System.in);

        while(true){
        System.out.println("Select the operation that you want to perform");
        System.out.println("1. Additioin  2. Subtraction  3. Multiplication  4. Division  5. Exit (to exit the program)\n");
        //Getting operation selection from user
        int opr= sc.nextInt();

        //Addition
        if(opr==1){
            System.out.println("Enter the numbers for addition");
            Double a= sc.nextDouble();
            Double b= sc.nextDouble();
            Double c= a+b;
            System.out.println("Result of addition is "+c+"\n");
        }

        //Subtraction
        else if(opr==2){
            System.out.println("Enter the numbers for subtraction");
            Double a= sc.nextDouble();
            Double b= sc.nextDouble();
            Double c= a-b;
            System.out.println("Result of subtraction is "+c+"\n");
        }

        //Multiplication
        else if(opr==3){
            System.out.println("Enter the numbers for multiplication");
            Double a= sc.nextDouble();
            Double b= sc.nextDouble();
            Double c= a*b;
            System.out.println("Result of multiplication is "+c+"\n");            
        }

        //Division
        else if(opr==4){
            System.out.println("Enter the numbers for division");
            Double a= sc.nextDouble();
            Double b= sc.nextDouble();
            Double c= a/b;
            System.out.println("Result of division is "+c+"\n");
        }

        //Exiting program
        else if(opr==5){
            sc.close();
            System.exit(0);
        }

        //Handling invalid options
        else{
            System.out.println("Enter a correct option\n");
            continue;
        }
    }
    }
}