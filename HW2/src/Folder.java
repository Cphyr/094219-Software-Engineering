import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

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

    public ArrayList<StorageItem> getItems() {
        return items;
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



    public File findFile(String path){
        String next="";
        int curPlace=0, length = path.length();
        Folder currFolder=this;
        boolean didChange=false;
        while(true){
            while(curPlace<length && path.charAt(curPlace) != '/'  ){
                next+=path.charAt(curPlace);
                curPlace++;
            }
            curPlace++;
            didChange=false;
            for(StorageItem s: currFolder.items){
                if(s.getName().equals(next)){
                    if(s instanceof File)
                        return (File)s;
                    currFolder=(Folder)s;
                    didChange=true;
                    break;
                }
            }
            if(! didChange)
                return null;
            next="";
        }
    }



}

