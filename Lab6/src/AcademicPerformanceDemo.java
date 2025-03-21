// Демонстрация работы системы
public class AcademicPerformanceDemo {
    public static void main(String[] args) {
        // Создаем кафедры
        Department mathDepartment = new Department("Математика");
        Department physicsDepartment = new Department("Физика");

        // Создаем преподавателей
        Teacher mathTeacher = new Teacher("Иванов И.И.", "Математика");
        Teacher physicsTeacher = new Teacher("Петров П.П.", "Физика");

        mathDepartment.addTeacher(mathTeacher);
        physicsDepartment.addTeacher(physicsTeacher);

        // Создаем группы
        Group group101 = new Group("101", "Математический анализ", mathTeacher);
        Group group102 = new Group("102", "Механика", physicsTeacher);

        // Добавляем студентов в группы
        for (int i = 1; i <= 5; i++) {
            group101.addStudent(new Student("101-" + i, "Студент " + i + " группы 101"));
            group102.addStudent(new Student("102-" + i, "Студент " + i + " группы 102"));
        }

        // Создаем систему мониторинга успеваемости
        AcademicPerformanceSystem system = new AcademicPerformanceSystem();
        system.addGroup(group101);
        system.addGroup(group102);
        system.addDepartment(mathDepartment);
        system.addDepartment(physicsDepartment);

        // Создаем деканат и регистрируем его как наблюдателя
        DeanOffice deanOffice = new DeanOffice();
        deanOffice.addDepartment(mathDepartment);
        deanOffice.addDepartment(physicsDepartment);
        system.registerObserver(deanOffice);

        // Преподаватель математики создает отчет для своей группы на 10-ю неделю
        mathTeacher.createWeeklyReport(group101, 10);

        // Преподаватель физики не создал отчет

        // Система проверяет наличие отчетов за 10-ю неделю
        System.out.println("Проверка отчетов за 10-ю неделю:");
        system.checkWeeklyReports(10);

        // Преподаватель физики создает отчет после уведомления
        physicsTeacher.createWeeklyReport(group102, 10);

        // Повторная проверка
        System.out.println("\nПовторная проверка отчетов за 10-ю неделю:");
        system.checkWeeklyReports(10);
    }
}
