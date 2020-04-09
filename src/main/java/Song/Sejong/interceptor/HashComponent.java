package Song.Sejong.interceptor;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.WebApplicationContext;

import javax.annotation.PostConstruct;
import java.lang.annotation.Annotation;
import java.util.HashMap;
import java.util.Map;

@Component
public class HashComponent {
    @Autowired
    WebApplicationContext context;
    Map<Integer, String> viewHash = new HashMap<>();
    Map<String,Integer> count;
    @PostConstruct
    public String viewCheck()
    {
        count = new HashMap<String,Integer>();
        Map<String, Object> controllers = context.getBeansWithAnnotation(Controller.class);
        for( Map.Entry<String,Object> controller : controllers.entrySet())
        {
            if(controller.getKey().equals("basicErrorController")) continue;
            Class<?> clazz = controller.getValue().getClass();
            RequestMapping controller1 = (RequestMapping) clazz.getAnnotation(RequestMapping.class);
            if(controller1 == null) continue;
            char[] t = controller1.value()[0].toCharArray();
            int sum = 0;
            for(char l : t)
            {
                sum += l;
            }
            viewHash.put(sum,"Access");
        }
        return null;
    }
    public void banIp(String ip)
    {
        if(count.containsKey(ip))
        {
                count.put(ip,count.get(ip)+1);
        }
        else{
            count.put(ip,1);
        }
    }

    /**
     * If IP was banned return true
     * else return false
     * @param ip
     * @return
     */
    public boolean checkBanIp(String ip)
    {
        if(count.containsKey(ip))
        {
            if(count.get(ip) >= 3)
            {
                return true;
            }
        }
        return false;
    }
}
