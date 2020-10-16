package com.DoAn.HairStyle.api;

import com.DoAn.HairStyle.dto.*;
import com.DoAn.HairStyle.entity.BlogEntity;
import com.DoAn.HairStyle.respositiry.BlogRespository;
import com.DoAn.HairStyle.respositiry.UserRespository;
import com.DoAn.HairStyle.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/post")
public class BlogController {
    private final BlogService blogService;

    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    @GetMapping
    public List<BlogEntity> getAllBlog(){
        return blogService.loadBlog();
    }

    @PostMapping(path = "{token}")
    public Response addNewPost(@Valid @NonNull @RequestBody PostRequest newPost ,@PathVariable("token") String token){
        return blogService.addNewPost(newPost,token);
    }
    @DeleteMapping(path = "/delete/{idPost}/{token}")
    public Response deletePost(@PathVariable("token") String token, @PathVariable("idPost") Long idPost){
        return blogService.deletePostById(token,idPost);
    }
    @PutMapping(path = "/update/{idPost}/{token}")
    public Response updatePost(@Valid @NonNull @RequestBody UpdatePostRequest updatePostRequest , @PathVariable("token") String token,@PathVariable("idPost") Long idPost){
        return blogService.updatePostById(token,idPost,updatePostRequest);
    }
}
