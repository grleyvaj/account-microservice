package com.devsu.account_service.application.controller.account;

import com.devsu.account_service.application.contract.Mapper;
import com.devsu.account_service.application.controller.account.create.AccountCreateRequest;
import com.devsu.account_service.application.controller.account.detail.AccountDetailResponse;
import com.devsu.account_service.application.controller.account.update.AccountUpdateRequest;
import com.devsu.account_service.domain.exception.ResourceNotFoundException;
import com.devsu.account_service.domain.exception.ValidationException;
import com.devsu.account_service.domain.models.AccountInfo;
import com.devsu.account_service.domain.use_cases.account.create.AccountCreateInput;
import com.devsu.account_service.domain.use_cases.account.create.AccountCreateUseCase;
import com.devsu.account_service.domain.use_cases.account.detail.AccountDetailUseCase;
import com.devsu.account_service.domain.use_cases.account.update.AccountUpdateInput;
import com.devsu.account_service.domain.use_cases.account.update.AccountUpdateUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RequiredArgsConstructor
@RestController
@RequestMapping("/accounts")
public class AccountsApiController implements AccountsApi {

	private final AccountCreateUseCase accountCreateUseCase;
	private final AccountDetailUseCase accountDetailUseCase;
	private final AccountUpdateUseCase accountUpdateUseCase;
//	private final AccountReportUseCase accountReportUseCase;
	private final Mapper<AccountCreateRequest, AccountCreateInput> accountCreateInputMapper;
	private final Mapper<AccountInfo, AccountDetailResponse> accountDetailResponseMapper;
	private final Mapper<AccountUpdateRequest, AccountUpdateInput> accountUpdateInputMapper;
//	private final ListMapper<Account, AccountDetailResponse> accountDetailResponseListMapper;

	@Override
	@PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
	public ResponseEntity<AccountDetailResponse> create(
	  @RequestBody @Valid AccountCreateRequest request
	) throws ValidationException, ResourceNotFoundException {

		AccountInfo accountInfo = this.accountCreateUseCase.execute(
		  this.accountCreateInputMapper.map(request)
		);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
		  .path("/{id}")
		  .buildAndExpand(accountInfo.getAccount().getId())
		  .toUri();

		return ResponseEntity.created(uri).body(this.accountDetailResponseMapper.map(accountInfo));
	}

	@Override
	@GetMapping(value = "/{id}", produces = APPLICATION_JSON_VALUE)
	public ResponseEntity<AccountDetailResponse> detail(
	  @PathVariable(value = "id") String id
	) throws ResourceNotFoundException {
		return ResponseEntity.ok(
		  this.accountDetailResponseMapper.map(
			this.accountDetailUseCase.execute(id)
		  )
		);
	}

	@Override
	@PatchMapping(value = "/{id}", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
	public ResponseEntity<AccountDetailResponse> update(
	  @PathVariable(value = "id") String id,
	  @RequestBody @Valid AccountUpdateRequest request
	) throws ResourceNotFoundException, ValidationException {

		return ResponseEntity.ok(
		  this.accountDetailResponseMapper.map(
			this.accountUpdateUseCase.execute(
			  id, this.accountUpdateInputMapper.map(request)
			)
		  )
		);
	}

	/*@Override
	@GetMapping(value = "/complete", produces = APPLICATION_JSON_VALUE)
	public ResponseEntity<AccountReportResponse> getAccountReport(
	  @RequestParam @CustomerExist String customerId,
	  @RequestParam(value = "fromDate", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime fromDate,
	  @RequestParam(value = "toDate", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime toDate
	) {
		List<Account> accounts = this.eventValidationsListUseCase.execute(
		  new ValidationFilterInput()
			.setFromDate(fromDate)
			.setToDate(toDate)
		);

		return ResponseEntity.ok(
		  new AccountReportResponse().setAccounts(
		    this.accountDetailResponseListMapper.map(accounts)
		  )
		);
	}*/

}
