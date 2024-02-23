import classes.MainInteraction;
import in.Input;

public class Main {
    public static void main(String[] args) {
        new MainInteraction().mainHandler();
        Input.getInstance().getScanner().close();
    }
}
