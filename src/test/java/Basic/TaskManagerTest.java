package Basic;

import org.example.basic.TaskManager;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.platform.commons.support.AnnotationSupport;

import java.lang.annotation.Annotation;
import java.util.concurrent.TimeUnit;

public class TaskManagerTest {
    @Test
    @Timeout(value=2,unit = TimeUnit.SECONDS)
    void testLongRunningTaskFailsOnTimeout(){
        TaskManager.longRunningTask();
    }
}
