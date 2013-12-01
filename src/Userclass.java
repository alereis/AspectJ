import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType (XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {"classname", "service"})
public class Userclass {
	@XmlElement(required = true)
	String classname;
	List<Service> service = new ArrayList<Service>();
	
	public String getClassname() {
		return classname;
	}

	public void setClassname(String classname) {
		this.classname = classname;
	}
	
	public List<Service> getService() {
		if (service == null) {
            service = new ArrayList<Service>();
        }
        return this.service;
	}
	
	public Userclass addService(Service s) {
		this.service.add(s);
		return this;
	}
}
