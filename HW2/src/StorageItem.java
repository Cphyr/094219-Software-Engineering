abstract public class StorageItem {
    private String name;
    private final double date;
    private int size;

    abstract public int getSize();

    public StorageItem(String name){
        this.name = name;
        this.date = 0; //change later
    }

    public String getName() {
        return name;
    }

    public double getDate() {
        return date;
    }
    public void printTree(SortingField field) {
        // TODO
    }
}
