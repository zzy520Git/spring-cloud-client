package notes.mvc.web.controller;

import lombok.extern.slf4j.Slf4j;
import notes.mvc.web.service.FeignTestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Description：
 *
 * @author zzy520git
 * @date 2020/1/9 11:21
 * @ see
 * @since
 */
@Slf4j
@RestController
@RequestMapping("/client")
public class IndexController {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired(required = false)
    private FeignTestClient feignTestClient;


    @RequestMapping("/index")
    public String sayHi() {
        String json = restTemplate.getForObject("http://eureka-provider/provider/index", String.class);
        return json;
    }

    @RequestMapping("/usefeign")
    public String useFeign() {
        log.error("feign测试");
        return feignTestClient.invokeProvider();
    }
}
