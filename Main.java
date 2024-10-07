class Thread1 implements Runnable {
    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("thread 1 : " + i);
            try {
                Thread.sleep(1000); // Jeda 1 detik
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Thread2 implements Runnable {
    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("thread 2 : " + i);
            try {
                Thread.sleep(1500); // Jeda 1,5 detik
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        // Membuat thread untuk angka
        Thread thread1 = new Thread(new Thread1());
        
        // Membuat thread untuk huruf
        Thread thread2 = new Thread(new Thread2());

        // Menjalankan thread
        thread1.start();
        thread2.start();

        // Menunggu kedua thread selesai
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Selesai!");
    }
}
