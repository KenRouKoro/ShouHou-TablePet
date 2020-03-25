/**
 * <p>文件名:Anumation.java</p>
 *
 * @author 16415
 * 创建时间：2019年7月31日 下午9:42:05
 */
package indi.koro.ShouHouTablePet.animation;

import indi.koro.ShouHouTablePet.data.Data;
import indi.koro.ShouHouTablePet.listener.AnimationListener;

import java.awt.*;
import java.util.Arrays;
import java.util.LinkedList;


/**
 * <p>项目名称：ShouHouTablePet</p>
 * <p>类名称:Animation</p>
 * 作者： 16415
 * 版本：1.0
 * 创建时间：2019年7月31日下午9:42:05
 * 类描述:
 */
abstract public class Animation {
    Component component;
    protected Animation animation = this;
    protected Thread thread = null;
    protected int time = 1000;
    protected int allFrame = 60;
    protected int frame = 0;
    protected boolean repeat = false;
    protected boolean loop = false;
    protected boolean stop = false;
    protected boolean pause = false;
    protected boolean run = false;
    protected LinkedList<AnimationListener> animationListeners = new LinkedList<>();

    public void removeAnimationListener(AnimationListener animationListener) {
        animationListeners.remove(animationListener);
    }

    public void addAnimationListeners(AnimationListener... animationListeners) {
        this.animationListeners.addAll(Arrays.asList(animationListeners));
    }

    public LinkedList<AnimationListener> getAnimationListeners() {
        return animationListeners;
    }

    public void setLoop(boolean loop) {
        this.loop = loop;
    }

    public boolean isLoop() {
        return loop;
    }

    public boolean isPause() {
        return pause;
    }

    public boolean isRun() {
        return run;
    }

    public boolean isStop() {
        return stop;
    }

    public void stop() {
        for (AnimationListener animationListener : animationListeners) {
            animationListener.stop();
        }
        stop = true;
    }

    public void pause(boolean pause) {
        for (AnimationListener animationListener : animationListeners) {
            animationListener.pause();
        }
        this.pause = pause;
    }

    /**
     *
     */

    public Animation() {
        // TODO 自动生成的构造函数存根
    }

    public Animation(Component component) {
        // TODO 自动生成的构造函数存根
        this.component = component;
    }

    /**
     * <p>变量名：setComponent</p>
     * 说明：TODO
     */
    public void setComponent(Component component) {
        this.component = component;
    }

    /**
     * <p>方法名：getComponent</p>
     * 说明：TODO
     */
    public Component getComponent() {
        return component;
    }


    protected void run() {
        for (AnimationListener animationListener : animationListeners) {
            animationListener.run();
        }
        if (loop) {
            while (loop) {
                while (frame < allFrame) {
                    render();
                    frame++;
                    if (pause | stop) {
                        if (!pause) frame = 0;
                        break;
                    }
                }
                if (repeat) {
                    while (frame > 0) {
                        render();
                        frame--;
                        if (pause | stop) {
                            if (!pause) frame = 0;
                            break;
                        }
                    }
                }
                frame = 0;
            }
        } else {
            while (frame < allFrame) {
                render();
                frame++;
            }
            if (repeat) {
                while (frame > 0) {
                    render();
                    frame--;
                }
            }
        }
    }

    protected void render() {
        for (AnimationListener animationListener : animationListeners) {
            animationListener.render();
        }
        try {
            Thread.sleep((int) (1000f / (float) Data.fps));
        } catch (InterruptedException e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        }
    }

    protected class ARunnable implements Runnable {

        /* （非 Javadoc）
         * @see java.lang.Runnable#run()
         */
        @Override
        public void run() {
            // TODO 自动生成的方法存根
            animation.run();
        }

    }


    public void start() {
        if (thread != null) {
            thread.stop();
        }
        thread = new Thread(new ARunnable());
        allFrame = (int) ((float) (time) / (1000f / (float) Data.fps));
        if (!pause) frame = 0;
        else pause = false;
        stop = false;
        for (AnimationListener animationListener : animationListeners) {
            animationListener.start();
        }
        thread.start();
    }


    /**
     * @return repeat
     */
    public boolean isRepeat() {
        return repeat;
    }

    /**
     * @param repeat 要设置的 repeat
     */
    public void setRepeat(boolean repeat) {
        this.repeat = repeat;
    }

    /**
     * @return time
     */
    public int getTime() {
        return time;
    }

    /**
     * @param time 要设置的 time
     */
    public void setTime(int time) {
        this.time = time;
    }

    /**
     * @return thread
     */
    public Thread getThread() {
        return thread;
    }

    /**
     * @return allFrame
     */
    public int getAllFrame() {
        return allFrame;
    }

    /**
     * @return frame
     */
    public int getFrame() {
        return frame;
    }

    public static float easeOut(float x) {
        return 1 - (1 - x) * (1 - x);
    }

    public static float easeIn(float x) {
        return x * x;
    }

    public static float easeBoth(float x) {
        return x > 0.5 ? 1 - 2 * (1 - x) * (1 - x) : 2 * x * x;
    }

}
