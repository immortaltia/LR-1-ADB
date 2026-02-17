public class Person {
    private String surname;
    private String name;
    private String city;
    private String passportSeriesAndNumber;

    public Person(String surname, String name, String city, String passportSeriesAndNumber) {
        this.surname = surname;
        this.name = name;
        this.city = city;
        this.passportSeriesAndNumber = passportSeriesAndNumber;
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public String getPassportSeriesAndNumber() {
        return passportSeriesAndNumber;
    }

    @Override
    public String toString() {
        return String.format("Person{surname='%s', name='%s', city='%s', passport='%s'}",
                surname, name, city, passportSeriesAndNumber);
    }
}
