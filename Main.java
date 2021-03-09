import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

class Main {
  public static void main(String[] args) throws FileNotFoundException {
      //Creating scanner to read name from user
        Scanner scan=new Scanner(System.in);
        System.out.println("Enter year");
        int year=scan.nextInt();
        File text = new File("yob"+ (Integer.toString(year))+ ".txt");
        System.out.println("Enter name");
        String name=scan.next();
        System.out.println("Specify Gender (M/F)");
        String gender=scan.next();
        gender=gender.toUpperCase();
        System.out.print(gender);
        
        //Creating Scanner instnace to read File in Java
        Scanner scnr = new Scanner(text);
     
        //Reading each line of file using Scanner class
        int instances=0;
        String nameComp="";
        String genderComp="";
        while(scnr.hasNextLine()&& !(nameComp.equals(name)&&(genderComp.equals(gender)))){
            String line = scnr.nextLine();
            //System.out.println(line);
            nameComp="";
            genderComp="";
            int i=0;
            while ((line.charAt(i)!=(','))){
              nameComp+=line.charAt(i);
              i++;
            }
            i+=1;
            genderComp=line.substring(i,i+1);
            //System.out.println(genderComp);
            i+=2;
            instances=Integer.parseInt(line.substring(i));
        }  
        System.out.println("The name: "+ name + " appeared in the "+ year + " census " + instances + " times.");
  }
}