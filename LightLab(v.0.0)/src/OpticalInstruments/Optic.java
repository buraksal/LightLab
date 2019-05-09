package OpticalInstruments;

import java.util.ArrayList;
import java.awt.*;

public class Optic{

    // properties
    ArrayList<Mirrors> opticList;
    ArrayList<Line> lineList;

    //constructor
    public Optic() {
        this.opticList = new ArrayList<Mirrors>();
        this.lineList = new ArrayList<Line>();
    }

    //methods
    public void addOptic( Mirrors a) {
        opticList.add( a);
    }
    
    public ArrayList<Mirrors> getOpticList(){
       return opticList;
    }
    
    public void addLine( Line a) {       
       lineList.add( a);
    }
    
    public ArrayList<Line> getLineList(){
       return lineList;
    }
    
    public void draw( Graphics g){
       for ( int i = 0; i < opticList.size(); i++){
          opticList.get( i).draw( g);
          
          ArrayList<Line> reflectedLines = opticList.get( i).returnLine( lineList);
          for ( int b = 0; b < reflectedLines.size(); b++)
             reflectedLines.get( b).draw( g);
       }
       for ( int a = 0; a < lineList.size(); a++)
          lineList.get( a).draw( g);
    }
}
