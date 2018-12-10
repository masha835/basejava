package storage;

import model.Resume;

import java.lang.reflect.Array;
import java.util.Arrays;


public abstract class AbstractArrayStorage implements Storage {
    protected static final int STORAGE_LIMIT = 10000;

    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size = 0;

    public int size() {
        return size;
    }

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public void update(Resume r) {
        int index = getIndex(r.getUuid());
        if (index == -1) {
            System.out.println("Ошибка выбора резюме для обновления");
        } else {
            storage[index] = r;
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

    public Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, size);
    }

    public void save(Resume r){
        if(getIndex(r.getUuid()) != -1) {
            System.out.println("Резюме" + r.getUuid() + "уже существует");
        } else if (size >= STORAGE_LIMIT) {
            System.out.println("Массив полон");
        } else {
            storage[size] = r;
            //   r++;
        }

    }

    public void delete(String uuid) {
        int index = getIndex(uuid);
        if(index == -1) {
            System.out.println("Резюме" + uuid + "не существует");
        } else {
            storage[index] = storage[size - 1];
            storage[size - 1] = null;
            size--;
        }


    }

    //protected abstract void doSave(Resume r);

   // protected abstract void doDelete(String uuid);

    protected abstract int  getIndex(String uuid);

}
