package android.content;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.io.IOException;
import java.io.Serializable;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import android.annotation.SdkConstant;
import android.annotation.SdkConstant.SdkConstantType;
import android.content.Intent;
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

import com.android.internal.util.XmlUtils;






public class Intent implements Parcelable, Cloneable {
    @DSVAModeled
    private String mAction;
    @DSVAModeled
    private Uri mData;
    @DSVAModeled
    private String mType;
    private String mPackage;
    private ComponentName mComponent;
    @DSVAModeled
    private int mFlags;
    private HashSet<String> mCategories;
    private Bundle mExtras;
    private Rect mSourceBounds;
    private Intent mSelector;
    
    @DSModeled(DSC.SAFE)
	public Intent() {
		//Do Nothing
	}

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.415 -0400", hash_original_method = "3FAB664599EE7924CC36F277EFA522C8", hash_generated_method = "AB0CC1E246524C1E63F16EBEA02DAD1F")
    public  Intent(Intent o) {
        this.mAction = o.mAction;
        this.mData = o.mData;
        this.mType = o.mType;
        this.mPackage = o.mPackage;
        this.mComponent = o.mComponent;
        this.mFlags = o.mFlags;
        if(o.mCategories != null)        
        {
            this.mCategories = new HashSet<String>(o.mCategories);
        } //End block
        if(o.mExtras != null)        
        {
            this.mExtras = new Bundle(o.mExtras);
        } //End block
        if(o.mSourceBounds != null)        
        {
            this.mSourceBounds = new Rect(o.mSourceBounds);
        } //End block
        if(o.mSelector != null)        
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

    
    @DSModeled(DSC.BAN)
	private Intent(Intent o, boolean all) {
		/*
		 * Piggyback on the setters to track the taint.  The desire here
		 * is to "inherit" the taint from the Intent that is passed in
		 */
		this.setAction(o.getAction());
		this.setData(o.getData());
		this.setType(o.getType());
		this.setPackage(o.getPackage());
		this.setComponent(o.getComponent());
		for (String category : o.getCategories()) {
			this.addCategory(category);
		}
		/*
		this.setCategories
        this.mAction = o.mAction;
        this.mData = o.mData;
        this.mType = o.mType;
        this.mPackage = o.mPackage;
        this.mComponent = o.mComponent;
        if (o.mCategories != null) {
            this.mCategories = new HashSet<String>(o.mCategories);
        }
        */
    }

    
    @DSModeled(DSC.SAFE)
	public Intent(String action) {
        mAction = action;
    }

    
    @DSModeled(DSC.SAFE)
	public Intent(String action, Uri uri) {
        mAction = action;
        mData = uri;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.417 -0400", hash_original_method = "8A8F598E2C7B57A58F1379D7AFC8B81F", hash_generated_method = "CFC95A750DAD5D8F9B4AF9DD7CFFB32A")
    public  Intent(Context packageContext, Class<?> cls) {
        mComponent = new ComponentName(packageContext, cls);
        // ---------- Original Method ----------
        //mComponent = new ComponentName(packageContext, cls);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.417 -0400", hash_original_method = "780AF3DA4D357977F460A8077F315476", hash_generated_method = "6432A8C7753059113592629EBEB24128")
    public  Intent(String action, Uri uri,
            Context packageContext, Class<?> cls) {
        addTaint(action.getTaint());
        setAction(action);
        mData = uri;
        mComponent = new ComponentName(packageContext, cls);
        // ---------- Original Method ----------
        //setAction(action);
        //mData = uri;
        //mComponent = new ComponentName(packageContext, cls);
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.417 -0400", hash_original_method = "BDABA8F9DB7F141DA2E5B48F186347CF", hash_generated_method = "BE74D7ED2F7F96E22889D59E35F861D9")
    protected  Intent(Parcel in) {
        addTaint(in.getTaint());
        readFromParcel(in);
        // ---------- Original Method ----------
        //readFromParcel(in);
    }

    
    @DSModeled(DSC.SPEC)
    public static Intent createChooser(Intent target, CharSequence title) {
        Intent intent = new Intent(ACTION_CHOOSER);
        intent.putExtra(EXTRA_INTENT, target);
        if (title != null) {
            intent.putExtra(EXTRA_TITLE, title);
        }
        return intent;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.418 -0400", hash_original_method = "0DE1E082CFAE738C657D3967F7BD3FA4", hash_generated_method = "72FE5AC65CE7C50D3EC8AEC99BE9E0FD")
    @Override
    public Object clone() {
Object var4E36CBC0BD061E9EF480883B7FB24134_284325800 =         new Intent(this);
        var4E36CBC0BD061E9EF480883B7FB24134_284325800.addTaint(taint);
        return var4E36CBC0BD061E9EF480883B7FB24134_284325800;
        // ---------- Original Method ----------
        //return new Intent(this);
    }

    
    @DSModeled(DSC.SAFE)
    public Intent cloneFilter() {
        return new Intent(this, false);
    }

    
    @DSModeled(DSC.SPEC)
    public static Intent makeMainActivity(ComponentName mainActivity) {
        Intent intent = new Intent(ACTION_MAIN);
        intent.setComponent(mainActivity);
        intent.addCategory(CATEGORY_LAUNCHER);
        return intent;
    }

    
    @DSModeled(DSC.SPEC)
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

    
    @DSModeled(DSC.SPEC)
    public static Intent makeRestartActivityTask(ComponentName mainActivity) {
        Intent intent = makeMainActivity(mainActivity);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK
                | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        return intent;
    }

    
    @DSModeled(DSC.SAFE)
    @Deprecated
    public static Intent getIntent(String uri) throws URISyntaxException {
        return parseUri(uri, 0);
    }

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SPEC)
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

    
    @DSModeled(DSC.SAFE) 
	public String getAction() {
		return mAction;
    }

    
    @DSModeled(DSC.SAFE)
	public Uri getData() {
        return mData;
    }

    
    @DSModeled(DSC.SAFE)
	public String getDataString() {
		return mData.toString();
        //return mData != null ? mData.toString() : null;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.421 -0400", hash_original_method = "773226227E17626211D04D8FDBCEC473", hash_generated_method = "6D4F3F5A21A24EC8D302B02FF0CEEC7E")
    public String getScheme() {
String var14402EC0EA2C7358ED085D3C5F282D68_1487754608 =         mData != null ? mData.getScheme() : null;
        var14402EC0EA2C7358ED085D3C5F282D68_1487754608.addTaint(taint);
        return var14402EC0EA2C7358ED085D3C5F282D68_1487754608;
        // ---------- Original Method ----------
        //return mData != null ? mData.getScheme() : null;
    }

    
    @DSModeled(DSC.SAFE) // Marked as SPEC per the original implementation from MIT
	public String getType() {
        return mType;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.422 -0400", hash_original_method = "BE275DDE2732AB3F4C79CA9D98784573", hash_generated_method = "9D577D895FC0521976A8B21AD92CDDC5")
    public String resolveType(Context context) {
        addTaint(context.getTaint());
String var90C2C1F361CED89C7BFAD7D8E72DF5B5_1542570561 =         resolveType(context.getContentResolver());
        var90C2C1F361CED89C7BFAD7D8E72DF5B5_1542570561.addTaint(taint);
        return var90C2C1F361CED89C7BFAD7D8E72DF5B5_1542570561;
        // ---------- Original Method ----------
        //return resolveType(context.getContentResolver());
    }

    
    @DSModeled(DSC.SAFE)
	public String resolveType(ContentResolver resolver) {
		/*
        if (mType != null) {
            return mType;
        }
        if (mData != null) { 
            if ("content".equals(mData.getScheme())) {
                return resolver.getType(mData);
            }
        }
        return null;
        */
		return getType();  //At the end of the day, it's a string, and we are doing static analysis
    }

    
    @DSModeled(value = DSC.SAFE)
	public String resolveTypeIfNeeded(ContentResolver resolver) {
		/*
		if (mComponent != null) {
		    return getType();
		}
		return resolveType(resolver);
		*/
		return getType();  //At the end of the day, it's a string, and we are doing static analysis
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.423 -0400", hash_original_method = "3612221F73372432993CCD6954A20D1D", hash_generated_method = "106F0CADEE30CF8C4D8083D888F4F776")
    public boolean hasCategory(String category) {
        addTaint(category.getTaint());
        boolean varEFA7F491986BF2EBD52565F05969A03E_992308320 = (mCategories != null && mCategories.contains(category));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1065773279 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1065773279;
        // ---------- Original Method ----------
        //return mCategories != null && mCategories.contains(category);
    }

    
    @DSModeled(DSC.SAFE)
	public Set<String> getCategories() {
		return mCategories;
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.423 -0400", hash_original_method = "0EFF867FD71A8B842E16179807F3AE79", hash_generated_method = "27232CF1746F2DC816655A1E01CD16D7")
    public Intent getSelector() {
Intent var44BB8E3AFA16E93BC70CCD822DE8222C_926770618 =         mSelector;
        var44BB8E3AFA16E93BC70CCD822DE8222C_926770618.addTaint(taint);
        return var44BB8E3AFA16E93BC70CCD822DE8222C_926770618;
        // ---------- Original Method ----------
        //return mSelector;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.424 -0400", hash_original_method = "C5389CB5192CD8E55615D6E62222251D", hash_generated_method = "9CF2EFE64D764A4F343BED5B7359B35F")
    public void setExtrasClassLoader(ClassLoader loader) {
        addTaint(loader.getTaint());
        if(mExtras != null)        
        {
            mExtras.setClassLoader(loader);
        } //End block
        // ---------- Original Method ----------
        //if (mExtras != null) {
            //mExtras.setClassLoader(loader);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.424 -0400", hash_original_method = "820997F7D9BF8A8B37DA5723F540EC8D", hash_generated_method = "E4731233C5D24201E9FF7A3F6132216A")
    public boolean hasExtra(String name) {
        addTaint(name.getTaint());
        boolean varA5BD5D8FBAED4C54F522F339A357AABF_2044704185 = (mExtras != null && mExtras.containsKey(name));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_63672761 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_63672761;
        // ---------- Original Method ----------
        //return mExtras != null && mExtras.containsKey(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.424 -0400", hash_original_method = "A4A187292984F1C3EE73C7C78931040C", hash_generated_method = "985E73BB9279E7F638C13A8B57C0CED8")
    public boolean hasFileDescriptors() {
        boolean var06E1EC96D3995934901FB1C116C048B6_723641061 = (mExtras != null && mExtras.hasFileDescriptors());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_23135940 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_23135940;
        // ---------- Original Method ----------
        //return mExtras != null && mExtras.hasFileDescriptors();
    }

    
    @DSModeled(DSC.BAN)
	public void setAllowFds(boolean allowFds) {
		// NOTE:  mExtras is a Bundle, perhaps it is best to push the taint down to that level
		addTaint(allowFds);
		/*
        if (mExtras != null) {
            mExtras.setAllowFds(allowFds);
        }
        */
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.425 -0400", hash_original_method = "4C23C66584C2E08F8D8923DC65F21B8A", hash_generated_method = "A6C7B5DCA1335B2906533F14678DCC62")
    @Deprecated
    public Object getExtra(String name) {
        addTaint(name.getTaint());
Object var7B6D65C767FBDEFE1F1B6D9F836F0E78_860317118 =         getExtra(name, null);
        var7B6D65C767FBDEFE1F1B6D9F836F0E78_860317118.addTaint(taint);
        return var7B6D65C767FBDEFE1F1B6D9F836F0E78_860317118;
        // ---------- Original Method ----------
        //return getExtra(name, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.425 -0400", hash_original_method = "6C77EA53DBDF6A732015829C63BCD454", hash_generated_method = "076C7FF9A0E9E168A9B636ECDD9A87ED")
    public boolean getBooleanExtra(String name, boolean defaultValue) {
        addTaint(defaultValue);
        addTaint(name.getTaint());
        boolean varF8C9AEB8FA1D510CFB5EF4F9F2CADB5A_1688635061 = (mExtras == null ? defaultValue :
            mExtras.getBoolean(name, defaultValue));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1439406997 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1439406997;
        // ---------- Original Method ----------
        //return mExtras == null ? defaultValue :
            //mExtras.getBoolean(name, defaultValue);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.426 -0400", hash_original_method = "7FB23DDD0BCB246CA49844E5ABE7B23C", hash_generated_method = "C41823EC76B63CADA23B512712485872")
    public byte getByteExtra(String name, byte defaultValue) {
        addTaint(defaultValue);
        addTaint(name.getTaint());
        byte var96FDD46CE6E3912C3106F72E808292C9_795678178 = (mExtras == null ? defaultValue :
            mExtras.getByte(name, defaultValue));
                byte var40EA57D3EE3C07BF1C102B466E1C3091_1755456482 = getTaintByte();
        return var40EA57D3EE3C07BF1C102B466E1C3091_1755456482;
        // ---------- Original Method ----------
        //return mExtras == null ? defaultValue :
            //mExtras.getByte(name, defaultValue);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.426 -0400", hash_original_method = "7EF2CF350AA07FA1327C85A618EDDBDF", hash_generated_method = "63788E4874ACB666259733A7BB004FC6")
    public short getShortExtra(String name, short defaultValue) {
        addTaint(defaultValue);
        addTaint(name.getTaint());
        short varF283EF1C21DB792F2AF112972729EF6A_1316218159 = (mExtras == null ? defaultValue :
            mExtras.getShort(name, defaultValue));
                short var4F09DAA9D95BCB166A302407A0E0BABE_799309178 = getTaintShort();
        return var4F09DAA9D95BCB166A302407A0E0BABE_799309178;
        // ---------- Original Method ----------
        //return mExtras == null ? defaultValue :
            //mExtras.getShort(name, defaultValue);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.426 -0400", hash_original_method = "49AA93250C5B660485540E34F899D621", hash_generated_method = "3E56CF52C607E0B57FE12026E177C9E5")
    public char getCharExtra(String name, char defaultValue) {
        addTaint(defaultValue);
        addTaint(name.getTaint());
        char var0AB118C31E6009F54F168C339A8267A3_2069569083 = (mExtras == null ? defaultValue :
            mExtras.getChar(name, defaultValue));
                char varA87DEB01C5F539E6BDA34829C8EF2368_1680144516 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_1680144516;
        // ---------- Original Method ----------
        //return mExtras == null ? defaultValue :
            //mExtras.getChar(name, defaultValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.426 -0400", hash_original_method = "E0513A91E6CBAE3AB1C6E2298E28F4E9", hash_generated_method = "97E6CEDF8541EFD8F2884B3A4C892A13")
    public int getIntExtra(String name, int defaultValue) {
        addTaint(defaultValue);
        addTaint(name.getTaint());
        int var1E9B6EF3F04EC3ECFD3AFD68F89E1DE4_906446360 = (mExtras == null ? defaultValue :
            mExtras.getInt(name, defaultValue));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_709530621 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_709530621;
        // ---------- Original Method ----------
        //return mExtras == null ? defaultValue :
            //mExtras.getInt(name, defaultValue);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.427 -0400", hash_original_method = "C094BEE2071DFD73ABD25F184B7F6CE5", hash_generated_method = "150F6842C8D4AC425E8C7994DA380605")
    public long getLongExtra(String name, long defaultValue) {
        addTaint(defaultValue);
        addTaint(name.getTaint());
        long varDF0FF5F69820FDF74ED93047BB7C13C5_653762628 = (mExtras == null ? defaultValue :
            mExtras.getLong(name, defaultValue));
                long var0F5264038205EDFB1AC05FBB0E8C5E94_219033016 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_219033016;
        // ---------- Original Method ----------
        //return mExtras == null ? defaultValue :
            //mExtras.getLong(name, defaultValue);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.427 -0400", hash_original_method = "468C9940FDAFD3DDCC0968AC84566FDC", hash_generated_method = "6710BB305A32CA3567CF7E66B0C78B22")
    public float getFloatExtra(String name, float defaultValue) {
        addTaint(defaultValue);
        addTaint(name.getTaint());
        float varFF428685A0B16739EFFF079934838235_71902117 = (mExtras == null ? defaultValue :
            mExtras.getFloat(name, defaultValue));
                float var546ADE640B6EDFBC8A086EF31347E768_792431165 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_792431165;
        // ---------- Original Method ----------
        //return mExtras == null ? defaultValue :
            //mExtras.getFloat(name, defaultValue);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.427 -0400", hash_original_method = "9D513802316CA501D261DB0FDD177D9E", hash_generated_method = "CB66F24853CAC2E512485B9DA25BA573")
    public double getDoubleExtra(String name, double defaultValue) {
        addTaint(defaultValue);
        addTaint(name.getTaint());
        double var626AF4FA4F8E74DB8CDA3B20322A71D4_1172895545 = (mExtras == null ? defaultValue :
            mExtras.getDouble(name, defaultValue));
                double varE8CD7DA078A86726031AD64F35F5A6C0_1185396273 = getTaintDouble();
        return varE8CD7DA078A86726031AD64F35F5A6C0_1185396273;
        // ---------- Original Method ----------
        //return mExtras == null ? defaultValue :
            //mExtras.getDouble(name, defaultValue);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.428 -0400", hash_original_method = "8063ECA9F5AA2AEF21F6A345FFE2B7E6", hash_generated_method = "78093FE57E4E78ACCC5621C882888D1C")
    public String getStringExtra(String name) {
        addTaint(name.getTaint());
String varD39C080D7FA6C4D7CC9994EB69BF755B_1551148785 =         mExtras == null ? null : mExtras.getString(name);
        varD39C080D7FA6C4D7CC9994EB69BF755B_1551148785.addTaint(taint);
        return varD39C080D7FA6C4D7CC9994EB69BF755B_1551148785;
        // ---------- Original Method ----------
        //return mExtras == null ? null : mExtras.getString(name);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.428 -0400", hash_original_method = "1694F41DCC8D039EBF419B4A0F2C4125", hash_generated_method = "86F5F4D081D56B1722DC2484B9300D86")
    public CharSequence getCharSequenceExtra(String name) {
        addTaint(name.getTaint());
CharSequence varFD94F0E7CBE7E4DCFEA8BB6A86B10B0F_1715305746 =         mExtras == null ? null : mExtras.getCharSequence(name);
        varFD94F0E7CBE7E4DCFEA8BB6A86B10B0F_1715305746.addTaint(taint);
        return varFD94F0E7CBE7E4DCFEA8BB6A86B10B0F_1715305746;
        // ---------- Original Method ----------
        //return mExtras == null ? null : mExtras.getCharSequence(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.428 -0400", hash_original_method = "1C448816D9B902054FE9E8A698247DA2", hash_generated_method = "3E3DEE7B959E87E94EACE1CB55226D17")
    public <T extends Parcelable> T getParcelableExtra(String name) {
        addTaint(name.getTaint());
T varE60849F90CB2B10CC4141E5BFED9EBB4_1888496787 =         mExtras == null ? null : mExtras.<T>getParcelable(name);
        varE60849F90CB2B10CC4141E5BFED9EBB4_1888496787.addTaint(taint);
        return varE60849F90CB2B10CC4141E5BFED9EBB4_1888496787;
        // ---------- Original Method ----------
        //return mExtras == null ? null : mExtras.<T>getParcelable(name);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.429 -0400", hash_original_method = "28D360BBB773D3DC39CC6E8B3FB095BE", hash_generated_method = "27FC64138A767F687876B4851C2F1D04")
    public Parcelable[] getParcelableArrayExtra(String name) {
        addTaint(name.getTaint());
Parcelable[] varD1F3082EF198383A6D9D185E31F8511B_494461160 =         mExtras == null ? null : mExtras.getParcelableArray(name);
        varD1F3082EF198383A6D9D185E31F8511B_494461160.addTaint(taint);
        return varD1F3082EF198383A6D9D185E31F8511B_494461160;
        // ---------- Original Method ----------
        //return mExtras == null ? null : mExtras.getParcelableArray(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.429 -0400", hash_original_method = "BB02D0F500EDCAC2282F912174ECF594", hash_generated_method = "8496E3B52B9613F422993EC5A62C4915")
    public <T extends Parcelable> ArrayList<T> getParcelableArrayListExtra(String name) {
        addTaint(name.getTaint());
ArrayList<T> var2AA7AC40ADC652D6C8E180CF68F49870_1307005652 =         mExtras == null ? null : mExtras.<T>getParcelableArrayList(name);
        var2AA7AC40ADC652D6C8E180CF68F49870_1307005652.addTaint(taint);
        return var2AA7AC40ADC652D6C8E180CF68F49870_1307005652;
        // ---------- Original Method ----------
        //return mExtras == null ? null : mExtras.<T>getParcelableArrayList(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.429 -0400", hash_original_method = "9F4D1ACCAA6C6918CB97F661FEDB7260", hash_generated_method = "F3799C8570F88EE9A28391B38A821267")
    public Serializable getSerializableExtra(String name) {
        addTaint(name.getTaint());
Serializable varE76A3D25F3D2E6A75E98E0F15C3E7223_1822878399 =         mExtras == null ? null : mExtras.getSerializable(name);
        varE76A3D25F3D2E6A75E98E0F15C3E7223_1822878399.addTaint(taint);
        return varE76A3D25F3D2E6A75E98E0F15C3E7223_1822878399;
        // ---------- Original Method ----------
        //return mExtras == null ? null : mExtras.getSerializable(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.430 -0400", hash_original_method = "E5A5C9C6BF01CEEFEAABCB20BBD32323", hash_generated_method = "C7B523624A769F8362C0D64B4814758B")
    public ArrayList<Integer> getIntegerArrayListExtra(String name) {
        addTaint(name.getTaint());
ArrayList<Integer> var9AC48EE8984558576697C21E39D624EF_106733645 =         mExtras == null ? null : mExtras.getIntegerArrayList(name);
        var9AC48EE8984558576697C21E39D624EF_106733645.addTaint(taint);
        return var9AC48EE8984558576697C21E39D624EF_106733645;
        // ---------- Original Method ----------
        //return mExtras == null ? null : mExtras.getIntegerArrayList(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.430 -0400", hash_original_method = "D8E538521D5877A04B9E1243CFFC8BD3", hash_generated_method = "8AE8FAC613AB6E98CAD3E12D7F5AC41A")
    public ArrayList<String> getStringArrayListExtra(String name) {
        addTaint(name.getTaint());
ArrayList<String> var21EE104992E340FBA26E0510B19A312E_1307727581 =         mExtras == null ? null : mExtras.getStringArrayList(name);
        var21EE104992E340FBA26E0510B19A312E_1307727581.addTaint(taint);
        return var21EE104992E340FBA26E0510B19A312E_1307727581;
        // ---------- Original Method ----------
        //return mExtras == null ? null : mExtras.getStringArrayList(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.430 -0400", hash_original_method = "3C0B0EF6206949D4005752F37A471C32", hash_generated_method = "FD12BAFBB3D8C9A3408B9701B4ADFF3C")
    public ArrayList<CharSequence> getCharSequenceArrayListExtra(String name) {
        addTaint(name.getTaint());
ArrayList<CharSequence> var3AE0483906B1F35D7B8AE1EDC698614E_1436506287 =         mExtras == null ? null : mExtras.getCharSequenceArrayList(name);
        var3AE0483906B1F35D7B8AE1EDC698614E_1436506287.addTaint(taint);
        return var3AE0483906B1F35D7B8AE1EDC698614E_1436506287;
        // ---------- Original Method ----------
        //return mExtras == null ? null : mExtras.getCharSequenceArrayList(name);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.431 -0400", hash_original_method = "FE55BFBE9F4BF617BE3A0BE7101EDA89", hash_generated_method = "92765442F156FDFAE36C83D30081E45C")
    public boolean[] getBooleanArrayExtra(String name) {
        addTaint(name.getTaint());
        boolean[] varAA567225C61BD7E69CD9448AF7C35F2B_741335775 = (mExtras == null ? null : mExtras.getBooleanArray(name));
                boolean[] var503EB2F420079C4024483971CE5EDEA8_1824442077 = {getTaintBoolean()};
        return var503EB2F420079C4024483971CE5EDEA8_1824442077;
        // ---------- Original Method ----------
        //return mExtras == null ? null : mExtras.getBooleanArray(name);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.431 -0400", hash_original_method = "8982B2CEDDCF3062481CA9400546FBDD", hash_generated_method = "389BABB5FF3AEEDB4AC2BE244D9956CD")
    public byte[] getByteArrayExtra(String name) {
        addTaint(name.getTaint());
        byte[] varBC7D26F2789D4B5E40CFDE528065CA8E_1575871529 = (mExtras == null ? null : mExtras.getByteArray(name));
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1742406052 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1742406052;
        // ---------- Original Method ----------
        //return mExtras == null ? null : mExtras.getByteArray(name);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.432 -0400", hash_original_method = "CD9B24503F7344F42640A5B885850704", hash_generated_method = "8BE9C09A021D8AF3CA28BA70EA597AC1")
    public short[] getShortArrayExtra(String name) {
        addTaint(name.getTaint());
        short[] var78EAFAEEF8075D317AE8F772054107DB_1091225109 = (mExtras == null ? null : mExtras.getShortArray(name));
                short[] var48EE7E2DDF8A83602BC526873BD0F875_1018079212 = {getTaintShort()};
        return var48EE7E2DDF8A83602BC526873BD0F875_1018079212;
        // ---------- Original Method ----------
        //return mExtras == null ? null : mExtras.getShortArray(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.432 -0400", hash_original_method = "CC419D577155763512853EA59FC750C3", hash_generated_method = "270E41132362423CBC85CF2BEE6832D2")
    public char[] getCharArrayExtra(String name) {
        addTaint(name.getTaint());
        char[] varD655A3970CF282F37EE0B6CA9AD5329A_2012493787 = (mExtras == null ? null : mExtras.getCharArray(name));
                char[] var50607924ABD4C17119BAF3A1CE41C0EC_1888684329 = {getTaintChar()};
        return var50607924ABD4C17119BAF3A1CE41C0EC_1888684329;
        // ---------- Original Method ----------
        //return mExtras == null ? null : mExtras.getCharArray(name);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.432 -0400", hash_original_method = "0A82189594F324AE308815E53494E5B0", hash_generated_method = "7CF50CFB0E66895C384101E3EF0759CC")
    public int[] getIntArrayExtra(String name) {
        addTaint(name.getTaint());
        int[] varCF3F1E0A390D23AA476A9843C26AAB36_1009906126 = (mExtras == null ? null : mExtras.getIntArray(name));
                int[] varB4CCCA26F9DB9189C32F33E82D425CFB_1317045640 = {getTaintInt()};
        return varB4CCCA26F9DB9189C32F33E82D425CFB_1317045640;
        // ---------- Original Method ----------
        //return mExtras == null ? null : mExtras.getIntArray(name);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.433 -0400", hash_original_method = "2B191C1241796E74336A46C43420CA80", hash_generated_method = "9EFA500341C404B440C5467D40C85C44")
    public long[] getLongArrayExtra(String name) {
        addTaint(name.getTaint());
        long[] varE2C96D6782AAF74531A7FA058AAE884C_450971028 = (mExtras == null ? null : mExtras.getLongArray(name));
                long[] var3908C7C3AF5171CEE1F112DAE77A5C4D_950527575 = {getTaintLong()};
        return var3908C7C3AF5171CEE1F112DAE77A5C4D_950527575;
        // ---------- Original Method ----------
        //return mExtras == null ? null : mExtras.getLongArray(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.433 -0400", hash_original_method = "8DC240B1B74093D697F56B17354B0D80", hash_generated_method = "D360744C2EDF91A4779627092AAB4A84")
    public float[] getFloatArrayExtra(String name) {
        addTaint(name.getTaint());
        float[] varE49D21BB3DB9714FE0F5413A05BA41A7_787174211 = (mExtras == null ? null : mExtras.getFloatArray(name));
                float[] varB2C245003BAB9224CFB496218F7DAFE0_759689292 = {getTaintFloat()};
        return varB2C245003BAB9224CFB496218F7DAFE0_759689292;
        // ---------- Original Method ----------
        //return mExtras == null ? null : mExtras.getFloatArray(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.433 -0400", hash_original_method = "3975857C05E9D537152AB546E3F37275", hash_generated_method = "299649C8FBC70DA1BD9389AFA894CBDF")
    public double[] getDoubleArrayExtra(String name) {
        addTaint(name.getTaint());
        double[] varA3840541F8AFD0F30013460600142DA9_249013474 = (mExtras == null ? null : mExtras.getDoubleArray(name));
                double[] var74D44D7D9EE6FE6C3433D694F869E521_2117098216 = {getTaintDouble()};
        return var74D44D7D9EE6FE6C3433D694F869E521_2117098216;
        // ---------- Original Method ----------
        //return mExtras == null ? null : mExtras.getDoubleArray(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.434 -0400", hash_original_method = "63A5C80C2A9C3E397356915A6EC07B98", hash_generated_method = "4199C9D1B24E3B37232A70181A6275BF")
    public String[] getStringArrayExtra(String name) {
        addTaint(name.getTaint());
String[] var1A47970DACBF007AE5E821A4376E0993_144366735 =         mExtras == null ? null : mExtras.getStringArray(name);
        var1A47970DACBF007AE5E821A4376E0993_144366735.addTaint(taint);
        return var1A47970DACBF007AE5E821A4376E0993_144366735;
        // ---------- Original Method ----------
        //return mExtras == null ? null : mExtras.getStringArray(name);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.434 -0400", hash_original_method = "9443A9A4C1E608DAA4A110E653269318", hash_generated_method = "946D14174EB1C46658023D5ACCBBABC3")
    public CharSequence[] getCharSequenceArrayExtra(String name) {
        addTaint(name.getTaint());
CharSequence[] var85421B610B8FFEFD9A09205D73AA5017_660310104 =         mExtras == null ? null : mExtras.getCharSequenceArray(name);
        var85421B610B8FFEFD9A09205D73AA5017_660310104.addTaint(taint);
        return var85421B610B8FFEFD9A09205D73AA5017_660310104;
        // ---------- Original Method ----------
        //return mExtras == null ? null : mExtras.getCharSequenceArray(name);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.434 -0400", hash_original_method = "913345623B540CBB75EA0BDD1C78C162", hash_generated_method = "08A922B8905E26E9F84E4D6AFDDDBE01")
    public Bundle getBundleExtra(String name) {
        addTaint(name.getTaint());
Bundle varCAF11425754284BA0042910D87F52AA8_563939932 =         mExtras == null ? null : mExtras.getBundle(name);
        varCAF11425754284BA0042910D87F52AA8_563939932.addTaint(taint);
        return varCAF11425754284BA0042910D87F52AA8_563939932;
        // ---------- Original Method ----------
        //return mExtras == null ? null : mExtras.getBundle(name);
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.435 -0400", hash_original_method = "657BCF405F69BF4C38A0897E9F672C84", hash_generated_method = "C5C10EC532D799F4D053C8C2503A0A96")
    @Deprecated
    public IBinder getIBinderExtra(String name) {
        addTaint(name.getTaint());
IBinder var143A8928F3995535588F4196BEABE7CF_322701552 =         mExtras == null ? null : mExtras.getIBinder(name);
        var143A8928F3995535588F4196BEABE7CF_322701552.addTaint(taint);
        return var143A8928F3995535588F4196BEABE7CF_322701552;
        // ---------- Original Method ----------
        //return mExtras == null ? null : mExtras.getIBinder(name);
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.435 -0400", hash_original_method = "EF34C6BD33619501EBC4FFC15D7C460E", hash_generated_method = "AECC91048E492FB60D72B8C62B31BB3A")
    @Deprecated
    public Object getExtra(String name, Object defaultValue) {
        addTaint(defaultValue.getTaint());
        addTaint(name.getTaint());
        Object result = defaultValue;
        if(mExtras != null)        
        {
            Object result2 = mExtras.get(name);
            if(result2 != null)            
            {
                result = result2;
            } //End block
        } //End block
Object varDC838461EE2FA0CA4C9BBB70A15456B0_511777325 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_511777325.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_511777325;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.435 -0400", hash_original_method = "6E509C3CEA63C12F8DB889EF86C70010", hash_generated_method = "ED93A535A317EF0A8C9280AD35F2C9BC")
    public Bundle getExtras() {
Bundle var4F9FE858E08C30B848B61BEAFAD82050_1992340088 =         (mExtras != null)
                ? new Bundle(mExtras)
                : null;
        var4F9FE858E08C30B848B61BEAFAD82050_1992340088.addTaint(taint);
        return var4F9FE858E08C30B848B61BEAFAD82050_1992340088;
        // ---------- Original Method ----------
        //return (mExtras != null)
                //? new Bundle(mExtras)
                //: null;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.436 -0400", hash_original_method = "CE8F8E5E4A30C515D6BD9049A49703B9", hash_generated_method = "54F20B3CF6AD040BDBFDC17C02003D8E")
    public int getFlags() {
        int var9C3CD7D37D3E1E66BE9B3B005FC98B3A_830491007 = (mFlags);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1153013553 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1153013553;
        // ---------- Original Method ----------
        //return mFlags;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.436 -0400", hash_original_method = "35A271981CF0FB3B138FC227A1ADE9BA", hash_generated_method = "9EB5DD92EFB13DA3F606E9CE10DA530C")
    public boolean isExcludingStopped() {
        boolean varF654CFA3BF239782293FCF5698FE37D9_1128761184 = ((mFlags&(FLAG_EXCLUDE_STOPPED_PACKAGES|FLAG_INCLUDE_STOPPED_PACKAGES))
                == FLAG_EXCLUDE_STOPPED_PACKAGES);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1730346840 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1730346840;
        // ---------- Original Method ----------
        //return (mFlags&(FLAG_EXCLUDE_STOPPED_PACKAGES|FLAG_INCLUDE_STOPPED_PACKAGES))
                //== FLAG_EXCLUDE_STOPPED_PACKAGES;
    }

    
    @DSModeled(DSC.SAFE)
	public String getPackage() {
		return mPackage;
    }

    
    @DSModeled(DSC.SAFE)
	public ComponentName getComponent() {
		return mComponent;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.437 -0400", hash_original_method = "418D2917B5B7B0B035ED428CB7C119CA", hash_generated_method = "ED153E9969265145D2631C311071F1C7")
    public Rect getSourceBounds() {
Rect var47B7C311877A78ED56DAD53E1AC99143_1234670392 =         mSourceBounds;
        var47B7C311877A78ED56DAD53E1AC99143_1234670392.addTaint(taint);
        return var47B7C311877A78ED56DAD53E1AC99143_1234670392;
        // ---------- Original Method ----------
        //return mSourceBounds;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.438 -0400", hash_original_method = "CDA09128651728DC4DB1AA79DEAE44CB", hash_generated_method = "1272ABC4167F0B18079074F5726E0F00")
    public ComponentName resolveActivity(PackageManager pm) {
        addTaint(pm.getTaint());
        if(mComponent != null)        
        {
ComponentName var05A4B5AD7D0B7D1F57C4FD8455C615E7_1295665473 =             mComponent;
            var05A4B5AD7D0B7D1F57C4FD8455C615E7_1295665473.addTaint(taint);
            return var05A4B5AD7D0B7D1F57C4FD8455C615E7_1295665473;
        } //End block
        ResolveInfo info = pm.resolveActivity(
            this, PackageManager.MATCH_DEFAULT_ONLY);
        if(info != null)        
        {
ComponentName varDAFDEB71C985952F05D33F2507483A36_581603753 =             new ComponentName(
                    info.activityInfo.applicationInfo.packageName,
                    info.activityInfo.name);
            varDAFDEB71C985952F05D33F2507483A36_581603753.addTaint(taint);
            return varDAFDEB71C985952F05D33F2507483A36_581603753;
        } //End block
ComponentName var540C13E9E156B687226421B24F2DF178_1535167867 =         null;
        var540C13E9E156B687226421B24F2DF178_1535167867.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1535167867;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.439 -0400", hash_original_method = "4C4C454D517012EF1DC091F981BC8CF0", hash_generated_method = "D9F886F5478CEFA253D00ED2940E4E4B")
    public ActivityInfo resolveActivityInfo(PackageManager pm, int flags) {
        addTaint(flags);
        addTaint(pm.getTaint());
        ActivityInfo ai = null;
        if(mComponent != null)        
        {
            try 
            {
                ai = pm.getActivityInfo(mComponent, flags);
            } //End block
            catch (PackageManager.NameNotFoundException e)
            {
            } //End block
        } //End block
        else
        {
            ResolveInfo info = pm.resolveActivity(
                this, PackageManager.MATCH_DEFAULT_ONLY | flags);
            if(info != null)            
            {
                ai = info.activityInfo;
            } //End block
        } //End block
ActivityInfo varF0D6783F85B950884EE206D023A357C0_1162764716 =         ai;
        varF0D6783F85B950884EE206D023A357C0_1162764716.addTaint(taint);
        return varF0D6783F85B950884EE206D023A357C0_1162764716;
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

    
    @DSModeled(DSC.SAFE)
	public Intent setAction(String action) {
		mAction = action;
        //mAction = action != null ? action.intern() : null;
        return this;
    }

    
    @DSModeled(DSC.SAFE)
	public Intent setData(Uri data) {
        mData = data;
		/*
        mType = null;
        */
        return this;
    }

    
    @DSModeled(DSC.SAFE)
	public Intent setType(String type) {
            mData=null;
            mType = type;
            return this;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.441 -0400", hash_original_method = "43AA0CE5E260B0FA5B26C9FC36ABF327", hash_generated_method = "00584B9FB3605C6799D9DC350D63DE8B")
    public Intent setDataAndType(Uri data, String type) {
        mData = data;
        mType = type;
Intent var72A74007B2BE62B849F475C7BDA4658B_1185276063 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1185276063.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1185276063;
        // ---------- Original Method ----------
        //mData = data;
        //mType = type;
        //return this;
    }

    
    @DSModeled(DSC.SAFE)
    public Intent addCategory(String category) {
		mCategories.addTaint(category.getTaint());
        if (mCategories == null) {
            mCategories = new HashSet<String>();
        }
        mCategories.add(category.intern());
        return this;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.442 -0400", hash_original_method = "CFCF8DDC5EB4FA9E7ADB1DEB9CFAFA89", hash_generated_method = "BC4AC277D768B1F7BE9D75FE5E9B97E3")
    public void removeCategory(String category) {
        addTaint(category.getTaint());
        if(mCategories != null)        
        {
            mCategories.remove(category);
            if(mCategories.size() == 0)            
            {
                mCategories = null;
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (mCategories != null) {
            //mCategories.remove(category);
            //if (mCategories.size() == 0) {
                //mCategories = null;
            //}
        //}
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.442 -0400", hash_original_method = "4143B41199E8262105CB671C15097E99", hash_generated_method = "287277779A434FB86F61699B992DAB08")
    public void setSelector(Intent selector) {
        if(selector == this)        
        {
            IllegalArgumentException varDB28EE105FC601F18A42EF13E45407D0_474748705 = new IllegalArgumentException(
                    "Intent being set as a selector of itself");
            varDB28EE105FC601F18A42EF13E45407D0_474748705.addTaint(taint);
            throw varDB28EE105FC601F18A42EF13E45407D0_474748705;
        } //End block
        if(selector != null && mPackage != null)        
        {
            IllegalArgumentException var8BA32FA43E547F20BF608AAF6B7199B5_1000380269 = new IllegalArgumentException(
                    "Can't set selector when package name is already set");
            var8BA32FA43E547F20BF608AAF6B7199B5_1000380269.addTaint(taint);
            throw var8BA32FA43E547F20BF608AAF6B7199B5_1000380269;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.443 -0400", hash_original_method = "E358DED697FF080F831811D5D578FEBC", hash_generated_method = "6FC14C6FCD606B26F0B5BB4AA37F7585")
    public Intent putExtra(String name, boolean value) {
        addTaint(value);
        addTaint(name.getTaint());
        if(mExtras == null)        
        {
            mExtras = new Bundle();
        } //End block
        mExtras.putBoolean(name, value);
Intent var72A74007B2BE62B849F475C7BDA4658B_1227486241 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1227486241.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1227486241;
        // ---------- Original Method ----------
        //if (mExtras == null) {
            //mExtras = new Bundle();
        //}
        //mExtras.putBoolean(name, value);
        //return this;
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.443 -0400", hash_original_method = "983951350B18B30CD357EFC4A5F8C533", hash_generated_method = "4A3437E124D37EF8591C07D5BBDCBFB4")
    public Intent putExtra(String name, byte value) {
        addTaint(value);
        addTaint(name.getTaint());
        if(mExtras == null)        
        {
            mExtras = new Bundle();
        } //End block
        mExtras.putByte(name, value);
Intent var72A74007B2BE62B849F475C7BDA4658B_1256530051 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1256530051.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1256530051;
        // ---------- Original Method ----------
        //if (mExtras == null) {
            //mExtras = new Bundle();
        //}
        //mExtras.putByte(name, value);
        //return this;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.444 -0400", hash_original_method = "44F743D0FCF3A3B09735F92996DFB8B8", hash_generated_method = "69589741CEBD20649F117A5BF2872734")
    public Intent putExtra(String name, char value) {
        addTaint(value);
        addTaint(name.getTaint());
        if(mExtras == null)        
        {
            mExtras = new Bundle();
        } //End block
        mExtras.putChar(name, value);
Intent var72A74007B2BE62B849F475C7BDA4658B_413710066 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_413710066.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_413710066;
        // ---------- Original Method ----------
        //if (mExtras == null) {
            //mExtras = new Bundle();
        //}
        //mExtras.putChar(name, value);
        //return this;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.444 -0400", hash_original_method = "D504428E6A64263CB337167E8E11D24B", hash_generated_method = "D941B61B7A1295FCEB4862AF92D1B4EF")
    public Intent putExtra(String name, short value) {
        addTaint(value);
        addTaint(name.getTaint());
        if(mExtras == null)        
        {
            mExtras = new Bundle();
        } //End block
        mExtras.putShort(name, value);
Intent var72A74007B2BE62B849F475C7BDA4658B_152699543 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_152699543.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_152699543;
        // ---------- Original Method ----------
        //if (mExtras == null) {
            //mExtras = new Bundle();
        //}
        //mExtras.putShort(name, value);
        //return this;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.444 -0400", hash_original_method = "0F8D3938F71F1CBC0AF93312AEF5DBAF", hash_generated_method = "4C022A6CF4C6C618F52A7FDC62182395")
    public Intent putExtra(String name, int value) {
        addTaint(value);
        addTaint(name.getTaint());
        if(mExtras == null)        
        {
            mExtras = new Bundle();
        } //End block
        mExtras.putInt(name, value);
Intent var72A74007B2BE62B849F475C7BDA4658B_1077840171 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1077840171.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1077840171;
        // ---------- Original Method ----------
        //if (mExtras == null) {
            //mExtras = new Bundle();
        //}
        //mExtras.putInt(name, value);
        //return this;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.445 -0400", hash_original_method = "210CE6920B09DE82954A1910A2E05BDA", hash_generated_method = "4285F022E8E9F8D9DA136DF915049C83")
    public Intent putExtra(String name, long value) {
        addTaint(value);
        addTaint(name.getTaint());
        if(mExtras == null)        
        {
            mExtras = new Bundle();
        } //End block
        mExtras.putLong(name, value);
Intent var72A74007B2BE62B849F475C7BDA4658B_1048094860 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1048094860.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1048094860;
        // ---------- Original Method ----------
        //if (mExtras == null) {
            //mExtras = new Bundle();
        //}
        //mExtras.putLong(name, value);
        //return this;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.445 -0400", hash_original_method = "5563D3D5FF8C4FA36F1584B48F1347B6", hash_generated_method = "D04BCA6DD36164E2BA0B4774997517DD")
    public Intent putExtra(String name, float value) {
        addTaint(value);
        addTaint(name.getTaint());
        if(mExtras == null)        
        {
            mExtras = new Bundle();
        } //End block
        mExtras.putFloat(name, value);
Intent var72A74007B2BE62B849F475C7BDA4658B_1119814417 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1119814417.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1119814417;
        // ---------- Original Method ----------
        //if (mExtras == null) {
            //mExtras = new Bundle();
        //}
        //mExtras.putFloat(name, value);
        //return this;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.446 -0400", hash_original_method = "FDAB0726590DA4887C7F048C162A9588", hash_generated_method = "9E49136917A924F81088344FD6BD618C")
    public Intent putExtra(String name, double value) {
        addTaint(value);
        addTaint(name.getTaint());
        if(mExtras == null)        
        {
            mExtras = new Bundle();
        } //End block
        mExtras.putDouble(name, value);
Intent var72A74007B2BE62B849F475C7BDA4658B_1384200937 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1384200937.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1384200937;
        // ---------- Original Method ----------
        //if (mExtras == null) {
            //mExtras = new Bundle();
        //}
        //mExtras.putDouble(name, value);
        //return this;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.446 -0400", hash_original_method = "FFA94FE476B4FC82FDFAB8191F06F76A", hash_generated_method = "A649C71C47E1D111D77B2DC066E74861")
    public Intent putExtra(String name, String value) {
        addTaint(value.getTaint());
        addTaint(name.getTaint());
        if(mExtras == null)        
        {
            mExtras = new Bundle();
        } //End block
        mExtras.putString(name, value);
Intent var72A74007B2BE62B849F475C7BDA4658B_126867015 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_126867015.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_126867015;
        // ---------- Original Method ----------
        //if (mExtras == null) {
            //mExtras = new Bundle();
        //}
        //mExtras.putString(name, value);
        //return this;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.446 -0400", hash_original_method = "C3AAC0183A1B956AD55E80A8556AFB71", hash_generated_method = "00F0170695A00B5D7C5F7E8C3AE2FF15")
    public Intent putExtra(String name, CharSequence value) {
        addTaint(value.getTaint());
        addTaint(name.getTaint());
        if(mExtras == null)        
        {
            mExtras = new Bundle();
        } //End block
        mExtras.putCharSequence(name, value);
Intent var72A74007B2BE62B849F475C7BDA4658B_1986935926 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1986935926.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1986935926;
        // ---------- Original Method ----------
        //if (mExtras == null) {
            //mExtras = new Bundle();
        //}
        //mExtras.putCharSequence(name, value);
        //return this;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.447 -0400", hash_original_method = "49EBB52F87B2F24E715C34795BBE3213", hash_generated_method = "1F6E9936318D9CD9BE0A99956FA962E6")
    public Intent putExtra(String name, Parcelable value) {
        addTaint(value.getTaint());
        addTaint(name.getTaint());
        if(mExtras == null)        
        {
            mExtras = new Bundle();
        } //End block
        mExtras.putParcelable(name, value);
Intent var72A74007B2BE62B849F475C7BDA4658B_807998465 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_807998465.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_807998465;
        // ---------- Original Method ----------
        //if (mExtras == null) {
            //mExtras = new Bundle();
        //}
        //mExtras.putParcelable(name, value);
        //return this;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.447 -0400", hash_original_method = "478D5F3649CF3C1019BEE6D895BDE15B", hash_generated_method = "E752A0D5F358F65F5512D9C2D45525DA")
    public Intent putExtra(String name, Parcelable[] value) {
        addTaint(value[0].getTaint());
        addTaint(name.getTaint());
        if(mExtras == null)        
        {
            mExtras = new Bundle();
        } //End block
        mExtras.putParcelableArray(name, value);
Intent var72A74007B2BE62B849F475C7BDA4658B_1460830537 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1460830537.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1460830537;
        // ---------- Original Method ----------
        //if (mExtras == null) {
            //mExtras = new Bundle();
        //}
        //mExtras.putParcelableArray(name, value);
        //return this;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.448 -0400", hash_original_method = "7056A89E2AB58239EE1F715B825304C9", hash_generated_method = "5AF8E4AD7F68D35C58F2F135BE430B73")
    public Intent putParcelableArrayListExtra(String name, ArrayList<? extends Parcelable> value) {
        addTaint(value.getTaint());
        addTaint(name.getTaint());
        if(mExtras == null)        
        {
            mExtras = new Bundle();
        } //End block
        mExtras.putParcelableArrayList(name, value);
Intent var72A74007B2BE62B849F475C7BDA4658B_475675296 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_475675296.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_475675296;
        // ---------- Original Method ----------
        //if (mExtras == null) {
            //mExtras = new Bundle();
        //}
        //mExtras.putParcelableArrayList(name, value);
        //return this;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.448 -0400", hash_original_method = "25611C5EA858F4B01007B3F78DCCE949", hash_generated_method = "3C01FEDB1113A57C8ADD7A46FEF50677")
    public Intent putIntegerArrayListExtra(String name, ArrayList<Integer> value) {
        addTaint(value.getTaint());
        addTaint(name.getTaint());
        if(mExtras == null)        
        {
            mExtras = new Bundle();
        } //End block
        mExtras.putIntegerArrayList(name, value);
Intent var72A74007B2BE62B849F475C7BDA4658B_1083956749 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1083956749.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1083956749;
        // ---------- Original Method ----------
        //if (mExtras == null) {
            //mExtras = new Bundle();
        //}
        //mExtras.putIntegerArrayList(name, value);
        //return this;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.449 -0400", hash_original_method = "FCCCC0193355017A3AB410227E2B8C63", hash_generated_method = "B380C150D689F214126199658D75EC95")
    public Intent putStringArrayListExtra(String name, ArrayList<String> value) {
        addTaint(value.getTaint());
        addTaint(name.getTaint());
        if(mExtras == null)        
        {
            mExtras = new Bundle();
        } //End block
        mExtras.putStringArrayList(name, value);
Intent var72A74007B2BE62B849F475C7BDA4658B_455769210 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_455769210.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_455769210;
        // ---------- Original Method ----------
        //if (mExtras == null) {
            //mExtras = new Bundle();
        //}
        //mExtras.putStringArrayList(name, value);
        //return this;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.449 -0400", hash_original_method = "56169BFB83B473D5686B58CC3B07DAC6", hash_generated_method = "73DFC315AF8450D1B4BC5084FE635C66")
    public Intent putCharSequenceArrayListExtra(String name, ArrayList<CharSequence> value) {
        addTaint(value.getTaint());
        addTaint(name.getTaint());
        if(mExtras == null)        
        {
            mExtras = new Bundle();
        } //End block
        mExtras.putCharSequenceArrayList(name, value);
Intent var72A74007B2BE62B849F475C7BDA4658B_1110251516 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1110251516.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1110251516;
        // ---------- Original Method ----------
        //if (mExtras == null) {
            //mExtras = new Bundle();
        //}
        //mExtras.putCharSequenceArrayList(name, value);
        //return this;
    }

    
    @DSModeled(DSC.SAFE)
	public Intent putExtra(String name, Serializable value) {
        mExtras = new Bundle();
        mExtras.putSerializable(name, value);
        return this;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.450 -0400", hash_original_method = "6C30326EEBD8635124BFC9218A6B6422", hash_generated_method = "34021BDB90C6ABEA81980D3EBCDAA27D")
    public Intent putExtra(String name, boolean[] value) {
        addTaint(value[0]);
        addTaint(name.getTaint());
        if(mExtras == null)        
        {
            mExtras = new Bundle();
        } //End block
        mExtras.putBooleanArray(name, value);
Intent var72A74007B2BE62B849F475C7BDA4658B_2035607540 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_2035607540.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_2035607540;
        // ---------- Original Method ----------
        //if (mExtras == null) {
            //mExtras = new Bundle();
        //}
        //mExtras.putBooleanArray(name, value);
        //return this;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.450 -0400", hash_original_method = "4D4788E50F7779B1D72BD45B4E76C775", hash_generated_method = "CF3C2265123AB4C4D7A27E2F63957EBD")
    public Intent putExtra(String name, byte[] value) {
        addTaint(value[0]);
        addTaint(name.getTaint());
        if(mExtras == null)        
        {
            mExtras = new Bundle();
        } //End block
        mExtras.putByteArray(name, value);
Intent var72A74007B2BE62B849F475C7BDA4658B_168825478 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_168825478.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_168825478;
        // ---------- Original Method ----------
        //if (mExtras == null) {
            //mExtras = new Bundle();
        //}
        //mExtras.putByteArray(name, value);
        //return this;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.451 -0400", hash_original_method = "521E65BC95668B6A66CE17103975D2B1", hash_generated_method = "4D8650C4823415F6820D650EA2E27271")
    public Intent putExtra(String name, short[] value) {
        addTaint(value[0]);
        addTaint(name.getTaint());
        if(mExtras == null)        
        {
            mExtras = new Bundle();
        } //End block
        mExtras.putShortArray(name, value);
Intent var72A74007B2BE62B849F475C7BDA4658B_128942859 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_128942859.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_128942859;
        // ---------- Original Method ----------
        //if (mExtras == null) {
            //mExtras = new Bundle();
        //}
        //mExtras.putShortArray(name, value);
        //return this;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.451 -0400", hash_original_method = "CEC6E945D8554F36BF71D2D38B61B7EF", hash_generated_method = "69A13F007306E7ECE5EBEF1329783FFE")
    public Intent putExtra(String name, char[] value) {
        addTaint(value[0]);
        addTaint(name.getTaint());
        if(mExtras == null)        
        {
            mExtras = new Bundle();
        } //End block
        mExtras.putCharArray(name, value);
Intent var72A74007B2BE62B849F475C7BDA4658B_1719850547 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1719850547.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1719850547;
        // ---------- Original Method ----------
        //if (mExtras == null) {
            //mExtras = new Bundle();
        //}
        //mExtras.putCharArray(name, value);
        //return this;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.452 -0400", hash_original_method = "AD8C8F2DD7A3862E32E54CE0FBFF67CE", hash_generated_method = "8DDE611CCD37F544A604270DBDC1A5D5")
    public Intent putExtra(String name, int[] value) {
        addTaint(value[0]);
        addTaint(name.getTaint());
        if(mExtras == null)        
        {
            mExtras = new Bundle();
        } //End block
        mExtras.putIntArray(name, value);
Intent var72A74007B2BE62B849F475C7BDA4658B_1472774377 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1472774377.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1472774377;
        // ---------- Original Method ----------
        //if (mExtras == null) {
            //mExtras = new Bundle();
        //}
        //mExtras.putIntArray(name, value);
        //return this;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.452 -0400", hash_original_method = "EEA209751D515DE89BAC56042276C483", hash_generated_method = "B1A592EF39456AEFAF186CE737D2A5F3")
    public Intent putExtra(String name, long[] value) {
        addTaint(value[0]);
        addTaint(name.getTaint());
        if(mExtras == null)        
        {
            mExtras = new Bundle();
        } //End block
        mExtras.putLongArray(name, value);
Intent var72A74007B2BE62B849F475C7BDA4658B_298183493 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_298183493.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_298183493;
        // ---------- Original Method ----------
        //if (mExtras == null) {
            //mExtras = new Bundle();
        //}
        //mExtras.putLongArray(name, value);
        //return this;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.452 -0400", hash_original_method = "F6CA728A57FEA4C77AF7294872C7D495", hash_generated_method = "840ABC0F4973AF6B794DC5896D94E8A9")
    public Intent putExtra(String name, float[] value) {
        addTaint(value[0]);
        addTaint(name.getTaint());
        if(mExtras == null)        
        {
            mExtras = new Bundle();
        } //End block
        mExtras.putFloatArray(name, value);
Intent var72A74007B2BE62B849F475C7BDA4658B_1577540344 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1577540344.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1577540344;
        // ---------- Original Method ----------
        //if (mExtras == null) {
            //mExtras = new Bundle();
        //}
        //mExtras.putFloatArray(name, value);
        //return this;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.453 -0400", hash_original_method = "3F155E9B232579FD3DCD2D3FAECEA79F", hash_generated_method = "E5C5720087B60FBF306A597010B3DE03")
    public Intent putExtra(String name, double[] value) {
        addTaint(value[0]);
        addTaint(name.getTaint());
        if(mExtras == null)        
        {
            mExtras = new Bundle();
        } //End block
        mExtras.putDoubleArray(name, value);
Intent var72A74007B2BE62B849F475C7BDA4658B_15332485 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_15332485.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_15332485;
        // ---------- Original Method ----------
        //if (mExtras == null) {
            //mExtras = new Bundle();
        //}
        //mExtras.putDoubleArray(name, value);
        //return this;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.453 -0400", hash_original_method = "4105C6229BFDC8C2B450D57FAD8A78CA", hash_generated_method = "317983737F6F8663246313C7B9759AD6")
    public Intent putExtra(String name, String[] value) {
        addTaint(value[0].getTaint());
        addTaint(name.getTaint());
        if(mExtras == null)        
        {
            mExtras = new Bundle();
        } //End block
        mExtras.putStringArray(name, value);
Intent var72A74007B2BE62B849F475C7BDA4658B_1987266773 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1987266773.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1987266773;
        // ---------- Original Method ----------
        //if (mExtras == null) {
            //mExtras = new Bundle();
        //}
        //mExtras.putStringArray(name, value);
        //return this;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.454 -0400", hash_original_method = "5B5979B9E2BB6EA8D0974FC96788F02A", hash_generated_method = "6AB4E6E2B83C7B565E2AF46572D156DB")
    public Intent putExtra(String name, CharSequence[] value) {
        addTaint(value[0].getTaint());
        addTaint(name.getTaint());
        if(mExtras == null)        
        {
            mExtras = new Bundle();
        } //End block
        mExtras.putCharSequenceArray(name, value);
Intent var72A74007B2BE62B849F475C7BDA4658B_163261742 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_163261742.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_163261742;
        // ---------- Original Method ----------
        //if (mExtras == null) {
            //mExtras = new Bundle();
        //}
        //mExtras.putCharSequenceArray(name, value);
        //return this;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.454 -0400", hash_original_method = "79076492A33BAA4B69A022CE305E32E8", hash_generated_method = "84BD74731F8AEB2E502522473E695B13")
    public Intent putExtra(String name, Bundle value) {
        addTaint(value.getTaint());
        addTaint(name.getTaint());
        if(mExtras == null)        
        {
            mExtras = new Bundle();
        } //End block
        mExtras.putBundle(name, value);
Intent var72A74007B2BE62B849F475C7BDA4658B_1040586575 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1040586575.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1040586575;
        // ---------- Original Method ----------
        //if (mExtras == null) {
            //mExtras = new Bundle();
        //}
        //mExtras.putBundle(name, value);
        //return this;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.454 -0400", hash_original_method = "1AE089536D0C6059F1731DCA673BC867", hash_generated_method = "A4F8B860B228D099BAF055237F9E7EA6")
    @Deprecated
    public Intent putExtra(String name, IBinder value) {
        addTaint(value.getTaint());
        addTaint(name.getTaint());
        if(mExtras == null)        
        {
            mExtras = new Bundle();
        } //End block
        mExtras.putIBinder(name, value);
Intent var72A74007B2BE62B849F475C7BDA4658B_1577964867 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1577964867.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1577964867;
        // ---------- Original Method ----------
        //if (mExtras == null) {
            //mExtras = new Bundle();
        //}
        //mExtras.putIBinder(name, value);
        //return this;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.455 -0400", hash_original_method = "49B5D5019DC4C58D3432134ADBF206CE", hash_generated_method = "681A3B1100A64E053B41FED99B0BF7F0")
    public Intent putExtras(Intent src) {
        if(src.mExtras != null)        
        {
            if(mExtras == null)            
            {
                mExtras = new Bundle(src.mExtras);
            } //End block
            else
            {
                mExtras.putAll(src.mExtras);
            } //End block
        } //End block
Intent var72A74007B2BE62B849F475C7BDA4658B_1830521493 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1830521493.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1830521493;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.455 -0400", hash_original_method = "300503D60C48D249178D35D7CDB92339", hash_generated_method = "DCC1E9168F1252D683D1F3858C61F395")
    public Intent putExtras(Bundle extras) {
        addTaint(extras.getTaint());
        if(mExtras == null)        
        {
            mExtras = new Bundle();
        } //End block
        mExtras.putAll(extras);
Intent var72A74007B2BE62B849F475C7BDA4658B_100255988 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_100255988.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_100255988;
        // ---------- Original Method ----------
        //if (mExtras == null) {
            //mExtras = new Bundle();
        //}
        //mExtras.putAll(extras);
        //return this;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.456 -0400", hash_original_method = "9273ED8AEDE591E5D2100B41909C8A11", hash_generated_method = "9F66296C57C2DB71D2BD91C69732475F")
    public Intent replaceExtras(Intent src) {
        mExtras = src.mExtras != null ? new Bundle(src.mExtras) : null;
Intent var72A74007B2BE62B849F475C7BDA4658B_42681688 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_42681688.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_42681688;
        // ---------- Original Method ----------
        //mExtras = src.mExtras != null ? new Bundle(src.mExtras) : null;
        //return this;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.456 -0400", hash_original_method = "CBF42E478CC456FFD10D6777F319F0BD", hash_generated_method = "0DABD8B324DDA852F73469340DA42640")
    public Intent replaceExtras(Bundle extras) {
        mExtras = extras != null ? new Bundle(extras) : null;
Intent var72A74007B2BE62B849F475C7BDA4658B_1839274427 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1839274427.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1839274427;
        // ---------- Original Method ----------
        //mExtras = extras != null ? new Bundle(extras) : null;
        //return this;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.456 -0400", hash_original_method = "84A47E40481CBF5586A9CCDD8AD7D655", hash_generated_method = "EA4AC43663DFD598B636025DE45F20E3")
    public void removeExtra(String name) {
        addTaint(name.getTaint());
        if(mExtras != null)        
        {
            mExtras.remove(name);
            if(mExtras.size() == 0)            
            {
                mExtras = null;
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (mExtras != null) {
            //mExtras.remove(name);
            //if (mExtras.size() == 0) {
                //mExtras = null;
            //}
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.457 -0400", hash_original_method = "240F6D2BBC198957F28DF199FF71FA51", hash_generated_method = "323448496A1EB64B6B509F0F11F239D5")
    public Intent setFlags(int flags) {
        mFlags = flags;
Intent var72A74007B2BE62B849F475C7BDA4658B_238535034 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_238535034.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_238535034;
        // ---------- Original Method ----------
        //mFlags = flags;
        //return this;
    }

    
    @DSModeled(DSC.SAFE)
	public Intent addFlags(int flags) {
        addTaint(flags);
        return this;
    }

    
    @DSModeled(DSC.SAFE)
	public Intent setPackage(String packageName) {
        if (packageName != null && mSelector != null) {
            throw new IllegalArgumentException(
                    "Can't set package name when selector is already set");
        }
        mPackage = packageName;
        return this;
    }

    
    @DSModeled(DSC.SAFE)
	public Intent setComponent(ComponentName component) {
        mComponent = component;
        return this;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.458 -0400", hash_original_method = "A7E573A4994CE22857A73F3E6FF16052", hash_generated_method = "C98CA911AF4638EF31A76CD5F5B6B418")
    public Intent setClassName(Context packageContext, String className) {
        mComponent = new ComponentName(packageContext, className);
Intent var72A74007B2BE62B849F475C7BDA4658B_607451133 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_607451133.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_607451133;
        // ---------- Original Method ----------
        //mComponent = new ComponentName(packageContext, className);
        //return this;
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.458 -0400", hash_original_method = "0DAD204BCD083F4BEBCC949C19CA4443", hash_generated_method = "5CEF145A6CCA0AADAE7E7BECBD589C6D")
    public Intent setClassName(String packageName, String className) {
        mComponent = new ComponentName(packageName, className);
Intent var72A74007B2BE62B849F475C7BDA4658B_1442856412 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1442856412.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1442856412;
        // ---------- Original Method ----------
        //mComponent = new ComponentName(packageName, className);
        //return this;
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.459 -0400", hash_original_method = "07D0BC1863460C70C46D0D4DB8E842CD", hash_generated_method = "7F6ACB39663195BC97A4BC6A90961AAC")
    public Intent setClass(Context packageContext, Class<?> cls) {
        mComponent = new ComponentName(packageContext, cls);
Intent var72A74007B2BE62B849F475C7BDA4658B_1106282301 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1106282301.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1106282301;
        // ---------- Original Method ----------
        //mComponent = new ComponentName(packageContext, cls);
        //return this;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.459 -0400", hash_original_method = "2A55D148D28C14A8FD18A3C56EB5208F", hash_generated_method = "3F18A382DDCF87C6C3FA225584DD8F71")
    public void setSourceBounds(Rect r) {
        if(r != null)        
        {
            mSourceBounds = new Rect(r);
        } //End block
        else
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

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.461 -0400", hash_original_method = "E5580C6082A47C0EDDA03A45ABBBF7D7", hash_generated_method = "4B8FA51A496FF6E4B5BA8D2EE3D46DB1")
    public int fillIn(Intent other, int flags) {
        addTaint(flags);
        int changes = 0;
        if(other.mAction != null
                && (mAction == null || (flags&FILL_IN_ACTION) != 0))        
        {
            mAction = other.mAction;
            changes |= FILL_IN_ACTION;
        } //End block
        if((other.mData != null || other.mType != null)
                && ((mData == null && mType == null)
                        || (flags&FILL_IN_DATA) != 0))        
        {
            mData = other.mData;
            mType = other.mType;
            changes |= FILL_IN_DATA;
        } //End block
        if(other.mCategories != null
                && (mCategories == null || (flags&FILL_IN_CATEGORIES) != 0))        
        {
            if(other.mCategories != null)            
            {
                mCategories = new HashSet<String>(other.mCategories);
            } //End block
            changes |= FILL_IN_CATEGORIES;
        } //End block
        if(other.mPackage != null
                && (mPackage == null || (flags&FILL_IN_PACKAGE) != 0))        
        {
            if(mSelector == null)            
            {
                mPackage = other.mPackage;
                changes |= FILL_IN_PACKAGE;
            } //End block
        } //End block
        if(other.mSelector != null && (flags&FILL_IN_SELECTOR) != 0)        
        {
            if(mPackage == null)            
            {
                mSelector = new Intent(other.mSelector);
                mPackage = null;
                changes |= FILL_IN_SELECTOR;
            } //End block
        } //End block
        if(other.mComponent != null && (flags&FILL_IN_COMPONENT) != 0)        
        {
            mComponent = other.mComponent;
            changes |= FILL_IN_COMPONENT;
        } //End block
        mFlags |= other.mFlags;
        if(other.mSourceBounds != null
                && (mSourceBounds == null || (flags&FILL_IN_SOURCE_BOUNDS) != 0))        
        {
            mSourceBounds = new Rect(other.mSourceBounds);
            changes |= FILL_IN_SOURCE_BOUNDS;
        } //End block
        if(mExtras == null)        
        {
            if(other.mExtras != null)            
            {
                mExtras = new Bundle(other.mExtras);
            } //End block
        } //End block
        else
        if(other.mExtras != null)        
        {
            try 
            {
                Bundle newb = new Bundle(other.mExtras);
                newb.putAll(mExtras);
                mExtras = newb;
            } //End block
            catch (RuntimeException e)
            {
            } //End block
        } //End block
        int var5A9D18BB87FF12835DC844883C5C3EBE_924264061 = (changes);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1803655200 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1803655200;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.462 -0400", hash_original_method = "B6E4053A3570119C1E3D361525D403A8", hash_generated_method = "C8D6E623D6274E5B094908B5C049F5B2")
    public boolean filterEquals(Intent other) {
        addTaint(other.getTaint());
        if(other == null)        
        {
            boolean var68934A3E9455FA72420237EB05902327_1790736717 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1833066724 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1833066724;
        } //End block
        if(mAction != other.mAction)        
        {
            if(mAction != null)            
            {
                if(!mAction.equals(other.mAction))                
                {
                    boolean var68934A3E9455FA72420237EB05902327_582901807 = (false);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1832143596 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_1832143596;
                } //End block
            } //End block
            else
            {
                if(!other.mAction.equals(mAction))                
                {
                    boolean var68934A3E9455FA72420237EB05902327_1934727722 = (false);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2085815512 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_2085815512;
                } //End block
            } //End block
        } //End block
        if(mData != other.mData)        
        {
            if(mData != null)            
            {
                if(!mData.equals(other.mData))                
                {
                    boolean var68934A3E9455FA72420237EB05902327_142414271 = (false);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2011417306 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_2011417306;
                } //End block
            } //End block
            else
            {
                if(!other.mData.equals(mData))                
                {
                    boolean var68934A3E9455FA72420237EB05902327_783690542 = (false);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_588687685 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_588687685;
                } //End block
            } //End block
        } //End block
        if(mType != other.mType)        
        {
            if(mType != null)            
            {
                if(!mType.equals(other.mType))                
                {
                    boolean var68934A3E9455FA72420237EB05902327_1145982851 = (false);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_192951307 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_192951307;
                } //End block
            } //End block
            else
            {
                if(!other.mType.equals(mType))                
                {
                    boolean var68934A3E9455FA72420237EB05902327_1365205665 = (false);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_586663098 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_586663098;
                } //End block
            } //End block
        } //End block
        if(mPackage != other.mPackage)        
        {
            if(mPackage != null)            
            {
                if(!mPackage.equals(other.mPackage))                
                {
                    boolean var68934A3E9455FA72420237EB05902327_124201562 = (false);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1165733371 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_1165733371;
                } //End block
            } //End block
            else
            {
                if(!other.mPackage.equals(mPackage))                
                {
                    boolean var68934A3E9455FA72420237EB05902327_682842912 = (false);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1616439131 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_1616439131;
                } //End block
            } //End block
        } //End block
        if(mComponent != other.mComponent)        
        {
            if(mComponent != null)            
            {
                if(!mComponent.equals(other.mComponent))                
                {
                    boolean var68934A3E9455FA72420237EB05902327_1766733685 = (false);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1477741934 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_1477741934;
                } //End block
            } //End block
            else
            {
                if(!other.mComponent.equals(mComponent))                
                {
                    boolean var68934A3E9455FA72420237EB05902327_1774808094 = (false);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1170229236 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_1170229236;
                } //End block
            } //End block
        } //End block
        if(mCategories != other.mCategories)        
        {
            if(mCategories != null)            
            {
                if(!mCategories.equals(other.mCategories))                
                {
                    boolean var68934A3E9455FA72420237EB05902327_1893746922 = (false);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_587230228 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_587230228;
                } //End block
            } //End block
            else
            {
                if(!other.mCategories.equals(mCategories))                
                {
                    boolean var68934A3E9455FA72420237EB05902327_1959984362 = (false);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2104148020 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_2104148020;
                } //End block
            } //End block
        } //End block
        boolean varB326B5062B2F0E69046810717534CB09_976003831 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1212680784 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1212680784;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.463 -0400", hash_original_method = "8096117DA4698C90A65D3667512D1D4C", hash_generated_method = "D506D0D0B53B35A630A8B69FE659274D")
    public int filterHashCode() {
        int code = 0;
        if(mAction != null)        
        {
            code += mAction.hashCode();
        } //End block
        if(mData != null)        
        {
            code += mData.hashCode();
        } //End block
        if(mType != null)        
        {
            code += mType.hashCode();
        } //End block
        if(mPackage != null)        
        {
            code += mPackage.hashCode();
        } //End block
        if(mComponent != null)        
        {
            code += mComponent.hashCode();
        } //End block
        if(mCategories != null)        
        {
            code += mCategories.hashCode();
        } //End block
        int varC13367945D5D4C91047B3B50234AA7AB_178773663 = (code);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_273806603 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_273806603;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.463 -0400", hash_original_method = "A07DFF04DF4B6FC888385D304C4BCF4A", hash_generated_method = "DF76F249C82FE03750DDE89F019EA1E5")
    @Override
    public String toString() {
        StringBuilder b = new StringBuilder(128);
        b.append("Intent { ");
        toShortString(b, true, true, true);
        b.append(" }");
String var53F188277CD163A95D3D9B5184E22806_1360283114 =         b.toString();
        var53F188277CD163A95D3D9B5184E22806_1360283114.addTaint(taint);
        return var53F188277CD163A95D3D9B5184E22806_1360283114;
        // ---------- Original Method ----------
        //StringBuilder b = new StringBuilder(128);
        //b.append("Intent { ");
        //toShortString(b, true, true, true);
        //b.append(" }");
        //return b.toString();
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.463 -0400", hash_original_method = "561478671997B5BD9B57800B6A20BE68", hash_generated_method = "BCFD6644F00C65263A5448EE887F46F7")
    public String toInsecureString() {
        StringBuilder b = new StringBuilder(128);
        b.append("Intent { ");
        toShortString(b, false, true, true);
        b.append(" }");
String var53F188277CD163A95D3D9B5184E22806_138543153 =         b.toString();
        var53F188277CD163A95D3D9B5184E22806_138543153.addTaint(taint);
        return var53F188277CD163A95D3D9B5184E22806_138543153;
        // ---------- Original Method ----------
        //StringBuilder b = new StringBuilder(128);
        //b.append("Intent { ");
        //toShortString(b, false, true, true);
        //b.append(" }");
        //return b.toString();
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.464 -0400", hash_original_method = "78E0A44749B0E137B37BE3EA0840E73D", hash_generated_method = "568003F378ED0283AED99FFF55E7917F")
    public String toShortString(boolean secure, boolean comp, boolean extras) {
        addTaint(extras);
        addTaint(comp);
        addTaint(secure);
        StringBuilder b = new StringBuilder(128);
        toShortString(b, secure, comp, extras);
String var53F188277CD163A95D3D9B5184E22806_55822107 =         b.toString();
        var53F188277CD163A95D3D9B5184E22806_55822107.addTaint(taint);
        return var53F188277CD163A95D3D9B5184E22806_55822107;
        // ---------- Original Method ----------
        //StringBuilder b = new StringBuilder(128);
        //toShortString(b, secure, comp, extras);
        //return b.toString();
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.465 -0400", hash_original_method = "084143D5D45481DE69737429FAF260F9", hash_generated_method = "5EE51709F59EF6FCA1D03333D8DB10AE")
    public void toShortString(StringBuilder b, boolean secure, boolean comp, boolean extras) {
        addTaint(extras);
        addTaint(comp);
        addTaint(secure);
        addTaint(b.getTaint());
        boolean first = true;
        if(mAction != null)        
        {
            b.append("act=").append(mAction);
            first = false;
        } //End block
        if(mCategories != null)        
        {
            if(!first)            
            {
                b.append(' ');
            } //End block
            first = false;
            b.append("cat=[");
            Iterator<String> i = mCategories.iterator();
            boolean didone = false;
            while
(i.hasNext())            
            {
                if(didone)                
                b.append(",");
                didone = true;
                b.append(i.next());
            } //End block
            b.append("]");
        } //End block
        if(mData != null)        
        {
            if(!first)            
            {
                b.append(' ');
            } //End block
            first = false;
            b.append("dat=");
            if(secure)            
            {
                b.append(mData.toSafeString());
            } //End block
            else
            {
                b.append(mData);
            } //End block
        } //End block
        if(mType != null)        
        {
            if(!first)            
            {
                b.append(' ');
            } //End block
            first = false;
            b.append("typ=").append(mType);
        } //End block
        if(mFlags != 0)        
        {
            if(!first)            
            {
                b.append(' ');
            } //End block
            first = false;
            b.append("flg=0x").append(Integer.toHexString(mFlags));
        } //End block
        if(mPackage != null)        
        {
            if(!first)            
            {
                b.append(' ');
            } //End block
            first = false;
            b.append("pkg=").append(mPackage);
        } //End block
        if(comp && mComponent != null)        
        {
            if(!first)            
            {
                b.append(' ');
            } //End block
            first = false;
            b.append("cmp=").append(mComponent.flattenToShortString());
        } //End block
        if(mSourceBounds != null)        
        {
            if(!first)            
            {
                b.append(' ');
            } //End block
            first = false;
            b.append("bnds=").append(mSourceBounds.toShortString());
        } //End block
        if(extras && mExtras != null)        
        {
            if(!first)            
            {
                b.append(' ');
            } //End block
            first = false;
            b.append("(has extras)");
        } //End block
        if(mSelector != null)        
        {
            b.append(" sel={");
            mSelector.toShortString(b, secure, comp, extras);
            b.append("}");
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.466 -0400", hash_original_method = "A1DA43CBB31EA268C3AC25819B92FFB9", hash_generated_method = "8A2418727667880CCCE7E3F59A42357A")
    @Deprecated
    public String toURI() {
String varBA1F7DA38A021A8435A2A26C7A311AE1_2119998145 =         toUri(0);
        varBA1F7DA38A021A8435A2A26C7A311AE1_2119998145.addTaint(taint);
        return varBA1F7DA38A021A8435A2A26C7A311AE1_2119998145;
        // ---------- Original Method ----------
        //return toUri(0);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.467 -0400", hash_original_method = "E005DA59F987D9130CC4868A94C4C496", hash_generated_method = "B299238AEC97FDCF268D8936CB2FF5C3")
    public String toUri(int flags) {
        addTaint(flags);
        StringBuilder uri = new StringBuilder(128);
        String scheme = null;
        if(mData != null)        
        {
            String data = mData.toString();
            if((flags&URI_INTENT_SCHEME) != 0)            
            {
                final int N = data.length();
for(int i=0;i<N;i++)
                {
                    char c = data.charAt(i);
                    if((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')
                            || c == '.' || c == '-')                    
                    {
                        continue;
                    } //End block
                    if(c == ':' && i > 0)                    
                    {
                        scheme = data.substring(0, i);
                        uri.append("intent:");
                        data = data.substring(i+1);
                        break;
                    } //End block
                    break;
                } //End block
            } //End block
            uri.append(data);
        } //End block
        else
        if((flags&URI_INTENT_SCHEME) != 0)        
        {
            uri.append("intent:");
        } //End block
        uri.append("#Intent;");
        toUriInner(uri, scheme, flags);
        if(mSelector != null)        
        {
            uri.append("SEL;");
            mSelector.toUriInner(uri, null, flags);
        } //End block
        uri.append("end");
String var7FF56EDDB8787D5A26612B0D44A02159_351815108 =         uri.toString();
        var7FF56EDDB8787D5A26612B0D44A02159_351815108.addTaint(taint);
        return var7FF56EDDB8787D5A26612B0D44A02159_351815108;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.468 -0400", hash_original_method = "C6B01852F6499829AE05E1CED618D6B2", hash_generated_method = "6B94F1297C26B0635A37BA19CBEFA674")
    private void toUriInner(StringBuilder uri, String scheme, int flags) {
        addTaint(flags);
        addTaint(scheme.getTaint());
        addTaint(uri.getTaint());
        if(scheme != null)        
        {
            uri.append("scheme=").append(scheme).append(';');
        } //End block
        if(mAction != null)        
        {
            uri.append("action=").append(Uri.encode(mAction)).append(';');
        } //End block
        if(mCategories != null)        
        {
for(String category : mCategories)
            {
                uri.append("category=").append(Uri.encode(category)).append(';');
            } //End block
        } //End block
        if(mType != null)        
        {
            uri.append("type=").append(Uri.encode(mType, "/")).append(';');
        } //End block
        if(mFlags != 0)        
        {
            uri.append("launchFlags=0x").append(Integer.toHexString(mFlags)).append(';');
        } //End block
        if(mPackage != null)        
        {
            uri.append("package=").append(Uri.encode(mPackage)).append(';');
        } //End block
        if(mComponent != null)        
        {
            uri.append("component=").append(Uri.encode(
                    mComponent.flattenToShortString(), "/")).append(';');
        } //End block
        if(mSourceBounds != null)        
        {
            uri.append("sourceBounds=")
                    .append(Uri.encode(mSourceBounds.flattenToString()))
                    .append(';');
        } //End block
        if(mExtras != null)        
        {
for(String key : mExtras.keySet())
            {
                final Object value = mExtras.get(key);
                char entryType = value instanceof String    ? 'S' :
                        value instanceof Boolean   ? 'B' :
                        value instanceof Byte      ? 'b' :
                        value instanceof Character ? 'c' :
                        value instanceof Double    ? 'd' :
                        value instanceof Float     ? 'f' :
                        value instanceof Integer   ? 'i' :
                        value instanceof Long      ? 'l' :
                        value instanceof Short     ? 's' :
                        '\0';
                if(entryType != '\0')                
                {
                    uri.append(entryType);
                    uri.append('.');
                    uri.append(Uri.encode(key));
                    uri.append('=');
                    uri.append(Uri.encode(value.toString()));
                    uri.append(';');
                } //End block
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.470 -0400", hash_original_method = "D9DA92F04D8A96D9F8D7CC23CBDB1396", hash_generated_method = "0C9E5D2AFA8DAE2F67B9F20BD0DE9E05")
    public void writeToParcel(Parcel out, int flags) {
        addTaint(flags);
        addTaint(out.getTaint());
        out.writeString(mAction);
        Uri.writeToParcel(out, mData);
        out.writeString(mType);
        out.writeInt(mFlags);
        out.writeString(mPackage);
        ComponentName.writeToParcel(mComponent, out);
        if(mSourceBounds != null)        
        {
            out.writeInt(1);
            mSourceBounds.writeToParcel(out, flags);
        } //End block
        else
        {
            out.writeInt(0);
        } //End block
        if(mCategories != null)        
        {
            out.writeInt(mCategories.size());
for(String category : mCategories)
            {
                out.writeString(category);
            } //End block
        } //End block
        else
        {
            out.writeInt(0);
        } //End block
        if(mSelector != null)        
        {
            out.writeInt(1);
            mSelector.writeToParcel(out, flags);
        } //End block
        else
        {
            out.writeInt(0);
        } //End block
        out.writeBundle(mExtras);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.472 -0400", hash_original_method = "275963C0D40D3AED4795057AE368B460", hash_generated_method = "2B7749721FBE433D7D66F7EFC057CF68")
    public void readFromParcel(Parcel in) {
        setAction(in.readString());
        mData = Uri.CREATOR.createFromParcel(in);
        mType = in.readString();
        mFlags = in.readInt();
        mPackage = in.readString();
        mComponent = ComponentName.readFromParcel(in);
        if(in.readInt() != 0)        
        {
            mSourceBounds = Rect.CREATOR.createFromParcel(in);
        } //End block
        int N = in.readInt();
        if(N > 0)        
        {
            mCategories = new HashSet<String>();
            int i;
for(i=0;i<N;i++)
            {
                mCategories.add(in.readString().intern());
            } //End block
        } //End block
        else
        {
            mCategories = null;
        } //End block
        if(in.readInt() != 0)        
        {
            mSelector = new Intent(in);
        } //End block
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

    
    /**
     * Use this method to translate one intent to another in a way that is
     * dependent on the values resolved by attribute modeling.  This call is modeled 
     * in the attribute modeling pass as well.
     */
    @DSModeled(DSC.BAN)
    public Intent translateIntent() {
        Intent result = new Intent();
        result.setAction(orig.getAction());
        result.setType(orig.getType());
        result.setPackage(orig.getPackage());

        result.setData(orig.getData());
        //set the data field to the type field in the case there is no existing uri
        result.setData(Uri.parse(orig.getType()));

        return result;
    }

    @DSModeled(DSC.SPEC)
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.473 -0400", hash_original_field = "387F1FA6FC99B8AE187C010A06120611", hash_generated_field = "AEA3D3739F492530AF8FD6582FAACBD9")

        public String packageName;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.474 -0400", hash_original_field = "8FAF06E45C46259BF19965503E274807", hash_generated_field = "08D9F4FE05D4D9B5AF5EACB299E1AC68")

        public String resourceName;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.474 -0400", hash_original_method = "76C9E47B1998842612265A8369AB620F", hash_generated_method = "76C9E47B1998842612265A8369AB620F")
        public ShortcutIconResource ()
        {
            //Synthesized constructor
        }


        @DSModeled(DSC.SAFE)
        public static ShortcutIconResource fromContext(Context context, int resourceId) {
            ShortcutIconResource icon = new ShortcutIconResource();
            icon.packageName = context.getPackageName();
            icon.resourceName = context.getResources().getResourceName(resourceId);
            return icon;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.474 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "80AA2C1E66BC0DB39A56391CA1D3F005")
        public int describeContents() {
            int varCFCD208495D565EF66E7DFF9F98764DA_737864464 = (0);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2124205039 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2124205039;
            // ---------- Original Method ----------
            //return 0;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.475 -0400", hash_original_method = "A078CBD5399741F593957325C4A01342", hash_generated_method = "865081BB075C546376884A7AF718F759")
        public void writeToParcel(Parcel dest, int flags) {
            addTaint(flags);
            addTaint(dest.getTaint());
            dest.writeString(packageName);
            dest.writeString(resourceName);
            // ---------- Original Method ----------
            //dest.writeString(packageName);
            //dest.writeString(resourceName);
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.475 -0400", hash_original_method = "8D66F7367028E1EB1EA87D8477E02D6C", hash_generated_method = "B7D61C272792EFE530E82F119AAAF9E3")
        @Override
        public String toString() {
String varDE4363A900B18904B4024DC514CB5E14_1967402729 =             resourceName;
            varDE4363A900B18904B4024DC514CB5E14_1967402729.addTaint(taint);
            return varDE4363A900B18904B4024DC514CB5E14_1967402729;
            // ---------- Original Method ----------
            //return resourceName;
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.475 -0400", hash_original_field = "FBF38D2B8BC640782282E16FFEC5198F", hash_generated_field = "1765F17BB54E8B45766A199ED3197D0C")

        public static final Parcelable.Creator<ShortcutIconResource> CREATOR =
            new Parcelable.Creator<ShortcutIconResource>() {

                @DSModeled(DSC.SAFE)
            public ShortcutIconResource createFromParcel(Parcel source) {
                    ShortcutIconResource icon = new ShortcutIconResource();
                    icon.packageName = source.readString();
                    icon.resourceName = source.readString();
                    return icon;
                }

                @DSModeled(DSC.SAFE)
            public ShortcutIconResource[] newArray(int size) {
                    return new ShortcutIconResource[size];
                }
            };
    }


    
    public static final class FilterComparison {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.475 -0400", hash_original_field = "B1135DD88C82BCDD4DCD8391BCD99883", hash_generated_field = "5782C825DA3F61D408DF2DCA63E7F54A")

        private Intent mIntent;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.475 -0400", hash_original_field = "D1324C907E3C733CA9E17C8F90836F79", hash_generated_field = "A977E573260D0E2786C71BC0961278A2")

        private int mHashCode;
        
        @DSModeled(DSC.SPEC)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.475 -0400", hash_original_method = "2099CA9774C8964FCB84A0C5BA5EC3C6", hash_generated_method = "01A84E541FBE057533665879491A9DB5")
        public  FilterComparison(Intent intent) {
            mIntent = intent;
            mHashCode = intent.filterHashCode();
            // ---------- Original Method ----------
            //mIntent = intent;
            //mHashCode = intent.filterHashCode();
        }

        
        @DSModeled(DSC.SPEC)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.476 -0400", hash_original_method = "AD027B7B58A4A2F151CC138FB7B23244", hash_generated_method = "595899E683EC727D70D16E1EF7BC42B1")
        public Intent getIntent() {
Intent var4DCF8E3D75AE0B94CDA94656DCE16BCE_894788610 =             mIntent;
            var4DCF8E3D75AE0B94CDA94656DCE16BCE_894788610.addTaint(taint);
            return var4DCF8E3D75AE0B94CDA94656DCE16BCE_894788610;
            // ---------- Original Method ----------
            //return mIntent;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.476 -0400", hash_original_method = "57E0DE3F426C34FAD2C087D7985C733F", hash_generated_method = "192C1A21E3741C56BD93E8110A631A7F")
        @Override
        public boolean equals(Object obj) {
            addTaint(obj.getTaint());
            if(obj instanceof FilterComparison)            
            {
                Intent other = ((FilterComparison)obj).mIntent;
                boolean varD2A6DADD7FB1811D8110FF668069F759_211808153 = (mIntent.filterEquals(other));
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_734541336 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_734541336;
            } //End block
            boolean var68934A3E9455FA72420237EB05902327_606969746 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_981793257 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_981793257;
            // ---------- Original Method ----------
            //if (obj instanceof FilterComparison) {
                //Intent other = ((FilterComparison)obj).mIntent;
                //return mIntent.filterEquals(other);
            //}
            //return false;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.476 -0400", hash_original_method = "D7D5E8B622FC6A9CB6E203DCD79B8799", hash_generated_method = "15166C1E1F14E2BD06D00639AB4ED00D")
        @Override
        public int hashCode() {
            int varD1324C907E3C733CA9E17C8F90836F79_1132671547 = (mHashCode);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_428735516 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_428735516;
            // ---------- Original Method ----------
            //return mHashCode;
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.476 -0400", hash_original_field = "A8B946E40C0F8F203925ED477BA2F488", hash_generated_field = "8C4948296C5582312F7CF47A7D2DC8E5")

    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_MAIN = "android.intent.action.MAIN";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.477 -0400", hash_original_field = "796311F4A44E07CF272E2A9B98EF5CAF", hash_generated_field = "B4FC4AC4434AF0988895645F8113BE4D")

    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_VIEW = "android.intent.action.VIEW";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.477 -0400", hash_original_field = "6D1142C4000E42A85B515A5253C0D7B6", hash_generated_field = "31B7CB6CE826B970ED2FBCA1E6169A2F")

    public static final String ACTION_DEFAULT = ACTION_VIEW;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.477 -0400", hash_original_field = "C884729C77510956CD52E6AFCA9E5371", hash_generated_field = "B7771E23284E70ECBAF10CF8D998AB41")

    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_ATTACH_DATA = "android.intent.action.ATTACH_DATA";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.477 -0400", hash_original_field = "E77EAF3FFFF3A8317CD55A336AF4D1E3", hash_generated_field = "44755A5ACF130CF4CF6E8287050DF9EB")

    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_EDIT = "android.intent.action.EDIT";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.477 -0400", hash_original_field = "228BA85FD5482D015B15DE9D96D2321B", hash_generated_field = "83D15D19A3398819C14A6C83965BAE99")

    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_INSERT_OR_EDIT = "android.intent.action.INSERT_OR_EDIT";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.477 -0400", hash_original_field = "406446BB3C927955BF05E94CF21E5433", hash_generated_field = "D9B827E0A1E1DCD9F132DDCC7FC46859")

    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_PICK = "android.intent.action.PICK";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.477 -0400", hash_original_field = "115054E1A7193CD193482465BB90A765", hash_generated_field = "993347C266428903DAA186C844B97694")

    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_CREATE_SHORTCUT = "android.intent.action.CREATE_SHORTCUT";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.477 -0400", hash_original_field = "3D36AB093ACD74D4AEFCCBDAD0ADFD5E", hash_generated_field = "B6ADBC69477081B9FC2AB0FFF4840082")

    public static final String EXTRA_SHORTCUT_INTENT = "android.intent.extra.shortcut.INTENT";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.477 -0400", hash_original_field = "AE1914FB40A9F18B6D5E8F92A045CFA6", hash_generated_field = "F8A802D90F8F3D251F6BD332F302EAF0")

    public static final String EXTRA_SHORTCUT_NAME = "android.intent.extra.shortcut.NAME";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.477 -0400", hash_original_field = "CE1EBCF2A7C9749471AE04C87618EDED", hash_generated_field = "0E7C24C264DE9B0116CDE392569F9C32")

    public static final String EXTRA_SHORTCUT_ICON = "android.intent.extra.shortcut.ICON";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.477 -0400", hash_original_field = "9F9F116C7BC071710CF6B851E6748424", hash_generated_field = "27DE92A0E7A6C6975AF7B85FFD1372DA")

    public static final String EXTRA_SHORTCUT_ICON_RESOURCE =
            "android.intent.extra.shortcut.ICON_RESOURCE";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.477 -0400", hash_original_field = "68AE3958F4460BAE6BEBE21AA0394CB4", hash_generated_field = "B903FA9C641B07A1FD05DF6C900DDE87")

    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_CHOOSER = "android.intent.action.CHOOSER";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.477 -0400", hash_original_field = "27721C175F1E72453157848B9AFB33C5", hash_generated_field = "224E520888804F5E9A6A84B1429FF6C0")

    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_GET_CONTENT = "android.intent.action.GET_CONTENT";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.477 -0400", hash_original_field = "129FEAF5279E0B6B34063591470E62D2", hash_generated_field = "BA8AC554D2E7958FEB87F665CB187200")

    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_DIAL = "android.intent.action.DIAL";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.478 -0400", hash_original_field = "12A6BF356707577A2428ACFFFD59153D", hash_generated_field = "156D2611F9948DFBC8BEB851A4F2D865")

    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_CALL = "android.intent.action.CALL";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.478 -0400", hash_original_field = "85E00C92EC28EF841EA8EF7947A76DFD", hash_generated_field = "C7F702A15124025B52F4AE9D5F1D8AD8")

    public static final String ACTION_CALL_EMERGENCY = "android.intent.action.CALL_EMERGENCY";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.478 -0400", hash_original_field = "64EA32DFD508A69432FF0B1584E13A4D", hash_generated_field = "B84BCDAAA8978FF3F9970DBD3472E33A")

    public static final String ACTION_CALL_PRIVILEGED = "android.intent.action.CALL_PRIVILEGED";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.478 -0400", hash_original_field = "51F7C06A8683898EFCB7410AC4F73318", hash_generated_field = "3EB1F7AB454572370D3425BC3C27609E")

    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_SENDTO = "android.intent.action.SENDTO";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.478 -0400", hash_original_field = "DA99766A71A9D28F609127834E21CBFE", hash_generated_field = "1A00662632D62B278530F5AAFC144039")

    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_SEND = "android.intent.action.SEND";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.478 -0400", hash_original_field = "27737F17778FB540F67ECDAAFE981CFE", hash_generated_field = "20049E89E82A72A563C5146D910079EA")

    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_SEND_MULTIPLE = "android.intent.action.SEND_MULTIPLE";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.478 -0400", hash_original_field = "6AFF647F405E10A1EC8E84BCE8F333C3", hash_generated_field = "BCE6BAF3569F0CD9A5E69A60137D5C81")

    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_ANSWER = "android.intent.action.ANSWER";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.478 -0400", hash_original_field = "E148FA947761B685A6980605AF00FC20", hash_generated_field = "0C3014CD7256D614A3FE7AD4340BF556")

    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_INSERT = "android.intent.action.INSERT";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.478 -0400", hash_original_field = "107D0D440F63BEB52061BC6197005E33", hash_generated_field = "B54448451E8A597131F91F0578FB99AD")

    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_PASTE = "android.intent.action.PASTE";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.478 -0400", hash_original_field = "F5A4DF774AB4DBD3A6535DE06B1B6F9B", hash_generated_field = "DF7BAB5523E713ECFAD35C76FE516A25")

    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_DELETE = "android.intent.action.DELETE";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.478 -0400", hash_original_field = "70928EA440745E12D4F465718BA952EB", hash_generated_field = "64053F2DE34FDC5E2063C0A720EE652A")

    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_RUN = "android.intent.action.RUN";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.478 -0400", hash_original_field = "0BED932883E0015368BF67C1015EE18B", hash_generated_field = "52B9A6D0C516BD31A4C95AEA422C7CDD")

    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_SYNC = "android.intent.action.SYNC";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.478 -0400", hash_original_field = "39453BBDD6A75C5CB7C9EE0E6B523CFA", hash_generated_field = "6E59FE4FD801C0D307FECC5EC4DF8628")

    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_PICK_ACTIVITY = "android.intent.action.PICK_ACTIVITY";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.479 -0400", hash_original_field = "8879CF3452B6491271484F5E4B4CC17E", hash_generated_field = "E7F9F68DFE9898629E0198A735569695")

    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_SEARCH = "android.intent.action.SEARCH";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.479 -0400", hash_original_field = "4F83F2665723B7E13FB552E202AB51F5", hash_generated_field = "737D48C4A21F919A73BF8BEED0D584ED")

    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_SYSTEM_TUTORIAL = "android.intent.action.SYSTEM_TUTORIAL";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.479 -0400", hash_original_field = "33A02BA405FCAAA580A9AF321CF6E98B", hash_generated_field = "26A470EDFD3CA2849C1FCACCD2E608D4")

    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_WEB_SEARCH = "android.intent.action.WEB_SEARCH";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.479 -0400", hash_original_field = "9F03C542BB9719438E64312DE2636DC1", hash_generated_field = "BE767857B9865892A73819172E037AD1")

    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_ALL_APPS = "android.intent.action.ALL_APPS";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.479 -0400", hash_original_field = "66469EFE01BC9D9A79D9EC1BBECCC6A0", hash_generated_field = "78B483C17CF8E280B3FFE64EBE9308D7")

    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_SET_WALLPAPER = "android.intent.action.SET_WALLPAPER";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.479 -0400", hash_original_field = "FDE87E06EBF94C541AE7047C6575B199", hash_generated_field = "88A571004065BB2EDB6670E75B4759B4")

    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_BUG_REPORT = "android.intent.action.BUG_REPORT";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.479 -0400", hash_original_field = "03BAF606EC0D92488225FEA702090CBC", hash_generated_field = "CE3414178F66CECEAE525495168216DF")

    public static final String ACTION_FACTORY_TEST = "android.intent.action.FACTORY_TEST";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.479 -0400", hash_original_field = "7D053EDF38227B551A6CF18E92CCA353", hash_generated_field = "B0656284FD0F7E03B7575D3D85A97AEE")

    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_CALL_BUTTON = "android.intent.action.CALL_BUTTON";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.479 -0400", hash_original_field = "8528F0AE3852862076D0EE186CA184C0", hash_generated_field = "A75AE92BC026CE01AEADCE0ABC24D90D")

    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_VOICE_COMMAND = "android.intent.action.VOICE_COMMAND";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.479 -0400", hash_original_field = "499FC79BEC46A6BFDEC25183566A5169", hash_generated_field = "694DBF6AB3FCCC208CBE973967A9AC55")

    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_SEARCH_LONG_PRESS = "android.intent.action.SEARCH_LONG_PRESS";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.479 -0400", hash_original_field = "D05E9495D6AAD50A9FEC91F89758EEA2", hash_generated_field = "DD97D416D92C0F615E268CAE319B9240")

    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_APP_ERROR = "android.intent.action.APP_ERROR";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.479 -0400", hash_original_field = "791FC936926CF8F3F506FB205157DE5A", hash_generated_field = "A3A3FAFEFA13163016A6BA1A34223541")

    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_POWER_USAGE_SUMMARY = "android.intent.action.POWER_USAGE_SUMMARY";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.479 -0400", hash_original_field = "53BE68F91DF39774F55F89CE89ED569E", hash_generated_field = "1EFAF27E8BB9D3EDBE3E169F25247ED4")

    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_UPGRADE_SETUP = "android.intent.action.UPGRADE_SETUP";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.479 -0400", hash_original_field = "267F4538830482CEC3ABBD76184D0745", hash_generated_field = "E9B6C831918B3E1D73A086432893716E")

    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_MANAGE_NETWORK_USAGE =
            "android.intent.action.MANAGE_NETWORK_USAGE";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.479 -0400", hash_original_field = "F175C83CB8981F0B406E4F17BA659303", hash_generated_field = "224FD1BF8BEC020F4764D95A85BFD13C")

    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_INSTALL_PACKAGE = "android.intent.action.INSTALL_PACKAGE";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.480 -0400", hash_original_field = "A01FD6DC5E600894209811F32F56B91D", hash_generated_field = "095986244542E9347842ED78D18CD74E")

    public static final String EXTRA_INSTALLER_PACKAGE_NAME
            = "android.intent.extra.INSTALLER_PACKAGE_NAME";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.480 -0400", hash_original_field = "5365E48984AE030157E927F4359CC241", hash_generated_field = "2279FC773C4241383D589A90D26BE2B5")

    public static final String EXTRA_NOT_UNKNOWN_SOURCE
            = "android.intent.extra.NOT_UNKNOWN_SOURCE";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.480 -0400", hash_original_field = "143EA34DE9089D023B14437FD8F414EE", hash_generated_field = "0F02B996D65BEFE314ED9C58EC4F054C")

    public static final String EXTRA_ALLOW_REPLACE
            = "android.intent.extra.ALLOW_REPLACE";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.480 -0400", hash_original_field = "F040EEC629D331F2677EF196C182348B", hash_generated_field = "CABD06708BF342F9A6F9EEF34216D9E5")

    public static final String EXTRA_RETURN_RESULT
            = "android.intent.extra.RETURN_RESULT";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.480 -0400", hash_original_field = "51F7E3DE5D78822A2C67AB55C4062EBD", hash_generated_field = "D664CE1BA8A3AD69E368E2660C3CB4E9")

    public static final String EXTRA_INSTALL_RESULT
            = "android.intent.extra.INSTALL_RESULT";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.480 -0400", hash_original_field = "2EB27F3DF7BFF9065CF805128DA949A2", hash_generated_field = "5D0C5026A979DB00BB5F4ADD3EBFDB2D")

    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_UNINSTALL_PACKAGE = "android.intent.action.UNINSTALL_PACKAGE";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.480 -0400", hash_original_field = "42784AA3F54756FDE7A6215A4C66D306", hash_generated_field = "604CC86BBA1936C2065E409B75C690BD")

    public static final String METADATA_SETUP_VERSION = "android.SETUP_VERSION";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.480 -0400", hash_original_field = "AC10B9A7A5F6ADFCA57066C15D8A3C44", hash_generated_field = "FDEAE1CF49A8C01C84FD5D71CAFFEC9D")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_SCREEN_OFF = "android.intent.action.SCREEN_OFF";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.480 -0400", hash_original_field = "01A5F1932A4970847D03F7A651A4A603", hash_generated_field = "1FC4F0F18C8B9F53FA7192917FC4AB66")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_SCREEN_ON = "android.intent.action.SCREEN_ON";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.480 -0400", hash_original_field = "ED9176148F7F847FF922C07DDC3123FE", hash_generated_field = "02A3AA184DBA3BF4ED8BBC3FF5A5EA52")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_USER_PRESENT = "android.intent.action.USER_PRESENT";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.480 -0400", hash_original_field = "E89C5128B40966DA4AC64E1E180F178B", hash_generated_field = "C4F52864EBD629B8C1AE5257671D488F")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_TIME_TICK = "android.intent.action.TIME_TICK";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.480 -0400", hash_original_field = "1EF7AD93F4ED1D9C68D9B62A442EE0C0", hash_generated_field = "90329A50970E9E426A169EEC900D33F0")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_TIME_CHANGED = "android.intent.action.TIME_SET";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.480 -0400", hash_original_field = "E4207C3CA3D798F0BAF04ECD1BC96615", hash_generated_field = "57160E8CBD5FB12354C9F2A165FC4406")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_DATE_CHANGED = "android.intent.action.DATE_CHANGED";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.480 -0400", hash_original_field = "7EDA8FAFB1FCE49A6B3A0BF0293733CC", hash_generated_field = "092DA96C44A18F27A501A8534FFCD4F2")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_TIMEZONE_CHANGED = "android.intent.action.TIMEZONE_CHANGED";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.481 -0400", hash_original_field = "C5D635BAB4A89C331FD7D9A131B3F406", hash_generated_field = "2283D5CDFBBD632A8875668E1CC33C72")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_CLEAR_DNS_CACHE = "android.intent.action.CLEAR_DNS_CACHE";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.481 -0400", hash_original_field = "79997921741E1D6BEA59D6556006F40F", hash_generated_field = "C359D5926C706990350C34DE9456F7E3")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_ALARM_CHANGED = "android.intent.action.ALARM_CHANGED";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.481 -0400", hash_original_field = "B94D7897232C2944B5B70514A85DFA93", hash_generated_field = "0E69C231C8306016AEE014A3D1AF38B7")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_SYNC_STATE_CHANGED
            = "android.intent.action.SYNC_STATE_CHANGED";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.481 -0400", hash_original_field = "C1D22BB4AAB40F3A4AA70ECAFAFB8600", hash_generated_field = "97FEB82EA8E82C6EA441D833FB2D22C8")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_BOOT_COMPLETED = "android.intent.action.BOOT_COMPLETED";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.481 -0400", hash_original_field = "5776AE1D20CE64A982FFE3E5CF07A557", hash_generated_field = "D95B98D4DA81F25EA38B96B61FBDB946")

    public static final String ACTION_CLOSE_SYSTEM_DIALOGS = "android.intent.action.CLOSE_SYSTEM_DIALOGS";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.481 -0400", hash_original_field = "DB9C13578210E28D259FB7060F0A661E", hash_generated_field = "2C7D09002B43654AC3703592944450CB")

    @Deprecated
    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_PACKAGE_INSTALL = "android.intent.action.PACKAGE_INSTALL";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.481 -0400", hash_original_field = "A63458462EB298509B857A921AF918DB", hash_generated_field = "E9BF2DB88022DA53F5B709714C727F77")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_PACKAGE_ADDED = "android.intent.action.PACKAGE_ADDED";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.481 -0400", hash_original_field = "E1F6D10EADF70BA722A08B8549847ADA", hash_generated_field = "4FE14146DF43D9EDF110C776366AEBA7")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_PACKAGE_REPLACED = "android.intent.action.PACKAGE_REPLACED";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.481 -0400", hash_original_field = "2002566C43E3485F3C34B5BB31F87207", hash_generated_field = "8E7A7A120C757C5788574BAE90EF4C4F")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_MY_PACKAGE_REPLACED = "android.intent.action.MY_PACKAGE_REPLACED";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.481 -0400", hash_original_field = "C1CC2774743B965C8575196E8B87FA53", hash_generated_field = "35FE490F4B8E618F5247F033A516643E")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_PACKAGE_REMOVED = "android.intent.action.PACKAGE_REMOVED";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.481 -0400", hash_original_field = "CEFA491D360B28870082F55E683C13DD", hash_generated_field = "45DA25B1BF4497A16EE81215EC103B86")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_PACKAGE_FULLY_REMOVED
            = "android.intent.action.PACKAGE_FULLY_REMOVED";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.482 -0400", hash_original_field = "974BC5FEE7B3F985713F59B7C98607CA", hash_generated_field = "3B88AC76A94E57D70607375559434DF6")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_PACKAGE_CHANGED = "android.intent.action.PACKAGE_CHANGED";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.482 -0400", hash_original_field = "DFBCF095A42ACA7A55643F0863DF8E8D", hash_generated_field = "83AB29CDF0C8D03ED03B189B0B3B427D")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_QUERY_PACKAGE_RESTART = "android.intent.action.QUERY_PACKAGE_RESTART";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.482 -0400", hash_original_field = "73F8CC86BDA7A6B496BD174C46A483AD", hash_generated_field = "485E38FFA9AEDA99636C6777203D486E")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_PACKAGE_RESTARTED = "android.intent.action.PACKAGE_RESTARTED";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.482 -0400", hash_original_field = "8FBCDA795A9A905721B9686123A338AE", hash_generated_field = "CE51064186158FF3C33BEB6F375C1BF1")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_PACKAGE_DATA_CLEARED = "android.intent.action.PACKAGE_DATA_CLEARED";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.482 -0400", hash_original_field = "AD6CD306DE617961650614459FCBFB3A", hash_generated_field = "F550ED6B3D1AF7CD7BB88086505B7ABD")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_UID_REMOVED = "android.intent.action.UID_REMOVED";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.482 -0400", hash_original_field = "DC4A82639596646547A6DC82886FCFCC", hash_generated_field = "6914952F46126338B1ABD751495C4588")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_PACKAGE_FIRST_LAUNCH = "android.intent.action.PACKAGE_FIRST_LAUNCH";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.482 -0400", hash_original_field = "952F6974186E0401813222C56B54D960", hash_generated_field = "772AAE9E85E0EFC70AE22DE59C52A048")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_PACKAGE_NEEDS_VERIFICATION = "android.intent.action.PACKAGE_NEEDS_VERIFICATION";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.482 -0400", hash_original_field = "3FBD18E81715442BDEE658474C5629E5", hash_generated_field = "21890D9A6F3165ECEF5820886B5827AD")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_EXTERNAL_APPLICATIONS_AVAILABLE =
        "android.intent.action.EXTERNAL_APPLICATIONS_AVAILABLE";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.482 -0400", hash_original_field = "79BBB6392C89883A34F60A67157B8582", hash_generated_field = "1D6B9ABFAFEDC734E8E2A5E0384923C8")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_EXTERNAL_APPLICATIONS_UNAVAILABLE =
        "android.intent.action.EXTERNAL_APPLICATIONS_UNAVAILABLE";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.482 -0400", hash_original_field = "0CA81190EF8F2C182EC0BFA71489F6BE", hash_generated_field = "D9C4187C78B1437F37AB9EC1AA21494E")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_WALLPAPER_CHANGED = "android.intent.action.WALLPAPER_CHANGED";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.482 -0400", hash_original_field = "CA63A4F0D845CC1A2BCE34B56FAC1C91", hash_generated_field = "1BBA1270FB38433693D57149CF8C0B2E")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_CONFIGURATION_CHANGED = "android.intent.action.CONFIGURATION_CHANGED";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.482 -0400", hash_original_field = "190930AA5CD7C41A46E58AE93DB4DAF9", hash_generated_field = "8CB211B82206532C1A38690C8B237654")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_LOCALE_CHANGED = "android.intent.action.LOCALE_CHANGED";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.482 -0400", hash_original_field = "ABE66503534AB36013F9685C92AD6591", hash_generated_field = "570C99553ED814D403177932D335BED6")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_BATTERY_CHANGED = "android.intent.action.BATTERY_CHANGED";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.482 -0400", hash_original_field = "C2AB6403A193FE10BC66D90B8FDDFF9F", hash_generated_field = "00E1ABC519EAD5F7A1CA909504F2202F")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_BATTERY_LOW = "android.intent.action.BATTERY_LOW";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.483 -0400", hash_original_field = "7D81F6B5F34EF94F54058BACC058E6EA", hash_generated_field = "9210CA8BA87692C4B485CE9B81D3110D")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_BATTERY_OKAY = "android.intent.action.BATTERY_OKAY";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.483 -0400", hash_original_field = "2FBCC98803903EB8DF2A2E59807AAD0B", hash_generated_field = "B2C6014C054E378354CF8FE40A52B2C2")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_POWER_CONNECTED = "android.intent.action.ACTION_POWER_CONNECTED";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.483 -0400", hash_original_field = "B65A00CA79DDAB92BD36A61399A53F2B", hash_generated_field = "EBEFF5DC3845903EFCEC6B07375DACA1")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_POWER_DISCONNECTED =
            "android.intent.action.ACTION_POWER_DISCONNECTED";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.483 -0400", hash_original_field = "5360B341F96A3309BDB72D08A8AF3101", hash_generated_field = "1BE5AD2EFAFDA27EB66F2443D735550E")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_SHUTDOWN = "android.intent.action.ACTION_SHUTDOWN";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.483 -0400", hash_original_field = "F6E2DBBBE878DBD513D21A5985484D79", hash_generated_field = "5F3F58AD9176A8304B540840F63575DB")

    public static final String ACTION_REQUEST_SHUTDOWN = "android.intent.action.ACTION_REQUEST_SHUTDOWN";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.483 -0400", hash_original_field = "119DD15F0F370A1DDD81085CDC53C416", hash_generated_field = "01A6016CF410E4B86318EFF197BCF8F9")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_DEVICE_STORAGE_LOW = "android.intent.action.DEVICE_STORAGE_LOW";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.483 -0400", hash_original_field = "B006976F3FD1C9379ED3FDC91DCEDAD0", hash_generated_field = "33F2A4A9934CCDA6F410E6F6C0F40214")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_DEVICE_STORAGE_OK = "android.intent.action.DEVICE_STORAGE_OK";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.483 -0400", hash_original_field = "A5B2E3301ADC08BEF1E7F56EBC9B4512", hash_generated_field = "368FAECEAD77772CAF85D0422B1C8A79")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_DEVICE_STORAGE_FULL = "android.intent.action.DEVICE_STORAGE_FULL";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.483 -0400", hash_original_field = "5E3F319F2CDD9D32B369D43C732D6318", hash_generated_field = "9C13CE86364BD1EE13C144EEC334D347")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_DEVICE_STORAGE_NOT_FULL = "android.intent.action.DEVICE_STORAGE_NOT_FULL";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.483 -0400", hash_original_field = "059125B32EFD1CCFEA64F4973EC2CDE0", hash_generated_field = "D65BD0B998073C9FE19756354457F478")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_MANAGE_PACKAGE_STORAGE = "android.intent.action.MANAGE_PACKAGE_STORAGE";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.483 -0400", hash_original_field = "D0AC83754C71725F6D08BA0C0C25267B", hash_generated_field = "3CBD0CC144FEC04702B3F1CD13F64839")

    @Deprecated
    public static final String ACTION_UMS_CONNECTED = "android.intent.action.UMS_CONNECTED";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.483 -0400", hash_original_field = "C92C26D8E96BDB97E9897B848DE2033A", hash_generated_field = "4BDE49336D4AFA09BB0FE3A57004C306")

    @Deprecated
    public static final String ACTION_UMS_DISCONNECTED = "android.intent.action.UMS_DISCONNECTED";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.483 -0400", hash_original_field = "0F5995E5E0CD89E06452ACE0AE11DC38", hash_generated_field = "B2BE1657103DB0488498829BD96E22F0")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_MEDIA_REMOVED = "android.intent.action.MEDIA_REMOVED";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.484 -0400", hash_original_field = "0BA4BC993DC7A1FB857E93FDFE872263", hash_generated_field = "C9CB40A30C23F3F14E497C2C7F2325BD")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_MEDIA_UNMOUNTED = "android.intent.action.MEDIA_UNMOUNTED";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.484 -0400", hash_original_field = "893452DB1B800AEF80988969D8E17444", hash_generated_field = "D43D07DAC9AFB658BCECFFD0CEB2069A")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_MEDIA_CHECKING = "android.intent.action.MEDIA_CHECKING";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.484 -0400", hash_original_field = "B2189C066541A4999F6EE7F447C87DA0", hash_generated_field = "55384D59F49FD41A2EADF0CCA4C0929A")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_MEDIA_NOFS = "android.intent.action.MEDIA_NOFS";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.484 -0400", hash_original_field = "608C05FB9F18771854CCC6BFA2E61B99", hash_generated_field = "10558D4779FCB99BEE53B32D18320978")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_MEDIA_MOUNTED = "android.intent.action.MEDIA_MOUNTED";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.484 -0400", hash_original_field = "11BE99F77B54DE8611DC73AE398FF47B", hash_generated_field = "8566E36A8F60EC1445E814C3A2CB4525")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_MEDIA_SHARED = "android.intent.action.MEDIA_SHARED";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.484 -0400", hash_original_field = "49BEEC1263231F173DFB9C83AAF90066", hash_generated_field = "4A0966F843885D1B4C7D86D57A30AB03")

    public static final String ACTION_MEDIA_UNSHARED = "android.intent.action.MEDIA_UNSHARED";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.484 -0400", hash_original_field = "41127306CF412F9F42D099AB126C8D7F", hash_generated_field = "803A350DA057B94CB8E27CB7B878C6A6")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_MEDIA_BAD_REMOVAL = "android.intent.action.MEDIA_BAD_REMOVAL";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.484 -0400", hash_original_field = "1C88A7F58841E50FBC52DAB70756F62F", hash_generated_field = "31F84A292E6949D56D48CCEB1F50770D")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_MEDIA_UNMOUNTABLE = "android.intent.action.MEDIA_UNMOUNTABLE";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.484 -0400", hash_original_field = "C9EF4EE02332ADF3A9FC44C9F6D2C825", hash_generated_field = "9059034AB7D9AA44CE7FCE4B140694F3")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_MEDIA_EJECT = "android.intent.action.MEDIA_EJECT";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.484 -0400", hash_original_field = "20A4E0AF785D3F8B1D62400AEAFFD659", hash_generated_field = "71A3429142C498B04ED73651826D736E")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_MEDIA_SCANNER_STARTED = "android.intent.action.MEDIA_SCANNER_STARTED";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.484 -0400", hash_original_field = "D65D35414000C272F52987DE8C2F8B15", hash_generated_field = "A5291D8E43EEC5A34C794D6EDB297C4B")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_MEDIA_SCANNER_FINISHED = "android.intent.action.MEDIA_SCANNER_FINISHED";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.484 -0400", hash_original_field = "22647845D0D96E7DB93C43A7B00C815B", hash_generated_field = "B73610259405BC52D46A6BB9A234CACC")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_MEDIA_SCANNER_SCAN_FILE = "android.intent.action.MEDIA_SCANNER_SCAN_FILE";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.484 -0400", hash_original_field = "6F8F18927694162775EC91AB42089027", hash_generated_field = "96866AE193EB7AD4C2D320F9E8F9667F")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_MEDIA_BUTTON = "android.intent.action.MEDIA_BUTTON";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.484 -0400", hash_original_field = "D7C400CE10ACF47F03EEDF3F777A3FA5", hash_generated_field = "1B888EC3E349732B7C1B7AADD006D324")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_CAMERA_BUTTON = "android.intent.action.CAMERA_BUTTON";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.484 -0400", hash_original_field = "DA60570D82EB22C48CE3C03AE187F5F9", hash_generated_field = "015F8ADF01F6BA460C769A049853C81F")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_GTALK_SERVICE_CONNECTED =
            "android.intent.action.GTALK_CONNECTED";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.485 -0400", hash_original_field = "E932654067B6A5F99CAC6C0E65474740", hash_generated_field = "8BD1CF036007C1899341967FD8CF4CDF")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_GTALK_SERVICE_DISCONNECTED =
            "android.intent.action.GTALK_DISCONNECTED";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.485 -0400", hash_original_field = "3BF4F29C6AB8210F1D77B2CC224E5B2B", hash_generated_field = "522D033A61D4D533DE9C09A76302DC98")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_INPUT_METHOD_CHANGED =
            "android.intent.action.INPUT_METHOD_CHANGED";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.485 -0400", hash_original_field = "C45DE8760103A7B7AAD791CFA471BD40", hash_generated_field = "D2528C9CC0EA562DC80B69589069F631")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_AIRPLANE_MODE_CHANGED = "android.intent.action.AIRPLANE_MODE";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.485 -0400", hash_original_field = "AED491A109C19AFE1086F764E0F8F1C5", hash_generated_field = "41C0CEA92EB9C8B86E585E41D9D7A0CF")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_PROVIDER_CHANGED =
            "android.intent.action.PROVIDER_CHANGED";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.485 -0400", hash_original_field = "AC89C4751319BD134FDA49F64E20A17D", hash_generated_field = "37C2771817E59664B8B239BCBDACBB10")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_HEADSET_PLUG =
            "android.intent.action.HEADSET_PLUG";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.485 -0400", hash_original_field = "97F0D02F275759DA6BC9DCCF5DA67B77", hash_generated_field = "D7E4EDC4328425F0329B2F8E1A88DAC9")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_USB_ANLG_HEADSET_PLUG =
            "android.intent.action.USB_ANLG_HEADSET_PLUG";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.485 -0400", hash_original_field = "194A5D6BCF934DE3E92D3DD709B06BB3", hash_generated_field = "B2FBB541357A96FDB3E687180A2EC76D")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_USB_DGTL_HEADSET_PLUG =
            "android.intent.action.USB_DGTL_HEADSET_PLUG";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.485 -0400", hash_original_field = "03F1ED15F5764C1EE2328771105571B3", hash_generated_field = "9163DF3896F055A609C5B564A0BFEBCC")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_HDMI_AUDIO_PLUG =
            "android.intent.action.HDMI_AUDIO_PLUG";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.485 -0400", hash_original_field = "38DC7D02EAB39D530A659027832681A6", hash_generated_field = "4EB742B935E945715EE07C7C0B3F92AC")

    public static final String ACTION_ADVANCED_SETTINGS_CHANGED
            = "android.intent.action.ADVANCED_SETTINGS";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.485 -0400", hash_original_field = "98DB3317D8784E8D0E3807DEBED0F12B", hash_generated_field = "D8133F9238C84FB44D78043BBC29F6DB")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_NEW_OUTGOING_CALL =
            "android.intent.action.NEW_OUTGOING_CALL";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.485 -0400", hash_original_field = "7469D5128F001D05C37CFEE084018501", hash_generated_field = "13D1D6B470020C1299E426407C602890")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_REBOOT =
            "android.intent.action.REBOOT";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.485 -0400", hash_original_field = "7AF3672116BBE301D783E3F9059BBFF0", hash_generated_field = "7CCBB1A0B45EFD0A2DFD1D63B82D87E8")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_DOCK_EVENT =
            "android.intent.action.DOCK_EVENT";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.486 -0400", hash_original_field = "07DD88111BB2F54CF270F070F017447B", hash_generated_field = "8EF6B8C482C12C7A4ACB03A0EE29DB00")

    public static final String ACTION_REMOTE_INTENT =
            "com.google.android.c2dm.intent.RECEIVE";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.486 -0400", hash_original_field = "32924E2C2DAC754DCCC5A3C5C39EE035", hash_generated_field = "8565FE3FC70ABB4476B729EE5BD6454E")

    public static final String ACTION_PRE_BOOT_COMPLETED =
            "android.intent.action.PRE_BOOT_COMPLETED";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.486 -0400", hash_original_field = "C1DCD3CCC883758EF400D2C83C00E7D7", hash_generated_field = "8075F7F627891123E230D050B9BAB405")

    @SdkConstant(SdkConstantType.INTENT_CATEGORY)
    public static final String CATEGORY_DEFAULT = "android.intent.category.DEFAULT";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.486 -0400", hash_original_field = "262A06DA9969EAC38ED6B7D0CA868897", hash_generated_field = "78B44AC3B312155C92B9E800BB603925")

    @SdkConstant(SdkConstantType.INTENT_CATEGORY)
    public static final String CATEGORY_BROWSABLE = "android.intent.category.BROWSABLE";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.486 -0400", hash_original_field = "7C705202BCD0ADD823BABCC88A5ED2C7", hash_generated_field = "5D58EABA225388825E6CB55C2DB3A0C5")

    @SdkConstant(SdkConstantType.INTENT_CATEGORY)
    public static final String CATEGORY_ALTERNATIVE = "android.intent.category.ALTERNATIVE";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.486 -0400", hash_original_field = "98581F09C3A53AAE096694E2BB12D613", hash_generated_field = "2B75CF89213BE077BE277CE183A8F989")

    @SdkConstant(SdkConstantType.INTENT_CATEGORY)
    public static final String CATEGORY_SELECTED_ALTERNATIVE = "android.intent.category.SELECTED_ALTERNATIVE";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.486 -0400", hash_original_field = "B01E7FF86BB6783BCD6A2330D12A9C13", hash_generated_field = "888B174B33729C88211F08DA737A729B")

    @SdkConstant(SdkConstantType.INTENT_CATEGORY)
    public static final String CATEGORY_TAB = "android.intent.category.TAB";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.486 -0400", hash_original_field = "1C097396847E07D1E85643E8DD9B2087", hash_generated_field = "56593E4A41EF7C8E79F804744316680A")

    @SdkConstant(SdkConstantType.INTENT_CATEGORY)
    public static final String CATEGORY_LAUNCHER = "android.intent.category.LAUNCHER";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.486 -0400", hash_original_field = "1F6D77CB1845F7CB21C02B283D1B6F00", hash_generated_field = "441C59FEE274EAC3BE26B4A58E9BB45F")

    @SdkConstant(SdkConstantType.INTENT_CATEGORY)
    public static final String CATEGORY_INFO = "android.intent.category.INFO";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.486 -0400", hash_original_field = "E795E3052F1ACD5E8D4E0CA0D408C339", hash_generated_field = "18557C6597B9FD9892461C1C1B6834A2")

    @SdkConstant(SdkConstantType.INTENT_CATEGORY)
    public static final String CATEGORY_HOME = "android.intent.category.HOME";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.486 -0400", hash_original_field = "5277FC097A4F388CAA95678514BBDAB2", hash_generated_field = "51881CD6A4034B4E905D061587A3240D")

    @SdkConstant(SdkConstantType.INTENT_CATEGORY)
    public static final String CATEGORY_PREFERENCE = "android.intent.category.PREFERENCE";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.486 -0400", hash_original_field = "CC0333A9A6C36FBEE9A05BAD3697220B", hash_generated_field = "747531EDE3442CA006298CA2157DE37B")

    @SdkConstant(SdkConstantType.INTENT_CATEGORY)
    public static final String CATEGORY_DEVELOPMENT_PREFERENCE = "android.intent.category.DEVELOPMENT_PREFERENCE";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.486 -0400", hash_original_field = "97573ED50FEF9D3B775819FB719EEA4E", hash_generated_field = "6B6F2EDBA682AA91A9896CAD371A8D07")

    @SdkConstant(SdkConstantType.INTENT_CATEGORY)
    public static final String CATEGORY_EMBED = "android.intent.category.EMBED";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.486 -0400", hash_original_field = "15BD7B2AB7965F1D54906AE580DD6FF1", hash_generated_field = "43D854893F1176EC545D499880817C81")

    @SdkConstant(SdkConstantType.INTENT_CATEGORY)
    public static final String CATEGORY_APP_MARKET = "android.intent.category.APP_MARKET";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.487 -0400", hash_original_field = "6A0F6B4B16B2364A628899EF7A6909C9", hash_generated_field = "2178E3078FC2C9C16B3710D31215720B")

    @SdkConstant(SdkConstantType.INTENT_CATEGORY)
    public static final String CATEGORY_MONKEY = "android.intent.category.MONKEY";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.487 -0400", hash_original_field = "121B826BD9B7F59E1DD347ECF4AFD032", hash_generated_field = "686B8018CC11BDB5C32BAAD279E5365B")

    public static final String CATEGORY_TEST = "android.intent.category.TEST";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.487 -0400", hash_original_field = "BB9055549E5CAB42F0006591A5C7021D", hash_generated_field = "E916DA7FE73FFB94CC2AEAE533EA23BF")

    public static final String CATEGORY_UNIT_TEST = "android.intent.category.UNIT_TEST";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.487 -0400", hash_original_field = "D1A6CD4CF824D88751232FB4E4AA0955", hash_generated_field = "F6FA58629915BFC7488711CA03CFE1DB")

    public static final String CATEGORY_SAMPLE_CODE = "android.intent.category.SAMPLE_CODE";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.487 -0400", hash_original_field = "7D4069A2BD82F7F403392E4C4FC1B778", hash_generated_field = "326BBB87AE978C10D0AC46A82D13B11D")

    @SdkConstant(SdkConstantType.INTENT_CATEGORY)
    public static final String CATEGORY_OPENABLE = "android.intent.category.OPENABLE";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.487 -0400", hash_original_field = "C8ABA7E7608B0A288D9065E881610226", hash_generated_field = "4A870B99349E92C8A35D53AF2630B90F")

    public static final String CATEGORY_FRAMEWORK_INSTRUMENTATION_TEST =
            "android.intent.category.FRAMEWORK_INSTRUMENTATION_TEST";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.487 -0400", hash_original_field = "801A128B6CA820DC7B9C45A39FD8EA31", hash_generated_field = "993F2D06C5CDD03C9EA7DCE8C1E78EC9")

    @SdkConstant(SdkConstantType.INTENT_CATEGORY)
    public static final String CATEGORY_CAR_DOCK = "android.intent.category.CAR_DOCK";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.487 -0400", hash_original_field = "5721889648B21D82BC396E47F3C179C1", hash_generated_field = "0E88B4F0151B540B4D837EFB418D0F48")

    @SdkConstant(SdkConstantType.INTENT_CATEGORY)
    public static final String CATEGORY_DESK_DOCK = "android.intent.category.DESK_DOCK";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.487 -0400", hash_original_field = "91E06774956F1982A73DEABE3ECF9EC2", hash_generated_field = "38EC7649AEEB239624A6794A7F07EA02")

    @SdkConstant(SdkConstantType.INTENT_CATEGORY)
    public static final String CATEGORY_LE_DESK_DOCK = "android.intent.category.LE_DESK_DOCK";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.487 -0400", hash_original_field = "850C5BB17AF80EE0C9ABA67A8DF5DA3B", hash_generated_field = "3F9D11FA3702BE350379D953C29C2F6F")

    @SdkConstant(SdkConstantType.INTENT_CATEGORY)
    public static final String CATEGORY_HE_DESK_DOCK = "android.intent.category.HE_DESK_DOCK";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.487 -0400", hash_original_field = "8167992C1DED360CAF126B13769A6D97", hash_generated_field = "11EB013E1E218EE05EC89A429A7652D4")

    @SdkConstant(SdkConstantType.INTENT_CATEGORY)
    public static final String CATEGORY_CAR_MODE = "android.intent.category.CAR_MODE";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.487 -0400", hash_original_field = "42EB30214146178B8E669F2F26DEB444", hash_generated_field = "9FD47E810741CAFE28D942DCFE763A51")

    @SdkConstant(SdkConstantType.INTENT_CATEGORY)
    public static final String CATEGORY_APP_BROWSER = "android.intent.category.APP_BROWSER";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.488 -0400", hash_original_field = "3E320411A65D0D17E23582F81126D1A8", hash_generated_field = "853D7E6DF6CA42B03E49C059E11DF6B2")

    @SdkConstant(SdkConstantType.INTENT_CATEGORY)
    public static final String CATEGORY_APP_CALCULATOR = "android.intent.category.APP_CALCULATOR";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.488 -0400", hash_original_field = "0CE17812B0F81E709253DBDEFC8BE3F4", hash_generated_field = "34490E78A1770B88FB00C51722A480EF")

    @SdkConstant(SdkConstantType.INTENT_CATEGORY)
    public static final String CATEGORY_APP_CALENDAR = "android.intent.category.APP_CALENDAR";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.488 -0400", hash_original_field = "F1B6F7AFD7750C14A86901EDE45B9E35", hash_generated_field = "23D411EC9BD34EB1956A7D20894B6F6B")

    @SdkConstant(SdkConstantType.INTENT_CATEGORY)
    public static final String CATEGORY_APP_CONTACTS = "android.intent.category.APP_CONTACTS";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.488 -0400", hash_original_field = "5145178B74321010501650DFF6BD231A", hash_generated_field = "B32849993CE54474DA658C00B93E9B06")

    @SdkConstant(SdkConstantType.INTENT_CATEGORY)
    public static final String CATEGORY_APP_EMAIL = "android.intent.category.APP_EMAIL";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.488 -0400", hash_original_field = "46E10F3C801D7FA6FC4D4A149FF4E221", hash_generated_field = "1AAD6D97E778061C4FC6B4579DBE698E")

    @SdkConstant(SdkConstantType.INTENT_CATEGORY)
    public static final String CATEGORY_APP_GALLERY = "android.intent.category.APP_GALLERY";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.488 -0400", hash_original_field = "CD5CA7EFF6B1D9CE5CE28720245188A3", hash_generated_field = "461AB4F858B20EDD3DC6D9BABFB25213")

    @SdkConstant(SdkConstantType.INTENT_CATEGORY)
    public static final String CATEGORY_APP_MAPS = "android.intent.category.APP_MAPS";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.488 -0400", hash_original_field = "62493FD84B3643DDC6E542F46296E291", hash_generated_field = "6E28A6D64C719D9421924F3B66DE5BA8")

    @SdkConstant(SdkConstantType.INTENT_CATEGORY)
    public static final String CATEGORY_APP_MESSAGING = "android.intent.category.APP_MESSAGING";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.488 -0400", hash_original_field = "3466FBB87701CE95C88BD77BD048111E", hash_generated_field = "7A01F1FB260B6B7E22C7231435E514F6")

    @SdkConstant(SdkConstantType.INTENT_CATEGORY)
    public static final String CATEGORY_APP_MUSIC = "android.intent.category.APP_MUSIC";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.488 -0400", hash_original_field = "805C80ACAE398088649F4391EBCDEAA8", hash_generated_field = "D84938735789F63BB5A99B3994808DF1")

    public static final String EXTRA_TEMPLATE = "android.intent.extra.TEMPLATE";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.488 -0400", hash_original_field = "26D8AC7B531CFE63141F4FC7EE777F86", hash_generated_field = "72214008F2D28B6F2C57EBF8F3F522E8")

    public static final String EXTRA_TEXT = "android.intent.extra.TEXT";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.488 -0400", hash_original_field = "A1039487987AAB30A86E10F3EE3BF0B7", hash_generated_field = "EC4454CE33F6CC89842034B94C293389")

    public static final String EXTRA_STREAM = "android.intent.extra.STREAM";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.488 -0400", hash_original_field = "A1DAFAD88FD8893754E31102FBC95018", hash_generated_field = "EBFD2B12F95245B3FBC9DF7A00777B71")

    public static final String EXTRA_EMAIL       = "android.intent.extra.EMAIL";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.488 -0400", hash_original_field = "236E94528EC51D76CCBAD14C63346C42", hash_generated_field = "8AFD20100EA68B345A45C08A01ECDB1C")

    public static final String EXTRA_CC       = "android.intent.extra.CC";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.489 -0400", hash_original_field = "E0D2FEE44BED77C32E0577BBBE70AE03", hash_generated_field = "248F5D1EC476962B448213113152C27D")

    public static final String EXTRA_BCC      = "android.intent.extra.BCC";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.489 -0400", hash_original_field = "0AF1E62A76EFEC85FB0811F0233FB7EE", hash_generated_field = "419F13F40D6F3539A0ADBB0EE25BDC61")

    public static final String EXTRA_SUBJECT  = "android.intent.extra.SUBJECT";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.489 -0400", hash_original_field = "3BE3E4C478716309FBA51637E3489AD3", hash_generated_field = "6C385524243DA13629D46DD4A076B2BE")

    public static final String EXTRA_INTENT = "android.intent.extra.INTENT";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.489 -0400", hash_original_field = "A4C173AD9584C3F44AF2B2D00D5E1CCD", hash_generated_field = "442A91F2FCA42809657F776F47AC14A2")

    public static final String EXTRA_TITLE = "android.intent.extra.TITLE";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.489 -0400", hash_original_field = "DCD538997D844DEBDBE7BA551E9D53AD", hash_generated_field = "83F4ECB331C2C4D31F6BF841AA493392")

    public static final String EXTRA_INITIAL_INTENTS = "android.intent.extra.INITIAL_INTENTS";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.489 -0400", hash_original_field = "05E56155D877CA1DFA30D1E6662DCB9F", hash_generated_field = "B22AF3F2DD8C690301A6C16272B182E6")

    public static final String EXTRA_KEY_EVENT = "android.intent.extra.KEY_EVENT";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.489 -0400", hash_original_field = "23A029E8E0E49DF4E625ED11FB872C44", hash_generated_field = "5A5722737DD73618327545E77C22EC76")

    public static final String EXTRA_KEY_CONFIRM = "android.intent.extra.KEY_CONFIRM";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.489 -0400", hash_original_field = "6739A1282C0BFAC9FAA22C7E02A0DFC5", hash_generated_field = "86E9F818118C4911260709A9CE25ABBF")

    public static final String EXTRA_DONT_KILL_APP = "android.intent.extra.DONT_KILL_APP";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.489 -0400", hash_original_field = "28D0ABEED076AF655D0753FE28CC8682", hash_generated_field = "250F8F3445ECA42F404D7699D0878462")

    public static final String EXTRA_PHONE_NUMBER = "android.intent.extra.PHONE_NUMBER";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.489 -0400", hash_original_field = "75903292DB8BE5F6059A4374F19B6C15", hash_generated_field = "784764F75FCAF4D594484BAE3D08E782")

    public static final String EXTRA_UID = "android.intent.extra.UID";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.489 -0400", hash_original_field = "1BEC945D1ED6A71A88B57B19F482154C", hash_generated_field = "DA292F34D2C63F59038060862D3FBD56")

    public static final String EXTRA_PACKAGES = "android.intent.extra.PACKAGES";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.489 -0400", hash_original_field = "525DD57428FAA64F1A5AD020F1B60AFB", hash_generated_field = "13D45ED3B0C6FB86F2CDE61794B5F803")

    public static final String EXTRA_DATA_REMOVED = "android.intent.extra.DATA_REMOVED";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.489 -0400", hash_original_field = "1BF64067F81CFE47D11E57C5DF299AF9", hash_generated_field = "418341504F0A4D6308A9E99137AEAD7B")

    public static final String EXTRA_REPLACING = "android.intent.extra.REPLACING";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.489 -0400", hash_original_field = "10AF3F88A47C6BF509A46733829DED94", hash_generated_field = "A8F2D11013AECF3F2B67B1FBE5E632E8")

    public static final String EXTRA_ALARM_COUNT = "android.intent.extra.ALARM_COUNT";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.490 -0400", hash_original_field = "CED8E449BC449F97CE74B6548886F74C", hash_generated_field = "117449B583EA94D1C241A664ADE13004")

    public static final String EXTRA_DOCK_STATE = "android.intent.extra.DOCK_STATE";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.490 -0400", hash_original_field = "954A396C5EF2F4F5B23303CB14553104", hash_generated_field = "51DD9310B52641CEBF8E5912ABBF09BB")

    public static final int EXTRA_DOCK_STATE_UNDOCKED = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.490 -0400", hash_original_field = "BD3B2D3FC4175BA4AC68D02FA4554729", hash_generated_field = "57A27A4EFB33D3F5C84CA5A20B8F39B3")

    public static final int EXTRA_DOCK_STATE_DESK = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.490 -0400", hash_original_field = "BD82C25B13664796D6F4827E8F5D51C5", hash_generated_field = "75F49C97684FECC9E5C28B82E7E20EBF")

    public static final int EXTRA_DOCK_STATE_CAR = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.490 -0400", hash_original_field = "13489C8700DF644D9358E7066034612E", hash_generated_field = "F7634A037B9D5564993679CDF49FD88B")

    public static final int EXTRA_DOCK_STATE_LE_DESK = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.490 -0400", hash_original_field = "B9B581372489638C5D78BEEF77A03848", hash_generated_field = "6EB3D92262E3C4391652FCAA2CEBA4A1")

    public static final int EXTRA_DOCK_STATE_HE_DESK = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.490 -0400", hash_original_field = "A53EF334B862EBF7F93E95FF74814FCB", hash_generated_field = "848D2959548644F6D0600879EF0668A2")

    public static final String METADATA_DOCK_HOME = "android.dock_home";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.490 -0400", hash_original_field = "091C70F0ABBE30F039A8673A81C8F084", hash_generated_field = "9274BDF219627A5BD62F1500834D5081")

    public static final String EXTRA_BUG_REPORT = "android.intent.extra.BUG_REPORT";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.490 -0400", hash_original_field = "02D961C971B11906D9492EAC79B33FD2", hash_generated_field = "58A65C26300F59D945079081B32418DA")

    public static final String EXTRA_REMOTE_INTENT_TOKEN =
            "android.intent.extra.remote_intent_token";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.490 -0400", hash_original_field = "9A01FC0A3646C3EAD9E142CC732AB98B", hash_generated_field = "E39BA7649A125B42097E11ABF6A59B91")

    @Deprecated public static final String EXTRA_CHANGED_COMPONENT_NAME =
            "android.intent.extra.changed_component_name";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.490 -0400", hash_original_field = "86F69B83F2A7C6D2AC4979482E9A62E6", hash_generated_field = "1396139177598651F4FE696440AA6B60")

    public static final String EXTRA_CHANGED_COMPONENT_NAME_LIST =
            "android.intent.extra.changed_component_name_list";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.490 -0400", hash_original_field = "FDA69BBD39712C3E27E462661D93CE75", hash_generated_field = "9F6BB52BB136081B0B5B704137151D62")

    public static final String EXTRA_CHANGED_PACKAGE_LIST =
            "android.intent.extra.changed_package_list";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.490 -0400", hash_original_field = "5B90A66309396174E4747C13B353BAE4", hash_generated_field = "0A835C4E438F2FB3E3F07E556FA3173A")

    public static final String EXTRA_CHANGED_UID_LIST =
            "android.intent.extra.changed_uid_list";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.490 -0400", hash_original_field = "2F4FBD002879C06D2D00B86E0322059C", hash_generated_field = "CE2CE80B4644D04179C8E3EAC591C752")

    public static final String EXTRA_CLIENT_LABEL =
            "android.intent.extra.client_label";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.491 -0400", hash_original_field = "545743511ACD01A6F78290186C426603", hash_generated_field = "7990A58774E5328794603E8DA07B84D6")

    public static final String EXTRA_CLIENT_INTENT =
            "android.intent.extra.client_intent";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.491 -0400", hash_original_field = "83824871407F038EBBD8981DB142BC94", hash_generated_field = "32EF8D5E473BF09D7DFE2474A075B3EF")

    public static final String EXTRA_LOCAL_ONLY =
        "android.intent.extra.LOCAL_ONLY";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.491 -0400", hash_original_field = "BC0657EC269830B71A283FD515E1D281", hash_generated_field = "51862CBCF8D4640389DEA37A774D56AE")

    public static final int FLAG_GRANT_READ_URI_PERMISSION = 0x00000001;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.491 -0400", hash_original_field = "7051451C73C1ABB33910546B483789B4", hash_generated_field = "AD11D27A7135AF27D29F8A1800E38B48")

    public static final int FLAG_GRANT_WRITE_URI_PERMISSION = 0x00000002;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.491 -0400", hash_original_field = "FFBFA876EBFFC162F8D7EF90769E790E", hash_generated_field = "F5144D0DD2B503AE068147CFB8AF3E20")

    public static final int FLAG_FROM_BACKGROUND = 0x00000004;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.491 -0400", hash_original_field = "0D92A15C2A3E9F421BDB2C1CE6D4FC76", hash_generated_field = "4992800D2B3327EB8ABD9B8392D76E59")

    public static final int FLAG_DEBUG_LOG_RESOLUTION = 0x00000008;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.491 -0400", hash_original_field = "7418B2D0649AC60F9EF55DC969249726", hash_generated_field = "F0503BB7715C67922785A00785804343")

    public static final int FLAG_EXCLUDE_STOPPED_PACKAGES = 0x00000010;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.491 -0400", hash_original_field = "BCF02393735EE15A1FE8B6F6109B2DC4", hash_generated_field = "6BF870212E33BF54D2F47B772F7E1D4D")

    public static final int FLAG_INCLUDE_STOPPED_PACKAGES = 0x00000020;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.491 -0400", hash_original_field = "8B546A30AB14489B8FFDEC1B666587BC", hash_generated_field = "2C482F373AA08BD3E8BAE66D0ABEB4A1")

    public static final int FLAG_ACTIVITY_NO_HISTORY = 0x40000000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.491 -0400", hash_original_field = "359B4835F93ACBCAFF71741A880AED3E", hash_generated_field = "F1C3991F7C5363979EB2F7071FC1B1E7")

    public static final int FLAG_ACTIVITY_SINGLE_TOP = 0x20000000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.491 -0400", hash_original_field = "FB39F645C4D630026BD55D59A1AC611D", hash_generated_field = "CB2EB43571F9F913DD85855F2A62F676")

    public static final int FLAG_ACTIVITY_NEW_TASK = 0x10000000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.491 -0400", hash_original_field = "2EF2E7C3F1F0E7AA90FAD9586221976A", hash_generated_field = "5331C0D5175D1B442B1E11194633885C")

    public static final int FLAG_ACTIVITY_MULTIPLE_TASK = 0x08000000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.491 -0400", hash_original_field = "9E1EFE5434DC4981642B64A89E92C518", hash_generated_field = "D15C6C6162723C7D62F659062880F6F9")

    public static final int FLAG_ACTIVITY_CLEAR_TOP = 0x04000000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.491 -0400", hash_original_field = "3E2D3EFE1886ABFC906946DF47538599", hash_generated_field = "F049434BC355C895C7B98BCE57D6923A")

    public static final int FLAG_ACTIVITY_FORWARD_RESULT = 0x02000000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.492 -0400", hash_original_field = "90968E170D46575A3A7B7892BC9AA882", hash_generated_field = "A963C95BDF18D2B0A0A3417D1EB14C63")

    public static final int FLAG_ACTIVITY_PREVIOUS_IS_TOP = 0x01000000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.492 -0400", hash_original_field = "8E831E15B9AD9EEBE1BB200162C979CE", hash_generated_field = "93C6E464C79835E60A724A0F138B2E5A")

    public static final int FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS = 0x00800000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.492 -0400", hash_original_field = "88D0F59312DAEB7DBBE760B4EE938E30", hash_generated_field = "475E818BB383C15D3EB34352066AF070")

    public static final int FLAG_ACTIVITY_BROUGHT_TO_FRONT = 0x00400000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.492 -0400", hash_original_field = "47358C93E57A26EF2A13AB4B32FBBE17", hash_generated_field = "09C09520072C3FC5B6B5D304280BB98B")

    public static final int FLAG_ACTIVITY_RESET_TASK_IF_NEEDED = 0x00200000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.492 -0400", hash_original_field = "BDDED4D3FA5833F4031180DDBB7C3A8A", hash_generated_field = "E6A8EC3B88D6C8ADD31C990D62C7170C")

    public static final int FLAG_ACTIVITY_LAUNCHED_FROM_HISTORY = 0x00100000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.492 -0400", hash_original_field = "0CC69F9ADF0C27361F82CBEE8255AA54", hash_generated_field = "0A9BB1EBF39780BBC96BF9154BADA771")

    public static final int FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET = 0x00080000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.492 -0400", hash_original_field = "9B0A01E5E2723B343A323ECEF6EB02EB", hash_generated_field = "BBB8D1C2213AA3D2546EE97A96B54CB3")

    public static final int FLAG_ACTIVITY_NO_USER_ACTION = 0x00040000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.492 -0400", hash_original_field = "E6D5DB8077429B364EE46BB3BAEE5FC3", hash_generated_field = "CD635E17DCA336DCD58C5F1450A5987B")

    public static final int FLAG_ACTIVITY_REORDER_TO_FRONT = 0X00020000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.492 -0400", hash_original_field = "9B2F27E6148CE14C0433775C4D784896", hash_generated_field = "2D9D2B18DAADEC730FD6599A8ACA6995")

    public static final int FLAG_ACTIVITY_NO_ANIMATION = 0X00010000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.492 -0400", hash_original_field = "20925229C9ECAA8CDEA944C0BF02149A", hash_generated_field = "486F83A3C19D70714934307A944E56C2")

    public static final int FLAG_ACTIVITY_CLEAR_TASK = 0X00008000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.492 -0400", hash_original_field = "2CC258568DD3D806AEEB48062AB5BE1E", hash_generated_field = "3DDA11574C4AF819E971AFE75A5CC07F")

    public static final int FLAG_ACTIVITY_TASK_ON_HOME = 0X00004000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.492 -0400", hash_original_field = "40D14A1AB30110CD3AB8173DA521B51D", hash_generated_field = "9E9DE382F25B3D58CC45D1E0C5D1436F")

    public static final int FLAG_RECEIVER_REGISTERED_ONLY = 0x40000000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.492 -0400", hash_original_field = "4F5BD59FD57D224EF013DBDD84B27DCB", hash_generated_field = "8E1ED2FC53376B3E78D1743C1F51D866")

    public static final int FLAG_RECEIVER_REPLACE_PENDING = 0x20000000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.492 -0400", hash_original_field = "5F72861FE2E2A3B1733DB4FA41011078", hash_generated_field = "7603B3041648CE612B1F62C28DF51220")

    public static final int FLAG_RECEIVER_REGISTERED_ONLY_BEFORE_BOOT = 0x10000000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.492 -0400", hash_original_field = "D9A24967D145EE204E5F678A2D23710E", hash_generated_field = "4D515443C5DB3D74B79815278456FCD3")

    public static final int FLAG_RECEIVER_BOOT_UPGRADE = 0x08000000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.493 -0400", hash_original_field = "3E241774911B3E81F1C0C8546C5449BB", hash_generated_field = "FD626475D9F6D6885F7E9DE54C1764F4")

    public static final int IMMUTABLE_FLAGS =
            FLAG_GRANT_READ_URI_PERMISSION
            | FLAG_GRANT_WRITE_URI_PERMISSION;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.493 -0400", hash_original_field = "13C9A3DA8736EDFFB7A6AFEE0BC01DD6", hash_generated_field = "1692965D76F6FCDDE4F31AC57A385A83")

    public static final int URI_INTENT_SCHEME = 1<<0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.493 -0400", hash_original_field = "F66119B16D5ADE52FA6F9F421EDF5D08", hash_generated_field = "63F981009E9BE73A1613A3A86CDA35C4")

    public static final int FILL_IN_ACTION = 1<<0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.493 -0400", hash_original_field = "6148B3E448E59D56502B89E19BB0A504", hash_generated_field = "467AD345159485AE2F5ED6775DC51B27")

    public static final int FILL_IN_DATA = 1<<1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.493 -0400", hash_original_field = "5365BA328C38E80FE195301EC5B759BC", hash_generated_field = "E89FFA2B091BAA2212245B31F564CFFF")

    public static final int FILL_IN_CATEGORIES = 1<<2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.493 -0400", hash_original_field = "78907C6FCD24B0D41AC9FFB1F8B13204", hash_generated_field = "6A3A0FFA6E425DF959306D11B15FF92D")

    public static final int FILL_IN_COMPONENT = 1<<3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.493 -0400", hash_original_field = "19A36D6480C50FDA6A30F8381EBA3C84", hash_generated_field = "363CC3E98D7D1AC7FC1E2718D2D54631")

    public static final int FILL_IN_PACKAGE = 1<<4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.493 -0400", hash_original_field = "8290D065BDE0155AB9AA8FBBE8556608", hash_generated_field = "87B57C3E1EED611456B2BA9EAB493CAA")

    public static final int FILL_IN_SOURCE_BOUNDS = 1<<5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.493 -0400", hash_original_field = "8FF3A165F0D3710C235076AB22D9B008", hash_generated_field = "F1670B3FCB0D6CFDDC829822B3B96A6F")

    public static final int FILL_IN_SELECTOR = 1<<6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.493 -0400", hash_original_field = "D14178DBCD458ABEE4FEAD50EBCFE74B", hash_generated_field = "B872AD5D6A6EEC2D35FED959BF1EC3BA")

    public static final Parcelable.Creator<Intent> CREATOR
            = new Parcelable.Creator<Intent>() {
        @DSModeled(DSC.SPEC)
        public Intent createFromParcel(Parcel in) {
            return new Intent(in);
        }
        @DSModeled(DSC.SAFE)
        public Intent[] newArray(int size) {
            return new Intent[size];
        }
    };
    
}

