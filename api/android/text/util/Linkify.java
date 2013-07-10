package android.text.util;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import android.text.method.LinkMovementMethod;
import android.text.method.MovementMethod;
import android.text.style.URLSpan;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.util.Patterns;
import android.webkit.WebView;
import android.widget.TextView;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Linkify {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.124 -0400", hash_original_method = "D1670E1FC2F10CF19A8A5BA1D0122F80", hash_generated_method = "D1670E1FC2F10CF19A8A5BA1D0122F80")
    public Linkify ()
    {
        
    }


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

    
    private static final void addLinkMovementMethod(TextView t) {
        MovementMethod m = t.getMovementMethod();
        if ((m == null) || !(m instanceof LinkMovementMethod)) {
            if (t.getLinksClickable()) {
                t.setMovementMethod(LinkMovementMethod.getInstance());
            }
        }
    }

    
    public static final void addLinks(TextView text, Pattern pattern, String scheme) {
        addLinks(text, pattern, scheme, null, null);
    }

    
    public static final void addLinks(TextView text, Pattern p, String scheme,
            MatchFilter matchFilter, TransformFilter transformFilter) {
        SpannableString s = SpannableString.valueOf(text.getText());
        if (addLinks(s, p, scheme, matchFilter, transformFilter)) {
            text.setText(s);
            addLinkMovementMethod(text);
        }
    }

    
    public static final boolean addLinks(Spannable text, Pattern pattern, String scheme) {
        return addLinks(text, pattern, scheme, null, null);
    }

    
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

    
    private static final void applyLink(String url, int start, int end, Spannable text) {
        URLSpan span = new URLSpan(url);
        text.setSpan(span, start, end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
    }

    
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

    
    private static final void pruneOverlaps(ArrayList<LinkSpec> links) {
        Comparator<LinkSpec>  c = new Comparator<LinkSpec>() {
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

    
    public interface MatchFilter {
        
        boolean acceptMatch(CharSequence s, int start, int end);
    }
    
    public interface TransformFilter {
        
        String transformUrl(final Matcher match, String url);
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.126 -0400", hash_original_field = "1269F4184CB04E11967898C54EC8D15D", hash_generated_field = "368D3C042CD4B22DC7E2E97B265A1597")

    public static final int WEB_URLS = 0x01;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.126 -0400", hash_original_field = "55ED058864363DA659896E2855AC9997", hash_generated_field = "49537DE6E32CE1FDEFBAA9B907C31C5A")

    public static final int EMAIL_ADDRESSES = 0x02;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.126 -0400", hash_original_field = "609FACB14D96841983AE682F05EB292C", hash_generated_field = "C10F585D529DD802A945821CA5FD4C88")

    public static final int PHONE_NUMBERS = 0x04;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.126 -0400", hash_original_field = "EA2E3F18A0EE154E2393173C7C6BE84D", hash_generated_field = "3CFB66FCB81210697B2CE809A5B9CEB6")

    public static final int MAP_ADDRESSES = 0x08;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.126 -0400", hash_original_field = "D80ED2E39FDE952217DA49A1D1247527", hash_generated_field = "5CA0F41FA914E0B91F6B4FF2405321CD")

    public static final int ALL = WEB_URLS | EMAIL_ADDRESSES | PHONE_NUMBERS | MAP_ADDRESSES;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.127 -0400", hash_original_field = "22A60E12D165FE70D0880E8FC2196406", hash_generated_field = "3AC0D2E4E2A49EBD47C3D4DEDB66D043")

    private static final int PHONE_NUMBER_MINIMUM_DIGITS = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.127 -0400", hash_original_field = "6B88F88D64011199D23480B3B784D6FC", hash_generated_field = "008D1D2B5A7B2E7FD037B74448FC9CE8")

    public static final MatchFilter sUrlMatchFilter = new MatchFilter() {
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.127 -0400", hash_original_field = "F9493765D21ABAB52702E4974A1B1708", hash_generated_field = "B2CCB2AB7A7BFE05D0DBC4E5E2C9C4F7")

    public static final MatchFilter sPhoneNumberMatchFilter = new MatchFilter() {
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.127 -0400", hash_original_field = "56A5F9993C0C7AC35957D43FBEFB0D1F", hash_generated_field = "EC888D0C5984A0BF717AAA49789F16EB")

    public static final TransformFilter sPhoneNumberTransformFilter = new TransformFilter() {
        public final String transformUrl(final Matcher match, String url) {
            return Patterns.digitsAndPlusOnly(match);
        }
    };
    
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
    
    
    public final boolean equals(Object o) {
                return false;
            }
    
    
    public final String transformUrl(final Matcher match, String url) {
            return Patterns.digitsAndPlusOnly(match);
        }
    
}

class LinkSpec {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.127 -0400", hash_original_field = "572D4E421E5E6B9BC11D815E8A027112", hash_generated_field = "1B433832A8D8C8722BF3FE2FD98C7841")

    String url;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.127 -0400", hash_original_field = "EA2B2676C28C0DB26D39331A336C6B92", hash_generated_field = "A420862623A673AB42FCEC90A616158F")

    int start;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.127 -0400", hash_original_field = "7F021A1415B86F2D013B2618FB31AE53", hash_generated_field = "302E5A3147803830441A79AED31F4022")

    int end;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.127 -0400", hash_original_method = "556B7BFA52BBBC98785B42B203495262", hash_generated_method = "556B7BFA52BBBC98785B42B203495262")
    public LinkSpec ()
    {
        
    }


}

