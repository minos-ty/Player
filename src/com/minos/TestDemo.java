package com.minos;

import java.util.Scanner;

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
    public static void testPlayList() {
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
        if (song != null) {
            System.out.println(song);
        } else {
            System.out.println("该歌曲不存在！");
        }

        //通过名称查询歌曲
        song = null;
        System.out.println("-----通过名称查询----- ");
        song = mainPlayList.searchSongByName("四只猫");
        if (song != null) {
            System.out.println(song);
        } else {
            System.out.println("该歌曲不存在！");
        }

        //修改歌曲信息
        Song song5 = new Song("S005", "新歌", "新歌手");
        mainPlayList.updateSong("S003", song5);
        mainPlayList.displayAllSongs();

        //删除歌曲信息
        mainPlayList.deleteSong("S005");
        mainPlayList.displayAllSongs();

    }

    //测试PlayListCollection播放器类
    public static void testPlayListCollection() {
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

    //主菜单
    public static void mainMenu() {
        System.out.println("*********************************");
        System.out.println("*        **主菜单**      *");
        System.out.println("*        1--播放列表管理      ");
        System.out.println("*        2--播放器管理      ");
        System.out.println("*        0--退出      *");
        System.out.println("*********************************");
    }

    //播放列表管理菜单
    public static void playListMenu() {
        System.out.println("************************************");
        System.out.println("*        **播放列表管理**      ");
        System.out.println("*        1--将歌曲添加到主播放列表      ");
        System.out.println("*        2--将歌曲添加到普通播放列表      ");
        System.out.println("*        3--通过歌曲ID查询歌曲      ");
        System.out.println("*        4--通过歌曲名称查询歌曲      ");
        System.out.println("*        5--修改播发列表中歌曲      ");
        System.out.println("*        6--删除播放列表中歌曲     ");
        System.out.println("*        7--显示播放列表中所有歌曲      ");
        System.out.println("*        9--返回上一级菜单      ");
        System.out.println("************************************");
    }

    //播放器管理菜单
    public static void playerMenu() {
        System.out.println("************************************");
        System.out.println("*        **播放器管理**      ");
        System.out.println("*        1--向播放器中添加列表      ");
        System.out.println("*        2--从播放器删除播放列表      ");
        System.out.println("*        3--通过名字查询播放列表信息      ");
        System.out.println("*        4--显示所有播放列表名称     ");
        System.out.println("*        9--返回上一级菜单      ");
        System.out.println("************************************");


    }

    //主流程
    public static void test() {
        Scanner sc = new Scanner(System.in);
        int input = 0, input1 = 0, input2 = 0; //键盘输入，控制主菜单选项
        //创建播放列表容器（播放器）
        PlayListCollection plc = new PlayListCollection();
        //创建主播放列表
        PlayList mainPlayList = new PlayList("主播放列表");
        //将主播放列表添加到播放器中
        plc.addPlayList(mainPlayList);
        PlayList favouritePlayList = null;

        while (true) {
            TestDemo.mainMenu();
            System.out.println("请输入对应数字进行操作：");
            input = sc.nextInt();
            if (input == 0) {
                break;
            }
            switch (input) {
                case 1:
                    //播放列表管理
                    while (true) {
                        TestDemo.playListMenu();
                        System.out.println("请输出对应数字对播放列表进行管理：");
                        input1 = sc.nextInt();
                        if (input1 == 9) {
                            break;
                        } else {
                            switch (input1) {
                                case 1:
                                    System.out.println("将歌曲添加到主播放列表");
                                    System.out.println("请输入要添加歌曲的数量：");
                                    int count = sc.nextInt();
                                    for (int i = 0; i < count; i++) {
                                        System.out.println("请输入第" + i + "首歌曲：");
                                        System.out.println("请输入歌曲的ID:");
                                        String strId = sc.next();
                                        System.out.println("请输入歌曲的名称:");
                                        String strName = sc.next();
                                        System.out.println("请输入歌手的名称:");
                                        String strSinger = sc.next();
                                        // 创建歌曲类对象
                                        Song song = new Song(strId, strName, strSinger);
                                        mainPlayList.addToPlayList(song);
                                        // mainPlayList.displayAllSongs();
                                    }
                                    break;
                                case 2:
                                    System.out.println("将歌曲添加到普通播放列表");
                                    System.out.println("请输入要添加的播放列表名称：");
                                    String sName = sc.next();
                                    //判断播放列表是否存在
                                   favouritePlayList =  plc.searchPlayListByName(sName);
                                   if(favouritePlayList == null){
                                       System.out.println("该播放列表不存在，请先将播放列表添加到播放器中");
                                   }else {
                                       System.out.println("请输入要添加歌曲的数量：");
                                       int count1 = sc.nextInt();
                                       for (int i = 0; i < count1; i++) {
                                           System.out.println("请输入第"+i+"首歌曲：");
                                           System.out.println("请输入歌曲I：");
                                           String strId = sc.next();
                                           //首先判断该Id歌曲是否在主播放器列表存在
                                           Song song = mainPlayList.searchSongById(strId);
                                           if (song == null){
                                               //如果歌曲不存在则创建新的添加并添加到主播放列表
                                               System.out.println("该歌曲在主播放列表不存在，继续输入歌曲其他信息：");
                                               System.out.println("请输入歌曲名称：");
                                               String strName = sc.next();
                                               System.out.println("请输入歌手：");
                                               String strSinger = sc.next();

                                               song = new Song(strId,sName,strSinger);
                                               //分别将歌曲添加到主播放列表和普通播放列表
                                                favouritePlayList.addToPlayList(song);
                                                mainPlayList.addToPlayList(song);
                                           }else {
                                               //如果歌曲存在于主播放列表，则直接添加到当前普通列表
                                               favouritePlayList.addToPlayList(song);
                                           }
                                           //显示播放列表中的歌曲信息
                                           System.out.println("主播放列表：");
                                           mainPlayList.displayAllSongs();
                                           //普通播放列表
                                           System.out.println("普通播放列表：");
                                           favouritePlayList.displayAllSongs();

                                       }
                                   }
                                    break;
                                case 3:
                                    System.out.println("通过歌曲ID查询播放列表中歌曲");
                                    System.out.println("请输入要查询的播放列表名称：");
                                    String strPlayListName1 = sc.next();
                                    //查询播放列表是否存在
                                    PlayList pl = plc.searchPlayListByName(strPlayListName1);
                                    if (pl == null){
                                        System.out.println("该播放列表不存在！");break;
                                    }else {
                                        System.out.println("请输入要查询的歌曲ID：");
                                        String strId1 = sc.next();
                                        Song s = pl.searchSongById(strId1);
                                        if (s == null) {
                                            System.out.println("该歌曲在播放列表" + strPlayListName1 + "中不存在！");
                                        }else {
                                            System.out.println("该歌曲的信息为：");
                                            System.out.println(s);
                                        }
                                    }

                                    break;
                                case 4:
                                    System.out.println("将歌曲名称到主播放列表");
                                    break;
                                case 5:
                                    System.out.println("修改播放列表中的歌曲");
                                    break;
                                case 6:
                                    System.out.println("删除播放列表中的歌曲");
                                    break;
                                case 7:
                                    System.out.println("显示播放列表中所有歌曲");
                                    break;
                                default:
                                    System.out.println("该数字无对应操作");
                                    break;

                            }
                        }
                    }
                    break;
                case 2:
                    //播放器管理
                    while (true) {
                        TestDemo.playerMenu();
                        System.out.println("请输出对应数字对播放器进行管理：");
                        input2 = sc.nextInt();
                        if (input2 == 9) {
                            break;
                        } else {
                            switch (input2) {
                                case 1:
                                    System.out.println("像播放器添加播放列表");
                                    System.out.println("输入要添加的播放列表名称：");
                                    String playerName = sc.next();
                                    //创建一个新的播放列表对象
                                    favouritePlayList = new PlayList(playerName);
                                    //将播发列表添加到播放器中
                                    plc.addPlayList(favouritePlayList);
                                    break;
                                case 2:
                                    System.out.println("从播放器删除播放列表");
                                    System.out.println("请输入要删除的播放列表名称：");
                                    String strPlayListName = sc.next();
                                    if (strPlayListName.equals(mainPlayList.getPlayListName())){
                                        System.out.println("主播放列表不能删除！");
                                        break;
                                    }
                                    //查询播放列表是否存在
                                    PlayList playList1 = plc.searchPlayListByName(strPlayListName);
                                    if (playList1 == null){
                                        System.out.println("该播放列表不存在！");
                                    }else {
                                        //存在则删除
                                        plc.deletePlayList(playList1);
                                    }
                                    break;
                                case 3:
                                    System.out.println("通过名字查询播放列表信息");
                                    System.out.println("请输入要查询的播放列表名称：");
                                    String strPlayList1 = sc.next();
                                    PlayList playList2 = plc.searchPlayListByName(strPlayList1);
                                    if (playList2 == null){
                                        System.out.println("该播放列表不存在！");
                                    }else {
                                        // 显示该播放列表名称及其中的所有歌曲
                                        System.out.println("该播放列表名称为："+strPlayList1);
                                        playList2.displayAllSongs();
                                    }
                                    break;
                                case 4:
                                    System.out.println("显示所有播发列表名称");
                                    plc.displayListName();
                                    break;
                                default:
                                    System.out.println("该数字无对应操作");
                            }
                        }

                    }
                    break;
                default:
                    System.out.println("该数字无对应操作！");
                    break;

            }
        }
    }


    public static void main(String[] args) {

//        Test.testSong();
//        Test.testPlayList();
//        TestDemo.testPlayListCollection();
        TestDemo.test();
    }
}











