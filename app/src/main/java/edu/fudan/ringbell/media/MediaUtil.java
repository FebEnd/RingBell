package edu.fudan.ringbell.media;

/**
 * Created by niuzhenghao on 2018/1/7.
 */

import android.content.Context;
import android.database.Cursor;
import android.provider.MediaStore;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import edu.fudan.ringbell.R;
import edu.fudan.ringbell.entity.MusicInfo;

public class MediaUtil {
    /**
     * 用于从数据库中查询歌曲的信息，保存在List当中
     *
     * @return
     */
    public static List<MusicInfo> getMusicInfos(Context context) {
        Cursor cursor = context.getContentResolver().query(
                MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, null, null, null,
                MediaStore.Audio.Media.DEFAULT_SORT_ORDER);
        List<MusicInfo> MusicInfos = new ArrayList<MusicInfo>();
        for (int i = 0; i < cursor.getCount(); i++) {
            cursor.moveToNext();
            MusicInfo MusicInfo = new MusicInfo();
            long id = cursor.getLong(cursor
                    .getColumnIndex(MediaStore.Audio.Media._ID));               //音乐id
            String title = cursor.getString((cursor
                    .getColumnIndex(MediaStore.Audio.Media.TITLE)));            //音乐标题
            String artist = cursor.getString(cursor
                    .getColumnIndex(MediaStore.Audio.Media.ARTIST));            //艺术家
            long duration = cursor.getLong(cursor
                    .getColumnIndex(MediaStore.Audio.Media.DURATION));          //时长
            long size = cursor.getLong(cursor
                    .getColumnIndex(MediaStore.Audio.Media.SIZE));              //文件大小
            String url = cursor.getString(cursor
                    .getColumnIndex(MediaStore.Audio.Media.DATA));              //文件路径
            int isMusic = cursor.getInt(cursor
                    .getColumnIndex(MediaStore.Audio.Media.IS_MUSIC));          //是否为音乐
            long  dateModified = cursor.getLong(cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.DATE_MODIFIED));
            if (isMusic != 0) {     //只把音乐添加到集合当中
                MusicInfo.setId(id);
                MusicInfo.setTitle(title);
                MusicInfo.setArtist(artist);
                MusicInfo.setDuration(duration);
                MusicInfo.setSize(size);
                MusicInfo.setUrl(url);
                MusicInfo.setDateModified(dateModified);
                MusicInfos.add(MusicInfo);
            }
        }
        return MusicInfos;
    }


    /**
     * 格式化时间，将毫秒转换为分:秒格式
     * @param time
     * @return
     */
    public static String formatTime(long time) {
        String min = time / (1000 * 60) + "";
        String sec = time % (1000 * 60) + "";
        if (min.length() < 2) {
            min = "0" + time / (1000 * 60) + "";
        } else {
            min = time / (1000 * 60) + "";
        }
        if (sec.length() == 4) {
            sec = "0" + (time % (1000 * 60)) + "";
        } else if (sec.length() == 3) {
            sec = "00" + (time % (1000 * 60)) + "";
        } else if (sec.length() == 2) {
            sec = "000" + (time % (1000 * 60)) + "";
        } else if (sec.length() == 1) {
            sec = "0000" + (time % (1000 * 60)) + "";
        }
        return min + ":" + sec.trim().substring(0, 2);
    }
}