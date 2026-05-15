package JavaCore.multithreading.synchronization.volatileThread;

public class VolatileDemo {

	/*
		тобто
		  1. flag = false
		  2. writethread - sleep
		  3. readThread go to infinite loop
		  4. writethread - awake
		  5. writethread - changed flag = true
		  6. readThread don't stop its loop cause use own version flag = false; and don't see changes
		  readThread - JIT оптимізації він зчитав flag у регістр CPU один раз
		  і більше ніколи не звертається до heap-пам'яті.
		  навіть якщо writeThread записав true в пам'ять — readThread про це не знає.
		  -----
		  7. if I add volatile then readThread will see changes and go out from the loop

	* */

	public static boolean flag = false;

	public static void main(String[] args){
		Thread writethread = new Thread(()->{
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
			flag = true;
		});

		Thread readThread = new Thread(() -> {
			while(!flag){
				int i = 0;
			}
			System.out.println("flag is " + flag);
		});

		writethread.start();
		readThread.start();

	}
}
