package nils.services;

import java.util.List;
import java.util.Scanner;

import nils.entities.Comment;
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

   //Switch case to let the user select a action
   public void start() {
      System.out.println("Hallo. Hier kannst du das API JsonPlaceholder testen.");
      while (run) {
         System.out.println("Wähle eine Aktion;");
         System.out.println("12 | Benutzer nach Name filtern");
         System.out.println("13 | Benutzer nach Stadt Namen filtern");
         System.out.println("14 | Benutzer nach Firma filtern");
         System.out.println("15 | Post nach Ersteller filtern");
         System.out.println("16 | Comments nach Post filtern");
         System.out.println("17 | Posts auflisten");
         System.out.println("18 | Benutzer auflisten");
         System.out.println("19 | Comments auflisten");
         System.out.println("stop | Beenden");
         Scanner scanner = new Scanner(System.in);
         String input = scanner.nextLine();
         switch (input) {
            case "12":
               findByName();
               break;
            case "13":
               findByCityName();
               break;
            case"14":
               findByCompany();
               break;
            case"15":
               findPostByUser();
               break;
            case "16":
               findCommentsByPost();
               break;
            case "17":
               listPosts();
               break;
            case "18":
               listUsers();
               break;
            case "19":
               listComments();
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

   //Prints all Users
   private void listUsers() {
      System.out.println();
      printUsers(userService.listUsers());
   }

   private void listComments() {
      System.out.println();
      printComments(commentService.listComments());
   }

   //Triggers the findbyname function from the user Service
   private void findByName() {
      Scanner scanner = new Scanner(System.in);
      System.out.println("Gib einen Teil eines Namens ein:");
      String searchString = scanner.nextLine();
      System.out.println();
      printUsers(userService.findByName(searchString));
   }

   //Triggers the findByCompany function from the user Service
   private void findByCompany(){
      Scanner scanner = new Scanner(System.in);
      System.out.println("Gib einen Teil eines Namens ein:");
      String searchString = scanner.nextLine();
      System.out.println();
      printUsers(userService.findByCompany(searchString));
   }

   private void findByCityName() {
      Scanner scanner = new Scanner(System.in);
      System.out.println("Gib einen Teil eines Stadt Namens ein:");
      String searchString = scanner.nextLine();
      System.out.println();
      printUsers(userService.findByCity(searchString));
   }

   private void findPostByUser() {
      Scanner scanner = new Scanner(System.in);
      System.out.println("Gib einen Teil eines Namens ein:");
      String searchString = scanner.nextLine();
      System.out.println();
      printPosts(postService.listPostsByUser(searchString));
   }

   private void findCommentsByPost() {
      Scanner scanner = new Scanner(System.in);
      System.out.println("Gib einen Teil eines Namens ein:");
      String searchString = scanner.nextLine();
      System.out.println();
      printComments(commentService.findCommentsByPost(searchString));
   }

   private void listPosts() {
      System.out.println();
      printPosts(postService.listPosts());
   }

   //Loops trough all the passed user objects and prints the pre selected attribute values
   private void printUsers(List<User> users) {
      for (User u : users) {
         System.out.println(u.getName());
         System.out.println(u.getPhone());
         System.out.println(u.getAddress().getStreet());
         System.out.println(u.getAddress().getCity());
         System.out.println(u.getCompany().getName());
         System.out.println();
      }
   }

   private void printPosts(List<Post> posts) {
      for(Post p : posts) {
         System.out.println("Post-Title ||"+p.getTitle()+"||");
         System.out.println(p.getBody());
         System.out.println();
      }
   }

   private void printComments(List<Comment> comments) {
      for (Comment u : comments) {
         System.out.println("Comment-Title ||"+u.getName()+"||");
         System.out.println(u.getEmail());
         System.out.println(u.getBody());
         System.out.println();
      }
   }
}
