package OpticalInstruments;

import java.util.Iterator;
import java.util.ArrayList;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class PlaneMirror extends Mirrors implements Returner{

    // properties
    double length;
    Line mirror;

    // constructor
    public PlaneMirror( ArrayList<Point> p){
        super( p);
        mirror = new Line( p.get(0), p.get(1));
    }

    //methods
    @Override
    public ArrayList<Line> returnLine( ArrayList<Line> rays){
       
       ArrayList<Line> answers = new ArrayList<Line>();       
       Iterator iterator = rays.iterator();
       while ( iterator.hasNext()){      
          
          Line ray = (Line)iterator.next();
          if ( this.hits( ray)){             
             answers.add( super.returnLine( ray, this));
          }
       }
       return answers;
    }
    
    public Line getLine(){
       return mirror;
    }
    
    @Override
    public boolean hits( Line line){
       if ( line.hitsBoolean( mirror)){
          line.setP2( line.hitsPoint( mirror));
          return true;
       }
       else
          return false;
    }
      
    @Override
    public void draw( Graphics g)
    {
      g.setColor( Color.RED);
      g.drawLine( (int)mirror.getP1().getX(), (int)mirror.getP1().getY(), (int)mirror.getP2().getX(), (int)mirror.getP2().getY());
    }  
}
