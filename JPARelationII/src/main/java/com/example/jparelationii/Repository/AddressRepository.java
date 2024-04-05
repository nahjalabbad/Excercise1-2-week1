package com.example.jparelationii.Repository;



import com.example.jparelationii.Model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address,Integer> {
    Address findAddressById(Integer id);
}
