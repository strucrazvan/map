package Domain.ADT;

import Exception.*;

public interface IDictionary<K,V> {

    /**
     * Adds a pear (first, second) to the dictionary;
     * @param key - the key of the element
     * @param value - the value of the element
     */
    void add(K key, V value);


    /**
     * Updates the value from a given key with another value
     * @param key - the given key
     * @param value - new value for key
     */
    void update(K key, V value);


    /**
     * Gets the value for a given key
     * @param key - the givem key
     * @return the value corresponding to the given key
     * @throws VariableNotDefined if the key was not found
     */
    V getValueForKey(K key) throws VariableNotDefined;

    /**
     * Checks if a given key it's in the dictionary
     * @param key - the key to be searched for
     * @return true - if the key was found
     *         false - otherwise
     */
    boolean checkExistence(K key);


    /**
     * String method to get all the elements from the dictionary.
     * @return a string with all the elements
     */
    String toString();




}
