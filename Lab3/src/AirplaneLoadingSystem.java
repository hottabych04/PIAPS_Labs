import java.util.Random;

// Основной класс для демонстрации
public class AirplaneLoadingSystem {
    public static void main(String[] args) {
        // Создаем самолет с максимальной загрузкой багажа 1500 кг
        Airplane airplane = new Airplane(1500);

        // Добавляем пилотов
        airplane.addPilot(new Pilot("Иван Петров", "P001", "Капитан"));
        airplane.addPilot(new Pilot("Алексей Смирнов", "P002", "Второй пилот"));

        // Добавляем стюардесс
        airplane.addFlightAttendant(new FlightAttendant("Мария Иванова", "A001", "Старший бортпроводник"));
        airplane.addFlightAttendant(new FlightAttendant("Елена Сидорова", "A002", "Бортпроводник"));
        airplane.addFlightAttendant(new FlightAttendant("Ольга Кузнецова", "A003", "Бортпроводник"));
        airplane.addFlightAttendant(new FlightAttendant("Татьяна Соколова", "A004", "Бортпроводник"));
        airplane.addFlightAttendant(new FlightAttendant("Анна Морозова", "A005", "Бортпроводник"));
        airplane.addFlightAttendant(new FlightAttendant("Екатерина Волкова", "A006", "Бортпроводник"));

        // Создаем классы пассажиров
        PassengerClass firstClass = new PassengerClass(ClassType.FIRST);
        PassengerClass businessClass = new PassengerClass(ClassType.BUSINESS);
        PassengerClass economyClass = new PassengerClass(ClassType.ECONOMY);

        // Добавляем пассажиров первого класса
        Random random = new Random();
        for (int i = 1; i <= 8; i++) {
            double luggageWeight = 5 + random.nextDouble() * 55; // От 5 до 60 кг
            Passenger passenger = new Passenger("FC Пассажир " + i, "FC" + i, firstClass, luggageWeight);
            airplane.addPassenger(passenger);
        }

        // Добавляем пассажиров бизнес-класса
        for (int i = 1; i <= 15; i++) {
            double luggageWeight = 5 + random.nextDouble() * 55; // От 5 до 60 кг
            Passenger passenger = new Passenger("BC Пассажир " + i, "BC" + i, businessClass, luggageWeight);
            airplane.addPassenger(passenger);
        }

        // Добавляем пассажиров эконом-класса (больше, чем нужно для демонстрации перевеса)
        for (int i = 1; i <= 120; i++) {
            // Больше багажа у эконом-класса для создания перевеса
            double luggageWeight = 15 + random.nextDouble() * 45; // От 15 до 60 кг
            Passenger passenger = new Passenger("EC Пассажир " + i, "EC" + i, economyClass, luggageWeight);
            airplane.addPassenger(passenger);
        }

        // Проверяем вес багажа
        System.out.println("Вес багажа до оптимизации: " + airplane.getCurrentLuggageWeight() + " кг");
        System.out.println("Перевес багажа: " + airplane.getLuggageOverweight() + " кг");

        // Оптимизируем вес багажа
        airplane.optimizeLuggageWeight();

        // Проверяем вес багажа после оптимизации
        System.out.println("\nВес багажа после оптимизации: " + airplane.getCurrentLuggageWeight() + " кг");
        System.out.println("Перевес багажа: " + airplane.getLuggageOverweight() + " кг");
        System.out.println("Количество снятых единиц багажа: " + airplane.getRemovedLuggage().size());

        // Генерируем и печатаем полный отчет
        System.out.println("\n" + airplane.generateLoadingReport());
    }
}
