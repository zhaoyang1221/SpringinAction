package soundsystem;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>Title: soundsystem.TrackCounter</p>
 *
 * @description: 记录磁道次数
 * @author: xiongzy
 * @date: 2018-10-18
 **/
@Aspect
public class TrackCounter {

    private Map<Integer, Integer> trackCounts = new HashMap<>();

    @Pointcut(
            "execution(* soundsystem.CompactDisc.playTrack(int)) " +
                    " && args(trackNumber)"
    )
    public void trackPlayed(int trackNumber) {
    }

    @Before(value = "trackPlayed(trackNumber)", argNames = "trackNumber")
    public void countTrack(int trackNumber) {
        int currentCount = getPlayCount(trackNumber);
        trackCounts.put(trackNumber, currentCount + 1);
    }

    public int getPlayCount(int trackNumber) {
        return trackCounts.getOrDefault(trackNumber, 0);
    }
}