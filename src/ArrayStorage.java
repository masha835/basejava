import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private Resume[] storage = new Resume[10_000];
    private int counter = 0;

    public void clear() {
        Arrays.fill(storage, 0, counter, null);
        counter = 0;
    }

    public void update(Resume r) {
        int index = getIndex(r.uuid);
        if (index == -1) {
            System.out.println("Не существует");

        } else {
            storage[index] = r;
        }

    }
    
    public void save(Resume r) {

        if (getIndex(r.uuid) != -1) {
            System.out.println("Резюме существует");

        } else if (counter >= storage.length) {
            System.out.println("Места больше нет");
        } else {
            storage[counter] = r;
            counter++;
        }

    }

    public Resume get(String uuid) {

        int index = getIndex(uuid);
        if (index != -1) {
            return storage[index];
        } else {
            System.out.println("Ошибка поиска резюме для вызова");
            return null;
        }
    }

    public void delete(String uuid) {
        int index = getIndex(uuid);
        if (index != -1) {
            counter = counter - 1;
            if(counter ==0) {
                storage[index]= null;
            }else{
                storage[index] = storage[counter];
            }
        }
        else {
            System.out.println("Ошибка поиска резюме для удаления");
        }
    }

    public Resume[] getAll() {
        return Arrays.copyOf(storage, counter);
    }

    public int size() {
        return counter;
    }

    private int getIndex(String uuid) {
        for (int i = 0; i < counter; i++) {
            if ((storage[i].uuid).equals(uuid)) {
                return i;
                // метод getIndex сравнивает переданное uuid каждого элемента массива storage и возвращает целочисленный индекс найденного элемента
            }
        }
        return -1;
    }
}


