package Song.Sejong.controller;


import Song.Sejong.model.dto.MenuBean;
import Song.Sejong.model.MenuItemDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/howMake")
public class MakeLogicController extends DefaultController{

    @GetMapping
    public ModelAndView testController()
    {
        ModelAndView view = new ModelAndView();
        view.setViewName("howMake");
        view.addObject("link",URLConst.MAKE);
        bean.setMenu(MenuItemDto.MAKE,true);
        view.addObject("menuBean",bean);
        return view;
    }
}
