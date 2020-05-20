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
        assertEquals(1, loopArr.poll());
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
}