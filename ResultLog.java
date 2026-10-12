import java.util.ArrayList;
import java.util.List;

/** Global log of results shown in "Display All Results". */
public class ResultLog {
    private static final List<String> LOG = new ArrayList<>();

    public static void add(String entry) { LOG.add(entry); }

    public static void displayAll() {
        System.out.println("=============================================");
        System.out.println("ALL RESULTS");
        System.out.println("=============================================");
        if (LOG.isEmpty()) {
            System.out.println("No results recorded yet. Run some operations first.");
        } else {
            for (int i = 0; i < LOG.size(); i++) {
                System.out.println((i + 1) + ". " + LOG.get(i));
            }
        }
        System.out.println("=============================================");
    }
}
