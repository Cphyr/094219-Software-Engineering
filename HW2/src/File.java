public class File extends StorageItem{
    private String end;
    private String content;
    public File(String name,String end){
        super(name);
        this.end=end;
        this.size=0;
        this.content="";
    }

    @Override
    public int getSize() {
        return this.size;
    }
    public String getName(){
        return this.name;
    }
    public void AddContent(String contentToAdd){
        this.content= this.content+contentToAdd;
        this.size+=contentToAdd.length();
    }
}
