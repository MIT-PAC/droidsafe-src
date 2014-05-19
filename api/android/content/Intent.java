package android.content;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.util.Log;
import java.util.Map;
import java.util.HashMap;
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

    /**
     * Convenience function for creating a {@link #ACTION_CHOOSER} Intent.
     *
     * @param target The Intent that the user will be selecting an activity
     * to perform.
     * @param title Optional title that will be displayed in the chooser.
     * @return Return a new Intent object that you can hand to
     * {@link Context#startActivity(Intent) Context.startActivity()} and
     * related methods.
     */
    @DSComment("Potential intent to trigger other processing")
    @DSSpec(DSCat.INTENT_EXCHANGE)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:08.739 -0500", hash_original_method = "43F6EAB342082D2390B2ECED1CCBA8B1", hash_generated_method = "A816FD59E9987469E7B74430ED69774F")
    
public static Intent createChooser(Intent target, CharSequence title) {
        Intent intent = new Intent(ACTION_CHOOSER);
        intent.putExtra(EXTRA_INTENT, target);
        if (title != null) {
            intent.putExtra(EXTRA_TITLE, title);
        }
        return intent;
    }

    /**
     * Create an intent to launch the main (root) activity of a task.  This
     * is the Intent that is started when the application's is launched from
     * Home.  For anything else that wants to launch an application in the
     * same way, it is important that they use an Intent structured the same
     * way, and can use this function to ensure this is the case.
     *
     * <p>The returned Intent has the given Activity component as its explicit
     * component, {@link #ACTION_MAIN} as its action, and includes the
     * category {@link #CATEGORY_LAUNCHER}.  This does <em>not</em> have
     * {@link #FLAG_ACTIVITY_NEW_TASK} set, though typically you will want
     * to do that through {@link #addFlags(int)} on the returned Intent.
     *
     * @param mainActivity The main activity component that this Intent will
     * launch.
     * @return Returns a newly created Intent that can be used to launch the
     * activity as a main application entry.
     *
     * @see #setClass
     * @see #setComponent
     */
    @DSComment("Potential intent to trigger other processing")
    @DSSpec(DSCat.INTENT_EXCHANGE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.304 -0500", hash_original_method = "7AED2B47C306BAB7F7D451618997A7BB", hash_generated_method = "FB6DA85F5D45B429213A71D4678F3259")
    
public static Intent makeMainActivity(ComponentName mainActivity) {
        Intent intent = new Intent(ACTION_MAIN);
        intent.setComponent(mainActivity);
        intent.addCategory(CATEGORY_LAUNCHER);
        return intent;
    }

    /**
     * Make an Intent for the main activity of an application, without
     * specifying a specific activity to run but giving a selector to find
     * the activity.  This results in a final Intent that is structured
     * the same as when the application is launched from
     * Home.  For anything else that wants to launch an application in the
     * same way, it is important that they use an Intent structured the same
     * way, and can use this function to ensure this is the case.
     *
     * <p>The returned Intent has {@link #ACTION_MAIN} as its action, and includes the
     * category {@link #CATEGORY_LAUNCHER}.  This does <em>not</em> have
     * {@link #FLAG_ACTIVITY_NEW_TASK} set, though typically you will want
     * to do that through {@link #addFlags(int)} on the returned Intent.
     *
     * @param selectorAction The action name of the Intent's selector.
     * @param selectorCategory The name of a category to add to the Intent's
     * selector.
     * @return Returns a newly created Intent that can be used to launch the
     * activity as a main application entry.
     *
     * @see #setSelector(Intent)
     */
    @DSComment("Potential intent to trigger other processing")
    @DSSpec(DSCat.INTENT_EXCHANGE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.307 -0500", hash_original_method = "D6FBF20876F918111C6430036A818C6A", hash_generated_method = "2A2960869EF2FB28477E1815FEAAEC84")
    
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

    /**
     * Make an Intent that can be used to re-launch an application's task
     * in its base state.  This is like {@link #makeMainActivity(ComponentName)},
     * but also sets the flags {@link #FLAG_ACTIVITY_NEW_TASK} and
     * {@link #FLAG_ACTIVITY_CLEAR_TASK}.
     *
     * @param mainActivity The activity component that is the root of the
     * task; this is the activity that has been published in the application's
     * manifest as the main launcher icon.
     *
     * @return Returns a newly created Intent that can be used to relaunch the
     * activity's task in its root state.
     */
    @DSComment("Potential intent to trigger other processing")
    @DSSpec(DSCat.INTENT_EXCHANGE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.310 -0500", hash_original_method = "A6877A9D43804E19B3305D0B2E659CAC", hash_generated_method = "C8346CB9F8080D74631221AA3292232B")
    
public static Intent makeRestartActivityTask(ComponentName mainActivity) {
        Intent intent = makeMainActivity(mainActivity);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK
                | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        return intent;
    }

    /**
     * Call {@link #parseUri} with 0 flags.
     * @deprecated Use {@link #parseUri} instead.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.312 -0500", hash_original_method = "98F9DED50B2CB0429925771F0A25EF9A", hash_generated_method = "5EA9CB4B5480139454B9912278C7C60B")
    
@Deprecated
    public static Intent getIntent(String uri) throws URISyntaxException {
        return parseUri(uri, 0);
    }

    /**
     * Create an intent from a URI.  This URI may encode the action,
     * category, and other intent fields, if it was returned by
     * {@link #toUri}.  If the Intent was not generate by toUri(), its data
     * will be the entire URI and its action will be ACTION_VIEW.
     *
     * <p>The URI given here must not be relative -- that is, it must include
     * the scheme and full path.
     *
     * @param uri The URI to turn into an Intent.
     * @param flags Additional processing flags.  Either 0 or
     * {@link #URI_INTENT_SCHEME}.
     *
     * @return Intent The newly created Intent object.
     *
     * @throws URISyntaxException Throws URISyntaxError if the basic URI syntax
     * it bad (as parsed by the Uri class) or the Intent data within the
     * URI is invalid.
     *
     * @see #toUri
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.317 -0500", hash_original_method = "C5B32AAE1FE2D64E6A622392E0301DD1", hash_generated_method = "5BD37E3F1971BB21378F20BDE5CC3A6B")
    
public static Intent parseUri(String uri, int flags) throws URISyntaxException {
        int i = 0;
        try {
            // Validate intent scheme for if requested.
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

            // simple case
            i = uri.lastIndexOf("#");
            if (i == -1) return new Intent(ACTION_VIEW, Uri.parse(uri));

            // old format Intent URI
            if (!uri.startsWith("#Intent;", i)) return getIntentOld(uri);

            // new format
            Intent intent = new Intent(ACTION_VIEW);
            Intent baseIntent = intent;

            // fetch data part, if present
            String data = i >= 0 ? uri.substring(0, i) : null;
            String scheme = null;
            i += "#Intent;".length();

            // loop over contents of Intent, all name=value;
            while (!uri.startsWith("end", i)) {
                int eq = uri.indexOf('=', i);
                if (eq < 0) eq = i-1;
                int semi = uri.indexOf(';', i);
                String value = eq < semi ? Uri.decode(uri.substring(eq + 1, semi)) : "";

                // action
                if (uri.startsWith("action=", i)) {
                    intent.setAction(value);
                }

                // categories
                else if (uri.startsWith("category=", i)) {
                    intent.addCategory(value);
                }

                // type
                else if (uri.startsWith("type=", i)) {
                    intent.mType = value;
                }

                // launch flags
                else if (uri.startsWith("launchFlags=", i)) {
                    intent.mFlags = Integer.decode(value).intValue();
                }

                // package
                else if (uri.startsWith("package=", i)) {
                    intent.mPackage = value;
                }

                // component
                else if (uri.startsWith("component=", i)) {
                    intent.mComponent = ComponentName.unflattenFromString(value);
                }

                // scheme
                else if (uri.startsWith("scheme=", i)) {
                    scheme = value;
                }

                // source bounds
                else if (uri.startsWith("sourceBounds=", i)) {
                    intent.mSourceBounds = Rect.unflattenFromString(value);
                }

                // selector
                else if (semi == (i+3) && uri.startsWith("SEL", i)) {
                    intent = new Intent();
                }

                // extra
                else {
                    String key = Uri.decode(uri.substring(i + 2, eq));
                    // create Bundle if it doesn't already exist
                    if (intent.mExtras == null) intent.mExtras = new HashMap<String, Object>();// Bundle();
                    Map<String,Object> b = intent.mExtras;

                    // add EXTRA
                    if      (uri.startsWith("S.", i)) b.put(key, value);
                    else if (uri.startsWith("B.", i)) b.put(key, Boolean.parseBoolean(value));
                    else if (uri.startsWith("b.", i)) b.put(key, Byte.parseByte(value));
                    else if (uri.startsWith("c.", i)) b.put(key, value.charAt(0));
                    else if (uri.startsWith("d.", i)) b.put(key, Double.parseDouble(value));
                    else if (uri.startsWith("f.", i)) b.put(key, Float.parseFloat(value));
                    else if (uri.startsWith("i.", i)) b.put(key, Integer.parseInt(value));
                    else if (uri.startsWith("l.", i)) b.put(key, Long.parseLong(value));
                    else if (uri.startsWith("s.", i)) b.put(key, Short.parseShort(value));
                    else throw new URISyntaxException(uri, "unknown EXTRA type", i);
                }

                // move to the next item
                i = semi + 1;
            }

            if (intent != baseIntent) {
                // The Intent had a selector; fix it up.
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

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.322 -0500", hash_original_method = "B4C415433E77631C2B3B21C89A688CF9", hash_generated_method = "A66E1A0B10FBA6D2E99E6541B86AC408")
    
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
                    // fetch the key value
                    int j = uri.indexOf('=', i);
                    if (j <= i + 1 || i >= closeParen) {
                        throw new URISyntaxException(uri, "EXTRA missing '='", i);
                    }
                    char type = uri.charAt(i);
                    i++;
                    String key = uri.substring(i, j);
                    i = j + 1;

                    // get type-value
                    j = uri.indexOf('!', i);
                    if (j == -1 || j >= closeParen) j = closeParen;
                    if (i >= j) throw new URISyntaxException(uri, "EXTRA missing '!'", i);
                    String value = uri.substring(i, j);
                    i = j;

                    // create Bundle if it doesn't already exist
                    if (intent.mExtras == null) intent.mExtras = new HashMap<String, Object>();//new Bundle();

                    // add item to bundle
                    try {
                        switch (type) {
                            case 'S':
                                intent.mExtras.put(key, Uri.decode(value));
                                break;
                            case 'B':
                                intent.mExtras.put(key, Boolean.parseBoolean(value));
                                break;
                            case 'b':
                                intent.mExtras.put(key, Byte.parseByte(value));
                                break;
                            case 'c':
                                intent.mExtras.put(key, Uri.decode(value).charAt(0));
                                break;
                            case 'd':
                                intent.mExtras.put(key, Double.parseDouble(value));
                                break;
                            case 'f':
                                intent.mExtras.put(key, Float.parseFloat(value));
                                break;
                            case 'i':
                                intent.mExtras.put(key, Integer.parseInt(value));
                                break;
                            case 'l':
                                intent.mExtras.put(key, Long.parseLong(value));
                                break;
                            case 's':
                                intent.mExtras.put(key, Short.parseShort(value));
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
                // By default, if no action is specified, then use VIEW.
                intent.mAction = ACTION_VIEW;
            }

        } else {
            intent = new Intent(ACTION_VIEW, Uri.parse(uri));
        }

        return intent;
    }

    /**
     * Parses the "intent" element (and its children) from XML and instantiates
     * an Intent object.  The given XML parser should be located at the tag
     * where parsing should start (often named "intent"), from which the
     * basic action, data, type, and package and class name will be
     * retrieved.  The function will then parse in to any child elements,
     * looking for <category android:name="xxx"> tags to add categories and
     * <extra android:name="xxx" android:value="yyy"> to attach extra data
     * to the intent.
     *
     * @param resources The Resources to use when inflating resources.
     * @param parser The XML parser pointing at an "intent" tag.
     * @param attrs The AttributeSet interface for retrieving extended
     * attribute data at the current <var>parser</var> location.
     * @return An Intent object matching the XML data.
     * @throws XmlPullParserException If there was an XML parsing error.
     * @throws IOException If there was an I/O error.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.631 -0500", hash_original_method = "EA5BCA16215C9C34CA5AC6D2E9340E92", hash_generated_method = "8BCFD14ABAF0729FF1A1792BB1869177")
    
public static Intent parseIntent(Resources resources, XmlPullParser parser, AttributeSet attrs)
            throws XmlPullParserException, IOException {
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
                    intent.mExtras = new HashMap<String,Object>();
                }
                //DroidSafe what to do here?
                //resources.parseBundleExtra("extra", attrs, intent.mExtras);
                XmlUtils.skipCurrentTag(parser);

            } else {
                XmlUtils.skipCurrentTag(parser);
            }
        }

        return intent;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:08.681 -0500", hash_original_field = "F05BE714296D55C43D1868783FE5DA69", hash_generated_field = "C18755792B880704680D319C2E87C29A")

    // ---------------------------------------------------------------------
    // Standard intent activity actions (see action variable).

    /**
     *  Activity Action: Start as a main entry point, does not expect to
     *  receive data.
     *  <p>Input: nothing
     *  <p>Output: nothing
     */
    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_MAIN = "android.intent.action.MAIN";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:08.683 -0500", hash_original_field = "B565198A4DF7FC0FFE5CE2A8AC662CCF", hash_generated_field = "B4FC4AC4434AF0988895645F8113BE4D")

    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_VIEW = "android.intent.action.VIEW";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:08.686 -0500", hash_original_field = "2F7A44DAE94DA2D120B6C5FB05454CEB", hash_generated_field = "31B7CB6CE826B970ED2FBCA1E6169A2F")

    public static final String ACTION_DEFAULT = ACTION_VIEW;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:08.688 -0500", hash_original_field = "16E2B2746EE0BB1EDE0C689A3AB95ABC", hash_generated_field = "B7771E23284E70ECBAF10CF8D998AB41")

    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_ATTACH_DATA = "android.intent.action.ATTACH_DATA";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:08.692 -0500", hash_original_field = "C903F7169DEF4D09382301E26CB6A593", hash_generated_field = "44755A5ACF130CF4CF6E8287050DF9EB")

    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_EDIT = "android.intent.action.EDIT";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:08.694 -0500", hash_original_field = "4D7CAD0E74B69A33DA6648992879667D", hash_generated_field = "83D15D19A3398819C14A6C83965BAE99")

    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_INSERT_OR_EDIT = "android.intent.action.INSERT_OR_EDIT";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:08.696 -0500", hash_original_field = "7AB42E3386843A7F3068EF57D4F75E37", hash_generated_field = "D9B827E0A1E1DCD9F132DDCC7FC46859")

    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_PICK = "android.intent.action.PICK";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:08.699 -0500", hash_original_field = "DBDEA6BAB880E2A35EAE46A837EB9FD1", hash_generated_field = "993347C266428903DAA186C844B97694")

    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_CREATE_SHORTCUT = "android.intent.action.CREATE_SHORTCUT";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:08.701 -0500", hash_original_field = "6C2516A7969773957373CDF12481D720", hash_generated_field = "B6ADBC69477081B9FC2AB0FFF4840082")

    public static final String EXTRA_SHORTCUT_INTENT = "android.intent.extra.shortcut.INTENT";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:08.703 -0500", hash_original_field = "BB0C59FE8E836C366EC3B6AA87DAFD8A", hash_generated_field = "F8A802D90F8F3D251F6BD332F302EAF0")

    public static final String EXTRA_SHORTCUT_NAME = "android.intent.extra.shortcut.NAME";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:08.706 -0500", hash_original_field = "854591CB400D251BE3AE9BCDB34D824B", hash_generated_field = "0E7C24C264DE9B0116CDE392569F9C32")

    public static final String EXTRA_SHORTCUT_ICON = "android.intent.extra.shortcut.ICON";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:08.708 -0500", hash_original_field = "00DFD4D210485819E77F19726CA392C4", hash_generated_field = "27DE92A0E7A6C6975AF7B85FFD1372DA")

    public static final String EXTRA_SHORTCUT_ICON_RESOURCE =
            "android.intent.extra.shortcut.ICON_RESOURCE";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:08.736 -0500", hash_original_field = "2D69DA90CB5C20ED63629079657B61D3", hash_generated_field = "B903FA9C641B07A1FD05DF6C900DDE87")

    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_CHOOSER = "android.intent.action.CHOOSER";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:08.741 -0500", hash_original_field = "EF5E4677D2C780A2DA4404E540DABF77", hash_generated_field = "224E520888804F5E9A6A84B1429FF6C0")

    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_GET_CONTENT = "android.intent.action.GET_CONTENT";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:08.744 -0500", hash_original_field = "C04AC95306E0F7BE59C84282CB469342", hash_generated_field = "BA8AC554D2E7958FEB87F665CB187200")

    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_DIAL = "android.intent.action.DIAL";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:08.746 -0500", hash_original_field = "847F9216ACBC84D76A185CD24CD5B4C4", hash_generated_field = "156D2611F9948DFBC8BEB851A4F2D865")

    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_CALL = "android.intent.action.CALL";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:08.748 -0500", hash_original_field = "03153D7FDBF8D6AE8B9D7B02C7585E6D", hash_generated_field = "C7F702A15124025B52F4AE9D5F1D8AD8")

    public static final String ACTION_CALL_EMERGENCY = "android.intent.action.CALL_EMERGENCY";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:08.751 -0500", hash_original_field = "1C3BA6474BA787266FC43502ADD56205", hash_generated_field = "B84BCDAAA8978FF3F9970DBD3472E33A")

    public static final String ACTION_CALL_PRIVILEGED = "android.intent.action.CALL_PRIVILEGED";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:08.754 -0500", hash_original_field = "9F073E36F83E9CC7D9CF589143C05A1E", hash_generated_field = "3EB1F7AB454572370D3425BC3C27609E")

    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_SENDTO = "android.intent.action.SENDTO";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:08.757 -0500", hash_original_field = "4AFFA38B29BD773807FECD2F55A068CD", hash_generated_field = "1A00662632D62B278530F5AAFC144039")

    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_SEND = "android.intent.action.SEND";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:08.759 -0500", hash_original_field = "B50A931FADAC601279F6A0792A30F680", hash_generated_field = "20049E89E82A72A563C5146D910079EA")

    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_SEND_MULTIPLE = "android.intent.action.SEND_MULTIPLE";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:08.762 -0500", hash_original_field = "B74F05DE70136C71FA031275A1B1BE17", hash_generated_field = "BCE6BAF3569F0CD9A5E69A60137D5C81")

    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_ANSWER = "android.intent.action.ANSWER";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:08.764 -0500", hash_original_field = "177574181B0ED0ED4F7FA2014FF19297", hash_generated_field = "0C3014CD7256D614A3FE7AD4340BF556")

    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_INSERT = "android.intent.action.INSERT";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:08.768 -0500", hash_original_field = "3A10466010CC95A5C0A5B2FABE381482", hash_generated_field = "B54448451E8A597131F91F0578FB99AD")

    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_PASTE = "android.intent.action.PASTE";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:08.770 -0500", hash_original_field = "C3D61B3D6CF871A084549B74465DAB18", hash_generated_field = "DF7BAB5523E713ECFAD35C76FE516A25")

    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_DELETE = "android.intent.action.DELETE";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:08.772 -0500", hash_original_field = "9F6A84C1EE18B3B56F41E9CCED70EC9B", hash_generated_field = "64053F2DE34FDC5E2063C0A720EE652A")

    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_RUN = "android.intent.action.RUN";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:08.775 -0500", hash_original_field = "2B7527545E7A167969D10D1AA88CE30D", hash_generated_field = "52B9A6D0C516BD31A4C95AEA422C7CDD")

    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_SYNC = "android.intent.action.SYNC";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:08.777 -0500", hash_original_field = "9ED90DA821DD13FD64CE8F287D6C74C4", hash_generated_field = "6E59FE4FD801C0D307FECC5EC4DF8628")

    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_PICK_ACTIVITY = "android.intent.action.PICK_ACTIVITY";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:08.779 -0500", hash_original_field = "1CFAED57B53E73E6CDCE62E82C3F490E", hash_generated_field = "E7F9F68DFE9898629E0198A735569695")

    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_SEARCH = "android.intent.action.SEARCH";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:08.783 -0500", hash_original_field = "7694342189665A8624F940C549FA7CC1", hash_generated_field = "737D48C4A21F919A73BF8BEED0D584ED")

    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_SYSTEM_TUTORIAL = "android.intent.action.SYSTEM_TUTORIAL";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:08.785 -0500", hash_original_field = "5712915ACFAB26853EBE8A3E9F168883", hash_generated_field = "26A470EDFD3CA2849C1FCACCD2E608D4")

    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_WEB_SEARCH = "android.intent.action.WEB_SEARCH";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:08.788 -0500", hash_original_field = "C5014404ACAB641C4A7AADB57A513F96", hash_generated_field = "BE767857B9865892A73819172E037AD1")

    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_ALL_APPS = "android.intent.action.ALL_APPS";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:08.790 -0500", hash_original_field = "AE70F9A40BFA3BA5392B9289A2C297FD", hash_generated_field = "78B483C17CF8E280B3FFE64EBE9308D7")

    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_SET_WALLPAPER = "android.intent.action.SET_WALLPAPER";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:08.792 -0500", hash_original_field = "091AE3EB0FA4092F2A4B39744821B91A", hash_generated_field = "88A571004065BB2EDB6670E75B4759B4")

    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_BUG_REPORT = "android.intent.action.BUG_REPORT";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:08.795 -0500", hash_original_field = "23A7ACF35478EDF9512DA74EAC1EB2AE", hash_generated_field = "CE3414178F66CECEAE525495168216DF")

    public static final String ACTION_FACTORY_TEST = "android.intent.action.FACTORY_TEST";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:08.797 -0500", hash_original_field = "666119E264BD5544E908F8E48D9C5329", hash_generated_field = "B0656284FD0F7E03B7575D3D85A97AEE")

    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_CALL_BUTTON = "android.intent.action.CALL_BUTTON";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:08.800 -0500", hash_original_field = "DD05619CD9E547B5431A02E67367FF5B", hash_generated_field = "A75AE92BC026CE01AEADCE0ABC24D90D")

    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_VOICE_COMMAND = "android.intent.action.VOICE_COMMAND";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:08.802 -0500", hash_original_field = "6970D9F89837279D30EB0CC7F4EA2407", hash_generated_field = "694DBF6AB3FCCC208CBE973967A9AC55")

    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_SEARCH_LONG_PRESS = "android.intent.action.SEARCH_LONG_PRESS";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:08.805 -0500", hash_original_field = "DD36BE251AD3DCE869512464D7AAC944", hash_generated_field = "DD97D416D92C0F615E268CAE319B9240")

    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_APP_ERROR = "android.intent.action.APP_ERROR";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:08.807 -0500", hash_original_field = "471303B8C2816DF6590E9453CC4D9699", hash_generated_field = "A3A3FAFEFA13163016A6BA1A34223541")

    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_POWER_USAGE_SUMMARY = "android.intent.action.POWER_USAGE_SUMMARY";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:08.810 -0500", hash_original_field = "10FBF85EF7C4633307E9D362A71BDA27", hash_generated_field = "1EFAF27E8BB9D3EDBE3E169F25247ED4")

    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_UPGRADE_SETUP = "android.intent.action.UPGRADE_SETUP";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:08.813 -0500", hash_original_field = "BA0DA2AA4F620FBA2269127883FEF6D4", hash_generated_field = "E9B6C831918B3E1D73A086432893716E")

    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_MANAGE_NETWORK_USAGE =
            "android.intent.action.MANAGE_NETWORK_USAGE";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:08.815 -0500", hash_original_field = "1BA1A8A67E0F55C501F555223BA730EC", hash_generated_field = "224FD1BF8BEC020F4764D95A85BFD13C")

    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_INSTALL_PACKAGE = "android.intent.action.INSTALL_PACKAGE";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:08.818 -0500", hash_original_field = "1E44F591A5B2841F5465332354C6C47C", hash_generated_field = "095986244542E9347842ED78D18CD74E")

    public static final String EXTRA_INSTALLER_PACKAGE_NAME
            = "android.intent.extra.INSTALLER_PACKAGE_NAME";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:08.820 -0500", hash_original_field = "77315C9C61E6334525CDFEE89A291DCF", hash_generated_field = "2279FC773C4241383D589A90D26BE2B5")

    public static final String EXTRA_NOT_UNKNOWN_SOURCE
            = "android.intent.extra.NOT_UNKNOWN_SOURCE";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:08.822 -0500", hash_original_field = "DE32220D78182C5053F4323BE2ABC17F", hash_generated_field = "0F02B996D65BEFE314ED9C58EC4F054C")

    public static final String EXTRA_ALLOW_REPLACE
            = "android.intent.extra.ALLOW_REPLACE";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:08.824 -0500", hash_original_field = "31CE9FCA6200779CED4F0F9D1F03E63C", hash_generated_field = "CABD06708BF342F9A6F9EEF34216D9E5")

    public static final String EXTRA_RETURN_RESULT
            = "android.intent.extra.RETURN_RESULT";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:08.828 -0500", hash_original_field = "8E15CB4142F59070E0A92575EAB87AE3", hash_generated_field = "D664CE1BA8A3AD69E368E2660C3CB4E9")

    public static final String EXTRA_INSTALL_RESULT
            = "android.intent.extra.INSTALL_RESULT";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:08.830 -0500", hash_original_field = "4451E2F32397696A3E7409C5657E9291", hash_generated_field = "5D0C5026A979DB00BB5F4ADD3EBFDB2D")

    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_UNINSTALL_PACKAGE = "android.intent.action.UNINSTALL_PACKAGE";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:08.833 -0500", hash_original_field = "EF9F590D8D90F0C1CC17302960871B16", hash_generated_field = "604CC86BBA1936C2065E409B75C690BD")

    public static final String METADATA_SETUP_VERSION = "android.SETUP_VERSION";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:08.835 -0500", hash_original_field = "58134645FAD8684F701CC61892F7687A", hash_generated_field = "F8C1B5E2F46F4866C2E699567C2EB4E5")

    // ---------------------------------------------------------------------
    // Standard intent broadcast actions (see action variable).

    /**
     * Broadcast Action: Sent after the screen turns off.
     *
     * <p class="note">This is a protected intent that can only be sent
     * by the system.
     */
    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_SCREEN_OFF = "android.intent.action.SCREEN_OFF";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:08.838 -0500", hash_original_field = "914164DE0CB13F7BAD12196144D23469", hash_generated_field = "1FC4F0F18C8B9F53FA7192917FC4AB66")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_SCREEN_ON = "android.intent.action.SCREEN_ON";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:08.841 -0500", hash_original_field = "929D9546238741A17FC7E656B19A93CA", hash_generated_field = "02A3AA184DBA3BF4ED8BBC3FF5A5EA52")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_USER_PRESENT = "android.intent.action.USER_PRESENT";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:08.843 -0500", hash_original_field = "D55264D235C3D1ECAA21AC6FAF7B8389", hash_generated_field = "C4F52864EBD629B8C1AE5257671D488F")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_TIME_TICK = "android.intent.action.TIME_TICK";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:08.846 -0500", hash_original_field = "CCF185BACEA80C66E2AE0C5196B4BA1E", hash_generated_field = "90329A50970E9E426A169EEC900D33F0")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_TIME_CHANGED = "android.intent.action.TIME_SET";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:08.848 -0500", hash_original_field = "05884D3C1D77D71184E4A0DA1743FBD6", hash_generated_field = "57160E8CBD5FB12354C9F2A165FC4406")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_DATE_CHANGED = "android.intent.action.DATE_CHANGED";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:08.851 -0500", hash_original_field = "CE3B493F3FC715D09AD824920C64D132", hash_generated_field = "092DA96C44A18F27A501A8534FFCD4F2")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_TIMEZONE_CHANGED = "android.intent.action.TIMEZONE_CHANGED";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:08.853 -0500", hash_original_field = "1C8CF9BDE0156DDF863070C63106B3C6", hash_generated_field = "2283D5CDFBBD632A8875668E1CC33C72")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_CLEAR_DNS_CACHE = "android.intent.action.CLEAR_DNS_CACHE";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:08.856 -0500", hash_original_field = "ABED8B9A5581FDCFEB4E4C80F188FD16", hash_generated_field = "C359D5926C706990350C34DE9456F7E3")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_ALARM_CHANGED = "android.intent.action.ALARM_CHANGED";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:08.859 -0500", hash_original_field = "DB6F9815E48EA6C084F810D2C50BAB95", hash_generated_field = "0E69C231C8306016AEE014A3D1AF38B7")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_SYNC_STATE_CHANGED
            = "android.intent.action.SYNC_STATE_CHANGED";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:08.862 -0500", hash_original_field = "EE81146177999CB98AFFC32932352A6B", hash_generated_field = "97FEB82EA8E82C6EA441D833FB2D22C8")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_BOOT_COMPLETED = "android.intent.action.BOOT_COMPLETED";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:08.864 -0500", hash_original_field = "551C8F4A084B1A74FFAB022FB3D26009", hash_generated_field = "D95B98D4DA81F25EA38B96B61FBDB946")

    public static final String ACTION_CLOSE_SYSTEM_DIALOGS = "android.intent.action.CLOSE_SYSTEM_DIALOGS";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:08.866 -0500", hash_original_field = "4D9A6F87B3116C13CE617C6D8E4F3452", hash_generated_field = "2C7D09002B43654AC3703592944450CB")

    @Deprecated
    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_PACKAGE_INSTALL = "android.intent.action.PACKAGE_INSTALL";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:08.869 -0500", hash_original_field = "99BC881FA0B86B8D49B67B3975262490", hash_generated_field = "E9BF2DB88022DA53F5B709714C727F77")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_PACKAGE_ADDED = "android.intent.action.PACKAGE_ADDED";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:08.871 -0500", hash_original_field = "8CB2F7ABC4BC9D3258B7DCB6CCA3907B", hash_generated_field = "4FE14146DF43D9EDF110C776366AEBA7")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_PACKAGE_REPLACED = "android.intent.action.PACKAGE_REPLACED";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:08.874 -0500", hash_original_field = "02FA5367E0FB00E24BA0C1EC32F14F5E", hash_generated_field = "8E7A7A120C757C5788574BAE90EF4C4F")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_MY_PACKAGE_REPLACED = "android.intent.action.MY_PACKAGE_REPLACED";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:08.877 -0500", hash_original_field = "463E6EE2827A56962C092E3E4AE14FA8", hash_generated_field = "35FE490F4B8E618F5247F033A516643E")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_PACKAGE_REMOVED = "android.intent.action.PACKAGE_REMOVED";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:08.879 -0500", hash_original_field = "BE7C3D3B4F1C6575C32381550B8550AA", hash_generated_field = "45DA25B1BF4497A16EE81215EC103B86")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_PACKAGE_FULLY_REMOVED
            = "android.intent.action.PACKAGE_FULLY_REMOVED";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:08.882 -0500", hash_original_field = "9F35A0E010E9216E4C362935048D118C", hash_generated_field = "3B88AC76A94E57D70607375559434DF6")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_PACKAGE_CHANGED = "android.intent.action.PACKAGE_CHANGED";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:08.885 -0500", hash_original_field = "EBD69DA4B2AA88E548276FD7E444D3F6", hash_generated_field = "83AB29CDF0C8D03ED03B189B0B3B427D")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_QUERY_PACKAGE_RESTART = "android.intent.action.QUERY_PACKAGE_RESTART";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:08.888 -0500", hash_original_field = "1324A0DF4529F96A36C28BDC87DCB48C", hash_generated_field = "485E38FFA9AEDA99636C6777203D486E")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_PACKAGE_RESTARTED = "android.intent.action.PACKAGE_RESTARTED";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:08.890 -0500", hash_original_field = "7A500C07CF5129FC3D5D185BFA4FA871", hash_generated_field = "CE51064186158FF3C33BEB6F375C1BF1")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_PACKAGE_DATA_CLEARED = "android.intent.action.PACKAGE_DATA_CLEARED";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:08.893 -0500", hash_original_field = "7382FE93FDB46D1479DDACBBC9E6BB78", hash_generated_field = "F550ED6B3D1AF7CD7BB88086505B7ABD")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_UID_REMOVED = "android.intent.action.UID_REMOVED";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:08.895 -0500", hash_original_field = "084F0B60A0BA2F24A2C3DA6CC8C5C85E", hash_generated_field = "6914952F46126338B1ABD751495C4588")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_PACKAGE_FIRST_LAUNCH = "android.intent.action.PACKAGE_FIRST_LAUNCH";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:08.898 -0500", hash_original_field = "C64921F5DBBD558A2EBFF88908C064AE", hash_generated_field = "772AAE9E85E0EFC70AE22DE59C52A048")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_PACKAGE_NEEDS_VERIFICATION = "android.intent.action.PACKAGE_NEEDS_VERIFICATION";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:08.900 -0500", hash_original_field = "B79625E19F4E2F1BD5E45C4B3667954F", hash_generated_field = "21890D9A6F3165ECEF5820886B5827AD")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_EXTERNAL_APPLICATIONS_AVAILABLE =
        "android.intent.action.EXTERNAL_APPLICATIONS_AVAILABLE";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:08.903 -0500", hash_original_field = "D7D623359205B1CA800A25BACAE86819", hash_generated_field = "1D6B9ABFAFEDC734E8E2A5E0384923C8")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_EXTERNAL_APPLICATIONS_UNAVAILABLE =
        "android.intent.action.EXTERNAL_APPLICATIONS_UNAVAILABLE";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:08.905 -0500", hash_original_field = "F38175A0EDB35189CCBFF4F85356FAB5", hash_generated_field = "D9C4187C78B1437F37AB9EC1AA21494E")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_WALLPAPER_CHANGED = "android.intent.action.WALLPAPER_CHANGED";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:08.908 -0500", hash_original_field = "2BC9899B22255D21352A4541BF0D6FB9", hash_generated_field = "1BBA1270FB38433693D57149CF8C0B2E")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_CONFIGURATION_CHANGED = "android.intent.action.CONFIGURATION_CHANGED";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:08.910 -0500", hash_original_field = "97114585369020C6F2E80F5AB8DA4998", hash_generated_field = "8CB211B82206532C1A38690C8B237654")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_LOCALE_CHANGED = "android.intent.action.LOCALE_CHANGED";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:08.913 -0500", hash_original_field = "A6D4C44C7EFDBE2D66C6F6C2217DC162", hash_generated_field = "570C99553ED814D403177932D335BED6")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_BATTERY_CHANGED = "android.intent.action.BATTERY_CHANGED";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:08.916 -0500", hash_original_field = "0E8C06E4EA68A949826A1CCC6A7C44BD", hash_generated_field = "00E1ABC519EAD5F7A1CA909504F2202F")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_BATTERY_LOW = "android.intent.action.BATTERY_LOW";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:08.919 -0500", hash_original_field = "CBF777D892BA9C7642EE2F7581F247D1", hash_generated_field = "9210CA8BA87692C4B485CE9B81D3110D")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_BATTERY_OKAY = "android.intent.action.BATTERY_OKAY";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:08.921 -0500", hash_original_field = "66A21C146035CF56B19217E62C40C468", hash_generated_field = "B2C6014C054E378354CF8FE40A52B2C2")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_POWER_CONNECTED = "android.intent.action.ACTION_POWER_CONNECTED";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:08.924 -0500", hash_original_field = "10E0D42F6E1AD1EEF30774C926005DBC", hash_generated_field = "EBEFF5DC3845903EFCEC6B07375DACA1")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_POWER_DISCONNECTED =
            "android.intent.action.ACTION_POWER_DISCONNECTED";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:08.926 -0500", hash_original_field = "8C4F73815AC9D1FED18EFE761638D8E6", hash_generated_field = "1BE5AD2EFAFDA27EB66F2443D735550E")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_SHUTDOWN = "android.intent.action.ACTION_SHUTDOWN";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:08.929 -0500", hash_original_field = "661DFE904768C71A4638E7F94D8BC440", hash_generated_field = "5F3F58AD9176A8304B540840F63575DB")

    public static final String ACTION_REQUEST_SHUTDOWN = "android.intent.action.ACTION_REQUEST_SHUTDOWN";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:08.931 -0500", hash_original_field = "88E48DD5A2ABC7BBDBA58CBD2EDAEAB2", hash_generated_field = "01A6016CF410E4B86318EFF197BCF8F9")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_DEVICE_STORAGE_LOW = "android.intent.action.DEVICE_STORAGE_LOW";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:08.933 -0500", hash_original_field = "238A5711E1790829AE26716F4B7EECC5", hash_generated_field = "33F2A4A9934CCDA6F410E6F6C0F40214")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_DEVICE_STORAGE_OK = "android.intent.action.DEVICE_STORAGE_OK";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:08.936 -0500", hash_original_field = "6042321195DCD0C284E7E6BD625F966A", hash_generated_field = "368FAECEAD77772CAF85D0422B1C8A79")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_DEVICE_STORAGE_FULL = "android.intent.action.DEVICE_STORAGE_FULL";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:08.939 -0500", hash_original_field = "EF20E92898C3ED4E86EFFF6BCC198C55", hash_generated_field = "9C13CE86364BD1EE13C144EEC334D347")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_DEVICE_STORAGE_NOT_FULL = "android.intent.action.DEVICE_STORAGE_NOT_FULL";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:08.941 -0500", hash_original_field = "BE71617B4921D8DCA7251ABB7BADBC07", hash_generated_field = "D65BD0B998073C9FE19756354457F478")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_MANAGE_PACKAGE_STORAGE = "android.intent.action.MANAGE_PACKAGE_STORAGE";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:08.944 -0500", hash_original_field = "5C8B9A4561EE3B6A4ABF4B0C6D5886FE", hash_generated_field = "3CBD0CC144FEC04702B3F1CD13F64839")

    @Deprecated
    public static final String ACTION_UMS_CONNECTED = "android.intent.action.UMS_CONNECTED";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:08.947 -0500", hash_original_field = "2AAC98D5FD5A45AF3D4AC8B85A740FC3", hash_generated_field = "4BDE49336D4AFA09BB0FE3A57004C306")

    @Deprecated
    public static final String ACTION_UMS_DISCONNECTED = "android.intent.action.UMS_DISCONNECTED";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:08.949 -0500", hash_original_field = "5F352EBE2D2FBA9F3823BA839C5FB2AC", hash_generated_field = "B2BE1657103DB0488498829BD96E22F0")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_MEDIA_REMOVED = "android.intent.action.MEDIA_REMOVED";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:08.952 -0500", hash_original_field = "D1A88B1477C39DB0AC34989BAF1BB975", hash_generated_field = "C9CB40A30C23F3F14E497C2C7F2325BD")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_MEDIA_UNMOUNTED = "android.intent.action.MEDIA_UNMOUNTED";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:08.954 -0500", hash_original_field = "D55DA9F501924D87051DF53D65145646", hash_generated_field = "D43D07DAC9AFB658BCECFFD0CEB2069A")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_MEDIA_CHECKING = "android.intent.action.MEDIA_CHECKING";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:08.956 -0500", hash_original_field = "84083A38796AD1641320882FBF85BB30", hash_generated_field = "55384D59F49FD41A2EADF0CCA4C0929A")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_MEDIA_NOFS = "android.intent.action.MEDIA_NOFS";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:08.959 -0500", hash_original_field = "F6EAAFCB956A067F8BF667EE934AEBB6", hash_generated_field = "10558D4779FCB99BEE53B32D18320978")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_MEDIA_MOUNTED = "android.intent.action.MEDIA_MOUNTED";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:08.962 -0500", hash_original_field = "21E644F9AC660DF2DD303A2CC9D9B37D", hash_generated_field = "8566E36A8F60EC1445E814C3A2CB4525")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_MEDIA_SHARED = "android.intent.action.MEDIA_SHARED";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:08.964 -0500", hash_original_field = "1C4014629A5A48039B954F29F939C310", hash_generated_field = "4A0966F843885D1B4C7D86D57A30AB03")

    public static final String ACTION_MEDIA_UNSHARED = "android.intent.action.MEDIA_UNSHARED";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:08.967 -0500", hash_original_field = "0F8BB27112137B2253311D26AE1B1E12", hash_generated_field = "803A350DA057B94CB8E27CB7B878C6A6")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_MEDIA_BAD_REMOVAL = "android.intent.action.MEDIA_BAD_REMOVAL";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:08.970 -0500", hash_original_field = "B91E57845FBFD4B64072D128440D3E41", hash_generated_field = "31F84A292E6949D56D48CCEB1F50770D")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_MEDIA_UNMOUNTABLE = "android.intent.action.MEDIA_UNMOUNTABLE";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:08.972 -0500", hash_original_field = "EF39B556C92AFA4BC9FADF471C2D9533", hash_generated_field = "9059034AB7D9AA44CE7FCE4B140694F3")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_MEDIA_EJECT = "android.intent.action.MEDIA_EJECT";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:08.976 -0500", hash_original_field = "079A9A7F722D0B27C92AB2A1466C683D", hash_generated_field = "71A3429142C498B04ED73651826D736E")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_MEDIA_SCANNER_STARTED = "android.intent.action.MEDIA_SCANNER_STARTED";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:08.978 -0500", hash_original_field = "65EC19751E59D6690D432E05C1249266", hash_generated_field = "A5291D8E43EEC5A34C794D6EDB297C4B")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_MEDIA_SCANNER_FINISHED = "android.intent.action.MEDIA_SCANNER_FINISHED";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:08.981 -0500", hash_original_field = "2CBE5C381D73EEE35A9370AA7EA5D73C", hash_generated_field = "B73610259405BC52D46A6BB9A234CACC")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_MEDIA_SCANNER_SCAN_FILE = "android.intent.action.MEDIA_SCANNER_SCAN_FILE";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:08.983 -0500", hash_original_field = "ACF3654BF39E6840D5F20EC2BC1986B9", hash_generated_field = "96866AE193EB7AD4C2D320F9E8F9667F")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_MEDIA_BUTTON = "android.intent.action.MEDIA_BUTTON";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:08.986 -0500", hash_original_field = "5A4CE3D9C29946D37822CD31A9397CE0", hash_generated_field = "1B888EC3E349732B7C1B7AADD006D324")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_CAMERA_BUTTON = "android.intent.action.CAMERA_BUTTON";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:08.988 -0500", hash_original_field = "1B1614BE1EECC864E2F6CB61D83848AE", hash_generated_field = "608ADE4E46CBECADA7B930C634E92B06")

    // location; they are not general-purpose actions.

    /**
     * Broadcast Action: An GTalk connection has been established.
     */
    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_GTALK_SERVICE_CONNECTED =
            "android.intent.action.GTALK_CONNECTED";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:08.991 -0500", hash_original_field = "C2B9DBA4DA35B4EDD5F2ABF4F6E25558", hash_generated_field = "8BD1CF036007C1899341967FD8CF4CDF")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_GTALK_SERVICE_DISCONNECTED =
            "android.intent.action.GTALK_DISCONNECTED";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:08.993 -0500", hash_original_field = "C66B1D1D0844B76651117AE7CC2604E3", hash_generated_field = "522D033A61D4D533DE9C09A76302DC98")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_INPUT_METHOD_CHANGED =
            "android.intent.action.INPUT_METHOD_CHANGED";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:08.996 -0500", hash_original_field = "65D23AD81584871788AAA8E53E074EA3", hash_generated_field = "D2528C9CC0EA562DC80B69589069F631")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_AIRPLANE_MODE_CHANGED = "android.intent.action.AIRPLANE_MODE";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:08.998 -0500", hash_original_field = "64CC65B2E908A28AC23168C999A77810", hash_generated_field = "41C0CEA92EB9C8B86E585E41D9D7A0CF")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_PROVIDER_CHANGED =
            "android.intent.action.PROVIDER_CHANGED";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.001 -0500", hash_original_field = "AFD82423B060C9179EFDD64C7DC603B4", hash_generated_field = "37C2771817E59664B8B239BCBDACBB10")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_HEADSET_PLUG =
            "android.intent.action.HEADSET_PLUG";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.003 -0500", hash_original_field = "E2C88734CEBEEE6E8B9180A4A4B71398", hash_generated_field = "D7E4EDC4328425F0329B2F8E1A88DAC9")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_USB_ANLG_HEADSET_PLUG =
            "android.intent.action.USB_ANLG_HEADSET_PLUG";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.006 -0500", hash_original_field = "94297CC19BCF8F35C915B370182EBA48", hash_generated_field = "B2FBB541357A96FDB3E687180A2EC76D")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_USB_DGTL_HEADSET_PLUG =
            "android.intent.action.USB_DGTL_HEADSET_PLUG";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.009 -0500", hash_original_field = "5854614051676A26C59DDBAE4B198CA0", hash_generated_field = "9163DF3896F055A609C5B564A0BFEBCC")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_HDMI_AUDIO_PLUG =
            "android.intent.action.HDMI_AUDIO_PLUG";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.011 -0500", hash_original_field = "63A050D88FE830DC56445C40581331BF", hash_generated_field = "A81D1B29362E913E47FA01AA899F1105")

    //@SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_ADVANCED_SETTINGS_CHANGED
            = "android.intent.action.ADVANCED_SETTINGS";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.014 -0500", hash_original_field = "0B918542F2CC4A807BBC5403B9D4E1CD", hash_generated_field = "D8133F9238C84FB44D78043BBC29F6DB")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_NEW_OUTGOING_CALL =
            "android.intent.action.NEW_OUTGOING_CALL";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.016 -0500", hash_original_field = "3A1DDB581CE0161D783358D3E91DC929", hash_generated_field = "13D1D6B470020C1299E426407C602890")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_REBOOT =
            "android.intent.action.REBOOT";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.019 -0500", hash_original_field = "A4CB5136FDCD196CE2FC28C445F783D3", hash_generated_field = "7CCBB1A0B45EFD0A2DFD1D63B82D87E8")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_DOCK_EVENT =
            "android.intent.action.DOCK_EVENT";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.021 -0500", hash_original_field = "CC5DFE02FCA8593B0E6FBE474C98CAC5", hash_generated_field = "8EF6B8C482C12C7A4ACB03A0EE29DB00")

    public static final String ACTION_REMOTE_INTENT =
            "com.google.android.c2dm.intent.RECEIVE";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.024 -0500", hash_original_field = "FD633CC9D6CE6966F383869985B8E679", hash_generated_field = "8565FE3FC70ABB4476B729EE5BD6454E")

    public static final String ACTION_PRE_BOOT_COMPLETED =
            "android.intent.action.PRE_BOOT_COMPLETED";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.027 -0500", hash_original_field = "73346E51B0AAA2B4AF42A9DB8E2F23DE", hash_generated_field = "6DD4014C587BC37A36C25A398DC40F06")

    // ---------------------------------------------------------------------
    // Standard intent categories (see addCategory()).

    /**
     * Set if the activity should be an option for the default action
     * (center press) to perform on a piece of data.  Setting this will
     * hide from the user any activities without it set when performing an
     * action on some data.  Note that this is normal -not- set in the
     * Intent when initiating an action -- it is for use in intent filters
     * specified in packages.
     */
    @SdkConstant(SdkConstantType.INTENT_CATEGORY)
    public static final String CATEGORY_DEFAULT = "android.intent.category.DEFAULT";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.029 -0500", hash_original_field = "54EACC83A269932182161F7D1B341E47", hash_generated_field = "78B44AC3B312155C92B9E800BB603925")

    @SdkConstant(SdkConstantType.INTENT_CATEGORY)
    public static final String CATEGORY_BROWSABLE = "android.intent.category.BROWSABLE";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.032 -0500", hash_original_field = "676FAA3ED4342D7F60A11535249AC49D", hash_generated_field = "5D58EABA225388825E6CB55C2DB3A0C5")

    @SdkConstant(SdkConstantType.INTENT_CATEGORY)
    public static final String CATEGORY_ALTERNATIVE = "android.intent.category.ALTERNATIVE";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.035 -0500", hash_original_field = "EA17EC5D38C488B239711FBD90255985", hash_generated_field = "2B75CF89213BE077BE277CE183A8F989")

    @SdkConstant(SdkConstantType.INTENT_CATEGORY)
    public static final String CATEGORY_SELECTED_ALTERNATIVE = "android.intent.category.SELECTED_ALTERNATIVE";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.037 -0500", hash_original_field = "4D195E268B64C6E91A80FA7265DCD5C1", hash_generated_field = "888B174B33729C88211F08DA737A729B")

    @SdkConstant(SdkConstantType.INTENT_CATEGORY)
    public static final String CATEGORY_TAB = "android.intent.category.TAB";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.040 -0500", hash_original_field = "248B7561C64830F284FF2EE8F30F2D04", hash_generated_field = "56593E4A41EF7C8E79F804744316680A")

    @SdkConstant(SdkConstantType.INTENT_CATEGORY)
    public static final String CATEGORY_LAUNCHER = "android.intent.category.LAUNCHER";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.042 -0500", hash_original_field = "1A4B0B1F3E7CD83ED56D5BFC7D7B3224", hash_generated_field = "441C59FEE274EAC3BE26B4A58E9BB45F")

    @SdkConstant(SdkConstantType.INTENT_CATEGORY)
    public static final String CATEGORY_INFO = "android.intent.category.INFO";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.044 -0500", hash_original_field = "C41179DDA5BDB163BFA13A56EAAA5EBC", hash_generated_field = "18557C6597B9FD9892461C1C1B6834A2")

    @SdkConstant(SdkConstantType.INTENT_CATEGORY)
    public static final String CATEGORY_HOME = "android.intent.category.HOME";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.047 -0500", hash_original_field = "1A1714D03ACDBE1E7F3AF3126CF5A4B8", hash_generated_field = "51881CD6A4034B4E905D061587A3240D")

    @SdkConstant(SdkConstantType.INTENT_CATEGORY)
    public static final String CATEGORY_PREFERENCE = "android.intent.category.PREFERENCE";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.049 -0500", hash_original_field = "9D94D8D66ACDDE1C9DF6D981CF8790AB", hash_generated_field = "747531EDE3442CA006298CA2157DE37B")

    @SdkConstant(SdkConstantType.INTENT_CATEGORY)
    public static final String CATEGORY_DEVELOPMENT_PREFERENCE = "android.intent.category.DEVELOPMENT_PREFERENCE";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.052 -0500", hash_original_field = "5E674DD045CC1D8B45BA1034C21626E9", hash_generated_field = "6B6F2EDBA682AA91A9896CAD371A8D07")

    @SdkConstant(SdkConstantType.INTENT_CATEGORY)
    public static final String CATEGORY_EMBED = "android.intent.category.EMBED";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.054 -0500", hash_original_field = "944698E95C7339992B89BF3618D4A481", hash_generated_field = "43D854893F1176EC545D499880817C81")

    @SdkConstant(SdkConstantType.INTENT_CATEGORY)
    public static final String CATEGORY_APP_MARKET = "android.intent.category.APP_MARKET";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.057 -0500", hash_original_field = "D788B69654B0550E65E944D4FDFC59EC", hash_generated_field = "2178E3078FC2C9C16B3710D31215720B")

    @SdkConstant(SdkConstantType.INTENT_CATEGORY)
    public static final String CATEGORY_MONKEY = "android.intent.category.MONKEY";
    
    public static class ShortcutIconResource implements Parcelable {

        /**
         * Creates a new ShortcutIconResource for the specified context and resource
         * identifier.
         *
         * @param context The context of the application.
         * @param resourceId The resource idenfitier for the icon.
         * @return A new ShortcutIconResource with the specified's context package name
         *         and icon resource idenfitier.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:08.716 -0500", hash_original_method = "9BE6357EB542FC84A087A4445B1D473C", hash_generated_method = "38B512328D2735C6716B0A16A54B15A6")
        
public static ShortcutIconResource fromContext(Context context, int resourceId) {
            ShortcutIconResource icon = new ShortcutIconResource();
            icon.packageName = context.getPackageName();
            icon.resourceName = context.getResources().getResourceName(resourceId);
            return icon;
        }
        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.475 -0400", hash_original_field = "FBF38D2B8BC640782282E16FFEC5198F", hash_generated_field = "1765F17BB54E8B45766A199ED3197D0C")

        public static final Parcelable.Creator<ShortcutIconResource> CREATOR =
            new Parcelable.Creator<ShortcutIconResource>() {

                @DSSafe(DSCat.SAFE_OTHERS)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:08.720 -0500", hash_original_method = "E5EFB41AF12EFD491D45E99DE4F055C4", hash_generated_method = "B87C27F2C8D77B5D6F6D753DDE5B9250")
            
public ShortcutIconResource createFromParcel(Parcel source) {
                    ShortcutIconResource icon = new ShortcutIconResource();
                    icon.packageName = source.readString();
                    icon.resourceName = source.readString();
                    return icon;
                }

                @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:08.722 -0500", hash_original_method = "3C31821CAA714EDAC90B580A2669C2C0", hash_generated_method = "A05D218338B3744C7F29669A44BACF86")
            
public ShortcutIconResource[] newArray(int size) {
                    return new ShortcutIconResource[size];
                }
            };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:08.711 -0500", hash_original_field = "6F92EE1B3BCDC0C4179CF5FD998BE046", hash_generated_field = "AEA3D3739F492530AF8FD6582FAACBD9")

        public String packageName;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:08.713 -0500", hash_original_field = "776DFC798E908134FBF3357EE69756C4", hash_generated_field = "08D9F4FE05D4D9B5AF5EACB299E1AC68")

        public String resourceName;
        
        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.474 -0400", hash_original_method = "76C9E47B1998842612265A8369AB620F", hash_generated_method = "76C9E47B1998842612265A8369AB620F")
        public ShortcutIconResource ()
        {
            //Synthesized constructor
        }

        /**
         * No special parcel contents.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:08.727 -0500", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "D90463461B2A94FF94D13FDF69BB80C9")
        
public int describeContents() {
            return 0;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:08.729 -0500", hash_original_method = "A078CBD5399741F593957325C4A01342", hash_generated_method = "BCD34DC6FDEBA18912843C2C6FD6D83C")
        
public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(packageName);
            dest.writeString(resourceName);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:08.732 -0500", hash_original_method = "8D66F7367028E1EB1EA87D8477E02D6C", hash_generated_method = "6F90CCE7688941528CC1D08D934509F0")
        
@Override
        public String toString() {
            return resourceName;
        }
    }
    
    public static final class FilterComparison {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.571 -0500", hash_original_field = "1811495D939DB843870F6315E04555CC", hash_generated_field = "5782C825DA3F61D408DF2DCA63E7F54A")

        private  Intent mIntent;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.573 -0500", hash_original_field = "A13152B9FE22A291FA8BF7E71C005049", hash_generated_field = "A977E573260D0E2786C71BC0961278A2")

        private  int mHashCode;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.577 -0500", hash_original_method = "2099CA9774C8964FCB84A0C5BA5EC3C6", hash_generated_method = "F5E93F3388F60EB0CB98E3A5B65E70FA")
        
public FilterComparison(Intent intent) {
            mIntent = intent;
            mHashCode = intent.filterHashCode();
        }

        /**
         * Return the Intent that this FilterComparison represents.
         * @return Returns the Intent held by the FilterComparison.  Do
         * not modify!
         */
        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.579 -0500", hash_original_method = "AD027B7B58A4A2F151CC138FB7B23244", hash_generated_method = "7CE6D2E5920E17BB1B744A5090D635BC")
        
public Intent getIntent() {
            return mIntent;
        }

        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.581 -0500", hash_original_method = "57E0DE3F426C34FAD2C087D7985C733F", hash_generated_method = "F90B90EFBE2EDE43A9416E0B4AB00241")
        
@Override
        public boolean equals(Object obj) {
            if (obj instanceof FilterComparison) {
                Intent other = ((FilterComparison)obj).mIntent;
                return mIntent.filterEquals(other);
            }
            return false;
        }

        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.584 -0500", hash_original_method = "D7D5E8B622FC6A9CB6E203DCD79B8799", hash_generated_method = "B0837B818531E3C208A8A4F995ED9F70")
        
@Override
        public int hashCode() {
            return mHashCode;
        }
        
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.059 -0500", hash_original_field = "3BDD06B2352FDA6E8DB4B328EAD8F6DB", hash_generated_field = "686B8018CC11BDB5C32BAAD279E5365B")

    public static final String CATEGORY_TEST = "android.intent.category.TEST";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.061 -0500", hash_original_field = "1FD0FEE9EEC7A9D1EBC1CC6D0FF377D1", hash_generated_field = "E916DA7FE73FFB94CC2AEAE533EA23BF")

    public static final String CATEGORY_UNIT_TEST = "android.intent.category.UNIT_TEST";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.065 -0500", hash_original_field = "74559E67B4A4EF29DD20166AD284321B", hash_generated_field = "F6FA58629915BFC7488711CA03CFE1DB")

    public static final String CATEGORY_SAMPLE_CODE = "android.intent.category.SAMPLE_CODE";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.067 -0500", hash_original_field = "6B4368A71A6F654586A2FBB7BA36AB28", hash_generated_field = "326BBB87AE978C10D0AC46A82D13B11D")

    @SdkConstant(SdkConstantType.INTENT_CATEGORY)
    public static final String CATEGORY_OPENABLE = "android.intent.category.OPENABLE";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.069 -0500", hash_original_field = "7C8D479408128882BCED77FCFC58E6D5", hash_generated_field = "4A870B99349E92C8A35D53AF2630B90F")

    public static final String CATEGORY_FRAMEWORK_INSTRUMENTATION_TEST =
            "android.intent.category.FRAMEWORK_INSTRUMENTATION_TEST";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.072 -0500", hash_original_field = "6A4097878F8AAD74206827633E28EC90", hash_generated_field = "993F2D06C5CDD03C9EA7DCE8C1E78EC9")

    @SdkConstant(SdkConstantType.INTENT_CATEGORY)
    public static final String CATEGORY_CAR_DOCK = "android.intent.category.CAR_DOCK";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.075 -0500", hash_original_field = "09FB62EFEE77B9EABCDBA6385AA92D77", hash_generated_field = "0E88B4F0151B540B4D837EFB418D0F48")

    @SdkConstant(SdkConstantType.INTENT_CATEGORY)
    public static final String CATEGORY_DESK_DOCK = "android.intent.category.DESK_DOCK";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.077 -0500", hash_original_field = "8A475AE65ED010C3C85F4459E10ABE6F", hash_generated_field = "38EC7649AEEB239624A6794A7F07EA02")

    @SdkConstant(SdkConstantType.INTENT_CATEGORY)
    public static final String CATEGORY_LE_DESK_DOCK = "android.intent.category.LE_DESK_DOCK";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.079 -0500", hash_original_field = "2DEAB20CC79CE07C45D8288B006AD2AC", hash_generated_field = "3F9D11FA3702BE350379D953C29C2F6F")

    @SdkConstant(SdkConstantType.INTENT_CATEGORY)
    public static final String CATEGORY_HE_DESK_DOCK = "android.intent.category.HE_DESK_DOCK";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.082 -0500", hash_original_field = "DDCDA6854AED92E99FDC6703AE71677C", hash_generated_field = "11EB013E1E218EE05EC89A429A7652D4")

    @SdkConstant(SdkConstantType.INTENT_CATEGORY)
    public static final String CATEGORY_CAR_MODE = "android.intent.category.CAR_MODE";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.085 -0500", hash_original_field = "DD8ED667B09FD32BFCBEEE90F98708D0", hash_generated_field = "3A858C783B7BB37E612CFC1E7656166A")

    // ---------------------------------------------------------------------
    // Application launch intent categories (see addCategory()).

    /**
     * Used with {@link #ACTION_MAIN} to launch the browser application.
     * The activity should be able to browse the Internet.
     * <p>NOTE: This should not be used as the primary key of an Intent,
     * since it will not result in the app launching with the correct
     * action and category.  Instead, use this with
     * {@link #makeMainSelectorActivity(String, String) to generate a main
     * Intent with this category in the selector.</p>
     */
    @SdkConstant(SdkConstantType.INTENT_CATEGORY)
    public static final String CATEGORY_APP_BROWSER = "android.intent.category.APP_BROWSER";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.087 -0500", hash_original_field = "BE76F90FB8E929E20ECFA5220AC43A33", hash_generated_field = "853D7E6DF6CA42B03E49C059E11DF6B2")

    @SdkConstant(SdkConstantType.INTENT_CATEGORY)
    public static final String CATEGORY_APP_CALCULATOR = "android.intent.category.APP_CALCULATOR";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.089 -0500", hash_original_field = "3383F1F5E11EB701D06466E2A586EC62", hash_generated_field = "34490E78A1770B88FB00C51722A480EF")

    @SdkConstant(SdkConstantType.INTENT_CATEGORY)
    public static final String CATEGORY_APP_CALENDAR = "android.intent.category.APP_CALENDAR";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.092 -0500", hash_original_field = "0C2E2E57DB83728CA2AD102E81252A51", hash_generated_field = "23D411EC9BD34EB1956A7D20894B6F6B")

    @SdkConstant(SdkConstantType.INTENT_CATEGORY)
    public static final String CATEGORY_APP_CONTACTS = "android.intent.category.APP_CONTACTS";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.094 -0500", hash_original_field = "5AD276ECA4ECAFD0A534A0EDEC236DC3", hash_generated_field = "B32849993CE54474DA658C00B93E9B06")

    @SdkConstant(SdkConstantType.INTENT_CATEGORY)
    public static final String CATEGORY_APP_EMAIL = "android.intent.category.APP_EMAIL";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.097 -0500", hash_original_field = "7D6473EC60A9BA49185D26378AAD5510", hash_generated_field = "1AAD6D97E778061C4FC6B4579DBE698E")

    @SdkConstant(SdkConstantType.INTENT_CATEGORY)
    public static final String CATEGORY_APP_GALLERY = "android.intent.category.APP_GALLERY";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.100 -0500", hash_original_field = "C87ED3A6E5ECAD5AD155DF45E8CEC5C4", hash_generated_field = "461AB4F858B20EDD3DC6D9BABFB25213")

    @SdkConstant(SdkConstantType.INTENT_CATEGORY)
    public static final String CATEGORY_APP_MAPS = "android.intent.category.APP_MAPS";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.102 -0500", hash_original_field = "C6C6ABA007F9776C4978C6E3E6D7BAFC", hash_generated_field = "6E28A6D64C719D9421924F3B66DE5BA8")

    @SdkConstant(SdkConstantType.INTENT_CATEGORY)
    public static final String CATEGORY_APP_MESSAGING = "android.intent.category.APP_MESSAGING";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.105 -0500", hash_original_field = "8BCFB348A483ED54B6D4D1A8B39713FE", hash_generated_field = "7A01F1FB260B6B7E22C7231435E514F6")

    @SdkConstant(SdkConstantType.INTENT_CATEGORY)
    public static final String CATEGORY_APP_MUSIC = "android.intent.category.APP_MUSIC";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.107 -0500", hash_original_field = "92764CF4D06433171DDF2F967CA6DB02", hash_generated_field = "0CA15AD2535837CBE88DF60446840D7A")

    // ---------------------------------------------------------------------
    // Standard extra data keys.

    /**
     * The initial data to place in a newly created record.  Use with
     * {@link #ACTION_INSERT}.  The data here is a Map containing the same
     * fields as would be given to the underlying ContentProvider.insert()
     * call.
     */
    public static final String EXTRA_TEMPLATE = "android.intent.extra.TEMPLATE";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.110 -0500", hash_original_field = "C2B9E11951A0C60D52CCB6E33E5F09F0", hash_generated_field = "72214008F2D28B6F2C57EBF8F3F522E8")

    public static final String EXTRA_TEXT = "android.intent.extra.TEXT";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.113 -0500", hash_original_field = "8CF1AA11D6FDE4626A7EFBCB311FB64B", hash_generated_field = "EC4454CE33F6CC89842034B94C293389")

    public static final String EXTRA_STREAM = "android.intent.extra.STREAM";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.115 -0500", hash_original_field = "3FB042F0B1CFE55875114A54CE4478A2", hash_generated_field = "EBFD2B12F95245B3FBC9DF7A00777B71")

    public static final String EXTRA_EMAIL       = "android.intent.extra.EMAIL";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.117 -0500", hash_original_field = "82471F5362F7A4C1DB1F7D0D2F91C606", hash_generated_field = "8AFD20100EA68B345A45C08A01ECDB1C")

    public static final String EXTRA_CC       = "android.intent.extra.CC";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.120 -0500", hash_original_field = "83777445571BC031914B9E861DE6F7C9", hash_generated_field = "248F5D1EC476962B448213113152C27D")

    public static final String EXTRA_BCC      = "android.intent.extra.BCC";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.122 -0500", hash_original_field = "3AF2B0F789939C22CB2A84B6E2477449", hash_generated_field = "419F13F40D6F3539A0ADBB0EE25BDC61")

    public static final String EXTRA_SUBJECT  = "android.intent.extra.SUBJECT";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.124 -0500", hash_original_field = "C44537A13B60E302478089F301735BD2", hash_generated_field = "6C385524243DA13629D46DD4A076B2BE")

    public static final String EXTRA_INTENT = "android.intent.extra.INTENT";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.127 -0500", hash_original_field = "30089B3EE6873B911ECC3E7ECCB180BF", hash_generated_field = "442A91F2FCA42809657F776F47AC14A2")

    public static final String EXTRA_TITLE = "android.intent.extra.TITLE";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.129 -0500", hash_original_field = "F650DAC334F4F2B3F767C9CB41087943", hash_generated_field = "83F4ECB331C2C4D31F6BF841AA493392")

    public static final String EXTRA_INITIAL_INTENTS = "android.intent.extra.INITIAL_INTENTS";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.131 -0500", hash_original_field = "9431E954509980745D80324E0DDC429A", hash_generated_field = "B22AF3F2DD8C690301A6C16272B182E6")

    public static final String EXTRA_KEY_EVENT = "android.intent.extra.KEY_EVENT";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.133 -0500", hash_original_field = "41C7C72DE2341FE1B4ABB4ABD6FA67EC", hash_generated_field = "5A5722737DD73618327545E77C22EC76")

    public static final String EXTRA_KEY_CONFIRM = "android.intent.extra.KEY_CONFIRM";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.136 -0500", hash_original_field = "FA877C6EC063DD6078698C5AE7611390", hash_generated_field = "86E9F818118C4911260709A9CE25ABBF")

    public static final String EXTRA_DONT_KILL_APP = "android.intent.extra.DONT_KILL_APP";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.138 -0500", hash_original_field = "93793DC8B041AEA84BC3D4C2C2D87F82", hash_generated_field = "250F8F3445ECA42F404D7699D0878462")

    public static final String EXTRA_PHONE_NUMBER = "android.intent.extra.PHONE_NUMBER";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.140 -0500", hash_original_field = "53AE8042304B61B28AEABE117CC4E67A", hash_generated_field = "784764F75FCAF4D594484BAE3D08E782")

    public static final String EXTRA_UID = "android.intent.extra.UID";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.142 -0500", hash_original_field = "FBACE614E1ED697EAA85B71966920594", hash_generated_field = "DA292F34D2C63F59038060862D3FBD56")

    public static final String EXTRA_PACKAGES = "android.intent.extra.PACKAGES";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.145 -0500", hash_original_field = "EFD2D39DD5793DD7A282F5B4587FC192", hash_generated_field = "13D45ED3B0C6FB86F2CDE61794B5F803")

    public static final String EXTRA_DATA_REMOVED = "android.intent.extra.DATA_REMOVED";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.148 -0500", hash_original_field = "E3B96BFD86444C2F088AA5C87F39DE8D", hash_generated_field = "418341504F0A4D6308A9E99137AEAD7B")

    public static final String EXTRA_REPLACING = "android.intent.extra.REPLACING";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.150 -0500", hash_original_field = "079CEF1D03116DEB057DADEB1EDC3364", hash_generated_field = "A8F2D11013AECF3F2B67B1FBE5E632E8")

    public static final String EXTRA_ALARM_COUNT = "android.intent.extra.ALARM_COUNT";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.152 -0500", hash_original_field = "4C937BEF96EFA24AD126823E1507996A", hash_generated_field = "117449B583EA94D1C241A664ADE13004")

    public static final String EXTRA_DOCK_STATE = "android.intent.extra.DOCK_STATE";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.155 -0500", hash_original_field = "28CBA9B9F2D1AFD97A31ED8E94B8F78D", hash_generated_field = "51DD9310B52641CEBF8E5912ABBF09BB")

    public static final int EXTRA_DOCK_STATE_UNDOCKED = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.158 -0500", hash_original_field = "FE6741085E4D8F2DC926332AE228064F", hash_generated_field = "57A27A4EFB33D3F5C84CA5A20B8F39B3")

    public static final int EXTRA_DOCK_STATE_DESK = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.161 -0500", hash_original_field = "9DF5AC5A059CF8D8473378F7C26DAE14", hash_generated_field = "75F49C97684FECC9E5C28B82E7E20EBF")

    public static final int EXTRA_DOCK_STATE_CAR = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.164 -0500", hash_original_field = "7AB1F280A4A2A8BF8D9571D2BCEB9319", hash_generated_field = "F7634A037B9D5564993679CDF49FD88B")

    public static final int EXTRA_DOCK_STATE_LE_DESK = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.166 -0500", hash_original_field = "61F242539C7142D45E8B8DE74D6BA52F", hash_generated_field = "6EB3D92262E3C4391652FCAA2CEBA4A1")

    public static final int EXTRA_DOCK_STATE_HE_DESK = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.169 -0500", hash_original_field = "3D01870FD73A89B103E22ED07DE0EDAD", hash_generated_field = "848D2959548644F6D0600879EF0668A2")

    public static final String METADATA_DOCK_HOME = "android.dock_home";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.171 -0500", hash_original_field = "25D2C8EC005077A62A963A8D65605A6B", hash_generated_field = "9274BDF219627A5BD62F1500834D5081")

    public static final String EXTRA_BUG_REPORT = "android.intent.extra.BUG_REPORT";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.174 -0500", hash_original_field = "76A6FA3D774D8D98E40A748D820896AD", hash_generated_field = "58A65C26300F59D945079081B32418DA")

    public static final String EXTRA_REMOTE_INTENT_TOKEN =
            "android.intent.extra.remote_intent_token";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.176 -0500", hash_original_field = "8D338C536788BFD24A5A51D8E8AB2669", hash_generated_field = "E39BA7649A125B42097E11ABF6A59B91")

    @Deprecated public static final String EXTRA_CHANGED_COMPONENT_NAME =
            "android.intent.extra.changed_component_name";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.178 -0500", hash_original_field = "0CF501A7BDB6B7DDD14C94638FA5D0C3", hash_generated_field = "1396139177598651F4FE696440AA6B60")

    public static final String EXTRA_CHANGED_COMPONENT_NAME_LIST =
            "android.intent.extra.changed_component_name_list";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.180 -0500", hash_original_field = "094D2080F87F58C3A626EB3CF998E8F2", hash_generated_field = "9F6BB52BB136081B0B5B704137151D62")

    public static final String EXTRA_CHANGED_PACKAGE_LIST =
            "android.intent.extra.changed_package_list";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.183 -0500", hash_original_field = "12452D95F908A28143BE566A06E08C95", hash_generated_field = "0A835C4E438F2FB3E3F07E556FA3173A")

    public static final String EXTRA_CHANGED_UID_LIST =
            "android.intent.extra.changed_uid_list";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.185 -0500", hash_original_field = "74EF14D280E81CDD74BFE67F09B7D947", hash_generated_field = "CE2CE80B4644D04179C8E3EAC591C752")

    public static final String EXTRA_CLIENT_LABEL =
            "android.intent.extra.client_label";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.188 -0500", hash_original_field = "1F6E915866D36F58A9CC91E0A5DE20A7", hash_generated_field = "7990A58774E5328794603E8DA07B84D6")

    public static final String EXTRA_CLIENT_INTENT =
            "android.intent.extra.client_intent";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.191 -0500", hash_original_field = "1907EC4328314C4971EE226ECEABFF65", hash_generated_field = "32EF8D5E473BF09D7DFE2474A075B3EF")

    public static final String EXTRA_LOCAL_ONLY =
        "android.intent.extra.LOCAL_ONLY";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.193 -0500", hash_original_field = "81B9E3E9E646F2EF92490D82EF13ED9D", hash_generated_field = "1E85859DD66F8DD99928A7D752B58291")

    // ---------------------------------------------------------------------
    // Intent flags (see mFlags variable).

    /**
     * If set, the recipient of this Intent will be granted permission to
     * perform read operations on the Uri in the Intent's data.
     */
    public static final int FLAG_GRANT_READ_URI_PERMISSION = 0x00000001;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.196 -0500", hash_original_field = "DB32AB0C2387714D15291A8C82417B7F", hash_generated_field = "AD11D27A7135AF27D29F8A1800E38B48")

    public static final int FLAG_GRANT_WRITE_URI_PERMISSION = 0x00000002;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.198 -0500", hash_original_field = "5C2C6D62B6FD9E38B018FDA028400F9B", hash_generated_field = "F5144D0DD2B503AE068147CFB8AF3E20")

    public static final int FLAG_FROM_BACKGROUND = 0x00000004;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.200 -0500", hash_original_field = "51A20F2C4825EFB74C9083CDE53E475D", hash_generated_field = "4992800D2B3327EB8ABD9B8392D76E59")

    public static final int FLAG_DEBUG_LOG_RESOLUTION = 0x00000008;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.203 -0500", hash_original_field = "AF02D5CAF2DAEA1D6A1A36B4E23C2FDC", hash_generated_field = "F0503BB7715C67922785A00785804343")

    public static final int FLAG_EXCLUDE_STOPPED_PACKAGES = 0x00000010;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.205 -0500", hash_original_field = "F90ED170E49C524CDF7408650C77BE55", hash_generated_field = "6BF870212E33BF54D2F47B772F7E1D4D")

    public static final int FLAG_INCLUDE_STOPPED_PACKAGES = 0x00000020;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.207 -0500", hash_original_field = "BB27BD58B45784A50B9CAA68A8172DEF", hash_generated_field = "2C482F373AA08BD3E8BAE66D0ABEB4A1")

    public static final int FLAG_ACTIVITY_NO_HISTORY = 0x40000000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.209 -0500", hash_original_field = "BE09383BE7CDD702AD7B3792A43CE8D2", hash_generated_field = "F1C3991F7C5363979EB2F7071FC1B1E7")

    public static final int FLAG_ACTIVITY_SINGLE_TOP = 0x20000000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.212 -0500", hash_original_field = "48B03C90481F8C945F74B5C8BA8B955A", hash_generated_field = "CB2EB43571F9F913DD85855F2A62F676")

    public static final int FLAG_ACTIVITY_NEW_TASK = 0x10000000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.214 -0500", hash_original_field = "EFB5684CDE15637200BA49B6B31F62FB", hash_generated_field = "5331C0D5175D1B442B1E11194633885C")

    public static final int FLAG_ACTIVITY_MULTIPLE_TASK = 0x08000000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.217 -0500", hash_original_field = "61167CB62449D315EDF529EFBB71DECB", hash_generated_field = "D15C6C6162723C7D62F659062880F6F9")

    public static final int FLAG_ACTIVITY_CLEAR_TOP = 0x04000000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.219 -0500", hash_original_field = "1F97402920E3CB809ABA8A72755B9C2E", hash_generated_field = "F049434BC355C895C7B98BCE57D6923A")

    public static final int FLAG_ACTIVITY_FORWARD_RESULT = 0x02000000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.222 -0500", hash_original_field = "47045021605DC088F6AC9EF129C23F1D", hash_generated_field = "A963C95BDF18D2B0A0A3417D1EB14C63")

    public static final int FLAG_ACTIVITY_PREVIOUS_IS_TOP = 0x01000000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.224 -0500", hash_original_field = "93EFF74362F4F5EFD2BC865987E041FB", hash_generated_field = "93C6E464C79835E60A724A0F138B2E5A")

    public static final int FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS = 0x00800000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.226 -0500", hash_original_field = "FD37C4AF597A556F42431E365E09C3F0", hash_generated_field = "475E818BB383C15D3EB34352066AF070")

    public static final int FLAG_ACTIVITY_BROUGHT_TO_FRONT = 0x00400000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.228 -0500", hash_original_field = "FDA0D3B1991B6BDDBB2E1F6C5AED6A86", hash_generated_field = "09C09520072C3FC5B6B5D304280BB98B")

    public static final int FLAG_ACTIVITY_RESET_TASK_IF_NEEDED = 0x00200000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.232 -0500", hash_original_field = "7964BA7B371D3A3AB5533D1E87561E4D", hash_generated_field = "E6A8EC3B88D6C8ADD31C990D62C7170C")

    public static final int FLAG_ACTIVITY_LAUNCHED_FROM_HISTORY = 0x00100000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.234 -0500", hash_original_field = "F4FDF1612D18B199472CF4B0E8C48C17", hash_generated_field = "0A9BB1EBF39780BBC96BF9154BADA771")

    public static final int FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET = 0x00080000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.236 -0500", hash_original_field = "9CC8DB591EA41B24B8958B0DC44D187C", hash_generated_field = "BBB8D1C2213AA3D2546EE97A96B54CB3")

    public static final int FLAG_ACTIVITY_NO_USER_ACTION = 0x00040000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.239 -0500", hash_original_field = "0F609468A5021FA5453197B5CBF665C2", hash_generated_field = "CD635E17DCA336DCD58C5F1450A5987B")

    public static final int FLAG_ACTIVITY_REORDER_TO_FRONT = 0X00020000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.241 -0500", hash_original_field = "CCC252870876E21B900B8B8332C0A67B", hash_generated_field = "2D9D2B18DAADEC730FD6599A8ACA6995")

    public static final int FLAG_ACTIVITY_NO_ANIMATION = 0X00010000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.243 -0500", hash_original_field = "E3F6ED96545AA6782441DC9154B7D59F", hash_generated_field = "486F83A3C19D70714934307A944E56C2")

    public static final int FLAG_ACTIVITY_CLEAR_TASK = 0X00008000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.246 -0500", hash_original_field = "85B7B9A458436EA4B8FB1CFFA2D26E5D", hash_generated_field = "3DDA11574C4AF819E971AFE75A5CC07F")

    public static final int FLAG_ACTIVITY_TASK_ON_HOME = 0X00004000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.248 -0500", hash_original_field = "CA20E3B77B92D96FE3DCFF381C631115", hash_generated_field = "9E9DE382F25B3D58CC45D1E0C5D1436F")

    public static final int FLAG_RECEIVER_REGISTERED_ONLY = 0x40000000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.250 -0500", hash_original_field = "667D353EC090A7C66DB4387089FC2E8F", hash_generated_field = "8E1ED2FC53376B3E78D1743C1F51D866")

    public static final int FLAG_RECEIVER_REPLACE_PENDING = 0x20000000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.252 -0500", hash_original_field = "EECAACA91088AAAA3E94CA6D1C99BB2B", hash_generated_field = "7603B3041648CE612B1F62C28DF51220")

    public static final int FLAG_RECEIVER_REGISTERED_ONLY_BEFORE_BOOT = 0x10000000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.254 -0500", hash_original_field = "7F1358C3B59810185747088B73F08DE1", hash_generated_field = "4D515443C5DB3D74B79815278456FCD3")

    public static final int FLAG_RECEIVER_BOOT_UPGRADE = 0x08000000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.257 -0500", hash_original_field = "9FA60C4C6FFA1D8AB74306EBB8E76C78", hash_generated_field = "FD626475D9F6D6885F7E9DE54C1764F4")

    public static final int IMMUTABLE_FLAGS =
            FLAG_GRANT_READ_URI_PERMISSION
            | FLAG_GRANT_WRITE_URI_PERMISSION;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.259 -0500", hash_original_field = "53E1D1AD4CBE5B9BD0CE12223A0D4D1D", hash_generated_field = "EC62E12AC4AD2FAE9B42EEB4D4F55324")

    // ---------------------------------------------------------------------
    // toUri() and parseUri() options.

    /**
     * Flag for use with {@link #toUri} and {@link #parseUri}: the URI string
     * always has the "intent:" scheme.  This syntax can be used when you want
     * to later disambiguate between URIs that are intended to describe an
     * Intent vs. all others that should be treated as raw URIs.  When used
     * with {@link #parseUri}, any other scheme will result in a generic
     * VIEW action for that raw URI.
     */
    public static final int URI_INTENT_SCHEME = 1<<0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.550 -0500", hash_original_field = "7EFAC47914EB97CEB850F993B6D06CDB", hash_generated_field = "63F981009E9BE73A1613A3A86CDA35C4")

    public static final int FILL_IN_ACTION = 1<<0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.552 -0500", hash_original_field = "4F543F80D247ED3F2650C225974DBA77", hash_generated_field = "467AD345159485AE2F5ED6775DC51B27")

    public static final int FILL_IN_DATA = 1<<1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.554 -0500", hash_original_field = "FF9A07406EFD4C371CB9FA401F53B5F2", hash_generated_field = "E89FFA2B091BAA2212245B31F564CFFF")

    public static final int FILL_IN_CATEGORIES = 1<<2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.557 -0500", hash_original_field = "7BE7A8727974DF1AC28B0E68FB9EF09D", hash_generated_field = "6A3A0FFA6E425DF959306D11B15FF92D")

    public static final int FILL_IN_COMPONENT = 1<<3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.560 -0500", hash_original_field = "0BB5AAECAC451FBFE7680FFF41F3C46B", hash_generated_field = "363CC3E98D7D1AC7FC1E2718D2D54631")

    public static final int FILL_IN_PACKAGE = 1<<4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.562 -0500", hash_original_field = "122D67A1193CA820B8D003C76F1535C5", hash_generated_field = "87B57C3E1EED611456B2BA9EAB493CAA")

    public static final int FILL_IN_SOURCE_BOUNDS = 1<<5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.565 -0500", hash_original_field = "03DD79A31437903A5D60C344CDE466EB", hash_generated_field = "F1670B3FCB0D6CFDDC829822B3B96A6F")

    public static final int FILL_IN_SELECTOR = 1<<6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.493 -0400", hash_original_field = "D14178DBCD458ABEE4FEAD50EBCFE74B", hash_generated_field = "B872AD5D6A6EEC2D35FED959BF1EC3BA")

    public static final Parcelable.Creator<Intent> CREATOR
            = new Parcelable.Creator<Intent>() {
        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.617 -0500", hash_original_method = "F9E3C09B709E0EDEDA66B8BB83B427D5", hash_generated_method = "D17491F45B3D1A9A7E33CB57F7E14A74")
        
public Intent createFromParcel(Parcel in) {
            return new Intent(in);
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.619 -0500", hash_original_method = "44BCAE850DE57DDD4EABB7D1FBBBB969", hash_generated_method = "3704EE392171F07E514F70F729DBB684")
        
public Intent[] newArray(int size) {
            return new Intent[size];
        }
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.262 -0500", hash_original_field = "8C9CE7EB6713765D87B246A6B527F11C", hash_generated_field = "6BA7274A46303AB4A280C73477809BB1")

    @DSVAModeled
    private String mAction;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.264 -0500", hash_original_field = "5D8362EBD99622D5EB2A35214E4F749B", hash_generated_field = "EAE374FAE80C7320375D0E6D6C17A234")

    @DSVAModeled
    private Uri mData;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.266 -0500", hash_original_field = "1672B69A08B1383BA3D3C191D3C06566", hash_generated_field = "DA7F98239A4F122D17620AC61DF29F55")

    @DSVAModeled
    private String mType;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.268 -0500", hash_original_field = "024AAB9E2577CC3DE3304162F102B92C", hash_generated_field = "D6E102019562022F9DE7C9915C7FD917")

    @DSVAModeled
    private String mPackage;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.270 -0500", hash_original_field = "FC166AFC662871D7EC38777C0105881C", hash_generated_field = "1B40E7C57A0B1682389BAE16521C0844")

    @DSVAModeled
    private ComponentName mComponent;

   @DSVAModeled
   private Class<?> mClsComponent;

@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.272 -0500", hash_original_field = "4E5A87EA4636A8ACF68875B877F3A7B8", hash_generated_field = "43F71E9173849705E01112D0229448B4")

    @DSVAModeled
    private int mFlags;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.275 -0500", hash_original_field = "F5406B98105BE593D67B771784EBBF5F", hash_generated_field = "0CC4E2884DD354D66A438C7E26DB89B1")

    private HashSet<String> mCategories;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.276 -0500", hash_original_field = "8E33C9E28D87B1286C4160446ABF7B5C", hash_generated_field = "5596C79D633F3A9F64294D3BD6D43156")

    @DSVAModeled
    private Map<String, Object> mExtras;

    //added by droidsafe
    private Bundle mBundle = new Bundle();

@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.278 -0500", hash_original_field = "708E5F39540EB50A3784AFB8B598ECB4", hash_generated_field = "B906B02E252E86FB4170D1D8409B9103")

    private Rect mSourceBounds;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.281 -0500", hash_original_field = "06832ADB256ECCC21128BB7F5B657E0D", hash_generated_field = "E0BD8AEFA324D8DA702D2534D195AB3A")

    private Intent mSelector;

    // ---------------------------------------------------------------------

    /**
     * Create an empty intent.
     */
    @DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.283 -0500", hash_original_method = "5C0F2C7B56AA3A635FE64462CDD8279E", hash_generated_method = "CA02BD6062B99ED9FB67966A876306F0")
    
public Intent() {
        mExtras = new HashMap<String, Object>();//new Bundle();
    }
    
    @DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.415 -0400", hash_original_method = "3FAB664599EE7924CC36F277EFA522C8", hash_generated_method = "AB0CC1E246524C1E63F16EBEA02DAD1F")
    public  Intent(Intent o) {
        this.mAction = o.mAction;
        this.mData = o.mData;
        this.mType = o.mType;
        this.mPackage = o.mPackage;
        this.mComponent = o.mComponent;
        this.mClsComponent = mClsComponent;
        this.mFlags = o.mFlags;
        if(o.mCategories != null)        
        {
            this.mCategories = new HashSet<String>(o.mCategories);
        } //End block
        if(o.mExtras != null)        
        {
            this.mExtras = new HashMap<String,Object>();//Bundle(o.mExtras);
        } //End block
        if(o.mSourceBounds != null)        
        {
            this.mSourceBounds = new Rect(o.mSourceBounds);
        } //End block
        if(o.mSelector != null)        
        {
            this.mSelector = new Intent(o.mSelector);
        } //End block
        addTaint(getTaint());
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
    
	@DSComment("constructor")
    @DSBan(DSCat.PRIVATE_METHOD)
    private Intent(Intent o, boolean all) {
            this();
		/*
		 * Piggyback on the setters to track the taint.  The desire here
		 * is to "inherit" the taint from the Intent that is passed in
		 */
		this.setAction(o.getAction());
		this.setData(o.getData());
		this.setType(o.getType());
		this.setPackage(o.getPackage());
		this.setComponent(o.getComponent());
                this.mClsComponent = mClsComponent;
                
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
    
	@DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    public Intent(String action) {
            this();
        mAction = action;
    }
    
	@DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    public Intent(String action, Uri uri) {
            this();
        mAction = action;
        mData = uri;
    }
    
    @DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.417 -0400", hash_original_method = "8A8F598E2C7B57A58F1379D7AFC8B81F", hash_generated_method = "CFC95A750DAD5D8F9B4AF9DD7CFFB32A")
    public  Intent(Context packageContext, Class<?> cls) {
        this();
        mClsComponent = cls;
        mComponent = new ComponentName(packageContext, cls.getName());
        // ---------- Original Method ----------
        //mComponent = new ComponentName(packageContext, cls);
    }
    
    @DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.417 -0400", hash_original_method = "780AF3DA4D357977F460A8077F315476", hash_generated_method = "6432A8C7753059113592629EBEB24128")
    public  Intent(String action, Uri uri,
            Context packageContext, Class<?> cls) {
        this();
        mClsComponent = cls;
        addTaint(action.getTaint());
        setAction(action);
        mData = uri;
        mComponent = new ComponentName(packageContext, cls.getName());
        // ---------- Original Method ----------
        //setAction(action);
        //mData = uri;
        //mComponent = new ComponentName(packageContext, cls);
    }

    /** @hide */
    @DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.624 -0500", hash_original_method = "BDABA8F9DB7F141DA2E5B48F186347CF", hash_generated_method = "FD782D49799CFD91C295FAFFCE111B9E")
    
protected Intent(Parcel in) {
        this();
        readFromParcel(in);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.288 -0500", hash_original_method = "0DE1E082CFAE738C657D3967F7BD3FA4", hash_generated_method = "70D87F5C5833337B2F59C8685D6E3D8A")
    
@Override
    public Object clone() {
        return new Intent(this);
    }

    /**
     * Make a clone of only the parts of the Intent that are relevant for
     * filter matching: the action, data, type, component, and categories.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.293 -0500", hash_original_method = "321DCA737B51074721765C9DBE3DB18C", hash_generated_method = "5FAC7568D6F34C6CC0CF3C57502A9AD0")
    
public Intent cloneFilter() {
        return new Intent(this, false);
    }

    /**
     * Retrieve the general action to be performed, such as
     * {@link #ACTION_VIEW}.  The action describes the general way the rest of
     * the information in the intent should be interpreted -- most importantly,
     * what to do with the data returned by {@link #getData}.
     *
     * @return The action of this intent or null if none is specified.
     *
     * @see #setAction
     */
    @DSComment("movement of Intent is spec")
    @DSSafe(DSCat.DATA_STRUCTURE)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.325 -0500", hash_original_method = "2F09B930D511D23A5EF1D9DB36B884EA", hash_generated_method = "2CBE2F0FEBD06003F64E120CD0AB8A01")
    
public String getAction() {
        return mAction;
    }

    /**
     * Retrieve data this intent is operating on.  This URI specifies the name
     * of the data; often it uses the content: scheme, specifying data in a
     * content provider.  Other schemes may be handled by specific activities,
     * such as http: by the web browser.
     *
     * @return The URI of the data this intent is targeting or null.
     *
     * @see #getScheme
     * @see #setData
     */
    @DSComment("movement of Intent is spec")
    @DSSafe(DSCat.DATA_STRUCTURE)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.327 -0500", hash_original_method = "E338941BA5F359CEDBE88CD11D2A1B67", hash_generated_method = "047382CB53A55CF7017DED36BC09DD15")
    
public Uri getData() {
        return mData;
    }
    
	@DSComment("movement of Intent is spec")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    public String getDataString() {
		return mData.toString();
        //return mData != null ? mData.toString() : null;
    }

    /**
     * Return the scheme portion of the intent's data.  If the data is null or
     * does not include a scheme, null is returned.  Otherwise, the scheme
     * prefix without the final ':' is returned, i.e. "http".
     *
     * <p>This is the same as calling getData().getScheme() (and checking for
     * null data).
     *
     * @return The scheme of this intent.
     *
     * @see #getData
     */
    @DSComment("movement of Intent is spec")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.331 -0500", hash_original_method = "773226227E17626211D04D8FDBCEC473", hash_generated_method = "B6D32FCF7D86EEC762FE19FA178F0441")
    
public String getScheme() {
        return mData != null ? mData.getScheme() : null;
    }

    /**
     * Retrieve any explicit MIME type included in the intent.  This is usually
     * null, as the type is determined by the intent data.
     *
     * @return If a type was manually set, it is returned; else null is
     *         returned.
     *
     * @see #resolveType(ContentResolver)
     * @see #setType
     */
    @DSComment("movement of Intent is spec")
    @DSSafe(DSCat.DATA_STRUCTURE)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.333 -0500", hash_original_method = "F57356AE1A37FC524BD36BB2BA67325B", hash_generated_method = "FD34A57B2342B04CD78207BBDCFD6F8F")
    
public String getType() {
        return mType;
    }

    /**
     * Return the MIME data type of this intent.  If the type field is
     * explicitly set, that is simply returned.  Otherwise, if the data is set,
     * the type of that data is returned.  If neither fields are set, a null is
     * returned.
     *
     * @return The MIME type of this intent.
     *
     * @see #getType
     * @see #resolveType(ContentResolver)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.335 -0500", hash_original_method = "BE275DDE2732AB3F4C79CA9D98784573", hash_generated_method = "66BE17CD09D5B5BA95935952938962E4")
    
public String resolveType(Context context) {
        return resolveType(context.getContentResolver());
    }
    
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
    
	@DSComment("movement of Intent is spec")
    @DSSafe(DSCat.DATA_STRUCTURE)
    
    public String resolveTypeIfNeeded(ContentResolver resolver) {
		/*
		if (mComponent != null) {
		    return getType();
		}
		return resolveType(resolver);
		*/
		return getType();  //At the end of the day, it's a string, and we are doing static analysis
    }

    /**
     * Check if an category exists in the intent.
     *
     * @param category The category to check.
     *
     * @return boolean True if the intent contains the category, else false.
     *
     * @see #getCategories
     * @see #addCategory
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.342 -0500", hash_original_method = "3612221F73372432993CCD6954A20D1D", hash_generated_method = "7915D278B71B4651DCC24C6686319D9A")
    
public boolean hasCategory(String category) {
        return mCategories != null && mCategories.contains(category);
    }

    /**
     * Return the set of all categories in the intent.  If there are no categories,
     * returns NULL.
     *
     * @return The set of categories you can examine.  Do not modify!
     *
     * @see #hasCategory
     * @see #addCategory
     */
    @DSComment("movement of Intent is spec")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.344 -0500", hash_original_method = "44E921F5CBF6AA9462AF2EF773666A6D", hash_generated_method = "E43A5082517AA30FD1672CDE76A65C68")
    
public Set<String> getCategories() {
        return mCategories;
    }

    /**
     * Return the specific selector associated with this Intent.  If there is
     * none, returns null.  See {@link #setSelector} for more information.
     *
     * @see #setSelector
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.345 -0500", hash_original_method = "0EFF867FD71A8B842E16179807F3AE79", hash_generated_method = "223EF73B005FF77EF26EC1D85CD03C83")
    
public Intent getSelector() {
        return mSelector;
    }

    /**
     * Sets the ClassLoader that will be used when unmarshalling
     * any Parcelable values from the extras of this Intent.
     *
     * @param loader a ClassLoader, or null to use the default loader
     * at the time of unmarshalling.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.347 -0500", hash_original_method = "C5389CB5192CD8E55615D6E62222251D", hash_generated_method = "1742444D8E555DE140BADD2B12A1C195")
    
public void setExtrasClassLoader(ClassLoader loader) {
        //        if (mExtras != null) {
            //mExtras.setClassLoader(loader);
        // }
    }

    /**
     * Returns true if an extra value is associated with the given name.
     * @param name the extra's name
     * @return true if the given extra is present.
     */
    @DSComment("movement of Intent is spec")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.350 -0500", hash_original_method = "820997F7D9BF8A8B37DA5723F540EC8D", hash_generated_method = "4CC0BD1A213F434B44B78EBB77DCCBE2")
    
public boolean hasExtra(String name) {
        return mExtras != null && mExtras.containsKey(name);
    }

    /**
     * Returns true if the Intent's extras contain a parcelled file descriptor.
     * @return true if the Intent contains a parcelled file descriptor.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.352 -0500", hash_original_method = "A4A187292984F1C3EE73C7C78931040C", hash_generated_method = "B45047FD99E72F75FF3244AA3317BDA2")
    
public boolean hasFileDescriptors() {
        return true;// mExtras != null && mExtras.hasFileDescriptors();
    }
    
	@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    public void setAllowFds(boolean allowFds) {
		// NOTE:  mExtras is a Bundle, perhaps it is best to push the taint down to that level
		addTaint(allowFds);
		/*
        if (mExtras != null) {
            mExtras.setAllowFds(allowFds);
        }
        */
    }

    /**
     * Retrieve extended data from the intent.
     *
     * @param name The name of the desired item.
     *
     * @return the value of an item that previously added with putExtra()
     * or null if none was found.
     *
     * @deprecated
     * @hide
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.356 -0500", hash_original_method = "4C23C66584C2E08F8D8923DC65F21B8A", hash_generated_method = "8E55B4B1B007A0564AE7967E42C097A0")
    
@Deprecated
    public Object getExtra(String name) {
        return getExtra(name, null);
    }

    /**
     * Retrieve extended data from the intent.
     *
     * @param name The name of the desired item.
     * @param defaultValue the value to be returned if no value of the desired
     * type is stored with the given name.
     *
     * @return the value of an item that previously added with putExtra()
     * or the default value if none was found.
     *
     * @see #putExtra(String, boolean)
     */
    @DSComment("movement of Intent is spec")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.359 -0500", hash_original_method = "6C77EA53DBDF6A732015829C63BCD454", hash_generated_method = "02A8C2F1680A1423978645221962E29D")
    
public boolean getBooleanExtra(String name, boolean defaultValue) {
        return mExtras == null ? defaultValue :
            ((Boolean)mExtras.get(name)).booleanValue();
    }

    /**
     * Retrieve extended data from the intent.
     *
     * @param name The name of the desired item.
     * @param defaultValue the value to be returned if no value of the desired
     * type is stored with the given name.
     *
     * @return the value of an item that previously added with putExtra()
     * or the default value if none was found.
     *
     * @see #putExtra(String, byte)
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.361 -0500", hash_original_method = "7FB23DDD0BCB246CA49844E5ABE7B23C", hash_generated_method = "9C79D394A2437EF6849851316B5829CF")
    
public byte getByteExtra(String name, byte defaultValue) {
        return mExtras == null ? defaultValue :
            ((Byte)mExtras.get(name)).byteValue();
    }

    /**
     * Retrieve extended data from the intent.
     *
     * @param name The name of the desired item.
     * @param defaultValue the value to be returned if no value of the desired
     * type is stored with the given name.
     *
     * @return the value of an item that previously added with putExtra()
     * or the default value if none was found.
     *
     * @see #putExtra(String, short)
     */
    @DSComment("movement of Intent is spec")
    @DSSafe(DSCat.DATA_STRUCTURE)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.364 -0500", hash_original_method = "7EF2CF350AA07FA1327C85A618EDDBDF", hash_generated_method = "7A2D49D6A8AA9AC64B52D23A1885544E")
    
public short getShortExtra(String name, short defaultValue) {
        return mExtras == null ? defaultValue :
            ((Short)mExtras.get(name)).shortValue();
    }

    /**
     * Retrieve extended data from the intent.
     *
     * @param name The name of the desired item.
     * @param defaultValue the value to be returned if no value of the desired
     * type is stored with the given name.
     *
     * @return the value of an item that previously added with putExtra()
     * or the default value if none was found.
     *
     * @see #putExtra(String, char)
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.366 -0500", hash_original_method = "49AA93250C5B660485540E34F899D621", hash_generated_method = "4D4CAD39AD186500077E3E4B006A1F0E")
    
public char getCharExtra(String name, char defaultValue) {
        return mExtras == null ? defaultValue :
            ((Character)mExtras.get(name)).charValue();
    }

    /**
     * Retrieve extended data from the intent.
     *
     * @param name The name of the desired item.
     * @param defaultValue the value to be returned if no value of the desired
     * type is stored with the given name.
     *
     * @return the value of an item that previously added with putExtra()
     * or the default value if none was found.
     *
     * @see #putExtra(String, int)
     */
    @DSComment("movement of Intent is spec")
    @DSSafe(DSCat.DATA_STRUCTURE)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.368 -0500", hash_original_method = "E0513A91E6CBAE3AB1C6E2298E28F4E9", hash_generated_method = "7536F8C642D6EC6EFAEB49F7A1E8EE03")
    
public int getIntExtra(String name, int defaultValue) {
        return mExtras == null ? defaultValue :
            ((Integer)mExtras.get(name)).intValue();
    }

    /**
     * Retrieve extended data from the intent.
     *
     * @param name The name of the desired item.
     * @param defaultValue the value to be returned if no value of the desired
     * type is stored with the given name.
     *
     * @return the value of an item that previously added with putExtra()
     * or the default value if none was found.
     *
     * @see #putExtra(String, long)
     */
    @DSComment("movement of Intent is spec")
    @DSSafe(DSCat.DATA_STRUCTURE)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.370 -0500", hash_original_method = "C094BEE2071DFD73ABD25F184B7F6CE5", hash_generated_method = "0EF10534F63415F2F7F0D8DF79122B66")
    
public long getLongExtra(String name, long defaultValue) {
        return mExtras == null ? defaultValue :
            ((Long)mExtras.get(name)).longValue();
    }

    /**
     * Retrieve extended data from the intent.
     *
     * @param name The name of the desired item.
     * @param defaultValue the value to be returned if no value of the desired
     * type is stored with the given name.
     *
     * @return the value of an item that previously added with putExtra(),
     * or the default value if no such item is present
     *
     * @see #putExtra(String, float)
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.372 -0500", hash_original_method = "468C9940FDAFD3DDCC0968AC84566FDC", hash_generated_method = "7702D18407DBD55E8482994ED0B8C662")
    
public float getFloatExtra(String name, float defaultValue) {
        return mExtras == null ? defaultValue :
            ((Float)mExtras.get(name)).floatValue();
    }

    /**
     * Retrieve extended data from the intent.
     *
     * @param name The name of the desired item.
     * @param defaultValue the value to be returned if no value of the desired
     * type is stored with the given name.
     *
     * @return the value of an item that previously added with putExtra()
     * or the default value if none was found.
     *
     * @see #putExtra(String, double)
     */
    @DSComment("movement of Intent is spec")
    @DSSafe(DSCat.DATA_STRUCTURE)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.374 -0500", hash_original_method = "9D513802316CA501D261DB0FDD177D9E", hash_generated_method = "237FBC9F07BF14699CA58B8E750592D1")
    
public double getDoubleExtra(String name, double defaultValue) {
        return mExtras == null ? defaultValue :
            ((Double)mExtras.get(name)).doubleValue();
    }

    /**
     * Retrieve extended data from the intent.
     *
     * @param name The name of the desired item.
     *
     * @return the value of an item that previously added with putExtra()
     * or null if no String value was found.
     *
     * @see #putExtra(String, String)
     */
    @DSComment("movement of Intent is spec")
    @DSSafe(DSCat.DATA_STRUCTURE)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.376 -0500", hash_original_method = "8063ECA9F5AA2AEF21F6A345FFE2B7E6", hash_generated_method = "92DA4B9217AE26D6B16B4A7152FDE01A")
    
public String getStringExtra(String name) {
        return mExtras == null ? null : (String)mExtras.get(name);
    }

    /**
     * Retrieve extended data from the intent.
     *
     * @param name The name of the desired item.
     *
     * @return the value of an item that previously added with putExtra()
     * or null if no CharSequence value was found.
     *
     * @see #putExtra(String, CharSequence)
     */
    @DSComment("movement of Intent is spec")
    @DSSafe(DSCat.DATA_STRUCTURE)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.378 -0500", hash_original_method = "1694F41DCC8D039EBF419B4A0F2C4125", hash_generated_method = "0261ACCD25A2458F32FBB474CDC883CF")
    
public CharSequence getCharSequenceExtra(String name) {
        return mExtras == null ? null : (CharSequence)mExtras.get(name);
    }
    
    @DSSpec(DSCat.SERIALIZATION)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.428 -0400", hash_original_method = "1C448816D9B902054FE9E8A698247DA2", hash_generated_method = "3E3DEE7B959E87E94EACE1CB55226D17")
    public <T extends Parcelable> T getParcelableExtra(String name) {
        addTaint(name.getTaint());
        T varE60849F90CB2B10CC4141E5BFED9EBB4_1888496787 =         mExtras == null ? null : (T) mExtras.get(name);
        varE60849F90CB2B10CC4141E5BFED9EBB4_1888496787.addTaint(getTaint());
        return varE60849F90CB2B10CC4141E5BFED9EBB4_1888496787;
        // ---------- Original Method ----------
        //return mExtras == null ? null : mExtras.<T>getParcelable(name);
    }

    /**
     * Retrieve extended data from the intent.
     *
     * @param name The name of the desired item.
     *
     * @return the value of an item that previously added with putExtra()
     * or null if no Parcelable[] value was found.
     *
     * @see #putExtra(String, Parcelable[])
     */
    @DSComment("Data serialization/deserialization")
    @DSSafe(DSCat.SERIALIZATION)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.382 -0500", hash_original_method = "28D360BBB773D3DC39CC6E8B3FB095BE", hash_generated_method = "95CF13FB7C566158CE15E0D32127AEB6")
    
public Parcelable[] getParcelableArrayExtra(String name) {
        return mExtras == null ? null : (Parcelable[])mExtras.get(name);
    }
    
    @DSComment("movement of Intent is spec")
    @DSSafe(DSCat.DATA_STRUCTURE)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.429 -0400", hash_original_method = "BB02D0F500EDCAC2282F912174ECF594", hash_generated_method = "8496E3B52B9613F422993EC5A62C4915")
    public <T extends Parcelable> ArrayList<T> getParcelableArrayListExtra(String name) {
        addTaint(name.getTaint());
        ArrayList<T> var2AA7AC40ADC652D6C8E180CF68F49870_1307005652 =         mExtras == null ? null : (ArrayList<T>)mExtras.get(name);
        return var2AA7AC40ADC652D6C8E180CF68F49870_1307005652;
        // ---------- Original Method ----------
        //return mExtras == null ? null : mExtras.<T>getParcelableArrayList(name);
    }

    /**
     * Retrieve extended data from the intent.
     *
     * @param name The name of the desired item.
     *
     * @return the value of an item that previously added with putExtra()
     * or null if no Serializable value was found.
     *
     * @see #putExtra(String, Serializable)
     */
    @DSComment("movement of Intent is spec")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.386 -0500", hash_original_method = "9F4D1ACCAA6C6918CB97F661FEDB7260", hash_generated_method = "76C340BC56D9F60CF88D86C558C6825B")
    
public Serializable getSerializableExtra(String name) {
        return mExtras == null ? null : (Serializable) mExtras.get(name);
    }

    /**
     * Retrieve extended data from the intent.
     *
     * @param name The name of the desired item.
     *
     * @return the value of an item that previously added with putExtra()
     * or null if no ArrayList<Integer> value was found.
     *
     * @see #putIntegerArrayListExtra(String, ArrayList)
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.388 -0500", hash_original_method = "E5A5C9C6BF01CEEFEAABCB20BBD32323", hash_generated_method = "9D819F72EA76BB36C2E7C757B77E7E73")
    
public ArrayList<Integer> getIntegerArrayListExtra(String name) {
        return mExtras == null ? null : (ArrayList<Integer>)mExtras.get(name);
    }

    /**
     * Retrieve extended data from the intent.
     *
     * @param name The name of the desired item.
     *
     * @return the value of an item that previously added with putExtra()
     * or null if no ArrayList<String> value was found.
     *
     * @see #putStringArrayListExtra(String, ArrayList)
     */
    @DSComment("movement of Intent is spec")
    @DSSafe(DSCat.DATA_STRUCTURE)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.390 -0500", hash_original_method = "D8E538521D5877A04B9E1243CFFC8BD3", hash_generated_method = "C957CBF04B8FE7BC5D3B612E6C8EF2B8")
    
public ArrayList<String> getStringArrayListExtra(String name) {
        return mExtras == null ? null : (ArrayList<String>)mExtras.get(name);
    }

    /**
     * Retrieve extended data from the intent.
     *
     * @param name The name of the desired item.
     *
     * @return the value of an item that previously added with putExtra()
     * or null if no ArrayList<CharSequence> value was found.
     *
     * @see #putCharSequenceArrayListExtra(String, ArrayList)
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.392 -0500", hash_original_method = "3C0B0EF6206949D4005752F37A471C32", hash_generated_method = "ECD41137BFE2663E1A6EF1072F5BC8BD")
    
public ArrayList<CharSequence> getCharSequenceArrayListExtra(String name) {
        return mExtras == null ? null : ( ArrayList<CharSequence> ) mExtras.get(name);
    }

    /**
     * Retrieve extended data from the intent.
     *
     * @param name The name of the desired item.
     *
     * @return the value of an item that previously added with putExtra()
     * or null if no boolean array value was found.
     *
     * @see #putExtra(String, boolean[])
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.394 -0500", hash_original_method = "FE55BFBE9F4BF617BE3A0BE7101EDA89", hash_generated_method = "46C15F919A0BC4FC1F5845C5606E2FCA")
    
public boolean[] getBooleanArrayExtra(String name) {
        return mExtras == null ? null : (boolean[])mExtras.get(name);
    }

    /**
     * Retrieve extended data from the intent.
     *
     * @param name The name of the desired item.
     *
     * @return the value of an item that previously added with putExtra()
     * or null if no byte array value was found.
     *
     * @see #putExtra(String, byte[])
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.397 -0500", hash_original_method = "8982B2CEDDCF3062481CA9400546FBDD", hash_generated_method = "AA610F065416BB90204CAC0C5A97C0BA")
    
public byte[] getByteArrayExtra(String name) {
        return mExtras == null ? null : (byte[])mExtras.get(name);
    }

    /**
     * Retrieve extended data from the intent.
     *
     * @param name The name of the desired item.
     *
     * @return the value of an item that previously added with putExtra()
     * or null if no short array value was found.
     *
     * @see #putExtra(String, short[])
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.400 -0500", hash_original_method = "CD9B24503F7344F42640A5B885850704", hash_generated_method = "C14AAA2A7CB39D2AACEA331C248790B9")
    
public short[] getShortArrayExtra(String name) {
        return mExtras == null ? null : (short[])mExtras.get(name);
    }

    /**
     * Retrieve extended data from the intent.
     *
     * @param name The name of the desired item.
     *
     * @return the value of an item that previously added with putExtra()
     * or null if no char array value was found.
     *
     * @see #putExtra(String, char[])
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.402 -0500", hash_original_method = "CC419D577155763512853EA59FC750C3", hash_generated_method = "6449192E644028A86E4E2A1C58F0BF9F")
    
public char[] getCharArrayExtra(String name) {
        return mExtras == null ? null : (char[])mExtras.get(name);
    }

    /**
     * Retrieve extended data from the intent.
     *
     * @param name The name of the desired item.
     *
     * @return the value of an item that previously added with putExtra()
     * or null if no int array value was found.
     *
     * @see #putExtra(String, int[])
     */
    @DSComment("movement of Intent is spec")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.404 -0500", hash_original_method = "0A82189594F324AE308815E53494E5B0", hash_generated_method = "18315128FFB19E0CB138FC41A8F8B9F1")
    
public int[] getIntArrayExtra(String name) {
        return mExtras == null ? null : (int[])mExtras.get(name);
    }

    /**
     * Retrieve extended data from the intent.
     *
     * @param name The name of the desired item.
     *
     * @return the value of an item that previously added with putExtra()
     * or null if no long array value was found.
     *
     * @see #putExtra(String, long[])
     */
    @DSComment("movement of Intent is spec")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.406 -0500", hash_original_method = "2B191C1241796E74336A46C43420CA80", hash_generated_method = "E9465F183BBDCF9BF79C15025BB3B762")
    
public long[] getLongArrayExtra(String name) {
        return mExtras == null ? null : (long[])mExtras.get(name);
    }

    /**
     * Retrieve extended data from the intent.
     *
     * @param name The name of the desired item.
     *
     * @return the value of an item that previously added with putExtra()
     * or null if no float array value was found.
     *
     * @see #putExtra(String, float[])
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.408 -0500", hash_original_method = "8DC240B1B74093D697F56B17354B0D80", hash_generated_method = "CD9CEAF80BD4CFD40B3E7E06ECE8F68A")
    
public float[] getFloatArrayExtra(String name) {
        return mExtras == null ? null : (float[])mExtras.get(name);
    }

    /**
     * Retrieve extended data from the intent.
     *
     * @param name The name of the desired item.
     *
     * @return the value of an item that previously added with putExtra()
     * or null if no double array value was found.
     *
     * @see #putExtra(String, double[])
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.410 -0500", hash_original_method = "3975857C05E9D537152AB546E3F37275", hash_generated_method = "101A5FF3F013762428C03E757BC8781C")
    
public double[] getDoubleArrayExtra(String name) {
        return mExtras == null ? null : (double[])mExtras.get(name);
    }

    /**
     * Retrieve extended data from the intent.
     *
     * @param name The name of the desired item.
     *
     * @return the value of an item that previously added with putExtra()
     * or null if no String array value was found.
     *
     * @see #putExtra(String, String[])
     */
    @DSComment("movement of Intent is spec")
    @DSSafe(DSCat.DATA_STRUCTURE)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.412 -0500", hash_original_method = "63A5C80C2A9C3E397356915A6EC07B98", hash_generated_method = "A76D69A0A3AF1C0E068340C351C69CE2")
    
public String[] getStringArrayExtra(String name) {
        return mExtras == null ? null : (String[])mExtras.get(name);
    }

    /**
     * Retrieve extended data from the intent.
     *
     * @param name The name of the desired item.
     *
     * @return the value of an item that previously added with putExtra()
     * or null if no CharSequence array value was found.
     *
     * @see #putExtra(String, CharSequence[])
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.414 -0500", hash_original_method = "9443A9A4C1E608DAA4A110E653269318", hash_generated_method = "6F6F167168942EAE44475ED712DAA9C6")
    
public CharSequence[] getCharSequenceArrayExtra(String name) {
        return mExtras == null ? null : (CharSequence[])mExtras.get(name);
    }

    /**
     * Retrieve extended data from the intent.
     *
     * @param name The name of the desired item.
     *
     * @return the value of an item that previously added with putExtra()
     * or null if no Bundle value was found.
     *
     * @see #putExtra(String, Bundle)
     */
    @DSComment("movement of Intent is spec")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.416 -0500", hash_original_method = "913345623B540CBB75EA0BDD1C78C162", hash_generated_method = "93F751E5024747FA0CAE2E759F15F6B4")
    
public Bundle getBundleExtra(String name) {
        return mExtras == null ? null : (Bundle)mExtras.get(name);
    }

    /**
     * Retrieve extended data from the intent.
     *
     * @param name The name of the desired item.
     *
     * @return the value of an item that previously added with putExtra()
     * or null if no IBinder value was found.
     *
     * @see #putExtra(String, IBinder)
     *
     * @deprecated
     * @hide
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.419 -0500", hash_original_method = "657BCF405F69BF4C38A0897E9F672C84", hash_generated_method = "B639443AE0ACCF354B03C0F3832CFB4A")
    
@Deprecated
    public IBinder getIBinderExtra(String name) {
        return mExtras == null ? null : (IBinder)mExtras.get(name);
    }

    /**
     * Retrieve extended data from the intent.
     *
     * @param name The name of the desired item.
     * @param defaultValue The default value to return in case no item is
     * associated with the key 'name'
     *
     * @return the value of an item that previously added with putExtra()
     * or defaultValue if none was found.
     *
     * @see #putExtra
     *
     * @deprecated
     * @hide
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.421 -0500", hash_original_method = "EF34C6BD33619501EBC4FFC15D7C460E", hash_generated_method = "93501DF6387A1AF4B62D0F0AE31DA0AC")
    
@Deprecated
    public Object getExtra(String name, Object defaultValue) {
        Object result = defaultValue;
        if (mExtras != null) {
            Object result2 = mExtras.get(name);
            if (result2 != null) {
                result = result2;
            }
        }

        return result;
    }

    /**
     * Retrieves a map of extended data from the intent.
     *
     * @return the map of all extras previously added with putExtra(),
     * or null if none have been added.
     */
    @DSComment("movement of Intent is spec")
    @DSSafe(DSCat.DATA_STRUCTURE)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.423 -0500", hash_original_method = "6E509C3CEA63C12F8DB889EF86C70010", hash_generated_method = "350C4CD52734D15F08BF35252FD71B56")
    
    public Bundle getExtras() {
        mBundle.mMap = mExtras;
                
        return mBundle;
    }

    /**
     * Retrieve any special flags associated with this intent.  You will
     * normally just set them with {@link #setFlags} and let the system
     * take the appropriate action with them.
     *
     * @return int The currently set flags.
     *
     * @see #setFlags
     */
    @DSComment("movement of Intent is spec")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.426 -0500", hash_original_method = "CE8F8E5E4A30C515D6BD9049A49703B9", hash_generated_method = "A2E92201CC64F45D5B306C5445EC4739")
    
public int getFlags() {
        return mFlags;
    }

    /** @hide */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.428 -0500", hash_original_method = "35A271981CF0FB3B138FC227A1ADE9BA", hash_generated_method = "28A7F0AD58F0360C563AEE071140B3F0")
    
public boolean isExcludingStopped() {
        return (mFlags&(FLAG_EXCLUDE_STOPPED_PACKAGES|FLAG_INCLUDE_STOPPED_PACKAGES))
                == FLAG_EXCLUDE_STOPPED_PACKAGES;
    }

    /**
     * Retrieve the application package name this Intent is limited to.  When
     * resolving an Intent, if non-null this limits the resolution to only
     * components in the given application package.
     *
     * @return The name of the application package for the Intent.
     *
     * @see #resolveActivity
     * @see #setPackage
     */
    @DSComment("movement of Intent is spec")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.429 -0500", hash_original_method = "D6B19F05A1BF219922EA06A43EF822A3", hash_generated_method = "E8E7BB1D5101EA7BCE0E9136023EF604")
    
public String getPackage() {
        return mPackage;
    }

    /**
     * Retrieve the concrete component associated with the intent.  When receiving
     * an intent, this is the component that was found to best handle it (that is,
     * yourself) and will always be non-null; in all other cases it will be
     * null unless explicitly set.
     *
     * @return The name of the application component to handle the intent.
     *
     * @see #resolveActivity
     * @see #setComponent
     */
    @DSComment("movement of Intent is spec")
    @DSSafe(DSCat.DATA_STRUCTURE)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.431 -0500", hash_original_method = "3446011C83A765263A4F2617180E656B", hash_generated_method = "6739CAFBADE6CDE61859869870CB9681")
    
public ComponentName getComponent() {
        return mComponent;
    }

    /**
     * Get the bounds of the sender of this intent, in screen coordinates.  This can be
     * used as a hint to the receiver for animations and the like.  Null means that there
     * is no source bounds.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.433 -0500", hash_original_method = "418D2917B5B7B0B035ED428CB7C119CA", hash_generated_method = "EBCEC9AF8CCDDD45E46036286F65D20D")
    
public Rect getSourceBounds() {
        return mSourceBounds;
    }

    /**
     * Return the Activity component that should be used to handle this intent.
     * The appropriate component is determined based on the information in the
     * intent, evaluated as follows:
     *
     * <p>If {@link #getComponent} returns an explicit class, that is returned
     * without any further consideration.
     *
     * <p>The activity must handle the {@link Intent#CATEGORY_DEFAULT} Intent
     * category to be considered.
     *
     * <p>If {@link #getAction} is non-NULL, the activity must handle this
     * action.
     *
     * <p>If {@link #resolveType} returns non-NULL, the activity must handle
     * this type.
     *
     * <p>If {@link #addCategory} has added any categories, the activity must
     * handle ALL of the categories specified.
     *
     * <p>If {@link #getPackage} is non-NULL, only activity components in
     * that application package will be considered.
     *
     * <p>If there are no activities that satisfy all of these conditions, a
     * null string is returned.
     *
     * <p>If multiple activities are found to satisfy the intent, the one with
     * the highest priority will be used.  If there are multiple activities
     * with the same priority, the system will either pick the best activity
     * based on user preference, or resolve to a system class that will allow
     * the user to pick an activity and forward from there.
     *
     * <p>This method is implemented simply by calling
     * {@link PackageManager#resolveActivity} with the "defaultOnly" parameter
     * true.</p>
     * <p> This API is called for you as part of starting an activity from an
     * intent.  You do not normally need to call it yourself.</p>
     *
     * @param pm The package manager with which to resolve the Intent.
     *
     * @return Name of the component implementing an activity that can
     *         display the intent.
     *
     * @see #setComponent
     * @see #getComponent
     * @see #resolveActivityInfo
     */
    @DSComment("movement of Intent is spec")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.436 -0500", hash_original_method = "CDA09128651728DC4DB1AA79DEAE44CB", hash_generated_method = "095BC738BF4126F38F8EB2423BA11BB3")
    
public ComponentName resolveActivity(PackageManager pm) {
        if (mComponent != null) {
            return mComponent;
        }

        ResolveInfo info = pm.resolveActivity(
            this, PackageManager.MATCH_DEFAULT_ONLY);
        if (info != null) {
            return new ComponentName(
                    info.activityInfo.applicationInfo.packageName,
                    info.activityInfo.name);
        }

        return null;
    }

    /**
     * Resolve the Intent into an {@link ActivityInfo}
     * describing the activity that should execute the intent.  Resolution
     * follows the same rules as described for {@link #resolveActivity}, but
     * you get back the completely information about the resolved activity
     * instead of just its class name.
     *
     * @param pm The package manager with which to resolve the Intent.
     * @param flags Addition information to retrieve as per
     * {@link PackageManager#getActivityInfo(ComponentName, int)
     * PackageManager.getActivityInfo()}.
     *
     * @return PackageManager.ActivityInfo
     *
     * @see #resolveActivity
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.438 -0500", hash_original_method = "4C4C454D517012EF1DC091F981BC8CF0", hash_generated_method = "69AF792620497B467D6937BF3352A474")
    
public ActivityInfo resolveActivityInfo(PackageManager pm, int flags) {
        ActivityInfo ai = null;
        if (mComponent != null) {
            try {
                ai = pm.getActivityInfo(mComponent, flags);
            } catch (PackageManager.NameNotFoundException e) {
                // ignore
            }
        } else {
            ResolveInfo info = pm.resolveActivity(
                this, PackageManager.MATCH_DEFAULT_ONLY | flags);
            if (info != null) {
                ai = info.activityInfo;
            }
        }

        return ai;
    }
    
	@DSComment("Potential intent to trigger other processing")
    @DSSafe(DSCat.INTENT_EXCHANGE)
    
    public Intent setAction(String action) {
		mAction = action;
        //mAction = action != null ? action.intern() : null;
		addTaint(action.getTaint());
        return this;
    }
    
	@DSComment("Potential intent to trigger other processing")
    @DSSafe(DSCat.INTENT_EXCHANGE)
    public Intent setData(Uri data) {
        mData = data;
        addTaint(data.getTaint());
		/*
        mType = null;
        */
        return this;
    }
    
	@DSComment("Potential intent to trigger other processing")
    @DSSafe(DSCat.INTENT_EXCHANGE)
    public Intent setType(String type) {
            mData=null;
            mType = type;
            addTaint(type.getTaint());
            return this;
    }
    
    @DSComment("Potential intent to trigger other processing")
    @DSSafe(DSCat.INTENT_EXCHANGE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.441 -0400", hash_original_method = "43AA0CE5E260B0FA5B26C9FC36ABF327", hash_generated_method = "00584B9FB3605C6799D9DC350D63DE8B")
    public Intent setDataAndType(Uri data, String type) {
        mData = data;
        mType = type;
Intent var72A74007B2BE62B849F475C7BDA4658B_1185276063 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1185276063.addTaint(getTaint());
        addTaint(data.getTaint());
        addTaint(type.getTaint());
        return var72A74007B2BE62B849F475C7BDA4658B_1185276063;
        // ---------- Original Method ----------
        //mData = data;
        //mType = type;
        //return this;
    }
    
    @DSComment("Potential intent to trigger other processing")
    @DSSafe(DSCat.INTENT_EXCHANGE)
    public Intent addCategory(String category) {
		mCategories.addTaint(category.getTaint());
        if (mCategories == null) {
            mCategories = new HashSet<String>();
        }
        mCategories.add(category.intern());
        return this;
    }

    /**
     * Remove an category from an intent.
     *
     * @param category The category to remove.
     *
     * @see #addCategory
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.452 -0500", hash_original_method = "CFCF8DDC5EB4FA9E7ADB1DEB9CFAFA89", hash_generated_method = "7620E865C473FDF4D70E129E45CC80E9")
    
public void removeCategory(String category) {
        if (mCategories != null) {
            mCategories.remove(category);
            if (mCategories.size() == 0) {
                mCategories = null;
            }
        }
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.442 -0400", hash_original_method = "4143B41199E8262105CB671C15097E99", hash_generated_method = "287277779A434FB86F61699B992DAB08")
    public void setSelector(Intent selector) {
        if(selector == this)        
        {
            IllegalArgumentException varDB28EE105FC601F18A42EF13E45407D0_474748705 = new IllegalArgumentException(
                    "Intent being set as a selector of itself");
            varDB28EE105FC601F18A42EF13E45407D0_474748705.addTaint(getTaint());
            throw varDB28EE105FC601F18A42EF13E45407D0_474748705;
        } //End block
        if(selector != null && mPackage != null)        
        {
            IllegalArgumentException var8BA32FA43E547F20BF608AAF6B7199B5_1000380269 = new IllegalArgumentException(
                    "Can't set selector when package name is already set");
            var8BA32FA43E547F20BF608AAF6B7199B5_1000380269.addTaint(getTaint());
            throw var8BA32FA43E547F20BF608AAF6B7199B5_1000380269;
        } //End block
        mSelector = selector;
        addTaint(selector.getTaint());
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

    /**
     * Add extended data to the intent.  The name must include a package
     * prefix, for example the app com.android.contacts would use names
     * like "com.android.contacts.ShowAll".
     *
     * @param name The name of the extra data, with package prefix.
     * @param value The boolean data value.
     *
     * @return Returns the same Intent object, for chaining multiple calls
     * into a single statement.
     *
     * @see #putExtras
     * @see #removeExtra
     * @see #getBooleanExtra(String, boolean)
     */
    @DSComment("Potential intent to trigger other processing")
    @DSSafe(DSCat.INTENT_EXCHANGE)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.456 -0500", hash_original_method = "E358DED697FF080F831811D5D578FEBC", hash_generated_method = "9CAFB07CB8CADF7A1B737CEF0A85C927")
    
public Intent putExtra(String name, boolean value) {
        mExtras.put(name, value);
        return this;
    }

    /**
     * Add extended data to the intent.  The name must include a package
     * prefix, for example the app com.android.contacts would use names
     * like "com.android.contacts.ShowAll".
     *
     * @param name The name of the extra data, with package prefix.
     * @param value The byte data value.
     *
     * @return Returns the same Intent object, for chaining multiple calls
     * into a single statement.
     *
     * @see #putExtras
     * @see #removeExtra
     * @see #getByteExtra(String, byte)
     */
    @DSComment("Potential intent to trigger other processing")
    @DSSafe(DSCat.INTENT_EXCHANGE)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.458 -0500", hash_original_method = "983951350B18B30CD357EFC4A5F8C533", hash_generated_method = "369EAA9A7D333C9805FC57A65750D36F")
    
public Intent putExtra(String name, byte value) {
        mExtras.put(name, value);
        return this;
    }

    /**
     * Add extended data to the intent.  The name must include a package
     * prefix, for example the app com.android.contacts would use names
     * like "com.android.contacts.ShowAll".
     *
     * @param name The name of the extra data, with package prefix.
     * @param value The char data value.
     *
     * @return Returns the same Intent object, for chaining multiple calls
     * into a single statement.
     *
     * @see #putExtras
     * @see #removeExtra
     * @see #getCharExtra(String, char)
     */
    @DSComment("Potential intent to trigger other processing")
    @DSSafe(DSCat.INTENT_EXCHANGE)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.461 -0500", hash_original_method = "44F743D0FCF3A3B09735F92996DFB8B8", hash_generated_method = "9A89A17EE52C9990C8D3B5950C6CB8BC")
    
public Intent putExtra(String name, char value) {
        mExtras.put(name, value);
        return this;
    }

    /**
     * Add extended data to the intent.  The name must include a package
     * prefix, for example the app com.android.contacts would use names
     * like "com.android.contacts.ShowAll".
     *
     * @param name The name of the extra data, with package prefix.
     * @param value The short data value.
     *
     * @return Returns the same Intent object, for chaining multiple calls
     * into a single statement.
     *
     * @see #putExtras
     * @see #removeExtra
     * @see #getShortExtra(String, short)
     */
    @DSComment("Potential intent to trigger other processing")
    @DSSafe(DSCat.INTENT_EXCHANGE)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.463 -0500", hash_original_method = "D504428E6A64263CB337167E8E11D24B", hash_generated_method = "F6A29E038B705BB14118CC4BC5C94282")
    
public Intent putExtra(String name, short value) {
        mExtras.put(name, value);
        return this;
    }

    /**
     * Add extended data to the intent.  The name must include a package
     * prefix, for example the app com.android.contacts would use names
     * like "com.android.contacts.ShowAll".
     *
     * @param name The name of the extra data, with package prefix.
     * @param value The integer data value.
     *
     * @return Returns the same Intent object, for chaining multiple calls
     * into a single statement.
     *
     * @see #putExtras
     * @see #removeExtra
     * @see #getIntExtra(String, int)
     */
    @DSComment("Potential intent to trigger other processing")
    @DSSafe(DSCat.INTENT_EXCHANGE)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.465 -0500", hash_original_method = "0F8D3938F71F1CBC0AF93312AEF5DBAF", hash_generated_method = "B6977BA11CBD13188A6EE2314F4AAB8E")
    
public Intent putExtra(String name, int value) {
        mExtras.put(name, value);
        return this;
    }

    /**
     * Add extended data to the intent.  The name must include a package
     * prefix, for example the app com.android.contacts would use names
     * like "com.android.contacts.ShowAll".
     *
     * @param name The name of the extra data, with package prefix.
     * @param value The long data value.
     *
     * @return Returns the same Intent object, for chaining multiple calls
     * into a single statement.
     *
     * @see #putExtras
     * @see #removeExtra
     * @see #getLongExtra(String, long)
     */
    @DSComment("Potential intent to trigger other processing")
    @DSSafe(DSCat.INTENT_EXCHANGE)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.467 -0500", hash_original_method = "210CE6920B09DE82954A1910A2E05BDA", hash_generated_method = "4EBA47DCA070071028BBC47A17DF202A")
    
public Intent putExtra(String name, long value) {
        mExtras.put(name, value);
        return this;
    }

    /**
     * Add extended data to the intent.  The name must include a package
     * prefix, for example the app com.android.contacts would use names
     * like "com.android.contacts.ShowAll".
     *
     * @param name The name of the extra data, with package prefix.
     * @param value The float data value.
     *
     * @return Returns the same Intent object, for chaining multiple calls
     * into a single statement.
     *
     * @see #putExtras
     * @see #removeExtra
     * @see #getFloatExtra(String, float)
     */
    @DSComment("Potential intent to trigger other processing")
    @DSSafe(DSCat.INTENT_EXCHANGE)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.469 -0500", hash_original_method = "5563D3D5FF8C4FA36F1584B48F1347B6", hash_generated_method = "5067A756CF8499B7ABF1DB4D1F6C7336")
    
public Intent putExtra(String name, float value) {
        mExtras.put(name, value);
        return this;
    }

    /**
     * Add extended data to the intent.  The name must include a package
     * prefix, for example the app com.android.contacts would use names
     * like "com.android.contacts.ShowAll".
     *
     * @param name The name of the extra data, with package prefix.
     * @param value The double data value.
     *
     * @return Returns the same Intent object, for chaining multiple calls
     * into a single statement.
     *
     * @see #putExtras
     * @see #removeExtra
     * @see #getDoubleExtra(String, double)
     */
    @DSComment("Potential intent to trigger other processing")
    @DSSafe(DSCat.INTENT_EXCHANGE)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.472 -0500", hash_original_method = "FDAB0726590DA4887C7F048C162A9588", hash_generated_method = "1C66BD585F85E5DE9F834C9668DEEE1F")
    
public Intent putExtra(String name, double value) {
        mExtras.put(name, value);
        return this;
    }

    /**
     * Add extended data to the intent.  The name must include a package
     * prefix, for example the app com.android.contacts would use names
     * like "com.android.contacts.ShowAll".
     *
     * @param name The name of the extra data, with package prefix.
     * @param value The String data value.
     *
     * @return Returns the same Intent object, for chaining multiple calls
     * into a single statement.
     *
     * @see #putExtras
     * @see #removeExtra
     * @see #getStringExtra(String)
     */
    @DSComment("Potential intent to trigger other processing")
    @DSSafe(DSCat.INTENT_EXCHANGE)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.474 -0500", hash_original_method = "FFA94FE476B4FC82FDFAB8191F06F76A", hash_generated_method = "4F3AC23F2FDE2E244EBF603512230CB6")
    
public Intent putExtra(String name, String value) {
        mExtras.put(name, value);
        return this;
    }

    /**
     * Add extended data to the intent.  The name must include a package
     * prefix, for example the app com.android.contacts would use names
     * like "com.android.contacts.ShowAll".
     *
     * @param name The name of the extra data, with package prefix.
     * @param value The CharSequence data value.
     *
     * @return Returns the same Intent object, for chaining multiple calls
     * into a single statement.
     *
     * @see #putExtras
     * @see #removeExtra
     * @see #getCharSequenceExtra(String)
     */
    @DSComment("Potential intent to trigger other processing")
    @DSSafe(DSCat.INTENT_EXCHANGE)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.476 -0500", hash_original_method = "C3AAC0183A1B956AD55E80A8556AFB71", hash_generated_method = "B7766A00144A1C85BA9AD9A626B68D86")
    
public Intent putExtra(String name, CharSequence value) {
        mExtras.put(name, value);
        return this;
    }

    /**
     * Add extended data to the intent.  The name must include a package
     * prefix, for example the app com.android.contacts would use names
     * like "com.android.contacts.ShowAll".
     *
     * @param name The name of the extra data, with package prefix.
     * @param value The Parcelable data value.
     *
     * @return Returns the same Intent object, for chaining multiple calls
     * into a single statement.
     *
     * @see #putExtras
     * @see #removeExtra
     * @see #getParcelableExtra(String)
     */
    @DSComment("Data serialization/deserialization")
    @DSSafe(DSCat.SERIALIZATION)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.478 -0500", hash_original_method = "49EBB52F87B2F24E715C34795BBE3213", hash_generated_method = "E35F92A22E889420C4D9EB6CCD82A333")
    
public Intent putExtra(String name, Parcelable value) {
        mExtras.put(name, value);
        return this;
    }

    /**
     * Add extended data to the intent.  The name must include a package
     * prefix, for example the app com.android.contacts would use names
     * like "com.android.contacts.ShowAll".
     *
     * @param name The name of the extra data, with package prefix.
     * @param value The Parcelable[] data value.
     *
     * @return Returns the same Intent object, for chaining multiple calls
     * into a single statement.
     *
     * @see #putExtras
     * @see #removeExtra
     * @see #getParcelableArrayExtra(String)
     */
    @DSComment("Data serialization/deserialization")
    @DSSafe(DSCat.SERIALIZATION)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.480 -0500", hash_original_method = "478D5F3649CF3C1019BEE6D895BDE15B", hash_generated_method = "8EE2EE37DEC8E216CE30AD3A34E60139")
    
public Intent putExtra(String name, Parcelable[] value) {
        mExtras.put(name, value);
        return this;
    }

    /**
     * Add extended data to the intent.  The name must include a package
     * prefix, for example the app com.android.contacts would use names
     * like "com.android.contacts.ShowAll".
     *
     * @param name The name of the extra data, with package prefix.
     * @param value The ArrayList<Parcelable> data value.
     *
     * @return Returns the same Intent object, for chaining multiple calls
     * into a single statement.
     *
     * @see #putExtras
     * @see #removeExtra
     * @see #getParcelableArrayListExtra(String)
     */
    @DSComment("Potential intent to trigger other processing")
    @DSSafe(DSCat.INTENT_EXCHANGE)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.483 -0500", hash_original_method = "7056A89E2AB58239EE1F715B825304C9", hash_generated_method = "CAA15AD865F73E5B8B7CEC0FDDEF3C48")
    
public Intent putParcelableArrayListExtra(String name, ArrayList<? extends Parcelable> value) {
        mExtras.put(name, value);
        return this;
    }

    /**
     * Add extended data to the intent.  The name must include a package
     * prefix, for example the app com.android.contacts would use names
     * like "com.android.contacts.ShowAll".
     *
     * @param name The name of the extra data, with package prefix.
     * @param value The ArrayList<Integer> data value.
     *
     * @return Returns the same Intent object, for chaining multiple calls
     * into a single statement.
     *
     * @see #putExtras
     * @see #removeExtra
     * @see #getIntegerArrayListExtra(String)
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.485 -0500", hash_original_method = "25611C5EA858F4B01007B3F78DCCE949", hash_generated_method = "B00CD5DBF3B90CCA1774FF3426ED7F66")
    
public Intent putIntegerArrayListExtra(String name, ArrayList<Integer> value) {
        mExtras.put(name, value);
        return this;
    }

    /**
     * Add extended data to the intent.  The name must include a package
     * prefix, for example the app com.android.contacts would use names
     * like "com.android.contacts.ShowAll".
     *
     * @param name The name of the extra data, with package prefix.
     * @param value The ArrayList<String> data value.
     *
     * @return Returns the same Intent object, for chaining multiple calls
     * into a single statement.
     *
     * @see #putExtras
     * @see #removeExtra
     * @see #getStringArrayListExtra(String)
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.487 -0500", hash_original_method = "FCCCC0193355017A3AB410227E2B8C63", hash_generated_method = "D9A90AA848BD3378AFD8B57E938B259A")
    
public Intent putStringArrayListExtra(String name, ArrayList<String> value) {
        mExtras.put(name, value);
        return this;
    }

    /**
     * Add extended data to the intent.  The name must include a package
     * prefix, for example the app com.android.contacts would use names
     * like "com.android.contacts.ShowAll".
     *
     * @param name The name of the extra data, with package prefix.
     * @param value The ArrayList<CharSequence> data value.
     *
     * @return Returns the same Intent object, for chaining multiple calls
     * into a single statement.
     *
     * @see #putExtras
     * @see #removeExtra
     * @see #getCharSequenceArrayListExtra(String)
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.490 -0500", hash_original_method = "56169BFB83B473D5686B58CC3B07DAC6", hash_generated_method = "13A3F22ED96C8CFEA983255956176211")
    
public Intent putCharSequenceArrayListExtra(String name, ArrayList<CharSequence> value) {
        mExtras.put(name, value);
        return this;
    }
    
	@DSComment("Potential intent to trigger other processing")
    @DSSafe(DSCat.INTENT_EXCHANGE)
    
    public Intent putExtra(String name, Serializable value) {
        mExtras.put(name, value);
        return this;
    }

    /**
     * Add extended data to the intent.  The name must include a package
     * prefix, for example the app com.android.contacts would use names
     * like "com.android.contacts.ShowAll".
     *
     * @param name The name of the extra data, with package prefix.
     * @param value The boolean array data value.
     *
     * @return Returns the same Intent object, for chaining multiple calls
     * into a single statement.
     *
     * @see #putExtras
     * @see #removeExtra
     * @see #getBooleanArrayExtra(String)
     */
    @DSComment("Potential intent to trigger other processing")
    @DSSafe(DSCat.INTENT_EXCHANGE)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.494 -0500", hash_original_method = "6C30326EEBD8635124BFC9218A6B6422", hash_generated_method = "C75337EC13A828BA2CF290B1734627F0")
    
public Intent putExtra(String name, boolean[] value) {
        mExtras.put(name, value);
        return this;
    }

    /**
     * Add extended data to the intent.  The name must include a package
     * prefix, for example the app com.android.contacts would use names
     * like "com.android.contacts.ShowAll".
     *
     * @param name The name of the extra data, with package prefix.
     * @param value The byte array data value.
     *
     * @return Returns the same Intent object, for chaining multiple calls
     * into a single statement.
     *
     * @see #putExtras
     * @see #removeExtra
     * @see #getByteArrayExtra(String)
     */
    @DSComment("Potential intent to trigger other processing")
    @DSSafe(DSCat.INTENT_EXCHANGE)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.496 -0500", hash_original_method = "4D4788E50F7779B1D72BD45B4E76C775", hash_generated_method = "CF81A6D8F26F9F109EFE6BE3F51D4C02")
    
public Intent putExtra(String name, byte[] value) {
        mExtras.put(name, value);
        return this;
    }

    /**
     * Add extended data to the intent.  The name must include a package
     * prefix, for example the app com.android.contacts would use names
     * like "com.android.contacts.ShowAll".
     *
     * @param name The name of the extra data, with package prefix.
     * @param value The short array data value.
     *
     * @return Returns the same Intent object, for chaining multiple calls
     * into a single statement.
     *
     * @see #putExtras
     * @see #removeExtra
     * @see #getShortArrayExtra(String)
     */
    @DSComment("Potential intent to trigger other processing")
    @DSSafe(DSCat.INTENT_EXCHANGE)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.498 -0500", hash_original_method = "521E65BC95668B6A66CE17103975D2B1", hash_generated_method = "8DC6ED6D9F00B4FC7646C9B74D598F46")
    
public Intent putExtra(String name, short[] value) {
        mExtras.put(name, value);
        return this;
    }

    /**
     * Add extended data to the intent.  The name must include a package
     * prefix, for example the app com.android.contacts would use names
     * like "com.android.contacts.ShowAll".
     *
     * @param name The name of the extra data, with package prefix.
     * @param value The char array data value.
     *
     * @return Returns the same Intent object, for chaining multiple calls
     * into a single statement.
     *
     * @see #putExtras
     * @see #removeExtra
     * @see #getCharArrayExtra(String)
     */
    @DSComment("Potential intent to trigger other processing")
    @DSSafe(DSCat.INTENT_EXCHANGE)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.500 -0500", hash_original_method = "CEC6E945D8554F36BF71D2D38B61B7EF", hash_generated_method = "5294EA3365F0D553D067410AB35C1AA8")
    
public Intent putExtra(String name, char[] value) {
        mExtras.put(name, value);
        return this;
    }

    /**
     * Add extended data to the intent.  The name must include a package
     * prefix, for example the app com.android.contacts would use names
     * like "com.android.contacts.ShowAll".
     *
     * @param name The name of the extra data, with package prefix.
     * @param value The int array data value.
     *
     * @return Returns the same Intent object, for chaining multiple calls
     * into a single statement.
     *
     * @see #putExtras
     * @see #removeExtra
     * @see #getIntArrayExtra(String)
     */
    @DSComment("Potential intent to trigger other processing")
    @DSSafe(DSCat.INTENT_EXCHANGE)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.502 -0500", hash_original_method = "AD8C8F2DD7A3862E32E54CE0FBFF67CE", hash_generated_method = "A74DCDCC8CEF665CFAAEBCFA9362ED98")
    
public Intent putExtra(String name, int[] value) {

        mExtras.put(name, value);
        return this;
    }

    /**
     * Add extended data to the intent.  The name must include a package
     * prefix, for example the app com.android.contacts would use names
     * like "com.android.contacts.ShowAll".
     *
     * @param name The name of the extra data, with package prefix.
     * @param value The byte array data value.
     *
     * @return Returns the same Intent object, for chaining multiple calls
     * into a single statement.
     *
     * @see #putExtras
     * @see #removeExtra
     * @see #getLongArrayExtra(String)
     */
    @DSComment("Potential intent to trigger other processing")
    @DSSafe(DSCat.INTENT_EXCHANGE)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.505 -0500", hash_original_method = "EEA209751D515DE89BAC56042276C483", hash_generated_method = "AD4E2FEBA3938BC3B383C31CE8AA5621")
    
public Intent putExtra(String name, long[] value) {

        mExtras.put(name, value);
        return this;
    }

    /**
     * Add extended data to the intent.  The name must include a package
     * prefix, for example the app com.android.contacts would use names
     * like "com.android.contacts.ShowAll".
     *
     * @param name The name of the extra data, with package prefix.
     * @param value The float array data value.
     *
     * @return Returns the same Intent object, for chaining multiple calls
     * into a single statement.
     *
     * @see #putExtras
     * @see #removeExtra
     * @see #getFloatArrayExtra(String)
     */
    @DSComment("Potential intent to trigger other processing")
    @DSSafe(DSCat.INTENT_EXCHANGE)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.507 -0500", hash_original_method = "F6CA728A57FEA4C77AF7294872C7D495", hash_generated_method = "0AB87D1FFE8ACBFD8140FF2BFBB1B700")
    
public Intent putExtra(String name, float[] value) {

        mExtras.put(name, value);
        return this;
    }

    /**
     * Add extended data to the intent.  The name must include a package
     * prefix, for example the app com.android.contacts would use names
     * like "com.android.contacts.ShowAll".
     *
     * @param name The name of the extra data, with package prefix.
     * @param value The double array data value.
     *
     * @return Returns the same Intent object, for chaining multiple calls
     * into a single statement.
     *
     * @see #putExtras
     * @see #removeExtra
     * @see #getDoubleArrayExtra(String)
     */
    @DSComment("Potential intent to trigger other processing")
    @DSSafe(DSCat.INTENT_EXCHANGE)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.510 -0500", hash_original_method = "3F155E9B232579FD3DCD2D3FAECEA79F", hash_generated_method = "D2DFE2902C91701683C6C77CD1D801AB")
    
public Intent putExtra(String name, double[] value) {

        mExtras.put(name, value);
        return this;
    }

    /**
     * Add extended data to the intent.  The name must include a package
     * prefix, for example the app com.android.contacts would use names
     * like "com.android.contacts.ShowAll".
     *
     * @param name The name of the extra data, with package prefix.
     * @param value The String array data value.
     *
     * @return Returns the same Intent object, for chaining multiple calls
     * into a single statement.
     *
     * @see #putExtras
     * @see #removeExtra
     * @see #getStringArrayExtra(String)
     */
    @DSComment("Potential intent to trigger other processing")
    @DSSafe(DSCat.INTENT_EXCHANGE)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.512 -0500", hash_original_method = "4105C6229BFDC8C2B450D57FAD8A78CA", hash_generated_method = "1D158E827BC908009601A331BE3E2C15")
    
public Intent putExtra(String name, String[] value) {
        mExtras.put(name, value);
        return this;
    }

    /**
     * Add extended data to the intent.  The name must include a package
     * prefix, for example the app com.android.contacts would use names
     * like "com.android.contacts.ShowAll".
     *
     * @param name The name of the extra data, with package prefix.
     * @param value The CharSequence array data value.
     *
     * @return Returns the same Intent object, for chaining multiple calls
     * into a single statement.
     *
     * @see #putExtras
     * @see #removeExtra
     * @see #getCharSequenceArrayExtra(String)
     */
    @DSComment("Potential intent to trigger other processing")
    @DSSafe(DSCat.INTENT_EXCHANGE)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.514 -0500", hash_original_method = "5B5979B9E2BB6EA8D0974FC96788F02A", hash_generated_method = "9CF7F62F974438343F82E84474D2AC00")
    
public Intent putExtra(String name, CharSequence[] value) {
        mExtras.put(name, value);
        return this;
    }

    /**
     * Add extended data to the intent.  The name must include a package
     * prefix, for example the app com.android.contacts would use names
     * like "com.android.contacts.ShowAll".
     *
     * @param name The name of the extra data, with package prefix.
     * @param value The Bundle data value.
     *
     * @return Returns the same Intent object, for chaining multiple calls
     * into a single statement.
     *
     * @see #putExtras
     * @see #removeExtra
     * @see #getBundleExtra(String)
     */
    @DSComment("Potential intent to trigger other processing")
    @DSSafe(DSCat.INTENT_EXCHANGE)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.517 -0500", hash_original_method = "79076492A33BAA4B69A022CE305E32E8", hash_generated_method = "1A23CC6FCDD5B5BFDC1538D40AAC1BAC")
    
public Intent putExtra(String name, Bundle value) {
        mExtras.put(name, value);
        return this;
    }

    /**
     * Add extended data to the intent.  The name must include a package
     * prefix, for example the app com.android.contacts would use names
     * like "com.android.contacts.ShowAll".
     *
     * @param name The name of the extra data, with package prefix.
     * @param value The IBinder data value.
     *
     * @return Returns the same Intent object, for chaining multiple calls
     * into a single statement.
     *
     * @see #putExtras
     * @see #removeExtra
     * @see #getIBinderExtra(String)
     *
     * @deprecated
     * @hide
     */
    @DSComment("Potential intent to trigger other processing")
    @DSSafe(DSCat.INTENT_EXCHANGE)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.519 -0500", hash_original_method = "1AE089536D0C6059F1731DCA673BC867", hash_generated_method = "F96CE15EA84327F92F6D10BA45D9B4F0")
    
@Deprecated
    public Intent putExtra(String name, IBinder value) {
        mExtras.put(name, value);
        return this;
    }

    /**
     * Copy all extras in 'src' in to this intent.
     *
     * @param src Contains the extras to copy.
     *
     * @see #putExtra
     */
    @DSComment("Potential intent to trigger other processing")
    @DSSafe(DSCat.INTENT_EXCHANGE)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.521 -0500", hash_original_method = "49B5D5019DC4C58D3432134ADBF206CE", hash_generated_method = "6A4551931679F7F4C88D98B48A5B93F2")
    
public Intent putExtras(Intent src) {
        if (src.mExtras != null) {
            mExtras.putAll(src.mExtras);
        }

        return this;
    }

    /**
     * Add a set of extended data to the intent.  The keys must include a package
     * prefix, for example the app com.android.contacts would use names
     * like "com.android.contacts.ShowAll".
     *
     * @param extras The Bundle of extras to add to this intent.
     *
     * @see #putExtra
     * @see #removeExtra
     */
    @DSComment("Potential intent to trigger other processing")
    @DSSafe(DSCat.INTENT_EXCHANGE)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.523 -0500", hash_original_method = "300503D60C48D249178D35D7CDB92339", hash_generated_method = "FC9E29D42D611ABE43D557232408FD20")
    
public Intent putExtras(Bundle extras) {
        mExtras.putAll(extras.mMap);
        return this;
    }

    /**
     * Completely replace the extras in the Intent with the extras in the
     * given Intent.
     *
     * @param src The exact extras contained in this Intent are copied
     * into the target intent, replacing any that were previously there.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.525 -0500", hash_original_method = "9273ED8AEDE591E5D2100B41909C8A11", hash_generated_method = "C2F0CCF4A1DAF110F7CBEF1FA7C79D71")
    
public Intent replaceExtras(Intent src) {
        mExtras = src.mExtras;
        return this;
    }

    /**
     * Completely replace the extras in the Intent with the given Bundle of
     * extras.
     *
     * @param extras The new set of extras in the Intent, or null to erase
     * all extras.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.527 -0500", hash_original_method = "CBF42E478CC456FFD10D6777F319F0BD", hash_generated_method = "F442059822B057D55A287710A70DCBAE")
    
public Intent replaceExtras(Bundle extras) {
        mExtras = extras.mMap;
        return this;
    }

    /**
     * Remove extended data from the intent.
     *
     * @see #putExtra
     */
    @DSComment("movement of Intent is spec")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.530 -0500", hash_original_method = "84A47E40481CBF5586A9CCDD8AD7D655", hash_generated_method = "02864C54AF97F2C1364CF06106399AA0")
    
public void removeExtra(String name) {
        if (mExtras != null) {
            mExtras.remove(name);
            if (mExtras.size() == 0) {
                mExtras = null;
            }
        }
    }
    
    @DSComment("Potential intent to trigger other processing")
    @DSSafe(DSCat.INTENT_EXCHANGE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.457 -0400", hash_original_method = "240F6D2BBC198957F28DF199FF71FA51", hash_generated_method = "323448496A1EB64B6B509F0F11F239D5")
    public Intent setFlags(int flags) {
        mFlags = flags;
        addTaint(flags);
Intent var72A74007B2BE62B849F475C7BDA4658B_238535034 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_238535034.addTaint(getTaint());
        return var72A74007B2BE62B849F475C7BDA4658B_238535034;
        // ---------- Original Method ----------
        //mFlags = flags;
        //return this;
    }
    
	@DSComment("Potential intent to trigger other processing")
    @DSSafe(DSCat.INTENT_EXCHANGE)
    public Intent addFlags(int flags) {
        addTaint(flags);
        return this;
    }
    
	@DSComment("Potential intent to trigger other processing")
    @DSSafe(DSCat.INTENT_EXCHANGE)
    public Intent setPackage(String packageName) {
        addTaint(packageName.getTaint());
        if (packageName != null && mSelector != null) {
            IllegalArgumentException exception = 
            new IllegalArgumentException(
                    "Can't set package name when selector is already set");
            exception.addTaint(getTaint());
            throw exception;
        }
        mPackage = packageName;
        return this;
    }
    
    @DSComment("Potential intent to trigger other processing")
    @DSSafe(DSCat.INTENT_EXCHANGE)
    public Intent setComponent(ComponentName component) {
        mComponent = component;
            //this is just to set mClsComponent to a unknown value for value analysis to account for this call...e
            try {
                mClsComponent = Class.forName(component.getClassName());    
            } catch (ClassNotFoundException e){
            }
            addTaint(component.getTaint());
            return this;
    }
    
    @DSComment("Potential intent to trigger other processing")
    @DSSafe(DSCat.INTENT_EXCHANGE)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.458 -0400", hash_original_method = "A7E573A4994CE22857A73F3E6FF16052", hash_generated_method = "C98CA911AF4638EF31A76CD5F5B6B418")
    public Intent setClassName(Context packageContext, String className) {
        mComponent = new ComponentName(packageContext, className);
        try {
            mClsComponent = Class.forName(className);  
        } catch (ClassNotFoundException e) {
        }
        addTaint(packageContext.getTaint());
        addTaint(className.getTaint()); 
        Intent var72A74007B2BE62B849F475C7BDA4658B_607451133 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_607451133.addTaint(getTaint());
        return var72A74007B2BE62B849F475C7BDA4658B_607451133;
        // ---------- Original Method ----------
        //mComponent = new ComponentName(packageContext, className);
        //return this;
    }
    
    @DSComment("Potential intent to trigger other processing")
    @DSSafe(DSCat.INTENT_EXCHANGE)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.458 -0400", hash_original_method = "0DAD204BCD083F4BEBCC949C19CA4443", hash_generated_method = "5CEF145A6CCA0AADAE7E7BECBD589C6D")
    public Intent setClassName(String packageName, String className) {
        addTaint(packageName.getTaint());
        addTaint(className.getTaint());
        try {
            mClsComponent = Class.forName(className);  
        } catch (ClassNotFoundException e) {
        }
        mComponent = new ComponentName(packageName, className);
        Intent var72A74007B2BE62B849F475C7BDA4658B_1442856412 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1442856412.addTaint(getTaint());
        return var72A74007B2BE62B849F475C7BDA4658B_1442856412;
        // ---------- Original Method ----------
        //mComponent = new ComponentName(packageName, className);
        //return this;
    }
    
    @DSComment("Refelction/class loader")
    @DSBan(DSCat.REFLECTION)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.459 -0400", hash_original_method = "07D0BC1863460C70C46D0D4DB8E842CD", hash_generated_method = "7F6ACB39663195BC97A4BC6A90961AAC")
    public Intent setClass(Context packageContext, Class<?> cls) {
        mClsComponent = cls;
        addTaint(packageContext.getTaint());
        addTaint(cls.getTaint());
        mComponent = new ComponentName(packageContext, cls.getName());
Intent var72A74007B2BE62B849F475C7BDA4658B_1106282301 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1106282301.addTaint(getTaint());
        return var72A74007B2BE62B849F475C7BDA4658B_1106282301;
        // ---------- Original Method ----------
        //mComponent = new ComponentName(packageContext, cls);
        //return this;
    }
    
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
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
        addTaint(r.getTaint());
        // ---------- Original Method ----------
        //if (r != null) {
            //mSourceBounds = new Rect(r);
        //} else {
            //mSourceBounds = null;
        //}
    }
    
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.461 -0400", hash_original_method = "E5580C6082A47C0EDDA03A45ABBBF7D7", hash_generated_method = "4B8FA51A496FF6E4B5BA8D2EE3D46DB1")
    public int fillIn(Intent other, int flags) {
        addTaint(flags);
        addTaint(other.getTaint());
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
                mExtras = new HashMap<String,Object>();// new Bundle(other.mExtras);
            } //End block
        } //End block
        else
        if(other.mExtras != null)        
        {
            try 
            {
                Map<String, Object> newb = new HashMap<String,Object>();//Bundle(other.mExtras);
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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.462 -0400", hash_original_method = "B6E4053A3570119C1E3D361525D403A8", hash_generated_method = "C8D6E623D6274E5B094908B5C049F5B2")
    public boolean filterEquals(Intent other) {
        addTaint(other.getTaint());
        return getTaintBoolean();
        
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.463 -0400", hash_original_method = "8096117DA4698C90A65D3667512D1D4C", hash_generated_method = "D506D0D0B53B35A630A8B69FE659274D")
    public int filterHashCode() {
        return getTaintInt();
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

    @DSComment("movement of Intent is spec")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.593 -0500", hash_original_method = "A07DFF04DF4B6FC888385D304C4BCF4A", hash_generated_method = "3A3B480D0B879B15008E432A8EB67CCD")
    
@Override
    public String toString() {
        StringBuilder b = new StringBuilder(128);

        b.append("Intent { ");
        toShortString(b, true, true, true);
        b.append(" }");

        return b.toString();
    }

    /** @hide */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.595 -0500", hash_original_method = "561478671997B5BD9B57800B6A20BE68", hash_generated_method = "688D2807E608B0BFFB5B95FAD59BEA21")
    
public String toInsecureString() {
        StringBuilder b = new StringBuilder(128);

        b.append("Intent { ");
        toShortString(b, false, true, true);
        b.append(" }");

        return b.toString();
    }

    /** @hide */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.597 -0500", hash_original_method = "78E0A44749B0E137B37BE3EA0840E73D", hash_generated_method = "2BEB8935EE6A621902DDFF007070D362")
    
public String toShortString(boolean secure, boolean comp, boolean extras) {
        StringBuilder b = new StringBuilder(128);
        toShortString(b, secure, comp, extras);
        return b.toString();
    }

    /** @hide */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.601 -0500", hash_original_method = "084143D5D45481DE69737429FAF260F9", hash_generated_method = "04E091D07882BE095A295CD6BBC30AB4")
    
public void toShortString(StringBuilder b, boolean secure, boolean comp, boolean extras) {
        boolean first = true;
        if (mAction != null) {
            b.append("act=").append(mAction);
            first = false;
        }
        if (mCategories != null) {
            if (!first) {
                b.append(' ');
            }
            first = false;
            b.append("cat=[");
            Iterator<String> i = mCategories.iterator();
            boolean didone = false;
            while (i.hasNext()) {
                if (didone) b.append(",");
                didone = true;
                b.append(i.next());
            }
            b.append("]");
        }
        if (mData != null) {
            if (!first) {
                b.append(' ');
            }
            first = false;
            b.append("dat=");
            if (secure) {
                b.append(mData.toSafeString());
            } else {
                b.append(mData);
            }
        }
        if (mType != null) {
            if (!first) {
                b.append(' ');
            }
            first = false;
            b.append("typ=").append(mType);
        }
        if (mFlags != 0) {
            if (!first) {
                b.append(' ');
            }
            first = false;
            b.append("flg=0x").append(Integer.toHexString(mFlags));
        }
        if (mPackage != null) {
            if (!first) {
                b.append(' ');
            }
            first = false;
            b.append("pkg=").append(mPackage);
        }
        if (comp && mComponent != null) {
            if (!first) {
                b.append(' ');
            }
            first = false;
            b.append("cmp=").append(mComponent.flattenToShortString());
        }
        if (mSourceBounds != null) {
            if (!first) {
                b.append(' ');
            }
            first = false;
            b.append("bnds=").append(mSourceBounds.toShortString());
        }
        if (extras && mExtras != null) {
            if (!first) {
                b.append(' ');
            }
            first = false;
            b.append("(has extras)");
        }
        if (mSelector != null) {
            b.append(" sel={");
            mSelector.toShortString(b, secure, comp, extras);
            b.append("}");
        }
    }

    /**
     * Call {@link #toUri} with 0 flags.
     * @deprecated Use {@link #toUri} instead.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.604 -0500", hash_original_method = "A1DA43CBB31EA268C3AC25819B92FFB9", hash_generated_method = "A45F3EE47FDDCDE6E81C8DE004E03C6E")
    
@Deprecated
    public String toURI() {
        return toUri(0);
    }

    /**
     * Convert this Intent into a String holding a URI representation of it.
     * The returned URI string has been properly URI encoded, so it can be
     * used with {@link Uri#parse Uri.parse(String)}.  The URI contains the
     * Intent's data as the base URI, with an additional fragment describing
     * the action, categories, type, flags, package, component, and extras.
     *
     * <p>You can convert the returned string back to an Intent with
     * {@link #getIntent}.
     *
     * @param flags Additional operating flags.  Either 0 or
     * {@link #URI_INTENT_SCHEME}.
     *
     * @return Returns a URI encoding URI string describing the entire contents
     * of the Intent.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.606 -0500", hash_original_method = "E005DA59F987D9130CC4868A94C4C496", hash_generated_method = "B754C91834347C3B9CD6B70822E99190")
    
public String toUri(int flags) {
        StringBuilder uri = new StringBuilder(128);
        String scheme = null;
        if (mData != null) {
            String data = mData.toString();
            if ((flags&URI_INTENT_SCHEME) != 0) {
                final int N = data.length();
                for (int i=0; i<N; i++) {
                    char c = data.charAt(i);
                    if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')
                            || c == '.' || c == '-') {
                        continue;
                    }
                    if (c == ':' && i > 0) {
                        // Valid scheme.
                        scheme = data.substring(0, i);
                        uri.append("intent:");
                        data = data.substring(i+1);
                        break;
                    }

                    // No scheme.
                    break;
                }
            }
            uri.append(data);

        } else if ((flags&URI_INTENT_SCHEME) != 0) {
            uri.append("intent:");
        }

        uri.append("#Intent;");

        toUriInner(uri, scheme, flags);
        if (mSelector != null) {
            uri.append("SEL;");
            // Note that for now we are not going to try to handle the
            // data part; not clear how to represent this as a URI, and
            // not much utility in it.
            mSelector.toUriInner(uri, null, flags);
        }

        uri.append("end");

        return uri.toString();
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.610 -0500", hash_original_method = "C6B01852F6499829AE05E1CED618D6B2", hash_generated_method = "B60DA575A299C52F8E50386CB38B6A27")
    
private void toUriInner(StringBuilder uri, String scheme, int flags) {
        if (scheme != null) {
            uri.append("scheme=").append(scheme).append(';');
        }
        if (mAction != null) {
            uri.append("action=").append(Uri.encode(mAction)).append(';');
        }
        if (mCategories != null) {
            for (String category : mCategories) {
                uri.append("category=").append(Uri.encode(category)).append(';');
            }
        }
        if (mType != null) {
            uri.append("type=").append(Uri.encode(mType, "/")).append(';');
        }
        if (mFlags != 0) {
            uri.append("launchFlags=0x").append(Integer.toHexString(mFlags)).append(';');
        }
        if (mPackage != null) {
            uri.append("package=").append(Uri.encode(mPackage)).append(';');
        }
        if (mComponent != null) {
            uri.append("component=").append(Uri.encode(
                    mComponent.flattenToShortString(), "/")).append(';');
        }
        if (mSourceBounds != null) {
            uri.append("sourceBounds=")
                    .append(Uri.encode(mSourceBounds.flattenToString()))
                    .append(';');
        }
        if (mExtras != null) {
            for (String key : mExtras.keySet()) {
                final Object value = mExtras.get(key);
                char entryType =
                        value instanceof String    ? 'S' :
                        value instanceof Boolean   ? 'B' :
                        value instanceof Byte      ? 'b' :
                        value instanceof Character ? 'c' :
                        value instanceof Double    ? 'd' :
                        value instanceof Float     ? 'f' :
                        value instanceof Integer   ? 'i' :
                        value instanceof Long      ? 'l' :
                        value instanceof Short     ? 's' :
                        '\0';

                if (entryType != '\0') {
                    uri.append(entryType);
                    uri.append('.');
                    uri.append(Uri.encode(key));
                    uri.append('=');
                    uri.append(Uri.encode(value.toString()));
                    uri.append(';');
                }
            }
        }
    }
    
    @Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return getTaintInt();
	}

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.614 -0500", hash_original_method = "D9DA92F04D8A96D9F8D7CC23CBDB1396", hash_generated_method = "125A115D73FBCF95715C94D08970F813")
    
public void writeToParcel(Parcel out, int flags) {
        out.writeString(mAction);
        Uri.writeToParcel(out, mData);
        out.writeString(mType);
        out.writeInt(mFlags);
        out.writeString(mPackage);
        ComponentName.writeToParcel(mComponent, out);

        if (mSourceBounds != null) {
            out.writeInt(1);
            mSourceBounds.writeToParcel(out, flags);
        } else {
            out.writeInt(0);
        }

        if (mCategories != null) {
            out.writeInt(mCategories.size());
            for (String category : mCategories) {
                out.writeString(category);
            }
        } else {
            out.writeInt(0);
        }

        if (mSelector != null) {
            out.writeInt(1);
            mSelector.writeToParcel(out, flags);
        } else {
            out.writeInt(0);
        }

        out.writeMap(mExtras);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:09.627 -0500", hash_original_method = "275963C0D40D3AED4795057AE368B460", hash_generated_method = "09B180D23DBB15F2E9219E7BBB908111")
    
public void readFromParcel(Parcel in) {
        setAction(in.readString());
        mData = Uri.CREATOR.createFromParcel(in);
        mType = in.readString();
        mFlags = in.readInt();
        mPackage = in.readString();
        mComponent = ComponentName.readFromParcel(in);

        if (in.readInt() != 0) {
            mSourceBounds = Rect.CREATOR.createFromParcel(in);
        }

        int N = in.readInt();
        if (N > 0) {
            mCategories = new HashSet<String>();
            int i;
            for (i=0; i<N; i++) {
                mCategories.add(in.readString().intern());
            }
        } else {
            mCategories = null;
        }

        if (in.readInt() != 0) {
            mSelector = new Intent(in);
        }

        mExtras = in.readBundle().mMap;
    }
    
    /**
     * Use this method to translate one intent to another in a way that is
     * dependent on the values resolved by attribute modeling.  This call is modeled 
     * in the attribute modeling pass as well.
     */
    
    public Intent translateIntent() {
        Intent result = new Intent();
        result.setAction(this.getAction());
        result.setType(this.getType());
        result.setPackage(this.getPackage());

        result.setData(this.getData());
        //set the data field to the type field in the case there is no existing uri
        result.setData(new Uri(this.getType()));

        return result;
    }
    
}

