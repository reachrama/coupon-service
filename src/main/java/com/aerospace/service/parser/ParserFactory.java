package com.aerospace.service.parser;

public interface ParserFactory {

    Parser getParser(ParserContentType contentType);
}
