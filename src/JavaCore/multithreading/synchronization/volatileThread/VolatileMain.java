package JavaCore.multithreading.synchronization.volatileThread;

public class VolatileMain {

    static  int i;

    public static void main(String[] args) {
        new MyThreadRead().start();
        new MyThreadWrite().start();
    }

    static class MyThreadWrite extends Thread {

        @Override
        public void run() {
            while (i < 5) {
                System.out.println("increment i to " + (++i));
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class MyThreadRead extends Thread {

        @Override
        public void run() {
            while (i < 5) {
//	            System.out.println("new value of i is " + (i));
// memory barrier, System.out.println — це synchronized метод, після якого javac into share memory
	            // println uses synchronized internally.
	            // monitor enter/exit create memory barriers,
	            // therefore the thread re-reads shared variable i.
	            // на exit monitor (monitorexit) JVM/CPU повинні:

	            //publish усі попередні writes
	            //invalidate / refresh stale cached reads у інших потоків
	           // Тобто після synchronization інший thread вже не може легально бачити стару версію.

	           // Thread-local working memory
               // ↓ publis
	            // Shared visible state

            }
        }
    }
}
