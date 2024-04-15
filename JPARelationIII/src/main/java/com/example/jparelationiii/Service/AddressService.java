package com.example.jparelationiii.Service;






import com.example.jparelationiii.Api.ApiException;
import com.example.jparelationiii.DTO.AddressDTO;
import com.example.jparelationiii.Model.Address;
import com.example.jparelationiii.Model.Teacher;
import com.example.jparelationiii.Repository.AddressRepository;
import com.example.jparelationiii.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressService {
    private final AddressRepository addressRepository;
    private final TeacherRepository teacherRepository;

    public List<Address> getAddress(){

        return  addressRepository.findAll();
    }

    public void addAddress(AddressDTO addressDTO){
        Teacher teacher= teacherRepository.findTeacherById(addressDTO.getTeacher_id());
        if (teacher==null){
            throw new ApiException("teacher not found");
        }

        Address address = new Address(null, addressDTO.getArea(), addressDTO.getStreet(), addressDTO.getBuildingNumber(),teacher );

        addressRepository.save(address);
    }

    public void updateAddress(AddressDTO addressDTO){
        Address address= addressRepository.findAddressById(addressDTO.getTeacher_id());
        if (address==null){
            throw new ApiException("Id not found");
        }

        address.setArea(addressDTO.getArea());
        address.setStreet(addressDTO.getStreet());
        address.setBuildingNumber(addressDTO.getBuildingNumber());
        addressRepository.save(address);
    }

    public void deleteAddress(Integer id){
        Address address= addressRepository.findAddressById(id);
        if (address==null){
            throw new ApiException("id not found");
        }
        addressRepository.delete(address);

    }
}
