import processing.core.PApplet;

public abstract class Figure extends PApplet {

    PApplet run = Main.prog;

    int color1,color2,color3;
    float sx,sy,ex,ey,ex2,ey2 = -1;

    int top = 55;
    int bottom = 60;


    public Figure()
    {
        randomColor();
        randomSize();
        randomPos();
    }

    //- Einzuführende Methoden
    public abstract void paint();
    public void paint(int setx, int sety){};
    public void paint(int setx, int sety, int setex,int setey, int setex2, int setey2){};

    public abstract void randomPos();

    public abstract void randomSize();

    public abstract String whatAmI();

    public void setColor(int c1, int c2, int c3)
    {
        this.color1 = c1;
        this.color2 = c2;
        this.color3 = c3;
    }

    public void randomColor()
    {
        color1 = (int)random(1,255);
        color2 = (int)random(1,255);
        color3 = (int)random(1,255);
        println("color1: " + color1 + "color2: " + color2 +"color3: " + color3);
    }

    public int getColor1() {
        return color1;
    }

    public void setColor1(int color1) {
        this.color1 = color1;
    }

    public int getColor2() {
        return color2;
    }

    public void setColor2(int color2) {
        this.color2 = color2;
    }

    public int getColor3() {
        return color3;
    }

    public void setColor3(int color3) {
        this.color3 = color3;
    }

    public float getSx() {
        return sx;
    }

    public void setSx(float sx) {
        this.sx = sx;
    }

    public float getSy() {
        return sy;
    }

    public void setSy(float sy) {
        this.sy = sy;
    }

    public float getEx() {
        return ex;
    }

    public void setEx(float ex) {
        this.ex = ex;
    }

    public float getEy() {
        return ey;
    }

    public void setEy(float ey) {
        this.ey = ey;
    }

    public float getEx2() {
        return ex2;
    }

    public void setEx2(float ex2) {
        this.ex2 = ex2;
    }

    public float getEy2() {
        return ey2;
    }

    public void setEy2(float ey2) {
        this.ey2 = ey2;
    }

    public int getTop() {
        return top;
    }

    public void setTop(int top) {
        this.top = top;
    }

    public int getBottom() {
        return bottom;
    }

    public void setBottom(int bottom) {
        this.bottom = bottom;
    }
}
