package arraylistmaxmin;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;

public class ArrayListMaxMin
{
    //In this example it displayes only the max and min value but not displayes the complete record of max and min values so we have to
    //use some advanced concepts
    public static void main(String[] args)
    {
        String filepath = "C:\\Users\\Shivu\\IdeaProjects\\DATASETS\\almaxmin.csv";
        ArrayList<String> LinesRead = new ArrayList<>();
        ArrayList<Student> records = new ArrayList<>();

        try {
            FileReader fr = new FileReader(filepath);
            BufferedReader br = new BufferedReader(fr);
            String currentline = br.readLine();

            while (currentline != null)
            {
                LinesRead.add(currentline);// Add line to String Arraylist
                currentline = br.readLine();
            }
            br.close();
            fr.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        //Displaying Names List,AgeList,MarksList
        ArrayList<String> nameList=new ArrayList<>();
        ArrayList<Integer> ageList=new ArrayList<>();
        ArrayList<Double> marksList=new ArrayList<>();

        Student sobj;
        for(String s:LinesRead)
        {
            String[] tokens=s.split(",");
            sobj=new Student(Integer.parseInt(tokens[0]), tokens[1], Integer.parseInt(tokens[2]), Double.parseDouble(tokens[3]));
            records.add(sobj);
            nameList.add(sobj.getName());
            ageList.add(sobj.getAge());
            marksList.add(sobj.getMarks());
        }
        System.out.println("Size of the records:" +records.size());
        //System.out.println("Elements in the records are:" +records);
        System.out.println("*************************************");

        //Using Enhanced for loop
        System.out.println("Now printing Object Values");
        for (Student st : records) {
            System.out.println(st.getRollNo()+ " " + st.getName() + " " + st.getAge() + " " + st.getMarks());
            //System.out.println("*************************************");
        }

        //Find Max age, Max Marks and Alphabetically Last name
        double maxmarks= Collections.max(marksList);
        System.out.println("Maximum Marks is:" +maxmarks);
        System.out.println("*************************************");

        int maxage=Collections.max(ageList);
        System.out.println("Maximum Age is:" +maxage);
        System.out.println("*************************************");


        //Always max displayes the Lastname becoz index value of lastname is more than the index value of firstname
        String lastname=Collections.max(nameList);
        System.out.println("Lastname of the record is:" +lastname);
        System.out.println("*************************************");

        double minmarks= Collections.min(marksList);
        System.out.println("Minimum Marks is:" +minmarks);
        System.out.println("*************************************");

        int minage=Collections.min(ageList);
        System.out.println("Minimum Age is:" +minage);
        System.out.println("*************************************");

        //Always min displayes the Firstname becoz index value of firstname is less than the index value of lastname
        String firstname=Collections.min(nameList);
        System.out.println("Firstname of the record is:" +firstname);
        System.out.println("*************************************");
    }
}