package indi.koro.ShouHouTablePet.animation;

public class Move extends Animation {
    protected int x = 20, y = 20;
    protected int originalx = 0, originaly = 0;

    @Override
    protected void render() {
        super.render();
        component.setLocation(originalx + (int) (x * ((float) frame / (float) allFrame)), originaly + (int) (y * ((float) frame / (float) allFrame)));

    }

    @Override
    public void start() {
        super.start();
        originalx = component.getX();
        originaly = component.getY();
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public void stop() {
        super.stop();
        component.setLocation(x, y);
    }
}
