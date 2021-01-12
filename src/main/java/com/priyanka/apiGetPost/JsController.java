package com.priyanka.apiGetPost;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JsController {

    @RequestMapping(value = "/page")
    public String getPage() {return "page";}

    @RequestMapping(value = "/pagePost")
    public String getPagePost() {return "pagePost";}
}
