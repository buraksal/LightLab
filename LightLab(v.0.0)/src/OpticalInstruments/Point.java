package OpticalInstruments;

//import javafx.geometry.Point2D;

public class Point{
 
 // Properties
 double x;
 double y;
 
 //constructors
 public Point( double x, double y){
    this.x = x;
    this.y = y;
 }
 
 //methods
 public double findAngle( Point p2){
    Line l = new Line( this, p2);
    
    return l.angle();
 }
 
 public double findAngleX( ){
    Point xP = new Point(1, 0);
    Line l = new Line( xP, this);
    
    return l.angle();
 }
 
 public double getX(){
    return x;
 }
 
 public double getY() {
    return y;
 }
 
 public Point addition( Point p){
    double newX = x + p.getX();
    double newY = y + p.getY();
    
    return new Point( newX, newY);
 }
}
