
package modele;

import javax.persistence.*;

@Entity
@Table (name="organisateur")
public class Organisateur {
    @Id
    private String login;
    private String password;

    public Organisateur() {}

    public Organisateur(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }
    
    
}
