package com.ui.listerners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.constants.Env;
import com.utility.JSONUtility;
import com.utility.PropertiesUtil;

public class MyRetryAnalyzer implements IRetryAnalyzer{
	
	private final static int MAX_NUMBER_OF_ATTEMPTS= Integer.parseInt(PropertiesUtil.readProperty(Env.QA, "MAX_NUMBER_OF_ATTEMPTS"));
//	private final static int MAX_NUMBER_OF_ATTEMPTS= JSONUtility.readJSON(Env.DEV).getMAX_NUMBER_OF_ATTEMPTS();
	private static int currentAttempt=1;

	@Override
	public boolean retry(ITestResult result) {
		if(currentAttempt<=MAX_NUMBER_OF_ATTEMPTS) {
			currentAttempt++;
			return true;
		} 
		return false;
	}
	
	

}
