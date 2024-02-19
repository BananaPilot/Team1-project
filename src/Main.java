import in.Input;
import interactions.MainInteraction;


public class Main {
    public static void main(String[] args) {
        MainInteraction app = new MainInteraction();
        app.mainHandler();
        Input.getScanner().close();
    }
}
