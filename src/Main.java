import processing.core.PApplet;

import java.util.ArrayList;
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
    int lifeCount = 2;

    //- Definition Level
    //- 1) level
    //- 2) Anzahl Leben
    //- 3) timeScore
    //- 4) Score
    //- 5) Anzahl Figuren

    int anzLvl = 10;
    long[][] Level = new long[anzLvl][5];
    int currentLVL = 1;

    //- Time
    long startTime = new Date().getTime();
    long currentTime = new Date().getTime();
    long lvlMaxTime = 400;
    long spendTime = 1;
    long countTime = 1;

    //- anz Figur im Spiel
    int countFigur = 5;

    //- Figure ready
    int readyFigure = 1;

    //- End Message
    String EndMessage = "";

    //- Score
    long scoreCount = 0;

    //- Figure init
    ArrayList<Figure> figurePool = new ArrayList<Figure>();


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

        setupLevel(currentLVL, lifeCount, (startTime - currentTime), scoreCount, countFigur);

        println(startTime);

        initFigure(countFigur, readyFigure);
        
    }


    public void draw(){

        if(countFigur == 0)
        {
            changeLevel();
        }

        //- reset Window
        resetWindow();

        //- paintFigure
        for(int i = 0; i < figurePool.size(); i++)
        {
            figurePool.get(i).paint();
        }

        //- Calculate Time differenz -> Countdown from lvlMaxtime
        calcSpendTime();

        //- calcScore
        //calcScore(1);
        calcScore(currentLVL);

        //- Framerate Bildaufbau --> hier 1 für alle sekunden
        frameRate(1);
    }

    public void initFigure(int figureCount, int readyFigure)
    {
        for(int i = 0; i <= figureCount; i++)
        {
            switch(readyFigure) {
                case 1:
                    figurePool.add(new Square(10,30,10,10));
                    break;
                default:
                    figurePool.add(new Square());
            }
        }
    }

    public void setupLevel(int cLVL, int lCount, long sTime, long sCount, int cFigure)
    {
        //- currentLVL
        Level[currentLVL -1][0] = cLVL;
        //- lifeCount
        Level[currentLVL -1][1] = lCount;
        //- spentTime
        Level[currentLVL -1][2] = sTime;
        //- scoreCount
        Level[currentLVL -1][3] = sCount;
        //- countFigure
        Level[currentLVL -1][4] = cFigure;
    }

    public void changeLevel()
    {
        resetTime();

        //- Level
        Level[currentLVL][0] = currentLVL+1;
        //- Life
        Level[currentLVL][1] = Level[currentLVL -1][1];
        //- spentTime
        Level[currentLVL][2] = spendTime;
        //- scoreCount
        Level[currentLVL][3] = Level[currentLVL -1][3];
        //- countFigure
        Level[currentLVL][4] = countFigur;
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
            //countTime = countTime + spendTime;
            Level[currentLVL -1][2] = currentTime;
        }
        else
        {
            //if(lifeCount == 0)
            if(Level[currentLVL -1][1] == 0)
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
                //lifeCount = lifeCount - 1;
                Level[currentLVL -1][1] = lifeCount - 1;
                //scoreCount = scoreCount / 2;
                Level[currentLVL -1][3] = scoreCount/2;
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

    public void resetWindow()
    {
        fill(255,255,255);
        rect(0,0,WinWidth,WinHeight);
        fill(0,0,0);
        rect(0, imgHeight,WinWidth,3 );

        //- Logo
        image(imgLogo, ((WinWidth/2)-imgWidth/2), 3, imgWidth,imgHeight);


        //- Life
        //if(lifeCount > 0){
        if(Level[currentLVL -1][1] > 0){
            for(int i = 0; i < Level[currentLVL -1][1]; i++)
            {
                lifePos = (i * lifeWidth) + 2 + lifeWidth;
                image(imgLife,(WinWidth-lifePos), 4, lifeWidth, lifeHeight);
            }
        }
        else
        {
            textSize(32);
            text("0", (WinWidth-(lifePos / 2)-10), 38);
        }


    }

    public void calcScore(int lvl)
    {
        //- Score
        textSize(14);
        scoreCount = scoreCount + (lvl * countTime);
        text("Score: " + scoreCount , 10, 32);
        Level[currentLVL -1][3] = scoreCount;
    }

}