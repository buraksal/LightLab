package OpticalInstruments;

import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ConvexMirror extends Mirrors implements Returner      // Drawable
{
   
   //properties
   Point p1; 
   Point p2;
   
   //constructor
   public ConvexMirror(ArrayList<Point> endPoints, int width, int height, int startAngle, int endAngle){
      super( endPoints, width, height, startAngle, endAngle);
      
      this.p1 = endPoints.get( 0);
      this.p2 = endPoints.get( 1);
   }
   
   //methods
   @Override
   public ArrayList<Line> returnLine( ArrayList<Line> rays){
      ArrayList<Line> reflectedLines = new ArrayList<Line>();
      for ( int i = 0; i < rays.size(); i++){
         if ( this.hits( rays.get(i))){
            //rays.get(i).angle() + 90.0            
            //find the plane mirror for each of the rays
            ArrayList<Point> coordinates = new ArrayList<Point>();
            coordinates.add( rays.get(i).getP2());
            coordinates.add( rays.get(i).getP2());
            PlaneMirror mirror = new PlaneMirror( coordinates);
            reflectedLines.add( super.returnLine( rays.get(i), mirror));
         }
      }
         //return answers  
         return reflectedLines;
   }
   
   @Override
   public boolean hits( Line line){
//      if ( line.getP1().pointAngle( p1) >= line.angle() && line.getP1().pointAngle( p1) <= line.angle()){
//         line.setP2( mirror.hitsPoint( line));
//         return true;
//      }
//      else
         return false;
   }
   
   @Override
   public void draw( Graphics g)
   {
      g.setColor( Color.BLUE);
      //draw arc
   }
   
}
