import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Класс для класса пассажиров
class PassengerClass {
    private ClassType type;
    private int maxPassengers;
    private List<Passenger> passengers = new ArrayList<>();

    public PassengerClass(ClassType type) {
        this.type = type;
        switch (type) {
            case FIRST:
                this.maxPassengers = 10;
                break;
            case BUSINESS:
                this.maxPassengers = 20;
                break;
            case ECONOMY:
                this.maxPassengers = 150;
                break;
        }
    }

    public ClassType getType() {
        return type;
    }

    public boolean addPassenger(Passenger passenger) {
        if (passengers.size() >= maxPassengers) {
            return false;
        }
        passengers.add(passenger);
        return true;
    }

    public List<Passenger> getPassengers() {
        return Collections.unmodifiableList(passengers);
    }

    public int getCurrentPassengerCount() {
        return passengers.size();
    }

    public int getMaxPassengers() {
        return maxPassengers;
    }

    public double getFreeLuggageAllowance() {
        switch (type) {
            case FIRST:
                return Double.POSITIVE_INFINITY; // Без ограничений
            case BUSINESS:
                return 35.0;
            case ECONOMY:
                return 20.0;
            default:
                return 0.0;
        }
    }

    @Override
    public String toString() {
        return type + " класс: " + getCurrentPassengerCount() + "/" + maxPassengers + " пассажиров";
    }
}
