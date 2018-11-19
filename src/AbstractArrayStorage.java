package ru.javawebinar.basejava.storage; 

import ru.javawebinar.basejava.model.Resume; 


public abstract class AbstractArrayStorage implements Storage { 
protected static final int STORAGE_LIMIT = 10000; 

protected Resume[] storage = new Resume[STORAGE_LIMIT]; 
protected int size = 0; 

public int size() { 
return size; 
} 
 public void clear() {
   Array.fill(storage, 0, size, null);
   size = 0;
 }
 public void update(Reasume r) {
   int index = getIndex(r.getUUid());
   if(index == -1) {
     System.out.println("Ошибка выбора резюме для обновления");
   } else {
     storage[index] = r;
   }
 }
 
 public Resume[] getAll() {
  return Array.copyOfRange(storage, 0, size);
 }
  
 public void delete(String uuid) {
  int index = getIndex(uuid);
  if(index == -1){
   System.out.println("Резюме по " + uuid + "не существует");
  } else {
    storage[index] = storage[size -1];
    storage[size -1] = null;
    size--;
  }
}
