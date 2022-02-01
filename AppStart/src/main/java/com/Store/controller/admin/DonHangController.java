package com.Store.controller.admin;

import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Store.model.ChitietdonhangDTO;
import com.Store.model.DonhangDTO;
import com.Store.service.DonHangService;
import com.Store.service.KhachHangService;

@Controller
@RequestMapping(value = "/admin/don-hang")
public class DonHangController {
	@Autowired
	DonHangService donHangService;
	@Autowired
	KhachHangService khachHangService;

	@GetMapping(value = "danh-sach-don-hang")
	public String listUsers(HttpServletRequest req, Model model) throws ParseException {
		// get parameters for search
				String tenkhachhang = req.getParameter("tenkhachhang") == null ? "" : req.getParameter("tenkhachhang");
				String trangthai = req.getParameter("trangthai") == null ? "" : req.getParameter("trangthai");
				String ngaydat = req.getParameter("ngaydat") == null ? "2021-01-01" :
				req.getParameter("ngaydat");
				
				// information of pagination
				int size = 5;
				int totalData = donHangService
						.search(tenkhachhang, trangthai, ngaydat, 0, (int) donHangService.count()).size();
				int totalPage = totalData < 1 ? 1
						: totalData / size * size < totalData ? totalData / size + 1 : totalData / size;
				int currentPage = req.getParameter("currentPage") == null ? 1
						: Integer.parseInt(req.getParameter("currentPage"));
				currentPage = currentPage < 1 ? 1 : currentPage > totalPage ? totalPage : currentPage;
				int start = (currentPage - 1) * size + 1;
				int end = start + size - 1 < totalData ? start + size - 1 : totalData;

				// set Attribute
				req.setAttribute("tenkhachhang", tenkhachhang);
				req.setAttribute("trangthai", trangthai);
				req.setAttribute("ngaydat", ngaydat);
				
				req.setAttribute("currentPage", currentPage);
				req.setAttribute("totalData", totalData);
				req.setAttribute("totalPage", totalPage);
				req.setAttribute("start", start);
				req.setAttribute("end", end);

				List<DonhangDTO> listDonHangs = donHangService
						.search(tenkhachhang, trangthai, ngaydat, currentPage - 1, size);
				/*
				for(DonhangDTO donhang : listDonHangs) {
					System.out.println("Đã thanh toán: "+ donhang.getDaThanhToan());
					System.out.println("Khách hàng: "+ donhang.getKhachHang().getTenKhachHang());
					for(ChitietdonhangDTO CTDH : donhang.getChiTietDonHang()) {
						System.out.println("Chi tiết đơn hàng: "+ CTDH.getMaChiTietDDH() + CTDH.getSoLuong() + CTDH.getTenSach() + CTDH.getDonGia());
					}
					donhang.setTenKhachHang(donhang.getKhachHang().getTenKhachHang());
				}
				*/
				
				model.addAttribute("listDonHangs", listDonHangs);
				return "admin/order/listoders";
	}

	
	@GetMapping(value = "/thong-tin-don-hang/{id}")
	public String detailsUser(HttpServletRequest req, @PathVariable(name = "id") int id) {
		req.setAttribute("donhang", donHangService.getDonHangByID(id));
		req.setAttribute("chitiets", donHangService.getDonHangByID(id).getChiTietDonHang());
		
		for(ChitietdonhangDTO chitiet : donHangService.getDonHangByID(id).getChiTietDonHang()) {
			System.out.println("Tên: "+ chitiet.getTenSach());
			System.out.println("Đơn Giá: "+ chitiet.getDonGia());
			System.out.println("Số lượng: "+ chitiet.getSoLuong());
		}
		return "admin/order/details";
	}

	@GetMapping(value = "/xoa-don-hang/{id}")
	public String deleteUser(HttpServletRequest req, @PathVariable(name = "id") int id) {
		donHangService.deleteDonHang(donHangService.getDonHangByID(id));
		return "redirect:/admin/don-hang/danh-sach-don-hang";
	}
}
