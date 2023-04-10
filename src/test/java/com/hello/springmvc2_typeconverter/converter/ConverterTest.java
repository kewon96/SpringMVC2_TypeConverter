package com.hello.springmvc2_typeconverter.converter;

import com.hello.springmvc2_typeconverter.type.IpPort;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ConverterTest {

    @Test
    void string_to_integer() {
        StringToIntegerConverter converter = new StringToIntegerConverter();
        Integer result = converter.convert("10");

        assertThat(result).isEqualTo(10);
    }

    @Test
    void integer_to_string() {
        IntegerToStringConverter converter = new IntegerToStringConverter();
        String result = converter.convert(10);

        assertThat(result).isEqualTo("10");
    }

    @Test
    void string_to_ip_port() {
        StringToIpPortConverter converter = new StringToIpPortConverter();
        IpPort result = converter.convert("192.168.0.7:8080");

        assertThat(result).isEqualTo(new IpPort("192.168.0.7", 8080));
    }

    @Test
    void ip_port_to_string() {
        IpPortToStringConverter converter = new IpPortToStringConverter();
        String result = converter.convert(new IpPort("192.168.0.101", 22));

        assertThat(result).isEqualTo("192.168.0.101:22");
    }


}
