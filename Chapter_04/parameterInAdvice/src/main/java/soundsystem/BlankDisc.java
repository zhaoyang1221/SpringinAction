package soundsystem;

import java.util.List;

/**
 * @author zhaoyang on 2018/8/5/0005.
 */
public class BlankDisc implements CompactDisc {
    private String title;
    private String artist;
    private List<String> tracks;

    void setTitle(String title) {
        this.title = title;
    }

    void setArtist(String artist) {
        this.artist = artist;
    }

    void setTracks(List<String> tracks) {
        this.tracks = tracks;
    }

//    public BlankDisc(String title, String artist, List<String> tracks) {
//        this.title = title;
//        this.artist = artist;
//        this.tracks = tracks;
//    }

    public void play() {
        System.out.println("Playing " + title + " by " + artist);
        for (String track: tracks) {
            System.out.println("-Track: " + track);
        }
    }

    @Override
    public void playTrack(int trackNumber) {
        System.out.println("-Track: " + tracks.get(trackNumber));
    }
}
