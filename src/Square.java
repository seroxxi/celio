public class Square extends Figure {

    int diffx, diffy;
    int sx,sy,ex,ey;

    //int color1,color2,color3;

    public Square()
    {
        super();
        sx = 0;
        sy = 0;
        ex = 0;
        ey = 0;
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
        paintSquare(sx,sy,ex,ey);
    };

    public void paintSquare(int startx, int starty, int sizex, int sizey)
    {
        fill(getColor1(),getColor2(),getColor3());
        rect(startx, starty, sizex, sizey);
    }

}
