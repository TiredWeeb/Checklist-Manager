public abstract class AbstractTask {
    String Name;
    String Description;

    public String toString()
    {
        return Name + ":" + Description + ":" ;
    }

    public abstract void GetInfo();
    public abstract void SetName(String Text);
    public abstract void SetDescription(String Text);
}
