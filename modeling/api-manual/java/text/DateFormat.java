package java.text;

import java.util.Date;

public abstract class DateFormat extends Format {
	
	public abstract StringBuffer format(Date date, StringBuffer buffer,
            FieldPosition field);
	
	public abstract Date parse(String string, ParsePosition position);

}
