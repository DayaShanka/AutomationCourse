package reexecutionFailedTestCases;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryFailedTestCases implements IRetryAnalyzer {

	private int retryCount = 0;
	private final int retryMaxCount = 3; // how many time i want to retry failed test case

	@Override
	public boolean retry(ITestResult arg0) {

		if (retryCount < retryMaxCount) {
			retryCount++;
			return true;
		}
		return false;
	}
}
