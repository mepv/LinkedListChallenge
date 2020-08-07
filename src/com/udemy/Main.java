package com.udemy;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

/**
 * Created by Mario Palacios Vasquez on 07/22/2020
 * */

public class Main {
	private static Scanner scanner = new Scanner(System.in);
	private static LinkedList<Song> playList = new LinkedList<>();

    public static void main(String[] args) {
	    Albums albums = new Albums();

	    albums.addAlbum("The Rocking Boat");
	    Song mySong1 = new Song("The Sinker", "3:45");
	    Song mySong2 = new Song("ABC", "3:45");
	    Song mySong3 = new Song("20 life", "3:45");
	    Song mySong4 = new Song("Boat", "3:45");

	    albums.addSongToAlbum("The Rocking Boat", mySong1);
	    albums.addSongToAlbum("The Rocking Boat", mySong2);
	    albums.addSongToAlbum("The Rocking Boat", mySong3);
	    albums.addSongToAlbum("The Rocking Boat", mySong4);

	    // 		Another Album.

		albums.addAlbum("Abbey Road");
	    Song mySong5 = new Song("Oh! Darling", "3:27");
	    Song mySong6 = new Song("Come Together", "4:19");
	    Song mySong7 = new Song("Here Comes The Sun", "3:05");
	    Song mySong8 = new Song("Because", "2:45");

	    albums.addSongToAlbum("Abbey Road", mySong5);
	    albums.addSongToAlbum("Abbey Road", mySong6);
	    albums.addSongToAlbum("Abbey Road", mySong7);
	    albums.addSongToAlbum("Abbey Road", mySong8);


		albums.addSongToPlayList("The Rocking Boat", "The Sinker", playList);
		albums.addSongToPlayList("The Rocking Boat", "ABC", playList);
		albums.addSongToPlayList("The Rocking Boat", "20 life", playList);
		albums.addSongToPlayList("The Rocking Boat", "Boat", playList);

	    albums.addSongToPlayList("Abbey Road", "Oh! Darling", playList);
	    albums.addSongToPlayList("Abbey Road", "Come Together", playList);
	    albums.addSongToPlayList("Abbey Road", "Here Comes The Sun", playList);
	    albums.addSongToPlayList("Abbey Road", "Because", playList);

	    albums.printAlbum();

		// you are missing put LinkedList as parameter on Albums class.  // added (23/07/2020)
	    playMusic(playList);

    }

	private static void playMusic(LinkedList<Song> playList) {
		boolean quit = false;
		boolean forward = true;
		ListIterator<Song> listIterator = playList.listIterator();

		if (playList.isEmpty()) {
			System.out.println("No songs on the playlist");
		} else {
			System.out.println("Now playing song " + listIterator.next().getSongTittle());
			printMenu();
		}
		while (!quit) {
			int action = scanner.nextInt();
			scanner.nextLine();
			switch (action) {
				case 0:
					System.out.println("Exiting play list.");
					quit = true;
					break;
				case 1:
					if (!forward) {
						if (listIterator.hasNext()) {
							listIterator.next();
						}
						forward = true;
					}
					if (listIterator.hasNext()) {
						System.out.println("Now playing " + listIterator.next());
					} else {
						System.out.println("Playlist is over.");
						forward= false;
					}
					break;
				case 2:
					if (forward) {
						if (listIterator.hasPrevious()) {
							listIterator.previous();
						}
						forward = false;
					}
					if (listIterator.hasPrevious()) {
						System.out.println("Now playing " + listIterator.previous());
					} else {
						System.out.println("Playlist is starting again");
						forward = true;
					}
					break;
				case 3:
					if (forward) {
						if (listIterator.hasPrevious()) {
							System.out.println("Playing song " + listIterator.previous() + " one more time.");
							forward = false;
						} else {
							System.out.println("At the start of the list.");
						}
					} else {
						if (listIterator.hasNext()) {
							System.out.println("Playing song " + listIterator.next() + " one more time.");
							forward = true;
						} else {
							System.out.println("Playlists if over.");
						}
					}
					break;
				case 4:
					printList(playList);
					break;
				case 5:
					printMenu();
					break;
			}
		}
	}

	private static void printMenu() {
		System.out.println("Available actions:\npress ");
		System.out.println("0 - to quit\n" +
				"1 - go to next song\n" +
				"2 - go to previous song\n" +
				"3 - to replay this song\n" +
				"4 - to print the list\n" +
				"5 - print menu options");

	}

	private static void printList(LinkedList<Song> playlist) {
		System.out.println("===================");
		for (Song song :
			 playlist) {
			System.out.println(song.getSongTittle());
		}
		System.out.println("===================");
	}
}
