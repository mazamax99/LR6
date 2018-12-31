
import java.text.SimpleDateFormat;
import java.util.Date;
public  class Log {
    public static void logger(String name){
        Date date=new Date();
        long data=date.getTime();
        SimpleDateFormat dateFormat=new SimpleDateFormat("dd.MM.yyyy 'at' HH:mm:ss z");
        System.out.println("["+dateFormat.format(date)+"]"+"["+name+"]");

    }
}
