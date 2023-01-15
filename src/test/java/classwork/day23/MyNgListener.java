package classwork.day23;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.text.SimpleDateFormat;


public class MyNgListener implements ITestListener {

    private static final Logger LOGGER = LogManager.getLogger(MyNgListener.class);

    public void onTestSuccess(ITestResult result) {
        String caseId = result.getMethod().getDescription();
        LOGGER.info(String.format("Test %s successfully passed: ", caseId));
        LOGGER.info("Test case Id: " + caseId);
        MyTestRailReported.report(caseId, 1,
                "Test passed at: " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(result.getEndMillis()));
    }

    public void onTestFailure(ITestResult result) {
        String caseId = result.getMethod().getDescription();
        LOGGER.info(String.format("Test %s failed: ", caseId));
        LOGGER.info("Test case Id: " + caseId);
        MyTestRailReported.report(caseId, 5,
                "Test failed at: " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(result.getEndMillis()));
    }

}
