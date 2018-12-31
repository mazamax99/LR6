public class NewThreadMulti implements Runnable{
    String name;
    Thread t;
    NewThreadMulti(String threadname) {
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
class MultiThread{
    public static void main (String args[]){
        new NewThreadMulti("Один");
        new NewThreadMulti("Два");
        new NewThreadMulti("Три");
        try {
                Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Главный поток прерван");
        }
        System.out.println("Главный поток завершен");
    }

}
//Соэдание многих потоков исполнения