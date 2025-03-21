import java.util.Date;
import java.util.HashMap;
import java.util.Map;

// Класс еженедельного отчета об успеваемости
public class WeeklyReport {
    private int weekNumber;
    private Date creationDate;
    private Map<Student, Integer> grades = new HashMap<>();

    public WeeklyReport(int weekNumber) {
        this.weekNumber = weekNumber;
        this.creationDate = new Date();
    }

    public void addGrade(Student student, int grade) {
        grades.put(student, grade);
    }

    public Integer getGrade(Student student) {
        return grades.get(student);
    }

    public int getWeekNumber() {
        return weekNumber;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public Map<Student, Integer> getGrades() {
        return grades;
    }
}

