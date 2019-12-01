package com.org.employee.feign;

import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.org.employee.domain.Address;

@FeignClient("org-address")
public interface AddressControllerProxy {
	@GetMapping("address/getAddress")
	public Optional<Address> getAddressById(@RequestParam String id);
}
