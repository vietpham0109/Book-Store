
package com.Store.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Store.entity.Thanhvien;
import com.Store.entity.Vaitro;
import com.Store.repository.ThanhVienRepository;
import com.Store.service.ThanhVienService;

@Service
@Transactional
public class LoginServiceImpl implements UserDetailsService {
	@Autowired
	ThanhVienRepository thanhVienRepository;
	@Autowired
	ThanhVienService thanhVienService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Thanhvien thanhVien = thanhVienRepository.getByUsername(username);
		if (thanhVien == null) {
			throw new UsernameNotFoundException("Account " + username + " does not exist");
		}
		List<String> roles = new ArrayList<String>();
		for (Vaitro vaiTro : thanhVien.getLoaithanhvien().getVaitros()) {
			roles.add(vaiTro.getTenVaiTro());
			System.out.println("ROLE: " + vaiTro.getTenVaiTro());
		}

		List<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
		for (String role : roles) {
			authorities.add(new SimpleGrantedAuthority(role));
		}

		UserDetails details = new User(thanhVien.getTaiKhoan(), thanhVien.getMatKhau(), authorities);
		return details;
	}

}
