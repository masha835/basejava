package ru.javawebinar.basejava.storage; 

import ru.javawebinar.basejava.model.Resume; 


public abstract class AbstractArrayStorage implements Storage { 
protected static final int STORAGE_LIMIT = 10000; 

protected Resume[] storage = new Resume[STORAGE_LIMIT]; 
protected int size = 0; 

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
