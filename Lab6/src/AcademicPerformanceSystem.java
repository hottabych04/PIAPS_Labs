import java.util.HashMap;
import java.util.Map;

// Система учета успеваемости, которая является субъектом наблюдения
class AcademicPerformanceSystem extends Subject {
    private Map<String, Group> groups = new HashMap<>();
    private Map<String, Department> departments = new HashMap<>();

    public void addGroup(Group group) {
        groups.put(group.getGroupId(), group);
    }

    public Group getGroup(String groupId) {
        return groups.get(groupId);
    }

    public void addDepartment(Department department) {
        departments.put(department.getName(), department);
    }

    // Метод для проверки отчетов и уведомления о проблемах
    public void checkWeeklyReports(int currentWeek) {
        for (Map.Entry<String, Group> entry : groups.entrySet()) {
            Group group = entry.getValue();
            WeeklyReport latestReport = group.getLatestReport();

            if (latestReport == null || latestReport.getWeekNumber() < currentWeek) {
                // Отчет отсутствует или устарел
                Teacher teacher = group.getTeacher();
                String message = "Отсутствует отчет для группы " + group.getGroupId() +
                        ", преподаватель: " + teacher.getDepartment();
                notifyObservers(message);
            }
        }
    }
}
