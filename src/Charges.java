import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType (XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {"userclass"})
@XmlRootElement(name="charges", namespace="")
public class Charges {
	List<Userclass> userclass = new ArrayList<Userclass>();
	
	public List<Userclass> getUserclass() {
		if (userclass == null) {
            userclass = new ArrayList<Userclass>();
        }
        return this.userclass;
	}
	
	public Charges addUserclass(Userclass uc) {
		this.userclass.add(uc);
		return this;
	}
}
