package OpticalInstruments;

import javax.swing.*;
import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.Graphics;

/**
 * testing the plane mirror logic.
 * @Aleyna Sütbaþ
 * @02.05.2019
 */ 
public class PlaneTestPanel extends JPanel
{
  //Properties
  Point p1;
  Point p2;
  ArrayList<Point> points;
  PlaneMirror mirror;
  Line line;
  ArrayList<Line> lines;
  Optic optic;
  
  // Constructor
  public PlaneTestPanel()
  {
    setPreferredSize( new Dimension( 500,500));
    optic = new Optic();
    p1 = new Point( 100.0, 100.0);
    p2 = new Point( 200.0, 200.0);
    points = new ArrayList<Point>();
    points.add( p1);
    points.add( p2);
    mirror = new PlaneMirror( points);
    optic.addOptic( mirror);
    line = new Line( new Point( 300, 150), 180.0);
    optic.addLine( line);
    System.out.println( mirror.getLine().angle());
  } 
  
  //Methods
  @Override
  public void paintComponent( Graphics g)
  {
    super.paintComponent( g);
    optic.draw( g);
  }  

   public static void main( String[] args)
   {
      Scanner scan = new Scanner( System.in);

      // constants

      // variables

      // program code
       
      JFrame frame = new JFrame();
      frame.setSize( 500,500);
      frame.add( new PlaneTestPanel());
      frame.setVisible( true);

      System.out.println( "End.");
   }

}