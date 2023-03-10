package za.co.wethinkcode.lms.test;

import org.junit.jupiter.api.Test;
import org.junit.platform.launcher.listeners.TestExecutionSummary;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Test class for running student's unit tests as part of LMS test suite.
 */
public class StudentTest {
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @Test
    void studentTests() {
        System.setOut(new PrintStream(outputStreamCaptor));
        TestExecutionSummary testSummary = RunJUnit5TestsFromJava.runAll("za.co.wethinkcode.toyrobot");
        System.setOut(standardOut);

        testSummary.printTo(new PrintWriter(System.out));
        testSummary.printFailuresTo(new PrintWriter(System.out));

        // assertTrue(testSummary.getContainersFoundCount() > 6, "Expected more than 6 student unit test classes.");
        assertEquals(0, testSummary.getContainersFailedCount(), "Expected that no unit test class fails.");
        assertTrue(testSummary.getTestsFoundCount() > 10, "Expected more than 10 student test cases."); //we want at least 3 individual tests
        // assertEquals(0, testSummary.getTotalFailureCount(), "Expected that there are no test failures.");
    }

}
