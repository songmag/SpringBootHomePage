package Song.Sejong.controller;

import Song.Sejong.model.StaticPostModel;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestFormApi {
    @Autowired
    Gson gson;
    @Autowired
    StaticPostModel model;
    @GetMapping("/post/sendPost")
    public String getPostForm() {
        return gson.toJson(model, StaticPostModel.class);
    }
}
