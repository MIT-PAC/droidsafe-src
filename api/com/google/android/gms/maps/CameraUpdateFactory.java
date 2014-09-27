package com.google.android.gms.maps;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.RuntimeRemoteException;

import android.os.RemoteException;
import android.graphics.Point;

public final class CameraUpdateFactory
{

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:49.975 -0400", hash_original_method = "FEA1E9259A24896DB98333182FE700BA", hash_generated_method = "5E8C3D7E130F9F53090A656D6FE46BB4")
    
public static CameraUpdate zoomIn() throws Throwable
    {

        CameraUpdate r6;
        RuntimeRemoteException r7;
        Throwable r8;
        try
        {
            r6 = new CameraUpdate(DSOnlyType.DONTCARE, DSUtils.FAKE_INT);
        }
        catch (RemoteException $r4)
        {
            r7 = new RuntimeRemoteException($r4);
            r8 = (Throwable) r7;
            throw r8;
        }

        return r6;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:49.980 -0400", hash_original_method = "C3B638B842BA7F1500E54C8293AE13D1", hash_generated_method = "B319FE0BC7CCD2AC57F28E23C2264EE3")
    
public static CameraUpdate zoomOut() throws Throwable
    {

        CameraUpdate r6;
        RuntimeRemoteException r7;
        Throwable r8;
        try
        {
            r6 = new CameraUpdate(DSOnlyType.DONTCARE, DSUtils.FAKE_INT);
        }
        catch (RemoteException $r4)
        {
            r7 = new RuntimeRemoteException($r4);
            r8 = (Throwable) r7;
            throw r8;
        }

        return r6;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:49.986 -0400", hash_original_method = "BE4483F7DD7E248E8171262741A546A4", hash_generated_method = "B754AB442F9D2CA67DB539F7DCECE8FB")
    
public static CameraUpdate scrollBy(float  f0, float  f1) throws Throwable
    {

        CameraUpdate r6;
        RuntimeRemoteException r7;
        Throwable r8;
        try
        {
            r6 = new CameraUpdate(DSOnlyType.DONTCARE, (f0 + f1));
        }
        catch (RemoteException $r4)
        {
            r7 = new RuntimeRemoteException($r4);
            r8 = (Throwable) r7;
            throw r8;
        }

        return r6;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:49.990 -0400", hash_original_method = "E9160BEA7A421979A82E3077FDBFAC5B", hash_generated_method = "F510F5BBFE2FCE57A98AEDDF93E46473")
    
public static CameraUpdate zoomTo(float  f0) throws Throwable
    {

        CameraUpdate r6;
        RuntimeRemoteException r7;
        Throwable r8;
        try
        {
            r6 = new CameraUpdate(DSOnlyType.DONTCARE, DSUtils.FAKE_INT);
        }
        catch (RemoteException $r4)
        {
            r7 = new RuntimeRemoteException($r4);
            r8 = (Throwable) r7;
            throw r8;
        }

        return r6;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:49.996 -0400", hash_original_method = "E8FE5C37B98B81A0EF35BE9A8FED48CE", hash_generated_method = "BCF98E9B03BD264F412719BE6B89A594")
    
public static CameraUpdate zoomBy(float  f0) throws Throwable
    {

        CameraUpdate r6;
        RuntimeRemoteException r7;
        Throwable r8;
        try
        {
            r6 = new CameraUpdate(DSOnlyType.DONTCARE, f0);
        }
        catch (RemoteException $r4)
        {
            r7 = new RuntimeRemoteException($r4);
            r8 = (Throwable) r7;
            throw r8;
        }

        return r6;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:50.001 -0400", hash_original_method = "2DD20807531EDB796C0691DA1C3A84AF", hash_generated_method = "6482E9FDCBE52935F1C13A39865A9DFC")
    
public static CameraUpdate zoomBy(float  f0, Point  r0) throws Throwable
    {

        CameraUpdate r7;
        RuntimeRemoteException r8;
        Throwable r9;
        try
        {
            r7 = new CameraUpdate(DSOnlyType.DONTCARE, f0 + r0.hashCode());
        }
        catch (RemoteException $r5)
        {
            r8 = new RuntimeRemoteException($r5);
            r9 = (Throwable) r8;
            throw r9;
        }

        return r7;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:50.006 -0400", hash_original_method = "84DDA912A7FEA58F6653094CD17F81C0", hash_generated_method = "8674B1D15E059E9069F1746B1D99853C")
    
public static CameraUpdate newCameraPosition(CameraPosition  r0) throws Throwable
    {

        CameraUpdate r7;
        RuntimeRemoteException r8;
        Throwable r9;
        try
        {
            r7 = new CameraUpdate(DSOnlyType.DONTCARE, r0.hashCode());
        }
        catch (RemoteException $r5)
        {
            r8 = new RuntimeRemoteException($r5);
            r9 = (Throwable) r8;
            throw r9;
        }

        return r7;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:50.010 -0400", hash_original_method = "4C5AF3F6B0707A1DE86F2B4DE23847CB", hash_generated_method = "67AA4310E9853C12B6AE9A0154ED774E")
    
public static CameraUpdate newLatLng(LatLng  r0) throws Throwable
    {

        CameraUpdate r7;
        RuntimeRemoteException r8;
        Throwable r9;
        try
        {
            r7 = new CameraUpdate(DSOnlyType.DONTCARE, r0.hashCode());
        }
        catch (RemoteException $r5)
        {
            r8 = new RuntimeRemoteException($r5);
            r9 = (Throwable) r8;
            throw r9;
        }

        return r7;
    }

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:50.015 -0400", hash_original_method = "2233E29C76C22C8D19761B33B2B194CB", hash_generated_method = "0D01CAA3B5442667C4E1E1A24B6B22AF")
    
public static CameraUpdate newLatLngZoom(LatLng  r0, float  f0) throws Throwable
    {

        CameraUpdate r7;
        RuntimeRemoteException r8;
        Throwable r9;
        try
        {
            r7 = new CameraUpdate(DSOnlyType.DONTCARE, (int)(r0.hashCode() + f0));
        }
        catch (RemoteException $r5)
        {
            r8 = new RuntimeRemoteException($r5);
            r9 = (Throwable) r8;
            throw r9;
        }

        return r7;
    }

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:50.021 -0400", hash_original_method = "572FBA5CF3B8608ADA812354B253FC38", hash_generated_method = "0B3C02E6783DA5FC2690FFCB16ABEA30")
    
public static CameraUpdate newLatLngBounds(LatLngBounds  r0, int  i0) throws Throwable
    {

        CameraUpdate r7;
        RuntimeRemoteException r8;
        Throwable r9;
        try
        {
            r7 = new CameraUpdate(DSOnlyType.DONTCARE, (r0.hashCode() + i0)); 
        }
        catch (RemoteException $r5)
        {
            r8 = new RuntimeRemoteException($r5);
            r9 = (Throwable) r8;
            throw r9;
        }

        return r7;
    }

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:50.027 -0400", hash_original_method = "6041EB07D67055899AA16B5BD2B91DF0", hash_generated_method = "BEC57287B4769FB60E92B00DC3580D43")
    
public static CameraUpdate newLatLngBounds(LatLngBounds  r0, int  i0, int  i1, int  i2) throws Throwable
    {

        CameraUpdate r7;
        RuntimeRemoteException r8;
        Throwable r9;
        try
        {
            r7 = new CameraUpdate(DSOnlyType.DONTCARE, (r0.hashCode() + i0 + i1 + i2));
        }
        catch (RemoteException $r5)
        {
            r8 = new RuntimeRemoteException($r5);
            r9 = (Throwable) r8;
            throw r9;
        }

        return r7;
    }
}
