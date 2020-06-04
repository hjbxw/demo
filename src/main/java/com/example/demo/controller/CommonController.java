package com.example.demo.controller;

import com.example.demo.model.Code;
import com.example.demo.model.JuBao;
import com.example.demo.model.Tuijian;
import com.example.demo.model.Video;
import com.example.demo.service.commonservice.CommonService;
import com.example.demo.utils.MyStringUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class CommonController {
    @Autowired
    private CommonService commonService;
    private Code code;
    @ResponseBody
    @RequestMapping("/common/torp/")
    public String insertRp(JuBao juBao){
        juBao.setId(MyStringUtils.getUUID());
        juBao.setCreatetime(MyStringUtils.getTime());
        commonService.createrp(juBao);
        return "ok";
    }

    @ResponseBody
    @RequestMapping("/common/findRpAll/{pageNum}/{pageSize}")
    public PageInfo<JuBao> findRpAll(@PathVariable( value = "pageNum") Integer pageNum,
                                     @PathVariable( value = "pageSize") Integer pageSize){
        PageHelper.startPage(pageNum, pageSize);
        List<JuBao> juBaoList = commonService.findAllRp(pageNum, pageSize);
        PageInfo<JuBao> juBaoPageInfo=new PageInfo<>(juBaoList,10);
        return juBaoPageInfo;
    }
    @ResponseBody
    @RequestMapping("/common/findByType/")
    public PageInfo<JuBao> findByType(@RequestParam  String type,
                                      @RequestParam Integer pageNums,
                                      @RequestParam  Integer pageSize){
        PageHelper.startPage(pageNums, pageSize);
        List<JuBao> juBaoList = commonService.findByType(type,pageNums, pageSize);
        PageInfo<JuBao> juBaoPageInfo=new PageInfo<>(juBaoList,10);
        return juBaoPageInfo;
    }

    @ResponseBody
    @RequestMapping("/common/delAll/")
    public String delAll(){
       commonService.delAllRp();
        return "ok";
    }
    @ResponseBody
    @RequestMapping("/common/delRpById/{id}")
    public String delRpById(@PathVariable String id){
        commonService.delRp(id);
        return "ok";
    }

    @ResponseBody
    @RequestMapping("/common/editState/{id}")
    public String editJbState(@PathVariable String id){
        String state ="0";
        commonService.editrp(id,state);
        return "ok";
    }
    @ResponseBody
    @RequestMapping("/common/addTjList/")
    public Code addToTj(@RequestParam String vid,
                        @RequestParam String userid,
                        @RequestParam String username,
                        @RequestParam String types){
        code = new Code();
        int i = commonService.checkHave(vid);
        int a =commonService.checkCount(types);
        if (i>0){
            code.setCode("2");
            return code;
        }
        if ("3".equals(types) && a>3){
                code.setCode("3");
                return code;
        }else if ("1".equals(types) && a>=3){
            code.setCode("3");
            return code;
        }else if ("2".equals(types) && a>=3){
            code.setCode("3");
            return code;
        }

        Tuijian tuijian = new Tuijian();
        tuijian.setId(MyStringUtils.getUUID());
        tuijian.setState("1");
        tuijian.setTypes(types);
        tuijian.setUserid(userid);
        tuijian.setUsername(username);
        tuijian.setVid(vid);
        commonService.addTj(tuijian);
        code.setCode("1");
        return code;
    }

    @ResponseBody
    @RequestMapping("/common/findTj/{pageNum}/{pageSize}")
    public PageInfo<Tuijian> findTJ(@PathVariable( value = "pageNum") Integer pageNum,
                                     @PathVariable( value = "pageSize") Integer pageSize){
        PageHelper.startPage(pageNum, pageSize);
        List<Tuijian> tuijians = commonService.selTjAll(pageNum, pageSize);
        PageInfo<Tuijian> tuijianPageInfo=new PageInfo<>(tuijians,10);
        return tuijianPageInfo;
    }

    @RequestMapping(value = "/common/delTj/{vid}")
    public Code delTjByVid(@PathVariable String vid){
        commonService.delTjById(vid);
        code.setCode("1");
        return code;
    }

    @ResponseBody
    @RequestMapping(value = "/common/findFqTj")
    public List<Tuijian> findFqTj(@RequestParam String types){
        List<Tuijian> videoList = commonService.selTjByTypesSp(types);
        return videoList;
    }

    @ResponseBody
    @RequestMapping(value = "/common/findFqTj2")
    public List<Tuijian> findFqTj2(){
        List<Tuijian> videoList = commonService.selTjByTypesTz();
        return videoList;
    }

    @ResponseBody
    @RequestMapping(value = "/common/checkReg")
    public Code checkRegDate(@RequestParam String regdata){
        code =new Code();
       int i = commonService.checkReg(regdata);
       if (i>0){
           /*1已被注册*/
           code.setCode("1");
       }else {
           /*未被注册*/
           code.setCode("2");
       }

        return code;
    }
}
