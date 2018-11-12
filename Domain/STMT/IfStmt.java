package Domain.STMT;

import Domain.ADT.IDictionary;
import Domain.ADT.IStack;
import Domain.Expression.Exp;
import Domain.PrgState;
import Exception.*;

public class IfStmt implements IStmt{

    Exp expression;
    IStmt thenS, elseS;

    public IfStmt(){}

    public IfStmt(Exp expression, IStmt thenS, IStmt elseS) {
        this.expression = expression;
        this.thenS = thenS;
        this.elseS = elseS;
    }

    @Override
    public PrgState execute(PrgState state) throws DivisionByZero, InvalidOperatorException, VariableNotDefined {

        IStack<IStmt> stack = state.getExeStack();
        IDictionary<String,Integer> symTable = state.getSymTable();
        if(expression.evaluate(symTable)!=0)
            stack.push(thenS);
        else
            stack.push(elseS);
        return state;
    }

    @Override
    public String toString(){
        return "IF ( " + expression.toString() + " ) THEN ( " + thenS.toString() + ") ELSE ( " + elseS.toString() + " ) ";}
}
