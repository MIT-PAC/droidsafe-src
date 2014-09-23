package com.google.android.gms.internal;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.view.ViewGroup;
import android.util.AttributeSet;
import android.content.Context;
import com.google.android.gms.ads.AdSize;
import android.os.RemoteException;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.ads.purchase.InAppPurchaseListener;
import com.google.android.gms.ads.purchase.PlayStorePurchaseListener;
import com.google.android.gms.dynamic.d;
import com.google.android.gms.dynamic.e;

public final class au
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 11:06:31.946 -0400", hash_original_field = "33A3CE8B06E92A996FBE6634C6A99246", hash_generated_field = "88CCD0E7ADBF261DF68E640A43628797")

    private  bs mw;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 11:06:31.956 -0400", hash_original_field = "B5564F369C036FA54488E01C9ABE216E", hash_generated_field = "2E6B4AA6A621EA8C9178555D0812058F")

    private  ak mx;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 11:06:31.962 -0400", hash_original_field = "B8B240193F6B79191214FE03577B5A75", hash_generated_field = "94EEFBB80A6DBA95780E3A0603944624")

    private AdListener lQ;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 11:06:31.968 -0400", hash_original_field = "800D47DD256234E270856FB3FF10AADF", hash_generated_field = "77AF74564884A60C5B8B3A777546D9B3")

    private aq my;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 11:06:31.974 -0400", hash_original_field = "4567B2D3B40393D2A41FA24829AB4E90", hash_generated_field = "67109A970A4FD5A37432C322056B2DDC")

    private AdSize[] mi;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 11:06:31.990 -0400", hash_original_field = "4BBBC4B126FC1DFD3CE761A229427A12", hash_generated_field = "EDDF6BAD561526B0F6553E7FEBF08E1E")

    private String mj;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 11:06:31.996 -0400", hash_original_field = "7B4A558BCF8A523C40E5A6863DC3CF66", hash_generated_field = "F68861C70546D6C457ACD2E42D31408F")

    private String mz;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 11:06:32.002 -0400", hash_original_field = "5BAAA835C08BE41ECA1D3E3D6A3B6387", hash_generated_field = "B5760A57FE1BFE9AD6F7C1F475FD9A2A")

    private ViewGroup mA;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 11:06:32.010 -0400", hash_original_field = "61DF7B8A305871248C65960870D816F7", hash_generated_field = "96985D3AA9BB2221E60F05B2BF558B4C")

    private AppEventListener mh;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 11:06:32.016 -0400", hash_original_field = "7DC7B379A02455AB645E24FED98AFABE", hash_generated_field = "62DBF4E6306D6B308752A22415F90D1E")

    private InAppPurchaseListener mB;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 11:06:32.023 -0400", hash_original_field = "29A7E59E12AC02A8CBA5504AE29965CC", hash_generated_field = "F8698F4BF275EB8B2F07546B23E85B40")

    private PlayStorePurchaseListener mC;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 11:06:32.031 -0400", hash_original_method = "3AC6B50D7232F2CB4147B681316B8816", hash_generated_method = "DA84EE4D00F2225C5879F08E45BC7F09")
    
public au(ViewGroup  r1)
    {
        this(r1, null, false, ak.aF());

        this.mw = null;
        this.mx = null;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 11:06:32.040 -0400", hash_original_method = "476E268119CDE01155DA00EDB3F3067C", hash_generated_method = "CAA589FA233D38B0DA4AD9BFCB082B7A")
    
public au(ViewGroup  r1, AttributeSet  r2, boolean  z0)
    {
        this(r1, r2, z0, ak.aF());

        this.mw = null;
        this.mx = null;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 11:06:32.056 -0400", hash_original_method = "7294AFD07470DAF29674E9331F2B8142", hash_generated_method = "7294AFD07470DAF29674E9331F2B8142")
    
au(ViewGroup  r1, AttributeSet  r2, boolean  z0, ak  r3)
    {

        Context r5;
        ao r6;
        mw = new bs();
        mA = r1;
        mx = r3;

        if (r2 != null)
        {
            r5 = r1.getContext();

            r6 = new ao(r5, r2);
            mi = r6.f(z0);
            mj = r6.getAdUnitId();

            if (r1.isInEditMode())
            {
                et.a(r1, new al(r5, mi[0]), "Ads by Google");
                return;
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 11:06:32.064 -0400", hash_original_method = "E88F14F377A8C0904E86622083446C9C", hash_generated_method = "9E277A4B378C897D5D0111FA8E7F9589")
    
public void destroy()
    {


        try
        {
            if (my != null)
            {
                my.destroy();
            }
        }
        catch (RemoteException $r4)
        {
            eu.c("Failed to destroy AdView.", $r4);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 11:06:32.071 -0400", hash_original_method = "FF2959A9557570407343FAB58E9871DD", hash_generated_method = "72E961525EC08B0E59B82D605D7A8393")
    
public AdListener getAdListener()
    {


        return lQ;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 11:06:32.083 -0400", hash_original_method = "87D3A5676332418F0965F257E58AC8EF", hash_generated_method = "8ECEBB2F0E603DB382C2E876647CE582")
    
public AdSize getAdSize()
    {

        AdSize $r5, $r9;
        label_1:
        {
            try
            {
                if (my == null)
                {
                    break label_1;
                }

                $r5 = my.V().aG();
            }
            catch (RemoteException $r6)
            {
                eu.c("Failed to get the current AdSize.", $r6);
                break label_1;
            }

            return $r5;
        } //end label_1:


        if (mi == null)
        {
            $r9 = null;
        }
        else
        {
            $r9 = mi[0];
        }

        return $r9;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 11:06:32.089 -0400", hash_original_method = "A24E2FAA072F545C838E1191F5766AC8", hash_generated_method = "A5982D436A07F541D0C36070BFF83012")
    
public AdSize[] getAdSizes()
    {


        return mi;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 11:06:32.096 -0400", hash_original_method = "5CFC79D3E46058B5F9417CADE5AC0D36", hash_generated_method = "4098E8C8F68241A599BE262FF6310079")
    
public String getAdUnitId()
    {


        return mj;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 11:06:32.102 -0400", hash_original_method = "2DE0C58CACE87447CB4F5211A9F4BC80", hash_generated_method = "6A71BEF20D60E14847DD04BEE56BC839")
    
public AppEventListener getAppEventListener()
    {


        return mh;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 11:06:32.109 -0400", hash_original_method = "CE7CA9EDF5CFFCB101565A99026847FE", hash_generated_method = "969CEDCEF90EDAE37E4C576E0DC3730A")
    
public InAppPurchaseListener getInAppPurchaseListener()
    {


        return mB;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 11:06:32.118 -0400", hash_original_method = "BF950D85BCB4D21833A44A4C7893BFD0", hash_generated_method = "602656DCAA07A60DC6691D3BCE9538B7")
    
public void a(at  r1)
    {


        try
        {
            if (my == null)
            {
                this.aM();
            }

            if (my.a(mx.a(mA.getContext(), r1)))
            {
                mw.c(r1.aI());
            }
        }
        catch (RemoteException $r11)
        {
            eu.c("Failed to load ad.", $r11);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 11:06:32.126 -0400", hash_original_method = "9E7DDAC8BC177BB126F1D30E74B9AAB5", hash_generated_method = "4A3AB52277340B7DE802CEDE2AF1D4A5")
    
public void pause()
    {


        try
        {
            if (my != null)
            {
                my.pause();
            }
        }
        catch (RemoteException $r4)
        {
            eu.c("Failed to call pause.", $r4);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 11:06:32.134 -0400", hash_original_method = "EC77ADA54CD1DADDC9072BCFF62A7676", hash_generated_method = "D2C17B5E80BCBA05DB93B7A82850F4E0")
    
public void recordManualImpression()
    {


        try
        {
            my.ag();
        }
        catch (RemoteException $r3)
        {
            eu.c("Failed to record impression.", $r3);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 11:06:32.141 -0400", hash_original_method = "387503ECB592BAC3FCAFE46297BEA9E9", hash_generated_method = "B37FB465A9A2DAF274FE8174F056CD10")
    
public void resume()
    {


        try
        {
            if (my != null)
            {
                my.resume();
            }
        }
        catch (RemoteException $r4)
        {
            eu.c("Failed to call resume.", $r4);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 11:06:32.154 -0400", hash_original_method = "15BF94DE6DFD6408468706CDB60C7DA3", hash_generated_method = "05FC055C61A400710A915002D13EF9F8")
    
public void setAdListener(AdListener  r1)
    {

        aq $r4;
        ag $r5;
        try
        {
            lQ = r1;

            if (my != null)
            {
                $r4 = my;

                if (r1 == null)
                {
                    $r5 = null;
                }
                else
                {
                    $r5 = new ag(r1);
                }

                $r4.a($r5);
            }
        }
        catch (RemoteException $r6)
        {
            eu.c("Failed to set the AdListener.", $r6);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 11:06:32.166 -0400", hash_original_method = "8A0778C09FE387AF595998DDEB733288", hash_generated_method = "BC490C9F5C33A900AC89B40DCB964BCF")
    
public transient void setAdSizes(AdSize[]  r1)
    {


        if (mi == null)
        {
            this.a(r1);
            return;
        }

        throw new IllegalStateException("The ad size can only be set once on AdView.");
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 11:06:32.175 -0400", hash_original_method = "ABD8EBD1B3753CDA7894E470EEA4DCCA", hash_generated_method = "BBD84B908D2AE6753C79DDB4587F80A3")
    
public transient void a(AdSize[]  r1)
    {


        mi = r1;

        try
        {
            if (my != null)
            {
                my.a(new al(mA.getContext(), mi));
            }
        }
        catch (RemoteException $r9)
        {
            eu.c("Failed to set the ad size.", $r9);
        }

        mA.requestLayout();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 11:06:32.185 -0400", hash_original_method = "384F3540F91E5A9455859500FF64ABD0", hash_generated_method = "3B86CB4CD47ABB4DDC588BBEA4A5F226")
    
public void setAdUnitId(String  r1)
    {


        if (mj == null)
        {
            mj = r1;
            return;
        }

        throw new IllegalStateException("The ad unit ID can only be set once on AdView.");
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 11:06:32.197 -0400", hash_original_method = "00764475FCF9BA53267BCE1D8DF86D10", hash_generated_method = "241B9BED46104748232A5E12A94A1E7D")
    
public void setAppEventListener(AppEventListener  r1)
    {

        aq $r4;
        an $r5;
        try
        {
            mh = r1;

            if (my != null)
            {
                $r4 = my;

                if (r1 == null)
                {
                    $r5 = null;
                }
                else
                {
                    $r5 = new an(r1);
                }

                $r4.a($r5);
            }
        }
        catch (RemoteException $r6)
        {
            eu.c("Failed to set the AppEventListener.", $r6);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 11:06:32.213 -0400", hash_original_method = "D1FD4F4570F3425C4F0C2E101AA505E1", hash_generated_method = "EB8433144FD1273AD7B6E08FD6E391D3")
    
public void setInAppPurchaseListener(InAppPurchaseListener  r1)
    {

        aq $r6;
        dh $r7;
        if (mC == null)
        {
            try
            {
                mB = r1;

                if (my != null)
                {
                    $r6 = my;

                    if (r1 == null)
                    {
                        $r7 = null;
                    }
                    else
                    {
                        $r7 = new dh(r1);
                    }

                    $r6.a($r7);
                }
            }
            catch (RemoteException $r8)
            {
                eu.c("Failed to set the InAppPurchaseListener.", $r8);
            }

            return;
        }

        throw new IllegalStateException("Play store purchase parameter has already been set.");
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 11:06:32.238 -0400", hash_original_method = "E3B44E2E1CEB92BC5B9C33655DC76133", hash_generated_method = "77A0EE849B40325FB65F590C1E0AA281")
    
public void setPlayStorePurchaseParams(PlayStorePurchaseListener  r1, String  r2)
    {

        aq $r7;
        dl $r8;
        if (mB == null)
        {
            try
            {
                mC = r1;
                mz = r2;

                if (my != null)
                {
                    $r7 = my;

                    if (r1 == null)
                    {
                        $r8 = null;
                    }
                    else
                    {
                        $r8 = new dl(r1);
                    }

                    $r7.a($r8, r2);
                }
            }
            catch (RemoteException $r9)
            {
                eu.c("Failed to set the play store purchase parameter.", $r9);
            }

            return;
        }

        throw new IllegalStateException("InAppPurchaseListener has already been set.");
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 11:06:32.246 -0400", hash_original_method = "F687C7CB99B5E22EF92906497B057D24", hash_generated_method = "A93BDED4DE5B453480BE9312BFA92651")
    
private void aL()
    {

        d r1;
        label_14:
        {
            label_13:
            {
                label_12:
                {
                    try
                    {
                        r1 = my.U();

                        if (r1 != null)
                        {
                            break label_12;
                        }
                    }
                    catch (RemoteException $r6)
                    {
                        break label_13;
                    }

                    return;
                } //end label_12:


                mA.addView((View) e.e(r1));
                break label_14;
            } //end label_13:


            eu.c("Failed to get an ad frame.", $r6);
        } //end label_14:

    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 11:06:32.261 -0400", hash_original_method = "74F247820354179885F353B4899F2758", hash_generated_method = "230E891C813E045DE897453A8C3FE6D7")
    
private void aM() throws android.os.RemoteException
    {

        Context r1;
        label_16:
        {
            if (mi != null && mj != null)
            {
                break label_16;
            }

            if (my == null)
            {
                throw new IllegalStateException("The ad size and ad unit ID must be set before loadAd is called.");
            }
        } //end label_16:


        r1 = mA.getContext();
        my = ah.a(r1, new al(r1, mi), mj, mw);

        if (lQ != null)
        {
            my.a(new ag(lQ));
        }

        if (mh != null)
        {
            my.a(new an(mh));
        }

        if (mB != null)
        {
            my.a(new dh(mB));
        }

        if (mC != null)
        {
            my.a(new dl(mC), mz);
        }

        this.aL();
    }
}
