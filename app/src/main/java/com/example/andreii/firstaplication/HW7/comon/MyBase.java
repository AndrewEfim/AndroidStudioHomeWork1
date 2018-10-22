package com.example.andreii.firstaplication.HW7.comon;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

public class MyBase {
    private static MyBase smyBase;
    private List<Album> mAlbums;

    public static MyBase get(Context context) {
        if (smyBase == null) {
            smyBase = new MyBase(context);
        }
        return smyBase;
    }

    private MyBase(Context context) {
        mAlbums = new ArrayList<>();
        mAlbums.add(new Album("Queen"
                , "1973", "http://www.metallibrary.ru/bands/discographies/images/queen/pictures/73_queen.jpg"));
        mAlbums.add(new Album("Queen II"
                , "1974", "http://www.metallibrary.ru/bands/discographies/images/queen/pictures/74_queen_ii.jpg"));
        mAlbums.add(new Album("Sheer Heart Attack"
                , "1974", "http://www.metallibrary.ru/bands/discographies/images/queen/pictures/74_sheer_heart_attack.jpg"));
        mAlbums.add(new Album("A Night At The Opera"
                , "1975", "http://www.metallibrary.ru/bands/discographies/images/queen/pictures/75_a_night_at_the_opera.jpg"));
        mAlbums.add(new Album("A Day At The Races"
                , "1976", "http://www.metallibrary.ru/bands/discographies/images/queen/pictures/76_a_day_at_the_races.jpg"));
        mAlbums.add(new Album("New Of The World"
                , "1977", "http://www.metallibrary.ru/bands/discographies/images/queen/pictures/77_news_of_the_world.jpg"));
        mAlbums.add(new Album("Jazz", "1978", "http://www.metallibrary.ru/bands/discographies/images/queen/pictures/78_jazz.jpg"));
        mAlbums.add(new Album("Queen Live Killers", "1979", "http://www.metallibrary.ru/bands/discographies/images/queen/pictures/79_queen_live_killers.jpg"));
        mAlbums.add(new Album("The Game", "1980", "http://www.metallibrary.ru/bands/discographies/images/queen/pictures/80_the_game.jpg"));
        mAlbums.add(new Album("Hot Space", "1982", "http://www.metallibrary.ru/bands/discographies/images/queen/pictures/82_hot_space.jpg"));
        mAlbums.add(new Album("The Works", "1984", "http://www.metallibrary.ru/bands/discographies/images/queen/pictures/84_the_works.jpg"));
        mAlbums.add(new Album("A Kind Of Magic", "1986", "http://www.metallibrary.ru/bands/discographies/images/queen/pictures/86_a_kind_of_magic.jpg"));
        mAlbums.add(new Album("The Miracle", "1989", "http://www.metallibrary.ru/bands/discographies/images/queen/pictures/89_the_miracle.jpg"));
        mAlbums.add(new Album("Innuendo", "1991"
                , "http://www.metallibrary.ru/bands/discographies/images/queen/pictures/91_innuendo.jpg"));
        mAlbums.add(new Album("Made In Heaven", "1995", "http://www.metallibrary.ru/bands/discographies/images/queen/pictures/95_made_in_heaven.jpg"));
    }

    public List<Album> getAlbums() {
        return mAlbums;
    }

//    public Album getAlbum(UUID id){
//        for(Album album:mAlbums){
//            if(album.getPhotoID().equals(id)){
//                return album;
//            }
//        }
//        return  null;
//    }

}

