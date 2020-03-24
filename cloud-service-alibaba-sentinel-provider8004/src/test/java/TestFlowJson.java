import com.alibaba.csp.sentinel.datasource.ReadableDataSource;
import com.alibaba.csp.sentinel.datasource.nacos.NacosDataSource;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;

import java.util.List;

/**
 * 描述:
 *
 * @author JimWu
 * @create 2020-03-24 22:33
 */
public class TestFlowJson {

    public static void main(String[] args) {
        final String remoteAddress = "localhost";
        final String groupId = "Sentinel:Demo";
        final String dataId = "com.alibaba.csp.sentinel.demo.flow.rule";

        ReadableDataSource<String, List<FlowRule>> flowRuleDataSource = new NacosDataSource<>(remoteAddress, groupId, dataId,
                source -> {
                    System.out.println(JSON.parseObject(source, new TypeReference<List<FlowRule>>() {
                    }));
                    return JSON.parseObject(source, new TypeReference<List<FlowRule>>() {
                    });
                });
    }

}