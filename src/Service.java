import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType (XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {"serviceclass", "servicemethod"})
public class Service {
	@XmlElement(required = true)
	String serviceclass;
	List<Servicemethod> servicemethod = new ArrayList<Servicemethod>();
	
	public String getServiceclass() {
		return serviceclass;
	}
	
	public void setServiceclass(String serviceclass) {
		this.serviceclass = serviceclass;
	}
	
	public List<Servicemethod> getServicemethod() {
		if (servicemethod == null) {
            servicemethod = new ArrayList<Servicemethod>();
        }
        return this.servicemethod;
	}
	
	public Service addServiceMethod(Servicemethod sm) {
		this.servicemethod.add(sm);
		return this;
	}
}
