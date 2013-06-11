package android.text.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
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
    public static final int WEB_URLS = 0x01;
    public static final int EMAIL_ADDRESSES = 0x02;
    public static final int PHONE_NUMBERS = 0x04;
    public static final int MAP_ADDRESSES = 0x08;
    public static final int ALL = WEB_URLS | EMAIL_ADDRESSES | PHONE_NUMBERS | MAP_ADDRESSES;
    private static final int PHONE_NUMBER_MINIMUM_DIGITS = 5;
    public static final MatchFilter sUrlMatchFilter = new MatchFilter() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.561 -0400", hash_original_method = "AAF769FD7BAFAAFBC12DBCD0A5379028", hash_generated_method = "363E712F1D1BEB5136853672C7B24CAC")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public final boolean acceptMatch(CharSequence s, int start, int end) {
            dsTaint.addTaint(s);
            dsTaint.addTaint(start);
            dsTaint.addTaint(end);
            {
                boolean var02D9D7AE30909F4CCD68B5E2961CF0AA_1669329851 = (s.charAt(start - 1) == '@');
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
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.561 -0400", hash_original_method = "CE7315FEE6FC136CE864E7D696A4648D", hash_generated_method = "974363F4C0098292FA68A8E75520BDC5")
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
                        boolean var35421BA2D7BDB98F8DBF8E226AB5886A_1301749447 = (Character.isDigit(s.charAt(i)));
                        {
                            digitCount++;
                        } //End block
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
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.561 -0400", hash_original_method = "98DF336D3D5B2E2B9C3D87FAC939396C", hash_generated_method = "FEF64C625CBC9CC226E25EB739575D2B")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public final String transformUrl(final Matcher match, String url) {
            dsTaint.addTaint(match.dsTaint);
            dsTaint.addTaint(url);
            String varA5CC6F5C5662042961C83546B44AAB03_2068691224 = (Patterns.digitsAndPlusOnly(match));
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return Patterns.digitsAndPlusOnly(match);
        }

        
}; //Transformed anonymous class
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.561 -0400", hash_original_method = "510F90B58644B66BB0035E784B519169", hash_generated_method = "1A156E678AD361ACA842A68E86E3BB2B")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.561 -0400", hash_original_method = "D4023CCAA6FDAA3E9FB26AE7253D5FC2", hash_generated_method = "A5F616A48879E1E66C24E798A9C82B2A")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.562 -0400", hash_original_method = "B3A143C63E26B7CFD3F7C75589162FB2", hash_generated_method = "C62486D87726CBF969CA54D9409C2FAB")
    private static final void addLinkMovementMethod(TextView t) {
        MovementMethod m = t.getMovementMethod();
        if ((m == null) || !(m instanceof LinkMovementMethod)) {
            if (t.getLinksClickable()) {
                t.setMovementMethod(LinkMovementMethod.getInstance());
            }
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.562 -0400", hash_original_method = "9F163477F9B0B187536137CC20B2DC0D", hash_generated_method = "921121D797C16A9C7CF564107E47138A")
    public static final void addLinks(TextView text, Pattern pattern, String scheme) {
        addLinks(text, pattern, scheme, null, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.562 -0400", hash_original_method = "524FF7740D87FDD88442F9E07F71C4C5", hash_generated_method = "EB9271C11E5362AFD32FD684F840EB47")
    public static final void addLinks(TextView text, Pattern p, String scheme,
            MatchFilter matchFilter, TransformFilter transformFilter) {
        SpannableString s = SpannableString.valueOf(text.getText());
        if (addLinks(s, p, scheme, matchFilter, transformFilter)) {
            text.setText(s);
            addLinkMovementMethod(text);
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.562 -0400", hash_original_method = "4771008E867E137AE8D7BAC2F0B7386A", hash_generated_method = "935F0F10BC8B50591B3F9D7FF378D172")
    public static final boolean addLinks(Spannable text, Pattern pattern, String scheme) {
        return addLinks(text, pattern, scheme, null, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.562 -0400", hash_original_method = "6CF180C8AC48F581F44385FCBEB35530", hash_generated_method = "497D4A1B31F5E5B3AFDA95280D0EF258")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.562 -0400", hash_original_method = "6A96E49D98DB283ABEDCA5DA8A0D27E1", hash_generated_method = "3DFF1086F3FB5C82A60C75633D7FFF46")
    private static final void applyLink(String url, int start, int end, Spannable text) {
        URLSpan span = new URLSpan(url);
        text.setSpan(span, start, end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.562 -0400", hash_original_method = "56EBC488F3C5E85B7277F381EAE46938", hash_generated_method = "CB40FFA8C490DA783D56C769FF0A219B")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.562 -0400", hash_original_method = "0A5825FC3972F737412507B95D87C8F2", hash_generated_method = "B0D53B7CB5CA47AD666E7768B30EFA0E")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.562 -0400", hash_original_method = "2760D74C5CC252E337320350F0C84F55", hash_generated_method = "5ED656E3B4083BA9313227BBAC4B002E")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.562 -0400", hash_original_method = "0B2FA58627B8661B3AA266184BE1D299", hash_generated_method = "3305B3CA9B121570394D797865E8D22E")
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
    
}

class LinkSpec {
    String url;
    int start;
    int end;
    
}


