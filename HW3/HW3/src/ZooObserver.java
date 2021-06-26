public class ZooObserver{
    final String name;
    public ZooObserver(String name){
        this.name=name;
    }

    public void notify(String msg){
        /**
         * @param   msg     the notification
         * @since   
         */
        System.out.println("["+name+"] "+msg);
    }
}