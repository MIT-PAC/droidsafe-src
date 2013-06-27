package java.text;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.text.AttributedCharacterIterator.Attribute;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;

public class AttributedString {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:48.709 -0400", hash_original_field = "1CB251EC0D568DE6A929B520C4AED8D1", hash_generated_field = "9EF4B8A5DE4B8BD37EE465C3BB62CC6C")

    String text;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:48.709 -0400", hash_original_field = "EC5B70424D6106D0D37EACD23354A330", hash_generated_field = "EA3CF0028C57B0F0FB6C371B620465D1")

    Map<AttributedCharacterIterator.Attribute, List<Range>> attributeMap;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:48.719 -0400", hash_original_method = "5638BBE38DFF9B04A672F4EC9A02409B", hash_generated_method = "EE4DDFFB428B5A6F914B1EEDAEA77B1A")
    public  AttributedString(AttributedCharacterIterator iterator) {
        {
            boolean var5791DB9351E60242F3260BB947788691_981194993 = (iterator.getBeginIndex() > iterator.getEndIndex());
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Invalid substring range");
            } //End block
        } //End collapsed parenthetic
        StringBuilder buffer;
        buffer = new StringBuilder();
        {
            int i;
            i = iterator.getBeginIndex();
            boolean varD47BAE727A1CA5D8FBD74E81EBBAC580_417540988 = (i < iterator.getEndIndex());
            {
                buffer.append(iterator.current());
                iterator.next();
            } //End block
        } //End collapsed parenthetic
        text = buffer.toString();
        Set<AttributedCharacterIterator.Attribute> attributes;
        attributes = iterator
                .getAllAttributeKeys();
        attributeMap = new HashMap<Attribute, List<Range>>(
                (attributes.size() * 4 / 3) + 1);
        Iterator<Attribute> it;
        it = attributes.iterator();
        {
            boolean var03729FD53960D8DCA3A41A13A0229637_843355917 = (it.hasNext());
            {
                AttributedCharacterIterator.Attribute attribute;
                attribute = it.next();
                iterator.setIndex(0);
                {
                    boolean var28ACB1F338988605D7BB159EDA96A571_98140391 = (iterator.current() != CharacterIterator.DONE);
                    {
                        int start;
                        start = iterator.getRunStart(attribute);
                        int limit;
                        limit = iterator.getRunLimit(attribute);
                        Object value;
                        value = iterator.getAttribute(attribute);
                        {
                            addAttribute(attribute, value, start, limit);
                        } //End block
                        iterator.setIndex(limit);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(iterator.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:48.720 -0400", hash_original_method = "3A8973AD4EBE1F3B94E1633368C42F9D", hash_generated_method = "E3E6E2C0923E87A95BD3CCE87CBB4F80")
    private  AttributedString(AttributedCharacterIterator iterator, int start,
            int end, Set<Attribute> attributes) {
        {
            boolean var6E1EE5C4631EC62ECEF890E2A840FF67_1774564804 = (start < iterator.getBeginIndex() || end > iterator.getEndIndex()
                || start > end);
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
            } //End block
        } //End collapsed parenthetic
        StringBuilder buffer;
        buffer = new StringBuilder();
        iterator.setIndex(start);
        {
            boolean varFB2E1080C5571E90BCE1803511FF22B4_491976477 = (iterator.getIndex() < end);
            {
                buffer.append(iterator.current());
                iterator.next();
            } //End block
        } //End collapsed parenthetic
        text = buffer.toString();
        attributeMap = new HashMap<Attribute, List<Range>>(
                (attributes.size() * 4 / 3) + 1);
        Iterator<Attribute> it;
        it = attributes.iterator();
        {
            boolean var03729FD53960D8DCA3A41A13A0229637_1897001894 = (it.hasNext());
            {
                AttributedCharacterIterator.Attribute attribute;
                attribute = it.next();
                iterator.setIndex(start);
                {
                    boolean var01C467E388CE293308E11B7796E75DEA_1694431109 = (iterator.getIndex() < end);
                    {
                        Object value;
                        value = iterator.getAttribute(attribute);
                        int runStart;
                        runStart = iterator.getRunStart(attribute);
                        int limit;
                        limit = iterator.getRunLimit(attribute);
                        {
                            addAttribute(attribute, value, (runStart < start ? start
                            : runStart)
                            - start, (limit > end ? end : limit) - start);
                        } //End block
                        iterator.setIndex(limit);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(iterator.getTaint());
        addTaint(start);
        addTaint(end);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:48.724 -0400", hash_original_method = "D0E1FC5545253EA6E008AE3675A9452F", hash_generated_method = "DD2B752A6779C8498BD80371C09AFEDD")
    public  AttributedString(AttributedCharacterIterator iterator, int start,
            int end) {
        this(iterator, start, end, iterator.getAllAttributeKeys());
        addTaint(iterator.getTaint());
        addTaint(start);
        addTaint(end);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:48.730 -0400", hash_original_method = "B4766721E168BC843A6EA06CFE59500E", hash_generated_method = "EC90DC0B7D0EA910D176297DA1AB5C63")
    public  AttributedString(AttributedCharacterIterator iterator, int start,
            int end, AttributedCharacterIterator.Attribute[] attributes) {
        this(iterator, start, end, (attributes == null
                ? new HashSet<Attribute>()
                : new HashSet<Attribute>(Arrays.asList(attributes))));
        addTaint(iterator.getTaint());
        addTaint(start);
        addTaint(end);
        addTaint(attributes[0].getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:48.735 -0400", hash_original_method = "A0ACF5D97B9D79B3295575A771939692", hash_generated_method = "88A4D20F83833C26A87FB62D6E7C80E3")
    public  AttributedString(String value) {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } //End block
        text = value;
        attributeMap = new HashMap<Attribute, List<Range>>(11);
        // ---------- Original Method ----------
        //if (value == null) {
            //throw new NullPointerException();
        //}
        //text = value;
        //attributeMap = new HashMap<Attribute, List<Range>>(11);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:48.736 -0400", hash_original_method = "85CF866984BA31F6F3E97322323F86BA", hash_generated_method = "5F7BB2C6CC29C6CAA74522ABD8601715")
    public  AttributedString(String value,
            Map<? extends AttributedCharacterIterator.Attribute, ?> attributes) {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } //End block
        {
            boolean varF38D1CF4F9C3BE6C8047C579649A2A1F_1794376498 = (value.length() == 0 && !attributes.isEmpty());
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Cannot add attributes to empty string");
            } //End block
        } //End collapsed parenthetic
        text = value;
        attributeMap = new HashMap<Attribute, List<Range>>(
                (attributes.size() * 4 / 3) + 1);
        Iterator<?> it;
        it = attributes.entrySet().iterator();
        {
            boolean var03729FD53960D8DCA3A41A13A0229637_1465301854 = (it.hasNext());
            {
                Map.Entry<?, ?> entry;
                entry = (Map.Entry<?, ?>) it.next();
                ArrayList<Range> ranges;
                ranges = new ArrayList<Range>(1);
                ranges.add(new Range(0, text.length(), entry.getValue()));
                attributeMap.put((AttributedCharacterIterator.Attribute) entry
                    .getKey(), ranges);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (value == null) {
            //throw new NullPointerException();
        //}
        //if (value.length() == 0 && !attributes.isEmpty()) {
            //throw new IllegalArgumentException("Cannot add attributes to empty string");
        //}
        //text = value;
        //attributeMap = new HashMap<Attribute, List<Range>>(
                //(attributes.size() * 4 / 3) + 1);
        //Iterator<?> it = attributes.entrySet().iterator();
        //while (it.hasNext()) {
            //Map.Entry<?, ?> entry = (Map.Entry<?, ?>) it.next();
            //ArrayList<Range> ranges = new ArrayList<Range>(1);
            //ranges.add(new Range(0, text.length(), entry.getValue()));
            //attributeMap.put((AttributedCharacterIterator.Attribute) entry
                    //.getKey(), ranges);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:48.737 -0400", hash_original_method = "F800EB2F1E580436E49CB51D04E3F37C", hash_generated_method = "264D1340A8E3A81B6034FCF6C408A73C")
    public void addAttribute(AttributedCharacterIterator.Attribute attribute, Object value) {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } //End block
        {
            boolean var2E3F580615CDCAA5961A2E6CF25EC4EB_1592574040 = (text.length() == 0);
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
            } //End block
        } //End collapsed parenthetic
        List<Range> ranges;
        ranges = attributeMap.get(attribute);
        {
            ranges = new ArrayList<Range>(1);
            attributeMap.put(attribute, ranges);
        } //End block
        {
            ranges.clear();
        } //End block
        ranges.add(new Range(0, text.length(), value));
        addTaint(attribute.getTaint());
        addTaint(value.getTaint());
        // ---------- Original Method ----------
        //if (attribute == null) {
            //throw new NullPointerException();
        //}
        //if (text.length() == 0) {
            //throw new IllegalArgumentException();
        //}
        //List<Range> ranges = attributeMap.get(attribute);
        //if (ranges == null) {
            //ranges = new ArrayList<Range>(1);
            //attributeMap.put(attribute, ranges);
        //} else {
            //ranges.clear();
        //}
        //ranges.add(new Range(0, text.length(), value));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:48.747 -0400", hash_original_method = "1EA9CE9DE6197B4051F39E120F823C8E", hash_generated_method = "E26B9706D922841955AEE14958DD7D04")
    public void addAttribute(AttributedCharacterIterator.Attribute attribute,
            Object value, int start, int end) {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } //End block
        {
            boolean varC9BCC04F7A62407C3BA13DEEA6DE5168_845811433 = (start < 0 || end > text.length() || start >= end);
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
            } //End block
        } //End collapsed parenthetic
        List<Range> ranges;
        ranges = attributeMap.get(attribute);
        {
            ranges = new ArrayList<Range>(1);
            ranges.add(new Range(start, end, value));
            attributeMap.put(attribute, ranges);
        } //End block
        ListIterator<Range> it;
        it = ranges.listIterator();
        {
            boolean var03729FD53960D8DCA3A41A13A0229637_777404347 = (it.hasNext());
            {
                Range range;
                range = it.next();
                {
                    it.previous();
                } //End block
                {
                    boolean varEF40E1D978FA25419409FAB7F79E01F6_167751540 = (start < range.end
                    || (start == range.end && value.equals(range.value)));
                    {
                        Range r1, r3;
                        r1 = null;
                        it.remove();
                        r1 = new Range(range.start, start, range.value);
                        r3 = new Range(end, range.end, range.value);
                        {
                            boolean var1FE3E7148FB59A827E5E6E2483C887F7_722791257 = (end > range.end && it.hasNext());
                            {
                                range = it.next();
                                {
                                    {
                                        boolean var9C218184248DFD9DE95E1445E7891FFF_709677608 = (end > range.start
                                || (end == range.start && value.equals(range.value)));
                                        {
                                            it.remove();
                                            r3 = new Range(end, range.end, range.value);
                                        } //End block
                                    } //End collapsed parenthetic
                                } //End block
                                {
                                    it.remove();
                                } //End block
                            } //End block
                        } //End collapsed parenthetic
                        {
                            boolean var1027DC60E68FD42C72653BFC2EFF2C3B_1467696526 = (value.equals(r1.value));
                            {
                                {
                                    boolean var25819F3F4E6FA285B1052DA41FF64523_1543066000 = (value.equals(r3.value));
                                    {
                                        it.add(new Range(r1.start < start ? r1.start : start,
                                r3.end > end ? r3.end : end, r1.value));
                                    } //End block
                                    {
                                        it.add(new Range(r1.start < start ? r1.start : start,
                                end, r1.value));
                                        {
                                            it.add(r3);
                                        } //End block
                                    } //End block
                                } //End collapsed parenthetic
                            } //End block
                            {
                                {
                                    boolean var25819F3F4E6FA285B1052DA41FF64523_1227447887 = (value.equals(r3.value));
                                    {
                                        {
                                            it.add(r1);
                                        } //End block
                                        it.add(new Range(start, r3.end > end ? r3.end : end,
                                r3.value));
                                    } //End block
                                    {
                                        {
                                            it.add(r1);
                                        } //End block
                                        it.add(new Range(start, end, value));
                                        {
                                            it.add(r3);
                                        } //End block
                                    } //End block
                                } //End collapsed parenthetic
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        it.add(new Range(start, end, value));
        addTaint(attribute.getTaint());
        addTaint(value.getTaint());
        addTaint(start);
        addTaint(end);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:48.749 -0400", hash_original_method = "9BDF8CEEC650CFF21B203033378C7411", hash_generated_method = "FF87F79AFED653427B70CC1122AAE307")
    public void addAttributes(
            Map<? extends AttributedCharacterIterator.Attribute, ?> attributes,
            int start, int end) {
        Iterator<?> it;
        it = attributes.entrySet().iterator();
        {
            boolean var03729FD53960D8DCA3A41A13A0229637_2104630274 = (it.hasNext());
            {
                Map.Entry<?, ?> entry;
                entry = (Map.Entry<?, ?>) it.next();
                addAttribute(
                    (AttributedCharacterIterator.Attribute) entry.getKey(),
                    entry.getValue(), start, end);
            } //End block
        } //End collapsed parenthetic
        addTaint(attributes.getTaint());
        addTaint(start);
        addTaint(end);
        // ---------- Original Method ----------
        //Iterator<?> it = attributes.entrySet().iterator();
        //while (it.hasNext()) {
            //Map.Entry<?, ?> entry = (Map.Entry<?, ?>) it.next();
            //addAttribute(
                    //(AttributedCharacterIterator.Attribute) entry.getKey(),
                    //entry.getValue(), start, end);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:48.749 -0400", hash_original_method = "3C3A14639543169375B4E8491231683C", hash_generated_method = "37F89E5EA724DF1B51B5B0B3CC11DF30")
    public AttributedCharacterIterator getIterator() {
        AttributedCharacterIterator varB4EAC82CA7396A68D541C85D26508E83_776137885 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_776137885 = new AttributedIterator(this);
        varB4EAC82CA7396A68D541C85D26508E83_776137885.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_776137885;
        // ---------- Original Method ----------
        //return new AttributedIterator(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:48.754 -0400", hash_original_method = "AFA08901CAEF730E40B185484FAABB29", hash_generated_method = "19D119E8ADDA7E317B0636BCD0F294EA")
    public AttributedCharacterIterator getIterator(
            AttributedCharacterIterator.Attribute[] attributes) {
        AttributedCharacterIterator varB4EAC82CA7396A68D541C85D26508E83_329492878 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_329492878 = new AttributedIterator(this, attributes, 0, text.length());
        addTaint(attributes[0].getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_329492878.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_329492878;
        // ---------- Original Method ----------
        //return new AttributedIterator(this, attributes, 0, text.length());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:48.759 -0400", hash_original_method = "EF8FB9411A496C9D99CDE8B83C48CE6B", hash_generated_method = "C592704FFC858D8D17D9377D76CB1245")
    public AttributedCharacterIterator getIterator(
            AttributedCharacterIterator.Attribute[] attributes, int start,
            int end) {
        AttributedCharacterIterator varB4EAC82CA7396A68D541C85D26508E83_1474915035 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1474915035 = new AttributedIterator(this, attributes, start, end);
        addTaint(attributes[0].getTaint());
        addTaint(start);
        addTaint(end);
        varB4EAC82CA7396A68D541C85D26508E83_1474915035.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1474915035;
        // ---------- Original Method ----------
        //return new AttributedIterator(this, attributes, start, end);
    }

    
    static class Range {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:48.759 -0400", hash_original_field = "EA2B2676C28C0DB26D39331A336C6B92", hash_generated_field = "A420862623A673AB42FCEC90A616158F")

        int start;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:48.760 -0400", hash_original_field = "7F021A1415B86F2D013B2618FB31AE53", hash_generated_field = "302E5A3147803830441A79AED31F4022")

        int end;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:48.760 -0400", hash_original_field = "2063C1608D6E0BAF80249C42E2BE5804", hash_generated_field = "01495BEB834F5098BB0B06183674C819")

        Object value;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:48.760 -0400", hash_original_method = "9919123D3D1FFC7D42BA1CB1CAFB2DA5", hash_generated_method = "8228AF779F86680294F263E155884242")
          Range(int s, int e, Object v) {
            start = s;
            end = e;
            value = v;
            // ---------- Original Method ----------
            //start = s;
            //end = e;
            //value = v;
        }

        
    }


    
    static class AttributedIterator implements AttributedCharacterIterator {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:48.760 -0400", hash_original_field = "8D589AFA4DFAEEED85FFF5AA78E5FF6A", hash_generated_field = "D0C174A901D805EE41B6CF46156FC355")

        private int begin;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:48.760 -0400", hash_original_field = "7F021A1415B86F2D013B2618FB31AE53", hash_generated_field = "BDD622074D0B9CD7867B17F38BB0017C")

        private int end;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:48.760 -0400", hash_original_field = "7A86C157EE9713C34FBD7A1EE40F0C5A", hash_generated_field = "EA4C80BAC452228E60AC0DA2D3E0C953")

        private int offset;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:48.760 -0400", hash_original_field = "2C8BD562555E6AE4F52959440C6BA23B", hash_generated_field = "D02499DC7F8023F8CAFDC0A4B220FECC")

        private AttributedString attrString;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:48.760 -0400", hash_original_field = "FF2C1866830EA081CCEAD6E49749026E", hash_generated_field = "8E1D222DFFE5F062ACF483541B60F0D5")

        private HashSet<Attribute> attributesAllowed;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:48.765 -0400", hash_original_method = "E441422DE6FDEDB0F1BB74606A67171C", hash_generated_method = "7AE495FC46AA7C0AB1D4C3ED30DBE5AF")
          AttributedIterator(AttributedString attrString) {
            this.attrString = attrString;
            begin = 0;
            end = attrString.text.length();
            offset = 0;
            // ---------- Original Method ----------
            //this.attrString = attrString;
            //begin = 0;
            //end = attrString.text.length();
            //offset = 0;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:48.770 -0400", hash_original_method = "43841E67E512106866A3902EDBE2D718", hash_generated_method = "24CE0651A219DA0F94FA10094AB388DB")
          AttributedIterator(AttributedString attrString,
                AttributedCharacterIterator.Attribute[] attributes, int begin,
                int end) {
            {
                boolean varFFD07E130858E065814762E8E384F7BD_1475676213 = (begin < 0 || end > attrString.text.length() || begin > end);
                {
                    if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
                } //End block
            } //End collapsed parenthetic
            this.begin = begin;
            this.end = end;
            offset = begin;
            this.attrString = attrString;
            {
                HashSet<Attribute> set;
                set = new HashSet<Attribute>(
                        (attributes.length * 4 / 3) + 1);
                {
                    int i;
                    i = attributes.length;
                    {
                        set.add(attributes[i]);
                    } //End block
                } //End collapsed parenthetic
                attributesAllowed = set;
            } //End block
            addTaint(attributes[0].getTaint());
            // ---------- Original Method ----------
            //if (begin < 0 || end > attrString.text.length() || begin > end) {
                //throw new IllegalArgumentException();
            //}
            //this.begin = begin;
            //this.end = end;
            //offset = begin;
            //this.attrString = attrString;
            //if (attributes != null) {
                //HashSet<Attribute> set = new HashSet<Attribute>(
                        //(attributes.length * 4 / 3) + 1);
                //for (int i = attributes.length; --i >= 0;) {
                    //set.add(attributes[i]);
                //}
                //attributesAllowed = set;
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:48.771 -0400", hash_original_method = "CC2190075ADAC44CCBDC93141CA9BE6C", hash_generated_method = "49DE78F9F72B80384E5E1CC7F0E7B761")
        @Override
        @SuppressWarnings("unchecked")
        public Object clone() {
            Object varB4EAC82CA7396A68D541C85D26508E83_1658037366 = null; //Variable for return #1
            try 
            {
                AttributedIterator clone;
                clone = (AttributedIterator) super.clone();
                {
                    clone.attributesAllowed = (HashSet<Attribute>) attributesAllowed
                            .clone();
                } //End block
                varB4EAC82CA7396A68D541C85D26508E83_1658037366 = clone;
            } //End block
            catch (CloneNotSupportedException e)
            {
                if (DroidSafeAndroidRuntime.control) throw new AssertionError(e);
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_1658037366.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1658037366;
            // ---------- Original Method ----------
            //try {
                //AttributedIterator clone = (AttributedIterator) super.clone();
                //if (attributesAllowed != null) {
                    //clone.attributesAllowed = (HashSet<Attribute>) attributesAllowed
                            //.clone();
                //}
                //return clone;
            //} catch (CloneNotSupportedException e) {
                //throw new AssertionError(e);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:48.775 -0400", hash_original_method = "81A9D498AF1F73C3D962F8C3EDD6D3D9", hash_generated_method = "E2921F1AC13BF2400C1ADEA43E909CF3")
        public char current() {
            char var7471FC70B539530D7206B8BC1B31F802_1425128475 = (attrString.text.charAt(offset));
            char varA87DEB01C5F539E6BDA34829C8EF2368_745037932 = getTaintChar();
            return varA87DEB01C5F539E6BDA34829C8EF2368_745037932;
            // ---------- Original Method ----------
            //if (offset == end) {
                //return DONE;
            //}
            //return attrString.text.charAt(offset);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:48.776 -0400", hash_original_method = "4AF9D055D17E58470820B415A8EBAFA4", hash_generated_method = "508B44D0D3D0C83B9641FD73D0F8EE07")
        public char first() {
            offset = begin;
            char var7471FC70B539530D7206B8BC1B31F802_1153821299 = (attrString.text.charAt(offset));
            char varA87DEB01C5F539E6BDA34829C8EF2368_1290092121 = getTaintChar();
            return varA87DEB01C5F539E6BDA34829C8EF2368_1290092121;
            // ---------- Original Method ----------
            //if (begin == end) {
                //return DONE;
            //}
            //offset = begin;
            //return attrString.text.charAt(offset);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:48.776 -0400", hash_original_method = "1D4D2C19F23B97FE6ECF3D3284916FD4", hash_generated_method = "761DD16B8A75983B86712E4900A0812D")
        public int getBeginIndex() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1408752232 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1408752232;
            // ---------- Original Method ----------
            //return begin;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:48.776 -0400", hash_original_method = "2693C2AA223CB37D0504CD257C6327BC", hash_generated_method = "106FC305376CC16C369806372E339BD4")
        public int getEndIndex() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1404872018 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1404872018;
            // ---------- Original Method ----------
            //return end;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:48.776 -0400", hash_original_method = "0952456464DB8DF9DBB7507E3C2ED53C", hash_generated_method = "7CF5C2D35067B2D4D2ADB3AEF0350BFF")
        public int getIndex() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1916646463 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1916646463;
            // ---------- Original Method ----------
            //return offset;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:48.781 -0400", hash_original_method = "20101C80E99D94E4CD68776989F0B447", hash_generated_method = "2C4D9655DA6EC289318E70F21D43ED96")
        private boolean inRange(Range range) {
            addTaint(range.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1156784750 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1156784750;
            // ---------- Original Method ----------
            //if (!(range.value instanceof Annotation)) {
                //return true;
            //}
            //return range.start >= begin && range.start < end
                    //&& range.end > begin && range.end <= end;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:48.782 -0400", hash_original_method = "D282867E9466B5652FFBD5F7BCA71B9B", hash_generated_method = "F3872FC907BB62EC89C9E8C661D4BDC2")
        private boolean inRange(List<Range> ranges) {
            Iterator<Range> it;
            it = ranges.iterator();
            {
                boolean varB2FF4435B274CC4BE01D264DEA08F957_1359706442 = (it.hasNext());
                {
                    Range range;
                    range = it.next();
                } //End block
            } //End collapsed parenthetic
            addTaint(ranges.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1127395777 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1127395777;
            // ---------- Original Method ----------
            //Iterator<Range> it = ranges.iterator();
            //while (it.hasNext()) {
                //Range range = it.next();
                //if (range.start >= begin && range.start < end) {
                    //return !(range.value instanceof Annotation)
                            //|| (range.end > begin && range.end <= end);
                //} else if (range.end > begin && range.end <= end) {
                    //return !(range.value instanceof Annotation)
                            //|| (range.start >= begin && range.start < end);
                //}
            //}
            //return false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:48.787 -0400", hash_original_method = "1F90FC3406D3E88B418E6F5A05B249D4", hash_generated_method = "F63C24E1562B3463B6F3ADB932797011")
        public Set<AttributedIterator.Attribute> getAllAttributeKeys() {
            Set<AttributedIterator.Attribute> varB4EAC82CA7396A68D541C85D26508E83_1746604143 = null; //Variable for return #1
            Set<AttributedIterator.Attribute> varB4EAC82CA7396A68D541C85D26508E83_1380545654 = null; //Variable for return #2
            {
                boolean var440E9841255491133E314328640A0B67_635391185 = (begin == 0 && end == attrString.text.length()
                    && attributesAllowed == null);
                {
                    varB4EAC82CA7396A68D541C85D26508E83_1746604143 = attrString.attributeMap.keySet();
                } //End block
            } //End collapsed parenthetic
            Set<AttributedIterator.Attribute> result;
            result = new HashSet<Attribute>(
                    (attrString.attributeMap.size() * 4 / 3) + 1);
            Iterator<Map.Entry<Attribute, List<Range>>> it;
            it = attrString.attributeMap
                    .entrySet().iterator();
            {
                boolean varB2FF4435B274CC4BE01D264DEA08F957_1824352104 = (it.hasNext());
                {
                    Map.Entry<Attribute, List<Range>> entry;
                    entry = it.next();
                    {
                        boolean var78A623E4F0CCA03B879F36D854BE57FF_410745173 = (attributesAllowed == null
                        || attributesAllowed.contains(entry.getKey()));
                        {
                            List<Range> ranges;
                            ranges = entry.getValue();
                            {
                                boolean var48BA0119E6136D30C1769489A0BAEB46_1475767012 = (inRange(ranges));
                                {
                                    result.add(entry.getKey());
                                } //End block
                            } //End collapsed parenthetic
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
            varB4EAC82CA7396A68D541C85D26508E83_1380545654 = result;
            Set<AttributedIterator.Attribute> varA7E53CE21691AB073D9660D615818899_1145358633; //Final return value
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: //Assign result for return ordinal #1
                    varA7E53CE21691AB073D9660D615818899_1145358633 = varB4EAC82CA7396A68D541C85D26508E83_1746604143;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_1145358633 = varB4EAC82CA7396A68D541C85D26508E83_1380545654;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_1145358633.addTaint(getTaint()); //Add taint from parent
            return varA7E53CE21691AB073D9660D615818899_1145358633;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:48.788 -0400", hash_original_method = "7F47FD199B74CEDC765420E2B0AD1B85", hash_generated_method = "654BDD7BE1D6E4F8D1EB874A1509A9C7")
        private Object currentValue(List<Range> ranges) {
            Object varB4EAC82CA7396A68D541C85D26508E83_1362689854 = null; //Variable for return #1
            Object varB4EAC82CA7396A68D541C85D26508E83_1390428759 = null; //Variable for return #2
            Iterator<Range> it;
            it = ranges.iterator();
            {
                boolean varB2FF4435B274CC4BE01D264DEA08F957_1767117276 = (it.hasNext());
                {
                    Range range;
                    range = it.next();
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_1362689854 = inRange(range) ? range.value : null;
                    } //End block
                } //End block
            } //End collapsed parenthetic
            varB4EAC82CA7396A68D541C85D26508E83_1390428759 = null;
            addTaint(ranges.getTaint());
            Object varA7E53CE21691AB073D9660D615818899_1389660758; //Final return value
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: //Assign result for return ordinal #1
                    varA7E53CE21691AB073D9660D615818899_1389660758 = varB4EAC82CA7396A68D541C85D26508E83_1362689854;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_1389660758 = varB4EAC82CA7396A68D541C85D26508E83_1390428759;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_1389660758.addTaint(getTaint()); //Add taint from parent
            return varA7E53CE21691AB073D9660D615818899_1389660758;
            // ---------- Original Method ----------
            //Iterator<Range> it = ranges.iterator();
            //while (it.hasNext()) {
                //Range range = it.next();
                //if (offset >= range.start && offset < range.end) {
                    //return inRange(range) ? range.value : null;
                //}
            //}
            //return null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:48.788 -0400", hash_original_method = "9256DFDAE9CB8C43C18A44C8B3AC6DAC", hash_generated_method = "282FEC934A440E8C52B558CDF8C0F671")
        public Object getAttribute(
                AttributedCharacterIterator.Attribute attribute) {
            Object varB4EAC82CA7396A68D541C85D26508E83_1975368070 = null; //Variable for return #1
            Object varB4EAC82CA7396A68D541C85D26508E83_584869941 = null; //Variable for return #2
            Object varB4EAC82CA7396A68D541C85D26508E83_1096329609 = null; //Variable for return #3
            {
                boolean var12D36913C4CC9B92E6CFDE0A26E3CD6F_1393162877 = (attributesAllowed != null
                    && !attributesAllowed.contains(attribute));
                {
                    varB4EAC82CA7396A68D541C85D26508E83_1975368070 = null;
                } //End block
            } //End collapsed parenthetic
            ArrayList<Range> ranges;
            ranges = (ArrayList<Range>) attrString.attributeMap
                    .get(attribute);
            {
                varB4EAC82CA7396A68D541C85D26508E83_584869941 = null;
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_1096329609 = currentValue(ranges);
            addTaint(attribute.getTaint());
            Object varA7E53CE21691AB073D9660D615818899_1052163559; //Final return value
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: //Assign result for return ordinal #1
                    varA7E53CE21691AB073D9660D615818899_1052163559 = varB4EAC82CA7396A68D541C85D26508E83_1975368070;
                    break;
                case 2: //Assign result for return ordinal #2
                    varA7E53CE21691AB073D9660D615818899_1052163559 = varB4EAC82CA7396A68D541C85D26508E83_584869941;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_1052163559 = varB4EAC82CA7396A68D541C85D26508E83_1096329609;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_1052163559.addTaint(getTaint()); //Add taint from parent
            return varA7E53CE21691AB073D9660D615818899_1052163559;
            // ---------- Original Method ----------
            //if (attributesAllowed != null
                    //&& !attributesAllowed.contains(attribute)) {
                //return null;
            //}
            //ArrayList<Range> ranges = (ArrayList<Range>) attrString.attributeMap
                    //.get(attribute);
            //if (ranges == null) {
                //return null;
            //}
            //return currentValue(ranges);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:48.791 -0400", hash_original_method = "AAAFE2E009783E25A93A8B590538D893", hash_generated_method = "FAFFE303870C52E835DD551AB8139F4F")
        public Map<Attribute, Object> getAttributes() {
            Map<Attribute, Object> varB4EAC82CA7396A68D541C85D26508E83_404321859 = null; //Variable for return #1
            Map<Attribute, Object> result;
            result = new HashMap<Attribute, Object>(
                    (attrString.attributeMap.size() * 4 / 3) + 1);
            Iterator<Map.Entry<Attribute, List<Range>>> it;
            it = attrString.attributeMap
                    .entrySet().iterator();
            {
                boolean varB2FF4435B274CC4BE01D264DEA08F957_1464187757 = (it.hasNext());
                {
                    Map.Entry<Attribute, List<Range>> entry;
                    entry = it.next();
                    {
                        boolean var78A623E4F0CCA03B879F36D854BE57FF_299636300 = (attributesAllowed == null
                        || attributesAllowed.contains(entry.getKey()));
                        {
                            Object value;
                            value = currentValue(entry.getValue());
                            {
                                result.put(entry.getKey(), value);
                            } //End block
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
            varB4EAC82CA7396A68D541C85D26508E83_404321859 = result;
            varB4EAC82CA7396A68D541C85D26508E83_404321859.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_404321859;
            // ---------- Original Method ----------
            //Map<Attribute, Object> result = new HashMap<Attribute, Object>(
                    //(attrString.attributeMap.size() * 4 / 3) + 1);
            //Iterator<Map.Entry<Attribute, List<Range>>> it = attrString.attributeMap
                    //.entrySet().iterator();
            //while (it.hasNext()) {
                //Map.Entry<Attribute, List<Range>> entry = it.next();
                //if (attributesAllowed == null
                        //|| attributesAllowed.contains(entry.getKey())) {
                    //Object value = currentValue(entry.getValue());
                    //if (value != null) {
                        //result.put(entry.getKey(), value);
                    //}
                //}
            //}
            //return result;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:48.791 -0400", hash_original_method = "B67CDF67136100A9ADF2991D47BD9A14", hash_generated_method = "5EBDF37405F141B05500A3EF1E094CF7")
        public int getRunLimit() {
            int varB8CB18E7DB26C804CE1E291715EC4085_849709644 = (getRunLimit(getAllAttributeKeys()));
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1989118150 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1989118150;
            // ---------- Original Method ----------
            //return getRunLimit(getAllAttributeKeys());
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:48.792 -0400", hash_original_method = "40F484258D42E498FCA29FFC5F596001", hash_generated_method = "801CF5808FBC6EC2AF99D3A4AB41F26F")
        private int runLimit(List<Range> ranges) {
            int result;
            result = end;
            ListIterator<Range> it;
            it = ranges.listIterator(ranges.size());
            {
                boolean varFF94A24275993577BF8E66186EAD8E8C_177454857 = (it.hasPrevious());
                {
                    Range range;
                    range = it.previous();
                    {
                        {
                            boolean var2FAF37F82B41CCA38F243EDFFC0955AC_1277016888 = (inRange(range));
                        } //End flattened ternary
                    } //End block
                    result = range.start;
                } //End block
            } //End collapsed parenthetic
            addTaint(ranges.getTaint());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_146778212 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_146778212;
            // ---------- Original Method ----------
            //int result = end;
            //ListIterator<Range> it = ranges.listIterator(ranges.size());
            //while (it.hasPrevious()) {
                //Range range = it.previous();
                //if (range.end <= begin) {
                    //break;
                //}
                //if (offset >= range.start && offset < range.end) {
                    //return inRange(range) ? range.end : result;
                //} else if (offset >= range.end) {
                    //break;
                //}
                //result = range.start;
            //}
            //return result;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:48.792 -0400", hash_original_method = "F819F4AC98ED7B00F15856104CEA6D7F", hash_generated_method = "F2B1D34D5A4EE58EBE46F5D3FA2416D6")
        public int getRunLimit(AttributedCharacterIterator.Attribute attribute) {
            {
                boolean var12D36913C4CC9B92E6CFDE0A26E3CD6F_710443958 = (attributesAllowed != null
                    && !attributesAllowed.contains(attribute));
            } //End collapsed parenthetic
            ArrayList<Range> ranges;
            ranges = (ArrayList<Range>) attrString.attributeMap
                    .get(attribute);
            int var3243E9C702621CDA5FC8AD3026FC7D28_1841757065 = (runLimit(ranges));
            addTaint(attribute.getTaint());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_316242160 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_316242160;
            // ---------- Original Method ----------
            //if (attributesAllowed != null
                    //&& !attributesAllowed.contains(attribute)) {
                //return end;
            //}
            //ArrayList<Range> ranges = (ArrayList<Range>) attrString.attributeMap
                    //.get(attribute);
            //if (ranges == null) {
                //return end;
            //}
            //return runLimit(ranges);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:48.792 -0400", hash_original_method = "39CD1571C1B0AAE61A932D3B1E130DFE", hash_generated_method = "8901C33B638683BD64F6C140C5A321DA")
        public int getRunLimit(Set<? extends Attribute> attributes) {
            int limit;
            limit = end;
            Iterator<? extends Attribute> it;
            it = attributes.iterator();
            {
                boolean varB2FF4435B274CC4BE01D264DEA08F957_492672323 = (it.hasNext());
                {
                    AttributedCharacterIterator.Attribute attribute;
                    attribute = it.next();
                    int newLimit;
                    newLimit = getRunLimit(attribute);
                    {
                        limit = newLimit;
                    } //End block
                } //End block
            } //End collapsed parenthetic
            addTaint(attributes.getTaint());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1287918493 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1287918493;
            // ---------- Original Method ----------
            //int limit = end;
            //Iterator<? extends Attribute> it = attributes.iterator();
            //while (it.hasNext()) {
                //AttributedCharacterIterator.Attribute attribute = it.next();
                //int newLimit = getRunLimit(attribute);
                //if (newLimit < limit) {
                    //limit = newLimit;
                //}
            //}
            //return limit;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:48.809 -0400", hash_original_method = "FE3F08CD8D40BCC02EAAB9CF9D349F73", hash_generated_method = "F3A95F853E909007F96A0ED4B7872D63")
        public int getRunStart() {
            int varD479F53F5B086C7131ABCE733DD47303_2108930825 = (getRunStart(getAllAttributeKeys()));
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1472727743 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1472727743;
            // ---------- Original Method ----------
            //return getRunStart(getAllAttributeKeys());
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:48.810 -0400", hash_original_method = "3940F742081E74CA234FF11DA5FD3120", hash_generated_method = "99C0FA43AA6F3AAAB4E179FA8BF19D9E")
        private int runStart(List<Range> ranges) {
            int result;
            result = begin;
            Iterator<Range> it;
            it = ranges.iterator();
            {
                boolean varB2FF4435B274CC4BE01D264DEA08F957_1233033776 = (it.hasNext());
                {
                    Range range;
                    range = it.next();
                    {
                        {
                            boolean var2FAF37F82B41CCA38F243EDFFC0955AC_168567099 = (inRange(range));
                        } //End flattened ternary
                    } //End block
                    result = range.end;
                } //End block
            } //End collapsed parenthetic
            addTaint(ranges.getTaint());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_833030774 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_833030774;
            // ---------- Original Method ----------
            //int result = begin;
            //Iterator<Range> it = ranges.iterator();
            //while (it.hasNext()) {
                //Range range = it.next();
                //if (range.start >= end) {
                    //break;
                //}
                //if (offset >= range.start && offset < range.end) {
                    //return inRange(range) ? range.start : result;
                //} else if (offset < range.start) {
                    //break;
                //}
                //result = range.end;
            //}
            //return result;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:48.811 -0400", hash_original_method = "D8F9F8B7D0C4F74D05FEF10E27E7F588", hash_generated_method = "9ECF1336F22D37314FB7943BB2BEF924")
        public int getRunStart(AttributedCharacterIterator.Attribute attribute) {
            {
                boolean var12D36913C4CC9B92E6CFDE0A26E3CD6F_793023748 = (attributesAllowed != null
                    && !attributesAllowed.contains(attribute));
            } //End collapsed parenthetic
            ArrayList<Range> ranges;
            ranges = (ArrayList<Range>) attrString.attributeMap
                    .get(attribute);
            int varF7B3B9AA84E9A9D092AE2BE6817D6B1C_1157156195 = (runStart(ranges));
            addTaint(attribute.getTaint());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1379509382 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1379509382;
            // ---------- Original Method ----------
            //if (attributesAllowed != null
                    //&& !attributesAllowed.contains(attribute)) {
                //return begin;
            //}
            //ArrayList<Range> ranges = (ArrayList<Range>) attrString.attributeMap
                    //.get(attribute);
            //if (ranges == null) {
                //return begin;
            //}
            //return runStart(ranges);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:48.814 -0400", hash_original_method = "62E2E3A1AAFB276945B722FDB547D45B", hash_generated_method = "35227C32B7060BFC203485A3CBC4FFA0")
        public int getRunStart(Set<? extends Attribute> attributes) {
            int start;
            start = begin;
            Iterator<? extends Attribute> it;
            it = attributes.iterator();
            {
                boolean varB2FF4435B274CC4BE01D264DEA08F957_1931933369 = (it.hasNext());
                {
                    AttributedCharacterIterator.Attribute attribute;
                    attribute = it.next();
                    int newStart;
                    newStart = getRunStart(attribute);
                    {
                        start = newStart;
                    } //End block
                } //End block
            } //End collapsed parenthetic
            addTaint(attributes.getTaint());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1854071917 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1854071917;
            // ---------- Original Method ----------
            //int start = begin;
            //Iterator<? extends Attribute> it = attributes.iterator();
            //while (it.hasNext()) {
                //AttributedCharacterIterator.Attribute attribute = it.next();
                //int newStart = getRunStart(attribute);
                //if (newStart > start) {
                    //start = newStart;
                //}
            //}
            //return start;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:48.815 -0400", hash_original_method = "6CAD62DAB178D2919A2036BE42DEC497", hash_generated_method = "8E87CEF31BA720F248F4FEEDE7B3E4F7")
        public char last() {
            offset = end - 1;
            char var7471FC70B539530D7206B8BC1B31F802_673677620 = (attrString.text.charAt(offset));
            char varA87DEB01C5F539E6BDA34829C8EF2368_2076154166 = getTaintChar();
            return varA87DEB01C5F539E6BDA34829C8EF2368_2076154166;
            // ---------- Original Method ----------
            //if (begin == end) {
                //return DONE;
            //}
            //offset = end - 1;
            //return attrString.text.charAt(offset);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:48.816 -0400", hash_original_method = "B623F272BE854A8CF15368B2FE2B8A97", hash_generated_method = "72A5DFD41D6393CFB40B843BEA34BC09")
        public char next() {
            {
                offset = end;
            } //End block
            char varCD2A465A117ACDFD77E8F731FFBCF3CF_457619305 = (attrString.text.charAt(++offset));
            char varA87DEB01C5F539E6BDA34829C8EF2368_473373187 = getTaintChar();
            return varA87DEB01C5F539E6BDA34829C8EF2368_473373187;
            // ---------- Original Method ----------
            //if (offset >= (end - 1)) {
                //offset = end;
                //return DONE;
            //}
            //return attrString.text.charAt(++offset);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:48.816 -0400", hash_original_method = "E77E60DF0F891730B03F44D98923AB66", hash_generated_method = "FC2F47D0C56B824048C1C6BE62980DBE")
        public char previous() {
            char var2ECEAF615C1A7B98A9B5DA51518FE2D8_1278119217 = (attrString.text.charAt(--offset));
            char varA87DEB01C5F539E6BDA34829C8EF2368_279745498 = getTaintChar();
            return varA87DEB01C5F539E6BDA34829C8EF2368_279745498;
            // ---------- Original Method ----------
            //if (offset == begin) {
                //return DONE;
            //}
            //return attrString.text.charAt(--offset);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:48.817 -0400", hash_original_method = "C542CEFF91217DDB3083AD983C51F194", hash_generated_method = "7B60FD4B3E50B9FB10EDAAFA0104F471")
        public char setIndex(int location) {
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
            } //End block
            offset = location;
            char var7471FC70B539530D7206B8BC1B31F802_109405843 = (attrString.text.charAt(offset));
            char varA87DEB01C5F539E6BDA34829C8EF2368_1010228417 = getTaintChar();
            return varA87DEB01C5F539E6BDA34829C8EF2368_1010228417;
            // ---------- Original Method ----------
            //if (location < begin || location > end) {
                //throw new IllegalArgumentException();
            //}
            //offset = location;
            //if (offset == end) {
                //return DONE;
            //}
            //return attrString.text.charAt(offset);
        }

        
    }


    
}

