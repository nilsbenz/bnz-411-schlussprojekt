package nils.services;

import static nils.api.Paths.BASE_URL;
import static nils.api.Paths.POST_URL;

import com.google.gson.Gson;
import java.util.Arrays;
import java.util.List;
import nils.api.ApiService;
import nils.entities.Post;

public class PostService {

   private ApiService apiService;

   public PostService() {
      apiService = new ApiService();
      loadPosts();
   }

   /**
    * List all posts.
    *
    * @return List of posts
    */
   public List<Post> listPosts() {
      return Repository.getPostRepository();
   }

   private void loadPosts() {
      String response = apiService.get(BASE_URL + POST_URL);
      Gson gson = new Gson();
      Post[] posts = gson.fromJson(response, Post[].class);
      Repository.setPostRepository(Arrays.asList(posts));
   }
}
