package arraylistfileread;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListFileRead
{
    public static void main(String[] args)
    {
        ArrayList<String> LinesRead=new ArrayList<>();

        ArrayList<Student> records=new ArrayList<>();

        String filepath="C:\\Users\\Shivu\\IdeaProjects\\DATASETS\\arrayliststd.csv";
        String filepath1="C:\\Users\\Shivu\\IdeaProjects\\DATASETS\\arraylistoptfile.txt";

        try
        {
            FileReader fr=new FileReader(filepath);
            BufferedReader br=new BufferedReader(fr);
            String currentLine=br.readLine();

            while(currentLine!=null)
            {
                LinesRead.add(currentLine);
                currentLine=br.readLine();
            }
            br.close();
            fr.close();

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        //To get the size of the Arraylist
        int length=LinesRead.size();
        System.out.println("Display size of the ArrayList:" +length);
        System.out.println("***************************************");

        Student sobj;
        for(String s:LinesRead)
        {
          String[] tokens=s.split(",");
          sobj=new Student(Integer.parseInt(tokens[0]), tokens[1],Integer.parseInt(tokens[2]));
          records.add(sobj);
        }

        length=records.size();
        System.out.println("Display size of the ArrayList:" +length);
        System.out.println("***************************************");

/*         for(Student st:records)//1st way
        {
            System.out.println(st);
        }
        System.out.println("***************************************");*/

        for(Student st:records)//2nd way
        {
            System.out.println(st.getRollno() +" " + st.getName() +" " + st.getAge());
        }
        System.out.println("***************************************");

        for(int i=0;i<length;i++)//3rd way
        {
            System.out.println(records.get(i).getRollno()+" " + records.get(i).getName()+" " + records.get(i).getAge());
            //Here records.get(i) is treated as Student object "sobj"
        }

        //Printing the specific values through user input
        System.out.println("Printing the Specific Values");
        Scanner sc=new Scanner(System.in);


        //Display the Names which matches the user input
        System.out.println("Enter Name");
        String name=sc.next();
        for(Student st:records)
        {

            if(name.equals(st.getName()))
            {
                System.out.println(st.getRollno() +" " + st.getName() +" " + st.getAge());
            }
        }


        //Displaying the records which matches the user input means names should start from that letter(user input)
        System.out.println("Enter Char");
        char c=sc.next().charAt(0);
        for(Student st:records)
        {

            if(c==(st.getName().charAt(0)))
            {
                System.out.println(st.getRollno() +" " + st.getName() +" " + st.getAge());
            }
        }

        //Display the perticular age which matches the user input
        System.out.println("Enter Age");
        int age=sc.nextInt();
        for(Student st:records)
        {

            if(age==st.getAge())
            {
                System.out.println(st.getRollno() +" " + st.getName() +" " + st.getAge());
            }
        }

        //Display the perticular age and name which matches the user input
        System.out.println("Enter Age");
        for (Student st:records)
        {
            if(age==st.getAge()&&c==st.getName().charAt(0))
            {
                System.out.println(st.getRollno() +" " + st.getName() +" " + st.getAge());
            }
        }

        String output="";
        for(Student st:records)
        {
            output +=st.getRollno() + " " + st.getName() + " " + st.getAge() + " \n";

            if(name.equals(st.getName()))
            {
                output +=st.getRollno() +" " + st.getName() +" " + st.getAge() + " \n";
            }

        }

        ArrayListFileWrite alwr=new ArrayListFileWrite();
        System.out.println("Content to be written in target file:" +records);
        alwr.writeToFile(output, filepath1);
    }
}
