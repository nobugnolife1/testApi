package com.DoAn.HairStyle.service;

import com.DoAn.HairStyle.dto.PostRequest;
import com.DoAn.HairStyle.dto.Response;
import com.DoAn.HairStyle.dto.UpdatePostRequest;
import com.DoAn.HairStyle.entity.BlogEntity;
import com.DoAn.HairStyle.entity.UserEntity;
import com.DoAn.HairStyle.respositiry.BlogRespository;
import com.DoAn.HairStyle.respositiry.UserRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Date;
import java.util.List;

@Service
public class BlogService {
    @Autowired
    private  BlogRespository blogRespository;
    @Autowired
    private UserRespository userRespository;

    public  List<BlogEntity> loadBlog() {
        return blogRespository.findAll();
    }

    public Response addNewPost(PostRequest newPost, String token) {
        UserEntity user = new UserEntity();
        user = userRespository.findByToken(token);
        if(user.getRole().equals("admin")){
            BlogEntity blog = new BlogEntity();
            blog.setTitle(newPost.getTitle());
            blog.setContent(newPost.getContent());
            blog.setDescription(newPost.getDescription());
            blog.setThumbnail(newPost.getThumbnail());
            blog.setTag(newPost.getTag());
            Date date = new Date();
            blog.setTime(date);
            blog.setLink(newPost.getLink());
            blog.setUser(user);
            blogRespository.save(blog);
            Response response = new Response();
            response.setStatus("Success!");
            return response;
        }
        Response response = new Response();
        response.setStatus("You no have permission!");
        return response;
    }



    public Response deletePostById(String token, Long idPost) {
        UserEntity user = new UserEntity();
        user = userRespository.findByToken(token);
        if(user.getRole().equals("admin")){
            blogRespository.deleteByBlogID(idPost);
            Response response = new Response();
            response.setStatus("Success!");
            return response;
        }
        Response response = new Response();
        response.setStatus("You no have permission!");
            return response;
    }

    public Response updatePostById(String token, Long idPost, UpdatePostRequest updatePostRequest) {
        UserEntity user = new UserEntity();
        user = userRespository.findByToken(token);
        if(user.getRole().equals("admin")){
            BlogEntity blog = new BlogEntity();
            blog.setBlogID(idPost);
            blog.setTitle(updatePostRequest.getTitle());
            blog.setContent(updatePostRequest.getContent());
            blog.setDescription(updatePostRequest.getDescription());
            blog.setThumbnail(updatePostRequest.getThumbnail());
            blog.setTag(updatePostRequest.getTag());
            Date date = new Date();
            blog.setTime(date);
            blog.setLink(updatePostRequest.getLink());
            blog.setUser(user);
            blogRespository.save(blog);
            Response response = new Response();
            response.setStatus("Success!");
            return response;
        }
        Response response = new Response();
        response.setStatus("You no have permission!");
        return response;
    }
}
