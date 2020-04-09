package Song.Sejong.controller;

import Song.Sejong.model.*;
import Song.Sejong.model.dto.MenuBean;
import Song.Sejong.model.dto.PortfolioDataObject;
import Song.Sejong.model.dto.portfolio.PortfolioList;
import Song.Sejong.model.dto.portfolio.PortfolioThumbnail;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ResourceBundle;

@Controller
@RequestMapping("/portfolio")
public class PortfolioController extends DefaultController{

    static final Logger logger = LoggerFactory.getLogger(PortfolioController.class);
    @GetMapping
    public ModelAndView testController()
    {
        ModelAndView view = new ModelAndView();
        view.setViewName("portfolio");
        view.addObject("link",URLConst.PORTFOLIO);
        bean.setMenu(MenuItemDto.PORTFOLIO,true);
        view.addObject("menuBean",bean);
        PortfolioList list=  new PortfolioList();
        for(int i = 1;i<=4;i++){
            list.getThumbnail().add(new PortfolioThumbnail("static/portfolio"+i+".png","portfolio"+i,"portFolioFileTest"));
        }
        view.addObject("portfolioList",list);
        return view;
    }


    @GetMapping(value="/{item}")
    @ResponseBody
    public String portfolioGetItem(@PathVariable("item") String item){
        PortfolioDataObject portfolioItem = new PortfolioDataObject();
        portfolioItem.setTitle(item);
        portfolioItem.setImageData("static/"+item+".png");
        return gson.toJson(portfolioItem);

    }
}
