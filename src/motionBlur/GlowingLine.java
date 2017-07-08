package motionBlur;

import processing.core.PApplet;

public class GlowingLine extends PApplet
{

    public void setup(){
      size(200,200);
      smooth();
      background(0);
      noStroke();
      //filter( BLUR, 10);
      fill(255,0,0);
      ellipse(100,100,95,95);
      
      //
      //stroke(0);
      filter( BLUR, 20);
      
      fill(255,255,0);
      ellipse(100,100,90,90);
      
      filter( BLUR, 20);
    }

    public void draw(){}


}
