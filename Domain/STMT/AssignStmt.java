package Domain.STMT;

import Domain.ADT.IDictionary;
import Domain.ADT.IStack;
import Domain.Expression.Exp;
import Domain.PrgState;
import Exception.*;

public class AssignStmt implements IStmt{

    String id;
    Exp expression;

    public AssignStmt(){}

    public AssignStmt(String id, Exp expression){
        this.id = id;
        this.expression = expression;
    }

    public String getId() {
        return id;
    }

    public Exp getExpression() {
        return expression;
    }

    @Override
    public PrgState execute(PrgState state) throws DivisionByZero, InvalidOperatorException, VariableNotDefined {
        IStack<IStmt> stack = state.getExeStack();
        IDictionary<String, Integer> symTable = state.getSymTable();
        int value = expression.evaluate(symTable);
        if (symTable.checkExistence(id))
            symTable.update(id, value);
        else
            symTable.add(id,value);
        return state;
    }

    @Override
    public String toString(){
        return id + " = " + expression.toString();
    }
}
