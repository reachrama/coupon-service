package com.aerospace.service.parser;

import com.aerospace.model.Coupon;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

public interface Parser {

    List<Coupon> parse(Reader r) throws IOException;

    List<Coupon> parse(String payLoad) throws IOException;

}
