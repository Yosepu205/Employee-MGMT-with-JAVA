import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;


class temp {
  public String ID, Mobile, name, Email, Password;
};

class Login{
  Scanner sc=new Scanner(System.in);
  public Login(){
    System.out.println("=============================");
    System.out.println("|welcome to JAVA Technologies|");
    System.out.println("=============================");
  }

  public void Admin(){

    Scanner sc=new Scanner(System.in);
    System.out.println("\nHey Admin! Please Enter your credentials to Login\n");
    System.out.println("\nEmail Address : ");
    String ID=sc.nextLine();
    System.out.println("Password      : ");
    String Password=sc.nextLine();

    try{
      File fin=new File("Admin.txt");
      Scanner read=new Scanner(fin);
      String sample=read.nextLine();
      String sample1=read.nextLine();
      read.close();
      
      if(sample.equals(ID) && sample1.equals(Password))
          {
            Employee Emp= new Employee();
            Boolean choice =true;
            System.out.println("\n1. Add Employee details\n2. List all Employees details\n3. Update  Employee details\n4. Search by ID\n");
            while (choice) {
              System.out.println("Enter Your Choice :");
              int option=sc.nextInt();
              switch (option) {
              case 1:
                Emp.add_Emp();
                break;
              case 2:
                Emp.list_Emp();
                break;
              case 3:
                Emp.update_Emp();
                break;
              case 4:
                Emp.search_id();
                break;
              default:
                System.out.println("\nEnter correct input\n\n");
              }
              System.out.println("\nEnter 0 to exit or anything to continue :");
              choice=sc.nextBoolean();
              if (choice == false)
                System.out.println("Thank you for choosing JAVA TECH!");
            }

        }
        else
        {
          System.out.println("\n*** Invalid Credentials ***\n");
        }
    }
    catch(FileNotFoundException e)
      {
        System.out.println("An Error occured");
        e.printStackTrace();
      }
      
      }

  public void Resource(){
    Boolean flag= false;
      System.out.println("\nHello Employee! Please Enter your credentials to Login\n");
      System.out.println("\nEmail Address : ");
      String Email=sc.nextLine();
      System.out.println("Password      : ");
      String Password=sc.nextLine();

      try{
      File fin=new File("Employee.txt");
      Scanner read=new Scanner(fin);
      while(read.hasNextLine())
        {
          String sample1=read.nextLine();
          String sample=read.nextLine();
          sample=read.nextLine();
          if(sample!=Email)
          {
            sample=read.nextLine();
            continue;
          }
          if(sample.equals(Email) && sample1.equals(Password))
          {
            flag = true;
            Workplace work=new Workplace();
            Boolean choice = true;
            System.out.println("\n1. Timesheet Management\n2. Leave Management\n3. Policy center \n4. My Learnings\n");
            while (choice) 
            {
              System.out.println("Enter Your Choice :");
              int option=sc.nextInt();
              System.out.println();
              switch (option) {
              case 1:
                work.TimeSheet();
                break;
              case 2:
                work.Leave_mgmt();
                break;
              case 3:
                work.Policies();
                break;
              case 4:
                work.MyLearnings();
                break;
              default:
                System.out.println("Enter correct input\n\n");
              }
              System.out.println("\nEnter 0 to exit or anything to continue :");
              choice=sc.nextBoolean();
              if (choice == false)
               System.out.println("Thank you!");
          }
          }  
        }
      read.close();
      if(flag==false)
      {
      System.out.println("\n*** Invalid Credentials ***\n");  
      }
    }
      catch(FileNotFoundException e){
      System.out.println("An error occured");
      e.printStackTrace();
  }
  }

  public class Employee{
    public Employee() {
    System.out.println("\n=======================================\n");
    System.out.println("|Welcome to Employee Management System|\n");
    System.out.println("=======================================\n");
  }

    public void add_Emp(){
      temp obj1=new temp();
        System.out.println("Enter Employee ID     :");
        obj1.ID=sc.nextLine();
        System.out.println("Enter Employee Name   :");
        obj1.name=sc.nextLine();
        System.out.println("Enter Employee E-mail :");
        obj1.Email=sc.nextLine();
        System.out.println("Enter Employee Mobile :");
        obj1.Mobile=sc.nextLine();
        System.out.println("Enter New Password    :");
        String temppass=sc.nextLine();
        System.out.println("Confirm New Password  :");
        obj1.Password=sc.nextLine();
        if(temppass.equals(obj1.Password))
        {
          try{
            FileWriter writer= new FileWriter("Employee.txt",true);
            writer.write(obj1.ID+"\n"+obj1.Password+"\n"+obj1.name+"\n"+obj1.Email+"\n"+obj1.Mobile+"\n");
            writer.close();
            System.out.println("\nEmployee Details added successfully \n");
          }
          catch(IOException e){
            System.out.println("An error occured");
            e.printStackTrace();
          }

        }
        else
        System.out.println("\n$$$ Passwords do not match, try again $$$\n");
    }

    public void list_Emp(){
      temp obj4=new temp();
      System.out.println("Available Employees are :\n\n");
      String sample;
      int i = 1;
      try{
      File fin=new File("Employee.txt");
      Scanner read1=new Scanner(fin);
      while(read1.hasNextLine()){
        sample = read1.nextLine();
        obj4.Password=read1.nextLine();
        obj4.name=read1.nextLine();
        obj4.Email=read1.nextLine();
        obj4.Mobile=read1.nextLine();
        System.out.println("Employee "+i+" ID : " +sample+"\n");
        i++;
      }
      read1.close();
      System.out.println("\nEmployee Details listed successfully \n");
    }
    catch(FileNotFoundException e)
    {
      System.out.println("An Error occured");
      e.printStackTrace();
    }
    }

    public void update_Emp(){
      temp obj3=new temp();
      Boolean flag=false;
      System.out.println("Enter Employee ID :");
      String ID=sc.nextLine();
      try{
      File file=new File("Emplpyee.txt");
      Scanner read=new Scanner(file);
      while (read.hasNextLine())
        {
          String sample=read.nextLine();
          if (sample.equals(ID))
            flag =true;
        }
      read.close();
      if (flag == true)
      {
      System.out.println("Enter New Employee ID :");
      String newID=sc.nextLine();
      System.out.println("Enter new Name        :");
      String name=sc.nextLine();
      System.out.println("Enter new E-mail      :");
      String Email=sc.nextLine();
      System.out.println("Enter new Mobile      :");
      String Mobile=sc.nextLine();
      System.out.println("Enter New Password    :");
      String temppass=sc.nextLine();
      System.out.println("Confirm New Password  :");
      String pass=sc.nextLine();
      if(temppass.equals(pass))
      {
        try{
          File ofile=new File("Employee.txt");
          Scanner reader=new Scanner(ofile);
          FileWriter nfile=new FileWriter("temp.txt");

          while (reader.hasNextLine()) {
            String sample=reader.nextLine();
            if (sample.equals(ID)) 
            {
              nfile.write(newID+"\n"+pass+"\n"+ name +"\n"+ Email +"\n"+ Mobile +"\n");
              obj3.Password=reader.nextLine();
              obj3.name=reader.nextLine();
              obj3.Email=reader.nextLine();
              obj3.Mobile=reader.nextLine();
            } 
            else
              nfile.write(sample +"\n");
          }
          reader.close();
          nfile.close();
          File mfile=new File("temp.txt");
          mfile.renameTo(ofile);
          ofile.delete();
          
          System.out.println("\nEmployee Details Updated successfully \n");
          }
        catch(IOException e){
          System.out.println("An error occured");
          e.printStackTrace();
        }
      }
      else
      System.out.println("\nPasswords do not match, try again\n");
      }
      else
        System.out.println("\nEmployee details not found\n"); 
    }
      catch(FileNotFoundException e){
        System.out.println("An error occured");
        e.printStackTrace();
      }
    }

    public void search_id(){
    temp obj2=new temp();
    Boolean flag = false;
    System.out.println("Enter Employee ID     :");
    String ID=sc.nextLine();
    try{
    File file=new File("Employee.txt");
      Scanner fin=new Scanner(file);
    while (fin.hasNextLine()) {
      String sample= fin.nextLine();
      if (sample.equals(ID)) {
        flag = true;
        obj2.Password= fin.nextLine();
        obj2.name= fin.nextLine();
        obj2.Email= fin.nextLine();
        obj2.Mobile= fin.nextLine();
        System.out.println("\nEmployee ID     : "+sample);
        System.out.println("Employee Name   : "+obj2.name);
        System.out.println("Employee E-mail : "+obj2.Email);
        System.out.println("Employee Mobile : "+obj2.Mobile);
        break;
      }
    }
    fin.close();
    if (flag == true)
      System.out.println("\nEmployee Details Fetched successfully ");
    else
      System.out.println("\nEmployee details not found\n");
    }
    catch(FileNotFoundException e){
      System.out.println("An error occured");
      e.printStackTrace();
    }
  }
}

public class Workplace{
  Workplace() {
    System.out.println("\n=========================\n");
    System.out.println("|Welcome to My Workplace|\n");
    System.out.println("=========================\n");
  }

  public void TimeSheet(){
    System.out.println("Time Sheet has been updated\n");
  }

  public void Leave_mgmt(){
    System.out.println("Leave ledger has been fetched\n");
  }

  public void Policies(){
    System.out.println("These are your Policies\n");
  }

  public void MyLearnings(){
    System.out.println("You have no due in MyLearning\n");
  }

}
}

public class Main{
  public static void main(String[] args){
    Login login= new Login();
    Scanner sc=new Scanner(System.in);
    String person;
    System.out.println("Choose your profile :\nA. Admin \nB. Employee \n");
      person=sc.nextLine();
      if(person == "A")
      {
        login.Admin();
      }
      else if(person == "B")
      {
        login.Resource();
      }
      else
        System.out.println("\n*** Invalid Input, Try Again ***\n\n");
    }
  }


