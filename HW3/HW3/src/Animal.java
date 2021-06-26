abstract public class Animal {
    String name;
    String food;
    String action;

    public Animal(String name, String food, String action) {
        this.name = name;
        this.food = food;
        this.action=action;
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
         * @return String the animal is eating its food
         * @since 1.1
         */
        return "The " + name.toLowerCase() + " is eating " + food + "...";
    }
    public String getActionMSG(){
        /**
         * @return String the animal is doing its action
         * @since 1.2
         */
        return "The "+name.toLowerCase()+" is "+action+"...";
    }
}

class Zebra extends Animal {
    public Zebra() {
        super("Zebra", "grass", "running");
    }

}

class Unicorn extends Animal {
    public Unicorn() {
        super("Unicorn", "rainbow cakes", "flying");
    }
}

class Monkey extends Animal {
    public Monkey() {
        super("Monkey", "a banana","hanging on trees");
    }

}