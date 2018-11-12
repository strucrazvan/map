package Domain.Expression;

import Domain.ADT.IDictionary;
import Exception.*;

public abstract class Exp {

    /**
     * Evaluates an expression with a given symbol table
     * @param table - the table to be evaluated
     * @return the result of the evaluation
     * @throws DivisionByZero - if we try to divide by 0
     * @throws InvalidOperatorException - if we enter an operator different form + - * /
     * @throws VariableNotDefined - if we try to access a key which is not valid
     */
    public abstract int evaluate(IDictionary<String, Integer> table) throws DivisionByZero, InvalidOperatorException, VariableNotDefined;

    /**
     * Gets the string with all expressions
     * @return - a String
     */
    public abstract String toString();
}
