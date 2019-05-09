package OpticalInstruments;

import java.awt.*;
import java.util.*;

public class Line {
    // properties
    double x1;
    double x2;
    double y1;
    double y2;
    Point p2;
    Point p1;
    boolean checked = false;

    //constructors
    public Line( Point p1, Point p2){
        x1 = p1.getX();
        x2 = p2.getX();
        y1 = p1.getY();
        y2 = p2.getY();

        this.p2 = p2;
        this.p1 = p1;
    }

    public Line( Point p1, Double angle){
        this.p1 = p1;
        Double ang = - angle / 180 * Math.PI;
        
        p2 = p1.addition( new Point( Math.cos( ang) * 10000, Math.sin( ang) * 10000));

        x1 = p1.getX();
        x2 = p2.getX();
        y1 = p1.getY();
        y2 = p2.getY();
    }

    //methods
    public double angle(){
       double angle = -Math.atan2( y2-y1, x2-x1) * 180 / Math.PI % 360;
       if ( angle < 0)
          return angle  + 360;
       else
          return angle;
    }

    // angle between 2 lines => angle of given line - this.angle()
    public double angleLine( Line l){
        return Math.abs( l.angle() - this.angle());
    }

    public Point getP1() {
        return p1;
    }
    
    public Point getP2() {
       return p2;
    }
    
    public void setP2( Point p2){
       this.p2 = p2;
    }
    
    public void setChecked( boolean set){       //where do we use this?
       checked = set;
    }
    
    // does this hit the given line?
    public boolean hitsBoolean( Line line){
       
       if( this.getP1().findAngle( line.getP1()) <= this.angle() || this.getP1().findAngle( line.getP2()) >= this.angle()){
          return true;
       }
       else
          return false;
    }

    // returns the intersection point
    public Point hitsPoint( Line line){
        // Line AB represented as a1x + b1y = c1
        double a1 = this.y2 - this.y1;
        double b1 = this.x1 - this.x2;
        double c1 = a1*( this.x1) + b1*( this.y1);

        // Line CD represented as a2x + b2y = c2
        double a2 = line.y2 - line.y1;
        double b2 = line.x1 - line.x2;
        double c2 = a2*( line.x1) + b2*( line.y1);

        double determinant = a1*b2 - a2*b1;

        if (determinant == 0)
        {
            // The lines are parallel. This is simplified
            // by returning a pair of FLT_MAX
            return new Point(Double.MAX_VALUE, Double.MAX_VALUE);
        }
        else
        {
            double x = (b2*c1 - b1*c2)/determinant;
            double y = (a1*c2 - a2*c1)/determinant;

            return new Point(x, y);
        }
    }

    public void draw( Graphics g){
       g.setColor( Color.BLUE);
       g.drawLine( (int) x1, (int) y1, (int) x2, (int) y2);
    }
}