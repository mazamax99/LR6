import java.util.Date;
public class Treed1 extends Thread {
    public  void run1(){
        boolean cycle=true;
        Log log=new Log();
        long time1=new Date().getTime();
        long time2=time1;
        while(cycle==true) {
            log.logger("Thread1 ran");
           time2=new Date().getTime();
            if(time2-time1>5000) {
                this.interrupt();
                log.logger("Thread1 stopped");
                break;
            }
        }

    }
}
