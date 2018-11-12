package Domain.Expression;

import Domain.ADT.IDictionary;
import Exception.*;


public class ArithExp extends Exp {

    Exp exp1,exp2;
    char option; // it may be: + or - or * or /

    public ArithExp(char option, Exp e1, Exp e2){
        this.option = option;
        exp1 = e1;
        exp2 = e2;
    }

    @Override
    public int evaluate(IDictionary<String, Integer> table) throws DivisionByZero, InvalidOperatorException, VariableNotDefined{
        if (option == '+') 
            return exp1.evaluate(table) + exp2.evaluate(table);
        if (option == '-') 
            return exp1.evaluate(table) - exp2.evaluate(table);
        if (option == '*') 
            return exp1.evaluate(table) * exp2.evaluate(table);
        if (option == '/' && exp2.evaluate(table)!=0)
            return exp1.evaluate(table) / exp2.evaluate(table);
        else
            if(exp2.evaluate(table) == 0)
                throw new DivisionByZero();
        throw new InvalidOperatorException();
    }

    @Override
    public String toString(){
        String str = "";
        str += exp1.toString();
        str += option;
        str += exp2.toString();
        return str;
    }

    public Exp getExp1() {
        return exp1;
    }

    public Exp getExp2() {
        return exp2;
    }

    public char getOption() {
        return option;
    }
}
