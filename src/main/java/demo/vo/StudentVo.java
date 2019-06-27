package demo.vo;

public class StudentVo {
    private String classNo;
    private String studentNo;
    private String name;

    public String getClassNo() {
        return classNo;
    }

    public void setClassNo(String classNo) {
        this.classNo = classNo;
    }

    public String getStudentNo() {
        return studentNo;
    }

    public void setStudentNo(String studentNo) {
        this.studentNo = studentNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public StudentVo() {
        System.out.println("StudentVo inital");
    }

    @Override
    public String toString() {
        return String.format("Student{classNo=%s, studentNo=%s, name=%s}",new Object[]{classNo, studentNo, name});
    }
}
