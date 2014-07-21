package ut;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import model.Auther;
import model.Book;
import model.Customer;
import model.Order;
import model.OrderDetail;

import org.junit.Before;
import org.junit.Test;

public class SenarioTestCase {

	@Before
	public void setUp() throws Exception {
	}

	/**
	 * 最初の状態。
	 * シナリオ0. 本を注文する。
	 */
	@Test
	public void 本を注文する() {
		// 顧客の作成
		Customer customer = new Customer("customer1", "hogehoge@gmail.com");
		// 著者の作成
		Auther auther = new Auther();
		auther.setName("Eric Evans");
		List<Auther> autherList = new ArrayList<Auther>();
		autherList.add(auther);
		// 本の作成
		Book book = new Book();
		book.setTitle("Domein-Driven Design");
		book.setPrice(51.21f);
		book.setAutherList(autherList);
		book.setIsbn("978-0321125217");
		// 注文の作成
		Order order = new Order();
		order.setCustomer(customer);
		order.setDate( Calendar.getInstance().getTime() );
		List<OrderDetail> detailList = new ArrayList<OrderDetail>();
		order.setDetailList(detailList);
		// 注文詳細の作成
		OrderDetail od = new OrderDetail();
		od.setAmount(1);
		od.setBook(book);
		od.setOrder(order);

		detailList.add(od);
		order.sumPrice();
		order.setId(1);
		assertEquals(51.21f, order.getTotalFee(), 0);
		assertEquals(book, order.getDetailList().get(0).getBook());
	}
}
