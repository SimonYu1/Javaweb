package entity;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StudentList {
    private List<Student> students;

    public StudentList() {
        students = new ArrayList<>();
        initializeStudents();
    }

    private void initializeStudents() {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

            students.add(new Student("1001", "爱丽丝", "Female", dateFormat.parse("2000-01-01"), "计算机科学", 2020));
            students.add(new Student("1002", "鲍勃", "Male", dateFormat.parse("1999-05-15"), "数学统计", 2020));
            students.add(new Student("1003", "查理", "Male", dateFormat.parse("2001-03-20"), "物理工程", 2021));
            students.add(new Student("1004", "大卫", "Male", dateFormat.parse("1998-12-10"), "生物工程", 2019));
            students.add(new Student("1005", "伊娃", "Female", dateFormat.parse("2002-08-05"), "化学", 2022));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public List<Student> getStudents() {
        return students;
    }
}
