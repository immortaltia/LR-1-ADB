public class Main {
    public static void main(String[] args) {
        System.out.println("LEVEL 1: HASH TABLE (variant 22)");
        HashTable table = new HashTable(15);

        table.insert("AB123456", new Person("Ivanov", "Ivan", "Kyiv", "AB123456"));
        table.insert("CD789012", new Person("Petrov", "Petro", "Lviv", "CD789012"));
        table.insert("EF345678", new Person("Sydorenko", "Olena", "Kyiv", "EF345678"));
        table.insert("GH901234", new Person("Kovalenko", "Andriy", "Kharkiv", "GH901234"));
        table.insert("IJ567890", new Person("Bondarenko", "Maria", "Kyiv", "IJ567890"));
        table.insert("KL234567", new Person("Shevchenko", "Dmytro", "Odesa", "KL234567"));
        table.insert("MN890123", new Person("Melnyk", "Olha", "Kyiv", "MN890123"));

        System.out.println("\nHash Table:");
        table.print();

        System.out.println("\nSearch by key 'EF345678':");
        Person found = table.get("EF345678");
        if (found != null) {
            System.out.println(found);
        } else {
            System.out.println("Person with key EF345678 not found.");
        }

        System.out.println("\n\nLEVEL 2: DEQUE");
        Deque deque = new Deque();

        deque.pushFront("First");
        deque.pushFront("Second");
        deque.pushBack("Zero");
        deque.pushFront("Third");

        System.out.println("Deque after pushes:");
        deque.print();

        System.out.println("\nPop from front: " + deque.popFront());
        System.out.println("Deque after pop:");
        deque.print();

        System.out.println("\n\nLEVEL 3: TRANSFER KYIV RESIDENTS");
        Deque kyivResidents = transferKyivResidents(table);
        System.out.println("Kyiv residents (surname and name) in table order:");
        kyivResidents.print();
    }

    public static Deque transferKyivResidents(HashTable table) {
        Deque deque = new Deque();
        Person[] persons = table.getAllPersons();
        for (int i = 0; i < persons.length; i++) {
            if (persons[i] != null && "Kyiv".equals(persons[i].getCity())) {
                String fullName = persons[i].getSurname() + " " + persons[i].getName();
                deque.pushBack(fullName);
            }
        }
        return deque;
    }
}
