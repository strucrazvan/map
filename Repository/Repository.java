package Repository;

import Domain.ADT.MyList;
import Domain.PrgState;

public class Repository implements IRepository{

    MyList<PrgState> programStates;

    public Repository(){
        programStates = new MyList<PrgState>();
    }

    public MyList<PrgState> getProgramStates() {
        return programStates;
    }

    @Override
    public PrgState getCurrentProgram(){
        return programStates.pop();
    }

    @Override
    public void addProgram(PrgState newPrg){
        programStates.add(newPrg);
    }
}
