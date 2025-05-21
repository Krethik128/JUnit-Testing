import com.gevernova.TaskManager;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.concurrent.TimeUnit;
import static org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

class TaskManagerTest {

    @Test
    @Timeout(value = 5, unit = TimeUnit.SECONDS)
    void testTaskCompletesWithinTimeout() {
        String result = TaskManager.longRunningTask();
        assertEquals("completed", result);
    }

    @Test
    void testTaskReturnsExpectedOutput() {
        assertEquals("completed", TaskManager.longRunningTask(), "Task should return 'completed'");
    }

    @Test
    @Timeout(value = 4, unit = TimeUnit.SECONDS)
    void testTaskRunsUnderSufficientTimeout() {
        assertDoesNotThrow(() -> TaskManager.longRunningTask());
    }

    @Test
    void testInterruptedExceptionHandledAsRuntimeException() {
        Thread testThread = new Thread(() -> {
            try {
                TaskManager.longRunningTask(); // Should be interrupted
                fail("Expected RuntimeException due to interruption");
            } catch (RuntimeException e) {
                assertTrue(e.getCause() instanceof InterruptedException);
            }
        });
        testThread.start();
        testThread.interrupt(); // Simulate interruption
    }

    @Test
    void testMultipleExecutionsWithPerformanceCheck() {
        long start = System.currentTimeMillis();
        TaskManager.longRunningTask();
        TaskManager.longRunningTask();
        TaskManager.longRunningTask();
        long duration = System.currentTimeMillis() - start;
        assertTrue(duration >= 9000, "Total time should be at least 9 seconds for 3 executions");
    }
}
