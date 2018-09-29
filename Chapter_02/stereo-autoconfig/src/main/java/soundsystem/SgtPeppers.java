package soundsystem;

import org.springframework.stereotype.Component;

/**
 * @author zhaoyang on 2018/7/15/0015.
 */
@Component
public class SgtPeppers  implements CompactDisc{

    private String title = "Sgt. Pepper's Lonely Hearts club Band";
    private String artist = "The Beatles";

    public void play() {
        System.out.println("Playing " + title + " by " + artist);
//        System.out.print("AAaa");
    }
}
