package android.text.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.080 -0400", hash_original_method = "917A42E443842412DB20101D262C3884", hash_generated_method = "917A42E443842412DB20101D262C3884")
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
    
    public static final int WEB_URLS = 0x01;
    public static final int EMAIL_ADDRESSES = 0x02;
    public static final int PHONE_NUMBERS = 0x04;
    public static final int MAP_ADDRESSES = 0x08;
    public static final int ALL = WEB_URLS | EMAIL_ADDRESSES | PHONE_NUMBERS | MAP_ADDRESSES;
    private static final int PHONE_NUMBER_MINIMUM_DIGITS = 5;
    public static final MatchFilter sUrlMatchFilter = new MatchFilter() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.083 -0400", hash_original_method = "AAF769FD7BAFAAFBC12DBCD0A5379028", hash_generated_method = "CA5441EBF20DBED4DECFF5D8DCCF9AC3")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public final boolean acceptMatch(CharSequence s, int start, int end) {
            dsTaint.addTaint(s);
            dsTaint.addTaint(start);
            dsTaint.addTaint(end);
            {
                boolean var02D9D7AE30909F4CCD68B5E2961CF0AA_2109617817 = (s.charAt(start - 1) == '@');
            } //End collapsed parenthetic
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //if (start == 0) {
                //return true;
            //}
            //if (s.charAt(start - 1) == '@') {
                //return false;
            //}
            //return true;
        }

        
}; //Transformed anonymous class
    public static final MatchFilter sPhoneNumberMatchFilter = new MatchFilter() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.083 -0400", hash_original_method = "CE7315FEE6FC136CE864E7D696A4648D", hash_generated_method = "F2178DF53E13185A426B3D1B297014F9")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public final boolean acceptMatch(CharSequence s, int start, int end) {
            dsTaint.addTaint(s);
            dsTaint.addTaint(start);
            dsTaint.addTaint(end);
            int digitCount;
            digitCount = 0;
            {
                int i;
                i = start;
                {
                    {
                        boolean var35421BA2D7BDB98F8DBF8E226AB5886A_415817275 = (Character.isDigit(s.charAt(i)));
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //int digitCount = 0;
            //for (int i = start; i < end; i++) {
                //if (Character.isDigit(s.charAt(i))) {
                    //digitCount++;
                    //if (digitCount >= PHONE_NUMBER_MINIMUM_DIGITS) {
                        //return true;
                    //}
                //}
            //}
            //return false;
        }

        
}; //Transformed anonymous class
    public static final TransformFilter sPhoneNumberTransformFilter = new TransformFilter() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.084 -0400", hash_original_method = "98DF336D3D5B2E2B9C3D87FAC939396C", hash_generated_method = "6B85AB01C68E6CDD49BA02A5B1D8B9BE")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public final String transformUrl(final Matcher match, String url) {
            dsTaint.addTaint(match.dsTaint);
            dsTaint.addTaint(url);
            String varA5CC6F5C5662042961C83546B44AAB03_676026968 = (Patterns.digitsAndPlusOnly(match));
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return Patterns.digitsAndPlusOnly(match);
        }

        
}; //Transformed anonymous class
}

class LinkSpec {
    String url;
    int start;
    int end;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.084 -0400", hash_original_method = "D23FC19026F33FCEAD3964BF62CA1353", hash_generated_method = "D23FC19026F33FCEAD3964BF62CA1353")
        public LinkSpec ()
    {
    }


}

