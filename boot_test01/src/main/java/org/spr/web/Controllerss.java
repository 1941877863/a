package org.spr.web;

import org.spr.dao.Impos;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Controller
@CrossOrigin(value = "*")
public class Controllerss {

    @Resource
    private Impos ed;

    @RequestMapping("select")
    @ResponseBody
    public List<Map<String, Object>> show(){
        String sql = "select * from user";
        List<Map<String, Object>> el = ed.queryAll(sql);
        System.out.println(el);
        return el;
    }

    @RequestMapping("delete")
    @ResponseBody
    public List<Map<String, Object>> shows(String id){
        String sql = "delete from user where id="+new Integer(id)+"";
        ed.dele(sql);
        String sql1 = "select * from user";
        List<Map<String, Object>> el = ed.queryAll(sql1);
        return el;
    }

    @RequestMapping("selegaoji")
    @ResponseBody
    public List<Map<String, Object>> shows1(Map<String,Object> map,String uname){
        System.out.println(map.get("ida"));
        System.out.println(map.get("uname"));
        System.out.println(uname);
        String sql1 = "select * from user where name like '%"+uname+"%' ";
        List<Map<String, Object>> el = ed.queryAll(sql1);
        System.out.println(sql1);
        return el;
    }

}
