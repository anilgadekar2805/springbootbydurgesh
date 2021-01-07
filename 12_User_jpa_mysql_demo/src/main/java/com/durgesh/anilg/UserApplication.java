package com.durgesh.anilg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.durgesh.anilg.dao.UserRepository;
import com.durgesh.anilg.entity.User;

@SpringBootApplication
public class UserApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(UserApplication.class, args);
	
		UserRepository userRepository = context.getBean(UserRepository.class);
		
		/**
		 * Save Single user
		 * */
//		User user = new User();
//		user.setName("HK product");;
//		user.setAge(22);
//		user.setRole("Full-stack Developer");
//		userRepository.save(user);
//		System.out.println(user);
		
		/**
		 * Now we can do CRUD operation
		 * */
		
		/**
		 * 	1. Create/Insert multiple records
		 * 
		 * */
//		User user1 = new User("Sudhar Sharma", 39, "AngularJS developer");
//		User user2 = new User("Nataraj Raja", 40, "full stack developer");
////		userRepository.saveAll(Arrays.asList(user1, user2));
//			
//		List<User> users = List.of(user1, user2);
//		Iterable<User> saveUsers = userRepository.saveAll(users);
//		saveUsers.forEach(System.out::println);

		/**
		 * 2. Read one/All Records from table
		 * */
		// find user by its ID
//		Optional<User> searchUser = userRepository.findById(4);
//		User userFound1 = searchUser.get();
//		System.out.println(userFound1);
		
			// find All 
		Iterable<User> findAllUser = userRepository.findAll();
//		findAllUser.forEach(new Consumer<User>() {
//			@Override
//			public void accept(User t) {
//				System.out.println(t);
//			}
//		});
		
		//findAllUser.forEach(System.out::println);
		
		/**
		 * 3. Update user
		 * */
		/*
		 * Optional<User> userfind = userRepository.findById(3); User userfind1 =
		 * userfind.get(); userfind1.setName("Mr. "+userfind1.getName());
		 * userRepository.save(userfind1);
		 * System.out.println("updated user details :"+userRepository.findById(3).get())
		 * ;
		 */		
		
		/**
		 * 4. delete records
		 * */
//		userRepository.deleteAll();
//		System.out.println("All records deleted");
//		Iterable<User> findAllUser2 = userRepository.findAll();
//		findAllUser2.forEach(System.out::println);
	
	}

}
