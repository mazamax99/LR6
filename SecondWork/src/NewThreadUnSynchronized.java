public class NewThreadUnSynchronized {
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
class Caller implements Runnable {
    String msg;
    NewThreadUnSynchronized target;
    Thread t;
    public Caller (NewThreadUnSynchronized targ,String s)
    {
        target=targ;
        msg=s;
        t=new Thread(this);
        t.start();
    }

    public void run() {
    target.call(msg);
    }
}
class Synch {
    public static void main (String args[]){
        NewThreadUnSynchronized target=new NewThreadUnSynchronized();
        Caller ob1= new Caller(target,"Добро пожаловать");
        Caller ob2= new Caller(target,"в синхронизированный");
        Caller ob3= new Caller(target,"мир!");
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
//Программа с несинхронизированным блоком