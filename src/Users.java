
public class Users {
	public String serviceclass;
	public float charges = 0;
	
	public float getCharges() {
		return this.charges;
	}
	
	public float setCharges(float serviceCharge) {
		return charges = serviceCharge;
	}
	
	public String getServiceClass() {
		return this.serviceclass;
	}
	
	public String setServiceClass(String serviceclass) {
		return this.serviceclass = serviceclass;
	}
	
	public void finalize() {
	}
	
	public void call(Charges ch, String servicetype, String method, String masquerading) {
	
	}
}
