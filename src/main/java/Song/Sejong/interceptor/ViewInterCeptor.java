package Song.Sejong.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

public class ViewInterCeptor implements HandlerInterceptor {
    @Autowired
    HashComponent component;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        char[] t = request.getRequestURI().toCharArray();
        if(component.checkBanIp(request.getRemoteAddr()))
        {
            return false;
        }
        if(("Access").equals(((String)request.getSession().getAttribute("view")))) {
            return true;
        }
        if(request.getRequestURI().startsWith("/WEB-INF/")) return true;
        int sum = 0;
        for(char l : t)
        {
            sum += l;
        }
        if(component.viewHash.containsKey(sum) || sum==0 || sum=='/')
        {
            request.getSession().setAttribute("view","Access");
            return true;
        }
        component.banIp(request.getRemoteAddr());
        return false;
    }
}
