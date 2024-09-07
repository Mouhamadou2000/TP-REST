package Models;

import jakarta.jws.soap.SOAPBinding;
import jakarta.persistence.*;

@Entity
@Access(AccessType.FIELD)
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    @Column(name="CodePostal")
    private String	prenom;

    @Column(name="name",length=80)
    private  String name;

    public User(){}

    public User(String prenom,String name){

        this.prenom=prenom;
        this.name=name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
