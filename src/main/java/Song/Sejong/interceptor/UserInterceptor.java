package Song.Sejong.interceptor;

import Song.Sejong.model.dto.user.DefaultUserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserInterceptor implements HandlerInterceptor {
    @Autowired
    DefaultUserModel defaultUserModel;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if(request.getSession().getAttribute("user") == null) {
            request.getSession().setAttribute("user",defaultUserModel);
        }
        return true;
    }
}
