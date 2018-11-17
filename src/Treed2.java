import java.util.Date;
public class Treed2  extends Thread{
    public  void run2(){
        boolean cycle=true;
        Log log=new Log();
        long time1=new Date().getTime();
        while(cycle==true) {
            log.logger("Thread2 ran");
            long time2=new Date().getTime();
            if(time2-time1>5000) {
                this.interrupt();
                log.logger("Thread2 stopped");
                break;
            }
        }


    }
}
