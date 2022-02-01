package com.Store.controller.client;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.Store.model.ChitietdonhangDTO;
import com.Store.model.SachDTO;
import com.Store.model.ThanhvienDTO;
import com.Store.service.NhaXuatBanService;
import com.Store.service.NhomMuaSevice;
import com.Store.service.SachService;
import com.Store.service.TheLoaiService;

@Controller
public class HomeController {
	@Autowired
	SachService sachService;
	@Autowired
	TheLoaiService theLoaiService;
	@Autowired
	NhomMuaSevice nhomMuaSevice;
	@Autowired
	NhaXuatBanService nhaXuatBanService;

	@GetMapping(value = "/danh-sach-san-pham")
	public String getListBook(HttpServletRequest req, HttpSession session) {
		// get user in session
		ThanhvienDTO thanhVienDTO = (ThanhvienDTO) session.getAttribute("user");
		if (thanhVienDTO != null)
			req.setAttribute("user", thanhVienDTO);

		// infomations pagination
		int size = 12;
		int totalData = sachService.getAllBook(0, (int) sachService.count()).size();
		int totalPage = totalData < 1 ? 1
				: totalData / size * size < totalData ? totalData / size + 1 : totalData / size;
		int currentPage = req.getParameter("currentPage") == null ? 1
				: Integer.parseInt(req.getParameter("currentPage"));
		currentPage = currentPage < 1 ? 1 : currentPage > totalPage ? totalPage : currentPage;
		int start = (currentPage - 1) * size + 1;
		int end = start + size - 1 < totalData ? start + size - 1 : totalData;

		req.setAttribute("currentPage", currentPage);
		req.setAttribute("totalData", totalData);
		req.setAttribute("totalPage", totalPage);
		req.setAttribute("start", start);
		req.setAttribute("end", end);

		List<SachDTO> books = new ArrayList<SachDTO>();
		for(SachDTO book : sachService.getAllBook(currentPage - 1, size)) {
			if(book.getSoLuongTon() >= 1) {
				books.add(book);
			}
		}

		req.setAttribute("NhomMuas", nhomMuaSevice.getAll());
		req.setAttribute("books", books);

		Set<SachDTO> theloaiSachs = new HashSet<SachDTO>();
		for (SachDTO book : sachService.getAllBook(0, (int) sachService.count())) {
			theloaiSachs.add(book);
		}
		req.setAttribute("theloais", theloaiSachs);
		
		int tongSoLuong = session.getAttribute("tongSoLuong") == null ? 0 : (int) session.getAttribute("tongSoLuong");
		session.setAttribute("tongSoLuong", tongSoLuong);
		return "client/index";
	}

	@GetMapping(value = "/tim-kiem")
	public String search(HttpServletRequest req, HttpSession session) {

		// get user in session
		ThanhvienDTO thanhVienDTO = (ThanhvienDTO) session.getAttribute("user");
		if (thanhVienDTO != null)
			req.setAttribute("user", thanhVienDTO);

		String tensach = req.getParameter("tensach") == null ? "" : req.getParameter("tensach");
		String theloai = req.getParameter("theloai") == null ? "" : req.getParameter("theloai");
		String nhommua = req.getParameter("nhommua") == null ? "" : req.getParameter("nhommua");

		int size = 12;
		int totalData = sachService.search(tensach, theloai, "", nhommua, 0, 1000000, 0, (int) sachService.count())
				.size();
		int totalPage = totalData < 1 ? 1
				: totalData / size * size < totalData ? totalData / size + 1 : totalData / size;

		int currentPage = req.getParameter("currentPage") == null ? 1
				: Integer.parseInt(req.getParameter("currentPage"));
		currentPage = currentPage < 1 ? 1 : currentPage > totalPage ? totalPage : currentPage;

		int start = (currentPage - 1) * size + 1;

		int end = start + size - 1 < totalData ? start + size - 1 : totalData;

		req.setAttribute("tensach", tensach);
		req.setAttribute("theloai", theloai);
		req.setAttribute("nhommua", nhommua);

		req.setAttribute("currentPage", currentPage);
		req.setAttribute("totalData", totalData);
		req.setAttribute("totalPage", totalPage);
		req.setAttribute("start", start);
		req.setAttribute("end", end);

		req.setAttribute("TheLoais", theLoaiService.getAll());
		req.setAttribute("NhomMuas", nhomMuaSevice.getAll());

		List<SachDTO> books = sachService.search(tensach, theloai, "", nhommua, 0, 1000000, currentPage - 1, size);
		Set<SachDTO> theloaiSachs = new HashSet<SachDTO>();
		for (SachDTO book : sachService.getAllBook(0, (int) sachService.count())) {
			theloaiSachs.add(book);
		}
		req.setAttribute("theloais", theloaiSachs);

		req.setAttribute("books", books);
		
		int tongSoLuong = session.getAttribute("tongSoLuong") == null ? 0 : (int) session.getAttribute("tongSoLuong");
		session.setAttribute("tongSoLuong", tongSoLuong);
		return "client/search";
	}

	@GetMapping(value = "/san-pham")
	public String deletesBook(HttpServletRequest req, HttpSession session) {
		// get cart in session
		int masach = req.getParameter("masach") == null ? 0 : Integer.parseInt(req.getParameter("masach"));
		Object cart = session.getAttribute("cart");
		Map<Integer, ChitietdonhangDTO> mapCTDHDTO = (Map<Integer, ChitietdonhangDTO>) cart;
		if(mapCTDHDTO != null) {
			ChitietdonhangDTO CTDHDTO = mapCTDHDTO.get(masach);
			if(CTDHDTO != null)
			req.setAttribute("soLuong", CTDHDTO.getSoLuong());
			else req.setAttribute("soLuong", 1);
		}
		else req.setAttribute("soLuong", 1);
		
		// get user in session
		ThanhvienDTO thanhVienDTO = (ThanhvienDTO) session.getAttribute("user");
		if (thanhVienDTO != null)
			req.setAttribute("user", thanhVienDTO);

		req.setAttribute("NhomMuas", nhomMuaSevice.getAll());
		Set<SachDTO> theloaiSachs = new HashSet<SachDTO>();
		for (SachDTO book : sachService.getAllBook(0, (int) sachService.count())) {
			theloaiSachs.add(book);
		}
		req.setAttribute("theloais", theloaiSachs);
		req.setAttribute("masach", masach);
		req.setAttribute("sach", sachService.getBookById(masach));
		
		int tongSoLuong = session.getAttribute("tongSoLuong") == null ? 0 : (int) session.getAttribute("tongSoLuong");
		session.setAttribute("tongSoLuong", tongSoLuong);
		return "client/details";
	}

	@GetMapping(value = "/download")
	public void download(HttpServletResponse response, @RequestParam("image") String image) {
		final String uploadFolder = ".\\src\\main\\resources\\static\\img\\";
		File file = new File(uploadFolder + File.separator + image);
		if (file.exists()) {
			try {
				Files.copy(file.toPath(), response.getOutputStream());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
