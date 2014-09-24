package com.google.android.gms.maps;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.RemoteException;
import android.app.Activity;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.View;

public class SupportMapFragment extends Fragment
{

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:52.408 -0400", hash_original_method = "EB7A616A150AC37F1F2E129246321BDA", hash_generated_method = "F068FA06EAC22CFFA867AB2D92ADB78F")
    
public static SupportMapFragment newInstance()
    {


        return new SupportMapFragment();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:52.412 -0400", hash_original_method = "84D8B32CE9BC4CC518566F32FECEB04D", hash_generated_method = "434B316A07FAEA6BDD0879AEB7082800")
    
public static SupportMapFragment newInstance(GoogleMapOptions  r0)
    {

        SupportMapFragment r5;
        Bundle r6;
        Parcelable r7;
        r5 = new SupportMapFragment();
        r6 = new Bundle();
        r7 = (Parcelable) r0;
        r6.putParcelable("MapOptions", r7);
        r5.setArguments(r6);
        return r5;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:52.401 -0400", hash_original_field = "44B194E898452902A9996B9A6E25675C", hash_generated_field = "CE5269A756FE474FEB6EF8A1E9FE09E1")

    private  SupportMapFragment$b aag;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:52.404 -0400", hash_original_field = "16473B2F56949AF6A49BB0FF31CE05A1", hash_generated_field = "2A243FBA6C87A6254B4FB4601B0DBF32")

    private GoogleMap ZD;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:52.416 -0400", hash_original_method = "12100C0FBB9DD81EC74A1C8DBDD528D9", hash_generated_method = "5CBE54A07E7AFD7F7B0164CBF71D5015")
    
public SupportMapFragment()
    {

        aag = new SupportMapFragment$b(this);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:52.419 -0400", hash_original_method = "48250AE51955665118633C4A4118BE7A", hash_generated_method = "38B58C6713791A067D68E67F3DFD5508")
    
protected IMapFragmentDelegate jy()
    {


        aag.jz();

        if (aag.gH() != null)
        {
            return ((SupportMapFragment$a) aag.gH()).jy();
        }

        return null;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:52.423 -0400", hash_original_method = "40D16AF3AD525A505DCF522054434A6E", hash_generated_method = "553FBC2F1B7E69328D7336D81FCFF3C0")
    
public final GoogleMap getMap()
    {

        IMapFragmentDelegate r1;
        IGoogleMapDelegate r2;
        RuntimeRemoteException r13;
        GoogleMap r14;
        Throwable r15;
        r1 = this.jy();

        if (r1 != null)
        {
            try
            {
                r2 = r1.getMap();
            }
            catch (RemoteException $r4)
            {
                r13 = new RuntimeRemoteException($r4);
                r15 = (Throwable) r13;
                throw r15;
            }

            if (r2 != null)
            {
                label_0:
                {
                    if (ZD != null && ZD.jp().asBinder() == r2.asBinder())
                    {
                        break label_0;
                    }

                    r14 = new GoogleMap(r2);
                    ZD = r14;
                } //end label_0:


                return ZD;
            }

            return null;
        }

        return null;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:52.426 -0400", hash_original_method = "4544BB8AE867CEF87144A675C62AF4C1", hash_generated_method = "63A56A471EE81CA45D754F5F038A2589")
    
public void onAttach(Activity  r1)
    {


        this.onAttach(r1);
        SupportMapFragment$b.a(aag, r1);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:52.430 -0400", hash_original_method = "C231FE0C14594E3F8DE444E03A311A01", hash_generated_method = "FC10F291F1CD8D33ECADB2E4A4440E8D")
    
public void onInflate(Activity  r1, AttributeSet  r2, Bundle  r3)
    {

        GoogleMapOptions r4;
        Bundle r9;
        Parcelable r10;
        this.onInflate(r1, r2, r3);
        SupportMapFragment$b.a(aag, r1);
        r4 = GoogleMapOptions.createFromAttributes(r1, r2);
        r9 = new Bundle();
        r10 = (Parcelable) r4;
        r9.putParcelable("MapOptions", r10);
        aag.onInflate(r1, r9, r3);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:52.433 -0400", hash_original_method = "94ADAB5E6AD569635EFC0A6F25C479B9", hash_generated_method = "29BBA21EAEA0BBFD2CF79C2A10DFCDF5")
    
public void onCreate(Bundle  r1)
    {


        this.onCreate(r1);
        aag.onCreate(r1);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:52.436 -0400", hash_original_method = "6411896216ED52E09AF2E2A47CB0E8AF", hash_generated_method = "543DB1575AE1554ED597AB75FED24853")
    
public View onCreateView(LayoutInflater  r1, ViewGroup  r2, Bundle  r3)
    {


        return aag.onCreateView(r1, r2, r3);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:52.440 -0400", hash_original_method = "6BBEE44A37CF991AE877D48CCEAA0D0E", hash_generated_method = "59251D9BF61CBA6EF4AF8D95EACF583A")
    
public void onResume()
    {


        this.onResume();
        aag.onResume();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:52.442 -0400", hash_original_method = "BC1AD295440542F8EE6CE028ACBDA805", hash_generated_method = "FA744E4BB4FE095F2F5F5048AE37B5D4")
    
public void onPause()
    {


        aag.onPause();
        this.onPause();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:52.445 -0400", hash_original_method = "07F51E8B34550A7D8E8AF72FAF1FED37", hash_generated_method = "DE15B79BFA28E80556AC462BA463085E")
    
public void onDestroyView()
    {


        aag.onDestroyView();
        this.onDestroyView();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:52.447 -0400", hash_original_method = "A128DAE7075EEFC850C0760B3BD70BD3", hash_generated_method = "BFA361BC3799A564B50B47B77F054EF5")
    
public void onDestroy()
    {


        aag.onDestroy();
        this.onDestroy();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:52.450 -0400", hash_original_method = "F2742724CCA41ABBF20EFE48F5B252E6", hash_generated_method = "CA753D19F2133290C6CDAFE81457B300")
    
public void onLowMemory()
    {


        aag.onLowMemory();
        this.onLowMemory();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:52.453 -0400", hash_original_method = "DFAD6CC9D13179CD76E32E07DFD47E7E", hash_generated_method = "F0465167A2EF95192854D938BCD47472")
    
public void onActivityCreated(Bundle  r1)
    {


        if (r1 != null)
        {
            r1.setClassLoader(SupportMapFragment.getClassLoader());
        }

        this.onActivityCreated(r1);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:52.456 -0400", hash_original_method = "7BE97E294943629FD1A3F23298A84376", hash_generated_method = "D3878409BC9E53DFDF31B1BE45E2459C")
    
public void onSaveInstanceState(Bundle  r1)
    {


        if (r1 != null)
        {
            r1.setClassLoader(SupportMapFragment.getClassLoader());
        }

        this.onSaveInstanceState(r1);
        aag.onSaveInstanceState(r1);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:52.459 -0400", hash_original_method = "D76282C62A93CE875451E21488810DB0", hash_generated_method = "F50CCF7F38312349B17D5842B9F8249E")
    
public void setArguments(Bundle  r1)
    {


        this.setArguments(r1);
    }
}
