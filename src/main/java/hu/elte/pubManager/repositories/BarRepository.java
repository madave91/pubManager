/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.elte.pubManager.repositories;

import hu.elte.pubManager.entities.Orders;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author madave91
 */
@Repository
public interface BarRepository extends CrudRepository<Orders, Integer> {
    // Extra query options
    Orders findByPropertyX(String propertyX);
    Orders findByPropertyXAndPropertyY(String propertyX, String propertyY);
    List<Orders> findAllByPropertyZ(String propertyZ);

    @Query("select f.baz from Foo f where f.baz = ?1")
    List<Orders> findBySomething(String baz);
}
