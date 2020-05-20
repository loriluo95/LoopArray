import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LoopArrayTest {

    LoopArray<Integer> loopArr;
    @BeforeEach
    public void init() {
        loopArr = new LoopArray<>(2);
    }

    @Test
    public void testOfferWhenNotFull() {
        loopArr.offer(1);
        assertEquals(1, loopArr.peek());
        loopArr.offer(2);
        assertEquals(1, loopArr.peek());
        assertEquals(2, loopArr.size());
    }

    @Test
    public void testOfferWhenFull() {
        loopArr.offer(1);
        loopArr.offer(2);
        loopArr.offer(3);
        assertEquals(1, loopArr.peek());
        assertEquals(3, loopArr.size());
    }

    @Test
    public void testPollWhenNotEmpty() {
        loopArr.offer(1);
        loopArr.offer(2);
        loopArr.offer(3);
        assertEquals(1, loopArr.poll());
        assertEquals(2, loopArr.size());
    }

    @Test
    public void testPollWhenEmpty() {
        loopArr.offer(1);
        loopArr.offer(2);
        loopArr.offer(3);
        assertEquals(1, loopArr.poll());
        assertEquals(2, loopArr.size());
        loopArr.poll();
        loopArr.poll();
        assertThrows(NullPointerException.class, () -> loopArr.poll());
    }

    @Test
    public void testPeek() {
        loopArr.offer(1);
        loopArr.offer(2);
        loopArr.offer(3);
        assertEquals(1, loopArr.peek());
        assertEquals(3, loopArr.size());
    }

    @Test
    public void testSize() {
        loopArr.offer(1);
        assertEquals(1, loopArr.size());
        loopArr.offer(2);
        loopArr.offer(3);
        assertEquals(3, loopArr.size());
        loopArr.poll();
        assertEquals(2, loopArr.size());
    }

    @Test
    void testIsEmpty() {
        loopArr.offer(1);
        assertEquals(false, loopArr.isEmpty());
        loopArr.poll();
        assertEquals(true, loopArr.isEmpty());
    }

    @Test
    void testLoopWithoutResize() {
        loopArr.offer(1);
        loopArr.offer(2);
        loopArr.poll();
        loopArr.offer(3);
        loopArr.poll();
        loopArr.offer(4);
        assertEquals(2, loopArr.size());
        assertEquals(3, loopArr.peek());
    }

    @Test
    void testLoopWithResize() {
        loopArr.offer(1);
        loopArr.offer(2);
        loopArr.offer(3);
        loopArr.offer(4);
        loopArr.offer(5);
        loopArr.poll();
        loopArr.poll();
        loopArr.offer(6);
        loopArr.poll();
        assertEquals(3, loopArr.size());
        assertEquals(4, loopArr.peek());
    }

    @Test
    void testDefaultCapacity() {
        loopArr = new LoopArray<>();
        loopArr.offer(1);
        loopArr.offer(2);
        loopArr.offer(3);
        loopArr.offer(4);
        loopArr.offer(5);
        loopArr.offer(6);
        loopArr.offer(7);
        loopArr.offer(8);
        loopArr.offer(9);
        loopArr.offer(10);
        assertEquals(10, loopArr.size());
        assertEquals(1, loopArr.poll());
        loopArr.offer(11);
        assertEquals(10, loopArr.size());
        assertEquals(2, loopArr.poll());
        assertEquals(3, loopArr.poll());
        loopArr.offer(12);
        assertEquals(9, loopArr.size());
    }
}