// Класс для пилота
public class Pilot extends Person {
    private String rank;

    public Pilot(String name, String id, String rank) {
        super(name, id);
        this.rank = rank;
    }

    public String getRank() {
        return rank;
    }

    @Override
    public String toString() {
        return "Пилот " + getName() + " (ID:" + getId() + "), Ранг: " + rank;
    }
}

