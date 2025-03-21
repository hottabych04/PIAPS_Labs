// Класс для стюардессы
class FlightAttendant extends Person {
    private String position;

    public FlightAttendant(String name, String id, String position) {
        super(name, id);
        this.position = position;
    }

    public String getPosition() {
        return position;
    }

    @Override
    public String toString() {
        return "Стюардесса " + getName() + " (ID:" + getId() + "), Позиция: " + position;
    }
}
