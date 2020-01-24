package nils.services;

import static nils.api.Paths.BASE_URL;
import static nils.api.Paths.USER_URL;

import com.google.gson.Gson;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import nils.api.ApiService;
import nils.entities.User;

public class UserService {

   private ApiService apiService;

   public UserService() {
      apiService = new ApiService();
      loadUsers();
   }

   /**
    * List all users.
    *
    * @return List of users
    */
   public List<User> listUsers() {
      return Repository.getUserRepository();
   }

   /**
    * Filter users by name. Returns all users which names start with given search string.
    *
    * @param name Search string
    * @return List of users
    */
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

   public List<User> findByCity(String cityname) {
      return Repository.getUserRepository().stream()
              .filter(user -> {
                 for (String namePart : user.getAddress().getCity().split(" ")) {
                    if (namePart.toUpperCase().startsWith(cityname.toUpperCase())) {
                       return true;
                    }
                 }
                 return false;
              }).collect(Collectors.toList());
   }

    public List<User> findByCompany(String companyname) {
        return Repository.getUserRepository().stream()
                .filter(user -> {
                    for (String namePart : user.getCompany().getName().split(" ")) {
                        if (companyname.toUpperCase().startsWith(namePart.toUpperCase())) {
                            return true;
                        }
                    }
                    return false;
                }).collect(Collectors.toList());
    }

   private void loadUsers() {
      String response = apiService.get(BASE_URL + USER_URL);
      Gson gson = new Gson();
      User[] users = gson.fromJson(response, User[].class);
      Repository.setUserRepository(Arrays.asList(users));
   }


}
