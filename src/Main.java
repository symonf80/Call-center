public class Main {
    public static final int CALL_FREQUENCY = 60;
    public static final int SPECIALIST = 9;

    public static void main(String[] args) {
        CallCenter center = new CallCenter();

        for (int i = 1; i <= CALL_FREQUENCY; i++) {
            new Thread( center::call, "№" + i).start();
        }
        for (int i = 1; i <= SPECIALIST; i++) {
            new Thread( center::takeCall, "№" + i).start();
        }
    }
}
