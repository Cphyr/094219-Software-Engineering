public abstract class AnimalFactory {
    public abstract Animal createAnimal();
}

class UnicornFactory extends AnimalFactory{
    @Override
    public Animal createAnimal(){
        /**
         * @return: (animal) a new Unicorn
         */
        return new Unicorn();
    }
}

class ZebraFactory extends AnimalFactory{
    @Override
    public Animal createAnimal(){
        /**
         * @return: (animal) a new Zebra
         */
        return new Zebra();
    }
}


class MonkeyFactory extends AnimalFactory{
    @Override
    public Animal createAnimal(){
        /**
         * @return: (animal) a new Monkey
         */
        return new Monkey();
    }
}
