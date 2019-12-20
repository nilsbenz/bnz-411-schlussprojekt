package nils.services;

import static nils.api.Paths.BASE_URL;
import static nils.api.Paths.COMMENT_URL;

import com.google.gson.Gson;
import java.util.Arrays;
import java.util.List;
import nils.api.ApiService;
import nils.entities.Comment;

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

   private void loadComments() {
      String response = apiService.get(BASE_URL + COMMENT_URL);
      Gson gson = new Gson();
      Comment[] comments = gson.fromJson(response, Comment[].class);
      Repository.setCommentRepository(Arrays.asList(comments));
   }
}
