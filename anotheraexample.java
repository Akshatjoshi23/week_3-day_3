import java.util.*;
class Playlist{
    private final List<String> songs=new ArrayList<>();
    void addSongs(String title){
        if(title==null || title.isBlank()){
            throw new IllegalArgumentException("Song title must not be blancked");
        }
        songs.add(title);
    }
    int songCount(){
        return songs.size();
    }
    void playAll(){
        for(String s:songs){
            System.out.println("Playing::"+s);
        }
    }
}
public class anotheraexample {

    public static void main(String[] args) {
        Playlist p=new Playlist();
        p.addSongs("Tum Hi Ho");
        p.addSongs("Cheap Thrills");
        p.addSongs("Kesariya");
        System.out.println("Songs: "+p.songCount());
        p.playAll();    
    }
}
