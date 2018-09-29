package knights;

import java.io.PrintStream;

/**
 * @author zhaoyang on 2018/7/13/0013.
 */
public class Minstrel {
    private PrintStream stream;

    public Minstrel(PrintStream stream) {
        this.stream = stream;
    }

    public void singBeforeQuest() {
        stream.println("Fa la la, the knight is so brave");
    }

    public void singAfterQuest() {
        stream.println("Tee hee hee, the brave knight did embark on a quest");
    }
}
