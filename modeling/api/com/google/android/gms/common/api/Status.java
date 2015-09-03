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

package com.google.android.gms.common.api;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import android.app.PendingIntent;
import android.app.Activity;
import android.content.IntentSender.SendIntentException;
import com.google.android.gms.common.ConnectionResult;
import android.os.Parcel;

public final class Status implements Result {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:45.907 -0400", hash_original_field = "D7D76730A3D8AD32BB2CD0DA1D089479", hash_generated_field = "BFBD5E2758AFB385D5C3F9454E87DE65")

    public static  Status En;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:45.912 -0400", hash_original_field = "735985CACB003A23EEC767B5B5328A78", hash_generated_field = "B82B349B422F26AE2F839FBFF052A2F2")

    public static  Status Eo;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:45.918 -0400", hash_original_field = "31F249FF39E8463C344C2084A900BE4A", hash_generated_field = "0D3D0E92207240F15E4397D6CD2A015E")

    public static  Status Ep;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:45.924 -0400", hash_original_field = "0D7E9CF2EB30BA894E5BCC5ABC8C319D", hash_generated_field = "6FA739B783B0B737BD9EB1C2A94BB78A")

    public static  Status Eq;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:45.931 -0400", hash_original_field = "F7F25E0EA9E29CFEDE0E666B3382ABFF", hash_generated_field = "6D9AC6CB6A7BAC6B9D1D9027A6B14E1C")

    public static  Status Er;

@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:45.945 -0400", hash_original_field = "1895632691E3D0ACD93635E7B4E629BC", hash_generated_field = "D85A02ED437AD53A72DD6BC8931F0E7E")

    private  int xM;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:45.950 -0400", hash_original_field = "EB6FA11735981CE0D22EEA25EEDA5A58", hash_generated_field = "EA19679A9BC271DCE3C542A4FC964D8A")

    private  int CT;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:45.954 -0400", hash_original_field = "E0DD9AD8A646E70AADE5B968F48B6C90", hash_generated_field = "3D01C565FB026B7D5B2B0E5142EDBBDA")

    private  String Es;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:45.960 -0400", hash_original_field = "7B47F6D668EAC8B29A4C2C64F0EA44AC", hash_generated_field = "094D5D79D03F65D4515938385B22FFF9")

    private  PendingIntent mPendingIntent;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:45.967 -0400", hash_original_method = "7780670E2440F8680E3CB84807EF69FC", hash_generated_method = "7780670E2440F8680E3CB84807EF69FC")
    
Status(int  i0, int  i1, String  r1, PendingIntent  r2)
    {

        xM = i0;
        CT = i1;
        Es = r1;
        mPendingIntent = r2;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:45.972 -0400", hash_original_method = "574599ED4F621FD345967CB402CEB479", hash_generated_method = "92FE59C8F10F8F5932BCEFD31CA677BB")
    
public Status(int  i0)
    {
        this(1, i0, null, null);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:45.978 -0400", hash_original_method = "38BAEE9EC71E10F4EE7B7F3557B34A54", hash_generated_method = "DC3455601882B358B6B09BFC7695C3AF")
    
public Status(int  i0, String  r1, PendingIntent  r2)
    {
        this(1, i0, r1, r2);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:45.983 -0400", hash_original_method = "D3584B1F7CDC9C1305D4E2A5E4362AE2", hash_generated_method = "6BD1440C39D31E00486984843266E6C5")
    
public void startResolutionForResult(Activity  r1, int  i0) throws android.content.IntentSender.SendIntentException
    {

        if (this.hasResolution())
        {
            r1.startIntentSenderForResult(mPendingIntent.getIntentSender(), i0, null, 0, 0, 0);
            return;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:45.987 -0400", hash_original_method = "4E207E2B6173914DE1ED0002FA2AB6EF", hash_generated_method = "4E207E2B6173914DE1ED0002FA2AB6EF")
    
PendingIntent eQ()
    {

        return mPendingIntent;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:45.992 -0400", hash_original_method = "6F7776733252076CEA0C4D13E3008B27", hash_generated_method = "B4D759E6B60A07B78CC6194581207AC9")
    
public String getStatusMessage()
    {

        return Es;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:45.997 -0400", hash_original_method = "4085B31D8AA7B6F7F53EA4B9C215022D", hash_generated_method = "4085B31D8AA7B6F7F53EA4B9C215022D")
    
int getVersionCode()
    {

        return xM;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:46.002 -0400", hash_original_method = "0004EC8619A8F387BE7E6ED323BB3BD1", hash_generated_method = "B75E8378382FC6E040048B92671EB66D")
    
public boolean hasResolution()
    {
    	return getTaintBoolean();
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:46.006 -0400", hash_original_method = "5C8C1404976646390107527FEACE73EB", hash_generated_method = "287214D70E372F51BA469A6B67AA66D6")
    
public boolean isSuccess()
    {
    	return getTaintBoolean();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:46.011 -0400", hash_original_method = "8C95844E58F568BAA3441BA24EE96E18", hash_generated_method = "6FF1CD67E2D668072C211E2E4A0BEE4D")
    
public boolean isCanceled()
    {
    	return getTaintBoolean();

    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:46.016 -0400", hash_original_method = "98FDF5193732D0E5F6DB05064D6A2A1E", hash_generated_method = "D6EFF74B7B930EB4734C8EC60AFAB025")
    
public boolean isInterrupted()
    {
    	return getTaintBoolean();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:46.020 -0400", hash_original_method = "5B07D5545FF0C5C69D93A85752CDB8CE", hash_generated_method = "B30252E719DD3E4CAEA8F105E7F752E0")
    
public int getStatusCode()
    {

        return CT;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:46.024 -0400", hash_original_method = "EA4CBA41218F1080855FDC7F39114923", hash_generated_method = "5096182068449B15D7727E28EF8BB6CC")
    
public PendingIntent getResolution()
    {

        return mPendingIntent;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:46.028 -0400", hash_original_method = "D391776F0E39A1FB8C97B34EC216BD97", hash_generated_method = "2E27F609647BBF07251372A543D5F68E")
    
public int hashCode()
    {
    	return getTaintInt();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:46.039 -0400", hash_original_method = "FBFBA897C529A80F4EA5CF7762FEA227", hash_generated_method = "2E207CEECBE6994B4A17C5C64A20D0CA")
    
private String ex()
    {
        return Es;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:46.043 -0400", hash_original_method = "599DF267E463A4D561BCF288B0A4175C", hash_generated_method = "54E8A05F8159ED89386EA2CABED2B4BD")
    
public String toString()
    {
    	return Es;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:46.047 -0400", hash_original_method = "9E52255DBA170973F04B73ACB35BED4D", hash_generated_method = "7987C7F886BCEF6E02A6D8205804B6F2")
    
public ConnectionResult eR()
    {
        return new ConnectionResult(CT, mPendingIntent);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:46.052 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "D90463461B2A94FF94D13FDF69BB80C9")
    
public int describeContents()
    {

        return 0;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:46.057 -0400", hash_original_method = "9D516E8EFB29E363E7E91DA498EA4D40", hash_generated_method = "23C658E41D840CFBB8F480B13FE5FB8A")
    
public void writeToParcel(Parcel  r1, int  i0)
    {
    	r1.writeInt(i0 + getTaintInt());
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:46.061 -0400", hash_original_method = "5CEBF82EDEE05C8E496DA2B4EC1E0ECC", hash_generated_method = "102FD6D3751D110EC9B1924292874AF1")
    
public Status getStatus()
    {
        return this;
    }

    static
    {
        En = new Status(0);
        Eo = new Status(14);
        Ep = new Status(8);
        Eq = new Status(15);
        Er = new Status(16);
    }
}
