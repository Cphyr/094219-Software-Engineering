public class File extends StorageItem{
    private String ending;
    private String content;

    public int getSize() {
        return content.length();
    }

    public File(String _name, String _ending) {
        super(_name);
        ending = _ending;
        content = "";
    }

    public void addContent(String contentToAdd){
        content += contentToAdd;
    }

    public void printContent() {
        System.out.println(this.getName() + " Size: " + this.getSize() + "MB Created: " + super.getDate());
        System.out.println(this.content);
    }

    public String getName() {
        return (super.getName() + "." + ending);
    }
}
