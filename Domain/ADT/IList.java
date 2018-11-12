package Domain.ADT;

public interface IList<T>{

    /**
     * Adds an element to the list
     * @param element - the element to be added
     */
    void add(T element);
    /**
     * Pops the element from the head of the list.
     * @return an element of type T which is the first one in the list
     */
    T pop();


    /**
     * Checks if the list is empty
     * @return true - if the list is empty
     *         false - otherwise
     */
    boolean isEmpty();


    /**
     * String method to get all the elements from the list.
     * @return a string with all the elements
     */
    String toString();


}
