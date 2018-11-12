package Domain.Expression;

import Domain.ADT.IDictionary;
import Exception.*;

public class ConstExp extends Exp {

    int number;

    public ConstExp(){}

    public ConstExp(int n){
        number = n;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public int evaluate(IDictionary<String, Integer> table) throws DivisionByZero, InvalidOperatorException {
        return number;
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }
}
