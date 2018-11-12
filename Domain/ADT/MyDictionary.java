package Domain.ADT;

import java.util.Map;
import java.util.HashMap;

import Exception.*;

public class MyDictionary<K,V> implements IDictionary<K,V> {

    private HashMap<K,V> dictionary;

    public MyDictionary(){
        dictionary = new HashMap<K,V>();
    }

    @Override
    public V getValueForKey(K key) throws VariableNotDefined{
        if(dictionary.get(key) != null)
            return dictionary.get(key);
        throw new VariableNotDefined();
    }

    @Override
    public boolean checkExistence(K key){
        if (dictionary.get(key) != null)
            return true;
        return false;
    }

    @Override
    public void add(K key, V value){
        dictionary.put(key,value);
    }

    @Override
    public void update(K key, V value){
        dictionary.put(key, value);
    }

    @Override
    public String toString(){
        String str = "";

        for(HashMap.Entry<K,V> element: dictionary.entrySet())
            str += "Key: " + element.getKey().toString() + " Value: " + element.getValue().toString() + "\n";

        return str;
    }


}
