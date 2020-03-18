import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.support.ServerWebExchangeUtils;

import java.time.ZonedDateTime;
import java.util.Map;

/**
 * @Author: wujianmin
 * @Date: 2020/3/18 15:53
 * @Function:
 * @Version 1.0
 */
@Slf4j
public class TimeZoneTest {

    public static void main(String[] args) {
        System.out.println(ZonedDateTime.now().toString());
        log.debug("ddd");
    }
}
