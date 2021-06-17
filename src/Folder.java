import java.util.ArrayList;
public class Folder extends StorageItem {
    private ArrayList<StorageItem> arr;
    public Folder(String name){
        super(name);
        this.arr= new ArrayList<>();
    }

}

