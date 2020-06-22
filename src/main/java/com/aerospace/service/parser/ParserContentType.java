package com.aerospace.service.parser;

public enum ParserContentType {

    JSON(ParserTypeConstants.JSON_PARSER) {
        @Override
        public String fileName() {
            return "coupons.json";
        }
    },

    CSV(ParserTypeConstants.CSV_PARSER) {
        @Override
        public String fileName() {
            return "coupons.csv";
        }
    },

    XML(ParserTypeConstants.XML_PARSER) {
        @Override
        public String fileName() {
            return "coupons.xml";
        }
    };

    private final String parserName;

    ParserContentType(String parserName) {
        this.parserName = parserName;
    }

    public abstract String fileName();

    @Override
    public String toString() {
        return parserName;
    }

}
