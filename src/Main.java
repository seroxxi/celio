import processing.core.PApplet;

import java.util.Date;

public class Main extends PApplet{

    //- Main Board
    int WinWidth = 800;
    int WinHeight = 700;

    //- Logo
    int imgWidth = 150;
    int imgHeight = 50;

    //- Life
    int lifeWidth = 40;
    int lifeHeight = 40;
    int lifePos = 0;
    //- Anzahl Leben
    int lifeCount = 1;

    //- Definition Level
    //- 1) level
    //- 2) Anzahl Leben
    //- 3) verbrauchte Zeit
    //- 4) Score
    //- 5) Anzahl Figuren

    int anzLvl = 10;
    int[][] Level = new int[anzLvl][5];

    //- Time
    long startTime = new Date().getTime();
    long currentTime = new Date().getTime();
    long lvlMaxTime = 5;
    long spendTime = 1;

    double countTime = 0.0;


    String EndMessage = "";


    //- Grundsatzüberlegung wegen Arrays oder ArrayList und ob diese Mehrdimensional
    //- Gerade wenn es um die Leben und Zeit geht. Leben und Score müssen von Level zu level kopiert werden
    //- Zeiten nur pro Level

    processing.core.PImage imgLogo;	// Declare a variable of type PImage
    processing.core.PImage imgLife;	// Declare a variable of type PImage

    public static void main(String[] args) {
        PApplet.main("Main");
    }

    public void settings(){
        size(WinWidth,WinHeight);
    }

    public void setup(){
        imgLogo = loadImage("CELIO_bLANK.png");
        imgLife = loadImage("heart-icon.png");
        println(startTime);
        
    }

    public void draw(){
        //- reset Window
        fill(255,255,255);
        rect(0,0,WinWidth,WinHeight);
        fill(0,0,0);
        rect(0, imgHeight,WinWidth,3 );

        //- Logo
        image(imgLogo, ((WinWidth/2)-imgWidth/2), 3, imgWidth,imgHeight);


        //- Life
        if(lifeCount > 0){
            for(int i = 0; i < lifeCount; i++)
            {
                lifePos = (i * lifeWidth) + 2 + lifeWidth;
                image(imgLife,(WinWidth-lifePos), 4, lifeWidth, lifeHeight);

            }
        }
        else
        {
            textSize(32);
            text("0", (WinWidth-(lifePos / 2)-5), 38);
        }


        //- Calculate Time differenz -> Countdown from lvlMaxtime
        calcSpendTime();

        //- Framerate Bildaufbau --> hier 1 für alle sekunden
        frameRate(1);
    }

    public void calcSpendTime()
    {
        //- Calculate Time differenz -> Countdown from lvlMaxtime
        if(spendTime > 0) {
            currentTime = ((new Date().getTime()) - startTime) / 1000;
            println("currentTime: "+currentTime);
            spendTime = lvlMaxTime - currentTime;
            println("spendTime: "+spendTime);
            println("lifeCount: "+lifeCount);
        }
        else
        {
            if(lifeCount == 0)
            {
                noLoop();
                println("Game Over");
                EndMessage = "Game Over";
                textSize(32);
                textAlign(CENTER);
                text(EndMessage, WinWidth/2, (WinHeight/2)-30);
                fill(0, 102, 153);
                text(EndMessage, WinWidth/2, (WinHeight/2));
                fill(0, 102, 153, 51);
                text(EndMessage, WinWidth/2, (WinHeight/2)+30);
            }
            else
            {
                lifeCount = lifeCount - 1;
                resetTime();
            }

        }
    }

    public void resetTime()
    {
        startTime = new Date().getTime();
        currentTime = new Date().getTime();
        spendTime = 1;
    }


}