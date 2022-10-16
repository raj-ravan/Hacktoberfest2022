import java.util.*;
class StudentData
{
    String record;
    String name;
    int age;
    String dob;

    StudentData(String record, String name, int age,String dob){
        this.record=record;
        this.name=name;
        this.age=age;
        this.dob=dob;
    }
    public String getRecord(){
        return record;
    }
    public String getName(){
        return name;
    }
    public int getAge(){
        return age;
    }
    public String getDob(){
        return dob;
    }
    public static void main(String[] args) 
    {
        LinkedList<StudentData> list=new LinkedList<StudentData>();
        list.add(new StudentData("Record1","bindu",20,"20feb"));
        list.add(new StudentData("Record2","kavya",21,"4mar"));
        list.add(new StudentData("Record3","sandhya",22,"5apr"));

        Scanner input=new Scanner(System.in);
        System.out.print("Enter record no to display: ");
        String rec=input.next();
        for(StudentData data:list){
            if(data.getRecord().equals(rec)){
            System.out.println(data.getRecord()+"\t"+data.getName()+"\t"+data.getAge()+"\t"+data.getDob());
            }
        }
    }
}
