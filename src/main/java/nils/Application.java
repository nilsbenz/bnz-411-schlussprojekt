package nils;

import nils.entities.User;
import nils.services.UserService;

public class Application {

   public static void main(String[] args) {

      UserService userService = new UserService();

      for (User u : userService.listUsers()) {
         System.out.println(u.getName());
         System.out.println(u.getPhone());
         System.out.println(u.getAddress().getStreet());
         System.out.println(u.getAddress().getCity());
         System.out.println();
      }
   }
}
