package Song.Sejong;

import Song.Sejong.interceptor.UserInterceptor;
import Song.Sejong.interceptor.ViewInterCeptor;
import Song.Sejong.model.dto.user.DefaultUserModel;
import Song.Sejong.model.dto.MenuBean;
import Song.Sejong.model.StaticPostModel;
import com.google.gson.Gson;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
public class WebConfigClass implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/*.ico").addResourceLocations("/WEB-INF/image");
        registry.addResourceHandler("/js/*.js").addResourceLocations("/WEB-INF/js/");
        registry.addResourceHandler("/*.css").addResourceLocations("/WEB-INF/css/");
        registry.addResourceHandler("/static/*").addResourceLocations("/WEB-INF/image/");
        registry.addResourceHandler("/ckeditor/**").addResourceLocations("/WEB-INF/ckeditor/");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(viewInterCeptor());
        registry.addInterceptor(userInterceptor());
    }

    @Bean
    public ViewInterCeptor viewInterCeptor(){return new ViewInterCeptor();}
    @Bean
    public DefaultUserModel defaultUserModel(){
        return new DefaultUserModel();
    }
    @Bean
    public HandlerInterceptor userInterceptor()
    {
        return new UserInterceptor();
    }
    @Bean
    public StaticPostModel staticPostModel(){
        return new StaticPostModel();
    }
    @Bean
    @Scope(value = WebApplicationContext.SCOPE_SESSION , proxyMode = ScopedProxyMode.TARGET_CLASS)
    public MenuBean menuBean(){
        return new MenuBean();
    }
    @Bean
    public Gson gson()
    {
        return new Gson();
    }
//    @Override
//    public void configureViewResolvers(ViewResolverRegistry registry) {
//        InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
//        internalResourceViewResolver.setPrefix("/WEB-INF/");
//        internalResourceViewResolver.setSuffix(".jsp");
//        internalResourceViewResolver.setOrder(Integer.MIN_VALUE);
//        registry.viewResolver(internalResourceViewResolver);
//    }
}
