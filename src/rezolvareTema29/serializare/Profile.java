package rezolvareTema29.serializare;

import java.io.Serializable;
import java.util.Arrays;

public class Profile implements Serializable {
    private final String email;
    private final String name;
    private final transient char[] password;
    private static final long serialVersionUID = 1L;

    public Profile(String email, String name, char[] password) {
        this.email = email;
        this.name = name;
        this.password = password;
    }


    @Override
    public String toString() {
        return "Profile{" +
                "email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", password=" + Arrays.toString(password) +
                '}';
    }
}
