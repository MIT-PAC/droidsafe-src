package com.android.internal.telephony;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class IccIoResult {
    public int sw1;
    public int sw2;
    public byte[] payload;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.343 -0400", hash_original_method = "FC114C268C65B1E20AA18C3590A39E31", hash_generated_method = "4B81C39DFC693AAEE7EDD08CC6D37E4B")
    @DSModeled(DSC.SAFE)
    public IccIoResult(int sw1, int sw2, byte[] payload) {
        dsTaint.addTaint(payload[0]);
        dsTaint.addTaint(sw2);
        dsTaint.addTaint(sw1);
        // ---------- Original Method ----------
        //this.sw1 = sw1;
        //this.sw2 = sw2;
        //this.payload = payload;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.344 -0400", hash_original_method = "ECAE0DFB5EB8DE1F7EC625CCCC39CE4E", hash_generated_method = "2DCB326CBDDB6564C3D291863D032370")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public IccIoResult(int sw1, int sw2, String hexString) {
        this(sw1, sw2, IccUtils.hexStringToBytes(hexString));
        dsTaint.addTaint(hexString);
        dsTaint.addTaint(sw2);
        dsTaint.addTaint(sw1);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.344 -0400", hash_original_method = "C2E2D21A49FBAEB09CAD48E279230B17", hash_generated_method = "B5DB56E52803F708B0C6C58827DFDB0D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String toString() {
        String var46A4DC3931BB00EDBC192035FB3AFDBA_1348692608 = ("IccIoResponse sw1:0x" + Integer.toHexString(sw1) + " sw2:0x"
                + Integer.toHexString(sw2));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return "IccIoResponse sw1:0x" + Integer.toHexString(sw1) + " sw2:0x"
                //+ Integer.toHexString(sw2);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.344 -0400", hash_original_method = "E45E4CA02C1498571B14F8EF02CBA542", hash_generated_method = "0E37C667CC2BC770FE8AABFE4D44493D")
    @DSModeled(DSC.SAFE)
    public boolean success() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return sw1 == 0x90 || sw1 == 0x91 || sw1 == 0x9e || sw1 == 0x9f;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.344 -0400", hash_original_method = "6314A49369EA2E2C83A84515E57327FB", hash_generated_method = "B1B2226A821EE6769E353CEEC78869B1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public IccException getException() {
        {
            boolean var18DA1CA4961A92F50E39298FDC380586_705327846 = (success());
        } //End collapsed parenthetic
        //Begin case 0x94 
        {
            IccException varCCFA8E1A60A87D781643EA06D18F5A31_962089197 = (new IccFileTypeMismatch());
        } //End block
        {
            IccException var5A869221EC4894A28B6AB5184F929B60_125828578 = (new IccFileNotFound());
        } //End block
        //End case 0x94 
        //Begin case default 
        IccException var10F784D5760A25DB4F9CF482CAC59CBE_561681560 = (new IccException("sw1:" + sw1 + " sw2:" + sw2));
        //End case default 
        return (IccException)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (success()) return null;
        //switch (sw1) {
            //case 0x94:
                //if (sw2 == 0x08) {
                    //return new IccFileTypeMismatch();
                //} else {
                    //return new IccFileNotFound();
                //}
            //default:
                //return new IccException("sw1:" + sw1 + " sw2:" + sw2);
        //}
    }

    
}

