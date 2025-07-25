public class StudManagement{
    private int id;
    private String name;
    private int age;
    private String course;

    public StudManagement(int id, String name, int age, String course){
        this.id = id;
        this.age = age;
        this.name = name;
        this.course = course;


    }

    //Getters
    public int getId() { return id; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public String getCourse() { return course; }


    //Setters
    public void setName(String name){
        this.name = name;
    }
    public void setAge(int age){
        this.age = age;
    }
    public void setCourse(String course){
        this.course = course;
    }


    @Override
    public String toString(){
        return "ID" + id +"Name" + name + "Age" + age + "Course" + course;
    }

}