public class NewThreadAliveAndJoin implements Runnable{
    String name;
    Thread t;
    NewThreadAliveAndJoin(String threadname) {
        name=threadname;
        t = new Thread(this, name);
        System.out.println("Новый поток: " + t);
        t.start();
    }

    public void run() {
        try {
            for (int i = 5; i > 0; i--) {
                System.out.println(name +":"+ i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println(name +":"+"прерван");
        }
        System.out.println(name +":"+"завершен");
    }
}
class DemoJoin{
    public static void main (String args[]){
        NewThreadAliveAndJoin ob1= new NewThreadAliveAndJoin("Один");
        NewThreadAliveAndJoin ob2= new NewThreadAliveAndJoin("Два");
        NewThreadAliveAndJoin ob3= new NewThreadAliveAndJoin("Три");
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
            System.out.println("Главный поток прерван");
        }
    }
}
//Применение методов isAlive () и join ()