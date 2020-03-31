/**
 * <p>文件名:MusicPlayer.java</p>
 *
 * @author 16415
 * 创建时间：2019年7月31日 下午10:00:32
 */
package indi.koro.ShouHouTablePet.music;

import javafx.embed.swing.JFXPanel;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import javax.swing.*;
import java.util.concurrent.CountDownLatch;

/**
 * <p>项目名称：ShouHouTablePet</p>
 * <p>类名称:MusicPlayer</p>
 * 作者： 16415
 * 版本：1.0
 * 创建时间：2019年7月31日下午10:00:32
 * 类描述:
 */
public class MusicPlayer {
    final CountDownLatch latch = new CountDownLatch(1);
    Media musicMedia;
    MediaPlayer musicMediaPlayer = null;
    String URI;

    /**
     *
     */
    public MusicPlayer() {
        // TODO 自动生成的构造函数存根
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new JFXPanel(); // initializes JavaFX environment
                latch.countDown();
            }
        });
        try {
            latch.await();
        } catch (InterruptedException e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        }
    }

    /**
     *<p>变量名：setURI</p>
     *说明：TODO
     *
     * @param uRI
     */
    public void setURI(String uRI) {
        URI = uRI;
        musicMedia = new Media(URI);
        musicMediaPlayer = new MediaPlayer(musicMedia);
    }

    public void play() {
        musicMediaPlayer.play();
    }

    /**
     *<p>方法名：getMusicMediaPlayer</p>
     *说明：TODO
     */
    public MediaPlayer getMusicMediaPlayer() {
        return musicMediaPlayer;
    }

    public void stop() {
        if (musicMediaPlayer != null) {
            musicMediaPlayer.stop();
        }
    }

    public void pause() {
        musicMediaPlayer.pause();
    }


}
