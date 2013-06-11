package org.xmlpull.v1;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;


public class XmlPullParserException extends Exception {
    protected Throwable detail;
    protected int row = -1;
    protected int column = -1;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.151 -0400", hash_original_method = "81C346207A813FD28C849879E7041B6E", hash_generated_method = "B42F88DA028DEDBFCC532200244D4DCF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public XmlPullParserException(String s) {
        super(s);
        dsTaint.addTaint(s);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.151 -0400", hash_original_method = "28FAE29CB2E621B52838DE3161E10D49", hash_generated_method = "4B16F38D895DF3F213CF3A2929CF9791")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public XmlPullParserException(String msg, XmlPullParser parser, Throwable chain) {
        super ((msg == null ? "" : msg+" ")
               + (parser == null ? "" : "(position:"+parser.getPositionDescription()+") ")
               + (chain == null ? "" : "caused by: "+chain));
        dsTaint.addTaint(chain.dsTaint);
        dsTaint.addTaint(msg);
        dsTaint.addTaint(parser.dsTaint);
        {
            this.row = parser.getLineNumber();
            this.column = parser.getColumnNumber();
        } //End block
        // ---------- Original Method ----------
        //if (parser != null) {
            //this.row = parser.getLineNumber();
            //this.column = parser.getColumnNumber();
        //}
        //this.detail = chain;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.151 -0400", hash_original_method = "94BA5080D380911C58CAC3733D4C69AF", hash_generated_method = "590FE535B1128853E5F333AD0B2C8429")
    @DSModeled(DSC.SAFE)
    public Throwable getDetail() {
        return (Throwable)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return detail;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.151 -0400", hash_original_method = "0760FB4E162E5971E2E765B2D1FE0093", hash_generated_method = "B658CC154D32E36D6072B8EF325C91DD")
    @DSModeled(DSC.SAFE)
    public int getLineNumber() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return row;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.151 -0400", hash_original_method = "52272B3AE5723072E22E93854866B927", hash_generated_method = "C652471EF6958E3D46170DF03172DFFE")
    @DSModeled(DSC.SAFE)
    public int getColumnNumber() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return column;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.151 -0400", hash_original_method = "5154476310B69FA819C717F88BC0BDF0", hash_generated_method = "4C560DE03D3CBB83A9578BA310862547")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void printStackTrace() {
        {
            super.printStackTrace();
        } //End block
        {
            {
                System.err.println(super.getMessage() + "; nested exception is:");
                detail.printStackTrace();
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (detail == null) {
            //super.printStackTrace();
        //} else {
            //synchronized(System.err) {
                //System.err.println(super.getMessage() + "; nested exception is:");
                //detail.printStackTrace();
            //}
        //}
    }

    
}


