package Models;

import jakarta.ws.rs.Path;

@Path("calculator")
public class Calculor {

	private int chiffre1;
	private int chiffre2;
	private int result;
	public Calculor() {
		
	}
	public Calculor(int chif1,int chif2,int result) {
		this.chiffre1=chif1;
		this.chiffre2=chif2;
		this.result=result;
	}
	
	public static Calculor add(int c1,int c2) {
		return new Calculor(c1,c2,(c1+c2)) ;
	}
	public int getChiffre1() {
		return chiffre1;
	}
	public void setChiffre1(int chiffre1) {
		this.chiffre1 = chiffre1;
	}
	public int getChiffre2() {
		return chiffre2;
	}
	public void setChiffre2(int chiffre2) {
		this.chiffre2 = chiffre2;
	}
	public int getResult() {
		return result;
	}
	public void setResult(int result) {
		this.result = result;
	}
	public static Calculor multiply(int c1,int c2) {
		return new Calculor(c1,c2,(c1*c2)) ;
	}
	
	public static Calculor divise(int c1,int c2) {
		return new Calculor(c1,c2,(c1/c2)) ;
	}
	
	
	
}
