package nils.services;

import static nils.api.Paths.BASE_URL;
import static nils.api.Paths.COMMENT_URL;

import com.google.gson.Gson;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import nils.api.ApiService;
import nils.entities.Comment;
import nils.entities.Post;
import nils.entities.User;

public class CommentService {

   private ApiService apiService;

   public CommentService() {
      apiService = new ApiService();
      loadComments();
   }


   /**
    * List all comments
    *
    * @return List of comments
    */
   public List<Comment> listComments() {
      return Repository.getCommentRepository();
   }


   public List<Post> findPostByName(String name) {
      return Repository.getPostRepository().stream()
              .filter(post -> {
                 for (String namePart : post.getTitle().split(" ")) {
                    if (namePart.toUpperCase().startsWith(name.toUpperCase())) {
                       return true;
                    }
                 }
                 return false;
              })
              .collect(Collectors.toList());
   }

   //This functions searches for all the Comments that are related to a specific comment the result is processed using the posts title
   public List<Comment> findCommentsByPost(String postname)  {
      List<Post> posts = findPostByName(postname);
      return Repository.getCommentRepository().stream().filter(
              comment ->  {
                  for(int i=0; i<posts.size(); i++) {
                      if(comment.getPostId() == posts.get(0).getId()) {
                    return true;
                    }
                  }
                 return false;
              }
      ).collect(Collectors.toList());
   }

   //Get all the comments from the apiservice and stores in localy in the Repository
   private void loadComments() {
      String response = apiService.get(BASE_URL + COMMENT_URL);
      Gson gson = new Gson();
      Comment[] comments = gson.fromJson(response, Comment[].class);
      Repository.setCommentRepository(Arrays.asList(comments));
   }
}
