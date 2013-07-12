package org.xml.sax;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public class SAXException extends Exception {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:23.122 -0400", hash_original_field = "42552B1F133F9F8EB406D4F306EA9FD1", hash_generated_field = "70BD42A5533D521458BB067703B0D3E8")

    private Exception exception;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:23.122 -0400", hash_original_method = "D831304643C6F5E396859CE263E8CD25", hash_generated_method = "AAA5AC1F47C13D6FA9C3251A3CA70252")
    public  SAXException() {
        this.exception = null;
        // ---------- Original Method ----------
        //this.exception = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:23.122 -0400", hash_original_method = "0B6772DEF84C5953639B673A22CD2D87", hash_generated_method = "95FCD2A8DBFB1DEEBF93EE10C63F4975")
    public  SAXException(String message) {
        super(message);
        addTaint(message.getTaint());
        this.exception = null;
        // ---------- Original Method ----------
        //this.exception = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:23.123 -0400", hash_original_method = "6C46F13EAE6D974667959E2EC15AB51C", hash_generated_method = "55130B653035BD76E425D4A793596D27")
    public  SAXException(Exception e) {
        this.exception = e;
        // ---------- Original Method ----------
        //this.exception = e;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:23.123 -0400", hash_original_method = "DAF90944A95CF29FF719B165EE1D8D20", hash_generated_method = "6FA45DF5D9923C5726263D99C0121233")
    public  SAXException(String message, Exception e) {
        super(message);
        addTaint(message.getTaint());
        this.exception = e;
        // ---------- Original Method ----------
        //this.exception = e;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:23.124 -0400", hash_original_method = "7F1A7B3B4DC8BE54F069CECA78CE108B", hash_generated_method = "30D553BCF0E1D372FAFB1EF642FA62AA")
    public String getMessage() {
        String message = super.getMessage();
    if(message == null && exception != null)        
        {
String var56A9A9C4DE0617B8FC85BA86A88F5292_76345669 =             exception.getMessage();
            var56A9A9C4DE0617B8FC85BA86A88F5292_76345669.addTaint(taint);
            return var56A9A9C4DE0617B8FC85BA86A88F5292_76345669;
        } //End block
        else
        {
String varFD182D7074F3848E773A38B067BBB880_787628292 =             message;
            varFD182D7074F3848E773A38B067BBB880_787628292.addTaint(taint);
            return varFD182D7074F3848E773A38B067BBB880_787628292;
        } //End block
        // ---------- Original Method ----------
        //String message = super.getMessage();
        //if (message == null && exception != null) {
        //return exception.getMessage();
    //} else {
        //return message;
    //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:23.124 -0400", hash_original_method = "DEACD8BC5F5C015493740DB375DC8E7E", hash_generated_method = "0146E215FF970B2EB9E63A353FF8832A")
    public Exception getException() {
Exception varB0A8CAD4B1C89FFC19A72F5757E92C21_1910108796 =         exception;
        varB0A8CAD4B1C89FFC19A72F5757E92C21_1910108796.addTaint(taint);
        return varB0A8CAD4B1C89FFC19A72F5757E92C21_1910108796;
        // ---------- Original Method ----------
        //return exception;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:23.124 -0400", hash_original_method = "0BE493810C06D201F4519F1260F94FAA", hash_generated_method = "CDCA89F5D441E7EB8BB2A64366CF4C52")
    public String toString() {
    if(exception != null)        
        {
String varDBA83892D0A572A6D50055A5F649DE6A_513110725 =             exception.toString();
            varDBA83892D0A572A6D50055A5F649DE6A_513110725.addTaint(taint);
            return varDBA83892D0A572A6D50055A5F649DE6A_513110725;
        } //End block
        else
        {
String varD8287C6801A4C167675BF9EBA9EC2C1B_1932833801 =             super.toString();
            varD8287C6801A4C167675BF9EBA9EC2C1B_1932833801.addTaint(taint);
            return varD8287C6801A4C167675BF9EBA9EC2C1B_1932833801;
        } //End block
        // ---------- Original Method ----------
        //if (exception != null) {
        //return exception.toString();
    //} else {
        //return super.toString();
    //}
    }

    
}

