import java.util.*;
import java.time.LocalDate;
import java.io.*;

//done
class StudyLog
{
    public LocalDate Date;
    public String Subject;
    public Double Duration;
    public String Discription;
   

    public StudyLog(LocalDate A,String B,Double C,String D)
    {
        this.Date = A;
        this.Subject = B;
        this.Duration = C;
        this.Discription = D;
    }
    @Override
    public String toString()
    {
        return Date+" | "+ Subject+" | "+Duration+" | "+Discription;
    }
    public LocalDate getDate()
    {
        return Date;
    }
    public String getSubject()
    {
        return Subject;
    }
    public double getDuration()
    {
        return Duration;
    }
    public String getDiscription()
    {
        return Discription;
    }
}
class StudyTracker
{
    // Data structure to hold the data about the study
    private ArrayList<StudyLog> Database = new ArrayList<StudyLog>();

    public void InsertLog()
    {
        Scanner Scannerobj = new Scanner(System.in);
        System.out.println("-------------------------------------------------------------");
        System.out.println("------please Enter the valid details of your Study-----------");
        System.out.println("-------------------------------------------------------------");


        LocalDate Dateobj = LocalDate.now();
        System.out.println("please prvide the name of subject like C/C++/Java/OS/DS");
        String sub = Scannerobj.nextLine();

        System.out.println("Enter the time period of your Study in Hr");
        double dur = Scannerobj.nextDouble();
        Scannerobj.nextLine();

        System.out.println("Please provide the discription about the study for future Reference");
        String desc = Scannerobj.nextLine();

        StudyLog Studyobj = new StudyLog(Dateobj,sub,dur,desc);

        Database.add(Studyobj);

        System.out.println("Study Log gets stored sucessfully");
        System.out.println("-------------------------------------------------------------");

       
    }
    public void DisplayLog()
    {
        System.out.println("-------------------------------------------------------------");

        if(Database.isEmpty())
        {
            System.out.println("Nothing to display as database as empty");
            System.out.println("-------------------------------------------------------------");
            return;
        }
         System.out.println("-------------------------------------------------------------");
         System.out.println("Log report form Marvellous study tracker");

        for(StudyLog sobj: Database)
         {
            System.out.println(sobj);
         }
        System.out.println("-------------------------------------------------------------");




 
    }
    public void ExportCSV()
    {
       if(Database.isEmpty())
        {
             System.out.println("-------------------------------------------------------------");
            System.out.println("Nothing to export as database is empty");
            System.out.println("-------------------------------------------------------------");
            return;
        } 
        String Filename = "MarvellousStudy.csv";

       try(FileWriter fwobj = new FileWriter(Filename))
       {
        //wite cvs header
        fwobj.write(" Date,Subject,Duration,Discription\n");

        //travel database
        for(StudyLog sobj: Database)
         {
            // write each line 
            fwobj.write((sobj.getDate())+","+
                                sobj.getSubject().replace(",", " ")+","+
                                sobj.getDuration()+","+
                                sobj.getDiscription().replace(",", " ")+"\n"
                              );
         }
         System.out.println("Log created Sucessfully ");
       }
       catch (Exception eobj) 
       {
        System.out.println("exception occured while creating the csv.");
        System.out.println("report the issuse to marvellous infosystem");
       }
    }
    public void SummaryByDate()
    {
         System.out.println("-------------------------------------------------------------");

        if(Database.isEmpty())
        {
            System.out.println("Nothing to display as database as empty");
            System.out.println("-------------------------------------------------------------");
            return;
        }
         System.out.println("-------------------------------------------------------------");
         System.out.println("Summary by date Marvellous study tracker");

         TreeMap<LocalDate, Double> tobj = new TreeMap<LocalDate, Double>();
         LocalDate lobj = null;
         double d,old;
        for(StudyLog sobj: Database)
         {
           lobj = sobj.getDate();
           d = sobj.getDuration();
           if(tobj.containsKey(lobj))
           {
            old = tobj.get(lobj);
            tobj.put(lobj,d+old);
           }
           else
           {
            tobj.put(lobj,d);
           }
         }
         // Display the details as per date
         for(LocalDate ldbj :tobj.keySet())
         {
            System.out.printf(" date "+lobj+" total study "+tobj.get(ldbj));
         }
        System.out.println("-------------------------------------------------------------");
    }
    public void SummaryBySubject()
    {
         System.out.println("-------------------------------------------------------------");

        if(Database.isEmpty())
        {
            System.out.println("-------------------------------------------------------------");
            System.out.println("Nothing to display as database as empty");
            System.out.println("-------------------------------------------------------------");
            return;
        }
         System.out.println("-------------------------------------------------------------");
         System.out.println("Summary by Subject Marvellous study tracker");
         System.out.println("-------------------------------------------------------------");

         TreeMap<String, Double> tobj = new TreeMap<String, Double>();

         double d ,old;
         String s;

        for(StudyLog sobj: Database)
         {
           
           s = sobj.getSubject();
           d = sobj.getDuration();
           if(tobj.containsKey(s))
           {
            old = tobj.get(s);
            tobj.put(s,d+old);
           }
           else
           {
            tobj.put(s,d);
           }
         }
         // Display the details as per Subject
         for(String str :tobj.keySet())
         {
            System.out.printf(" Subject "+str+" total study "+tobj.get(str));
         }
        System.out.println("-------------------------------------------------------------");
    }
    

}
class pg558    //StudyTrackerStarter
{
    public static void main(String A[])
    {
        StudyTracker stobj = new StudyTracker();
        Scanner Scannerobj = new Scanner(System.in);
        int iChoise = 0;
         System.out.println("-------------------------------------------------------------");
        System.out.println("------welcome to Marvellous Study Tracker Application---------");
        System.out.println("-------------------------------------------------------------");

        do
        {
            System.out.println("please select the appropiate option");
            System.out.println("1 : insert new Study Log into Database");
            System.out.println("2 : vivw All study log");
            System.out.println("3 : Summary of log by date");
            System.out.println("4 : Summary of log by Subject");
            System.out.println("5 : Export stuy log to csv");
            System.out.println("6 : Exit");

            iChoise = Scannerobj.nextInt();

            switch (iChoise)
            {
                case 1:                              // insert new Study Log into Database
                    stobj.InsertLog();
                    break;

                case 2:                             // vivw All study log
                    stobj.DisplayLog();
                    break;

                case 3:                             //Summary of log by date
                    stobj.SummaryByDate();
                    break;

                case 4:                             //Summary of log by date
                    stobj.SummaryBySubject();
                    break;

                case 5:                           // Export stuy log to csv
                    stobj.ExportCSV();
                    break;

                case 6:         //exit
                   
                    System.out.println("-------------------------------------------------------------");
                    System.out.println("thanky yoy for using marvellous log application");
                    System.out.println("-------------------------------------------------------------");
                    System.exit(0);
                    break;
        
                default:
                    System.out.println("please enter the valid option");
                    
            }

        }while(iChoise != 0);

       
    }
}