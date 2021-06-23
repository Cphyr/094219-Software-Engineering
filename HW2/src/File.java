public class File extends StorageItem {
    private String ending;
    private String content;

    public int getSize() {
        return content.length();
    }

    public File(String name, String ending) {
        /**
         * The constructor
         * @param   name    (string) the files name
         * @param   ending    (string) the files ending
         */
        super(name);
        this.ending = ending;
        content = "";
    }

    public void addContent(String contentToAdd)
    {
        /**
         * Adds content
         * @param contentToAdd (String) The string to add
         */
        content += contentToAdd;
    }

    public void printContent() {
        /**
         * Prints the content of the file.
         */
        System.out.println(this.getName() + " Size: " + this.getSize() + "MB Created: " + super.getDate());
        System.out.println(this.content);
    }

    public String getName() {
        /**
         * @return  (String) the name of the file
         */
        return (super.getName() + "." + ending);
    }
}
