import java.util.ArrayList;

public class Zoo {
    private static Zoo instance = null;
    private ArrayList<Animal> animals;
    private ArrayList<ZooObserver> observers;
    private int happiness; // [1..5]
    private int hunger; // [1..5]

    private Zoo() {
        /**
         * @since 1.1
         */
        this.happiness = 2;
        this.hunger = 3;
        observers = new ArrayList<>();
    }

    public void addAnimal(Animal animal) {
        /**
         * @param animal an animal to be added
         * @since 1.1
         */
        animals.add(animal);
        notifyAll(animal.getName() + " has been added to the zoo!");
    }

    public static Zoo getInstance() {
        /**
         * @return the instance of the singleton -> the zoo
         * @since 1.1
         */
        if (instance == null) {
            instance = new Zoo();
        }
        return instance;
    }

    public void addObserver(ZooObserver obs) {
        /**
         * @param obs a new observer to be added to the collection
         * @return void
         * @since 1.1
         */
        observers.add(obs);
    }

    public void notifyAll(String msg) {
        /**
         * @param msg a message to send to all obs
         * @return void
         * @since 1.1
         */
        for (ZooObserver obs : observers) {
            obs.notify(msg);
        }
    }

    public int getHunger() {
        /**
         * @return int the hunger level
         */
        return hunger;
    }

    public int getHappiness() {
        /**
         * @return int the happiness level
         */
        return happiness;
    }

    public void DecreaseHunger() {
        /**
         * Decreases the hunger level
         */
        if (hunger > 0) {
            hunger--;
        }
    }

    public void IncreaseHunger() {
        /**
         * Increases the hunger level
         */
        if (hunger < 5) {
            hunger++;
        }
    }

    public void DecreaseHappiness() {
        /**
         * Decreases the happiness level
         */
        if (happiness > 0) {
            happiness--;
        }
    }

    public void IncreaseHappiness() {
        /**
         * Increases the happiness level
         */
        if (happiness < 5) {
            happiness++;
        }
    }

    public void gotInAShow() {
        /**
         * update the attributes by the rules.
         * 
         * @since 1.1
         */
        IncreaseHappiness();
        IncreaseHunger();
    }
}
