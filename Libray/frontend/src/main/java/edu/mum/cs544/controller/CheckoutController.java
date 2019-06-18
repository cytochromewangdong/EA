package edu.mum.cs544.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import edu.mum.cs544.common.dto.CheckoutDto;
import edu.mum.cs544.common.dto.ResultDto;
import edu.mum.cs544.dto.CheckoutInputDto;
import edu.mum.cs544.dto.SimpleResultDto;
import edu.mum.cs544.rcall.BackEndConstants;

@RestController
@RequestMapping("/api/lib/")
@PreAuthorize("hasAuthority('lib')")
public class CheckoutController {

	@Autowired
	private RestTemplate restTemplate;

	@PostMapping("/checkout")
	public SimpleResultDto<Map<String, Object>> checkout(@RequestBody CheckoutInputDto dto) {
		CheckoutDto result = restTemplate.postForObject(
				BackEndConstants.BACKEND_SERVER + "api/checkout/{readerId}/{bookId}", null, CheckoutDto.class,
				dto.getReaderId(), dto.getBookId());
		Map<String, Object> map = new HashMap<>();
		map.put("due_date", result.getDueDate());

		SimpleResultDto<Map<String, Object>> ret = new SimpleResultDto<>(result.isResult() ? map : null);
		ret.setMessage(result.getMessage());
		return ret;

	}

	@PostMapping("/checkin")
	public ResultDto checkin(@RequestBody CheckoutInputDto dto) {
		ResultDto result = restTemplate.postForObject(BackEndConstants.BACKEND_SERVER + "api/checkin/{bookId}", null,
				ResultDto.class, dto.getBookId());

		return result;

	}
	// router.post('/checkin', (req, res, next) => {
	// // checkoutIn.count({
	// // copyId: req.body.bookId, status: 1
	// // }
	// checkoutIn.findOneAndUpdate({
	// copyId: req.body.bookId, status: 1
	// }, { status: 0 }, (err, doc) => {
	// // console.log(err);
	// // console.log(doc);
	// // console.log(res);
	// if(err)
	// {
	// return next(createError(500, err));
	// }
	// if(!doc)
	// {
	// res.json({ result: false, message: "The book copy is not borrowed by anyone."
	// })
	// } else{
	// res.json({ result: true });
	// }
	// })
	//
	// });
}
