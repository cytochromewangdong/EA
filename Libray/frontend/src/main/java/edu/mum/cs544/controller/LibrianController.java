package edu.mum.cs544.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.mum.cs544.common.domain.Staff;
import edu.mum.cs544.common.dto.IdDto;
import edu.mum.cs544.common.dto.ResultDto;
import edu.mum.cs544.common.dto.UserNamePassword;
import edu.mum.cs544.domain.Test;
import edu.mum.cs544.dto.ListResultDto;
import edu.mum.cs544.dto.SimpleResultDto;
import edu.mum.cs544.repository.TestRepository;
import edu.mum.cs544.service.LibrianService;

@RestController
@RequestMapping("/api/admin/librian")
@PreAuthorize("hasAuthority('admin')")
public class LibrianController {
	@Autowired
	private TestRepository testRepository;

	@Autowired
	private LibrianService librianService;

	@RequestMapping("/test")
	public String test() {
		testRepository.save(new Test("test 111"));
		return "success";
	}

	// res.json({ result: true, data: { items: librianList, total_count: count } });
	@GetMapping
	public ListResultDto<Staff> getAllLibrian(
			@RequestParam(value = "page", required = false, defaultValue = "0") Integer page) {
		return librianService.getAll(page);
	}

	@GetMapping("/{id}")
	public SimpleResultDto<Staff> get(@PathVariable int id) {
		return librianService.getOne(id);
	}
	
	// {
	// "firstname": "Dong",
	// "lastname": "Wang",
	// "email": "wangdongliyanxiang@hotmail.com",
	// "password": "123",
	// "phoneNumber":"123343",
	// "roles":["admin"]
	// }
	@PostMapping
	public ResultDto add(@RequestBody @Valid Staff staff) {
		return IdDto.of(librianService.add(staff));
	}

	// PUT http://localhost:3000/api/admin/librian/5cba8791ae03681c077df6b0 HTTP/1.1
	// content-type: application/json
	// Authorization: Bearer
	// eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJpc3MiOiJzZWN1cmUtYXBpIiwiYXVkIjoic2VjdXJlLWFwcCIsInN1YiI6ImFkbWluIiwiZXhwIjoxNTYxNjU1OTc1LCJyb2xlcyI6WyJhZG1pbiJdLCJ1c2VybmFtZSI6ImFkbWluIiwiaWQiOjJ9.9sXuatGA2DnMh4CFaVUorpeD56nD3ngo_EyGLL_BQ93WmeExv9dwzx2LVAf-wkabn5EgrgZGMrMYL2NZssfXHg
	//
	//
	// {
	// "firstname": "Dong12",
	// "lastname": "Wang3",
	// "email": "wangdongliyanxiang@hotmail.com",
	// "password": "123",
	// "phoneNumber":"7788888",
	// "roles":["admin", "lib"]
	// }
	@PutMapping("/{id}")
	public ResultDto update(@RequestBody @Valid Staff staff, @PathVariable Long id) {
		librianService.update(staff, id);
		return ResultDto.DEFAULT_OK_RESULT;
	}
	
//	router.put('/:id/password', (req, res, next) => {
//	    const id = req.params.id;
//	    bcrypt.hash(req.body.password, 2, function (err, hash) {
//	        Librian.findByIdAndUpdate(id,
//	            {
//	                password: hash
//	            },
//	            { new: true }).then(data => {
//	                const retData = data._doc ? { ...data._doc } : { ...data };
//	                delete retData["password"];
//	                res.json({ result: true, data: retData });
//
//	            }).catch(err => {
//	                res.json({ result: false });
//	            });
//	    });
//
//	});
	@PutMapping("/{id}/password")
	public ResultDto updatePassword(@PathVariable Long id, @RequestBody UserNamePassword usernamePassword) {
		librianService.updatePassword(id, usernamePassword.getPassword());
		return ResultDto.DEFAULT_OK_RESULT;
	}
//
//	router.delete('/:id', (req, res, next) => {
//	    const id = req.params.id;
//	    Librian.findByIdAndUpdate(id,
//	        {
//	            removalFlag:1
//	        },
//	        { new: true }).then(data => {
//	            const retData = data._doc ? { ...data._doc } : { ...data };
//	            delete retData["password"];
//	            res.json({ result: true, data: retData });
//
//	        }).catch(err => {
//	            res.json({ result: false });
//	        });
//
//
//	});
	@DeleteMapping("/{id}")
	public ResultDto deleteUser(@PathVariable Long id) {
		librianService.deleteUser(id);
		return ResultDto.DEFAULT_OK_RESULT;
	}
}
