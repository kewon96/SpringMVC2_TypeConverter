package com.hello.springmvc2_typeconverter.config;

import com.hello.springmvc2_typeconverter.converter.IntegerToStringConverter;
import com.hello.springmvc2_typeconverter.converter.IpPortToStringConverter;
import com.hello.springmvc2_typeconverter.converter.StringToIntegerConverter;
import com.hello.springmvc2_typeconverter.converter.StringToIpPortConverter;
import com.hello.springmvc2_typeconverter.formatter.MyNumberFormatter;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addFormatters(FormatterRegistry registry) {
        // 우선순위로 인해 비활성화처리
//        registry.addConverter(new StringToIntegerConverter());
//        registry.addConverter(new IntegerToStringConverter());
        registry.addConverter(new StringToIpPortConverter());
        registry.addConverter(new IpPortToStringConverter());

        // Formatter
        registry.addFormatter(new MyNumberFormatter());
    }
}
