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
 * 
 * 
 * This file incorporates work covered by the following copyright and
 * permission notice:
 *
 * Copyright (C) 2011 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package android.media;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.content.ContentValues;
import android.content.IContentProvider;
import android.net.Uri;
import android.os.RemoteException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * A MediaScanner helper class which enables us to do lazy insertion on the
 * given provider. This class manages buffers internally and flushes when they
 * are full. Note that you should call flushAll() after using this class.
 * {@hide}
 */
public class MediaInserter {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:40:22.151 -0400", hash_original_field = "D0AB4E724F80469837870F4AE88E5545", hash_generated_field = "028C9513B86E364B627048590775FCAB")

    private HashMap<Uri, List<ContentValues>> mRowMap =
            new HashMap<Uri, List<ContentValues>>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:40:22.156 -0400", hash_original_field = "4165A1FBAFFD21863CC0EAC1937582F7", hash_generated_field = "358248BDBAA0C39D138E82A554F14381")


    private IContentProvider mProvider;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:40:22.159 -0400", hash_original_field = "0D4B99A5FDD62FE823878520B043EDEF", hash_generated_field = "23B0D01D423E9FB41546B19C1F309BD9")

    private int mBufferSizePerUri;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:40:22.164 -0400", hash_original_method = "80E75E3D7125B52789176CEB21CE8AE9", hash_generated_method = "E5832C939BCBE1FC3D5ED542CB251A83")
    
public MediaInserter(IContentProvider provider, int bufferSizePerUri) {
        mProvider = provider;
        mBufferSizePerUri = bufferSizePerUri;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:40:22.168 -0400", hash_original_method = "FD4B32382D9BBB71783421C997DD8821", hash_generated_method = "5E062367956BF637C66F87DAF1EE8697")
    
public void insert(Uri tableUri, ContentValues values) throws RemoteException {
        List<ContentValues> list = mRowMap.get(tableUri);
        if (list == null) {
            list = new ArrayList<ContentValues>();
            mRowMap.put(tableUri, list);
        }
        list.add(new ContentValues(values));
        if (list.size() >= mBufferSizePerUri) {
            flush(tableUri);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:40:22.172 -0400", hash_original_method = "4234DB268A71670B25809B3C650BE78D", hash_generated_method = "B56DF4D30E4DDC3C7643C874F4AEA9D6")
    
public void flushAll() throws RemoteException {
        for (Uri tableUri : mRowMap.keySet()){
            flush(tableUri);
        }
        mRowMap.clear();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:40:22.176 -0400", hash_original_method = "D1F18A65BB0AD81C61A555E799DC2EFA", hash_generated_method = "7D0CCD961DD39EF3BC4A8A154AABB3F0")
    
private void flush(Uri tableUri) throws RemoteException {
        List<ContentValues> list = mRowMap.get(tableUri);
        if (!list.isEmpty()) {
            ContentValues[] valuesArray = new ContentValues[list.size()];
            valuesArray = list.toArray(valuesArray);
            mProvider.bulkInsert(tableUri, valuesArray);
            list.clear();
        }
    }
}
