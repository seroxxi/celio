public class Triangle extends Figure {

    public Triangle()
    {
        super();
    }

    public void paint()
    {

    }

    public void randomSize()
    {
        ex = random(10,50);
        ey = random(10,50);
    }

    public void randomPos()
    {
        sx = random(1,  run.width - ex);
        sy = random(top, run.height - bottom - ey);
    }

}

