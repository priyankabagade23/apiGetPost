package com.priyanka.apiGetPost;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Optional;
import java.sql.*;

@Controller	// This means that this class is a Controller
@RequestMapping(path="/demo") // This means URL's start with /demo (after Application path)
public class MainController {
	@Autowired
	private UserRepository userRepository;

	@PostMapping(path="/add") // Map ONLY POST Requests
	public @ResponseBody void addNewUser (@RequestBody User user) {

		try{
			//Class.forName("com.mysql.jdbc.Driver");
			Connection con= DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/db_example","springuser","ThePassword");

			Statement stmt=con.createStatement();
			stmt.executeUpdate("insert into user values ( '" +user.getEmail()+ "','" +user.getName()+ "'," +user.getId()+")");
//			while(rs.next())
//				System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));

			con.close();
		}catch(Exception e){ System.out.println(e);}

//		userRepository.save(user);

//		return "Saved";
	}

	@GetMapping(path="/getUserById")
	public @ResponseBody Optional<User> getUserById(@RequestParam Integer id) {
		// This returns a JSON or XML with the users
		return userRepository.findById(id);
	}
	@GetMapping(path = "/getAllUsers")
	public @ResponseBody Iterable<User> getAllUsers() {
		return userRepository.findAll();
	}




	@GetMapping(path = "/ping")
	public @ResponseBody String getPing(){return "pong";}
}
