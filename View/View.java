package View;

import Controller.*;
import Domain.ADT.*;
import Domain.Expression.ArithExp;
import Domain.Expression.ConstExp;
import Domain.Expression.VarExp;
import Domain.PrgState;
import Domain.STMT.*;
import Exception.*;
import java.util.Scanner;

public class View {

    Controller ctrl;

    public View(Controller ctrl){
        this.ctrl = ctrl;
    }

    void printMenu(){
        System.out.println("Choose an option: ");
        System.out.println("\t1. Input a program. ");
        System.out.println("\t2. One-step evaluation");
        System.out.println("\t3. Complete evaluation");
    }

    void printMenuExamples(){
        System.out.println("Choose an example to load: ");
        System.out.println("\t1. v=5;Print(v)");
        System.out.println("\t2. a=2+3*5 ; b=a+1; Print(b)");
        System.out.println("\t3. a=2-2;(If a Then v=2 Else v=3);Print(v)");
    }

    public void run(){
        int command = 0;
        int menuCommand = 0;

        IStack<IStmt> exeStack = new MyStack<IStmt>();
        //exeStack.push(originalProgram);
        IDictionary<String, Integer> symTable = new MyDictionary<String, Integer>();
        IList<Integer> out = new MyList<Integer>();
        PrgState newProgramState = null;
        IStmt ex = null;

        Scanner in = new Scanner(System.in);

        while(true){
            printMenu();
            System.out.print("Option: ");

            try {

                menuCommand = Integer.parseInt(in.nextLine());

                if (menuCommand == 1) {
                    printMenuExamples();

                    System.out.print("Option: ");
                    command = Integer.parseInt(in.nextLine());

                    if (command == 1) {
                        ex = new CompStmt(new AssignStmt("v", new ConstExp(5)), new PrintStmt(new VarExp("v")));
                    }
                    if (command == 2) {
                        ex = new CompStmt(new AssignStmt("a", new ArithExp('+', new ConstExp(2), new
                                ArithExp('*', new ConstExp(3), new ConstExp(5)))),
                                new CompStmt(new AssignStmt("b", new ArithExp('+', new VarExp("a"), new
                                        ConstExp(1))), new PrintStmt(new VarExp("b"))));
                    }
                    if (command == 3) {
                        ex = new CompStmt(new AssignStmt("a", new ArithExp('-', new ConstExp(2), new
                                ConstExp(2))), new CompStmt(new IfStmt(new VarExp("a"), new
                                AssignStmt("v", new ConstExp(2)), new AssignStmt("v", new ConstExp(3))), new PrintStmt(new VarExp("v"))));
                    }

                    if (command == 4) {
                        ex = new IfStmt(new ConstExp(10), new CompStmt(new AssignStmt("v", new ConstExp(5)), new PrintStmt(new ArithExp('/', new VarExp("v"), new ConstExp(3)))), new PrintStmt(new ConstExp(100)));
                    }

                    if (command == 0) {
                        break;
                    }

                    newProgramState = new PrgState(exeStack, symTable, out, ex);
                    ctrl.addProgramState(newProgramState);
                }

                if (menuCommand == 2) {
                    try {
                        if (!exeStack.isEmpty()) {
                            System.out.println("\n");
                            ctrl.oneStepEvaluation(newProgramState);
                            System.out.println("\n");
                        }
                        else
                            throw new EmptyStack();
                    } catch (EmptyStack e) {
                        System.out.println(e.getMessage());
                    } catch (VariableNotDefined e) {
                        System.out.println(e.getMessage());
                    } catch (DivisionByZero e) {
                        System.out.println(e.getMessage());
                    } catch (InvalidOperatorException e) {
                        System.out.println(e.getMessage());
                    }
                }

                if (menuCommand == 3) {
                    try {
                        if (!exeStack.isEmpty())
                            ctrl.allStepEvaluation();
                        else
                            throw new EmptyStack();
                    } catch (EmptyStack e) {
                        System.out.println(e.getMessage());
                    }
                }

            } catch (Exception e) {
                System.out.println(e);
            }

        }
    }

}
