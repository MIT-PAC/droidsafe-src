package android.content;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import android.annotation.SdkConstant;
import android.annotation.SdkConstant.SdkConstantType;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import com.android.internal.util.XmlUtils;
import java.io.IOException;
import java.io.Serializable;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Intent implements Parcelable, Cloneable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:59.934 -0400", hash_original_field = "A3988EEE869C06063B06A0C38A6A1E11", hash_generated_field = "6BA7274A46303AB4A280C73477809BB1")

    private String mAction;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:59.934 -0400", hash_original_field = "B7DE4FF1B7CCEFDA36733D8B6DFF2904", hash_generated_field = "EAE374FAE80C7320375D0E6D6C17A234")

    private Uri mData;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:59.934 -0400", hash_original_field = "3462A1A18A0EE070E8953CCF1DD788C0", hash_generated_field = "DA7F98239A4F122D17620AC61DF29F55")

    private String mType;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:59.934 -0400", hash_original_field = "089616237F5DED8B7A7F9A618C4FC032", hash_generated_field = "D6E102019562022F9DE7C9915C7FD917")

    private String mPackage;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:59.935 -0400", hash_original_field = "C0386E973BB6E008B1720A8BB4936F69", hash_generated_field = "1B40E7C57A0B1682389BAE16521C0844")

    private ComponentName mComponent;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:59.935 -0400", hash_original_field = "9C3CD7D37D3E1E66BE9B3B005FC98B3A", hash_generated_field = "43F71E9173849705E01112D0229448B4")

    private int mFlags;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:59.935 -0400", hash_original_field = "8B78B778A55BF7BA9FCA325DD3C7F159", hash_generated_field = "0CC4E2884DD354D66A438C7E26DB89B1")

    private HashSet<String> mCategories;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:59.935 -0400", hash_original_field = "45F5DC4EA541ED660CFEDA0032CA356C", hash_generated_field = "5596C79D633F3A9F64294D3BD6D43156")

    private Bundle mExtras;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:59.935 -0400", hash_original_field = "362964976893BB3412A47087DA9F002C", hash_generated_field = "B906B02E252E86FB4170D1D8409B9103")

    private Rect mSourceBounds;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:59.935 -0400", hash_original_field = "D697BABF55DFD739589D0F84316D9938", hash_generated_field = "E0BD8AEFA324D8DA702D2534D195AB3A")

    private Intent mSelector;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:59.946 -0400", hash_original_method = "5C0F2C7B56AA3A635FE64462CDD8279E", hash_generated_method = "2F40AB6E2EC88F714802FB672BF7EC58")
    public  Intent() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:59.949 -0400", hash_original_method = "3FAB664599EE7924CC36F277EFA522C8", hash_generated_method = "00952665995EF664D7F24028FC4F6CB9")
    public  Intent(Intent o) {
        this.mAction = o.mAction;
        this.mData = o.mData;
        this.mType = o.mType;
        this.mPackage = o.mPackage;
        this.mComponent = o.mComponent;
        this.mFlags = o.mFlags;
        {
            this.mCategories = new HashSet<String>(o.mCategories);
        } //End block
        {
            this.mExtras = new Bundle(o.mExtras);
        } //End block
        {
            this.mSourceBounds = new Rect(o.mSourceBounds);
        } //End block
        {
            this.mSelector = new Intent(o.mSelector);
        } //End block
        // ---------- Original Method ----------
        //this.mAction = o.mAction;
        //this.mData = o.mData;
        //this.mType = o.mType;
        //this.mPackage = o.mPackage;
        //this.mComponent = o.mComponent;
        //this.mFlags = o.mFlags;
        //if (o.mCategories != null) {
            //this.mCategories = new HashSet<String>(o.mCategories);
        //}
        //if (o.mExtras != null) {
            //this.mExtras = new Bundle(o.mExtras);
        //}
        //if (o.mSourceBounds != null) {
            //this.mSourceBounds = new Rect(o.mSourceBounds);
        //}
        //if (o.mSelector != null) {
            //this.mSelector = new Intent(o.mSelector);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:59.950 -0400", hash_original_method = "C1E3B3E9040DD8E1371895A668D56796", hash_generated_method = "194B5E35F32E780B9BF008CAB1F74367")
    private  Intent(Intent o, boolean all) {
        this.mAction = o.mAction;
        this.mData = o.mData;
        this.mType = o.mType;
        this.mPackage = o.mPackage;
        this.mComponent = o.mComponent;
        {
            this.mCategories = new HashSet<String>(o.mCategories);
        } //End block
        addTaint(all);
        // ---------- Original Method ----------
        //this.mAction = o.mAction;
        //this.mData = o.mData;
        //this.mType = o.mType;
        //this.mPackage = o.mPackage;
        //this.mComponent = o.mComponent;
        //if (o.mCategories != null) {
            //this.mCategories = new HashSet<String>(o.mCategories);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:59.978 -0400", hash_original_method = "D5ECE127B03D5F5367AC94B767F0584E", hash_generated_method = "34DA2CFDEFE0D5AAA4A2CB8DF5E09C8F")
    public  Intent(String action) {
        setAction(action);
        addTaint(action.getTaint());
        // ---------- Original Method ----------
        //setAction(action);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:59.978 -0400", hash_original_method = "FF213ACFD5B7DFA2C83F432472B13960", hash_generated_method = "8A2E325F8E2B9359A414C84764C05E3C")
    public  Intent(String action, Uri uri) {
        setAction(action);
        mData = uri;
        addTaint(action.getTaint());
        // ---------- Original Method ----------
        //setAction(action);
        //mData = uri;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:59.979 -0400", hash_original_method = "8A8F598E2C7B57A58F1379D7AFC8B81F", hash_generated_method = "CFC95A750DAD5D8F9B4AF9DD7CFFB32A")
    public  Intent(Context packageContext, Class<?> cls) {
        mComponent = new ComponentName(packageContext, cls);
        // ---------- Original Method ----------
        //mComponent = new ComponentName(packageContext, cls);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:59.980 -0400", hash_original_method = "780AF3DA4D357977F460A8077F315476", hash_generated_method = "179AAA00B8BB8F15A9F9C54B3E944FB4")
    public  Intent(String action, Uri uri,
            Context packageContext, Class<?> cls) {
        setAction(action);
        mData = uri;
        mComponent = new ComponentName(packageContext, cls);
        addTaint(action.getTaint());
        // ---------- Original Method ----------
        //setAction(action);
        //mData = uri;
        //mComponent = new ComponentName(packageContext, cls);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:59.981 -0400", hash_original_method = "BDABA8F9DB7F141DA2E5B48F186347CF", hash_generated_method = "16FA652E6E169A74C8F77D1FEFBDB01B")
    protected  Intent(Parcel in) {
        readFromParcel(in);
        addTaint(in.getTaint());
        // ---------- Original Method ----------
        //readFromParcel(in);
    }

    
        public static Intent createChooser(Intent target, CharSequence title) {
        Intent intent = new Intent(ACTION_CHOOSER);
        intent.putExtra(EXTRA_INTENT, target);
        if (title != null) {
            intent.putExtra(EXTRA_TITLE, title);
        }
        return intent;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:00.061 -0400", hash_original_method = "0DE1E082CFAE738C657D3967F7BD3FA4", hash_generated_method = "A24B99EDE6F6B99DE87BE1BF8EB36D9E")
    @Override
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_1855765325 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1855765325 = new Intent(this);
        varB4EAC82CA7396A68D541C85D26508E83_1855765325.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1855765325;
        // ---------- Original Method ----------
        //return new Intent(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:00.064 -0400", hash_original_method = "321DCA737B51074721765C9DBE3DB18C", hash_generated_method = "AF6D7400A84B23C2061E39FCF7940EDB")
    public Intent cloneFilter() {
        Intent varB4EAC82CA7396A68D541C85D26508E83_669815224 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_669815224 = new Intent(this, false);
        varB4EAC82CA7396A68D541C85D26508E83_669815224.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_669815224;
        // ---------- Original Method ----------
        //return new Intent(this, false);
    }

    
        public static Intent makeMainActivity(ComponentName mainActivity) {
        Intent intent = new Intent(ACTION_MAIN);
        intent.setComponent(mainActivity);
        intent.addCategory(CATEGORY_LAUNCHER);
        return intent;
    }

    
        public static Intent makeMainSelectorActivity(String selectorAction,
            String selectorCategory) {
        Intent intent = new Intent(ACTION_MAIN);
        intent.addCategory(CATEGORY_LAUNCHER);
        Intent selector = new Intent();
        selector.setAction(selectorAction);
        selector.addCategory(selectorCategory);
        intent.setSelector(selector);
        return intent;
    }

    
        public static Intent makeRestartActivityTask(ComponentName mainActivity) {
        Intent intent = makeMainActivity(mainActivity);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK
                | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        return intent;
    }

    
        @Deprecated
    public static Intent getIntent(String uri) throws URISyntaxException {
        return parseUri(uri, 0);
    }

    
        public static Intent parseUri(String uri, int flags) throws URISyntaxException {
        int i = 0;
        try {
            if ((flags&URI_INTENT_SCHEME) != 0) {
                if (!uri.startsWith("intent:")) {
                    Intent intent = new Intent(ACTION_VIEW);
                    try {
                        intent.setData(Uri.parse(uri));
                    } catch (IllegalArgumentException e) {
                        throw new URISyntaxException(uri, e.getMessage());
                    }
                    return intent;
                }
            }
            i = uri.lastIndexOf("#");
            if (i == -1) return new Intent(ACTION_VIEW, Uri.parse(uri));
            if (!uri.startsWith("#Intent;", i)) return getIntentOld(uri);
            Intent intent = new Intent(ACTION_VIEW);
            Intent baseIntent = intent;
            String data = i >= 0 ? uri.substring(0, i) : null;
            String scheme = null;
            i += "#Intent;".length();
            while (!uri.startsWith("end", i)) {
                int eq = uri.indexOf('=', i);
                if (eq < 0) eq = i-1;
                int semi = uri.indexOf(';', i);
                String value = eq < semi ? Uri.decode(uri.substring(eq + 1, semi)) : "";
                if (uri.startsWith("action=", i)) {
                    intent.setAction(value);
                }
                else if (uri.startsWith("category=", i)) {
                    intent.addCategory(value);
                }
                else if (uri.startsWith("type=", i)) {
                    intent.mType = value;
                }
                else if (uri.startsWith("launchFlags=", i)) {
                    intent.mFlags = Integer.decode(value).intValue();
                }
                else if (uri.startsWith("package=", i)) {
                    intent.mPackage = value;
                }
                else if (uri.startsWith("component=", i)) {
                    intent.mComponent = ComponentName.unflattenFromString(value);
                }
                else if (uri.startsWith("scheme=", i)) {
                    scheme = value;
                }
                else if (uri.startsWith("sourceBounds=", i)) {
                    intent.mSourceBounds = Rect.unflattenFromString(value);
                }
                else if (semi == (i+3) && uri.startsWith("SEL", i)) {
                    intent = new Intent();
                }
                else {
                    String key = Uri.decode(uri.substring(i + 2, eq));
                    if (intent.mExtras == null) intent.mExtras = new Bundle();
                    Bundle b = intent.mExtras;
                    if      (uri.startsWith("S.", i)) b.putString(key, value);
                    else if (uri.startsWith("B.", i)) b.putBoolean(key, Boolean.parseBoolean(value));
                    else if (uri.startsWith("b.", i)) b.putByte(key, Byte.parseByte(value));
                    else if (uri.startsWith("c.", i)) b.putChar(key, value.charAt(0));
                    else if (uri.startsWith("d.", i)) b.putDouble(key, Double.parseDouble(value));
                    else if (uri.startsWith("f.", i)) b.putFloat(key, Float.parseFloat(value));
                    else if (uri.startsWith("i.", i)) b.putInt(key, Integer.parseInt(value));
                    else if (uri.startsWith("l.", i)) b.putLong(key, Long.parseLong(value));
                    else if (uri.startsWith("s.", i)) b.putShort(key, Short.parseShort(value));
                    else throw new URISyntaxException(uri, "unknown EXTRA type", i);
                }
                i = semi + 1;
            }
            if (intent != baseIntent) {
                baseIntent.setSelector(intent);
                intent = baseIntent;
            }
            if (data != null) {
                if (data.startsWith("intent:")) {
                    data = data.substring(7);
                    if (scheme != null) {
                        data = scheme + ':' + data;
                    }
                }
                if (data.length() > 0) {
                    try {
                        intent.mData = Uri.parse(data);
                    } catch (IllegalArgumentException e) {
                        throw new URISyntaxException(uri, e.getMessage());
                    }
                }
            }
            return intent;
        } catch (IndexOutOfBoundsException e) {
            throw new URISyntaxException(uri, "illegal Intent URI format", i);
        }
    }

    
        public static Intent getIntentOld(String uri) throws URISyntaxException {
        Intent intent;
        int i = uri.lastIndexOf('#');
        if (i >= 0) {
            String action = null;
            final int intentFragmentStart = i;
            boolean isIntentFragment = false;
            i++;
            if (uri.regionMatches(i, "action(", 0, 7)) {
                isIntentFragment = true;
                i += 7;
                int j = uri.indexOf(')', i);
                action = uri.substring(i, j);
                i = j + 1;
            }
            intent = new Intent(action);
            if (uri.regionMatches(i, "categories(", 0, 11)) {
                isIntentFragment = true;
                i += 11;
                int j = uri.indexOf(')', i);
                while (i < j) {
                    int sep = uri.indexOf('!', i);
                    if (sep < 0) sep = j;
                    if (i < sep) {
                        intent.addCategory(uri.substring(i, sep));
                    }
                    i = sep + 1;
                }
                i = j + 1;
            }
            if (uri.regionMatches(i, "type(", 0, 5)) {
                isIntentFragment = true;
                i += 5;
                int j = uri.indexOf(')', i);
                intent.mType = uri.substring(i, j);
                i = j + 1;
            }
            if (uri.regionMatches(i, "launchFlags(", 0, 12)) {
                isIntentFragment = true;
                i += 12;
                int j = uri.indexOf(')', i);
                intent.mFlags = Integer.decode(uri.substring(i, j)).intValue();
                i = j + 1;
            }
            if (uri.regionMatches(i, "component(", 0, 10)) {
                isIntentFragment = true;
                i += 10;
                int j = uri.indexOf(')', i);
                int sep = uri.indexOf('!', i);
                if (sep >= 0 && sep < j) {
                    String pkg = uri.substring(i, sep);
                    String cls = uri.substring(sep + 1, j);
                    intent.mComponent = new ComponentName(pkg, cls);
                }
                i = j + 1;
            }
            if (uri.regionMatches(i, "extras(", 0, 7)) {
                isIntentFragment = true;
                i += 7;
                final int closeParen = uri.indexOf(')', i);
                if (closeParen == -1) throw new URISyntaxException(uri,
                        "EXTRA missing trailing ')'", i);
                while (i < closeParen) {
                    int j = uri.indexOf('=', i);
                    if (j <= i + 1 || i >= closeParen) {
                        throw new URISyntaxException(uri, "EXTRA missing '='", i);
                    }
                    char type = uri.charAt(i);
                    i++;
                    String key = uri.substring(i, j);
                    i = j + 1;
                    j = uri.indexOf('!', i);
                    if (j == -1 || j >= closeParen) j = closeParen;
                    if (i >= j) throw new URISyntaxException(uri, "EXTRA missing '!'", i);
                    String value = uri.substring(i, j);
                    i = j;
                    if (intent.mExtras == null) intent.mExtras = new Bundle();
                    try {
                        switch (type) {
                            case 'S':
                                intent.mExtras.putString(key, Uri.decode(value));
                                break;
                            case 'B':
                                intent.mExtras.putBoolean(key, Boolean.parseBoolean(value));
                                break;
                            case 'b':
                                intent.mExtras.putByte(key, Byte.parseByte(value));
                                break;
                            case 'c':
                                intent.mExtras.putChar(key, Uri.decode(value).charAt(0));
                                break;
                            case 'd':
                                intent.mExtras.putDouble(key, Double.parseDouble(value));
                                break;
                            case 'f':
                                intent.mExtras.putFloat(key, Float.parseFloat(value));
                                break;
                            case 'i':
                                intent.mExtras.putInt(key, Integer.parseInt(value));
                                break;
                            case 'l':
                                intent.mExtras.putLong(key, Long.parseLong(value));
                                break;
                            case 's':
                                intent.mExtras.putShort(key, Short.parseShort(value));
                                break;
                            default:
                                throw new URISyntaxException(uri, "EXTRA has unknown type", i);
                        }
                    } catch (NumberFormatException e) {
                        throw new URISyntaxException(uri, "EXTRA value can't be parsed", i);
                    }
                    char ch = uri.charAt(i);
                    if (ch == ')') break;
                    if (ch != '!') throw new URISyntaxException(uri, "EXTRA missing '!'", i);
                    i++;
                }
            }
            if (isIntentFragment) {
                intent.mData = Uri.parse(uri.substring(0, intentFragmentStart));
            } else {
                intent.mData = Uri.parse(uri);
            }
            if (intent.mAction == null) {
                intent.mAction = ACTION_VIEW;
            }
        } else {
            intent = new Intent(ACTION_VIEW, Uri.parse(uri));
        }
        return intent;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:00.083 -0400", hash_original_method = "2F09B930D511D23A5EF1D9DB36B884EA", hash_generated_method = "8E2B969875B1646E09A9C011FFA02F81")
    public String getAction() {
        String varB4EAC82CA7396A68D541C85D26508E83_32998852 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_32998852 = mAction;
        varB4EAC82CA7396A68D541C85D26508E83_32998852.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_32998852;
        // ---------- Original Method ----------
        //return mAction;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:00.084 -0400", hash_original_method = "E338941BA5F359CEDBE88CD11D2A1B67", hash_generated_method = "AF4DB56100E286A27B6562489887035A")
    public Uri getData() {
        Uri varB4EAC82CA7396A68D541C85D26508E83_77109732 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_77109732 = mData;
        varB4EAC82CA7396A68D541C85D26508E83_77109732.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_77109732;
        // ---------- Original Method ----------
        //return mData;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:00.108 -0400", hash_original_method = "3391B7F4BF539D2060FFC8B715534970", hash_generated_method = "60528D17DC36375C2959D312310FB7CB")
    public String getDataString() {
        String varB4EAC82CA7396A68D541C85D26508E83_493842932 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_493842932 = mData != null ? mData.toString() : null;
        varB4EAC82CA7396A68D541C85D26508E83_493842932.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_493842932;
        // ---------- Original Method ----------
        //return mData != null ? mData.toString() : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:00.109 -0400", hash_original_method = "773226227E17626211D04D8FDBCEC473", hash_generated_method = "50EDE6E84EAAAC0EA34C153FBE9A2265")
    public String getScheme() {
        String varB4EAC82CA7396A68D541C85D26508E83_232905230 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_232905230 = mData != null ? mData.getScheme() : null;
        varB4EAC82CA7396A68D541C85D26508E83_232905230.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_232905230;
        // ---------- Original Method ----------
        //return mData != null ? mData.getScheme() : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:00.110 -0400", hash_original_method = "F57356AE1A37FC524BD36BB2BA67325B", hash_generated_method = "344F2973875ADFDE1F487ED7EC274677")
    public String getType() {
        String varB4EAC82CA7396A68D541C85D26508E83_1191115832 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1191115832 = mType;
        varB4EAC82CA7396A68D541C85D26508E83_1191115832.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1191115832;
        // ---------- Original Method ----------
        //return mType;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:00.111 -0400", hash_original_method = "BE275DDE2732AB3F4C79CA9D98784573", hash_generated_method = "ADC90F05D4123A62EA17764D7363175A")
    public String resolveType(Context context) {
        String varB4EAC82CA7396A68D541C85D26508E83_680027960 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_680027960 = resolveType(context.getContentResolver());
        addTaint(context.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_680027960.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_680027960;
        // ---------- Original Method ----------
        //return resolveType(context.getContentResolver());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:00.112 -0400", hash_original_method = "897693CEC97DB20AF099C3D62602279E", hash_generated_method = "065155013CE84B0A77DFAC99BCA418D0")
    public String resolveType(ContentResolver resolver) {
        String varB4EAC82CA7396A68D541C85D26508E83_368356706 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1104012785 = null; //Variable for return #2
        String varB4EAC82CA7396A68D541C85D26508E83_372267703 = null; //Variable for return #3
        {
            varB4EAC82CA7396A68D541C85D26508E83_368356706 = mType;
        } //End block
        {
            {
                boolean var7B4C5E574C7ED5DA8E1E1A150D29C82A_561314378 = ("content".equals(mData.getScheme()));
                {
                    varB4EAC82CA7396A68D541C85D26508E83_1104012785 = resolver.getType(mData);
                } //End block
            } //End collapsed parenthetic
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_372267703 = null;
        addTaint(resolver.getTaint());
        String varA7E53CE21691AB073D9660D615818899_500669666; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_500669666 = varB4EAC82CA7396A68D541C85D26508E83_368356706;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_500669666 = varB4EAC82CA7396A68D541C85D26508E83_1104012785;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_500669666 = varB4EAC82CA7396A68D541C85D26508E83_372267703;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_500669666.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_500669666;
        // ---------- Original Method ----------
        //if (mType != null) {
            //return mType;
        //}
        //if (mData != null) {
            //if ("content".equals(mData.getScheme())) {
                //return resolver.getType(mData);
            //}
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:00.142 -0400", hash_original_method = "824F1F0C825483A1D800708DE36CD7E2", hash_generated_method = "8B3502D9F303EB90B205AB6223F9916B")
    public String resolveTypeIfNeeded(ContentResolver resolver) {
        String varB4EAC82CA7396A68D541C85D26508E83_1346281310 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_987686111 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_1346281310 = mType;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_987686111 = resolveType(resolver);
        addTaint(resolver.getTaint());
        String varA7E53CE21691AB073D9660D615818899_1518502210; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1518502210 = varB4EAC82CA7396A68D541C85D26508E83_1346281310;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1518502210 = varB4EAC82CA7396A68D541C85D26508E83_987686111;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1518502210.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1518502210;
        // ---------- Original Method ----------
        //if (mComponent != null) {
            //return mType;
        //}
        //return resolveType(resolver);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:00.143 -0400", hash_original_method = "3612221F73372432993CCD6954A20D1D", hash_generated_method = "E06D07ABE840AD964EA215EA6279EB68")
    public boolean hasCategory(String category) {
        boolean varC2460535E11742A1B298C090C684A3C7_909754545 = (mCategories != null && mCategories.contains(category));
        addTaint(category.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1751972384 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1751972384;
        // ---------- Original Method ----------
        //return mCategories != null && mCategories.contains(category);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:00.161 -0400", hash_original_method = "44E921F5CBF6AA9462AF2EF773666A6D", hash_generated_method = "3C2A5C61AF272C9B254DDE9140E1B402")
    public Set<String> getCategories() {
        Set<String> varB4EAC82CA7396A68D541C85D26508E83_1202378043 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1202378043 = mCategories;
        varB4EAC82CA7396A68D541C85D26508E83_1202378043.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1202378043;
        // ---------- Original Method ----------
        //return mCategories;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:00.163 -0400", hash_original_method = "0EFF867FD71A8B842E16179807F3AE79", hash_generated_method = "761B19D7450BAAFFD0125FC23A49C3F8")
    public Intent getSelector() {
        Intent varB4EAC82CA7396A68D541C85D26508E83_1507737810 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1507737810 = mSelector;
        varB4EAC82CA7396A68D541C85D26508E83_1507737810.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1507737810;
        // ---------- Original Method ----------
        //return mSelector;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:00.168 -0400", hash_original_method = "C5389CB5192CD8E55615D6E62222251D", hash_generated_method = "F0FBA8D75C22CD2CFA1EDB76BE433A36")
    public void setExtrasClassLoader(ClassLoader loader) {
        {
            mExtras.setClassLoader(loader);
        } //End block
        addTaint(loader.getTaint());
        // ---------- Original Method ----------
        //if (mExtras != null) {
            //mExtras.setClassLoader(loader);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:00.169 -0400", hash_original_method = "820997F7D9BF8A8B37DA5723F540EC8D", hash_generated_method = "80E0FA825CAB02113450B4F1DAF7B68A")
    public boolean hasExtra(String name) {
        boolean var8D5EC6D3C753A94FA222F4E5ACC81591_1777035611 = (mExtras != null && mExtras.containsKey(name));
        addTaint(name.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_864822463 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_864822463;
        // ---------- Original Method ----------
        //return mExtras != null && mExtras.containsKey(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:00.189 -0400", hash_original_method = "A4A187292984F1C3EE73C7C78931040C", hash_generated_method = "7809D94565F806BD06889F4F43C8A0FF")
    public boolean hasFileDescriptors() {
        boolean var0C8CC71D26B004C46DB7A137664B7280_80112583 = (mExtras != null && mExtras.hasFileDescriptors());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1042834275 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1042834275;
        // ---------- Original Method ----------
        //return mExtras != null && mExtras.hasFileDescriptors();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:00.190 -0400", hash_original_method = "D5A9FCC072E976E3B1807EE38A32DBE8", hash_generated_method = "9C16B7EA2539CE65EE89DB7AAA00C36F")
    public void setAllowFds(boolean allowFds) {
        {
            mExtras.setAllowFds(allowFds);
        } //End block
        addTaint(allowFds);
        // ---------- Original Method ----------
        //if (mExtras != null) {
            //mExtras.setAllowFds(allowFds);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:00.207 -0400", hash_original_method = "4C23C66584C2E08F8D8923DC65F21B8A", hash_generated_method = "CA9FF3108FF17F63666C9862FF95405E")
    @Deprecated
    public Object getExtra(String name) {
        Object varB4EAC82CA7396A68D541C85D26508E83_853511632 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_853511632 = getExtra(name, null);
        addTaint(name.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_853511632.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_853511632;
        // ---------- Original Method ----------
        //return getExtra(name, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:00.209 -0400", hash_original_method = "6C77EA53DBDF6A732015829C63BCD454", hash_generated_method = "FD196DAF3441B2AFC31D312C0E437964")
    public boolean getBooleanExtra(String name, boolean defaultValue) {
        {
            Object var441345A13C50B96F36B1BDDFE386B01D_1068664072 = (mExtras.getBoolean(name, defaultValue));
        } //End flattened ternary
        addTaint(name.getTaint());
        addTaint(defaultValue);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2141545933 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2141545933;
        // ---------- Original Method ----------
        //return mExtras == null ? defaultValue :
            //mExtras.getBoolean(name, defaultValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:00.215 -0400", hash_original_method = "7FB23DDD0BCB246CA49844E5ABE7B23C", hash_generated_method = "402C63CEAC1730BC8CF51A8C7F0707F1")
    public byte getByteExtra(String name, byte defaultValue) {
        {
            Object var5E722E48E6374BC3181BB0395ED7280C_2080922115 = (mExtras.getByte(name, defaultValue));
        } //End flattened ternary
        addTaint(name.getTaint());
        addTaint(defaultValue);
        byte var40EA57D3EE3C07BF1C102B466E1C3091_936462745 = getTaintByte();
        return var40EA57D3EE3C07BF1C102B466E1C3091_936462745;
        // ---------- Original Method ----------
        //return mExtras == null ? defaultValue :
            //mExtras.getByte(name, defaultValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:00.231 -0400", hash_original_method = "7EF2CF350AA07FA1327C85A618EDDBDF", hash_generated_method = "C151460DF81759D8E27E8389276D14ED")
    public short getShortExtra(String name, short defaultValue) {
        {
            Object var1F19702B4265707BAB9F4C74EAFD2129_2001364735 = (mExtras.getShort(name, defaultValue));
        } //End flattened ternary
        addTaint(name.getTaint());
        addTaint(defaultValue);
        short var4F09DAA9D95BCB166A302407A0E0BABE_1585457035 = getTaintShort();
        return var4F09DAA9D95BCB166A302407A0E0BABE_1585457035;
        // ---------- Original Method ----------
        //return mExtras == null ? defaultValue :
            //mExtras.getShort(name, defaultValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:00.232 -0400", hash_original_method = "49AA93250C5B660485540E34F899D621", hash_generated_method = "B86D3776E776B029D95D90CA06D2DAED")
    public char getCharExtra(String name, char defaultValue) {
        {
            Object varF0573B87D0C0746DE636734AFBFD1074_1782934603 = (mExtras.getChar(name, defaultValue));
        } //End flattened ternary
        addTaint(name.getTaint());
        addTaint(defaultValue);
        char varA87DEB01C5F539E6BDA34829C8EF2368_1396649230 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_1396649230;
        // ---------- Original Method ----------
        //return mExtras == null ? defaultValue :
            //mExtras.getChar(name, defaultValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:00.251 -0400", hash_original_method = "E0513A91E6CBAE3AB1C6E2298E28F4E9", hash_generated_method = "147BFB601818997D515741E451D16B18")
    public int getIntExtra(String name, int defaultValue) {
        {
            Object var005750265D68679C9436FF96E8585426_508891703 = (mExtras.getInt(name, defaultValue));
        } //End flattened ternary
        addTaint(name.getTaint());
        addTaint(defaultValue);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1688582487 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1688582487;
        // ---------- Original Method ----------
        //return mExtras == null ? defaultValue :
            //mExtras.getInt(name, defaultValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:00.252 -0400", hash_original_method = "C094BEE2071DFD73ABD25F184B7F6CE5", hash_generated_method = "3B6A31E32A954CA06F8F06FCA4991C26")
    public long getLongExtra(String name, long defaultValue) {
        {
            Object varB55020DEBF1224039DDEA4A270305BFE_1810909182 = (mExtras.getLong(name, defaultValue));
        } //End flattened ternary
        addTaint(name.getTaint());
        addTaint(defaultValue);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_654137273 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_654137273;
        // ---------- Original Method ----------
        //return mExtras == null ? defaultValue :
            //mExtras.getLong(name, defaultValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:00.253 -0400", hash_original_method = "468C9940FDAFD3DDCC0968AC84566FDC", hash_generated_method = "7384B3EDFE20568C7E60ADF9819D90BD")
    public float getFloatExtra(String name, float defaultValue) {
        {
            Object varFEEC99C4EF3B173D2F91E923C717FD9F_1907419091 = (mExtras.getFloat(name, defaultValue));
        } //End flattened ternary
        addTaint(name.getTaint());
        addTaint(defaultValue);
        float var546ADE640B6EDFBC8A086EF31347E768_1094413745 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1094413745;
        // ---------- Original Method ----------
        //return mExtras == null ? defaultValue :
            //mExtras.getFloat(name, defaultValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:00.257 -0400", hash_original_method = "9D513802316CA501D261DB0FDD177D9E", hash_generated_method = "EC4E75737623417DD1A1CD9B44445FC5")
    public double getDoubleExtra(String name, double defaultValue) {
        {
            Object varA815D167050171A219111346DF8F615D_454684306 = (mExtras.getDouble(name, defaultValue));
        } //End flattened ternary
        addTaint(name.getTaint());
        addTaint(defaultValue);
        double varE8CD7DA078A86726031AD64F35F5A6C0_199192550 = getTaintDouble();
        return varE8CD7DA078A86726031AD64F35F5A6C0_199192550;
        // ---------- Original Method ----------
        //return mExtras == null ? defaultValue :
            //mExtras.getDouble(name, defaultValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:00.277 -0400", hash_original_method = "8063ECA9F5AA2AEF21F6A345FFE2B7E6", hash_generated_method = "44E2388E6C9176A8EFC10E81297006CD")
    public String getStringExtra(String name) {
        String varB4EAC82CA7396A68D541C85D26508E83_716970600 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_716970600 = mExtras == null ? null : mExtras.getString(name);
        addTaint(name.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_716970600.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_716970600;
        // ---------- Original Method ----------
        //return mExtras == null ? null : mExtras.getString(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:00.278 -0400", hash_original_method = "1694F41DCC8D039EBF419B4A0F2C4125", hash_generated_method = "71967B584992C360FE5BCB2EC4EA1DB9")
    public CharSequence getCharSequenceExtra(String name) {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_491684541 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_491684541 = mExtras == null ? null : mExtras.getCharSequence(name);
        addTaint(name.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_491684541.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_491684541;
        // ---------- Original Method ----------
        //return mExtras == null ? null : mExtras.getCharSequence(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:00.279 -0400", hash_original_method = "1C448816D9B902054FE9E8A698247DA2", hash_generated_method = "5948FCC76E41915890F1121B3A5935A8")
    public <T extends Parcelable> T getParcelableExtra(String name) {
        T varB4EAC82CA7396A68D541C85D26508E83_1724487198 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1724487198 = mExtras == null ? null : mExtras.<T>getParcelable(name);
        addTaint(name.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1724487198.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1724487198;
        // ---------- Original Method ----------
        //return mExtras == null ? null : mExtras.<T>getParcelable(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:00.284 -0400", hash_original_method = "28D360BBB773D3DC39CC6E8B3FB095BE", hash_generated_method = "5A66D6D95DF4438E7224D682C7D626B2")
    public Parcelable[] getParcelableArrayExtra(String name) {
        Parcelable[] varB4EAC82CA7396A68D541C85D26508E83_379814094 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_379814094 = mExtras == null ? null : mExtras.getParcelableArray(name);
        addTaint(name.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_379814094.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_379814094;
        // ---------- Original Method ----------
        //return mExtras == null ? null : mExtras.getParcelableArray(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:00.289 -0400", hash_original_method = "BB02D0F500EDCAC2282F912174ECF594", hash_generated_method = "CAEEBC55256162F049FE8B6DBA4D5140")
    public <T extends Parcelable> ArrayList<T> getParcelableArrayListExtra(String name) {
        ArrayList<T> varB4EAC82CA7396A68D541C85D26508E83_1162310895 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1162310895 = mExtras == null ? null : mExtras.<T>getParcelableArrayList(name);
        addTaint(name.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1162310895.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1162310895;
        // ---------- Original Method ----------
        //return mExtras == null ? null : mExtras.<T>getParcelableArrayList(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:00.290 -0400", hash_original_method = "9F4D1ACCAA6C6918CB97F661FEDB7260", hash_generated_method = "66E8A15FF46B94FB0EB9FCF5814F7D7D")
    public Serializable getSerializableExtra(String name) {
        Serializable varB4EAC82CA7396A68D541C85D26508E83_394954152 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_394954152 = mExtras == null ? null : mExtras.getSerializable(name);
        addTaint(name.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_394954152.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_394954152;
        // ---------- Original Method ----------
        //return mExtras == null ? null : mExtras.getSerializable(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:00.312 -0400", hash_original_method = "E5A5C9C6BF01CEEFEAABCB20BBD32323", hash_generated_method = "E1C6232D479993E5F7DCF4627ECDF93A")
    public ArrayList<Integer> getIntegerArrayListExtra(String name) {
        ArrayList<Integer> varB4EAC82CA7396A68D541C85D26508E83_1997295166 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1997295166 = mExtras == null ? null : mExtras.getIntegerArrayList(name);
        addTaint(name.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1997295166.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1997295166;
        // ---------- Original Method ----------
        //return mExtras == null ? null : mExtras.getIntegerArrayList(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:00.314 -0400", hash_original_method = "D8E538521D5877A04B9E1243CFFC8BD3", hash_generated_method = "80DD24714B9B1D681F4AD515DCF849D8")
    public ArrayList<String> getStringArrayListExtra(String name) {
        ArrayList<String> varB4EAC82CA7396A68D541C85D26508E83_302157488 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_302157488 = mExtras == null ? null : mExtras.getStringArrayList(name);
        addTaint(name.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_302157488.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_302157488;
        // ---------- Original Method ----------
        //return mExtras == null ? null : mExtras.getStringArrayList(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:00.316 -0400", hash_original_method = "3C0B0EF6206949D4005752F37A471C32", hash_generated_method = "163D692798F29F1F67EBAF6A66049C3B")
    public ArrayList<CharSequence> getCharSequenceArrayListExtra(String name) {
        ArrayList<CharSequence> varB4EAC82CA7396A68D541C85D26508E83_216405895 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_216405895 = mExtras == null ? null : mExtras.getCharSequenceArrayList(name);
        addTaint(name.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_216405895.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_216405895;
        // ---------- Original Method ----------
        //return mExtras == null ? null : mExtras.getCharSequenceArrayList(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:00.317 -0400", hash_original_method = "FE55BFBE9F4BF617BE3A0BE7101EDA89", hash_generated_method = "5E2BD1D5457B4A452A40559F5CC8F600")
    public boolean[] getBooleanArrayExtra(String name) {
        {
            Object var00FB540837D005E34C6B04656181AAF7_1291890490 = (mExtras.getBooleanArray(name));
        } //End flattened ternary
        addTaint(name.getTaint());
        boolean[] var503EB2F420079C4024483971CE5EDEA8_1063232009 = {getTaintBoolean()};
        return var503EB2F420079C4024483971CE5EDEA8_1063232009;
        // ---------- Original Method ----------
        //return mExtras == null ? null : mExtras.getBooleanArray(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:00.335 -0400", hash_original_method = "8982B2CEDDCF3062481CA9400546FBDD", hash_generated_method = "BDFC7D981BBF3A8A19B1B6B1FE0C23F3")
    public byte[] getByteArrayExtra(String name) {
        {
            Object var322B50C01B0B62460932D61E8C8FF801_1006571880 = (mExtras.getByteArray(name));
        } //End flattened ternary
        addTaint(name.getTaint());
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_295933237 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_295933237;
        // ---------- Original Method ----------
        //return mExtras == null ? null : mExtras.getByteArray(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:00.336 -0400", hash_original_method = "CD9B24503F7344F42640A5B885850704", hash_generated_method = "DF7884B2A112F38F124286D046F6F254")
    public short[] getShortArrayExtra(String name) {
        {
            Object var04AD7917A8202994626E7AF890795D1F_1365403032 = (mExtras.getShortArray(name));
        } //End flattened ternary
        addTaint(name.getTaint());
        short[] var48EE7E2DDF8A83602BC526873BD0F875_246921224 = {getTaintShort()};
        return var48EE7E2DDF8A83602BC526873BD0F875_246921224;
        // ---------- Original Method ----------
        //return mExtras == null ? null : mExtras.getShortArray(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:00.337 -0400", hash_original_method = "CC419D577155763512853EA59FC750C3", hash_generated_method = "695EA9FF409943996D7454A687C08BD5")
    public char[] getCharArrayExtra(String name) {
        {
            Object varD9F1732DD887AB31EBCB5E5E8A0BEC70_831207883 = (mExtras.getCharArray(name));
        } //End flattened ternary
        addTaint(name.getTaint());
        char[] var50607924ABD4C17119BAF3A1CE41C0EC_935748247 = {getTaintChar()};
        return var50607924ABD4C17119BAF3A1CE41C0EC_935748247;
        // ---------- Original Method ----------
        //return mExtras == null ? null : mExtras.getCharArray(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:00.350 -0400", hash_original_method = "0A82189594F324AE308815E53494E5B0", hash_generated_method = "10413C70051BEBF8570E556CB8E322BA")
    public int[] getIntArrayExtra(String name) {
        {
            Object varDE084C3791D41A1082090562E4AEDD61_1657325721 = (mExtras.getIntArray(name));
        } //End flattened ternary
        addTaint(name.getTaint());
        int[] varB4CCCA26F9DB9189C32F33E82D425CFB_215893670 = {getTaintInt()};
        return varB4CCCA26F9DB9189C32F33E82D425CFB_215893670;
        // ---------- Original Method ----------
        //return mExtras == null ? null : mExtras.getIntArray(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:00.351 -0400", hash_original_method = "2B191C1241796E74336A46C43420CA80", hash_generated_method = "16B3B6BE2E8A3F9ED87B9018D69E22DC")
    public long[] getLongArrayExtra(String name) {
        {
            Object var57E54E068A5207CC6FCC89D5EA86074A_1625287941 = (mExtras.getLongArray(name));
        } //End flattened ternary
        addTaint(name.getTaint());
        long[] var3908C7C3AF5171CEE1F112DAE77A5C4D_1111328414 = {getTaintLong()};
        return var3908C7C3AF5171CEE1F112DAE77A5C4D_1111328414;
        // ---------- Original Method ----------
        //return mExtras == null ? null : mExtras.getLongArray(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:00.364 -0400", hash_original_method = "8DC240B1B74093D697F56B17354B0D80", hash_generated_method = "9AADC1B09A5CAC0E27179137A106E9F5")
    public float[] getFloatArrayExtra(String name) {
        {
            Object var02187F0ED2F1F083AB042B5328108502_409622946 = (mExtras.getFloatArray(name));
        } //End flattened ternary
        addTaint(name.getTaint());
        float[] varB2C245003BAB9224CFB496218F7DAFE0_676684373 = {getTaintFloat()};
        return varB2C245003BAB9224CFB496218F7DAFE0_676684373;
        // ---------- Original Method ----------
        //return mExtras == null ? null : mExtras.getFloatArray(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:00.366 -0400", hash_original_method = "3975857C05E9D537152AB546E3F37275", hash_generated_method = "E665FCF9630E1153F016BF2E4FE65A28")
    public double[] getDoubleArrayExtra(String name) {
        {
            Object var28E231FBCD466F21C98163F52E08EB15_578544001 = (mExtras.getDoubleArray(name));
        } //End flattened ternary
        addTaint(name.getTaint());
        double[] var74D44D7D9EE6FE6C3433D694F869E521_219893124 = {getTaintDouble()};
        return var74D44D7D9EE6FE6C3433D694F869E521_219893124;
        // ---------- Original Method ----------
        //return mExtras == null ? null : mExtras.getDoubleArray(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:00.386 -0400", hash_original_method = "63A5C80C2A9C3E397356915A6EC07B98", hash_generated_method = "2D8EF89309E11B2F0729C08560973FE2")
    public String[] getStringArrayExtra(String name) {
        String[] varB4EAC82CA7396A68D541C85D26508E83_12591491 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_12591491 = mExtras == null ? null : mExtras.getStringArray(name);
        addTaint(name.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_12591491.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_12591491;
        // ---------- Original Method ----------
        //return mExtras == null ? null : mExtras.getStringArray(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:00.388 -0400", hash_original_method = "9443A9A4C1E608DAA4A110E653269318", hash_generated_method = "52EF97B536D4CD16BF1DCBA2203D83C1")
    public CharSequence[] getCharSequenceArrayExtra(String name) {
        CharSequence[] varB4EAC82CA7396A68D541C85D26508E83_915737556 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_915737556 = mExtras == null ? null : mExtras.getCharSequenceArray(name);
        addTaint(name.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_915737556.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_915737556;
        // ---------- Original Method ----------
        //return mExtras == null ? null : mExtras.getCharSequenceArray(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:00.400 -0400", hash_original_method = "913345623B540CBB75EA0BDD1C78C162", hash_generated_method = "E3C4AB5C11C9A9AD421B49A3B214479B")
    public Bundle getBundleExtra(String name) {
        Bundle varB4EAC82CA7396A68D541C85D26508E83_1217961251 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1217961251 = mExtras == null ? null : mExtras.getBundle(name);
        addTaint(name.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1217961251.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1217961251;
        // ---------- Original Method ----------
        //return mExtras == null ? null : mExtras.getBundle(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:00.401 -0400", hash_original_method = "657BCF405F69BF4C38A0897E9F672C84", hash_generated_method = "1D07F65C0E458EE1F9350017125F8503")
    @Deprecated
    public IBinder getIBinderExtra(String name) {
        IBinder varB4EAC82CA7396A68D541C85D26508E83_405461177 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_405461177 = mExtras == null ? null : mExtras.getIBinder(name);
        addTaint(name.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_405461177.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_405461177;
        // ---------- Original Method ----------
        //return mExtras == null ? null : mExtras.getIBinder(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:00.404 -0400", hash_original_method = "EF34C6BD33619501EBC4FFC15D7C460E", hash_generated_method = "B56EBBB3ACA6A32B0B72D280272E78C3")
    @Deprecated
    public Object getExtra(String name, Object defaultValue) {
        Object varB4EAC82CA7396A68D541C85D26508E83_779620313 = null; //Variable for return #1
        Object result;
        result = defaultValue;
        {
            Object result2;
            result2 = mExtras.get(name);
            {
                result = result2;
            } //End block
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_779620313 = result;
        addTaint(name.getTaint());
        addTaint(defaultValue.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_779620313.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_779620313;
        // ---------- Original Method ----------
        //Object result = defaultValue;
        //if (mExtras != null) {
            //Object result2 = mExtras.get(name);
            //if (result2 != null) {
                //result = result2;
            //}
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:00.408 -0400", hash_original_method = "6E509C3CEA63C12F8DB889EF86C70010", hash_generated_method = "E3FDAFE0F27077BF2C4D50EF41B27A1D")
    public Bundle getExtras() {
        Bundle varB4EAC82CA7396A68D541C85D26508E83_932654751 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_932654751 = (mExtras != null)
                ? new Bundle(mExtras)
                : null;
        varB4EAC82CA7396A68D541C85D26508E83_932654751.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_932654751;
        // ---------- Original Method ----------
        //return (mExtras != null)
                //? new Bundle(mExtras)
                //: null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:00.408 -0400", hash_original_method = "CE8F8E5E4A30C515D6BD9049A49703B9", hash_generated_method = "AAFF2B3F30006A25C2ECF10AD1750199")
    public int getFlags() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1267114062 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1267114062;
        // ---------- Original Method ----------
        //return mFlags;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:00.424 -0400", hash_original_method = "35A271981CF0FB3B138FC227A1ADE9BA", hash_generated_method = "C6A4053C7BC99D298F2E235DC2728494")
    public boolean isExcludingStopped() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1900368447 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1900368447;
        // ---------- Original Method ----------
        //return (mFlags&(FLAG_EXCLUDE_STOPPED_PACKAGES|FLAG_INCLUDE_STOPPED_PACKAGES))
                //== FLAG_EXCLUDE_STOPPED_PACKAGES;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:00.425 -0400", hash_original_method = "D6B19F05A1BF219922EA06A43EF822A3", hash_generated_method = "B2B6325E94BBD4672C281DDBFB445483")
    public String getPackage() {
        String varB4EAC82CA7396A68D541C85D26508E83_1512837135 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1512837135 = mPackage;
        varB4EAC82CA7396A68D541C85D26508E83_1512837135.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1512837135;
        // ---------- Original Method ----------
        //return mPackage;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:00.439 -0400", hash_original_method = "3446011C83A765263A4F2617180E656B", hash_generated_method = "53843C6C8637FED6DF69D8FB3FDE06A7")
    public ComponentName getComponent() {
        ComponentName varB4EAC82CA7396A68D541C85D26508E83_12451731 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_12451731 = mComponent;
        varB4EAC82CA7396A68D541C85D26508E83_12451731.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_12451731;
        // ---------- Original Method ----------
        //return mComponent;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:00.441 -0400", hash_original_method = "418D2917B5B7B0B035ED428CB7C119CA", hash_generated_method = "BB4676AA9D80A380C470EB90F2EA6BF9")
    public Rect getSourceBounds() {
        Rect varB4EAC82CA7396A68D541C85D26508E83_1805176561 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1805176561 = mSourceBounds;
        varB4EAC82CA7396A68D541C85D26508E83_1805176561.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1805176561;
        // ---------- Original Method ----------
        //return mSourceBounds;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:00.465 -0400", hash_original_method = "CDA09128651728DC4DB1AA79DEAE44CB", hash_generated_method = "728DF7E3E799D0222A36D5AF2ADE7473")
    public ComponentName resolveActivity(PackageManager pm) {
        ComponentName varB4EAC82CA7396A68D541C85D26508E83_47405243 = null; //Variable for return #1
        ComponentName varB4EAC82CA7396A68D541C85D26508E83_1526041241 = null; //Variable for return #2
        ComponentName varB4EAC82CA7396A68D541C85D26508E83_625196196 = null; //Variable for return #3
        {
            varB4EAC82CA7396A68D541C85D26508E83_47405243 = mComponent;
        } //End block
        ResolveInfo info;
        info = pm.resolveActivity(
            this, PackageManager.MATCH_DEFAULT_ONLY);
        {
            varB4EAC82CA7396A68D541C85D26508E83_1526041241 = new ComponentName(
                    info.activityInfo.applicationInfo.packageName,
                    info.activityInfo.name);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_625196196 = null;
        addTaint(pm.getTaint());
        ComponentName varA7E53CE21691AB073D9660D615818899_787230101; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_787230101 = varB4EAC82CA7396A68D541C85D26508E83_47405243;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_787230101 = varB4EAC82CA7396A68D541C85D26508E83_1526041241;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_787230101 = varB4EAC82CA7396A68D541C85D26508E83_625196196;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_787230101.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_787230101;
        // ---------- Original Method ----------
        //if (mComponent != null) {
            //return mComponent;
        //}
        //ResolveInfo info = pm.resolveActivity(
            //this, PackageManager.MATCH_DEFAULT_ONLY);
        //if (info != null) {
            //return new ComponentName(
                    //info.activityInfo.applicationInfo.packageName,
                    //info.activityInfo.name);
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:00.489 -0400", hash_original_method = "4C4C454D517012EF1DC091F981BC8CF0", hash_generated_method = "E634BFC701FCCD7C8F81CF2CAA643DCB")
    public ActivityInfo resolveActivityInfo(PackageManager pm, int flags) {
        ActivityInfo varB4EAC82CA7396A68D541C85D26508E83_2016470634 = null; //Variable for return #1
        ActivityInfo ai;
        ai = null;
        {
            try 
            {
                ai = pm.getActivityInfo(mComponent, flags);
            } //End block
            catch (PackageManager.NameNotFoundException e)
            { }
        } //End block
        {
            ResolveInfo info;
            info = pm.resolveActivity(
                this, PackageManager.MATCH_DEFAULT_ONLY | flags);
            {
                ai = info.activityInfo;
            } //End block
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_2016470634 = ai;
        addTaint(pm.getTaint());
        addTaint(flags);
        varB4EAC82CA7396A68D541C85D26508E83_2016470634.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2016470634;
        // ---------- Original Method ----------
        //ActivityInfo ai = null;
        //if (mComponent != null) {
            //try {
                //ai = pm.getActivityInfo(mComponent, flags);
            //} catch (PackageManager.NameNotFoundException e) {
            //}
        //} else {
            //ResolveInfo info = pm.resolveActivity(
                //this, PackageManager.MATCH_DEFAULT_ONLY | flags);
            //if (info != null) {
                //ai = info.activityInfo;
            //}
        //}
        //return ai;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:00.490 -0400", hash_original_method = "7FAE192103F51EFC97895E1DA306617B", hash_generated_method = "05E295E80B5C9A782FEC8E327F06E382")
    public Intent setAction(String action) {
        Intent varB4EAC82CA7396A68D541C85D26508E83_1044066225 = null; //Variable for return #1
        mAction = action != null ? action.intern() : null;
        varB4EAC82CA7396A68D541C85D26508E83_1044066225 = this;
        varB4EAC82CA7396A68D541C85D26508E83_1044066225.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1044066225;
        // ---------- Original Method ----------
        //mAction = action != null ? action.intern() : null;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:00.497 -0400", hash_original_method = "7ABFC734F037DFB16AA9737CCDEC3D90", hash_generated_method = "C3621F94CDF26FE01C0730DB86DB48EF")
    public Intent setData(Uri data) {
        Intent varB4EAC82CA7396A68D541C85D26508E83_614913536 = null; //Variable for return #1
        mData = data;
        mType = null;
        varB4EAC82CA7396A68D541C85D26508E83_614913536 = this;
        varB4EAC82CA7396A68D541C85D26508E83_614913536.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_614913536;
        // ---------- Original Method ----------
        //mData = data;
        //mType = null;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:00.514 -0400", hash_original_method = "797A6BD6371209544F539CFD71A54CFB", hash_generated_method = "9AFAAE6419EFC7132AFD7C40B9895DD7")
    public Intent setType(String type) {
        Intent varB4EAC82CA7396A68D541C85D26508E83_226407726 = null; //Variable for return #1
        mData = null;
        mType = type;
        varB4EAC82CA7396A68D541C85D26508E83_226407726 = this;
        varB4EAC82CA7396A68D541C85D26508E83_226407726.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_226407726;
        // ---------- Original Method ----------
        //mData = null;
        //mType = type;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:00.525 -0400", hash_original_method = "43AA0CE5E260B0FA5B26C9FC36ABF327", hash_generated_method = "15CA3158EB3F0A6B22FD81B76B180315")
    public Intent setDataAndType(Uri data, String type) {
        Intent varB4EAC82CA7396A68D541C85D26508E83_2004646434 = null; //Variable for return #1
        mData = data;
        mType = type;
        varB4EAC82CA7396A68D541C85D26508E83_2004646434 = this;
        varB4EAC82CA7396A68D541C85D26508E83_2004646434.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2004646434;
        // ---------- Original Method ----------
        //mData = data;
        //mType = type;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:00.526 -0400", hash_original_method = "0929EFE348972B36CEEED1BD1629D6D4", hash_generated_method = "3A32097589E38A24D252CB3A706D891B")
    public Intent addCategory(String category) {
        Intent varB4EAC82CA7396A68D541C85D26508E83_1817242034 = null; //Variable for return #1
        {
            mCategories = new HashSet<String>();
        } //End block
        mCategories.add(category.intern());
        varB4EAC82CA7396A68D541C85D26508E83_1817242034 = this;
        addTaint(category.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1817242034.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1817242034;
        // ---------- Original Method ----------
        //if (mCategories == null) {
            //mCategories = new HashSet<String>();
        //}
        //mCategories.add(category.intern());
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:00.540 -0400", hash_original_method = "CFCF8DDC5EB4FA9E7ADB1DEB9CFAFA89", hash_generated_method = "DCE40AE17E6C7F19F5AE2EBF61CDC71F")
    public void removeCategory(String category) {
        {
            mCategories.remove(category);
            {
                boolean varF3E827929A4D5BB767FBFDA33518C46A_1754932313 = (mCategories.size() == 0);
                {
                    mCategories = null;
                } //End block
            } //End collapsed parenthetic
        } //End block
        addTaint(category.getTaint());
        // ---------- Original Method ----------
        //if (mCategories != null) {
            //mCategories.remove(category);
            //if (mCategories.size() == 0) {
                //mCategories = null;
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:00.541 -0400", hash_original_method = "4143B41199E8262105CB671C15097E99", hash_generated_method = "E2734F132E953885ADC659466DA63AC6")
    public void setSelector(Intent selector) {
        {
            boolean var3775AC94E687E01878B10DC95B8A223E_1579708321 = (selector == this);
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException(
                    "Intent being set as a selector of itself");
            } //End block
        } //End collapsed parenthetic
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException(
                    "Can't set selector when package name is already set");
        } //End block
        mSelector = selector;
        // ---------- Original Method ----------
        //if (selector == this) {
            //throw new IllegalArgumentException(
                    //"Intent being set as a selector of itself");
        //}
        //if (selector != null && mPackage != null) {
            //throw new IllegalArgumentException(
                    //"Can't set selector when package name is already set");
        //}
        //mSelector = selector;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:00.543 -0400", hash_original_method = "E358DED697FF080F831811D5D578FEBC", hash_generated_method = "484B3E9EA1EA30BD2D973F5D488F146F")
    public Intent putExtra(String name, boolean value) {
        Intent varB4EAC82CA7396A68D541C85D26508E83_998944783 = null; //Variable for return #1
        {
            mExtras = new Bundle();
        } //End block
        mExtras.putBoolean(name, value);
        varB4EAC82CA7396A68D541C85D26508E83_998944783 = this;
        addTaint(name.getTaint());
        addTaint(value);
        varB4EAC82CA7396A68D541C85D26508E83_998944783.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_998944783;
        // ---------- Original Method ----------
        //if (mExtras == null) {
            //mExtras = new Bundle();
        //}
        //mExtras.putBoolean(name, value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:00.563 -0400", hash_original_method = "983951350B18B30CD357EFC4A5F8C533", hash_generated_method = "F31BE879674ACF52EB352BBF43354222")
    public Intent putExtra(String name, byte value) {
        Intent varB4EAC82CA7396A68D541C85D26508E83_1806242989 = null; //Variable for return #1
        {
            mExtras = new Bundle();
        } //End block
        mExtras.putByte(name, value);
        varB4EAC82CA7396A68D541C85D26508E83_1806242989 = this;
        addTaint(name.getTaint());
        addTaint(value);
        varB4EAC82CA7396A68D541C85D26508E83_1806242989.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1806242989;
        // ---------- Original Method ----------
        //if (mExtras == null) {
            //mExtras = new Bundle();
        //}
        //mExtras.putByte(name, value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:00.566 -0400", hash_original_method = "44F743D0FCF3A3B09735F92996DFB8B8", hash_generated_method = "AA3FFB2E305CA9AC820613A124A2E3BA")
    public Intent putExtra(String name, char value) {
        Intent varB4EAC82CA7396A68D541C85D26508E83_1908833689 = null; //Variable for return #1
        {
            mExtras = new Bundle();
        } //End block
        mExtras.putChar(name, value);
        varB4EAC82CA7396A68D541C85D26508E83_1908833689 = this;
        addTaint(name.getTaint());
        addTaint(value);
        varB4EAC82CA7396A68D541C85D26508E83_1908833689.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1908833689;
        // ---------- Original Method ----------
        //if (mExtras == null) {
            //mExtras = new Bundle();
        //}
        //mExtras.putChar(name, value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:00.584 -0400", hash_original_method = "D504428E6A64263CB337167E8E11D24B", hash_generated_method = "05C12737134FE166718EB204373C0CE5")
    public Intent putExtra(String name, short value) {
        Intent varB4EAC82CA7396A68D541C85D26508E83_2111654834 = null; //Variable for return #1
        {
            mExtras = new Bundle();
        } //End block
        mExtras.putShort(name, value);
        varB4EAC82CA7396A68D541C85D26508E83_2111654834 = this;
        addTaint(name.getTaint());
        addTaint(value);
        varB4EAC82CA7396A68D541C85D26508E83_2111654834.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2111654834;
        // ---------- Original Method ----------
        //if (mExtras == null) {
            //mExtras = new Bundle();
        //}
        //mExtras.putShort(name, value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:00.586 -0400", hash_original_method = "0F8D3938F71F1CBC0AF93312AEF5DBAF", hash_generated_method = "19EFBDF3015F20C237BDB8B70BDB5433")
    public Intent putExtra(String name, int value) {
        Intent varB4EAC82CA7396A68D541C85D26508E83_1866554445 = null; //Variable for return #1
        {
            mExtras = new Bundle();
        } //End block
        mExtras.putInt(name, value);
        varB4EAC82CA7396A68D541C85D26508E83_1866554445 = this;
        addTaint(name.getTaint());
        addTaint(value);
        varB4EAC82CA7396A68D541C85D26508E83_1866554445.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1866554445;
        // ---------- Original Method ----------
        //if (mExtras == null) {
            //mExtras = new Bundle();
        //}
        //mExtras.putInt(name, value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:00.591 -0400", hash_original_method = "210CE6920B09DE82954A1910A2E05BDA", hash_generated_method = "74EAE17762C06F16AD18C7B26DD12010")
    public Intent putExtra(String name, long value) {
        Intent varB4EAC82CA7396A68D541C85D26508E83_2059178968 = null; //Variable for return #1
        {
            mExtras = new Bundle();
        } //End block
        mExtras.putLong(name, value);
        varB4EAC82CA7396A68D541C85D26508E83_2059178968 = this;
        addTaint(name.getTaint());
        addTaint(value);
        varB4EAC82CA7396A68D541C85D26508E83_2059178968.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2059178968;
        // ---------- Original Method ----------
        //if (mExtras == null) {
            //mExtras = new Bundle();
        //}
        //mExtras.putLong(name, value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:00.600 -0400", hash_original_method = "5563D3D5FF8C4FA36F1584B48F1347B6", hash_generated_method = "654454210BE0D8A938732C58C0027F88")
    public Intent putExtra(String name, float value) {
        Intent varB4EAC82CA7396A68D541C85D26508E83_67150384 = null; //Variable for return #1
        {
            mExtras = new Bundle();
        } //End block
        mExtras.putFloat(name, value);
        varB4EAC82CA7396A68D541C85D26508E83_67150384 = this;
        addTaint(name.getTaint());
        addTaint(value);
        varB4EAC82CA7396A68D541C85D26508E83_67150384.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_67150384;
        // ---------- Original Method ----------
        //if (mExtras == null) {
            //mExtras = new Bundle();
        //}
        //mExtras.putFloat(name, value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:00.619 -0400", hash_original_method = "FDAB0726590DA4887C7F048C162A9588", hash_generated_method = "BB71749727E36630657CE77B72F07EC7")
    public Intent putExtra(String name, double value) {
        Intent varB4EAC82CA7396A68D541C85D26508E83_949373284 = null; //Variable for return #1
        {
            mExtras = new Bundle();
        } //End block
        mExtras.putDouble(name, value);
        varB4EAC82CA7396A68D541C85D26508E83_949373284 = this;
        addTaint(name.getTaint());
        addTaint(value);
        varB4EAC82CA7396A68D541C85D26508E83_949373284.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_949373284;
        // ---------- Original Method ----------
        //if (mExtras == null) {
            //mExtras = new Bundle();
        //}
        //mExtras.putDouble(name, value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:00.633 -0400", hash_original_method = "FFA94FE476B4FC82FDFAB8191F06F76A", hash_generated_method = "3226CB54567C481134A70699A7DEE8B4")
    public Intent putExtra(String name, String value) {
        Intent varB4EAC82CA7396A68D541C85D26508E83_582854287 = null; //Variable for return #1
        {
            mExtras = new Bundle();
        } //End block
        mExtras.putString(name, value);
        varB4EAC82CA7396A68D541C85D26508E83_582854287 = this;
        addTaint(name.getTaint());
        addTaint(value.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_582854287.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_582854287;
        // ---------- Original Method ----------
        //if (mExtras == null) {
            //mExtras = new Bundle();
        //}
        //mExtras.putString(name, value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:00.635 -0400", hash_original_method = "C3AAC0183A1B956AD55E80A8556AFB71", hash_generated_method = "B13FC924A5E4430E3E9F13E559217F2C")
    public Intent putExtra(String name, CharSequence value) {
        Intent varB4EAC82CA7396A68D541C85D26508E83_2133091638 = null; //Variable for return #1
        {
            mExtras = new Bundle();
        } //End block
        mExtras.putCharSequence(name, value);
        varB4EAC82CA7396A68D541C85D26508E83_2133091638 = this;
        addTaint(name.getTaint());
        addTaint(value.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_2133091638.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2133091638;
        // ---------- Original Method ----------
        //if (mExtras == null) {
            //mExtras = new Bundle();
        //}
        //mExtras.putCharSequence(name, value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:00.653 -0400", hash_original_method = "49EBB52F87B2F24E715C34795BBE3213", hash_generated_method = "12681AF125E374E1A0D2EFA92C2C804C")
    public Intent putExtra(String name, Parcelable value) {
        Intent varB4EAC82CA7396A68D541C85D26508E83_882029833 = null; //Variable for return #1
        {
            mExtras = new Bundle();
        } //End block
        mExtras.putParcelable(name, value);
        varB4EAC82CA7396A68D541C85D26508E83_882029833 = this;
        addTaint(name.getTaint());
        addTaint(value.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_882029833.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_882029833;
        // ---------- Original Method ----------
        //if (mExtras == null) {
            //mExtras = new Bundle();
        //}
        //mExtras.putParcelable(name, value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:00.658 -0400", hash_original_method = "478D5F3649CF3C1019BEE6D895BDE15B", hash_generated_method = "A2B877A8FDB88697FA725EBFD6F5E247")
    public Intent putExtra(String name, Parcelable[] value) {
        Intent varB4EAC82CA7396A68D541C85D26508E83_2017564994 = null; //Variable for return #1
        {
            mExtras = new Bundle();
        } //End block
        mExtras.putParcelableArray(name, value);
        varB4EAC82CA7396A68D541C85D26508E83_2017564994 = this;
        addTaint(name.getTaint());
        addTaint(value[0].getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_2017564994.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2017564994;
        // ---------- Original Method ----------
        //if (mExtras == null) {
            //mExtras = new Bundle();
        //}
        //mExtras.putParcelableArray(name, value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:00.659 -0400", hash_original_method = "7056A89E2AB58239EE1F715B825304C9", hash_generated_method = "D2D4C12B0B8273BE214E8476EE6BD87C")
    public Intent putParcelableArrayListExtra(String name, ArrayList<? extends Parcelable> value) {
        Intent varB4EAC82CA7396A68D541C85D26508E83_859986214 = null; //Variable for return #1
        {
            mExtras = new Bundle();
        } //End block
        mExtras.putParcelableArrayList(name, value);
        varB4EAC82CA7396A68D541C85D26508E83_859986214 = this;
        addTaint(name.getTaint());
        addTaint(value.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_859986214.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_859986214;
        // ---------- Original Method ----------
        //if (mExtras == null) {
            //mExtras = new Bundle();
        //}
        //mExtras.putParcelableArrayList(name, value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:00.684 -0400", hash_original_method = "25611C5EA858F4B01007B3F78DCCE949", hash_generated_method = "7B6EA7219AA12DD67BA8CFFAD1DB67AB")
    public Intent putIntegerArrayListExtra(String name, ArrayList<Integer> value) {
        Intent varB4EAC82CA7396A68D541C85D26508E83_859833001 = null; //Variable for return #1
        {
            mExtras = new Bundle();
        } //End block
        mExtras.putIntegerArrayList(name, value);
        varB4EAC82CA7396A68D541C85D26508E83_859833001 = this;
        addTaint(name.getTaint());
        addTaint(value.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_859833001.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_859833001;
        // ---------- Original Method ----------
        //if (mExtras == null) {
            //mExtras = new Bundle();
        //}
        //mExtras.putIntegerArrayList(name, value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:00.686 -0400", hash_original_method = "FCCCC0193355017A3AB410227E2B8C63", hash_generated_method = "8C28141BC6D135410FD08205FB3F6996")
    public Intent putStringArrayListExtra(String name, ArrayList<String> value) {
        Intent varB4EAC82CA7396A68D541C85D26508E83_1245260736 = null; //Variable for return #1
        {
            mExtras = new Bundle();
        } //End block
        mExtras.putStringArrayList(name, value);
        varB4EAC82CA7396A68D541C85D26508E83_1245260736 = this;
        addTaint(name.getTaint());
        addTaint(value.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1245260736.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1245260736;
        // ---------- Original Method ----------
        //if (mExtras == null) {
            //mExtras = new Bundle();
        //}
        //mExtras.putStringArrayList(name, value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:00.702 -0400", hash_original_method = "56169BFB83B473D5686B58CC3B07DAC6", hash_generated_method = "B476E266410245078EAA5701D4E98339")
    public Intent putCharSequenceArrayListExtra(String name, ArrayList<CharSequence> value) {
        Intent varB4EAC82CA7396A68D541C85D26508E83_836323051 = null; //Variable for return #1
        {
            mExtras = new Bundle();
        } //End block
        mExtras.putCharSequenceArrayList(name, value);
        varB4EAC82CA7396A68D541C85D26508E83_836323051 = this;
        addTaint(name.getTaint());
        addTaint(value.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_836323051.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_836323051;
        // ---------- Original Method ----------
        //if (mExtras == null) {
            //mExtras = new Bundle();
        //}
        //mExtras.putCharSequenceArrayList(name, value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:00.717 -0400", hash_original_method = "050AC720F09B8AB16CBB253B94EE49E6", hash_generated_method = "086967F5E9650E942A47815D287B9027")
    public Intent putExtra(String name, Serializable value) {
        Intent varB4EAC82CA7396A68D541C85D26508E83_964323635 = null; //Variable for return #1
        {
            mExtras = new Bundle();
        } //End block
        mExtras.putSerializable(name, value);
        varB4EAC82CA7396A68D541C85D26508E83_964323635 = this;
        addTaint(name.getTaint());
        addTaint(value.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_964323635.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_964323635;
        // ---------- Original Method ----------
        //if (mExtras == null) {
            //mExtras = new Bundle();
        //}
        //mExtras.putSerializable(name, value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:00.719 -0400", hash_original_method = "6C30326EEBD8635124BFC9218A6B6422", hash_generated_method = "3CDA59C7C70909D5491061242A13D052")
    public Intent putExtra(String name, boolean[] value) {
        Intent varB4EAC82CA7396A68D541C85D26508E83_1380461731 = null; //Variable for return #1
        {
            mExtras = new Bundle();
        } //End block
        mExtras.putBooleanArray(name, value);
        varB4EAC82CA7396A68D541C85D26508E83_1380461731 = this;
        addTaint(name.getTaint());
        addTaint(value[0]);
        varB4EAC82CA7396A68D541C85D26508E83_1380461731.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1380461731;
        // ---------- Original Method ----------
        //if (mExtras == null) {
            //mExtras = new Bundle();
        //}
        //mExtras.putBooleanArray(name, value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:00.734 -0400", hash_original_method = "4D4788E50F7779B1D72BD45B4E76C775", hash_generated_method = "98DB42558B65F300C6540447068999C0")
    public Intent putExtra(String name, byte[] value) {
        Intent varB4EAC82CA7396A68D541C85D26508E83_17221351 = null; //Variable for return #1
        {
            mExtras = new Bundle();
        } //End block
        mExtras.putByteArray(name, value);
        varB4EAC82CA7396A68D541C85D26508E83_17221351 = this;
        addTaint(name.getTaint());
        addTaint(value[0]);
        varB4EAC82CA7396A68D541C85D26508E83_17221351.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_17221351;
        // ---------- Original Method ----------
        //if (mExtras == null) {
            //mExtras = new Bundle();
        //}
        //mExtras.putByteArray(name, value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:00.736 -0400", hash_original_method = "521E65BC95668B6A66CE17103975D2B1", hash_generated_method = "4F3328BA4652F7CC7A75E8F2224E84E5")
    public Intent putExtra(String name, short[] value) {
        Intent varB4EAC82CA7396A68D541C85D26508E83_299120696 = null; //Variable for return #1
        {
            mExtras = new Bundle();
        } //End block
        mExtras.putShortArray(name, value);
        varB4EAC82CA7396A68D541C85D26508E83_299120696 = this;
        addTaint(name.getTaint());
        addTaint(value[0]);
        varB4EAC82CA7396A68D541C85D26508E83_299120696.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_299120696;
        // ---------- Original Method ----------
        //if (mExtras == null) {
            //mExtras = new Bundle();
        //}
        //mExtras.putShortArray(name, value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:00.751 -0400", hash_original_method = "CEC6E945D8554F36BF71D2D38B61B7EF", hash_generated_method = "A88320E360AFD4DF572BDBFD127412F5")
    public Intent putExtra(String name, char[] value) {
        Intent varB4EAC82CA7396A68D541C85D26508E83_1945970101 = null; //Variable for return #1
        {
            mExtras = new Bundle();
        } //End block
        mExtras.putCharArray(name, value);
        varB4EAC82CA7396A68D541C85D26508E83_1945970101 = this;
        addTaint(name.getTaint());
        addTaint(value[0]);
        varB4EAC82CA7396A68D541C85D26508E83_1945970101.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1945970101;
        // ---------- Original Method ----------
        //if (mExtras == null) {
            //mExtras = new Bundle();
        //}
        //mExtras.putCharArray(name, value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:00.762 -0400", hash_original_method = "AD8C8F2DD7A3862E32E54CE0FBFF67CE", hash_generated_method = "342D3F9DDE4154E30FD4D4AF4B9F764C")
    public Intent putExtra(String name, int[] value) {
        Intent varB4EAC82CA7396A68D541C85D26508E83_1996514200 = null; //Variable for return #1
        {
            mExtras = new Bundle();
        } //End block
        mExtras.putIntArray(name, value);
        varB4EAC82CA7396A68D541C85D26508E83_1996514200 = this;
        addTaint(name.getTaint());
        addTaint(value[0]);
        varB4EAC82CA7396A68D541C85D26508E83_1996514200.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1996514200;
        // ---------- Original Method ----------
        //if (mExtras == null) {
            //mExtras = new Bundle();
        //}
        //mExtras.putIntArray(name, value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:00.777 -0400", hash_original_method = "EEA209751D515DE89BAC56042276C483", hash_generated_method = "81B5C1F472FA8BF28A6FF79C88CE00F7")
    public Intent putExtra(String name, long[] value) {
        Intent varB4EAC82CA7396A68D541C85D26508E83_1798366602 = null; //Variable for return #1
        {
            mExtras = new Bundle();
        } //End block
        mExtras.putLongArray(name, value);
        varB4EAC82CA7396A68D541C85D26508E83_1798366602 = this;
        addTaint(name.getTaint());
        addTaint(value[0]);
        varB4EAC82CA7396A68D541C85D26508E83_1798366602.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1798366602;
        // ---------- Original Method ----------
        //if (mExtras == null) {
            //mExtras = new Bundle();
        //}
        //mExtras.putLongArray(name, value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:00.797 -0400", hash_original_method = "F6CA728A57FEA4C77AF7294872C7D495", hash_generated_method = "9276EF15DA821F0861E4B8422325069F")
    public Intent putExtra(String name, float[] value) {
        Intent varB4EAC82CA7396A68D541C85D26508E83_967256806 = null; //Variable for return #1
        {
            mExtras = new Bundle();
        } //End block
        mExtras.putFloatArray(name, value);
        varB4EAC82CA7396A68D541C85D26508E83_967256806 = this;
        addTaint(name.getTaint());
        addTaint(value[0]);
        varB4EAC82CA7396A68D541C85D26508E83_967256806.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_967256806;
        // ---------- Original Method ----------
        //if (mExtras == null) {
            //mExtras = new Bundle();
        //}
        //mExtras.putFloatArray(name, value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:00.810 -0400", hash_original_method = "3F155E9B232579FD3DCD2D3FAECEA79F", hash_generated_method = "9DD37226A5BA731C9E0BE725466ED6C4")
    public Intent putExtra(String name, double[] value) {
        Intent varB4EAC82CA7396A68D541C85D26508E83_1488737684 = null; //Variable for return #1
        {
            mExtras = new Bundle();
        } //End block
        mExtras.putDoubleArray(name, value);
        varB4EAC82CA7396A68D541C85D26508E83_1488737684 = this;
        addTaint(name.getTaint());
        addTaint(value[0]);
        varB4EAC82CA7396A68D541C85D26508E83_1488737684.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1488737684;
        // ---------- Original Method ----------
        //if (mExtras == null) {
            //mExtras = new Bundle();
        //}
        //mExtras.putDoubleArray(name, value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:00.825 -0400", hash_original_method = "4105C6229BFDC8C2B450D57FAD8A78CA", hash_generated_method = "2B5BC0AE45E8F7B914B5284E4E085EA2")
    public Intent putExtra(String name, String[] value) {
        Intent varB4EAC82CA7396A68D541C85D26508E83_1354971919 = null; //Variable for return #1
        {
            mExtras = new Bundle();
        } //End block
        mExtras.putStringArray(name, value);
        varB4EAC82CA7396A68D541C85D26508E83_1354971919 = this;
        addTaint(name.getTaint());
        addTaint(value[0].getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1354971919.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1354971919;
        // ---------- Original Method ----------
        //if (mExtras == null) {
            //mExtras = new Bundle();
        //}
        //mExtras.putStringArray(name, value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:00.826 -0400", hash_original_method = "5B5979B9E2BB6EA8D0974FC96788F02A", hash_generated_method = "78BADA4FB6FFF74B3ADED3D2372C343E")
    public Intent putExtra(String name, CharSequence[] value) {
        Intent varB4EAC82CA7396A68D541C85D26508E83_355757102 = null; //Variable for return #1
        {
            mExtras = new Bundle();
        } //End block
        mExtras.putCharSequenceArray(name, value);
        varB4EAC82CA7396A68D541C85D26508E83_355757102 = this;
        addTaint(name.getTaint());
        addTaint(value[0].getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_355757102.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_355757102;
        // ---------- Original Method ----------
        //if (mExtras == null) {
            //mExtras = new Bundle();
        //}
        //mExtras.putCharSequenceArray(name, value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:00.837 -0400", hash_original_method = "79076492A33BAA4B69A022CE305E32E8", hash_generated_method = "D386D23887F990CEF7DDA31B206EEE4F")
    public Intent putExtra(String name, Bundle value) {
        Intent varB4EAC82CA7396A68D541C85D26508E83_894108868 = null; //Variable for return #1
        {
            mExtras = new Bundle();
        } //End block
        mExtras.putBundle(name, value);
        varB4EAC82CA7396A68D541C85D26508E83_894108868 = this;
        addTaint(name.getTaint());
        addTaint(value.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_894108868.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_894108868;
        // ---------- Original Method ----------
        //if (mExtras == null) {
            //mExtras = new Bundle();
        //}
        //mExtras.putBundle(name, value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:00.964 -0400", hash_original_method = "1AE089536D0C6059F1731DCA673BC867", hash_generated_method = "E9B9843B03547113AB3A97D30D835975")
    @Deprecated
    public Intent putExtra(String name, IBinder value) {
        Intent varB4EAC82CA7396A68D541C85D26508E83_2015515154 = null; //Variable for return #1
        {
            mExtras = new Bundle();
        } //End block
        mExtras.putIBinder(name, value);
        varB4EAC82CA7396A68D541C85D26508E83_2015515154 = this;
        addTaint(name.getTaint());
        addTaint(value.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_2015515154.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2015515154;
        // ---------- Original Method ----------
        //if (mExtras == null) {
            //mExtras = new Bundle();
        //}
        //mExtras.putIBinder(name, value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:00.965 -0400", hash_original_method = "49B5D5019DC4C58D3432134ADBF206CE", hash_generated_method = "3CE018F3C7F388DA34D99D4FBA7DCF36")
    public Intent putExtras(Intent src) {
        Intent varB4EAC82CA7396A68D541C85D26508E83_907957558 = null; //Variable for return #1
        {
            {
                mExtras = new Bundle(src.mExtras);
            } //End block
            {
                mExtras.putAll(src.mExtras);
            } //End block
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_907957558 = this;
        varB4EAC82CA7396A68D541C85D26508E83_907957558.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_907957558;
        // ---------- Original Method ----------
        //if (src.mExtras != null) {
            //if (mExtras == null) {
                //mExtras = new Bundle(src.mExtras);
            //} else {
                //mExtras.putAll(src.mExtras);
            //}
        //}
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:00.967 -0400", hash_original_method = "300503D60C48D249178D35D7CDB92339", hash_generated_method = "23AE16F71D5874561C2C3B76CB66BF79")
    public Intent putExtras(Bundle extras) {
        Intent varB4EAC82CA7396A68D541C85D26508E83_1586069310 = null; //Variable for return #1
        {
            mExtras = new Bundle();
        } //End block
        mExtras.putAll(extras);
        varB4EAC82CA7396A68D541C85D26508E83_1586069310 = this;
        addTaint(extras.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1586069310.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1586069310;
        // ---------- Original Method ----------
        //if (mExtras == null) {
            //mExtras = new Bundle();
        //}
        //mExtras.putAll(extras);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:00.976 -0400", hash_original_method = "9273ED8AEDE591E5D2100B41909C8A11", hash_generated_method = "EA12F6B6B4F3C1C67C03778A5B778B1C")
    public Intent replaceExtras(Intent src) {
        Intent varB4EAC82CA7396A68D541C85D26508E83_135822800 = null; //Variable for return #1
        mExtras = src.mExtras != null ? new Bundle(src.mExtras) : null;
        varB4EAC82CA7396A68D541C85D26508E83_135822800 = this;
        varB4EAC82CA7396A68D541C85D26508E83_135822800.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_135822800;
        // ---------- Original Method ----------
        //mExtras = src.mExtras != null ? new Bundle(src.mExtras) : null;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:00.978 -0400", hash_original_method = "CBF42E478CC456FFD10D6777F319F0BD", hash_generated_method = "D21ABEF0522E548E2A54C7EFC6E1DF80")
    public Intent replaceExtras(Bundle extras) {
        Intent varB4EAC82CA7396A68D541C85D26508E83_2101923483 = null; //Variable for return #1
        mExtras = extras != null ? new Bundle(extras) : null;
        varB4EAC82CA7396A68D541C85D26508E83_2101923483 = this;
        varB4EAC82CA7396A68D541C85D26508E83_2101923483.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2101923483;
        // ---------- Original Method ----------
        //mExtras = extras != null ? new Bundle(extras) : null;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:00.979 -0400", hash_original_method = "84A47E40481CBF5586A9CCDD8AD7D655", hash_generated_method = "937D92058D6E6A5721D0FE828202297E")
    public void removeExtra(String name) {
        {
            mExtras.remove(name);
            {
                boolean var7E8DAB3F8FE8420FBC71F6F461E1A32B_2139690361 = (mExtras.size() == 0);
                {
                    mExtras = null;
                } //End block
            } //End collapsed parenthetic
        } //End block
        addTaint(name.getTaint());
        // ---------- Original Method ----------
        //if (mExtras != null) {
            //mExtras.remove(name);
            //if (mExtras.size() == 0) {
                //mExtras = null;
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:01.005 -0400", hash_original_method = "240F6D2BBC198957F28DF199FF71FA51", hash_generated_method = "3EBEF97F729730550E05EFF9B7BE24BA")
    public Intent setFlags(int flags) {
        Intent varB4EAC82CA7396A68D541C85D26508E83_285501664 = null; //Variable for return #1
        mFlags = flags;
        varB4EAC82CA7396A68D541C85D26508E83_285501664 = this;
        varB4EAC82CA7396A68D541C85D26508E83_285501664.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_285501664;
        // ---------- Original Method ----------
        //mFlags = flags;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:01.006 -0400", hash_original_method = "324CD70B42F70589537B5DD566C39001", hash_generated_method = "254CE7F17B3587DBC6277BA4904950ED")
    public Intent addFlags(int flags) {
        Intent varB4EAC82CA7396A68D541C85D26508E83_1302940045 = null; //Variable for return #1
        mFlags |= flags;
        varB4EAC82CA7396A68D541C85D26508E83_1302940045 = this;
        varB4EAC82CA7396A68D541C85D26508E83_1302940045.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1302940045;
        // ---------- Original Method ----------
        //mFlags |= flags;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:01.012 -0400", hash_original_method = "200C4521B9AF8FCBBA6D2C276396E1AF", hash_generated_method = "AB6BCB7A90994320E8222BEE7FD5CD43")
    public Intent setPackage(String packageName) {
        Intent varB4EAC82CA7396A68D541C85D26508E83_1499672344 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException(
                    "Can't set package name when selector is already set");
        } //End block
        mPackage = packageName;
        varB4EAC82CA7396A68D541C85D26508E83_1499672344 = this;
        varB4EAC82CA7396A68D541C85D26508E83_1499672344.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1499672344;
        // ---------- Original Method ----------
        //if (packageName != null && mSelector != null) {
            //throw new IllegalArgumentException(
                    //"Can't set package name when selector is already set");
        //}
        //mPackage = packageName;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:01.020 -0400", hash_original_method = "36A7CA099992FC1299C683CE16869B23", hash_generated_method = "20F86937547F578260878BF8C9BC003A")
    public Intent setComponent(ComponentName component) {
        Intent varB4EAC82CA7396A68D541C85D26508E83_386422179 = null; //Variable for return #1
        mComponent = component;
        varB4EAC82CA7396A68D541C85D26508E83_386422179 = this;
        varB4EAC82CA7396A68D541C85D26508E83_386422179.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_386422179;
        // ---------- Original Method ----------
        //mComponent = component;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:01.045 -0400", hash_original_method = "A7E573A4994CE22857A73F3E6FF16052", hash_generated_method = "6531C78A4EA60D4F23023CDE1B07B9D8")
    public Intent setClassName(Context packageContext, String className) {
        Intent varB4EAC82CA7396A68D541C85D26508E83_870881933 = null; //Variable for return #1
        mComponent = new ComponentName(packageContext, className);
        varB4EAC82CA7396A68D541C85D26508E83_870881933 = this;
        varB4EAC82CA7396A68D541C85D26508E83_870881933.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_870881933;
        // ---------- Original Method ----------
        //mComponent = new ComponentName(packageContext, className);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:01.047 -0400", hash_original_method = "0DAD204BCD083F4BEBCC949C19CA4443", hash_generated_method = "5525F4D2A866C47F3DA0CD2162B00F04")
    public Intent setClassName(String packageName, String className) {
        Intent varB4EAC82CA7396A68D541C85D26508E83_454530881 = null; //Variable for return #1
        mComponent = new ComponentName(packageName, className);
        varB4EAC82CA7396A68D541C85D26508E83_454530881 = this;
        varB4EAC82CA7396A68D541C85D26508E83_454530881.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_454530881;
        // ---------- Original Method ----------
        //mComponent = new ComponentName(packageName, className);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:01.048 -0400", hash_original_method = "07D0BC1863460C70C46D0D4DB8E842CD", hash_generated_method = "50C448702EBDF8F8F16C74ACF10B4C9D")
    public Intent setClass(Context packageContext, Class<?> cls) {
        Intent varB4EAC82CA7396A68D541C85D26508E83_1606190082 = null; //Variable for return #1
        mComponent = new ComponentName(packageContext, cls);
        varB4EAC82CA7396A68D541C85D26508E83_1606190082 = this;
        varB4EAC82CA7396A68D541C85D26508E83_1606190082.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1606190082;
        // ---------- Original Method ----------
        //mComponent = new ComponentName(packageContext, cls);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:01.050 -0400", hash_original_method = "2A55D148D28C14A8FD18A3C56EB5208F", hash_generated_method = "368D172D687AB5A7815F466891D11CD0")
    public void setSourceBounds(Rect r) {
        {
            mSourceBounds = new Rect(r);
        } //End block
        {
            mSourceBounds = null;
        } //End block
        // ---------- Original Method ----------
        //if (r != null) {
            //mSourceBounds = new Rect(r);
        //} else {
            //mSourceBounds = null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:01.111 -0400", hash_original_method = "E5580C6082A47C0EDDA03A45ABBBF7D7", hash_generated_method = "FDA29F3DC882902D0BCD8979FCD4897C")
    public int fillIn(Intent other, int flags) {
        int changes;
        changes = 0;
        {
            mAction = other.mAction;
            changes |= FILL_IN_ACTION;
        } //End block
        {
            mData = other.mData;
            mType = other.mType;
            changes |= FILL_IN_DATA;
        } //End block
        {
            {
                mCategories = new HashSet<String>(other.mCategories);
            } //End block
            changes |= FILL_IN_CATEGORIES;
        } //End block
        {
            {
                mPackage = other.mPackage;
                changes |= FILL_IN_PACKAGE;
            } //End block
        } //End block
        {
            {
                mSelector = new Intent(other.mSelector);
                mPackage = null;
                changes |= FILL_IN_SELECTOR;
            } //End block
        } //End block
        {
            mComponent = other.mComponent;
            changes |= FILL_IN_COMPONENT;
        } //End block
        mFlags |= other.mFlags;
        {
            mSourceBounds = new Rect(other.mSourceBounds);
            changes |= FILL_IN_SOURCE_BOUNDS;
        } //End block
        {
            {
                mExtras = new Bundle(other.mExtras);
            } //End block
        } //End block
        {
            try 
            {
                Bundle newb;
                newb = new Bundle(other.mExtras);
                newb.putAll(mExtras);
                mExtras = newb;
            } //End block
            catch (RuntimeException e)
            { }
        } //End block
        addTaint(flags);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_25965253 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_25965253;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:01.135 -0400", hash_original_method = "B6E4053A3570119C1E3D361525D403A8", hash_generated_method = "AECC724BB06CB78A758EB3A6CE1A1643")
    public boolean filterEquals(Intent other) {
        {
            {
                {
                    boolean var34A6740CF00C4CE99E014DB52800A86C_1495854315 = (!mAction.equals(other.mAction));
                } //End collapsed parenthetic
            } //End block
            {
                {
                    boolean varAEFDA509D1872F11467FB8BDF0BEF91F_734044251 = (!other.mAction.equals(mAction));
                } //End collapsed parenthetic
            } //End block
        } //End block
        {
            {
                {
                    boolean var1B3E4D86DDEB4D4A831A6326700A0F0B_1024460277 = (!mData.equals(other.mData));
                } //End collapsed parenthetic
            } //End block
            {
                {
                    boolean varB9280F5A87CB7471F1F68ACAD9FF512A_2087903491 = (!other.mData.equals(mData));
                } //End collapsed parenthetic
            } //End block
        } //End block
        {
            {
                {
                    boolean var6E90D3CB216BAFFC33A8A7351B637345_1657333558 = (!mType.equals(other.mType));
                } //End collapsed parenthetic
            } //End block
            {
                {
                    boolean var49F589FDF6BAFD9349A39C37D467C96C_1111962243 = (!other.mType.equals(mType));
                } //End collapsed parenthetic
            } //End block
        } //End block
        {
            {
                {
                    boolean var0FF5A23B099AB3A4E4889633C3DF81A9_605825182 = (!mPackage.equals(other.mPackage));
                } //End collapsed parenthetic
            } //End block
            {
                {
                    boolean var7A82FF7EACC0A9829485BCB718ACD023_1860905268 = (!other.mPackage.equals(mPackage));
                } //End collapsed parenthetic
            } //End block
        } //End block
        {
            {
                {
                    boolean var8978EFF033EC0F607CC0AB6AE0299151_307853091 = (!mComponent.equals(other.mComponent));
                } //End collapsed parenthetic
            } //End block
            {
                {
                    boolean var384CAB8913950049F62446B39911719F_443079906 = (!other.mComponent.equals(mComponent));
                } //End collapsed parenthetic
            } //End block
        } //End block
        {
            {
                {
                    boolean varAE538A113FE5A591A0CC1368E43F8DD6_1160264026 = (!mCategories.equals(other.mCategories));
                } //End collapsed parenthetic
            } //End block
            {
                {
                    boolean varE14E437DACF017225A5A506C3E8F03FE_2143170500 = (!other.mCategories.equals(mCategories));
                } //End collapsed parenthetic
            } //End block
        } //End block
        addTaint(other.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1895727088 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1895727088;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:01.155 -0400", hash_original_method = "8096117DA4698C90A65D3667512D1D4C", hash_generated_method = "E3076C977B0176F87021158866302F97")
    public int filterHashCode() {
        int code;
        code = 0;
        {
            code += mAction.hashCode();
        } //End block
        {
            code += mData.hashCode();
        } //End block
        {
            code += mType.hashCode();
        } //End block
        {
            code += mPackage.hashCode();
        } //End block
        {
            code += mComponent.hashCode();
        } //End block
        {
            code += mCategories.hashCode();
        } //End block
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1278396041 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1278396041;
        // ---------- Original Method ----------
        //int code = 0;
        //if (mAction != null) {
            //code += mAction.hashCode();
        //}
        //if (mData != null) {
            //code += mData.hashCode();
        //}
        //if (mType != null) {
            //code += mType.hashCode();
        //}
        //if (mPackage != null) {
            //code += mPackage.hashCode();
        //}
        //if (mComponent != null) {
            //code += mComponent.hashCode();
        //}
        //if (mCategories != null) {
            //code += mCategories.hashCode();
        //}
        //return code;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:01.157 -0400", hash_original_method = "A07DFF04DF4B6FC888385D304C4BCF4A", hash_generated_method = "3C980D336B2CF68651686B09CD40F17F")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_391190213 = null; //Variable for return #1
        StringBuilder b;
        b = new StringBuilder(128);
        b.append("Intent { ");
        toShortString(b, true, true, true);
        b.append(" }");
        varB4EAC82CA7396A68D541C85D26508E83_391190213 = b.toString();
        varB4EAC82CA7396A68D541C85D26508E83_391190213.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_391190213;
        // ---------- Original Method ----------
        //StringBuilder b = new StringBuilder(128);
        //b.append("Intent { ");
        //toShortString(b, true, true, true);
        //b.append(" }");
        //return b.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:01.165 -0400", hash_original_method = "561478671997B5BD9B57800B6A20BE68", hash_generated_method = "F3125D540EEBC4453065EE579B7F3A41")
    public String toInsecureString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1049529126 = null; //Variable for return #1
        StringBuilder b;
        b = new StringBuilder(128);
        b.append("Intent { ");
        toShortString(b, false, true, true);
        b.append(" }");
        varB4EAC82CA7396A68D541C85D26508E83_1049529126 = b.toString();
        varB4EAC82CA7396A68D541C85D26508E83_1049529126.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1049529126;
        // ---------- Original Method ----------
        //StringBuilder b = new StringBuilder(128);
        //b.append("Intent { ");
        //toShortString(b, false, true, true);
        //b.append(" }");
        //return b.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:01.182 -0400", hash_original_method = "78E0A44749B0E137B37BE3EA0840E73D", hash_generated_method = "EC259968EAC043811F3C54A7276890DA")
    public String toShortString(boolean secure, boolean comp, boolean extras) {
        String varB4EAC82CA7396A68D541C85D26508E83_651904862 = null; //Variable for return #1
        StringBuilder b;
        b = new StringBuilder(128);
        toShortString(b, secure, comp, extras);
        varB4EAC82CA7396A68D541C85D26508E83_651904862 = b.toString();
        addTaint(secure);
        addTaint(comp);
        addTaint(extras);
        varB4EAC82CA7396A68D541C85D26508E83_651904862.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_651904862;
        // ---------- Original Method ----------
        //StringBuilder b = new StringBuilder(128);
        //toShortString(b, secure, comp, extras);
        //return b.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:01.219 -0400", hash_original_method = "084143D5D45481DE69737429FAF260F9", hash_generated_method = "D08DAC7EBEE4DC75FDA6F3A16663FB96")
    public void toShortString(StringBuilder b, boolean secure, boolean comp, boolean extras) {
        boolean first;
        first = true;
        {
            b.append("act=").append(mAction);
            first = false;
        } //End block
        {
            {
                b.append(' ');
            } //End block
            first = false;
            b.append("cat=[");
            Iterator<String> i;
            i = mCategories.iterator();
            boolean didone;
            didone = false;
            {
                boolean varD8B5E52A597500CBD863E52A46B42708_760080899 = (i.hasNext());
                {
                    b.append(",");
                    didone = true;
                    b.append(i.next());
                } //End block
            } //End collapsed parenthetic
            b.append("]");
        } //End block
        {
            {
                b.append(' ');
            } //End block
            first = false;
            b.append("dat=");
            {
                b.append(mData.toSafeString());
            } //End block
            {
                b.append(mData);
            } //End block
        } //End block
        {
            {
                b.append(' ');
            } //End block
            first = false;
            b.append("typ=").append(mType);
        } //End block
        {
            {
                b.append(' ');
            } //End block
            first = false;
            b.append("flg=0x").append(Integer.toHexString(mFlags));
        } //End block
        {
            {
                b.append(' ');
            } //End block
            first = false;
            b.append("pkg=").append(mPackage);
        } //End block
        {
            {
                b.append(' ');
            } //End block
            first = false;
            b.append("cmp=").append(mComponent.flattenToShortString());
        } //End block
        {
            {
                b.append(' ');
            } //End block
            first = false;
            b.append("bnds=").append(mSourceBounds.toShortString());
        } //End block
        {
            {
                b.append(' ');
            } //End block
            first = false;
            b.append("(has extras)");
        } //End block
        {
            b.append(" sel={");
            mSelector.toShortString(b, secure, comp, extras);
            b.append("}");
        } //End block
        addTaint(b.getTaint());
        addTaint(secure);
        addTaint(comp);
        addTaint(extras);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:01.223 -0400", hash_original_method = "A1DA43CBB31EA268C3AC25819B92FFB9", hash_generated_method = "E9482CEE221DC8DFC3C5F9CCD134D194")
    @Deprecated
    public String toURI() {
        String varB4EAC82CA7396A68D541C85D26508E83_703873105 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_703873105 = toUri(0);
        varB4EAC82CA7396A68D541C85D26508E83_703873105.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_703873105;
        // ---------- Original Method ----------
        //return toUri(0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:01.277 -0400", hash_original_method = "E005DA59F987D9130CC4868A94C4C496", hash_generated_method = "75EDADB77BF1C28BED0139175044D130")
    public String toUri(int flags) {
        String varB4EAC82CA7396A68D541C85D26508E83_1143410498 = null; //Variable for return #1
        StringBuilder uri;
        uri = new StringBuilder(128);
        String scheme;
        scheme = null;
        {
            String data;
            data = mData.toString();
            {
                int N;
                N = data.length();
                {
                    int i;
                    i = 0;
                    {
                        char c;
                        c = data.charAt(i);
                        {
                            scheme = data.substring(0, i);
                            uri.append("intent:");
                            data = data.substring(i+1);
                        } //End block
                    } //End block
                } //End collapsed parenthetic
            } //End block
            uri.append(data);
        } //End block
        {
            uri.append("intent:");
        } //End block
        uri.append("#Intent;");
        toUriInner(uri, scheme, flags);
        {
            uri.append("SEL;");
            mSelector.toUriInner(uri, null, flags);
        } //End block
        uri.append("end");
        varB4EAC82CA7396A68D541C85D26508E83_1143410498 = uri.toString();
        addTaint(flags);
        varB4EAC82CA7396A68D541C85D26508E83_1143410498.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1143410498;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:01.784 -0400", hash_original_method = "C6B01852F6499829AE05E1CED618D6B2", hash_generated_method = "9FDE7F15F637C92DE16F5841CAF28C4A")
    private void toUriInner(StringBuilder uri, String scheme, int flags) {
        {
            uri.append("scheme=").append(scheme).append(';');
        } //End block
        {
            uri.append("action=").append(Uri.encode(mAction)).append(';');
        } //End block
        {
            {
                Iterator<String> varC5C97730832E94B972365D2927406D4C_1259744154 = (mCategories).iterator();
                varC5C97730832E94B972365D2927406D4C_1259744154.hasNext();
                String category = varC5C97730832E94B972365D2927406D4C_1259744154.next();
                {
                    uri.append("category=").append(Uri.encode(category)).append(';');
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            uri.append("type=").append(Uri.encode(mType, "/")).append(';');
        } //End block
        {
            uri.append("launchFlags=0x").append(Integer.toHexString(mFlags)).append(';');
        } //End block
        {
            uri.append("package=").append(Uri.encode(mPackage)).append(';');
        } //End block
        {
            uri.append("component=").append(Uri.encode(
                    mComponent.flattenToShortString(), "/")).append(';');
        } //End block
        {
            uri.append("sourceBounds=")
                    .append(Uri.encode(mSourceBounds.flattenToString()))
                    .append(';');
        } //End block
        {
            {
                Iterator<String> varC3DCE956407274DC1E5507689933E9CE_1911460073 = (mExtras.keySet()).iterator();
                varC3DCE956407274DC1E5507689933E9CE_1911460073.hasNext();
                String key = varC3DCE956407274DC1E5507689933E9CE_1911460073.next();
                {
                    Object value;
                    value = mExtras.get(key);
                    char entryType;
                    entryType = 's';
                    entryType = '\0';
                    {
                        uri.append(entryType);
                        uri.append('.');
                        uri.append(Uri.encode(key));
                        uri.append('=');
                        uri.append(Uri.encode(value.toString()));
                        uri.append(';');
                    } //End block
                } //End block
            } //End collapsed parenthetic
        } //End block
        addTaint(uri.getTaint());
        addTaint(scheme.getTaint());
        addTaint(flags);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:01.795 -0400", hash_original_method = "2C347F4A4F86FFA77F246DC5FD21E5D6", hash_generated_method = "A0BEAB79756885BBBEBE4279E23C93B0")
    public int describeContents() {
        {
            Object varE627D80D86B1145CFBB6F925B58A1813_1660306743 = (mExtras.describeContents());
        } //End flattened ternary
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_710907533 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_710907533;
        // ---------- Original Method ----------
        //return (mExtras != null) ? mExtras.describeContents() : 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.082 -0400", hash_original_method = "D9DA92F04D8A96D9F8D7CC23CBDB1396", hash_generated_method = "5C3B0A065AA2D4093FB28C628CF30ED5")
    public void writeToParcel(Parcel out, int flags) {
        out.writeString(mAction);
        Uri.writeToParcel(out, mData);
        out.writeString(mType);
        out.writeInt(mFlags);
        out.writeString(mPackage);
        ComponentName.writeToParcel(mComponent, out);
        {
            out.writeInt(1);
            mSourceBounds.writeToParcel(out, flags);
        } //End block
        {
            out.writeInt(0);
        } //End block
        {
            out.writeInt(mCategories.size());
            {
                Iterator<String> varC5C97730832E94B972365D2927406D4C_534810500 = (mCategories).iterator();
                varC5C97730832E94B972365D2927406D4C_534810500.hasNext();
                String category = varC5C97730832E94B972365D2927406D4C_534810500.next();
                {
                    out.writeString(category);
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            out.writeInt(0);
        } //End block
        {
            out.writeInt(1);
            mSelector.writeToParcel(out, flags);
        } //End block
        {
            out.writeInt(0);
        } //End block
        out.writeBundle(mExtras);
        addTaint(out.getTaint());
        addTaint(flags);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.108 -0400", hash_original_method = "275963C0D40D3AED4795057AE368B460", hash_generated_method = "FC3658EB1EB5FF045A4D2A09CF8533D9")
    public void readFromParcel(Parcel in) {
        setAction(in.readString());
        mData = Uri.CREATOR.createFromParcel(in);
        mType = in.readString();
        mFlags = in.readInt();
        mPackage = in.readString();
        mComponent = ComponentName.readFromParcel(in);
        {
            boolean var25D67F28E4887DDC152DCB9726EAB4D3_594363781 = (in.readInt() != 0);
            {
                mSourceBounds = Rect.CREATOR.createFromParcel(in);
            } //End block
        } //End collapsed parenthetic
        int N;
        N = in.readInt();
        {
            mCategories = new HashSet<String>();
            int i;
            {
                i=0;
                {
                    mCategories.add(in.readString().intern());
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            mCategories = null;
        } //End block
        {
            boolean var25D67F28E4887DDC152DCB9726EAB4D3_322028158 = (in.readInt() != 0);
            {
                mSelector = new Intent(in);
            } //End block
        } //End collapsed parenthetic
        mExtras = in.readBundle();
        // ---------- Original Method ----------
        //setAction(in.readString());
        //mData = Uri.CREATOR.createFromParcel(in);
        //mType = in.readString();
        //mFlags = in.readInt();
        //mPackage = in.readString();
        //mComponent = ComponentName.readFromParcel(in);
        //if (in.readInt() != 0) {
            //mSourceBounds = Rect.CREATOR.createFromParcel(in);
        //}
        //int N = in.readInt();
        //if (N > 0) {
            //mCategories = new HashSet<String>();
            //int i;
            //for (i=0; i<N; i++) {
                //mCategories.add(in.readString().intern());
            //}
        //} else {
            //mCategories = null;
        //}
        //if (in.readInt() != 0) {
            //mSelector = new Intent(in);
        //}
        //mExtras = in.readBundle();
    }

    
        public static Intent parseIntent(Resources resources, XmlPullParser parser, AttributeSet attrs) throws XmlPullParserException, IOException {
        Intent intent = new Intent();
        TypedArray sa = resources.obtainAttributes(attrs,
                com.android.internal.R.styleable.Intent);
        intent.setAction(sa.getString(com.android.internal.R.styleable.Intent_action));
        String data = sa.getString(com.android.internal.R.styleable.Intent_data);
        String mimeType = sa.getString(com.android.internal.R.styleable.Intent_mimeType);
        intent.setDataAndType(data != null ? Uri.parse(data) : null, mimeType);
        String packageName = sa.getString(com.android.internal.R.styleable.Intent_targetPackage);
        String className = sa.getString(com.android.internal.R.styleable.Intent_targetClass);
        if (packageName != null && className != null) {
            intent.setComponent(new ComponentName(packageName, className));
        }
        sa.recycle();
        int outerDepth = parser.getDepth();
        int type;
        while ((type=parser.next()) != XmlPullParser.END_DOCUMENT
               && (type != XmlPullParser.END_TAG || parser.getDepth() > outerDepth)) {
            if (type == XmlPullParser.END_TAG || type == XmlPullParser.TEXT) {
                continue;
            }
            String nodeName = parser.getName();
            if (nodeName.equals("category")) {
                sa = resources.obtainAttributes(attrs,
                        com.android.internal.R.styleable.IntentCategory);
                String cat = sa.getString(com.android.internal.R.styleable.IntentCategory_name);
                sa.recycle();
                if (cat != null) {
                    intent.addCategory(cat);
                }
                XmlUtils.skipCurrentTag(parser);
            } else if (nodeName.equals("extra")) {
                if (intent.mExtras == null) {
                    intent.mExtras = new Bundle();
                }
                resources.parseBundleExtra("extra", attrs, intent.mExtras);
                XmlUtils.skipCurrentTag(parser);
            } else {
                XmlUtils.skipCurrentTag(parser);
            }
        }
        return intent;
    }

    
    public static class ShortcutIconResource implements Parcelable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.109 -0400", hash_original_field = "387F1FA6FC99B8AE187C010A06120611", hash_generated_field = "AEA3D3739F492530AF8FD6582FAACBD9")

        public String packageName;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.109 -0400", hash_original_field = "8FAF06E45C46259BF19965503E274807", hash_generated_field = "08D9F4FE05D4D9B5AF5EACB299E1AC68")

        public String resourceName;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.116 -0400", hash_original_method = "76C9E47B1998842612265A8369AB620F", hash_generated_method = "76C9E47B1998842612265A8369AB620F")
        public ShortcutIconResource ()
        {
            //Synthesized constructor
        }


                public static ShortcutIconResource fromContext(Context context, int resourceId) {
            ShortcutIconResource icon = new ShortcutIconResource();
            icon.packageName = context.getPackageName();
            icon.resourceName = context.getResources().getResourceName(resourceId);
            return icon;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.117 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "68F10BCF06BED66FA436ACB8D9F84291")
        public int describeContents() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1836735346 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1836735346;
            // ---------- Original Method ----------
            //return 0;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.118 -0400", hash_original_method = "A078CBD5399741F593957325C4A01342", hash_generated_method = "8744A70258812FA0D96388DB5F87F3EB")
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(packageName);
            dest.writeString(resourceName);
            addTaint(dest.getTaint());
            addTaint(flags);
            // ---------- Original Method ----------
            //dest.writeString(packageName);
            //dest.writeString(resourceName);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.119 -0400", hash_original_method = "8D66F7367028E1EB1EA87D8477E02D6C", hash_generated_method = "E30B77A40B099D49B21764F39D4D2CA0")
        @Override
        public String toString() {
            String varB4EAC82CA7396A68D541C85D26508E83_1609638433 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1609638433 = resourceName;
            varB4EAC82CA7396A68D541C85D26508E83_1609638433.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1609638433;
            // ---------- Original Method ----------
            //return resourceName;
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.119 -0400", hash_original_field = "FBF38D2B8BC640782282E16FFEC5198F", hash_generated_field = "1765F17BB54E8B45766A199ED3197D0C")

        public static final Parcelable.Creator<ShortcutIconResource> CREATOR =
            new Parcelable.Creator<ShortcutIconResource>() {

                public ShortcutIconResource createFromParcel(Parcel source) {
                    ShortcutIconResource icon = new ShortcutIconResource();
                    icon.packageName = source.readString();
                    icon.resourceName = source.readString();
                    return icon;
                }

                public ShortcutIconResource[] newArray(int size) {
                    return new ShortcutIconResource[size];
                }
            };
    }


    
    public static final class FilterComparison {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.120 -0400", hash_original_field = "B1135DD88C82BCDD4DCD8391BCD99883", hash_generated_field = "5782C825DA3F61D408DF2DCA63E7F54A")

        private Intent mIntent;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.120 -0400", hash_original_field = "D1324C907E3C733CA9E17C8F90836F79", hash_generated_field = "A977E573260D0E2786C71BC0961278A2")

        private int mHashCode;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.136 -0400", hash_original_method = "2099CA9774C8964FCB84A0C5BA5EC3C6", hash_generated_method = "01A84E541FBE057533665879491A9DB5")
        public  FilterComparison(Intent intent) {
            mIntent = intent;
            mHashCode = intent.filterHashCode();
            // ---------- Original Method ----------
            //mIntent = intent;
            //mHashCode = intent.filterHashCode();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.138 -0400", hash_original_method = "AD027B7B58A4A2F151CC138FB7B23244", hash_generated_method = "17DFD3F3F14BDE9A22DFBD1973F4780A")
        public Intent getIntent() {
            Intent varB4EAC82CA7396A68D541C85D26508E83_1102256659 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1102256659 = mIntent;
            varB4EAC82CA7396A68D541C85D26508E83_1102256659.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1102256659;
            // ---------- Original Method ----------
            //return mIntent;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.142 -0400", hash_original_method = "57E0DE3F426C34FAD2C087D7985C733F", hash_generated_method = "B6929A0868D63F5D54B347E1F9633BA2")
        @Override
        public boolean equals(Object obj) {
            {
                Intent other;
                other = ((FilterComparison)obj).mIntent;
                boolean varE65638074C2BB312154E364F2332F00A_232538555 = (mIntent.filterEquals(other));
            } //End block
            addTaint(obj.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1166009662 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1166009662;
            // ---------- Original Method ----------
            //if (obj instanceof FilterComparison) {
                //Intent other = ((FilterComparison)obj).mIntent;
                //return mIntent.filterEquals(other);
            //}
            //return false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.143 -0400", hash_original_method = "D7D5E8B622FC6A9CB6E203DCD79B8799", hash_generated_method = "2C4A14C4BD40952BAADD2476711B3E41")
        @Override
        public int hashCode() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2073390192 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2073390192;
            // ---------- Original Method ----------
            //return mHashCode;
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.144 -0400", hash_original_field = "A8B946E40C0F8F203925ED477BA2F488", hash_generated_field = "8C4948296C5582312F7CF47A7D2DC8E5")

    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_MAIN = "android.intent.action.MAIN";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.144 -0400", hash_original_field = "796311F4A44E07CF272E2A9B98EF5CAF", hash_generated_field = "B4FC4AC4434AF0988895645F8113BE4D")

    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_VIEW = "android.intent.action.VIEW";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.144 -0400", hash_original_field = "6D1142C4000E42A85B515A5253C0D7B6", hash_generated_field = "31B7CB6CE826B970ED2FBCA1E6169A2F")

    public static final String ACTION_DEFAULT = ACTION_VIEW;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.144 -0400", hash_original_field = "C884729C77510956CD52E6AFCA9E5371", hash_generated_field = "B7771E23284E70ECBAF10CF8D998AB41")

    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_ATTACH_DATA = "android.intent.action.ATTACH_DATA";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.144 -0400", hash_original_field = "E77EAF3FFFF3A8317CD55A336AF4D1E3", hash_generated_field = "44755A5ACF130CF4CF6E8287050DF9EB")

    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_EDIT = "android.intent.action.EDIT";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.144 -0400", hash_original_field = "228BA85FD5482D015B15DE9D96D2321B", hash_generated_field = "83D15D19A3398819C14A6C83965BAE99")

    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_INSERT_OR_EDIT = "android.intent.action.INSERT_OR_EDIT";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.144 -0400", hash_original_field = "406446BB3C927955BF05E94CF21E5433", hash_generated_field = "D9B827E0A1E1DCD9F132DDCC7FC46859")

    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_PICK = "android.intent.action.PICK";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.145 -0400", hash_original_field = "115054E1A7193CD193482465BB90A765", hash_generated_field = "993347C266428903DAA186C844B97694")

    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_CREATE_SHORTCUT = "android.intent.action.CREATE_SHORTCUT";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.145 -0400", hash_original_field = "3D36AB093ACD74D4AEFCCBDAD0ADFD5E", hash_generated_field = "B6ADBC69477081B9FC2AB0FFF4840082")

    public static final String EXTRA_SHORTCUT_INTENT = "android.intent.extra.shortcut.INTENT";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.145 -0400", hash_original_field = "AE1914FB40A9F18B6D5E8F92A045CFA6", hash_generated_field = "F8A802D90F8F3D251F6BD332F302EAF0")

    public static final String EXTRA_SHORTCUT_NAME = "android.intent.extra.shortcut.NAME";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.145 -0400", hash_original_field = "CE1EBCF2A7C9749471AE04C87618EDED", hash_generated_field = "0E7C24C264DE9B0116CDE392569F9C32")

    public static final String EXTRA_SHORTCUT_ICON = "android.intent.extra.shortcut.ICON";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.145 -0400", hash_original_field = "9F9F116C7BC071710CF6B851E6748424", hash_generated_field = "27DE92A0E7A6C6975AF7B85FFD1372DA")

    public static final String EXTRA_SHORTCUT_ICON_RESOURCE =
            "android.intent.extra.shortcut.ICON_RESOURCE";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.145 -0400", hash_original_field = "68AE3958F4460BAE6BEBE21AA0394CB4", hash_generated_field = "B903FA9C641B07A1FD05DF6C900DDE87")

    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_CHOOSER = "android.intent.action.CHOOSER";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.145 -0400", hash_original_field = "27721C175F1E72453157848B9AFB33C5", hash_generated_field = "224E520888804F5E9A6A84B1429FF6C0")

    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_GET_CONTENT = "android.intent.action.GET_CONTENT";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.146 -0400", hash_original_field = "129FEAF5279E0B6B34063591470E62D2", hash_generated_field = "BA8AC554D2E7958FEB87F665CB187200")

    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_DIAL = "android.intent.action.DIAL";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.163 -0400", hash_original_field = "12A6BF356707577A2428ACFFFD59153D", hash_generated_field = "156D2611F9948DFBC8BEB851A4F2D865")

    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_CALL = "android.intent.action.CALL";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.163 -0400", hash_original_field = "85E00C92EC28EF841EA8EF7947A76DFD", hash_generated_field = "C7F702A15124025B52F4AE9D5F1D8AD8")

    public static final String ACTION_CALL_EMERGENCY = "android.intent.action.CALL_EMERGENCY";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.163 -0400", hash_original_field = "64EA32DFD508A69432FF0B1584E13A4D", hash_generated_field = "B84BCDAAA8978FF3F9970DBD3472E33A")

    public static final String ACTION_CALL_PRIVILEGED = "android.intent.action.CALL_PRIVILEGED";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.163 -0400", hash_original_field = "51F7C06A8683898EFCB7410AC4F73318", hash_generated_field = "3EB1F7AB454572370D3425BC3C27609E")

    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_SENDTO = "android.intent.action.SENDTO";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.163 -0400", hash_original_field = "DA99766A71A9D28F609127834E21CBFE", hash_generated_field = "1A00662632D62B278530F5AAFC144039")

    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_SEND = "android.intent.action.SEND";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.164 -0400", hash_original_field = "27737F17778FB540F67ECDAAFE981CFE", hash_generated_field = "20049E89E82A72A563C5146D910079EA")

    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_SEND_MULTIPLE = "android.intent.action.SEND_MULTIPLE";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.164 -0400", hash_original_field = "6AFF647F405E10A1EC8E84BCE8F333C3", hash_generated_field = "BCE6BAF3569F0CD9A5E69A60137D5C81")

    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_ANSWER = "android.intent.action.ANSWER";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.164 -0400", hash_original_field = "E148FA947761B685A6980605AF00FC20", hash_generated_field = "0C3014CD7256D614A3FE7AD4340BF556")

    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_INSERT = "android.intent.action.INSERT";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.164 -0400", hash_original_field = "107D0D440F63BEB52061BC6197005E33", hash_generated_field = "B54448451E8A597131F91F0578FB99AD")

    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_PASTE = "android.intent.action.PASTE";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.165 -0400", hash_original_field = "F5A4DF774AB4DBD3A6535DE06B1B6F9B", hash_generated_field = "DF7BAB5523E713ECFAD35C76FE516A25")

    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_DELETE = "android.intent.action.DELETE";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.165 -0400", hash_original_field = "70928EA440745E12D4F465718BA952EB", hash_generated_field = "64053F2DE34FDC5E2063C0A720EE652A")

    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_RUN = "android.intent.action.RUN";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.165 -0400", hash_original_field = "0BED932883E0015368BF67C1015EE18B", hash_generated_field = "52B9A6D0C516BD31A4C95AEA422C7CDD")

    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_SYNC = "android.intent.action.SYNC";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.165 -0400", hash_original_field = "39453BBDD6A75C5CB7C9EE0E6B523CFA", hash_generated_field = "6E59FE4FD801C0D307FECC5EC4DF8628")

    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_PICK_ACTIVITY = "android.intent.action.PICK_ACTIVITY";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.165 -0400", hash_original_field = "8879CF3452B6491271484F5E4B4CC17E", hash_generated_field = "E7F9F68DFE9898629E0198A735569695")

    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_SEARCH = "android.intent.action.SEARCH";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.165 -0400", hash_original_field = "4F83F2665723B7E13FB552E202AB51F5", hash_generated_field = "737D48C4A21F919A73BF8BEED0D584ED")

    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_SYSTEM_TUTORIAL = "android.intent.action.SYSTEM_TUTORIAL";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.165 -0400", hash_original_field = "33A02BA405FCAAA580A9AF321CF6E98B", hash_generated_field = "26A470EDFD3CA2849C1FCACCD2E608D4")

    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_WEB_SEARCH = "android.intent.action.WEB_SEARCH";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.165 -0400", hash_original_field = "9F03C542BB9719438E64312DE2636DC1", hash_generated_field = "BE767857B9865892A73819172E037AD1")

    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_ALL_APPS = "android.intent.action.ALL_APPS";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.166 -0400", hash_original_field = "66469EFE01BC9D9A79D9EC1BBECCC6A0", hash_generated_field = "78B483C17CF8E280B3FFE64EBE9308D7")

    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_SET_WALLPAPER = "android.intent.action.SET_WALLPAPER";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.174 -0400", hash_original_field = "FDE87E06EBF94C541AE7047C6575B199", hash_generated_field = "88A571004065BB2EDB6670E75B4759B4")

    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_BUG_REPORT = "android.intent.action.BUG_REPORT";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.174 -0400", hash_original_field = "03BAF606EC0D92488225FEA702090CBC", hash_generated_field = "CE3414178F66CECEAE525495168216DF")

    public static final String ACTION_FACTORY_TEST = "android.intent.action.FACTORY_TEST";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.175 -0400", hash_original_field = "7D053EDF38227B551A6CF18E92CCA353", hash_generated_field = "B0656284FD0F7E03B7575D3D85A97AEE")

    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_CALL_BUTTON = "android.intent.action.CALL_BUTTON";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.175 -0400", hash_original_field = "8528F0AE3852862076D0EE186CA184C0", hash_generated_field = "A75AE92BC026CE01AEADCE0ABC24D90D")

    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_VOICE_COMMAND = "android.intent.action.VOICE_COMMAND";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.175 -0400", hash_original_field = "499FC79BEC46A6BFDEC25183566A5169", hash_generated_field = "694DBF6AB3FCCC208CBE973967A9AC55")

    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_SEARCH_LONG_PRESS = "android.intent.action.SEARCH_LONG_PRESS";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.175 -0400", hash_original_field = "D05E9495D6AAD50A9FEC91F89758EEA2", hash_generated_field = "DD97D416D92C0F615E268CAE319B9240")

    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_APP_ERROR = "android.intent.action.APP_ERROR";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.175 -0400", hash_original_field = "791FC936926CF8F3F506FB205157DE5A", hash_generated_field = "A3A3FAFEFA13163016A6BA1A34223541")

    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_POWER_USAGE_SUMMARY = "android.intent.action.POWER_USAGE_SUMMARY";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.175 -0400", hash_original_field = "53BE68F91DF39774F55F89CE89ED569E", hash_generated_field = "1EFAF27E8BB9D3EDBE3E169F25247ED4")

    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_UPGRADE_SETUP = "android.intent.action.UPGRADE_SETUP";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.175 -0400", hash_original_field = "267F4538830482CEC3ABBD76184D0745", hash_generated_field = "E9B6C831918B3E1D73A086432893716E")

    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_MANAGE_NETWORK_USAGE =
            "android.intent.action.MANAGE_NETWORK_USAGE";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.175 -0400", hash_original_field = "F175C83CB8981F0B406E4F17BA659303", hash_generated_field = "224FD1BF8BEC020F4764D95A85BFD13C")

    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_INSTALL_PACKAGE = "android.intent.action.INSTALL_PACKAGE";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.176 -0400", hash_original_field = "A01FD6DC5E600894209811F32F56B91D", hash_generated_field = "095986244542E9347842ED78D18CD74E")

    public static final String EXTRA_INSTALLER_PACKAGE_NAME
            = "android.intent.extra.INSTALLER_PACKAGE_NAME";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.176 -0400", hash_original_field = "5365E48984AE030157E927F4359CC241", hash_generated_field = "2279FC773C4241383D589A90D26BE2B5")

    public static final String EXTRA_NOT_UNKNOWN_SOURCE
            = "android.intent.extra.NOT_UNKNOWN_SOURCE";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.176 -0400", hash_original_field = "143EA34DE9089D023B14437FD8F414EE", hash_generated_field = "0F02B996D65BEFE314ED9C58EC4F054C")

    public static final String EXTRA_ALLOW_REPLACE
            = "android.intent.extra.ALLOW_REPLACE";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.176 -0400", hash_original_field = "F040EEC629D331F2677EF196C182348B", hash_generated_field = "CABD06708BF342F9A6F9EEF34216D9E5")

    public static final String EXTRA_RETURN_RESULT
            = "android.intent.extra.RETURN_RESULT";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.176 -0400", hash_original_field = "51F7E3DE5D78822A2C67AB55C4062EBD", hash_generated_field = "D664CE1BA8A3AD69E368E2660C3CB4E9")

    public static final String EXTRA_INSTALL_RESULT
            = "android.intent.extra.INSTALL_RESULT";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.176 -0400", hash_original_field = "2EB27F3DF7BFF9065CF805128DA949A2", hash_generated_field = "5D0C5026A979DB00BB5F4ADD3EBFDB2D")

    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_UNINSTALL_PACKAGE = "android.intent.action.UNINSTALL_PACKAGE";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.176 -0400", hash_original_field = "42784AA3F54756FDE7A6215A4C66D306", hash_generated_field = "604CC86BBA1936C2065E409B75C690BD")

    public static final String METADATA_SETUP_VERSION = "android.SETUP_VERSION";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.176 -0400", hash_original_field = "AC10B9A7A5F6ADFCA57066C15D8A3C44", hash_generated_field = "FDEAE1CF49A8C01C84FD5D71CAFFEC9D")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_SCREEN_OFF = "android.intent.action.SCREEN_OFF";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.177 -0400", hash_original_field = "01A5F1932A4970847D03F7A651A4A603", hash_generated_field = "1FC4F0F18C8B9F53FA7192917FC4AB66")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_SCREEN_ON = "android.intent.action.SCREEN_ON";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.180 -0400", hash_original_field = "ED9176148F7F847FF922C07DDC3123FE", hash_generated_field = "02A3AA184DBA3BF4ED8BBC3FF5A5EA52")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_USER_PRESENT = "android.intent.action.USER_PRESENT";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.180 -0400", hash_original_field = "E89C5128B40966DA4AC64E1E180F178B", hash_generated_field = "C4F52864EBD629B8C1AE5257671D488F")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_TIME_TICK = "android.intent.action.TIME_TICK";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.180 -0400", hash_original_field = "1EF7AD93F4ED1D9C68D9B62A442EE0C0", hash_generated_field = "90329A50970E9E426A169EEC900D33F0")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_TIME_CHANGED = "android.intent.action.TIME_SET";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.181 -0400", hash_original_field = "E4207C3CA3D798F0BAF04ECD1BC96615", hash_generated_field = "57160E8CBD5FB12354C9F2A165FC4406")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_DATE_CHANGED = "android.intent.action.DATE_CHANGED";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.181 -0400", hash_original_field = "7EDA8FAFB1FCE49A6B3A0BF0293733CC", hash_generated_field = "092DA96C44A18F27A501A8534FFCD4F2")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_TIMEZONE_CHANGED = "android.intent.action.TIMEZONE_CHANGED";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.181 -0400", hash_original_field = "C5D635BAB4A89C331FD7D9A131B3F406", hash_generated_field = "2283D5CDFBBD632A8875668E1CC33C72")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_CLEAR_DNS_CACHE = "android.intent.action.CLEAR_DNS_CACHE";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.181 -0400", hash_original_field = "79997921741E1D6BEA59D6556006F40F", hash_generated_field = "C359D5926C706990350C34DE9456F7E3")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_ALARM_CHANGED = "android.intent.action.ALARM_CHANGED";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.181 -0400", hash_original_field = "B94D7897232C2944B5B70514A85DFA93", hash_generated_field = "0E69C231C8306016AEE014A3D1AF38B7")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_SYNC_STATE_CHANGED
            = "android.intent.action.SYNC_STATE_CHANGED";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.181 -0400", hash_original_field = "C1D22BB4AAB40F3A4AA70ECAFAFB8600", hash_generated_field = "97FEB82EA8E82C6EA441D833FB2D22C8")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_BOOT_COMPLETED = "android.intent.action.BOOT_COMPLETED";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.181 -0400", hash_original_field = "5776AE1D20CE64A982FFE3E5CF07A557", hash_generated_field = "D95B98D4DA81F25EA38B96B61FBDB946")

    public static final String ACTION_CLOSE_SYSTEM_DIALOGS = "android.intent.action.CLOSE_SYSTEM_DIALOGS";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.181 -0400", hash_original_field = "DB9C13578210E28D259FB7060F0A661E", hash_generated_field = "2C7D09002B43654AC3703592944450CB")

    @Deprecated
    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_PACKAGE_INSTALL = "android.intent.action.PACKAGE_INSTALL";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.182 -0400", hash_original_field = "A63458462EB298509B857A921AF918DB", hash_generated_field = "E9BF2DB88022DA53F5B709714C727F77")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_PACKAGE_ADDED = "android.intent.action.PACKAGE_ADDED";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.182 -0400", hash_original_field = "E1F6D10EADF70BA722A08B8549847ADA", hash_generated_field = "4FE14146DF43D9EDF110C776366AEBA7")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_PACKAGE_REPLACED = "android.intent.action.PACKAGE_REPLACED";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.182 -0400", hash_original_field = "2002566C43E3485F3C34B5BB31F87207", hash_generated_field = "8E7A7A120C757C5788574BAE90EF4C4F")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_MY_PACKAGE_REPLACED = "android.intent.action.MY_PACKAGE_REPLACED";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.182 -0400", hash_original_field = "C1CC2774743B965C8575196E8B87FA53", hash_generated_field = "35FE490F4B8E618F5247F033A516643E")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_PACKAGE_REMOVED = "android.intent.action.PACKAGE_REMOVED";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.182 -0400", hash_original_field = "CEFA491D360B28870082F55E683C13DD", hash_generated_field = "45DA25B1BF4497A16EE81215EC103B86")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_PACKAGE_FULLY_REMOVED
            = "android.intent.action.PACKAGE_FULLY_REMOVED";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.182 -0400", hash_original_field = "974BC5FEE7B3F985713F59B7C98607CA", hash_generated_field = "3B88AC76A94E57D70607375559434DF6")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_PACKAGE_CHANGED = "android.intent.action.PACKAGE_CHANGED";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.182 -0400", hash_original_field = "DFBCF095A42ACA7A55643F0863DF8E8D", hash_generated_field = "83AB29CDF0C8D03ED03B189B0B3B427D")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_QUERY_PACKAGE_RESTART = "android.intent.action.QUERY_PACKAGE_RESTART";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.182 -0400", hash_original_field = "73F8CC86BDA7A6B496BD174C46A483AD", hash_generated_field = "485E38FFA9AEDA99636C6777203D486E")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_PACKAGE_RESTARTED = "android.intent.action.PACKAGE_RESTARTED";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.183 -0400", hash_original_field = "8FBCDA795A9A905721B9686123A338AE", hash_generated_field = "CE51064186158FF3C33BEB6F375C1BF1")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_PACKAGE_DATA_CLEARED = "android.intent.action.PACKAGE_DATA_CLEARED";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.196 -0400", hash_original_field = "AD6CD306DE617961650614459FCBFB3A", hash_generated_field = "F550ED6B3D1AF7CD7BB88086505B7ABD")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_UID_REMOVED = "android.intent.action.UID_REMOVED";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.197 -0400", hash_original_field = "DC4A82639596646547A6DC82886FCFCC", hash_generated_field = "6914952F46126338B1ABD751495C4588")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_PACKAGE_FIRST_LAUNCH = "android.intent.action.PACKAGE_FIRST_LAUNCH";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.197 -0400", hash_original_field = "952F6974186E0401813222C56B54D960", hash_generated_field = "772AAE9E85E0EFC70AE22DE59C52A048")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_PACKAGE_NEEDS_VERIFICATION = "android.intent.action.PACKAGE_NEEDS_VERIFICATION";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.197 -0400", hash_original_field = "3FBD18E81715442BDEE658474C5629E5", hash_generated_field = "21890D9A6F3165ECEF5820886B5827AD")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_EXTERNAL_APPLICATIONS_AVAILABLE =
        "android.intent.action.EXTERNAL_APPLICATIONS_AVAILABLE";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.197 -0400", hash_original_field = "79BBB6392C89883A34F60A67157B8582", hash_generated_field = "1D6B9ABFAFEDC734E8E2A5E0384923C8")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_EXTERNAL_APPLICATIONS_UNAVAILABLE =
        "android.intent.action.EXTERNAL_APPLICATIONS_UNAVAILABLE";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.197 -0400", hash_original_field = "0CA81190EF8F2C182EC0BFA71489F6BE", hash_generated_field = "D9C4187C78B1437F37AB9EC1AA21494E")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_WALLPAPER_CHANGED = "android.intent.action.WALLPAPER_CHANGED";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.197 -0400", hash_original_field = "CA63A4F0D845CC1A2BCE34B56FAC1C91", hash_generated_field = "1BBA1270FB38433693D57149CF8C0B2E")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_CONFIGURATION_CHANGED = "android.intent.action.CONFIGURATION_CHANGED";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.197 -0400", hash_original_field = "190930AA5CD7C41A46E58AE93DB4DAF9", hash_generated_field = "8CB211B82206532C1A38690C8B237654")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_LOCALE_CHANGED = "android.intent.action.LOCALE_CHANGED";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.197 -0400", hash_original_field = "ABE66503534AB36013F9685C92AD6591", hash_generated_field = "570C99553ED814D403177932D335BED6")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_BATTERY_CHANGED = "android.intent.action.BATTERY_CHANGED";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.197 -0400", hash_original_field = "C2AB6403A193FE10BC66D90B8FDDFF9F", hash_generated_field = "00E1ABC519EAD5F7A1CA909504F2202F")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_BATTERY_LOW = "android.intent.action.BATTERY_LOW";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.198 -0400", hash_original_field = "7D81F6B5F34EF94F54058BACC058E6EA", hash_generated_field = "9210CA8BA87692C4B485CE9B81D3110D")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_BATTERY_OKAY = "android.intent.action.BATTERY_OKAY";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.198 -0400", hash_original_field = "2FBCC98803903EB8DF2A2E59807AAD0B", hash_generated_field = "B2C6014C054E378354CF8FE40A52B2C2")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_POWER_CONNECTED = "android.intent.action.ACTION_POWER_CONNECTED";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.198 -0400", hash_original_field = "B65A00CA79DDAB92BD36A61399A53F2B", hash_generated_field = "EBEFF5DC3845903EFCEC6B07375DACA1")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_POWER_DISCONNECTED =
            "android.intent.action.ACTION_POWER_DISCONNECTED";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.198 -0400", hash_original_field = "5360B341F96A3309BDB72D08A8AF3101", hash_generated_field = "1BE5AD2EFAFDA27EB66F2443D735550E")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_SHUTDOWN = "android.intent.action.ACTION_SHUTDOWN";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.198 -0400", hash_original_field = "F6E2DBBBE878DBD513D21A5985484D79", hash_generated_field = "5F3F58AD9176A8304B540840F63575DB")

    public static final String ACTION_REQUEST_SHUTDOWN = "android.intent.action.ACTION_REQUEST_SHUTDOWN";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.198 -0400", hash_original_field = "119DD15F0F370A1DDD81085CDC53C416", hash_generated_field = "01A6016CF410E4B86318EFF197BCF8F9")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_DEVICE_STORAGE_LOW = "android.intent.action.DEVICE_STORAGE_LOW";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.198 -0400", hash_original_field = "B006976F3FD1C9379ED3FDC91DCEDAD0", hash_generated_field = "33F2A4A9934CCDA6F410E6F6C0F40214")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_DEVICE_STORAGE_OK = "android.intent.action.DEVICE_STORAGE_OK";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.198 -0400", hash_original_field = "A5B2E3301ADC08BEF1E7F56EBC9B4512", hash_generated_field = "368FAECEAD77772CAF85D0422B1C8A79")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_DEVICE_STORAGE_FULL = "android.intent.action.DEVICE_STORAGE_FULL";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.198 -0400", hash_original_field = "5E3F319F2CDD9D32B369D43C732D6318", hash_generated_field = "9C13CE86364BD1EE13C144EEC334D347")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_DEVICE_STORAGE_NOT_FULL = "android.intent.action.DEVICE_STORAGE_NOT_FULL";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.199 -0400", hash_original_field = "059125B32EFD1CCFEA64F4973EC2CDE0", hash_generated_field = "D65BD0B998073C9FE19756354457F478")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_MANAGE_PACKAGE_STORAGE = "android.intent.action.MANAGE_PACKAGE_STORAGE";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.199 -0400", hash_original_field = "D0AC83754C71725F6D08BA0C0C25267B", hash_generated_field = "3CBD0CC144FEC04702B3F1CD13F64839")

    @Deprecated
    public static final String ACTION_UMS_CONNECTED = "android.intent.action.UMS_CONNECTED";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.199 -0400", hash_original_field = "C92C26D8E96BDB97E9897B848DE2033A", hash_generated_field = "4BDE49336D4AFA09BB0FE3A57004C306")

    @Deprecated
    public static final String ACTION_UMS_DISCONNECTED = "android.intent.action.UMS_DISCONNECTED";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.199 -0400", hash_original_field = "0F5995E5E0CD89E06452ACE0AE11DC38", hash_generated_field = "B2BE1657103DB0488498829BD96E22F0")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_MEDIA_REMOVED = "android.intent.action.MEDIA_REMOVED";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.199 -0400", hash_original_field = "0BA4BC993DC7A1FB857E93FDFE872263", hash_generated_field = "C9CB40A30C23F3F14E497C2C7F2325BD")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_MEDIA_UNMOUNTED = "android.intent.action.MEDIA_UNMOUNTED";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.199 -0400", hash_original_field = "893452DB1B800AEF80988969D8E17444", hash_generated_field = "D43D07DAC9AFB658BCECFFD0CEB2069A")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_MEDIA_CHECKING = "android.intent.action.MEDIA_CHECKING";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.199 -0400", hash_original_field = "B2189C066541A4999F6EE7F447C87DA0", hash_generated_field = "55384D59F49FD41A2EADF0CCA4C0929A")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_MEDIA_NOFS = "android.intent.action.MEDIA_NOFS";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.200 -0400", hash_original_field = "608C05FB9F18771854CCC6BFA2E61B99", hash_generated_field = "10558D4779FCB99BEE53B32D18320978")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_MEDIA_MOUNTED = "android.intent.action.MEDIA_MOUNTED";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.213 -0400", hash_original_field = "11BE99F77B54DE8611DC73AE398FF47B", hash_generated_field = "8566E36A8F60EC1445E814C3A2CB4525")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_MEDIA_SHARED = "android.intent.action.MEDIA_SHARED";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.213 -0400", hash_original_field = "49BEEC1263231F173DFB9C83AAF90066", hash_generated_field = "4A0966F843885D1B4C7D86D57A30AB03")

    public static final String ACTION_MEDIA_UNSHARED = "android.intent.action.MEDIA_UNSHARED";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.214 -0400", hash_original_field = "41127306CF412F9F42D099AB126C8D7F", hash_generated_field = "803A350DA057B94CB8E27CB7B878C6A6")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_MEDIA_BAD_REMOVAL = "android.intent.action.MEDIA_BAD_REMOVAL";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.214 -0400", hash_original_field = "1C88A7F58841E50FBC52DAB70756F62F", hash_generated_field = "31F84A292E6949D56D48CCEB1F50770D")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_MEDIA_UNMOUNTABLE = "android.intent.action.MEDIA_UNMOUNTABLE";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.214 -0400", hash_original_field = "C9EF4EE02332ADF3A9FC44C9F6D2C825", hash_generated_field = "9059034AB7D9AA44CE7FCE4B140694F3")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_MEDIA_EJECT = "android.intent.action.MEDIA_EJECT";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.214 -0400", hash_original_field = "20A4E0AF785D3F8B1D62400AEAFFD659", hash_generated_field = "71A3429142C498B04ED73651826D736E")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_MEDIA_SCANNER_STARTED = "android.intent.action.MEDIA_SCANNER_STARTED";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.214 -0400", hash_original_field = "D65D35414000C272F52987DE8C2F8B15", hash_generated_field = "A5291D8E43EEC5A34C794D6EDB297C4B")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_MEDIA_SCANNER_FINISHED = "android.intent.action.MEDIA_SCANNER_FINISHED";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.214 -0400", hash_original_field = "22647845D0D96E7DB93C43A7B00C815B", hash_generated_field = "B73610259405BC52D46A6BB9A234CACC")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_MEDIA_SCANNER_SCAN_FILE = "android.intent.action.MEDIA_SCANNER_SCAN_FILE";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.214 -0400", hash_original_field = "6F8F18927694162775EC91AB42089027", hash_generated_field = "96866AE193EB7AD4C2D320F9E8F9667F")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_MEDIA_BUTTON = "android.intent.action.MEDIA_BUTTON";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.214 -0400", hash_original_field = "D7C400CE10ACF47F03EEDF3F777A3FA5", hash_generated_field = "1B888EC3E349732B7C1B7AADD006D324")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_CAMERA_BUTTON = "android.intent.action.CAMERA_BUTTON";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.215 -0400", hash_original_field = "DA60570D82EB22C48CE3C03AE187F5F9", hash_generated_field = "015F8ADF01F6BA460C769A049853C81F")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_GTALK_SERVICE_CONNECTED =
            "android.intent.action.GTALK_CONNECTED";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.215 -0400", hash_original_field = "E932654067B6A5F99CAC6C0E65474740", hash_generated_field = "8BD1CF036007C1899341967FD8CF4CDF")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_GTALK_SERVICE_DISCONNECTED =
            "android.intent.action.GTALK_DISCONNECTED";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.215 -0400", hash_original_field = "3BF4F29C6AB8210F1D77B2CC224E5B2B", hash_generated_field = "522D033A61D4D533DE9C09A76302DC98")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_INPUT_METHOD_CHANGED =
            "android.intent.action.INPUT_METHOD_CHANGED";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.215 -0400", hash_original_field = "C45DE8760103A7B7AAD791CFA471BD40", hash_generated_field = "D2528C9CC0EA562DC80B69589069F631")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_AIRPLANE_MODE_CHANGED = "android.intent.action.AIRPLANE_MODE";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.215 -0400", hash_original_field = "AED491A109C19AFE1086F764E0F8F1C5", hash_generated_field = "41C0CEA92EB9C8B86E585E41D9D7A0CF")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_PROVIDER_CHANGED =
            "android.intent.action.PROVIDER_CHANGED";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.215 -0400", hash_original_field = "AC89C4751319BD134FDA49F64E20A17D", hash_generated_field = "37C2771817E59664B8B239BCBDACBB10")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_HEADSET_PLUG =
            "android.intent.action.HEADSET_PLUG";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.215 -0400", hash_original_field = "97F0D02F275759DA6BC9DCCF5DA67B77", hash_generated_field = "D7E4EDC4328425F0329B2F8E1A88DAC9")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_USB_ANLG_HEADSET_PLUG =
            "android.intent.action.USB_ANLG_HEADSET_PLUG";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.215 -0400", hash_original_field = "194A5D6BCF934DE3E92D3DD709B06BB3", hash_generated_field = "B2FBB541357A96FDB3E687180A2EC76D")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_USB_DGTL_HEADSET_PLUG =
            "android.intent.action.USB_DGTL_HEADSET_PLUG";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.215 -0400", hash_original_field = "03F1ED15F5764C1EE2328771105571B3", hash_generated_field = "9163DF3896F055A609C5B564A0BFEBCC")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_HDMI_AUDIO_PLUG =
            "android.intent.action.HDMI_AUDIO_PLUG";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.216 -0400", hash_original_field = "38DC7D02EAB39D530A659027832681A6", hash_generated_field = "4EB742B935E945715EE07C7C0B3F92AC")

    public static final String ACTION_ADVANCED_SETTINGS_CHANGED
            = "android.intent.action.ADVANCED_SETTINGS";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.223 -0400", hash_original_field = "98DB3317D8784E8D0E3807DEBED0F12B", hash_generated_field = "D8133F9238C84FB44D78043BBC29F6DB")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_NEW_OUTGOING_CALL =
            "android.intent.action.NEW_OUTGOING_CALL";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.223 -0400", hash_original_field = "7469D5128F001D05C37CFEE084018501", hash_generated_field = "13D1D6B470020C1299E426407C602890")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_REBOOT =
            "android.intent.action.REBOOT";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.224 -0400", hash_original_field = "7AF3672116BBE301D783E3F9059BBFF0", hash_generated_field = "7CCBB1A0B45EFD0A2DFD1D63B82D87E8")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_DOCK_EVENT =
            "android.intent.action.DOCK_EVENT";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.224 -0400", hash_original_field = "07DD88111BB2F54CF270F070F017447B", hash_generated_field = "8EF6B8C482C12C7A4ACB03A0EE29DB00")

    public static final String ACTION_REMOTE_INTENT =
            "com.google.android.c2dm.intent.RECEIVE";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.224 -0400", hash_original_field = "32924E2C2DAC754DCCC5A3C5C39EE035", hash_generated_field = "8565FE3FC70ABB4476B729EE5BD6454E")

    public static final String ACTION_PRE_BOOT_COMPLETED =
            "android.intent.action.PRE_BOOT_COMPLETED";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.224 -0400", hash_original_field = "C1DCD3CCC883758EF400D2C83C00E7D7", hash_generated_field = "8075F7F627891123E230D050B9BAB405")

    @SdkConstant(SdkConstantType.INTENT_CATEGORY)
    public static final String CATEGORY_DEFAULT = "android.intent.category.DEFAULT";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.224 -0400", hash_original_field = "262A06DA9969EAC38ED6B7D0CA868897", hash_generated_field = "78B44AC3B312155C92B9E800BB603925")

    @SdkConstant(SdkConstantType.INTENT_CATEGORY)
    public static final String CATEGORY_BROWSABLE = "android.intent.category.BROWSABLE";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.224 -0400", hash_original_field = "7C705202BCD0ADD823BABCC88A5ED2C7", hash_generated_field = "5D58EABA225388825E6CB55C2DB3A0C5")

    @SdkConstant(SdkConstantType.INTENT_CATEGORY)
    public static final String CATEGORY_ALTERNATIVE = "android.intent.category.ALTERNATIVE";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.224 -0400", hash_original_field = "98581F09C3A53AAE096694E2BB12D613", hash_generated_field = "2B75CF89213BE077BE277CE183A8F989")

    @SdkConstant(SdkConstantType.INTENT_CATEGORY)
    public static final String CATEGORY_SELECTED_ALTERNATIVE = "android.intent.category.SELECTED_ALTERNATIVE";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.225 -0400", hash_original_field = "B01E7FF86BB6783BCD6A2330D12A9C13", hash_generated_field = "888B174B33729C88211F08DA737A729B")

    @SdkConstant(SdkConstantType.INTENT_CATEGORY)
    public static final String CATEGORY_TAB = "android.intent.category.TAB";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.225 -0400", hash_original_field = "1C097396847E07D1E85643E8DD9B2087", hash_generated_field = "56593E4A41EF7C8E79F804744316680A")

    @SdkConstant(SdkConstantType.INTENT_CATEGORY)
    public static final String CATEGORY_LAUNCHER = "android.intent.category.LAUNCHER";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.225 -0400", hash_original_field = "1F6D77CB1845F7CB21C02B283D1B6F00", hash_generated_field = "441C59FEE274EAC3BE26B4A58E9BB45F")

    @SdkConstant(SdkConstantType.INTENT_CATEGORY)
    public static final String CATEGORY_INFO = "android.intent.category.INFO";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.225 -0400", hash_original_field = "E795E3052F1ACD5E8D4E0CA0D408C339", hash_generated_field = "18557C6597B9FD9892461C1C1B6834A2")

    @SdkConstant(SdkConstantType.INTENT_CATEGORY)
    public static final String CATEGORY_HOME = "android.intent.category.HOME";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.225 -0400", hash_original_field = "5277FC097A4F388CAA95678514BBDAB2", hash_generated_field = "51881CD6A4034B4E905D061587A3240D")

    @SdkConstant(SdkConstantType.INTENT_CATEGORY)
    public static final String CATEGORY_PREFERENCE = "android.intent.category.PREFERENCE";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.225 -0400", hash_original_field = "CC0333A9A6C36FBEE9A05BAD3697220B", hash_generated_field = "747531EDE3442CA006298CA2157DE37B")

    @SdkConstant(SdkConstantType.INTENT_CATEGORY)
    public static final String CATEGORY_DEVELOPMENT_PREFERENCE = "android.intent.category.DEVELOPMENT_PREFERENCE";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.225 -0400", hash_original_field = "97573ED50FEF9D3B775819FB719EEA4E", hash_generated_field = "6B6F2EDBA682AA91A9896CAD371A8D07")

    @SdkConstant(SdkConstantType.INTENT_CATEGORY)
    public static final String CATEGORY_EMBED = "android.intent.category.EMBED";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.226 -0400", hash_original_field = "15BD7B2AB7965F1D54906AE580DD6FF1", hash_generated_field = "43D854893F1176EC545D499880817C81")

    @SdkConstant(SdkConstantType.INTENT_CATEGORY)
    public static final String CATEGORY_APP_MARKET = "android.intent.category.APP_MARKET";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.235 -0400", hash_original_field = "6A0F6B4B16B2364A628899EF7A6909C9", hash_generated_field = "2178E3078FC2C9C16B3710D31215720B")

    @SdkConstant(SdkConstantType.INTENT_CATEGORY)
    public static final String CATEGORY_MONKEY = "android.intent.category.MONKEY";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.235 -0400", hash_original_field = "121B826BD9B7F59E1DD347ECF4AFD032", hash_generated_field = "686B8018CC11BDB5C32BAAD279E5365B")

    public static final String CATEGORY_TEST = "android.intent.category.TEST";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.235 -0400", hash_original_field = "BB9055549E5CAB42F0006591A5C7021D", hash_generated_field = "E916DA7FE73FFB94CC2AEAE533EA23BF")

    public static final String CATEGORY_UNIT_TEST = "android.intent.category.UNIT_TEST";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.236 -0400", hash_original_field = "D1A6CD4CF824D88751232FB4E4AA0955", hash_generated_field = "F6FA58629915BFC7488711CA03CFE1DB")

    public static final String CATEGORY_SAMPLE_CODE = "android.intent.category.SAMPLE_CODE";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.236 -0400", hash_original_field = "7D4069A2BD82F7F403392E4C4FC1B778", hash_generated_field = "326BBB87AE978C10D0AC46A82D13B11D")

    @SdkConstant(SdkConstantType.INTENT_CATEGORY)
    public static final String CATEGORY_OPENABLE = "android.intent.category.OPENABLE";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.236 -0400", hash_original_field = "C8ABA7E7608B0A288D9065E881610226", hash_generated_field = "4A870B99349E92C8A35D53AF2630B90F")

    public static final String CATEGORY_FRAMEWORK_INSTRUMENTATION_TEST =
            "android.intent.category.FRAMEWORK_INSTRUMENTATION_TEST";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.236 -0400", hash_original_field = "801A128B6CA820DC7B9C45A39FD8EA31", hash_generated_field = "993F2D06C5CDD03C9EA7DCE8C1E78EC9")

    @SdkConstant(SdkConstantType.INTENT_CATEGORY)
    public static final String CATEGORY_CAR_DOCK = "android.intent.category.CAR_DOCK";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.236 -0400", hash_original_field = "5721889648B21D82BC396E47F3C179C1", hash_generated_field = "0E88B4F0151B540B4D837EFB418D0F48")

    @SdkConstant(SdkConstantType.INTENT_CATEGORY)
    public static final String CATEGORY_DESK_DOCK = "android.intent.category.DESK_DOCK";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.236 -0400", hash_original_field = "91E06774956F1982A73DEABE3ECF9EC2", hash_generated_field = "38EC7649AEEB239624A6794A7F07EA02")

    @SdkConstant(SdkConstantType.INTENT_CATEGORY)
    public static final String CATEGORY_LE_DESK_DOCK = "android.intent.category.LE_DESK_DOCK";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.236 -0400", hash_original_field = "850C5BB17AF80EE0C9ABA67A8DF5DA3B", hash_generated_field = "3F9D11FA3702BE350379D953C29C2F6F")

    @SdkConstant(SdkConstantType.INTENT_CATEGORY)
    public static final String CATEGORY_HE_DESK_DOCK = "android.intent.category.HE_DESK_DOCK";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.236 -0400", hash_original_field = "8167992C1DED360CAF126B13769A6D97", hash_generated_field = "11EB013E1E218EE05EC89A429A7652D4")

    @SdkConstant(SdkConstantType.INTENT_CATEGORY)
    public static final String CATEGORY_CAR_MODE = "android.intent.category.CAR_MODE";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.237 -0400", hash_original_field = "42EB30214146178B8E669F2F26DEB444", hash_generated_field = "9FD47E810741CAFE28D942DCFE763A51")

    @SdkConstant(SdkConstantType.INTENT_CATEGORY)
    public static final String CATEGORY_APP_BROWSER = "android.intent.category.APP_BROWSER";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.237 -0400", hash_original_field = "3E320411A65D0D17E23582F81126D1A8", hash_generated_field = "853D7E6DF6CA42B03E49C059E11DF6B2")

    @SdkConstant(SdkConstantType.INTENT_CATEGORY)
    public static final String CATEGORY_APP_CALCULATOR = "android.intent.category.APP_CALCULATOR";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.237 -0400", hash_original_field = "0CE17812B0F81E709253DBDEFC8BE3F4", hash_generated_field = "34490E78A1770B88FB00C51722A480EF")

    @SdkConstant(SdkConstantType.INTENT_CATEGORY)
    public static final String CATEGORY_APP_CALENDAR = "android.intent.category.APP_CALENDAR";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.237 -0400", hash_original_field = "F1B6F7AFD7750C14A86901EDE45B9E35", hash_generated_field = "23D411EC9BD34EB1956A7D20894B6F6B")

    @SdkConstant(SdkConstantType.INTENT_CATEGORY)
    public static final String CATEGORY_APP_CONTACTS = "android.intent.category.APP_CONTACTS";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.237 -0400", hash_original_field = "5145178B74321010501650DFF6BD231A", hash_generated_field = "B32849993CE54474DA658C00B93E9B06")

    @SdkConstant(SdkConstantType.INTENT_CATEGORY)
    public static final String CATEGORY_APP_EMAIL = "android.intent.category.APP_EMAIL";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.237 -0400", hash_original_field = "46E10F3C801D7FA6FC4D4A149FF4E221", hash_generated_field = "1AAD6D97E778061C4FC6B4579DBE698E")

    @SdkConstant(SdkConstantType.INTENT_CATEGORY)
    public static final String CATEGORY_APP_GALLERY = "android.intent.category.APP_GALLERY";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.237 -0400", hash_original_field = "CD5CA7EFF6B1D9CE5CE28720245188A3", hash_generated_field = "461AB4F858B20EDD3DC6D9BABFB25213")

    @SdkConstant(SdkConstantType.INTENT_CATEGORY)
    public static final String CATEGORY_APP_MAPS = "android.intent.category.APP_MAPS";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.237 -0400", hash_original_field = "62493FD84B3643DDC6E542F46296E291", hash_generated_field = "6E28A6D64C719D9421924F3B66DE5BA8")

    @SdkConstant(SdkConstantType.INTENT_CATEGORY)
    public static final String CATEGORY_APP_MESSAGING = "android.intent.category.APP_MESSAGING";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.237 -0400", hash_original_field = "3466FBB87701CE95C88BD77BD048111E", hash_generated_field = "7A01F1FB260B6B7E22C7231435E514F6")

    @SdkConstant(SdkConstantType.INTENT_CATEGORY)
    public static final String CATEGORY_APP_MUSIC = "android.intent.category.APP_MUSIC";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.238 -0400", hash_original_field = "805C80ACAE398088649F4391EBCDEAA8", hash_generated_field = "D84938735789F63BB5A99B3994808DF1")

    public static final String EXTRA_TEMPLATE = "android.intent.extra.TEMPLATE";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.238 -0400", hash_original_field = "26D8AC7B531CFE63141F4FC7EE777F86", hash_generated_field = "72214008F2D28B6F2C57EBF8F3F522E8")

    public static final String EXTRA_TEXT = "android.intent.extra.TEXT";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.244 -0400", hash_original_field = "A1039487987AAB30A86E10F3EE3BF0B7", hash_generated_field = "EC4454CE33F6CC89842034B94C293389")

    public static final String EXTRA_STREAM = "android.intent.extra.STREAM";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.245 -0400", hash_original_field = "A1DAFAD88FD8893754E31102FBC95018", hash_generated_field = "EBFD2B12F95245B3FBC9DF7A00777B71")

    public static final String EXTRA_EMAIL       = "android.intent.extra.EMAIL";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.245 -0400", hash_original_field = "236E94528EC51D76CCBAD14C63346C42", hash_generated_field = "8AFD20100EA68B345A45C08A01ECDB1C")

    public static final String EXTRA_CC       = "android.intent.extra.CC";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.245 -0400", hash_original_field = "E0D2FEE44BED77C32E0577BBBE70AE03", hash_generated_field = "248F5D1EC476962B448213113152C27D")

    public static final String EXTRA_BCC      = "android.intent.extra.BCC";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.245 -0400", hash_original_field = "0AF1E62A76EFEC85FB0811F0233FB7EE", hash_generated_field = "419F13F40D6F3539A0ADBB0EE25BDC61")

    public static final String EXTRA_SUBJECT  = "android.intent.extra.SUBJECT";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.245 -0400", hash_original_field = "3BE3E4C478716309FBA51637E3489AD3", hash_generated_field = "6C385524243DA13629D46DD4A076B2BE")

    public static final String EXTRA_INTENT = "android.intent.extra.INTENT";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.245 -0400", hash_original_field = "A4C173AD9584C3F44AF2B2D00D5E1CCD", hash_generated_field = "442A91F2FCA42809657F776F47AC14A2")

    public static final String EXTRA_TITLE = "android.intent.extra.TITLE";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.245 -0400", hash_original_field = "DCD538997D844DEBDBE7BA551E9D53AD", hash_generated_field = "83F4ECB331C2C4D31F6BF841AA493392")

    public static final String EXTRA_INITIAL_INTENTS = "android.intent.extra.INITIAL_INTENTS";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.245 -0400", hash_original_field = "05E56155D877CA1DFA30D1E6662DCB9F", hash_generated_field = "B22AF3F2DD8C690301A6C16272B182E6")

    public static final String EXTRA_KEY_EVENT = "android.intent.extra.KEY_EVENT";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.245 -0400", hash_original_field = "23A029E8E0E49DF4E625ED11FB872C44", hash_generated_field = "5A5722737DD73618327545E77C22EC76")

    public static final String EXTRA_KEY_CONFIRM = "android.intent.extra.KEY_CONFIRM";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.245 -0400", hash_original_field = "6739A1282C0BFAC9FAA22C7E02A0DFC5", hash_generated_field = "86E9F818118C4911260709A9CE25ABBF")

    public static final String EXTRA_DONT_KILL_APP = "android.intent.extra.DONT_KILL_APP";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.246 -0400", hash_original_field = "28D0ABEED076AF655D0753FE28CC8682", hash_generated_field = "250F8F3445ECA42F404D7699D0878462")

    public static final String EXTRA_PHONE_NUMBER = "android.intent.extra.PHONE_NUMBER";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.246 -0400", hash_original_field = "75903292DB8BE5F6059A4374F19B6C15", hash_generated_field = "784764F75FCAF4D594484BAE3D08E782")

    public static final String EXTRA_UID = "android.intent.extra.UID";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.246 -0400", hash_original_field = "1BEC945D1ED6A71A88B57B19F482154C", hash_generated_field = "DA292F34D2C63F59038060862D3FBD56")

    public static final String EXTRA_PACKAGES = "android.intent.extra.PACKAGES";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.246 -0400", hash_original_field = "525DD57428FAA64F1A5AD020F1B60AFB", hash_generated_field = "13D45ED3B0C6FB86F2CDE61794B5F803")

    public static final String EXTRA_DATA_REMOVED = "android.intent.extra.DATA_REMOVED";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.246 -0400", hash_original_field = "1BF64067F81CFE47D11E57C5DF299AF9", hash_generated_field = "418341504F0A4D6308A9E99137AEAD7B")

    public static final String EXTRA_REPLACING = "android.intent.extra.REPLACING";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.246 -0400", hash_original_field = "10AF3F88A47C6BF509A46733829DED94", hash_generated_field = "A8F2D11013AECF3F2B67B1FBE5E632E8")

    public static final String EXTRA_ALARM_COUNT = "android.intent.extra.ALARM_COUNT";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.246 -0400", hash_original_field = "CED8E449BC449F97CE74B6548886F74C", hash_generated_field = "117449B583EA94D1C241A664ADE13004")

    public static final String EXTRA_DOCK_STATE = "android.intent.extra.DOCK_STATE";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.247 -0400", hash_original_field = "954A396C5EF2F4F5B23303CB14553104", hash_generated_field = "51DD9310B52641CEBF8E5912ABBF09BB")

    public static final int EXTRA_DOCK_STATE_UNDOCKED = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.247 -0400", hash_original_field = "BD3B2D3FC4175BA4AC68D02FA4554729", hash_generated_field = "57A27A4EFB33D3F5C84CA5A20B8F39B3")

    public static final int EXTRA_DOCK_STATE_DESK = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.247 -0400", hash_original_field = "BD82C25B13664796D6F4827E8F5D51C5", hash_generated_field = "75F49C97684FECC9E5C28B82E7E20EBF")

    public static final int EXTRA_DOCK_STATE_CAR = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.247 -0400", hash_original_field = "13489C8700DF644D9358E7066034612E", hash_generated_field = "F7634A037B9D5564993679CDF49FD88B")

    public static final int EXTRA_DOCK_STATE_LE_DESK = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.247 -0400", hash_original_field = "B9B581372489638C5D78BEEF77A03848", hash_generated_field = "6EB3D92262E3C4391652FCAA2CEBA4A1")

    public static final int EXTRA_DOCK_STATE_HE_DESK = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.247 -0400", hash_original_field = "A53EF334B862EBF7F93E95FF74814FCB", hash_generated_field = "848D2959548644F6D0600879EF0668A2")

    public static final String METADATA_DOCK_HOME = "android.dock_home";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.247 -0400", hash_original_field = "091C70F0ABBE30F039A8673A81C8F084", hash_generated_field = "9274BDF219627A5BD62F1500834D5081")

    public static final String EXTRA_BUG_REPORT = "android.intent.extra.BUG_REPORT";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.247 -0400", hash_original_field = "02D961C971B11906D9492EAC79B33FD2", hash_generated_field = "58A65C26300F59D945079081B32418DA")

    public static final String EXTRA_REMOTE_INTENT_TOKEN =
            "android.intent.extra.remote_intent_token";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.248 -0400", hash_original_field = "9A01FC0A3646C3EAD9E142CC732AB98B", hash_generated_field = "E39BA7649A125B42097E11ABF6A59B91")

    @Deprecated public static final String EXTRA_CHANGED_COMPONENT_NAME =
            "android.intent.extra.changed_component_name";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.257 -0400", hash_original_field = "86F69B83F2A7C6D2AC4979482E9A62E6", hash_generated_field = "1396139177598651F4FE696440AA6B60")

    public static final String EXTRA_CHANGED_COMPONENT_NAME_LIST =
            "android.intent.extra.changed_component_name_list";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.257 -0400", hash_original_field = "FDA69BBD39712C3E27E462661D93CE75", hash_generated_field = "9F6BB52BB136081B0B5B704137151D62")

    public static final String EXTRA_CHANGED_PACKAGE_LIST =
            "android.intent.extra.changed_package_list";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.257 -0400", hash_original_field = "5B90A66309396174E4747C13B353BAE4", hash_generated_field = "0A835C4E438F2FB3E3F07E556FA3173A")

    public static final String EXTRA_CHANGED_UID_LIST =
            "android.intent.extra.changed_uid_list";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.257 -0400", hash_original_field = "2F4FBD002879C06D2D00B86E0322059C", hash_generated_field = "CE2CE80B4644D04179C8E3EAC591C752")

    public static final String EXTRA_CLIENT_LABEL =
            "android.intent.extra.client_label";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.257 -0400", hash_original_field = "545743511ACD01A6F78290186C426603", hash_generated_field = "7990A58774E5328794603E8DA07B84D6")

    public static final String EXTRA_CLIENT_INTENT =
            "android.intent.extra.client_intent";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.257 -0400", hash_original_field = "83824871407F038EBBD8981DB142BC94", hash_generated_field = "32EF8D5E473BF09D7DFE2474A075B3EF")

    public static final String EXTRA_LOCAL_ONLY =
        "android.intent.extra.LOCAL_ONLY";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.258 -0400", hash_original_field = "BC0657EC269830B71A283FD515E1D281", hash_generated_field = "51862CBCF8D4640389DEA37A774D56AE")

    public static final int FLAG_GRANT_READ_URI_PERMISSION = 0x00000001;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.258 -0400", hash_original_field = "7051451C73C1ABB33910546B483789B4", hash_generated_field = "AD11D27A7135AF27D29F8A1800E38B48")

    public static final int FLAG_GRANT_WRITE_URI_PERMISSION = 0x00000002;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.258 -0400", hash_original_field = "FFBFA876EBFFC162F8D7EF90769E790E", hash_generated_field = "F5144D0DD2B503AE068147CFB8AF3E20")

    public static final int FLAG_FROM_BACKGROUND = 0x00000004;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.258 -0400", hash_original_field = "0D92A15C2A3E9F421BDB2C1CE6D4FC76", hash_generated_field = "4992800D2B3327EB8ABD9B8392D76E59")

    public static final int FLAG_DEBUG_LOG_RESOLUTION = 0x00000008;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.258 -0400", hash_original_field = "7418B2D0649AC60F9EF55DC969249726", hash_generated_field = "F0503BB7715C67922785A00785804343")

    public static final int FLAG_EXCLUDE_STOPPED_PACKAGES = 0x00000010;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.258 -0400", hash_original_field = "BCF02393735EE15A1FE8B6F6109B2DC4", hash_generated_field = "6BF870212E33BF54D2F47B772F7E1D4D")

    public static final int FLAG_INCLUDE_STOPPED_PACKAGES = 0x00000020;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.258 -0400", hash_original_field = "8B546A30AB14489B8FFDEC1B666587BC", hash_generated_field = "2C482F373AA08BD3E8BAE66D0ABEB4A1")

    public static final int FLAG_ACTIVITY_NO_HISTORY = 0x40000000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.258 -0400", hash_original_field = "359B4835F93ACBCAFF71741A880AED3E", hash_generated_field = "F1C3991F7C5363979EB2F7071FC1B1E7")

    public static final int FLAG_ACTIVITY_SINGLE_TOP = 0x20000000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.258 -0400", hash_original_field = "FB39F645C4D630026BD55D59A1AC611D", hash_generated_field = "CB2EB43571F9F913DD85855F2A62F676")

    public static final int FLAG_ACTIVITY_NEW_TASK = 0x10000000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.259 -0400", hash_original_field = "2EF2E7C3F1F0E7AA90FAD9586221976A", hash_generated_field = "5331C0D5175D1B442B1E11194633885C")

    public static final int FLAG_ACTIVITY_MULTIPLE_TASK = 0x08000000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.259 -0400", hash_original_field = "9E1EFE5434DC4981642B64A89E92C518", hash_generated_field = "D15C6C6162723C7D62F659062880F6F9")

    public static final int FLAG_ACTIVITY_CLEAR_TOP = 0x04000000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.259 -0400", hash_original_field = "3E2D3EFE1886ABFC906946DF47538599", hash_generated_field = "F049434BC355C895C7B98BCE57D6923A")

    public static final int FLAG_ACTIVITY_FORWARD_RESULT = 0x02000000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.259 -0400", hash_original_field = "90968E170D46575A3A7B7892BC9AA882", hash_generated_field = "A963C95BDF18D2B0A0A3417D1EB14C63")

    public static final int FLAG_ACTIVITY_PREVIOUS_IS_TOP = 0x01000000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.259 -0400", hash_original_field = "8E831E15B9AD9EEBE1BB200162C979CE", hash_generated_field = "93C6E464C79835E60A724A0F138B2E5A")

    public static final int FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS = 0x00800000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.259 -0400", hash_original_field = "88D0F59312DAEB7DBBE760B4EE938E30", hash_generated_field = "475E818BB383C15D3EB34352066AF070")

    public static final int FLAG_ACTIVITY_BROUGHT_TO_FRONT = 0x00400000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.259 -0400", hash_original_field = "47358C93E57A26EF2A13AB4B32FBBE17", hash_generated_field = "09C09520072C3FC5B6B5D304280BB98B")

    public static final int FLAG_ACTIVITY_RESET_TASK_IF_NEEDED = 0x00200000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.259 -0400", hash_original_field = "BDDED4D3FA5833F4031180DDBB7C3A8A", hash_generated_field = "E6A8EC3B88D6C8ADD31C990D62C7170C")

    public static final int FLAG_ACTIVITY_LAUNCHED_FROM_HISTORY = 0x00100000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.260 -0400", hash_original_field = "0CC69F9ADF0C27361F82CBEE8255AA54", hash_generated_field = "0A9BB1EBF39780BBC96BF9154BADA771")

    public static final int FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET = 0x00080000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.270 -0400", hash_original_field = "9B0A01E5E2723B343A323ECEF6EB02EB", hash_generated_field = "BBB8D1C2213AA3D2546EE97A96B54CB3")

    public static final int FLAG_ACTIVITY_NO_USER_ACTION = 0x00040000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.270 -0400", hash_original_field = "E6D5DB8077429B364EE46BB3BAEE5FC3", hash_generated_field = "CD635E17DCA336DCD58C5F1450A5987B")

    public static final int FLAG_ACTIVITY_REORDER_TO_FRONT = 0X00020000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.270 -0400", hash_original_field = "9B2F27E6148CE14C0433775C4D784896", hash_generated_field = "2D9D2B18DAADEC730FD6599A8ACA6995")

    public static final int FLAG_ACTIVITY_NO_ANIMATION = 0X00010000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.270 -0400", hash_original_field = "20925229C9ECAA8CDEA944C0BF02149A", hash_generated_field = "486F83A3C19D70714934307A944E56C2")

    public static final int FLAG_ACTIVITY_CLEAR_TASK = 0X00008000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.270 -0400", hash_original_field = "2CC258568DD3D806AEEB48062AB5BE1E", hash_generated_field = "3DDA11574C4AF819E971AFE75A5CC07F")

    public static final int FLAG_ACTIVITY_TASK_ON_HOME = 0X00004000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.270 -0400", hash_original_field = "40D14A1AB30110CD3AB8173DA521B51D", hash_generated_field = "9E9DE382F25B3D58CC45D1E0C5D1436F")

    public static final int FLAG_RECEIVER_REGISTERED_ONLY = 0x40000000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.271 -0400", hash_original_field = "4F5BD59FD57D224EF013DBDD84B27DCB", hash_generated_field = "8E1ED2FC53376B3E78D1743C1F51D866")

    public static final int FLAG_RECEIVER_REPLACE_PENDING = 0x20000000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.271 -0400", hash_original_field = "5F72861FE2E2A3B1733DB4FA41011078", hash_generated_field = "7603B3041648CE612B1F62C28DF51220")

    public static final int FLAG_RECEIVER_REGISTERED_ONLY_BEFORE_BOOT = 0x10000000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.271 -0400", hash_original_field = "D9A24967D145EE204E5F678A2D23710E", hash_generated_field = "4D515443C5DB3D74B79815278456FCD3")

    public static final int FLAG_RECEIVER_BOOT_UPGRADE = 0x08000000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.271 -0400", hash_original_field = "3E241774911B3E81F1C0C8546C5449BB", hash_generated_field = "FD626475D9F6D6885F7E9DE54C1764F4")

    public static final int IMMUTABLE_FLAGS =
            FLAG_GRANT_READ_URI_PERMISSION
            | FLAG_GRANT_WRITE_URI_PERMISSION;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.271 -0400", hash_original_field = "13C9A3DA8736EDFFB7A6AFEE0BC01DD6", hash_generated_field = "1692965D76F6FCDDE4F31AC57A385A83")

    public static final int URI_INTENT_SCHEME = 1<<0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.271 -0400", hash_original_field = "F66119B16D5ADE52FA6F9F421EDF5D08", hash_generated_field = "63F981009E9BE73A1613A3A86CDA35C4")

    public static final int FILL_IN_ACTION = 1<<0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.271 -0400", hash_original_field = "6148B3E448E59D56502B89E19BB0A504", hash_generated_field = "467AD345159485AE2F5ED6775DC51B27")

    public static final int FILL_IN_DATA = 1<<1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.271 -0400", hash_original_field = "5365BA328C38E80FE195301EC5B759BC", hash_generated_field = "E89FFA2B091BAA2212245B31F564CFFF")

    public static final int FILL_IN_CATEGORIES = 1<<2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.272 -0400", hash_original_field = "78907C6FCD24B0D41AC9FFB1F8B13204", hash_generated_field = "6A3A0FFA6E425DF959306D11B15FF92D")

    public static final int FILL_IN_COMPONENT = 1<<3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.272 -0400", hash_original_field = "19A36D6480C50FDA6A30F8381EBA3C84", hash_generated_field = "363CC3E98D7D1AC7FC1E2718D2D54631")

    public static final int FILL_IN_PACKAGE = 1<<4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.272 -0400", hash_original_field = "8290D065BDE0155AB9AA8FBBE8556608", hash_generated_field = "87B57C3E1EED611456B2BA9EAB493CAA")

    public static final int FILL_IN_SOURCE_BOUNDS = 1<<5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.272 -0400", hash_original_field = "8FF3A165F0D3710C235076AB22D9B008", hash_generated_field = "F1670B3FCB0D6CFDDC829822B3B96A6F")

    public static final int FILL_IN_SELECTOR = 1<<6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:02.272 -0400", hash_original_field = "D14178DBCD458ABEE4FEAD50EBCFE74B", hash_generated_field = "B872AD5D6A6EEC2D35FED959BF1EC3BA")

    public static final Parcelable.Creator<Intent> CREATOR
            = new Parcelable.Creator<Intent>() {
        public Intent createFromParcel(Parcel in) {
            return new Intent(in);
        }
        public Intent[] newArray(int size) {
            return new Intent[size];
        }
    };
}

