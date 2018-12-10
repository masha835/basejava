package storage;

import model.Resume;

import java.util.Arrays;



public class SortedArrayStorage extends AbstractArrayStorage {
    private int counter = 0;
   // @Override
    //public void clear() {

   // }

   // @Override
   // public void update(Resume r) {

   // }

    @Override
    public void save(Resume r) {
        //сортируем по uuid перед сохранением
        if (getIndex(r.getUuid()) != -1) {
            System.out.println("Резюме существует");
        } else if (counter >= storage.length) {
            System.out.println("Места больше нет");
        } else {
            storage[size] = r;
            counter++;
        }
    }

    @Override
    public void delete(String uuid) {

        int index = getIndex(uuid);
        if (index != -1) {
            size--;
            storage[index] = storage[size];
            storage[size] = null;
        }
        else {
            System.out.println("Ошибка поиска резюме для удаления");
        }


    }

  //  @Override
   // public Resume[] getAll() {
   //     return new Resume[0];
  //  }

    @Override
    protected int getIndex(String uuid) {
        Resume searchKey = new Resume();
        searchKey.setUuid(uuid);
        return Arrays.binarySearch(storage, 0, size, searchKey);
    }

  //  @Override
   // protected int doSave(Resume r) {

   // }

   // @Override

   // protected int doDelete (String uuid) {

   // }
}