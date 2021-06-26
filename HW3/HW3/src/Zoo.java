import java.util.ArrayList;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Hashtable;

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
        animals = new ArrayList<>();
    }

    public void addAnimal(Animal animal) {
        /**
         * @param animal an animal to be added
         * @since 1.1
         */
        animals.add(animal);
        notifyAll(animal.getName() + " has been added to the zoo!");
    }

    public void removeObserver(ZooObserver obs){
        /**
         * removes an observer
         * @since 1.2
         */
        observers.remove(obs);
    }
    public void feedAnimals(){
        /**
         * Feeds the animals and notifies
         * @since 1.2
         */
        DecreaseHunger();
        for(Animal a: animals) {
            System.out.println(a.getEatingMSG());
        }
        notifyAll("The animals are being fed");
    }
    public void showAnimalsInfo(){
        /**
         * Prints the animals info.
         * @since 1.2
         */
        String type;
        Integer CurCounter;
        HashMap<String, Integer> dict= new HashMap<String, Integer>();
        //Initializes a dictionary
        for( Animal a: animals){
            dict.put(a.getName(), 0);
        }
        // Counts how many times an animal has appeared
        for( Animal a: animals){
            dict.put(a.getName(), dict.get(a.getName())+1);
        }
        //Prints the details
        System.out.println("The zoo contains total of "+animals.size()+" animals:");
        for(String s: dict.keySet()){
            System.out.println("- "+s+": "+dict.get(s));
        }
        PrintHappiness();
        PrintHunger();

    }

    void PrintHappiness(){
        /**
         * Prints the happiness level and the correct msg
         * @since 1.2
         */
        System.out.println("Happiness level: "+happiness);
        if(happiness<3){
            System.out.println("The animals are not happy, you should watch them...");
        }
        else{
            System.out.println("The animals are very happy, keep working hard...");
        }
    }
    void PrintHunger(){
        /**
         * Prints the hunger level and the correct msg
         * @since 1.2
         */
        System.out.println("Hunger level: "+hunger);
        if(hunger>3){
            System.out.println("The animals are hungry, you should feed them...");
        }
    }

    public static Zoo getInstance() {
        /**
         * @return the instance of the singleton -> the zoo
         * @since 1.1
         */
        if (instance == null) {
            System.out.println("Creating zoo...");
            instance = new Zoo();
        }
        else{
            System.out.println("The zoo already exists...");
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
        System.out.println("Notifying observers:");
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
        if (hunger > 1) {
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
        if (happiness > 1) {
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

    public void watchAnimals() {
        /**
         * update the attributes by the rules.
         * 
         * @since 1.1
         */
        for(Animal a: animals) {
            System.out.println(a.getActionMSG());
        }
        notifyAll("The animals are being watched");
        IncreaseHappiness();
        IncreaseHunger();
    }
}
