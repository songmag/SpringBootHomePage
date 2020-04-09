package Song.Sejong.controller;


import Song.Sejong.model.*;
import Song.Sejong.model.dto.MenuBean;
import Song.Sejong.model.dto.post.Post;
import Song.Sejong.model.dto.post.PostList;
import Song.Sejong.model.dto.post.SubjectList;
import Song.Sejong.model.dto.user.UserModel;
import Song.Sejong.service.PostService;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value="/post")
public class PostController extends DefaultController{

    @Autowired
    private PostService service;
    private static final Logger logger = LoggerFactory.getLogger(PostController.class);

    @GetMapping
    public ModelAndView postController(@SessionAttribute UserModel user,HttpSession session) {
        ModelAndView view = new ModelAndView();
        view.setViewName("post");
        view.addObject("link", URLConst.POST);
        bean.setMenu(MenuItemDto.POST, true);
        view.addObject("menuBean", bean);
        SubjectList sblist;
        if(session.getAttribute("subjectList") == null) {
            sblist = service.getSubjectListDto(user);
            session.setAttribute("subjectList",sblist);
        }
        else
        {
            sblist= (SubjectList) session.getAttribute("subjectList");
        }
        view.addObject("subjectList",sblist);
        PostList list;
        if(session.getAttribute("postList") == null)
        {
            list = service.getPostList(sblist.getSelectedSubject().getId(),1);
            session.setAttribute("postList",list);
        }
        else{
            list = (PostList) session.getAttribute("postList");
        }
        view.addObject("postList",list);
        return view;
    }

    @GetMapping("/list/{postSubject}")
    @ResponseBody
    public String changeSubject(@SessionAttribute UserModel user,@PathVariable("postSubject") Long subject,HttpSession session){
        PostList list = (PostList) session.getAttribute("postList");
        SubjectList subjectList = (SubjectList) session.getAttribute("subjectList");
        if(list == null && subjectList == null) {
            list = service.getPostList(subject,1);
            subjectList = service.getSubjectListDto(user);
            session.setAttribute("postList",list);
            subjectList.setSelectedSubject(subjectList.getSubjectList().get((int) (subject-1)));
            session.setAttribute("subjectList",subjectList);
            return gson.toJson(list);
        }
        else{
            if(subject != subjectList.getSelectedSubject().getId())
            {
                list = service.getPostList(subject,1);
                subjectList.setSelectedSubject(subjectList.getSubjectList().get((int) (subject-1)));
                session.setAttribute("subjectList",subjectList);
                session.setAttribute("postList",list);
            }
            return gson.toJson(list);
        }
    }

    @GetMapping("/page/{page}")
    @ResponseBody
    public String getPostsOfPage(@PathVariable("page") int page,@SessionAttribute UserModel user, HttpSession session)
    {
           PostList list = service.getPostList((SubjectList) session.getAttribute("subjectList"),page,user);
           session.setAttribute("postList", list);
           logger.info(gson.toJson(list));
           return gson.toJson(list,PostList.class);
    }

    @PostMapping("/sendPost")
    @ResponseBody
    public String commitPost(@RequestBody Post object, @SessionAttribute UserModel user)
    {
        object.setOwner(user);
        service.submmitPost(object);
        return gson.toJson("success!! Input");
    }
}
