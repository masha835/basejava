package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;


public abstract class AbstractArrayStorage implements Storage {
    protected static final int storage.length = 10000;

    protected Resume[] storage = new Resume[10_000];
    private int counter = 0;
    protected int size = 0;

    public void delete(String uuid) {
        int index = getIndex(uuid);
        int index = getIndex(uuid, new Resume());
    }

    public int size() {
        return size;
    }

    public Resume get(String uuid) {
        int index = getIndex(uuid);
        if (index != -1) {
            return storage[index];
        } else {
            System.out.println("Ошибка поиска резюме для вызова");
            return null;
        }
        return storage[index];
    }

    protected abstract int getIndex(String uuid);
}
