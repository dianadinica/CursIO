package rezolvareTema29.serializare;

import java.time.LocalDate;

public class FullProfile extends Profile {
    private LocalDate birthdate;

    public FullProfile(String email, String name, char[] password, LocalDate birthdate) {
        super(email, name, password);
        this.birthdate = birthdate;
    }

    @Override
    public String toString() {
        return "FullProfile{" +
                "birthdate=" + birthdate +
                '}' + super.toString();
    }
}
