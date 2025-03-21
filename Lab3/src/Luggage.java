// Класс для багажа
class Luggage {
    private double weight;
    private String status = "На борту"; // "На борту" или "Снят с рейса"

    public Luggage(double weight) {
        if (weight < 5) {
            this.weight = 5;
        } else if (weight > 60) {
            this.weight = 60;
        } else {
            this.weight = weight;
        }
    }

    public double getWeight() {
        return weight;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Багаж " + weight + " кг, Статус: " + status;
    }
}
