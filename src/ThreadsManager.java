public class ThreadsManager extends Thread {
    public void manager(Object thread){
        String name=thread.getClass().getSimpleName();
        Log log=new Log();
        this.interrupt();
        log.logger(name+" stopped");
    }
}
