package com.aerospace.service;

import com.aerospace.repository.CouponRepository;
import com.aerospace.model.Coupon;
import com.aerospace.service.parser.ParserContentType;
import com.aerospace.service.parser.ParserFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.List;

@Service
@Slf4j
public class CouponService extends AbstractService<Coupon, CouponRepository> {

    private ParserFactory parserFactory;

    public CouponService(CouponRepository repository) {
        super(repository);
    }

    @Autowired
    public CouponService(CouponRepository repository, ParserFactory parserFactory) {
        this(repository);
        this.parserFactory = parserFactory;
    }

    @Override
    public Coupon save(Coupon entity) {
        return this.repository.save(entity);
    }

    @Override
    public List<Coupon> getAll(ParserContentType contentType) throws IOException {
        String fileName = contentType.fileName();
        log.info("Fetching list from file {}", fileName);

        return parserFactory
                .getParser(contentType)
                .parse(getFileHandle(fileName));
    }

    private Reader getFileHandle(String fileName) {
        InputStream is = this.getClass().getClassLoader().getResourceAsStream(fileName);
        return new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));
    }
}
