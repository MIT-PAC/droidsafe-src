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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:02:34.672 -0400", hash_original_field = "F73A484D028786DD5D129A72B43722CF", hash_generated_field = "15F257B2B58A2F7DD1DF612124F55DC1")

    IndexEntry[] mFileEntries;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:02:34.674 -0400", hash_original_field = "AC8BA05A72AEC18F12DD0E8C012B9FFC", hash_generated_field = "514FB88864F91247F240CC01D2ACC68C")

    InputStream mInputStream;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:02:34.682 -0400", hash_original_method = "91271D1D3E9059341D099747D061D3F2", hash_generated_method = "8C3BA97D8067038995406B7FE0EFAC34")
      FileA3D(int id, RenderScript rs, InputStream stream) {
        super(id, rs);
        addTaint(rs.getTaint());
        addTaint(id);
        mInputStream = stream;
        // ---------- Original Method ----------
        //mInputStream = stream;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:02:34.706 -0400", hash_original_method = "269B092AF0EC3A5F2942611AA8A98D07", hash_generated_method = "1B3BDECEFD18EC756EA0C22F92C4DD6B")
    private void initEntries() {
        int numFileEntries = mRS.nFileA3DGetNumIndexEntries(getID());
        if(numFileEntries <= 0)        
        {
            return;
        } //End block
        mFileEntries = new IndexEntry[numFileEntries];
        int[] ids = new int[numFileEntries];
        String[] names = new String[numFileEntries];
        mRS.nFileA3DGetIndexEntries(getID(), numFileEntries, ids, names);
for(int i = 0;i < numFileEntries;i ++)
        {
            mFileEntries[i] = new IndexEntry(mRS, i, getID(), names[i], EntryType.toEntryType(ids[i]));
        } //End block
        // ---------- Original Method ----------
        //int numFileEntries = mRS.nFileA3DGetNumIndexEntries(getID());
        //if(numFileEntries <= 0) {
            //return;
        //}
        //mFileEntries = new IndexEntry[numFileEntries];
        //int[] ids = new int[numFileEntries];
        //String[] names = new String[numFileEntries];
        //mRS.nFileA3DGetIndexEntries(getID(), numFileEntries, ids, names);
        //for(int i = 0; i < numFileEntries; i ++) {
            //mFileEntries[i] = new IndexEntry(mRS, i, getID(), names[i], EntryType.toEntryType(ids[i]));
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:02:34.739 -0400", hash_original_method = "43026D362674C7F77E1B13142D92AB01", hash_generated_method = "1808F435ADFE0F035DAE4E584355B904")
    public int getIndexEntryCount() {
        if(mFileEntries == null)        
        {
            int varCFCD208495D565EF66E7DFF9F98764DA_338460560 = (0);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_694506455 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_694506455;
        } //End block
        int var647A849708AE6F4A0EE645F2705F76E2_1110878834 = (mFileEntries.length);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1516605195 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1516605195;
        // ---------- Original Method ----------
        //if(mFileEntries == null) {
            //return 0;
        //}
        //return mFileEntries.length;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:02:34.756 -0400", hash_original_method = "27D5CB32E5BFA60469EB476FDB126ADE", hash_generated_method = "95C184F71583CC2762DD851932DBF6F2")
    public IndexEntry getIndexEntry(int index) {
        addTaint(index);
        if(getIndexEntryCount() == 0 || index < 0 || index >= mFileEntries.length)        
        {
IndexEntry var540C13E9E156B687226421B24F2DF178_2090162553 =             null;
            var540C13E9E156B687226421B24F2DF178_2090162553.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_2090162553;
        } //End block
IndexEntry varD01CF6E3ACDF99B6478B9E47E49EAA74_446919829 =         mFileEntries[index];
        varD01CF6E3ACDF99B6478B9E47E49EAA74_446919829.addTaint(taint);
        return varD01CF6E3ACDF99B6478B9E47E49EAA74_446919829;
        // ---------- Original Method ----------
        //if(getIndexEntryCount() == 0 || index < 0 || index >= mFileEntries.length) {
            //return null;
        //}
        //return mFileEntries[index];
    }

    
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

    
        static public FileA3D createFromFile(RenderScript rs, String path) {
        int fileId = rs.nFileA3DCreateFromFile(path);
        if(fileId == 0) {
            throw new RSRuntimeException("Unable to create a3d file from " + path);
        }
        FileA3D fa3d = new FileA3D(fileId, rs, null);
        fa3d.initEntries();
        return fa3d;
    }

    
        static public FileA3D createFromFile(RenderScript rs, File path) {
        return createFromFile(rs, path.getAbsolutePath());
    }

    
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

    
    public enum EntryType {
        UNKNOWN (0),
        MESH (1);
        int mID;
        EntryType(int id) {
            mID = id;
        }
        static EntryType toEntryType(int intID) {
            return EntryType.values()[intID];
        }
    }

    
    public static class IndexEntry {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:02:34.786 -0400", hash_original_field = "15EADDEB24354180E81F0ADC804C4CED", hash_generated_field = "AD6E2452AD39DF3B497ED4B7E83C4E0C")

        RenderScript mRS;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:02:34.787 -0400", hash_original_field = "DEC4E8A5D764B68C732DE242B685EABE", hash_generated_field = "3FE793BBC68255EAC5B3588E7DE2E2C6")

        int mIndex;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:02:34.791 -0400", hash_original_field = "F967916F035DAD625F94606212B89077", hash_generated_field = "0B53E374282B34FB268F3024A1E73BA5")

        int mID;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:02:34.795 -0400", hash_original_field = "311C2C8498DF6A626CBDB8AA4193499C", hash_generated_field = "ED29A5CAC2A4A14894CD28BA3B1CE29C")

        String mName;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:02:34.797 -0400", hash_original_field = "897C9E2151614ACAFC4C0D9E7FFD8435", hash_generated_field = "4DCA839C55D5AFD8D446B9C845872A84")

        EntryType mEntryType;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:02:34.798 -0400", hash_original_field = "4B04C5D2DFFA53A4E6273E24BCD95096", hash_generated_field = "B0E944831847E4E67913EFAE0C971B91")

        BaseObj mLoadedObj;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:02:34.810 -0400", hash_original_method = "5C371A19D72845A7A744D3B656A45B20", hash_generated_method = "83D1067FC58DEAE2F44EBA8B7CE0ED91")
          IndexEntry(RenderScript rs, int index, int id, String name, EntryType type) {
            mRS = rs;
            mIndex = index;
            mID = id;
            mName = name;
            mEntryType = type;
            mLoadedObj = null;
            // ---------- Original Method ----------
            //mRS = rs;
            //mIndex = index;
            //mID = id;
            //mName = name;
            //mEntryType = type;
            //mLoadedObj = null;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:02:34.818 -0400", hash_original_method = "9194A7433912D38B9A3F1171AC921C56", hash_generated_method = "7CAAE93E5208A485ABFC1CC9E0180994")
        public String getName() {
String varDBF15A5FB8102A5C28D5046A0E92E443_736135851 =             mName;
            varDBF15A5FB8102A5C28D5046A0E92E443_736135851.addTaint(taint);
            return varDBF15A5FB8102A5C28D5046A0E92E443_736135851;
            // ---------- Original Method ----------
            //return mName;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:02:34.824 -0400", hash_original_method = "B61BB3B634295075609E5761A0D6F231", hash_generated_method = "C6A2F2ADEC206839A2F032CBA5478561")
        public EntryType getEntryType() {
EntryType var090BBB390B511490E21A283693B944FF_2036613388 =             mEntryType;
            var090BBB390B511490E21A283693B944FF_2036613388.addTaint(taint);
            return var090BBB390B511490E21A283693B944FF_2036613388;
            // ---------- Original Method ----------
            //return mEntryType;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:02:34.832 -0400", hash_original_method = "B532C29993711FB50B70114D61D3EE81", hash_generated_method = "AB4DD0DFD303B43D11F2F29BF29A372A")
        public BaseObj getObject() {
            mRS.validate();
            BaseObj obj = internalCreate(mRS, this);
BaseObj var2FDE1120F80AA4E8798ECDBDB1C0E85C_491879173 =             obj;
            var2FDE1120F80AA4E8798ECDBDB1C0E85C_491879173.addTaint(taint);
            return var2FDE1120F80AA4E8798ECDBDB1C0E85C_491879173;
            // ---------- Original Method ----------
            //mRS.validate();
            //BaseObj obj = internalCreate(mRS, this);
            //return obj;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:02:34.839 -0400", hash_original_method = "EA3DD7198DAB1863389D08AED87B7E1C", hash_generated_method = "08A26057DAFB743EBA98F47637EF18A4")
        public Mesh getMesh() {
Mesh var1D14ADB8D61899EB69078B7D2FBB70E4_148031194 =             (Mesh)getObject();
            var1D14ADB8D61899EB69078B7D2FBB70E4_148031194.addTaint(taint);
            return var1D14ADB8D61899EB69078B7D2FBB70E4_148031194;
            // ---------- Original Method ----------
            //return (Mesh)getObject();
        }

        
                @DSModeled(DSC.SAFE)
        static synchronized BaseObj internalCreate(RenderScript rs, IndexEntry entry) {
            if(entry.mLoadedObj != null) {
                return entry.mLoadedObj;
            }
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

        
    }


    
}

