package droidsafe.analyses.value.models.android.content;

import droidsafe.analyses.value.models.android.content.Intent;
import droidsafe.analyses.value.models.android.net.Uri;
import droidsafe.analyses.value.models.droidsafe.primitives.ValueAnalysisBoolean;
import droidsafe.analyses.value.models.droidsafe.primitives.ValueAnalysisInt;
import droidsafe.analyses.value.ValueAnalysisModeledObject;
import droidsafe.analyses.value.ValueAnalysisModelingSet;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import soot.jimple.spark.pag.AllocNode;

public class IntentFilter extends ValueAnalysisModeledObject {

    public final ArrayList<String> mActions = new ArrayList<String>();

    public IntentFilter(AllocNode allocNode) {
        super(allocNode);
    }

    /**
     * New empty IntentFilter.
     */
    public void _init_() {
        /*
        mPriority = 0;
        mActions = new ArrayList<String>();
        */
    }

    /**
     * New IntentFilter that matches a single action with no data.  If
     * no data characteristics are subsequently specified, then the
     * filter will only match intents that contain no data.
     *
     * @param action The action to match, i.e. Intent.ACTION_MAIN.
     */
    public void _init_(Set<String> action) {
        __ds__invalidate();
        /*
        mPriority = 0;
        mActions = new ArrayList<String>();
        addAction(action);
        */
    }

    /**
     * New IntentFilter that matches a single action and data type.
     *
     * <p><em>Note: MIME type matching in the Android framework is
     * case-sensitive, unlike formal RFC MIME types.  As a result,
     * you should always write your MIME types with lower case letters,
     * and any MIME types you receive from outside of Android should be
     * converted to lower case before supplying them here.</em></p>
     *
     * <p>Throws {@link MalformedMimeTypeException} if the given MIME type is
     * not syntactically correct.
     *
     * @param action The action to match, i.e. Intent.ACTION_VIEW.
     * @param dataType The type to match, i.e. "vnd.android.cursor.dir/person".
     *
     */
    public void _init_(Set<String> action, Set<String> dataType) {
        __ds__invalidate();
        /*
        mPriority = 0;
        mActions = new ArrayList<String>();
        addAction(action);
        addDataType(dataType);
        */
    }

    /**
     * New IntentFilter containing a copy of an existing filter.
     *
     * @param o The original filter to copy.
     */
    public void _init_(IntentFilter o) {
        __ds__invalidate();
        /*
        mPriority = o.mPriority;
        mActions = new ArrayList<String>(o.mActions);
        if (o.mCategories != null) {
            mCategories = new ArrayList<String>(o.mCategories);
        }
        if (o.mDataTypes != null) {
            mDataTypes = new ArrayList<String>(o.mDataTypes);
        }
        if (o.mDataSchemes != null) {
            mDataSchemes = new ArrayList<String>(o.mDataSchemes);
        }
        if (o.mDataAuthorities != null) {
            mDataAuthorities = new ArrayList<AuthorityEntry>(o.mDataAuthorities);
        }
        if (o.mDataPaths != null) {
            mDataPaths = new ArrayList<PatternMatcher>(o.mDataPaths);
        }
        mHasPartialTypes = o.mHasPartialTypes;
        */
    }

    // These functions are the start of more optimized code for managing 
    // the string sets...  not yet implemented. 
    public static int findStringInSet(String[] set, Set<String> string, int[] lengths, Set<ValueAnalysisInt> lenPos) {
        return 0;
        /*
        if (set == null) return -1;
        final int N = lengths[lenPos];
        for (int i=0; i<N; i++) {
            if (set[i].equals(string)) return i;
        }
        return -1;
        */
    }

    public static String[] addStringToSet(String[] set, Set<String> string, int[] lengths, Set<ValueAnalysisInt> lenPos) {
        return null;
        /*
        if (findStringInSet(set, string, lengths, lenPos) >= 0) return set;
        if (set == null) {
            set = new String[2];
            set[0] = string;
            lengths[lenPos] = 1;
            return set;
        }
        final int N = lengths[lenPos];
        if (N < set.length) {
            set[N] = string;
            lengths[lenPos] = N+1;
            return set;
        }

        String[] newSet = new String[(N*3)/2 + 2];
        System.arraycopy(set, 0, newSet, 0, N);
        set = newSet;
        set[N] = string;
        lengths[lenPos] = N+1;
        return set;
        */
    }

    public static String[] removeStringFromSet(String[] set, Set<String> string, int[] lengths, Set<ValueAnalysisInt> lenPos) {
        return null;
        /*
        int pos = findStringInSet(set, string, lengths, lenPos);
        if (pos < 0) return set;
        final int N = lengths[lenPos];
        if (N > (set.length/4)) {
            int copyLen = N-(pos+1);
            if (copyLen > 0) {
                System.arraycopy(set, pos+1, set, pos, copyLen);
            }
            set[N-1] = null;
            lengths[lenPos] = N-1;
            return set;
        }

        String[] newSet = new String[set.length/3];
        if (pos > 0) System.arraycopy(set, 0, newSet, 0, pos);
        if ((pos+1) < N) System.arraycopy(set, pos+1, newSet, pos, N-(pos+1));
        return newSet;
        */
    }

    /**
     * Create a new IntentFilter instance with a specified action and MIME
     * type, where you know the MIME type is correctly formatted.  This catches
     * the {@link MalformedMimeTypeException} exception that the constructor
     * can call and turns it into a runtime exception.
     *
     * @param action The action to match, i.e. Intent.ACTION_VIEW.
     * @param dataType The type to match, i.e. "vnd.android.cursor.dir/person".
     *
     * @return A new IntentFilter for the given action and type.
     *
     * @see #IntentFilter(String, String)
     */
    public static IntentFilter create(Set<String> action, Set<String> dataType) {
        return null;
        /*
        try {
            return new IntentFilter(action, dataType);
        } catch (MalformedMimeTypeException e) {
            throw new RuntimeException("Bad MIME type", e);
        }
        */
    }

    /**
     * Modify priority of this filter.  The default priority is 0. Positive
     * values will be before the default, lower values will be after it.
     * Applications must use a value that is larger than
     * {@link #SYSTEM_LOW_PRIORITY} and smaller than
     * {@link #SYSTEM_HIGH_PRIORITY} .
     *
     * @param priority The new priority value.
     *
     * @see #getPriority
     * @see #SYSTEM_LOW_PRIORITY
     * @see #SYSTEM_HIGH_PRIORITY
     */
    public final void setPriority(Set<ValueAnalysisInt> priority) {
        __ds__invalidate();
        /*
        mPriority = priority;
        */
    }

    /**
     * Return the priority of this filter.
     *
     * @return The priority of the filter.
     *
     * @see #setPriority
     */
    public final int getPriority() {
        __ds__invalidate();
        return 0;
        /*
        return mPriority;
        */
    }

    /**
     * Add a new Intent action to match against.  If any actions are included
     * in the filter, then an Intent's action must be one of those values for
     * it to match.  If no actions are included, the Intent action is ignored.
     *
     * @param action Name of the action to match, i.e. Intent.ACTION_VIEW.
     */
    public final void addAction(Set<String> actions) {
        for(String action : actions) {
            if (!mActions.contains(action)) {
                mActions.add(action);
            }
        }
        /*
        if (!mActions.contains(action)) {
            mActions.add(action.intern());
        }
        */
    }

    /**
     * Return the number of actions in the filter.
     */
    public final int countActions() {
        __ds__invalidate();
        return 0;
        /*
        return mActions.size();
        */
    }

    /**
     * Return an action in the filter.
     */
    public final String getAction(Set<ValueAnalysisInt> index) {
        __ds__invalidate();
        return null;
        /*
        return mActions.get(index);
        */
    }

    /**
     * Is the given action included in the filter?  Note that if the filter
     * does not include any actions, false will <em>always</em> be returned.
     *
     * @param action The action to look for.
     *
     * @return True if the action is explicitly mentioned in the filter.
     */
    public final boolean hasAction(Set<String> action) {
        __ds__invalidate();
        return false;
        /*
        return action != null && mActions.contains(action);
        */
    }

    /**
     * Match this filter against an Intent's action.  If the filter does not
     * specify any actions, the match will always fail.
     *
     * @param action The desired action to look for.
     *
     * @return True if the action is listed in the filter.
     */
    public final boolean matchAction(Set<String> action) {
        __ds__invalidate();
        return false;
        /*
        return hasAction(action);
        */
    }

    /**
     * Return an iterator over the filter's actions.  If there are no actions,
     * returns null.
     */
    public final Iterator<String> actionsIterator() {
        __ds__invalidate();
        return null;
        /*
        return mActions != null ? mActions.iterator() : null;
        */
    }

    /**
     * Add a new Intent data type to match against.  If any types are
     * included in the filter, then an Intent's data must be <em>either</em>
     * one of these types <em>or</em> a matching scheme.  If no data types
     * are included, then an Intent will only match if it specifies no data.
     *
     * <p><em>Note: MIME type matching in the Android framework is
     * case-sensitive, unlike formal RFC MIME types.  As a result,
     * you should always write your MIME types with lower case letters,
     * and any MIME types you receive from outside of Android should be
     * converted to lower case before supplying them here.</em></p>
     *
     * <p>Throws {@link MalformedMimeTypeException} if the given MIME type is
     * not syntactically correct.
     *
     * @param type Name of the data type to match, i.e. "vnd.android.cursor.dir/person".
     *
     * @see #matchData
     */
    public final void addDataType(Set<String> type) {
        __ds__invalidate();
        /*
        final int slashpos = type.indexOf('/');
        final int typelen = type.length();
        if (slashpos > 0 && typelen >= slashpos+2) {
            if (mDataTypes == null) mDataTypes = new ArrayList<String>();
            if (typelen == slashpos+2 && type.charAt(slashpos+1) == '*') {
                String str = type.substring(0, slashpos);
                if (!mDataTypes.contains(str)) {
                    mDataTypes.add(str.intern());
                }
                mHasPartialTypes = true;
            } else {
                if (!mDataTypes.contains(type)) {
                    mDataTypes.add(type.intern());
                }
            }
            return;
        }

        throw new MalformedMimeTypeException(type);
        */
    }

    /**
     * Is the given data type included in the filter?  Note that if the filter
     * does not include any type, false will <em>always</em> be returned.
     *
     * @param type The data type to look for.
     *
     * @return True if the type is explicitly mentioned in the filter.
     */
    public final boolean hasDataType(Set<String> type) {
        __ds__invalidate();
        return false;
        /*
        return mDataTypes != null && findMimeType(type);
        */
    }

    /**
     * Return the number of data types in the filter.
     */
    public final int countDataTypes() {
        __ds__invalidate();
        return 0;
        /*
        return mDataTypes != null ? mDataTypes.size() : 0;
        */
    }

    /**
     * Return a data type in the filter.
     */
    public final String getDataType(Set<ValueAnalysisInt> index) {
        __ds__invalidate();
        return null;
        /*
        return mDataTypes.get(index);
        */
    }

    /**
     * Return an iterator over the filter's data types.
     */
    public final Iterator<String> typesIterator() {
        __ds__invalidate();
        return null;
        /*
        return mDataTypes != null ? mDataTypes.iterator() : null;
        */
    }

    /**
     * Add a new Intent data scheme to match against.  If any schemes are
     * included in the filter, then an Intent's data must be <em>either</em>
     * one of these schemes <em>or</em> a matching data type.  If no schemes
     * are included, then an Intent will match only if it includes no data.
     *
     * <p><em>Note: scheme matching in the Android framework is
     * case-sensitive, unlike formal RFC schemes.  As a result,
     * you should always write your schemes with lower case letters,
     * and any schemes you receive from outside of Android should be
     * converted to lower case before supplying them here.</em></p>
     *
     * @param scheme Name of the scheme to match, i.e. "http".
     *
     * @see #matchData
     */
    public final void addDataScheme(Set<String> scheme) {
        __ds__invalidate();
        /*
        if (mDataSchemes == null) mDataSchemes = new ArrayList<String>();
        if (!mDataSchemes.contains(scheme)) {
            mDataSchemes.add(scheme.intern());
        }
        */
    }

    /**
     * Return the number of data schemes in the filter.
     */
    public final int countDataSchemes() {
        __ds__invalidate();
        return 0;
        /*
        return mDataSchemes != null ? mDataSchemes.size() : 0;
        */
    }

    /**
     * Return a data scheme in the filter.
     */
    public final String getDataScheme(Set<ValueAnalysisInt> index) {
        __ds__invalidate();
        return null;
        /*
        return mDataSchemes.get(index);
        */
    }

    /**
     * Is the given data scheme included in the filter?  Note that if the
     * filter does not include any scheme, false will <em>always</em> be
     * returned.
     *
     * @param scheme The data scheme to look for.
     *
     * @return True if the scheme is explicitly mentioned in the filter.
     */
    public final boolean hasDataScheme(Set<String> scheme) {
        __ds__invalidate();
        return false;
        /*
        return mDataSchemes != null && mDataSchemes.contains(scheme);
        */
    }

    /**
     * Return an iterator over the filter's data schemes.
     */
    public final Iterator<String> schemesIterator() {
        __ds__invalidate();
        return null;
        /*
        return mDataSchemes != null ? mDataSchemes.iterator() : null;
        */
    }

    /**
     * Add a new Intent data authority to match against.  The filter must
     * include one or more schemes (via {@link #addDataScheme}) for the
     * authority to be considered.  If any authorities are
     * included in the filter, then an Intent's data must match one of
     * them.  If no authorities are included, then only the scheme must match.
     *
     * <p><em>Note: host name in the Android framework is
     * case-sensitive, unlike formal RFC host names.  As a result,
     * you should always write your host names with lower case letters,
     * and any host names you receive from outside of Android should be
     * converted to lower case before supplying them here.</em></p>
     *
     * @param host The host part of the authority to match.  May start with a
     *             single '*' to wildcard the front of the host name.
     * @param port Optional port part of the authority to match.  If null, any
     *             port is allowed.
     *
     * @see #matchData
     * @see #addDataScheme
     */
    public final void addDataAuthority(Set<String> host, Set<String> port) {
        __ds__invalidate();
        /*
        if (mDataAuthorities == null) mDataAuthorities =
                new ArrayList<AuthorityEntry>();
        if (port != null) port = port.intern();
        mDataAuthorities.add(new AuthorityEntry(host.intern(), port));
        */
    }

    /**
     * Return the number of data authorities in the filter.
     */
    public final int countDataAuthorities() {
        __ds__invalidate();
        return 0;
        /*
        return mDataAuthorities != null ? mDataAuthorities.size() : 0;
        */
    }

    /**
     * Is the given data authority included in the filter?  Note that if the
     * filter does not include any authorities, false will <em>always</em> be
     * returned.
     *
     * @param data The data whose authority is being looked for.
     *
     * @return Returns true if the data string matches an authority listed in the
     *         filter.
     */
    public final boolean hasDataAuthority(Uri data) {
        __ds__invalidate();
        return false;
        /*
        return matchDataAuthority(data) >= 0;
        */
    }


    /**
     * Add a new Intent data path to match against.  The filter must
     * include one or more schemes (via {@link #addDataScheme}) <em>and</em>
     * one or more authorities (via {@link #addDataAuthority}) for the
     * path to be considered.  If any paths are
     * included in the filter, then an Intent's data must match one of
     * them.  If no paths are included, then only the scheme/authority must
     * match.
     *
     * <p>The path given here can either be a literal that must directly
     * match or match against a prefix, or it can be a simple globbing pattern.
     * If the latter, you can use '*' anywhere in the pattern to match zero
     * or more instances of the previous character, '.' as a wildcard to match
     * any character, and '\' to escape the next character.
     *
     * @param path Either a raw string that must exactly match the file
     * path, or a simple pattern, depending on <var>type</var>.
     * @param type Determines how <var>path</var> will be compared to
     * determine a match: either {@link PatternMatcher#PATTERN_LITERAL},
     * {@link PatternMatcher#PATTERN_PREFIX}, or
     * {@link PatternMatcher#PATTERN_SIMPLE_GLOB}.
     *
     * @see #matchData
     * @see #addDataScheme
     * @see #addDataAuthority
     */
    public final void addDataPath(Set<String> path, Set<ValueAnalysisInt> type) {
        __ds__invalidate();
        /*
        if (mDataPaths == null) mDataPaths = new ArrayList<PatternMatcher>();
        mDataPaths.add(new PatternMatcher(path.intern(), type));
        */
    }

    /**
     * Return the number of data paths in the filter.
     */
    public final int countDataPaths() {
        __ds__invalidate();
        return 0;
        /*
        return mDataPaths != null ? mDataPaths.size() : 0;
        */
    }

    /**
     * Is the given data path included in the filter?  Note that if the
     * filter does not include any paths, false will <em>always</em> be
     * returned.
     *
     * @param data The data path to look for.  This is without the scheme
     *             prefix.
     *
     * @return True if the data string matches a path listed in the
     *         filter.
     */
    public final boolean hasDataPath(Set<String> data) {
        __ds__invalidate();
        return false;
        /*
        if (mDataPaths == null) {
            return false;
        }
        final int numDataPaths = mDataPaths.size();
        for (int i = 0; i < numDataPaths; i++) {
            final PatternMatcher pe = mDataPaths.get(i);
            if (pe.match(data)) {
                return true;
            }
        }
        return false;
        */
    }

    /**
     * Match this intent filter against the given Intent data.  This ignores
     * the data scheme -- unlike {@link #matchData}, the authority will match
     * regardless of whether there is a matching scheme.
     *
     * @param data The data whose authority is being looked for.
     *
     * @return Returns either {@link #MATCH_CATEGORY_HOST},
     * {@link #MATCH_CATEGORY_PORT}, {@link #NO_MATCH_DATA}.
     */
    public final int matchDataAuthority(Uri data) {
        __ds__invalidate();
        return 0;
        /*
        if (mDataAuthorities == null) {
            return NO_MATCH_DATA;
        }
        final int numDataAuthorities = mDataAuthorities.size();
        for (int i = 0; i < numDataAuthorities; i++) {
            final AuthorityEntry ae = mDataAuthorities.get(i);
            int match = ae.match(data);
            if (match >= 0) {
                return match;
            }
        }
        return NO_MATCH_DATA;
        */
    }

    /**
     * Match this filter against an Intent's data (type, scheme and path). If
     * the filter does not specify any types and does not specify any
     * schemes/paths, the match will only succeed if the intent does not
     * also specify a type or data.
     *
     * <p>Be aware that to match against an authority, you must also specify a base
     * scheme the authority is in.  To match against a data path, both a scheme
     * and authority must be specified.  If the filter does not specify any
     * types or schemes that it matches against, it is considered to be empty
     * (any authority or data path given is ignored, as if it were empty as
     * well).
     *
     * <p><em>Note: MIME type, Uri scheme, and host name matching in the
     * Android framework is case-sensitive, unlike the formal RFC definitions.
     * As a result, you should always write these elements with lower case letters,
     * and normalize any MIME types or Uris you receive from
     * outside of Android to ensure these elements are lower case before
     * supplying them here.</em></p>
     *
     * @param type The desired data type to look for, as returned by
     *             Intent.resolveType().
     * @param scheme The desired data scheme to look for, as returned by
     *               Intent.getScheme().
     * @param data The full data string to match against, as supplied in
     *             Intent.data.
     *
     * @return Returns either a valid match constant (a combination of
     * {@link #MATCH_CATEGORY_MASK} and {@link #MATCH_ADJUSTMENT_MASK}),
     * or one of the error codes {@link #NO_MATCH_TYPE} if the type didn't match
     * or {@link #NO_MATCH_DATA} if the scheme/path didn't match.
     *
     * @see #match
     */
    public final int matchData(Set<String> type, Set<String> scheme, Uri data) {
        __ds__invalidate();
        return 0;
        /*
        final ArrayList<String> types = mDataTypes;
        final ArrayList<String> schemes = mDataSchemes;
        final ArrayList<AuthorityEntry> authorities = mDataAuthorities;
        final ArrayList<PatternMatcher> paths = mDataPaths;

        int match = MATCH_CATEGORY_EMPTY;

        if (types == null && schemes == null) {
            return ((type == null && data == null)
                ? (MATCH_CATEGORY_EMPTY+MATCH_ADJUSTMENT_NORMAL) : NO_MATCH_DATA);
        }

        if (schemes != null) {
            if (schemes.contains(scheme != null ? scheme : "")) {
                match = MATCH_CATEGORY_SCHEME;
            } else {
                return NO_MATCH_DATA;
            }

            if (authorities != null) {
                int authMatch = matchDataAuthority(data);
                if (authMatch >= 0) {
                    if (paths == null) {
                        match = authMatch;
                    } else if (hasDataPath(data.getPath())) {
                        match = MATCH_CATEGORY_PATH;
                    } else {
                        return NO_MATCH_DATA;
                    }
                } else {
                    return NO_MATCH_DATA;
                }
            }
        } else {
            // Special case: match either an Intent with no data URI,
            // or with a scheme: URI.  This is to give a convenience for
            // the common case where you want to deal with data in a
            // content provider, which is done by type, and we don't want
            // to force everyone to say they handle content: or file: URIs.
            if (scheme != null && !"".equals(scheme)
                    && !"content".equals(scheme)
                    && !"file".equals(scheme)) {
                return NO_MATCH_DATA;
            }
        }

        if (types != null) {
            if (findMimeType(type)) {
                match = MATCH_CATEGORY_TYPE;
            } else {
                return NO_MATCH_TYPE;
            }
        } else {
            // If no MIME types are specified, then we will only match against
            // an Intent that does not have a MIME type.
            if (type != null) {
                return NO_MATCH_TYPE;
            }
        }

        return match + MATCH_ADJUSTMENT_NORMAL;
        */
    }

    /**
     * Add a new Intent category to match against.  The semantics of
     * categories is the opposite of actions -- an Intent includes the
     * categories that it requires, all of which must be included in the
     * filter in order to match.  In other words, adding a category to the
     * filter has no impact on matching unless that category is specified in
     * the intent.
     *
     * @param category Name of category to match, i.e. Intent.CATEGORY_EMBED.
     */
    public final void addCategory(Set<String> category) {
        __ds__invalidate();
        /*
        if (mCategories == null) mCategories = new ArrayList<String>();
        if (!mCategories.contains(category)) {
            mCategories.add(category.intern());
        }
        */
    }

    /**
     * Return the number of categories in the filter.
     */
    public final int countCategories() {
        __ds__invalidate();
        return 0;
        /*
        return mCategories != null ? mCategories.size() : 0;
        */
    }

    /**
     * Return a category in the filter.
     */
    public final String getCategory(Set<ValueAnalysisInt> index) {
        __ds__invalidate();
        return null;
        /*
        return mCategories.get(index);
        */
    }

    /**
     * Is the given category included in the filter?
     *
     * @param category The category that the filter supports.
     *
     * @return True if the category is explicitly mentioned in the filter.
     */
    public final boolean hasCategory(Set<String> category) {
        __ds__invalidate();
        return false;
        /*
        return mCategories != null && mCategories.contains(category);
        */
    }

    /**
     * Return an iterator over the filter's categories.
     *
     * @return Iterator if this filter has categories or {@code null} if none.
     */
    public final Iterator<String> categoriesIterator() {
        __ds__invalidate();
        return null;
        /*
        return mCategories != null ? mCategories.iterator() : null;
        */
    }

    /**
     * Match this filter against an Intent's categories.  Each category in
     * the Intent must be specified by the filter; if any are not in the
     * filter, the match fails.
     *
     * @param categories The categories included in the intent, as returned by
     *                   Intent.getCategories().
     *
     * @return If all categories match (success), null; else the name of the
     *         first category that didn't match.
     */
    public final String matchCategories(Set<Set<String>> categories) {
        __ds__invalidate();
        return null;
        /*
        if (categories == null) {
            return null;
        }

        Iterator<String> it = categories.iterator();

        if (mCategories == null) {
            return it.hasNext() ? it.next() : null;
        }

        while (it.hasNext()) {
            final String category = it.next();
            if (!mCategories.contains(category)) {
                return category;
            }
        }

        return null;
        */
    }

    /**
     * Test whether this filter matches the given intent data.  A match is
     * only successful if the actions and categories in the Intent match
     * against the filter, as described in {@link IntentFilter}; in that case,
     * the match result returned will be as per {@link #matchData}.
     *
     * @param action The intent action to match against (Intent.getAction).
     * @param type The intent type to match against (Intent.resolveType()).
     * @param scheme The data scheme to match against (Intent.getScheme()).
     * @param data The data URI to match against (Intent.getData()).
     * @param categories The categories to match against
     *                   (Intent.getCategories()).
     * @param logTag Tag to use in debugging messages.
     *
     * @return Returns either a valid match constant (a combination of
     * {@link #MATCH_CATEGORY_MASK} and {@link #MATCH_ADJUSTMENT_MASK}),
     * or one of the error codes {@link #NO_MATCH_TYPE} if the type didn't match,
     * {@link #NO_MATCH_DATA} if the scheme/path didn't match,
     * {@link #NO_MATCH_ACTION if the action didn't match, or
     * {@link #NO_MATCH_CATEGORY} if one or more categories didn't match.
     *
     * @see #matchData
     * @see Intent#getAction
     * @see Intent#resolveType
     * @see Intent#getScheme
     * @see Intent#getData
     * @see Intent#getCategories
     */
    public final int match(Set<String> action, Set<String> type, Set<String> scheme, Uri data, Set<Set<String>> categories, Set<String> logTag) {
        __ds__invalidate();
        return 0;
        /*
        if (action != null && !matchAction(action)) {
            if (false) Log.v(
                logTag, "No matching action " + action + " for " + this);
            return NO_MATCH_ACTION;
        }

        int dataMatch = matchData(type, scheme, data);
        if (dataMatch < 0) {
            if (false) {
                if (dataMatch == NO_MATCH_TYPE) {
                    Log.v(logTag, "No matching type " + type
                          + " for " + this);
                }
                if (dataMatch == NO_MATCH_DATA) {
                    Log.v(logTag, "No matching scheme/path " + data
                          + " for " + this);
                }
            }
            return dataMatch;
        }

        String categoryMismatch = matchCategories(categories);
        if (categoryMismatch != null) {
            if (false) {
                Log.v(logTag, "No matching category " + categoryMismatch + " for " + this);
            }
            return NO_MATCH_CATEGORY;
        }

        // It would be nice to treat container activities as more
        // important than ones that can be embedded, but this is not the way...
        if (false) {
            if (categories != null) {
                dataMatch -= mCategories.size() - categories.size();
            }
        }

        return dataMatch;
        */
    }

    public final int describeContents() {
        __ds__invalidate();
        return 0;
        /*
        return 0;
        */
    }

    /**
     * For debugging -- perform a check on the filter, return true if it passed
     * or false if it failed.
     *
     * {@hide}
     */
    public boolean debugCheck() {
        __ds__invalidate();
        return false;
        /*
        return true;
        */
    }
}
