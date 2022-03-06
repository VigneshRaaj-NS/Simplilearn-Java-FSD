import java.util.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileHandling{
    public static void main(String args[]){
        Scanner sc= new Scanner(System.in);
        String filesep= System.getProperty("file.separator");
        String fname, d, n= "";       

        try{
            //File creation part
            while(true){
                //Getting the file name
                System.out.println("Choose the option for creating the file\n\n1. Create file with only file name (Specify only name, not extensions or file type)");
                System.out.println("2. Create file in specific directory path (Specify absolute directory path)\n");
                n= sc.next();
                //Creating file with only file name
                if(Integer.parseInt(n)==1){
                    sc.nextLine();
                    System.out.print("Enter the file name: ");
                    fname = sc.nextLine();
                    fname= fname+".txt";
                    File f = new File(fname);

                    //Checking file creation operation's success
                    if (f.createNewFile()) {  
                        System.out.println("File " + f.getName() + " is created successfully.");
                        break;
                    } 
                    else {  
                        System.out.println("Given file already exists");
                        break;
                    }
                }

                //Creating file with specific directory path
                else if(Integer.parseInt(n)==2){
                    sc.nextLine();
                    System.out.print("Enter directory path: ");
                    d= sc.nextLine();
                    System.out.print("Enter the file name: ");
                    fname= sc.nextLine();
                    fname= d+filesep+fname+".txt";
                    
                    File f = new File(fname);
                    //Checking file creation operation's success
                    if (f.createNewFile()) {  
                        System.out.println("File " + f.getName() + " is created successfully.");
                        break; 
                    } 
                    else {  
                        System.out.println("Given file already exists");
                        break;
                    }
                }

                else{
                    System.out.println("Enter a valid option");
                    continue;
                }
            }
            //File creation ends here

            //Checking properties of the file
            File f = new File(fname);
            System.out.println("\nFile name: "+f.getName());
            System.out.println("Path of file: "+f.getPath());
            System.out.println("Absolute path of file: "+f.getAbsolutePath());

            while(true){
                //File operations
                System.out.println("\nSelect an option to perform the operation\n1. Write to the file\n2. Read from the file");
                System.out.println("3. Append to the file\n");
                String opr= sc.next();

                //Write operations
                if(Integer.parseInt(opr)==1){
                    sc.nextLine();
                    File f1= new File(fname);
                    FileWriter fwrite= new FileWriter(f1);
                    System.out.println("Enter the content to be written on the file");
                    String towrite= sc.nextLine();
                    fwrite.write(towrite);
                    fwrite.close();
                    System.out.println("Content is written successfully on the file "+f1.getName());
                    sc.close();
                    break;
                }

                //Read operation
                else if(Integer.parseInt(opr)==2){
                    sc.nextLine();
                    File f1= new File(fname);
                    Scanner dataReader = new Scanner(f1);
                    if(dataReader.hasNextLine()){ 
                        while (dataReader.hasNextLine()){  
                            String fileData = dataReader.nextLine();  
                            System.out.println(fileData);  
                        }
                    }
                    else{
                        System.out.println("File has no contents to be read");
                    }

                    dataReader.close();
                    break;
                }

                //Append operation
                else if(Integer.parseInt(opr)==3){
                    sc.nextLine();
                    File f1= new File(fname);
                    FileWriter fwrite= new FileWriter(f1, true);
                    System.out.println("Enter the content to be appended on the file");
                    String towrite= sc.nextLine();
                    fwrite.append(towrite);
                    fwrite.close();
                    System.out.println("Content is appended successfully on the file "+f1.getName());
                    break;
                }

                //Invalid option
                else{
                    System.out.println("Enter a valid option");
                    continue;
                }
            }
        }        

        catch(IOException e){
            e.printStackTrace();
            System.out.println("Error occurred; File creation or file content manipulation failed");
            sc.close();
            System.exit(0);
        }
    }
}