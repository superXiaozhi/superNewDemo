package com.dh.superxz_bottom.alibaba.fastjson.parser.deserializer;

import java.lang.reflect.Type;

import com.dh.superxz_bottom.alibaba.fastjson.parser.DefaultExtJSONParser;
import com.dh.superxz_bottom.alibaba.fastjson.parser.JSONLexer;
import com.dh.superxz_bottom.alibaba.fastjson.parser.JSONToken;
import com.dh.superxz_bottom.alibaba.fastjson.util.TypeUtils;

public class FloatDeserializer implements ObjectDeserializer {

    public final static FloatDeserializer instance = new FloatDeserializer();

    @SuppressWarnings("unchecked")
    public <T> T deserialze(DefaultExtJSONParser parser, Type clazz) {
        return (T) deserialze(parser);
    }

    @SuppressWarnings("unchecked")
    public static <T> T deserialze(DefaultExtJSONParser parser) {
        final JSONLexer lexer = parser.getLexer();
        if (lexer.token() == JSONToken.LITERAL_INT) {
            String val = lexer.numberString();
            lexer.nextToken(JSONToken.COMMA);
            return (T) Float.valueOf(Float.parseFloat(val));
        }

        if (lexer.token() == JSONToken.LITERAL_FLOAT) {
            float val = lexer.floatValue();
            lexer.nextToken(JSONToken.COMMA);
            return (T) Float.valueOf(val);
        }

        Object value = parser.parse();

        if (value == null) {
            return null;
        }

        return (T) TypeUtils.castToFloat(value);
    }

    public int getFastMatchToken() {
        return JSONToken.LITERAL_INT;
    }
}
