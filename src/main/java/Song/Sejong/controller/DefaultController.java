package Song.Sejong.controller;

import Song.Sejong.model.dto.MenuBean;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;

public class DefaultController {
    @Autowired
    MenuBean bean;
    @Autowired
    Gson gson;

}
