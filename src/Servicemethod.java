import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;

@XmlAccessorType (XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {"value"})
public class Servicemethod {
	@XmlValue
    protected String value;
    @XmlAttribute(name = "charge")
    protected float charge;
	
    public String getValue() {
        return value;
    }
    
    public void setValue(String value) {
        this.value = value;
    }
    
    public float getCharge() {
        return charge;
    }
    
    public void setCharge(float value) {
        this.charge = value;
    }
}
