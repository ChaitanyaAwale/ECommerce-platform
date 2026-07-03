package com.Chaitanya.Project1.E_Commerce.platform.Service;

import com.Chaitanya.Project1.E_Commerce.platform.Entity.Address;
import com.Chaitanya.Project1.E_Commerce.platform.Entity.User;
import com.Chaitanya.Project1.E_Commerce.platform.dto.AddressRequestDto;
import com.Chaitanya.Project1.E_Commerce.platform.dto.AddressResponseDto;
import com.Chaitanya.Project1.E_Commerce.platform.exceptions.ResourceNotFoundException;
import com.Chaitanya.Project1.E_Commerce.platform.repository.AddressRepository;
import com.Chaitanya.Project1.E_Commerce.platform.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressService {

    private final AddressRepository addressRepository;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    // Create Address
    public AddressResponseDto createAddress(AddressRequestDto dto) {

        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Address address = modelMapper.map(dto, Address.class);

        address.setUser(user);

        Address savedAddress = addressRepository.save(address);

        return mapToResponseDto(savedAddress);
    }

    // Get All Addresses
    public List<AddressResponseDto> getAllAddresses() {

        List<Address> addresses = addressRepository.findAll();

        return addresses.stream()
                .map(this::mapToResponseDto)
                .toList();
    }

    // Get Address By Id
    public AddressResponseDto getAddressById(Long id) {

        Address address = addressRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Address not found"));

        return mapToResponseDto(address);
    }

    // Get Addresses Of A User
    public List<AddressResponseDto> getAddressesByUser(Long userId) {

        List<Address> addresses = addressRepository.findByUser_Id(userId);

        return addresses.stream()
                .map(this::mapToResponseDto)
                .toList();
    }

    // Update Address
    public AddressResponseDto updateAddress(Long id,
                                            AddressRequestDto dto) {

        Address address = addressRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Address not found"));

        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        address.setStreet(dto.getStreet());
        address.setCity(dto.getCity());
        address.setState(dto.getState());
        address.setCountry(dto.getCountry());
        address.setPincode(dto.getPincode());
        address.setUser(user);

        Address updatedAddress = addressRepository.save(address);

        return mapToResponseDto(updatedAddress);
    }

    // Delete Address
    public void deleteAddress(Long id) {

        Address address = addressRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Address not found"));

        addressRepository.delete(address);
    }

    // Helper Method
    private AddressResponseDto mapToResponseDto(Address address) {

        AddressResponseDto dto =
                modelMapper.map(address, AddressResponseDto.class);

        dto.setUserId(address.getUser().getId());
        dto.setUsername(address.getUser().getUsername());

        return dto;
    }
}