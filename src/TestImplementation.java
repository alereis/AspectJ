import javax.xml.bind.JAXBException;


public class TestImplementation {

	public static void main(String[] args) throws JAXBException {
		ParseXML p = new ParseXML();
		Charges ch = p.parse();
		
		// tests for No Masquerading = no
		// each customer is charged for their calls
		Users alessandro = new Users();
		alessandro.setServiceClass("adhoc");
		alessandro.call(ch, "local", "call", "no"); // 0.05
		alessandro.call(ch, "local", "call", "no"); // 0.05
		alessandro.call(ch, "longdistance", "call", "no"); // 0
		alessandro.call(ch, "local", "text", "no"); // 0.02
		alessandro.finalize();
		
		Users Bob = new Users();
		Bob.setServiceClass("prepaid");
		Bob.call(ch, "longdistance", "call", "no"); // 0.05
		Bob.call(ch, "longdistance", "text", "no"); // 0.02
		Bob.call(ch, "international", "call", "no"); // 0.25
		Bob.call(ch, "local", "text", "no"); // 0.01
		Bob.finalize();
		
		Users Peter = new Users();
		Peter.setServiceClass("monthly");
		Peter.call(ch, "longdistance", "call", "no"); // 0.03
		Peter.call(ch, "longdistance", "text", "no"); // 0
		Peter.call(ch, "international", "call", "no"); // 0.05
		Peter.call(ch, "local", "text", "no"); // 0
		Peter.finalize();
		
		// tests for No Masquerading = yes
		// Top level customer will be charged for all calls
		
		Users Will = new Users();
		Will.setServiceClass("adhoc");
		Will.call(ch, "local", "call", "yes"); //0.05
		
		Users Linda = new Users();
		Linda.setServiceClass("prepaid");
		Linda.call(ch, "longdistance", "call", "yes"); //0.05
		
		Users Robert = new Users();
		Robert.setServiceClass("monthly");
		Robert.call(ch, "longdistance", "call", "yes"); // 0.03
		
		Will.finalize();
	}
}
