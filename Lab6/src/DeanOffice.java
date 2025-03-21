import java.util.HashMap;
import java.util.Map;

// Класс деканата, который является наблюдателем
class DeanOffice implements Observer {
    private Map<String, Department> departments = new HashMap<>();

    public void addDepartment(Department department) {
        departments.put(department.getName(), department);
    }

    @Override
    public void update(String state) {
        System.out.println("Деканат получил уведомление: " + state);

        // Извлекаем информацию о группе и преподавателе из уведомления
        if (state.contains("Отсутствует отчет для группы")) {
            // Пример формата: "Отсутствует отчет для группы ID, преподаватель: dept"
            String[] parts = state.split(", преподаватель: ");
            if (parts.length == 2) {
                String departmentName = parts[1];
                notifyDepartment(departmentName);
            }
        }
    }

    public void notifyDepartment(String departmentName) {
        Department department = departments.get(departmentName);
        if (department != null) {
            department.receiveNotification("Срочно предоставить отчет об успеваемости!");
        }
    }
}
