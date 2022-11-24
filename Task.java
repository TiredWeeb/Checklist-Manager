public class Task extends AbstractTask {
    String Name;
    String Description = "N/A";

    public Task(String Name)
    {
        this.Name = Name;
    }

    public Task(String Name, String Description)
    {
        this.Name = Name;
        this.Description = Description;
    }

    public Task()
    {

    }

    @Override
    public void GetInfo()
    {
        System.out.println("Name: " + this.Name + "\nDescription: " + this.Description);
    }

    @Override
    public void SetName(String Text)
    {
        this.Name = Text;
    }

    @Override
    public void SetDescription(String Text)
    {
        this.Description = Text;
    }

    @Override
    public String toString()
    {
        return Name + ":" + Description + ":" ;
    }
}
