import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Folder extends StorageItem {

    private ArrayList<StorageItem> items;

    public Folder(String name) {
        /**
         * @param name (String) the name of the folder
         * @return Constructor
         */
        super(name);
        this.items = new ArrayList<StorageItem>();
    }

    public int getSize() {
        /**
         * @return (int) sum over all item's length in the folder recursivly where
         *         length of a file is the len of the content of a file
         */
        int len = 0;
        for (StorageItem item : items) {
            len += item.getSize(); // recursive call
        }
        return len;
    }

    public ArrayList<StorageItem> getItems() {
        /**
         * @return the items in the folder
         */
        return items;
    }

    public boolean addItem(StorageItem item) {
        /**
         * @param item (StorageItem) an item to add to the folder
         * @return (boolean) true if succeeded, false otherwise, where success is
         *         defined as if the there was an item of this name in the folder
         *         already
         */
        String itemName = item.getName();
        for (StorageItem i : items) {
            if (i.getName().equals(itemName))
                return false;
        }
        items.add(item);
        return true;
    }

    public File findFile(String path) {
        /**
         * @param path (String) the path to find in the folder
         * @return (File) The file with that path. If none were found return null
         */
        String next = "";
        int curPlace = 0, length = path.length();
        Folder currFolder = this;
        boolean didChange = false;
        while (true) {
            while (curPlace < length && path.charAt(curPlace) != '/') {
                next += path.charAt(curPlace);
                curPlace++;
            }
            curPlace++;
            didChange = false;
            for (StorageItem s : currFolder.items) {
                if (s.getName().equals(next)) {
                    if (s instanceof File)
                        return (File) s;
                    currFolder = (Folder) s;
                    didChange = true;
                    break;
                }
            }
            if (!didChange)
                return null;
            next = "";
        }
    }

}
