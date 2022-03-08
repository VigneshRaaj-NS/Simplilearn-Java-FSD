import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.io.IOException;


public class LockedMe {
    public static void main(String[] args) {
        //Welcome message starts here
        System.out.println("********************************************************************************\n");
        System.out.println("\t\t     \"Lockers Pvt. Ltd.\" \t");
        System.out.println("\t \"Welcome to the LockedMe.com application\" \t\n");
        System.out.println("\t This application provides you the following features");
        System.out.println("\t 1. To view all existing files & directories in ascending order");
        System.out.println("\t 2. To perform following file manipulation operations on this directory");
        System.out.println("\t    -> Create a new file in this directory that you want to create");
        System.out.println("\t    -> Delete a file that you want to be deleted from here");
        System.out.println("\t    -> Search a file you want to search for in the directory");
        System.out.println("\t 3. Close the application whenever you want!!");        
        System.out.println("\n********************************************************************************\n");
        //Welcome message ends here

        Scanner sc= new Scanner(System.in);

        File folder= new File("New Files");
        folder.mkdir(); //Making the directory New Files to store the files

        while(true){

            System.out.println("\t    **Main Menu**");
            System.out.println("Select from any of the following options:\n");
            System.out.println("1. To view all the files in the directory in ascending order");
            System.out.println("2. To perform new file creation, existing file deletion or search for a file in the directory");
            System.out.println("3. To close and exit the application\n");
            String op= sc.next().trim();

            //To view files in ascending order
            if(op.equals("1")){                
                String filesep= System.getProperty("file.separator");
                File flist=new File(folder,filesep);
                ArrayList<String> filenames= new ArrayList<String>(Arrays.asList(flist.list()));
                if(filenames.isEmpty()){
                    System.out.println("The directory is empty\n");
                }
                else{
                    System.out.println("The files present in the directory are: ");
                    Collections.sort(filenames);
                    for(String name: filenames){
                        System.out.println(name);
                    }
                    System.out.println();
                }
                continue;
            }

            //To perform file manipulations
            else if(op.equals("2")){
                fileManipulation(folder);             
                continue;
            }

            //To close the application
            else if(op.equals("3")){
                System.out.println("\nThank you for using LockedMe application. Have a nice day!!\n");
                System.exit(0);
            }

            //For invalid options
            else{
                System.out.println("\nThe option you entered is invalid!! Please enter a valid option\n");
                continue;
            }

        }

    }
    //End of main method() and start of operation methods

    static void fileManipulation(File folder){
        while(true){
            //Displaying options for file operations
            System.out.println("\t **File Operations menu**");
            System.out.println("Select the operation you want to perform:\n");
            System.out.println("1. To create and add a new file in the directory");
            System.out.println("2. To delete a file from the directory");
            System.out.println("3. To search for a particular file in the directory");
            System.out.println("4. To go back to the main menu\n");
            Scanner sc= new Scanner(System.in);
            String opr= sc.next().trim();

            //New file creation
            if(opr.equals("1")){
                System.out.println("Enter the name of the file you want to create with extension:");
                sc.nextLine();
                String file= sc.nextLine();
                File addfile= new File(folder, file);

                try {
                    if(addfile.createNewFile())
                        System.out.println("The file "+file+" is successfully added to the directory\n");
                    else
                        System.out.println("The given file "+file+" already exists in the directory\n");
                } 
                catch (IOException e) { 
                    System.out.println("Sorry!! The file creation operation of "+file+" was unsuccessful.\n");
                }

                continue;
            }

            //Deleting file from directory
            else if(opr.equals("2")){
                System.out.println("Enter the name of the file you want to delete:");
                sc.nextLine();
                String fname= sc.nextLine();
                File delfile= new File(folder,fname);
                if(delfile.exists()) {
                    if(delfile.delete()) {
                        System.out.println("The file "+fname+" was deleted successfully from the directory\n");
                    }
                    else{
                        System.out.println("The file deletion "+fname+" failed\n");
                    }
                }
                else{
                    System.out.println("The specified file "+fname+" was not found in the directory to get deleted\n");
                }
                continue;
            }

            //Searching file in directory
            else if(opr.equals("3")){
                System.out.println("Enter the file name you want to search:");
                sc.nextLine();
                String sfile= sc.nextLine();
                File searchfile= new File(folder, sfile);
                if(searchfile.exists()) {
                    System.out.println("The file "+sfile+" is present in the directory\n");
                }
                else{
                    System.out.println("The file "+sfile+" is not present in the directory\n");
                }

                continue;
            }

            //Redirect to main Menu
            else if(opr.equals("4")){
                sc.nextLine();
                System.out.println("Redirecting to main menu...\n");
                return;
            }

            //For invalid operation input
            else{
                sc.nextLine();
                System.out.println("\nThe option you entered is invalid!! Enter a valid option\n");
                continue;
            }

        }//End of file manipulation loop
    }//End of fileManipulation() method 
}