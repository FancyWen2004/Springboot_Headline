package com.kun.controller;

import com.kun.pojo.Headline;
import com.kun.service.HeadlineService;
import com.kun.utils.Result;
import org.aspectj.weaver.patterns.IToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("headline")
@CrossOrigin
public class HeadLineController {
    @Autowired
    private HeadlineService headlineService;

    //登陆以后才能访问
    @PostMapping("publish")
    public Result publish(@RequestBody Headline headline, @RequestHeader String token) {
        Result result = headlineService.publish(headline, token);
        return result;
    }


    @PostMapping("findHeadlineByHid")
    public Result findHeadlineByHid(Integer hid){
        Headline headline = headlineService.getById(hid);
        Map data = new HashMap();
        data.put("headline",headline);
        return Result.ok(data);
    }

    @PostMapping("update")
    public Result update(@RequestBody  Headline headline){
        Result result = headlineService.updateData(headline);
        return  result;
    }

    @PostMapping("removeByHid")
    public Result removeByHid(Integer hid){
        headlineService.removeById(hid);
        return Result.ok(null);
    }
}
