public class Square extends Figure {

    int diffx, diffy;
    int sx,sy,ex,ey;

    //int color1,color2,color3;

    public Square()
    {
        super();
        sx = 100;
        sy = 100;
        ex = 10;
        ey = 10;
    }

    public Square(int stx, int sty, int enx, int eny)
    {
        super();
        sx = stx;
        sy = sty;
        ex = enx;
        ey = eny;
    }

    public void paint()
    {
        super.fill(color1,color2,color3);
        super.rect(sx, sy, ex, ey);
    };

    public void paintSquare(int startx, int starty, int sizex, int sizey)
    {
        fill(color1,color2,color3);
        rect(startx, starty, sizex, sizey);
    }

}
