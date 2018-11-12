package Domain.STMT;


import Domain.ADT.IDictionary;
import Domain.ADT.IList;
import Domain.Expression.*;
import Domain.PrgState;
import Exception.*;

public class PrintStmt implements IStmt {

    Exp exp;

    public PrintStmt(){}

    public PrintStmt(Exp e){
        exp = e;
    }

    public Exp getExp(){
        return exp;
    }

    @Override
    public PrgState execute(PrgState state) throws DivisionByZero, InvalidOperatorException, VariableNotDefined {
        IList<Integer> queue = state.getOut();
        IDictionary<String,Integer> symTable = state.getSymTable();
        queue.add(exp.evaluate(symTable));
        return state;
    }

    @Override
    public String toString(){
        return "print( " +  exp.toString() + ")";
    }
}
