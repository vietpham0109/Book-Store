package com.Store.controller.admin;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.Store.model.SachDTO;
import com.Store.service.NhaXuatBanService;
import com.Store.service.NhomMuaSevice;
import com.Store.service.SachService;
import com.Store.service.TheLoaiService;
import com.Store.validator.SachValidator;

@Controller
@RequestMapping(value = "/admin/san-pham")
public class SachController {

	@Autowired
	private SachService sachService;
	@Autowired
	private TheLoaiService theLoaiService;
	@Autowired
	private NhomMuaSevice nhomMuaSevice;
	@Autowired
	private NhaXuatBanService nhaXuatBanService;
	@Autowired
	private SachValidator sachValidator;

	@GetMapping(value = "/danh-sach-san-pham")
	public String getListBook(HttpServletRequest req) {
		/*
		Principal principal = req.getUserPrincipal();
		ThanhvienDTO tv = new ThanhvienDTO();
		tv = thanhVienService.getThanhVienByUsername(principal.getName());
		*/
		
		
		// get parameters for search
		String tensach = req.getParameter("tensach") == null ? "" : req.getParameter("tensach");
		String theloai = req.getParameter("theloai") == null ? "" : req.getParameter("theloai");
		String nxb = req.getParameter("nxb") == null ? "" : req.getParameter("nxb");
		String nhommua = req.getParameter("nhommua") == null ? "" : req.getParameter("nhommua");

		Long priceStart = (req.getParameter("priceStart") == null || req.getParameter("priceStart") == "") ? 0
				: Long.valueOf(req.getParameter("priceStart"));

		Long priceEnd = (req.getParameter("priceEnd") == null || req.getParameter("priceEnd") == "") ? 100000000
				: Long.valueOf(req.getParameter("priceEnd"));

		// information of pagination
		int size = 5;

		int totalData = sachService
				.search(tensach, theloai, nxb, nhommua, priceStart, priceEnd, 0, (int) sachService.count()).size();

		int totalPage = totalData < 1 ? 1
				: totalData / size * size < totalData ? totalData / size + 1 : totalData / size;

		int currentPage = req.getParameter("currentPage") == null ? 1
				: Integer.parseInt(req.getParameter("currentPage"));
		currentPage = currentPage < 1 ? 1 : currentPage > totalPage ? totalPage : currentPage;

		int start = (currentPage - 1) * size + 1;

		int end = start + size - 1 < totalData ? start + size - 1 : totalData;

		req.setAttribute("tensach", tensach);
		req.setAttribute("theloai", theloai);
		req.setAttribute("nxb", nxb);
		req.setAttribute("nhommua", nhommua);
		req.setAttribute("priceStart", priceStart);
		req.setAttribute("priceEnd", priceEnd);

		req.setAttribute("currentPage", currentPage);
		req.setAttribute("totalData", totalData);
		req.setAttribute("totalPage", totalPage);
		req.setAttribute("start", start);
		req.setAttribute("end", end);

		req.setAttribute("TheLoais", theLoaiService.getAll());
		req.setAttribute("NhomMuas", nhomMuaSevice.getAll());
		req.setAttribute("NhaXuatBans", nhaXuatBanService.getAll());

		/* List<SachDTO> books = sachService.getAllBook(currentPage - 1, size); */

		List<SachDTO> books = sachService.search(tensach, theloai, nxb, nhommua, priceStart, priceEnd, currentPage - 1,
				size);

		req.setAttribute("books", books);
		return "admin/book/listbook";
	}

	@GetMapping(value = "/xoa-san-pham/{bookId}")
	public String deletesBook(HttpServletRequest req, @PathVariable(name = "bookId") int bookId) {
		sachService.deleteBook(sachService.getBookById(bookId));
		return "redirect:/admin/san-pham/danh-sach-san-pham";
	}

	@GetMapping(value = "/them-moi-san-pham")
	public String addBook(HttpServletRequest req, Model model) {

		req.setAttribute("TheLoais", theLoaiService.getAll());
		req.setAttribute("NhomMuas", nhomMuaSevice.getAll());
		req.setAttribute("NhaXuatBans", nhaXuatBanService.getAll());
		model.addAttribute("Sach", new SachDTO());

		return "admin/book/addbook";
	}

	@PostMapping(value = "/them-moi-san-pham")
	public String addBook(HttpServletRequest req, @ModelAttribute("Sach") SachDTO sach, BindingResult bindingResult)
			throws IOException {

		sachValidator.validate(sach, bindingResult);

		/*kiểm tra trên view cái element có tên imagefiles xem đã input chưa?? */
		if (bindingResult.hasErrors()) {
			/* nếu chứ có input */
			req.setAttribute("TheLoais", theLoaiService.getAll());
			req.setAttribute("NhomMuas", nhomMuaSevice.getAll());
			req.setAttribute("NhaXuatBans", nhaXuatBanService.getAll());
			return "admin/book/addbook";
		}
		/* đã có input thì sẽ chạy đến*/
		
		List<String> fileNames = new ArrayList<String>();
		for (MultipartFile file : sach.getImagefiles()) {

			String originalFilename = file.getOriginalFilename();

			int lastIndex = originalFilename.lastIndexOf(".");

			String ext = originalFilename.substring(lastIndex);

			/* không đọc được file ảnh a.png, ...*/
			
			String fileName = System.currentTimeMillis() + ext;

			Path uploadPath = Paths.get(".\\src\\main\\resources\\static\\img\\");

			if (!Files.exists(uploadPath)) {
				Files.createDirectories(uploadPath);
			}

			try (InputStream inputStream = file.getInputStream()) {
				Path filePath = uploadPath.resolve(fileName);

				System.out.println(filePath.toString());
				System.out.println(filePath.toFile().getAbsolutePath());

				Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
			} catch (IOException e) {
				throw new IOException("Could not save upload file: " + fileName);
			}

			fileNames.add(fileName);
		}
		sach.setHinhAnh(fileNames.get(0));
		if (fileNames.size() >= 2)
			sach.setHinhAnh2(fileNames.get(1));
		if (fileNames.size() == 3)
			sach.setHinhAnh3(fileNames.get(2));

		Date dt = new Date();

		sach.setNgayCapNhat(dt);

		sachService.addBook(sach);

		return "redirect:/admin/san-pham/danh-sach-san-pham";
	}

	@GetMapping(value = "/sua-san-pham")
	public String updateBook(HttpServletRequest req, Model model) {

		int maSach = Integer.parseInt(req.getParameter("maSach"));
		SachDTO sach = sachService.getBookById(maSach);

		req.setAttribute("TheLoais", theLoaiService.getAll());
		req.setAttribute("NhomMuas", nhomMuaSevice.getAll());
		req.setAttribute("NhaXuatBans", nhaXuatBanService.getAll());
		model.addAttribute("Sach", sach);

		return "admin/book/updatebook";
	}

	@PostMapping(value = "/sua-san-pham")
	public String updateBook(HttpServletRequest req, @ModelAttribute("Sach") SachDTO sach, BindingResult bindingResult)
			throws IOException {
		sachValidator.validate(sach, bindingResult);
		if (bindingResult.hasErrors()) {
			req.setAttribute("TheLoais", theLoaiService.getAll());
			req.setAttribute("NhomMuas", nhomMuaSevice.getAll());
			req.setAttribute("NhaXuatBans", nhaXuatBanService.getAll());
			return "admin/book/updatebook";
		}
		if (sach.getImagefiles().get(0).getOriginalFilename() != "") {
			List<String> fileNames = new ArrayList<String>();

			for (MultipartFile file : sach.getImagefiles()) {

				String originalFilename = file.getOriginalFilename();

				int lastIndex = originalFilename.lastIndexOf(".");

				String ext = originalFilename.substring(lastIndex);

				String fileName = System.currentTimeMillis() + ext;

				Path uploadPath = Paths.get(".\\src\\main\\resources\\static\\img\\");

				if (!Files.exists(uploadPath)) {
					Files.createDirectories(uploadPath);
				}

				try (InputStream inputStream = file.getInputStream()) {
					Path filePath = uploadPath.resolve(fileName);

					System.out.println(filePath.toString());
					System.out.println(filePath.toFile().getAbsolutePath());

					Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
				} catch (IOException e) {
					throw new IOException("Could not save upload file: " + fileName);
				}

				fileNames.add(fileName);
			}
			sach.setHinhAnh(fileNames.get(0));
			if (fileNames.size() >= 2)
				sach.setHinhAnh2(fileNames.get(1));
			if (fileNames.size() == 3)
				sach.setHinhAnh3(fileNames.get(2));
		}
		Date dt = new Date();

		sach.setNgayCapNhat(dt);

		sachService.updateBook(sach);

		return "redirect:/admin/san-pham/danh-sach-san-pham";
	}

}
