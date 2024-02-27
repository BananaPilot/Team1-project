import classes.MainInteraction;
import in.Input;

public class Main {
    public static void main(String[] args) {
        try {
            new MainInteraction().mainHandler();
        } catch (Exception e){
            e.printStackTrace();
        }
        Input.getInstance().getScanner().close();
    }
}
