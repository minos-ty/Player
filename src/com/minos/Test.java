package com.minos;

import java.util.Collections;

public class Test {

    //对歌曲类Song进行测试
    public static void testSong() {
        Song song1 = new Song("S001", "两只老虎", "小太阳");
        Song song2 = new Song("S002", "三只老鼠", "中太阳");
        Song song3 = new Song("S003", "四只猫", "大太阳");
        Song song4 = new Song("S003", "四只猫", "大太阳");

        System.out.println(song1);
        System.out.println(song2);
        System.out.println(song3);
        //测试Song是否相等
        System.out.println("song1=song3? " + (song1.equals(song3)));
        System.out.println("song3=song4? " + (song3.equals(song4)));

    }

    //对播放列表类PlayList进行测试
    public static void testPlayList(){
        Song song1 = new Song("S001", "两只老虎", "小太阳");
        Song song2 = new Song("S002", "三只老鼠", "中太阳");
        Song song3 = new Song("S003", "四只猫", "大太阳");
        Song song4 = new Song("S003", "四只猫", "大太阳");

        PlayList mainPlayList = new PlayList("主播放列表");

        mainPlayList.addToPlayList(song1);
        mainPlayList.addToPlayList(song2);
        mainPlayList.addToPlayList(song3);
        mainPlayList.addToPlayList(song4);

        mainPlayList.displayAllSongs();
    }

    public static void main(String[] args) {
//        Test.testSong();
        Test.testPlayList();
    }
}











