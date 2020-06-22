package com.aerospace.service.parser;

import com.aerospace.model.Coupon;
import org.simpleflatmapper.csv.CsvParser;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Component (ParserTypeConstants.CSV_PARSER)
public class CSVParser  implements Parser {

    private static CsvParser.MapToDSL _cached;

    static {
        _cached = CsvParser
                .separator(',')
                .trimSpaces()
                .mapTo(Coupon.class);
    }

    @Override
    public List<Coupon> parse(Reader r) throws IOException {
        List<Coupon> couponList = null;
        try {
             couponList = (List<Coupon>) _cached
                    .stream(r)
                    .collect(toList());
        } catch (IOException e) {
            throw new IOException("Io error while parsing CSV file", e);
        }
        return couponList;
    }

    @Override
    public List<Coupon> parse(String payLoad) throws IOException {
        List<Coupon> couponList = null;
        try {
            couponList = CsvParser
                    .mapTo(Coupon.class)
                    .stream(payLoad)
                    .collect(toList());
        } catch (IOException e) {
            throw new IOException("Io error while parsing CSV file", e);
        }
        return couponList;
    }
}
