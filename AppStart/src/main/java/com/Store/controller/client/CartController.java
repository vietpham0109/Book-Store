package com.Store.controller.client;

import java.text.NumberFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Store.model.ChitietdonhangDTO;
import com.Store.model.DonhangDTO;
import com.Store.model.KhachhangDTO;
import com.Store.model.SachDTO;
import com.Store.service.ChiTietDonHangService;
import com.Store.service.DonHangService;
import com.Store.service.KhachHangService;
import com.Store.service.NhomMuaSevice;
import com.Store.service.SachService;
import com.Store.service.TheLoaiService;
import com.Store.validator.KhachHangValidator;

@Controller
public class CartController {
	@Autowired
	KhachHangService khachHangService;
	@Autowired
	DonHangService donHangService;
	@Autowired
	ChiTietDonHangService chiTietDonHangService;
	@Autowired
	SachService sachService;
	@Autowired
	KhachHangValidator khachHangValidator;
	@Autowired
	TheLoaiService theLoaiService;
	@Autowired
	NhomMuaSevice nhomMuaSevice;

	@GetMapping(value = "/them-san-pham")
	public String addToCart(HttpServletRequest req, HttpSession session, @RequestParam(name = "maSach") int maSach,
			@RequestParam(name = "soLuong") int soLuong) {
		int tongSoLuong = session.getAttribute("tongSoLuong") == null ? 0 : (int) session.getAttribute("tongSoLuong");
		long tongTien = session.getAttribute("tongTien") == null ? 0 : (long) session.getAttribute("tongTien");
		SachDTO sachDTO = sachService.getBookById(maSach);
		soLuong = soLuong < 1 ? 1 : soLuong;

		Object cart = session.getAttribute("cart");
		if (cart == null) { // nếu giỏ hàng chưa tồn tại
			ChitietdonhangDTO CTDHDTO = new ChitietdonhangDTO();
			CTDHDTO.setSach(sachDTO);
			CTDHDTO.setSoLuong(soLuong <= sachDTO.getSoLuongTon() ? soLuong : sachDTO.getSoLuongTon());
			CTDHDTO.setTenSach(sachDTO.getTenSach());
			CTDHDTO.setDonGia(sachDTO.getDonGia());
			CTDHDTO.setDonGiaS(formatAmount(sachDTO.getDonGia()));
			CTDHDTO.getSach().setHinhAnh(sachDTO.getHinhAnh());
			tongSoLuong += CTDHDTO.getSoLuong();
			tongTien += CTDHDTO.getDonGia() * CTDHDTO.getSoLuong();
			Map<Integer, ChitietdonhangDTO> mapCTDHDTO = new HashMap<>();
			mapCTDHDTO.put(maSach, CTDHDTO);
			session.setAttribute("cart", mapCTDHDTO);
		} else { // nếu sản phẩm chưa có trong giỏ hàng
			Map<Integer, ChitietdonhangDTO> mapCTDHDTO = (Map<Integer, ChitietdonhangDTO>) cart;
			ChitietdonhangDTO CTDHDTO = mapCTDHDTO.get(maSach);
			if (CTDHDTO == null) {
				CTDHDTO = new ChitietdonhangDTO();
				CTDHDTO.setSach(sachDTO);
				CTDHDTO.setSoLuong(soLuong);
				CTDHDTO.setTenSach(sachDTO.getTenSach());
				CTDHDTO.setDonGia(sachDTO.getDonGia());
				CTDHDTO.setDonGiaS(formatAmount(sachDTO.getDonGia()));
				CTDHDTO.getSach().setHinhAnh(sachDTO.getHinhAnh());
				tongSoLuong += CTDHDTO.getSoLuong();
				tongTien += CTDHDTO.getDonGia() * CTDHDTO.getSoLuong();
				mapCTDHDTO.put(maSach, CTDHDTO);
			} else { // nếu sản phẩm đã có trong giỏ hàng
				if ((soLuong) <= sachDTO.getSoLuongTon()) {
					tongSoLuong = tongSoLuong - CTDHDTO.getSoLuong() + soLuong;
					tongTien -= CTDHDTO.getDonGia() * CTDHDTO.getSoLuong();
					CTDHDTO.setSoLuong(soLuong);
					tongTien += CTDHDTO.getDonGia() * CTDHDTO.getSoLuong();
				} else {
					tongSoLuong = tongSoLuong - CTDHDTO.getSoLuong() + sachDTO.getSoLuongTon();
					tongTien -= CTDHDTO.getDonGia() * CTDHDTO.getSoLuong();
					CTDHDTO.setSoLuong(sachDTO.getSoLuongTon());
					tongTien += CTDHDTO.getDonGia() * CTDHDTO.getSoLuong();
				}
			}
			session.setAttribute("cart", mapCTDHDTO);
		}

		session.setAttribute("tongSoLuong", tongSoLuong);
		session.setAttribute("tongTien", tongTien);
		session.setAttribute("tongTienS", formatAmount(tongTien));
		return "redirect:/gio-hang";
	}

	@GetMapping(value = "/xoa-san-pham")
	public String Deletefromtocart(HttpServletRequest req,
			@RequestParam(name = "maSach", required = true) Integer maSach) {
		HttpSession session = req.getSession();
		Object cart = session.getAttribute("cart");
		if (cart != null) {
			int tongSoLuong = (int) session.getAttribute("tongSoLuong");
			long tongTien = (long) session.getAttribute("tongTien");
			Map<Integer, ChitietdonhangDTO> mapCTDHDTO = (Map<Integer, ChitietdonhangDTO>) cart;

			tongSoLuong -= mapCTDHDTO.get(maSach).getSoLuong();
			tongTien -= mapCTDHDTO.get(maSach).getDonGia() * mapCTDHDTO.get(maSach).getSoLuong();
			mapCTDHDTO.remove(maSach);

			session.setAttribute("tongSoLuong", tongSoLuong);
			session.setAttribute("tongTien", tongTien);
			session.setAttribute("tongTienS", formatAmount(tongTien));
			session.setAttribute("cart", mapCTDHDTO);
		}
		return "redirect:/gio-hang";
	}

	@GetMapping(value = "/gio-hang")
	public String addOrder(HttpServletRequest req, Model model) {
		req.setAttribute("NhomMuas", nhomMuaSevice.getAll());

		Set<SachDTO> theloaiSachs = new HashSet<SachDTO>();
		for (SachDTO book : sachService.getAllBook(0, (int) sachService.count())) {
			theloaiSachs.add(book);
		}
		req.setAttribute("theloais", theloaiSachs);

		model.addAttribute("Khachang", new KhachhangDTO());
		return "client/cart";
	}

	@PostMapping(value = "/gio-hang")
	public String addOrder(HttpServletRequest req, HttpSession session,
			@ModelAttribute("Khachang") KhachhangDTO khachhang, BindingResult bindingResult) {
		req.setAttribute("NhomMuas", nhomMuaSevice.getAll());

		Set<SachDTO> theloaiSachs = new HashSet<SachDTO>();
		for (SachDTO book : sachService.getAllBook(0, (int) sachService.count())) {
			theloaiSachs.add(book);
		}

		Object cart = session.getAttribute("cart");

		if (cart != null) {
			if (khachHangService.search(khachhang.getTenKhachHang(), khachhang.getSoDienThoai(),
					khachhang.getEmail()) == null) {
				// validate khachhang
				khachHangValidator.validate(khachhang, bindingResult);
				if (bindingResult.hasErrors()) {
					return "client/cart";
				}
				khachHangService.addKhachHang(khachhang);
			}

			KhachhangDTO khachHangDTO = khachHangService.search(khachhang.getTenKhachHang(), khachhang.getSoDienThoai(),
					khachhang.getEmail());
			System.out.println("Mã khách hàng: " + khachHangDTO.getMaKhachHang());
			Map<Integer, ChitietdonhangDTO> mapCTDHDTO = (Map<Integer, ChitietdonhangDTO>) cart;
			DonhangDTO donHangDTO = new DonhangDTO();
			donHangDTO.setKhachHang(khachHangDTO);
			donHangDTO.setDaThanhToan(false);
			donHangDTO.setNgayDat(new Date());
			// donHangDTO.setNgayGiao(null);
			donHangDTO.setTinhTrangGiaoHang("Đang giao hàng");
			donHangService.addDonHang(donHangDTO);

			DonhangDTO donhang = donHangService.getLastDonHang();
			for (Entry<Integer, ChitietdonhangDTO> entry : mapCTDHDTO.entrySet()) {
				ChitietdonhangDTO chitietdonhangDTO = entry.getValue();
				chitietdonhangDTO.setDonHang(donhang);

				chiTietDonHangService.addCTDH(chitietdonhangDTO);

				// update số lượng sách sau khi đặt đơn hàng thành công
				SachDTO sachDTO = sachService.getBookById(entry.getValue().getSach().getMaSach());
				sachDTO.setSoLuongTon(sachDTO.getSoLuongTon() - chitietdonhangDTO.getSoLuong());
				sachDTO.setSoLuongMua(sachDTO.getSoLuongMua() + chitietdonhangDTO.getSoLuong());
				sachService.updateBook(sachDTO);
			}
			session.setAttribute("Khachhang", khachHangDTO);
		}
		session.removeAttribute("cart");
		session.setAttribute("tongSoLuong", 0);
		session.removeAttribute("tongTien");
		session.removeAttribute("tongTienS");
		return "redirect:/gio-hang";
	}

	public String formatAmount(long amount) {
		Locale vn = new Locale("vn", "VN");
		NumberFormat dollarFormat = NumberFormat.getCurrencyInstance(vn);
		return dollarFormat.format(amount).substring(2);
	}
}
