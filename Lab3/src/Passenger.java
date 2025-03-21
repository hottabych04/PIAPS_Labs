// Класс для пассажира
class Passenger extends Person {
    private Luggage luggage;
    private PassengerClass passengerClass;

    public Passenger(String name, String id, PassengerClass passengerClass, double luggageWeight) {
        super(name, id);
        this.passengerClass = passengerClass;
        this.luggage = new Luggage(luggageWeight);
    }

    public Luggage getLuggage() {
        return luggage;
    }

    public PassengerClass getPassengerClass() {
        return passengerClass;
    }

    public double getFreeLuggageAllowance() {
        return passengerClass.getFreeLuggageAllowance();
    }

    public double getExcessLuggageWeight() {
        double freeAllowance = getFreeLuggageAllowance();
        if (passengerClass.getType() == ClassType.FIRST) {
            return 0; // Нет ограничений для первого класса
        }
        return Math.max(0, luggage.getWeight() - freeAllowance);
    }

    public void removeLuggage() {
        this.luggage = null;
    }

    @Override
    public String toString() {
        return "Пассажир " + getName() + " (ID:" + getId() + "), Класс: " + passengerClass.getType() +
                ", Багаж: " + (luggage != null ? luggage.getWeight() + " кг" : "нет");
    }
}
