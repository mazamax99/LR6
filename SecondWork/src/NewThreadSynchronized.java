public class NewThreadSynchronized {
    void call(String msg){
        System.out.println("["+msg);
        try{
            Thread.sleep(1000);
        } catch(InterruptedException e){
            System.out.println("Прервано");
        }
        System.out.println("]");
    }
}
class CallerTrue implements Runnable {
    String msg;
    NewThreadSynchronized target;
    Thread t;
    public CallerTrue  (NewThreadSynchronized targ,String s)
    {
        target=targ;
        msg=s;
        t=new Thread(this);
        t.start();
    }

    public void run() {
        synchronized (target){
            target.call(msg);
        }

    }
}
class SynchTrue  {
    public static void main (String args[]){
        NewThreadSynchronized target=new NewThreadSynchronized();
        CallerTrue  ob1= new CallerTrue (target,"Добро пожаловать");
        CallerTrue  ob2= new CallerTrue (target,"в синхронизированный");
        CallerTrue  ob3= new CallerTrue (target,"мир!");
        System.out.println("Поток Один запущен: "+ ob1.t.isAlive());
        System.out.println("Поток Два запущен: "+ ob2.t.isAlive());
        System.out.println("Поток Три запущен: "+ ob3.t.isAlive());
        try {
            System.out.println("Ожидание завершения потоков");
            ob1.t.join();
            ob2.t.join();
            ob3.t.join();
        }
        catch (InterruptedException e) {
            System.out.println("Прервано");
        }
    }
}
//Программа с синхронизированным блоком