/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package droidsafe.gui;

import java.util.LinkedList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This class encapsulates a trace line so that we can easily deal with 
 * @author Nguyen Nguyen
 */
public class TraceLine {
    private static Logger logger = LoggerFactory.getLogger(CallTree.class);
    
    public static enum TraceType {
        UNKNOWN,
        ENTERING,  // marked with +
        INSIDE,    // marked with =
        EXITING    // marked with -
    }
    
    public String     threadId;
    public TraceType  traceType; 
    public String     methodSignature;
    public String     actualClass;
    public String     parameterString;
           
    public TraceLine() {    
       
    }
    
    public static TraceLine parseTraceLine(String line)  {
        TraceLine traceLine = null;
         List<String> tokens = parseLine(line);
        if (tokens == null)
            return null;

        if (tokens.size() < 5) {
            logger.warn("Call line not completed {} ", line);
            return null;
        }
        
        traceLine = new TraceLine();
        
        String directionToken = tokens.get(0);
        
        if (directionToken.equals("="))
            traceLine.traceType = TraceType.INSIDE;
        else if (directionToken.equals("+"))
            traceLine.traceType = TraceType.ENTERING;
        else if (directionToken.equals("-"))
            traceLine.traceType = TraceType.EXITING;
        else 
            traceLine.traceType = TraceType.UNKNOWN;
        
        traceLine.threadId = tokens.get(1);
        traceLine.methodSignature = tokens.get(2);
        traceLine.actualClass = tokens.get(3);
        traceLine.parameterString = tokens.get(4);
    
        return traceLine;        
    }
    
     private static List<String> parseLine(String line) {
        String origLine = line;
        List<String> list = new LinkedList<String>();
        int ind = line.indexOf(":");
        
        if (ind == -1)
            return list;
        
        try {
            line = line.substring(ind+1).trim();

            //direction 
            list.add("" + line.charAt(0));

            // thread id
            ind = line.indexOf("[");
            int endInd = line.indexOf("]");       
            list.add(line.substring(ind+1, endInd));

            //method signature
            ind = line.indexOf("<");
            endInd = line.indexOf(")>");
            list.add(line.substring(ind+1, endInd+2));

            //Actual class
            line = line.substring(endInd + 2);
            ind = line.indexOf("[");
            endInd = line.indexOf("]");       
            list.add(line.substring(ind+1, endInd));

            //parameter string
            line = line.substring(endInd);
            ind = line.indexOf("[");
            endInd = line.lastIndexOf("]");       
            list.add(line.substring(ind+1, endInd));        
        }
        catch (Exception ex ) {
            logger.warn("Exception while processing {} ", origLine);
            logger.warn("{} ", ex.getStackTrace());
        }

        logger.info("List {} ", list);
        return list;

    }
          
    public String toString() {
        StringBuilder sb = new StringBuilder();

        String signature = methodSignature;

        if (actualClass.length() > 0) {
           int colonIndex   = signature.indexOf(":");
           signature =  signature.substring(colonIndex);                
           signature = String.format("<%s%s", actualClass, signature);
        }

        sb.append(signature);
        sb.append(String.format("(%s)", parameterString));         
        return sb.toString();
    }

     public boolean equals(String methodSig) {
         return (methodSignature.equals(methodSig));
     }
    
}
