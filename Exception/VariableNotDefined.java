package Exception;

public class VariableNotDefined extends Exception {

    public VariableNotDefined(){
        super("The variable was not defined in the symbol table!");
    }
}
