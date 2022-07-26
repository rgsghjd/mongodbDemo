package com.atheima.service;

import com.atheima.pojo.Comment;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.time.LocalDateTime;

@SpringBootTest
@RunWith(SpringRunner.class) //是一个运行容器，指定运行的环境
public class CommentServiceTest {
    @Resource
    CommentService service;
    @Test
    public void testAdd(){
        Comment comment=new Comment();
        comment.setArticleid("100000");
        comment.setContent("测试添加的数据");
        comment.setCreatedatetime(LocalDateTime.now());
        comment.setUserid("1003");
        comment.setNickname("杜江鹏666");
        comment.setState("1");
        comment.setLikenum(0);
        comment.setReplynum(0);
        service.add(comment);
    }
    @Test
    public void testRemove(){
        service.remove("62d7d48b011ba95c94c311f3");

    }
    @Test
    public void testSelect(){
        service.find();

    }
    @Test
    public void testUpdate(){
        Comment comment=new Comment();
        comment.setId("62d7d703011ba95ba891a46d");
        comment.setArticleid("100000");
        comment.setContent("测试添加的数据");
        comment.setCreatedatetime(LocalDateTime.now());
        comment.setUserid("1003");
        comment.setNickname("蒋航666");
        comment.setState("1");
        comment.setLikenum(0);
        comment.setReplynum(0);
        service.update(comment);
    }
    @Test
    public void page(){
        service.page("62d7d93c011ba96104eda0f5",1,1);
    }
    @Test
    public void inc(){
        service.updateThumbup("62d7d703011ba95ba891a46d");
    }
}
