package android.text.util;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.method.MovementMethod;
import android.text.style.URLSpan;
import android.util.Patterns;
import android.webkit.WebView;
import android.widget.TextView;

public class Linkify {

    /**
     *  Scans the text of the provided Spannable and turns all occurrences
     *  of the link types indicated in the mask into clickable links.
     *  If the mask is nonzero, it also removes any existing URLSpans
     *  attached to the Spannable, to avoid problems if you call it
     *  repeatedly on the same text.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:13.769 -0500", hash_original_method = "6675017785DF7C3E1BBF27AB1F21461B", hash_generated_method = "1A156E678AD361ACA842A68E86E3BB2B")
    
public static final boolean addLinks(Spannable text, int mask) {
        if (mask == 0) {
            return false;
        }

        URLSpan[] old = text.getSpans(0, text.length(), URLSpan.class);

        for (int i = old.length - 1; i >= 0; i--) {
            text.removeSpan(old[i]);
        }

        ArrayList<LinkSpec> links = new ArrayList<LinkSpec>();

        if ((mask & WEB_URLS) != 0) {
            gatherLinks(links, text, Patterns.WEB_URL,
                new String[] { "http://", "https://", "rtsp://" },
                sUrlMatchFilter, null);
        }

        if ((mask & EMAIL_ADDRESSES) != 0) {
            gatherLinks(links, text, Patterns.EMAIL_ADDRESS,
                new String[] { "mailto:" },
                null, null);
        }

        if ((mask & PHONE_NUMBERS) != 0) {
            gatherLinks(links, text, Patterns.PHONE,
                new String[] { "tel:" },
                sPhoneNumberMatchFilter, sPhoneNumberTransformFilter);
        }

        if ((mask & MAP_ADDRESSES) != 0) {
            gatherMapLinks(links, text);
        }

        pruneOverlaps(links);

        if (links.size() == 0) {
            return false;
        }

        for (LinkSpec link: links) {
            applyLink(link.url, link.start, link.end, text);
        }

        return true;
    }

    /**
     *  Scans the text of the provided TextView and turns all occurrences of
     *  the link types indicated in the mask into clickable links.  If matches
     *  are found the movement method for the TextView is set to
     *  LinkMovementMethod.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:13.772 -0500", hash_original_method = "D4023CCAA6FDAA3E9FB26AE7253D5FC2", hash_generated_method = "A5F616A48879E1E66C24E798A9C82B2A")
    
public static final boolean addLinks(TextView text, int mask) {
        if (mask == 0) {
            return false;
        }

        CharSequence t = text.getText();

        if (t instanceof Spannable) {
            if (addLinks((Spannable) t, mask)) {
                addLinkMovementMethod(text);
                return true;
            }

            return false;
        } else {
            SpannableString s = SpannableString.valueOf(t);

            if (addLinks(s, mask)) {
                addLinkMovementMethod(text);
                text.setText(s);

                return true;
            }

            return false;
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:13.776 -0500", hash_original_method = "B3A143C63E26B7CFD3F7C75589162FB2", hash_generated_method = "C62486D87726CBF969CA54D9409C2FAB")
    
private static final void addLinkMovementMethod(TextView t) {
        MovementMethod m = t.getMovementMethod();

        if ((m == null) || !(m instanceof LinkMovementMethod)) {
            if (t.getLinksClickable()) {
                t.setMovementMethod(LinkMovementMethod.getInstance());
            }
        }
    }

    /**
     *  Applies a regex to the text of a TextView turning the matches into
     *  links.  If links are found then UrlSpans are applied to the link
     *  text match areas, and the movement method for the text is changed
     *  to LinkMovementMethod.
     *
     *  @param text         TextView whose text is to be marked-up with links
     *  @param pattern      Regex pattern to be used for finding links
     *  @param scheme       Url scheme string (eg <code>http://</code> to be
     *                      prepended to the url of links that do not have
     *                      a scheme specified in the link text
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:13.778 -0500", hash_original_method = "9F163477F9B0B187536137CC20B2DC0D", hash_generated_method = "921121D797C16A9C7CF564107E47138A")
    
public static final void addLinks(TextView text, Pattern pattern, String scheme) {
        addLinks(text, pattern, scheme, null, null);
    }

    /**
     *  Applies a regex to the text of a TextView turning the matches into
     *  links.  If links are found then UrlSpans are applied to the link
     *  text match areas, and the movement method for the text is changed
     *  to LinkMovementMethod.
     *
     *  @param text         TextView whose text is to be marked-up with links
     *  @param p            Regex pattern to be used for finding links
     *  @param scheme       Url scheme string (eg <code>http://</code> to be
     *                      prepended to the url of links that do not have
     *                      a scheme specified in the link text
     *  @param matchFilter  The filter that is used to allow the client code
     *                      additional control over which pattern matches are
     *                      to be converted into links.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:13.781 -0500", hash_original_method = "524FF7740D87FDD88442F9E07F71C4C5", hash_generated_method = "EB9271C11E5362AFD32FD684F840EB47")
    
public static final void addLinks(TextView text, Pattern p, String scheme,
            MatchFilter matchFilter, TransformFilter transformFilter) {
        SpannableString s = SpannableString.valueOf(text.getText());

        if (addLinks(s, p, scheme, matchFilter, transformFilter)) {
            text.setText(s);
            addLinkMovementMethod(text);
        }
    }

    /**
     *  Applies a regex to a Spannable turning the matches into
     *  links.
     *
     *  @param text         Spannable whose text is to be marked-up with
     *                      links
     *  @param pattern      Regex pattern to be used for finding links
     *  @param scheme       Url scheme string (eg <code>http://</code> to be
     *                      prepended to the url of links that do not have
     *                      a scheme specified in the link text
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:13.785 -0500", hash_original_method = "4771008E867E137AE8D7BAC2F0B7386A", hash_generated_method = "935F0F10BC8B50591B3F9D7FF378D172")
    
public static final boolean addLinks(Spannable text, Pattern pattern, String scheme) {
        return addLinks(text, pattern, scheme, null, null);
    }

    /**
     *  Applies a regex to a Spannable turning the matches into
     *  links.
     *
     *  @param s            Spannable whose text is to be marked-up with
     *                      links
     *  @param p            Regex pattern to be used for finding links
     *  @param scheme       Url scheme string (eg <code>http://</code> to be
     *                      prepended to the url of links that do not have
     *                      a scheme specified in the link text
     *  @param matchFilter  The filter that is used to allow the client code
     *                      additional control over which pattern matches are
     *                      to be converted into links.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:13.788 -0500", hash_original_method = "6CF180C8AC48F581F44385FCBEB35530", hash_generated_method = "497D4A1B31F5E5B3AFDA95280D0EF258")
    
public static final boolean addLinks(Spannable s, Pattern p,
            String scheme, MatchFilter matchFilter,
            TransformFilter transformFilter) {
        boolean hasMatches = false;
        String prefix = (scheme == null) ? "" : scheme.toLowerCase();
        Matcher m = p.matcher(s);

        while (m.find()) {
            int start = m.start();
            int end = m.end();
            boolean allowed = true;

            if (matchFilter != null) {
                allowed = matchFilter.acceptMatch(s, start, end);
            }

            if (allowed) {
                String url = makeUrl(m.group(0), new String[] { prefix },
                                     m, transformFilter);

                applyLink(url, start, end, s);
                hasMatches = true;
            }
        }

        return hasMatches;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:13.790 -0500", hash_original_method = "6A96E49D98DB283ABEDCA5DA8A0D27E1", hash_generated_method = "3DFF1086F3FB5C82A60C75633D7FFF46")
    
private static final void applyLink(String url, int start, int end, Spannable text) {
        URLSpan span = new URLSpan(url);

        text.setSpan(span, start, end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:13.794 -0500", hash_original_method = "56EBC488F3C5E85B7277F381EAE46938", hash_generated_method = "B3B1029566EB5A60F682379C38FD0323")
    
private static final String makeUrl(String url, String[] prefixes,
            Matcher m, TransformFilter filter) {
        if (filter != null) {
            url = filter.transformUrl(m, url);
        }

        boolean hasPrefix = false;
        
        for (int i = 0; i < prefixes.length; i++) {
            if (url.regionMatches(true, 0, prefixes[i], 0,
                                  prefixes[i].length())) {
                hasPrefix = true;

                // Fix capitalization if necessary
                if (!url.regionMatches(false, 0, prefixes[i], 0,
                                       prefixes[i].length())) {
                    url = prefixes[i] + url.substring(prefixes[i].length());
                }

                break;
            }
        }

        if (!hasPrefix) {
            url = prefixes[0] + url;
        }

        return url;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:13.797 -0500", hash_original_method = "0A5825FC3972F737412507B95D87C8F2", hash_generated_method = "B0D53B7CB5CA47AD666E7768B30EFA0E")
    
private static final void gatherLinks(ArrayList<LinkSpec> links,
            Spannable s, Pattern pattern, String[] schemes,
            MatchFilter matchFilter, TransformFilter transformFilter) {
        Matcher m = pattern.matcher(s);

        while (m.find()) {
            int start = m.start();
            int end = m.end();

            if (matchFilter == null || matchFilter.acceptMatch(s, start, end)) {
                LinkSpec spec = new LinkSpec();
                String url = makeUrl(m.group(0), schemes, m, transformFilter);

                spec.url = url;
                spec.start = start;
                spec.end = end;

                links.add(spec);
            }
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:13.800 -0500", hash_original_method = "2760D74C5CC252E337320350F0C84F55", hash_generated_method = "5ED656E3B4083BA9313227BBAC4B002E")
    
private static final void gatherMapLinks(ArrayList<LinkSpec> links, Spannable s) {
        String string = s.toString();
        String address;
        int base = 0;

        while ((address = WebView.findAddress(string)) != null) {
            int start = string.indexOf(address);

            if (start < 0) {
                break;
            }

            LinkSpec spec = new LinkSpec();
            int length = address.length();
            int end = start + length;
            
            spec.start = base + start;
            spec.end = base + end;
            string = string.substring(end);
            base += end;

            String encodedAddress = null;

            try {
                encodedAddress = URLEncoder.encode(address,"UTF-8");
            } catch (UnsupportedEncodingException e) {
                continue;
            }

            spec.url = "geo:0,0?q=" + encodedAddress;
            links.add(spec);
        }
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static final void pruneOverlaps(ArrayList<LinkSpec> links) {
        Comparator<LinkSpec>  c = new Comparator<LinkSpec>() {
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:13.804 -0500", hash_original_method = "8ED3E1F0B1838A02146C142C5B858BAA", hash_generated_method = "7CF7D8B086CE7815023B31658E63FE8B")
            
public final int compare(LinkSpec a, LinkSpec b) {
                if (a.start < b.start) {
                    return -1;
                }

                if (a.start > b.start) {
                    return 1;
                }

                if (a.end < b.end) {
                    return 1;
                }

                if (a.end > b.end) {
                    return -1;
                }

                return 0;
            }

            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:13.807 -0500", hash_original_method = "41879F3ECE84BDD3E4B04325E71E8A69", hash_generated_method = "F0FFBDE17DFCB00CE91A2991226C5D29")
            
public final boolean equals(Object o) {
                return false;
            }
        };
        Collections.sort(links, c);
        int len = links.size();
        int i = 0;
        while (i < len - 1) {
            LinkSpec a = links.get(i);
            LinkSpec b = links.get(i + 1);
            int remove = -1;
            if ((a.start <= b.start) && (a.end > b.start)) {
                if (b.end <= a.end) {
                    remove = i + 1;
                } else if ((a.end - a.start) > (b.end - b.start)) {
                    remove = i + 1;
                } else if ((a.end - a.start) < (b.end - b.start)) {
                    remove = i;
                }
                if (remove != -1) {
                    links.remove(remove);
                    len--;
                    continue;
                }
            }
            i++;
        }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:13.728 -0500", hash_original_field = "1539B154C51FEE1E4007A9D0CC57AC8E", hash_generated_field = "368D3C042CD4B22DC7E2E97B265A1597")

    public static final int WEB_URLS = 0x01;
    
    public interface MatchFilter {
        
        @DSComment("Abstract Method")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        @DSVerified
        boolean acceptMatch(CharSequence s, int start, int end);
    }
    
    public interface TransformFilter {
        
        @DSVerified
        String transformUrl(final Matcher match, String url);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:13.730 -0500", hash_original_field = "0B087C31A3D9458F8B5B2380338FB1CA", hash_generated_field = "49537DE6E32CE1FDEFBAA9B907C31C5A")

    public static final int EMAIL_ADDRESSES = 0x02;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:13.733 -0500", hash_original_field = "3BB571E9B4FA068F7430AC660FCA230D", hash_generated_field = "C10F585D529DD802A945821CA5FD4C88")

    public static final int PHONE_NUMBERS = 0x04;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:13.736 -0500", hash_original_field = "E1618FC7087867AC97AD15838436ED73", hash_generated_field = "3CFB66FCB81210697B2CE809A5B9CEB6")

    public static final int MAP_ADDRESSES = 0x08;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:13.739 -0500", hash_original_field = "5982208D3FEB2A3AC71DE5C05E1294CB", hash_generated_field = "5CA0F41FA914E0B91F6B4FF2405321CD")

    public static final int ALL = WEB_URLS | EMAIL_ADDRESSES | PHONE_NUMBERS | MAP_ADDRESSES;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:13.741 -0500", hash_original_field = "E5A4DD8A5F0002E2DA467172C983B9A0", hash_generated_field = "3AC0D2E4E2A49EBD47C3D4DEDB66D043")

    private static final int PHONE_NUMBER_MINIMUM_DIGITS = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:40.483 -0400", hash_original_field = "6B88F88D64011199D23480B3B784D6FC", hash_generated_field = "008D1D2B5A7B2E7FD037B74448FC9CE8")

    public static final MatchFilter sUrlMatchFilter = new MatchFilter() {
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:13.745 -0500", hash_original_method = "AAF769FD7BAFAAFBC12DBCD0A5379028", hash_generated_method = "E3F6039DA7A936B630E4A9CEC402206A")
        
public final boolean acceptMatch(CharSequence s, int start, int end) {
            if (start == 0) {
                return true;
            }

            if (s.charAt(start - 1) == '@') {
                return false;
            }

            return true;
        }
    };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:40.483 -0400", hash_original_field = "F9493765D21ABAB52702E4974A1B1708", hash_generated_field = "B2CCB2AB7A7BFE05D0DBC4E5E2C9C4F7")

    public static final MatchFilter sPhoneNumberMatchFilter = new MatchFilter() {
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:13.752 -0500", hash_original_method = "CE7315FEE6FC136CE864E7D696A4648D", hash_generated_method = "B758E7F06A4AF83A3C8CC4415F549F6F")
        
public final boolean acceptMatch(CharSequence s, int start, int end) {
            int digitCount = 0;

            for (int i = start; i < end; i++) {
                if (Character.isDigit(s.charAt(i))) {
                    digitCount++;
                    if (digitCount >= PHONE_NUMBER_MINIMUM_DIGITS) {
                        return true;
                    }
                }
            }
            return false;
        }
    };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:40.483 -0400", hash_original_field = "56A5F9993C0C7AC35957D43FBEFB0D1F", hash_generated_field = "EC888D0C5984A0BF717AAA49789F16EB")

    public static final TransformFilter sPhoneNumberTransformFilter = new TransformFilter() {
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:13.759 -0500", hash_original_method = "98DF336D3D5B2E2B9C3D87FAC939396C", hash_generated_method = "0EB6710A9F75FA19B2327695DC8460DC")
        
public final String transformUrl(final Matcher match, String url) {
            return Patterns.digitsAndPlusOnly(match);
        }
    };
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:40.467 -0400", hash_original_method = "D1670E1FC2F10CF19A8A5BA1D0122F80", hash_generated_method = "D1670E1FC2F10CF19A8A5BA1D0122F80")
    public Linkify ()
    {
        //Synthesized constructor
    }
    // orphaned legacy method
    public final boolean acceptMatch(CharSequence s, int start, int end) {
            int digitCount = 0;

            for (int i = start; i < end; i++) {
                if (Character.isDigit(s.charAt(i))) {
                    digitCount++;
                    if (digitCount >= PHONE_NUMBER_MINIMUM_DIGITS) {
                        return true;
                    }
                }
            }
            return false;
        }
    
    // orphaned legacy method
    public final int compare(LinkSpec a, LinkSpec b) {
                if (a.start < b.start) {
                    return -1;
                }
                if (a.start > b.start) {
                    return 1;
                }
                if (a.end < b.end) {
                    return 1;
                }
                if (a.end > b.end) {
                    return -1;
                }
                return 0;
            }
    
    // orphaned legacy method
    public final boolean equals(Object o) {
                return false;
            }
    
    // orphaned legacy method
    public final String transformUrl(final Matcher match, String url) {
            return Patterns.digitsAndPlusOnly(match);
        }
    
}

class LinkSpec {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:13.813 -0500", hash_original_field = "1B433832A8D8C8722BF3FE2FD98C7841", hash_generated_field = "1B433832A8D8C8722BF3FE2FD98C7841")

    String url;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:13.815 -0500", hash_original_field = "A420862623A673AB42FCEC90A616158F", hash_generated_field = "A420862623A673AB42FCEC90A616158F")

    int start;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:13.817 -0500", hash_original_field = "302E5A3147803830441A79AED31F4022", hash_generated_field = "302E5A3147803830441A79AED31F4022")

    int end;
    
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:40.484 -0400", hash_original_method = "556B7BFA52BBBC98785B42B203495262", hash_generated_method = "556B7BFA52BBBC98785B42B203495262")
    public LinkSpec ()
    {
        //Synthesized constructor
    }

}

