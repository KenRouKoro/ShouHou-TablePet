package indi.koro.ShouHouTablePet.animation;

import java.awt.*;

public class Float extends Animation {
    int moveX = 20, moveY = 20;
    int originalX, originalY;

    public Float() {

    }

    public Float(Component component) {
        super(component);
        originalX = component.getX();
        originalY = component.getY();
    }

    public void setMoveX(int moveX) {
        this.moveX = moveX;
    }

    public void setMoveY(int moveY) {
        this.moveY = moveY;
    }

    @Override
    public void setComponent(Component component) {
        super.setComponent(component);
        originalX = component.getX();
        originalY = component.getY();
    }


    @Override
    protected void render() {
        int x = 0;
        int y = 0;
        if (frame < allFrame / 2) {
            if (frame < allFrame / 4) {
                x = (int) (originalX + easeOut(frame / (allFrame / 4f)) * moveX);
                y = (int) (originalY + easeOut(frame / (allFrame / 4f)) * moveY);
            } else {
                x = (int) (originalX + moveX - easeIn((frame - allFrame / 4f) / (allFrame / 4f)) * moveX);
                y = (int) (originalY + moveY - easeIn((frame - allFrame / 4f) / (allFrame / 4f)) * moveY);
            }
        } else {
            if (frame < allFrame * 3f / 4f) {
                int i = allFrame / 2;
                x = (int) (originalX - easeOut((frame - i) / (allFrame / 4f)) * moveX);
                y = (int) (originalY - easeOut((frame - i) / (allFrame / 4f)) * moveY);
            } else {
                int i = allFrame * 3 / 4;
                x = (int) (originalX - moveX + easeIn((frame - i) / (allFrame / 4f)) * moveX);
                y = (int) (originalY - moveY + easeIn((frame - i) / (allFrame / 4f)) * moveY);
            }
        }
        component.setLocation(x, y);
        super.render();
    }

}
