package Repository;

import Domain.PrgState;

public interface IRepository {

    /**
     * Gets the current program state
     * @return - the current program state
     */
    PrgState getCurrentProgram();

    /**
     * Adds a new program state in the stack
     * @param newPrgState - the program state to be added
     */
    void addProgram(PrgState newPrgState);
}
