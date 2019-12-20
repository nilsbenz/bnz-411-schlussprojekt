package nils.services;

import java.util.List;
import nils.entities.Comment;
import nils.entities.Post;
import nils.entities.User;

class Repository {

   private static List<User> userRepository;
   private static List<Post> postRepository;
   private static List<Comment> commentRepository;

   private Repository() {

   }

   public static List<User> getUserRepository() {
      return userRepository;
   }

   public static void setUserRepository(List<User> userRepository) {
      Repository.userRepository = userRepository;
   }

   public static List<Post> getPostRepository() {
      return postRepository;
   }

   public static void setPostRepository(List<Post> postRepository) {
      Repository.postRepository = postRepository;
   }

   public static List<Comment> getCommentRepository() {
      return commentRepository;
   }

   public static void setCommentRepository(List<Comment> commentRepository) {
      Repository.commentRepository = commentRepository;
   }
}
