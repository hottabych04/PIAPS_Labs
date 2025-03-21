import java.util.ArrayList;
import java.util.List;

// Абстрактный класс Subject
abstract class Subject {
    private List<Observer> observers = new ArrayList<>();

    public void registerObserver(Observer o) {
        observers.add(o);
    }

    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    protected void notifyObservers(String state) {
        for (Observer observer : observers) {
            observer.update(state);
        }
    }
}
