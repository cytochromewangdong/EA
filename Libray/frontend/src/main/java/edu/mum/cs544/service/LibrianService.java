package edu.mum.cs544.service;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import edu.mum.cs544.common.Constants;
import edu.mum.cs544.common.domain.Staff;
import edu.mum.cs544.common.service.base.BaseService;
import edu.mum.cs544.dto.ListResultDto;
import edu.mum.cs544.dto.SimpleResultDto;
import edu.mum.cs544.dto.base.DataPart;

@Service
@Transactional
public class LibrianService extends BaseService {
	public ListResultDto<Staff> getAll(int page) {
		Page<Staff> pageItem = staffRepository.findByRemovalFlagOrderByModifyDate(0,
				PageRequest.of(page, Constants.PAGE_SIZE));
		return new ListResultDto<>(new DataPart<>(pageItem.getContent(), pageItem.getTotalElements()));
	}

	public Long add(Staff staff) {
		staff.setPassword(bCryptPasswordEncoder.encode(staff.getPassword()));
		staffRepository.save(staff);
		return staff.getId();
	}

	public void update(Staff staff, Long id) {
		Staff oldStaff = staffRepository.getOne(id);
		// firstname: req.body.firstname,
		// lastname: req.body.lastname,
		// phoneNumber: req.body.phoneNumber,
		// roles: req.body.roles
		oldStaff.setFirstname(staff.getFirstname());
		oldStaff.setLastname(staff.getLastname());
		oldStaff.setPhoneNumber(staff.getPhoneNumber());
		oldStaff.setRoleList(staff.getRoleList());
	}

	public SimpleResultDto<Staff> getOne(long id) {
		return new SimpleResultDto<>(staffRepository.findById(id).get());
	}

	public void updatePassword(Long id, String password) {
		Staff staff = staffRepository.getOne(id);
		staff.setPassword(bCryptPasswordEncoder.encode(password));

	}

	public void deleteUser(Long id) {
		Staff staff = staffRepository.getOne(id);
		staff.setRemovalFlag(1);
	}
}
