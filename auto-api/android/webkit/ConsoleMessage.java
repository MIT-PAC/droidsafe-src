package android.webkit;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class ConsoleMessage {
    private MessageLevel mLevel;
    private String mMessage;
    private String mSourceId;
    private int mLineNumber;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.938 -0400", hash_original_method = "054E47655FB4B805E39E1B05003FB12B", hash_generated_method = "6B81984B7833F1345CE00F751A5683D3")
    @DSModeled(DSC.SAFE)
    public ConsoleMessage(String message, String sourceId, int lineNumber, MessageLevel msgLevel) {
        dsTaint.addTaint(message);
        dsTaint.addTaint(lineNumber);
        dsTaint.addTaint(msgLevel.dsTaint);
        dsTaint.addTaint(sourceId);
        // ---------- Original Method ----------
        //mMessage = message;
        //mSourceId = sourceId;
        //mLineNumber = lineNumber;
        //mLevel = msgLevel;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.938 -0400", hash_original_method = "25C4EE735F0CFD6521F32D3F800D92AC", hash_generated_method = "445AC87F761DABED571D5674EA327976")
    @DSModeled(DSC.SAFE)
    public MessageLevel messageLevel() {
        return (MessageLevel)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mLevel;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.939 -0400", hash_original_method = "52DD879A1942417F2863E1B67C410E21", hash_generated_method = "0E09E518F3788B6E7A6B394B4D21746A")
    @DSModeled(DSC.SAFE)
    public String message() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mMessage;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.939 -0400", hash_original_method = "215864977BD1865913F9AFF2A58F69AA", hash_generated_method = "5BE8457B02AF937EEB88A3DEE077F607")
    @DSModeled(DSC.SAFE)
    public String sourceId() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mSourceId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.939 -0400", hash_original_method = "C9721078850915D930C57EA652CD2BDC", hash_generated_method = "AFFA0CD060544364654F1C29D2017DB9")
    @DSModeled(DSC.SAFE)
    public int lineNumber() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mLineNumber;
    }

    
    public enum MessageLevel {
        TIP,
        LOG,
        WARNING,
        ERROR,
        DEBUG
    }

    
}

