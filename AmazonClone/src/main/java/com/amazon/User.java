package com.amazon;

public class User {
	 private int id;
	    private String name;
	   private String countrycode;
	    private String email;
	    private String mobile;
	    private String  password;
		public int getId() {
			return id;
		}
		
		public String getCountrycode() {
			return countrycode;
		}

		public void setCountrycode(String countrycode) {
			this.countrycode = countrycode;
		}

		public void setId(int id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getMobile() {
			return mobile;
		}
		public void setMobile(String mobile) {
			this.mobile = mobile;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}

		public User(int id, String name, String countrycode, String email, String mobile, String password) {
			super();
			this.id = id;
			this.name = name;
			this.countrycode = countrycode;
			this.email = email;
			this.mobile = mobile;
			this.password = password;
		}
		
	    

}
