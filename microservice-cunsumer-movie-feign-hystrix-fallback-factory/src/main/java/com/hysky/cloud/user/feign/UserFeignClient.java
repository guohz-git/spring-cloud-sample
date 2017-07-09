package com.hysky.cloud.user.feign;

import com.hysky.cloud.user.entity.User;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Feign的fallbackfactory测试
 * 使用@Feign的fallbackfactory回退类日志信息
 */
@FeignClient(name = "microservice-provider-user",
    fallbackFactory = FeignClientFallbackFactory.class)
public interface UserFeignClient {
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    User findById(@PathVariable("id") Long id);

}
/**
 * 回退类FeignClientFallback需实现Feign Client接口
 * FeignClientFallback也可以是public class，没有区别
 * @author 周立
 */
@Component
class FeignClientFallbackFactory implements FallbackFactory<UserFeignClient> {

    private static final Logger log = LoggerFactory.getLogger(FeignClientFallbackFactory.class);


    @Override
    public UserFeignClient create(Throwable throwable) {
        return new UserFeignClient() {
            @Override
            public User findById(Long id) {
                log.info("fallback; reason was:" ,throwable);
                User user = new User();
                user.setId(-1L);
                user.setUsername("默认用户");
                return user;
            }
        };
    }
}

