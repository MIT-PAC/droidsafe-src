package java.text;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.479 -0400", hash_original_field = "1CB251EC0D568DE6A929B520C4AED8D1", hash_generated_field = "9EF4B8A5DE4B8BD37EE465C3BB62CC6C")

    String text;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.479 -0400", hash_original_field = "EC5B70424D6106D0D37EACD23354A330", hash_generated_field = "EA3CF0028C57B0F0FB6C371B620465D1")

    Map<AttributedCharacterIterator.Attribute, List<Range>> attributeMap;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.480 -0400", hash_original_method = "5638BBE38DFF9B04A672F4EC9A02409B", hash_generated_method = "2FCE4E1539063FFB76FF3BB77C735D7E")
    public  AttributedString(AttributedCharacterIterator iterator) {
        {
            boolean var5791DB9351E60242F3260BB947788691_1337134354 = (iterator.getBeginIndex() > iterator.getEndIndex());
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Invalid substring range");
            } 
        } 
        StringBuilder buffer = new StringBuilder();
        {
            int i = iterator.getBeginIndex();
            boolean varD47BAE727A1CA5D8FBD74E81EBBAC580_1468145018 = (i < iterator.getEndIndex());
            {
                buffer.append(iterator.current());
                iterator.next();
            } 
        } 
        text = buffer.toString();
        Set<AttributedCharacterIterator.Attribute> attributes = iterator
                .getAllAttributeKeys();
        attributeMap = new HashMap<Attribute, List<Range>>(
                (attributes.size() * 4 / 3) + 1);
        Iterator<Attribute> it = attributes.iterator();
        {
            boolean var03729FD53960D8DCA3A41A13A0229637_252263329 = (it.hasNext());
            {
                AttributedCharacterIterator.Attribute attribute = it.next();
                iterator.setIndex(0);
                {
                    boolean var28ACB1F338988605D7BB159EDA96A571_2004195143 = (iterator.current() != CharacterIterator.DONE);
                    {
                        int start = iterator.getRunStart(attribute);
                        int limit = iterator.getRunLimit(attribute);
                        Object value = iterator.getAttribute(attribute);
                        {
                            addAttribute(attribute, value, start, limit);
                        } 
                        iterator.setIndex(limit);
                    } 
                } 
            } 
        } 
        addTaint(iterator.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.484 -0400", hash_original_method = "3A8973AD4EBE1F3B94E1633368C42F9D", hash_generated_method = "6087D841973B20C35EC120FC6E52AE13")
    private  AttributedString(AttributedCharacterIterator iterator, int start,
            int end, Set<Attribute> attributes) {
        {
            boolean var6E1EE5C4631EC62ECEF890E2A840FF67_1757793331 = (start < iterator.getBeginIndex() || end > iterator.getEndIndex()
                || start > end);
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
            } 
        } 
        StringBuilder buffer = new StringBuilder();
        iterator.setIndex(start);
        {
            boolean varFB2E1080C5571E90BCE1803511FF22B4_26445726 = (iterator.getIndex() < end);
            {
                buffer.append(iterator.current());
                iterator.next();
            } 
        } 
        text = buffer.toString();
        attributeMap = new HashMap<Attribute, List<Range>>(
                (attributes.size() * 4 / 3) + 1);
        Iterator<Attribute> it = attributes.iterator();
        {
            boolean var03729FD53960D8DCA3A41A13A0229637_709550311 = (it.hasNext());
            {
                AttributedCharacterIterator.Attribute attribute = it.next();
                iterator.setIndex(start);
                {
                    boolean var01C467E388CE293308E11B7796E75DEA_514318548 = (iterator.getIndex() < end);
                    {
                        Object value = iterator.getAttribute(attribute);
                        int runStart = iterator.getRunStart(attribute);
                        int limit = iterator.getRunLimit(attribute);
                        {
                            addAttribute(attribute, value, (runStart < start ? start
                            : runStart)
                            - start, (limit > end ? end : limit) - start);
                        } 
                        iterator.setIndex(limit);
                    } 
                } 
            } 
        } 
        addTaint(iterator.getTaint());
        addTaint(start);
        addTaint(end);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.484 -0400", hash_original_method = "D0E1FC5545253EA6E008AE3675A9452F", hash_generated_method = "DD2B752A6779C8498BD80371C09AFEDD")
    public  AttributedString(AttributedCharacterIterator iterator, int start,
            int end) {
        this(iterator, start, end, iterator.getAllAttributeKeys());
        addTaint(iterator.getTaint());
        addTaint(start);
        addTaint(end);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.485 -0400", hash_original_method = "B4766721E168BC843A6EA06CFE59500E", hash_generated_method = "EC90DC0B7D0EA910D176297DA1AB5C63")
    public  AttributedString(AttributedCharacterIterator iterator, int start,
            int end, AttributedCharacterIterator.Attribute[] attributes) {
        this(iterator, start, end, (attributes == null
                ? new HashSet<Attribute>()
                : new HashSet<Attribute>(Arrays.asList(attributes))));
        addTaint(iterator.getTaint());
        addTaint(start);
        addTaint(end);
        addTaint(attributes[0].getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.485 -0400", hash_original_method = "A0ACF5D97B9D79B3295575A771939692", hash_generated_method = "88A4D20F83833C26A87FB62D6E7C80E3")
    public  AttributedString(String value) {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } 
        text = value;
        attributeMap = new HashMap<Attribute, List<Range>>(11);
        
        
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.486 -0400", hash_original_method = "85CF866984BA31F6F3E97322323F86BA", hash_generated_method = "EE18E357FE416E3F6EF3155100FC3D2C")
    public  AttributedString(String value,
            Map<? extends AttributedCharacterIterator.Attribute, ?> attributes) {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } 
        {
            boolean varF38D1CF4F9C3BE6C8047C579649A2A1F_1898682126 = (value.length() == 0 && !attributes.isEmpty());
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Cannot add attributes to empty string");
            } 
        } 
        text = value;
        attributeMap = new HashMap<Attribute, List<Range>>(
                (attributes.size() * 4 / 3) + 1);
        Iterator<?> it = attributes.entrySet().iterator();
        {
            boolean var03729FD53960D8DCA3A41A13A0229637_143878646 = (it.hasNext());
            {
                Map.Entry<?, ?> entry = (Map.Entry<?, ?>) it.next();
                ArrayList<Range> ranges = new ArrayList<Range>(1);
                ranges.add(new Range(0, text.length(), entry.getValue()));
                attributeMap.put((AttributedCharacterIterator.Attribute) entry
                    .getKey(), ranges);
            } 
        } 
        
        
            
        
        
            
        
        
        
                
        
        
            
            
            
            
                    
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.486 -0400", hash_original_method = "F800EB2F1E580436E49CB51D04E3F37C", hash_generated_method = "F1A489CF12FDC4CFCC822F1F1E4B8964")
    public void addAttribute(AttributedCharacterIterator.Attribute attribute, Object value) {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } 
        {
            boolean var2E3F580615CDCAA5961A2E6CF25EC4EB_589749624 = (text.length() == 0);
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
            } 
        } 
        List<Range> ranges = attributeMap.get(attribute);
        {
            ranges = new ArrayList<Range>(1);
            attributeMap.put(attribute, ranges);
        } 
        {
            ranges.clear();
        } 
        ranges.add(new Range(0, text.length(), value));
        addTaint(attribute.getTaint());
        addTaint(value.getTaint());
        
        
            
        
        
            
        
        
        
            
            
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.487 -0400", hash_original_method = "1EA9CE9DE6197B4051F39E120F823C8E", hash_generated_method = "77847F8EEAD668347D1BF0240112EEE5")
    public void addAttribute(AttributedCharacterIterator.Attribute attribute,
            Object value, int start, int end) {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } 
        {
            boolean varC9BCC04F7A62407C3BA13DEEA6DE5168_2056846647 = (start < 0 || end > text.length() || start >= end);
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
            } 
        } 
        List<Range> ranges = attributeMap.get(attribute);
        {
            ranges = new ArrayList<Range>(1);
            ranges.add(new Range(start, end, value));
            attributeMap.put(attribute, ranges);
        } 
        ListIterator<Range> it = ranges.listIterator();
        {
            boolean var03729FD53960D8DCA3A41A13A0229637_1946113122 = (it.hasNext());
            {
                Range range = it.next();
                {
                    it.previous();
                } 
                {
                    boolean varEF40E1D978FA25419409FAB7F79E01F6_1339828684 = (start < range.end
                    || (start == range.end && value.equals(range.value)));
                    {
                        Range r1 = null;
                        Range r3;
                        it.remove();
                        r1 = new Range(range.start, start, range.value);
                        r3 = new Range(end, range.end, range.value);
                        {
                            boolean var1FE3E7148FB59A827E5E6E2483C887F7_1156607822 = (end > range.end && it.hasNext());
                            {
                                range = it.next();
                                {
                                    {
                                        boolean var9C218184248DFD9DE95E1445E7891FFF_1530093426 = (end > range.start
                                || (end == range.start && value.equals(range.value)));
                                        {
                                            it.remove();
                                            r3 = new Range(end, range.end, range.value);
                                        } 
                                    } 
                                } 
                                {
                                    it.remove();
                                } 
                            } 
                        } 
                        {
                            boolean var1027DC60E68FD42C72653BFC2EFF2C3B_726217082 = (value.equals(r1.value));
                            {
                                {
                                    boolean var25819F3F4E6FA285B1052DA41FF64523_1569578545 = (value.equals(r3.value));
                                    {
                                        it.add(new Range(r1.start < start ? r1.start : start,
                                r3.end > end ? r3.end : end, r1.value));
                                    } 
                                    {
                                        it.add(new Range(r1.start < start ? r1.start : start,
                                end, r1.value));
                                        {
                                            it.add(r3);
                                        } 
                                    } 
                                } 
                            } 
                            {
                                {
                                    boolean var25819F3F4E6FA285B1052DA41FF64523_924073071 = (value.equals(r3.value));
                                    {
                                        {
                                            it.add(r1);
                                        } 
                                        it.add(new Range(start, r3.end > end ? r3.end : end,
                                r3.value));
                                    } 
                                    {
                                        {
                                            it.add(r1);
                                        } 
                                        it.add(new Range(start, end, value));
                                        {
                                            it.add(r3);
                                        } 
                                    } 
                                } 
                            } 
                        } 
                    } 
                } 
            } 
        } 
        it.add(new Range(start, end, value));
        addTaint(attribute.getTaint());
        addTaint(value.getTaint());
        addTaint(start);
        addTaint(end);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.488 -0400", hash_original_method = "9BDF8CEEC650CFF21B203033378C7411", hash_generated_method = "F73ECF1D5C742471B040703809F9F1A1")
    public void addAttributes(
            Map<? extends AttributedCharacterIterator.Attribute, ?> attributes,
            int start, int end) {
        Iterator<?> it = attributes.entrySet().iterator();
        {
            boolean var03729FD53960D8DCA3A41A13A0229637_1929248432 = (it.hasNext());
            {
                Map.Entry<?, ?> entry = (Map.Entry<?, ?>) it.next();
                addAttribute(
                    (AttributedCharacterIterator.Attribute) entry.getKey(),
                    entry.getValue(), start, end);
            } 
        } 
        addTaint(attributes.getTaint());
        addTaint(start);
        addTaint(end);
        
        
        
            
            
                    
                    
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.488 -0400", hash_original_method = "3C3A14639543169375B4E8491231683C", hash_generated_method = "269F69BA4ED110AC2CCB05DD7775BD1B")
    public AttributedCharacterIterator getIterator() {
        AttributedCharacterIterator varB4EAC82CA7396A68D541C85D26508E83_1381105378 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1381105378 = new AttributedIterator(this);
        varB4EAC82CA7396A68D541C85D26508E83_1381105378.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1381105378;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.489 -0400", hash_original_method = "AFA08901CAEF730E40B185484FAABB29", hash_generated_method = "AD8E714D65ED591CCA2DA5964B4BC82E")
    public AttributedCharacterIterator getIterator(
            AttributedCharacterIterator.Attribute[] attributes) {
        AttributedCharacterIterator varB4EAC82CA7396A68D541C85D26508E83_2013311768 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_2013311768 = new AttributedIterator(this, attributes, 0, text.length());
        addTaint(attributes[0].getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_2013311768.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2013311768;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.489 -0400", hash_original_method = "EF8FB9411A496C9D99CDE8B83C48CE6B", hash_generated_method = "56E350D6B2BC64B198BBEA9CFF4CA655")
    public AttributedCharacterIterator getIterator(
            AttributedCharacterIterator.Attribute[] attributes, int start,
            int end) {
        AttributedCharacterIterator varB4EAC82CA7396A68D541C85D26508E83_887694744 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_887694744 = new AttributedIterator(this, attributes, start, end);
        addTaint(attributes[0].getTaint());
        addTaint(start);
        addTaint(end);
        varB4EAC82CA7396A68D541C85D26508E83_887694744.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_887694744;
        
        
    }

    
    static class Range {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.489 -0400", hash_original_field = "EA2B2676C28C0DB26D39331A336C6B92", hash_generated_field = "A420862623A673AB42FCEC90A616158F")

        int start;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.489 -0400", hash_original_field = "7F021A1415B86F2D013B2618FB31AE53", hash_generated_field = "302E5A3147803830441A79AED31F4022")

        int end;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.489 -0400", hash_original_field = "2063C1608D6E0BAF80249C42E2BE5804", hash_generated_field = "01495BEB834F5098BB0B06183674C819")

        Object value;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.489 -0400", hash_original_method = "9919123D3D1FFC7D42BA1CB1CAFB2DA5", hash_generated_method = "8228AF779F86680294F263E155884242")
          Range(int s, int e, Object v) {
            start = s;
            end = e;
            value = v;
            
            
            
            
        }

        
    }


    
    static class AttributedIterator implements AttributedCharacterIterator {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.490 -0400", hash_original_field = "8D589AFA4DFAEEED85FFF5AA78E5FF6A", hash_generated_field = "D0C174A901D805EE41B6CF46156FC355")

        private int begin;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.490 -0400", hash_original_field = "7F021A1415B86F2D013B2618FB31AE53", hash_generated_field = "BDD622074D0B9CD7867B17F38BB0017C")

        private int end;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.490 -0400", hash_original_field = "7A86C157EE9713C34FBD7A1EE40F0C5A", hash_generated_field = "EA4C80BAC452228E60AC0DA2D3E0C953")

        private int offset;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.490 -0400", hash_original_field = "2C8BD562555E6AE4F52959440C6BA23B", hash_generated_field = "D02499DC7F8023F8CAFDC0A4B220FECC")

        private AttributedString attrString;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.490 -0400", hash_original_field = "FF2C1866830EA081CCEAD6E49749026E", hash_generated_field = "8E1D222DFFE5F062ACF483541B60F0D5")

        private HashSet<Attribute> attributesAllowed;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.490 -0400", hash_original_method = "E441422DE6FDEDB0F1BB74606A67171C", hash_generated_method = "7AE495FC46AA7C0AB1D4C3ED30DBE5AF")
          AttributedIterator(AttributedString attrString) {
            this.attrString = attrString;
            begin = 0;
            end = attrString.text.length();
            offset = 0;
            
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.491 -0400", hash_original_method = "43841E67E512106866A3902EDBE2D718", hash_generated_method = "847A1C03C0FAEA503477C51784112E0D")
          AttributedIterator(AttributedString attrString,
                AttributedCharacterIterator.Attribute[] attributes, int begin,
                int end) {
            {
                boolean varFFD07E130858E065814762E8E384F7BD_193717468 = (begin < 0 || end > attrString.text.length() || begin > end);
                {
                    if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
                } 
            } 
            this.begin = begin;
            this.end = end;
            offset = begin;
            this.attrString = attrString;
            {
                HashSet<Attribute> set = new HashSet<Attribute>(
                        (attributes.length * 4 / 3) + 1);
                {
                    int i = attributes.length;
                    {
                        set.add(attributes[i]);
                    } 
                } 
                attributesAllowed = set;
            } 
            addTaint(attributes[0].getTaint());
            
            
                
            
            
            
            
            
            
                
                        
                
                    
                
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.491 -0400", hash_original_method = "CC2190075ADAC44CCBDC93141CA9BE6C", hash_generated_method = "47FB8490FFAF0DB2D1EFE56B48B55B58")
        @Override
        @SuppressWarnings("unchecked")
        public Object clone() {
            Object varB4EAC82CA7396A68D541C85D26508E83_1498227340 = null; 
            try 
            {
                AttributedIterator clone = (AttributedIterator) super.clone();
                {
                    clone.attributesAllowed = (HashSet<Attribute>) attributesAllowed
                            .clone();
                } 
                varB4EAC82CA7396A68D541C85D26508E83_1498227340 = clone;
            } 
            catch (CloneNotSupportedException e)
            {
                if (DroidSafeAndroidRuntime.control) throw new AssertionError(e);
            } 
            varB4EAC82CA7396A68D541C85D26508E83_1498227340.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1498227340;
            
            
                
                
                    
                            
                
                
            
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.492 -0400", hash_original_method = "81A9D498AF1F73C3D962F8C3EDD6D3D9", hash_generated_method = "5C102694C2257C535840F83D4B364107")
        public char current() {
            char var7471FC70B539530D7206B8BC1B31F802_988158402 = (attrString.text.charAt(offset));
            char varA87DEB01C5F539E6BDA34829C8EF2368_2100903191 = getTaintChar();
            return varA87DEB01C5F539E6BDA34829C8EF2368_2100903191;
            
            
                
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.492 -0400", hash_original_method = "4AF9D055D17E58470820B415A8EBAFA4", hash_generated_method = "3C4ABA7EDDB10175C34008266DBE7AA0")
        public char first() {
            offset = begin;
            char var7471FC70B539530D7206B8BC1B31F802_1289497574 = (attrString.text.charAt(offset));
            char varA87DEB01C5F539E6BDA34829C8EF2368_2065056212 = getTaintChar();
            return varA87DEB01C5F539E6BDA34829C8EF2368_2065056212;
            
            
                
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.492 -0400", hash_original_method = "1D4D2C19F23B97FE6ECF3D3284916FD4", hash_generated_method = "1C8E958345E1D4D95C3AEC4DC5AF0FEC")
        public int getBeginIndex() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1866068366 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1866068366;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.492 -0400", hash_original_method = "2693C2AA223CB37D0504CD257C6327BC", hash_generated_method = "F0A6D7FE6A653AC2494787BD3F64FE9F")
        public int getEndIndex() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_296255665 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_296255665;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.492 -0400", hash_original_method = "0952456464DB8DF9DBB7507E3C2ED53C", hash_generated_method = "3E95A14D766478B72328C54A03E520D3")
        public int getIndex() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1562436713 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1562436713;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.493 -0400", hash_original_method = "20101C80E99D94E4CD68776989F0B447", hash_generated_method = "EA681FCE952A4A6E085494011ED05437")
        private boolean inRange(Range range) {
            addTaint(range.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_361987525 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_361987525;
            
            
                
            
            
                    
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.493 -0400", hash_original_method = "D282867E9466B5652FFBD5F7BCA71B9B", hash_generated_method = "5F9A7F40568A2A8DB0CE9EEFEA36B2A9")
        private boolean inRange(List<Range> ranges) {
            Iterator<Range> it = ranges.iterator();
            {
                boolean varB2FF4435B274CC4BE01D264DEA08F957_1073248198 = (it.hasNext());
                {
                    Range range = it.next();
                } 
            } 
            addTaint(ranges.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1228308811 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1228308811;
            
            
            
                
                
                    
                            
                
                    
                            
                
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.494 -0400", hash_original_method = "1F90FC3406D3E88B418E6F5A05B249D4", hash_generated_method = "D09EC881B8AEEEB273CBC7506D08C477")
        public Set<AttributedIterator.Attribute> getAllAttributeKeys() {
            Set<AttributedIterator.Attribute> varB4EAC82CA7396A68D541C85D26508E83_1623397152 = null; 
            Set<AttributedIterator.Attribute> varB4EAC82CA7396A68D541C85D26508E83_1392592973 = null; 
            {
                boolean var440E9841255491133E314328640A0B67_1952458919 = (begin == 0 && end == attrString.text.length()
                    && attributesAllowed == null);
                {
                    varB4EAC82CA7396A68D541C85D26508E83_1623397152 = attrString.attributeMap.keySet();
                } 
            } 
            Set<AttributedIterator.Attribute> result = new HashSet<Attribute>(
                    (attrString.attributeMap.size() * 4 / 3) + 1);
            Iterator<Map.Entry<Attribute, List<Range>>> it = attrString.attributeMap
                    .entrySet().iterator();
            {
                boolean varB2FF4435B274CC4BE01D264DEA08F957_554187498 = (it.hasNext());
                {
                    Map.Entry<Attribute, List<Range>> entry = it.next();
                    {
                        boolean var78A623E4F0CCA03B879F36D854BE57FF_181990983 = (attributesAllowed == null
                        || attributesAllowed.contains(entry.getKey()));
                        {
                            List<Range> ranges = entry.getValue();
                            {
                                boolean var48BA0119E6136D30C1769489A0BAEB46_577438068 = (inRange(ranges));
                                {
                                    result.add(entry.getKey());
                                } 
                            } 
                        } 
                    } 
                } 
            } 
            varB4EAC82CA7396A68D541C85D26508E83_1392592973 = result;
            Set<AttributedIterator.Attribute> varA7E53CE21691AB073D9660D615818899_350976105; 
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: 
                    varA7E53CE21691AB073D9660D615818899_350976105 = varB4EAC82CA7396A68D541C85D26508E83_1623397152;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_350976105 = varB4EAC82CA7396A68D541C85D26508E83_1392592973;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_350976105.addTaint(getTaint()); 
            return varA7E53CE21691AB073D9660D615818899_350976105;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.495 -0400", hash_original_method = "7F47FD199B74CEDC765420E2B0AD1B85", hash_generated_method = "DA66C050A3411AD7AB8FD29F3B0F5A0A")
        private Object currentValue(List<Range> ranges) {
            Object varB4EAC82CA7396A68D541C85D26508E83_1566278480 = null; 
            Object varB4EAC82CA7396A68D541C85D26508E83_802862953 = null; 
            Iterator<Range> it = ranges.iterator();
            {
                boolean varB2FF4435B274CC4BE01D264DEA08F957_1219050183 = (it.hasNext());
                {
                    Range range = it.next();
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_1566278480 = inRange(range) ? range.value : null;
                    } 
                } 
            } 
            varB4EAC82CA7396A68D541C85D26508E83_802862953 = null;
            addTaint(ranges.getTaint());
            Object varA7E53CE21691AB073D9660D615818899_770876426; 
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: 
                    varA7E53CE21691AB073D9660D615818899_770876426 = varB4EAC82CA7396A68D541C85D26508E83_1566278480;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_770876426 = varB4EAC82CA7396A68D541C85D26508E83_802862953;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_770876426.addTaint(getTaint()); 
            return varA7E53CE21691AB073D9660D615818899_770876426;
            
            
            
                
                
                    
                
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.496 -0400", hash_original_method = "9256DFDAE9CB8C43C18A44C8B3AC6DAC", hash_generated_method = "DA88E5E7FE9D4BC1913513DA4615BAC5")
        public Object getAttribute(
                AttributedCharacterIterator.Attribute attribute) {
            Object varB4EAC82CA7396A68D541C85D26508E83_1385739446 = null; 
            Object varB4EAC82CA7396A68D541C85D26508E83_443039342 = null; 
            Object varB4EAC82CA7396A68D541C85D26508E83_66790449 = null; 
            {
                boolean var12D36913C4CC9B92E6CFDE0A26E3CD6F_697415133 = (attributesAllowed != null
                    && !attributesAllowed.contains(attribute));
                {
                    varB4EAC82CA7396A68D541C85D26508E83_1385739446 = null;
                } 
            } 
            ArrayList<Range> ranges = (ArrayList<Range>) attrString.attributeMap
                    .get(attribute);
            {
                varB4EAC82CA7396A68D541C85D26508E83_443039342 = null;
            } 
            varB4EAC82CA7396A68D541C85D26508E83_66790449 = currentValue(ranges);
            addTaint(attribute.getTaint());
            Object varA7E53CE21691AB073D9660D615818899_2041416861; 
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: 
                    varA7E53CE21691AB073D9660D615818899_2041416861 = varB4EAC82CA7396A68D541C85D26508E83_1385739446;
                    break;
                case 2: 
                    varA7E53CE21691AB073D9660D615818899_2041416861 = varB4EAC82CA7396A68D541C85D26508E83_443039342;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_2041416861 = varB4EAC82CA7396A68D541C85D26508E83_66790449;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_2041416861.addTaint(getTaint()); 
            return varA7E53CE21691AB073D9660D615818899_2041416861;
            
            
                    
                
            
            
                    
            
                
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.498 -0400", hash_original_method = "AAAFE2E009783E25A93A8B590538D893", hash_generated_method = "2783D1734BA23950AFBD816214B53AD2")
        public Map<Attribute, Object> getAttributes() {
            Map<Attribute, Object> varB4EAC82CA7396A68D541C85D26508E83_2049147793 = null; 
            Map<Attribute, Object> result = new HashMap<Attribute, Object>(
                    (attrString.attributeMap.size() * 4 / 3) + 1);
            Iterator<Map.Entry<Attribute, List<Range>>> it = attrString.attributeMap
                    .entrySet().iterator();
            {
                boolean varB2FF4435B274CC4BE01D264DEA08F957_577752688 = (it.hasNext());
                {
                    Map.Entry<Attribute, List<Range>> entry = it.next();
                    {
                        boolean var78A623E4F0CCA03B879F36D854BE57FF_366367466 = (attributesAllowed == null
                        || attributesAllowed.contains(entry.getKey()));
                        {
                            Object value = currentValue(entry.getValue());
                            {
                                result.put(entry.getKey(), value);
                            } 
                        } 
                    } 
                } 
            } 
            varB4EAC82CA7396A68D541C85D26508E83_2049147793 = result;
            varB4EAC82CA7396A68D541C85D26508E83_2049147793.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_2049147793;
            
            
                    
            
                    
            
                
                
                        
                    
                    
                        
                    
                
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.498 -0400", hash_original_method = "B67CDF67136100A9ADF2991D47BD9A14", hash_generated_method = "E8947C84220697C89806ACD6180ED6FA")
        public int getRunLimit() {
            int varB8CB18E7DB26C804CE1E291715EC4085_1100052799 = (getRunLimit(getAllAttributeKeys()));
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_658958228 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_658958228;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.499 -0400", hash_original_method = "40F484258D42E498FCA29FFC5F596001", hash_generated_method = "EAC9FE32FB96A4647B1B15EEC1D80E7B")
        private int runLimit(List<Range> ranges) {
            int result = end;
            ListIterator<Range> it = ranges.listIterator(ranges.size());
            {
                boolean varFF94A24275993577BF8E66186EAD8E8C_1395764639 = (it.hasPrevious());
                {
                    Range range = it.previous();
                    {
                        {
                            boolean var2FAF37F82B41CCA38F243EDFFC0955AC_1459747839 = (inRange(range));
                        } 
                    } 
                    result = range.start;
                } 
            } 
            addTaint(ranges.getTaint());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_37009986 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_37009986;
            
            
            
            
                
                
                    
                
                
                    
                
                    
                
                
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.500 -0400", hash_original_method = "F819F4AC98ED7B00F15856104CEA6D7F", hash_generated_method = "A7ECE833510789A08489F2125F6683C0")
        public int getRunLimit(AttributedCharacterIterator.Attribute attribute) {
            {
                boolean var12D36913C4CC9B92E6CFDE0A26E3CD6F_211464149 = (attributesAllowed != null
                    && !attributesAllowed.contains(attribute));
            } 
            ArrayList<Range> ranges = (ArrayList<Range>) attrString.attributeMap
                    .get(attribute);
            int var3243E9C702621CDA5FC8AD3026FC7D28_2049068561 = (runLimit(ranges));
            addTaint(attribute.getTaint());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_354240941 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_354240941;
            
            
                    
                
            
            
                    
            
                
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.500 -0400", hash_original_method = "39CD1571C1B0AAE61A932D3B1E130DFE", hash_generated_method = "FEAAB8F690EA1BF00EEEF9EC71847F70")
        public int getRunLimit(Set<? extends Attribute> attributes) {
            int limit = end;
            Iterator<? extends Attribute> it = attributes.iterator();
            {
                boolean varB2FF4435B274CC4BE01D264DEA08F957_1667806465 = (it.hasNext());
                {
                    AttributedCharacterIterator.Attribute attribute = it.next();
                    int newLimit = getRunLimit(attribute);
                    {
                        limit = newLimit;
                    } 
                } 
            } 
            addTaint(attributes.getTaint());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1006722198 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1006722198;
            
            
            
            
                
                
                
                    
                
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.501 -0400", hash_original_method = "FE3F08CD8D40BCC02EAAB9CF9D349F73", hash_generated_method = "6C7AF5F5CF627D5EFABF8F9BE50E6791")
        public int getRunStart() {
            int varD479F53F5B086C7131ABCE733DD47303_78226506 = (getRunStart(getAllAttributeKeys()));
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1123052139 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1123052139;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.501 -0400", hash_original_method = "3940F742081E74CA234FF11DA5FD3120", hash_generated_method = "2540B67564AD6BF5434E3691E39F4D59")
        private int runStart(List<Range> ranges) {
            int result = begin;
            Iterator<Range> it = ranges.iterator();
            {
                boolean varB2FF4435B274CC4BE01D264DEA08F957_433157485 = (it.hasNext());
                {
                    Range range = it.next();
                    {
                        {
                            boolean var2FAF37F82B41CCA38F243EDFFC0955AC_559331150 = (inRange(range));
                        } 
                    } 
                    result = range.end;
                } 
            } 
            addTaint(ranges.getTaint());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_724879324 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_724879324;
            
            
            
            
                
                
                    
                
                
                    
                
                    
                
                
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.502 -0400", hash_original_method = "D8F9F8B7D0C4F74D05FEF10E27E7F588", hash_generated_method = "ED4FB1E2FDDF6F15033D7523E22A367A")
        public int getRunStart(AttributedCharacterIterator.Attribute attribute) {
            {
                boolean var12D36913C4CC9B92E6CFDE0A26E3CD6F_892590719 = (attributesAllowed != null
                    && !attributesAllowed.contains(attribute));
            } 
            ArrayList<Range> ranges = (ArrayList<Range>) attrString.attributeMap
                    .get(attribute);
            int varF7B3B9AA84E9A9D092AE2BE6817D6B1C_1554966599 = (runStart(ranges));
            addTaint(attribute.getTaint());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2073470122 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2073470122;
            
            
                    
                
            
            
                    
            
                
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.502 -0400", hash_original_method = "62E2E3A1AAFB276945B722FDB547D45B", hash_generated_method = "DA0E59B0614729838E238A38DD084D20")
        public int getRunStart(Set<? extends Attribute> attributes) {
            int start = begin;
            Iterator<? extends Attribute> it = attributes.iterator();
            {
                boolean varB2FF4435B274CC4BE01D264DEA08F957_2072055982 = (it.hasNext());
                {
                    AttributedCharacterIterator.Attribute attribute = it.next();
                    int newStart = getRunStart(attribute);
                    {
                        start = newStart;
                    } 
                } 
            } 
            addTaint(attributes.getTaint());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1713466433 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1713466433;
            
            
            
            
                
                
                
                    
                
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.503 -0400", hash_original_method = "6CAD62DAB178D2919A2036BE42DEC497", hash_generated_method = "8FC2C5C05ACAAEE63193D81CE156CD30")
        public char last() {
            offset = end - 1;
            char var7471FC70B539530D7206B8BC1B31F802_765719024 = (attrString.text.charAt(offset));
            char varA87DEB01C5F539E6BDA34829C8EF2368_1282249429 = getTaintChar();
            return varA87DEB01C5F539E6BDA34829C8EF2368_1282249429;
            
            
                
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.503 -0400", hash_original_method = "B623F272BE854A8CF15368B2FE2B8A97", hash_generated_method = "6D7C385B873AA47704FFFED7543323CC")
        public char next() {
            {
                offset = end;
            } 
            char varCD2A465A117ACDFD77E8F731FFBCF3CF_1243558211 = (attrString.text.charAt(++offset));
            char varA87DEB01C5F539E6BDA34829C8EF2368_526253127 = getTaintChar();
            return varA87DEB01C5F539E6BDA34829C8EF2368_526253127;
            
            
                
                
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.504 -0400", hash_original_method = "E77E60DF0F891730B03F44D98923AB66", hash_generated_method = "790C795899C6B1ED6CB21EAFEA08A108")
        public char previous() {
            char var2ECEAF615C1A7B98A9B5DA51518FE2D8_1107072248 = (attrString.text.charAt(--offset));
            char varA87DEB01C5F539E6BDA34829C8EF2368_349807335 = getTaintChar();
            return varA87DEB01C5F539E6BDA34829C8EF2368_349807335;
            
            
                
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.504 -0400", hash_original_method = "C542CEFF91217DDB3083AD983C51F194", hash_generated_method = "A72129D577A8F45F57358CBC4611D9F6")
        public char setIndex(int location) {
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
            } 
            offset = location;
            char var7471FC70B539530D7206B8BC1B31F802_332197870 = (attrString.text.charAt(offset));
            char varA87DEB01C5F539E6BDA34829C8EF2368_484669439 = getTaintChar();
            return varA87DEB01C5F539E6BDA34829C8EF2368_484669439;
            
            
                
            
            
            
                
            
            
        }

        
    }


    
}

