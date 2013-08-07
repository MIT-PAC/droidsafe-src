package org.xml.sax;

// Droidsafe Imports
import droidsafe.annotations.*;





public class SAXException extends Exception {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:44.219 -0400", hash_original_field = "42552B1F133F9F8EB406D4F306EA9FD1", hash_generated_field = "70BD42A5533D521458BB067703B0D3E8")

    private Exception exception;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:44.220 -0400", hash_original_method = "D831304643C6F5E396859CE263E8CD25", hash_generated_method = "AAA5AC1F47C13D6FA9C3251A3CA70252")
    public  SAXException() {
        this.exception = null;
        // ---------- Original Method ----------
        //this.exception = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:44.220 -0400", hash_original_method = "0B6772DEF84C5953639B673A22CD2D87", hash_generated_method = "95FCD2A8DBFB1DEEBF93EE10C63F4975")
    public  SAXException(String message) {
        super(message);
        addTaint(message.getTaint());
        this.exception = null;
        // ---------- Original Method ----------
        //this.exception = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:44.221 -0400", hash_original_method = "6C46F13EAE6D974667959E2EC15AB51C", hash_generated_method = "55130B653035BD76E425D4A793596D27")
    public  SAXException(Exception e) {
        this.exception = e;
        // ---------- Original Method ----------
        //this.exception = e;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:44.221 -0400", hash_original_method = "DAF90944A95CF29FF719B165EE1D8D20", hash_generated_method = "6FA45DF5D9923C5726263D99C0121233")
    public  SAXException(String message, Exception e) {
        super(message);
        addTaint(message.getTaint());
        this.exception = e;
        // ---------- Original Method ----------
        //this.exception = e;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:44.222 -0400", hash_original_method = "7F1A7B3B4DC8BE54F069CECA78CE108B", hash_generated_method = "A0FFAA7B8E4ADF385172AF09A052629E")
    public String getMessage() {
        String message = super.getMessage();
        if(message == null && exception != null)        
        {
String var56A9A9C4DE0617B8FC85BA86A88F5292_1336530851 =             exception.getMessage();
            var56A9A9C4DE0617B8FC85BA86A88F5292_1336530851.addTaint(taint);
            return var56A9A9C4DE0617B8FC85BA86A88F5292_1336530851;
        } //End block
        else
        {
String varFD182D7074F3848E773A38B067BBB880_728352829 =             message;
            varFD182D7074F3848E773A38B067BBB880_728352829.addTaint(taint);
            return varFD182D7074F3848E773A38B067BBB880_728352829;
        } //End block
        // ---------- Original Method ----------
        //String message = super.getMessage();
        //if (message == null && exception != null) {
        //return exception.getMessage();
    //} else {
        //return message;
    //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:44.222 -0400", hash_original_method = "DEACD8BC5F5C015493740DB375DC8E7E", hash_generated_method = "91567B40BA453134B7FBAD088E0F4388")
    public Exception getException() {
Exception varB0A8CAD4B1C89FFC19A72F5757E92C21_964451098 =         exception;
        varB0A8CAD4B1C89FFC19A72F5757E92C21_964451098.addTaint(taint);
        return varB0A8CAD4B1C89FFC19A72F5757E92C21_964451098;
        // ---------- Original Method ----------
        //return exception;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:44.223 -0400", hash_original_method = "0BE493810C06D201F4519F1260F94FAA", hash_generated_method = "0780AB060625F2C3A1AA47D2E6AE3293")
    public String toString() {
        if(exception != null)        
        {
String varDBA83892D0A572A6D50055A5F649DE6A_1624216205 =             exception.toString();
            varDBA83892D0A572A6D50055A5F649DE6A_1624216205.addTaint(taint);
            return varDBA83892D0A572A6D50055A5F649DE6A_1624216205;
        } //End block
        else
        {
String varD8287C6801A4C167675BF9EBA9EC2C1B_2041516567 =             super.toString();
            varD8287C6801A4C167675BF9EBA9EC2C1B_2041516567.addTaint(taint);
            return varD8287C6801A4C167675BF9EBA9EC2C1B_2041516567;
        } //End block
        // ---------- Original Method ----------
        //if (exception != null) {
        //return exception.toString();
    //} else {
        //return super.toString();
    //}
    }

    
}

