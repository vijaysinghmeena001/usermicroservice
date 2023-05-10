package com.vijay.user.UserService;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.vijay.user.UserEntity.User;
import com.vijay.user.UserRepository.UserRepo;

@Service
public class UserService {
	
	@Autowired
	private UserRepo userrepo;
	
	@Autowired
	private RestTemplate resttemplate; 
	
	private Logger logger =LoggerFactory.getLogger(UserService.class);
	
	public List<User> getAllUserList() {
		// TODO Auto-generated method stub
		return userrepo.findAll();
	}

	public User getUserdetails(int id) throws NullPointerException {
		// TODO Auto-generated method stub
	String userRating=resttemplate.getForObject("http://localhost:8080/getuser/153",String.class);
//	RatingEntity rt=ratingservice.getrating(id);
	User user=userrepo.findById(id).orElseThrow(()-> new NullPointerException());
	logger.info("{} ",userRating);
	if(userRating!=null) {
		try {
		logger.info("{} ",userRating);
//		user.setRatings(userRating);
		}
		catch (NullPointerException e) {
			System.out.println(e);
			// TODO: handle exception
		}
	}
		return user;
	}

	public User saveUserdetails(User user) {
		// TODO Auto-generated method stub
		return userrepo.save(user);
	}

	public User updateUserdetail(User user,int id) throws NullPointerException {
		// TODO Auto-generated method stub
		System.out.println(id);
		if(user==null) {
			throw new NullPointerException("User does not exists");
		}
		Optional<User> userhistory=userrepo.findById(id);
		if(!userhistory.isPresent()) {
			throw new NullPointerException("User with id : "+ id+ " Does not exists :");
		}
		User newrecord=userhistory.get();
		newrecord.setFirstname(user.getFirstname());
		newrecord.setLastname(user.getLastname());
		newrecord.setMiddlename(user.getMiddlename());
		newrecord.setMobno(user.getMobno());
		newrecord.setEmail(user.getEmail());		
		return userrepo.save(newrecord);
	}

	
	
	
}
