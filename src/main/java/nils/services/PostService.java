package nils.services;

import static nils.api.Paths.BASE_URL;
import static nils.api.Paths.POST_URL;

import com.google.gson.Gson;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import nils.api.ApiService;
import nils.entities.Post;
import nils.entities.User;

public class PostService {

   private ApiService apiService;
   private UserService userService;

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

   //Workarround If Equal function is called from user service the Response is empty and a nullpointer exception will be thrown
   public List<User> findByName(String name) {
      return Repository.getUserRepository().stream()
              .filter(user -> {
                 for (String namePart : user.getName().split(" ")) {
                    if (namePart.toUpperCase().startsWith(name.toUpperCase())) {
                       return true;
                    }
                 }
                 return false;
              })
              .collect(Collectors.toList());
   }

   public List<Post> listPostsByUser(String userName)  {
      List<User> users = findByName(userName);
           return Repository.getPostRepository().stream().filter(
              post ->  {
                  for(int i=0; i<users.size(); i++) {
                    if(post.getUserId() == Integer.parseInt(users.get(i).getId())) {
                        return true;
                    }
                  }
                 return false;
              }
      ).collect(Collectors.toList());
   }

   private void loadPosts() {
      String response = apiService.get(BASE_URL + POST_URL);
      Gson gson = new Gson();
      Post[] posts = gson.fromJson(response, Post[].class);
      Repository.setPostRepository(Arrays.asList(posts));
   }
}
