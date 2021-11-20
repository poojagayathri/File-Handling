/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filehandling;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pooja gayathri p v
 */
public class FileHandling {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int option_1,option_2;
        String name;
        do{
           System.out.println("WELCOME \n choose an option");
        System.out.println("1. Retrieve all the files");
        System.out.println("2. Perform file opertaions");
        System.out.println("3. Exit");
        Scanner scan=new Scanner(System.in);
        option_1=scan.nextInt();
        switch(option_1){
            case 1:
                File allFiles=new File("UserFiles");
                List<File> list=Arrays.asList(allFiles.listFiles());
                for(File file:list){
                    System.out.println(file);
                }
                break;
            case 2:
                do{
                    System.out.println("1. Create a file");
                    System.out.println("2. Delete a file");
                    System.out.println("3. Search a file");
                    System.out.println("4. Return to main menu");
                    option_2=scan.nextInt();
                    scan.nextLine();
                    switch(option_2){
                        case 1:
                            System.out.println("Enter the file name to be created");
                            name=scan.nextLine();
                            File create=new File("UserFiles\\"+name);
                           
                        try {
                            if (create.createNewFile()) {
                                System.out.println("File created: " + create.getName());
                            } else {
                                System.out.println("File already exists.");
                            }
                        } catch (IOException ex) {
                            Logger.getLogger(FileHandling.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    
                            //else
                                //create.mkdir();
                            break;
                        case 2:
                            System.out.println("Enter the file name to be deleted");
                            name=scan.nextLine();
                            File deleteFile=new File("UserFiles\\"+name);
                            if(deleteFile.exists())
                                deleteFile.delete();
                            else
                                System.out.println("File/Folder does not exist");
                            break;
                        case 3:
                            System.out.println("Enter the file name to search ");
                            String fileName=scan.nextLine();
                            File searchFile=new File("UserFiles");
                            File fileList[]=searchFile.listFiles();
                            System.out.println(fileList.length);
                            if(fileList.length==0)
                                System.out.println("No files starting with "+fileName);
                            for(File file : fileList){
                                if(file.getName().startsWith(fileName))
                                    System.out.println("File "+file);
                            }
                            break;
                        default:
                            break;
                    }
                }while(option_2<=3);
                
                break;
            case 3:
                break;
        }
        }
       while(option_1<=2);
                
                
                
                
                
                
    }
    
}
