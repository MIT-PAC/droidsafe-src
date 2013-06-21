package com.android.internal.telephony.gsm;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public final class SmsBroadcastConfigInfo {
    private int fromServiceId;
    private int toServiceId;
    private int fromCodeScheme;
    private int toCodeScheme;
    private boolean selected;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:16.877 -0400", hash_original_method = "9D05E73016D00F2A428351060541CD33", hash_generated_method = "344131F5086BA3D89B0C1C4294261E14")
    @DSModeled(DSC.SAFE)
    public SmsBroadcastConfigInfo(int fromId, int toId, int fromScheme,
            int toScheme, boolean selected) {
        dsTaint.addTaint(toScheme);
        dsTaint.addTaint(fromId);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:16.877 -0400", hash_original_method = "EC03A9EAB74ED9CD08C5E767148A9E3D", hash_generated_method = "6DE74DDB4E4F6A86D006CED620A8758A")
    @DSModeled(DSC.SAFE)
    public void setFromServiceId(int fromServiceId) {
        dsTaint.addTaint(fromServiceId);
        // ---------- Original Method ----------
        //this.fromServiceId = fromServiceId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:16.877 -0400", hash_original_method = "000CFE123E4AC86430B83F6EA13C644C", hash_generated_method = "FE041CA5A598C2AD74BCCA0598DD5E53")
    @DSModeled(DSC.SAFE)
    public int getFromServiceId() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return fromServiceId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:16.877 -0400", hash_original_method = "C662FD0745B0F3A8663C07D8F01AF54F", hash_generated_method = "8B16F741F32FC08E4834B26B59654527")
    @DSModeled(DSC.SAFE)
    public void setToServiceId(int toServiceId) {
        dsTaint.addTaint(toServiceId);
        // ---------- Original Method ----------
        //this.toServiceId = toServiceId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:16.878 -0400", hash_original_method = "708E088605DA57A3DA16BEEB2BE47BA2", hash_generated_method = "276E8B6F4D2316310C7F9391C8927B30")
    @DSModeled(DSC.SAFE)
    public int getToServiceId() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return toServiceId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:16.878 -0400", hash_original_method = "0A2734671D04AE4B45C1C1B3377422E5", hash_generated_method = "69309329DAD1B16B601A946F420A883D")
    @DSModeled(DSC.SAFE)
    public void setFromCodeScheme(int fromCodeScheme) {
        dsTaint.addTaint(fromCodeScheme);
        // ---------- Original Method ----------
        //this.fromCodeScheme = fromCodeScheme;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:16.878 -0400", hash_original_method = "7AEC5FB7E81910AF5A7A8C716EA8E7A5", hash_generated_method = "3F059ED5CB095FBC7BD560A5CCEEC3C0")
    @DSModeled(DSC.SAFE)
    public int getFromCodeScheme() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return fromCodeScheme;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:16.878 -0400", hash_original_method = "33ACE8C1E6B66F0AD44209B7329819FD", hash_generated_method = "F0CEB364DA47670859C615B2C21466D9")
    @DSModeled(DSC.SAFE)
    public void setToCodeScheme(int toCodeScheme) {
        dsTaint.addTaint(toCodeScheme);
        // ---------- Original Method ----------
        //this.toCodeScheme = toCodeScheme;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:16.878 -0400", hash_original_method = "70F3C47437BA22E7BE36EFF6F1AA8F5B", hash_generated_method = "3F10CD0DA22523ABE86CF8640258BADE")
    @DSModeled(DSC.SAFE)
    public int getToCodeScheme() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return toCodeScheme;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:16.879 -0400", hash_original_method = "F22B16E73947604A26216421AD1B5C38", hash_generated_method = "C5325F5A7A3D01BBA9CA6A9A974CC803")
    @DSModeled(DSC.SAFE)
    public void setSelected(boolean selected) {
        dsTaint.addTaint(selected);
        // ---------- Original Method ----------
        //this.selected = selected;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:16.879 -0400", hash_original_method = "4072656BD90ABB561422ECCC238321A3", hash_generated_method = "3E58E7BD73E39A5825B9AB0347B0BAD8")
    @DSModeled(DSC.SAFE)
    public boolean isSelected() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return selected;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:16.879 -0400", hash_original_method = "7023ED8B006DA79CC4837559B31EDFCC", hash_generated_method = "8D11C8C12E68C3F3E797385E07E848CF")
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

