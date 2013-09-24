package com.google.android.maps;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import com.android.layoutlib.bridge.MockView;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.os.Bundle;
public class MapView extends MockView {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-09-24 14:12:51.465 -0400", hash_original_method = "C1DDDF8AD9CA1EEC3B5E67629E531AD2", hash_generated_method = "6C4E0124152F338A7C858A29FF501651")
    public  MapView(Context context) {
        this(context, null);
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-09-24 14:12:51.475 -0400", hash_original_method = "E5823CA0349E1BE21D9C45B8B9FAEBBF", hash_generated_method = "438B5E50706E57CC1C063996F44C25C4")
    public  MapView(Context context, AttributeSet attrs) {
        this(context, attrs, com.android.internal.R.attr.mapViewStyle);
        addTaint(attrs.getTaint());
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-09-24 14:12:51.484 -0400", hash_original_method = "E5E0F6A0D4E2DB742AD5FA2BA02C5B13", hash_generated_method = "8F929D8F6A5E05453D841C81DB09069F")
    public  MapView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        addTaint(defStyle);
        addTaint(attrs.getTaint());
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-09-24 14:12:51.492 -0400", hash_original_method = "4D90A8F6A81B7C577FD4299468BD5EE8", hash_generated_method = "E2F595BFB7330F61E2193233D257F5B7")
    public void displayZoomControls(boolean takeFocus) {
        addTaint(takeFocus);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-09-24 14:12:51.501 -0400", hash_original_method = "99DA6572AED1EA697B60FFAC50C731F6", hash_generated_method = "E534461B69626B83F72702612575D9F0")
    public boolean canCoverCenter() {
        boolean var68934A3E9455FA72420237EB05902327_911083464 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1826188995 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1826188995;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-09-24 14:12:51.506 -0400", hash_original_method = "4CD6119A3B3D22F82C625AD32683388B", hash_generated_method = "C96AF0761186E98E9B5C92B09A0C5B11")
    public void preLoad() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-09-24 14:12:51.513 -0400", hash_original_method = "4D06F2AD85AE8C1ACFF5A523EADB8C43", hash_generated_method = "2E3859DEF078DCC0A9D5589DF75F859D")
    public int getZoomLevel() {
        int varCFCD208495D565EF66E7DFF9F98764DA_38697139 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1300134537 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1300134537;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-09-24 14:12:51.518 -0400", hash_original_method = "E913D51BA79BA9D7B2D18E849A1DE79B", hash_generated_method = "3FC154C30D4E9443FC4DCD38917C64E4")
    public void setSatellite(boolean on) {
        addTaint(on);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-09-24 14:12:51.530 -0400", hash_original_method = "DA6B74CDE69E783E9191480286E0E7EC", hash_generated_method = "2DFFC0D46C8BF11B199D30ED8BDB23B1")
    public boolean isSatellite() {
        boolean var68934A3E9455FA72420237EB05902327_1700065487 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_544381435 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_544381435;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-09-24 14:12:51.535 -0400", hash_original_method = "CA6CE52262BCAD4A6A4ECFB401810B01", hash_generated_method = "DF70BE34A35148B4E3347EA64BE4D159")
    public void setTraffic(boolean on) {
        addTaint(on);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-09-24 14:12:51.541 -0400", hash_original_method = "B05611106C1948C8566585AF47118EEF", hash_generated_method = "2847FFD0FF398CAB3DE487D5B689B907")
    public boolean isTraffic() {
        boolean var68934A3E9455FA72420237EB05902327_1888536059 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1537876706 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1537876706;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-09-24 14:12:51.546 -0400", hash_original_method = "A799338C2FD5CE6419ED3093A90CD4EE", hash_generated_method = "41493D1BF9E376C22299DB02B4E09E7F")
    public void setStreetView(boolean on) {
        addTaint(on);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-09-24 14:12:51.552 -0400", hash_original_method = "CC9F190F6E1BCAC525FD381B3B60F20F", hash_generated_method = "8DFB25906B02CA2CF864C12CDE059D25")
    public boolean isStreetView() {
        boolean var68934A3E9455FA72420237EB05902327_904685831 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_808153113 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_808153113;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-09-24 14:12:51.558 -0400", hash_original_method = "51DD7C96DA0FF2AC9CA8FF1B349676EE", hash_generated_method = "19D8C5D5DFFBAC38431A001E46EBC600")
    public int getLatitudeSpan() {
        int varCFCD208495D565EF66E7DFF9F98764DA_125406382 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1483409207 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1483409207;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-09-24 14:12:51.563 -0400", hash_original_method = "94E896409EF5620D087039BC1712BC50", hash_generated_method = "457BF8DE4FE9EAF47AA1BD27700AACDC")
    public int getLongitudeSpan() {
        int varCFCD208495D565EF66E7DFF9F98764DA_464319491 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_255869407 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_255869407;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-09-24 14:12:51.568 -0400", hash_original_method = "D35A68A298C8A6D24A6211B158875380", hash_generated_method = "F4B5A1C97A634CAE0732DAC85884F675")
    public int getMaxZoomLevel() {
        int varCFCD208495D565EF66E7DFF9F98764DA_943656674 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_109702666 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_109702666;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-09-24 14:12:51.573 -0400", hash_original_method = "74A113CCFBA442C44764DDB0A6F1DB16", hash_generated_method = "B011001C73083707B9FCDF8A7F276A94")
    public void onSaveInstanceState(Bundle state) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(state.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-09-24 14:12:51.578 -0400", hash_original_method = "42703701FA3868F2ED1BB2FB522276EB", hash_generated_method = "460F1CCCC259856F030740DD9A2B942C")
    public void onRestoreInstanceState(Bundle state) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(state.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-09-24 14:12:51.583 -0400", hash_original_method = "7FE7C69301F37F23C63B63FB2AF9273B", hash_generated_method = "4CBA838F5991A4139D1F3EDA531AB4B6")
    public View getZoomControls() {
View var540C13E9E156B687226421B24F2DF178_1698609560 =         null;
        var540C13E9E156B687226421B24F2DF178_1698609560.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1698609560;
        // ---------- Original Method ----------
        //return null;
    }

    
}

