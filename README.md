#spring-cloud-sample


ognl  -x  3 '@com.pamirs.pradar.maxplanck.module.agent.shared.service.CutoffConfiguration@loadedClasses'


ognl  -x  3 '@com.pamirs.pradar.maxplanck.module.agent.shared.service.CutoffConfiguration@loadedConfigs'


trace com.pamirs.pradar.maxplanck.module.agent.shared.service.CutoffConfiguration getConfigInvoker -n 5 '1==1'
/api/link/guard/guardmanage?current=0&pageSize=1024&applicationName=%s


import com.huawei.it.cec.tc.order.fulfillment.infra.provider.dto.cic.SkuResponse;
import com.alibaba.fastjson.JSON;

String str="{\n"+"\"product_sku_id\":\"automate_sp1\",\n"+"\"sku_type_code\":\"0\",\n"
+"\"list\":[{\n"+"\"one_level_code\":\"1001\",\n"
+"\"two_level_code\":\"1001018M\",\n"+"\"sku_type_code\":\"0\",\n"
+"\"sku_code\":\"automate_sp1\",\n"+"\"sku_name\":\"自动化测试实物商品1\",\n"
+"\"ean_code\":\"automate_ean1\",\n"+"\"spart_code\":\"automate_sp1\",\n"
+"\"source_code\":\"1\",\n"+"\"purchase_type\":2,\n"
+"\"product_type\":10,\n"+"\"battery_flag\":\"1\",\n"
+"\"type_code\":\"1\",\n"+"\"authorized_price\":100,\n"
+"\"optional_price\":0,\n"+"\"package_price\":0,\n"
+"\"retail_price\":100,\n"+"\"tax_code\":\"automate_tax\",\n"
+"\"battery_model\":\"automate_battery\",\n"+"\"battery_report\":\"0\",\n"
+"\"is_integration\":\"0\",\n"+"\"is_magnetic\":\"10\",\n"
+"\"is_write_off\":\"2\",\n"+"\"software_name\":\"华为终端智能设备人机交互通信软件V2.0\",\n"
+"\"is_install\":\"1\",\n"+"\"is_invoice\":\"0\"\n"+"}]\n"+"}";
SkuResponse object= JSON.parseObject(str,SkuResponse.class);
return object;














 {
      "product_sku_id": "automate_sp1",
      "sku_type_code": "0",
      "sku_basic_detail_responses": [      {
         "one_level_code": "1001",
         "two_level_code": "1001018M",
         "sku_type_code": "0",
         "sku_code": "automate_sp1",
         "sku_name": "自动化测试实物商品1",
         "ean_code": "automate_ean1",
         "spart_code": "automate_sp1",
         "source_code": "1",
         "purchase_type": 2,
         "product_type": 10,
         "battery_flag": "1",
         "type_code": "1",
         "authorized_price": 100,
         "optional_price": 0,
         "package_price": 0,
         "retail_price": 100,
         "tax_code": "automate_tax",
         "battery_model": "automate_battery",
         "battery_report": "0",
         "is_integration": "0",
         "is_magnetic": "10",
         "is_write_off": "2",
         "software_name": "华为终端智能设备人机交互通信软件V2.0",
         "is_install": "1",
         "is_invoice": "0"
      }]
   }
