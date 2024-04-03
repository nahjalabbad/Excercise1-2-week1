package com.example.jpa_relational.Repository;


import com.example.jpa_relational.Model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address,Integer> {
    Address findAddressById(Integer id);
}
