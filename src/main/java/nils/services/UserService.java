package nils.services;

import static nils.api.Paths.BASE_URL;
import static nils.api.Paths.USER_URL;

import com.google.gson.Gson;
import java.util.Arrays;
import java.util.List;
import nils.api.ApiService;
import nils.entities.User;

public class UserService {

   private ApiService apiService;

   public UserService() {
      apiService = new ApiService();
   }

   public List<User> listUsers() {
      String response = apiService.get(BASE_URL + USER_URL);
      Gson gson = new Gson();
      User[] users = gson.fromJson(response, User[].class);
      return Arrays.asList(users);
   }
}
