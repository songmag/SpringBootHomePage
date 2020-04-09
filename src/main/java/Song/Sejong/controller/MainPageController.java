package Song.Sejong.controller;

import Song.Sejong.model.dto.MenuBean;
import Song.Sejong.model.MenuItemDto;
import Song.Sejong.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller()
@RequestMapping(value = "/main")
public class MainPageController extends DefaultController{

    @Autowired
    UserService service;

    @GetMapping()
    public ModelAndView mainController(HttpServletRequest request)
    {
        ModelAndView view = new ModelAndView();
        view.setViewName("main");
        view.addObject("link",URLConst.MAIN);
        bean.setMenu(MenuItemDto.MAIN,true);
        view.addObject("menuBean",bean);
        return view;
    }
}
