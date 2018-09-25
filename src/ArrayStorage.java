import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private Resume[] storage = new Resume[10000];
    //по ООП мы делаем приватным то,что мы не хотим, что мог бы изменять пользователь(инкапсуляция) или закрытие реализации
    private int counter = 0;


    public void clear() {
        Arrays.fill(storage, 0, counter, null);
        counter = 0;
    }

    public void update(Resume r) {
        int index = getIndex(r.uuid);
        storage[index] = r;

        System.out.println("Резюме" + r.uuid + "уже существует");




    }

    public void save(Resume r) {
        storage[counter] = r;
        counter++;
    }

    public int getIndex(String uuid) {
        for (int i = 0; i < counter; i++) {
            if ((storage[i].uuid).equals(uuid)) {
                return i;


            }

        }
        return -1;
    }

    public Resume get(String uuid) {
        int index = getIndex(uuid);

        return storage[index];
    }



    public void delete(String uuid) {


        counter--;
        storage[counter] = null;


    }

    public Resume[] getAll() {
        return Arrays.copyOf(storage, counter);
    }

    public int size() {
        return counter;
    }
}

