package com.controller;

import com.DTO.AccountDTO;
import com.service.AccountService;
import com.utils.Convert;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/v1")
@CrossOrigin("*")
@RequiredArgsConstructor
public class AccountController {
	private final AccountService accountService;

	@GetMapping("/accounts")
	public ResponseEntity<?> fetchData(){
		return ResponseEntity.ok(accountService.findAll());
	}
	@PostMapping("/accounts")
	public ResponseEntity<?> insert(@RequestBody AccountDTO accountDTO){
		if (accountService.findById(accountDTO.getUsername())!=null)
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Account already exits");
		else return ResponseEntity.ok(accountService.create(accountDTO));
	}
	@PutMapping("/accounts")
	public ResponseEntity<?> update(@RequestBody AccountDTO accountDTO){
		if (accountService.findById(accountDTO.getUsername())==null) return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Account not found");
		else {
			return ResponseEntity.ok(accountService.update(accountDTO));
		}
	}
	@PutMapping("/accounts/update-password")
	public ResponseEntity<?> updatePassword(@RequestBody NewPassword input){
		AccountDTO accountDTO = accountService.findById(input.getUsername());
		if (accountDTO==null ) return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Account not found");
		else {
			if (accountDTO.getPassword().equals(input.getOld_password())) {
				accountDTO.setPassword(input.getNew_password());
				return ResponseEntity.ok("Update password successfully!");
			}
			else
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Password error!");
		}
	}
	

}
@Data
class NewPassword{
    private String username;
    private String old_password;
    private String new_password;
}
