package threads;

public class Threads implements Runnable{

    @Override
    public void run(){

        for(int i = 0; i < 5; i ++) {
            System.out.println(Thread.currentThread().getName() + " Executada pela " + (i+1) + "º vez");
            try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
        }
    }

    public static void main(String[] args) throws Exception{
        Runnable runnable = new Threads();
        Thread firstThread = new Thread(runnable);
        Thread secondThread = new Thread(runnable);

        firstThread.start();
        secondThread.start();

        secondThread.join(200);

    }
    
}