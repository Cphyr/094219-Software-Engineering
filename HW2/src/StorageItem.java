import java.sql.Timestamp;
import java.util.Collections;
import java.util.Comparator;

abstract public class StorageItem {
    private String name;
    private final Timestamp date;
    private int size;

    abstract public int getSize();

    public StorageItem(String name) {
        /**
         * Makes a StorageItem
         * 
         * @param name (string) the StorageItem's name
         */
        this.name = name;
        this.date = MakeDate();
    }

    public long abs(long num) {
        /**
         * @params num (long) the number
         * @return (long) the abs value
         */
        if (num >= 0)
            return num;
        return -num;
    }

    public Timestamp MakeDate() {
        /**
         * @returns (Timestamp) random timestamp
         */
        Timestamp first = Timestamp.valueOf("2017-1-1 00:00:00");
        Timestamp second = Timestamp.valueOf("2021-12-31 23:59:59");
        // calculates the number of milliseconds between the dates/
        long numOfMilli = second.getTime() - first.getTime();
        long mill = Main.rnd.nextLong();
        mill = abs(mill % numOfMilli);
        // Generates new long number
        return new Timestamp(mill + first.getTime());
    }

    public String getName() {
        return name;
    }

    public Timestamp getDate() {
        return date;
    }

    public void sortTree(SortingField field) {
        /**
         * Sorts the tree based on a given SortingField
         * 
         * @params field (SortingField) the SortingField to sort by.
         */
        Comparator<StorageItem> comparator;
        // Makes the correct Comparator object;
        if (field == SortingField.DATE) {
            comparator = Comparator.comparing(StorageItem::getDate).thenComparing(StorageItem::getName);
        } else if (field == SortingField.NAME) {
            comparator = Comparator.comparing(StorageItem::getName);
        } else {
            comparator = Comparator.comparing(StorageItem::getSize).thenComparing(StorageItem::getName);
        }
        // Sorts the tree
        if (this instanceof Folder)
            Collections.sort(((Folder) this).getItems(), comparator);
    }

    public void printTree(SortingField field) {
        /**
         * Calls a different PrintTree
         * 
         * @param field (SortingField) the SortingField to sort by.
         */
        printTree(0, field);
    }

    public void printTree(int depth, SortingField field) {
        /**
         * Prints the tree
         * 
         * @param depth (int) the depth in the tree the StorageItem is
         * @param field (SortingField) the SortingField to sort by.
         */
        sortTree(field);
        String start = "";
        for (int i = 0; i < depth; i++) {
            start += "|    ";
        }
        System.out.println(start + this.getName());
        if (this instanceof File)
            return;
        for (StorageItem s : ((Folder) this).getItems()) {
            s.printTree(depth + 1, field);
        }
    }
}
