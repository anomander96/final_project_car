package com.example.final_project_car.controller.command;

import com.example.final_project_car.controller.command.impl.LoginCommand;
import com.example.final_project_car.controller.command.impl.RegistrationCommand;

import java.util.Map;
import java.util.TreeMap;

public class CommandContainer {
    private static Map<String, Command> commandsContainer = new TreeMap<>();

    static {
        commandsContainer.put("login", new LoginCommand());
        commandsContainer.put("registration", new RegistrationCommand());
//        commandsContainer.put("logout", new LogoutCommand());
//        commandsContainer.put("noCommand", new NoCommand());
    }

    public static Command get(String commandName) {
        if (commandName == null || !commandsContainer.containsKey(commandName)) {
            // add a Logger Here("no such command")
            return commandsContainer.get("noCommand");
        }
        return commandsContainer.get(commandName);
    }
}
