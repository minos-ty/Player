package com.minos;

public class TestDemo {

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

        //通过ID查询歌曲
        System.out.println("-----通过ID查询----- ");
        Song song = mainPlayList.searchSongById("S002");
        if (song != null){
            System.out.println(song);
        }else {
            System.out.println("该歌曲不存在！");
        }

        //通过名称查询歌曲
        song = null;
        System.out.println("-----通过名称查询----- ");
        song = mainPlayList.searchSongByName("四只猫");
        if (song != null){
            System.out.println(song);
        }else {
            System.out.println("该歌曲不存在！");
        }

        //修改歌曲信息
        Song song5 = new Song("S005", "新歌", "新歌手");
        mainPlayList.updateSong("S003",song5);
        mainPlayList.displayAllSongs();

        //删除歌曲信息
        mainPlayList.deleteSong("S005");
        mainPlayList.displayAllSongs();

    }

    //测试PlayListCollection播放器类
    public static void testPlayListCollection(){
        Song song1 = new Song("S001", "两只老虎", "小太阳");
        Song song2 = new Song("S002", "三只老鼠", "中太阳");
        Song song3 = new Song("S003", "四只猫", "大太阳");

        //创建主播放列表
        PlayList mainPlayList = new PlayList("主播放列表");
        mainPlayList.addToPlayList(song1);
        mainPlayList.addToPlayList(song2);
        mainPlayList.addToPlayList(song3);

        //创建普通播放列表,从主播放列表中添加歌曲进来
        PlayList favouritePlayList = new PlayList("最喜欢的歌曲");
        favouritePlayList.addToPlayList(mainPlayList.getMusicList().get(0));
        favouritePlayList.addToPlayList(mainPlayList.getMusicList().get(1));
        favouritePlayList.displayAllSongs();

        //将两个播放列表添加到播放集合中（播放器）
        PlayListCollection plc = new PlayListCollection();
        plc.addPlayList(mainPlayList);
        plc.addPlayList(favouritePlayList);
        plc.displayListName();

        //根据播放列表名称查询播放列表信息，并显示所有歌曲信息
        PlayList playList = plc.searchPlayListByName("最喜欢的歌曲");
        playList.displayAllSongs();

        //删除播放列表信息
        System.out.println("删除前：");
        plc.displayListName();
        System.out.println("删除后：");
        plc.deletePlayList(favouritePlayList);
        plc.displayListName();


    }



    public static void main(String[] args) {
//        Test.testSong();
//        Test.testPlayList();
        TestDemo.testPlayListCollection();
    }
}











