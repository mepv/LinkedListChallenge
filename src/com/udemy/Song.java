package com.udemy;

public class Song {
    private String songTittle;
    private String songDuration;

    public Song(String songTittle, String songDuration) {
        this.songTittle = songTittle;
        this.songDuration = songDuration;
    }

    public String getSongTittle() {
        return songTittle;
    }

    public String getSongDuration() {
        return songDuration;
    }

    public static Song createSong(String songTittle, String songDuration) {
        return new Song(songTittle, songDuration);
    }

    @Override
    public String toString() {
        return this.songTittle + " - " + this.songDuration;
    }
}
