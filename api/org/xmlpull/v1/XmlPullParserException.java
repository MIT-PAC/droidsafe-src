package org.xmlpull.v1;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public class XmlPullParserException extends Exception {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:11.936 -0500", hash_original_field = "01FF179A7E52E704AD95DCB4F9EF5587", hash_generated_field = "EDAD1988191BC8FE2A32ADF91A96320C")

    protected Throwable detail;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:11.939 -0500", hash_original_field = "40127855093EB96F9ED1C4872DE2AC1A", hash_generated_field = "156AAEA15ABF3CBA31DAC677D9612539")

    protected int row = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:11.941 -0500", hash_original_field = "51191D808B1836074CB1CF2BA7969685", hash_generated_field = "A5B3244522132AF33705DB6C2189351A")

    protected int column = -1;

    /*    public XmlPullParserException() {
          }*/

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:11.943 -0500", hash_original_method = "81C346207A813FD28C849879E7041B6E", hash_generated_method = "8AEBC415188C2414825B6975462CB6B6")
    
public XmlPullParserException(String s) {
        super(s);
    }

    /*
    public XmlPullParserException(String s, Throwable thrwble) {
        super(s);
        this.detail = thrwble;
        }

    public XmlPullParserException(String s, int row, int column) {
        super(s);
        this.row = row;
        this.column = column;
    }
    */

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:11.948 -0500", hash_original_method = "28FAE29CB2E621B52838DE3161E10D49", hash_generated_method = "225A30E3BA9CB0EA3FC879A52A6B5E1B")
    
public XmlPullParserException(String msg, XmlPullParser parser, Throwable chain) {
        super ((msg == null ? "" : msg+" ")
               + (parser == null ? "" : "(position:"+parser.getPositionDescription()+") ")
               + (chain == null ? "" : "caused by: "+chain));

        if (parser != null) {
            this.row = parser.getLineNumber();
            this.column = parser.getColumnNumber();
        }
        this.detail = chain;
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:11.951 -0500", hash_original_method = "94BA5080D380911C58CAC3733D4C69AF", hash_generated_method = "05579720176758580DEFBDEEBD5A79BE")
    
public Throwable getDetail() { return detail; }
    //    public void setDetail(Throwable cause) { this.detail = cause; }
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:11.953 -0500", hash_original_method = "0760FB4E162E5971E2E765B2D1FE0093", hash_generated_method = "F05B9A70C1A3CCB97B11F679BF5D30B0")
    
public int getLineNumber() { return row; }
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:11.956 -0500", hash_original_method = "52272B3AE5723072E22E93854866B927", hash_generated_method = "BEB017487A76AB3AC679B50BE70C3FAB")
    
public int getColumnNumber() { return column; }

    /*
    public String getMessage() {
        if(detail == null)
            return super.getMessage();
        else
            return super.getMessage() + "; nested exception is: \n\t"
                + detail.getMessage();
    }
    */

    //NOTE: code that prints this and detail is difficult in J2ME
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:11.959 -0500", hash_original_method = "5154476310B69FA819C717F88BC0BDF0", hash_generated_method = "66964249575538104583078C803F14FE")
    
public void printStackTrace() {
        if (detail == null) {
            super.printStackTrace();
        } else {
            synchronized(System.err) {
                System.err.println(super.getMessage() + "; nested exception is:");
                detail.printStackTrace();
            }
        }
    }
    
}

