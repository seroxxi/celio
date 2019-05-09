public class Circle extends Figure {

    public Circle()
    {
        super();
    }

    public void paint()
    {
        run.fill(color1,color2,color3);
        run.circle(sx, sy, ex);
    }

    @Override
    public void paint(int setx, int sety)
    {
        run.fill(color1,color2,color3);
        run.circle(setx, sety, ex);
    }


    public void randomSize()
    {
        ex = random(10,50);
        ey = random(10,50);
    }

    public void randomPos()
    {
        sx = random(ex,  run.width - ex);
        sy = random(top+ex, run.height - bottom - ey);
    }

    public String whatAmI()
    {
        return "Circle";
    }

}
