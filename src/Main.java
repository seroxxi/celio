import processing.core.PApplet;


public class Main extends PApplet{

    float x1 = 10;
    float x2 = 310;
    float x3 = 160;
    float y1 = 10;
    float y2 = 10;
    float y3 = 10+(sqrt((float) (3.0/4))*300);

    int size = 8;


    public static void main(String[] args) {
        PApplet.main("Main");
    }

    public void settings(){
        size(300,300);
    }

    public void setup(){
        fill(255,0,0);
        triangle(x1, y1, x2, y2, x3, y3);
        pattern(x1, y1, x2, y2, x3, y3, size);
    }

    public void draw(){
        ellipse(width/2,height/2,second(),second());
    }

    //- Recursive Pattern
    public  void pattern(float x1, float y1, float x2, float y2, float x3, float y3,int size)
    {
        size = size -1;
        System.out.println("Control: "+size);

        if(size >=1){
            pattern(x1,y1,(x1+x2)/2,(y1+y2)/2,(x1+x3)/2,(y1+y3)/2,size);
            pattern((x1+x2)/2,(y1+y2)/2,x2,y2,(x2+x3)/2,(y2+y3)/2,size);
            pattern((x1+x3)/2,(y1+y3)/2,(x2+x3)/2,(y2+y3)/2,x3,y3,size);
        }
        else
        {
            System.out.println("Bin im Malcase " + size);
            triangle(x1, y1, x2, y2, x3, y3);
        }


    }

}