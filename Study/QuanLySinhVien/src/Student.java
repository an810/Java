public class Student {
    private String name;
    private String dob;
    private String id;


    public Student(String name, String dob, String id) {
        this.name = name;
        this.dob = dob;
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setDob(String dob) {
        this.dob = dob;
    }
    public String getDob() {
        return dob;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getId() {
        return id;
    }
}
