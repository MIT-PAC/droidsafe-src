package android.content;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.058 -0400", hash_original_field = "C18C91213C987999CDB9110CD9126E6F", hash_generated_field = "BD054FDEC655C28C2D1BA2544910FE2F")

    ClipDescription mClipDescription;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.059 -0400", hash_original_field = "1A265556E59DF15CAEC4E55FB61E68C7", hash_generated_field = "EC076BF50357690C1FC8AB2DC0D41329")

    Bitmap mIcon;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.059 -0400", hash_original_field = "9A2B48118B27FC7163B411FED67908AC", hash_generated_field = "642CB554EA43ABB4F05AD892541D7330")

    final ArrayList<Item> mItems = new ArrayList<Item>();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.059 -0400", hash_original_method = "EBF505A176A1691C0AFF349A48F88B72", hash_generated_method = "9612A63A2F759412423E3608CBBF39AD")
    public  ClipData(CharSequence label, String[] mimeTypes, Item item) {
        mClipDescription = new ClipDescription(label, mimeTypes);
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("item is null");
        } 
        mIcon = null;
        mItems.add(item);
        addTaint(item.getTaint());
        
        
        
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.060 -0400", hash_original_method = "07F73711C3AF49FFEB328A8FE4F43045", hash_generated_method = "BAFA0373B4A0DB857C971C137ADD1AD8")
    public  ClipData(ClipDescription description, Item item) {
        mClipDescription = description;
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("item is null");
        } 
        mIcon = null;
        mItems.add(item);
        addTaint(item.getTaint());
        
        
        
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.061 -0400", hash_original_method = "58D4E89221B1347651A83B7DDCBD7718", hash_generated_method = "35AA05DE270F483BED2233C0483558F8")
      ClipData(Parcel in) {
        mClipDescription = new ClipDescription(in);
        {
            boolean var25D67F28E4887DDC152DCB9726EAB4D3_713163787 = (in.readInt() != 0);
            {
                mIcon = Bitmap.CREATOR.createFromParcel(in);
            } 
            {
                mIcon = null;
            } 
        } 
        final int N = in.readInt();
        {
            int i = 0;
            {
                CharSequence text = TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(in);
                Intent intent;
                boolean var331417C59A822E59FB0B216D2F29CB47_1495818274 = (in.readInt() != 0);
                intent = Intent.CREATOR.createFromParcel(in);
                intent = null;
                Uri uri;
                boolean var331417C59A822E59FB0B216D2F29CB47_816067196 = (in.readInt() != 0);
                uri = Uri.CREATOR.createFromParcel(in);
                uri = null;
                mItems.add(new Item(text, intent, uri));
            } 
        } 
        
        
        
            
        
            
        
        
        
            
            
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.063 -0400", hash_original_method = "8475A7793CA47249207DFD30E601781C", hash_generated_method = "D0C007B8F5089D5E007DDBE59D4544D4")
    public ClipDescription getDescription() {
        ClipDescription varB4EAC82CA7396A68D541C85D26508E83_1171112870 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1171112870 = mClipDescription;
        varB4EAC82CA7396A68D541C85D26508E83_1171112870.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1171112870;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.064 -0400", hash_original_method = "150F076539D3E4866582D984173D26A6", hash_generated_method = "27A4D385BC017B47D41C4DECBB9E21CB")
    public void addItem(Item item) {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("item is null");
        } 
        mItems.add(item);
        addTaint(item.getTaint());
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.065 -0400", hash_original_method = "229D9D1026C0301FD9A4AD50AC984F17", hash_generated_method = "5D41E17175FFCA32DABDA38642E0692F")
    public Bitmap getIcon() {
        Bitmap varB4EAC82CA7396A68D541C85D26508E83_601315981 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_601315981 = mIcon;
        varB4EAC82CA7396A68D541C85D26508E83_601315981.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_601315981;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.065 -0400", hash_original_method = "2908203B9FEFAA3035EA88685E6DC23A", hash_generated_method = "079E01A02E152C3EB22222DB613B1890")
    public int getItemCount() {
        int var903E593E570CF8A7196E435EA30221CF_1528188171 = (mItems.size());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1061981804 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1061981804;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.066 -0400", hash_original_method = "79B4F12EE34F43C8036D233ADFF72DDF", hash_generated_method = "984BD221F62B8FA74192EEBD76CB38A3")
    public Item getItemAt(int index) {
        Item varB4EAC82CA7396A68D541C85D26508E83_1375922811 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1375922811 = mItems.get(index);
        addTaint(index);
        varB4EAC82CA7396A68D541C85D26508E83_1375922811.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1375922811;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.066 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "E99DB485F5DC4772D4F3503AF8DE09D6")
    @Override
    public int describeContents() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_809329480 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_809329480;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.067 -0400", hash_original_method = "0C9FB932279AD72A7EC79D2538384FC0", hash_generated_method = "8D29E227A06995FD63718B477BD1EEFA")
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        mClipDescription.writeToParcel(dest, flags);
        {
            dest.writeInt(1);
            mIcon.writeToParcel(dest, flags);
        } 
        {
            dest.writeInt(0);
        } 
        final int N = mItems.size();
        dest.writeInt(N);
        {
            int i = 0;
            {
                Item item = mItems.get(i);
                TextUtils.writeToParcel(item.mText, dest, flags);
                {
                    dest.writeInt(1);
                    item.mIntent.writeToParcel(dest, flags);
                } 
                {
                    dest.writeInt(0);
                } 
                {
                    dest.writeInt(1);
                    item.mUri.writeToParcel(dest, flags);
                } 
                {
                    dest.writeInt(0);
                } 
            } 
        } 
        addTaint(dest.getTaint());
        addTaint(flags);
        
        
        
            
            
        
            
        
        
        
        
            
            
            
                
                
            
                
            
            
                
                
            
                
            
        
    }

    
    public static class Item {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.068 -0400", hash_original_field = "39624508B9E3028D8A5DDA741D3E3DDE", hash_generated_field = "A59BBC07E5E46996D793B2F37E80BD24")

        CharSequence mText;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.068 -0400", hash_original_field = "B1135DD88C82BCDD4DCD8391BCD99883", hash_generated_field = "1811495D939DB843870F6315E04555CC")

        Intent mIntent;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.068 -0400", hash_original_field = "5FBE3730DCFF234F97B15868D5CE649D", hash_generated_field = "49226456B4CE4E55A779249DE3DC63D4")

        Uri mUri;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.068 -0400", hash_original_method = "4A009EFCCF51C2EA640445D87C84D900", hash_generated_method = "F5679DD9C9B02BBE86AE8D02CB384497")
        public  Item(CharSequence text) {
            mText = text;
            mIntent = null;
            mUri = null;
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.069 -0400", hash_original_method = "11EC393E75756EFF910C83D0B79625D8", hash_generated_method = "B2819D5E3832B4449B5964548646CA2E")
        public  Item(Intent intent) {
            mText = null;
            mIntent = intent;
            mUri = null;
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.069 -0400", hash_original_method = "C0C0DA6EE7D207BF80500DD7F8FC5437", hash_generated_method = "689B67F56845AB695374FCBA9B58C5EA")
        public  Item(Uri uri) {
            mText = null;
            mIntent = null;
            mUri = uri;
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.070 -0400", hash_original_method = "40EC9D6AF0E3564A5C6CD681E96DEE48", hash_generated_method = "8323B86D23D0D4C05CBDB8CA988DDE3A")
        public  Item(CharSequence text, Intent intent, Uri uri) {
            mText = text;
            mIntent = intent;
            mUri = uri;
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.070 -0400", hash_original_method = "D3D56665E0CC0B43413FBFB4C720E96C", hash_generated_method = "28BA78BE6472A9BFB2258DB0B7DD45B7")
        public CharSequence getText() {
            CharSequence varB4EAC82CA7396A68D541C85D26508E83_659347048 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_659347048 = mText;
            varB4EAC82CA7396A68D541C85D26508E83_659347048.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_659347048;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.071 -0400", hash_original_method = "AD027B7B58A4A2F151CC138FB7B23244", hash_generated_method = "5F6A4A245F9BDE38B1D69A659DFC581E")
        public Intent getIntent() {
            Intent varB4EAC82CA7396A68D541C85D26508E83_1798323764 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1798323764 = mIntent;
            varB4EAC82CA7396A68D541C85D26508E83_1798323764.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1798323764;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.072 -0400", hash_original_method = "225259AA593B6A59F476A2C569F1B075", hash_generated_method = "E291D64E01A107DF13754F3F6383DA11")
        public Uri getUri() {
            Uri varB4EAC82CA7396A68D541C85D26508E83_315816102 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_315816102 = mUri;
            varB4EAC82CA7396A68D541C85D26508E83_315816102.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_315816102;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.075 -0400", hash_original_method = "2A1795F61A3E14A1308A3A7CD55951FC", hash_generated_method = "62A523887CE399ED21FD40F55F646113")
        public CharSequence coerceToText(Context context) {
            CharSequence varB4EAC82CA7396A68D541C85D26508E83_1271999250 = null; 
            CharSequence varB4EAC82CA7396A68D541C85D26508E83_1684848433 = null; 
            CharSequence varB4EAC82CA7396A68D541C85D26508E83_895363620 = null; 
            CharSequence varB4EAC82CA7396A68D541C85D26508E83_484482319 = null; 
            CharSequence varB4EAC82CA7396A68D541C85D26508E83_1991163404 = null; 
            CharSequence varB4EAC82CA7396A68D541C85D26508E83_2108769264 = null; 
            {
                varB4EAC82CA7396A68D541C85D26508E83_1271999250 = mText;
            } 
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
                    {
                        boolean var23C869020A3A67DDAE5E9A347BAC4416_577956951 = ((len=reader.read(buffer)) > 0);
                        {
                            builder.append(buffer, 0, len);
                        } 
                    } 
                    varB4EAC82CA7396A68D541C85D26508E83_1684848433 = builder.toString();
                } 
                catch (FileNotFoundException e)
                { }
                catch (IOException e)
                {
                    varB4EAC82CA7396A68D541C85D26508E83_895363620 = e.toString();
                } 
                finally 
                {
                    {
                        try 
                        {
                            stream.close();
                        } 
                        catch (IOException e)
                        { }
                    } 
                } 
                varB4EAC82CA7396A68D541C85D26508E83_484482319 = mUri.toString();
            } 
            {
                varB4EAC82CA7396A68D541C85D26508E83_1991163404 = mIntent.toUri(Intent.URI_INTENT_SCHEME);
            } 
            varB4EAC82CA7396A68D541C85D26508E83_2108769264 = "";
            addTaint(context.getTaint());
            CharSequence varA7E53CE21691AB073D9660D615818899_535417019; 
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: 
                    varA7E53CE21691AB073D9660D615818899_535417019 = varB4EAC82CA7396A68D541C85D26508E83_1271999250;
                    break;
                case 2: 
                    varA7E53CE21691AB073D9660D615818899_535417019 = varB4EAC82CA7396A68D541C85D26508E83_1684848433;
                    break;
                case 3: 
                    varA7E53CE21691AB073D9660D615818899_535417019 = varB4EAC82CA7396A68D541C85D26508E83_895363620;
                    break;
                case 4: 
                    varA7E53CE21691AB073D9660D615818899_535417019 = varB4EAC82CA7396A68D541C85D26508E83_484482319;
                    break;
                case 5: 
                    varA7E53CE21691AB073D9660D615818899_535417019 = varB4EAC82CA7396A68D541C85D26508E83_1991163404;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_535417019 = varB4EAC82CA7396A68D541C85D26508E83_2108769264;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_535417019.addTaint(getTaint()); 
            return varA7E53CE21691AB073D9660D615818899_535417019;
            
            
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.075 -0400", hash_original_field = "D3F0628814080CA40397E45440265A07", hash_generated_field = "FFD278290163FA53346E9B463D548F25")

    static final String[] MIMETYPES_TEXT_PLAIN = new String[] {
        ClipDescription.MIMETYPE_TEXT_PLAIN };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.076 -0400", hash_original_field = "D5509B042F96236C47759856FEB2FE0C", hash_generated_field = "0081E14CF2E7DA589C4FFF459050BDC6")

    static final String[] MIMETYPES_TEXT_URILIST = new String[] {
        ClipDescription.MIMETYPE_TEXT_URILIST };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.076 -0400", hash_original_field = "E757FCA750885867688751998961A34A", hash_generated_field = "DD2F391B9027C3620AF732A9D8A52B0F")

    static final String[] MIMETYPES_TEXT_INTENT = new String[] {
        ClipDescription.MIMETYPE_TEXT_INTENT };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.076 -0400", hash_original_field = "3BBA404F84527DE1C18693556D0F0F97", hash_generated_field = "354B16FF6CC203D912D18248606A7B92")

    public static final Parcelable.Creator<ClipData> CREATOR =
        new Parcelable.Creator<ClipData>() {

            public ClipData createFromParcel(Parcel source) {
                return new ClipData(source);
            }

            public ClipData[] newArray(int size) {
                return new ClipData[size];
            }
        };
    
    public ClipData createFromParcel(Parcel source) {
                return new ClipData(source);
            }
    
    
    public ClipData[] newArray(int size) {
                return new ClipData[size];
            }
    
}

