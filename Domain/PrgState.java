package Domain;

import Domain.ADT.IDictionary;
import Domain.ADT.IList;
import Domain.ADT.IStack;
import Domain.STMT.IStmt;

public class PrgState {

    IStack<IStmt> exeStack;
    IDictionary<String,Integer> symTable;
    IList<Integer> out;
    IStmt originalProgram; // optional

    public PrgState(IStack<IStmt> e, IDictionary<String,Integer> s, IList<Integer> o, IStmt op){
        exeStack = e;
        symTable = s;
        out = o;
        originalProgram = op;
        exeStack.push(op);
    }

    @Override
    public String toString() {
        String str = "";
        str += "ExeStack:\n" + exeStack.toString();
        str += "Sym Table:\n" + symTable.toString();
        str += "Print output:\n" + out.toString();
        return str;
    }

    public IStack<IStmt> getExeStack(){
        return exeStack;
    }

    public IDictionary<String, Integer> getSymTable(){
        return symTable;
    }

    public IList<Integer> getOut(){
        return out;
    }

    public IStmt getOriginalProgram() {
        return originalProgram;
    }

    public void setExeStack(IStack<IStmt> exeStack) {
        this.exeStack = exeStack;
    }

    public void setSymTable(IDictionary<String, Integer> symTable) {
        this.symTable = symTable;
    }

    public void setOut(IList<Integer> out) {
        this.out = out;
    }

    public void setOriginalProgram(IStmt originalProgram) {
        this.originalProgram = originalProgram;
    }
}
