package ru.jenia.orders;

public class StartUI {
    private final Output out;

    public StartUI(Output out) {
        this.out = out;
    }

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
        out.println("Menu:");
        for (int i = 0; i < actions.length; i++) {
            out.println(i + ". " + actions[i].name());
        }
    }

    public static void main(String[] args) {
        Output output = new ConsoleOutput();
        Input input = new ConsoleInput();
        Orders orders = new Orders();
        UserAction[] actions = {
                new CreateAction(output), new EditAction(output), new ShowAllAction(output),
                new DeleteAction(output), new FindByIdAction(output), new FindByNameAction(output),
                new ExitAction()
        };
        new StartUI(output).init(input, orders, actions);
    }
}
