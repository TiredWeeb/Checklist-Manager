import java.util.*;



public class Main {
    static ArrayList<String> Help = new ArrayList<String>();

    public static int Prompt(ChecklistManager bob)
    {
        System.out.println("\nPlease input a command");
        Scanner Test = new Scanner(System.in);
        String cmd = Test.next().toLowerCase(Locale.ROOT);

        if (cmd.equals("add")){  //Add TaskName
            bob.AddTask(Test.nextLine());
        }
        else if(cmd.equals("remove")) { //Remove TaskNum
            if(Test.hasNextInt()) {
                bob.RemoveTask(Test.nextInt());
            }
            else{
                System.out.println("WARNING: Command remove requires an integer afterwards Ex: remove 2");
            }
        }
        else if(cmd.equals("info")) { //Info TaskNum
            if(Test.hasNextInt()) {
                bob.TaskList.get(Test.nextInt()).GetInfo();
            }
            else{
                System.out.println("WARNING: Command info requires an integer afterwards Ex: remove 2");
            }
        }
        else if(cmd.equals("setname")) { //setname TaskNum NewName
            if(Test.hasNextInt()) {
                bob.EditTask(Test.nextInt(),Test.nextLine(),0);
            }
            else{
                System.out.println("WARNING: Command setname requires an integer afterwards Ex: remove 2 Name");
            }
        }
        else if(cmd.equals("setdescription") || cmd.equals("setdesc")) { //setdesc TaskNum NewDescription
            if(Test.hasNextInt()) {
                bob.EditTask(Test.nextInt(),Test.nextLine(),1);
            }
            else{
                System.out.println("WARNING: Command setdescription requires an integer afterwards Ex: remove 2 description");
            }
        }
        else if(cmd.equals("help")){
            Iterator it = Help.iterator();

            while (it.hasNext())
            {
                System.out.println(it.next());
            }
        }
        else if(cmd.equals("exit")) { //exit
            System.out.println("Have a good day!");
            return 1;
        }
        else{
            System.out.println("WARNING" + cmd + " is not a viable command.");
        }
        return 0;
    }

    public static void main(String [] args) {
        ChecklistManager bob = new ChecklistManager();
        if (bob.TaskList == null) {System.out.println("WARNING: To do list data not retrieved from Stuff.txt"); System.exit(0); }
        Help.add("add Name                     (Adds a new task of name 'Name' to the list)");
        Help.add("remove TaskNum               (Removes the task with the number 'TaskNum' from the list)");
        Help.add("info TaskNum                 (Displays the name and description of the task with number 'TaskNum')");
        Help.add("setname TaskNum NewName      (Changes the name of the task with  number 'TaskNum' to 'NewName')");
        Help.add("setdesc TaskNum description  (Changes the description of the task with  number 'TaskNum' to 'description')");
        Help.add("exit                         (Exits the program)");
        Help.add(" ");

        bob.printToDoList();
        int Num = 0;
        while(Num == 0)
        {
            Num = Prompt(bob);
        }
    }

}
