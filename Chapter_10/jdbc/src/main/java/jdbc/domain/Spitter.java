package jdbc.domain;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * <p>Title: jdbc.domain.Spitter</p>
 *
 * @description:
 * @author: xiongzy
 * @date: 2018-10-23
 **/
public class Spitter {


    private Long id;
    private String username;
    private String password;
    private String fullName;
    private String email;
    private boolean updateByEmail;

    public Spitter() {
    }

    public Spitter(Long id, String username, String password, String fullName, String email, boolean updateByEmail) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.email = email;
        this.updateByEmail = updateByEmail;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getFullName() {
        return fullName;
    }

    public String getEmail() {
        return email;
    }

    public boolean isUpdateByEmail() {
        return updateByEmail;
    }

    @Override
    public boolean equals(Object obj) {
        return EqualsBuilder.reflectionEquals(this, obj);
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    // @Test
    public static void main(String[] args) {
        Spitter spitter = new Spitter(1L, "habuma", "password", "Craig Walls",
                "craig@habuma.com", false);
        Spitter spitter2 = new Spitter(2L, "habuma", "password", "Craig Walls",
                "craig@habuma.com", false);

        System.out.println(spitter.equals(spitter2));
    }
}