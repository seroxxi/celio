public class Square extends Figure {

    int diffx, diffy;

    //int color1,color2,color3;

    public Square()
    {
        super();
    }

    public Square(float stx, float sty, float enx, float eny)
    {
        super();
        sx = stx;
        sy = sty;
        ex = enx;
        ey = eny;
    }

    public void paint()
    {
        println(color1 + ", " + color2 + ", " + color3);
        run.fill(color1,color2,color3);
        run.rect(sx, sy, ex, ey);
    }

    @Override
    public void paint(int setx, int sety)
    {
        run.fill(color1,color2,color3);
        run.rect(setx, sety, ex, ey);
    }



    public void randomSize()
    {
        ex = random(10,45);
        ey = random(10, 45);
    }

    public void randomPos()
    {
        sx = random(1,  run.width - ex);
        sy = random(top, run.height - bottom - ey);
    }

    public String whatAmI()
    {
        return "Square";
    }

}
