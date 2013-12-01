import java.text.DecimalFormat;


public aspect AJBilling {
	ParseXML p = new ParseXML();
	boolean flag = true;
	Users currentUser;
	
	// pointcut is called when a user makes a call
	pointcut addToBill(Users u) : target(u) && execution(* Users.call(Charges, String , String, String));
	
	after(Users u) returning(): addToBill(u) {
		// when no masquerading charge each user
		if (thisJoinPoint.getArgs()[3].toString().equals("no")) {		
			float total = u.getCharges();
			total +=  p.getCharges((Charges) thisJoinPoint.getArgs()[0], u.getServiceClass(), thisJoinPoint.getArgs()[1].toString(), thisJoinPoint.getArgs()[2].toString(), total);
			u.setCharges(total);
		} else { // when no masquerading is relaxed charge top level user
			if (flag) {
				currentUser = (Users) thisJoinPoint.getTarget();
				flag = false;
			}
			float total = currentUser.getCharges();
			total +=  p.getCharges((Charges) thisJoinPoint.getArgs()[0], u.getServiceClass(), thisJoinPoint.getArgs()[1].toString(), thisJoinPoint.getArgs()[2].toString(), total);
			currentUser.setCharges(total);
		}
	}
	
	// pointcut is called when the user finalize a call
	pointcut totalBill(Users u) : target(u) && execution(* Users.finalize(..));
	
	after(Users u) returning(): totalBill(u) {
		DecimalFormat df = new DecimalFormat("###.##");
		System.out.println("Total = " + df.format(u.getCharges()) + "\n");
	}
}
