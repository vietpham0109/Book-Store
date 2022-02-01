package com.Store.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.springframework.web.multipart.MultipartFile;

import com.Store.entity.Sach;
import com.Store.model.SachDTO;

@Component
public class SachValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return Sach.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		SachDTO sach = (SachDTO) target;
		
		// validate cho tên sách
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "tenSach", "input.require");
		
		// validate cho imagefiles của sachDTO <=> hinhAnh của sach trong entity
		if (sach.getHinhAnh() == null) {
			
			for (MultipartFile file : sach.getImagefiles()) {
				if (file.isEmpty()) {
					errors.rejectValue("imagefiles", "input.img.require");
					break;
				}
			}
		}
		if (sach.getDonGia() < 0) errors.rejectValue("donGia","input.price");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "moTa", "input.require");
		if (sach.getSoLuongTon() < 0) errors.rejectValue("soLuongTon","input.quantity");
	}

}
