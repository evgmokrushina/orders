package ru.jenia.orders;

public class StartUI {
    public void init(Input input, Orders orders, UserAction[] actions) {
        boolean run = true;
        while (run) {
            showMenu(actions);
            int select = input.askInt("Select: ");
            UserAction action = actions[select];
            run = action.execute(input, orders);
        }
    }

    private void showMenu(UserAction[] actions) {
        System.out.println("Menu:");
        for (int i = 0; i < actions.length; i++) {
            System.out.println(i + ". " + actions[i].name());
        }
    }

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Orders orders = new Orders();
        UserAction[] actions = {
                new CreateAction(), new EditAction(), new ShowAllAction(), new DeleteAction(),
                new FindByIdAction(), new FindByNameAction(), new ExitAction()
        };
        new StartUI().init(input, orders, actions);
    }
}
