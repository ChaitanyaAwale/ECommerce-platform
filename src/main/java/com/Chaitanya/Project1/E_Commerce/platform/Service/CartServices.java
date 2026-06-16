package com.Chaitanya.Project1.E_Commerce.platform.Service;

import com.Chaitanya.Project1.E_Commerce.platform.Entity.Cart;
import com.Chaitanya.Project1.E_Commerce.platform.Entity.CartItem;
import com.Chaitanya.Project1.E_Commerce.platform.Entity.Product;
import com.Chaitanya.Project1.E_Commerce.platform.Entity.User;
import com.Chaitanya.Project1.E_Commerce.platform.dto.CartDto;
import com.Chaitanya.Project1.E_Commerce.platform.dto.CartItemDto;
import com.Chaitanya.Project1.E_Commerce.platform.repository.CartItemRepository;
import com.Chaitanya.Project1.E_Commerce.platform.repository.CartRepository;
import com.Chaitanya.Project1.E_Commerce.platform.repository.ProductRepository;
import com.Chaitanya.Project1.E_Commerce.platform.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CartServices {
    private final CartRepository cartRepository;
    private final CartItemRepository cartItemRepository;
    private final ProductRepository productRepository;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;


    public CartItemDto addProductToCart(
            Long userId,
            Long productId,
            Integer quantity
    )
    {
        User user= userRepository.findById(userId).orElseThrow(()-> new RuntimeException("User not found"));
       Cart cart=cartRepository.findByUser_Id(userId).orElseThrow(()->new RuntimeException("Cart not found"));
        Product product=productRepository.findById(productId).orElseThrow(()-> new RuntimeException("No product exists"));

        if(product.getStockQuantity()<quantity)
        {
            throw new RuntimeException("Insufficient stocks");

        }
       CartItem cartItem=CartItem.builder()
               .cart(cart)
               .product(product)
               .quantity(quantity)
               .build();
        cartItemRepository.save(cartItem);
        CartItemDto dto=modelMapper.map(cartItem,CartItemDto.class);
    return dto;
    }

    public CartDto getCart(Long userId) {
//        User user=userRepository.findById(userId).orElseThrow(()->new RuntimeException("No user found"));
//        Cart cart=cartRepository.findById(user).orElseThrow(()->new RuntimeException("no cart  found"));
        Cart cart = cartRepository.findByUser_Id(userId).orElseThrow(()-> new RuntimeException("No cart found"));
        CartDto dto=modelMapper.map(cart,CartDto.class);
        return dto;

    }
    public void removeProductFromCart(Long userId, Long productId) {

        Cart cart = cartRepository.findByUser_Id(userId).orElseThrow(()-> new RuntimeException("No cart found"));

        CartItem cartItem = cartItemRepository
                .findByCart_IdAndProduct_Id(cart.getId(), productId)
                .orElseThrow(() -> new RuntimeException("Product not found in cart"));

        cartItemRepository.delete(cartItem);
    }
}


