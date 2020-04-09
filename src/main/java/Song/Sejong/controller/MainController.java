package Song.Sejong.controller;

import Song.Sejong.model.dto.MenuBean;
import Song.Sejong.model.MenuItemDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("")
public class MainController extends DefaultController{

    @GetMapping
    public ModelAndView testController()
    {
        ModelAndView view = new ModelAndView();
        view.setViewName("home");
        view.addObject("link",URLConst.HOME);
        bean.setMenu(MenuItemDto.HOME,true);
        view.addObject("menuBean",bean);
        return view;
    }
}
