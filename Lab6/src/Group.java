import java.util.ArrayList;
import java.util.List;

// Класс для представления группы студентов
class Group {
    private String groupId;
    private String disciplineName;
    private Teacher teacher;
    private List<Student> students = new ArrayList<>();
    private List<WeeklyReport> reports = new ArrayList<>();

    public Group(String groupId, String disciplineName, Teacher teacher) {
        this.groupId = groupId;
        this.disciplineName = disciplineName;
        this.teacher = teacher;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void addReport(WeeklyReport report) {
        reports.add(report);
    }

    public WeeklyReport getLatestReport() {
        if (reports.isEmpty()) {
            return null;
        }
        return reports.get(reports.size() - 1);
    }

    public List<Student> getStudents() {
        return students;
    }

    public String getGroupId() {
        return groupId;
    }

    public String getDisciplineName() {
        return disciplineName;
    }

    public Teacher getTeacher() {
        return teacher;
    }
}
