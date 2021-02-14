package com.example.final_project_car.controller.command;

import com.example.final_project_car.controller.command.impl.LoginCommand;

public enum CommandType {
    LOGIN(new LoginCommand());
//    LOGOUT,
//    REGISTRATION;


    private final Command command;

    CommandType(Command command) {
        this.command = command;
    }

    public Command getCommand() {
        return command;
    }
}
