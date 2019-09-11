import org.apache.jmeter.engine.StandardJMeterEngine;
import org.apache.jmeter.save.SaveService;
import org.apache.jmeter.util.JMeterUtils;
import org.apache.jorphan.collections.HashTree;
import java.io.File;

public class RunTest {

	public static void main(String[] args) throws Exception {
		// JMeter Engine
		StandardJMeterEngine jmeter = new StandardJMeterEngine();

		// Initialize Properties, logging, locale, etc.
		JMeterUtils.loadJMeterProperties("E:\\apache-jmeter-5.1.1\\bin");
		JMeterUtils.setJMeterHome("E:\\apache-jmeter-5.1.1");
		//JMeterUtils.initLogging(); // you can comment this line out to see extra log messages of i.e. DEBUG level
		JMeterUtils.initLocale();

		// Initialize JMeter SaveService
		SaveService.loadProperties();

		// Load existing .jmx Test Plan
		File in = new File("./jmxPath/Inedge.jmx");
		HashTree testPlanTree = SaveService.loadTree(in);
		//in.close();

		// Run JMeter Test
		jmeter.configure(testPlanTree);
		jmeter.run();
	}
}
