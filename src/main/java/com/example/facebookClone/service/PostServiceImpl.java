package com.example.facebookClone.service;

import com.example.facebookClone.entity.PostEntity;
import com.example.facebookClone.model.Post;
import com.example.facebookClone.repository.PostEntityRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService{

    @Autowired
    private PostEntityRepository postEntityRepository;


    @Override
    public Post addPost(Post post) throws Exception {

        try {
            PostEntity postEntity = new PostEntity();
            BeanUtils.copyProperties(post,postEntity);

            if (post.getFile() != null && !post.getFile().equalsIgnoreCase("null")) {
                postEntity.setImage(post.getFile());
            } else {
                postEntity.setImage(null);
            }

            postEntity = postEntityRepository.save(postEntity);
            post.setId(postEntity.getId());
            post.setFile(null);
            post.setImage(postEntity.getImage());

            return post;



        } catch (Exception e) {
            throw new Exception("Could not save Post: " + e);
        }
    }

    @Override
    public List<Post> getPost() {
        List<PostEntity> postEntities = postEntityRepository.findAll();
        List<Post> posts = new ArrayList<>();

        posts = postEntities.stream()
                .map(postEntity ->
                    Post.builder()
                            .id(postEntity.getId())
                            .post(postEntity.getPost())
                            .timeStamp(postEntity.getTimeStamp())
                            .email(postEntity.getEmail())
                            .name(postEntity.getName())
                            .image(postEntity.getImage())
                            .profilePic(postEntity.getProfilePic())
                            .build())
                .collect(Collectors.toList());

        return posts;
    }
}
