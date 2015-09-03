/*
 * Copyright (C) 2015,  Massachusetts Institute of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the
 * Free Software Foundation; either version 2 of the License, or (at your
 * option) any later version.
 * 
 * This program is distributed in the hope that it will be useful, but 
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * for more details.
 * 
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc., 
 * 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 * 
 * Please email droidsafe@lists.csail.mit.edu if you need additional
 * information or have any questions.
 */

package com.google.android.gms.drive.widget;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.widget.BaseAdapter;
import android.content.Context;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import com.google.android.gms.common.data.DataBuffer;
import java.util.Iterator;
import android.database.CursorIndexOutOfBoundsException;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.view.LayoutInflater;
import android.util.Log;

public class DataBufferAdapter extends BaseAdapter
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:49.503 -0400", hash_original_field = "B997E37019471EC8FC5B98148C7A8AD7", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private  Context mContext;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:49.508 -0400", hash_original_field = "7F8A0EB7077E8EA4CC1D1DB417B35292", hash_generated_field = "C86710B3E03CCF8101D1B83263913896")

    private  int LR;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:49.511 -0400", hash_original_field = "C2E1C43EBFB617CA56A06DAD375392BD", hash_generated_field = "BD9BB4C172F2D693516771A4EE44DBE8")

    private int LS;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:49.515 -0400", hash_original_field = "99BFDC838A17BDC1F6E3F18FF62BDFCA", hash_generated_field = "3DE5136F529AB9A0648A79BE0A15B673")

    private  int LT;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:49.518 -0400", hash_original_field = "7621A2325FDE36E8BEAB7757CBF022DD", hash_generated_field = "117D9082D6DAD42B3742AC98AC504767")

    private  List LU;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:49.522 -0400", hash_original_field = "F5C6F747D2B06396C799180AF765BF78", hash_generated_field = "74DCDFA5D96C5D8FBEA702172D144CCB")

    private  LayoutInflater LV;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:49.525 -0400", hash_original_field = "36799F0EA74AFFFDA21A24EE72EE1682", hash_generated_field = "299BBDF70A69EF58B89819BFB6DAEF8F")

    private boolean LW;

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:49.530 -0400", hash_original_method = "B05791820C0F2D2A52F1C20A1D621FE2", hash_generated_method = "DBBA3BF3D4172FC22B6865AA3232C610")
    
public DataBufferAdapter(Context  r1, int  i0, int  i1, List  r2)
    {

        LW = true;
        mContext = r1;
        LS = i0;
        LR = i0;
        LT = i1;
        LU = r2;
        LV = (LayoutInflater) r1.getSystemService("layout_inflater");
    }

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:49.535 -0400", hash_original_method = "F55FA2383A3E40E4459A4629E6952A18", hash_generated_method = "AADA380188B8D2419BF0009BFDBB77CB")
    
public DataBufferAdapter(Context  r1, int  i0, int  i1)
    {
        this(r1, i0, i1, new ArrayList());

        this.mContext = null;
        this.LR = 0;
        this.LT = 0;
        this.LU = null;
        this.LV = null;
    }

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:49.539 -0400", hash_original_method = "ED46DE6DE1587F192A92C530B6B97DB2", hash_generated_method = "D8505903D40AAD8723638DAEACB91ACE")
    
public DataBufferAdapter(Context  r1, int  i0, List  r2)
    {
        this(r1, i0, 0, r2);

        this.mContext = null;
        this.LR = 0;
        this.LT = 0;
        this.LU = null;
        this.LV = null;
    }

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:49.545 -0400", hash_original_method = "10CF3668BA1397468C9BE12AF6669FB9", hash_generated_method = "CC8365A023674B14836290508FDB3D62")
    
public DataBufferAdapter(Context  r1, int  i0)
    {
        this(r1, i0, 0, new ArrayList());

        this.mContext = null;
        this.LR = 0;
        this.LT = 0;
        this.LU = null;
        this.LV = null;
    }

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:49.550 -0400", hash_original_method = "B8355918EAD5E10F47C4CFD264DE8431", hash_generated_method = "1E40D745CE3CA7A7F4F8D559B9AD244E")
    
public DataBufferAdapter(Context  r1, int  i0, int  i1, DataBuffer[]  r2)
    {
        this(r1, i0, i1, Arrays.asList(r2));

        this.mContext = null;
        this.LR = 0;
        this.LT = 0;
        this.LU = null;
        this.LV = null;
    }

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:49.554 -0400", hash_original_method = "F582E6520CE25D99669A361F6333B865", hash_generated_method = "BE873B4032EDCB588111F8293A60E2E4")
    
public DataBufferAdapter(Context  r1, int  i0, DataBuffer[]  r2)
    {
        this(r1, i0, 0, Arrays.asList(r2));

        this.mContext = null;
        this.LR = 0;
        this.LT = 0;
        this.LU = null;
        this.LV = null;
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:49.557 -0400", hash_original_method = "AD4DF83DE92D9CD449F4F0B0A8006189", hash_generated_method = "04675B154620A48FFCB9420D9C59F84C")
    
public void append(DataBuffer  r1)
    {

        LU.add(r1);

        if (LW)
        {
            this.notifyDataSetChanged();
        }
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:49.562 -0400", hash_original_method = "3E4801BA7E37546C296353C9FD28009C", hash_generated_method = "2224F52B9031D621DEC16E59441543AB")
    
public void clear()
    {

        Iterator r1;
        DataBuffer r2;
        r1 = LU.iterator();

        while (r1.hasNext())
        {
            r2 = (DataBuffer) r1.next();
            r2.close();
        }

        LU.clear();

        if (LW)
        {
            this.notifyDataSetChanged();
        }
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:49.566 -0400", hash_original_method = "5D3FE53CD63696029740B9C7BBD9A29E", hash_generated_method = "E3DACA7BC2A6C9044D068A996474E547")
    
public void notifyDataSetChanged()
    {

        this.notifyDataSetChanged();
        LW = true;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:49.570 -0400", hash_original_method = "4A872EA515854C7E66ECBE06168BC1D2", hash_generated_method = "1FAD66E4286C15AF7CE4713D832897D0")
    
public void setNotifyOnChange(boolean  z0)
    {

        LW = z0;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:49.573 -0400", hash_original_method = "4F4EBC54D108D66F416C93B46580E117", hash_generated_method = "BA026F6873AF9B17E96AB49AFB6CEE03")
    
public Context getContext()
    {

        return mContext;
    }

    @DSSource({DSSourceKind.DATABASE})
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:49.577 -0400", hash_original_method = "65BD61761E4E2925D75936086459838F", hash_generated_method = "8FF634C97FFA366B2A6FD50D52C71ADB")
    
public int getCount()
    {

        int i0;
        Iterator r1;
        DataBuffer r2;
        for (i0 = 0 , r1 = LU.iterator(); r1.hasNext(); i0 = i0 + r2.getCount())
        {
            r2 = (DataBuffer) r1.next();
        }

        return i0;
    }

    @DSSource({DSSourceKind.DATABASE_INFORMATION})
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:49.582 -0400", hash_original_method = "23EA664A10DEDD5FFC56AFAFD75D95C6", hash_generated_method = "1B17C607B207FB15B2192B63933B4B4D")
    
public Object getItem(int  i0) throws android.database.CursorIndexOutOfBoundsException
    {

        int i1, i2;
        Iterator r1;
        DataBuffer r2;
        Object $r6;
        for (i1 = i0 , r1 = LU.iterator(); r1.hasNext(); i1 = i1 - i2)
        {
            r2 = (DataBuffer) r1.next();
            i2 = r2.getCount();

            if (i2 > i1)
            {
                $r6 = r2.get(i1);

                return $r6;
            }

        }

        throw new CursorIndexOutOfBoundsException(i0, this.getCount());
    }

    @DSSource({DSSourceKind.DATABASE})
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:49.586 -0400", hash_original_method = "680BCDE07EC38134C41F09798364548A", hash_generated_method = "42D13A05946A243693FC1402B05AEF47")
    
public long getItemId(int  i0)
    {

        return (long) i0;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:49.592 -0400", hash_original_method = "85FB22C28CF5F2AC3EB82D955B121B15", hash_generated_method = "7B6D14B74CFDA358B0E84A71814214F0")
    
private View a(int  i0, View  r1, ViewGroup  r2, int  i1)
    {

        View r3;
        TextView r4;
        Object r10;
        if (r1 != null)
        {
            r3 = r1;
        }
        else
        {
            r3 = LV.inflate(i1, r2, false);
        }

        if (LT != 0)
        {
            r4 = (TextView) r3.findViewById(LT);
        }
        else
        {
            r4 = (TextView) r3;
        }

        r10 = this.getItem(i0);

        if ( ! (r10 instanceof CharSequence))
        {
            r4.setText(r10.toString());
        }
        else
        {
            r4.setText((CharSequence) r10);
        }

        return r3;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:49.596 -0400", hash_original_method = "C504C7C2DA2504C1080738D93F8BCC68", hash_generated_method = "8E86602D3B2DA3E75B98A697FF67B65B")
    
public View getView(int  i0, View  r1, ViewGroup  r2)
    {

        return this.a(i0, r1, r2, LR);
    }

    @DSSource({DSSourceKind.DATABASE})
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:49.600 -0400", hash_original_method = "E78BF4A16CE324ED28F4ABB354455F58", hash_generated_method = "A69606443145F79A19AF1EBBBAA4C526")
    
public View getDropDownView(int  i0, View  r1, ViewGroup  r2)
    {

        return this.a(i0, r1, r2, LS);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:49.604 -0400", hash_original_method = "788BBBBC8C3982BB4AF59913A8913F3A", hash_generated_method = "1347211C8983B9AA8FF1868F189DA30E")
    
public void setDropDownViewResource(int  i0)
    {

        LS = i0;
    }
}
