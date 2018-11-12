package Domain.STMT;

import Domain.PrgState;
import Exception.*;

public interface IStmt {

    /**
     * Execution method for a statement
     * @param state - the statement to be executed
     * @return new program state
     * @throws DivisionByZero - if we try to divide by 0
     * @throws InvalidOperatorException - if we enter an operator different form + - * /
     * @throws VariableNotDefined - if we try to access a key which is not valid
     */
    PrgState execute(PrgState state) throws DivisionByZero, InvalidOperatorException, VariableNotDefined;

    /**
     * Gets the String containing the details of the program state
     * @return a String
     */
    String toString();

}
