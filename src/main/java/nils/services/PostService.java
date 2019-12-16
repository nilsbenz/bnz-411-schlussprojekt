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
   }

   public List<Post> listPosts() {
      String response = apiService.get(BASE_URL + POST_URL);
      Gson gson = new Gson();
      Post[] posts = gson.fromJson(response, Post[].class);
      return Arrays.asList(posts);
   }
}
