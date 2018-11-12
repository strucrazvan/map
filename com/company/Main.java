package com.company;

import Controller.Controller;
import Repository.Repository;
import View.View;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Repository repo = new Repository();
        Controller ctrl = new Controller(repo);
        View ui = new View(ctrl);
        ui.run();
    }
}
