package ut;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import model.Customer;
import model.Item;
import model.ItemType;
import model.Order;
import model.OrderDetail;
import model.Property;

import org.junit.Before;
import org.junit.Test;

public class SenarioTestCase {

	@Before
	public void setUp() throws Exception {
	}

	/**
	 * 最初の状態。
	 * シナリオ0. 本を注文する。
	 * （シナリオ2に合わせて変更済み）
	 */
	@Test
	public void 本を注文するテスト() {
		// 顧客の作成
		Customer customer = new Customer("customer1", "hogehoge@gmail.com");
		// 商品の種類として本を作成
		ItemType typeBook = new ItemType("book");
		// DDD本を作成
		Item ddd = new Item();
		ddd.setItemType(typeBook);
		ddd.setPrice(51.21f);
		List<Property> propertyList = new ArrayList<Property>();
		propertyList.add(new Property("title", "Domein-Driven Design"));
		propertyList.add(new Property("isbn", "978-0321125217"));
		propertyList.add(new Property("auther", "Eric Evans"));
		ddd.setPropertyList(propertyList);
		// 注文の作成
		Order order = new Order();
		order.setCustomer(customer);
		order.setDate( Calendar.getInstance().getTime() );
		List<OrderDetail> detailList = new ArrayList<OrderDetail>();
		order.setDetailList(detailList);
		// 注文詳細の作成
		OrderDetail od = new OrderDetail();
		od.setAmount(1);
		od.setItem(ddd);
		od.setOrder(order);

		detailList.add(od);
		order.sumPrice();
		order.setId(1);

		assertEquals(51.21f, order.getTotalFee(), 0);
		assertEquals(ddd, order.getDetailList().get(0).getItem());
	}

	/**
	 * シナリオ1. CDを注文する。
	 * （シナリオ2に合わせて変更済み）
	 */
	@Test
	public void CDを注文するテスト() {
		// 顧客の作成
		Customer customer = new Customer("customer1", "hogehoge@gmail.com");
		// CDの作成
		ItemType typeCD = new ItemType("CD");
		Item gipsyKingsBest = new Item();
		gipsyKingsBest.setPrice(1728f);
		List<Property> plist = new ArrayList<Property>();
		plist.add(new Property("title", "The Very Best Of Gispsy Kings"));
		plist.add(new Property("jancode", "************"));
		plist.add(new Property("artist", "Gipsy Kings"));
		gipsyKingsBest.setPropertyList(plist);
		// 注文の作成
		Order order = new Order();
		order.setCustomer(customer);
		order.setDate( Calendar.getInstance().getTime() );
		List<OrderDetail> detailList = new ArrayList<OrderDetail>();
		order.setDetailList(detailList);
		// 注文詳細の作成
		OrderDetail od = new OrderDetail();
		od.setAmount(1);
		od.setItem(gipsyKingsBest);
		od.setOrder(order);

		detailList.add(od);
		order.sumPrice();
		order.setId(1);

		// 注文の合計金額をチェック
		assertEquals(1728f, order.getTotalFee(), 0);

		// オーダーがCDのみであるのをチェック
		assertEquals(1, order.getDetailList().size() );
		assertEquals(gipsyKingsBest, order.getDetailList().get(0).getItem() );
	}

	/**
	 * シナリオ2. あらゆる商品を注文できるようにする
	 *    新たな商品の種類の追加が楽になるようにする。
	 */
	@Test
	public void シナリオ2のテスト(){
		// 商品の種類として本を作成
		ItemType typeBook = new ItemType("book");
		// DDD本を作成
		Item ddd = new Item();
		ddd.setItemType(typeBook);
		ddd.setPrice(51.21f);
		List<Property> propertyList = new ArrayList<Property>();
		propertyList.add( new Property("title", "Domein-Driven Design"));
		propertyList.add(new Property("isbn", "978-0321125217"));
		ddd.setPropertyList(propertyList);

		// dddの商品種別をチェック
		assertEquals(typeBook, ddd.getItemType());

		// 商品の種類として文具を作成
		ItemType typeStationery = new ItemType("stationery");
		// POSCAみどりを作成
		Item poscaGreen = new Item();
		poscaGreen.setItemType(typeStationery);
		poscaGreen.setPrice(0.98f);
		List<Property> plist = new ArrayList<Property>();
		plist.add(new Property("name", "POSCA<Green>"));
		plist.add(new Property("color", "GREEN"));
		poscaGreen.setPropertyList(plist);

		// poscaGreenの商品種別をチェック
		assertEquals(typeStationery, poscaGreen.getItemType());

		// 顧客の作成
		Customer customer = new Customer("John Doe", "john-doe@gamil.com");

		// 注文の作成
		Order order = new Order();
		order.setCustomer(customer);
		order.setDate( Calendar.getInstance().getTime() );
		List<OrderDetail> detailList = new ArrayList<OrderDetail>();
		order.setDetailList(detailList);
		// DDD本を注文
		OrderDetail od_ddd = new OrderDetail();
		od_ddd.setAmount(1);
		od_ddd.setItem(ddd);
		od_ddd.setOrder(order);
		detailList.add(od_ddd);
		order.sumPrice();
		// ポスカを２本注文
		OrderDetail od_posca = new OrderDetail();
		od_posca.setAmount(2);
		od_posca.setItem(poscaGreen);
		od_posca.setOrder(order);
		detailList.add(od_posca);
		order.sumPrice();
		order.setId(1);


		// 注文した数のチェック
		assertEquals(3, order.count() );

		// 注文の合計金額をチェック
		assertEquals(53.17f, order.getTotalFee(), 0);
	}
}
