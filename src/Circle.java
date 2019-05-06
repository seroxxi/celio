public class Circle extends Figure {

    public Circle()
    {
        super();
    }

    public void paint()
    {
        run.circle(sx, sy, ex);
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

}
