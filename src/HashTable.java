public class HashTable {
    private static class HashElement {
        String key;
        Person value;
        boolean deleted;

        HashElement(String key, Person value) {
            this.key = key;
            this.value = value;
            this.deleted = false;
        }
    }

    private HashElement[] table;
    private int capacity;
    private int count;

    public HashTable(int capacity) {
        if (capacity <= 0) capacity = 16;
        this.capacity = capacity;
        this.table = new HashElement[capacity];
        this.count = 0;
    }

    private int hashFunc(String key) {
        long hash = 0;
        for (int i = 0; i < key.length(); i++) {
            hash += key.charAt(i);
        }
        return (int) (hash % capacity);
    }

    public boolean isFull() {
        return count == capacity;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean insert(String key, Person value) {
        if (key == null || value == null) return false;
        if (isFull()) {
            System.out.println("HashTable is full. Cannot insert.");
            return false;
        }

        int index = hashFunc(key);
        int start = index;
        int firstDeletedIndex = -1;

        do {
            HashElement el = table[index];
            if (el == null) {
                int target = (firstDeletedIndex != -1) ? firstDeletedIndex : index;
                table[target] = new HashElement(key, value);
                count++;
                return true;
            } else if (el.deleted) {
                if (firstDeletedIndex == -1) firstDeletedIndex = index;
            } else if (el.key.equals(key)) {
                table[index].value = value;
                return true;
            }
            index = (index + 1) % capacity;
        } while (index != start);

        if (firstDeletedIndex != -1) {
            table[firstDeletedIndex] = new HashElement(key, value);
            count++;
            return true;
        }

        return false;
    }

    public Person get(String key) {
        if (key == null) return null;
        int index = hashFunc(key);
        int start = index;

        do {
            HashElement el = table[index];
            if (el == null) {
                return null;
            }
            if (!el.deleted && el.key.equals(key)) {
                return el.value;
            }
            index = (index + 1) % capacity;
        } while (index != start);

        return null;
    }

    public void print() {
        System.out.println(String.format("%-5s | %-15s | %s", "Idx", "Key", "Value"));
        System.out.println("-----------------------------------------------");
        for (int i = 0; i < capacity; i++) {
            HashElement el = table[i];
            if (el != null && !el.deleted) {
                System.out.println(String.format("%-5d | %-15s | %s", i, el.key, el.value.toString()));
            }
        }
    }

    public Person[] getAllPersons() {
        Person[] res = new Person[capacity];
        for (int i = 0; i < capacity; i++) {
            HashElement el = table[i];
            if (el != null && !el.deleted) res[i] = el.value;
            else res[i] = null;
        }
        return res;
    }
}
