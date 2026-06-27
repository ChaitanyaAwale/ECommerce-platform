package com.Chaitanya.Project1.E_Commerce.platform.controller;
//package com.Chaitanya.Project1.E_Commerce.platform.controller;

import com.Chaitanya.Project1.E_Commerce.platform.Service.AddressService;
import com.Chaitanya.Project1.E_Commerce.platform.dto.AddressRequestDto;
import com.Chaitanya.Project1.E_Commerce.platform.dto.AddressResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/address")
@RequiredArgsConstructor
public class AddressController {

    private final AddressService addressService;

    @PostMapping
    public AddressResponseDto createAddress(
            @RequestBody AddressRequestDto dto) {

        return addressService.createAddress(dto);
    }

    @GetMapping
    public List<AddressResponseDto> getAllAddresses() {

        return addressService.getAllAddresses();
    }

    @GetMapping("/{id}")
    public AddressResponseDto getAddressById(
            @PathVariable Long id) {

        return addressService.getAddressById(id);
    }

    @GetMapping("/user/{userId}")
    public List<AddressResponseDto> getUserAddresses(
            @PathVariable Long userId) {

        return addressService.getAddressesByUser(userId);
    }

    @PutMapping("/{id}")
    public AddressResponseDto updateAddress(
            @PathVariable Long id,
            @RequestBody AddressRequestDto dto) {

        return addressService.updateAddress(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deleteAddress(@PathVariable Long id) {

        addressService.deleteAddress(id);
    }
}
