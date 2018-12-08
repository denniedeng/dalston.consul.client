package cloud.dalston.consul.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/discovery")
public class DiscoveryController {
	
    @Autowired
    DiscoveryClient discoveryClient;
	
	@RequestMapping(value = "/calculate" ,method = RequestMethod.GET)
    public Integer add(@RequestParam Integer a, @RequestParam Integer b) {
		//打印服务清单
		String services = "Services: " + discoveryClient.getServices();
        System.out.println(services);
		
        Integer r = a + b;
        return r;
    }
}
