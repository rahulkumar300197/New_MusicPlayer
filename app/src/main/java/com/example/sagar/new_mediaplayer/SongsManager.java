package com.example.sagar.new_mediaplayer;
import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.HashMap;

public class SongsManager {
    // SDCard Path
   // final String MEDIA_PATH = Environment.getExternalStorageDirectory().getPath();
    private ArrayList<HashMap<String, String>> songsList = new ArrayList<HashMap<String, String>>();

    // Constructor
    public SongsManager(){

    }

    public ArrayList<HashMap<String, String>> getPlayList(File s) {

        File list[] = s.listFiles();
        for (File file1 : list) {
            if (file1.isDirectory()) {
                getPlayList(file1);
            }
            else if (file1.getName().endsWith(".mp3")) {
                HashMap<String, String> song = new HashMap<String, String>();
                song.put("songTitle", file1.getName().substring(0, (file1.getName().length() - 4)));
                song.put("songPath", file1.getPath());
                songsList.add(song);
            }
        }
        return songsList;
    }

}