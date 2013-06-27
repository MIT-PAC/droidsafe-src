package android.content;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:56.501 -0400", hash_original_field = "C18C91213C987999CDB9110CD9126E6F", hash_generated_field = "BD054FDEC655C28C2D1BA2544910FE2F")

    ClipDescription mClipDescription;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:56.501 -0400", hash_original_field = "1A265556E59DF15CAEC4E55FB61E68C7", hash_generated_field = "EC076BF50357690C1FC8AB2DC0D41329")

    Bitmap mIcon;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:56.501 -0400", hash_original_field = "9A2B48118B27FC7163B411FED67908AC", hash_generated_field = "C06D30D4FE5B15243361075EF8FC091A")

    ArrayList<Item> mItems = new ArrayList<Item>();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:56.522 -0400", hash_original_method = "EBF505A176A1691C0AFF349A48F88B72", hash_generated_method = "9612A63A2F759412423E3608CBBF39AD")
    public  ClipData(CharSequence label, String[] mimeTypes, Item item) {
        mClipDescription = new ClipDescription(label, mimeTypes);
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("item is null");
        } //End block
        mIcon = null;
        mItems.add(item);
        addTaint(item.getTaint());
        // ---------- Original Method ----------
        //mClipDescription = new ClipDescription(label, mimeTypes);
        //if (item == null) {
            //throw new NullPointerException("item is null");
        //}
        //mIcon = null;
        //mItems.add(item);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:56.527 -0400", hash_original_method = "07F73711C3AF49FFEB328A8FE4F43045", hash_generated_method = "BAFA0373B4A0DB857C971C137ADD1AD8")
    public  ClipData(ClipDescription description, Item item) {
        mClipDescription = description;
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("item is null");
        } //End block
        mIcon = null;
        mItems.add(item);
        addTaint(item.getTaint());
        // ---------- Original Method ----------
        //mClipDescription = description;
        //if (item == null) {
            //throw new NullPointerException("item is null");
        //}
        //mIcon = null;
        //mItems.add(item);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:56.529 -0400", hash_original_method = "58D4E89221B1347651A83B7DDCBD7718", hash_generated_method = "E0F8A55DC00BFB13578375DA5C309318")
      ClipData(Parcel in) {
        mClipDescription = new ClipDescription(in);
        {
            boolean var25D67F28E4887DDC152DCB9726EAB4D3_907416535 = (in.readInt() != 0);
            {
                mIcon = Bitmap.CREATOR.createFromParcel(in);
            } //End block
            {
                mIcon = null;
            } //End block
        } //End collapsed parenthetic
        int N;
        N = in.readInt();
        {
            int i;
            i = 0;
            {
                CharSequence text;
                text = TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(in);
                Intent intent;
                boolean var331417C59A822E59FB0B216D2F29CB47_1007461323 = (in.readInt() != 0);
                intent = Intent.CREATOR.createFromParcel(in);
                intent = null;
                Uri uri;
                boolean var331417C59A822E59FB0B216D2F29CB47_73826876 = (in.readInt() != 0);
                uri = Uri.CREATOR.createFromParcel(in);
                uri = null;
                mItems.add(new Item(text, intent, uri));
            } //End block
        } //End collapsed parenthetic
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

    
        static public ClipData newIntent(CharSequence label, Intent intent) {
        Item item = new Item(intent);
        return new ClipData(label, MIMETYPES_TEXT_INTENT, item);
    }

    
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

    
        static public ClipData newRawUri(CharSequence label, Uri uri) {
        Item item = new Item(uri);
        return new ClipData(label, MIMETYPES_TEXT_URILIST, item);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:56.550 -0400", hash_original_method = "8475A7793CA47249207DFD30E601781C", hash_generated_method = "A150EA03A0A8D7833580158CA530E236")
    public ClipDescription getDescription() {
        ClipDescription varB4EAC82CA7396A68D541C85D26508E83_514936033 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_514936033 = mClipDescription;
        varB4EAC82CA7396A68D541C85D26508E83_514936033.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_514936033;
        // ---------- Original Method ----------
        //return mClipDescription;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:56.566 -0400", hash_original_method = "150F076539D3E4866582D984173D26A6", hash_generated_method = "27A4D385BC017B47D41C4DECBB9E21CB")
    public void addItem(Item item) {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("item is null");
        } //End block
        mItems.add(item);
        addTaint(item.getTaint());
        // ---------- Original Method ----------
        //if (item == null) {
            //throw new NullPointerException("item is null");
        //}
        //mItems.add(item);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:56.571 -0400", hash_original_method = "229D9D1026C0301FD9A4AD50AC984F17", hash_generated_method = "5500C8284C5233FBAA36B02D60800265")
    public Bitmap getIcon() {
        Bitmap varB4EAC82CA7396A68D541C85D26508E83_932294314 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_932294314 = mIcon;
        varB4EAC82CA7396A68D541C85D26508E83_932294314.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_932294314;
        // ---------- Original Method ----------
        //return mIcon;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:56.572 -0400", hash_original_method = "2908203B9FEFAA3035EA88685E6DC23A", hash_generated_method = "D14720B55B0430F2AB9F454F3B6AF7B6")
    public int getItemCount() {
        int var903E593E570CF8A7196E435EA30221CF_1116559072 = (mItems.size());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1622717232 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1622717232;
        // ---------- Original Method ----------
        //return mItems.size();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:56.599 -0400", hash_original_method = "79B4F12EE34F43C8036D233ADFF72DDF", hash_generated_method = "8E811B755A894223120B3C78136F9FD6")
    public Item getItemAt(int index) {
        Item varB4EAC82CA7396A68D541C85D26508E83_256940134 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_256940134 = mItems.get(index);
        addTaint(index);
        varB4EAC82CA7396A68D541C85D26508E83_256940134.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_256940134;
        // ---------- Original Method ----------
        //return mItems.get(index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:56.601 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "E58A8F701DEBC8D0BF4ADAFF09110BB6")
    @Override
    public int describeContents() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1706463516 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1706463516;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:56.616 -0400", hash_original_method = "0C9FB932279AD72A7EC79D2538384FC0", hash_generated_method = "88BC032B7BCB561B7B2AF01958B92604")
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        mClipDescription.writeToParcel(dest, flags);
        {
            dest.writeInt(1);
            mIcon.writeToParcel(dest, flags);
        } //End block
        {
            dest.writeInt(0);
        } //End block
        int N;
        N = mItems.size();
        dest.writeInt(N);
        {
            int i;
            i = 0;
            {
                Item item;
                item = mItems.get(i);
                TextUtils.writeToParcel(item.mText, dest, flags);
                {
                    dest.writeInt(1);
                    item.mIntent.writeToParcel(dest, flags);
                } //End block
                {
                    dest.writeInt(0);
                } //End block
                {
                    dest.writeInt(1);
                    item.mUri.writeToParcel(dest, flags);
                } //End block
                {
                    dest.writeInt(0);
                } //End block
            } //End block
        } //End collapsed parenthetic
        addTaint(dest.getTaint());
        addTaint(flags);
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:56.617 -0400", hash_original_field = "39624508B9E3028D8A5DDA741D3E3DDE", hash_generated_field = "A59BBC07E5E46996D793B2F37E80BD24")

        CharSequence mText;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:56.617 -0400", hash_original_field = "B1135DD88C82BCDD4DCD8391BCD99883", hash_generated_field = "1811495D939DB843870F6315E04555CC")

        Intent mIntent;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:56.617 -0400", hash_original_field = "5FBE3730DCFF234F97B15868D5CE649D", hash_generated_field = "49226456B4CE4E55A779249DE3DC63D4")

        Uri mUri;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:56.622 -0400", hash_original_method = "4A009EFCCF51C2EA640445D87C84D900", hash_generated_method = "F5679DD9C9B02BBE86AE8D02CB384497")
        public  Item(CharSequence text) {
            mText = text;
            mIntent = null;
            mUri = null;
            // ---------- Original Method ----------
            //mText = text;
            //mIntent = null;
            //mUri = null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:56.632 -0400", hash_original_method = "11EC393E75756EFF910C83D0B79625D8", hash_generated_method = "B2819D5E3832B4449B5964548646CA2E")
        public  Item(Intent intent) {
            mText = null;
            mIntent = intent;
            mUri = null;
            // ---------- Original Method ----------
            //mText = null;
            //mIntent = intent;
            //mUri = null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:56.633 -0400", hash_original_method = "C0C0DA6EE7D207BF80500DD7F8FC5437", hash_generated_method = "689B67F56845AB695374FCBA9B58C5EA")
        public  Item(Uri uri) {
            mText = null;
            mIntent = null;
            mUri = uri;
            // ---------- Original Method ----------
            //mText = null;
            //mIntent = null;
            //mUri = uri;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:56.635 -0400", hash_original_method = "40EC9D6AF0E3564A5C6CD681E96DEE48", hash_generated_method = "8323B86D23D0D4C05CBDB8CA988DDE3A")
        public  Item(CharSequence text, Intent intent, Uri uri) {
            mText = text;
            mIntent = intent;
            mUri = uri;
            // ---------- Original Method ----------
            //mText = text;
            //mIntent = intent;
            //mUri = uri;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:56.655 -0400", hash_original_method = "D3D56665E0CC0B43413FBFB4C720E96C", hash_generated_method = "B55FDB77458EFAD293823CCF992CC987")
        public CharSequence getText() {
            CharSequence varB4EAC82CA7396A68D541C85D26508E83_1029008146 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1029008146 = mText;
            varB4EAC82CA7396A68D541C85D26508E83_1029008146.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1029008146;
            // ---------- Original Method ----------
            //return mText;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:56.657 -0400", hash_original_method = "AD027B7B58A4A2F151CC138FB7B23244", hash_generated_method = "20C788847638F9F13CCD9F06D609947A")
        public Intent getIntent() {
            Intent varB4EAC82CA7396A68D541C85D26508E83_1104128436 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1104128436 = mIntent;
            varB4EAC82CA7396A68D541C85D26508E83_1104128436.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1104128436;
            // ---------- Original Method ----------
            //return mIntent;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:56.674 -0400", hash_original_method = "225259AA593B6A59F476A2C569F1B075", hash_generated_method = "51548C2D7B0C578450E50AAA82BEA326")
        public Uri getUri() {
            Uri varB4EAC82CA7396A68D541C85D26508E83_109377981 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_109377981 = mUri;
            varB4EAC82CA7396A68D541C85D26508E83_109377981.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_109377981;
            // ---------- Original Method ----------
            //return mUri;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:56.707 -0400", hash_original_method = "2A1795F61A3E14A1308A3A7CD55951FC", hash_generated_method = "2919F3F78BE346651FC0E9379A96190E")
        public CharSequence coerceToText(Context context) {
            CharSequence varB4EAC82CA7396A68D541C85D26508E83_1499111646 = null; //Variable for return #1
            CharSequence varB4EAC82CA7396A68D541C85D26508E83_2017037892 = null; //Variable for return #2
            CharSequence varB4EAC82CA7396A68D541C85D26508E83_791968243 = null; //Variable for return #3
            CharSequence varB4EAC82CA7396A68D541C85D26508E83_1244510248 = null; //Variable for return #4
            CharSequence varB4EAC82CA7396A68D541C85D26508E83_1456258841 = null; //Variable for return #5
            CharSequence varB4EAC82CA7396A68D541C85D26508E83_1410984158 = null; //Variable for return #6
            {
                varB4EAC82CA7396A68D541C85D26508E83_1499111646 = mText;
            } //End block
            {
                FileInputStream stream;
                stream = null;
                try 
                {
                    AssetFileDescriptor descr;
                    descr = context.getContentResolver()
                            .openTypedAssetFileDescriptor(mUri, "text/*", null);
                    stream = descr.createInputStream();
                    InputStreamReader reader;
                    reader = new InputStreamReader(stream, "UTF-8");
                    StringBuilder builder;
                    builder = new StringBuilder(128);
                    char[] buffer;
                    buffer = new char[8192];
                    int len;
                    {
                        boolean var23C869020A3A67DDAE5E9A347BAC4416_1827114980 = ((len=reader.read(buffer)) > 0);
                        {
                            builder.append(buffer, 0, len);
                        } //End block
                    } //End collapsed parenthetic
                    varB4EAC82CA7396A68D541C85D26508E83_2017037892 = builder.toString();
                } //End block
                catch (FileNotFoundException e)
                { }
                catch (IOException e)
                {
                    varB4EAC82CA7396A68D541C85D26508E83_791968243 = e.toString();
                } //End block
                finally 
                {
                    {
                        try 
                        {
                            stream.close();
                        } //End block
                        catch (IOException e)
                        { }
                    } //End block
                } //End block
                varB4EAC82CA7396A68D541C85D26508E83_1244510248 = mUri.toString();
            } //End block
            {
                varB4EAC82CA7396A68D541C85D26508E83_1456258841 = mIntent.toUri(Intent.URI_INTENT_SCHEME);
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_1410984158 = "";
            addTaint(context.getTaint());
            CharSequence varA7E53CE21691AB073D9660D615818899_1872887642; //Final return value
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: //Assign result for return ordinal #1
                    varA7E53CE21691AB073D9660D615818899_1872887642 = varB4EAC82CA7396A68D541C85D26508E83_1499111646;
                    break;
                case 2: //Assign result for return ordinal #2
                    varA7E53CE21691AB073D9660D615818899_1872887642 = varB4EAC82CA7396A68D541C85D26508E83_2017037892;
                    break;
                case 3: //Assign result for return ordinal #3
                    varA7E53CE21691AB073D9660D615818899_1872887642 = varB4EAC82CA7396A68D541C85D26508E83_791968243;
                    break;
                case 4: //Assign result for return ordinal #4
                    varA7E53CE21691AB073D9660D615818899_1872887642 = varB4EAC82CA7396A68D541C85D26508E83_1244510248;
                    break;
                case 5: //Assign result for return ordinal #5
                    varA7E53CE21691AB073D9660D615818899_1872887642 = varB4EAC82CA7396A68D541C85D26508E83_1456258841;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_1872887642 = varB4EAC82CA7396A68D541C85D26508E83_1410984158;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_1872887642.addTaint(getTaint()); //Add taint from parent
            return varA7E53CE21691AB073D9660D615818899_1872887642;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:56.724 -0400", hash_original_field = "D3F0628814080CA40397E45440265A07", hash_generated_field = "561737776364DD7F7B56CB9390E27571")

    static String[] MIMETYPES_TEXT_PLAIN = new String[] {
        ClipDescription.MIMETYPE_TEXT_PLAIN };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:56.724 -0400", hash_original_field = "D5509B042F96236C47759856FEB2FE0C", hash_generated_field = "91320D82C8571E57C8805869D0A39F9F")

    static String[] MIMETYPES_TEXT_URILIST = new String[] {
        ClipDescription.MIMETYPE_TEXT_URILIST };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:56.725 -0400", hash_original_field = "E757FCA750885867688751998961A34A", hash_generated_field = "A2CDCB4F60D89E17BCEF72862917E11B")

    static String[] MIMETYPES_TEXT_INTENT = new String[] {
        ClipDescription.MIMETYPE_TEXT_INTENT };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:56.725 -0400", hash_original_field = "3BBA404F84527DE1C18693556D0F0F97", hash_generated_field = "354B16FF6CC203D912D18248606A7B92")

    public static final Parcelable.Creator<ClipData> CREATOR =
        new Parcelable.Creator<ClipData>() {

            public ClipData createFromParcel(Parcel source) {
                return new ClipData(source);
            }

            public ClipData[] newArray(int size) {
                return new ClipData[size];
            }
        };
}

