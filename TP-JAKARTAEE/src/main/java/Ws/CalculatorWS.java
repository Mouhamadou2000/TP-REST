package Ws;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;

@WebService
public class CalculatorWS {
	@WebMethod
	public int add(int a,int b) {
		return a+b;
	}

	
}
