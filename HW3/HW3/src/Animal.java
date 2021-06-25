abstract public class Animal {
    String name;
    String food;

    public Animal(String name, String food) {
        this.name = name;
        this.food = food;
    }

    public String getName() {
        /**
         * @return String the animal's name
         * @since 1.1
         */
        return name;
    }

    public String getEatingMSG() {
        /**
         * @return String the animal is eating it's food
         * @since 1.1
         */
        return "The " + name + " is eating " + food + "...";
    }
}

class Zebra extends Animal {
    public Zebra() {
        super("zebra", "grass");
    }

}

class Unicorn extends Animal {
    public Unicorn() {
        super("unicorn", "rainbow cakes");
    }
}

class Monkey extends Animal {
    public Monkey() {
        super("monkey", "bananas");
    }

}