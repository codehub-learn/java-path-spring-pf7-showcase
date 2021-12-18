package gr.codelearn.spring.showcase.app.controller;

import gr.codelearn.spring.showcase.app.domain.Order;
import gr.codelearn.spring.showcase.app.service.BaseService;
import gr.codelearn.spring.showcase.app.service.OrderService;
import gr.codelearn.spring.showcase.app.transfer.ApiResponse;
import gr.codelearn.spring.showcase.app.transfer.KeyValue;
import gr.codelearn.spring.showcase.app.transfer.PurchasesAndCostPerCustomerCategoryDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/orders")
public class OrderController extends AbstractController<Order> {
	private final OrderService orderService;

	@Override
	protected BaseService<Order, Long> getBaseService() {
		return orderService;
	}

	@GetMapping(headers = "a=findAverageOrderCostPerCustomer")
	public ResponseEntity<ApiResponse<List<KeyValue<String, BigDecimal>>>> findAverageOrderCostPerCustomer() {
		return ResponseEntity.ok(ApiResponse.<List<KeyValue<String, BigDecimal>>>builder()
											.data(orderService.findAverageOrderCostPerCustomer()).build());
	}

	@GetMapping(headers = "a=findTotalNumberAndCostOfPurchasesPerCustomerCategory")
	public ResponseEntity<ApiResponse<List<PurchasesAndCostPerCustomerCategoryDto>>> findTotalNumberAndCostOfPurchasesPerCustomerCategory() {
		return ResponseEntity.ok(ApiResponse.<List<PurchasesAndCostPerCustomerCategoryDto>>builder()
											.data(orderService.findTotalNumberAndCostOfPurchasesPerCustomerCategory())
											.build());
	}
}
