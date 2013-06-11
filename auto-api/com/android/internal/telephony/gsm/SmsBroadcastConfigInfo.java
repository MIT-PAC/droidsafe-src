package com.android.internal.telephony.gsm;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;


public final class SmsBroadcastConfigInfo {
    private int fromServiceId;
    private int toServiceId;
    private int fromCodeScheme;
    private int toCodeScheme;
    private boolean selected;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.994 -0400", hash_original_method = "9D05E73016D00F2A428351060541CD33", hash_generated_method = "32C710E79664662ED349B1A719D44AF7")
    @DSModeled(DSC.SAFE)
    public SmsBroadcastConfigInfo(int fromId, int toId, int fromScheme,
            int toScheme, boolean selected) {
        dsTaint.addTaint(fromId);
        dsTaint.addTaint(toScheme);
        dsTaint.addTaint(selected);
        dsTaint.addTaint(fromScheme);
        dsTaint.addTaint(toId);
        // ---------- Original Method ----------
        //fromServiceId = fromId;
        //toServiceId = toId;
        //fromCodeScheme = fromScheme;
        //toCodeScheme = toScheme;
        //this.selected = selected;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.994 -0400", hash_original_method = "EC03A9EAB74ED9CD08C5E767148A9E3D", hash_generated_method = "521ABE16A5CFE98F8D1183A1FF1CEF18")
    @DSModeled(DSC.SAFE)
    public void setFromServiceId(int fromServiceId) {
        dsTaint.addTaint(fromServiceId);
        // ---------- Original Method ----------
        //this.fromServiceId = fromServiceId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.994 -0400", hash_original_method = "000CFE123E4AC86430B83F6EA13C644C", hash_generated_method = "2464543645B1BA2635A396DE97537C47")
    @DSModeled(DSC.SAFE)
    public int getFromServiceId() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return fromServiceId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.995 -0400", hash_original_method = "C662FD0745B0F3A8663C07D8F01AF54F", hash_generated_method = "A48E508141BA42B067F38319D983DF71")
    @DSModeled(DSC.SAFE)
    public void setToServiceId(int toServiceId) {
        dsTaint.addTaint(toServiceId);
        // ---------- Original Method ----------
        //this.toServiceId = toServiceId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.995 -0400", hash_original_method = "708E088605DA57A3DA16BEEB2BE47BA2", hash_generated_method = "B6E8268082AC3A4C1AB865E2022476AC")
    @DSModeled(DSC.SAFE)
    public int getToServiceId() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return toServiceId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.995 -0400", hash_original_method = "0A2734671D04AE4B45C1C1B3377422E5", hash_generated_method = "8F63C4486B87EAB181725E32AD0FDD32")
    @DSModeled(DSC.SAFE)
    public void setFromCodeScheme(int fromCodeScheme) {
        dsTaint.addTaint(fromCodeScheme);
        // ---------- Original Method ----------
        //this.fromCodeScheme = fromCodeScheme;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.995 -0400", hash_original_method = "7AEC5FB7E81910AF5A7A8C716EA8E7A5", hash_generated_method = "800699A1D5AA90CC53E34872F6188E7B")
    @DSModeled(DSC.SAFE)
    public int getFromCodeScheme() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return fromCodeScheme;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.995 -0400", hash_original_method = "33ACE8C1E6B66F0AD44209B7329819FD", hash_generated_method = "5D23D42B616135F3AF52F1A0F46D8927")
    @DSModeled(DSC.SAFE)
    public void setToCodeScheme(int toCodeScheme) {
        dsTaint.addTaint(toCodeScheme);
        // ---------- Original Method ----------
        //this.toCodeScheme = toCodeScheme;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.995 -0400", hash_original_method = "70F3C47437BA22E7BE36EFF6F1AA8F5B", hash_generated_method = "0B049E5507B8DA798A2EEC64FA9E4AF3")
    @DSModeled(DSC.SAFE)
    public int getToCodeScheme() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return toCodeScheme;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.995 -0400", hash_original_method = "F22B16E73947604A26216421AD1B5C38", hash_generated_method = "3F2D25995620EF13DFD8D327AB5372FE")
    @DSModeled(DSC.SAFE)
    public void setSelected(boolean selected) {
        dsTaint.addTaint(selected);
        // ---------- Original Method ----------
        //this.selected = selected;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.995 -0400", hash_original_method = "4072656BD90ABB561422ECCC238321A3", hash_generated_method = "E2F8E94ACDB7CE780BA2FC6993971171")
    @DSModeled(DSC.SAFE)
    public boolean isSelected() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return selected;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.995 -0400", hash_original_method = "7023ED8B006DA79CC4837559B31EDFCC", hash_generated_method = "05346FF296A0E3BA37A174B0358B2639")
    @DSModeled(DSC.SAFE)
    @Override
    public String toString() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return "SmsBroadcastConfigInfo: Id [" +
                //fromServiceId + ',' + toServiceId + "] Code [" +
                //fromCodeScheme + ',' + toCodeScheme + "] " +
            //(selected ? "ENABLED" : "DISABLED");
    }

    
}


