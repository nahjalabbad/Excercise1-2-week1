package com.example.jparelationiii.Repository;



import com.example.jparelationiii.Model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address,Integer> {
    Address findAddressById(Integer id);
}
