package seralizare;

public class Angajat extends Persoana {
    private String numeCompanie;

    public Angajat(String name, Integer age, Job job, String numeCompanie) {
        super(name, age, job);
        this.numeCompanie = numeCompanie;
    }

    @Override
    public String toString() {
        return "Angajat{" +
                "numeCompanie='" + numeCompanie + '\'' +
                '}' + super.toString();
    }
}
