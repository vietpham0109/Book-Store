package com.Store.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.Store.entity.Khachhang;

@Component
public class KhachHangValidator implements Validator {
	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return Khachhang.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// validate
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "tenKhachHang", "input.require");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "diaChi", "input.require");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "input.require");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "soDienThoai", "input.require");
	}
}
