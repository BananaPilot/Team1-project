import classes.MainInteraction;
import classes.shared.ExceptionHandler;
import in.Input;

public class Main {
    public static void main(String[] args) {
        try {
            new MainInteraction().mainHandler();
        } catch (InterruptedException e) {
            new ExceptionHandler().handle(e);
        }
        Input.getInstance().getScanner().close();
    }
}
