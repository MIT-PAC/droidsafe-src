package android.content;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
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
    static final String[] MIMETYPES_TEXT_PLAIN = new String[] {
        ClipDescription.MIMETYPE_TEXT_PLAIN };
    static final String[] MIMETYPES_TEXT_URILIST = new String[] {
        ClipDescription.MIMETYPE_TEXT_URILIST };
    static final String[] MIMETYPES_TEXT_INTENT = new String[] {
        ClipDescription.MIMETYPE_TEXT_INTENT };
    final ClipDescription mClipDescription;
    final Bitmap mIcon;
    final ArrayList<Item> mItems = new ArrayList<Item>();
    public static final Parcelable.Creator<ClipData> CREATOR = new Parcelable.Creator<ClipData>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.231 -0400", hash_original_method = "E9B77AA38C2D4F67ACBCF421C777825E", hash_generated_method = "49F20F0E75E4AA535F4D5F103488F966")
        @DSModeled(DSC.SAFE)
        public ClipData createFromParcel(Parcel source) {
            dsTaint.addTaint(source.dsTaint);
            return (ClipData)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new ClipData(source);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.231 -0400", hash_original_method = "4F6E120BA30B443AED50CCA81CAD8061", hash_generated_method = "41C5650E086DFC4C7B1C7AB39333E363")
        @DSModeled(DSC.SAFE)
        public ClipData[] newArray(int size) {
            dsTaint.addTaint(size);
            return (ClipData[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new ClipData[size];
        }

        
}; //Transformed anonymous class
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.232 -0400", hash_original_method = "EBF505A176A1691C0AFF349A48F88B72", hash_generated_method = "9279B879FED439CB9FD5E2FE61266573")
    @DSModeled(DSC.SAFE)
    public ClipData(CharSequence label, String[] mimeTypes, Item item) {
        dsTaint.addTaint(item.dsTaint);
        dsTaint.addTaint(label);
        dsTaint.addTaint(mimeTypes);
        mClipDescription = new ClipDescription(label, mimeTypes);
        {
            throw new NullPointerException("item is null");
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.232 -0400", hash_original_method = "07F73711C3AF49FFEB328A8FE4F43045", hash_generated_method = "275AB163B42F8DD98F69A0F96BC81E18")
    @DSModeled(DSC.SAFE)
    public ClipData(ClipDescription description, Item item) {
        dsTaint.addTaint(description.dsTaint);
        dsTaint.addTaint(item.dsTaint);
        {
            throw new NullPointerException("item is null");
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.233 -0400", hash_original_method = "58D4E89221B1347651A83B7DDCBD7718", hash_generated_method = "D02F25AC0BD080F8A2D922DAC672CD7D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     ClipData(Parcel in) {
        dsTaint.addTaint(in.dsTaint);
        mClipDescription = new ClipDescription(in);
        {
            boolean var25D67F28E4887DDC152DCB9726EAB4D3_822333345 = (in.readInt() != 0);
            {
                mIcon = Bitmap.CREATOR.createFromParcel(in);
            } //End block
            {
                mIcon = null;
            } //End block
        } //End collapsed parenthetic
        final int N;
        N = in.readInt();
        {
            int i;
            i = 0;
            {
                CharSequence text;
                text = TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(in);
                Intent intent;
                boolean var331417C59A822E59FB0B216D2F29CB47_1610383666 = (in.readInt() != 0);
                intent = Intent.CREATOR.createFromParcel(in);
                intent = null;
                Uri uri;
                boolean var331417C59A822E59FB0B216D2F29CB47_1685929485 = (in.readInt() != 0);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.233 -0400", hash_original_method = "6CB00F4121B4A367251983F994C76576", hash_generated_method = "1E4CE54ECA8AC843024EDE9ABED5CE43")
    static public ClipData newPlainText(CharSequence label, CharSequence text) {
        Item item = new Item(text);
        return new ClipData(label, MIMETYPES_TEXT_PLAIN, item);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.233 -0400", hash_original_method = "4E92BB296FD3CDEF44C04DC9305DF09F", hash_generated_method = "616324D254BCF2C43662D8927D30FA51")
    static public ClipData newIntent(CharSequence label, Intent intent) {
        Item item = new Item(intent);
        return new ClipData(label, MIMETYPES_TEXT_INTENT, item);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.233 -0400", hash_original_method = "C11B990F3F58DC47FD386C0AEFA978D2", hash_generated_method = "083E3C3CE214A8DD083306D88FED7A3D")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.234 -0400", hash_original_method = "155F3F7B153F5EA8333C8D51E7A66990", hash_generated_method = "8A56D48CAE45BA842C91F0F5ADE2C28E")
    static public ClipData newRawUri(CharSequence label, Uri uri) {
        Item item = new Item(uri);
        return new ClipData(label, MIMETYPES_TEXT_URILIST, item);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.234 -0400", hash_original_method = "8475A7793CA47249207DFD30E601781C", hash_generated_method = "9C5653D16BFA83A95F78B82E79D793F8")
    @DSModeled(DSC.SAFE)
    public ClipDescription getDescription() {
        return (ClipDescription)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mClipDescription;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.234 -0400", hash_original_method = "150F076539D3E4866582D984173D26A6", hash_generated_method = "D09752E1D9B24AE1CE3F58A2FE36A2D9")
    @DSModeled(DSC.SAFE)
    public void addItem(Item item) {
        dsTaint.addTaint(item.dsTaint);
        {
            throw new NullPointerException("item is null");
        } //End block
        mItems.add(item);
        // ---------- Original Method ----------
        //if (item == null) {
            //throw new NullPointerException("item is null");
        //}
        //mItems.add(item);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.234 -0400", hash_original_method = "229D9D1026C0301FD9A4AD50AC984F17", hash_generated_method = "AD03073861BCF6BEF795C24D3C9E96A5")
    @DSModeled(DSC.SAFE)
    public Bitmap getIcon() {
        return (Bitmap)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mIcon;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.235 -0400", hash_original_method = "2908203B9FEFAA3035EA88685E6DC23A", hash_generated_method = "DFD76F2EEE6A88120E9E9761B4F2C82C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getItemCount() {
        int var903E593E570CF8A7196E435EA30221CF_540365139 = (mItems.size());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mItems.size();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.235 -0400", hash_original_method = "79B4F12EE34F43C8036D233ADFF72DDF", hash_generated_method = "7602D37DC32025530B545DEC1E4309D5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Item getItemAt(int index) {
        dsTaint.addTaint(index);
        Item var50B6C60F66EE15A22205325C098ECD35_979442500 = (mItems.get(index));
        return (Item)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mItems.get(index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.235 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "826038BB7EBD5D3C24D01F025676D20A")
    @DSModeled(DSC.SAFE)
    @Override
    public int describeContents() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.236 -0400", hash_original_method = "0C9FB932279AD72A7EC79D2538384FC0", hash_generated_method = "2F1138E846042A4D1B74FCB180593996")
    @DSModeled(DSC.SAFE)
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dsTaint.addTaint(dest.dsTaint);
        dsTaint.addTaint(flags);
        mClipDescription.writeToParcel(dest, flags);
        {
            dest.writeInt(1);
            mIcon.writeToParcel(dest, flags);
        } //End block
        {
            dest.writeInt(0);
        } //End block
        final int N;
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
        final CharSequence mText;
        final Intent mIntent;
        final Uri mUri;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.236 -0400", hash_original_method = "4A009EFCCF51C2EA640445D87C84D900", hash_generated_method = "6B7B3F8F92B5A381F1E04CCF0F018009")
        @DSModeled(DSC.SAFE)
        public Item(CharSequence text) {
            dsTaint.addTaint(text);
            mIntent = null;
            mUri = null;
            // ---------- Original Method ----------
            //mText = text;
            //mIntent = null;
            //mUri = null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.236 -0400", hash_original_method = "11EC393E75756EFF910C83D0B79625D8", hash_generated_method = "0374B8C719E782DB69E4708C6897FF38")
        @DSModeled(DSC.SPEC)
        public Item(Intent intent) {
            dsTaint.addTaint(intent.dsTaint);
            mText = null;
            mUri = null;
            // ---------- Original Method ----------
            //mText = null;
            //mIntent = intent;
            //mUri = null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.237 -0400", hash_original_method = "C0C0DA6EE7D207BF80500DD7F8FC5437", hash_generated_method = "9E31DC926A02931A483A872E95C7B401")
        @DSModeled(DSC.SPEC)
        public Item(Uri uri) {
            dsTaint.addTaint(uri.dsTaint);
            mText = null;
            mIntent = null;
            // ---------- Original Method ----------
            //mText = null;
            //mIntent = null;
            //mUri = uri;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.237 -0400", hash_original_method = "40EC9D6AF0E3564A5C6CD681E96DEE48", hash_generated_method = "90DD1D598FA7340E91FBC74E5ACFB223")
        @DSModeled(DSC.SPEC)
        public Item(CharSequence text, Intent intent, Uri uri) {
            dsTaint.addTaint(text);
            dsTaint.addTaint(intent.dsTaint);
            dsTaint.addTaint(uri.dsTaint);
            // ---------- Original Method ----------
            //mText = text;
            //mIntent = intent;
            //mUri = uri;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.237 -0400", hash_original_method = "D3D56665E0CC0B43413FBFB4C720E96C", hash_generated_method = "928F7BAE9EC962F9C33EAB96518969CD")
        @DSModeled(DSC.SAFE)
        public CharSequence getText() {
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return mText;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.237 -0400", hash_original_method = "AD027B7B58A4A2F151CC138FB7B23244", hash_generated_method = "0171D0DC4EAD6361737CA1E97CC20C8A")
        @DSModeled(DSC.SPEC)
        public Intent getIntent() {
            return (Intent)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return mIntent;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.237 -0400", hash_original_method = "225259AA593B6A59F476A2C569F1B075", hash_generated_method = "94C4A5FE659081F708F6FF00E69FFC4B")
        @DSModeled(DSC.SPEC)
        public Uri getUri() {
            return (Uri)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return mUri;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.238 -0400", hash_original_method = "2A1795F61A3E14A1308A3A7CD55951FC", hash_generated_method = "9CB2D1880821BAEDF4AE96321022DBF7")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public CharSequence coerceToText(Context context) {
            dsTaint.addTaint(context.dsTaint);
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
                        boolean var23C869020A3A67DDAE5E9A347BAC4416_990494738 = ((len=reader.read(buffer)) > 0);
                        {
                            builder.append(buffer, 0, len);
                        } //End block
                    } //End collapsed parenthetic
                    CharSequence var1F59284C411F9419B065CDD234D02411_1650430575 = (builder.toString());
                } //End block
                catch (FileNotFoundException e)
                { }
                catch (IOException e)
                {
                    CharSequence var06CA5ED4FBDCBE4BE16F532D9B33FBEF_1360561886 = (e.toString());
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
                CharSequence var9672E488737864E5D560CF8261D3DE51_1531237765 = (mUri.toString());
            } //End block
            {
                CharSequence varBBEDEEBA998A1B73C99F78C431323EB9_1419535945 = (mIntent.toUri(Intent.URI_INTENT_SCHEME));
            } //End block
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
    }


    
}


