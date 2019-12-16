package nils.entities;

public class User {

   private String id;
   private String name;
   private String username;
   private Address address;
   private String phone;
   private String website;
   private Company company;

   public User() {
   }

   public User(String id, String name, String username, Address address, String phone, String website, Company company) {
      this.id = id;
      this.name = name;
      this.username = username;
      this.address = address;
      this.phone = phone;
      this.website = website;
      this.company = company;
   }

   public String getId() {
      return id;
   }

   public void setId(String id) {
      this.id = id;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getUsername() {
      return username;
   }

   public void setUsername(String username) {
      this.username = username;
   }

   public Address getAddress() {
      return address;
   }

   public void setAddress(Address address) {
      this.address = address;
   }

   public String getPhone() {
      return phone;
   }

   public void setPhone(String phone) {
      this.phone = phone;
   }

   public String getWebsite() {
      return website;
   }

   public void setWebsite(String website) {
      this.website = website;
   }

   public Company getCompany() {
      return company;
   }

   public void setCompany(Company company) {
      this.company = company;
   }
}
