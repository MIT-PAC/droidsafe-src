package com.android.internal.telephony.gsm;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public final class SmsBroadcastConfigInfo {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:22.915 -0400", hash_original_field = "6CB791FB42180E76757B8CE655EA63BC", hash_generated_field = "333B1EBCCD576A11F3929B04C911A0CC")

    private int fromServiceId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:22.915 -0400", hash_original_field = "78C07AB482FAE915C24343F7756E27DF", hash_generated_field = "21D520383BDB72483F46B478E9E8442E")

    private int toServiceId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:22.915 -0400", hash_original_field = "45B1CAD460DB900C18FFF089139DC888", hash_generated_field = "1C45CBAE9BFCDDAE4B54CFFD731AE53A")

    private int fromCodeScheme;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:22.915 -0400", hash_original_field = "E65C94DD69C903E23E4B04500887A5B3", hash_generated_field = "6C4271AD3AC2111E09C7BAF5CEECEDA7")

    private int toCodeScheme;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:22.915 -0400", hash_original_field = "EF7DE3F485174FF47F061AD27D83D0EE", hash_generated_field = "63F1085A29CC1E5353801D8BBF9C9BF5")

    private boolean selected;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:22.916 -0400", hash_original_method = "9D05E73016D00F2A428351060541CD33", hash_generated_method = "24427794CEEB7051C06B777AC42D0B80")
    public  SmsBroadcastConfigInfo(int fromId, int toId, int fromScheme,
            int toScheme, boolean selected) {
        fromServiceId = fromId;
        toServiceId = toId;
        fromCodeScheme = fromScheme;
        toCodeScheme = toScheme;
        this.selected = selected;
        // ---------- Original Method ----------
        //fromServiceId = fromId;
        //toServiceId = toId;
        //fromCodeScheme = fromScheme;
        //toCodeScheme = toScheme;
        //this.selected = selected;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:22.917 -0400", hash_original_method = "EC03A9EAB74ED9CD08C5E767148A9E3D", hash_generated_method = "496707E01480A77738DBF7D33FB881B0")
    public void setFromServiceId(int fromServiceId) {
        this.fromServiceId = fromServiceId;
        // ---------- Original Method ----------
        //this.fromServiceId = fromServiceId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:22.917 -0400", hash_original_method = "000CFE123E4AC86430B83F6EA13C644C", hash_generated_method = "E8108E3408363B4F6C7D578681FB7DC6")
    public int getFromServiceId() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_384235258 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_384235258;
        // ---------- Original Method ----------
        //return fromServiceId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:22.917 -0400", hash_original_method = "C662FD0745B0F3A8663C07D8F01AF54F", hash_generated_method = "9127DC336ABDEEC77E06814D5ECDD0CD")
    public void setToServiceId(int toServiceId) {
        this.toServiceId = toServiceId;
        // ---------- Original Method ----------
        //this.toServiceId = toServiceId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:22.917 -0400", hash_original_method = "708E088605DA57A3DA16BEEB2BE47BA2", hash_generated_method = "E044F51364B026100EE1BCDA35407DD0")
    public int getToServiceId() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_731560902 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_731560902;
        // ---------- Original Method ----------
        //return toServiceId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:22.918 -0400", hash_original_method = "0A2734671D04AE4B45C1C1B3377422E5", hash_generated_method = "CC8CD577D428ADAA8EA094CC4841F1E7")
    public void setFromCodeScheme(int fromCodeScheme) {
        this.fromCodeScheme = fromCodeScheme;
        // ---------- Original Method ----------
        //this.fromCodeScheme = fromCodeScheme;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:22.918 -0400", hash_original_method = "7AEC5FB7E81910AF5A7A8C716EA8E7A5", hash_generated_method = "5E9148FA893F90673F6B5E8C71C4F000")
    public int getFromCodeScheme() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1857395998 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1857395998;
        // ---------- Original Method ----------
        //return fromCodeScheme;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:22.918 -0400", hash_original_method = "33ACE8C1E6B66F0AD44209B7329819FD", hash_generated_method = "E3018D7A149FE0867ABD4D0307C6F9A0")
    public void setToCodeScheme(int toCodeScheme) {
        this.toCodeScheme = toCodeScheme;
        // ---------- Original Method ----------
        //this.toCodeScheme = toCodeScheme;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:22.918 -0400", hash_original_method = "70F3C47437BA22E7BE36EFF6F1AA8F5B", hash_generated_method = "D3CED59A2D0B798713AC5280262A15A3")
    public int getToCodeScheme() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1101086965 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1101086965;
        // ---------- Original Method ----------
        //return toCodeScheme;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:22.918 -0400", hash_original_method = "F22B16E73947604A26216421AD1B5C38", hash_generated_method = "6A3776683D035BBD3F20B198F2F711A3")
    public void setSelected(boolean selected) {
        this.selected = selected;
        // ---------- Original Method ----------
        //this.selected = selected;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:22.919 -0400", hash_original_method = "4072656BD90ABB561422ECCC238321A3", hash_generated_method = "A38361AE039B9DE8032B5F49EB6CDE21")
    public boolean isSelected() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1524268648 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1524268648;
        // ---------- Original Method ----------
        //return selected;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:22.919 -0400", hash_original_method = "7023ED8B006DA79CC4837559B31EDFCC", hash_generated_method = "DBF0FCBAB71178DA87E4985941C691AD")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_747038900 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_747038900 = "SmsBroadcastConfigInfo: Id [" +
                fromServiceId + ',' + toServiceId + "] Code [" +
                fromCodeScheme + ',' + toCodeScheme + "] " +
            (selected ? "ENABLED" : "DISABLED");
        varB4EAC82CA7396A68D541C85D26508E83_747038900.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_747038900;
        // ---------- Original Method ----------
        //return "SmsBroadcastConfigInfo: Id [" +
                //fromServiceId + ',' + toServiceId + "] Code [" +
                //fromCodeScheme + ',' + toCodeScheme + "] " +
            //(selected ? "ENABLED" : "DISABLED");
    }

    
}

