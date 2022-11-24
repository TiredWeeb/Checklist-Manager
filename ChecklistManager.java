import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class ChecklistManager {
    HashMap<Integer,Task> TaskList = new HashMap<Integer,Task>();

    public ChecklistManager()
    {
        try {
            FileReader Reader = new FileReader("Stuff.txt");
            Scanner Test = new Scanner(Reader);
            Test.useDelimiter(":");

            int Count = 1;
            while(Test.hasNext())
            {
                Task Temp = new Task(Test.next(),Test.next());
                TaskList.put(Count,Temp);
                //System.out.println("ID: " + Count + " Name: " + Temp.Name + " Description: " + Temp.Description);
                Count += 1;
            }
        }
        catch(IOException err){
            System.out.println(err.getMessage());
            TaskList = null;
        }
    }


    public void printToDoList()//Prints out the to do list
    {
        System.out.println("--------------------------------");
        System.out.println("Current Tasks to Complete:");
        Set<Integer> mapKeys = TaskList.keySet();

        for(Integer Key : mapKeys) {
            System.out.println(Key + ": " + TaskList.get(Key).Name);
        }
        System.out.println("");
    }

    public void AddTask(String Name)
    {
        try {
            FileWriter writer = new FileWriter("Stuff.txt", true);
            TaskList.put(TaskList.size() + 1, new Task(Name));

            writer.write(TaskList.get(TaskList.size()).toString());
            writer.close();
            printToDoList();
        } catch(IOException err){
            System.out.println(err.getMessage());
        }
    }

    public void RemoveTask(Integer Num)
    {
        if(Num>TaskList.size()) { System.out.println("\033[0;31m"+ "Integer " + Num + " is too big. The list size is " + TaskList.size() + ". Please select a different number." + "\033[0m"); return; }
        try {
            FileWriter writer = new FileWriter("Stuff.txt");

            TaskList.replace(Num,TaskList.get(TaskList.size()));
            TaskList.remove(TaskList.size());

            Set<Integer> mapKeys = TaskList.keySet();
            for(Integer Key : mapKeys) {
                writer.write(TaskList.get(Key).toString());
            }
            writer.close();
            printToDoList();
        } catch(IOException err){
            System.out.println(err.getMessage());
        }
    }

    public void EditTask(Integer Num, String Text, int type)
    {
        try{
            FileWriter writer = new FileWriter("Stuff.txt");
            if(type == 0) {
                TaskList.get(Num).SetName(Text);
            }
            else{
                TaskList.get(Num).SetDescription(Text);
            }

            Set<Integer> mapKeys = TaskList.keySet();
            for(Integer Key : mapKeys) {
                writer.write(TaskList.get(Key).toString());
            }
            writer.close();
            printToDoList();
        }catch(IOException err){
            System.out.println(err.getMessage());
        }
    }
}
