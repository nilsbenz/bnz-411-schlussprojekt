package nils.services;

import java.util.List;
import java.util.Scanner;
import nils.entities.Post;
import nils.entities.User;

public class TextUserInterface {

   private boolean run;

   private UserService userService;
   private PostService postService;
   private CommentService commentService;

   public TextUserInterface() {
      userService = new UserService();
      postService = new PostService();
      commentService = new CommentService();
      run = true;
   }

   public void start() {
      System.out.println("Hallo. Hier kannst du das API JsonPlaceholder testen.");
      while (run) {
         System.out.println("Wähle eine Aktion;");
         System.out.println("11 | Benutzer auflisten");
         System.out.println("12 | Benutzer nach Name filtern");
         System.out.println("21 | Posts auflisten");
         System.out.println("stop | Beenden");
         Scanner scanner = new Scanner(System.in);
         String input = scanner.nextLine();
         switch (input) {
            case "11":
               listUsers();
               break;
            case "12":
               findByName();
               break;
            case "21":
               listPosts();
               break;
            case "stop":
               stop();
               break;
         }
      }
   }

   public void stop() {
      run = false;
   }

   private void listUsers() {
      System.out.println();
      printUsers(userService.listUsers());
   }

   private void findByName() {
      Scanner scanner = new Scanner(System.in);
      System.out.println("Gib einen Teil eines Namens ein:");
      String searchString = scanner.nextLine();
      System.out.println();
      printUsers(userService.findByName(searchString));
   }

   private void listPosts() {
      System.out.println();
      printPosts(postService.listPosts());
   }

   private void printUsers(List<User> users) {
      for (User u : users) {
         System.out.println(u.getName());
         System.out.println(u.getPhone());
         System.out.println(u.getAddress().getStreet());
         System.out.println(u.getAddress().getCity());
         System.out.println();
      }
   }

   private void printPosts(List<Post> posts) {
      for(Post p : posts) {
         System.out.println(p.getTitle());
         System.out.println(p.getBody());
         System.out.println();
      }
   }
}
