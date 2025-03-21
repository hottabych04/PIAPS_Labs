import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Класс самолета
class Airplane {
    private static final int MAX_PILOTS = 2;
    private static final int MAX_ATTENDANTS = 6;
    private double maxLuggageWeight;

    private List<Pilot> pilots = new ArrayList<>();
    private List<FlightAttendant> attendants = new ArrayList<>();
    private PassengerClass firstClass = new PassengerClass(ClassType.FIRST);
    private PassengerClass businessClass = new PassengerClass(ClassType.BUSINESS);
    private PassengerClass economyClass = new PassengerClass(ClassType.ECONOMY);
    private List<Luggage> removedLuggage = new ArrayList<>();

    public Airplane(double maxLuggageWeight) {
        this.maxLuggageWeight = maxLuggageWeight;
    }

    public boolean addPilot(Pilot pilot) {
        if (pilots.size() >= MAX_PILOTS) {
            return false;
        }
        pilots.add(pilot);
        return true;
    }

    public boolean addFlightAttendant(FlightAttendant attendant) {
        if (attendants.size() >= MAX_ATTENDANTS) {
            return false;
        }
        attendants.add(attendant);
        return true;
    }

    public boolean addPassenger(Passenger passenger) {
        switch (passenger.getPassengerClass().getType()) {
            case FIRST:
                return firstClass.addPassenger(passenger);
            case BUSINESS:
                return businessClass.addPassenger(passenger);
            case ECONOMY:
                return economyClass.addPassenger(passenger);
            default:
                return false;
        }
    }

    public double getCurrentLuggageWeight() {
        double totalWeight = 0;

        for (Passenger p : firstClass.getPassengers()) {
            if (p.getLuggage() != null && p.getLuggage().getStatus().equals("На борту")) {
                totalWeight += p.getLuggage().getWeight();
            }
        }

        for (Passenger p : businessClass.getPassengers()) {
            if (p.getLuggage() != null && p.getLuggage().getStatus().equals("На борту")) {
                totalWeight += p.getLuggage().getWeight();
            }
        }

        for (Passenger p : economyClass.getPassengers()) {
            if (p.getLuggage() != null && p.getLuggage().getStatus().equals("На борту")) {
                totalWeight += p.getLuggage().getWeight();
            }
        }

        return totalWeight;
    }

    public double getLuggageOverweight() {
        return Math.max(0, getCurrentLuggageWeight() - maxLuggageWeight);
    }

    public void optimizeLuggageWeight() {
        if (getLuggageOverweight() <= 0) {
            return; // Нет перевеса
        }

        // Создаем список пассажиров эконом класса, сортированный по избыточному весу багажа
        List<Passenger> economyPassengers = new ArrayList<>(economyClass.getPassengers());
        economyPassengers.sort((p1, p2) -> Double.compare(p2.getExcessLuggageWeight(), p1.getExcessLuggageWeight()));

        double overweight = getLuggageOverweight();

        // Снимаем багаж пассажиров эконом класса, начиная с тех, у кого наибольший избыточный вес
        for (Passenger passenger : economyPassengers) {
            if (overweight <= 0) {
                break;
            }

            if (passenger.getLuggage() != null && passenger.getLuggage().getStatus().equals("На борту")) {
                Luggage luggage = passenger.getLuggage();
                double luggageWeight = luggage.getWeight();

                luggage.setStatus("Снят с рейса");
                removedLuggage.add(luggage);
                overweight -= luggageWeight;
            }
        }
    }

    public boolean isReadyForDeparture() {
        // Проверка готовности самолета к отправлению
        boolean hasPilots = pilots.size() == MAX_PILOTS;
        boolean hasAttendants = attendants.size() == MAX_ATTENDANTS;
        boolean noLuggageOverweight = getLuggageOverweight() <= 0;

        return hasPilots && hasAttendants && noLuggageOverweight;
    }

    public List<Luggage> getRemovedLuggage() {
        return Collections.unmodifiableList(removedLuggage);
    }

    public String generateLoadingReport() {
        StringBuilder report = new StringBuilder();
        report.append("=== ОТЧЕТ О ЗАГРУЗКЕ САМОЛЕТА ===\n\n");

        // Информация о персонале
        report.append("ПЕРСОНАЛ:\n");
        report.append("Пилоты (" + pilots.size() + "/" + MAX_PILOTS + "):\n");
        for (Pilot pilot : pilots) {
            report.append("  - ").append(pilot).append("\n");
        }

        report.append("Стюардессы (" + attendants.size() + "/" + MAX_ATTENDANTS + "):\n");
        for (FlightAttendant attendant : attendants) {
            report.append("  - ").append(attendant).append("\n");
        }

        // Информация о пассажирах
        report.append("\nПАССАЖИРЫ:\n");
        report.append("Первый класс (" + firstClass.getCurrentPassengerCount() + "/" +
                firstClass.getMaxPassengers() + "):\n");
        for (Passenger passenger : firstClass.getPassengers()) {
            report.append("  - ").append(passenger).append("\n");
        }

        report.append("Бизнес класс (" + businessClass.getCurrentPassengerCount() + "/" +
                businessClass.getMaxPassengers() + "):\n");
        for (Passenger passenger : businessClass.getPassengers()) {
            report.append("  - ").append(passenger).append("\n");
        }

        report.append("Эконом класс (" + economyClass.getCurrentPassengerCount() + "/" +
                economyClass.getMaxPassengers() + "):\n");
        for (Passenger passenger : economyClass.getPassengers()) {
            report.append("  - ").append(passenger).append("\n");
        }

        // Информация о багаже
        report.append("\nБАГАЖ:\n");
        report.append("Максимальный допустимый вес: ").append(maxLuggageWeight).append(" кг\n");
        report.append("Текущий вес багажа: ").append(getCurrentLuggageWeight()).append(" кг\n");

        double overweight = getLuggageOverweight();
        if (overweight > 0) {
            report.append("Перевес багажа: ").append(overweight).append(" кг\n");
        } else {
            report.append("Перевеса багажа нет\n");
        }

        if (!removedLuggage.isEmpty()) {
            report.append("\nСНЯТЫЙ БАГАЖ:\n");
            for (Luggage luggage : removedLuggage) {
                report.append("  - ").append(luggage).append("\n");
            }
        }

        // Статус готовности к отправлению
        report.append("\nСТАТУС ГОТОВНОСТИ: ");
        if (isReadyForDeparture()) {
            report.append("ГОТОВ К ОТПРАВЛЕНИЮ\n");
        } else {
            report.append("НЕ ГОТОВ К ОТПРАВЛЕНИЮ\n");

            if (pilots.size() < MAX_PILOTS) {
                report.append("  - Недостаточно пилотов: ").append(pilots.size()).append("/").append(MAX_PILOTS).append("\n");
            }

            if (attendants.size() < MAX_ATTENDANTS) {
                report.append("  - Недостаточно стюардесс: ").append(attendants.size()).append("/").append(MAX_ATTENDANTS).append("\n");
            }

            if (overweight > 0) {
                report.append("  - Перевес багажа: ").append(overweight).append(" кг\n");
            }
        }

        return report.toString();
    }
}
