package reexecutionFailedTestCases;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

public class IAnnot implements IAnnotationTransformer {
	@Override
	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
		annotation.setRetryAnalyzer(reexecutionFailedTestCases.RetryFailedTestCases.class); // it will apply for every
																							// test if the test failed

	}

}