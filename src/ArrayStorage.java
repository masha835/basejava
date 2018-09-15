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

public void save(Resume r) { 
storage[counter] = r; 
counter++; 
} 

public Resume get(String uuid) { 
for (int i = 0; i < counter; i++) { 
if (storage[i].uuid.equals(uuid)) { 
return storage[i]; 
} 
} 
return null; 
} 

public void delete(String uuid) { 
for (int i = 0; i < counter; i++) { 
if (storage[i].uuid.equals(uuid)) { 
counter--; 
storage[counter]=null; 
break; 
} 
} 

} 

public Resume[] getAll() { 
return Arrays.copyOf(storage, counter); 
} 

public int size() { 
return counter; 
} 
}
