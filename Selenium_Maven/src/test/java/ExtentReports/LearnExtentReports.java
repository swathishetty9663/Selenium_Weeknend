package ExtentReports;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class LearnExtentReports {
	@Test
	public void createReport() {
		
		String time = LocalDateTime.now().toString().replace(":", "-");
		//step1: create ExtentSparkReporter object
		ExtentSparkReporter spark=new ExtentSparkReporter("./HTML_Reports/ExtentReport_"+time+".html");
		
		//step2 : create ExtentReports object
		ExtentReports extReport=new ExtentReports();
		
		//step3 :  attach ExtentSparkReporter to ExtentReports
		extReport.attachReporter(spark);
		
		//step4 : create ExtentTest object
		ExtentTest test=extReport.createTest("createReport");
		
		//step5: call log() to provide status and message
		test.log(Status.PASS, "Message added into report");
		
		//step6 : call flush()
		extReport.flush();
		
	}
}
