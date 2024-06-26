package com.alipay.api.internal.util.json;

import com.alipay.api.AlipayConstants;

import java.lang.reflect.Array;
import java.text.CharacterIterator;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.text.StringCharacterIterator;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Stack;
import java.util.TimeZone;

public class JSONWriter {

    private StringBuffer buf = new StringBuffer();
    private Stack<Object> calls = new Stack<Object>();
    private boolean emitClassName = true;
    private DateFormat format;

    public JSONWriter(boolean emitClassName) {
        this.emitClassName = emitClassName;
    }

    public JSONWriter() {
        this(false);
    }

    public JSONWriter(DateFormat format) {
        this(false);
        this.format = format;
    }

    public String write(Object object) {
        return write(object, false);
    }

    public String write(Object object, boolean isApiModel) {
        buf.setLength(0);
        value(object, isApiModel);
        return buf.toString();
    }

    public String write(long n) {
        return String.valueOf(n);
    }

    public String write(double d) {
        return String.valueOf(d);
    }

    public String write(char c) {
        return "\"" + c + "\"";
    }

    public String write(boolean b) {
        return String.valueOf(b);
    }

    private void value(Object object) {
        value(object, false);
    }

    private void value(Object object, boolean isApiModel) {
        if (object == null || cyclic(object)) {
            add(null);
        } else {
            calls.push(object);
            if (object instanceof Class<?>)
                string(object);
            else if (object instanceof Boolean)
                bool(((Boolean) object).booleanValue());
            else if (object instanceof Number)
                add(object);
            else if (object instanceof String)
                string(object);
            else if (object instanceof Character)
                string(object);
            else if (object instanceof Map<?, ?>)
                map((Map<?, ?>) object);
            else if (object.getClass().isArray())
                array(object, isApiModel);
            else if (object instanceof Iterator<?>)
                array((Iterator<?>) object, isApiModel);
            else if (object instanceof Collection<?>)
                array(((Collection<?>) object).iterator(), isApiModel);
            else if (object instanceof Date)
                date((Date) object);
            else {
            }
            calls.pop();
        }
    }

    private boolean cyclic(Object object) {
        Iterator<Object> it = calls.iterator();
        while (it.hasNext()) {
            Object called = it.next();
            if (object == called)
                return true;
        }
        return false;
    }


    private void add(String name, Object value) {
        add(name, value, false);
    }

    private void add(String name, Object value, boolean isApiModel) {
        add('"');
        add(name);
        add("\":");
        value(value, isApiModel);
    }

    private void map(Map<?, ?> map) {
        add("{");
        Iterator<?> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<?, ?> e = (Map.Entry<?, ?>) it.next();
            value(e.getKey());
            add(":");
            value(e.getValue());
            if (it.hasNext())
                add(',');
        }
        add("}");
    }

    private void array(Iterator<?> it) {
        array(it, false);
    }

    private void array(Iterator<?> it, boolean isApiModel) {
        add("[");
        while (it.hasNext()) {
            value(it.next(), isApiModel);
            if (it.hasNext())
                add(",");
        }
        add("]");
    }

    private void array(Object object) {
        array(object, false);
    }

    private void array(Object object, boolean isApiModel) {
        add("[");
        int length = Array.getLength(object);
        for (int i = 0; i < length; ++i) {
            value(Array.get(object, i), isApiModel);
            if (i < length - 1)
                add(',');
        }
        add("]");
    }

    private void bool(boolean b) {
        add(b ? "true" : "false");
    }

    private void date(Date date) {
        if (this.format == null) {
            this.format = new SimpleDateFormat(AlipayConstants.DATE_TIME_FORMAT);
            this.format.setTimeZone(TimeZone.getTimeZone(AlipayConstants.DATE_TIMEZONE));
        }
        add("\"");
        add(format.format(date));
        add("\"");
    }

    private void string(Object obj) {
        add('"');
        CharacterIterator it = new StringCharacterIterator(obj.toString());
        for (char c = it.first(); c != CharacterIterator.DONE; c = it.next()) {
            if (c == '"')
                add("\\\"");
            else if (c == '\\')
                add("\\\\");
            else if (c == '/')
                add("\\/");
            else if (c == '\b')
                add("\\b");
            else if (c == '\f')
                add("\\f");
            else if (c == '\n')
                add("\\n");
            else if (c == '\r')
                add("\\r");
            else if (c == '\t')
                add("\\t");
            else if (Character.isISOControl(c)) {
                unicode(c);
            } else {
                add(c);
            }
        }
        add('"');
    }

    private void add(Object obj) {
        buf.append(obj);
    }

    private void add(char c) {
        buf.append(c);
    }

    static char[] hex = "0123456789ABCDEF".toCharArray();

    private void unicode(char c) {
        add("\\u");
        int n = c;
        for (int i = 0; i < 4; ++i) {
            int digit = (n & 0xf000) >> 12;
            add(hex[digit]);
            n <<= 4;
        }
    }
}
