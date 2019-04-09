package arraylistmaxminadvanced;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ArrayListMaxMinAdvanced
{
    public static void main(String[] args)
    {
        String filepath="C:\\Users\\Shivu\\IdeaProjects\\DATASETS\\almaxminadv.csv";
        ArrayList<String> linesRead=new ArrayList<>();
        ArrayList<Student> records=new ArrayList<>();

        try
        {
            FileReader fr=new FileReader(filepath);
            BufferedReader br=new BufferedReader(fr);
            String currentLine=br.readLine();

            while(currentLine!=null)
            {
                linesRead.add(currentLine);
                currentLine=br.readLine();
            }
            br.close();
            fr.close();

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        Student sobj;
        for(String s:linesRead)
        {
            String[] tokens=s.split(",");
            sobj=new Student(Integer.parseInt(tokens[0]), tokens[1], Integer.parseInt(tokens[2]), Double.parseDouble(tokens[3]));
            records.add(sobj);
        }

         // System.out.println("Array Elements are:\n" +linesRead + " \n");

        for(String s:linesRead)
        {
            System.out.println(s);
        }
        System.out.println();

        //First way of displaying the records using Collections.max and Collections.min(Utilities)
        Student element;

        //Displayes the highest roll no along with complete student details
        element= Collections.max(records, Comparator.comparingInt(Student::getRollNo));
        System.out.println("Maximum Roll No is:"+element.getRollNo());
        printStudentDetails("Student detials having highest roll no:" , element);
        System.out.println("*********************************************************");

        //Displayes the Last Name or Maximum student name along with complete student details
        element= Collections.max(records, Comparator.comparing(Student::getName));
        System.out.println("Maximum/Last Name is:"+element.getName());
        printStudentDetails("Student detials having highest/Last Name is:" , element);
        System.out.println("*********************************************************");

        //Displayes the Maximum age along with complete student details
        element= Collections.max(records, Comparator.comparingInt(Student::getAge));
        System.out.println("Maximum Age is:"+element.getAge());
        printStudentDetails("Student detials having maximum age is:" , element);
        System.out.println("*********************************************************");

        //Displayes the Maximum marks along with complete student details
        element= Collections.max(records, Comparator.comparingDouble(Student::getMarks));
        System.out.println("Maximum Marks is:"+element.getMarks());
        printStudentDetails("Student detials having maximum marks is:" , element);
        System.out.println("*********************************************************");

        //Displayes the lowest roll no along with complete student details
        element= Collections.min(records, Comparator.comparingInt(Student::getRollNo));
        System.out.println("Minimum Roll No is:"+element.getRollNo());
        printStudentDetails("Student detials having lowest roll no:" , element);
        System.out.println("*********************************************************");

        //Displayes the First Name and Minimum student name along with complete student details
        element= Collections.min(records, Comparator.comparing(Student::getName));
        System.out.println("Minimum/First Name is:"+element.getName());
        printStudentDetails("Student detials having Minimum/First Name is:" , element);
        System.out.println("*********************************************************");

        //Displayes the Minimum age along with complete student details
        element= Collections.min(records, Comparator.comparingInt(Student::getAge));
        System.out.println("Minimum Age is:"+element.getAge());
        printStudentDetails("Student detials having minimum age is:" , element);
        System.out.println("*********************************************************");

        //Displayes the Minimum marks along with complete student details
        element= Collections.min(records, Comparator.comparingDouble(Student::getMarks));
        System.out.println("Minimum Marks is:"+element.getMarks());
        printStudentDetails("Student detials having minimum marks is:" , element);
        System.out.println("*********************************************************");

        //Second way of displaying the output using Stream Method
        System.out.println("Using Stream Method");
        Student element1;

        //Displayes the highest roll no along with complete student details
        element1=records.stream().max(Comparator.comparingInt(Student::getRollNo)).get();
        System.out.println("Maximum Roll No is:"+element1.getRollNo());
        printStudentDetails("Student detials having highest roll no:" , element1);
        System.out.println("*********************************************************");

        //Displayes the Last Name or Maximum student name along with complete student details
        element1=records.stream().max(Comparator.comparing(Student::getName)).get();
        System.out.println("Maximum/Last Name is:"+element1.getName());
        printStudentDetails("Student detials having highest/Last Name is:" , element1);
        System.out.println("*********************************************************");

        //Displayes the Maximum age along with complete student details
        element1= records.stream().max(Comparator.comparingInt(Student::getAge)).get();
        System.out.println("Maximum Age is:"+element1.getAge());
        printStudentDetails("Student detials having maximum age is:" , element1);
        System.out.println("*********************************************************");

        //Displayes the Maximum marks along with complete student details
        element1= records.stream().max(Comparator.comparingDouble(Student::getMarks)).get();
        System.out.println("Maximum Marks is:"+element1.getMarks());
        printStudentDetails("Student detials having maximum marks is:" , element1);
        System.out.println("*********************************************************");

        //Displayes the lowest roll no along with complete student details
        element1= records.stream().min(Comparator.comparingInt(Student::getRollNo)).get();
        System.out.println("Minimum Roll No is:"+element1.getRollNo());
        printStudentDetails("Student detials having lowest roll no:" , element1);
        System.out.println("*********************************************************");

        //Displayes the First Name and Minimum student name along with complete student details
        element1=records.stream().min(Comparator.comparing(Student::getName)).get();
        System.out.println("Minimum/First Name is:"+element1.getName());
        printStudentDetails("Student detials having Minimum/First Name is:" , element1);
        System.out.println("*********************************************************");

        //Displayes the Minimum age along with complete student details
        element1= records.stream().min(Comparator.comparingInt(Student::getAge)).get();
        System.out.println("Minimum Age is:"+element1.getAge());
        printStudentDetails("Student detials having minimum age is:" , element1);
        System.out.println("*********************************************************");

        //Displayes the Minimum marks along with complete student details
        element1= records.stream().min(Comparator.comparingDouble(Student::getMarks)).get();
        System.out.println("Minimum Marks is:"+element1.getMarks());
        printStudentDetails("Student detials having minimum marks is:" , element1);
        System.out.println("Stream Concept Method ended");
        System.out.println("*********************************************************");

    }

    private static void printStudentDetails(String s, Student element)
    {
        System.out.println(s + element.getRollNo() + " " + element.getName() + " " + element.getAge() + " " + element.getMarks());
    }
}
