package com.Store.controller;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Store.model.ThanhvienDTO;
import com.Store.service.ThanhVienService;

@Controller
public class LoginController {
	@Autowired
	ThanhVienService thanhVienService;

	@GetMapping(value = "/dang-nhap")
	public String login(HttpServletRequest request, @RequestParam(name = "error", required = false) String error,
			HttpSession session) {
		if (error != null) {
			request.setAttribute("error", error);
		}
		if (request.getUserPrincipal() != null) {
			Principal principal = request.getUserPrincipal();
			ThanhvienDTO user = new ThanhvienDTO();
			user = thanhVienService.getThanhVienByUsername(principal.getName());
			session.setAttribute("user", user);
		}
		return "redirect:/danh-sach-san-pham";
	}

	@RequestMapping("/default")
	public String defaultAfterLogin(HttpServletRequest request, HttpSession session) {
		if(session.getAttribute("user") == null) {
			Principal principal = request.getUserPrincipal();
			ThanhvienDTO user = new ThanhvienDTO();
			user = thanhVienService.getThanhVienByUsername(principal.getName());
			session.setAttribute("user", user);
		}
		if (request.isUserInRole("ROLE_ADMIN")) {
			return "redirect:/admin/san-pham/danh-sach-san-pham";
		}
		return "redirect:/danh-sach-san-pham";
	}

	@PostMapping(value = "/logout")
	public String login(HttpServletRequest request, HttpSession session) {
		session.setAttribute("user", null);
		return "redirect:/danh-sach-san-pham";
	}
}
