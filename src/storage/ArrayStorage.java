package storage;

import java.lang.reflect.Array;
import java.util.Arrays;

import model.Resume;


/**
 * Array based storage for Resumes
 */
public class ArrayStorage extends AbstractArrayStorage {
    private Resume[] storage = new Resume[10_000];
    private int counter = 0;

    public void clear() {
        Arrays.fill(storage, 0, counter, null);
        counter = 0;
    }

    public void update(Resume r) {
        int index = getIndex(r.getUuid());
        if (index == -1) {
            System.out.println("Резюме" + r.getUuid() + "не существует");
        } else {
            storage[index] = r;
        }
    }

    public void save(Resume r) {
        if (getIndex(r.getUuid()) != -1) {
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
           // counter--;
            //storage[index] = storage[counter];
           // storage[counter] = null;
            System.arraycopy(storage, index, storage, index, size);
            //Arrays.sort(storage);
           // Arrays.binarySearch(storage, index);
            System.out.println(index);

            }
         else {
            System.out.println("Ошибка поиска резюме для удаления");
        }
    }



    public Resume[] getAll() {
        return Arrays.copyOf(storage,0, counter);
    }

    public int size() {
        return counter;
    }

    protected int getIndex(String uuid) {
        Resume searchKey = new Resume();
        searchKey.setUuid(uuid);
        return Arrays.binarySearch(storage, 0, counter, searchKey);
    }
    protected int doSave(Resume r) {


    }
}


