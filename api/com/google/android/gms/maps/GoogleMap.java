package com.google.android.gms.maps;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import com.google.android.gms.internal.hm;
import com.google.android.gms.maps.internal.IGoogleMapDelegate;
import com.google.android.gms.maps.model.RuntimeRemoteException;

import android.os.RemoteException;
import com.google.android.gms.dynamic.d;
import android.location.Location;
import android.graphics.Bitmap;
import com.google.android.gms.dynamic.e;

public final class GoogleMap
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:50.216 -0400", hash_original_field = "C57D9922711B0652A06DEC71EE134ECB", hash_generated_field = "863A4018BB9F04F1B819CF44BDCA6F55")

    public static final int MAP_TYPE_NONE = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:50.220 -0400", hash_original_field = "E897483F106A4876DFBA0FA7680E932A", hash_generated_field = "F43F8EF31C91A66C1E5DDE69C42593A0")

    public static final int MAP_TYPE_NORMAL = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:50.224 -0400", hash_original_field = "8041250A8EBEF0B0090674833D93C09A", hash_generated_field = "BBD36726448CE5F52702D1356293F8BD")

    public static final int MAP_TYPE_SATELLITE = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:50.228 -0400", hash_original_field = "F64C18A6E0798F6082682B6683F421E6", hash_generated_field = "905819122168777D9E59C4F63E529B6B")

    public static final int MAP_TYPE_TERRAIN = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:50.232 -0400", hash_original_field = "D568F7F1ED655DCB89DAC52ADEA944BC", hash_generated_field = "88129CEF7D3C40BBF3CBC626874CF998")

    public static final int MAP_TYPE_HYBRID = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:50.236 -0400", hash_original_field = "7F69E88E1409CB045EC270E7B65E0357", hash_generated_field = "8544DC7B3E386287E8688A8B6CB686E3")

    private  IGoogleMapDelegate YZ;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:50.241 -0400", hash_original_field = "3BBE2329614389242FBE79C653ECEE86", hash_generated_field = "6B01BAA011E0B22D2AECED306CAA9928")

    private UiSettings Za;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:50.244 -0400", hash_original_method = "109B38D631CE6FAF8A1E34C745753266", hash_generated_method = "9EBBCECEA62B2BA28BD90E41A94E5525")
    
protected GoogleMap(IGoogleMapDelegate  r1)
    {
        YZ = (IGoogleMapDelegate) hm.f(r1);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:50.248 -0400", hash_original_method = "F307DE44F2960F7558BAC336211B3D04", hash_generated_method = "F307DE44F2960F7558BAC336211B3D04")
    
IGoogleMapDelegate jp()
    {


        return YZ;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:50.252 -0400", hash_original_method = "AB115A9010D1B8CD0CFEEAACB8E296BD", hash_generated_method = "A5E5B7D8C5639F73AEF7F6DA4F6AA8AB")
    
public final CameraPosition getCameraPosition()
    {

        CameraPosition $r3;
        RuntimeRemoteException r6;
        Throwable r7;
        try
        {
            $r3 = YZ.getCameraPosition();
        }
        catch (RemoteException $r4)
        {
            r6 = new RuntimeRemoteException($r4);
            r7 = (Throwable) r6;
            throw r7;
        }

        return $r3;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:50.256 -0400", hash_original_method = "FBAC9AC5D91B7005FF7FB147F2FA39AA", hash_generated_method = "20416A9179164713F0D2C0FA56AD671F")
    
public final float getMaxZoomLevel()
    {

        float $f0;
        RuntimeRemoteException r5;
        Throwable r6;
        try
        {
            $f0 = YZ.getMaxZoomLevel();
        }
        catch (RemoteException $r3)
        {
            r5 = new RuntimeRemoteException($r3);
            r6 = (Throwable) r5;
            throw r6;
        }

        return $f0;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:50.260 -0400", hash_original_method = "76F08D96F8B0562C0252E2514B163524", hash_generated_method = "CDB671B7561D4A61F065E5CE6A3D7441")
    
public final float getMinZoomLevel()
    {

        float $f0;
        RuntimeRemoteException r5;
        Throwable r6;
        try
        {
            $f0 = YZ.getMinZoomLevel();
        }
        catch (RemoteException $r3)
        {
            r5 = new RuntimeRemoteException($r3);
            r6 = (Throwable) r5;
            throw r6;
        }

        return $f0;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:50.265 -0400", hash_original_method = "4718EC58E81F22732A9408F388E95D4F", hash_generated_method = "324D42CE382BB572542524C120A6E4DC")
    
public final void moveCamera(CameraUpdate  r1)
    {

        RuntimeRemoteException r7;
        Throwable r8;
        try
        {
            YZ.moveCamera(r1.jn());
        }
        catch (RemoteException $r5)
        {
            r7 = new RuntimeRemoteException($r5);
            r8 = (Throwable) r7;
            throw r8;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:50.269 -0400", hash_original_method = "AC11F899FE295376101FD9D196DD247C", hash_generated_method = "80EBCBD11D28E18D3B3A6D1BFC36F61F")
    
public final void animateCamera(CameraUpdate  r1)
    {

        RuntimeRemoteException r7;
        Throwable r8;
        try
        {
            YZ.animateCamera(r1.jn());
        }
        catch (RemoteException $r5)
        {
            r7 = new RuntimeRemoteException($r5);
            r8 = (Throwable) r7;
            throw r8;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:50.273 -0400", hash_original_method = "A868C8CAAA2609A6918495F073DACC2F", hash_generated_method = "3100696577DD2106BC772C45B58030AC")
    
public final void animateCamera(CameraUpdate  r1, GoogleMap$CancelableCallback  r2)
    {

        IGoogleMapDelegate $r4;
        d $r5;
        GoogleMap$a $r6, r9;
        RuntimeRemoteException r10;
        Throwable r11;
        try
        {
            $r4 = YZ;
            $r5 = r1.jn();

            if (r2 != null)
            {
                $r6 = r9;
                r9 = new GoogleMap$a(r2);
            }
            else
            {
                $r6 = null;
            }

            $r4.animateCameraWithCallback($r5, $r6);
        }
        catch (RemoteException $r7)
        {
            r10 = new RuntimeRemoteException($r7);
            r11 = (Throwable) r10;
            throw r11;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:50.279 -0400", hash_original_method = "74719CF523AAD3B8C3F8AC86A5C084FC", hash_generated_method = "73F83A08576F1E94B4E8FFD361F88335")
    
public final void animateCamera(CameraUpdate  r1, int  i0, GoogleMap$CancelableCallback  r2)
    {

        IGoogleMapDelegate $r4;
        d $r5;
        GoogleMap$a $r6, r9;
        RuntimeRemoteException r10;
        Throwable r11;
        try
        {
            $r4 = YZ;
            $r5 = r1.jn();

            if (r2 != null)
            {
                $r6 = r9;
                r9 = new GoogleMap$a(r2);
            }
            else
            {
                $r6 = null;
            }

            $r4.animateCameraWithDurationAndCallback($r5, i0, $r6);
        }
        catch (RemoteException $r7)
        {
            r10 = new RuntimeRemoteException($r7);
            r11 = (Throwable) r10;
            throw r11;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:50.284 -0400", hash_original_method = "0A8D7547603A3BF714B6760625A91A6A", hash_generated_method = "7404AE329D8102CF127FD9EB538BC7A6")
    
public final void stopAnimation()
    {

        RuntimeRemoteException r5;
        Throwable r6;
        try
        {
            YZ.stopAnimation();
        }
        catch (RemoteException $r3)
        {
            r5 = new RuntimeRemoteException($r3);
            r6 = (Throwable) r5;
            throw r6;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:50.289 -0400", hash_original_method = "FC080BD8D58112BBD298CD06823D28C4", hash_generated_method = "CBF91B83BEEDDB8950A487EC1C1EFCA0")
    
public final Polyline addPolyline(PolylineOptions  r1)
    {

        Polyline r8;
        RuntimeRemoteException r9;
        Throwable r10;
        try
        {
            r8 = new Polyline(YZ.addPolyline(r1));
        }
        catch (RemoteException $r6)
        {
            r9 = new RuntimeRemoteException($r6);
            r10 = (Throwable) r9;
            throw r10;
        }

        return r8;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:50.293 -0400", hash_original_method = "C335EF489BBBAC97393468FE1079678B", hash_generated_method = "398C1F47B6414E6148F0215F89D5293A")
    
public final Polygon addPolygon(PolygonOptions  r1)
    {

        Polygon r8;
        RuntimeRemoteException r9;
        Throwable r10;
        try
        {
            r8 = new Polygon(YZ.addPolygon(r1));
        }
        catch (RemoteException $r6)
        {
            r9 = new RuntimeRemoteException($r6);
            r10 = (Throwable) r9;
            throw r10;
        }

        return r8;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:50.299 -0400", hash_original_method = "E01905601AF7E63E56AFB8C4E0D34E4F", hash_generated_method = "D73E5DD988185843F80FF684AE7C57D0")
    
public final Circle addCircle(CircleOptions  r1)
    {

        Circle r8;
        RuntimeRemoteException r9;
        Throwable r10;
        try
        {
            r8 = new Circle(YZ.addCircle(r1));
        }
        catch (RemoteException $r6)
        {
            r9 = new RuntimeRemoteException($r6);
            r10 = (Throwable) r9;
            throw r10;
        }

        return r8;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:50.304 -0400", hash_original_method = "BAEBD3E64FF6C8B2F7743E1C33F41BAF", hash_generated_method = "C3FF9F3416485CE62296309FB907D46C")
    
public final Marker addMarker(MarkerOptions  r1)
    {

        f r2;
        Object $n0;
        Marker r8;
        RuntimeRemoteException r9;
        Throwable r10;
        label_2:
        {
            label_1:
            {
                label_0:
                {
                    try
                    {
                        r2 = YZ.addMarker(r1);

                        if (r2 == null)
                        {
                            break label_0;
                        }

                        r8 = new Marker(r2);
                    }
                    catch (RemoteException $r5)
                    {
                        break label_1;
                    }

                    return r8;
                } //end label_0:


                $n0 = null;
                break label_2;
            } //end label_1:


            r9 = new RuntimeRemoteException($r5);
            r10 = (Throwable) r9;
            throw r10;
        } //end label_2:


        return $n0;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:50.309 -0400", hash_original_method = "264891DB089CA63DA5BCEB6505435D0B", hash_generated_method = "6AC3219D8C8F195BA8115C1D4AF94246")
    
public final GroundOverlay addGroundOverlay(GroundOverlayOptions  r1)
    {

        c r2;
        Object $n0;
        GroundOverlay r8;
        RuntimeRemoteException r9;
        Throwable r10;
        label_5:
        {
            label_4:
            {
                label_3:
                {
                    try
                    {
                        r2 = YZ.addGroundOverlay(r1);

                        if (r2 == null)
                        {
                            break label_3;
                        }

                        r8 = new GroundOverlay(r2);
                    }
                    catch (RemoteException $r5)
                    {
                        break label_4;
                    }

                    return r8;
                } //end label_3:


                $n0 = null;
                break label_5;
            } //end label_4:


            r9 = new RuntimeRemoteException($r5);
            r10 = (Throwable) r9;
            throw r10;
        } //end label_5:


        return $n0;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:50.315 -0400", hash_original_method = "142A25D019AAC99721820AA7F467ACB7", hash_generated_method = "5F5796413A39FDC41DBD422B151156C7")
    
public final TileOverlay addTileOverlay(TileOverlayOptions  r1)
    {

        h r2;
        Object $n0;
        TileOverlay r8;
        RuntimeRemoteException r9;
        Throwable r10;
        label_8:
        {
            label_7:
            {
                label_6:
                {
                    try
                    {
                        r2 = YZ.addTileOverlay(r1);

                        if (r2 == null)
                        {
                            break label_6;
                        }

                        r8 = new TileOverlay(r2);
                    }
                    catch (RemoteException $r5)
                    {
                        break label_7;
                    }

                    return r8;
                } //end label_6:


                $n0 = null;
                break label_8;
            } //end label_7:


            r9 = new RuntimeRemoteException($r5);
            r10 = (Throwable) r9;
            throw r10;
        } //end label_8:


        return $n0;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:50.318 -0400", hash_original_method = "E54D76BD82C144579401EC5FB071F511", hash_generated_method = "F6C243EB622A366887C25FCFE5398018")
    
public final void clear()
    {

        RuntimeRemoteException r5;
        Throwable r6;
        try
        {
            YZ.clear();
        }
        catch (RemoteException $r3)
        {
            r5 = new RuntimeRemoteException($r3);
            r6 = (Throwable) r5;
            throw r6;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:50.324 -0400", hash_original_method = "A405BC06BA17FCC8E6521FDF8C30106D", hash_generated_method = "327AF66DB3ABFCC34867FE5135F953C4")
    
public IndoorBuilding getFocusedBuilding()
    {

        d r1;
        Object $n0;
        IndoorBuilding r7;
        RuntimeRemoteException r8;
        Throwable r9;
        label_11:
        {
            label_10:
            {
                label_9:
                {
                    try
                    {
                        r1 = YZ.getFocusedBuilding();

                        if (r1 == null)
                        {
                            break label_9;
                        }

                        r7 = new IndoorBuilding(r1);
                    }
                    catch (RemoteException $r4)
                    {
                        break label_10;
                    }

                    return r7;
                } //end label_9:


                $n0 = null;
                break label_11;
            } //end label_10:


            r8 = new RuntimeRemoteException($r4);
            r9 = (Throwable) r8;
            throw r9;
        } //end label_11:


        return $n0;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:50.329 -0400", hash_original_method = "D8091E5041EDEB5D6DB1084750604441", hash_generated_method = "808A21CC5C3727CE2701BD763DFAF8E7")
    
public final void setOnIndoorStateChangeListener(GoogleMap$OnIndoorStateChangeListener  r1)
    {

        IGoogleMapDelegate $r4;
        GoogleMap$1 r8;
        RuntimeRemoteException r9;
        Throwable r10;
        try
        {
            if (r1 != null)
            {
                $r4 = YZ;
                r8 = new GoogleMap$1(this, r1);
                $r4.setOnIndoorStateChangeListener(r8);
            }
            else
            {
                YZ.setOnIndoorStateChangeListener(null);
            }
        }
        catch (RemoteException $r6)
        {
            r9 = new RuntimeRemoteException($r6);
            r10 = (Throwable) r9;
            throw r10;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:50.333 -0400", hash_original_method = "4755FC0770357205216EE7F0C1FDC577", hash_generated_method = "DDFEFBD0DF741F292477919DFB23350C")
    
public final int getMapType()
    {

        int $i0;
        RuntimeRemoteException r5;
        Throwable r6;
        try
        {
            $i0 = YZ.getMapType();
        }
        catch (RemoteException $r3)
        {
            r5 = new RuntimeRemoteException($r3);
            r6 = (Throwable) r5;
            throw r6;
        }

        return $i0;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:50.337 -0400", hash_original_method = "FDE8807FAA05B51664098A0C3DB62DC1", hash_generated_method = "709E0DFE489155D679FB5EE3B0C48CE0")
    
public final void setMapType(int  i0)
    {

        RuntimeRemoteException r5;
        Throwable r6;
        try
        {
            YZ.setMapType(i0);
        }
        catch (RemoteException $r3)
        {
            r5 = new RuntimeRemoteException($r3);
            r6 = (Throwable) r5;
            throw r6;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:50.342 -0400", hash_original_method = "13F254882FE9AA244325E1F1824216E4", hash_generated_method = "346E95CE97D9F4582169A875B27FBBC1")
    
public final boolean isTrafficEnabled()
    {

        boolean $z0;
        RuntimeRemoteException r5;
        Throwable r6;
        try
        {
            $z0 = YZ.isTrafficEnabled();
        }
        catch (RemoteException $r3)
        {
            r5 = new RuntimeRemoteException($r3);
            r6 = (Throwable) r5;
            throw r6;
        }

        return $z0;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:50.346 -0400", hash_original_method = "FB08C1F7B42AC4F2879F7A078871E8D1", hash_generated_method = "BCDFE09D05FE966C169D8C0DAC0281E0")
    
public final void setTrafficEnabled(boolean  z0)
    {

        RuntimeRemoteException r5;
        Throwable r6;
        try
        {
            YZ.setTrafficEnabled(z0);
        }
        catch (RemoteException $r3)
        {
            r5 = new RuntimeRemoteException($r3);
            r6 = (Throwable) r5;
            throw r6;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:50.350 -0400", hash_original_method = "3EA1C467425722AC7CA5E3AE46D4AE5E", hash_generated_method = "67697061B01B2B72F0D6B2609695E5E1")
    
public final boolean isIndoorEnabled()
    {

        boolean $z0;
        RuntimeRemoteException r5;
        Throwable r6;
        try
        {
            $z0 = YZ.isIndoorEnabled();
        }
        catch (RemoteException $r3)
        {
            r5 = new RuntimeRemoteException($r3);
            r6 = (Throwable) r5;
            throw r6;
        }

        return $z0;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:50.354 -0400", hash_original_method = "736ACD9B68B48102C1E8EA3B55D34CB8", hash_generated_method = "B84371C2435D500CD2D4E9F7758CCEE9")
    
public final boolean setIndoorEnabled(boolean  z0)
    {

        boolean $z1;
        RuntimeRemoteException r5;
        Throwable r6;
        try
        {
            $z1 = YZ.setIndoorEnabled(z0);
        }
        catch (RemoteException $r3)
        {
            r5 = new RuntimeRemoteException($r3);
            r6 = (Throwable) r5;
            throw r6;
        }

        return $z1;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:50.358 -0400", hash_original_method = "7A71F10BB59CB319BA1FC4B4733BD8D0", hash_generated_method = "61D5BA71E9828A9962B99691DC19D7BB")
    
public final boolean isBuildingsEnabled()
    {

        boolean $z0;
        RuntimeRemoteException r5;
        Throwable r6;
        try
        {
            $z0 = YZ.isBuildingsEnabled();
        }
        catch (RemoteException $r3)
        {
            r5 = new RuntimeRemoteException($r3);
            r6 = (Throwable) r5;
            throw r6;
        }

        return $z0;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:50.362 -0400", hash_original_method = "CFCFF0228CD8C77FD436EF51F0B34B46", hash_generated_method = "52FFD15201661A702D8EFE0101A5B848")
    
public final void setBuildingsEnabled(boolean  z0)
    {

        RuntimeRemoteException r5;
        Throwable r6;
        try
        {
            YZ.setBuildingsEnabled(z0);
        }
        catch (RemoteException $r3)
        {
            r5 = new RuntimeRemoteException($r3);
            r6 = (Throwable) r5;
            throw r6;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:50.367 -0400", hash_original_method = "F1A8267963AD5B7D8823B6E505CF052B", hash_generated_method = "19C460F039188C72663C4AF5A838C479")
    
public final boolean isMyLocationEnabled()
    {

        boolean $z0;
        RuntimeRemoteException r5;
        Throwable r6;
        try
        {
            $z0 = YZ.isMyLocationEnabled();
        }
        catch (RemoteException $r3)
        {
            r5 = new RuntimeRemoteException($r3);
            r6 = (Throwable) r5;
            throw r6;
        }

        return $z0;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:50.371 -0400", hash_original_method = "ABDBEFC2D1449D0AA8895933128D5271", hash_generated_method = "716D2F440C1548007A225575A397E005")
    
public final void setMyLocationEnabled(boolean  z0)
    {

        RuntimeRemoteException r5;
        Throwable r6;
        try
        {
            YZ.setMyLocationEnabled(z0);
        }
        catch (RemoteException $r3)
        {
            r5 = new RuntimeRemoteException($r3);
            r6 = (Throwable) r5;
            throw r6;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:50.376 -0400", hash_original_method = "0DE75C3750335F00D5A1296F66E89702", hash_generated_method = "32D1030413AF86D21EE820D53CA23930")
    
public final Location getMyLocation()
    {

        Location $r3;
        RuntimeRemoteException r6;
        Throwable r7;
        try
        {
            $r3 = YZ.getMyLocation();
        }
        catch (RemoteException $r4)
        {
            r6 = new RuntimeRemoteException($r4);
            r7 = (Throwable) r6;
            throw r7;
        }

        return $r3;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:50.381 -0400", hash_original_method = "946EC37E089D00BC34480425D8D0E0F5", hash_generated_method = "97E89430010B6AA4A066746A59160F60")
    
public final void setLocationSource(LocationSource  r1)
    {

        IGoogleMapDelegate $r4;
        GoogleMap$6 r8;
        RuntimeRemoteException r9;
        Throwable r10;
        try
        {
            if (r1 != null)
            {
                $r4 = YZ;
                r8 = new GoogleMap$6(this, r1);
                $r4.setLocationSource(r8);
            }
            else
            {
                YZ.setLocationSource(null);
            }
        }
        catch (RemoteException $r6)
        {
            r9 = new RuntimeRemoteException($r6);
            r10 = (Throwable) r9;
            throw r10;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:50.385 -0400", hash_original_method = "4C1AFEB4E643F4F1EF95BFB11F7E2E4C", hash_generated_method = "C186E95176CDD5D82A2506ABF0C91D08")
    
public final UiSettings getUiSettings()
    {

        UiSettings $r6, r9;
        RuntimeRemoteException r10;
        Throwable r11;
        try
        {
            if (Za == null)
            {
                r9 = new UiSettings(YZ.getUiSettings());
                Za = r9;
            }

            $r6 = Za;
        }
        catch (RemoteException $r7)
        {
            r10 = new RuntimeRemoteException($r7);
            r11 = (Throwable) r10;
            throw r11;
        }

        return $r6;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:50.390 -0400", hash_original_method = "CFF31B68AD16A327ACE4219640120232", hash_generated_method = "8F54AC382312C913205D47A153DC7F36")
    
public final Projection getProjection()
    {

        Projection r7;
        RuntimeRemoteException r8;
        Throwable r9;
        try
        {
            r7 = new Projection(YZ.getProjection());
        }
        catch (RemoteException $r5)
        {
            r8 = new RuntimeRemoteException($r5);
            r9 = (Throwable) r8;
            throw r9;
        }

        return r7;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:50.394 -0400", hash_original_method = "6B1136EE4A01B1EBBA16144825A1F2C7", hash_generated_method = "93F585E27B515B557E4A581DA8FB3DB4")
    
public final void setOnCameraChangeListener(GoogleMap$OnCameraChangeListener  r1)
    {

        IGoogleMapDelegate $r4;
        GoogleMap$7 r8;
        RuntimeRemoteException r9;
        Throwable r10;
        try
        {
            if (r1 != null)
            {
                $r4 = YZ;
                r8 = new GoogleMap$7(this, r1);
                $r4.setOnCameraChangeListener(r8);
            }
            else
            {
                YZ.setOnCameraChangeListener(null);
            }
        }
        catch (RemoteException $r6)
        {
            r9 = new RuntimeRemoteException($r6);
            r10 = (Throwable) r9;
            throw r10;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:50.399 -0400", hash_original_method = "5DA00B075C2AB1FC9A50A38D4F7DE47B", hash_generated_method = "76C820620716D84DEA1E1E8017C9658F")
    
public final void setOnMapClickListener(GoogleMap$OnMapClickListener  r1)
    {

        IGoogleMapDelegate $r4;
        GoogleMap$8 r8;
        RuntimeRemoteException r9;
        Throwable r10;
        try
        {
            if (r1 != null)
            {
                $r4 = YZ;
                r8 = new GoogleMap$8(this, r1);
                $r4.setOnMapClickListener(r8);
            }
            else
            {
                YZ.setOnMapClickListener(null);
            }
        }
        catch (RemoteException $r6)
        {
            r9 = new RuntimeRemoteException($r6);
            r10 = (Throwable) r9;
            throw r10;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:50.405 -0400", hash_original_method = "70141355058134C44B95A2B67BFE005F", hash_generated_method = "574B4B3F2B1B9886C7C7117BAF232ACF")
    
public final void setOnMapLongClickListener(GoogleMap$OnMapLongClickListener  r1)
    {

        IGoogleMapDelegate $r4;
        GoogleMap$9 r8;
        RuntimeRemoteException r9;
        Throwable r10;
        try
        {
            if (r1 != null)
            {
                $r4 = YZ;
                r8 = new GoogleMap$9(this, r1);
                $r4.setOnMapLongClickListener(r8);
            }
            else
            {
                YZ.setOnMapLongClickListener(null);
            }
        }
        catch (RemoteException $r6)
        {
            r9 = new RuntimeRemoteException($r6);
            r10 = (Throwable) r9;
            throw r10;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:50.409 -0400", hash_original_method = "913C7C758F2112CDC26F4F56346152D8", hash_generated_method = "646F6E7E9714F35C378D4AAB58CEC308")
    
public final void setOnMarkerClickListener(GoogleMap$OnMarkerClickListener  r1)
    {

        IGoogleMapDelegate $r4;
        GoogleMap$10 r8;
        RuntimeRemoteException r9;
        Throwable r10;
        try
        {
            if (r1 != null)
            {
                $r4 = YZ;
                r8 = new GoogleMap$10(this, r1);
                $r4.setOnMarkerClickListener(r8);
            }
            else
            {
                YZ.setOnMarkerClickListener(null);
            }
        }
        catch (RemoteException $r6)
        {
            r9 = new RuntimeRemoteException($r6);
            r10 = (Throwable) r9;
            throw r10;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:50.414 -0400", hash_original_method = "C4976A4D6084C910A860DE281910F5C6", hash_generated_method = "C2F0A9BF297785DB3039A386B27C681A")
    
public final void setOnMarkerDragListener(GoogleMap$OnMarkerDragListener  r1)
    {

        IGoogleMapDelegate $r4;
        GoogleMap$11 r8;
        RuntimeRemoteException r9;
        Throwable r10;
        try
        {
            if (r1 != null)
            {
                $r4 = YZ;
                r8 = new GoogleMap$11(this, r1);
                $r4.setOnMarkerDragListener(r8);
            }
            else
            {
                YZ.setOnMarkerDragListener(null);
            }
        }
        catch (RemoteException $r6)
        {
            r9 = new RuntimeRemoteException($r6);
            r10 = (Throwable) r9;
            throw r10;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:50.419 -0400", hash_original_method = "0406BE05D73F9D00F98605FA7DB2510B", hash_generated_method = "F56011BD67CF6516E63CE7B61544A748")
    
public final void setOnInfoWindowClickListener(GoogleMap$OnInfoWindowClickListener  r1)
    {

        IGoogleMapDelegate $r4;
        GoogleMap$12 r8;
        RuntimeRemoteException r9;
        Throwable r10;
        try
        {
            if (r1 != null)
            {
                $r4 = YZ;
                r8 = new GoogleMap$12(this, r1);
                $r4.setOnInfoWindowClickListener(r8);
            }
            else
            {
                YZ.setOnInfoWindowClickListener(null);
            }
        }
        catch (RemoteException $r6)
        {
            r9 = new RuntimeRemoteException($r6);
            r10 = (Throwable) r9;
            throw r10;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:50.424 -0400", hash_original_method = "9A15E2726E216B092118B7C01CFB79CB", hash_generated_method = "CBA28D46EB2480074C7A99CC68F51230")
    
public final void setInfoWindowAdapter(GoogleMap$InfoWindowAdapter  r1)
    {

        IGoogleMapDelegate $r4;
        GoogleMap$13 r8;
        RuntimeRemoteException r9;
        Throwable r10;
        try
        {
            if (r1 != null)
            {
                $r4 = YZ;
                r8 = new GoogleMap$13(this, r1);
                $r4.setInfoWindowAdapter(r8);
            }
            else
            {
                YZ.setInfoWindowAdapter(null);
            }
        }
        catch (RemoteException $r6)
        {
            r9 = new RuntimeRemoteException($r6);
            r10 = (Throwable) r9;
            throw r10;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:50.430 -0400", hash_original_method = "E818E0606B666BC64837EEEB36CFE5A4", hash_generated_method = "51CBBDF9038C7748B9CF6DCB7D9CED3C")
    
public final void setOnMyLocationChangeListener(GoogleMap$OnMyLocationChangeListener  r1)
    {

        IGoogleMapDelegate $r4;
        GoogleMap$2 r8;
        RuntimeRemoteException r9;
        Throwable r10;
        try
        {
            if (r1 != null)
            {
                $r4 = YZ;
                r8 = new GoogleMap$2(this, r1);
                $r4.setOnMyLocationChangeListener(r8);
            }
            else
            {
                YZ.setOnMyLocationChangeListener(null);
            }
        }
        catch (RemoteException $r6)
        {
            r9 = new RuntimeRemoteException($r6);
            r10 = (Throwable) r9;
            throw r10;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:50.434 -0400", hash_original_method = "B287A9307B0A5333DF6A3CE4C65E72F2", hash_generated_method = "FA6863EE911E7FAAA8F00020387A5DA5")
    
public final void setOnMyLocationButtonClickListener(GoogleMap$OnMyLocationButtonClickListener  r1)
    {

        IGoogleMapDelegate $r4;
        GoogleMap$3 r8;
        RuntimeRemoteException r9;
        Throwable r10;
        try
        {
            if (r1 != null)
            {
                $r4 = YZ;
                r8 = new GoogleMap$3(this, r1);
                $r4.setOnMyLocationButtonClickListener(r8);
            }
            else
            {
                YZ.setOnMyLocationButtonClickListener(null);
            }
        }
        catch (RemoteException $r6)
        {
            r9 = new RuntimeRemoteException($r6);
            r10 = (Throwable) r9;
            throw r10;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:50.439 -0400", hash_original_method = "A84859A216895B6B576FEF5465DD61A5", hash_generated_method = "FC97513391828D51149145057ABC21B9")
    
public void setOnMapLoadedCallback(GoogleMap$OnMapLoadedCallback  r1)
    {

        IGoogleMapDelegate $r4;
        GoogleMap$4 r8;
        RuntimeRemoteException r9;
        Throwable r10;
        try
        {
            if (r1 != null)
            {
                $r4 = YZ;
                r8 = new GoogleMap$4(this, r1);
                $r4.setOnMapLoadedCallback(r8);
            }
            else
            {
                YZ.setOnMapLoadedCallback(null);
            }
        }
        catch (RemoteException $r6)
        {
            r9 = new RuntimeRemoteException($r6);
            r10 = (Throwable) r9;
            throw r10;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:50.443 -0400", hash_original_method = "9A42DFBCF2211BCA92C8FC53D5C55698", hash_generated_method = "C054255492D2A5FC219A35F798A020E1")
    
public final void snapshot(GoogleMap$SnapshotReadyCallback  r1)
    {


        this.snapshot(r1, null);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:50.448 -0400", hash_original_method = "37D8122362DB6BD5C9E8B4B74C0D5B22", hash_generated_method = "8AA5DABCE7331187C45208F43FFBFA39")
    
public final void snapshot(GoogleMap$SnapshotReadyCallback  r1, Bitmap  r2)
    {

        e r3;
        d $r6;
        IGoogleMapDelegate $r8;
        GoogleMap$5 r11;
        RuntimeRemoteException r12;
        Throwable r13;
        if (r2 == null)
        {
            $r6 = null;
        }
        else
        {
            $r6 = e.h(r2);
        }

        r3 = (e) (e) $r6;

        try
        {
            $r8 = YZ;
            r11 = new GoogleMap$5(this, r1);
            $r8.snapshot(r11, r3);
        }
        catch (RemoteException $r9)
        {
            r12 = new RuntimeRemoteException($r9);
            r13 = (Throwable) r12;
            throw r13;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:50.452 -0400", hash_original_method = "1E7C40BC3688F2B26F321C8448E4A532", hash_generated_method = "609DA187C95F552A5D993305B09430B5")
    
public final void setPadding(int  i0, int  i1, int  i2, int  i3)
    {

        RuntimeRemoteException r5;
        Throwable r6;
        try
        {
            YZ.setPadding(i0, i1, i2, i3);
        }
        catch (RemoteException $r3)
        {
            r5 = new RuntimeRemoteException($r3);
            r6 = (Throwable) r5;
            throw r6;
        }
    }
}
