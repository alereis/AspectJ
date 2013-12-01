import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class ParseXML {
	
	public Charges parse() throws JAXBException {
		JAXBContext jaxbContext = JAXBContext.newInstance(Charges.class);		
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		File file = new File("src/charges.xml");
		Charges ch = (Charges) jaxbUnmarshaller.unmarshal(file);
		return ch;
	}
	
	public float getCharges(Charges ch, String classname, String serviceclass, String servicemethod, float charges) {
		boolean flag = true;
		outerloop:
		for (Userclass uc : ch.userclass) {
			if (uc.getClassname().equals(classname)) { // get classname
				for (Service s : uc.getService()) {
					if (s.getServiceclass().equals(serviceclass)) { // get serviceclass
						for (Servicemethod sm : s.getServicemethod()) {
							if (sm.getValue().equals(servicemethod)) { // get servicemethod
								charges = sm.getCharge();
								flag = true;
								break outerloop;
							} else {
								flag = false;
							}
						}
					} else {
						flag = false;
					}
				}
			} else {
				flag = false;
			}
		}
		
		if (!flag) {
			charges = (float) 0.0;
		}
		
		return charges;
	}
}
