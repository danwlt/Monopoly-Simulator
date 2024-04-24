import Model.GameHost;
import View.MonopolyView;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        new MonopolyView();
        GameHost.getInstance().run();
    }
}