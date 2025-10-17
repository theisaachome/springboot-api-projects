package com.isaachome.eshop.api.repository;

import com.isaachome.eshop.api.entiy.ItemEntity;
import com.isaachome.eshop.api.entiy.OrderEntity;
import com.isaachome.eshop.api.exceptions.ResourceNotFoundException;
import com.isaachome.eshop.api.model.NewOrder;
import com.isaachome.eshop.api.service.ItemService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Repository
@Transactional
public class OrderRepositoryImpl implements OrderRepositoryExt{
    @PersistenceContext
    private EntityManager em;

    private final ItemRepository itemRepository;
    private final AddressRepository addressRepository;
    private final CartRepository cartRepository;
    private final OrderItemRepository orderItemRepository;
    private final ItemService itemService;

    public OrderRepositoryImpl(ItemRepository itemRepository, AddressRepository addressRepository, CartRepository cartRepository, OrderItemRepository orderItemRepository, ItemService itemService) {
        this.itemRepository = itemRepository;
        this.addressRepository = addressRepository;
        this.cartRepository = cartRepository;
        this.orderItemRepository = orderItemRepository;
        this.itemService = itemService;
    }

    @Override
    public Optional<OrderEntity> insert(NewOrder m) {
       Iterable<ItemEntity> dbItems= itemRepository.findByCustomerId(m.customerId());
        List<ItemEntity> items  = StreamSupport.stream(dbItems.spliterator(), false).toList();
        if(items.isEmpty()){
            throw new ResourceNotFoundException(String
                    .format("There is no item found in customer's (ID: %s) cart.", m.customerId()));
        }
        BigDecimal totalPrice = BigDecimal.ZERO;
        for(ItemEntity i:items){
            totalPrice = (BigDecimal.valueOf(i.getQuantity()).multiply(i.getPrice())).add(totalPrice);
        }

        Timestamp orderDate = Timestamp.from(Instant.now());
        em.createNativeQuery("""
             INSERT INTO ecomm.orders (address_id, card_id, customer_id, order_date, total, status)\s
            VALUES(?, ?, ?, ?, ?, ?)
        """)
                .setPa;
        return Optional.empty();
    }
}
