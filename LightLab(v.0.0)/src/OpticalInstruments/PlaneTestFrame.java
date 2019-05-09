package OpticalInstruments;

import java.util.*;
import javax.swing.*;

/**
 * plane test frame
 * @author __your name___
 * @version __date__
 */ 
public class PlaneTestFrame
{
   public static void main( String[] args)
   {
      Scanner scan = new Scanner( System.in);

      // constants

      // variables

      // program code
      System.out.println( "Start...");
      JFrame frame = new JFrame();
      frame.setSize( 500,500);
      frame.add( new PlaneTestPanel());
      frame.setVisible( true);

      System.out.println( "End.");
   }

}