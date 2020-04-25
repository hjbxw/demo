package com.example.demo.controller.videocontroller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demo.model.CommentSaying;
import com.example.demo.service.commentservice.CommentSayingService;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author Whitte
 * @Description 用于处理父级评论请求
 * @date 2019/7/26 9:15
 */
@RequestMapping("/comment")
@RestController
public class CommentSayingController {
	
	@Autowired
	private CommentSayingService commentSayingService;

	@Autowired
	private UserService userService;

	/**
	  * @Description 新增父级评论
	  * @param commentSaying 父级评论pojo
	  * @return 父级评论pojo
	  */
	@RequestMapping(value="/saying/add/first", method= RequestMethod.POST)
	public CommentSaying addFirstLevelCommment(CommentSaying commentSaying) {
		commentSaying.setCreateTime(new Date());
		commentSaying.setId(UUID.randomUUID().toString().replace("-", ""));
		commentSayingService.insertComment(commentSaying);
		return commentSaying;
	}

	/**
	  * @Description 根据评论所属板块，查找评论
	  * @param sectionId 评论所属板块ID
	  * @return 评论pojo
	  */
	@RequestMapping("/saying/get/comment/list/{sectionId}/{pageNum}/{pageSize}")
	public PageInfo<CommentSaying> showList(@PathVariable(value="sectionId") String sectionId,
										@PathVariable( value = "pageNum") Integer pageNum,
										@PathVariable( value = "pageSize") Integer pageSize,
										HttpSession session) {
		PageHelper.startPage(pageNum, pageSize);
		List<CommentSaying> commentSayingList = commentSayingService.selectListBySectionId(pageNum, pageSize, sectionId);
		PageInfo<CommentSaying> pageInfo = new PageInfo<>(commentSayingList, 10);
		session.setAttribute("pageInfo", pageInfo);
		return pageInfo;
	}


	/**
	  * @Description 删除父级评论
	  * @param sayingId 父级评论ID
	  * @return 无
	  */
	@RequestMapping("/saying/delete/{sayingId}")
	public void delete(@PathVariable(value="sayingId") String sayingId) {
		commentSayingService.deleteById(sayingId);
	}


	/**
	  * @Description 根据ID查找父级评论
	  * @param id 父级评论ID
	  * @return 父级评论pojo
	  */
	@RequestMapping("/saying/get/comment/{id}")
    public CommentSaying showCommment(@PathVariable(value="id") String id) {
		return commentSayingService.queryOneSaying(id);
    }

    /**
      * @Description 更新父级评论likes
      * @param id 父级评论ID
	  * @param likes likes参数
      * @return 无
      */
	@RequestMapping(value="/comment/saying/like", method= RequestMethod.POST)
    public void changeLikes(@RequestParam String id, @RequestParam String likes) {
		commentSayingService.modifySayingLikes(id, likes);
    }

	@RequestMapping("/user/getUser/{scrid}")
	public User getUser(@PathVariable(value="scrid") String scrid) {
		return userService.findUserById(scrid);
	}

}
