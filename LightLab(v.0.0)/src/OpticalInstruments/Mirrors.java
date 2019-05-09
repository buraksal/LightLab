package OpticalInstruments;

import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public abstract class Mirrors implements Returner{
   // properties
   private ArrayList<Point> coordinates;
   int width;
   int height;
   int startAngle;
   int endAngle;
   
   //constructor
   public Mirrors(ArrayList<Point> points){
      coordinates = points;
   }
   
   public Mirrors(ArrayList<Point> points, int width, int height, int startAngle, int endAngle){
      coordinates = points;
      this.width = width;
      this.height = height;
      this.startAngle = startAngle;
      this.endAngle = endAngle;
   }
   
   //methods
   //returns ArrayList of rays being reflected from the given PlaneMirror

   public Line returnLine( Line ray, PlaneMirror mirror){
//      ArrayList<Line> answers = new ArrayList<Line>();
//      
//      Iterator iterator = rays.iterator();
//      while ( iterator.hasNext()){           
//         Line ray = (Line)iterator.next();
//         if ( mirror.getLine().hits( ray)){
//            Line returned = new Line( ray.hitsPoint( mirror.getLine()), ray.angleLine( mirror.getLine()) + mirror.getLine().angle());
//            answers.add( returned);
//         }
//      }      
//      return answer;
      Line reflected = new Line( ray.hitsPoint( mirror.getLine()), ray.angleLine( mirror.getLine()) + mirror.getLine().angle());
      return reflected;
   }
   
   // first two of mirrors should not be center 
   //do we need this? i used hitsBoolean(Line line) of Line class above
   
   public abstract boolean hits( Line l);
//      ArrayList<Point> mirror = this.coordinates;
//      
//      if( l.getP1().findAngle( mirror.get( 0)) <= l.angle() || l.getP1().findAngle( mirror.get( 1)) >= l.angle()){
//         return true;
//      }
//      else
//         return false;
//   }

   public int getWidth(){
      return this.width;
   }
   
   public int getHeigtht(){
      return this.height;
   }
   
   public int getStartAngle(){
      return this.startAngle;
   }

   public int getEndAngle(){
      return this.endAngle;
   }
   
   public abstract void draw( Graphics g);
}
