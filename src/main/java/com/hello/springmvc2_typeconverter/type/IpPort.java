package com.hello.springmvc2_typeconverter.type;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class IpPort {

    private String ip;
    private int port;

    public IpPort(String ip, int port) {
        this.ip = ip;
        this.port = port;
    }

    /** ip:port형식의 문자열로 반환 */
    public String toString() {
        return this.ip + ":" + this.port;
    }

}
