package com.Chaitanya.Project1.E_Commerce.platform.controller;

import com.Chaitanya.Project1.E_Commerce.platform.Service.CartServices;
import com.Chaitanya.Project1.E_Commerce.platform.dto.CartDto;
import com.Chaitanya.Project1.E_Commerce.platform.dto.CartItemDto;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cart")
@RequiredArgsConstructor
public class CartController {
    private final CartServices cartService;


@GetMapping("/{userId}")
public CartDto getCart(@PathVariable Long userId)
{
    return cartService.getCart(userId);
}
 @PostMapping("/add")
    public CartItemDto addProductToCart(@RequestParam Long userId,
                                        @RequestParam Long productId,
                                        @RequestParam Integer quantity)
 {
     return cartService.addProductToCart(userId,productId,quantity);
 }

 @DeleteMapping("/remove")
    public void removeProductFromCart(@RequestParam Long userId,
                                         @RequestParam Long productId)
 {
     cartService. removeProductFromCart(userId,productId);
 }

}
