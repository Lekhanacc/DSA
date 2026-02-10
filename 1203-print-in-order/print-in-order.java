// class Foo {

//     public Foo() {
        
//     }

//     public void first(Runnable printFirst) throws InterruptedException {
        
//         // printFirst.run() outputs "first". Do not change or remove this line.
//         printFirst.run();
//     }

//     public void second(Runnable printSecond) throws InterruptedException {
        
//         // printSecond.run() outputs "second". Do not change or remove this line.
//         printSecond.run();
//     }

//     public void third(Runnable printThird) throws InterruptedException {
        
//         // printThird.run() outputs "third". Do not change or remove this line.
//         printThird.run();
//     }
// }

import java.util.concurrent.CountDownLatch;
class Foo {

    // Latch to make second wait for first
    private CountDownLatch latch1;

    // Latch to make third wait for second
    private CountDownLatch latch2;

    public Foo() {
        latch1 = new CountDownLatch(1);
        latch2 = new CountDownLatch(1);
    }

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first"
        printFirst.run();

        // Signal that first() is finished
        latch1.countDown();
    }

    public void second(Runnable printSecond) throws InterruptedException {

        // Wait until first() finishes
        latch1.await();

        // printSecond.run() outputs "second"
        printSecond.run();

        // Signal that second() is finished
        latch2.countDown();
    }

    public void third(Runnable printThird) throws InterruptedException {

        // Wait until second() finishes
        latch2.await();

        // printThird.run() outputs "third"
        printThird.run();
    }
}
