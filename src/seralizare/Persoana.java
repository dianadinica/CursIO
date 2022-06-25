package seralizare;

import java.io.Serializable;
import java.util.Objects;

public class Persoana implements Serializable {
    private String myName;
    private Integer age;
    private transient Job job;
    private static Integer nrPersoane = 0;
    private static final long serialVersionUID = 1;

    public Persoana() {
        nrPersoane++;
        System.out.println("Din constructorul default");
    }

    public Persoana(String myName, Integer age) {
        nrPersoane++;
        System.out.println("Din constructorul cu 2 params");
        this.myName = myName;
        this.age = age;
    }

    public Persoana(String myName, Integer age, Job job) {
        System.out.println("Din constructorul cu 3 params");
        nrPersoane++;
        this.myName = myName;
        this.age = age;
        this.job = job;
    }

    @Override
    public String toString() {
        return "Persoana{" +
                "myName='" + myName + '\'' +
                ", age=" + age +
                ", job=" + job +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Persoana persoana = (Persoana) o;
        return Objects.equals(myName, persoana.myName) && Objects.equals(age, persoana.age) && Objects.equals(job, persoana.job);
    }

    @Override
    public int hashCode() {
        return Objects.hash(myName, age, job);
    }
}
