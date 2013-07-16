package android.content;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ClipData implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.241 -0400", hash_original_field = "C18C91213C987999CDB9110CD9126E6F", hash_generated_field = "BD054FDEC655C28C2D1BA2544910FE2F")

    ClipDescription mClipDescription;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.241 -0400", hash_original_field = "1A265556E59DF15CAEC4E55FB61E68C7", hash_generated_field = "EC076BF50357690C1FC8AB2DC0D41329")

    Bitmap mIcon;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.242 -0400", hash_original_field = "9A2B48118B27FC7163B411FED67908AC", hash_generated_field = "642CB554EA43ABB4F05AD892541D7330")

    final ArrayList<Item> mItems = new ArrayList<Item>();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.243 -0400", hash_original_method = "EBF505A176A1691C0AFF349A48F88B72", hash_generated_method = "D88C90A019247B9615714D09A179AEF5")
    public  ClipData(CharSequence label, String[] mimeTypes, Item item) {
        addTaint(item.getTaint());
        mClipDescription = new ClipDescription(label, mimeTypes);
    if(item == null)        
        {
            NullPointerException var7AB68A07996D71FE90F8DD58F021F543_701845800 = new NullPointerException("item is null");
            var7AB68A07996D71FE90F8DD58F021F543_701845800.addTaint(taint);
            throw var7AB68A07996D71FE90F8DD58F021F543_701845800;
        } //End block
        mIcon = null;
        mItems.add(item);
        // ---------- Original Method ----------
        //mClipDescription = new ClipDescription(label, mimeTypes);
        //if (item == null) {
            //throw new NullPointerException("item is null");
        //}
        //mIcon = null;
        //mItems.add(item);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.244 -0400", hash_original_method = "07F73711C3AF49FFEB328A8FE4F43045", hash_generated_method = "4DDDDCB251B7200543929ED9650671BF")
    public  ClipData(ClipDescription description, Item item) {
        addTaint(item.getTaint());
        mClipDescription = description;
    if(item == null)        
        {
            NullPointerException var7AB68A07996D71FE90F8DD58F021F543_989410613 = new NullPointerException("item is null");
            var7AB68A07996D71FE90F8DD58F021F543_989410613.addTaint(taint);
            throw var7AB68A07996D71FE90F8DD58F021F543_989410613;
        } //End block
        mIcon = null;
        mItems.add(item);
        // ---------- Original Method ----------
        //mClipDescription = description;
        //if (item == null) {
            //throw new NullPointerException("item is null");
        //}
        //mIcon = null;
        //mItems.add(item);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.245 -0400", hash_original_method = "58D4E89221B1347651A83B7DDCBD7718", hash_generated_method = "207929556FD17766E89481E87DC0B7EF")
      ClipData(Parcel in) {
        mClipDescription = new ClipDescription(in);
    if(in.readInt() != 0)        
        {
            mIcon = Bitmap.CREATOR.createFromParcel(in);
        } //End block
        else
        {
            mIcon = null;
        } //End block
        final int N = in.readInt();
for(int i=0;i<N;i++)
        {
            CharSequence text = TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(in);
            Intent intent = in.readInt() != 0 ? Intent.CREATOR.createFromParcel(in) : null;
            Uri uri = in.readInt() != 0 ? Uri.CREATOR.createFromParcel(in) : null;
            mItems.add(new Item(text, intent, uri));
        } //End block
        // ---------- Original Method ----------
        //mClipDescription = new ClipDescription(in);
        //if (in.readInt() != 0) {
            //mIcon = Bitmap.CREATOR.createFromParcel(in);
        //} else {
            //mIcon = null;
        //}
        //final int N = in.readInt();
        //for (int i=0; i<N; i++) {
            //CharSequence text = TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(in);
            //Intent intent = in.readInt() != 0 ? Intent.CREATOR.createFromParcel(in) : null;
            //Uri uri = in.readInt() != 0 ? Uri.CREATOR.createFromParcel(in) : null;
            //mItems.add(new Item(text, intent, uri));
        //}
    }

    
        static public ClipData newPlainText(CharSequence label, CharSequence text) {
        Item item = new Item(text);
        return new ClipData(label, MIMETYPES_TEXT_PLAIN, item);
    }

    
        @DSModeled(DSC.SPEC)
    static public ClipData newIntent(CharSequence label, Intent intent) {
        Item item = new Item(intent);
        return new ClipData(label, MIMETYPES_TEXT_INTENT, item);
    }

    
        @DSModeled(DSC.SPEC)
    static public ClipData newUri(ContentResolver resolver, CharSequence label,
            Uri uri) {
        Item item = new Item(uri);
        String[] mimeTypes = null;
        if ("content".equals(uri.getScheme())) {
            String realType = resolver.getType(uri);
            mimeTypes = resolver.getStreamTypes(uri, "*/*");
            if (mimeTypes == null) {
                if (realType != null) {
                    mimeTypes = new String[] { realType, ClipDescription.MIMETYPE_TEXT_URILIST };
                }
            } else {
                String[] tmp = new String[mimeTypes.length + (realType != null ? 2 : 1)];
                int i = 0;
                if (realType != null) {
                    tmp[0] = realType;
                    i++;
                }
                System.arraycopy(mimeTypes, 0, tmp, i, mimeTypes.length);
                tmp[i + mimeTypes.length] = ClipDescription.MIMETYPE_TEXT_URILIST;
                mimeTypes = tmp;
            }
        }
        if (mimeTypes == null) {
            mimeTypes = MIMETYPES_TEXT_URILIST;
        }
        return new ClipData(label, mimeTypes, item);
    }

    
        @DSModeled(DSC.SPEC)
    static public ClipData newRawUri(CharSequence label, Uri uri) {
        Item item = new Item(uri);
        return new ClipData(label, MIMETYPES_TEXT_URILIST, item);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.248 -0400", hash_original_method = "8475A7793CA47249207DFD30E601781C", hash_generated_method = "72D9D2B261814C64A2F85BDB0D857B9C")
    public ClipDescription getDescription() {
ClipDescription var66737B70E012D8A6A7B87AF89D5A9D5F_283119724 =         mClipDescription;
        var66737B70E012D8A6A7B87AF89D5A9D5F_283119724.addTaint(taint);
        return var66737B70E012D8A6A7B87AF89D5A9D5F_283119724;
        // ---------- Original Method ----------
        //return mClipDescription;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.248 -0400", hash_original_method = "150F076539D3E4866582D984173D26A6", hash_generated_method = "1497677FD5D2C0F521025A228B0BE0E5")
    public void addItem(Item item) {
        addTaint(item.getTaint());
    if(item == null)        
        {
            NullPointerException var7AB68A07996D71FE90F8DD58F021F543_1174067529 = new NullPointerException("item is null");
            var7AB68A07996D71FE90F8DD58F021F543_1174067529.addTaint(taint);
            throw var7AB68A07996D71FE90F8DD58F021F543_1174067529;
        } //End block
        mItems.add(item);
        // ---------- Original Method ----------
        //if (item == null) {
            //throw new NullPointerException("item is null");
        //}
        //mItems.add(item);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.249 -0400", hash_original_method = "229D9D1026C0301FD9A4AD50AC984F17", hash_generated_method = "7D74DB5683DBA8BE851C2BD0BE550817")
    public Bitmap getIcon() {
Bitmap var664A3A1F0DCFF82F0A8D0B798A32C3B0_1787955001 =         mIcon;
        var664A3A1F0DCFF82F0A8D0B798A32C3B0_1787955001.addTaint(taint);
        return var664A3A1F0DCFF82F0A8D0B798A32C3B0_1787955001;
        // ---------- Original Method ----------
        //return mIcon;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.249 -0400", hash_original_method = "2908203B9FEFAA3035EA88685E6DC23A", hash_generated_method = "46458642F295D67635853486DFEC867D")
    public int getItemCount() {
        int var9B434FD456AC2D14B6AB22377BFF1926_388397218 = (mItems.size());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1852463493 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1852463493;
        // ---------- Original Method ----------
        //return mItems.size();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.249 -0400", hash_original_method = "79B4F12EE34F43C8036D233ADFF72DDF", hash_generated_method = "30054F36D64494472B1AC45647008696")
    public Item getItemAt(int index) {
        addTaint(index);
Item var955C9579A8231EA8752336C152243F31_1921877989 =         mItems.get(index);
        var955C9579A8231EA8752336C152243F31_1921877989.addTaint(taint);
        return var955C9579A8231EA8752336C152243F31_1921877989;
        // ---------- Original Method ----------
        //return mItems.get(index);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.250 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "367CC80F9F6E8BCC65C53602A4AB1AC9")
    @Override
    public int describeContents() {
        int varCFCD208495D565EF66E7DFF9F98764DA_2040298659 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1681170170 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1681170170;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.250 -0400", hash_original_method = "0C9FB932279AD72A7EC79D2538384FC0", hash_generated_method = "C27D3B1BBC9B3CDDFDA0A83D0F34FA47")
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        addTaint(flags);
        addTaint(dest.getTaint());
        mClipDescription.writeToParcel(dest, flags);
    if(mIcon != null)        
        {
            dest.writeInt(1);
            mIcon.writeToParcel(dest, flags);
        } //End block
        else
        {
            dest.writeInt(0);
        } //End block
        final int N = mItems.size();
        dest.writeInt(N);
for(int i=0;i<N;i++)
        {
            Item item = mItems.get(i);
            TextUtils.writeToParcel(item.mText, dest, flags);
    if(item.mIntent != null)            
            {
                dest.writeInt(1);
                item.mIntent.writeToParcel(dest, flags);
            } //End block
            else
            {
                dest.writeInt(0);
            } //End block
    if(item.mUri != null)            
            {
                dest.writeInt(1);
                item.mUri.writeToParcel(dest, flags);
            } //End block
            else
            {
                dest.writeInt(0);
            } //End block
        } //End block
        // ---------- Original Method ----------
        //mClipDescription.writeToParcel(dest, flags);
        //if (mIcon != null) {
            //dest.writeInt(1);
            //mIcon.writeToParcel(dest, flags);
        //} else {
            //dest.writeInt(0);
        //}
        //final int N = mItems.size();
        //dest.writeInt(N);
        //for (int i=0; i<N; i++) {
            //Item item = mItems.get(i);
            //TextUtils.writeToParcel(item.mText, dest, flags);
            //if (item.mIntent != null) {
                //dest.writeInt(1);
                //item.mIntent.writeToParcel(dest, flags);
            //} else {
                //dest.writeInt(0);
            //}
            //if (item.mUri != null) {
                //dest.writeInt(1);
                //item.mUri.writeToParcel(dest, flags);
            //} else {
                //dest.writeInt(0);
            //}
        //}
    }

    
    public static class Item {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.251 -0400", hash_original_field = "39624508B9E3028D8A5DDA741D3E3DDE", hash_generated_field = "A59BBC07E5E46996D793B2F37E80BD24")

        CharSequence mText;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.251 -0400", hash_original_field = "B1135DD88C82BCDD4DCD8391BCD99883", hash_generated_field = "1811495D939DB843870F6315E04555CC")

        Intent mIntent;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.252 -0400", hash_original_field = "5FBE3730DCFF234F97B15868D5CE649D", hash_generated_field = "49226456B4CE4E55A779249DE3DC63D4")

        Uri mUri;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.252 -0400", hash_original_method = "4A009EFCCF51C2EA640445D87C84D900", hash_generated_method = "F5679DD9C9B02BBE86AE8D02CB384497")
        public  Item(CharSequence text) {
            mText = text;
            mIntent = null;
            mUri = null;
            // ---------- Original Method ----------
            //mText = text;
            //mIntent = null;
            //mUri = null;
        }

        
        @DSModeled(DSC.SPEC)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.253 -0400", hash_original_method = "11EC393E75756EFF910C83D0B79625D8", hash_generated_method = "B2819D5E3832B4449B5964548646CA2E")
        public  Item(Intent intent) {
            mText = null;
            mIntent = intent;
            mUri = null;
            // ---------- Original Method ----------
            //mText = null;
            //mIntent = intent;
            //mUri = null;
        }

        
        @DSModeled(DSC.SPEC)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.257 -0400", hash_original_method = "C0C0DA6EE7D207BF80500DD7F8FC5437", hash_generated_method = "689B67F56845AB695374FCBA9B58C5EA")
        public  Item(Uri uri) {
            mText = null;
            mIntent = null;
            mUri = uri;
            // ---------- Original Method ----------
            //mText = null;
            //mIntent = null;
            //mUri = uri;
        }

        
        @DSModeled(DSC.SPEC)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.259 -0400", hash_original_method = "40EC9D6AF0E3564A5C6CD681E96DEE48", hash_generated_method = "8323B86D23D0D4C05CBDB8CA988DDE3A")
        public  Item(CharSequence text, Intent intent, Uri uri) {
            mText = text;
            mIntent = intent;
            mUri = uri;
            // ---------- Original Method ----------
            //mText = text;
            //mIntent = intent;
            //mUri = uri;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.259 -0400", hash_original_method = "D3D56665E0CC0B43413FBFB4C720E96C", hash_generated_method = "9B6CE575E11621D931A08DC8A6E927DB")
        public CharSequence getText() {
CharSequence var7F7ECB4B14362FFBA020956966B29A66_807284972 =             mText;
            var7F7ECB4B14362FFBA020956966B29A66_807284972.addTaint(taint);
            return var7F7ECB4B14362FFBA020956966B29A66_807284972;
            // ---------- Original Method ----------
            //return mText;
        }

        
        @DSModeled(DSC.SPEC)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.260 -0400", hash_original_method = "AD027B7B58A4A2F151CC138FB7B23244", hash_generated_method = "F269A679633EEA861B0DD8700F50B188")
        public Intent getIntent() {
Intent var4DCF8E3D75AE0B94CDA94656DCE16BCE_1670900416 =             mIntent;
            var4DCF8E3D75AE0B94CDA94656DCE16BCE_1670900416.addTaint(taint);
            return var4DCF8E3D75AE0B94CDA94656DCE16BCE_1670900416;
            // ---------- Original Method ----------
            //return mIntent;
        }

        
        @DSModeled(DSC.SPEC)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.260 -0400", hash_original_method = "225259AA593B6A59F476A2C569F1B075", hash_generated_method = "8DD77BA842FF8B3DE4E14E9984063945")
        public Uri getUri() {
Uri var7D41D50876117CE5D7DFAD684A455037_365991867 =             mUri;
            var7D41D50876117CE5D7DFAD684A455037_365991867.addTaint(taint);
            return var7D41D50876117CE5D7DFAD684A455037_365991867;
            // ---------- Original Method ----------
            //return mUri;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.261 -0400", hash_original_method = "2A1795F61A3E14A1308A3A7CD55951FC", hash_generated_method = "730A1F8C7D7E3490D939C1EC11D92CB6")
        public CharSequence coerceToText(Context context) {
            addTaint(context.getTaint());
    if(mText != null)            
            {
CharSequence var7F7ECB4B14362FFBA020956966B29A66_2123408296 =                 mText;
                var7F7ECB4B14362FFBA020956966B29A66_2123408296.addTaint(taint);
                return var7F7ECB4B14362FFBA020956966B29A66_2123408296;
            } //End block
    if(mUri != null)            
            {
                FileInputStream stream = null;
                try 
                {
                    AssetFileDescriptor descr = context.getContentResolver()
                            .openTypedAssetFileDescriptor(mUri, "text/*", null);
                    stream = descr.createInputStream();
                    InputStreamReader reader = new InputStreamReader(stream, "UTF-8");
                    StringBuilder builder = new StringBuilder(128);
                    char[] buffer = new char[8192];
                    int len;
                    while
((len=reader.read(buffer)) > 0)                    
                    {
                        builder.append(buffer, 0, len);
                    } //End block
CharSequence varF4CF030572656354ACFDF83FEE21D7A6_986040384 =                     builder.toString();
                    varF4CF030572656354ACFDF83FEE21D7A6_986040384.addTaint(taint);
                    return varF4CF030572656354ACFDF83FEE21D7A6_986040384;
                } //End block
                catch (FileNotFoundException e)
                {
                } //End block
                catch (IOException e)
                {
CharSequence varB1071CD0E076C663B32B4BA8A95F73F2_1388067581 =                     e.toString();
                    varB1071CD0E076C663B32B4BA8A95F73F2_1388067581.addTaint(taint);
                    return varB1071CD0E076C663B32B4BA8A95F73F2_1388067581;
                } //End block
                finally 
                {
    if(stream != null)                    
                    {
                        try 
                        {
                            stream.close();
                        } //End block
                        catch (IOException e)
                        {
                        } //End block
                    } //End block
                } //End block
CharSequence varB2005789EAA9176832EA559C3023D52A_1216758018 =                 mUri.toString();
                varB2005789EAA9176832EA559C3023D52A_1216758018.addTaint(taint);
                return varB2005789EAA9176832EA559C3023D52A_1216758018;
            } //End block
    if(mIntent != null)            
            {
CharSequence varCD147CD666D21033AEEBC64FDBDD4AE6_851294511 =                 mIntent.toUri(Intent.URI_INTENT_SCHEME);
                varCD147CD666D21033AEEBC64FDBDD4AE6_851294511.addTaint(taint);
                return varCD147CD666D21033AEEBC64FDBDD4AE6_851294511;
            } //End block
CharSequence var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_1058590254 =             "";
            var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_1058590254.addTaint(taint);
            return var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_1058590254;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.261 -0400", hash_original_field = "D3F0628814080CA40397E45440265A07", hash_generated_field = "FFD278290163FA53346E9B463D548F25")

    static final String[] MIMETYPES_TEXT_PLAIN = new String[] {
        ClipDescription.MIMETYPE_TEXT_PLAIN };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.261 -0400", hash_original_field = "D5509B042F96236C47759856FEB2FE0C", hash_generated_field = "0081E14CF2E7DA589C4FFF459050BDC6")

    static final String[] MIMETYPES_TEXT_URILIST = new String[] {
        ClipDescription.MIMETYPE_TEXT_URILIST };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.262 -0400", hash_original_field = "E757FCA750885867688751998961A34A", hash_generated_field = "DD2F391B9027C3620AF732A9D8A52B0F")

    static final String[] MIMETYPES_TEXT_INTENT = new String[] {
        ClipDescription.MIMETYPE_TEXT_INTENT };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.262 -0400", hash_original_field = "3BBA404F84527DE1C18693556D0F0F97", hash_generated_field = "354B16FF6CC203D912D18248606A7B92")

    public static final Parcelable.Creator<ClipData> CREATOR =
        new Parcelable.Creator<ClipData>() {

            public ClipData createFromParcel(Parcel source) {
                return new ClipData(source);
            }

            public ClipData[] newArray(int size) {
                return new ClipData[size];
            }
        };
    // orphaned legacy method
    public ClipData createFromParcel(Parcel source) {
                return new ClipData(source);
            }
    
    // orphaned legacy method
    public ClipData[] newArray(int size) {
                return new ClipData[size];
            }
    
}

