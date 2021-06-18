public class StorageItem {
    public String name;
    protected final double date;
    protected int size;
    public StorageItem(String name){
        this.name=name;
        this.date=0; //change later
    }

    public int getSize() {
        return size;
    }

}
