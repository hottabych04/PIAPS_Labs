import java.util.ArrayList;
import java.util.List;

// Класс для представления кафедры
class Department {
    private String name;
    private List<Teacher> teachers = new ArrayList<>();

    public Department(String name) {
        this.name = name;
    }

    public void addTeacher(Teacher teacher) {
        teachers.add(teacher);
    }

    public String getName() {
        return name;
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public void receiveNotification(String message) {
        System.out.println("Кафедра " + name + " получила уведомление: " + message);
    }
}
