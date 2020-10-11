package dao;

import entity.Address;

import java.util.List;

public interface AddressDAO {

    void add(Address address) throws Exception;

    List<Address> getAll() throws Exception;
    Address getById(long id) throws Exception;

    void update(Address address) throws Exception;

    void remove(Address address) throws Exception;

}
