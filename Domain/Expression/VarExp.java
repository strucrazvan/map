package Domain.Expression;

import Domain.ADT.IDictionary;
import Exception.*;

public class VarExp extends Exp {

    String id;

    public VarExp(){}

    public VarExp(String i){
        id = i;
    }

    public String getId(){
        return id;
    }

    @Override
    public int evaluate(IDictionary<String, Integer> table) throws DivisionByZero, InvalidOperatorException, VariableNotDefined{
        return table.getValueForKey(id);
    }

    @Override
    public String toString() {
        return id;
    }
}
