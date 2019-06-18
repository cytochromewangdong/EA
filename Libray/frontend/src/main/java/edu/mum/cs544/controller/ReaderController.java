package edu.mum.cs544.controller;

import java.util.List;

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

import edu.mum.cs544.common.domain.Member;
import edu.mum.cs544.common.dto.IdDto;
import edu.mum.cs544.dto.SimpleResultDto;
import edu.mum.cs544.service.ReaderService;

@RestController
@RequestMapping("/api/admin/reader")
@PreAuthorize("hasAuthority('admin')")
public class ReaderController {

	@Autowired
	private ReaderService readerService;

	// res.json({ result: true, data: { items: librianList, total_count: count } });
	@GetMapping
	public List<Member> getAllLibrian(
			@RequestParam(value = "page", required = false, defaultValue = "0") Integer page) {
		return readerService.getAll(page).getData().getItems();
	}

	@GetMapping("/{id}")
	public SimpleResultDto<Member> get(@PathVariable int id) {
		return readerService.getOne(id);
	}

	// {
	// "firstname": "Dong",
	// "lastname": "Wang",
	// "email": "wangdongliyanxiang@hotmail.com",
	// "password": "123",
	// "phoneNumber":"123343",
	// "roles":["admin"]
	// }
	@PostMapping("/add")
	public Member add(@RequestBody @Valid Member member) {
		return readerService.add(member).getData();
	}

	///api/admin/reader/update/5
	@PutMapping("/update/{id}")
	public Member update(@RequestBody @Valid Member member, @PathVariable Long id) {
		return readerService.update(member, id).getData();
	}

	@DeleteMapping("/delete/{id}")
	public IdDto deleteUser(@PathVariable Long id) {
		readerService.deleteUser(id);
		return IdDto.of(id);
	}
}
