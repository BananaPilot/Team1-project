import in.Input;
import interactions.MainInteraction;


public class Main {
    public static void main(String[] args) {
        MainInteraction mainInteraction = new MainInteraction();
        mainInteraction.mainHandler();
        Input.getScanner().close();
    }
}
