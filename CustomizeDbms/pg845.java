import java.util.*;
import java.io.*;

class Employee implements Serializable      // marker interface
{
    public int EmpID;
    public String EmpName;
    public int EmpAge;
    public String EmpAddres;
    public int EmpSalary;

    private static int Counter = 1;

    static
    {
       
        Counter = 1;
    }

   
        public Employee(String b,int c,String d,int e)
        {
          

            this.EmpID = Counter++;
            this.EmpName = b;
            this.EmpAge = c;
            this.EmpAddres = d;
            this.EmpSalary = e;
        }

        public void DisplayInformation()
        {
            System.out.println(" ID :"+this.EmpID+" Name :"+this.EmpName+" Age :"+this.EmpAge+" Address :"+this.EmpAddres+"Salary :"+this.EmpSalary);
        }
        
        public String toString()
        {
            return " ID :"+this.EmpID+" Name :"+this.EmpName+" Age :"+this.EmpAge+" Address :"+this.EmpAddres+"Salary :"+this.EmpSalary;
        }
}

class MarvellousDBMS implements Serializable
{
    private LinkedList <Employee> Table;

    public MarvellousDBMS()
    {
        System.out.println("Marvellous dbms stratrd Sucessfully...\n");
        Table = new LinkedList();
    }

    // insert into Employee values(1,"amit",23,"pune",21000)
    public void InsertIntoTable(
                                String name,
                                int age,
                                String  city,
                                int salary
                                )
    {
        Employee eobj = new Employee(name, salary, city, age);

        Table.add(eobj);

        System.out.println("MArvellousDBMS : new Record inserted Sucessfully..");

    }

    // selct * from Employee

    public void SelectStarFrom()
    {
        System.out.println("-------------------------------------------------------------------");
        System.out.println("data from the employee table ");
        System.out.println("-------------------------------------------------------------------");

        for(Employee eref : Table)
        {
            System.out.println(eref);
        }
        System.out.println("-------------------------------------------------------------------");
    }

    // incomplit
    public  static void RestoreBackup()
    {
        try{

        
         FileInputStream fos = new FileInputStream("MArvellous.ser");

                ObjectInputStream ois  = new ObjectInputStream(fos);
                ois.writeObject(this.Table);

                System.out.println("Sucessfully ");
        }
        catch (Exception eobj)
        {
            System.out.println("exception occured..");
        }
    }
    // Select * from Employee whewr eid = 11
    public void SelectSpecificId(int id)
    {
        boolean found  = false;
        for(Employee errf : Table)
        {
            if(errf.EmpID == id)
            {
                found = true;
                System.out.println(errf);
                break;
            }
           
        }
        if(found == false)
            {
                System.out.println("there is no such record .");
            }
    }
    public void SelectSpecificName(int name)
    {
        boolean found  = false;
        for(Employee errf : Table)
        {
            if(errf.EmpID == name)
            {
                found = true;
                System.out.println(errf);
               
            }
           
        }
        if(found == false)
            {
                System.out.println("there is no such record .");
            }
    }

    // delete from employee whwrwe
    public void deleteSpecificId(int id)
    {
        boolean found  = false;
        int index  = 0;

        for(Employee errf : Table)
        {
            if(errf.EmpID == id)
            {
                found = true;
                break;
            }
            index++;

           
        }
        if(found == false)
            {
                System.out.println("there is no such record .");
         
            }
            else
            {
                Table.remove(index);
                System.out.println("record Sucessfully deleteed");
            }

}

class pg845
{
    public static void main(String A[]) throws Exception
    {
        MarvellousDBMS mobj = new MarvellousDBMS();

        Scanner sobj = new Scanner(System.in);


        int iOption  = 0;
        int id  = 0;
        char name  = '\0';

        System.out.println("---------------------------------------------------------------------");
        System.out.println("-------------------------Marvellous Dbms-----------------------------");
        System.out.println("---------------------------------------------------------------------");

        while(iOption != 20)
        {
            System.out.println(("---------------------------------------------------------------------"));

            System.out.println("1 : insert into employee \n");
            System.out.println("2 : select * from employee \n");
            System.out.println("3 : Take a backup of table \n");
            System.out.println("4 : selct * from employee wherw empId = \n");
            System.out.println("5 : selct * from employee wherw name = \n");
            System.out.println("6 : delete forom Employee where eid =  \n");
            System.out.println("20 : terminate the operation\n");
            System.out.println(("---------------------------------------------------------------------"));
        
            System.out.println("Please select the desired operation on the DAtabase : \n");
            iOption = sobj.nextInt();

            if(iOption == 1)
            {
                mobj.InsertIntoTable("Sagar", 21,"pune", 23000);
            }
            else if(iOption == 2)
            {
                mobj.SelectStarFrom();
            }
            else if(iOption == 3)
            {
               mobj.TakeBackup();
            }
            else if(iOption == 4)
            {
                System.out.println("Enter employee id = ");
                id = sobj.nextInt();

                mobj.SelectSpecificId(id);

            }
            else if(iOption == 6)
            {
                System.out.println("Enter employee id = ");
                id = sobj.nextInt();

                mobj.deleteSpecificId(id);

            }
            
            else if(iOption == 20)
            {
                System.out.println("Thank you for using...");
                mobj = null;
                System.gc();
                break;
            }

        
        }// end of while
      
      
    }// End of main method
 }
}// End of main class 