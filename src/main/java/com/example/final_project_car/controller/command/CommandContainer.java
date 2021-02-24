package com.example.final_project_car.controller.command;

import com.example.final_project_car.controller.command.impl.*;

import java.util.Map;
import java.util.TreeMap;

public class CommandContainer {
    private static final Map<String, Command> commandsContainer = new TreeMap<>();

    static {
        commandsContainer.put("login", new LoginCommand());
        commandsContainer.put("logout", new LogoutCommand());
        commandsContainer.put("registration", new RegistrationCommand());
        commandsContainer.put("user_profile", new UserProfileCommand());
        commandsContainer.put("cars_list", new CarsListCommand());

        commandsContainer.put("car_info", new CarInfoPage());

        commandsContainer.put("go_to_order_page", new GoToOrderPage());

        commandsContainer.put("user_orders", new OrdersUserList());

        commandsContainer.put("go_to_create_admin", new GoToCreateAdminPage());
        commandsContainer.put("create_admin", new CreateAdmin());

        commandsContainer.put("go_to_create_car", new GoToCreateCarPage());
        commandsContainer.put("create_car", new CreateCarCommand());

        commandsContainer.put("create_order", new CreateOrderCommand());
        commandsContainer.put("go_to_user_orders", new GoToUserOrdersPage());

        commandsContainer.put("go_to_home_page", new GoToHomePage());
        commandsContainer.put("go_to_admin_panel", new GoToAdminPanel());
        commandsContainer.put("all_orders", new AllOrdersCommand());

        commandsContainer.put("all_cars", new AllCarsCommand());
        commandsContainer.put("delete_car", new DeleteCar());
        commandsContainer.put("update_car", new UpdateCar());
        commandsContainer.put("go_to_update_car", new GoToUpdateCarPage());

        commandsContainer.put("change_order_status_on_approved", new ChangeOrderStatusOnApproved());
        commandsContainer.put("change_order_status_on_canceled", new ChangeOrderStatusOnCanceled());
        commandsContainer.put("change_order_status_on_paid", new ChangeOrderStatusOnPaid());
        commandsContainer.put("change_order_status_on_closed", new ChangeOrderStatusOnClosed());

        commandsContainer.put("all_accidents", new AllAccidentsCommand());
        commandsContainer.put("go_to_create_accident", new GoToCreateAccident());
        commandsContainer.put("create_accident", new CreateAccident());
        commandsContainer.put("delete_accident", new DeleteAccident());


    }

    public static Command get(String commandName) {
        if (commandName == null || !commandsContainer.containsKey(commandName)) {
            // add a Logger Here("no such command")
            return commandsContainer.get("noCommand");
        }
        return commandsContainer.get(commandName);
    }
}
