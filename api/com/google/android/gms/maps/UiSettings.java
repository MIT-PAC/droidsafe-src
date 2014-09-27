package com.google.android.gms.maps;

import com.google.android.gms.maps.internal.IUiSettingsDelegate;
import com.google.android.gms.maps.model.RuntimeRemoteException;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.os.RemoteException;

public final class UiSettings
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:52.560 -0400", hash_original_field = "78A8BE92B2D71878BDE5C4DBBFAFE225", hash_generated_field = "72C660AEBB96BA0B3922BB16C631121A")

    private  IUiSettingsDelegate aai;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:52.563 -0400", hash_original_method = "0B40015AC064DD915C8A3480A80911C2", hash_generated_method = "0B40015AC064DD915C8A3480A80911C2")
    
UiSettings(IUiSettingsDelegate  r1)
    {

        aai = r1;
    }

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:52.566 -0400", hash_original_method = "61122D5B2E36A38D25688B9DD4C55E15", hash_generated_method = "9E93001B56CECA6F2258DFA65F672E86")
    
public void setZoomControlsEnabled(boolean  z0) throws Throwable
    {

        RuntimeRemoteException r5;
        Throwable r6;
        try
        {
            aai.setZoomControlsEnabled(z0);
        }
        catch (RemoteException $r3)
        {
            r5 = new RuntimeRemoteException($r3);
            r6 = (Throwable) r5;
            throw r6;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:52.570 -0400", hash_original_method = "1380B6D63DDDAC751C029E74CC834E5F", hash_generated_method = "AB29822D6B6BB2BCAA5DEFE3FEC359C3")
    
public void setCompassEnabled(boolean  z0) throws Throwable
    {

        RuntimeRemoteException r5;
        Throwable r6;
        try
        {
            aai.setCompassEnabled(z0);
        }
        catch (RemoteException $r3)
        {
            r5 = new RuntimeRemoteException($r3);
            r6 = (Throwable) r5;
            throw r6;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:52.573 -0400", hash_original_method = "E2B0D4C044B5F34ED7AD5C321CF5D14A", hash_generated_method = "FC7D219CB8B3C7B93C462ABA69E239F2")
    
public void setMyLocationButtonEnabled(boolean  z0) throws Throwable
    {

        RuntimeRemoteException r5;
        Throwable r6;
        try
        {
            aai.setMyLocationButtonEnabled(z0);
        }
        catch (RemoteException $r3)
        {
            r5 = new RuntimeRemoteException($r3);
            r6 = (Throwable) r5;
            throw r6;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:52.576 -0400", hash_original_method = "A011F27EA89C6BAAC2047008A4A6D7D7", hash_generated_method = "7260A9235B621A444FE379C53E1C1EF1")
    
public void setIndoorLevelPickerEnabled(boolean  z0) throws Throwable
    {

        RuntimeRemoteException r5;
        Throwable r6;
        try
        {
            aai.setIndoorLevelPickerEnabled(z0);
        }
        catch (RemoteException $r3)
        {
            r5 = new RuntimeRemoteException($r3);
            r6 = (Throwable) r5;
            throw r6;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:52.579 -0400", hash_original_method = "CB572DFAA46079FCB511FEBF7FBB459A", hash_generated_method = "59919A728C5CD0998F35114FB83B19D9")
    
public void setScrollGesturesEnabled(boolean  z0) throws Throwable
    {

        RuntimeRemoteException r5;
        Throwable r6;
        try
        {
            aai.setScrollGesturesEnabled(z0);
        }
        catch (RemoteException $r3)
        {
            r5 = new RuntimeRemoteException($r3);
            r6 = (Throwable) r5;
            throw r6;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:52.582 -0400", hash_original_method = "C62DBA1A03422C1CAC507062C6C8F7BE", hash_generated_method = "EF521385916DD6A3468A52ADB6DE1652")
    
public void setZoomGesturesEnabled(boolean  z0) throws Throwable
    {

        RuntimeRemoteException r5;
        Throwable r6;
        try
        {
            aai.setZoomGesturesEnabled(z0);
        }
        catch (RemoteException $r3)
        {
            r5 = new RuntimeRemoteException($r3);
            r6 = (Throwable) r5;
            throw r6;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:52.585 -0400", hash_original_method = "81B27CB8FF271DD591FDE58A28E3B911", hash_generated_method = "6C60F3088B98EE236666D253D3E58342")
    
public void setTiltGesturesEnabled(boolean  z0) throws Throwable
    {

        RuntimeRemoteException r5;
        Throwable r6;
        try
        {
            aai.setTiltGesturesEnabled(z0);
        }
        catch (RemoteException $r3)
        {
            r5 = new RuntimeRemoteException($r3);
            r6 = (Throwable) r5;
            throw r6;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:52.588 -0400", hash_original_method = "EA0A0EE80632B99C01469BC167C147E3", hash_generated_method = "F753CAC5D5C2DB2B4E35A2D0C5CA1816")
    
public void setRotateGesturesEnabled(boolean  z0) throws Throwable
    {

        RuntimeRemoteException r5;
        Throwable r6;
        try
        {
            aai.setRotateGesturesEnabled(z0);
        }
        catch (RemoteException $r3)
        {
            r5 = new RuntimeRemoteException($r3);
            r6 = (Throwable) r5;
            throw r6;
        }
    }

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:52.591 -0400", hash_original_method = "1FE424884862D38BD6D6EFCF7D5B8615", hash_generated_method = "72202A1C5CF9D1B3BAE746CE477D17C3")
    
public void setAllGesturesEnabled(boolean  z0) throws Throwable
    {

        RuntimeRemoteException r5;
        Throwable r6;
        try
        {
            aai.setAllGesturesEnabled(z0);
        }
        catch (RemoteException $r3)
        {
            r5 = new RuntimeRemoteException($r3);
            r6 = (Throwable) r5;
            throw r6;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:52.595 -0400", hash_original_method = "E0D44801BDC2870BC7F76F072D9DDF97", hash_generated_method = "2A6EA8D52ACD29311D30D089C3B0B470")
    
public boolean isZoomControlsEnabled() throws Throwable
    {

        boolean $z0;
        RuntimeRemoteException r5;
        Throwable r6;
        try
        {
            $z0 = aai.isZoomControlsEnabled();
        }
        catch (RemoteException $r3)
        {
            r5 = new RuntimeRemoteException($r3);
            r6 = (Throwable) r5;
            throw r6;
        }

        return $z0;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:52.598 -0400", hash_original_method = "AAF0AEFD069CDEE1C3A65BC9D08E1D21", hash_generated_method = "632A1430932A5096B5C3279F81CEEA64")
    
public boolean isCompassEnabled() throws Throwable
    {

        boolean $z0;
        RuntimeRemoteException r5;
        Throwable r6;
        try
        {
            $z0 = aai.isCompassEnabled();
        }
        catch (RemoteException $r3)
        {
            r5 = new RuntimeRemoteException($r3);
            r6 = (Throwable) r5;
            throw r6;
        }

        return $z0;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:52.601 -0400", hash_original_method = "D4EF8371DF7F33620633E5EB8E1E9355", hash_generated_method = "55D000127E1FEA02A25889D0A5A6BA84")
    
public boolean isMyLocationButtonEnabled() throws Throwable
    {

        boolean $z0;
        RuntimeRemoteException r5;
        Throwable r6;
        try
        {
            $z0 = aai.isMyLocationButtonEnabled();
        }
        catch (RemoteException $r3)
        {
            r5 = new RuntimeRemoteException($r3);
            r6 = (Throwable) r5;
            throw r6;
        }

        return $z0;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:52.604 -0400", hash_original_method = "3F28EF79A55C250028EC49AC055D60C9", hash_generated_method = "CD8E6D9E06EAEFE0E091F2DF55E62FE5")
    
public boolean isIndoorLevelPickerEnabled() throws Throwable
    {

        boolean $z0;
        RuntimeRemoteException r5;
        Throwable r6;
        try
        {
            $z0 = aai.isIndoorLevelPickerEnabled();
        }
        catch (RemoteException $r3)
        {
            r5 = new RuntimeRemoteException($r3);
            r6 = (Throwable) r5;
            throw r6;
        }

        return $z0;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:52.607 -0400", hash_original_method = "6A9BCA5D5B57F2212C59F2E045879834", hash_generated_method = "DE4D08F500F1C0AEE56C1B777F2B8F4A")
    
public boolean isScrollGesturesEnabled() throws Throwable
    {

        boolean $z0;
        RuntimeRemoteException r5;
        Throwable r6;
        try
        {
            $z0 = aai.isScrollGesturesEnabled();
        }
        catch (RemoteException $r3)
        {
            r5 = new RuntimeRemoteException($r3);
            r6 = (Throwable) r5;
            throw r6;
        }

        return $z0;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:52.610 -0400", hash_original_method = "BAA356D134AAB37C6794C334F1A93650", hash_generated_method = "578308A76B734C8691C7AFD902CD583B")
    
public boolean isZoomGesturesEnabled() throws Throwable
    {

        boolean $z0;
        RuntimeRemoteException r5;
        Throwable r6;
        try
        {
            $z0 = aai.isZoomGesturesEnabled();
        }
        catch (RemoteException $r3)
        {
            r5 = new RuntimeRemoteException($r3);
            r6 = (Throwable) r5;
            throw r6;
        }

        return $z0;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:52.614 -0400", hash_original_method = "DD09DB843C992E5ABD608CC596F9A34E", hash_generated_method = "979BAA9854DA735DE8E59F7A95200CD1")
    
public boolean isTiltGesturesEnabled() throws Throwable
    {

        boolean $z0;
        RuntimeRemoteException r5;
        Throwable r6;
        try
        {
            $z0 = aai.isTiltGesturesEnabled();
        }
        catch (RemoteException $r3)
        {
            r5 = new RuntimeRemoteException($r3);
            r6 = (Throwable) r5;
            throw r6;
        }

        return $z0;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:52.617 -0400", hash_original_method = "294A56F14DB4441D87334046D413BB2B", hash_generated_method = "2B17A7E8AA70CD36C89B76F90A792EFF")
    
public boolean isRotateGesturesEnabled() throws Throwable
    {

        boolean $z0;
        RuntimeRemoteException r5;
        Throwable r6;
        try
        {
            $z0 = aai.isRotateGesturesEnabled();
        }
        catch (RemoteException $r3)
        {
            r5 = new RuntimeRemoteException($r3);
            r6 = (Throwable) r5;
            throw r6;
        }

        return $z0;
    }
}
