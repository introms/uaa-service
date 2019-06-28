package it.itresources.demo.micro.uaaservice.domain;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "descriptions")
public class Description {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = true, length = 512)
    private String desccriptionText;

    @OneToOne(mappedBy = "description")
    private User user;

  

    public Description() {
    }

    public Description(Long id, String desccriptionText, User user) {
        this.id = id;
        this.desccriptionText = desccriptionText;
        this.user = user;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDesccriptionText() {
        return this.desccriptionText;
    }

    public void setDesccriptionText(String desccriptionText) {
        this.desccriptionText = desccriptionText;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Description id(Long id) {
        this.id = id;
        return this;
    }

    public Description desccriptionText(String desccriptionText) {
        this.desccriptionText = desccriptionText;
        return this;
    }

    public Description user(User user) {
        this.user = user;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Description)) {
            return false;
        }
        Description description = (Description) o;
        return Objects.equals(id, description.id) && Objects.equals(desccriptionText, description.desccriptionText) && Objects.equals(user, description.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, desccriptionText, user);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", desccriptionText='" + getDesccriptionText() + "'" +
            ", user='" + getUser() + "'" +
            "}";
    }

    
}