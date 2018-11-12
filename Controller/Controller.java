package Controller;

import Domain.ADT.IStack;
import Domain.PrgState;
import Domain.STMT.IStmt;
import Repository.IRepository;
import Repository.Repository;
import Exception.*;

public class Controller {

    IRepository repo;

    public Controller(){
        repo = new Repository();
    }

    public Controller(Repository r){
        repo = r;
    }

    public void addProgramState(PrgState newProgramState){
        repo.addProgram(newProgramState);
    }

    public PrgState oneStepEvaluation(PrgState programState) throws VariableNotDefined, DivisionByZero, InvalidOperatorException, EmptyStack{

        IStack<IStmt> stack = programState.getExeStack();
        if (stack.isEmpty())
            throw new EmptyStack();
        IStmt currentStatement = stack.pop();
        PrgState prg = currentStatement.execute(programState);
        System.out.println(prg.toString());

        return prg;

    }

    public void allStepEvaluation(){

        PrgState program = repo.getCurrentProgram();
        try {
            while (true) {
                oneStepEvaluation(program);
            }
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
            System.out.println();

            }
        }


}
