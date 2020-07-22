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

    public String getPlayListName() {
        return playListName;
    }

    public void setPlayListName(String playListName) {
        this.playListName = playListName;
    }

    public List<Song> getMusicList() {
        return musicList;
    }

    public void setMusicList(List<Song> musicList) {
        this.musicList = musicList;
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

    /**
     * 通过歌曲ID查询
     * @param id 歌曲ID
     * @return 歌曲对象,返回NULL代表列表中没有该歌曲
     */
    public Song searchSongById(String id){
        Song song = null;
        for (Song song1: musicList){
            if (song1.getId().equals(id)){
                song = song1;
            }
        }
        return song;
    }

    /**
     * 根据歌曲名称查询
     * @param name 歌名称曲
     * @return
     */
    public Song searchSongByName(String name){
        Song song = null;
        for (Song song1: musicList){
            if (song1.getName().equals(name)){
                song = song1;
            }
        }
        return song;
    }

    /**
     * 根据ID修改歌曲信息
     * @param id 歌曲ID
     * @param song 歌曲名称
     */
    public void updateSong(String id, Song song){
        Song song1 = searchSongById(id);
        if (song1 == null){
            System.out.println("没有ID："+id+"对应的歌曲信息。");
        }else {
            //先移除原来的信息再添加
            musicList.remove(song1);
            musicList.add(song);
            System.out.println("修改成功！");
        }
    }

    /**
     * 删除指定歌曲信息
     * @param id
     */
    public void deleteSong(String id){
        Song song = searchSongById(id);
        if (song != null){
            musicList.remove(song);
        }else {
            System.out.println("没有ID："+id+"对应的歌曲信息。");
        };
    }

}
