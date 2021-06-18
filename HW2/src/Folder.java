import java.util.ArrayList;
public class Folder extends StorageItem {

    private ArrayList<StorageItem> items;

    public Folder(String name){
        super(name);
        this.items = new ArrayList<StorageItem>();
    }

    public int getSize() {
        int len = 0;
        for (StorageItem item : items){
            len += item.getSize();
        }
        return len;
    }


    public boolean addItem(StorageItem item) {
        String itemName = item.getName();
        for (StorageItem i : items) {
            if (i.getName().equals(itemName))
                return false;
        }
        items.add(item);
        return true;
    }



}

