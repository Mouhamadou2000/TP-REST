package Models;

import jakarta.persistence.Access;
import jakarta.persistence.AccessType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
@Access(AccessType.FIELD)
public class Commune {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@Column(name="CodePostal")
	private long	CodePostal;
	
	@Column(name="name",length=80)
	private  String name;
	   public Commune() {
		   
	   }
	   
public Commune(long CodePostal,String name ) {
	this.CodePostal=CodePostal;
	this.name=name;
		   
	  }
public Commune(long id,long CodePostal,String name ) {
	this.CodePostal=CodePostal;
	this.name=name;
	this.id=id;
		   
	  }

	   
	    
	
   public long getCodePostael() {
		return CodePostal;
	}
	public void setCodePostael(long codePostael) {
		CodePostal = codePostael;
	}
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

   
}
