// Класс для представления преподавателя
class Teacher {
    private String name;
    private String department;

    public Teacher(String name, String department) {
        this.name = name;
        this.department = department;
    }

    public WeeklyReport createWeeklyReport(Group group, int weekNumber) {
        WeeklyReport report = new WeeklyReport(weekNumber);

        // Здесь преподаватель заполняет отчет оценками
        for (Student student : group.getStudents()) {
            // Пример: случайная оценка от 2 до 5
            int grade = (int) (Math.random() * 4) + 2;
            report.addGrade(student, grade);
        }

        group.addReport(report);
        return report;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }
}
