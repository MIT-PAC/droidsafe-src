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
 * Copyright (C) 2008 The Android Open Source Project
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


package android.renderscript;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.InputStream;
import android.graphics.Bitmap;
import android.content.res.AssetManager;
import android.util.Log;
import android.util.TypedValue;
import android.graphics.BitmapFactory;
import java.io.File;
import java.io.IOException;
import android.content.res.Resources;
public class FileA3D extends BaseObj {

    /**
    * Creates a FileA3D object from an asset stored on disk
    *
    * @param rs Context to which the object will belong.
    * @param mgr asset manager used to load asset
    * @param path location of the file to load
    *
    * @return a3d file containing renderscript objects
    */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:11.437 -0500", hash_original_method = "C29DCCF585DA8A7190E597A3D60BC217", hash_generated_method = "53F435516A4DF3560A1034C4E3F1ACE2")
    
static public FileA3D createFromAsset(RenderScript rs, AssetManager mgr, String path) {
        rs.validate();
        int fileId = rs.nFileA3DCreateFromAsset(mgr, path);

        if(fileId == 0) {
            throw new RSRuntimeException("Unable to create a3d file from asset " + path);
        }
        FileA3D fa3d = new FileA3D(fileId, rs, null);
        fa3d.initEntries();
        return fa3d;
    }

    /**
    * Creates a FileA3D object from a file stored on disk
    *
    * @param rs Context to which the object will belong.
    * @param path location of the file to load
    *
    * @return a3d file containing renderscript objects
    */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:11.440 -0500", hash_original_method = "DE83B28F19106842758F77288DAEAA27", hash_generated_method = "E8160E9C4F541C673943DD74608BDCC6")
    
static public FileA3D createFromFile(RenderScript rs, String path) {
        int fileId = rs.nFileA3DCreateFromFile(path);

        if(fileId == 0) {
            throw new RSRuntimeException("Unable to create a3d file from " + path);
        }
        FileA3D fa3d = new FileA3D(fileId, rs, null);
        fa3d.initEntries();
        return fa3d;
    }

    /**
    * Creates a FileA3D object from a file stored on disk
    *
    * @param rs Context to which the object will belong.
    * @param path location of the file to load
    *
    * @return a3d file containing renderscript objects
    */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:11.442 -0500", hash_original_method = "D9A3541A7FCE1B51D5769F33D7BC37C6", hash_generated_method = "721257353AFBA8231AD2516CD0463A2E")
    
static public FileA3D createFromFile(RenderScript rs, File path) {
        return createFromFile(rs, path.getAbsolutePath());
    }

    /**
    * Creates a FileA3D object from an application resource
    *
    * @param rs Context to which the object will belong.
    * @param res resource manager used for loading
    * @param id resource to create FileA3D from
    *
    * @return a3d file containing renderscript objects
    */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:11.444 -0500", hash_original_method = "8CBCB41C90B55C0D320AD938E2B6273D", hash_generated_method = "A5FA69A3CCB19FFBBD7A744313A1F0A4")
    
static public FileA3D createFromResource(RenderScript rs, Resources res, int id) {

        rs.validate();
        InputStream is = null;
        try {
            is = res.openRawResource(id);
        } catch (Exception e) {
            throw new RSRuntimeException("Unable to open resource " + id);
        }

        int fileId = 0;
        if (is instanceof AssetManager.AssetInputStream) {
            int asset = ((AssetManager.AssetInputStream) is).getAssetInt();
            fileId = rs.nFileA3DCreateFromAssetStream(asset);
        } else {
            throw new RSRuntimeException("Unsupported asset stream");
        }

        if(fileId == 0) {
            throw new RSRuntimeException("Unable to create a3d file from resource " + id);
        }
        FileA3D fa3d = new FileA3D(fileId, rs, is);
        fa3d.initEntries();
        return fa3d;

    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:11.423 -0500", hash_original_field = "15F257B2B58A2F7DD1DF612124F55DC1", hash_generated_field = "15F257B2B58A2F7DD1DF612124F55DC1")

    IndexEntry[] mFileEntries;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:11.425 -0500", hash_original_field = "514FB88864F91247F240CC01D2ACC68C", hash_generated_field = "514FB88864F91247F240CC01D2ACC68C")

    InputStream mInputStream;

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:11.428 -0500", hash_original_method = "91271D1D3E9059341D099747D061D3F2", hash_generated_method = "91271D1D3E9059341D099747D061D3F2")
    
FileA3D(int id, RenderScript rs, InputStream stream) {
        super(id, rs);
        mInputStream = stream;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:11.430 -0500", hash_original_method = "269B092AF0EC3A5F2942611AA8A98D07", hash_generated_method = "2FCF1440FC8F457DCE537A7C0DB485DF")
    
private void initEntries() {
        int numFileEntries = mRS.nFileA3DGetNumIndexEntries(getID());
        if(numFileEntries <= 0) {
            return;
        }

        mFileEntries = new IndexEntry[numFileEntries];
        int[] ids = new int[numFileEntries];
        String[] names = new String[numFileEntries];

        mRS.nFileA3DGetIndexEntries(getID(), numFileEntries, ids, names);

        for(int i = 0; i < numFileEntries; i ++) {
            mFileEntries[i] = new IndexEntry(mRS, i, getID(), names[i], EntryType.toEntryType(ids[i]));
        }
    }

    /**
    * Returns the number of objects stored inside the a3d file
    *
    * @return the number of objects stored inside the a3d file
    */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:11.432 -0500", hash_original_method = "43026D362674C7F77E1B13142D92AB01", hash_generated_method = "503F1CC3564B44DCC4C094C685633870")
    
public int getIndexEntryCount() {
        if(mFileEntries == null) {
            return 0;
        }
        return mFileEntries.length;
    }

    /**
    * Returns an index entry from the list of all objects inside
    * FileA3D
    *
    * @param index number of the entry from the list to return
    *
    * @return entry in the a3d file described by the index
    */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:11.435 -0500", hash_original_method = "27D5CB32E5BFA60469EB476FDB126ADE", hash_generated_method = "73F458CC96A805BDA70BAC8FB8C7C5AD")
    
public IndexEntry getIndexEntry(int index) {
        if(getIndexEntryCount() == 0 || index < 0 || index >= mFileEntries.length) {
            return null;
        }
        return mFileEntries[index];
    }
    
    public enum EntryType {
        UNKNOWN (0),
        MESH (1);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:11.382 -0500", hash_original_field = "0B53E374282B34FB268F3024A1E73BA5", hash_generated_field = "0B53E374282B34FB268F3024A1E73BA5")

        int mID;
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:11.385 -0500", hash_original_method = "2F37A1A6EA27CDE145768A1C14F98CCA", hash_generated_method = "2F37A1A6EA27CDE145768A1C14F98CCA")
            
EntryType(int id) {
            mID = id;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:11.387 -0500", hash_original_method = "933606CEBE6C65236D0644811DE322CD", hash_generated_method = "568A26D4CB50EEE15E7A3E0164292614")
            
static EntryType toEntryType(int intID) {
            return EntryType.values()[intID];
        }
    }
    
    public static class IndexEntry {

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:11.416 -0500", hash_original_method = "8C3A303BF9AF4B9B24A6291EBA192A83", hash_generated_method = "7C8669EEFD3EEEBF08A85BF9C5149211")
        
static synchronized BaseObj internalCreate(RenderScript rs, IndexEntry entry) {
            if(entry.mLoadedObj != null) {
                return entry.mLoadedObj;
            }

            // to be purged on cleanup
            if(entry.mEntryType == EntryType.UNKNOWN) {
                return null;
            }

            int objectID = rs.nFileA3DGetEntryByIndex(entry.mID, entry.mIndex);
            if(objectID == 0) {
                return null;
            }

            switch (entry.mEntryType) {
            case MESH:
                entry.mLoadedObj = new Mesh(objectID, rs);
                break;
            }

            entry.mLoadedObj.updateFromNative();
            return entry.mLoadedObj;
        }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:11.393 -0500", hash_original_field = "AD6E2452AD39DF3B497ED4B7E83C4E0C", hash_generated_field = "AD6E2452AD39DF3B497ED4B7E83C4E0C")

        RenderScript mRS;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:11.395 -0500", hash_original_field = "3FE793BBC68255EAC5B3588E7DE2E2C6", hash_generated_field = "3FE793BBC68255EAC5B3588E7DE2E2C6")

        int mIndex;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:11.397 -0500", hash_original_field = "0B53E374282B34FB268F3024A1E73BA5", hash_generated_field = "0B53E374282B34FB268F3024A1E73BA5")

        int mID;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:11.399 -0500", hash_original_field = "ED29A5CAC2A4A14894CD28BA3B1CE29C", hash_generated_field = "ED29A5CAC2A4A14894CD28BA3B1CE29C")

        String mName;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:11.400 -0500", hash_original_field = "4DCA839C55D5AFD8D446B9C845872A84", hash_generated_field = "4DCA839C55D5AFD8D446B9C845872A84")

        EntryType mEntryType;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:11.402 -0500", hash_original_field = "B0E944831847E4E67913EFAE0C971B91", hash_generated_field = "B0E944831847E4E67913EFAE0C971B91")

        BaseObj mLoadedObj;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:11.419 -0500", hash_original_method = "5C371A19D72845A7A744D3B656A45B20", hash_generated_method = "5C371A19D72845A7A744D3B656A45B20")
        
IndexEntry(RenderScript rs, int index, int id, String name, EntryType type) {
            mRS = rs;
            mIndex = index;
            mID = id;
            mName = name;
            mEntryType = type;
            mLoadedObj = null;
        }

        /**
        * Returns the name of a renderscript object the index entry
        * describes
        *
        * @return name of a renderscript object the index entry
        * describes
        *
        */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:11.405 -0500", hash_original_method = "9194A7433912D38B9A3F1171AC921C56", hash_generated_method = "AD920925278DEAFAFBD283F9C2E39E5D")
        
public String getName() {
            return mName;
        }

        /**
        * Returns the type of a renderscript object the index entry
        * describes
        * @return type of a renderscript object the index entry
        *         describes
        */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:11.408 -0500", hash_original_method = "B61BB3B634295075609E5761A0D6F231", hash_generated_method = "F654BD39D7B11C51218585FE332A081D")
        
public EntryType getEntryType() {
            return mEntryType;
        }

        /**
        * Used to load the object described by the index entry
        * @return base renderscript object described by the entry
        */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:11.410 -0500", hash_original_method = "B532C29993711FB50B70114D61D3EE81", hash_generated_method = "62C28903F8CD77BD2165CBB3C72C1904")
        
public BaseObj getObject() {
            mRS.validate();
            BaseObj obj = internalCreate(mRS, this);
            return obj;
        }

        /**
        * Used to load the mesh described by the index entry, object
        * described by the index entry must be a renderscript mesh
        *
        * @return renderscript mesh object described by the entry
        */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:11.412 -0500", hash_original_method = "EA3DD7198DAB1863389D08AED87B7E1C", hash_generated_method = "9357BF9F5D9AB05F7A064479A6DBEC1C")
        
public Mesh getMesh() {
            return (Mesh)getObject();
        }
        
    }
    
}

