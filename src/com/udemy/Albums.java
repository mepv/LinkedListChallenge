package com.udemy;

import java.util.ArrayList;
import java.util.LinkedList;

public class Albums {
    private String albumName;
    private ArrayList<Song> albumSongsList;
    private ArrayList<Albums> albumsList;

    public Albums() {
        this.albumsList = new ArrayList<>();
        this.albumSongsList = new ArrayList<>();
    }

    private Albums(String albumName) {
        this.albumName = albumName;
        new Albums();
    }

    public String getAlbumName() {
        return albumName;
    }

    public boolean addSongToAlbum(String albumName, Song song) {
        song = Song.createSong(song.getSongTittle(), song.getSongDuration());
        Albums album = findAlbum(albumName);
        if (album != null) {
            this.albumSongsList.add(song);
            return true;
        }
        return false;
    }

    public boolean addAlbum(String albumName) {
        Albums album = findAlbum(albumName);
        if (album == null) {
            this.albumsList.add(new Albums(albumName));
            return true;
        }
        return false;
    }

    public void printAlbum() {
        System.out.println("Albums from which songs can be added:");
        for (Albums value:
             this.albumsList) {
            System.out.println(value.getAlbumName());
        }
        System.out.println();
    }

    public boolean addSongToPlayList(String albumName, String songTittle, LinkedList<Song> playList) {
        Albums album = findAlbum(albumName);
        Song song = findSong(songTittle);
        if (album != null && song != null) {     // review the condition, it may be == null instead of != null // the condition is ok.
            playList.add(song);
            return true;
        }
        return false;
    }

    private Albums findAlbum(String albumName) {
        for (int i = 0; i < this.albumsList.size(); i++) {
            Albums checkedAlbum = this.albumsList.get(i);
            if (checkedAlbum.getAlbumName().equals(albumName)) {
                return checkedAlbum;
            }
        }
        return null;
    }

    private Song findSong(String songTittle) {
        for (Song checkedSong : this.albumSongsList) {
            if (checkedSong.getSongTittle().equals(songTittle)) {
                return checkedSong;
            }
        }
        return null;
    }
}
