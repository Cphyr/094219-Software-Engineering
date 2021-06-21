import java.sql.Timestamp;
import java.util.Collections;
import java.util.Comparator;

abstract public class StorageItem {
    private String name;
    private final Timestamp date;
    private int size;

    abstract public int getSize();

    public StorageItem(String name) {
        this.name = name;
        this.date = MakeDate(); // change later
    }

    public long abs(long num) {
        if (num >= 0)
            return num;
        return -num;
    }

    public Timestamp MakeDate() {
        Timestamp first = Timestamp.valueOf("2017-1-1 00:00:00");
        Timestamp second = Timestamp.valueOf("2021-12-31 23:59:59");
        long numOfMilli = second.getTime() - first.getTime();
        long mill = Main.rnd.nextLong();
        mill = abs(mill % numOfMilli);
        return new Timestamp(mill + first.getTime());
    }

    public String getName() {
        return name;
    }

    public Timestamp getDate() {
        return date;
    }

    public void sortTree(SortingField field) {
        Comparator<StorageItem> comparator = Comparator.comparing(StorageItem::getSize);
        if (field == SortingField.DATE) {
            comparator = Comparator.comparing(StorageItem::getDate).thenComparing(StorageItem::getName);
        } else if (field == SortingField.NAME) {
            comparator = Comparator.comparing(StorageItem::getName);
        } else {
            comparator = Comparator.comparing(StorageItem::getSize).thenComparing(StorageItem::getName);
        }
        if (this instanceof Folder)
            Collections.sort(((Folder) this).getItems(), comparator);
    }

    public void printTree(SortingField field) {
        printTree(0, field);
    }

    public void printTree(int depth, SortingField field) {
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
