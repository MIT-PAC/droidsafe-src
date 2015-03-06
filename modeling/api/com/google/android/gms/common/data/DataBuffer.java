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

package com.google.android.gms.common.data;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.os.Bundle;
import java.util.Iterator;

public abstract class DataBuffer 
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 15:57:51.996 -0400", hash_original_field = "585744AAFC38F79A45E78B32053202C4", hash_generated_field = "68C30B118F02E06C695EF899DE42F485")

    protected  DataHolder DG;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 15:57:52.008 -0400", hash_original_method = "9F0F798CB6E65854E841DAFF97A44C26", hash_generated_method = "1BE0E8E43630932BB6F2B9455FEB2ACA")
    
protected DataBuffer(DataHolder  r1)
    {

        DG = r1;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 15:57:52.018 -0400", hash_original_method = "BC705CAAC812C0699163DCB69FCE4676", hash_generated_method = "09CE8794DD64B8211AA4BBEA9F613D0C")
    
public int getCount()
    {

        int $i0;
        if (DG != null)
        {
            $i0 = DG.getCount();
        }
        else
        {
            $i0 = 0;
        }

        return $i0;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 15:57:52.025 -0400", hash_original_method = "B48A8C14E07506EFDE5838D0B1F2ACE6", hash_generated_method = "B1EE38B270C68B7D0F92FC63CD929F21")
    
public abstract java.lang.Object get(int  i0);

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 15:57:52.032 -0400", hash_original_method = "20ACFA87CE2946263EF62A8878DCF4F1", hash_generated_method = "F9C2A05D39AB4CA519CEE1CEB34C488C")
    
public final void close()
    {
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 15:57:52.041 -0400", hash_original_method = "D0502577824545DB1CEA13531EDE50BF", hash_generated_method = "EAE3FE11346291C5BFB5C7CE3A3C47D0")
    
public boolean isClosed()
    {
        boolean $z0;
        if (DG != null)
        {
            $z0 = DG.isClosed();
        }
        else
        {
            $z0 = true;
        }

        return $z0;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 15:57:52.047 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "D90463461B2A94FF94D13FDF69BB80C9")
    
public int describeContents()
    {


        return 0;
    }

   /* @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 15:57:52.065 -0400", hash_original_method = "B905D81F35A60830BF0BFEB8A43EF3FE", hash_generated_method = "FD7410C5571181A7EEA05F18A10DFB39")
    
public Bundle eU()
    {

        return DG.eU();
    }
*/
   /* @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 15:57:52.074 -0400", hash_original_method = "38B79531902F192130CEE4A2D16E031A", hash_generated_method = "F1792FA0FAA06D7A67FB06784C481758")
    
public Iterator iterator()
    {

        c r2;
        Iterator r3;
        r2 = new c(this);
        r3 = (Iterator) r2;
        return r3;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 15:57:52.085 -0400", hash_original_method = "E17F893EFF28465FC485C24FA189D5AB", hash_generated_method = "F3350AC600AF1D6EECF40497CC5BFF1A")
    
public Iterator singleRefIterator()
    {

        h r2;
        Iterator r3;
        r2 = new h(this);
        r3 = (Iterator) r2;
        return r3;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 15:57:52.092 -0400", hash_original_method = "4705465F202F2E466B7B97A8F39D4359", hash_generated_method = "33E6A01102325E7FDBCB78C1CC2F30C8")
    
public void release()
    {


        if (DG != null)
        {
            DG.close();
        }
    }*/
}
