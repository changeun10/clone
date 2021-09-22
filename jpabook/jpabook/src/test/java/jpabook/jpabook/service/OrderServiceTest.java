package jpabook.jpabook.service;

import jpabook.jpabook.domain.Address;
import jpabook.jpabook.domain.Member;

import jpabook.jpabook.domain.Order;
import jpabook.jpabook.domain.OrderStatus;
import jpabook.jpabook.domain.item.Book;
import jpabook.jpabook.exception.NotEnoughStockException;
import jpabook.jpabook.repository.OrderRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class OrderServiceTest {

    @Autowired EntityManager em;
    @Autowired OrderService orderService;
    @Autowired OrderRepository orderRepository;
    @Test
    public void 상품주문() throws Exception {
        Member member = new Member();
        member.setName("회원1");
        member.setAddress(new Address("서울","강가","123"));
        em.persist(member);

        Book book = new Book();
        book.setName("jpa");
        book.setPrice(10000);
        book.setStockQuantity(10);
        em.persist(book);

        //when
        Long orderId = orderService.order(member.getId(), book.getId(), 2);

        //then
        Order getOrder = orderRepository.findOne(orderId);
        assertEquals("상품 주문시 상태는 order", OrderStatus.ORDER,getOrder.getStatus());
        assertEquals("주문한 상품 종류 수가 맞아야한다.", 1,getOrder.getOrderItems().size());
        assertEquals("주문가격은 가격 * 수량이다.", 20000,getOrder.getTotalPrice());
        assertEquals("주문 수량칸큼 재고가 줄어야한다.", 8, book.getStockQuantity());

    }

    @Test(expected = NotEnoughStockException.class)
    public void 상품주문_재고량초과() {
        Member member = new Member();
        member.setName("회원1");
        member.setAddress(new Address("서울","강가","123"));
        em.persist(member);

        Book book = new Book();
        book.setName("jpa");
        book.setPrice(10000);
        book.setStockQuantity(10);
        em.persist(book);

        orderService.order(member.getId(), book.getId(),15);

        fail("오류발생해야한다");
    }

    @Test
    public void 취소() {
        Member member = new Member();
        member.setName("회원1");
        member.setAddress(new Address("서울","강가","123"));
        em.persist(member);

        Book book = new Book();
        book.setName("jpa");
        book.setPrice(10000);
        book.setStockQuantity(10);
        em.persist(book);

        Long orderId = orderService.order(member.getId(), book.getId(),5);
        orderService.cancelOrder(orderId);

        Order order = orderRepository.findOne(orderId);
        assertEquals("주문상태는 cancel",OrderStatus.CANCEL,order.getStatus());
        assertEquals("주문수량 원상복구",10,book.getStockQuantity());
    }
}