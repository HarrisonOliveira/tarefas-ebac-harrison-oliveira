package Observer;

import java.util.ArrayList;

public class Jornalist implements Subject{

    private String title, summaty, image, text;
    private ArrayList<Observer> observers = new ArrayList<>();

    public void publish(String title, String summaty, String image, String text) {
        this.title = title;
        this.summaty = summaty;
        this.image = image;
        this.text = text;
        notifyObserver();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);

    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObserver() {
        observers.forEach(observer -> observer.update(this)) ;
    }

    public ArrayList<Observer> getObservers() {
        return observers;
    }

    public void setObservers(ArrayList<Observer> observers) {
        this.observers = observers;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummaty() {
        return summaty;
    }

    public void setSummaty(String summaty) {
        this.summaty = summaty;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Jornalist{" +
                "observers=" + observers +
                ", title='" + title + '\'' +
                ", summaty='" + summaty + '\'' +
                ", image='" + image + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
