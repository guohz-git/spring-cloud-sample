package com.hysky.config;

import feign.Contract;

/**
 *Feign 配置类
 */
public class FeginConfiguration {

    /**
     * 将契约改为feign原生的默认契约。这样就可以使用feign自带的注解了。
     * @return 默认的feign契约
     */
    public Contract feginContract(){
        return new feign.Contract.Default();
    }
}
