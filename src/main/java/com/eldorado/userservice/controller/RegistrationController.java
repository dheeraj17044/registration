package com.eldorado.userservice.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.eldorado.userservice.config.LoggingConfig;
import com.eldorado.userservice.constant.Constants;
import com.eldorado.userservice.entities.ConfirmationToken;
import com.eldorado.userservice.entities.User;
import com.eldorado.userservice.repository.ConfirmationTokenRepository;
import com.eldorado.userservice.repository.UserRepository;
import com.eldorado.userservice.service.EmailService;

@RestController
@RequestMapping("/user")
public class RegistrationController {

	@Autowired
	UserRepository userRepo;

	@Autowired
	private ConfirmationTokenRepository confirmationTokenRepository;

	@Autowired
	private EmailService emailService;

	Logger log = LoggingConfig.getLog();

	// Add a new User
	@PostMapping("/register")
	public User addUser(@RequestBody User user) {
		User retUser = userRepo.save(user);
		ConfirmationToken confirmationToken = new ConfirmationToken(user);
        log.info(confirmationToken);
		confirmationTokenRepository.save(confirmationToken);
        
		try {
			SimpleMailMessage mailMessage = new SimpleMailMessage();
			mailMessage.setTo(user.getUsername());

			mailMessage.setSubject("Complete Registration!");
			mailMessage.setText("To confirm your account, please click here : "
					+ "http://localhost:8083/user/confirm-account/" + confirmationToken.getConfirmationToken());

			emailService.sendEmail(mailMessage);
			  log.info(Constants.messageSendSuccess);
		}catch(Exception e) {
			System.out.println(e.toString());
			log.error(e.toString());
		}
		

		return retUser;
	}

	@GetMapping("/confirm-account/{token}")
	public String confirmUserAccount(@PathVariable(value = "token")String confirmationToken) {
		String str;
		try {
			ConfirmationToken token = confirmationTokenRepository.findByConfirmationToken(confirmationToken);
			
			if (token != null) {
	        	User user = userRepo.findByUsernameIgnoreCase(token.getUser().getUsername());
	            user.setIsVerified(1);
				userRepo.save(user);
				str = Constants.confirmUserSuccess;
				log.info(Constants.confirmUserSuccess);
			} else {
				log.error(Constants.confirmUserError);
				str = Constants.confirmUserError;
			}
		} catch (Exception e) {
			System.out.println(e.toString());
			log.error(e.toString());
			str = Constants.failedToRun;
		}
		return str;
	}
	
	@GetMapping("/validUser/{username}")
	public String confirmValidUser(@PathVariable(value="username") String username) {
		String str;
		try {
			User user = userRepo.findByUsernameIgnoreCase(username);
			
			if (user != null) {
	        	if(user.getIsVerified()==0) {
	        		log.info(Constants.notVerified);
					str = Constants.notVerified;
	        	}else {
	        		str = Constants.verified;
					log.info(Constants.verified);
	        	}
			} else {
				log.error(Constants.noUserFound);
				str = Constants.noUserFound;
			}
		} catch (Exception e) {
			System.out.println(e.toString());
			log.error(e.toString());
			str = Constants.failedToRun;
		}
		return str;
	}
}
