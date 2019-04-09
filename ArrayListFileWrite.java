package arraylistfileread;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.ListIterator;

public class ArrayListFileWrite
{
    public void writeToFile(String filecontents, String filepath1)
    {
        try
        {
            filepath1="C:\\Users\\Shivu\\IdeaProjects\\DATASETS\\arraylistoptfile.txt";
            FileWriter fw = new FileWriter(filepath1);
            BufferedWriter bw=new BufferedWriter(fw);


           /* for(Student st:records)
            {
                ListIterator litr=records.listIterator();
                while(litr.hasNext())
                {
                    System.out.println(litr.next());
                }
            }*/
            bw.write(filecontents);

            bw.close();
            fw.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }
}

