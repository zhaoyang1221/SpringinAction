package knights;

import java.io.PrintStream;

/**
 * @author zhaoyang on 2018/7/11/0011.
 */
public class SlayDragonQuest implements Quest{
    private PrintStream stream;

    public SlayDragonQuest(PrintStream stream) {
        this.stream = stream;
    }

    public void embark() {
        stream.println("Embarking on quest to slay the dragon");
    }
}
