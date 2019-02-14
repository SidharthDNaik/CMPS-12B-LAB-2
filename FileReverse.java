import java.util.Scanner;
import java.io.*;

/*
* Name: Sidharth Naik
* ID: 1647945
* Class: 12B/M
* Date: January 25,2018
* Description: This is the code that contains all the methods for the FileReverse.
* File Name: Search.java
* Instructions: After compiling by using the make command in the command line
* type: FileReverse (source file name) (file to copy to) in the command line to run the code
*/

class FileReverse{

  public static String stringReverse(String s, int n){
    char[] reverseString = new char[n];
    for(int i = n-1, k = 0; i >= 0; i--, k++){
      reverseString[k] = s.charAt(i);
    }
    return new String(reverseString);
  }

  public static void main(String[] args) throws IOException {

    if(args.length >= 1){
      try {
        Scanner fileList = new Scanner(new File(args[0]));
      }
      catch(FileNotFoundException e){
        System.err.println(args[0] + " (No such file or directory)");
        System.err.println("Usage: FileCopy <file input>, <file output>");
        System.exit(1);
      }
    }

    if(args.length < 2){
      System.out.println("Usage: FileCopy <file input>, <file output>");
      System.exit(1);
    }

    Scanner fileList = new Scanner(new File(args[0]));
    PrintWriter newFile = new PrintWriter(new FileWriter(args[1]));
    int i, n, lineNumber = 0;
    String newLine;
    String[] fake;

    while( fileList.hasNextLine() ){
      lineNumber++;

      newLine = fileList.nextLine().trim() + " ";
      fake = newLine.split("\\s+");
      n = fake.length;
      for(i = 0; i < n; i++){
        fake[i] = stringReverse(fake[i],fake[i].length());
        newFile.println(" "+fake[i]);
      }
    }
    fileList.close();
    newFile.close();

  }

}
