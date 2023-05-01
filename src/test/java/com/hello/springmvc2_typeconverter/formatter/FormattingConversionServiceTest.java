package com.hello.springmvc2_typeconverter.formatter;

import com.hello.springmvc2_typeconverter.converter.IpPortToStringConverter;
import com.hello.springmvc2_typeconverter.converter.StringToIpPortConverter;
import com.hello.springmvc2_typeconverter.type.IpPort;
import org.junit.jupiter.api.Test;
import org.springframework.format.support.DefaultFormattingConversionService;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class FormattingConversionServiceTest {

    @Test
    void formattingConversionService() {
        DefaultFormattingConversionService conversionService = new DefaultFormattingConversionService();

        // Converter 등록
        conversionService.addConverter(new StringToIpPortConverter());
        conversionService.addConverter(new IpPortToStringConverter());

        // Formatter 등록
        conversionService.addFormatter(new MyNumberFormatter());

        // Converter 등록
        IpPort ipPort = conversionService.convert("127.0.0.1:8080", IpPort.class);
        assertThat(ipPort).isEqualTo(new IpPort("127.0.0.1", 8080));

        // Formatter 사용
        // 등록할 때는 구분하지만 사용할 땐 Converter를 사용하듯이 사용한다.(구분할 필요가 없다.)
        assertThat(conversionService.convert(1000, String.class)).isEqualTo("1,000");
        assertThat(conversionService.convert("1,000", Long.class)).isEqualTo(1000L);


    }

}
