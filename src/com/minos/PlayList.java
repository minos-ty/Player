package com.minos;

import java.util.ArrayList;
import java.util.List;

public class PlayList {
    private String playListName;
    private List<Song> musicList;//播放列表中的歌曲集合

    public PlayList(String playListName) {
        this.playListName = playListName;
        musicList = new ArrayList<>();
    }

    /**
     * 将歌曲添加到播放列表
     * @param song 需添加的歌曲对象
     */
    public void addToPlayList(Song song){
        //去重
        boolean flag = false;//判断播放列表中是否以存在该歌曲
        for (Song song1: musicList){
            if (song1.equals(song)){
                flag = true;
                break;
            }
        }

        if (flag){
            System.out.println("歌曲已存在！");
        }else {
            musicList.add(song);
        }

    }

    /**
     * 显示播放列表中所有歌曲
     */
    public void displayAllSongs(){
        System.out.println("播放表中所有歌曲为：");
        for (Song song:musicList){
            System.out.println(song);
        }
    }

}
